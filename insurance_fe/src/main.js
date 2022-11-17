import { createApp } from 'vue'
import App from './App.vue'
import store from './store'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"
import 'v-calendar/dist/style.css';
import VCalendar from 'v-calendar';


createApp(App).use(store).use(VCalendar, {}).mount('#app')
