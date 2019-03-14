/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTArrayDimsAndInits.java */

package net.sourceforge.pmd.lang.java.ast;

public class ASTArrayDimsAndInits extends AbstractJavaNode implements Dimensionable {
    private int arrayDepth;

    public ASTArrayDimsAndInits(int id) {
        super(id);
    }

    public ASTArrayDimsAndInits(JavaParser p, int id) {
        super(p, id);
    }

    /**
     * Accept the visitor. *
     */
    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    @Deprecated
    public void bumpArrayDepth() {
        arrayDepth++;
    }

    @Override
    @Deprecated
    public int getArrayDepth() {
        return arrayDepth;
    }

    @Override
    @Deprecated
    public boolean isArray() {
        return arrayDepth > 0; // should always be true...
    }
}
