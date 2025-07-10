package model;

public class book1
{
	private int book_id;
	private String title;
	private String price;
	private int author_id;
	
	public book1(int book_id, String title, String price, int author_id) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.price = price;
		this.author_id = author_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	@Override
	public String toString() {
		return "book1 [book_id=" + book_id + ", title=" + title + ", price=" + price + ", author_id=" + author_id + "]";
	}
	
	

}
