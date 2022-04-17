import java.io.*;
import java.util.*;

public class Database  
{
   private static HashMap<String, HashMap<String, HashSet<organization>>> byStatethenType;
   private donator Donator;
   
   public Database()
   {
      byStatethenType = new HashMap<String, HashMap<String, HashSet<organization>>>();
   }

   public static void add(organization org)
   {
      String state = org.getState();
      HashMap<String, HashSet<organization>> stateMap;
      if(byStatethenType.containsKey(state))
      {
         stateMap = byStatethenType.get(state);
      }
      else
      {
         stateMap = new HashMap<String, HashSet<organization>>();
         HashMap<String, HashSet<organization>> typesOrgs = addTypeMap(stateMap, org);
         byStatethenType.put(state, typesOrgs);
      }

   }

   public static HashMap<String, HashSet<organization>> addTypeMap(HashMap<String, HashSet<organization>> map, organization org)
   {
      String type = org.getType();
      HashSet<organization> typeSet;
      if(map.containsKey(type))
      {
         map.get(type).add(org);
      }
      else
      {
         typeSet = new HashSet<organization>();
          map.put(type, typeSet);
      }
      return map;
   }
   
   public ArrayList<String> display(String state, String type)
   {
      
      ArrayList<String> orgDescriptions = new ArrayList<String>();
      for(organization orgs: byStatethenType.get(state).get(type))
      {
         String description = "";
         description += orgs.getName() + "\n" + orgs.getDescription() + "\n" + "Keywords: " + orgs.getState() + ", " + orgs.getType();
         for(String str: orgs.getFocus())
         {
            if(donator.getFocus().contains(str))
               description += ", " + str;
         }
         orgDescriptions.add(description);
      }

      System.out.println(orgDescriptions.toString());
      return orgDescriptions;
   }

}
