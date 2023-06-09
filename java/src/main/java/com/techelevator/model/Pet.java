package com.techelevator.model;

import java.util.Date;

public class Pet {
    private int petId;
    private String petName;
    private String species;
    //TODO LocalDate ???
    private String adoptionDate;
    private String gender;
    private String breed;
    private int age;
    private String description;
    private boolean isAdopted;
    private String petPhoto;
    public Pet(){

    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", petName='" + petName + '\'' +
                ", species='" + species + '\'' +
                ", adoptionDate=" + adoptionDate +
                ", gender='" + gender + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", isAdopted=" + isAdopted +
                ", petPhoto=" + petPhoto +
                '}';
    }

    public Pet(int petId, String petName, String species, String adoptionDate, String gender, String breed, int age, String description, boolean isAdopted, String petPhoto) {
        this.petId = petId;
        this.petName = petName;
        this.species = species;
        this.adoptionDate = adoptionDate;
        this.gender = gender;
        this.breed = breed;
        this.age = age;
        this.description = description;
        this.isAdopted = isAdopted;
        this.petPhoto = petPhoto;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getAdoptionDate() {
        return adoptionDate;
    }

    public String setAdoptionDate(String adoptionDate) {
        return this.adoptionDate = adoptionDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }

    public String getPetPhoto() { return petPhoto;}

    public void setPetPhoto(String petPhoto) {
        this.petPhoto = petPhoto;
    }

}
