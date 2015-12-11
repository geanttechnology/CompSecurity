// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift:
//            TProcessor

public class TProcessorFactory
{

    private final TProcessor a;

    public TProcessorFactory(TProcessor tprocessor)
    {
        a = tprocessor;
    }

    public TProcessor getProcessor(TTransport ttransport)
    {
        return a;
    }
}
