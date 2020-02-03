package model;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static dao.ConnectionDAO.getConnection;

public class DeliveryMan {
    private int delivManID;
    private String delivManName;
    private int delivDone;
    private int late;
	private String req;
	private ArrayList<DeliveryMan> delivMen = new ArrayList<>();

    public DeliveryMan() {

	}

	public DeliveryMan(DeliveryMan delivMan) {
    	this.delivManID = delivMan.getDelivManID();
    	this.delivManName = delivMan.getDelivManName();
    	this.delivDone = delivMan.getDelivDone();
    	this.late = delivMan.getLate();
	}

	public DeliveryMan(String name, int delivDone, int late) {
		this.delivManName = name;
		this.delivDone = delivDone;
		this.late = late;
	}

    public int getDelivManID() {
        return delivManID;
    }

    public void setDelivManID(int delivManID) {
        this.delivManID = delivManID;
    }

    public String getDelivManName() {
        return delivManName;
    }

    public void setDelivManName(String delivManName) {
        this.delivManName = delivManName;
    }

    public int getDelivDone() {
        return delivDone;
    }

    public void setDelivDone(int delivDone) {
        this.delivDone = delivDone;
    }

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }

	public ArrayList<DeliveryMan> getAll() throws IOException, SQLException {
		req = "SELECT LIVREUR_NOM AS \"Nom\", COUNT(*) AS \"Nombre livraison\", " +
                "SUM(CASE WHEN RETARD = 1 THEN 1 ELSE 0 END) AS \"Nombre retard\" " +
                "FROM livreur JOIN commande USING (LIVREUR_ID) GROUP BY LIVREUR_NOM;";

		ResultSet result = getConnection().createStatement().executeQuery(req);
		while (result.next()) {
			String name = result.getString("Nom");
			int late = result.getInt("Nombre retard");
            int delivDone = result.getInt("Nombre livraison");

			this.delivMen.add(new DeliveryMan(name, delivDone, late));
		}

		return delivMen;
	}

}
