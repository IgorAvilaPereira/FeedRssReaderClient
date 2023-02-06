/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

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

    public ArrayList<Article> read() throws IOException {
        ArrayList<Article> results = new ArrayList();
        URL feedSource = new URL(this.getUrl());
        SyndFeedInput input = new SyndFeedInput();
        try {
            SyndFeed feed = input.build(new XmlReader(feedSource));
            Iterator itr = feed.getEntries().iterator();            
            while (itr.hasNext()) {
                SyndEntry syndEntry = (SyndEntry) itr.next();
                results.add(Article.mapToArticle(syndEntry));
            }
        } catch(FeedException e){
            return results;
        }
        return results;
    }

    @Override
    public String toString() {
        return "Feed{" + "id=" + id + ", name=" + name + ", url=" + url + '}';
    }
    
    

}
