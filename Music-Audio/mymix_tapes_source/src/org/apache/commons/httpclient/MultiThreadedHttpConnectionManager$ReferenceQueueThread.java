// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import org.apache.commons.logging.Log;

// Referenced classes of package org.apache.commons.httpclient:
//            MultiThreadedHttpConnectionManager

private static class setName extends Thread
{

    private volatile boolean shutdown;

    private void handleReference(Reference reference)
    {
        synchronized (MultiThreadedHttpConnectionManager.access$1400())
        {
            reference = (setName)MultiThreadedHttpConnectionManager.access$1400().remove(reference);
        }
        if (reference != null)
        {
            if (MultiThreadedHttpConnectionManager.access$700().isDebugEnabled())
            {
                MultiThreadedHttpConnectionManager.access$700().debug("Connection reclaimed by garbage collector, hostConfig=" + ((setName) (reference)).Configuration);
            }
            ((Configuration) (reference)).ectionPool.LostConnection(((LostConnection) (reference)).Configuration);
        }
        return;
        reference;
        map;
        JVM INSTR monitorexit ;
        throw reference;
    }

    public void run()
    {
_L2:
        if (shutdown)
        {
            break; /* Loop/switch isn't completed */
        }
        Reference reference = MultiThreadedHttpConnectionManager.access$1500().remove();
        if (reference != null)
        {
            try
            {
                handleReference(reference);
            }
            catch (InterruptedException interruptedexception)
            {
                MultiThreadedHttpConnectionManager.access$700().debug("ReferenceQueueThread interrupted", interruptedexception);
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void shutdown()
    {
        shutdown = true;
        interrupt();
    }

    public ()
    {
        shutdown = false;
        setDaemon(true);
        setName("MultiThreadedHttpConnectionManager cleanup");
    }
}
