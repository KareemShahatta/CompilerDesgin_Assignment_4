package symboltable;
import syntaxtree.*;

import java.util.ArrayList;
import java.util.Iterator;

public class RamMethod extends MethodDecl
{
    String identifier;
    Type type;
    public RamMethod(String string , Type type) {
        super(type, new Identifier(string), new FormalList() , new VarDeclList() , new StatementList() , null);
        this.identifier = string;

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
            vl.addElement(new RamVariable(string, type));
            return true;
        }

        return false;
    }

    public RamVariable getVar(String string) {

        for(int i = 0 ; i < vl.size() ; i++)
        {
            if(vl.elementAt(i).i.toString().equals(string))
            {
                return new RamVariable(vl.elementAt(i).i.toString() ,  vl.elementAt(i).t);
            }
        }

        return null;
    }



    public String getId() {
        return identifier;
    }
    public Type type() {
        return type;
    }


    @Override
    public String toString() {
        String METHOD_CLASS_SPACE = "\t\t\t";
        String METHOD_CLASS_PRAM_LOCAL_SPACE = "\n\t\t\t\t";
        String METHOD_CLASS_PRAM_LOCAL_CLASS_SPACE = "\n\t\t\t\t\t";

        StringBuilder outputString = new StringBuilder();
        outputString.append(METHOD_CLASS_SPACE).append("class ").append(t.getClass().getCanonicalName()).append(" ").append(i.toString());
        outputString.append(METHOD_CLASS_PRAM_LOCAL_SPACE).append("Params:");

        for(String param : fl.toString().split(","))
        {
            if(!param.isEmpty())
            {
                outputString.append(METHOD_CLASS_PRAM_LOCAL_CLASS_SPACE).append(param);
            }
        }

        outputString.append(METHOD_CLASS_PRAM_LOCAL_SPACE).append("Locals:");

        for(String var : vl.toString().split(","))
        {
            if(!var.isEmpty())
            {
                outputString.append(METHOD_CLASS_PRAM_LOCAL_CLASS_SPACE).append(var);
            }
        }

        outputString.append("\n");

        return outputString.toString();
    }
}
