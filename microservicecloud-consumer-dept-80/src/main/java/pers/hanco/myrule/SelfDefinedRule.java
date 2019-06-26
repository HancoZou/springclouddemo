package pers.hanco.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author Hanco on 2019/6/19
 */
public class SelfDefinedRule extends AbstractLoadBalancerRule {

    private static final Integer ROUND_TIME = 5;

    private int total = 0;
    private int currentIndex = 0;

    private Server choose(ILoadBalancer lb, Object o) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while (true) {
                if (server == null) {
                    List<Server> allServers = lb.getAllServers();
                    List<Server> upServers = lb.getReachableServers();

                    int serverCount = allServers.size();
                    int upCount = upServers.size();

                    if (total < 5) {
                        server = upServers.get(currentIndex);
                        total++;
                    } else {
                        total = 0;
                        currentIndex++;
                        if (currentIndex > upCount) {
                            currentIndex = 0;
                        }
                    }

                    if (server == null) {

                    }

                }

            }
        }


    }

    @Override
    public Server choose(Object o) {
        return this.choose(this.getLoadBalancer(), o);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }
}
