// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.gs;

public final class aai extends aag
    implements qo, qp
{

    private final aaf a;
    private final aaj b;
    private final Object c = new Object();

    public aai(Context context, fh fh1, aaf aaf1)
    {
        super(fh1, aaf1);
        a = aaf1;
        b = new aaj(context, this, this, fh1.k.d);
        b.a();
    }

    public void c()
    {
        synchronized (c)
        {
            if (b.c() || b.g())
            {
                b.b();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public aan d()
    {
        obj;
        JVM INSTR monitorenter ;
        aan aan;
        synchronized (c)
        {
            aan = b.f();
        }
        return aan;
_L2:
        obj;
        JVM INSTR monitorexit ;
        return null;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj1;
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onConnected(Bundle bundle)
    {
        e();
    }

    public void onConnectionFailed(pp pp)
    {
        a.a(new fj(0));
    }

    public void onConnectionSuspended(int i)
    {
        acb.a("Disconnected from remote ad request service.");
    }
}
