package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.News;



public interface NewsService {

	public List<News> findAll();
	
	public News findById(int Id);
	
	public void save(News news);
	
	public void deleteById(int id);
	
	
}
