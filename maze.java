 import java.util.*;
 import java.io.*;
 import java.lang.*;

 public class maze {
  
   public void puzzle() throws IOException{

   System.out.println("*****************************************************************************");
   System.out.println("******************* T H E  E L D E R  S C R O L L S *************************");
   System.out.println("********************  W E L C O M E   Y O U   TO   **************************");//***********************");
   System.out.println("*******************     T H E  W O R L D   O F  *****************************");
   System.out.println("*****************************************************************************");

   System.out.println("   --------------------------------------------------------------------------");
   System.out.println("---                S     K     Y     R     I     M                           ---");
   System.out.println("   --------------------------------------------------------------------------");


   System.out.println("\n\n\n");
   System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
   System.out.println("|         The game takes place in Skyrim, a province of the Empire on the      |");
   System.out.println("|         continent of Tamriel, amid a civil war between two factions.         |");
   System.out.println("|         The Stormcloaks are made up of Skyrim's native Nord race and The     |");
   System.out.println("|         Imperial Legion. The main story begins with the player being         |");
   System.out.println("|         imprisoned by Alduin, a powerful black dragon also known as the      |");
   System.out.println("|         Nordic God of destruction. Alduin is prophesied to destroy the       |");
   System.out.println("|         races of Men and Mer, and consume the world. In order to save not    |");
   System.out.println("|         only Skyrim but the whole world from Alduin's wrath the player has   |");
   System.out.println("|         to find his way through the torturous maze set by Alduin and         |");
   System.out.println("|         encounter many obstacles along the way to attain the title of        |");
   System.out.println("|                         D  O  V  A  H  K  I  I  N                            |");
   System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
 


   
  



















   StringBuilder sb = new StringBuilder();  
   int [][] a = new int [500][5];           int [][] b = new int [500][500];
   BufferedReader br = null;                
   String line = null;
   int i=0,j=0;int rowno=0;
     try
          {
            br = new BufferedReader(new FileReader("CreateMaze.txt"));
            while((line = br.readLine())!=null)
             {
            String[] s = line.split(" ");
                for(j=0;j<s.length;j++)
                {
                     a[i][j] = Integer.parseInt(s[j]);
                }
               i++;rowno++;  //System.out.println(i);
             }         
          }

         finally
          {
          if(br != null)
           {
             try
             {
               br.close();
             }
             catch(IOException e)
             {
               throw new IOException("Something is wrong.Try again");
             }
           }
          }
          //System.out.println("Maze Created!");delay();
         
          
//***********************************  TRAVERSING  **********************************************************************          
          int []traverserow = new int [500];i=0;
               try
          {    
            br = new BufferedReader(new FileReader("TraverseMaze.txt"));
            while((line = br.readLine())!=null)
             {
                String[] s = line.split(" ");
                for(j=0;j<s.length;j++)
                {
                     b[i][j] = Integer.parseInt(s[j]);
                     //System.out.println("j="+j);
                     traverserow[i]=j;
                      //System.out.println(b[i][j]);     //Maze traversed
                      
                }
                //System.out.println("traverserow="+traverserow[i]);
                i++;
             }
              
          }

         finally
          {
          if(br != null)
           {
             try
             {
               br.close();
             }
             catch(IOException e)
              {
              throw new IOException("Something is wrong.Try again");
              }
           }
          }
          //System.out.println("Maze traversed!");delay();
          System.out.println("\n\n\n\n");

          
//*******************************  FINDING  DESTINATION  *******************************

    
    door d = new door();
    wall w = new wall();

    PrintWriter output = new PrintWriter("Destinations.txt", "UTF-8");

    int i1=0,j1=0,destination,rowfele;
    for(i1=0;traverserow[i1]!=0;i1++)
    {
        rowfele=b[i1][0];
        destination=rowfele;
 
         System.out.println("YOU ARE IN ROOM "+rowfele+".DESTINY AWAITS!");


        for(j1=1;j1<=traverserow[i1];j1++)
        {
           switch(b[i1][j1])
           {
              case 0:
                      {
                         if(a[destination-1][1]!=0)
                          {  
                            delay();
                            int temp = a[destination-1][1];
                             d.enter(destination,temp);
                            destination=a[destination-1][1];break;   } 
                         else
                          {  
                            delay();
                            w.enter(0);break;       }
                      }
              case 1:
                      {
                        if(a[destination-1][2]!=0)
                       {    
                        delay();
                        int temp = a[destination-1][2];
                        d.enter(destination,temp);
                        destination=a[destination-1][2];break;     }
                        else
                       {    
                            delay();
                            w.enter(1);break;        }
                      }        
              case 2:
                      {
                        if(a[destination-1][3]!=0)
                       {  
                        delay();
                        int temp = a[destination-1][3];
                        d.enter(destination,temp);
                        destination=a[destination-1][3];break;      }
                        else
                       {    delay();
                            w.enter(2);break;       }
                      }        
              case 3:
                      {
                        if(a[destination-1][4]!=0)
                       {   
                         delay();
                         int temp = a[destination-1][4];
                        d.enter(destination,temp);
                        destination=a[destination-1][4];break;     }
                        else
                       {     delay();
                             w.enter(3);break;       }
                      }    
              default:
                      {
                        System.out.println("wrong direction");
                      }            
            }

        }
        System.out.println("destination for room "+rowfele+" is "+destination);
        output.println(destination);
         System.out.println("\n\n");
      }output.close();
    }

        void delay()
    {
      for(int i=0;i<100000;i++)
      {}
    }


  }

         



 

 
