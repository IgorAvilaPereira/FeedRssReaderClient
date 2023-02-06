/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trash;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import negocio.Article;
import negocio.Feed;

/**
 *
 * @author iapereira
 */
public class RSSReaderUtil {
    
     public static ArrayList<Article> read(Feed f) throws IOException, FeedException {
        URL feedSource = new URL(f.getUrl());
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedSource));
        Iterator itr = feed.getEntries().iterator();
        ArrayList<Article> results = new ArrayList();
        while (itr.hasNext()) {
            SyndEntry syndEntry = (SyndEntry) itr.next();
            results.add(mapToArticle(syndEntry));
        }
        return results;
    }

    public static ArrayList<Article> read(String feedUrl) throws IOException, FeedException {
        URL feedSource = new URL(feedUrl);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedSource));
        Iterator itr = feed.getEntries().iterator();
        ArrayList<Article> results = new ArrayList();
        while (itr.hasNext()) {
            SyndEntry syndEntry = (SyndEntry) itr.next();
            results.add(mapToArticle(syndEntry));
        }
        return results;
    }

    /**
     * Map to Article
     * @param syndEntry
     */
    private static Article mapToArticle(SyndEntry syndEntry) {
        Article newsArticle = new Article();
        newsArticle.setTitle(syndEntry.getTitle());
        newsArticle.setPublishedDate(syndEntry.getPublishedDate().toString());
        newsArticle.setImgUrl("");
        newsArticle.setLink(syndEntry.getLink());
        return newsArticle;
    }
}