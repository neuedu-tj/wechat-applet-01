package com.repository;


import com.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


//@Mapper
public interface CategoryRepository {

    List<Category> queryCategory();

}
