package virtualpetsamok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private Map<String, VirtualPet> shelter = new HashMap<String, VirtualPet>();

	public Collection<VirtualPet> pets() {
		return shelter.values();
	}

	// Litter Box Checker
	public int litterBoxNastyLevel;

	public boolean checkIfLitterBoxNeedsCleaning() {
		if (litterBoxNastyLevel >= 10) {
			return true;
		} else {
			return false;
		}
	}

	// Individual Interactions
	public VirtualPet getPet(String name) {
		return shelter.get(name);
	}

	public void takePetIn(VirtualPet pet) {
		shelter.put(pet.getName(), pet);
	}

	public void adoptPetOut(String name) {
		shelter.remove(name);
	}

	public void playWithPet(String name) {
		VirtualPet selectedPet = shelter.get(name);
		selectedPet.play();
	}

	public void setLitterBoxNastyLevel(int litterBoxNastyLevel) {
		this.litterBoxNastyLevel = litterBoxNastyLevel;
	}

	// Group interactions
	public void feedOrganicPets() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof OrganicInterface) {
				pet.feed();
			}
		}
	}

	public void giveWaterToOrganicPets() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof OrganicInterface) {
				pet.giveWater();
			}
		}
	}

	public void oilRoboPets() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof RoboInterface) {
				pet.oil();
			}
		}
	}

	public void cleanDogCages() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof OrganicDog) {
				pet.setPooedInCage(false);
			}
		}
	}

	public void cleanLitterBox() {
		litterBoxNastyLevel = 0;
	}

	// Tick Method
	public void shelterTick() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof OrganicCat) {
				if (litterBoxNastyLevel >= 10) {
					pet.setHappiness(pet.getHappiness() - 1);
					litterBoxNastyLevel++;
				}
			}
			pet.tick();
		}
	}

	// Size Getter
	public int getSize() {
		return shelter.size();
	}
}
