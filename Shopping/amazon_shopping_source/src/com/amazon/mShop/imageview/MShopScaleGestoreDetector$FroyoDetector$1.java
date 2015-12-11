// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.imageview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

// Referenced classes of package com.amazon.mShop.imageview:
//            MShopScaleGestoreDetector

class this._cls0 extends ScaleGestureDetector
{

    final this._cls0 this$0;

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

    (Context context, android.view.r r)
    {
        this$0 = this._cls0.this;
        super(context, r);
    }
}
