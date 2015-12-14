// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            ImageViewVignette

private class <init> extends android.view.ner
{

    final ImageViewVignette this$0;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return ImageViewVignette.this.onDown(motionevent);
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
        while (ImageViewVignette.access$200(ImageViewVignette.this).isInProgress() || motionevent1.getPointerCount() > 1 || motionevent.getPointerCount() > 1) 
        {
            return false;
        }
        return ImageViewVignette.this.onScroll(motionevent, motionevent1, f, f1);
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        return false;
    }

    private ()
    {
        this$0 = ImageViewVignette.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
