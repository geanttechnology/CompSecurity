// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.b;

import android.view.MotionEvent;

// Referenced classes of package com.j.a.b:
//            h, n, d

public class c
{

    static final d a;

    public static int a(MotionEvent motionevent)
    {
        return (motionevent.getAction() & 0xff00) >> 8;
    }

    public static int a(MotionEvent motionevent, int i)
    {
        return a.a(motionevent, i);
    }

    public static float b(MotionEvent motionevent, int i)
    {
        return a.b(motionevent, i);
    }

    public static int b(MotionEvent motionevent)
    {
        return a.a(motionevent);
    }

    public static float c(MotionEvent motionevent, int i)
    {
        return a.c(motionevent, i);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 5)
        {
            a = new h();
        } else
        {
            a = new n();
        }
    }
}
