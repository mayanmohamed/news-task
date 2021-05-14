package com.example.demo.restcontroller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.News;
import com.example.demo.service.NewsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class NewsController {

	@Autowired
	private NewsService newsService;

	@GetMapping("/news")
	public List<News> getNews() {
		return newsService.findAll();

	}

	@PostMapping("admin/news")
	public void fileUpload(@RequestPart("file") MultipartFile file, @RequestPart News news) throws IOException {

		news.setImage(file.getBytes());

		newsService.save(news);
	}

	@GetMapping("/news/{newsId}")
	public ResponseEntity<News> getNewsById(@PathVariable int newsId) {
		log.debug("get news by ID {}", newsId);
        
	    var newsOptional = newsService.findById(newsId);
		
		if (newsOptional.isPresent()) {
			return ResponseEntity.ok(newsOptional.get());
		}else {
			log.debug("the news" + " does not exist");
			return ResponseEntity.notFound().build();
		}
		
	}

	@DeleteMapping("admin/news/{newsId}")
	public void deleteEmployee(@PathVariable int newsId) {
		newsService.findById(newsId).ifPresent(news -> newsService.deleteById(news.getId()));
	}
}
