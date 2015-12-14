// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.view.ScaleGestureDetector;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            ImageViewSpotSingleTap

class this._cls0 extends it.sephiroth.android.library.imagezoom.his._cls0
{

    final ImageViewSpotSingleTap this$0;

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        if (mTouchMode == this._fld0)
        {
            mX = scalegesturedetector.getFocusX();
            mY = scalegesturedetector.getFocusY();
            postInvalidate();
            return true;
        } else
        {
            return super._mth0(scalegesturedetector);
        }
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        if (mTouchMode == this._fld0)
        {
            mX = scalegesturedetector.getFocusX();
            mY = scalegesturedetector.getFocusY();
            mStartX = mX;
            mStartY = mY;
            mCanceled = true;
            postInvalidate();
            return true;
        } else
        {
            return super.n(scalegesturedetector);
        }
    }

    public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
        mCanceled = false;
        super.n(scalegesturedetector);
    }

    ()
    {
        this$0 = ImageViewSpotSingleTap.this;
        super(ImageViewSpotSingleTap.this);
    }
}
