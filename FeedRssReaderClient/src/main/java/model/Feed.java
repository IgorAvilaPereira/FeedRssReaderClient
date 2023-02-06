/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iapereira
 */
public class Feed {

    private int id;
    private String name;
    private String url;
    private ArrayList<Article> articles;

    public Feed() {
        this.articles = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<Article> read() {
        ArrayList<Article> results = new ArrayList();
        try {
            System.out.println("URL:" + this.getUrl());
            URL feedSource = new URL(this.getUrl());
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedSource));
            Iterator itr = feed.getEntries().iterator();
            while (itr.hasNext()) {
                SyndEntry syndEntry = (SyndEntry) itr.next();
                results.add(Article.mapToArticle(syndEntry));
            }
        } catch (FeedException ex) {
            System.out.println("========");
            System.out.println("1");
            System.out.println("========");
//            Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
            return results;
        } catch (IOException ex) {
            System.out.println("========");
            System.out.println("2");
            System.out.println("========");
//            Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
            return results;
        } catch (IllegalArgumentException ex) {
            System.out.println("========");
            System.out.println("3");
            System.out.println("========");
//            Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
            return results;
        }

        return results;
    }

    @Override
    public String toString() {
        return "Feed{" + "id=" + id + ", name=" + name + ", url=" + url + '}';
    }

}
