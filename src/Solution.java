import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Solution {

	public static void main (String [] args) throws IOException, JSONException{
		
		URL url = new URL("https://api.themoviedb.org/3/"
				+ "discover/movie?sort_by=popularity.desc&api_key='Here goes your api code'");
		
		URLConnection urlConnection = url.openConnection();
        HttpURLConnection connection = null;
        if(urlConnection instanceof HttpURLConnection)
        {
           connection = (HttpURLConnection) urlConnection;
        }
        else
        {
           System.out.println("Please enter an HTTP URL.");
           return;
        }
        BufferedReader in = new BufferedReader(
        new InputStreamReader(connection.getInputStream()));
        String urlString = "";
        String current;
        while((current = in.readLine()) != null)
        {
           urlString += current;
        }
        
        JSONObject jsonObject = new JSONObject (urlString);
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        for (int i = 0; i < jsonArray.length(); i++){
        	System.out.println(jsonArray.getJSONObject(i).getString("title"));
        }
	}
}
