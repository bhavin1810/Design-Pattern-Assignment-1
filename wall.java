 import java.util.*;
 import java.io.*;
    public class wall extends map{
    public wall() {}

    
    
    void enter(int a) {
    	switch(a)
    	{
    		case 0: System.out.println("There is a wall to your east");break;
    		case 1: System.out.println("There is a wall to your west");break;
    		case 2: System.out.println("There is a wall to your north");break;
    		case 3: System.out.println("There is a wall to your south");break;
            default: System.out.println("Something is wrong.Try again");break;

    	}
        
    }
}