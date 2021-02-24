import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.Iterator;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/*
 * Original website: https://rapidapi.com/blog/how-to-use-an-api-with-java/
*/

public class App {

	public static void main(String[] args) throws Exception {
		
		// Host url
		String host = "https://movie-database-imdb-alternative.p.rapidapi.com";
		String charset = "UTF-8";
		String x_rapidapi_host = "movie-database-imdb-alternative.p.rapidapi.com";
		String x_rapidapi_key ="b6d595d888mshfb9fb6201939a6fp13a489jsnf7b9b76e05c3";
		
		// Params
		String s = "pulp";
		
		// Format query for preventing encoding problems
		String query = String.format("s=%s", URLEncoder.encode(s, charset));
		
		// The HttpResponse and JsonNode comes from Unirest 
		HttpResponse<JsonNode> response = Unirest.get(host + "?" + query)
				.header("x-rapidapi-host", x_rapidapi_host)
				.header("x-rapidapi-key", x_rapidapi_key)
				.asJson();
		
		System.out.println(response.getStatus());
		System.out.println(response.getHeaders().getFirst("Content-Type"));
		System.out.println(response.getBody());
		
		
		// Using Google's GSON to prettify data
		String i = "tt0110912";
		
		query = String.format("i=%s", URLEncoder.encode(i, charset));
		
		// JSON Response
		HttpResponse <JsonNode> secondResponse = Unirest.get(host + "?" + query)
				.header("x-rapidapi-host", x_rapidapi_host)
				.header("x-rapidapi-key", x_rapidapi_key)
				.asJson();
		
		// Prettifying - making the JSON human-readable
		
		// .setPrettyPrinting() method configures GSON to output JSON that fits in a page for pretty printing
		// .create() method creates GSON instance based on current configuration
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// Deserialize response	
		JsonElement resultsElement = JsonParser.parseString(response.getBody().toString());
		JsonObject resultsObject = resultsElement.getAsJsonObject();
		JsonArray searchResultsArray = resultsObject.getAsJsonArray("Search");
		
		
		Results results = new Results();
		results.setResponse(resultsObject.get("Response").getAsString());
		results.setTotalResults(resultsObject.get("totalResults").getAsInt());

		// NEXT: GET THIS TO WORK
		for (Iterator iterator = searchResultsArray.iterator(); iterator.hasNext();) {
			Results.Search searchResult = gson.fromJson((JsonElement)iterator.next(), Results.Search.class);
			results.addSearchResult(searchResult);
			
		}
		
		System.out.println("type of first search result" + results.getSearchResultArray().get(0).getType());
		
		
		JsonElement je01 = JsonParser.parseString(response.getBody().toString());
		String prettyJsonString01 = gson.toJson(je01);
		System.out.println(prettyJsonString01);
		
		
		JsonElement je02 = JsonParser.parseString(secondResponse.getBody().toString()); // JsonElement is a class representing an element of Josn
		String prettyJsonString02 = gson.toJson(je02);
		System.out.println(prettyJsonString02);
		
		// extra 
	
		
		
		
		

	}

}
