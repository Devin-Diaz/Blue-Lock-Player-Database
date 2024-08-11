import axios from 'axios';

const api = axios.create({
    baseURL: 'https://blue-lock-player-database-production.up.railway.app' // Make sure to include 'https://' or 'http://'
});

export default api;
