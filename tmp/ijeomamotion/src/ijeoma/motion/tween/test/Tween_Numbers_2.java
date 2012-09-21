package ijeoma.motion.tween.test;

import ijeoma.motion.Motion;
import ijeoma.motion.tween.Tween;
import processing.core.PApplet;
import processing.core.PFont;

public class Tween_Numbers_2 extends PApplet {
	PFont f;

	Tween t;
	Rect r;

	@Override
	public void setup() {
		size(400, 400);
		smooth();

		f = createFont("Arial", 12);

		Motion.setup(this);

		r = new Rect();

		t = new Tween(100).add(r, "y", 400).play();

		// The above could also be written as
		// t = new Tween(r, "x", 400, 100).add(r, "y", 400).play();
	}

	@Override
	public void draw() {
		background(255);

		r.draw();

		String time = t.getTime() + " / " + t.getDuration();
		fill(0);
		text(time, width - textWidth(time) - 10, height - 10);
	}

	@Override
	public void keyPressed() {
		t.play();
	}

	public class Rect {
		public float x, y;

		void draw() {
			noStroke();
			fill(255 / 2f);
			rect(x, y, 50, 50);
		}
	}
}