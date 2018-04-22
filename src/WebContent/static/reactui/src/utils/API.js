import axios from 'axios';

export default {
    // Gets all books
    getStocks: function() {
      return axios.get("/stocks");
    },
    getWeather: function() {
      return axios.get("/weather");
    }
  };