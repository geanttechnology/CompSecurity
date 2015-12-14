// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.gifencoder;

import java.util.concurrent.ScheduledThreadPoolExecutor;

final class a extends ScheduledThreadPoolExecutor
{

    private static volatile a a = null;

    private a()
    {
        super(1, new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
    }

    public static a a()
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        com/picsart/studio/gifencoder/a;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new a();
        }
        com/picsart/studio/gifencoder/a;
        JVM INSTR monitorexit ;
_L2:
        return a;
        Exception exception;
        exception;
        com/picsart/studio/gifencoder/a;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
