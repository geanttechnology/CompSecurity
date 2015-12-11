// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import com.smule.android.c.aa;

public class q
{

    private static final String d = com/smule/android/f/q.getName();
    Runnable a;
    int b;
    Runnable c;

    public q(int i, Runnable runnable)
    {
        c = new Runnable() {

            final q a;

            public void run()
            {
                a.a();
            }

            
            {
                a = q.this;
                super();
            }
        };
        b = i;
        a = runnable;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        b = b - 1;
        if (b != 0) goto _L2; else goto _L1
_L1:
        if (a != null)
        {
            a.run();
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (b >= 0) goto _L4; else goto _L3
_L3:
        Object obj;
        String s;
        StringBuilder stringbuilder;
        s = d;
        stringbuilder = (new StringBuilder()).append("Too many workers called 'done'. Callback ");
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        obj = a.getClass().getName();
_L5:
        aa.e(s, stringbuilder.append(((String) (obj))).toString());
          goto _L4
        obj;
        throw obj;
        obj = "";
          goto _L5
    }

    public Runnable b()
    {
        return c;
    }

}
