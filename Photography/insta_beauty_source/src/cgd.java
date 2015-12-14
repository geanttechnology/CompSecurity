// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.ScaleGestureDetector;
import wantu.sephiroth.android.library.imagezoom.ImageViewTouch;

public class cgd extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
{

    final ImageViewTouch a;

    public cgd(ImageViewTouch imageviewtouch)
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
            a.zoomTo(f, scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
            Log.v("ImageViewTouch", (new StringBuilder()).append("ImageViewTouch ScaleListener targetScale:").append(f).toString());
            Log.v("ImageViewTouch", (new StringBuilder()).append("ImageViewTouch ScaleListener detectorX :").append(scalegesturedetector.getFocusX()).toString());
            Log.v("ImageViewTouch", (new StringBuilder()).append("ImageViewTouch ScaleListener detectorY :").append(scalegesturedetector.getFocusY()).toString());
            a.mCurrentScaleFactor = Math.min(a.getMaxZoom(), Math.max(f, a.MIN_ZOOM));
            Log.v("ImageViewTouch", (new StringBuilder()).append("ImageViewTouch ScaleListener mCurrentScaleFactor :").append(a.mCurrentScaleFactor).toString());
            a.mDoubleTapDirection = 1;
            a.invalidate();
            return true;
        } else
        {
            return false;
        }
    }
}
