// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


// Referenced classes of package org.apache.thrift.transport:
//            TTransportFactory, TFramedTransport, TTransport

public static class  extends TTransportFactory
{

    public TTransport getTransport(TTransport ttransport)
    {
        return new TFramedTransport(ttransport);
    }

    public ()
    {
    }
}
