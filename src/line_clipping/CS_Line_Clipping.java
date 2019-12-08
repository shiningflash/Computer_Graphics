package line_clipping;

public class CS_Line_Clipping {
	
	int left = 1, right = 2, below = 4, above = 8;
	int xmin, xmax, ymin, ymax;
	
	public CS_Line_Clipping() {}
	
	public CS_Line_Clipping(int xmin, int xmax, int ymin, int ymax) {
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
	}

	int computeOutCode(int x, int y) {
		int outcode = 0;  
		if (x < xmin) outcode =outcode | left;
		else if (x > xmax) outcode =outcode | right;
		if (y < ymin) outcode = outcode | below;
		else if (y > ymax) outcode= outcode | above;
		return outcode;
	}
	
	void drawRectangle(int xmin, int ymin, int xmax, int ymax) {
		
	}
	
	void drawLine(int x0, int y0, int x1, int y1) {
		//DDALines(x0, y0, x1, y1);
	}

	int[] CohenSutherlandLineClipAndDraw(int x0, int y0, int x1, int y1) {
		int outcode0 = computeOutCode(x0, y0);
		int outcode1 = computeOutCode(x1, y1);
		boolean accept = false;
	 
		while (true) {
			if ((outcode0 | outcode1)==0) {
				accept = true;
				break;
			}
			else if ((outcode0 & outcode1)!=0) {
				accept = false;
				break;
			}
			else {
				double x = 0, y = 0;
				int outcodeOut = outcode0 != 0 ? outcode0 : outcode1;
	 
				if ((outcodeOut & above) >= 1) {      			
					x = x0 + (x1 - x0) * (ymax - y0) / (y1 - y0);
					y = ymax;
				}
				else if ((outcodeOut & below) >= 1) { 		
					x = x0 + (x1 - x0) * (ymin - y0) / (y1 - y0);
					y = ymin;
				}
				else if ((outcodeOut & right) >= 1) {
					y = y0 + (y1 - y0) * (xmax - x0) / (x1 - x0);
					x = xmax;
				}
				else if ((outcodeOut & left) >= 1) {   
					y = y0 + (y1 - y0) * (xmin - x0) / (x1 - x0);
					x = xmin;
				}
				if (outcodeOut == outcode0) {
					x0 = (int) x;
					y0 = (int) y;
					outcode0 = computeOutCode(x0, y0);
				} else {
					x1 = (int) x;
					y1 = (int) y;
					outcode1 = computeOutCode(x1, y1);
				}
			}
		}
		if (accept) {
			drawRectangle(xmin, ymin, xmax, ymax);
			drawLine(x0, y0, x1, y1);
			return new int[] {x0, y0, x1, y1};
		}
		return new int[] {x0, y0, x1, y1};
	}

}
