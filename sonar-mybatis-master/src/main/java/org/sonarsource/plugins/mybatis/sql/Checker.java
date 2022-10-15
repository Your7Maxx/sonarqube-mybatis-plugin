/**
 * @Author:snoopyhzy@hotmai.com
 */
package org.sonarsource.plugins.mybatis.sql;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class Checker  {

    public static List<Result> doCheck(String sql, String dbType){
        //USE DRUID SQL AST TO PARSER SQL
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);
        //USE JAVA SPI TO GET RULE DEFINE IN META-INF/services
        ServiceLoader<AbstractRule> rules = ServiceLoader.load(AbstractRule.class,AbstractRule.class.getClassLoader());
        //RESULT
        List<Result> results=new ArrayList<>();
        for (SQLStatement statement : stmtList) {
            //DO CHECK
            for(AbstractRule rule:rules){
                rule.initCheckResults(results);
                statement.accept(rule);
            }
        }

        return results;
    }

    //NEED MOVE TO JUNIT
    public static void main(String[] argus){
        System.out.println(doCheck("select * from dual",null));
    }

}