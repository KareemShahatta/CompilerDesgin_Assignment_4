package visitor;

import symboltable.Table;

public class RamTypeCheckVisitor
{
    Table symbolTable;

    public RamTypeCheckVisitor(Table s)
    {
        symbolTable = s;
    }
}
