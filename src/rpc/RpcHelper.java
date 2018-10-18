package rpc;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class RpcHelper {
	public static void writeJsonArray(HttpServletResponse response, JSONArray array) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		out.print(array);
		out.close();
	}
	
	public static void writeJsonObject(HttpServletResponse response, JSONObject obj) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		out.print(obj);
		out.close();
	}
	
	public static JSONObject readJSONObject(HttpServletRequest request) {
		StringBuilder sBuilder = new StringBuilder();
		try (BufferedReader reader = request.getReader()) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				sBuilder.append(line);
			}
			return new JSONObject(sBuilder.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new JSONObject();
             }

}
