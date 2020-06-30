package com.example.demoinlineclasspropertybug;

import org.junit.ClassRule;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


@Testcontainers
public class Neo4JTestBase {
    public final static String PASSWORD = "password";
    @Container
    @ClassRule
    public static Neo4jContainer neo4jContainer = (Neo4jContainer) new Neo4jContainer()
        .withAdminPassword(PASSWORD);

}
