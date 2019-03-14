/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTCompilationUnit.java */

package net.sourceforge.pmd.lang.jsp.ast;

import net.sourceforge.pmd.lang.ast.RootNode;

public class ASTCompilationUnit extends AbstractJspNode implements RootNode {
    public ASTCompilationUnit(int id) {
        super(id);
    }

    public ASTCompilationUnit(JspParser p, int id) {
        super(p, id);
    }

    /**
     * Accept the visitor. *
     */
    @Override
    public Object jjtAccept(JspParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}
