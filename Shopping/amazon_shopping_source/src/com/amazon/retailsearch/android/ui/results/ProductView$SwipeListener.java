// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.view.MotionEvent;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ProductView, SwipeDetector

private class <init>
    implements <init>
{

    final ProductView this$0;

    public boolean onDown(MotionEvent motionevent)
    {
        if (!swipeDetector.isSwiping())
        {
            swiped = false;
        }
        return true;
    }

    public boolean onMove(float f, float f1, MotionEvent motionevent, float f2, float f3)
    {
        if (!swiped)
        {
            swiped = true;
        }
        return true;
    }

    public boolean onSwipe(float f, float f1, MotionEvent motionevent, float f2, float f3)
    {
        return true;
    }

    private ()
    {
        this$0 = ProductView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
