package line_draw;

import java.io.File;
import java.util.Scanner;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author Amirul Islam
 */
public class Points implements GLEventListener {

	private GLU glu;
	@Override
	public void init(GLAutoDrawable gld) {
		GL2 gl = gld.getGL().getGL2();
		glu = new GLU();
	}

	@Override
	public void dispose(GLAutoDrawable glad) {

	}

	@Override
	public void display(GLAutoDrawable drawable) {
		double x=0;
		double y=0;
		double z=0;
		double x1=0;
		double y1=0;
		double z1=0;


		Scanner sc=null;
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		gl.glPointSize(14.0f);
		gl.glColor3d(1, 0, 0);

		gl.glBegin(GL2.GL_LINES);
		try {
			sc = new Scanner(new File("C:\\Users\\17101537\\Documents\\value.txt"));
			while(sc.hasNext()) {
				x =sc.nextDouble();
				y =sc.nextDouble();
				z =sc.nextDouble();
				x1 =sc.nextDouble();
				y1 =sc.nextDouble();
				z1 =sc.nextDouble();
				gl.glVertex3d(x, y,z); 
				gl.glVertex3d(x1, y1,z1); 
			}
			gl.glEnd();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {

	}

}
