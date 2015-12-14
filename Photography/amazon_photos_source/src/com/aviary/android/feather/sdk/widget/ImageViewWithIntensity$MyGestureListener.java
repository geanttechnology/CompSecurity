// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.view.MotionEvent;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            ImageViewWithIntensity

private class <init> extends android.view.ensity.MyGestureListener
{

    final ImageViewWithIntensity this$0;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return ImageViewWithIntensity.this.onDown(motionevent);
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return false;
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return ImageViewWithIntensity.this.onScroll(motionevent, motionevent1, f, f1);
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        return false;
    }

    private ()
    {
        this$0 = ImageViewWithIntensity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
