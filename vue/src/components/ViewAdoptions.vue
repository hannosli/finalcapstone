<template>
<body>
  <div class="container">
    <button @click="scrollToTop" class="scroll-btn"><ion-icon name="paw-outline"></ion-icon></button>
    <div class="btn-container" id="btn-container">
      <button @click="selectSpecies(null)">All Adopted Pets</button>
      <button @click="selectSpecies('Dog')">Dogs</button>
      <button @click="selectSpecies('Cat')">Cats</button>
      <button @click="selectSpecies('Bird')">Birds</button>
      <button @click="selectSpecies('Guinea Pig')">Guinea Pigs</button>
      <button @click="selectSpecies('Hamster')">Hamsters</button>
    </div>
    <div class="pet-container" id="pet-container">
      <div
        v-for="pet in filteredPets"
        :key="pet.petId"
        class="pet-card"
      >
              <div class="image-container">
                <img v-for="photo in petPhotos[pet.petId]" :key="photo" :src="photo" alt="Photos of this Pet">
              </div>
              <div class="text-box">
                <p>{{ pet.petName }}</p>
                <p>Species: {{ pet.species }}</p>
                <p>Breed: {{ pet.breed }}</p>
                <p>{{ pet.description }}</p>
                <p> Date Adopted: {{ pet.adoptionDate }}</p>
                <button class="button" v-show="$store.state.user.authorities[0].name.includes('ROLE_VOLUNTEER') ||$store.state.user.authorities[0].name.includes('ROLE_ADMIN')"><router-link
                  :to="{
                    name: 'update-pet-page',
                    params: { petId: pet.petId, pet: pet },
                  }"
                  class="button"
                  >Edit</router-link
                ></button>
              </div>
            </div>
          </div>
        </div>
        </body>
</template>

<script>
import petservice from "../services/PetService";
export default {
  name: "view-adoptions",
  data() {
    return {
      selectedSpecies: null,
      petPhotos: {},
    };
  },
  mounted() {
    this.retrievePets();
  },
  methods: {
    retrievePets() {
      petservice.findAdoptedPets().then((response) => {
        this.$store.commit("SET_ADOPTIONS_INFO", response.data);
        response.data.forEach((pet) => {
          this.retrievePetPhotos(pet.petId);
        });
      });
    },
    retrievePetPhotos(petId) {
      petservice.findAllPhotos(petId).then((response) => {
        this.$store.commit("SET_PET_PHOTOS", { petId: petId, photos: response.data });
        this.$set(this.petPhotos, petId, response.data);
      });
    },
    selectSpecies(species) {
      this.selectedSpecies = species;
    },
     scrollToTop() {
      window.scrollTo({
        top: 0,
        behavior: 'smooth',
      });},
  },
  computed: {
    pets() {
      return this.$store.state.adoptedPets;
    },
    filteredPets() {
      if (!this.selectedSpecies) {
        return this.$store.state.adoptedPets;
      }
      return this.$store.state.adoptedPets.filter(
        (pet) => pet.species === this.selectedSpecies
      );
    },
  },
};
</script>


<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300&family=Poppins:wght@300;400;500&display=swap");
body {
   background-image: url('../assets/background2.png');
   background-repeat: repeat;
}
.pet-container {
  font-family: Montserrat, sans-serif;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: flex-start;
  height: 100%;
  position: static; 
  top: 325px; 
  padding: 0 2px;
  margin-top: 50px;
  max-width: 1200px;
}
img {
  width: 300px;
  height: 300px;
  object-fit: cover;
}
.image-container {
  display: flex;
  flex-direction: row;
  justify-content: center;
  border-radius: 5px;
  align-items: center;
  height: 300px;
  width: 300px;
  overflow-y: hidden;
}
.pet-card {
  position: relative;
  margin: 10px;
  padding: 30px;
  border: 1px solid #ccc;
  border-radius: 5px;
  display: flex;
  flex-direction: column;
  align-items: center;
  max-width: 300px;
  backdrop-filter: blur(10px);
  box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.2);
  transition: transform 500ms ease;
  background-color: rgba(197, 172, 207, 0.8);
  z-index: 1;
  font-weight: bold;
  flex-basis: calc(50% - 20px);
  width: calc(50% - 10px);
  margin: 10px;
}

.pet-card:hover {
  transform: scale(1.05);
 
}
button {
  border: none;
}
button .button {
  cursor: pointer;
  display: inline;
  text-decoration: none;
  color: black;
  background-color: rgb(195, 226, 199);
  padding: 0.5em 1.25em;
  border-radius: 0.25em;
  font-weight: bold;
}
.button:hover,
.button:focus {
  background-color: rgb(208, 182, 214);
}

.text-box {
  background-color: white;
  padding: 10px 30px 30px;
  border-radius: 5px;
  line-height: 1; 
  margin-top: 0px;
  height: 40%;
  width: 80%;
}
.logo {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 50px;
}

.logo img {
  max-width: 400px;
  max-height: 200px;
}
.btn {
  border: none;
  outline: none;
  padding: 12px 16px;
  background-color: #f1f1f1;
  cursor: pointer;
}
.btn:hover {
  background-color: #ddd;
}
.btn.active {
  background-color: #666;
  color: white;
}
.btn-container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 20px;
}
.btn-container button {
  cursor: pointer;
  display: inline-block;
  font-size: 16px;
  font-weight: 600;
  text-align: center;
  text-transform: uppercase;
  padding: 8px 16px;
  border: none;
  border-radius: 4px;
  margin: 0 4px;
  transition: all 0.3s ease;
  background-color: rgb(195, 226, 199);
  color: black;
  box-shadow: 0px 1px 1px rgba(0, 0, 0, 0.1);
}
.btn-container button:hover {
  background-color: rgb(218, 219, 221);
}
#pet-container {
  height: 500px;
}
button {
  height: -100px;
  z-index: 15;
  background-color: rgb(195, 226, 199);
  margin-top: -100px;
}

.pet-card:hover .card-content {
  transform: translateY(0);
}
.scroll-btn {
  position: fixed;
  right: 20px;
  bottom: 100px;
  height: 60px;
  width: 60px;
  margin: 30px;
  border-radius: 50%;
  background-color: rgb(195, 226, 199);
  color: #5c5470;
  font-size: 24px;
  line-height: 50px;
  text-align: center;
  cursor: pointer;
  opacity: 0.5;
  transition: opacity 0.3s;
}

.scroll-btn:hover {
  opacity: 1;
  background-color: #5c5470;
}
.scroll-btn::before {
  content: '';
  display: inline-block;
  vertical-align: middle;
  height: 50%;
}
.scroll-btn ion-icon {
  display:inline-block;
  vertical-align: middle;
  
}
@media only screen and (max-width: 768px) {
  .pet-container {
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
   
  }
  .image-container {
    height: 200px;
    width: 100%;
    margin-bottom: 10px;
  }

  img {
    width: 100%;
    height: 100%;
  }
  .btn-container {
    display:flex;
    flex-wrap: wrap;
    justify-content: center;
    margin: 0 -5px;
    margin-top: 200px;

  }
  .btn-container button {
    font-size: 12px;
    padding: 5px 10px;
    margin: 5px;
    display: inline-block;
  }
  .scroll-btn {
    display: none;
  }
  }

</style>