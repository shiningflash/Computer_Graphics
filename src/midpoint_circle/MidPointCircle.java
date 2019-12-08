package midpoint_circle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author Amirul Islam (17101537)
 */
public class MidPointCircle  implements GLEventListener {
	/**
	 * Interface to the GLU library.
	 */
	private GLU glu;

	/**
	 * Take care of initialization here.
	 * @param gld
	 */
	@Override
	public void init(GLAutoDrawable gld) {
		GL2 gl = gld.getGL().getGL2();
		glu = new GLU();

		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		gl.glViewport(-250, -150, 250, 150);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
	}

	/**
	 * Take care of drawing here.
	 * @param drawable
	 */
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

		drawMPC(gl, 70);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		//do nothing
	}

	public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
		//do nothing
	}

	int dx, dy, b;
	public void drawMPC(GL2 gl, int r){

		gl.glPointSize(2.0f);
		gl.glColor3d(1, 0, 0);              
		gl.glBegin(GL2.GL_POINTS); 



		int x = r;
		int y = 0;
		int d = 5-4*r;

		drawPixel8Way(gl,x,y);
		while(y<x) {
			if(d<0) { //dN
				d += 8*y+12;
				y++;
			}
			else { //dNW
				d += 8*y-8*x+20;
				y++;
				x--;
			}
			drawPixel8Way(gl,x,y);
		}

		gl.glEnd();
	}

	void drawPixel8Way(GL2 gl, int x, int y) {
		// TODO Auto-generated method stub

		gl.glPointSize(5.0f);
		gl.glColor3d(1, 0, 0);

		gl.glBegin(GL2.GL_POINTS); 

		gl.glVertex2d(x, y); 
		gl.glVertex2d(-x, y);
		gl.glVertex2d(x, -y); 
		gl.glVertex2d(-x, -y); 

		gl.glVertex2d(y, x); 
		gl.glVertex2d(-y, x); 
		gl.glVertex2d(y, -x); 
		gl.glVertex2d(-y, -x); 

	}

	//y=mx+b
	private int func(int x, float y){
		return (int)(dy*x - y*dx + b*dx);
	}


	int findZone(int x1, int y1, int x2, int y2) {
		int zone = 0;
		int dx = x2 - x1;
		int dy = y2 - y1;
		if (dx >= 0 && dy >= 0) {
			if (dx >= dy) zone = 0;
			else zone = 1;
		}
		else if (dx < 0 && dy >= 0) {
			if (Math.abs(dx) > dy) zone = 3;
			else zone = 2;
		}
		else if (dx < 0 && dy < 0) {
			if (Math.abs(dx) > Math.abs(dy)) zone = 4;
			else zone = 5;
		}
		else {
			if (dx < Math.abs(dy)) zone = 6;
			else zone = 7;
		}
		return zone;
	}

	int convertX(int x, int y, int zone){
		int convertedX=0;
		if (zone == 0) convertedX = x;
		else if (zone == 1) convertedX = y;
		else if (zone == 2) convertedX = y;
		else if (zone == 3) convertedX = -x;
		else if (zone == 4) convertedX = -x;
		else if (zone == 5) convertedX = -y;
		else if (zone == 6) convertedX = -y;
		else convertedX = x;
		return convertedX;
	}

	int convertY(int x, int y, int zone){
		int convertedY=0;   
		if (zone == 0) convertedY = y;
		else if (zone == 1) convertedY = x;
		else if (zone == 2) convertedY = -x;
		else if (zone == 3) convertedY = y;
		else if (zone == 4) convertedY = -y;
		else if (zone == 5) convertedY = -x;
		else if (zone == 6) convertedY = x;
		else convertedY = -y;
		return convertedY;
	}


	public void dispose(GLAutoDrawable arg0) {
		//do nothing
	}
}