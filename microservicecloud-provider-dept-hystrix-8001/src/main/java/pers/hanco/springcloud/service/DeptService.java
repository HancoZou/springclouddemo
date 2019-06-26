package pers.hanco.springcloud.service;

import pers.hanco.springcloud.entity.Dept;

import java.util.List;

/**
 * @author Hanco on 2019/6/13
 */
public interface DeptService {
    public boolean add(Dept dept);
    public Dept get(Long id);
    public List<Dept> list();
}
