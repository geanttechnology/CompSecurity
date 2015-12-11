// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class acv
    implements aee.c
{

    private final Context a;
    private final String b;
    private final ExecutorService c = Executors.newSingleThreadExecutor();

    acv(Context context, String s)
    {
        a = context;
        b = s;
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        c.shutdown();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
