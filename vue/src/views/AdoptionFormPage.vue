<template>
  <div>
    <adoption-form
      v-bind:petId="parseInt($route.params.petId)" 
      v-bind:petName="($route.params.petName)" /> 
  </div>
</template>

<script>
import AdoptionForm from "../components/AdoptionForm.vue";

export default {
  components: {
    AdoptionForm
  }
};
</script>

<style>
</style>