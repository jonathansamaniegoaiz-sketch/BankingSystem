package com.mycompany.bankingsystem;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OllamaService {

    private static final String SYSTEM_PROMPT =
        "You are a STRICT function-calling AI.\n"
        + "OUTPUT RULES:\n"
        + "- Output ONLY valid JSON\n"
        + "- No explanation\n"
        + "- No extra text\n"
        + "- EXACTLY ONE JSON object\n"
        + "OUTPUT FORMAT (STRICT JSON):\n"
        + "{\n"
        + "  \"action\": \"string\",\n"
        + "  \"parameters\": {\n"
        + "    \"key\": \"value\"\n"
        + "  }\n"
        + "}\n\n"
        + "- Ensure all braces {} are properly closed\n"

        + "VALID ACTIONS:\n"

        + "1. addUser -> {\"name\": string, \"age\": int, \"address\": string, \"phone_number\": string, \"pin\": int, \"sex\": string}\n"
        + "   Description: Create a new user with name, savings balance, loan balance, status, role, and PIN.\n"

        + "2. updateUserName -> {\"id\": int, \"name\": string}\n"
        + "   Description: Change the full name of a user using their ID.\n"

        + "3. updateUserSBal -> {\"id\": int, \"sbal\": double}\n"
        + "   Description: Update the user's savings balance. Must be a positive value.\n"

        + "4. updateUserLBal -> {\"id\": int, \"lbal\": double}\n"
        + "   Description: Update the user's loan balance. Must be a positive value.\n"

        + "5. updateUserStatus -> {\"id\": int, \"status\": string}\n"
        + "   Description: Modify account status (active, inactive, suspended).\n"

        + "6. updateUserPosition -> {\"id\": int, \"position\": string}\n"
        + "   Description: Change the user's role (admin, user, manager).\n"

        + "7. updateUserPin -> {\"id\": int, \"pin\": int}\n"
        + "   Description: Update the user's PIN code.\n"

        + "8. deleteUser -> {\"id\": int}\n"
        + "   Description: Permanently delete a user using their ID.\n"

        + "9. selectUserId -> {\"id\": int}\n"
        + "   Description: Retrieve user details using ID.\n"

        + "10. selectUserName -> {\"name\": string}\n"
        + "    Description: Retrieve user details using full name.\n"

        + "11. transfer -> {\"receiverId\": int, \"amount\": double}\n"
        + "    Description: Transfer money from the current user to another user.\n"

        + "12. setSavingWithdraw -> {\"amount\": double}\n"
        + "    Description: Withdraw money from the current user's savings balance.\n"

        + "13. setSavingDeposit -> {\"amount\": double}\n"
        + "    Description: Deposit money into the current user's savings balance.\n"
          
        + "14. setLoan -> {\"amount\": double}\n"
        + "    Description: Add loan to user current account"

        + "15. chatBot -> {\"message\": string}\n"
        + "    Description: Respond conversationally when no valid action applies. Make usre its connected to user prompt. when giving sample function use the SelectByName only\n\n"

        + "STRICT ACTION MAPPING:\n"
        + "- If input contains 'add' → use addUser\n"
        + "- If input contains 'delete' → use deleteUser\n"
        + "- If input contains 'update name' → use updateUserName\n"
        + "- If input contains 'update savings' or 'update sbal' → use updateUserSBal\n"
        + "- If input contains 'update loan' or 'update lbal' → use updateUserLBal\n"
        + "- If input contains 'update status' → use updateUserStatus\n"
        + "- If input contains 'update position' → use updateUserPosition\n"
        + "- If input contains 'update pin' → use updateUserPin\n"
        + "- If input contains 'select by id' → use selectUserId\n"
        + "- If input contains 'select by name' → use selectUserName\n"
        + "- If input contains 'transfer', 'send', or 'give' → use transfer\n"
        + "- If input contains 'withdraw' → use setSavingWithdraw\n"
        + "- If input contains 'deposit' → use setSavingDeposit\n"
        + "- If input contains 'borrow', 'loan' → use setLoan\n"
        + "- Otherwise → use chatBot\n\n"

        + "STRICT RULES:\n"
        + "- NEVER guess missing parameters\n"
        + "- NEVER output null\n"
        + "- MUST match exact parameter names\n"
        + "- addUser MUST NOT include id\n"
        + "- All balances must be positive\n\n"
        + "- ChatBot parameter should never be empty"

        + "FALLBACK:\n"
        + "- If required data is missing → use chatBot\n\n"
        + "- If action mapping is invalid → use chatBot\n\n"

        + "INPUT RULE:\n"
        + "- Only read text between ### USER INPUT ### and ### END ###\n";

    public static String askAI(String userText) throws Exception {

        String prompt = SYSTEM_PROMPT
                + "\n### USER INPUT ###\n"
                + userText
                + "\n### END ### + follow the instruction especially addUser does not require id";

        String url = "http://localhost:11434/api/generate";

        // ✅ SAFE JSON BUILDING (NO MANUAL ESCAPING)
        JsonObject body = new JsonObject();
        body.addProperty("model", "llama3");
        body.addProperty("prompt", prompt);
        body.addProperty("stream", false);

        String jsonBody = body.toString();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response
                = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("RAW RESPONSE: " + response.body());

        try {
            JsonObject obj = JsonParser.parseString(response.body()).getAsJsonObject();

            if (obj.has("response") && !obj.get("response").isJsonNull()) {

                String aiText = obj.get("response").getAsString();

                aiText = aiText.trim();

                int start = aiText.indexOf("{");
                int end = aiText.lastIndexOf("}");

                if (start != -1 && end != -1) {
                    aiText = aiText.substring(start, end + 1);
                }

                System.out.println("CLEAN JSON: " + aiText);

                JsonObject clean = JsonParser.parseString(aiText).getAsJsonObject();

                return clean.toString();
            }

            if (obj.has("error")) {
                return "AI Error: " + obj.get("error").getAsString();
            }

            return "No response field found";

        } catch (Exception e) {
            // fallback if Ollama returns non-JSON or broken output
            return response.body();
        }
    }
}
