// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.ContentObserver;
import android.os.Handler;
import java.util.HashMap;

final class bch extends ContentObserver
{

    private bcg a;

    bch(bcg bcg1, Handler handler)
    {
        a = bcg1;
        super(handler);
    }

    public final void onChange(boolean flag)
    {
        bcf;
        JVM INSTR monitorenter ;
        bcf.a().clear();
        bcf.a(new Object());
        if (bcf.b().length > 0)
        {
            bcf.b(a.a, bcf.b());
        }
        bcf;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        bcf;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
