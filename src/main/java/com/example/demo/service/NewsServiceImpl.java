package com.example.demo.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Dao.NewsRepository;
import com.example.demo.entity.News;


@Service
public class NewsServiceImpl implements NewsService{

	@Autowired
	private NewsRepository newsRepository;
	

	@Override
	public List<News> findAll() {
		
		return newsRepository.findAll();
	}


	@Override
	public News findById(int Id) {
		
Optional<News> result = newsRepository.findById(Id);
		
		News news = null;
		if(result.isPresent())
		{
			news = result.get();
		}
		else {
			throw new RuntimeException("didn't find any news with an id of: " + Id);
		}
		return news;
	}


	@Override
	public void deleteById(int id) {

		newsRepository.deleteById(id);
		
	}


	
	@Override
	public void save(News news) {
		
		newsRepository.save(news);
		
	}


	
	
	
}
