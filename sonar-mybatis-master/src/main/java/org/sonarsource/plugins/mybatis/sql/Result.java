package org.sonarsource.plugins.mybatis.sql;

import com.alibaba.druid.sql.ast.SQLObject;

public class Result {


    @Override
    public String toString() {
        return "Result{" +
                "obj=" + obj +
                ", rule='" + rule + '\'' +
                '}';
    }

    SQLObject obj;
    String rule;

    public SQLObject getObj() {
        return obj;
    }

    public void setObj(SQLObject obj) {
        this.obj = obj;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

}
