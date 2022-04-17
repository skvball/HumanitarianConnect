import java.util.HashSet;

public class donator 
{
   private String name;
   private String state;
   private String type;
   private static HashSet<String> focus;
   
   public donator(String n, String s, String t) 
   {
      name = n;
      state = s;
      type = t;
      focus = new HashSet<String>();
   }
   public String getName()
   {
      return name;
   }
   public void addFocus(String f)
   {
      focus.add(f);
   }
   public static HashSet<String> getFocus()
   {
      return focus;
   }
   public String getState()
   {
      return state;
   } 

   public String getType()
   {
      return type;
   }

   public void setType(String t)
   {
      type = t;
   }
}