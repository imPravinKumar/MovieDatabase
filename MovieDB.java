package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * 
 */
public class MovieDB {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/movie.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param Actor_name
     * @param Actress_name
     * @param Dict_name
     * @param Year
     */
    public void insert(String Actor_name, String Actress_name, String Dict_name, int Year) {
        String sql = "INSERT INTO movie(Actor_name,Actress_name,Dict_name,Year) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Actor_name);
            pstmt.setString(2, Actress_name);
            pstmt.setDouble(3, Dict_name);
            pstmt.setInt(4, Year);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        // insert three new rows
        app.insert("Vijay","Malivika Mohan","Lokesh", 2021);
        app.insert("Kavin","Amritha Aiyer","Vineeth Varaprasad",2021);
        app.insert("Raai Laxmi"," Sakshi Agarwal","Vinoo Venkatesh",2021);
        app.insert("Yogi Babu","Malavika Menon","Sakthi Chidambaram",2021);
        app.insert(" Bharath","Aparna Vinod","Sharang",2021);
        app.insert(" Harish Kalyan","Sundeep Kishan"," Chimbu Deven",2021);
        app.insert("Pavel Navageethan","Aishwarya Rajesh"," Rathindran R. Prasad",2021);
        app.insert("Arvind Swamy","Suriya Sivakumar"," Sarjun KM",2021);
        app.insert(" Pradeep Anthony"," TJ Bhanu","Arun Prabu Purushothaman",2021);
        app.insert(" Samuthirakani","Athmiya"," Subramaniam Siva",2021);
    }

}
