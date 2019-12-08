package advance_application1;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author Amirul Islam
 */
public class Special_Symbol implements GLEventListener {
	private GLU glu;
	
	@Override
	public void init(GLAutoDrawable gld) {
		GL2 gl = gld.getGL().getGL2();
		glu = new GLU();

		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		gl.glViewport(-350, -250, 350, 350);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluOrtho2D(-150.0, 150.0, -150.0, 150.0);
	}

	/**
	 * Take care of drawing here.
	 * @param drawable
	 */
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();

		Line(gl, 0, 50, 25, 25);
		Line(gl, 25, 25, -25, -25);
		Line(gl, -25, -25, 0, -50);
		Line(gl, -25, 25, -50, 0);
		Line(gl, -25, 25, 0, 0);
		Line(gl, 0, 0, 25, -25);
		Line(gl, 50, 0, 25, -25);
	}
	
	private void Line(GL2 gl, double x, double y, double x1, double y1) {
		if (y1 > y) {
			double s=0;
			double dx= x1-x;
			double dy= y1-y;
			//dx = Math.abs(dx);
			//dy = Math.abs(dy);

			if(dy>dx) s=dy;
			else s=dx;
			double xin=dx/s, yin=dy/s;

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
		else {
			double s=0;
			double dx= x-x1;
			double dy= y-y1;
			dx = (dx);
			dy = (dy);
			//dx= Math.abs(dx);
			//dy = Math.abs(dy);

			if(dy>dx) s=dy;
			else s=dx;
			double xin=dx/s, yin=dy/s;

			//gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

			DDA(gl, x1,y1);
			double i=0;
			while(i<s) {

				x1=xin+x1;
				y1=yin+y1;
				i++;
				DDA(gl, x1,y1);
			}
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
		gl.glPointSize(5.0f);
		gl.glColor3d(0, 2, 2);
		gl.glBegin(GL2.GL_POINTS);

		gl.glVertex2d(x, y);
		//gl.glVertex2d(x2, y2);	
		gl.glEnd();
	}

	public void dispose(GLAutoDrawable arg0) {
		//do nothing
	}
}

