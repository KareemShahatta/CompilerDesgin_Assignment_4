package visitor;

import symboltable.RamMethod;
import syntaxtree.Call;
import syntaxtree.IdentifierType;
import syntaxtree.Type;

public class RamTypeCheckExpVisitor extends TypeCheckExpVisitor
{
    @Override
    public Type visit(Call n)
    {

        if (!(n.e.accept(this) instanceof IdentifierType))
        {
            System.out.println("method " + n.i.toString()
                    + "called  on something that is not a"
                    + " class or Object.");
            System.exit(-1);
        }

        String mname = n.i.toString();
        String cname = ((IdentifierType) n.e.accept(this)).s;

        RamMethod calledMethod = RamTypeCheckVisitor.symbolTable.getMethod(mname, cname);

        if(calledMethod != null)
        {
            for (int i = 0; i < n.el.size(); i++) {
                Type t1 = null;
                Type t2 = null;

                if (calledMethod.getParamAt(i) != null) {
                    t1 = calledMethod.getParamAt(i).type();
                }
                t2 = n.el.elementAt(i).accept(this);
                if (!TypeCheckVisitor.symbolTable.compareTypes(t1, t2)) {
                    System.out.println("Type Error in arguments passed to "
                            + cname + "." + mname);
                    System.exit(-1);
                }
            }

        }

        return TypeCheckVisitor.symbolTable.getMethodType(mname, cname);
    }
}
