<template>
  <div>
    <update-pet-listing
      v-bind:petId="parseInt($route.params.petId)" />
      <!-- v-bind:pet="($route.params.pet)" /> -->
  </div>
</template>

<script>
import UpdatePetListing from "../components/UpdatePetListing.vue";

export default {
  components: {
    UpdatePetListing
  }
};
</script>

<style>
</style>
