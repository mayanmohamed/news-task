package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.News;
import com.example.demo.repository.NewsRepository;
import com.example.demo.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsRepository newsRepository;

	@Override
	public List<News> findAll() {

		return newsRepository.findAll();
	}

	@Override
	public Optional<News> findById(int Id){

		return newsRepository.findById(Id);

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
