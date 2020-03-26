package com.company;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Character {

    Scanner input;
    private String name;
    private String race;
    private String profession;
    private int strength;
    private int dexterity;
    private int endurance;
    private int intelligence;
    private int charisma;
    private int perception;
    private int carry;
    private int health;
    private int evasion;
    private int melee;
    private int marksmanship;
    private int athletics;
    private int medicine;
    private int repair;
    private int science;
    private int vehicles;
    private int lockpick;
    private int sneak;
    private int survival;
    private int speech;
    private int barter;
    ArrayList<Item> equipment;
    private int currency;

    public Character() {
        this.input = new Scanner(System.in);
        this.strength = 1;
        this.dexterity = 1;
        this.endurance = 1;
        this.intelligence = 1;
        this.charisma = 1;
        this.perception = 1;
        this.carry = 20 + this.strength * 10;
        this.health = 10 + this.endurance * 5;
        this.evasion = 10 + this.dexterity * 2;
        this.melee = 10;
        this.marksmanship = 10;
        this.athletics = 10;
        this.medicine = 10;
        this.repair = 10;
        this.science = 10;
        this.vehicles = 10;
        this.lockpick = 10;
        this.sneak = 10;
        this.survival = 10;
        this.speech = 10;
        this.barter = 10;
        this.equipment = new ArrayList();
        this.currency = 20;
    }

    public void chooseRace() {
        do {
            System.out.println(
                    "*****************************************" +
                    "\nWybierz rasę. Wybór rasy daje jeden punkt dla danego atrybutu." +
                    "\nCzłowiek - najbardziej dominująca rasa pustkowii jak, oryginalnie jedyni inteligentni mieszkańcy ziemii (+ do charyzmy)" +
                    "\nMutant - ewoluowali od ludzi w trakcie wielkiej wojny. Większość z nich zmarła w trakcie przemiany, lecz najsilniejsi przetrwali (+ do siły)" +
                    "\nAndroid - konstrukty stworzone do walki z obcymi najeźdźcami w trakcie wielkiej wojny przez ludzi. Wkrótce jednak zyskali świadomość i się przeciwko nim odwrócili (+ do intelektu)" +
                    "\nRobal - istoty, które przybyły wraz z obcymi, nikt nie wie czy to jedna ze zniewolonych przez nich ras czy zostali przez nich stworzeni (+ do wytrzymałości)"
            );
            String raceChoice = this.input.nextLine().toLowerCase();
            this.race = "";

            switch(raceChoice) {
                case "człowiek":
                    this.race = "Człowiek";
                    ++this.charisma;
                    break;
                case "mutant":
                    this.race = "Mutant";
                    ++this.strength;
                    break;
                case "android":
                    this.race = "Android";
                    ++this.intelligence;
                    break;
                case "robal":
                    this.race = "Robal";
                    ++this.endurance;
                    break;
                default:
                    System.out.println("Musisz wybrać jedną z dostępnych ras");
            }
        } while(!this.race.equals("Człowiek") && !this.race.equals("Mutant") && !this.race.equals("Android") && !this.race.equals("Robal"));

        System.out.println("Wybrałeś rasę " + this.race + ".");
    }

    public String getRace() {
        return this.race;
    }

    public void chooseClass() {
        do {
            System.out.println(
                    "*****************************************" +
                    "\nWybierz klasę. Wybór klasy daje dodatkowe 10 punktów do dwóch umiejętności oraz ustala początkowy ekwipunek." +
                    "\nPięść - wojownicy, bandyci, dzikusy. Wszyscy polecający na sile swoich mięśni ( + do sprawności i walki wręcz, ekwipunek: włócznia i ciężka zbroja)" +
                    "\nOczko - tropiciele, strzelcy i gangsterzy. Wprawieni w broni dystansowej i znajdowaniu poszlak. (+ do broni i przetrwania, ekwipunek: strzelba i lekka zbroja" +
                    "\nMózg - naukowcy i lekarze. Polegający na sile swojego umysły (+ do medycyny i nauki, ekwipunek: lekarstwa i książka z przed-wojenną wiedzą)" +
                    "\nRączka - inżynierzy i mechanicy. Operujący praktycznymi umiejętnościami (+ do naprawy i pojazdów, ekwipunek: sprzęt do napraw, motor)Cień - złodzieje i szpiedzy. Wolący pozostać w cieniu (+ do skradania i włamywania się, ekwipunek, wytrychy i sztylet)." +
                    "\nBużka - kupcy i dyplomaci. Ludzie polegający na retoryce (+ do mowy i handlu, ekwipunek: 30 monet i pistolet)"
            );
            String classChoice = this.input.nextLine().toLowerCase();
            this.profession = "";
            switch(classChoice) {
                case "pięść":
                    this.profession = "Pięść";
                    this.melee += 10;
                    this.athletics += 10;
                    this.equipment.add(new Item("Włócznia", 1));
                    this.equipment.add(new Item("Ciężka zbroja", 1));
                    break;
                case "oczko":
                    this.profession = "Oczko";
                    this.marksmanship += 10;
                    this.survival += 10;
                    this.equipment.add(new Item("Strzelba", 1));
                    this.equipment.add(new Item("lekka zbroja", 1));
                    break;
                case "mózg":
                    this.profession = "Mózg";
                    this.science += 10;
                    this.medicine += 10;
                    this.equipment.add(new Item("Lekarstwa", 3));
                    this.equipment.add(new Item("Przed-wojenna książka", 1));
                    break;
                case "rączka":
                    this.profession = "Rączka";
                    this.repair += 10;
                    this.vehicles += 10;
                    this.equipment.add(new Item("Sprzęt do napraw", 3));
                    this.equipment.add(new Item("Zepsuty przed-wojenny sprzęt", 1));
                    break;
                case "cień":
                    this.profession = "Cień";
                    this.sneak += 10;
                    this.lockpick += 10;
                    this.equipment.add(new Item("Wytrychy", 3));
                    this.equipment.add(new Item("Sztylet", 1));
                    break;
                case "buźka":
                    this.profession = "Buźka";
                    this.speech += 10;
                    this.barter += 10;
                    this.currency += 30;
                    this.equipment.add(new Item("Pistolet", 1));
                    break;
                default:
                    System.out.println("Musisz wybrać jedną z dostępnych klas");
            }
        } while(!this.profession.equals("Pięść") && !this.profession.equals("Oczko") && !this.profession.equals("Mózg") && !this.profession.equals("Rączka") && !this.profession.equals("Cień") && !this.profession.equals("Buźka"));

        System.out.println("Wybrałeś klasę " + this.profession + ".");
    }

    public String getProfession() {
        return this.profession;
    }

    private int[] addPoints(int attribute, int maxAttribute, int pointsLeft) {
        System.out.println("Ilość punktów do dodania: ");
        int pointsToAdd = this.input.nextInt();
        this.input.nextLine();
        if (pointsToAdd > pointsLeft) {
            System.out.println("Nie masz wystarczającej liczby punktów.");
        } else if (attribute + pointsToAdd > maxAttribute) {
            System.out.println("Nie możesz dodać tylu punktów do tej cechy.");
        } else {
            attribute += pointsToAdd;
            pointsLeft -= pointsToAdd;
        }

        int[] temp = new int[]{attribute, pointsLeft};
        return temp;
    }

    private void distributeStatisticsPoints() {
        int pointsLeft = 10;
        int maxAddStatistic = 4;
        int maxStrength = this.strength + maxAddStatistic;
        int maxEndurance = this.endurance + maxAddStatistic;
        int maxDexterity = this.dexterity + maxAddStatistic;
        int maxIntelligence = this.intelligence + maxAddStatistic;
        int maxPerception = this.perception + maxAddStatistic;
        int maxCharisma = this.charisma + maxAddStatistic;

        do {
            System.out.println(
                    "*****************************************" +
                    "\nPrzydziel punkty do cech, masz do rozdania " + pointsLeft + " punktów. Maksymalnie możesz podnieść atrybut o " + maxAddStatistic + " punkty. Którą cechę chcesz pdwyższyć:" +
                    "\nSiła: " + this.strength + "" +
                    "\nKondycja: " + this.endurance + "" +
                    "\nZręczność: " + this.dexterity + "" +
                    "\nInteligencja: " + this.intelligence + "" +
                    "\nPercepcja: " + this.perception + "" +
                    "\nCharyzma: " + this.charisma);
            String attributeChoice = this.input.nextLine().toLowerCase();
            int[] temp;
            switch(attributeChoice) {
                case "siłą":
                    temp = this.addPoints(this.strength, maxStrength, pointsLeft);
                    this.strength = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "kondycja":
                    temp = this.addPoints(this.endurance, maxEndurance, pointsLeft);
                    this.endurance = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "zręczność":
                    temp = this.addPoints(this.dexterity, maxDexterity, pointsLeft);
                    this.dexterity = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "inteligencja":
                    temp = this.addPoints(this.intelligence, maxIntelligence, pointsLeft);
                    this.intelligence = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "percepcja":
                    temp = this.addPoints(this.perception, maxPerception, pointsLeft);
                    this.perception = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "charyzma":
                    temp = this.addPoints(this.charisma, maxCharisma, pointsLeft);
                    this.charisma = temp[0];
                    pointsLeft = temp[1];
                    break;
                default:
                    System.out.println("Nie ma takiej cechy do wyboru:");
            }
        } while(pointsLeft > 0);

        System.out.println("Wszystkie punkty zostały rozdane");
    }

    public void showStatistics() {
        System.out.println("Twoje statystyki: \nSiła: " + this.strength + "\nKondycja: " + this.endurance + "\nZręczność: " + this.dexterity + "\nInteligencja: " + this.intelligence + "\nPercepcja: " + this.perception + "\nCharyzma: " + this.charisma);
    }

    private void distributeSkillPoints() {
        int pointsLeft = 100;
        int maxAddStatistic = 80;
        int maxMelee = this.melee + maxAddStatistic;
        int maxMarksmanship = this.marksmanship + maxAddStatistic;
        int maxAthletics = this.athletics + maxAddStatistic;
        int maxMedicine = this.medicine + maxAddStatistic;
        int maxRepair = this.repair + maxAddStatistic;
        int maxScience = this.science + maxAddStatistic;
        int maxVehicles = this.vehicles + maxAddStatistic;
        int maxLockpick = this.lockpick + maxAddStatistic;
        int maxSneak = this.sneak + maxAddStatistic;
        int maxSurvival = this.survival + maxAddStatistic;
        int maxSpeech = this.speech + maxAddStatistic;
        int maxBarter = this.barter + maxAddStatistic;

        do {
            System.out.println(
                    "*****************************************" +
                            "\nPrzydziel punkty do umiejętności, masz do rozdania " + pointsLeft + " punktów. Maksymalnie możesz podnieść atrybut o " + maxAddStatistic + " punkty. Który atrybut chcesz pdwyższyć:" +
                            "\nFizyczne:" +
                            "\nWalka wręcz: " + this.melee + "" +
                            "\nStrzelectwo: " + this.marksmanship + "" +
                            "\nAtletyka: " + this.athletics + "" +
                            "\nWiedza:" +
                            "\nMedycyna: " + this.medicine + "" +
                            "\nNaprawa: " + this.repair + "" +
                            "\nNauka: " + this.science + "" +
                            "\nPojazdy: " + this.vehicles + "" +
                            "\nSpryt: " +
                            "\nWłamywanie się: " + this.lockpick + "" +
                            "\nSkradanie: " + this.sneak + "" +
                            "\nPrzetrwanie: " + this.survival + "" +
                            "\nRetoryka: " +
                            "\nHandel: " + this.barter + "" +
                            "\nMowa: " + this.speech);
            String skillChoice = this.input.nextLine().toLowerCase();
            int[] temp;
            switch(skillChoice) {
                case "walka wręcz":
                    temp = this.addPoints(this.melee, maxMelee, pointsLeft);
                    this.melee = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "strzelectwo":
                    temp = this.addPoints(this.marksmanship, maxMarksmanship, pointsLeft);
                    this.marksmanship = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "atletyka":
                    temp = this.addPoints(this.athletics, maxAthletics, pointsLeft);
                    this.athletics = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "medycyna":
                    temp = this.addPoints(this.medicine, maxMedicine, pointsLeft);
                    this.medicine = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "naprawa":
                    temp = this.addPoints(this.repair, maxRepair, pointsLeft);
                    this.repair = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "nauka":
                    temp = this.addPoints(this.science, maxScience, pointsLeft);
                    this.science = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "pojazdy":
                    temp = this.addPoints(this.vehicles, maxVehicles, pointsLeft);
                    this.vehicles = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "włamywanie się":
                    temp = this.addPoints(this.lockpick, maxLockpick, pointsLeft);
                    this.lockpick = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "skradanie się":
                    temp = this.addPoints(this.sneak, maxSneak, pointsLeft);
                    this.sneak = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "przetrwanie":
                    temp = this.addPoints(this.survival, maxSurvival, pointsLeft);
                    this.survival = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "handel":
                    temp = this.addPoints(this.barter, maxBarter, pointsLeft);
                    this.barter = temp[0];
                    pointsLeft = temp[1];
                    break;
                case "mowa":
                    temp = this.addPoints(this.speech, maxSpeech, pointsLeft);
                    this.speech = temp[0];
                    pointsLeft = temp[1];
                    break;
                default:
                    System.out.println("Nie ma takiej cechy do wyboru:");
            }
        } while(pointsLeft > 0);

        System.out.println("Wszystkie punkty zostały rozdane.");
    }

    public void showSkills() {
        System.out.println(
                "Twoje umiejętności:" +
                "\nFizyczne:" +
                "\nWalka wręcz: " + this.melee + "" +
                "\nStrzelectwo: " + this.marksmanship + "" +
                "\nAtletyka: " + this.athletics + "" +
                "\nWiedza:\nMedycyna: " + this.medicine + "" +
                "\nNaprawa: " + this.repair + "" +
                "\nNauka: " + this.science + "" +
                "\nPojazdy: " + this.vehicles + "" +
                "\nSpryt: " +
                "\nWłamywanie się: " + this.lockpick + "" +
                "\nSkradanie: " + this.sneak + "" +
                "\nPrzetrwanie: " + this.survival + "" +
                "\nRetoryka: " +
                "\nHandel: " + this.barter + "" +
                "\nMowa: " + this.speech);
    }

    public void showDerivedStatistics() {
        System.out.println(
                "Atrybuty:" +
                "\nPunkty życia: " + this.health + "" +
                "\nObrona: " + this.evasion + "" +
                "\nUdźwig: " + this.carry);
    }

    private void findItemAndAdd(String itemName, int amount) {
        boolean found = false;
        Iterator var4 = this.equipment.iterator();

        while(var4.hasNext()) {
            Item equipmentToList = (Item)var4.next();
            if (equipmentToList.getName().equals(itemName)) {
                equipmentToList.addAmount(amount);
                found = true;
            }
        }

        if (!found) {
            this.equipment.add(new Item(itemName, amount));
        }

    }

    private void chooseAdditionalEquipment() {
        boolean done = false;
        this.equipment.add(new Item("Prowiant (dzienna porcja)", 7));
        this.equipment.add(new Item("Woda (dzienna porcja)", 7));
        this.equipment.add(new Item("Namiot i śpiwór", 1));
        this.equipment.add(new Item("Zapalniczka", 1));
        this.equipment.add(new Item("Siekiera", 1));
        this.equipment.add(new Item("Lina (w metrach)", 10));

        do {
            System.out.println("Możesz wybrać dodatkowe przedmioty. Masz do wyboru (wybierz numer):\n1. Dodatkowe 50 monet\n2. Katana\n3. Snajperka\n4. Prowiant i woda na na tydzień\n5. Trzy porcje leków\n6. Trzy zestawy naprawcze");
            int itemChoice = this.input.nextInt();
            switch(itemChoice) {
                case 0:
                    this.currency += 50;
                    done = true;
                    break;
                case 1:
                    this.equipment.add(new Item("Katana", 1));
                    done = true;
                    break;
                case 2:
                    this.equipment.add(new Item("Snajperka", 1));
                    done = true;
                    break;
                case 3:
                    this.findItemAndAdd("Prowiant (dzienna porcja)", 7);
                    this.findItemAndAdd("Woda (dzienna porcja)", 7);
                    done = true;
                    break;
                case 4:
                    this.findItemAndAdd("Lekarstwa", 3);
                    done = true;
                    break;
                case 5:
                    this.findItemAndAdd("Sprzęt do napraw", 3);
                    done = true;
                    break;
                default:
                    System.out.println("Musisz wybrać, któryś z dostępnych przedmiotów.");
            }
        } while(!done);

        System.out.println("Dodano przedmiot do ekwipunku.");
    }

    public void showEquipment() {
        System.out.println("Ekwipunek: ");
        Iterator var1 = this.equipment.iterator();

        while(var1.hasNext()) {
            Item equipmentToList = (Item)var1.next();
            PrintStream var10000 = System.out;
            String var10001 = equipmentToList.getName();
            var10000.println(var10001 + ", Ilość: " + equipmentToList.getAmount());
        }

        System.out.println("Monety: " + this.currency);
    }

    public void setName() {
        System.out.println("Jakie jest imię twojej postaci: ");
        String nameChoice = this.input.nextLine();
        this.name = nameChoice;
        System.out.println("Twoja postać nazywa się " + this.name);
    }

    public String getName() {
        return this.name;
    }

    public void createCharacter() {
        this.chooseRace();
        this.chooseClass();
        this.distributeStatisticsPoints();
        this.distributeSkillPoints();
        this.chooseAdditionalEquipment();
        this.setName();
        System.out.println("Ukończono tworzenie postaci.");
        System.out.println("*****************************************");
    }

    public void showCharacterInfo() {
        System.out.println("*****************************************");
        System.out.println("*****************************************");
        System.out.println("Imię: " + this.getName());
        System.out.println("Rasa: " + this.getRace());
        System.out.println("Klasa: " + this.getProfession());
        System.out.println("*****************************************");
        this.showDerivedStatistics();
        System.out.println("*****************************************");
        this.showStatistics();
        System.out.println("*****************************************");
        this.showSkills();
        System.out.println("*****************************************");
        this.showEquipment();
    }

}
