<template>
  <table class="table" id="table-margin-bottom-0">
    <thead>
      <tr>
        <th scope="col" class="fw-bold col-md-auto">Variant poistenia</th>
        <th scope="col" class="text-sm-start fw-bold col-md-auto">Začiatok poistenia</th>
        <th scope="col" class="text-sm-start fw-bold col-md-auto">Koniec poistenia</th>
        <th scope="col" class="fw-bold col-md-auto">Balík</th>
        <th scope="col" class="fw-bold col-md-auto">Pripoistenie</th>
        <th scope="col" class="fw-bold col-md-auto">Počet osôb</th>
        <th scope="col" class="fw-bold col-md-auto">Price</th>
      </tr>
    </thead>
    <tbody>
      <tr class="custom-column" v-for="insurance in insurances" :key="insurance.id">
        <th scope="row" valign="middle">
          <div class="fw-bolder">
            {{ insurance.lifeSpanType }}
          </div>
        </th>
        <td valign="middle">
          <div class="opacity-75 fw-bolder d-flex align-content-center flex-wrap mx-2">
            {{ insurance.fromDate }}
          </div>
        </td>
        <td valign="middle">
          <div class="opacity-75 fw-bolder d-flex align-content-center flex-wrap mx-2">
            {{ insurance.toDate }}
          </div>
        </td>
        <td valign="middle">
          <div class="fw-bolder">
            {{ insurance.packageType }}
          </div>
        </td>
        <td valign="middle">
          <div class="fw-bolder" v-if="insurance.additionalInsurance">
            {{ insurance.additionalInsurance.join(', ') }}
          </div>
        </td>
        <td valign="middle">
          <div class="fw-bolder">
            {{ insurance.persons }}
          </div>
        </td>
        <td valign="middle">
          <div class="fw-bolder">
            {{ insurance.price }} €
          </div>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import { mapActions } from "vuex";
export default {
  name: 'InsuranceRecords',
  data() {
    return {
      insurances: [],
    }
  },
  methods: {
    ...mapActions(["getInsurances"]),
  },
  created () {
    this.getInsurances().then(data => this.insurances = data);
  },
}
</script>

<style scoped>
</style>
