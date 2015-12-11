// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.view.MotionEvent;

// Referenced classes of package com.aio.downloader.views:
//            DragLayout

class  extends android.view.tureListener
{

    final DragLayout this$0;

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return Math.abs(f1) <= Math.abs(f);
    }

    ()
    {
        this$0 = DragLayout.this;
        super();
    }
}
