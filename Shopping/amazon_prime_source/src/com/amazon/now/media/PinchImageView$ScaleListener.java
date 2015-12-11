// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.media;

import android.view.ScaleGestureDetector;

// Referenced classes of package com.amazon.now.media:
//            PinchImageView

private class <init> extends android.view.ScaleGestureListener
{

    final PinchImageView this$0;

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        updateScale(scalegesturedetector);
        return true;
    }

    private tureListener()
    {
        this$0 = PinchImageView.this;
        super();
    }

    tureListener(tureListener turelistener)
    {
        this();
    }
}
