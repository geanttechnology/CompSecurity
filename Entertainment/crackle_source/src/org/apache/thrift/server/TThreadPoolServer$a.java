// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;
import org.slf4j.Logger;

// Referenced classes of package org.apache.thrift.server:
//            TThreadPoolServer

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

    on(TThreadPoolServer tthreadpoolserver, TTransport ttransport)
    {
        this(tthreadpoolserver, ttransport, (byte)0);
    }

    private <init>(TThreadPoolServer tthreadpoolserver, TTransport ttransport, byte byte0)
    {
        b = tthreadpoolserver;
        super();
        a = ttransport;
    }
}
