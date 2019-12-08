package DDALines;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author Amirul Islam
 */
public class DDALines implements GLEventListener {
	private GLU glu;
	
	@Override
	public void init(GLAutoDrawable gld) {
		GL2 gl = gld.getGL().getGL2();
		glu = new GLU();

		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		gl.glViewport(0, 100, 350, 250);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluOrtho2D(-250.0, 100.0, -350.0, 250.0);
	}

	/**
	 * Take care of drawing here.
	 * @param drawable
	 */
	@Override
	public void display(GLAutoDrawable drawable) {
		double x=-140;
		double y=-50;
		double x1=40;
		double y1=100;
		double s=0;
		double dx= x1-x;
		double dy= y1-y;
		dx= Math.abs(dx);
		dy = Math.abs(dy);

		if(dy>dx) s=dy;
		else s=dx;
		double xin=dx/s, yin=dy/s;
		GL2 gl = drawable.getGL().getGL2();

		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

		DDA(gl, x,y);
		double i=0;
		while(i<s) {

			x=xin+x;
			y=yin+y;
			i++;
			DDA(gl, x,y);
		}


	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		//do nothing
	}

	public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
		//do nothing
	}

	private void DDA(GL2 gl, double x, double y) {
		//write your own code
		gl.glPointSize(3.0f);
		gl.glColor3d(0, 1, 1);
		gl.glBegin(GL2.GL_POINTS);

		gl.glVertex2d(x, y);
		//gl.glVertex2d(x2, y2);	
		gl.glEnd();
	}

	public void dispose(GLAutoDrawable arg0) {
		//do nothing
	}
}

