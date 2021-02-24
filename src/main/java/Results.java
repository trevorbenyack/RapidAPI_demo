import java.util.ArrayList;

public class Results {
	
	private String response;
	private int totalResults;
	private ArrayList<Search> searchResults = new ArrayList<Search>();
	
	public class Search {
		
		private String type;
		private String year;
		private String imdbID;
		private String poster;
		private String title;
		
		
		private Search(
				String type,
				String year,
				String imdbID,
				String poster,
				String title) {
			
			this.type = type;
			this.year = year;
			this.imdbID = imdbID;
			this.poster = poster;
			this.title = title;
			
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public String getImdbID() {
			return imdbID;
		}

		public void setImdbID(String imdbID) {
			this.imdbID = imdbID;
		}

		public String getPoster() {
			return poster;
		}

		public void setPoster(String poster) {
			this.poster = poster;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		
		
		
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	
	public void addSearchResult(Search searchResult) {
		searchResults.add(searchResult);
	}
	
	public ArrayList<Search> getSearchResultArray() {
		return searchResults;
	}
	
	
	
}
