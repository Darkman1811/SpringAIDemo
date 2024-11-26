package com.example.springiapromptdemo.repositories;

import com.example.springiapromptdemo.datasets.GraphDatasetElement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataSetRepository extends JpaRepository<GraphDatasetElement,Long> {
}
