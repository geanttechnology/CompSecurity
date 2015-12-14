// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import wantu.sephiroth.android.library.imagezoom.ImageViewTouch;

public class aip extends android.view.GestureDetector.SimpleOnGestureListener
{

    final ImageViewTouch a;

    public aip(ImageViewTouch imageviewtouch)
    {
        a = imageviewtouch;
        super();
    }

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        Log.i("image", (new StringBuilder()).append("onDoubleTap. double tap enabled? ").append(a.mDoubleTapToZoomEnabled).toString());
        if (a.mDoubleTapToZoomEnabled)
        {
            float f = a.getScale();
            f = a.onDoubleTapPost(f, a.getMaxZoom());
            f = Math.min(a.getMaxZoom(), Math.max(f, a.MIN_ZOOM));
            a.mCurrentScaleFactor = f;
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)a.getLayoutParams();
            a.zoomTo(f, motionevent.getX() - (float)layoutparams.leftMargin, motionevent.getY() - (float)layoutparams.topMargin, 200F);
            a.invalidate();
        }
        if (ImageViewTouch.access$100(a) != null)
        {
            ImageViewTouch.access$100(a).a();
        }
        return super.onDoubleTap(motionevent);
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        while (!a.mScrollEnabled || motionevent.getPointerCount() > 1 || motionevent1.getPointerCount() > 1 || a.mScaleDetector.isInProgress()) 
        {
            return false;
        }
        float f2 = motionevent1.getX();
        float f3 = motionevent.getX();
        float f4 = motionevent1.getY();
        float f5 = motionevent.getY();
        if (Math.abs(f) > 800F || Math.abs(f1) > 800F)
        {
            a.scrollBy((f2 - f3) / 2.0F, (f4 - f5) / 2.0F, 300D);
            a.invalidate();
        }
        return super.onFling(motionevent, motionevent1, f, f1);
    }

    public void onLongPress(MotionEvent motionevent)
    {
        if (a.isLongClickable() && !a.mScaleDetector.isInProgress())
        {
            if (ImageViewTouch.access$200(a) != null)
            {
                ImageViewTouch.access$200(a).onLongPress();
            }
            a.setPressed(true);
            a.performLongClick();
        }
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (ImageViewTouch.access$300(a))
        {
            ImageViewTouch.access$302(a, false);
        } else
        if (a.mScrollEnabled && motionevent != null && motionevent1 != null && motionevent.getPointerCount() <= 1 && motionevent1.getPointerCount() <= 1 && !a.mScaleDetector.isInProgress())
        {
            a.scrollBy(-f, -f1);
            a.invalidate();
            return super.onScroll(motionevent, motionevent1, f, f1);
        }
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        if (ImageViewTouch.access$000(a) != null)
        {
            ImageViewTouch.access$000(a).onSingleTap();
        }
        a.performClick();
        return super.onSingleTapConfirmed(motionevent);
    }
}
