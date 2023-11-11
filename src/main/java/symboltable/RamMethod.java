package symboltable;
import syntaxtree.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class RamMethod extends MethodDecl
{
    String string_identifier;
    Identifier identifier;
    Type type;
    public RamMethod(String string , Type type) {
        super(type, new Identifier(string), new FormalList() , new VarDeclList() , new StatementList() , null);
        this.identifier = new Identifier(string);
        this.string_identifier = string;

        this.type = type;
    }

    public boolean containsParam(String string) {
        for(int i = 0 ; i < fl.size() ; i++)
        {
            if(fl.elementAt(i).i.toString().equals(string))
            {
                return true;
            }
        }

        return false;
    }

    public boolean addParam(String string, Type type) {
        if(!containsParam(string))
        {
            fl.addElement(new Formal(type, new Identifier(string)));
            return true;
        }

        return false;
    }


    public RamVariable getParam(String string) {
        for(int i = 0 ; i < fl.size() ; i++)
        {
            if(fl.elementAt(i).i.toString().equals(string))
            {
                return new RamVariable(fl.elementAt(i).i.toString() , fl.elementAt(i).t);
            }
        }

        return null;
    }

    public RamVariable getParamAt(int number) {
        return new RamVariable(fl.elementAt(number).i.toString() , fl.elementAt(number).t);
    }

    public Iterator getParams() {
        ArrayList<Formal> paramList = new ArrayList<>();

        for(int i = 0 ; i < fl.size() ; i++)
        {
            paramList.add(fl.elementAt(i));
        }

        return paramList.iterator();
    }



    public boolean containsVar(String string) {
        for(int i = 0 ; i < vl.size() ; i++)
        {
            if(vl.elementAt(i).i.toString().equals(string))
            {
                return true;
            }
        }

        return false;
    }

    public boolean addVar(String string, Type type) {
        if(!containsVar(string))
        {
            vl.addElement(new VarDecl(type, new Identifier(string)));
            return true;
        }

        return false;
    }

    public RamVariable getVar(String string) {

        for(int i = 0 ; i < vl.size() ; i++)
        {
            if(vl.elementAt(i).i.toString().equals(string))
            {
                return (RamVariable) vl.elementAt(i);
            }
        }

        return null;
    }



    public String getId() {
        return string_identifier;
    }
    public Type type() {
        return type;
    }
}
