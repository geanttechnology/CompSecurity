// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.SystemClock;
import android.util.Log;

public class bum
{

    private final String a;
    private final String b;
    private final boolean c;
    private long d;
    private long e;

    public bum(String s, String s1)
    {
        a = s;
        b = s1;
        boolean flag;
        if (!Log.isLoggable(s1, 2))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
    }

    private void c()
    {
        Log.v(b, (new StringBuilder()).append(a).append(": ").append(e).append("ms").toString());
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = c;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        d = SystemClock.elapsedRealtime();
        e = 0L;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = c;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (e == 0L)
        {
            e = SystemClock.elapsedRealtime() - d;
            c();
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }
}
