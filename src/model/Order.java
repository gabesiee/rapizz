package model;

public class Order {
	private int orderID;
	private String orderDate;
	private boolean late;
	private int clientID;
	private int pizzaID;
	private int sizeID;
	private int registration;
	private int delivManID;

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public boolean isLate() {
		return late;
	}

	public void setLate(boolean late) {
		this.late = late;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getPizzaID() {
		return pizzaID;
	}

	public void setPizzaID(int pizzaID) {
		this.pizzaID = pizzaID;
	}

	public int getSizeID() {
		return sizeID;
	}

	public void setSizeID(int sizeID) {
		this.sizeID = sizeID;
	}

	public int getRegistration() {
		return registration;
	}

	public void setRegistration(int registration) {
		this.registration = registration;
	}

	public int getDelivManID() {
		return delivManID;
	}

	public void setDelivManID(int delivManID) {
		this.delivManID = delivManID;
	}

}
