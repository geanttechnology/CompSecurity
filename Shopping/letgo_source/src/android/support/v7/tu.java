// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.x;

public class tu
{

    private HandlerThread a;
    private int b;
    private final Object c = new Object();

    public tu()
    {
        a = null;
        b = 0;
    }

    public Looper a()
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        Looper looper;
        Exception exception;
        boolean flag;
        if (b == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.b(flag, "Invalid state: mHandlerThread should already been initialized.");
        zzb.v("Starting the looper provider thread.");
        a = new HandlerThread("LooperProvider");
        a.start();
        b = b + 1;
        looper = a.getLooper();
        obj;
        JVM INSTR monitorexit ;
        return looper;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b()
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        int i;
        boolean flag;
        if (b > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.b(flag, "Invalid state: release() called more times than expected.");
        i = b - 1;
        b = i;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        zzb.v("Terminate the looper provider thread.");
        a.quit();
        a = null;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
