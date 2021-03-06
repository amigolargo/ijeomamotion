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

package ijeoma.geom.tween;

import ijeoma.geom.Curve;
import ijeoma.motion.event.MotionEvent;
import ijeoma.motion.tween.Tween;

import java.lang.reflect.Method;

import processing.core.PApplet;
import processing.core.PVector;

public class CurveTween extends Tween { // implements Comparable {
	private Method tweenCurveStartedMethod, tweenCurveEndedMethod,
			tweenCurveChangedMethod, tweenCurveRepeatedMethod;

	private Curve curve;

	public CurveTween(Curve _path, float _begin, float _end,
			float _duration, float _delay, String _easing) {
		super(_duration, _delay, _easing);
		setupCurve(_path);
	}

	public CurveTween(Curve _path, float _begin, float _end,
			float _duration, float _delay) {
		super(_duration, _delay);
		setupCurve(_path);
	}

	public CurveTween(Curve _path, float _begin, float _end, float _duration) {
		super(_duration);
		setupCurve(_path);
	}

	protected void setupCurve(Curve _curve) {
		curve = _curve;
	}

	/**
	 * Sets the events
	 */
	@Override
	protected void setupEvents() {
		super.setupEvents();

		Class<? extends PApplet> parentClass = parent.getClass();

		try {
			tweenCurveStartedMethod = parentClass.getMethod(
					MotionEvent.TWEEN_STARTED,
					new Class[] { CurveTween.class });
		} catch (Exception e) {
		}

		try {
			tweenCurveEndedMethod = parentClass
					.getMethod(MotionEvent.TWEEN_ENDED,
							new Class[] { CurveTween.class });
		} catch (Exception e) {
		}

		try {
			tweenCurveChangedMethod = parentClass.getMethod(
					MotionEvent.TWEEN_CHANGED,
					new Class[] { CurveTween.class });
		} catch (Exception e) {
		}

		try {
			tweenCurveRepeatedMethod = parentClass.getMethod(
					MotionEvent.TWEEN_REPEATED,
					new Class[] { CurveTween.class });
		} catch (Exception e) {
		}
	}

	public PVector getPoint() {
		return curve.getPoint(getPosition());
	}

	public float getX() {
		return getPoint().x;
	}

	public float getY() {
		return getPoint().y;
	}

	public float getZ() {
		return getPoint().y;
	}

	public void setCurve(Curve _curve) {
		curve = _curve;
	}

	public Curve getCurve() {
		return curve;
	}

	@Override
	protected void dispatchMotionStartedEvent() {
		if (tweenCurveStartedMethod != null) {
			try {
				tweenCurveStartedMethod.invoke(parent, new Object[] { this });
			} catch (Exception e) {
				// e.printStackTrace();
				tweenCurveStartedMethod = null;
			}
		}

		dispatchEvent(MotionEvent.TWEEN_STARTED);
	}

	@Override
	protected void dispatchMotionEndedEvent() {
		if (tweenCurveEndedMethod != null) {
			try {
				tweenCurveEndedMethod.invoke(parent, new Object[] { this });
			} catch (Exception e) {
				e.printStackTrace();
				tweenCurveEndedMethod = null;
			}
		}

		dispatchEvent(MotionEvent.TWEEN_ENDED);
	}

	@Override
	protected void dispatchMotionChangedEvent() {
		if (tweenCurveChangedMethod != null) {
			try {
				tweenCurveChangedMethod.invoke(parent, new Object[] { this });
			} catch (Exception e) {
				// e.printStackTrace();
				tweenCurveChangedMethod = null;
			}
		}

		dispatchEvent(MotionEvent.TWEEN_CHANGED);
	}

	@Override
	protected void dispatchMotionRepeatedEvent() {
		if (tweenCurveRepeatedMethod != null) {
			try {
				tweenCurveRepeatedMethod.invoke(parent, new Object[] { this });
			} catch (Exception e) {
				// e.printStackTrace();
				tweenCurveRepeatedMethod = null;
			}
		}

		dispatchEvent(MotionEvent.TWEEN_REPEATED);
	}
}
