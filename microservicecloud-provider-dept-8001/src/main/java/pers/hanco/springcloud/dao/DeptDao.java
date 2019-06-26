package pers.hanco.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.hanco.springcloud.entity.Dept;

import java.util.List;

/**
 * @author Hanco on 2019/6/13
 */
@Mapper
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
