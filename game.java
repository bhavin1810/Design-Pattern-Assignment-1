 import java.util.*;
 import java.io.*;
 import java.lang.*;

 public class game{
  
   public static void main(String[] args)
   {
   	maze t = new maze();
   	try{
         
          t.puzzle();
        }
     catch(IOException e)
     {
       e.printStackTrace();
     }

    


   }}