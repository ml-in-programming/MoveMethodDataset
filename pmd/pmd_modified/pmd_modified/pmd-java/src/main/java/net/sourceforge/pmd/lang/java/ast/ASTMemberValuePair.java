/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTMemberValuePair.java */

package net.sourceforge.pmd.lang.java.ast;

/**
 * Represents a single member-value pair in an annotation.
 *
 * <pre>
 *
 * MemberValuePair ::=  &lt;IDENTIFIER&gt; "=" {@linkplain ASTMemberValue MemberValue}
 *
 * </pre>
 */
public class ASTMemberValuePair extends AbstractJavaNode {
    public ASTMemberValuePair(int id) {
        super(id);
    }


    public ASTMemberValuePair(JavaParser p, int id) {
        super(p, id);
    }


    /**
     * Returns the name of the member set by this pair.
     */
    public String getMemberName() {
        return getImage();
    }


    /**
     * Returns the value of the member set by this pair.
     */
    public ASTMemberValue getMemberValue() {
        return (ASTMemberValue) jjtGetChild(0);
    }


    @Override
    public ASTMemberValuePairs jjtGetParent() {
        return (ASTMemberValuePairs) super.jjtGetParent();
    }


    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}