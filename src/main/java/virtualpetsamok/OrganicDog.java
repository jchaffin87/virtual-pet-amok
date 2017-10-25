package virtualpetsamok;

public class OrganicDog extends Dogs implements OrganicInterface {
	private int hunger;
	private int thirst;

	// Constructor
	public OrganicDog(String name, String description, int happiness, int health, int hunger, int thirst,
			int walkDesire, boolean pooedInCage) {
		super(name, description, happiness, health, pooedInCage, walkDesire);
		this.hunger = hunger;
		this.thirst = thirst;
		description = "Organic Dog";
	}

	// Setters
	@Override
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	@Override
	public void setHealth(int health) {
		this.health = health;
	}

	@Override
	public void setPooedInCage(boolean pooedInCage) {
		this.pooedInCage = pooedInCage;
	}

	@Override
	public void setName(String nameChoice) {
		name = nameChoice;
	}

	@Override
	public void setDescription(String descriptionChoice) {
		description = descriptionChoice;
	}

	// Getters
	@Override
	public int getWalkDesire() {
		return walkDesire;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public int getHappiness() {
		return happiness;
	}

	@Override
	public int getHealth() {
		return health;
	}

	// Instance variable threshold checks
	@Override
	public boolean checkHungry() {
		if (hunger >= 5) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public boolean checkThirsty() {
		if (thirst >= 5) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkDead() {
		if (health <= 0) {
			return true;
		} else {
			return false;
		}
	}

	// Activity Methods (effect instance variables)
	@Override
	public void feed() {
		if (hunger >= 5) {
			hunger -= 5;
		} else {
			hunger = 0;
		}

	}

	@Override
	public void giveWater() {
		if (thirst >= 5) {
			thirst -= 5;
		} else {
			thirst = 0;
		}
	}

	@Override
	public void play() {
		happiness = happiness++;
	}

	// Tick override
	@Override
	public void tick() {
		hunger += 2;
		thirst += 2;
		walkDesire += 2;
		if (walkDesire >= 10) {
			pooedInCage = true;
		}
		if (pooedInCage = true) {
			happiness -= 1;
		}
		if (hunger >= 10) {
			happiness -= 1;
		}
		if (thirst >= 10) {
			happiness -= 1;
		}
		if (happiness <= 10) {
			health -= 1;
		}
	}

	@Override
	public String toString() {
		return "\nPet Name: \t " + name + "\nDescription: \t" + description + "\nHunger: \t" + hunger + "\nThirst: \t"
				+ thirst + "\nHappiness: \t" + happiness + "\nHealth: \t" + health + "\n";
	}

	@Override
	public boolean checkNeedsOil() {
		return false;
	}

}
