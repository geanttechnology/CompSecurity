// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TSimpleJSONProtocol

protected class first_ extends first_
{

    private TSimpleJSONProtocol a;
    protected boolean first_;

    protected void write()
        throws TException
    {
        if (first_)
        {
            first_ = false;
            return;
        } else
        {
            a.trans_.write(TSimpleJSONProtocol.COMMA);
            return;
        }
    }

    protected (TSimpleJSONProtocol tsimplejsonprotocol)
    {
        a = tsimplejsonprotocol;
        super(tsimplejsonprotocol);
        first_ = true;
    }
}
