package vo;

public class BookVO {
	private int bookno;
	private String title;
	private String publisher;
	private int price;

	public BookVO() {
		super();
	}

	public BookVO(int bookno, String title, String publisher, int price) {
		super();
		this.bookno = bookno;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
	}


	public int getBookno() {
		return bookno;
	}

	public void setBookno(int bookno) {
		this.bookno = bookno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookVO [bookno=" + bookno + ", title=" + title + ", publisher=" + publisher + ", price=" + price + "]";
	}
	
	
	
	
}
