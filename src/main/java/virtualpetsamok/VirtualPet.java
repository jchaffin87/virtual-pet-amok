package virtualpetsamok;

public abstract class VirtualPet {

	protected String name;
	protected String description;
	protected int happiness;
	protected int health;
	protected boolean pooedInCage;

	// Constructors
	public VirtualPet(String name, String description, int happiness, int health, boolean pooedInCage) {
		this.name = name;
		this.description = description;
		this.happiness = happiness;
		this.health = health;
		this.pooedInCage = pooedInCage;
	}

	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		health = 50;
		happiness = 50;
		pooedInCage = false;

	}

	// Setters
	public abstract void setHappiness(int happiness);

	public abstract void setHealth(int health);

	public abstract void setPooedInCage(boolean pooedInCage);

	public abstract void setName(String nameChoice);

	public abstract void setDescription(String descriptionChoice);

	// Getters
	public abstract String getName();

	public abstract String getDescription();

	public abstract int getHappiness();

	public abstract int getHealth();

	// Instance variable threshold checks
	public abstract boolean checkHungry();

	public abstract boolean checkThirsty();

	public abstract boolean checkDead();

	public abstract boolean checkNeedsOil();

	// Activity Methods (effect instance variables)
	public abstract void feed();

	public abstract void giveWater();

	public abstract void oil();

	public abstract void play();

	// Tick method
	public abstract void tick();

}
