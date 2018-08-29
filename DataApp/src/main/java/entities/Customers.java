package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "customers")
@Cache(region = "customerCacheRegion",usage = CacheConcurrencyStrategy.READ_WRITE)
public class Customers implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "increment",strategy = "increment")
	@GeneratedValue(generator = "increment")
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registered_on")
	private Date registeredOn;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "card_id")
	private Card card;

	/**
	 * The below configuration will create separate table for one to many relationship
	 * eg:- Customer_vehicles table which will containe id for customer and vehicle table will be created
	 */
	
/*	
 * @OneToMany
	@JoinTable(	name = "customer_vehicles",
				joinColumns = @JoinColumn(name = "customer_id"),
				inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
	private Collection<Vehicle> vehicles = new LinkedList<Vehicle>();
*/
	
	/*
	 * The below configuration will avoid creating new table for one to many relationship
	 */
	@OneToMany(mappedBy = "customer",cascade = CascadeType.PERSIST)
	 private Collection<Vehicle> vehicles = new LinkedList<Vehicle>();
	
	
	public Customers() {}

	public Customers(String firstName, String lastName, Date registeredOn)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.registeredOn  = registeredOn;
	}

	public Collection<Vehicle> getVehicles()
	{
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles)
	{
		this.vehicles = vehicles;
	}

	public Card getCard()
	{
		return card;
	}

	public void setCard(Card card)
	{
		this.card = card;
	}

	public long getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(long customerId)
	{
		this.customerId = customerId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Date getRegisteredOn()
	{
		return registeredOn;
	}

	public void setRegisteredOn(Date registeredOn)
	{
		this.registeredOn = registeredOn;
	}
}
