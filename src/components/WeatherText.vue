<template>
  <div class="weather-report">
    <h1>天气预报</h1>
    <div class="input-group">
      <input type="text" v-model="city" placeholder="请输入城市名" />
      <button @click="getWeatherData">提交</button>
    </div>
    <div v-if="weatherData" class="weather-details">
      <div class="weather-info">
        <p>省份: <span class="detail">{{ weatherData[0] }}</span></p>
        <p>城市: <span class="detail">{{ weatherData[1] }}</span></p>
        <p>温度: <span class="detail">{{ weatherData[5] }}</span></p>
        <p>天气状况: <span class="detail">{{ weatherData[6] }}</span></p>
        <p>风向/风力: <span class="detail">{{ weatherData[7] }}</span></p>
      </div>
      <div class="weather-indexes">
        <p>紫外线指数: <span class="detail">{{ weatherData[8] }}</span></p>
        <p>穿衣指数: <span class="detail">{{ weatherData[9] }}</span></p>
        <p>洗车指数: <span class="detail">{{ weatherData[10] }}</span></p>
        <p>运动指数: <span class="detail">{{ weatherData[11] }}</span></p>
        <p>过敏指数: <span class="detail">{{ weatherData[12] }}</span></p>
      </div>
    </div>
    <div v-else class="loading">
      <p>加载天气数据中...</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      city: '南京', // 默认城市
      weatherData: null
    };
  },
  methods: {
    getWeatherData() {
      if (!this.city) {
        alert('请输入城市名');
        return;
      }
      axios.post('api/WebServices/WeatherWebService.asmx/getWeatherbyCityName', 
        'theCityName=' + encodeURIComponent(this.city), 
        {
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
          }
        }
      )
      .then(response => {
        const parser = new DOMParser();
        const xmlDoc = parser.parseFromString(response.data, "text/xml");
        const weatherArray = xmlDoc.getElementsByTagName("string");
        this.weatherData = Array.from(weatherArray).map(node => node.childNodes[0].nodeValue);
      })
      .catch(error => {
        console.error("Error fetching weather data:", error);
      });
    }
  }
};
</script>

<style scoped>
.weather-report {
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin: 20px;
  font-family: Arial, sans-serif;
}

.input-group {
  margin-bottom: 20px;
}

.input-group input {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: 200px;
}

.input-group button {
  padding: 8px 16px;
  margin-left: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: #f0f0f0;
  cursor: pointer;
}

.input-group button:hover {
  background-color: #e0e0e0;
}

.weather-details {
  display: flex;
  justify-content: space-between;
}

.weather-info, .weather-indexes {
  width: 48%;
}

.detail {
  font-weight: bold;
  color: #333;
}

.loading {
  text-align: center;
  color: #888;
}
</style>