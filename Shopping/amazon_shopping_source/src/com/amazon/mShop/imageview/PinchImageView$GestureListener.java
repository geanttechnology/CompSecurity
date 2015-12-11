// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.imageview;

import android.view.MotionEvent;

// Referenced classes of package com.amazon.mShop.imageview:
//            PinchImageView

class > extends android.view.Listener
{

    final PinchImageView this$0;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        float f = getScale();
        f = onDoubleTapPost(f, 4F);
        zoomTo(f, motionevent.getX(), motionevent.getY());
        invalidate();
        return super.onDoubleTap(motionevent);
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        while (motionevent == null || motionevent1 == null || motionevent.getPointerCount() > 1 || motionevent1.getPointerCount() > 1 || PinchImageView.access$000(PinchImageView.this).isInProgress() || getScale() <= 1.0F) 
        {
            return false;
        }
        scrollBy(-f, -f1);
        invalidate();
        return super.onScroll(motionevent, motionevent1, f, f1);
    }

    onedGestureDetector()
    {
        this$0 = PinchImageView.this;
        super();
    }
}
