/**
 * Name: 林明毅
 * ID: U10316024
 * EX: 11.8
 */ 
import java.util.Date;
import java.util.ArrayList;
public class Account {

	//Main method
	public static void main(String[] args){
		
		TestAccount account = new TestAccount(1122,1000,"George");

		account.setAnnualInterestRate(1.5);

		//invoke deposit method
		account.deposit(30);
		account.deposit(40);
		account.deposit(50);

		//invoke withdraw method
		account.withdraw(5);
		account.withdraw(4);
		account.withdraw(2);

		//print result
		System.out.println(account.toString());

	}
}

//Define a class TestAccount
//Constructor of TestAccount
class TestAccount{

	//data fields
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	private String name;	

	int i = 0;
	
	//create a list
	ArrayList<Transaction> list = new ArrayList<Transaction>();

	//no-arg constructor
	TestAccount(){

		dateCreated = new Date();
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		name = "";
	}
	
	//constrcutor
	TestAccount(int id, double balance,String name){

		dateCreated = new Date();
		this.id = id;
		this.balance = balance;
		this.name = name;
	}

	//get method
	public Date getDateCreated() {

		return dateCreated;

	}

	//get method
	public int getId() {

		return id;

	}

	//get method
	public double getBalance() {

		return balance;

	}

	//get method
	public double getAnnualInterestRate() {

		return annualInterestRate/100;

	}

	//get method
	public double getMonthlyInterestRate() {

		return annualInterestRate/1200;

	}

	//get method
	public double getMonthlyInterest() {

		return balance*getMonthlyInterestRate();

	}

	//set method
	public void setId(int id) {

		this.id = id;
	
	}

	//set method
	public void setBalance(double balance) {

		this.balance = balance;

	}

	//set method
	public void setAnnualInterestRate(double annualInterestRate) {

		this.annualInterestRate = annualInterestRate;

	}

	//withdraw method
	public void withdraw(double money) {		

		balance = balance - money;	
		list.add(new Transaction('W', money, balance, "end"));

		System.out.println("\nDetail: " + ((Transaction)list.get(i)).getDescription());

		i++;
	}

	//deposit method
	public void deposit(double money) {		

		balance = balance + money;	
		list.add(new Transaction('D', money, balance, "end"));

		System.out.println("\nDetail: " + ((Transaction)list.get(i)).getDescription());
		
		i++;
	}
	
	//set method
	public String toString() {

		return "\nId: " + getId() +  "\nBalance: " + getBalance() + "\nMonthlyInterest: " + getMonthlyInterest() + "\nDate: " + getDateCreated();		

	}
}

//Define a class Transaction
//Constructor of Transaction
class Transaction{

	//Data fields
	private Date date;
	private char type;
	private double amount;
	private double balance;
	private String description;

	//no-arg constructor
	public Transaction() {

		date = new Date();
		type = '\u0000';
		amount = 0;
		balance = 0;
		description = "";

	}

	//constrcutor
	public Transaction(char type,double amount,double balance,String description) {

		date = new Date();
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;

	}

	//set method
	public void setType(char type) {

		this.type = type;
	}

	//set method
	public void setAmount(double amount) {

		this.amount = amount;

	}

	//set method
	public void setbalance(double balance) {

		this.balance = balance;

	}

	//set method
	public void setdescription(String description) {

		this.description = description;

	}
	
	//get method
	public Date getDate() {

		return date;

	}

	//get method
	public char getType() {

		return type;

	}

	//get method
	public double getAmount() {

		return amount;

	}

	//get method
	public double getBalance() {

		return balance;

	}

	//get method
	public String getDescription() {

		return "\nType : " + getType() + "\nAmount : " + getAmount() + "\nBalance : " + getBalance() + "\nDate : " + getDate();

	}
}
