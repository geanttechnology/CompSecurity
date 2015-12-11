// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.common.util.concurrent:
//            SerializingExecutor

private final class <init>
    implements Runnable
{

    final SerializingExecutor this$0;

    private void workOnQueue()
    {
_L2:
        Object obj = null;
        Object obj1 = SerializingExecutor.access$100(SerializingExecutor.this);
        obj1;
        JVM INSTR monitorenter ;
        if (SerializingExecutor.access$300(SerializingExecutor.this) == 0)
        {
            obj = (Runnable)SerializingExecutor.access$400(SerializingExecutor.this).poll();
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        SerializingExecutor.access$202(SerializingExecutor.this, false);
        obj1;
        JVM INSTR monitorexit ;
        return;
        obj1;
        JVM INSTR monitorexit ;
        try
        {
            ((Runnable) (obj)).run();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            Logger logger = SerializingExecutor.access$500();
            Level level = Level.SEVERE;
            obj = String.valueOf(obj);
            logger.log(level, (new StringBuilder(String.valueOf(obj).length() + 35)).append("Exception while executing runnable ").append(((String) (obj))).toString(), ((Throwable) (obj1)));
        }
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void run()
    {
        try
        {
            workOnQueue();
            return;
        }
        catch (Error error)
        {
            synchronized (SerializingExecutor.access$100(SerializingExecutor.this))
            {
                SerializingExecutor.access$202(SerializingExecutor.this, false);
            }
            throw error;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private ()
    {
        this$0 = SerializingExecutor.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
