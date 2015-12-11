// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class di
{
    static final class a
    {

        final Runnable a;
        final Executor b;
    }


    private static final Logger a = Logger.getLogger(com/tapjoy/internal/di.getName());
    private final Queue b = new LinkedList();
    private boolean c;

    public di()
    {
        c = false;
    }

    public final void a()
    {
label0:
        {
            synchronized (b)
            {
                if (!c)
                {
                    break label0;
                }
            }
            return;
        }
        c = true;
        obj;
        JVM INSTR monitorexit ;
        while (!b.isEmpty()) 
        {
            obj = (a)b.poll();
            try
            {
                ((a) (obj)).b.execute(((a) (obj)).a);
            }
            catch (RuntimeException runtimeexception)
            {
                a.log(Level.SEVERE, (new StringBuilder("RuntimeException while executing runnable ")).append(((a) (obj)).a).append(" with executor ").append(((a) (obj)).b).toString(), runtimeexception);
            }
        }
        break MISSING_BLOCK_LABEL_115;
        exception;
        throw exception;
    }

}
