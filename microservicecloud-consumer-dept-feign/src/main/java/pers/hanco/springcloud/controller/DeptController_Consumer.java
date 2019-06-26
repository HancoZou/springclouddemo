package pers.hanco.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.hanco.springcloud.entity.Dept;
import pers.hanco.springcloud.service.DeptClientService;

import java.util.List;

/**
 * @author Hanco on 2019/6/13
 */
@RestController
public class DeptController_Consumer {
    @Autowired
    private DeptClientService clientService;

    @RequestMapping(value = "/consumer/dept/add", method = RequestMethod.GET)
    public boolean add(Dept dept) {
        return clientService.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return clientService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return clientService.list();
    }
}
