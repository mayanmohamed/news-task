package com.example.demo.RestControllers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.News;
import com.example.demo.service.NewsService;

@RestController
@RequestMapping("/api")
public class NewsRestController {
	
	private static final Logger logger = Logger.getLogger("MyController.class");

	@Autowired
	private NewsService newsService;
	
	
	
	@GetMapping("/news")
	public List<News> getNews()
	{
		return newsService.findAll();
	}
	
	
	
	@PostMapping("/fileupload")
    public void fileUpload(@RequestPart("file") MultipartFile file , @RequestPart News news) throws IOException  {
        
		news.setImage(file.getBytes());
            			
				newsService.save(news);           
    }
	
	@GetMapping("/news/{newsId}")
	public News getNewsById(@PathVariable int newsId)
	{
			
		News news = newsService.findById(newsId);
		if(news == null)
		{
			throw new RuntimeException("the news" + " does not exist");
		}
		return news;
	}
	
	
	@PutMapping("/fileupload")
    public void update(@RequestPart("file") MultipartFile file , @RequestPart News news) throws IOException  {
        
		news.setImage(file.getBytes());
            			
				newsService.save(news);
		
           
    }
	
	@DeleteMapping("/news/{newsId}")
	public void deleteEmployee(@PathVariable int newsId)
	{
		News news = newsService.findById(newsId);
		if(news == null)
		{
			throw new RuntimeException("the news doesn't exist");
		}
		
		newsService.deleteById(newsId);
	}
}
