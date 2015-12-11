// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.imageview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public class MShopScaleGestoreDetector
{
    private static class EclairDetector
        implements VersionedGestureDetector
    {

        public boolean isInProgress()
        {
            return false;
        }

        public boolean onTouchEvent(MotionEvent motionevent)
        {
            return false;
        }

        private EclairDetector()
        {
        }

    }

    private static class FroyoDetector
        implements VersionedGestureDetector
    {

        private ScaleGestureDetector mDetector;

        public boolean isInProgress()
        {
            return mDetector.isInProgress();
        }

        public boolean onTouchEvent(MotionEvent motionevent)
        {
            mDetector.onTouchEvent(motionevent);
            return false;
        }

        public FroyoDetector(Context context, android.view.ScaleGestureDetector.SimpleOnScaleGestureListener simpleonscalegesturelistener)
        {
            mDetector = new _cls1(context, simpleonscalegesturelistener);
        }
    }

    public static interface VersionedGestureDetector
    {

        public abstract boolean isInProgress();

        public abstract boolean onTouchEvent(MotionEvent motionevent);
    }


    public MShopScaleGestoreDetector()
    {
    }

    public static VersionedGestureDetector newInstance(Context context, android.view.ScaleGestureDetector.SimpleOnScaleGestureListener simpleonscalegesturelistener)
    {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) < 8)
        {
            return new EclairDetector();
        } else
        {
            return new FroyoDetector(context, simpleonscalegesturelistener);
        }
    }

    // Unreferenced inner class com/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector$1

/* anonymous class */
    class FroyoDetector._cls1 extends ScaleGestureDetector
    {

        final FroyoDetector this$0;

        public boolean onTouchEvent(MotionEvent motionevent)
        {
            if (motionevent.getPointerCount() >= 2)
            {
                return super.onTouchEvent(motionevent);
            } else
            {
                return false;
            }
        }

            
            {
                this$0 = FroyoDetector.this;
                super(context, onscalegesturelistener);
            }
    }

}
