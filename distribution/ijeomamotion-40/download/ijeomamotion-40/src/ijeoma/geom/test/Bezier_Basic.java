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

package ijeoma.geom.test;

import ijeoma.geom.Bezier;
import processing.core.PApplet;

public class Bezier_Basic extends PApplet {

	Bezier b;

	@Override
	public void setup() {
		size(100, 100);
		smooth();

		b = new Bezier (g, 85, 20, 10, 10, 90, 90, 15, 80);
	}

	@Override
	public void draw() {
		background(255);

		noFill();
		b.draw();
	}
}
