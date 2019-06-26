package pers.hanco.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.hanco.springcloud.dao.DeptDao;
import pers.hanco.springcloud.entity.Dept;
import pers.hanco.springcloud.service.DeptService;

import java.util.List;

/**
 * @author Hanco on 2019/6/13
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }
}
