/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author iapereira
 */
import trash.ArticleController;
import controller.FeedController;
import java.util.ArrayList;
import model.Article;
import java.util.HashMap;
import java.util.Map;
import persistence.MyConnection;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.mustache.MustacheTemplateEngine;

public class Main {

    public static void main(String[] args) {     
        staticFileLocation("/static");    
        MyConnection myConnection = new MyConnection();
        myConnection.createFeedsTable();        
        
        get("/", (rq, rs) -> new FeedController().index(rq, rs), new MustacheTemplateEngine());
        get("/my_feeds", (rq, rs) -> new FeedController().myFeeds(), new MustacheTemplateEngine());                      
        get("/view_feed/:id", (rq, rs) -> new FeedController().view(rq, rs), new MustacheTemplateEngine());
        
        get("/new_feed", (rq, rs) -> new ModelAndView(new HashMap(), "new_feed.html"), new MustacheTemplateEngine());        
        post("/new_feed", (rq, rs) -> new FeedController().newFeed(rq, rs), new MustacheTemplateEngine());
        
        get("/edit_feed/:id", (rq, rs) -> new FeedController().editScreen(rq, rs), new MustacheTemplateEngine());        
        post("/edit", (rq, rs) -> new FeedController().edit(rq, rs), new MustacheTemplateEngine());
        
        get("/remove_feed/:id", (rq, rs) -> {
            new FeedController().removeFeed(rq,rs);
            rs.redirect("/");
            return null;
        });
    }
}