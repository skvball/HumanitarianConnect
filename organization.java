import java.util.HashSet;

public class organization 
{
   private String name; 
   private String state;
   private String description; 
   private String type; 
   private HashSet<String> focus;
   private boolean accepting;

   public organization (String n, String s, String d, String t)
   {
      name = n;
      state = s;
      description = d;
      type = t;
      focus = new HashSet<String>();
   }

   public String getName()
   {
      return name;
   }

   public String getState()
   {
      return state; 
   }

   public String getDescription()
   {
      return description;
   }
   public void setType(String t)
   {
      type = t;
   }
   public String getType()
   {
    return type;
   }

   public void addFocus(String f)
   {
      focus.add(f); 
   }

   public HashSet<String> getFocus()
   {
     return focus; 
   }

   public void changeStatus(boolean ac)
   {
      accepting = ac; 
   }

   public boolean getStatus()
   {
      return accepting; 
   }
}