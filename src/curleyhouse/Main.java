/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curleyhouse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author Greg
 */
public class Main {

    private static List<Point> points = new ArrayList<Point>();
    private static int count = 0;

    public static void main(String[] args) {
        Thread pointThread = new Thread() {
            public void run() {
                getPoints(count);
            }
        };
        Thread graphicsThread = new Thread() {
            public void run() {
                initDisplay();
                gameLoop();
            }
        };
        pointThread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
        }
        graphicsThread.start();
    }

    public static void gameLoop() {
        Camera cam = new Camera(70, (float) Display.getWidth() / (float) Display.getHeight(), 0.3f, 1000);
        cam.rotateX(-90f);
        cam.moveCamera(19f, 1);
        cam.setY(cam.getY() + 15f);
        while (!Display.isCloseRequested()) {
            boolean forward = Keyboard.isKeyDown(Keyboard.KEY_W);
            boolean backwards = Keyboard.isKeyDown(Keyboard.KEY_S);
            boolean up = Keyboard.isKeyDown(Keyboard.KEY_Q);
            boolean down = Keyboard.isKeyDown(Keyboard.KEY_Z);

            if (forward) {
                cam.move(.5f, -1);
                //cam.setY(cam.getY() - .5f);
            }
            if (backwards) {
                cam.move(.5f, 1);
                //cam.setY(cam.getY() - .5f);
            }
            if (up) {
                cam.setZ(cam.getZ() - .5f);
            }
            if (down) {
                cam.setZ(cam.getZ() + .5f);
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
                cam.rotateZ(-5f);
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
                cam.rotateZ(5f);
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
                cam.rotateX(5f);
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
                cam.rotateX(-5f);
            }
            glRotatef(45, 0, 1, 0);

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glLoadIdentity();
            cam.useView();
            glPushMatrix();

            glTranslatef(-10f, -20f, -20f);
            glPointSize(5f);
            glBegin(GL_POINTS);
            {
                for (int i = 0; i < points.size(); i++) {
                    Point p = points.get(i);
                    if (p != null) {
                        glColor3f(p.getRed(), p.getGreen(), p.getBlue());
                        glVertex3f(p.getX(), p.getY(), p.getZ());
                    }
                }
            }
            glEnd();
            glPopMatrix();
            Display.update();
        }
        Display.destroy();
    }

    public static void initDisplay() {
        try {
            Display.setDisplayMode(new DisplayMode(1200, 800));
            Display.create();
        } catch (LWJGLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getPoints(int count) {
        try {
            if (count == 0) {
                addPoints("west face.txt");
            } else if (count == 1) {
                addPoints("mid.txt");
            } else if (count == 2) {
                addPoints("2nd-3rd floor.txt");
            } else if (count == 3) {
                addPoints("dinning room.txt");
            } else if (count == 4) {
                addPoints("east face.txt");
            } else if (count == 5) {
                addPoints("south face.txt");
            } else if (count == 6) {
                addPoints("North Face.txt");
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
//            addPoints("west face.txt");
//            addPoints("mid.txt");
//            addPoints("2nd-3rd floor.txt");
//            addPoints("North Face.txt");
//            addPoints("dinning room.txt");
//            addPoints("east face.txt");
//            addPoints("south face.txt");
    }

    private static void addPoints(String fileName) throws IOException {
        BufferedReader linkBr = null;
        try {
            linkBr = new BufferedReader(new FileReader("src\\curleyHouse\\LinkToData.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        String path = linkBr.readLine();
        Thread loadThread = new Thread() {
            public void run() {
                try {
                    StringBuilder builder = new StringBuilder();
                    builder.append(path);
                    builder.append(fileName);
                    BufferedReader br = new BufferedReader(new FileReader(builder.toString()));
                    String line;
                    while ((line = br.readLine()) != null) {
                        points.add(new Point(line.split(" ")));
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                    }
                    br.close();
                    Thread.currentThread().interrupt();
                    count += 1;
                    getPoints(count);
                } catch (IOException ex) {
                    System.exit(-1);
                }
            }
        };
        Thread loadThread2 = new Thread() {
            public void run() {
                try {
                    StringBuilder builder = new StringBuilder();
                    builder.append(path);
                    builder.append(fileName);
                    BufferedReader br = new BufferedReader(new FileReader(builder.toString()));
                    String line;
                    while ((line = br.readLine()) != null) {
                        points.add(new Point(line.split(" ")));
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                    }
                    br.close();
                    Thread.currentThread().interrupt();
                    count += 1;
                    getPoints(count);
                } catch (IOException ex) {
                    System.exit(-1);
                }
            }
        };
        loadThread.start();
        loadThread2.start();
    }
}
