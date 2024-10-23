<template>
  <div id="app">
    <!-- <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <weather-text></weather-text>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
import WeatherText from './components/WeatherText.vue';
export default {
  name: 'App',
  components: {
    // HelloWorld,
    WeatherText,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
