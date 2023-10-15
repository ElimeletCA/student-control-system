package com.student_control_system.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.student_control_system.domain")
@EnableJpaRepositories("com.student_control_system.repos")
@EnableTransactionManagement
public class DomainConfig {
}
