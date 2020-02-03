package model;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static dao.ConnectionDAO.getConnection;

public class Vehicule {
    private int vehicID;
    private String registration;
    private String model;
    private int typeID;
    private String typeName;
    private int delivDone;
    private String req;
    private ArrayList<Vehicule> vehicules = new ArrayList<>();

    public Vehicule() {

    }

    public Vehicule(Vehicule vehicule) {
        this.vehicID = vehicule.getVehicID();
        this.registration = vehicule.getRegistration();
        this.model = vehicule.getModel();
        this.typeID = vehicule.getTypeID();
        this.typeName = vehicule.getTypeName();
        this.delivDone = vehicule.getDelivDone();
    }

    public Vehicule(String typeName, String model, String registration, int delivDone) {
        this.model = model;
        this.typeName = typeName;
        this.registration = registration;
        this.delivDone = delivDone;
    }

    public int getVehicID() {
        return vehicID;
    }

    public void setVehicID(int vehicID) {
        this.vehicID = vehicID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDelivDone() {
        return delivDone;
    }

    public void setdelivDone(int delivDone) {
        this.delivDone = delivDone;
    }

    public ArrayList<Vehicule> getAll() throws IOException, SQLException {
        req = "SELECT TYPE_NOM AS \"Type\", MODELE AS \"Modèle\", IMMAT AS \"Immatriculation\", " +
                "COUNT(COM_ID) AS \"Nombre de livraison\" FROM type_vehicule JOIN vehicule USING (TYPE_ID) " +
                "LEFT JOIN commande USING (VEHIC_ID) GROUP BY TYPE_NOM, MODELE, IMMAT;";

        ResultSet result = getConnection().createStatement().executeQuery(req);
        while (result.next()) {
            String type = result.getString("Type");
            String model = result.getString("Modèle");
            String registration = result.getString("Immatriculation");
            int delivDone = result.getInt("Nombre de livraison");

            this.vehicules.add(new Vehicule(type, model, registration, delivDone));
        }

        return vehicules;
    }

}
