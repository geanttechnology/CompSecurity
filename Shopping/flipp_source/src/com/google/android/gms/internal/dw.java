// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            dx, dy, et, ew, 
//            af

public final class dw
{

    final Object a = new Object();
    ew b;
    String c;
    int d;
    String e;
    public final af f = new dx(this);
    public final af g = new dy(this);

    public dw(String s)
    {
        d = -2;
        c = s;
    }

    public final int a()
    {
        int i;
        synchronized (a)
        {
            i = d;
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final String b()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
_L1:
        int i;
        if (e != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        i = d;
        if (i != -2)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        a.wait();
          goto _L1
        Object obj1;
        obj1;
        et.d("Ad request service was interrupted.");
        obj;
        JVM INSTR monitorexit ;
        return null;
        String s = e;
        obj;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }
}
