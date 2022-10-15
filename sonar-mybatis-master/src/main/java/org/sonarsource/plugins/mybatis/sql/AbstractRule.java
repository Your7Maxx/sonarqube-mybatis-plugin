package org.sonarsource.plugins.mybatis.sql;

import com.alibaba.druid.sql.ast.SQLObject;
import com.alibaba.druid.sql.visitor.SQLASTVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRule extends SQLASTVisitorAdapter {

    List<Result> results;

    public final void initCheckResults(List<Result> results){
        this.results=results;
    }

    protected final boolean addCheckResult(SQLObject object){
        Result result=new  Result();
        result.setRule(this.getClass().getSimpleName());
        result.setObj(object);
        return results.add(result);
    }

    public final List<Result> getCheckResults(){
        return results;
    }


}
