// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.socialin.android.brushlib.input.TouchResponse;
import com.socialin.android.brushlib.input.d;

public final class f
    implements d
{

    public float a;
    public float b;
    public boolean c;
    private Handler d;
    private Runnable e;
    private long f;
    private float g;

    public f(Context context, Runnable runnable)
    {
        d = new Handler();
        f = 500L;
        c = false;
        e = runnable;
        g = TypedValue.applyDimension(1, 5F, context.getResources().getDisplayMetrics());
    }

    private void a()
    {
        d.removeCallbacks(e);
        c = false;
    }

    public final TouchResponse a(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 40
    //                   1 32
    //                   2 83;
           goto _L1 _L2 _L1 _L3
_L1:
        a();
        return TouchResponse.REJECT;
_L2:
        a = motionevent.getX();
        b = motionevent.getY();
        if (d.postDelayed(e, f))
        {
            c = true;
        }
_L5:
        return TouchResponse.UNDEFINED;
_L3:
        if (Math.hypot(a - motionevent.getX(), b - motionevent.getY()) >= (double)g)
        {
            a();
            return TouchResponse.REJECT;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void d()
    {
        a();
    }
}
