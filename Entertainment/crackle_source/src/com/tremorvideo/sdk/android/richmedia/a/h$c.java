// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import android.view.MotionEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.a:
//            h

private class <init> extends android.view.ureDetector.SimpleOnGestureListener
{

    final h a;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        h.a(a).set(true);
        h.b(a).set(System.currentTimeMillis());
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionevent)
    {
        h.a(a).set(true);
        h.b(a).set(System.currentTimeMillis());
        return true;
    }

    private Listener(h h1)
    {
        a = h1;
        super();
    }

    ener(h h1, ener ener)
    {
        this(h1);
    }
}
