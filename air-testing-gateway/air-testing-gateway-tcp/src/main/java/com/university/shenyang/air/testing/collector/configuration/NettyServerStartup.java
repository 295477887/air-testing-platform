package com.university.shenyang.air.testing.collector.configuration;

import com.university.shenyang.air.testing.collector.tcp.server.TcpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author chenjc
 * @version 1.0
 * @date 2017-05-14
 */
@Component
public class NettyServerStartup  implements CommandLineRunner {
    @Autowired
    TcpServer tcpServer;

    @Override
    public void run(String... args) throws Exception {
        tcpServer.start();
    }

}