// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.media;

import android.view.MotionEvent;

// Referenced classes of package com.amazon.now.media:
//            PinchImageView, Gallery

private class <init> extends android.view.Listener
{

    final PinchImageView this$0;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        if (PinchImageView.access$200(PinchImageView.this) < 5F)
        {
            doubleTapScale(motionevent.getX(), motionevent.getY());
        } else
        {
            PinchImageView.access$300(PinchImageView.this).setVisibility(0);
            setVisibility(4);
        }
        return true;
    }

    private ()
    {
        this$0 = PinchImageView.this;
        super();
    }

    ( )
    {
        this();
    }
}
