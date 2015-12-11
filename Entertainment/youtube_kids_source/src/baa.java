// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.SystemClock;
import org.json.JSONObject;

public final class baa
{

    public static final Object a = new Object();
    private static final azv f = new azv("RequestTracker");
    private long b;
    private long c;
    private long d;
    private azz e;

    public baa(long l)
    {
        b = l;
        c = -1L;
        d = 0L;
    }

    private void c()
    {
        c = -1L;
        e = null;
        d = 0L;
    }

    public final void a()
    {
        synchronized (a)
        {
            if (c != -1L)
            {
                c();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(long l, azz azz1)
    {
        azz azz2;
        synchronized (a)
        {
            azz2 = e;
            long l1 = c;
            c = l;
            e = azz1;
            d = SystemClock.elapsedRealtime();
        }
        if (azz2 != null)
        {
            azz2.a();
        }
        return;
        azz1;
        obj;
        JVM INSTR monitorexit ;
        throw azz1;
    }

    public final boolean a(long l)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (c != -1L && c == l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean a(long l, int i)
    {
        boolean flag = true;
        Object obj1 = a;
        obj1;
        JVM INSTR monitorenter ;
        Object obj;
        if (c == -1L || l - d < b)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        f.a("request %d timed out", new Object[] {
            Long.valueOf(c)
        });
        l = c;
        obj = e;
        c();
_L2:
        if (obj != null)
        {
            ((azz) (obj)).a(2102, null);
        }
        return flag;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        flag = false;
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final boolean a(long l, int i, JSONObject jsonobject)
    {
        azz azz1;
        boolean flag;
        flag = true;
        azz1 = null;
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (c == -1L || c != l)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        f.a("request %d completed", new Object[] {
            Long.valueOf(c)
        });
        azz1 = e;
        c();
_L2:
        if (azz1 != null)
        {
            azz1.a(i, jsonobject);
        }
        return flag;
        jsonobject;
        obj;
        JVM INSTR monitorexit ;
        throw jsonobject;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final boolean b()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (c != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
