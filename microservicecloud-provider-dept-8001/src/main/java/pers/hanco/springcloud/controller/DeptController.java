package pers.hanco.springcloud.controller;

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
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.get(id);

        if (dept == null) {
            throw new RuntimeException("该id：" + id + "没有对应的信息");
        }

        return dept;
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.list();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println(">>>>>>>>>>>>>>" + list);

        List<ServiceInstance> instanceList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        instanceList.forEach(instance -> System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" +
                instance.getPort() + "\t" + instance.getUri()));

        return this.discoveryClient;
    }
}
