/**
 * ijeomamotion
 * A library for sketching animations with numbers, colors vectors, beziers, curves and more! 
 * http://ekeneijeoma.com/processing/ijeomamotion/
 *
 * Copyright (C) 2012 Ekene Ijeoma http://ekeneijeoma.com
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      Ekene Ijeoma http://ekeneijeoma.com
 * @modified    10/30/2012
 * @version     4 (40)
 */

package ijeoma.geom;

import processing.core.PGraphics;
import processing.core.PVector;

public class Curve {
	PGraphics g;
	float x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4;
	boolean is3D = false;

	public Curve(PGraphics _g, float _x1, float _y1, float _x2, float _y2,
			float _x3, float _y3, float _x4, float _y4) {
		g = _g;

		x1 = _x1;
		y1 = _y1;

		x2 = _x2;
		y2 = _y2;

		x3 = _x3;
		y3 = _y3;

		x4 = _x4;
		y4 = _y4;
	}

	public Curve(PGraphics _g, float _x1, float _y1, float _z1, float _x2,
			float _y2, float _z2, float _x3, float _y3, float _z3, float _x4,
			float _y4, float _z4) {
		g = _g;

		x1 = _x1;
		y1 = _y1;
		z1 = _z1;

		x2 = _x2;
		y2 = _y2;
		z2 = _z2;

		x3 = _x3;
		y3 = _y3;
		z3 = _z3;

		x4 = _x4;
		y4 = _y4;
		z4 = _z4;

		is3D = true;
	}

	public void draw() {
		if (is3D)
			g.curve(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
		else
			g.curve(x1, y1, x2, y2, x3, y3, x4, y4);
	}

	public PVector getPoint(float _position) {
		float x = g.curvePoint(x1, x2, x3, x4, _position);
		float y = g.curvePoint(y1, y2, y3, y4, _position);

		if (is3D) {
			float z = g.curvePoint(z1, z2, z3, z4, _position);
			return new PVector(x, y, z);
		} else
			return new PVector(x, y);
	}
}
