// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils;

import android.view.MotionEvent;
import android.view.View;

public final class b
    implements android.view.View.OnTouchListener
{
    public static interface a
    {

        public abstract void a(View view);
    }


    private a a;
    private int b;
    private int c;

    public b(a a1)
    {
        c = 0;
        a = a1;
        b = 2;
    }

    private void a(View view)
    {
        if (a != null)
        {
            a.a(view);
        }
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 39
    //                   1 74
    //                   2 138;
           goto _L1 _L2 _L3 _L4
_L1:
        c = 3;
_L6:
        return false;
_L2:
        if (c == 0)
        {
            c = 1;
        } else
        {
            c = 3;
        }
        if (b != 2) goto _L6; else goto _L5
_L5:
        a(view);
        return false;
_L3:
        if (c != 2)
        {
            c = 0;
            if (b == 0)
            {
                a(view);
            }
        } else
        if (c == 2)
        {
            c = 0;
        } else
        {
            c = 3;
        }
        if (b != 1) goto _L6; else goto _L7
_L7:
        a(view);
        return false;
_L4:
        if (c == 1 || c == 2)
        {
            c = 2;
            return false;
        } else
        {
            c = 3;
            return false;
        }
    }
}
