package com.codecool.shop.dao;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * <h1>This abstract class is used to give database related methods to the daojdbc classes via inheritance</h1>
 *The main purpose of this class was giving the the most used methods for the jdbc
 *implementation classes, via inheritance. Such as connecting to the database, executing queries.
 *
 * @author Majoross Daniel
 * @author Racz Anna
 * @author Adam Kovacs
 * @version 1.0
 * @since 2017-05-20
 */

public abstract class JDBC {

    /**
     * This method is used to establish a connection to the database
     * @return returns the connection with properties called from the read() method
     * @throws SQLException for handling database related issues.
     */
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://" + read(1) + "/" + read(2) + "",
                read(3),
                read(4));
    }

    /**
     * This method is responsible to forward sql queries to the database.
     * @param query sql queries created in the JDBC classes.
     */
    protected void executeQuery(String query) {

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * A method for hanadling privacy of the users passwords of the database.
     * This method reads the related information from the connection.properties file, which was put in git ignore.
     * @param paramNumber for indicating the method which line is needed: 1 is the URL, 2 is the database name,
     *                   3 user name 4 is password.
     * @return returns the requested information, or null if some problem occurs.
     */
    protected String read(int paramNumber) {
        Properties prop = new Properties();
        InputStream input = null;
        try {

            input = new FileInputStream("src/main/resources/connection.properties");

            prop.load(input);
            if (paramNumber == 1) {
                return prop.getProperty("url");
            } else if (paramNumber == 2) {
                return prop.getProperty("database");
            } else if (paramNumber == 3) {
                return prop.getProperty("user");
            } else if (paramNumber == 4) {
                return prop.getProperty("password");
            } else {
                return null;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
