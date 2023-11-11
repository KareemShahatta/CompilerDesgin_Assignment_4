package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class MethodDecl {
  public Type t;
  public Identifier i;
  public FormalList fl;
  public VarDeclList vl;
  public StatementList sl;
  public Exp e;

  public MethodDecl(Type at, Identifier ai, FormalList afl, VarDeclList avl, 
                    StatementList asl, Exp ae) {
    t=at; i=ai; fl=afl; vl=avl; sl=asl; e=ae;
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
    String METHOD_CLASS_SPACE = "\n\t\t\t";
    String METHOD_CLASS_PRAM_LOCAL_SPACE = "\n\t\t\t\t";
    String METHOD_CLASS_PRAM_LOCAL_CLASS_SPACE = "\n\t\t\t\t\t";

    StringBuilder outputString = new StringBuilder();
    outputString.append(METHOD_CLASS_SPACE).append("class ").append(t.getClass().getCanonicalName()).append(" ").append(i.toString());
    outputString.append(METHOD_CLASS_PRAM_LOCAL_SPACE).append("Params:");

    for(String param : fl.toString().split(","))
    {
      outputString.append(METHOD_CLASS_PRAM_LOCAL_CLASS_SPACE).append(param);
    }

    outputString.append(METHOD_CLASS_PRAM_LOCAL_SPACE).append("Locals:");

    for(String var : vl.toString().split(","))
    {
      outputString.append(METHOD_CLASS_PRAM_LOCAL_CLASS_SPACE).append(var);
    }

    return outputString.toString();
  }
}
