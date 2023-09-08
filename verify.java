public  class verify {
    static boolean[][] member;
  static boolean[][] tested;
    static int sidecount = 3;
    static int[][][] pixels;
    static int imgwidth;
    static int imgheight;
    static int joinedpixels;
    static double red;
    static double green;
    static double blue;
    static int sume =0;
  static  void start(int[][][]pixelsstart,int startwidth,int startheight,int startx,int starty){
    member = new boolean[startwidth][startheight];
tested = new boolean[startwidth][startheight];
    member[startx][starty]=true;
    pixels=pixelsstart;
    red = pixels[0][0][0];
    green = pixels[0][0][1];
    blue = pixels[0][0][2];
imgwidth=startwidth;
imgheight=startheight;
    solidify(startx,starty);
    //System.out.print(index);
    }
  static void solidify(int x,int y){
     
    if(x<0||x>=imgwidth||y<0||y>=imgheight)return;
     
    for(int ysides=0;ysides<2;ysides=ysides* -1 + (1 * ((ysides <= 0) ? 1 : 0)))
    for(int xsides=0;xsides<2;xsides= xsides*-1 + (1 * ((xsides <= 0) ? 1 : 0))){
      
      if(x+xsides<0||x+xsides>=imgwidth||y+ysides<0||y+ysides>=imgheight)continue;
      if(member[x+xsides][y+ysides]==true||tested[x+xsides][y+ysides]==true)continue;
      tested[x+xsides][y+ysides]=true;
    if(Math.abs(pixels[x+xsides][y+ysides][0]-red)<10){
       member[x+xsides][y+ysides]=true;
       joinedpixels+=1;
       red+= (pixels[x+xsides][y+ysides][0]-red)/joinedpixels;
      green+= (pixels[x+xsides][y+ysides][1]-green)/joinedpixels;
      blue+= (pixels[x+xsides][y+ysides][2]-blue)/joinedpixels;
//        System.out.print(x);
//        System.out.print(" , ");

// System.out.println(y);
// try {
//   Thread.sleep(2, y);
// } catch (InterruptedException e) {

// }
       solidify(x+xsides, y+ysides);
    }
  }
    }
}
