/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.sun.syndication.io.FeedException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Feed;

/**
 *
 * @author iapereira
 */
public class FeedDAO {
    
    public void remove(int id) throws SQLException {
        String sql = "DELETE FROM feeds WHERE id = ?";
        MyConnection myConnection = new MyConnection();
        Connection connection = myConnection.getMyConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }
    
    public ArrayList<Feed> list() throws SQLException, IOException, FeedException {
        ArrayList<Feed> vetFeed = new ArrayList<>();
        String sql = "SELECT * FROM feeds;";
        MyConnection myConnection = new MyConnection();
        Connection connection = myConnection.getMyConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Feed feed = new Feed();            
            feed.setId(rs.getInt("id"));
            feed.setName(rs.getString("name"));
            feed.setUrl(rs.getString("url"));
            feed.setArticles(feed.read());
            vetFeed.add(feed);            
        }
        preparedStatement.close();
        connection.close();
        return vetFeed;
    }
    
    public void add(Feed feed) throws SQLException {
        String sql = "INSERT INTO feeds (name, url) values (?,?);";
        MyConnection myConnection = new MyConnection();
        Connection connection = myConnection.getMyConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, feed.getName());
        preparedStatement.setString(2, feed.getUrl());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }
    
}
