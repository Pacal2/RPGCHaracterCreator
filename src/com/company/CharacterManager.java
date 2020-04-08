package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CharacterManager implements Serializable{

    transient Scanner input;
    private ArrayList<Character> characters;
    private int userChoice;




    public CharacterManager(){
        this.input = new Scanner(System.in);
        this.characters = new ArrayList();
    }

    public void commandLoop() throws IOException, ClassNotFoundException {

        do {
            System.out.println("*****************************************\nKREATOR POSTACI - SETTING POST-APO\nWybierz jedną z opcji:\n1 - Stwórz postać\n2 - Wyświetl postacie\n3 - Exit\nWpisz numer opcji: ");

            this.userChoice = this.input.nextInt();
            this.input.nextLine();
            switch(this.userChoice) {
                case 1:
                    Character character = new Character();
                    character.createCharacter();
                    this.characters.add(character);
                    save(characters, "save.txt");
                    break;
                case 2:
                    this.characters = load("save.txt");
                    System.out.println("Lista postaci: ");
                    for (Character charactersToList : characters) {
                        System.out.println(charactersToList.getName());
                    }

                    System.out.println("Czyje statystyki chcesz zobaczyć: ");
                    boolean found = false;
                    String characterChoice = this.input.nextLine();
                    for (Character charactersToList : characters) {
                        if (charactersToList.getName().equals(characterChoice)) {
                            charactersToList.showCharacterInfo();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Na liście nie ma takiej postaci.");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Zła komenda.\n");
            }
        } while(this.userChoice != 3);



    }

    public void save (ArrayList<Character> characterList, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(characterList);
        oos.close();
    }

    public ArrayList<Character> load(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (ArrayList<Character>) ois.readObject();
    }


}
