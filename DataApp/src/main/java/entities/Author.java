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
@Table(name = "author")
public class Author
{
	@Id
	@GenericGenerator(name = "increment", strategy = "increment")
	@GeneratedValue(generator = "increment")
	private int id;
	
	@Column(name = "name",length = 50,nullable = false)
	private String name;
	
	@Column(name = "surname",length = 50,nullable = false)
	private String surname;
	
	@ManyToMany(cascade = CascadeType.PERSIST,mappedBy = "authors")
	private Collection<Book> books = new LinkedList<Book>();
	
	public Author() {}

	public Author(String name, String surname)
	{
		this.name = name;
		this.surname = surname;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public Collection<Book> getBooks()
	{
		return books;
	}

	public void setBooks(Collection<Book> books)
	{
		this.books = books;
	}
}
