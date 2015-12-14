// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.view.ScaleGestureDetector;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            CropImageView

class this._cls0 extends android.view.leGestureListener
{

    final CropImageView this$0;

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        float f = scalegesturedetector.getCurrentSpan();
        float f2 = scalegesturedetector.getPreviousSpan();
        float f3 = getScale();
        float f4 = scalegesturedetector.getScaleFactor();
        if (f - f2 != 0.0F)
        {
            float f1 = Math.min(getMaxScale(), Math.max(f3 * f4, 1.0F));
            CropImageView.access$1100(CropImageView.this, f1, scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
            CropImageView.access$1202(CropImageView.this, 1);
            invalidate();
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        return super.onScaleBegin(scalegesturedetector);
    }

    public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
        super.onScaleEnd(scalegesturedetector);
    }

    ()
    {
        this$0 = CropImageView.this;
        super();
    }
}
