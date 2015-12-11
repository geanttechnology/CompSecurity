// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package com.google.android.gms.e:
//            b, d, a, bs, 
//            aj

final class cy
    implements com.google.android.gms.e.b
{
    public static interface a
    {
    }

    private final class b extends Handler
    {

        public final void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                aj.a("Don't know how to handle this message.");
                return;

            case 1: // '\001'
                message = ((Message) (message.obj));
                break;
            }
        }
    }


    private final Looper a;
    private com.google.android.gms.e.a b;
    private com.google.android.gms.e.a c;
    private Status d;
    private b e;
    private a f;
    private boolean g;
    private d h;

    public cy(Status status)
    {
        d = status;
        a = null;
    }

    public cy(d d1, Looper looper, com.google.android.gms.e.a a1, a a2)
    {
        h = d1;
        if (looper == null)
        {
            looper = Looper.getMainLooper();
        }
        a = looper;
        b = a1;
        f = a2;
        d = Status.a;
        d1.e.put(this, Boolean.valueOf(true));
    }

    public final Status a()
    {
        return d;
    }

    public final void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = g;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        b.a().a(s);
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!g) goto _L2; else goto _L1
_L1:
        aj.a("Releasing a released ContainerHolder.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        g = true;
        h.e.remove(this);
        b.a = null;
        b = null;
        c = null;
        f = null;
        e = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final com.google.android.gms.e.a c()
    {
        com.google.android.gms.e.a a1 = null;
        this;
        JVM INSTR monitorenter ;
        if (!g) goto _L2; else goto _L1
_L1:
        aj.a("ContainerHolder is released.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return a1;
_L2:
        if (c != null)
        {
            b = c;
            c = null;
        }
        a1 = b;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }
}
