// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TJSONProtocol

protected class a extends a
{

    private boolean a;
    private TJSONProtocol b;

    protected void read()
        throws TException
    {
        if (a)
        {
            a = false;
            return;
        } else
        {
            b.readJSONSyntaxChar(TJSONProtocol.a());
            return;
        }
    }

    protected void write()
        throws TException
    {
        if (a)
        {
            a = false;
            return;
        } else
        {
            b.trans_.write(TJSONProtocol.a());
            return;
        }
    }

    protected (TJSONProtocol tjsonprotocol)
    {
        b = tjsonprotocol;
        super(tjsonprotocol);
        a = true;
    }
}
