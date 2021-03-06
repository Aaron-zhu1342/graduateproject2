package org.com.Service.Interface;

import org.com.Entity.Article;
import org.com.Entity.QueryInfo;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface ArticleService {
    public List<Article> getAllArticle(QueryInfo queryInfo);

    public String getContent(int article_id);

    public int addArticle(Article article);

    public int deleteArticle(int article_id);

    public int AddArticleLike(int like_article_id,String like_user_name);

    public int DeleteArticleLike(int like_article_id,String like_user_name);

    public List<Article> GetAllArticleByUser(String article_user_name);

    public List<Article> GetHotArticle() throws ParseException;

    public int UpdateArticleClick(int article_id);

    public List<Article> GetSimilarArticle(int article_id);

}
