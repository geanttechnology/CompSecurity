// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingServerTransport;

// Referenced classes of package org.apache.thrift.server:
//            TNonblockingServer

public class THsHaServer extends TNonblockingServer
{
    public static class Options extends TNonblockingServer.Options
    {

        public int maxWorkerThreads;
        public int minWorkerThreads;
        public TimeUnit stopTimeoutUnit;
        public int stopTimeoutVal;

        public Options()
        {
            minWorkerThreads = 5;
            maxWorkerThreads = 0x7fffffff;
            stopTimeoutVal = 60;
            stopTimeoutUnit = TimeUnit.SECONDS;
        }
    }

    private final class a
        implements Runnable
    {

        private final TNonblockingServer.FrameBuffer a;

        public final void run()
        {
            a.invoke();
        }

        public a(TNonblockingServer.FrameBuffer framebuffer)
        {
            a = framebuffer;
        }
    }


    protected final int MAX_WORKER_THREADS;
    protected final int MIN_WORKER_THREADS;
    protected final TimeUnit STOP_TIMEOUT_UNIT;
    protected final int STOP_TIMEOUT_VAL;
    private ExecutorService a;

    public THsHaServer(TProcessor tprocessor, TNonblockingServerTransport tnonblockingservertransport)
    {
        this(tprocessor, tnonblockingservertransport, new Options());
    }

    public THsHaServer(TProcessor tprocessor, TNonblockingServerTransport tnonblockingservertransport, TProtocolFactory tprotocolfactory)
    {
        this(tprocessor, tnonblockingservertransport, tprotocolfactory, new Options());
    }

    public THsHaServer(TProcessor tprocessor, TNonblockingServerTransport tnonblockingservertransport, TProtocolFactory tprotocolfactory, Options options)
    {
        this(tprocessor, tnonblockingservertransport, new org.apache.thrift.transport.TFramedTransport.Factory(), tprotocolfactory);
    }

    public THsHaServer(TProcessor tprocessor, TNonblockingServerTransport tnonblockingservertransport, Options options)
    {
        this(new TProcessorFactory(tprocessor), tnonblockingservertransport, options);
    }

    public THsHaServer(TProcessor tprocessor, TNonblockingServerTransport tnonblockingservertransport, org.apache.thrift.transport.TFramedTransport.Factory factory, TProtocolFactory tprotocolfactory)
    {
        this(new TProcessorFactory(tprocessor), tnonblockingservertransport, factory, tprotocolfactory);
    }

    public THsHaServer(TProcessor tprocessor, TNonblockingServerTransport tnonblockingservertransport, org.apache.thrift.transport.TFramedTransport.Factory factory, org.apache.thrift.transport.TFramedTransport.Factory factory1, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1)
    {
        this(new TProcessorFactory(tprocessor), tnonblockingservertransport, factory, factory1, tprotocolfactory, tprotocolfactory1);
    }

    public THsHaServer(TProcessorFactory tprocessorfactory, TNonblockingServerTransport tnonblockingservertransport)
    {
        this(tprocessorfactory, tnonblockingservertransport, new Options());
    }

    public THsHaServer(TProcessorFactory tprocessorfactory, TNonblockingServerTransport tnonblockingservertransport, Options options)
    {
        this(tprocessorfactory, tnonblockingservertransport, new org.apache.thrift.transport.TFramedTransport.Factory(), ((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())), options);
    }

    public THsHaServer(TProcessorFactory tprocessorfactory, TNonblockingServerTransport tnonblockingservertransport, org.apache.thrift.transport.TFramedTransport.Factory factory, TProtocolFactory tprotocolfactory)
    {
        this(tprocessorfactory, tnonblockingservertransport, factory, factory, tprotocolfactory, tprotocolfactory, new Options());
    }

    public THsHaServer(TProcessorFactory tprocessorfactory, TNonblockingServerTransport tnonblockingservertransport, org.apache.thrift.transport.TFramedTransport.Factory factory, TProtocolFactory tprotocolfactory, Options options)
    {
        this(tprocessorfactory, tnonblockingservertransport, factory, factory, tprotocolfactory, tprotocolfactory, options);
    }

    public THsHaServer(TProcessorFactory tprocessorfactory, TNonblockingServerTransport tnonblockingservertransport, org.apache.thrift.transport.TFramedTransport.Factory factory, org.apache.thrift.transport.TFramedTransport.Factory factory1, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1)
    {
        this(tprocessorfactory, tnonblockingservertransport, factory, factory1, tprotocolfactory, tprotocolfactory1, new Options());
    }

    public THsHaServer(TProcessorFactory tprocessorfactory, TNonblockingServerTransport tnonblockingservertransport, org.apache.thrift.transport.TFramedTransport.Factory factory, org.apache.thrift.transport.TFramedTransport.Factory factory1, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1, Options options)
    {
        super(tprocessorfactory, tnonblockingservertransport, factory, factory1, tprotocolfactory, tprotocolfactory1, options);
        MIN_WORKER_THREADS = options.minWorkerThreads;
        MAX_WORKER_THREADS = options.maxWorkerThreads;
        STOP_TIMEOUT_VAL = options.stopTimeoutVal;
        STOP_TIMEOUT_UNIT = options.stopTimeoutUnit;
    }

    protected void gracefullyShutdownInvokerPool()
    {
        long l;
        long l1;
        a.shutdown();
        l = System.currentTimeMillis();
        l1 = 10000L;
_L2:
        if (l1 < 0L)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        a.awaitTermination(l1, TimeUnit.MILLISECONDS);
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        long l2 = System.currentTimeMillis();
        l1 -= l2 - l;
        l = l2;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void requestInvoke(TNonblockingServer.FrameBuffer framebuffer)
    {
        a.execute(new a(framebuffer));
    }

    public void serve()
    {
        while (!startInvokerPool() || !startListening() || !startSelectorThread()) 
        {
            return;
        }
        joinSelector();
        gracefullyShutdownInvokerPool();
        stopListening();
    }

    protected boolean startInvokerPool()
    {
        LinkedBlockingQueue linkedblockingqueue = new LinkedBlockingQueue();
        a = new ThreadPoolExecutor(MIN_WORKER_THREADS, MAX_WORKER_THREADS, STOP_TIMEOUT_VAL, STOP_TIMEOUT_UNIT, linkedblockingqueue);
        return true;
    }
}
