// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.w;

public final class gr
{

    public HandlerThread a;
    public int b;
    public final Object c = new Object();

    public gr()
    {
        a = null;
        b = 0;
    }

    public final Looper a()
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
        w.b(flag, "Invalid state: mHandlerThread should already been initialized.");
        com.google.android.gms.ads.internal.util.client.b.a(2);
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
}
