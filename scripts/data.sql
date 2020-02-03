INSERT INTO PIZZA (PIZZA_NOM, PRIX_BASE)
VALUES ('Margherita', 11),
       ('Reine', 11),
       ('Napolitaine', 12),
       ('Marinara', 11),
       ('Diavola', 12),
       ('Romaine', 12),
       ('Sicilienne', 12),
       ('Capricciosa', 13),
       ('Quatre fromages', 12),
       ('Calzone', 11),
       ('Toute garnie', 13),
       ('Hawaïenne', 12);

INSERT INTO INGREDIENT (INGRE_NOM)
VALUES ('Tomate'),
       ('Mozzarella'),
       ('Basilic'),
       ('Huile olive'),
       ('Jambon'),
       ('Champignon'),
       ('Anchois'),
       ('Origan'),
       ('Olive'),
       ('Ail'),
       ('Salami'),
       ('Câpres'),
       ('Artichaut'),
       ('Pepperoni'),
       ('Poivron'),
       ('Fromage de chevre'),
       ('Sauce tomate'),
       ('Oeuf'),
       ('Ananas'),
       ('Parmesan'),
       ('Emmental rape');

INSERT INTO TAILLE (TAILLE_NOM, COEF)
VALUES ('Naine', 0.66),
       ('Humaine', 1),
       ('Ogresse', 1.33);

INSERT INTO LIVREUR (LIVREUR_NOM)
VALUES ('Frodo'),
       ('Sauron'),
       ('Gollum'),
       ('Boromir');

INSERT INTO TYPE_VEHICULE (TYPE_NOM)
VALUES ('Voiture'),
       ('Scooter');

INSERT INTO CLIENT (CLIENT_NOM, CLIENT_PRENOM, CLIENT_ADRS, MONTANT_COMPTE, COMPTEUR_PIZZA)
VALUES ('Baggins', 'Bilbo', 'Hobbiton', 100.30, 3),
       ('Oakenshield', 'Thorin', 'Blue Mountains', 32.09, 2),
       ('Bombadil', 'Tom', 'Old forest', 76.45, 2),
       ('Gamgee', 'Samwise', 'Hobbiton', 784.99, 6),
       ('Brandybuck', 'Meriadoc', 'Hobbiton', 659.54, 5),
       ('the White', 'Gandalf', 'Valinor', 43.44, 2),
       ('Peredhel', 'Elrond', 'Rivendell', 398.87, 3),
       ('the Bowman', 'Bard', 'Esgaroth', 10.76, 3),
       ('Felagund', 'Finrod', 'Nargothrond', 123.45, 2),
       ('Inglorion', 'Gildor', 'Rivendell', 432.49, 3);

INSERT INTO VEHICULE (IMMAT, MODELE, TYPE_ID)
VALUES ('JH-257-YT', 'Piaggio Liberty 50', 2),
       ('PM-967-PO', 'Peugeot 208', 1),
       ('BA-874-RN', 'Citroen Berlingo', 1),
       ('QQ-337-ZC', 'Piaggio Liberty 50', 2),
       ('FV-148-RA', 'Kymco Agility Delivry 50', 2),
       ('JZ-272-KE', 'Mercedes classe C', 1);

INSERT INTO COMMANDE (COM_DATE, FIDELITE, RETARD, TAILLE_ID, PIZZA_ID, CLIENT_ID, VEHIC_ID, LIVREUR_ID)
VALUES ('2019-08-14', 0, 0, 2, 3, 4, 2, 1),
       ('2019-08-18', 0, 1, 1, 12, 10, 5, 1),
       ('2019-09-04', 0, 1, 1, 1, 9, 4, 3),
       ('2019-09-11', 0, 0, 1, 6, 4, 1, 2),
       ('2019-09-14', 0, 0, 2, 3, 4, 4, 1),
       ('2019-09-18', 0, 0, 3, 8, 7, 3, 2),
       ('2019-09-21', 0, 0, 3, 10, 8, 5, 4),
       ('2019-10-02', 0, 0, 2, 11, 1, 5, 1),
       ('2019-10-07', 0, 1, 2, 9, 3, 4, 3),
       ('2019-10-17', 0, 0, 2, 4, 10, 2, 2),
       ('2019-10-27', 0, 0, 2, 1, 2, 4, 4),
       ('2019-10-27', 0, 0, 3, 8, 4, 4, 1),
       ('2019-10-30', 0, 0, 3, 3, 4, 2, 1),
       ('2019-11-01', 0, 1, 1, 2, 5, 5, 1),
       ('2019-11-01', 0, 1, 3, 2, 5, 1, 1),
       ('2019-11-07', 0, 1, 3, 6, 5, 5, 1),
       ('2019-11-09', 0, 1, 3, 7, 6, 1, 4),
       ('2019-11-15', 0, 0, 2, 7, 6, 2, 4),
       ('2019-11-21', 0, 0, 2, 8, 9, 3, 2),
       ('2019-11-25', 0, 0, 2, 12, 2, 5, 3),
       ('2019-11-29', 0, 0, 2, 4, 8, 4, 2),
       ('2019-12-03', 0, 0, 1, 3, 3, 3, 3),
       ('2019-12-10', 0, 1, 3, 9, 5, 1, 1),
       ('2019-12-14', 0, 0, 3, 9, 10, 5, 3),
       ('2019-12-20', 0, 0, 3, 4, 7, 2, 1),
       ('2019-12-21', 0, 0, 3, 6, 1, 1, 2),
       ('2020-01-05', 0, 1, 2, 10, 8, 2, 3),
       ('2020-01-12', 0, 1, 3, 2, 5, 1, 1),
       ('2020-01-19', 0, 1, 1, 11, 7, 1, 4),
       ('2020-01-19', 0, 0, 2, 5, 1, 5, 2),
       ('2020-01-20', 0, 0, 2, 6, 4, 4, 3);

INSERT INTO COMPOSER
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 1),
       (2, 2),
       (2, 5),
       (2, 6),
       (3, 1),
       (3, 2),
       (3, 4),
       (3, 7),
       (3, 8),
       (3, 9),
       (4, 1),
       (4, 4),
       (4, 8),
       (4, 10),
       (5, 1),
       (5, 2),
       (5, 11),
       (6, 1),
       (6, 2),
       (6, 4),
       (6, 7),
       (6, 8),
       (7, 1),
       (7, 2),
       (7, 3),
       (7, 6),
       (7, 7),
       (7, 12),
       (8, 1),
       (8, 4),
       (8, 5),
       (8, 6),
       (8, 9),
       (8, 13),
       (9, 2),
       (9, 16),
       (9, 20),
       (9, 21),
       (10, 2),
       (10, 5),
       (10, 6),
       (10, 17),
       (10, 18),
       (11, 2),
       (11, 6),
       (11, 14),
       (11, 15),
       (11, 17),
       (12, 1),
       (12, 2),
       (12, 5),
       (12, 19);

INSERT INTO GESTIONNAIRE
VALUES ('plouf', 'sap');
