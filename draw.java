import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

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
    frame.setSize(2400, 1000);
    panel.setLayout(null);

    frame.add(panel);
  }

  public static void verify() {

    // Printing the content inside the file

    BufferedImage img1;
    BufferedImage img2;
    BufferedImage img3;
    try {
      img1 = ImageIO.read(new File("D:/Documents/images/1.jpg"));
      img2 = ImageIO.read(new File("D:/Documents/images/2.jpg"));
      img3 = ImageIO
        .read(new File("D:/Documents/images/white.jpg"));
    } catch (IOException e) {
      img1 = null;
      img2 = null;
      img3 = null;

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
    int[][] matching = new int[width1][height1];
    matching[0][0] = 1;
    double maxdiff = 20;
    int maxdest = 9;
    int unnumbered = 1;
    boolean firstunnumbered = true;
    int index = 0;
    double[][][] matchdiff = new double[width1][height1][3];
    for (int y = 0; y < height1; y++) {
      for (int x = 0; x < width1; x++) {
        matchdiff[x][y][0] = maxdiff * 0.2126;
        matchdiff[x][y][1] = maxdiff * 0.7152;
        matchdiff[x][y][2] = maxdiff * 0.0722;
        //     matchdiff[x][y][0]=maxdiff;
        //  matchdiff[x][y][1]=maxdiff;
        //          matchdiff[x][y][2]=maxdiff;
      }
    }
    while (unnumbered != -1) {
      System.out.println(index);

      unnumbered = -1;
      firstunnumbered = true;
      index++;
      for (int y = 0; y < height1; y++) {
        outerLoop: for (int x = 0; x < width1; x++) {

          if (matching[x][y] == 0) {

            unnumbered = index;
            if (!firstunnumbered) {

              continue;
            } else {

              matching[x][y] = index;
              firstunnumbered = false;
            }
          }
          if (matching[x][y] != index) continue;
          Color color = new Color(img1.getRGB(x, y));

          if (color.getAlpha() != 255) System.out.println(color.getAlpha());
          int restartx = -1;
          int restarty = -1;
          for (int ydiff = -maxdest; ydiff < maxdest + 1; ydiff++) {
            for (int xdiff = -maxdest; xdiff < maxdest + 1; xdiff++) {
              if (x + xdiff < 0 || x + xdiff >= width1 || y + ydiff < 0 || y + ydiff >= height1 || matching[x + xdiff][y + ydiff] == index) continue;

              if (xdiff == 0 && ydiff == 0) continue;

              Color color2 = new Color(img1.getRGB(x + xdiff, y + ydiff));
              float diffred = Math.abs(color2.getRed() - color.getRed());
              float diffgreen = Math.abs(color2.getGreen() - color.getGreen());
              float diffblue = Math.abs(color2.getBlue() - color.getBlue());

              if (diffred < matchdiff[x + xdiff][y + ydiff][0] && diffgreen < matchdiff[x + xdiff][y + ydiff][1] && diffblue < matchdiff[x + xdiff][y + ydiff][2]) {

                matching[x + xdiff][y + ydiff] = index;
                matchdiff[x + xdiff][y + ydiff][0] = diffred;
                matchdiff[x + xdiff][y + ydiff][1] = diffgreen;
                matchdiff[x + xdiff][y + ydiff][2] = diffblue;
                if (xdiff > 0 || ydiff > 0 || restartx != -1) continue;

                restartx = x + xdiff;
                restarty = y + ydiff;

              }
            }
          }
          if (restartx != -1) {

            if (restartx > 0) {

              x = restartx - 1;
              y = restarty;
            } else {
              x = width1 - 1;

              y = restarty - 1;
            }
            continue outerLoop;
          }
        }
      }
    }
    for (int y = 0; y < height1; y++) {
      for (int x = 0; x < width1; x++) {
        if (matching[x][y] == 1)
          img3.setRGB(x, y, img1.getRGB(x, y));
      }
    }
    System.out.println(img1.getRGB(0, 0 + 1) & 0x00FFFFFF);
    ImageIcon icon = new ImageIcon(img1.getScaledInstance((int) 600, (int) 600,
      Image.SCALE_DEFAULT));
    JLabel label = new JLabel();

    // icon = new ImageIcon(icon.getImage());

    label.setIcon(icon);
    panel.add(label);
    label.setBounds(0, 0, 600, 600);

    ImageIcon icon2 = new ImageIcon(img2.getScaledInstance((int) 600, (int) 600,
      Image.SCALE_DEFAULT));
    JLabel label2 = new JLabel();

    // icon = new ImageIcon(icon.getImage());

    label2.setIcon(icon2);
    // panel.add(label2);
    label2.setBounds(600, 0, 600, 600);

    ImageIcon icon3 = new ImageIcon(img3.getScaledInstance((int) 600, (int) 600,
      Image.SCALE_DEFAULT));
    JLabel label3 = new JLabel();

    // icon = new ImageIcon(icon.getImage());

    label3.setIcon(icon3);
    panel.add(label3);
    label3.setBounds(1200, 0, 600, 600);
    System.out.println(icon);
    // System.out.println(pixel[0]);
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