package line_clipping;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class DDALines implements GLEventListener {

    private GLU glu;
    int x0, y0, x1, y1;
    int xmin = 10, xmax = 100, ymin = 10, ymax = 100;

    public DDALines(int x, int xmin, int xmax, int ymin, int ymax) {
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
	}
    
    public DDALines(int x0, int y0, int x1, int y1) {
    	this.x0 = x0;
    	this.y0 = y0;
    	this.x1 = x1;
    	this.y1 = y1;
    }
    
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

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        DDA(gl, xmin, ymin, xmax, ymin);
		DDA(gl, xmin, ymin, xmin, ymax);
		DDA(gl, xmin, ymax, xmax, ymax);
		DDA(gl, xmax, ymin, xmax, ymax);
        DDA(gl, x0, y0, x1, y1);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //do nothing
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        //do nothing
    }
    private void DDA(GL2 gl, int x1, int y1, int x2, int y2) {
       double dx = x2 - x1;
       double dy = y2 - y1;
       double length = Math.max(dx,  dy);
       double Xin = dx / length;
       double Yin = dy / length;
       double X = x1, Y = y1;
       gl.glBegin(GL2.GL_POINTS);
       for (int i = 0; i < length; i++) {
    	   X += Xin;
    	   Y += Yin;
    	   gl.glPointSize(1.0f);
           gl.glColor3d(1, 0, 0);
           gl.glVertex2d(X, Y);	
       }
       gl.glEnd();
    }
    
    public void dispose(GLAutoDrawable arg0) {
        //do nothing
    }
}
