/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.sun.syndication.feed.synd.SyndEntry;
import java.util.List;

/**
 *
 * @author iapereira
 */
public class Article {

    private String title;
    private String link;
    private String imgUrl;
    private List<String> categories;
    private String body;

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    private String publishedDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Article{" + "title=" + title + ", link=" + link + ", imgUrl=" + imgUrl + ", categories=" + categories + ", body=" + body + ", publishedDate=" + publishedDate + '}';
    }

    public static Article mapToArticle(SyndEntry syndEntry) {
        Article newsArticle = new Article();
//          System.out.println("========");
//          System.out.println(syndEntry.getDescription().getValue());
//          System.out.println("========");
        newsArticle.setTitle(syndEntry.getTitle());
        newsArticle.setPublishedDate(syndEntry.getPublishedDate().toString());
        newsArticle.setImgUrl("");
        newsArticle.setLink(syndEntry.getLink());
//        newsArticle.setBody((String) syndEntry.getContents().get(0));
        newsArticle.setBody(syndEntry.getDescription().getValue());
        return newsArticle;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
