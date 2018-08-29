package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "card")
@Cache(region = "cardCacheRegion",usage = CacheConcurrencyStrategy.READ_WRITE)
public class Card
{
	@Id
	@GenericGenerator(name = "increment",strategy = "increment")
	@GeneratedValue(generator = "increment")
	@Column(name = "card_id")
	private int cardId;
	
	@Column(name = "card_type")
	private String cardType;
	
	@Column(name = "bank_name")
	private String bankName;
	
	@Column(name = "account")
	private String accountNumber;
	
	@Column(name = "pin")
	private int pinNumber;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "customer_id")
	private Customers customer;

	public Card() {}
	
	public Card(String cardType, String bankName, String accountNumber, int pinNumber)
	{
		this.cardType = cardType;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.pinNumber = pinNumber;
	}

	public Customers getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customers customer)
	{
		this.customer = customer;
	}

	public int getCardId()
	{
		return cardId;
	}

	public void setCardId(int cardId)
	{
		this.cardId = cardId;
	}

	public String getCardType()
	{
		return cardType;
	}

	public void setCardType(String cardType)
	{
		this.cardType = cardType;
	}

	public String getBankName()
	{
		return bankName;
	}

	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public int getPinNumber()
	{
		return pinNumber;
	}

	public void setPinNumber(int pinNumber)
	{
		this.pinNumber = pinNumber;
	}
}
