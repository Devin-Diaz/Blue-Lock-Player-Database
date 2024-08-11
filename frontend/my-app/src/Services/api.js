import axios from 'axios';

const api = axios.create({
    baseURL: 'https://blue-lock-player-database-production.up.railway.app' 
});

export default api;
