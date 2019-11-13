package restandtest;

public class CreatePost {
	//Create As Many Variables In JSON Object
	/*
   	 {  
         "id":1,
         "title":"json-server",
         "author":"typicode"
     }
	 */
	private int id;
	private String title;
	private String author;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
