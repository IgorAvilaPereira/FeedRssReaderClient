/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author iapereira
 */
import com.sun.syndication.io.FeedException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import negocio.Feed;
import persistencia.FeedDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

/**
 *
 * @author iapereira
 */
public class FeedController {     
    private FeedDAO feedDAO;
    
    public FeedController(){
        this.feedDAO = new FeedDAO();
    }
    
     public ModelAndView index(Request rq, Response rs) throws MalformedURLException, IOException, FeedException, SQLException {
        Map map = new HashMap();
        map.put("vetFeed", this.feedDAO.list());        
        rs.type("text/html");
        return new ModelAndView(map, "index.html");
    }

    public ModelAndView myFeeds() throws MalformedURLException, IOException, FeedException, SQLException {
        Map map = new HashMap();
        ArrayList<Feed> vetFeed = this.feedDAO.list();
        map.put("vetFeed", vetFeed);        
        return new ModelAndView(map, "my_feeds.html");
    }

    public void removeFeed(Request rq, Response rs) throws SQLException {
//        System.out.println("==========");
//        System.out.println(Integer.parseInt(rq.params(":id"))); 
//        System.out.println("==========");
       this.feedDAO.remove(Integer.parseInt(rq.params(":id")));
        
    }

    public void newFeed(Request rq, Response rs) throws SQLException {
        Feed feed = new Feed();
        feed.setName(rq.queryParams("name"));
        feed.setUrl(rq.queryParams("url"));
//        System.out.println(feed);
        this.feedDAO.add(feed);
    }
}
