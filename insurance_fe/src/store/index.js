import { createStore } from 'vuex'
import axios from "axios";

export default createStore({
  state: {
    insurances: [],
    additionalInsurances: [],
    lifeSpanTypes: [],
    packageTypes: [],
  },
  getters: {
    getInsurances: (state) => {
      return state.insurances;
    }
  },
  mutations: {
    setInsurances: (state, insurances) => {
      state.insurances = insurances;
    },
    setAdditionalInsurances: (state, additionalInsurances) => {
      state.additionalInsurances = additionalInsurances;
    },
    setLifeSpanTypes: (state, lifeSpanTypes) => {
      state.lifeSpanTypes = lifeSpanTypes;
    },
    setPackageTypes: (state, packageTypes) => {
      state.packageTypes = packageTypes;
    },
    addInsurance: (state, insurance) => {
      state.insurances.push(insurance);
    },
  },
  actions: {
    getInsurances({ commit }) {
      return new Promise((resolve, reject) => {
        axios
          .get("http://localhost:9999/")
          .then((insurances) => {
            commit("setInsurances", insurances.data);
            resolve(insurances.data);
          });
      }).catch((error) => {
        reject(error);
      });
    },
    getAdditionalInsurances({ commit }) {
      return new Promise((resolve, reject) => {
        axios
          .get("http://localhost:9999/additional-insurances")
          .then((additionalInsurances) => {
            commit("setAdditionalInsurances", additionalInsurances.data);
            resolve(additionalInsurances.data);
          });
      }).catch((error) => {
        reject(error);
      });
    },
    getPackageTypes({ commit }) {
      return new Promise((resolve, reject) => {
        axios
          .get("http://localhost:9999/package-types")
          .then((packageTypes) => {
            commit("setPackageTypes", packageTypes.data);
            resolve(packageTypes.data);
          });
      }).catch((error) => {
        reject(error);
      });
    },
    getLifeSpanTypes({ commit }) {
      return new Promise((resolve, reject) => {
        axios
          .get("http://localhost:9999/life-span-types")
          .then((lifeSpanTypes) => {
            commit("setLifeSpanTypes", lifeSpanTypes.data);
            resolve(lifeSpanTypes.data);
          });
      }).catch((error) => {
        reject(error);
      });
    },
    saveInsurance({ commit }, insurance) {
      return new Promise((resolve, reject) => {
        axios
          .post("http://localhost:9999/", insurance)
          .then((response) => {
            commit("addInsurance", response.data);
          })
          .catch((error) => {
            console.log(error.response);
          });
      }).catch((error) => {
        reject(error);
      });
    },
  }
})
