
import java.util.*;

public class App {
  
  public static void main(String args[]){
    Scanner sc1=new Scanner(System.in);
    int opt=1,diff,bunker[],bombs,flag=0,gflag=0,x,y,prev1=0,prev2=0,wins=0,loses=0,grid;
    while(opt!=5){
    System.out.println("\nBusting Bunkers");
      
      System.out.print("\n1.)Play \n2.)About \n3.)Scores \n4.)Guide \n5.)Quit \nEnter Choice: ");
      opt=sc1.nextInt();

      switch(opt){
        case 1:
            System.out.print("\n1.)Sepoy \n2.)Lieutenant \n3.)Colonel \n4.)Field Marshal \nChoose Difficulty: ");
            diff=sc1.nextInt();
            if(diff==1){
            grid=2;
            }
            else if(diff==2){
            grid=3;
            }
            else if(diff==3){
            grid=4;
            }
            else if(diff==4){
            grid=5;
            }
            else{
            System.out.println("\nSince you Didn't report your ranking properly,\nThe Fuhrer has setup a much more difficult trap...\nHitting the bunker has now become close to impossible");
            grid=diff;
            }
            Adolf ad1=new Adolf();
            bunker=ad1.selectBunker(grid);
            //System.out.print("FROM MAIN:"+bunker[0]+" "+bunker[1]);
            bombs=3;
            prev1=prev2=0;
            gflag=0;
            flag=0;
            while(bombs!=0 && flag!=1){
            
            if(gflag==0){
            Draw d1=new Draw(grid);
            gflag=1;
            }
            else{
            Draw d1=new Draw(grid,prev1,prev2);
            String check=bombs>1?"bombs":"bomb";
            System.out.println("Not Quite on Target, You have "+bombs+" "+check+" left.");
            }

            System.out.print("\nEnter Coordinates(x,y) to be attacked: ");
            x=sc1.nextInt()-1; y=sc1.nextInt()-1;

            if(x==bunker[0] && y==bunker[1]){

                System.out.println("\nCongratulations, You Saved the world.");

                flag=1;
                bombs--;
                break;

            }
            else{
                prev1=x;
                prev2=y;
                bombs--;
            }

            }
            if(flag==1){
            System.out.println("");
            ad1.draw();
            System.out.println("");
            String check=bombs>1?"bombs":"bomb";
            System.out.println("YOU WON, WITH "+bombs+" "+check+" to spare.");
            wins++;

            }
            else{
            System.out.println("\nYou Attacked Here....\n");
            Draw d1=new Draw(grid,prev1,prev2);
            System.out.println("\n");
            ad1.draw();

            System.out.println("Unfortunately you missed a chance to murder the Fuhrer.");
            loses++;
            }

            break;

      case 2:
      System.out.println("\nThis is a Mini-Project designed for Subject OOP, for year 2020-21\n"); 
      System.out.println("\nBy Students: Nithin Nair, Sterlin Peter, Sahil Takbhate and Prathmesh Naik\n");
      break;

      case 3: System.out.println("\nWON: "+wins+"\nLOST: "+loses); break;

      case 4:
      System.out.println("It is 1944, You are on a mission to save the planet from the dangerous Dictator's wrath \n");
      System.out.println(". . .");
      System.out.println(". . .");
      System.out.println(". . .\n");
      System.out.println("A map with coordinates is shown above, you must input the coordinates like:- \n");
      System.out.println("'1 1' '1 2' '1 3'");
      System.out.println("'2 1' '2 2' '2 3'");
      System.out.println("'3 1' '3 2' '3 3'\n");
      System.out.println("You have to enter the coordinates to eliminate the bunker in that position....\nGuess wisely...\n");
      break;

      case 5: System.out.println("\n");break;

      default: System.out.println("INVALID CODE, You can get court-martialed for this...");

      }

    }
    sc1.close();
  }
}

class Adolf{
  int m[]={1,2},i,j,grid;
  int[] selectBunker(int grid){
    
    this.grid=grid;

    Random r1=new Random();
    Random r2=new Random();
    
    
    m[0]=r1.nextInt(grid);
    m[1]=r2.nextInt(grid);
    return m;

  }
  void draw(){
    System.out.println("Adolf was hidden here...");
    System.out.println("");
    for(i=0;i<grid;i++){
      for(j=0;j<grid;j++){
        if(i==m[0] && j==m[1]){

        System.out.print("X ");
        }
        else{

        System.out.print(". ");
        }
      }
      System.out.println("");
    }
    System.out.println("");
  }
}

class Draw{
  int i,j;
  Draw(int n,int m1,int m2){
    System.out.println("");
    for(i=0;i<n;i++){
      for(j=0;j<n;j++){
        if(i==m1 && j==m2){

        System.out.print("O ");
        }
        else{

        System.out.print(". ");
        }
      }
      System.out.println("");
    }
    System.out.println("");
  }
  Draw(int n){
    System.out.println("");
    int i,j;
    for(i=0;i<n;i++){
      for(j=0;j<n;j++){
        System.out.print(". ");
      }
      System.out.println("");
    }
  }
}
