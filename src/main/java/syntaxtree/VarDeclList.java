package syntaxtree;

import java.util.Vector;

public class VarDeclList {
   private Vector<VarDecl> list;

   public VarDeclList() {
      list = new Vector<VarDecl>();
   }

   public void addElement(VarDecl n) {
      list.addElement(n);
   }

   public VarDecl elementAt(int i)  { 
      return list.elementAt(i); 
   }

   public int size() { 
      return list.size(); 
   }

   @Override
   public String toString()
   {
      StringBuilder outputString = new StringBuilder();

      for(VarDecl var : list)
      {
         outputString.append(var.toString()).append(",");
      }

      return outputString.toString();
   }
}
