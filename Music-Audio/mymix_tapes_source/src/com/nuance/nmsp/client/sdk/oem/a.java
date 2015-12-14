// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;

public final class com.nuance.nmsp.client.sdk.oem.a extends Handler
{
    final class a
    {

        final Message a;
        final long b;

        a(Message message, long l)
        {
            a = message;
            b = l;
        }
    }


    private Handler a;
    private final ArrayList b = new ArrayList();

    public com.nuance.nmsp.client.sdk.oem.a()
    {
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        a = new Handler();
        if (b.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        a a1;
        for (Iterator iterator = b.iterator(); iterator.hasNext(); a.sendMessageAtTime(a1.a, a1.b))
        {
            a1 = (a)iterator.next();
        }

        break MISSING_BLOCK_LABEL_74;
        Exception exception;
        exception;
        throw exception;
        b.clear();
        this;
        JVM INSTR monitorexit ;
    }

    public final boolean sendMessageAtTime(Message message, long l)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        if (a != null) goto _L2; else goto _L1
_L1:
        b.add(new a(message, l));
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (a.getLooper().getThread().isAlive())
        {
            flag = a.sendMessageAtTime(message, l);
        }
        if (true) goto _L4; else goto _L3
_L3:
        message;
        throw message;
    }
}
