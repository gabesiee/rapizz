package model;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static dao.ConnectionDAO.getConnection;

public class Order {
	private int orderID;
	private String orderDate;
	private String fidelity;
	private String late;
	private int clientID;
	private int pizzaID;
	private int sizeID;
	private String registration;
	private String delivMan;
	private String clientName;
	private String pizzaName;
	private String sizeName;
	private float price;
	private String req;
	private ArrayList<Order> orders = new ArrayList<>();

	public Order() {

	}

	public Order(Order order) {
		this.orderDate = order.getOrderDate();
		this.fidelity = order.getFidelity();
		this.late = order.getLate();
		this.clientID = order.getClientID();
		this.pizzaID = order.getPizzaID();
		this.sizeID = order.getSizeID();
		this.registration = order.getRegistration();
		this.delivMan = order.getDelivMan();
		this.clientName = order.getClientName();
		this.pizzaName = order.getPizzaName();
		this.sizeName = order.getSizeName();
		this.price = order.getPrice();
	}

	public Order(String orderDate, String clientName, String pizzaName, String sizeName, String delivMan,
				 String registration, String fidelity, String late, float price) {
		this.orderDate = orderDate;
		this.fidelity = fidelity;
		this.late = late;
		this.registration = registration;
		this.delivMan = delivMan;
		this.clientName = clientName;
		this.pizzaName = pizzaName;
		this.sizeName = sizeName;
		this.price = price;
	}

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

	public String getFidelity() {
		return fidelity;
	}

	public void setFidelity(String fidelity) {
		this.fidelity = fidelity;
	}

	public String getLate() {
		return late;
	}

	public void setLate(String late) {
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

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getDelivMan() {
		return delivMan;
	}

	public void setDelivMan(String delivMan) {
		this.delivMan = delivMan;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public ArrayList<Order> getAll() throws IOException, SQLException {
		req = "SELECT COM_DATE AS \"Date\", CONCAT(CLIENT_NOM, \" \", CLIENT_PRENOM) AS \"Client\", " +
				"PIZZA_NOM AS \"Pizza\", TAILLE_NOM AS \"Taille\", LIVREUR_NOM AS \"Livreur\", IMMAT AS \"Véhicule\", " +
				"FIDELITE AS \"Fidélité\", RETARD AS \"Retard\", (PRIX_BASE * COEF) AS \"Prix\"\n" +
				"FROM client JOIN commande USING (CLIENT_ID) JOIN pizza USING (PIZZA_ID) JOIN taille USING (TAILLE_ID) " +
				"JOIN vehicule USING (VEHIC_ID) JOIN livreur USING (LIVREUR_ID) ORDER BY Date;";

		ResultSet result = getConnection().createStatement().executeQuery(req);
		while (result.next()) {
			Date date = result.getDate("Date");
			String clientName = result.getString("Client");
			String pizzaName = result.getString("Pizza");
			String sizeName = result.getString("Taille");
			String delivMan = result.getString("Livreur");
			String registration = result.getString("Véhicule");
			int fidelity = result.getInt("Fidélité");
			int late = result.getInt("Retard");
			float price = result.getFloat("Prix");

			SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
			String date_s = sdfr.format(date);
			String fidelity_s;
			if(fidelity == 1) {
				fidelity_s = "Oui";
			}else{
				fidelity_s = "Non";
			}
			String late_s;
			if(late == 1) {
				late_s = "Oui";
			}else{
				late_s = "Non";
			}

			this.orders.add(new Order(date_s, clientName, pizzaName, sizeName, delivMan, registration, fidelity_s, late_s, price));
		}

		return orders;
	}
}
