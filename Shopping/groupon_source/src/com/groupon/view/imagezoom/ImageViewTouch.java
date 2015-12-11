// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.imagezoom;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

// Referenced classes of package com.groupon.view.imagezoom:
//            ImageViewTouchBase

public class ImageViewTouch extends ImageViewTouchBase
{
    public class GestureListener extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final ImageViewTouch this$0;

        public boolean onDoubleTap(MotionEvent motionevent)
        {
            float f = getScale();
            f = onDoubleTapPost(f, getMaxScale());
            f = Math.min(getMaxScale(), Math.max(f, getMinScale()));
            zoomTo(f, motionevent.getX(), motionevent.getY(), 200F);
            invalidate();
            if (doubleTapListener != null)
            {
                doubleTapListener.onDoubleTap();
            }
            return super.onDoubleTap(motionevent);
        }

        public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            return ImageViewTouch.this.onFling(motionevent, motionevent1, f, f1);
        }

        public void onLongPress(MotionEvent motionevent)
        {
            if (isLongClickable() && !scaleDetector.isInProgress())
            {
                setPressed(true);
                performLongClick();
            }
        }

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            return ImageViewTouch.this.onScroll(motionevent, motionevent1, f, f1);
        }

        public boolean onSingleTapConfirmed(MotionEvent motionevent)
        {
            if (singleTapListener != null)
            {
                singleTapListener.onSingleTapConfirmed();
            }
            return super.onSingleTapConfirmed(motionevent);
        }

        public GestureListener()
        {
            this$0 = ImageViewTouch.this;
            super();
        }
    }

    public static interface OnImageViewTouchDoubleTapListener
    {

        public abstract void onDoubleTap();
    }

    public static interface OnImageViewTouchScaleListener
    {

        public abstract void onScale();
    }

    public static interface OnImageViewTouchSingleTapListener
    {

        public abstract void onSingleTapConfirmed();
    }

    public class ScaleListener extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
    {

        private boolean mScaled;
        final ImageViewTouch this$0;

        public boolean onScale(ScaleGestureDetector scalegesturedetector)
        {
            float f = scalegesturedetector.getCurrentSpan();
            float f2 = scalegesturedetector.getPreviousSpan();
            float f3 = getScale();
            float f4 = scalegesturedetector.getScaleFactor();
            if (userScaleListener != null)
            {
                userScaleListener.onScale();
            }
            if (mScaled && f - f2 != 0.0F)
            {
                float f1 = Math.min(getMaxScale(), Math.max(f3 * f4, getMinScale() - 0.1F));
                zoomTo(f1, scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
                doubleTapDirection = 1;
                invalidate();
            } else
            if (!mScaled)
            {
                mScaled = true;
                return true;
            }
            return true;
        }

        public ScaleListener()
        {
            this$0 = ImageViewTouch.this;
            super();
            mScaled = false;
        }
    }


    private int doubleTapDirection;
    private OnImageViewTouchDoubleTapListener doubleTapListener;
    private GestureDetector gestureDetector;
    private android.view.GestureDetector.OnGestureListener gestureListener;
    private ScaleGestureDetector scaleDetector;
    private float scaleFactor;
    private android.view.ScaleGestureDetector.OnScaleGestureListener scaleListener;
    private OnImageViewTouchSingleTapListener singleTapListener;
    private OnImageViewTouchScaleListener userScaleListener;

    public ImageViewTouch(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void _setImageDrawable(Drawable drawable, Matrix matrix, float f, float f1)
    {
        super._setImageDrawable(drawable, matrix, f, f1);
        scaleFactor = getMaxScale() / 3F;
    }

    protected android.view.GestureDetector.OnGestureListener getGestureListener()
    {
        return new GestureListener();
    }

    protected android.view.ScaleGestureDetector.OnScaleGestureListener getScaleListener()
    {
        return new ScaleListener();
    }

    protected void init()
    {
        super.init();
        gestureListener = getGestureListener();
        scaleListener = getScaleListener();
        scaleDetector = new ScaleGestureDetector(getContext(), scaleListener);
        gestureDetector = new GestureDetector(getContext(), gestureListener, null, true);
        doubleTapDirection = 1;
    }

    protected float onDoubleTapPost(float f, float f1)
    {
        if (doubleTapDirection == 1)
        {
            if (scaleFactor * 2.0F + f <= f1)
            {
                return f + scaleFactor;
            } else
            {
                doubleTapDirection = -1;
                return f1;
            }
        } else
        {
            doubleTapDirection = 1;
            return 1.0F;
        }
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (motionevent.getPointerCount() <= 1 && motionevent1.getPointerCount() <= 1 && !scaleDetector.isInProgress())
        {
            float f2 = motionevent1.getX();
            float f3 = motionevent.getX();
            float f4 = motionevent1.getY();
            float f5 = motionevent.getY();
            if (Math.abs(f) > 800F || Math.abs(f1) > 800F)
            {
                scrollBy((f2 - f3) / 2.0F, (f4 - f5) / 2.0F, 300D);
                invalidate();
                return true;
            }
        }
        return false;
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        while (motionevent == null || motionevent1 == null || motionevent.getPointerCount() > 1 || motionevent1.getPointerCount() > 1 || scaleDetector.isInProgress() || getScale() == 1.0F) 
        {
            return false;
        }
        scrollBy(-f, -f1);
        invalidate();
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        scaleDetector.onTouchEvent(motionevent);
        if (!scaleDetector.isInProgress())
        {
            gestureDetector.onTouchEvent(motionevent);
        }
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 1 1: default 56
    //                   1 58;
           goto _L1 _L2
_L1:
        return true;
_L2:
        if (getScale() < getMinScale())
        {
            zoomTo(getMinScale(), 50F);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onZoomAnimationCompleted(float f)
    {
        if (f < getMinScale())
        {
            zoomTo(getMinScale(), 50F);
        }
    }

    public void setDoubleTapListener(OnImageViewTouchDoubleTapListener onimageviewtouchdoubletaplistener)
    {
        doubleTapListener = onimageviewtouchdoubletaplistener;
    }

    public void setSingleTapListener(OnImageViewTouchSingleTapListener onimageviewtouchsingletaplistener)
    {
        singleTapListener = onimageviewtouchsingletaplistener;
    }

    public void setUserScaleListener(OnImageViewTouchScaleListener onimageviewtouchscalelistener)
    {
        userScaleListener = onimageviewtouchscalelistener;
    }






/*
    static int access$402(ImageViewTouch imageviewtouch, int i)
    {
        imageviewtouch.doubleTapDirection = i;
        return i;
    }

*/
}
