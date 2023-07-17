package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class HomeSteps extends CommonUtility{
	POMFactory factory = new POMFactory();
	
	
	// All Section 
	
	@When("User click on All section")
	public void userClickOnAllSection() {
	   click(factory.homePage().allField);
	   logger.info("user clicked on all setion field successfully");
	}
	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists(String.class);
		Assert.assertTrue(isElementDisplayed(factory.homePage().allButton));
		logger.info("options Electronics, Computers, Smarth Home, Sports and Automative are present");
	    
	}
	
	// Department sections ----------------------------------------
	String department;
	
	@When("User on {string}")
	public String userOn(String department) {
		switch (department) {
		case "Electronics":
			Assert.assertTrue(isElementDisplayed(factory.homePage().electronics));
			logger.info("user is on electronic section");
			break;
		case "Computers":
			Assert.assertTrue(isElementDisplayed(factory.homePage().computers));
			logger.info("user is on computers section");
			break;
		case "Smart Home":
			Assert.assertTrue(isElementDisplayed(factory.homePage().smartHome));
			logger.info("user is on Smart Home section");
			break;
		case "Sports":
			Assert.assertTrue(isElementDisplayed(factory.homePage().sports));
			logger.info("user is on Sports sections");
			break;
		case "Automative":
			Assert.assertTrue(isElementDisplayed(factory.homePage().automative));
			logger.info("user is on automative section");
			break;
			default:
	}
		return this.department = department;
	}
	
	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> department = dataTable.asLists();
		
		switch ("department") {
		case "Electronics":
			click(factory.homePage().electronics);
			String video = getText(factory.homePage().videoGames);
			String tvAndVideo = getText(factory.homePage().tvAndVideo);
			Assert.assertEquals(tvAndVideo, department.get(0).get(0));
			Assert.assertEquals(video, department.get(0).get(1));
			logger.info(video + " options are present in department " + tvAndVideo);
			break;
		case "Computers":
			click(factory.homePage().computers);
			String accessories = getText(factory.homePage().accessories);
			String networking = getText(factory.homePage().networking);
			Assert.assertEquals(accessories, department.get(0).get(0));
			Assert.assertEquals(networking, department.get(0).get(1));
			logger.info(accessories + " options are present in department " + networking);
			break;
		case "Smart Home":
			click(factory.homePage().smartHome);
			String smartHomeLightings = getText(factory.homePage().smartHomeLightnings);
			String plugsAndOutlets = getText(factory.homePage().plugsAndOutlets);
			Assert.assertEquals(smartHomeLightings, department.get(0).get(0));
			Assert.assertEquals(plugsAndOutlets, department.get(0).get(1));
			logger.info(smartHomeLightings + " options are present in department " + plugsAndOutlets);
			break;
		case "Sport":
			click(factory.homePage().sports);
			String athleticClothing = getText(factory.homePage().athleticClothing);
			String excerciseAndfitness = getText(factory.homePage().excerciseAndFitness);
			Assert.assertEquals(athleticClothing, department.get(0).get(0));
			Assert.assertEquals(excerciseAndfitness, department.get(0).get(1));
			logger.info(athleticClothing + " options are present in department " + excerciseAndfitness); 
			break;
		case "Automative":
			click(factory.homePage().automative);
			String automativepartsAndAccessories = getText(factory.homePage().automativepartsAndAccessories);
			String motorCycleAndPowersports = getText(factory.homePage().motorCycleAndPowersports);
			Assert.assertEquals(automativepartsAndAccessories, department.get(0).get(0));
			Assert.assertEquals(motorCycleAndPowersports, department.get(0).get(1));
			logger.info(motorCycleAndPowersports + " options are present in department " + automativepartsAndAccessories);
			break;
	}
	}
}


