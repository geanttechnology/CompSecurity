// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TJSONProtocol

protected class b
{

    private boolean a;
    private byte b[];
    private TJSONProtocol c;

    protected byte peek()
        throws TException
    {
        if (!a)
        {
            c.trans_.readAll(b, 0, 1);
        }
        a = true;
        return b[0];
    }

    protected byte read()
        throws TException
    {
        if (a)
        {
            a = false;
        } else
        {
            c.trans_.readAll(b, 0, 1);
        }
        return b[0];
    }

    protected (TJSONProtocol tjsonprotocol)
    {
        c = tjsonprotocol;
        super();
        b = new byte[1];
    }
}
