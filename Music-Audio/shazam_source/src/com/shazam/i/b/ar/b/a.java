// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.ar.b;

import android.media.AudioRecord;
import com.shazam.android.au.e.b.c;
import com.shazam.android.ay.a.e;
import com.shazam.android.j.af.f;
import com.shazam.i.b.n.b;

public final class a
{

    private static final com.shazam.android.au.e.b.b a;
    private static final int b;

    private static int a(int i)
    {
        int j = 0;
        int k = AudioRecord.getMinBufferSize(i, 16, 2);
        j = k * 2;
_L2:
        if (j > 0)
        {
            return j;
        } else
        {
            return (i * 2) / 2;
        }
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static com.shazam.android.au.e.b.b a()
    {
        com/shazam/i/b/ar/b/a;
        JVM INSTR monitorenter ;
        com.shazam.android.au.e.b.b b1 = a;
        com/shazam/i/b/ar/b/a;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public static int b()
    {
        return b;
    }

    public static c c()
    {
        return new c(a);
    }

    static int d()
    {
        return b;
    }

    static 
    {
        f f1 = com.shazam.i.b.n.b.i();
        int i = f1.a();
        b = a(i);
        int j = Math.max(1, f1.c());
        new e();
        a = new com.shazam.android.au.e.b.b(new _cls1(), (j * i * 2) / b);
    }

    /* member class not found */
    class _cls1 {}

}
