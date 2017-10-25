package virtualpetsamok;

public class RoboCat extends VirtualPet implements RoboInterface {

	private int oilLevel;

	public RoboCat(String name, String description, int happiness, int health, int walkDesire, boolean pooedInCage,
			int oilLevel) {
		super(name, description, happiness, health, pooedInCage);
		this.oilLevel = oilLevel;
		oilLevel = 10;
		description = "Robot Cat";
	}

	// Getters
	public int getOilLevel() {
		return oilLevel;
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
	public boolean checkNeedsOil() {
		if (oilLevel <= 8) {
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

	@Override
	public boolean checkHungry() {
		return false;
	}

	@Override
	public boolean checkThirsty() {
		return false;
	}

	// Activity Methods (effect instance variables)
	@Override
	public void oil() {
		oilLevel += 5;
	}

	@Override
	public void feed() {
	}

	@Override
	public void giveWater() {
	}

	@Override
	public void play() {
		happiness = happiness++;
	}

	// Tick method override
	@Override
	public void tick() {
		oilLevel -= 1;
		if (oilLevel <= 5) {
			happiness -= 1;
		}
		if (happiness <= 10) {
			health -= 1;
		}
	}

	@Override
	public String toString() {
		return "\nPet Name:\t " + name + "\nDescription: \t" + description + "\nHappiness: \t" + happiness
				+ "\nHealth: \t" + health + "\nOil Level: \t" + oilLevel + "\n";
	}

}
