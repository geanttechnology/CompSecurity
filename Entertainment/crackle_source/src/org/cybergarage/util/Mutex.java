// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.util;


// Referenced classes of package org.cybergarage.util:
//            Debug

public class Mutex
{

    private boolean syncLock;

    public Mutex()
    {
        syncLock = false;
    }

    public void lock()
    {
        this;
        JVM INSTR monitorenter ;
_L2:
        if (syncLock)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        syncLock = true;
        this;
        JVM INSTR monitorexit ;
        return;
        wait();
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        Debug.warning(((Exception) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    public void unlock()
    {
        this;
        JVM INSTR monitorenter ;
        syncLock = false;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
