package visitor;

import symboltable.Table;
import syntaxtree.*;

public class RamTypeCheckVisitor extends TypeCheckVisitor
{
    public RamTypeCheckVisitor(Table s)
    {
        super(s);
        symbolTable = s;
    }

    @Override
    public void visit(MethodDecl n)
    {
        n.t.accept(this);
        String id = n.i.toString();
        currMethod = currClass.getMethod(id);
        Type retType = currMethod.type();

        for ( int i = 0; i < n.fl.size(); i++ ) {
            n.fl.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.vl.size(); i++ ) {
            n.vl.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.sl.size(); i++ ) {
            n.sl.elementAt(i).accept(this);
        }
        if (symbolTable.compareTypes(retType, n.e.accept(new RamTypeCheckExpVisitor()))==false){
            System.out.println("Wrong return type for method "+ id);
            System.exit(0);
        }
    }

    @Override
    public void visit(Print n)
    {
        if (!(n.e.accept(new RamTypeCheckExpVisitor()) instanceof IntegerType) && !(n.e.accept(new RamTypeCheckExpVisitor()) instanceof BooleanType))
        {
            System.out.println("The argument of System.out.println must be of type int or boolean");
            System.exit(-1);
        }
    }

    @Override
    public void visit(While n)
    {
        if (!(n.e.accept(new RamTypeCheckExpVisitor()) instanceof BooleanType))
        {
            System.out.println("The condition of while must be of type boolean");
            System.exit(-1);
        }

        n.s.accept(this);
    }
}
