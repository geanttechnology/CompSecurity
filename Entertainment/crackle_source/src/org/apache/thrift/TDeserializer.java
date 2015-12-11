// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.transport.TIOStreamTransport;

// Referenced classes of package org.apache.thrift:
//            TException, TBase

public class TDeserializer
{

    private final TProtocolFactory a;

    public TDeserializer()
    {
        this(((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())));
    }

    public TDeserializer(TProtocolFactory tprotocolfactory)
    {
        a = tprotocolfactory;
    }

    public void deserialize(TBase tbase, String s, String s1)
        throws TException
    {
        try
        {
            deserialize(tbase, s.getBytes(s1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TBase tbase)
        {
            throw new TException((new StringBuilder()).append("JVM DOES NOT SUPPORT ENCODING: ").append(s1).toString());
        }
    }

    public void deserialize(TBase tbase, byte abyte0[])
        throws TException
    {
        tbase.read(a.getProtocol(new TIOStreamTransport(new ByteArrayInputStream(abyte0))));
    }

    public transient void partialDeserialize(TBase tbase, byte abyte0[], int ai[])
        throws TException
    {
        if (ai.length != 0) goto _L2; else goto _L1
_L1:
        deserialize(tbase, abyte0);
_L4:
        return;
_L2:
        abyte0 = a.getProtocol(new TIOStreamTransport(new ByteArrayInputStream(abyte0)));
        int i = 0;
        abyte0.readStructBegin();
label0:
        do
        {
label1:
            {
                if (i >= ai.length)
                {
                    break label1;
                }
                TField tfield = abyte0.readFieldBegin();
                if (tfield.type == 0 || tfield.id > ai[i])
                {
                    break label0;
                }
                if (tfield.id != ai[i])
                {
                    TProtocolUtil.skip(abyte0, tfield.type);
                    abyte0.readFieldEnd();
                } else
                {
                    int j = i + 1;
                    i = j;
                    if (j < ai.length)
                    {
                        abyte0.readStructBegin();
                        i = j;
                    }
                }
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        tbase.read(abyte0);
        return;
    }

    public void toString(TBase tbase, String s)
        throws TException
    {
        deserialize(tbase, s.getBytes());
    }
}
