package virtualpetsamok;

import java.util.Scanner;

public class VirtualPetShelterApp {

	public static Scanner input = new Scanner(System.in);
	public static String playerResponse;
	public static boolean hungerStatus;
	public static boolean thirstStatus;
	public static boolean oilStatus;
	public static boolean litterStatus;

	public static void main(String[] args) {

		VirtualPetShelter myShelter = new VirtualPetShelter();
		VirtualPet pet1 = new OrganicCat("Freddy", "Organic Cat", 50, 50, 5, 5, false);
		VirtualPet pet2 = new OrganicDog("Michael", "Organic Dog", 50, 50, 5, 5, 5, false);
		VirtualPet pet3 = new RoboDog("Jason", "Robot Dog", 50, 50, 0, false, 5);
		VirtualPet pet4 = new RoboCat("T-1000", "Robot Cat", 50, 50, 0, false, 5);

		myShelter.takePetIn(pet1);
		myShelter.takePetIn(pet2);
		myShelter.takePetIn(pet3);
		myShelter.takePetIn(pet4);

		Boolean gameActive = false;
		litterStatus = myShelter.checkIfLitterBoxNeedsCleaning();

		// Intro
		System.out.println("-Hello, new remote employee! Welcome to your first day working for WeCanShelterIt!");
		System.out.println("-Here at WCSI we shelter cats and dogs of both the organic and robotic varieties.");
		System.out.println(
				"-Your job will be, basically, to keep all of the pets we shelter alive by making sure that they get what they"
						+ " need (food and water, in the case of our organics, and oil in the case of our robots), keeping their facilities clean"
						+ " so  that they don't get sick, and maybe playing with them from time to time to keep their spirits "
						+ "up while they wait to be adopted.");
		System.out.println(
				"You will also be responsible for intake of new pets into the shelter and processing the adoption of any pets"
						+ "who are lucky enough too be taken out of here and into a home by new, loving petrents.");
		System.out
				.println("Simply follow the prompts and choose the best  options to keep the pets happy and healthy.");
		System.out.println("Oh and, by the way, one last tip: if you want the dogs, not only will they be happier, they"
				+ " will be much less likely to dirty their cages. You want that.");
		System.out.println("Good luck!");

		gameActive = true;

		// Game loop
		while (gameActive) {

			System.out.println("We currently shelter " + myShelter.getSize() + " pets in this facility");
			System.out.println("Here are our currently sheltered pets: ");
			for (VirtualPet pet : myShelter.pets()) {
				System.out.println(pet);
			}

			for (VirtualPet pet : myShelter.pets()) {
				if (pet instanceof OrganicInterface) {
					hungerStatus = pet.checkHungry();
					if (hungerStatus = true) {
						System.out.println(pet.getName() + " is hungry.");
					}
				}
				if (pet instanceof OrganicInterface) {
					thirstStatus = pet.checkThirsty();
					if (thirstStatus = true) {
						System.out.println(pet.getName() + " is thirsty.");
					}
				}
			}
			for (VirtualPet pet : myShelter.pets()) {
				if (pet instanceof RoboInterface) {
					oilStatus = pet.checkNeedsOil();
					if (oilStatus = true) {
						System.out.println(pet.getName() + " needs oil.");
					}
				}
			}
			for (VirtualPet pet : myShelter.pets()) {
				if (pet.checkDead()) {
					System.out.println("Oh, no! " + pet.getName() + " has died!");
					System.out.println(
							"This is unacceptable. Your services are no longer required here at the shelter. Goodbye.");
					gameActive = false;
				}
			}
			if (litterStatus = true) {
				System.out.println("The litter needs cleaning.");
			}

			System.out.println("Press 1 to feed the organic pets.");
			System.out.println("Press 2 to give the organic pets water.");
			System.out.println("Press 3 to oil robotic pets.");
			System.out.println("Press 4 to play with a pet.");
			System.out.println("Press 5 to clean the litter box.");
			System.out.println("Press 6 to clean the organic dogs' cages.");
			System.out.println("Press 7 to take a new pet in to the shelter.");
			System.out.println("Press 8 to adopt a pet out.");
			System.out.println("Press 9 to quit.");
			playerResponse = input.next();

			if (playerResponse.equals("1")) {
				for (VirtualPet pet : myShelter.pets()) {
					if (pet instanceof OrganicInterface) {
						pet.feed();
					}
				}
				System.out.println("You have fed the organic pets.");
			} else if (playerResponse.equals("2")) {
				for (VirtualPet pet : myShelter.pets()) {
					if (pet instanceof OrganicInterface) {
						pet.giveWater();
					}
				}
				System.out.println("You have watered the organic pets.");
			} else if (playerResponse.equals("3")) {
				for (VirtualPet pet : myShelter.pets()) {
					if (pet instanceof RoboInterface) {
						pet.oil();
					}
				}
				System.out.println("You have oiled the robotic pets.");
			} else if (playerResponse.equals("4")) {
				System.out.println("Please enter the name of the pet you would like to play with.");
				String petToPlayWith = input.next();
				System.out.println("You have played with " + petToPlayWith + ".");
				myShelter.playWithPet(petToPlayWith);
			} else if (playerResponse.equals("5")) {
				myShelter.setLitterBoxNastyLevel(0);
			} else if (playerResponse.equals("6")) {
				myShelter.cleanDogCages();
				System.out.println("You have cleaned the dog cages.");
			} else if (playerResponse.equals("7")) {
				System.out.println("Enter new pet name.");
				String newPetName = input.next();
				System.out.println("Press 1 if the new pet is an organic dog.");
				System.out.println("Press 2 if the new pet is an robotic dog.");
				System.out.println("Press 3 if the new pet is an organic cat");
				System.out.println("Press 4 if the new pet is an robotic cat.");
				String newPetChoice = input.next();
				if (newPetChoice.equals("1")) {
					VirtualPet NewPet = new OrganicDog(newPetName, "Organic Dog", 50, 50, 5, 5, 5, false);
					myShelter.takePetIn(NewPet);
				} else if (newPetChoice.equals("2")) {
					VirtualPet NewPet = new RoboDog(newPetName, "Robot Dog", 50, 50, 0, false, 5);
					myShelter.takePetIn(NewPet);
				} else if (newPetChoice.equals("3")) {
					VirtualPet NewPet = new OrganicCat(newPetName, "Organic Cat", 50, 50, 5, 5, false);
					myShelter.takePetIn(NewPet);
				} else if (newPetChoice.equals("4")) {
					VirtualPet NewPet = new RoboCat(newPetName, "Robot Cat", 50, 50, 0, false, 5);
					myShelter.takePetIn(NewPet);
				} else {
					System.out.println("That is not an option.");
				}
			} else if (playerResponse.equals("8")) {
				System.out.println("Please enter the name of the pet being adopted.");
				String petBeingAdopted = input.next();
				myShelter.adoptPetOut(petBeingAdopted);
			} else if (playerResponse.equals("9")) {
				System.out.println("Goodbye.");
				gameActive = false;
			} else {
				System.out.println("That is not a valid response.");
			}

			// Tick
			myShelter.shelterTick();

		}
		input.close();
	}

}
