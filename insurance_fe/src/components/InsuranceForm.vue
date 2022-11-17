<template>
  <div class="insurance_form">
    <header class="d-flex justify-content-center align-items-center my-5">
      <h1 class="fw-bold">Insurance</h1>
      <h5 class="fw-bold mx-2">by Ivan</h5>
    </header>

    <div class="form-inline my-5 fw-bold">
      <div class="form-wrapper d-flex justify-content-center align-items-center">
        <div class="select-wrapper mx-5">
          <div class="d-flex justify-content-center align-items-center my-4">
            <label class="my-1 mr-2 w-50" for="inlineFormCustomSelectPref">Variant poistenia</label>
            <select v-model="this.lifeSpanType" class="form-select" aria-label="Default select example">
              <option value="1">Vyber variant poistenia</option>
              <option v-for="lifeSpanType in this.lifeSpanTypes" :key="lifeSpanType" :value="lifeSpanType">
                {{ lifeSpanType }}
              </option>;
            </select>
          </div>
          <div class="d-flex justify-content-center align-items-center my-4">
            <label class="my-1 mr-2 w-50" for="inlineFormCustomSelectPref">Balík</label>
            <select v-model="this.packageType" class="form-select" aria-label="Default select example">
              <option selected value="1">Vyber balík</option>
                <option v-for="packageType in this.packageTypes" :key="packageType" :value="packageType">
                  {{ packageType }}
                </option>;
            </select>
          </div>
          <div class="d-flex justify-content-center align-items-center my-4">
            <label class="my-1 mr-2 w-50" for="inlineFormCustomSelectPref">Pripoistenia</label>
            <div class="form-check" v-for="additionalInsurance in this.additionalInsurances" :key="additionalInsurance">
              <input v-model="this.additionalInsurance" class="form-check-input" type="checkbox" :value="additionalInsurance" :id="'flexCheckDefault_' + additionalInsurance">
              <label class="form-check-label" :for="'flexCheckDefault_' + additionalInsurance">
                {{ additionalInsurance }}
              </label>
            </div>
          </div>
          <div class="d-flex justify-content-center align-items-center my-4">
            <label class="my-1 mr-2 w-50" for="inlineFormCustomSelectPref">Počet osôb</label>
            <select v-model="this.persons" class="form-select" aria-label="Default select example">
              <option v-for="index in 3" :key="index" :value="index">
                  {{ index }}
              </option>;
            </select>
          </div>
        </div>
        <div class="date-picker-wrapper" v-if="this.lifeSpanType === 'krátkodobé poistenie'">
          <label class="d-flex justify-content-start my-1" for="inlineFormCustomSelectPref">Vyber deň</label>
          <v-date-picker v-model="this.range" is-range :min-date='new Date()'>
            <template v-slot="{ inputValue, inputEvents }">
              <div class="flex justify-center items-center">
                <input
                  :value="inputValue.start"
                  v-on="inputEvents.start"
                  class="border px-2 py-1 w-32 rounded focus:outline-none focus:border-indigo-300"
                />
                <input
                  :value="inputValue.end"
                  v-on="inputEvents.end"
                  class="border px-2 py-1 w-32 rounded focus:outline-none focus:border-indigo-300"
                />
              </div>
            </template>
          </v-date-picker>
        </div>
        <div class="date-picker-wrapper" v-if="this.lifeSpanType === 'celoročné poistenie'">
          <label class="d-flex justify-content-start my-1" for="inlineFormCustomSelectPref">Vyber deň</label>
          <v-date-picker v-model="date" :input-debounce="500" :min-date='new Date()'>
            <template v-slot="{ inputValue, inputEvents }">
              <input
                class="bg-white border px-2 py-1 rounded"
                :value="inputValue"
                v-on="inputEvents"
              />
            </template>
          </v-date-picker>
        </div>
      </div>
      <button @click="submit" class="btn btn-primary my-1">Submit</button>
    </div>

    <div class="h1 fw-bold">Records</div>
    <insurance-records/>
  </div>
</template>

<script>
import InsuranceRecords from "./InsuranceRecords.vue";
import { mapActions } from "vuex";

export default {
  name: 'insurance-form',
  components: {
    InsuranceRecords,
  },
  data() {
    return {
      insurances: [],
      additionalInsurances: [],
      packageTypes: [],
      lifeSpanTypes: [],
      insurance: {},
      additionalInsurance: [],
      persons: 1,
      packageType: "základný",
      lifeSpanType: "",
      date: new Date(),
      range: {
        start: new Date(),
        end: new Date()
      }
    }
  },
  methods: {
    ...mapActions(["getInsurances", "getAdditionalInsurances", "getPackageTypes", "getLifeSpanTypes","saveInsurance"]),
    submit() {
      console.log(this.insurance);
      this.insurance = {
        lifeSpanType: this.lifeSpanType,
        packageType: this.packageType,
        persons: this.persons
      };
      if (this.additionalInsurance.length !== 0) {
        this.insurance.additionalInsurance = this.additionalInsurance;
      }
      if (this.lifeSpanType !== 'celoročné poistenie') {
        this.insurance.toDate = this.range.end; 
        this.insurance.fromDate = this.range.start;
      } else {
        this.insurance.fromDate = this.date; 
      }
      console.log(this.insurance);
      this.saveInsurance(this.insurance);
    }
  },
  created () {
    this.getInsurances().then(data => this.insurances = data);
    this.getAdditionalInsurances().then(data => this.additionalInsurances = data);
    this.getPackageTypes().then(data => this.packageTypes = data);
    this.getLifeSpanTypes().then(data => this.lifeSpanTypes = data);
  },
  
}
</script>
