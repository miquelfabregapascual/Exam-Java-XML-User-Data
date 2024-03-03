/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AluCiclesGS1
 */
public class Examen {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int choice;
    do {
        System.out.println("Select an exercise to run:");
        System.out.println("1. Player with less level");
        System.out.println("2. Create user mail");
        System.out.println("3. See mails");

        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                exercise1();
                break;
            case 2:
                exercise2();
                break;
            case 3:
                exercise3();
                break;
         
           
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 0);
}

    public static Document openXMLFile(String xmlFile) throws Exception {
        File fxml = new File(xmlFile);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = (Document) dBuilder.parse(fxml);
        doc.getDocumentElement().normalize();
        return doc;
    }

    
  private static void exercise1() throws Exception {
    Document doc = openXMLFile("./src/Examen/Players.xml");
    NodeList players = doc.getElementsByTagName("player");

    double lowestLevel = Double.MAX_VALUE;
    double lowestGold = Double.MAX_VALUE;
    double lowestHealth = Double.MAX_VALUE;
    double lowestAttack = Double.MAX_VALUE;
    double lowestDefense = Double.MAX_VALUE;
    double lowestMagic = Double.MAX_VALUE;

    Element playerLowestLevel = null;
    Element playerLowestGold = null;
    Element playerLowestHealth = null;
    Element playerLowestAttack = null;
    Element playerLowestDefense = null;
    Element playerLowestMagic = null;

    for (int i = 0; i < players.getLength(); i++) {
        Element player = (Element) players.item(i);

        double level = Double.parseDouble(player.getElementsByTagName("level").item(0).getTextContent());
        double gold = Double.parseDouble(player.getElementsByTagName("gold").item(0).getTextContent());
        double health = Double.parseDouble(player.getElementsByTagName("health").item(0).getTextContent());
        double attack = Double.parseDouble(player.getElementsByTagName("attack").item(0).getTextContent());
        double defense = Double.parseDouble(player.getElementsByTagName("defense").item(0).getTextContent());
        double magic = Double.parseDouble(player.getElementsByTagName("magic").item(0).getTextContent());

        if (level < lowestLevel) {
            lowestLevel = level;
            playerLowestLevel = player;
        }

        if (gold < lowestGold) {
            lowestGold = gold;
            playerLowestGold = player;
        }

        if (health < lowestHealth) {
            lowestHealth = health;
            playerLowestHealth = player;
        }

        if (attack < lowestAttack) {
            lowestAttack = attack;
            playerLowestAttack = player;
        }

        if (defense < lowestDefense) {
            lowestDefense = defense;
            playerLowestDefense = player;
        }

        if (magic < lowestMagic) {
            lowestMagic = magic;
            playerLowestMagic = player;
        }
    }

    System.out.println("Player with lowest level: " + playerLowestLevel.getElementsByTagName("name").item(0).getTextContent());
    System.out.println("Stats:");
    System.out.println("Level: " + playerLowestLevel.getElementsByTagName("level").item(0).getTextContent());
    System.out.println("Gold: " + playerLowestLevel.getElementsByTagName("gold").item(0).getTextContent());
    System.out.println("Health: " + playerLowestLevel.getElementsByTagName("health").item(0).getTextContent());
    System.out.println("Attack: " + playerLowestLevel.getElementsByTagName("attack").item(0).getTextContent());
    System.out.println("Defense: " + playerLowestLevel.getElementsByTagName("defense").item(0).getTextContent());
    System.out.println("Magic: " + playerLowestLevel.getElementsByTagName("magic").item(0).getTextContent());
    System.out.println();

    // Repeat for other attributes
    System.out.println("Player with lowest gold: " + playerLowestGold.getElementsByTagName("name").item(0).getTextContent());
    System.out.println("Stats:");
    System.out.println("Level: " + playerLowestGold.getElementsByTagName("level").item(0).getTextContent());
    System.out.println("Gold: " + playerLowestGold.getElementsByTagName("gold").item(0).getTextContent());
    System.out.println("Health: " + playerLowestGold.getElementsByTagName("health").item(0).getTextContent());
    System.out.println("Attack: " + playerLowestGold.getElementsByTagName("attack").item(0).getTextContent());
    System.out.println("Defense: " + playerLowestGold.getElementsByTagName("defense").item(0).getTextContent());
    System.out.println("Magic: " + playerLowestGold.getElementsByTagName("magic").item(0).getTextContent());
    System.out.println();

    System.out.println("Player with lowest health: " + playerLowestHealth.getElementsByTagName("name").item(0).getTextContent());
    System.out.println("Stats:");
    System.out.println("Level: " + playerLowestHealth.getElementsByTagName("level").item(0).getTextContent());
    System.out.println("Gold: " + playerLowestHealth.getElementsByTagName("gold").item(0).getTextContent());
    System.out.println("Health: " + playerLowestHealth.getElementsByTagName("health").item(0).getTextContent());
    System.out.println("Attack: " + playerLowestHealth.getElementsByTagName("attack").item(0).getTextContent());
    System.out.println("Defense: " + playerLowestHealth.getElementsByTagName("defense").item(0).getTextContent());
    System.out.println("Magic: " + playerLowestHealth.getElementsByTagName("magic").item(0).getTextContent());
    System.out.println();

    System.out.println("Player with lowest attack: " + playerLowestAttack.getElementsByTagName("name").item(0).getTextContent());
    System.out.println("Stats:");
    System.out.println("Level: " + playerLowestAttack.getElementsByTagName("level").item(0).getTextContent());
    System.out.println("Gold: " + playerLowestAttack.getElementsByTagName("gold").item(0).getTextContent());
    System.out.println("Health: " + playerLowestAttack.getElementsByTagName("health").item(0).getTextContent());
    System.out.println("Attack: " + playerLowestAttack.getElementsByTagName("attack").item(0).getTextContent());
    System.out.println("Defense: " + playerLowestAttack.getElementsByTagName("defense").item(0).getTextContent());
    System.out.println("Magic: " + playerLowestAttack.getElementsByTagName("magic").item(0).getTextContent());
    System.out.println();

    System.out.println("Player with lowest defense: " + playerLowestDefense.getElementsByTagName("name").item(0).getTextContent());
    System.out.println("Stats:");
    System.out.println("Level: " + playerLowestDefense.getElementsByTagName("level").item(0).getTextContent());
    System.out.println("Gold: " + playerLowestDefense.getElementsByTagName("gold").item(0).getTextContent());
    System.out.println("Health: " + playerLowestDefense.getElementsByTagName("health").item(0).getTextContent());
    System.out.println("Attack: " + playerLowestDefense.getElementsByTagName("attack").item(0).getTextContent());
    System.out.println("Defense: " + playerLowestDefense.getElementsByTagName("defense").item(0).getTextContent());
    System.out.println("Magic: " + playerLowestDefense.getElementsByTagName("magic").item(0).getTextContent());
    System.out.println();

    System.out.println("Player with lowest magic: " + playerLowestMagic.getElementsByTagName("name").item(0).getTextContent());
    System.out.println("Stats:");
    System.out.println("Level: " + playerLowestMagic.getElementsByTagName("level").item(0).getTextContent());
    System.out.println("Gold: " + playerLowestMagic.getElementsByTagName("gold").item(0).getTextContent());
    System.out.println("Health: " + playerLowestMagic.getElementsByTagName("health").item(0).getTextContent());
    System.out.println("Attack: " + playerLowestMagic.getElementsByTagName("attack").item(0).getTextContent());
    System.out.println("Defense: " + playerLowestMagic.getElementsByTagName("defense").item(0).getTextContent());
    System.out.println("Magic: " + playerLowestMagic.getElementsByTagName("magic").item(0).getTextContent());
    System.out.println();
}

    private static void exercise2() throws Exception {
        FileWriter f = null;
        try {
            f = new FileWriter("./file.txt", true);
            Scanner input = new Scanner(System.in);
            String text = "a";
            while (!"".equals(text)) {
                System.out.println("Enter the username (leave blank to finish):");
                text = input.nextLine();
                System.out.println("Enter the password (leave blank to finish):");
                String password = input.nextLine();
                System.out.println("Enter the email (leave blank to finish):");
                String email = input.nextLine();
                if (!"".equals(text)) {
                  f.write(text + ":" + password + " : email :" + email + "\n");
                }
            }
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void exercise3() throws Exception {
    try {
        FileReader fr = new FileReader("./file.txt");
        BufferedReader buf = new BufferedReader(fr);
        String line;

        while ((line = buf.readLine()) != null) {
            System.out.println(line);
        }

        buf.close();
    } catch (IOException ex) {
        Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
    }
     }
}

