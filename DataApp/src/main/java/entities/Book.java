package entities;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "book")
public class Book
{
	@Id
	@Column(name = "book_id")
	@GenericGenerator(name = "increment",strategy = "increment")
	@GeneratedValue(generator = "increment")
	private int bookId;
	
	@Column(name = "title",length = 50,nullable = false)
	private String title;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "isbn")
	private String isbn;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "author_books",joinColumns = @JoinColumn(name = "author_id"),
	inverseJoinColumns = @JoinColumn(name = "book_id"))
	private Collection<Author> authors = new LinkedList<Author>();
	
	private Book() {}

	public Book(String title, String category, String isbn)
	{
		this.title = title;
		this.category = category;
		this.isbn = isbn;
	}

	public int getBookId()
	{
		return bookId;
	}

	public void setBookId(int bookId)
	{
		this.bookId = bookId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public Collection<Author> getAuthors()
	{
		return authors;
	}

	public void setAuthors(Collection<Author> authors)
	{
		this.authors = authors;
	}
}
