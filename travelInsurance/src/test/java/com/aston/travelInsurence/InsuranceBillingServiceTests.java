package com.aston.travelInsurence;

import com.aston.travelInsurence.service.InsuranceBillingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class InsuranceBillingServiceTests {

	@Autowired
	InsuranceBillingService insuranceBillingService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void saveShortTermInsuranceExtraTripCancellation2Persons2DaysExcept21_6Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "krátkodobé poistenie",
				    "packageType": "extra",
				    "additionalInsurance": ["storno cesty"],
				    "fromDate": "2022-12-01",
				    "toDate": "2022-12-04",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(21.6f));
	}

	@Test
	void saveShortTermInsuranceExtendedTripCancellation3Persons2DaysExcept16_2Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "krátkodobé poistenie",
				    "packageType": "rozšírený",
				    "additionalInsurance": ["storno cesty"],
				    "fromDate": "2022-12-01",
				    "toDate": "2022-12-04",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(16.2f));;
	}

	@Test
	void saveShortTermInsuranceBasicTripCancellation3Persons2DaysExcept10_8Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "krátkodobé poistenie",
				    "packageType": "základný",
				    "additionalInsurance": ["storno cesty"],
				    "fromDate": "2022-12-01",
				    "toDate": "2022-12-04",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(10.8f));;
	}

	@Test
	void saveShortTermInsuranceExtraSportActivities3Persons2DaysExcept18_72Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "krátkodobé poistenie",
				    "packageType": "extra",
				    "additionalInsurance": ["športové aktivity"],
				    "fromDate": "2022-12-01",
				    "toDate": "2022-12-04",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(18.72f));;
	}

	@Test
	void saveShortTermInsuranceExtendedSportActivities3Persons2DaysExcept14_04Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "krátkodobé poistenie",
				    "packageType": "rozšírený",
				    "additionalInsurance": ["športové aktivity"],
				    "fromDate": "2022-12-01",
				    "toDate": "2022-12-04",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(14.04f));;
	}

	@Test
	void saveShortTermInsuranceBasicSportActivities3Persons2DaysExcept9_36Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "krátkodobé poistenie",
				    "packageType": "základný",
				    "additionalInsurance": ["športové aktivity"],
				    "fromDate": "2022-12-01",
				    "toDate": "2022-12-04",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(9.36f));;
	}

	@Test
	void saveShortTermInsuranceExtraSportActivitiesAndTripCancellation3Persons2DaysExcept12_96Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "krátkodobé poistenie",
				    "packageType": "základný",
				    "additionalInsurance": ["športové aktivity", "storno cesty"],
				    "fromDate": "2022-12-01",
				    "toDate": "2022-12-04",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(12.96f));;
	}

	@Test
	void saveShortTermInsuranceExtendedSportActivitiesAndTripCancellation3Persons2DaysExcept19_44Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "krátkodobé poistenie",
				    "packageType": "rozšírený",
				    "additionalInsurance": ["športové aktivity", "storno cesty"],
				    "fromDate": "2022-12-01",
				    "toDate": "2022-12-04",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(19.44f));;
	}

	@Test
	void saveShortTermInsuranceExtraSportActivitiesAndTripCancellation3Persons2DaysExcept25_92Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "krátkodobé poistenie",
				    "packageType": "extra",
				    "additionalInsurance": ["športové aktivity", "storno cesty"],
				    "fromDate": "2022-12-01",
				    "toDate": "2022-12-04",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(25.92f));;
	}

	@Test
	void saveShortTermInsuranceExtra3Persons2DaysExcept7_2Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "krátkodobé poistenie",
				    "packageType": "základný",
				    "fromDate": "2022-12-01",
				    "toDate": "2022-12-04",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(7.2f));;
	}

	/*
	*
	* 		ANNUAL INSURANCES TESTs
	*
	* */

	@Test
	void saveAnnualInsuranceExtraTripCancellation3Persons2DaysExcept141_6Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "celoročné poistenie",
				    "packageType": "extra",
				    "additionalInsurance": ["storno cesty"],
				    "fromDate": "2022-12-01",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(141.6f));;
	}

	@Test
	void saveAnnualInsuranceExtendedTripCancellation3Persons2DaysExcept117_6Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "celoročné poistenie",
				    "packageType": "rozšírený",
				    "additionalInsurance": ["storno cesty"],
				    "fromDate": "2022-12-01",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(117.6f));;
	}

	@Test
	void saveAnnualInsuranceBasicTripCancellation3Persons2DaysExcept93_6Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "celoročné poistenie",
				    "packageType": "základný",
				    "additionalInsurance": ["storno cesty"],
				    "fromDate": "2022-12-01",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(93.6f));;
	}

	@Test
	void saveAnnualInsuranceExtraSportActivities3Persons2DaysExcept129_8Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "celoročné poistenie",
				    "packageType": "extra",
				    "additionalInsurance": ["športové aktivity"],
				    "fromDate": "2022-12-01",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(129.8f));;
	}

	@Test
	void saveAnnualInsuranceExtendedSportActivities3Persons2DaysExcept107_8Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "celoročné poistenie",
				    "packageType": "rozšírený",
				    "additionalInsurance": ["športové aktivity"],
				    "fromDate": "2022-12-01",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(107.8f));;
	}

	@Test
	void saveAnnualInsuranceBasicSportActivities3Persons2DaysExcept85_8Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "celoročné poistenie",
				    "packageType": "základný",
				    "additionalInsurance": ["športové aktivity"],
				    "fromDate": "2022-12-01",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(85.8f));;
	}

	@Test
	void saveAnnualInsuranceBasicSportActivitiesAndTripCancellation3Persons2DaysExcept153_4Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "celoročné poistenie",
				    "packageType": "extra",
				    "additionalInsurance": ["športové aktivity", "storno cesty"],
				    "fromDate": "2022-12-01",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(153.4f));;
	}

	@Test
	void saveAnnualInsuranceExtendedSportActivitiesAndTripCancellation3Persons2DaysExcept127_4Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "celoročné poistenie",
				    "packageType": "rozšírený",
				    "additionalInsurance": ["športové aktivity", "storno cesty"],
				    "fromDate": "2022-12-01",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(127.4f));;
	}

	@Test
	void saveAnnualInsuranceExtraSportActivitiesAndTripCancellation3Persons2DaysExcept101_4Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "celoročné poistenie",
				    "packageType": "základný",
				    "additionalInsurance": ["športové aktivity", "storno cesty"],
				    "fromDate": "2022-12-01",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(101.4f));;
	}

	@Test
	void saveAnnualInsuranceExtra3Persons2DaysExcept118Test() throws Exception {
		String request = """
				{
				    "lifeSpanType": "celoročné poistenie",
				    "packageType": "extra",
				    "fromDate": "2022-12-01",
				    "persons": 2
				}""";
		this.mockMvc.perform(post("/").content(request)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price" ).value(118f));;
	}



	@Test
	void getAllInsurances() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}



}
