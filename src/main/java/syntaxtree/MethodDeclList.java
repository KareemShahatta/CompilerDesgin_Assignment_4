package syntaxtree;

import java.util.Vector;

public class MethodDeclList {
   private Vector<MethodDecl> list;

   public MethodDeclList() {
      list = new Vector<MethodDecl>();
   }

   public void addElement(MethodDecl n) {
      list.addElement(n);
   }

   public MethodDecl elementAt(int i)  { 
      return list.elementAt(i); 
   }

   public int size() { 
      return list.size(); 
   }

   @Override
   public String toString()
   {
     /* String METHOD_CLASS_SPACE = "\n\t\t\t";

      StringBuilder outputString = new StringBuilder();

      for(MethodDecl method : list)
      {
         outputString.append(METHOD_CLASS_SPACE).append(method.toString());
      }

      return outputString.toString();*/
      return null;
   }
}
