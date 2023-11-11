package syntaxtree;

import java.util.Vector;

public class ClassDeclList {
   private Vector<ClassDecl> list;

   public ClassDeclList() {
      list = new Vector<ClassDecl>();
   }

   public void addElement(ClassDecl n) {
      list.addElement(n);
   }

   public ClassDecl elementAt(int i)  { 
      return list.elementAt(i); 
   }

   public int size() { 
      return list.size(); 
   }


   @Override
   public String toString()
   {
      /*String CLASS_SPACE = "\n\t";

      StringBuilder outputString = new StringBuilder();
      outputString.append("Classes:");

      for(ClassDecl declared_class : list)
      {
         outputString.append(CLASS_SPACE).append(declared_class.toString());
      }*/

      //return outputString.toString();
      return null;
   }
}
