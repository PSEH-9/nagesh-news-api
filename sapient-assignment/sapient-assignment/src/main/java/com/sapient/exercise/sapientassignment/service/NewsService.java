package com.sapient.exercise.sapientassignment.service;


import com.sapient.exercise.sapientassignment.model.Articles;
import com.sapient.exercise.sapientassignment.model.ResponceExample;
import com.sapient.exercise.sapientassignment.model.Source;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService extends MappingJackson2HttpMessageConverter {

    @Value("$api.key}")
    private static String apiKey;


    public static List<ResponceExample> sendRefinedUpdate(String country,
                                                          String category,
                                                          String source123) throws IOException {

        String urlString = "https://newsapi.org/v2/top-headlines?apiKey=" +
                "9cc1bbc959d04b37808f8f9b67c1d114"+
                "&country="+country+
                "&category="+category+
                "&source="+source123+"";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(urlString, String.class);

        JSONObject root = new JSONObject(result);

        String status = null;
        Integer totalResults = null;
        String id = null;
        String name = null;
        String author = null;
        String title = null;
        String description = null;
        String urlother = null;
        String urlToImage = null;
        String publishedAt = null;
        String content = null;

        List<ResponceExample> newsList = new ArrayList<>();

        status =  root.getString("status");
        totalResults =  root.getInt("totalResults");

        JSONArray articlesObject = root.getJSONArray("articles");

        for(int i = 0; i < articlesObject.length(); i++) {

            JSONObject arrayElement = articlesObject.getJSONObject(i);

            JSONObject sourceother = arrayElement.getJSONObject("source");

            if(!sourceother.isNull("id")){
                id = sourceother.getString("id");
            }else {
                id=null;
            }

            name =  sourceother.getString("name");

            if(!arrayElement.isNull("author")){
                author = arrayElement.getString("author");
            }else {
                author = null;
            }

            title = arrayElement.getString("title");

            if(!arrayElement.isNull("description")){
                description = arrayElement.getString("description");
            }else {
                description = null;
            }

            urlother = arrayElement.getString("url");

            if(!arrayElement.isNull("urlToImage")){
                urlToImage = arrayElement.getString("urlToImage");
            }else {
                urlToImage = null;
            }

            publishedAt = arrayElement.getString("publishedAt");

            if(!arrayElement.isNull("content")){
                content = arrayElement.getString("content");
            }else {
                content = null;
            }

            ResponceExample emp = new ResponceExample();
            Articles articles = new Articles();
            Source source = new Source();

            emp.setStatus(status);
            emp.setTotalResults(totalResults);
            articles.setAuthor(author);
            articles.setContent(content);
            articles.setDescription(description);
            articles.setPublishedAt(publishedAt);
            articles.setTitle(title);
            articles.setUrlOther(urlother);
            articles.setUrlToImage(urlToImage);
            source.setId(id);
            source.setName(name);

            articles.setSource(source);
            emp.setArticles(articles);
            newsList.add(emp);
        }
        return newsList;
    }

    public static List<ResponceExample> sendCategoryUpdate(String country, String category) throws IOException {

        String urlString = "https://newsapi.org/v2/top-headlines?apiKey=9cc1bbc959d04b37808f8f9b67c1d114&country="+country+"&category="+category+"";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(urlString, String.class);

        JSONObject root = new JSONObject(result);

        String status = null;
        Integer totalResults = null;
        String id = null;
        String name = null;
        String author = null;
        String title = null;
        String description = null;
        String urlother = null;
        String urlToImage = null;
        String publishedAt = null;
        String content = null;

        List<ResponceExample> newsList = new ArrayList<>();

        status =  root.getString("status");
        totalResults =  root.getInt("totalResults");

        JSONArray articlesObject = root.getJSONArray("articles");

        for(int i = 0; i < articlesObject.length(); i++) {

            JSONObject arrayElement = articlesObject.getJSONObject(i);

            JSONObject sourceother = arrayElement.getJSONObject("source");

            if(!sourceother.isNull("id")){
                id = sourceother.getString("id");
            }else {
                id=null;
            }

            name =  sourceother.getString("name");

            if(!arrayElement.isNull("author")){
                author = arrayElement.getString("author");
            }else {
                author = null;
            }

            title = arrayElement.getString("title");

            if(!arrayElement.isNull("description")){
                description = arrayElement.getString("description");
            }else {
                description = null;
            }

            urlother = arrayElement.getString("url");

            if(!arrayElement.isNull("urlToImage")){
                urlToImage = arrayElement.getString("urlToImage");
            }else {
                urlToImage = null;
            }

            publishedAt = arrayElement.getString("publishedAt");

            if(!arrayElement.isNull("content")){
                content = arrayElement.getString("content");
            }else {
                content = null;
            }

            ResponceExample emp = new ResponceExample();
            Articles articles = new Articles();
            Source source = new Source();

            emp.setStatus(status);
            emp.setTotalResults(totalResults);
            articles.setAuthor(author);
            articles.setContent(content);
            articles.setDescription(description);
            articles.setPublishedAt(publishedAt);
            articles.setTitle(title);
            articles.setUrlOther(urlother);
            articles.setUrlToImage(urlToImage);
            source.setId(id);
            source.setName(name);

            articles.setSource(source);

            emp.setArticles(articles);
            newsList.add(emp);
        }
        return newsList;

    }

    public static List<ResponceExample> sendSourcedNews(String country,
                                                        String source123) throws IOException {

        String urlString = "https://newsapi.org/v2/top-headlines?apiKey=9cc1bbc959d04b37808f8f9b67c1d114"+"&country="+country+"&source="+source123+"";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(urlString, String.class);

        JSONObject root = new JSONObject(result);
        String status = null;
        Integer totalResults = null;
        String id = null;
        String name = null;
        String author = null;
        String title = null;
        String description = null;
        String urlother = null;
        String urlToImage = null;
        String publishedAt = null;
        String content = null;

        List<ResponceExample> newsList = new ArrayList<>();

        status =  root.getString("status");
        totalResults =  root.getInt("totalResults");

        JSONArray articlesObject = root.getJSONArray("articles");

        for(int i = 0; i < articlesObject.length(); i++) {

            JSONObject arrayElement = articlesObject.getJSONObject(i);

            JSONObject sourceother = arrayElement.getJSONObject("source");

            if(!sourceother.isNull("id")){
                id = sourceother.getString("id");
            }else {
                id=null;
            }

            name =  sourceother.getString("name");

            if(!arrayElement.isNull("author")){
                author = arrayElement.getString("author");
            }else {
                author = null;
            }

            title = arrayElement.getString("title");

            if(!arrayElement.isNull("description")){
                description = arrayElement.getString("description");
            }else {
                description = null;
            }

            urlother = arrayElement.getString("url");

            if(!arrayElement.isNull("urlToImage")){
                urlToImage = arrayElement.getString("urlToImage");
            }else {
                urlToImage = null;
            }

            publishedAt = arrayElement.getString("publishedAt");

            if(!arrayElement.isNull("content")){
                content = arrayElement.getString("content");
            }else {
                content = null;
            }

            ResponceExample emp = new ResponceExample();
            Articles articles = new Articles();
            Source source = new Source();

            emp.setStatus(status);
            emp.setTotalResults(totalResults);
            articles.setAuthor(author);
            articles.setContent(content);
            articles.setDescription(description);
            articles.setPublishedAt(publishedAt);
            articles.setTitle(title);
            articles.setUrlOther(urlother);
            articles.setUrlToImage(urlToImage);
            source.setId(id);
            source.setName(name);

            articles.setSource(source);
            emp.setArticles(articles);
            newsList.add(emp);
        }
        return newsList;

    }

}