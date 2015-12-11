// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.media;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

// Referenced classes of package com.amazon.now.media:
//            PinchImageView

class r extends ScaleGestureDetector
{

    final PinchImageView this$0;

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

    r(Context context, android.view.tor.OnScaleGestureListener onscalegesturelistener)
    {
        this$0 = PinchImageView.this;
        super(context, onscalegesturelistener);
    }
}
