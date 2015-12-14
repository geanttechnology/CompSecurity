// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ScaleGestureDetector;
import wantu.sephiroth.android.library.imagezoom.ImageViewTouch;

public class ait extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
{

    final ImageViewTouch a;

    public ait(ImageViewTouch imageviewtouch)
    {
        a = imageviewtouch;
        super();
    }

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        scalegesturedetector.getCurrentSpan();
        scalegesturedetector.getPreviousSpan();
        float f = a.mCurrentScaleFactor;
        float f1 = scalegesturedetector.getScaleFactor();
        if (a.mScaleEnabled)
        {
            f = Math.min(a.getMaxZoom(), Math.max(f * f1, a.MIN_ZOOM));
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)a.getLayoutParams();
            a.zoomTo(f, scalegesturedetector.getFocusX() - (float)layoutparams.leftMargin, scalegesturedetector.getFocusY() - (float)layoutparams.topMargin);
            a.mCurrentScaleFactor = Math.min(a.getMaxZoom(), Math.max(f, a.MIN_ZOOM));
            a.mDoubleTapDirection = 1;
            a.invalidate();
            return true;
        } else
        {
            return false;
        }
    }
}
