// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.view.ScaleGestureDetector;

// Referenced classes of package com.aio.downloader.views:
//            TouchImageView

private class <init> extends android.view.ScaleGestureListener
{

    final TouchImageView this$0;

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        TouchImageView.access$20(TouchImageView.this, scalegesturedetector.getScaleFactor(), scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY(), true);
        if (TouchImageView.access$19(TouchImageView.this) != null)
        {
            TouchImageView.access$19(TouchImageView.this).onMove();
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        TouchImageView.access$10(TouchImageView.this, this._fld0);
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
        float f;
        boolean flag;
        super.onScaleEnd(scalegesturedetector);
        TouchImageView.access$10(TouchImageView.this, this._fld0);
        flag = false;
        f = TouchImageView.access$5(TouchImageView.this);
        if (TouchImageView.access$5(TouchImageView.this) <= TouchImageView.access$7(TouchImageView.this)) goto _L2; else goto _L1
_L1:
        f = TouchImageView.access$7(TouchImageView.this);
        flag = true;
_L4:
        if (flag)
        {
            scalegesturedetector = new <init>(TouchImageView.this, f, TouchImageView.access$11(TouchImageView.this) / 2, TouchImageView.access$14(TouchImageView.this) / 2, true);
            TouchImageView.access$3(TouchImageView.this, scalegesturedetector);
        }
        return;
_L2:
        if (TouchImageView.access$5(TouchImageView.this) < TouchImageView.access$6(TouchImageView.this))
        {
            f = TouchImageView.access$6(TouchImageView.this);
            flag = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private ewListener()
    {
        this$0 = TouchImageView.this;
        super();
    }

    Listener(Listener listener)
    {
        this();
    }
}
