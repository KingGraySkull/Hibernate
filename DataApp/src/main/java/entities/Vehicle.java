package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "vehicle")
public class Vehicle
{
	@Id
	@Column(name = "vehicle_id")
	@GenericGenerator(name = "increment",strategy = "increment")
	@GeneratedValue(generator = "increment")
	private Integer id;
	
	@Column(name = "vehicle_reg_no")
	private String vehicleRegNo;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "color")
	private String color;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customer;
	
	public Vehicle() {}

	public Vehicle(String vehicleRegNo, String brand, String model, String color)
	{
		this.vehicleRegNo = vehicleRegNo;
		this.brand = brand;
		this.model = model;
		this.color = color;
	}
	
	public Customers getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customers customer)
	{
		this.customer = customer;
	}

	public String getVehicleRegNo()
	{
		return vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo)
	{
		this.vehicleRegNo = vehicleRegNo;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}
}
