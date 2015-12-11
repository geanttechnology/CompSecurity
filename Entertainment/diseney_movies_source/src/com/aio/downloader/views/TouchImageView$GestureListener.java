// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.view.MotionEvent;

// Referenced classes of package com.aio.downloader.views:
//            TouchImageView

private class <init> extends android.view.Listener
{

    final TouchImageView this$0;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        boolean flag = false;
        if (TouchImageView.access$0(TouchImageView.this) != null)
        {
            flag = TouchImageView.access$0(TouchImageView.this).onDoubleTap(motionevent);
        }
        if (TouchImageView.access$4(TouchImageView.this) == this._fld0)
        {
            float f;
            if (TouchImageView.access$5(TouchImageView.this) == TouchImageView.access$6(TouchImageView.this))
            {
                f = TouchImageView.access$7(TouchImageView.this);
            } else
            {
                f = TouchImageView.access$6(TouchImageView.this);
            }
            motionevent = new nit>(TouchImageView.this, f, motionevent.getX(), motionevent.getY(), false);
            TouchImageView.access$3(TouchImageView.this, motionevent);
            flag = true;
        }
        return flag;
    }

    public boolean onDoubleTapEvent(MotionEvent motionevent)
    {
        if (TouchImageView.access$0(TouchImageView.this) != null)
        {
            return TouchImageView.access$0(TouchImageView.this).onDoubleTapEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (TouchImageView.access$1(TouchImageView.this) != null)
        {
            TouchImageView.access$1(TouchImageView.this).g();
        }
        TouchImageView.access$2(TouchImageView.this, new this._cls0(TouchImageView.this, (int)f, (int)f1));
        TouchImageView.access$3(TouchImageView.this, TouchImageView.access$1(TouchImageView.this));
        return super.onFling(motionevent, motionevent1, f, f1);
    }

    public void onLongPress(MotionEvent motionevent)
    {
        performLongClick();
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        if (TouchImageView.access$0(TouchImageView.this) != null)
        {
            return TouchImageView.access$0(TouchImageView.this).onSingleTapConfirmed(motionevent);
        } else
        {
            return performClick();
        }
    }

    private ()
    {
        this$0 = TouchImageView.this;
        super();
    }

    it>(it> it>)
    {
        this();
    }
}
