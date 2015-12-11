// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

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

public class TSimpleServer extends TServer
{

    private static final Logger a = LoggerFactory.getLogger(org/apache/thrift/server/TSimpleServer.getName());
    private boolean b;

    public TSimpleServer(TProcessor tprocessor, TServerTransport tservertransport)
    {
        super(new TProcessorFactory(tprocessor), tservertransport);
        b = false;
    }

    public TSimpleServer(TProcessor tprocessor, TServerTransport tservertransport, TTransportFactory ttransportfactory, TProtocolFactory tprotocolfactory)
    {
        super(new TProcessorFactory(tprocessor), tservertransport, ttransportfactory, tprotocolfactory);
        b = false;
    }

    public TSimpleServer(TProcessor tprocessor, TServerTransport tservertransport, TTransportFactory ttransportfactory, TTransportFactory ttransportfactory1, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1)
    {
        super(new TProcessorFactory(tprocessor), tservertransport, ttransportfactory, ttransportfactory1, tprotocolfactory, tprotocolfactory1);
        b = false;
    }

    public TSimpleServer(TProcessorFactory tprocessorfactory, TServerTransport tservertransport)
    {
        super(tprocessorfactory, tservertransport);
        b = false;
    }

    public TSimpleServer(TProcessorFactory tprocessorfactory, TServerTransport tservertransport, TTransportFactory ttransportfactory, TProtocolFactory tprotocolfactory)
    {
        super(tprocessorfactory, tservertransport, ttransportfactory, tprotocolfactory);
        b = false;
    }

    public TSimpleServer(TProcessorFactory tprocessorfactory, TServerTransport tservertransport, TTransportFactory ttransportfactory, TTransportFactory ttransportfactory1, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1)
    {
        super(tprocessorfactory, tservertransport, ttransportfactory, ttransportfactory1, tprotocolfactory, tprotocolfactory1);
        b = false;
    }

    public void serve()
    {
        b = false;
        serverTransport_.listen();
_L3:
        if (b) goto _L2; else goto _L1
_L1:
        Object obj1 = serverTransport_.accept();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        Object obj;
        Object obj2;
        obj2 = processorFactory_.getProcessor(((TTransport) (obj1)));
        obj = inputTransportFactory_.getTransport(((TTransport) (obj1)));
        obj1 = outputTransportFactory_.getTransport(((TTransport) (obj1)));
        Object obj3;
        org.apache.thrift.protocol.TProtocol tprotocol;
        obj3 = inputProtocolFactory_.getProtocol(((TTransport) (obj)));
        tprotocol = outputProtocolFactory_.getProtocol(((TTransport) (obj1)));
        boolean flag;
        do
        {
            flag = ((TProcessor) (obj2)).process(((org.apache.thrift.protocol.TProtocol) (obj3)), tprotocol);
        } while (flag);
_L8:
        obj2 = obj1;
        obj1 = obj;
        obj = obj2;
_L4:
        if (obj1 != null)
        {
            ((TTransport) (obj1)).close();
        }
        if (obj != null)
        {
            ((TTransport) (obj)).close();
        }
          goto _L3
        obj;
        a.error("Error occurred during listening.", ((Throwable) (obj)));
_L2:
        return;
        obj;
        obj1 = null;
        obj = null;
_L7:
        obj2 = obj;
        obj = obj1;
        obj1 = obj2;
          goto _L4
        Object obj4;
        obj4;
        obj2 = null;
        obj3 = null;
_L6:
        obj = obj2;
        obj1 = obj3;
        if (!b)
        {
            a.error("Thrift error occurred during processing of message.", ((Throwable) (obj4)));
            obj = obj2;
            obj1 = obj3;
        }
          goto _L4
        obj4;
        obj2 = null;
        obj3 = null;
_L5:
        obj = obj2;
        obj1 = obj3;
        if (!b)
        {
            a.error("Error occurred during processing of message.", ((Throwable) (obj4)));
            obj = obj2;
            obj1 = obj3;
        }
          goto _L4
        obj4;
        obj2 = null;
        obj3 = obj;
          goto _L5
        obj4;
        obj2 = obj1;
        obj3 = obj;
          goto _L5
        obj4;
        obj2 = null;
        obj3 = obj;
          goto _L6
        obj4;
        obj2 = obj1;
        obj3 = obj;
          goto _L6
        obj1;
        obj1 = null;
          goto _L7
        TTransportException ttransportexception;
        ttransportexception;
          goto _L7
        obj1 = null;
        obj = null;
          goto _L8
    }

    public void stop()
    {
        b = true;
        serverTransport_.interrupt();
    }

}
