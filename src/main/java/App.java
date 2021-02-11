import java.net.URLEncoder;

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

	}

}
