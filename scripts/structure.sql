CREATE TABLE PIZZA(
   PIZZA_ID INT NOT NULL AUTO_INCREMENT,
   PIZZA_NOM VARCHAR(25) NOT NULL,
   PRIX_BASE INT NOT NULL,
   PRIMARY KEY(PIZZA_ID)
);

CREATE TABLE INGREDIENT(
   INGRE_ID INT NOT NULL AUTO_INCREMENT,
   INGRE_NOM VARCHAR(25) NOT NULL,
   PRIMARY KEY(INGRE_ID)
);

CREATE TABLE TAILLE(
   TAILLE_ID INT NOT NULL AUTO_INCREMENT,
   TAILLE_NOM VARCHAR(25) NOT NULL,
   COEF DECIMAL(3,2) NOT NULL,
   PRIMARY KEY(TAILLE_ID)
);

CREATE TABLE LIVREUR(
   LIVREUR_ID INT NOT NULL AUTO_INCREMENT,
   LIVREUR_NOM VARCHAR(25) NOT NULL,
   PRIMARY KEY(LIVREUR_ID)
);

CREATE TABLE TYPE_VEHICULE(
   TYPE_ID INT NOT NULL AUTO_INCREMENT,
   TYPE_NOM VARCHAR(25) NOT NULL,
   PRIMARY KEY(TYPE_ID)
);

CREATE TABLE CLIENT(
   CLIENT_ID INT NOT NULL AUTO_INCREMENT,
   CLIENT_NOM VARCHAR(25) NOT NULL,
   CLIENT_PRENOM VARCHAR(25) NOT NULL,
   CLIENT_ADRS VARCHAR(25) NOT NULL,
   CLIENT_EMAIL VARCHAR(25) NOT NULL,
   CLIENT_MDP VARCHAR(25) NOT NULL,
   MONTANT_COMPTE DECIMAL(15,2),
   COMPTEUR_PIZZA INT,
   PRIMARY KEY(CLIENT_ID)
);

CREATE TABLE GESTIONNAIRE(
   GEST_ID VARCHAR(25) NOT NULL,
   GEST_PASSWORD VARCHAR(25) NOT NULL,
   PRIMARY KEY(GEST_ID)
);

CREATE TABLE VEHICULE(
   IMMAT VARCHAR(9) NOT NULL,
   MODELE VARCHAR(25) NOT NULL,
   TYPE_ID INT NOT NULL,
   PRIMARY KEY(IMMAT),
   FOREIGN KEY(TYPE_ID) REFERENCES TYPE_VEHICULE(TYPE_ID)
);

CREATE TABLE COMMANDE(
   COM_ID INT NOT NULL AUTO_INCREMENT,
   COM_DATE DATE NOT NULL,
   RETARD TINYINT(1),
   TAILLE_ID INT NOT NULL,
   PIZZA_ID INT NOT NULL,
   CLIENT_ID INT NOT NULL,
   IMMAT VARCHAR(9) NOT NULL,
   LIVREUR_ID INT NOT NULL,
   PRIMARY KEY(COM_ID),
   FOREIGN KEY(TAILLE_ID) REFERENCES TAILLE(TAILLE_ID),
   FOREIGN KEY(PIZZA_ID) REFERENCES PIZZA(PIZZA_ID),
   FOREIGN KEY(CLIENT_ID) REFERENCES CLIENT(CLIENT_ID),
   FOREIGN KEY(IMMAT) REFERENCES VEHICULE(IMMAT),
   FOREIGN KEY(LIVREUR_ID) REFERENCES LIVREUR(LIVREUR_ID)
);

CREATE TABLE COMPOSER(
   PIZZA_ID INT NOT NULL,
   INGRE_ID INT NOT NULL,
   PRIMARY KEY(PIZZA_ID, INGRE_ID),
   FOREIGN KEY(PIZZA_ID) REFERENCES PIZZA(PIZZA_ID),
   FOREIGN KEY(INGRE_ID) REFERENCES ENGREDIENT(INGRE_ID)
);
