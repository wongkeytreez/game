import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class draw extends JPanel {
  static JPanel panel;
  static JFrame frame;
  static BufferedImage image;

  static void start() {
    panel = new JPanel();
    frame = new JFrame("My Java Application");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(2500, 1000);
    panel.setLayout(null);

    frame.add(panel);
  }
  
  public static void verify() {

    // Printing the content inside the file

    BufferedImage img1;
    BufferedImage img2;
    BufferedImage img3;
    BufferedImage img4;
    try {
      img1 = ImageIO.read(new File("D:/Documents/images/1.jpg"));
      img2 = ImageIO
        .read(new File("D:/Documents/images/white2.jpg"));
      img3 = ImageIO
        .read(new File("D:/Documents/images/white2.jpg"));
      img4 = ImageIO
        .read(new File("D:/Documents/images/white2.jpg"));
    } catch (IOException e) {
      img1 = null;
      img2 = null;
      img3 = null;
      img4 = null;
    }
    int width1 = img1.getWidth();
    int height1 = img1.getHeight();
    int width2 = img2.getWidth();
    int height2 = img2.getHeight();
    int[][][] pixels1 = new int[width1][height1][3];
    int[][][] pixels2 = new int[width2][height2][3];

    for (int y = 0; y < height1; y++) {
      for (int x = 0; x < width1; x++) {
        Color pixelColor = new Color(img1.getRGB(x, y));

        // int diff = 1;
        // int r = pixelColor.getRed();
        // int g = pixelColor.getGreen();
        // int b = pixelColor.getBlue();
        // img1.setRGB(x, y, new Color((r / diff) * diff, (g / diff) * diff,
        // (b / diff) * diff).getRGB());
        pixels1[x][y][0] = pixelColor.getRed();
        pixels1[x][y][1] = pixelColor.getGreen();
        pixels1[x][y][2] = pixelColor.getBlue();
        // img3.setRGB(x, y, new Color(img3.getRGB(x, y) + 30).getRGB());
      }
    }
    for (int y = 0; y < height2; y++) {
      for (int x = 0; x < width2; x++) {
        Color pixelColor = new Color(img2.getRGB(x, y));
        // int diff = 40;
        // int r = pixelColor.getRed();
        // int g = pixelColor.getGreen();
        // int b = pixelColor.getBlue();
        // img2.setRGB(x, y, new Color((r / diff) * diff, (g / diff) * diff,
        // (b / diff) * diff).getRGB());
        pixels2[x][y][0] = pixelColor.getRed();
        pixels2[x][y][1] = pixelColor.getGreen();
        pixels2[x][y][2] = pixelColor.getBlue();
        // img3.setRGB(x, y, new Color(img3.getRGB(x, y) + 30).getRGB());
      }
    }
    //     int[][] matching = new int[width1][height1];
    //     matching[0][0] = 1;
    //     double maxdiff = 72;
    //     int maxdest = 3;
    //     boolean unnumbered = true;
    //     boolean firstunnumbered = true;
    //     int index = 0;
    //     double[][] matchdiff = new double[width1][height1];
    //     double[][][] tested = new double[width1][height1][2];

    //     for (int y = 0; y < height1; y++) {
    //       for (int x = 0; x < width1; x++) {
    //             matchdiff[x][y]=maxdiff;
    //       }
    //     }
    //     while (unnumbered) {
    //       System.out.println(index );
    //       tested = new double[width1][height1][2];
    //   for (int y = 0; y<height1  ; y++) {
    //            for (int x = 0;x< width1 ; x++) {
    //             tested[x][y][0]=0.5;      
    //             tested[x][y][1]=0.5;
    //             }}
    //       unnumbered = false;
    //       firstunnumbered = true;
    //       index++;

    //       for (int y = 0; y < height1; y++) {

    //         outerLoop: for (int x = 0; x < width1; x++) {

    //           if (matching[x][y] == 0) {

    //             unnumbered = true;
    //             if (!firstunnumbered)

    //               continue;

    //             matching[x][y] = index;
    //             firstunnumbered = false;

    //           }
    //           if (matching[x][y] != index) continue;

    //           for (double ydiffx = tested[x][y][1]; Math.abs(ydiffx) < maxdest ; ydiffx=(Math.abs(ydiffx)+0.5)*((ydiffx<0)?1:-1)) {
    //             for (double xdiffx =tested[x][y][0];   Math.abs(xdiffx) < maxdest ; xdiffx=(Math.abs(xdiffx)+0.5)*((xdiffx<0)?1:-1)) {
    //               int xdiff  = (int)xdiffx;
    //                 int ydiff  = (int)ydiffx;

    //       tested[x][y][0] =xdiffx;
    //         tested[x][y][1] =ydiffx;

    //               if (x + xdiff < 0 || x + xdiff >= width1 || y + ydiff < 0 || y + ydiff >= height1 || matching[x + xdiff][y + ydiff] == index) continue;

    //                 double deltaL = (pixels1[x+xdiff][y+ydiff][0] - pixels1[x][y][0])*0.2126;
    //         double deltaA =( pixels1[x+xdiff][y+ydiff][1] - pixels1[x][y][1])*0.7152;
    //         double deltaB =( pixels1[x+xdiff][y+ydiff][2]- pixels1[x][y][2])*0.0722;
    //         int diff=(int)(Math.sqrt(deltaL * deltaL + deltaA * deltaA + deltaB * deltaB)*5);
    //               if (diff<matchdiff[x+xdiff][y+ydiff]) {

    // matchdiff[x+xdiff][y+ydiff]=diff;
    //                 matching[x + xdiff][y + ydiff] = index;

    //                 if (xdiff > 0 || ydiff > 0 ) continue;

    //               if (x+xdiff > 0) {

    //               x = x+xdiff - 1;
    //               y = y+ydiff;
    //             } else {
    //               x = width1 - 1;
    //               y = y+ydiff - 1;
    //             }

    //             continue outerLoop;

    //               }else if((diff/2)>matchdiff[x+xdiff][y+ydiff]){
    //               continue outerLoop;
    //               }
    //             }
    //           }

    //         }
    //       }
    //     }

    // for (int y = 0; y < height1; y++) {
    //   for (int x = 0; x < width1; x++) {

    //          if(matching[x][y]==1)  img3.setRGB(x, y,matching[x][y]*2);
    //   }
    // }
    //     int[][] colors = new int[width1][4];
    //     int index = 0;
    //     boolean unnumbered = true;
    //     int[][] color = new int[width1][height1];
    //     int[][] similarity = new int[width1][height1];
    //     int maxcolordiif = 10;
    //     long startTime = System.currentTimeMillis();
    //     int sidecount = 3;
    //     while (index < 1 && unnumbered) {
    //       unnumbered = false;
    //       index++;
    //       boolean[][] tested = new boolean[width1][height1];
    //       for (int y = 0; y < height1; y++) {
    //       restart:  for (int x = 0; x < width1; x++) {

    //           if (tested[x][y]) continue;

    //           if (colors[index][3] == 0 && color[x][y] == 0) {
    //             unnumbered = true;
    //             color[x][y] = index;
    //             colors[index][0] = pixels1[x][y][0];
    //             colors[index][1] = pixels1[x][y][1];
    //             colors[index][2] = pixels1[x][y][2];
    // colors[index][3]++;
    //           }
    //           if (color[x][y] == index)
    //             for (int ysides = 0; ysides < sidecount + 1; ysides = ysides * -1 + (1 * ((ysides <= 0) ? 1 : 0))) {
    //               for (int xsides = 0; xsides < sidecount + 1; xsides = xsides * -1 + (1 * ((xsides <= 0) ? 1 : 0))) {
    //                 if (x + xsides < 0 || x + xsides >= width1 || y + ysides < 0 || y + ysides >= height1||(ysides==0&&xsides==0)) continue;
    //                 if(color[x + xsides][y + ysides]!=0)continue;
    //                 if (!((Math.abs(((pixels1[x][y][0]+colors[index][0])/2) - pixels1[x + xsides][y + ysides][0]) < maxcolordiif
    //                      &&
    //                      Math.abs(((pixels1[x][y][1]+colors[index][1])/2) - pixels1[x + xsides][y + ysides][1]) < maxcolordiif)||
    //                     (Math.abs(((pixels1[x][y][0]+colors[index][0])/2) - pixels1[x + xsides][y + ysides][0]) < maxcolordiif
    //                      &&
    //                      Math.abs(((pixels1[x][y][2]+colors[index][2])/2) - pixels1[x + xsides][y + ysides][2]) < maxcolordiif)||
    //                     (Math.abs(((pixels1[x][y][1]+colors[index][1])/2) - pixels1[x + xsides][y + ysides][1]) < maxcolordiif
    //                      &&
    //                      Math.abs(((pixels1[x][y][2]+colors[index][2])/2) - pixels1[x + xsides][y + ysides][2]) < maxcolordiif))) continue;
    //                      colors[index][3]++;    
    //                      color[x + xsides][y + ysides]=index;

    //            colors[index][0] = colors[index][0] + (pixels1[x + xsides][y + ysides][0] - colors[index][0]) / colors[index][3];
    //            colors[index][1] = colors[index][1] + (pixels1[x + xsides][y + ysides][1] - colors[index][1]) / colors[index][3];
    //            colors[index][2] = colors[index][2] + (pixels1[x + xsides][y + ysides][2] - colors[index][2]) / colors[index][3];
    //               }
    //             }

    //           //  img2.setRGB(x, y, (pixels1[x][y][0] << 16) | 0| 0);

    //           // if (
    //           //   Math.abs(pixels1[x][y][1] - colors[index][1]) < 4
    //           // ) img3.setRGB(x, y, (0 << 16) | (pixels1[x][y][1] << 8) | 0);
    //           // if (
    //           //   Math.abs(pixels1[x][y][2] - colors[index][2]) < 4

    //           // ) img4.setRGB(x, y, (0 << 16) | (0 << 8) | pixels1[x][y][2]);
    //           //   color[x][y]=index;

    //           tested[x][y] = true;

    //         }
    //       }
    //     }
    //  for (int y = 0; y < height1; y++) 
    //         for (int x = 0; x < width1; x++)if(color[x][y]==1) img2.setRGB(x, y, (pixels1[x][y][0] << 16) | 0| 0);
    //     long endTime = System.currentTimeMillis();

    //     long duration = endTime - startTime;
    //     System.out.println("Function took " + duration + " milliseconds to execute.");
verify.start(pixels1,width1,height1,0,0);
  

    
 //   checkpixel(1, 0, 0);
    ImageIcon icon1 = new ImageIcon(img1.getScaledInstance((int) 600, (int) 600,
      Image.SCALE_DEFAULT));
    JLabel label1 = new JLabel();
    label1.setIcon(icon1);
    panel.add(label1);
    label1.setBounds(0, 0, 600, 600);
    ImageIcon icon2 = new ImageIcon(img2.getScaledInstance((int) 600, (int) 600,
      Image.SCALE_DEFAULT));
    JLabel label2 = new JLabel();
    label2.setIcon(icon2);
    panel.add(label2);
    label2.setBounds(600, 0, 600, 600);
    ImageIcon icon3 = new ImageIcon(img3.getScaledInstance((int) 600, (int) 600,
      Image.SCALE_DEFAULT));
    JLabel label3 = new JLabel();
    label3.setIcon(icon3);
    panel.add(label3);
    label3.setBounds(1200, 0, 600, 600);
    ImageIcon icon4 = new ImageIcon(img4.getScaledInstance((int) 600, (int) 600,
      Image.SCALE_DEFAULT));
    JLabel label4 = new JLabel();
    label4.setIcon(icon4);
    panel.add(label4);
    label4.setBounds(1800, 0, 600, 600);

  }

  static void image(String imagePath, int x, int y, float size, int[] color) {

    JLabel label = new JLabel();
    ImageIcon icon;
    if (color[0] == 1) {
      icon = new ImageIcon(imagePath);
    } else if (color[0] == 0) {
      BufferedImage originalImage;
      try {
        originalImage = ImageIO.read(new File(imagePath));
        BufferedImage grayscaleImage = new BufferedImage(
          originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        ColorConvertOp colorConvertOp = new ColorConvertOp(
          originalImage.getColorModel().getColorSpace(), grayscaleImage.getColorModel().getColorSpace(),
          null);
        colorConvertOp.filter(originalImage, grayscaleImage);
        icon = new ImageIcon(grayscaleImage);
      } catch (IOException e) {
        icon = new ImageIcon(imagePath);
      }

    } else {
      try {
        BufferedImage originalImage = ImageIO.read(new File(imagePath));
        ImageFilter filter = new javax.swing.GrayFilter(true, color[1]); // Adjust the brightness percentage
        // (0-100)
        ImageProducer producer = new java.awt.image.FilteredImageSource(originalImage.getSource(), filter);
        Image grayscaleImage = java.awt.Toolkit.getDefaultToolkit().createImage(producer);

        icon = new ImageIcon(grayscaleImage);
      } catch (IOException e) {
        icon = new ImageIcon(imagePath);
      }

    }
    int iconwidth = icon.getImage().getWidth(label);
    int iconheight = icon.getImage().getHeight(label);
    icon = new ImageIcon(icon.getImage().getScaledInstance((int) size, (int)((size / iconwidth) * iconheight),
      Image.SCALE_DEFAULT));
    label.setIcon(icon);

    panel.add(label);

    label.setBounds(x, y, 300, 300);

  }

  static void update() {

    frame.setVisible(true);

  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 0, 0, null);
  }
}