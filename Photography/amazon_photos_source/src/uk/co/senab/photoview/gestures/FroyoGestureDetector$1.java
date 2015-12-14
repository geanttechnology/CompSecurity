// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview.gestures;

import android.view.ScaleGestureDetector;

// Referenced classes of package uk.co.senab.photoview.gestures:
//            FroyoGestureDetector, OnGestureListener

class this._cls0
    implements android.view.ScaleGestureListener
{

    final FroyoGestureDetector this$0;

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        float f = scalegesturedetector.getScaleFactor();
        if (Float.isNaN(f) || Float.isInfinite(f))
        {
            return false;
        } else
        {
            mListener.onScale(f, scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
            return true;
        }
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
    }

    er()
    {
        this$0 = FroyoGestureDetector.this;
        super();
    }
}
