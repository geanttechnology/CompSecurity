// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

// Referenced classes of package uk.co.senab.photoview.gestures:
//            EclairGestureDetector

public class FroyoGestureDetector extends EclairGestureDetector
{

    protected final ScaleGestureDetector mDetector;

    public FroyoGestureDetector(Context context)
    {
        super(context);
        mDetector = new ScaleGestureDetector(context, new _cls1());
    }

    public boolean isScaling()
    {
        return mDetector.isInProgress();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        mDetector.onTouchEvent(motionevent);
        return super.onTouchEvent(motionevent);
    }

    private class _cls1
        implements android.view.ScaleGestureDetector.OnScaleGestureListener
    {

        final FroyoGestureDetector this$0;

        public boolean onScale(ScaleGestureDetector scalegesturedetector)
        {
            mListener.onScale(scalegesturedetector.getScaleFactor(), scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
        {
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
        {
        }

        _cls1()
        {
            this$0 = FroyoGestureDetector.this;
            super();
        }
    }

}
