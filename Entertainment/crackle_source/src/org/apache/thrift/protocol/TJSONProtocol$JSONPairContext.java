// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TJSONProtocol

protected class b extends b
{

    private boolean a;
    private boolean b;
    private TJSONProtocol c;

    protected boolean escapeNum()
    {
        return b;
    }

    protected void read()
        throws TException
    {
        boolean flag;
        if (a)
        {
            a = false;
            flag = true;
        } else
        {
            TJSONProtocol tjsonprotocol = c;
            byte abyte0[];
            if (b)
            {
                abyte0 = TJSONProtocol.b();
            } else
            {
                abyte0 = TJSONProtocol.a();
            }
            tjsonprotocol.readJSONSyntaxChar(abyte0);
            if (!b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        b = flag;
    }

    protected void write()
        throws TException
    {
        boolean flag;
        if (a)
        {
            a = false;
            flag = true;
        } else
        {
            TTransport ttransport = c.trans_;
            byte abyte0[];
            if (b)
            {
                abyte0 = TJSONProtocol.b();
            } else
            {
                abyte0 = TJSONProtocol.a();
            }
            ttransport.write(abyte0);
            if (!b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        b = flag;
    }

    protected (TJSONProtocol tjsonprotocol)
    {
        c = tjsonprotocol;
        super(tjsonprotocol);
        a = true;
        b = true;
    }
}
