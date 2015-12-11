// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.imagezoom;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

// Referenced classes of package com.groupon.view.imagezoom:
//            ImageViewTouch

public class > extends android.view.Listener
{

    final ImageViewTouch this$0;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        float f = getScale();
        f = onDoubleTapPost(f, getMaxScale());
        f = Math.min(getMaxScale(), Math.max(f, getMinScale()));
        zoomTo(f, motionevent.getX(), motionevent.getY(), 200F);
        invalidate();
        if (ImageViewTouch.access$100(ImageViewTouch.this) != null)
        {
            ImageViewTouch.access$100(ImageViewTouch.this).onDoubleTap();
        }
        return super.onDoubleTap(motionevent);
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return ImageViewTouch.this.onFling(motionevent, motionevent1, f, f1);
    }

    public void onLongPress(MotionEvent motionevent)
    {
        if (isLongClickable() && !ImageViewTouch.access$200(ImageViewTouch.this).isInProgress())
        {
            setPressed(true);
            performLongClick();
        }
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return ImageViewTouch.this.onScroll(motionevent, motionevent1, f, f1);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        if (ImageViewTouch.access$000(ImageViewTouch.this) != null)
        {
            ImageViewTouch.access$000(ImageViewTouch.this).onSingleTapConfirmed();
        }
        return super.onSingleTapConfirmed(motionevent);
    }

    public SingleTapListener()
    {
        this$0 = ImageViewTouch.this;
        super();
    }
}
