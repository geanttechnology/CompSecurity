// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import org.apache.thrift.TByteArrayOutputStream;
import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.slf4j.Logger;

// Referenced classes of package org.apache.thrift.server:
//            TNonblockingServer

protected class d
{

    private final TNonblockingTransport a;
    private final SelectionKey b;
    private int c;
    private ByteBuffer d;
    private TByteArrayOutputStream e;
    private TNonblockingServer f;

    private boolean a()
    {
        int i;
        try
        {
            i = a.read(d);
        }
        catch (IOException ioexception)
        {
            TNonblockingServer.a().warn("Got an IOException in internalRead!", ioexception);
            return false;
        }
        return i >= 0;
    }

    private void b()
    {
        b.interestOps(1);
        d = ByteBuffer.allocate(4);
        c = 1;
    }

    private void c()
    {
        if (Thread.currentThread() == TNonblockingServer.d(f))
        {
            changeSelectInterests();
            return;
        } else
        {
            f.requestSelectInterestChange(this);
            return;
        }
    }

    public void changeSelectInterests()
    {
        if (c == 4)
        {
            b.interestOps(4);
            c = 6;
            return;
        }
        if (c == 7)
        {
            b();
            return;
        }
        if (c == 8)
        {
            close();
            b.cancel();
            return;
        } else
        {
            TNonblockingServer.a().error((new StringBuilder()).append("changeSelectInterest was called, but state is invalid (").append(c).append(")").toString());
            return;
        }
    }

    public void close()
    {
        if (c == 2 || c == 3)
        {
            TNonblockingServer.b(f, d.array().length);
        }
        a.close();
    }

    public void invoke()
    {
        org.apache.thrift.transport.TTransport ttransport = f.inputTransportFactory_.getTransport(new TIOStreamTransport(new ByteArrayInputStream(d.array())));
        org.apache.thrift.protocol.TProtocol tprotocol = f.inputProtocolFactory_.getProtocol(ttransport);
        Object obj = f.outputProtocolFactory_;
        e = new TByteArrayOutputStream();
        obj = ((TProtocolFactory) (obj)).getProtocol(f.outputTransportFactory_.getTransport(new TIOStreamTransport(e)));
        try
        {
            f.processorFactory_.getProcessor(ttransport).process(tprotocol, ((org.apache.thrift.protocol.TProtocol) (obj)));
            responseReady();
            return;
        }
        catch (TException texception)
        {
            TNonblockingServer.a().warn("Exception while invoking!", texception);
        }
        catch (Exception exception)
        {
            TNonblockingServer.a().error("Unexpected exception while invoking!", exception);
        }
        c = 8;
        c();
    }

    public boolean isFrameFullyRead()
    {
        return c == 3;
    }

    public boolean read()
    {
        if (c != 1) goto _L2; else goto _L1
_L1:
        if (a()) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        if (d.remaining() != 0) goto _L6; else goto _L5
_L5:
        int i = d.getInt(0);
        if (i <= 0)
        {
            TNonblockingServer.a().error((new StringBuilder()).append("Read an invalid frame size of ").append(i).append(". Are you using TFramedTransport on the client side?").toString());
            return false;
        }
        if ((long)(i + 4) > TNonblockingServer.b(f))
        {
            TNonblockingServer.a().error((new StringBuilder()).append("Read a frame size of ").append(i).append(", which is bigger than the maximum allowable buffer size for ALL connections.").toString());
            return false;
        }
        if (TNonblockingServer.c(f) + (long)i + 4L > TNonblockingServer.b(f))
        {
            return true;
        }
        TNonblockingServer.a(f, i + 4);
        d = ByteBuffer.allocate(i + 4);
        d.putInt(i);
        c = 2;
_L2:
        if (c == 2)
        {
            if (a())
            {
                if (d.remaining() == 0)
                {
                    b.interestOps(0);
                    c = 3;
                }
                return true;
            }
        } else
        {
            TNonblockingServer.a().error((new StringBuilder()).append("Read was called but state is invalid (").append(c).append(")").toString());
            return false;
        }
        if (true) goto _L3; else goto _L6
_L6:
        return true;
    }

    public void responseReady()
    {
        TNonblockingServer.b(f, d.array().length);
        if (e.len() == 0)
        {
            c = 7;
            d = null;
        } else
        {
            d = ByteBuffer.wrap(e.get(), 0, e.len());
            c = 4;
        }
        c();
    }

    public boolean write()
    {
        if (c == 6)
        {
            int i;
            try
            {
                i = a.write(d);
            }
            catch (IOException ioexception)
            {
                TNonblockingServer.a().warn("Got an IOException during write!", ioexception);
                return false;
            }
            if (i < 0)
            {
                return false;
            }
            if (d.remaining() == 0)
            {
                b();
            }
            return true;
        } else
        {
            TNonblockingServer.a().error((new StringBuilder()).append("Write was called, but state is invalid (").append(c).append(")").toString());
            return false;
        }
    }

    public (TNonblockingServer tnonblockingserver, TNonblockingTransport tnonblockingtransport, SelectionKey selectionkey)
    {
        f = tnonblockingserver;
        super();
        c = 1;
        a = tnonblockingtransport;
        b = selectionkey;
        d = ByteBuffer.allocate(4);
    }
}
