/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTElExpression.java */

package net.sourceforge.pmd.lang.jsp.ast;

public class ASTElExpression extends AbstractJspNode {
    public ASTElExpression(int id) {
        super(id);
    }

    public ASTElExpression(JspParser p, int id) {
        super(p, id);
    }

    /**
     * Accept the visitor. *
     */
    @Override
    public Object jjtAccept(JspParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    public boolean elOutsideTaglib() {
        ASTElement parentASTElement = getFirstParentOfType(ASTElement.class);

        boolean elInTaglib = parentASTElement != null && parentASTElement.getName() != null
                && parentASTElement.getName().contains(":");

        boolean elWithFnEscapeXml = getImage() != null && getImage().matches("^fn:escapeXml\\(.+\\)$");

        return !elInTaglib && !elWithFnEscapeXml;
    }
}
