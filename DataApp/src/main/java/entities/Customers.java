package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.type.SerializableType;

@Entity
@Table(name = "customers")
@Cache(region = "customerCacheRegion",usage = CacheConcurrencyStrategy.READ_WRITE)
public class Customers implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registered_on")
	private Date registeredOn;
	
	public Customers() {}

	public Customers(String firstName, String lastName, Date registeredOn)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.registeredOn  = registeredOn;
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
