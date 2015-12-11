// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.server:
//            TServer

public class TThreadPoolServer extends TServer
{
    public static class Options
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

        private TTransport a;
        private TThreadPoolServer b;

        public final void run()
        {
            Object obj2;
            Object obj5;
            obj5 = null;
            obj2 = null;
            Object obj;
            TProcessor tprocessor;
            tprocessor = b.processorFactory_.getProcessor(a);
            obj = b.inputTransportFactory_.getTransport(a);
            Object obj1 = b.outputTransportFactory_.getTransport(a);
            obj5 = obj1;
            org.apache.thrift.protocol.TProtocol tprotocol = b.inputProtocolFactory_.getProtocol(((TTransport) (obj)));
            obj5 = obj1;
            org.apache.thrift.protocol.TProtocol tprotocol1 = b.outputProtocolFactory_.getProtocol(((TTransport) (obj1)));
_L2:
            Object obj4;
            obj2 = obj1;
            obj4 = obj;
            obj5 = obj1;
            if (TThreadPoolServer.a(b))
            {
                break MISSING_BLOCK_LABEL_131;
            }
            obj5 = obj1;
            boolean flag = tprocessor.process(tprotocol, tprotocol1);
            if (flag) goto _L2; else goto _L1
_L1:
            obj4 = obj;
            obj2 = obj1;
_L8:
            if (obj4 != null)
            {
                ((TTransport) (obj4)).close();
            }
            if (obj2 != null)
            {
                ((TTransport) (obj2)).close();
            }
            return;
            Object obj3;
            obj3;
            obj1 = null;
            obj = null;
_L6:
            TThreadPoolServer.a().error("Thrift error occurred during processing of message.", ((Throwable) (obj3)));
            obj3 = obj;
            obj4 = obj1;
            continue; /* Loop/switch isn't completed */
            obj3;
            obj1 = null;
            obj = null;
_L4:
            TThreadPoolServer.a().error("Error occurred during processing of message.", ((Throwable) (obj3)));
            obj3 = obj;
            obj4 = obj1;
            continue; /* Loop/switch isn't completed */
            obj3;
            obj1 = obj;
            obj = null;
            continue; /* Loop/switch isn't completed */
            obj3;
            obj4 = obj;
            obj = obj1;
            obj1 = obj4;
            if (true) goto _L4; else goto _L3
_L3:
            obj3;
            obj1 = obj;
            obj = null;
            continue; /* Loop/switch isn't completed */
            obj3;
            obj4 = obj;
            obj = obj1;
            obj1 = obj4;
            if (true) goto _L6; else goto _L5
_L5:
            obj;
            obj4 = null;
            continue; /* Loop/switch isn't completed */
            TTransportException ttransportexception;
            ttransportexception;
            obj3 = obj5;
            obj4 = obj;
            if (true) goto _L8; else goto _L7
_L7:
        }

        a(TTransport ttransport)
        {
            this(ttransport, (byte)0);
        }

        private a(TTransport ttransport, byte byte0)
        {
            b = TThreadPoolServer.this;
            super();
            a = ttransport;
        }
    }


    private static final Logger a = LoggerFactory.getLogger(org/apache/thrift/server/TThreadPoolServer.getName());
    private ExecutorService b;
    private volatile boolean c;
    private Options d;

    public TThreadPoolServer(TProcessor tprocessor, TServerTransport tservertransport)
    {
        this(tprocessor, tservertransport, new TTransportFactory(), new TTransportFactory(), ((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())), ((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())));
    }

    public TThreadPoolServer(TProcessor tprocessor, TServerTransport tservertransport, TProtocolFactory tprotocolfactory)
    {
        this(tprocessor, tservertransport, new TTransportFactory(), new TTransportFactory(), tprotocolfactory, tprotocolfactory);
    }

    public TThreadPoolServer(TProcessor tprocessor, TServerTransport tservertransport, TTransportFactory ttransportfactory, TProtocolFactory tprotocolfactory)
    {
        this(tprocessor, tservertransport, ttransportfactory, ttransportfactory, tprotocolfactory, tprotocolfactory);
    }

    public TThreadPoolServer(TProcessor tprocessor, TServerTransport tservertransport, TTransportFactory ttransportfactory, TTransportFactory ttransportfactory1, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1)
    {
        this(new TProcessorFactory(tprocessor), tservertransport, ttransportfactory, ttransportfactory1, tprotocolfactory, tprotocolfactory1);
    }

    public TThreadPoolServer(TProcessor tprocessor, TServerTransport tservertransport, TTransportFactory ttransportfactory, TTransportFactory ttransportfactory1, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1, Options options)
    {
        this(new TProcessorFactory(tprocessor), tservertransport, ttransportfactory, ttransportfactory1, tprotocolfactory, tprotocolfactory1, options);
    }

    public TThreadPoolServer(TProcessorFactory tprocessorfactory, TServerTransport tservertransport)
    {
        this(tprocessorfactory, tservertransport, new TTransportFactory(), new TTransportFactory(), ((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())), ((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())));
    }

    public TThreadPoolServer(TProcessorFactory tprocessorfactory, TServerTransport tservertransport, TTransportFactory ttransportfactory, TProtocolFactory tprotocolfactory)
    {
        this(tprocessorfactory, tservertransport, ttransportfactory, ttransportfactory, tprotocolfactory, tprotocolfactory);
    }

    public TThreadPoolServer(TProcessorFactory tprocessorfactory, TServerTransport tservertransport, TTransportFactory ttransportfactory, TTransportFactory ttransportfactory1, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1)
    {
        super(tprocessorfactory, tservertransport, ttransportfactory, ttransportfactory1, tprotocolfactory, tprotocolfactory1);
        d = new Options();
        b = Executors.newCachedThreadPool();
    }

    public TThreadPoolServer(TProcessorFactory tprocessorfactory, TServerTransport tservertransport, TTransportFactory ttransportfactory, TTransportFactory ttransportfactory1, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1, Options options)
    {
        super(tprocessorfactory, tservertransport, ttransportfactory, ttransportfactory1, tprotocolfactory, tprotocolfactory1);
        b = null;
        tprocessorfactory = new SynchronousQueue();
        b = new ThreadPoolExecutor(options.minWorkerThreads, options.maxWorkerThreads, 60L, TimeUnit.SECONDS, tprocessorfactory);
        d = options;
    }

    static Logger a()
    {
        return a;
    }

    static boolean a(TThreadPoolServer tthreadpoolserver)
    {
        return tthreadpoolserver.c;
    }

    public void serve()
    {
        serverTransport_.listen();
        c = false;
        TTransportException ttransportexception1;
        do
        {
            if (c)
            {
                break;
            }
            try
            {
                a a1 = new a(serverTransport_.accept());
                b.execute(a1);
            }
            catch (TTransportException ttransportexception)
            {
                if (!c)
                {
                    a.warn("Transport error occurred during acceptance of message.", ttransportexception);
                }
            }
        } while (true);
        b.shutdown();
        long l1 = d.stopTimeoutUnit.toMillis(d.stopTimeoutVal);
        long l = System.currentTimeMillis();
        while (l1 >= 0L) 
        {
            try
            {
                b.awaitTermination(l1, TimeUnit.MILLISECONDS);
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                long l2 = System.currentTimeMillis();
                l1 -= l2 - l;
                l = l2;
            }
        }
          goto _L1
        ttransportexception1;
        a.error("Error occurred during listening.", ttransportexception1);
_L3:
        return;
_L1:
        if (true) goto _L3; else goto _L2
_L2:
    }

    public void stop()
    {
        c = true;
        serverTransport_.interrupt();
    }

}
