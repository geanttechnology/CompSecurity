// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.SystemClock;
import java.util.Iterator;
import java.util.List;

final class azx
    implements Runnable
{

    private azw a;

    azx(azw azw1)
    {
        a = azw1;
        super();
    }

    public final void run()
    {
        boolean flag;
        flag = false;
        azw.a(a, false);
        long l = SystemClock.elapsedRealtime();
        for (Iterator iterator = azw.a(a).iterator(); iterator.hasNext(); ((baa)iterator.next()).a(l, 2102)) { }
        Object obj = baa.a;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator1 = azw.a(a).iterator(); iterator1.hasNext();)
        {
            if (((baa)iterator1.next()).b())
            {
                flag = true;
            }
        }

        obj;
        JVM INSTR monitorexit ;
        azw.b(a, flag);
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
