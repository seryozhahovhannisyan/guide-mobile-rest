package com.connectto.mobile.configuration;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Seryozha on 4/30/16.
 */
@Configuration
@EntityScan("com.connectto.mobile.entity")
@EnableJpaRepositories("com.connectto.mobile.repository")
@EnableTransactionManagement
public class DataConfiguration {
}