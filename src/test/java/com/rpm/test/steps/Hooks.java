package com.rpm.test.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;

import com.rpm.test.utils.db.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Hooks {
    private static Logger logger = Logger.getLogger(Hooks.class.getName());

    @Managed
    private WebDriver userBrowser;

    @Managed
    private EnvironmentVariables environmentVariables;

    private Actor agencyAdmin;

    public Connection connection;


    @Before(order = 1)
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
        agencyAdmin = OnStage.theActorCalled("AA");
        agencyAdmin.whoCan(BrowseTheWeb.with(userBrowser));
    }

    @After(order = 1)
    public void tearDown() {
        userBrowser.close();
        userBrowser.quit();
    }

	/*
	 * @Before(order = 1) public void db_setup() { EnvironmentVariables
	 * environmentVariables = SerenityInfrastructure.getEnvironmentVariables();
	 * String dbUserName =
	 * EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(
	 * "dm.db.username"); String dbPassword =
	 * EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(
	 * "dm.db.password"); String dbIP =
	 * EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(
	 * "dm.db.ip"); String dbPort =
	 * EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(
	 * "dm.db.port"); String dbName =
	 * EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(
	 * "dm.db.name"); try { connection = DBHelper.getOracleConnection(dbIP, dbPort,
	 * dbName, dbUserName, dbPassword); agencyAdmin.remember("connection",
	 * connection); } catch (Exception dbe) {
	 * logger.severe("Unable to retrieve the data from DB - " + dbe); } }
	 * 
	 * @After(order = 1) public void db_tearDown() { try { if (connection != null)
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } finally
	 * { connection = null; } }
	 */
    
}
