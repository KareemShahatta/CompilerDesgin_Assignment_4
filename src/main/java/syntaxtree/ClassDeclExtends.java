package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class ClassDeclExtends extends ClassDecl {
  public Identifier i;
  public Identifier j;
  public VarDeclList vl;  
  public MethodDeclList ml;
 
  public ClassDeclExtends(Identifier ai, Identifier aj, 
                  VarDeclList avl, MethodDeclList aml) {
    i=ai; j=aj; vl=avl; ml=aml;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Type accept(TypeVisitor v) {
    return v.visit(this);
  }

  @Override
  public String toString()
  {
    /*String VAR_METHOD_SPACE = "\t\t";

    String VAR_CLASS_SPACE = "\n\t\t\t";

    StringBuilder outputString = new StringBuilder();
    outputString.append(i.toString()).append(" extends ").append(j.toString()).append(VAR_METHOD_SPACE).append("Fields");

    for(String var : vl.toString().split(","))
    {
      outputString.append(VAR_CLASS_SPACE).append(var);
    }

    outputString.append(VAR_METHOD_SPACE).append("Methods");

    outputString.append(ml.toString());

    return outputString.toString();*/
    return null;
  }
}
