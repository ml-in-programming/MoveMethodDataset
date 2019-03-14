/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import java.util.Iterator;
import java.util.List;

import apex.jorje.data.Identifier;
import apex.jorje.semantic.ast.expression.MethodCallExpression;
import net.sourceforge.pmd.lang.rule.AbstractRule;

public class ASTMethodCallExpression extends AbstractApexNode<MethodCallExpression> {

    public ASTMethodCallExpression(MethodCallExpression methodCallExpression) {
        super(methodCallExpression);
    }

    @Override
    public Object jjtAccept(ApexParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    public String getMethodName() {
        return getNode().getMethodName();
    }

    public String getFullMethodName() {
        final String methodName = getMethodName();
        StringBuilder typeName = new StringBuilder();
        for (Iterator<Identifier> it = getNode().getReferenceContext().getNames().iterator(); it.hasNext();) {
            typeName.append(it.next().getValue()).append('.');
        }
        return typeName.toString() + methodName;
    }

    public void validateLiteralPresence(Object data, AbstractRule abstractRule) {
        List<ASTVariableExpression> variables = findDescendantsOfType(ASTVariableExpression.class);
        for (ASTVariableExpression v : variables) {
            abstractRule.addViolation(data, v);
        }
    }
}
