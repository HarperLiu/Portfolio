package server.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import server.service.NewsService;
import server.util.OptMessage;
import server.util.ResultMessage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping(value = "/news")
@CrossOrigin
public class News {
    @Resource(name = "newsService")
    private NewsService newsService;

    @RequestMapping(value = "/searchNews",method = RequestMethod.GET)
    public void searchNews(HttpServletRequest request, HttpServletResponse response){
        JSONArray jsonArray = newsService.searchNews();
        try (PrintWriter out = response.getWriter()){
            out.println(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/searchIndex",method = RequestMethod.GET)
    public void searchIndex(HttpServletRequest request, HttpServletResponse response){
        JSONArray jsonArray = newsService.searchIndexes();
        try (PrintWriter out = response.getWriter()){
            out.println(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
