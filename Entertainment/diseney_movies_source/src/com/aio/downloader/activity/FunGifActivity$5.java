// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.view.MotionEvent;

// Referenced classes of package com.aio.downloader.activity:
//            FunGifActivity

class this._cls0
    implements android.view.nDoubleTapListener
{

    final FunGifActivity this$0;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        finish();
        return false;
    }

    ner()
    {
        this$0 = FunGifActivity.this;
        super();
    }
}
