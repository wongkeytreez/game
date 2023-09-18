import java.util.Arrays;

public  class verify {
    static boolean[][] member;

    static int sidecount = 3;
    static int[][][] pixels;
    static int imgwidth;
    static int imgheight;
    static int joinedpixels;
    static double red;
    static double green;
    static double blue;
    static int maxdiff = 10;
  static  int[][][] start(int[][][]pixelsstart,int startwidth,int startheight,int startx,int starty){
    member = new boolean[startwidth][startheight];

    member[startx][starty]=true;
    pixels=pixelsstart;
    red = pixels[0][0][0];
    green = pixels[0][0][1];
    blue = pixels[0][0][2];
    joinedpixels=0;
imgwidth=startwidth;
imgheight=startheight;
    

        
 for(int checki=0;checki<50;checki++)
     solidify(starty*startwidth+startx);
          
        
        
      


    return pixels;
    }
  static int[][][] solidify(int startint){
    int[] todolist = new int[imgwidth*imgheight];
    todolist[0]=startint;
    int todolength=1;
    boolean[][] tested = new boolean [imgwidth][imgheight];
    while(todolength>0){

    // manage x and y
    int x =todolist[0]%imgwidth;
    int y =todolist[0] / imgwidth;

    // set main RGB
    joinedpixels++;
    red += (pixels[x][y][0]-red)/joinedpixels;
    green += (pixels[x][y][1]-green)/joinedpixels;
    blue += (pixels[x][y][2]-blue)/joinedpixels;

    // manage todo list
    for( int i = 0; i <todolength; i++ )
    todolist[i]= todolist[i+1];
    todolength--;

    int checksize = 3;
    double checkerpower = 0.3;
    int maxlightdiff=20;
    int thisRed=(int)(red+(pixels[x][y][0]-red)*checkerpower)-maxlightdiff;
    int thisGreen=(int)(green+(pixels[x][y][1]-green)*checkerpower)-maxlightdiff;
    int thisBlue=(int)(blue+(pixels[x][y][2]-blue)*checkerpower)-maxlightdiff;
    for(int ydiff = -checksize;ydiff<checksize+1;ydiff++)
    for(int xdiff = -(checksize-Math.abs(ydiff));xdiff<(checksize-Math.abs(ydiff))+1;xdiff++){
  //  System.out.print(xdiff);
  //  System.out.print(" ");
  //  System.out.println(ydiff);
    //  xdiff = (int) (Math.ceil(i/4)*((i%4>=2)?-1:1)*((i%2==0)?0:1));
    //  ydiff = (int) (Math.ceil(i/4)*((i%4>=2)?-1:1)*((i%2==1)?0:1));


     //System.out.println("2");

   if(x+xdiff<imgwidth&&x+xdiff>-1&&y+ydiff<imgheight&&y+ydiff>-1&&!tested[x+xdiff][y+ydiff]){ 
       
      // double thisRed=red;
      //   double thisGreen=green;
      //   double thisBlue=blue;
for(int i = -maxlightdiff;i<maxlightdiff+1;i++){
  thisRed++;
  thisGreen++;
  thisBlue++;
      if((Math.abs(thisRed-pixels[x+xdiff][y+ydiff][0])<maxdiff
        && 
        Math.abs(thisGreen-pixels[x+xdiff][y+ydiff][1])<maxdiff)||
        (Math.abs(thisRed-pixels[x+xdiff][y+ydiff][0])<maxdiff
        && 
        Math.abs(thisBlue-pixels[x+xdiff][y+ydiff][2])<maxdiff)||
        (Math.abs(thisGreen-pixels[x+xdiff][y+ydiff][1])<maxdiff
        && 
        Math.abs(thisBlue-pixels[x+xdiff][y+ydiff][2])<maxdiff)
        ){
      todolist[todolength]=  (y+ydiff) * imgwidth + (x+xdiff);
      todolength++;
    member[x+xdiff][y+ydiff]=true;
    break;
   }}
      tested[x+xdiff][y+ydiff]=true;
    }
  }
    

     }
    for(int i=0;i<imgwidth*imgheight;i++){
       int x =i%imgwidth;
      int y =i / imgwidth;
      pixels[x][y][0]=(member[x][y])?(int)red:0;
      pixels[x][y][1]=(member[x][y])?(int)green:0;
      pixels[x][y][2]=(member[x][y])?(int)blue:0;
    }
   
    return pixels;
  }}
