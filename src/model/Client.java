package model;

public class Client {
	private int clientID;
	private String clientLastName;
	private String clientFirstName;
	private String clientAdrs;
	private float accountBalance;
	private int pizzaCounter;

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getClientLastName() {
		return clientLastName;
	}

	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}

	public String getClientFirstName() {
		return clientFirstName;
	}

	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

	public String getClientAdrs() {
		return clientAdrs;
	}

	public void setClientAdrs(String clientAdrs) {
		this.clientAdrs = clientAdrs;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getPizzaCounter() {
		return pizzaCounter;
	}

	public void setPizzaCounter(int pizzaCounter) {
		this.pizzaCounter = pizzaCounter;
	}

}
