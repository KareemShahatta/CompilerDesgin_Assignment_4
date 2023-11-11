package symboltable;
import syntaxtree.Identifier;
import syntaxtree.Type;
import syntaxtree.VarDecl;

public class RamVariable extends VarDecl
{
    String identifier;
    Type type;

    public RamVariable(String string, Type type)
    {
        super(type, new Identifier(string));
        this.identifier = string;
        this.type = type;
    }
    public String getId()
    {
        return identifier;
    }

    public Type type()
    {
        return type;
    }
}
