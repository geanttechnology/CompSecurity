// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

public class AppLovinTouchToClickListener
    implements android.view.View.OnTouchListener
{

    private long a;
    private float b;
    private float c;
    private Context d;
    private android.view.View.OnClickListener e;

    public AppLovinTouchToClickListener(Context context, android.view.View.OnClickListener onclicklistener)
    {
        d = context;
        e = onclicklistener;
    }

    private float a(float f)
    {
        return f / d.getResources().getDisplayMetrics().density;
    }

    private float a(float f, float f1, float f2, float f3)
    {
        f -= f2;
        f1 -= f3;
        return a((float)Math.sqrt(f * f + f1 * f1));
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 1: default 28
    //                   0 30
    //                   1 56;
           goto _L1 _L2 _L3
_L1:
        return true;
_L2:
        a = System.currentTimeMillis();
        b = motionevent.getX();
        c = motionevent.getY();
        continue; /* Loop/switch isn't completed */
_L3:
        if (System.currentTimeMillis() - a < 1000L && a(b, c, motionevent.getX(), motionevent.getY()) < 10F)
        {
            e.onClick(view);
        }
        if (true) goto _L1; else goto _L4
_L4:
    }
}
