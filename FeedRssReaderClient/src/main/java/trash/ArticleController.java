/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trash;

import com.sun.syndication.io.FeedException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import negocio.Article;
import negocio.Feed;
import trash.RSSReaderUtil;
import persistencia.MyConnection;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

/**
 *
 * @author iapereira
 */
public class ArticleController {

    public ModelAndView index() throws MalformedURLException, IOException, FeedException {
        Map map = new HashMap();
        ArrayList<Feed> vetFeed = new ArrayList<>();
        Feed f1 = new Feed();
        f1.setName("Diolinux");
        f1.setUrl("https://diolinux.com.br/feed");
        f1.setArticles(f1.read());
        vetFeed.add(f1);
        Feed f2 = new Feed();
        f2.setName("Nerdcast");
        f2.setUrl("https://diolinux.com.br/feed");
        f2.setArticles(f2.read());
        vetFeed.add(f2);
        map.put("vetFeed", vetFeed);        
        return new ModelAndView(map, "index.html");
    }
}
