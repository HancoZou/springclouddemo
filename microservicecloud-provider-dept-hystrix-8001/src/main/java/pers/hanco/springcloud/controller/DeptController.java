package pers.hanco.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import pers.hanco.springcloud.entity.Dept;
import pers.hanco.springcloud.service.DeptService;

import java.util.List;

/**
 * @author Hanco on 2019/6/13
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.get(id);

        if (dept == null) {
            throw new RuntimeException("该id：" + id + "没有对应的信息");
        }

        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("该id：" + id + "没有对应的信息, null===@HystrixCommand")
                .setDb_source("no this data in MySQL database");
    }
}
