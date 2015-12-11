// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.imageview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

// Referenced classes of package com.amazon.mShop.imageview:
//            MShopScaleGestoreDetector

private static class _cls1
    implements reDetector
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

    public _cls1.this._cls0(Context context, android.view.eListener elistener)
    {
        mDetector = new ScaleGestureDetector(context, elistener) {

            final MShopScaleGestoreDetector.FroyoDetector this$0;

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
                this$0 = MShopScaleGestoreDetector.FroyoDetector.this;
                super(context, onscalegesturelistener);
            }
        };
    }
}
