// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.imagezoom;

import android.view.ScaleGestureDetector;

// Referenced classes of package com.groupon.view.imagezoom:
//            ImageViewTouch

public class mScaled extends android.view.ScaleGestureListener
{

    private boolean mScaled;
    final ImageViewTouch this$0;

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        float f = scalegesturedetector.getCurrentSpan();
        float f2 = scalegesturedetector.getPreviousSpan();
        float f3 = getScale();
        float f4 = scalegesturedetector.getScaleFactor();
        if (ImageViewTouch.access$300(ImageViewTouch.this) != null)
        {
            ImageViewTouch.access$300(ImageViewTouch.this).onScale();
        }
        if (mScaled && f - f2 != 0.0F)
        {
            float f1 = Math.min(getMaxScale(), Math.max(f3 * f4, getMinScale() - 0.1F));
            zoomTo(f1, scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
            ImageViewTouch.access$402(ImageViewTouch.this, 1);
            invalidate();
        } else
        if (!mScaled)
        {
            mScaled = true;
            return true;
        }
        return true;
    }

    public chScaleListener()
    {
        this$0 = ImageViewTouch.this;
        super();
        mScaled = false;
    }
}
