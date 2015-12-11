// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;

// Referenced classes of package android.support.v7:
//            aag, aai, aaf, abo

class aed
    implements aag
{
    public static interface a
    {
    }

    private class b extends Handler
    {

        final aed a;
        private final aag.a b;

        protected void a(String s)
        {
            b.a(a, s);
        }

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                abo.a("Don't know how to handle this message.");
                return;

            case 1: // '\001'
                a((String)message.obj);
                break;
            }
        }
    }


    private final Looper a;
    private aaf b;
    private aaf c;
    private Status d;
    private b e;
    private a f;
    private boolean g;
    private aai h;

    public aed(aai aai1, Looper looper, aaf aaf1, a a1)
    {
        h = aai1;
        if (looper == null)
        {
            looper = Looper.getMainLooper();
        }
        a = looper;
        b = aaf1;
        f = a1;
        d = Status.a;
        aai1.a(this);
    }

    public aed(Status status)
    {
        d = status;
        a = null;
    }

    public Status a()
    {
        return d;
    }

    public void a(String s)
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
        b.e(s);
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!g) goto _L2; else goto _L1
_L1:
        abo.a("Releasing a released ContainerHolder.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        g = true;
        h.b(this);
        b.c();
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

    public aaf c()
    {
        aaf aaf1 = null;
        this;
        JVM INSTR monitorenter ;
        if (!g) goto _L2; else goto _L1
_L1:
        abo.a("ContainerHolder is released.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return aaf1;
_L2:
        if (c != null)
        {
            b = c;
            c = null;
        }
        aaf1 = b;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }
}
