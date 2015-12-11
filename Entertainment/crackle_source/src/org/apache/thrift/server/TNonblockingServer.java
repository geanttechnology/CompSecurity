// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.thrift.TByteArrayOutputStream;
import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.server:
//            TServer

public class TNonblockingServer extends TServer
{
    protected class FrameBuffer
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

        public FrameBuffer(TNonblockingTransport tnonblockingtransport, SelectionKey selectionkey)
        {
            f = TNonblockingServer.this;
            super();
            c = 1;
            a = tnonblockingtransport;
            b = selectionkey;
            d = ByteBuffer.allocate(4);
        }
    }

    public static class Options
    {

        public long maxReadBufferBytes;

        public void validate()
        {
            if (maxReadBufferBytes <= 1024L)
            {
                throw new IllegalArgumentException("You must allocate at least 1KB to the read buffer.");
            } else
            {
                return;
            }
        }

        public Options()
        {
            maxReadBufferBytes = 0x7fffffffffffffffL;
        }
    }

    protected class SelectThread extends Thread
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
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((FrameBuffer)iterator.next()).changeSelectInterests()) { }
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
            FrameBuffer framebuffer = (FrameBuffer)selectionkey.attachment();
            if (framebuffer != null)
            {
                framebuffer.close();
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
            selectionkey1.attach(d. new FrameBuffer(tnonblockingtransport, selectionkey1));
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

        public void requestSelectInterestChange(FrameBuffer framebuffer)
        {
            synchronized (c)
            {
                c.add(framebuffer);
            }
            b.wakeup();
            return;
            framebuffer;
            set;
            JVM INSTR monitorexit ;
            throw framebuffer;
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
                FrameBuffer framebuffer = (FrameBuffer)selectionkey.attachment();
                if (!framebuffer.read())
                {
                    break label1;
                }
                if (framebuffer.isFrameFullyRead())
                {
                    d.requestInvoke(framebuffer);
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
                if (!((FrameBuffer)selectionkey.attachment()).write())
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

        public SelectThread(TNonblockingServerTransport tnonblockingservertransport)
            throws IOException
        {
            d = TNonblockingServer.this;
            super();
            a = tnonblockingservertransport;
            tnonblockingservertransport.registerSelector(b);
        }
    }


    private static final Logger a = LoggerFactory.getLogger(org/apache/thrift/server/TNonblockingServer.getName());
    private volatile boolean b;
    private SelectThread c;
    private final long d;
    private long e;
    protected final Options options_;

    public TNonblockingServer(TProcessor tprocessor, TNonblockingServerTransport tnonblockingservertransport)
    {
        this(new TProcessorFactory(tprocessor), tnonblockingservertransport);
    }

    public TNonblockingServer(TProcessor tprocessor, TNonblockingServerTransport tnonblockingservertransport, TProtocolFactory tprotocolfactory)
    {
        this(tprocessor, tnonblockingservertransport, new org.apache.thrift.transport.TFramedTransport.Factory(), new org.apache.thrift.transport.TFramedTransport.Factory(), tprotocolfactory, tprotocolfactory);
    }

    public TNonblockingServer(TProcessor tprocessor, TNonblockingServerTransport tnonblockingservertransport, org.apache.thrift.transport.TFramedTransport.Factory factory, TProtocolFactory tprotocolfactory)
    {
        this(tprocessor, tnonblockingservertransport, factory, factory, tprotocolfactory, tprotocolfactory);
    }

    public TNonblockingServer(TProcessor tprocessor, TNonblockingServerTransport tnonblockingservertransport, org.apache.thrift.transport.TFramedTransport.Factory factory, org.apache.thrift.transport.TFramedTransport.Factory factory1, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1)
    {
        this(new TProcessorFactory(tprocessor), tnonblockingservertransport, factory, factory1, tprotocolfactory, tprotocolfactory1);
    }

    public TNonblockingServer(TProcessorFactory tprocessorfactory, TNonblockingServerTransport tnonblockingservertransport)
    {
        this(tprocessorfactory, tnonblockingservertransport, new org.apache.thrift.transport.TFramedTransport.Factory(), new org.apache.thrift.transport.TFramedTransport.Factory(), ((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())), ((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())));
    }

    public TNonblockingServer(TProcessorFactory tprocessorfactory, TNonblockingServerTransport tnonblockingservertransport, org.apache.thrift.transport.TFramedTransport.Factory factory, TProtocolFactory tprotocolfactory)
    {
        this(tprocessorfactory, tnonblockingservertransport, factory, factory, tprotocolfactory, tprotocolfactory);
    }

    public TNonblockingServer(TProcessorFactory tprocessorfactory, TNonblockingServerTransport tnonblockingservertransport, org.apache.thrift.transport.TFramedTransport.Factory factory, org.apache.thrift.transport.TFramedTransport.Factory factory1, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1)
    {
        this(tprocessorfactory, tnonblockingservertransport, factory, factory1, tprotocolfactory, tprotocolfactory1, new Options());
    }

    public TNonblockingServer(TProcessorFactory tprocessorfactory, TNonblockingServerTransport tnonblockingservertransport, org.apache.thrift.transport.TFramedTransport.Factory factory, org.apache.thrift.transport.TFramedTransport.Factory factory1, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1, Options options)
    {
        super(tprocessorfactory, tnonblockingservertransport, factory, factory1, tprotocolfactory, tprotocolfactory1);
        e = 0L;
        options_ = options;
        options_.validate();
        d = options.maxReadBufferBytes;
    }

    static long a(TNonblockingServer tnonblockingserver, long l)
    {
        l = tnonblockingserver.e + l;
        tnonblockingserver.e = l;
        return l;
    }

    static Logger a()
    {
        return a;
    }

    static boolean a(TNonblockingServer tnonblockingserver)
    {
        return tnonblockingserver.b;
    }

    static long b(TNonblockingServer tnonblockingserver)
    {
        return tnonblockingserver.d;
    }

    static long b(TNonblockingServer tnonblockingserver, long l)
    {
        l = tnonblockingserver.e - l;
        tnonblockingserver.e = l;
        return l;
    }

    static long c(TNonblockingServer tnonblockingserver)
    {
        return tnonblockingserver.e;
    }

    static SelectThread d(TNonblockingServer tnonblockingserver)
    {
        return tnonblockingserver.c;
    }

    protected void joinSelector()
    {
        try
        {
            c.join();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }

    protected void requestInvoke(FrameBuffer framebuffer)
    {
        framebuffer.invoke();
    }

    protected void requestSelectInterestChange(FrameBuffer framebuffer)
    {
        c.requestSelectInterestChange(framebuffer);
    }

    public void serve()
    {
        while (!startListening() || !startSelectorThread()) 
        {
            return;
        }
        joinSelector();
        stopListening();
    }

    protected boolean startListening()
    {
        try
        {
            serverTransport_.listen();
        }
        catch (TTransportException ttransportexception)
        {
            a.error("Failed to start listening on server socket!", ttransportexception);
            return false;
        }
        return true;
    }

    protected boolean startSelectorThread()
    {
        try
        {
            c = new SelectThread((TNonblockingServerTransport)serverTransport_);
            c.start();
        }
        catch (IOException ioexception)
        {
            a.error("Failed to start selector thread!", ioexception);
            return false;
        }
        return true;
    }

    public void stop()
    {
        b = true;
        if (c != null)
        {
            c.wakeupSelector();
        }
    }

    protected void stopListening()
    {
        serverTransport_.close();
    }

}
