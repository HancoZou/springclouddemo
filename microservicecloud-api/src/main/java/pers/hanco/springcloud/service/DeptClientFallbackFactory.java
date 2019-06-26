package pers.hanco.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import pers.hanco.springcloud.entity.Dept;

import java.util.List;

/**
 * @author Hanco on 2019/6/25
 */
@Component
public class DeptClientFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("该id：" + id + "没有对应的信息, Consumer客户端提供的降级信息，此刻Provider已经关闭")
                        .setDb_source("no this data in MySQL database");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
