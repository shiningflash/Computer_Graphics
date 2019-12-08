package symmetric_star;

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
public class Symmetric_Star  implements GLEventListener {
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
		
		DrawMPL(gl,0,-100,59,81);
		DrawMPL(gl,0,-100,-59,81);
		DrawMPL(gl,59,81,-95,-31);
		DrawMPL(gl,95,-31,-95,-31);
		DrawMPL(gl,95,-31,-59,81);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		//do nothing
	}

	public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
		//do nothing
	}

	int dx, dy, b;
	private void DrawMPL(GL2 gl, int x1, int y1, int x2, int y2) {
		//write your own code	

		int zone = findZone(x1, y1, x2, y2);
		int nx1 = convertX(x1, y1, zone);
		int ny1 = convertY(x1, y1, zone);
		int nx2 = convertX(x2, y2, zone);
		int ny2 = convertY(x2, y2, zone);

		int dx = nx2 - nx1;
		int dy = ny2 - ny1;
		int d = 2 * dy - dx;
		int iE = 2 * dy;
		int iNE = 2 * (dy - dx);
		int y = ny1;

		for (int x = nx1; x <= nx2; x++) {

			//WritePixel(x, y);
			gl.glPointSize(3.0f);
			gl.glColor3d(1, 0, 0);
			gl.glBegin(GL2.GL_POINTS);

			if(zone==0) gl.glVertex2d(x, y);
			else if(zone==1) gl.glVertex2d(y, x);
			else if(zone==2) gl.glVertex2d(-y, x);
			else if(zone==3) gl.glVertex2d(-x, y);
			else if(zone==4) gl.glVertex2d(-x, -y);
			else if(zone==5) gl.glVertex2d(-y, -x);
			else if(zone==6) gl.glVertex2d(y, -x);
			else gl.glVertex2d(x, -y);

			gl.glEnd();

			if (d > 0) {
				d = d + iNE;
				y++;
			}
			else d = d + iE;
		}         
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