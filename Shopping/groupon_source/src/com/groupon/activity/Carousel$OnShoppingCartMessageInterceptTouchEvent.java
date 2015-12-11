// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.MotionEvent;
import com.groupon.util.OnInterceptTouchEvent;

// Referenced classes of package com.groupon.activity:
//            Carousel

private class <init>
    implements OnInterceptTouchEvent
{

    final Carousel this$0;

    public void onInterceptTouchEvent(MotionEvent motionevent)
    {
        Carousel.access$1900(Carousel.this);
        Carousel.access$2400(Carousel.this, getSupportActionBar());
    }

    private ()
    {
        this$0 = Carousel.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
