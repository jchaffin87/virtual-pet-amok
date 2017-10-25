package virtualpetsamok;

public abstract class Dogs extends VirtualPet {

	protected int walkDesire;

	public Dogs(String name, String description, int happiness, int health, boolean pooedInCage, int walkDesire) {
		super(name, description, happiness, health, pooedInCage);
		this.walkDesire = walkDesire;
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
	public abstract boolean checkHungry();

	@Override
	public abstract boolean checkThirsty();

	@Override
	public abstract boolean checkDead();

	// Activity Methods (effect instance variables)
	public void walk() {
		if (walkDesire >= 5) {
			walkDesire -= 5;
			happiness += 2;
		} else {
			walkDesire = 0;
			happiness += 2;
		}

	}

	@Override
	public void feed() {
	}

	@Override
	public void giveWater() {
	}

	@Override
	public void oil() {
	}

	@Override
	public void play() {
	}

	// Tick method override
	@Override
	public void tick() {
	}

}
