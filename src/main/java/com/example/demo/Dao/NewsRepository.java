package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

}
