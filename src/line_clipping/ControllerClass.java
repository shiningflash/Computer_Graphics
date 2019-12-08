package line_clipping;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class ControllerClass {

	public static void main(String[] args) {
		  //getting the capabilities object of GL2 profile        
	      final GLProfile profile = GLProfile.get(GLProfile.GL2);
	      GLCapabilities capabilities = new GLCapabilities(profile);
	      // The canvas
	      final GLCanvas glcanvas = new GLCanvas(capabilities);  
		
	      // create rectangle
		  int xmin = 10, xmax = 100, ymin = 10, ymax = 100;
		  DDALines drawing = new DDALines(0, xmin, xmax, ymin, ymax);		  
		  CS_Line_Clipping line = new CS_Line_Clipping(xmin, xmax, ymin, ymax);
		  
		  // line clip
		  int a[] = line.CohenSutherlandLineClipAndDraw(0, 0, 200, 300);
		  drawing = new DDALines(a[0], a[1], a[2], a[3]);
		  glcanvas.addGLEventListener(drawing);
		  
		  
	      glcanvas.setSize(400, 400);
		  JFrame frame = new JFrame ("straight Line");
		  frame.getContentPane().add(glcanvas);                 
		  frame.setSize(frame.getContentPane().getPreferredSize());
		  frame.setVisible(true);
	}

}
