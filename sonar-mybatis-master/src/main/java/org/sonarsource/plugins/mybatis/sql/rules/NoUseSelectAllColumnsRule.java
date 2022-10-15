package org.sonarsource.plugins.mybatis.sql.rules;

import com.alibaba.druid.sql.ast.expr.SQLAllColumnExpr;
import org.sonarsource.plugins.mybatis.sql.AbstractRule;

public class NoUseSelectAllColumnsRule extends AbstractRule {
    @Override
    public boolean visit(SQLAllColumnExpr x) {
        this.addCheckResult(x);
        return super.visit(x);
    }

}
