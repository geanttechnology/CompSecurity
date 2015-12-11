// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;

public abstract class TServer
{

    protected TProtocolFactory inputProtocolFactory_;
    protected TTransportFactory inputTransportFactory_;
    protected TProtocolFactory outputProtocolFactory_;
    protected TTransportFactory outputTransportFactory_;
    protected TProcessorFactory processorFactory_;
    protected TServerTransport serverTransport_;

    protected TServer(TProcessorFactory tprocessorfactory, TServerTransport tservertransport)
    {
        this(tprocessorfactory, tservertransport, new TTransportFactory(), new TTransportFactory(), ((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())), ((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())));
    }

    protected TServer(TProcessorFactory tprocessorfactory, TServerTransport tservertransport, TTransportFactory ttransportfactory)
    {
        this(tprocessorfactory, tservertransport, ttransportfactory, ttransportfactory, ((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())), ((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())));
    }

    protected TServer(TProcessorFactory tprocessorfactory, TServerTransport tservertransport, TTransportFactory ttransportfactory, TProtocolFactory tprotocolfactory)
    {
        this(tprocessorfactory, tservertransport, ttransportfactory, ttransportfactory, tprotocolfactory, tprotocolfactory);
    }

    protected TServer(TProcessorFactory tprocessorfactory, TServerTransport tservertransport, TTransportFactory ttransportfactory, TTransportFactory ttransportfactory1, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1)
    {
        processorFactory_ = tprocessorfactory;
        serverTransport_ = tservertransport;
        inputTransportFactory_ = ttransportfactory;
        outputTransportFactory_ = ttransportfactory1;
        inputProtocolFactory_ = tprotocolfactory;
        outputProtocolFactory_ = tprotocolfactory1;
    }

    public abstract void serve();

    public void stop()
    {
    }
}
