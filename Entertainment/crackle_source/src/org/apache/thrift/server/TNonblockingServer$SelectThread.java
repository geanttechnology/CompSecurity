// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;

// Referenced classes of package org.apache.thrift.server:
//            TNonblockingServer

protected class b extends Thread
{

    private final TNonblockingServerTransport a;
    private final Selector b = SelectorProvider.provider().openSelector();
    private final Set c = new HashSet();
    private TNonblockingServer d;

    private void a()
    {
        Set set = c;
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((c)iterator.next()).hangeSelectInterests()) { }
        break MISSING_BLOCK_LABEL_46;
        Exception exception;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
        c.clear();
        set;
        JVM INSTR monitorexit ;
    }

    private static void a(SelectionKey selectionkey)
    {
        c c1 = (c)selectionkey.attachment();
        if (c1 != null)
        {
            c1.lose();
        }
        selectionkey.cancel();
    }

    private void b()
        throws IOException
    {
        SelectionKey selectionkey;
        SelectionKey selectionkey1;
        selectionkey1 = null;
        selectionkey = null;
        TNonblockingTransport tnonblockingtransport = (TNonblockingTransport)a.accept();
        selectionkey = selectionkey1;
        selectionkey1 = tnonblockingtransport.registerSelector(b, 1);
        selectionkey = selectionkey1;
        selectionkey1.attach(new init>(d, tnonblockingtransport, selectionkey1));
_L2:
        return;
        TTransportException ttransportexception;
        ttransportexception;
        tnonblockingtransport = null;
_L3:
        TNonblockingServer.a().warn("Exception trying to accept!", ttransportexception);
        ttransportexception.printStackTrace();
        if (selectionkey != null)
        {
            a(selectionkey);
        }
        if (tnonblockingtransport == null) goto _L2; else goto _L1
_L1:
        tnonblockingtransport.close();
        return;
        ttransportexception;
          goto _L3
    }

    public void requestSelectInterestChange(a a1)
    {
        synchronized (c)
        {
            c.add(a1);
        }
        b.wakeup();
        return;
        a1;
        set;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public void run()
    {
_L7:
        if (TNonblockingServer.a(d))
        {
            break MISSING_BLOCK_LABEL_220;
        }
        Iterator iterator;
        b.select();
        iterator = b.selectedKeys().iterator();
_L5:
        if (TNonblockingServer.a(d) || !iterator.hasNext()) goto _L2; else goto _L1
_L1:
        SelectionKey selectionkey;
        selectionkey = (SelectionKey)iterator.next();
        iterator.remove();
        if (selectionkey.isValid()) goto _L4; else goto _L3
_L3:
        a(selectionkey);
          goto _L5
        IOException ioexception;
        ioexception;
        TNonblockingServer.a().warn("Got an IOException while selecting!", ioexception);
_L2:
        a();
        continue; /* Loop/switch isn't completed */
_L4:
label0:
        {
            if (!selectionkey.isAcceptable())
            {
                break label0;
            }
            b();
        }
          goto _L5
label1:
        {
            if (!selectionkey.isReadable())
            {
                break MISSING_BLOCK_LABEL_160;
            }
            b b1 = (b)selectionkey.attachment();
            if (!b1.ead())
            {
                break label1;
            }
            if (b1.sFrameFullyRead())
            {
                d.requestInvoke(b1);
            }
        }
          goto _L5
        a(selectionkey);
          goto _L5
label2:
        {
            if (!selectionkey.isWritable())
            {
                break label2;
            }
            if (!((a)selectionkey.attachment()).rite())
            {
                a(selectionkey);
            }
        }
          goto _L5
        TNonblockingServer.a().warn((new StringBuilder()).append("Unexpected state in select! ").append(selectionkey.interestOps()).toString());
          goto _L5
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void wakeupSelector()
    {
        b.wakeup();
    }

    public (TNonblockingServer tnonblockingserver, TNonblockingServerTransport tnonblockingservertransport)
        throws IOException
    {
        d = tnonblockingserver;
        super();
        a = tnonblockingservertransport;
        tnonblockingservertransport.registerSelector(b);
    }
}
