// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TIOStreamTransport;

// Referenced classes of package org.apache.thrift:
//            TException, TBase

public class TSerializer
{

    private final ByteArrayOutputStream a;
    private final TIOStreamTransport b;
    private TProtocol c;

    public TSerializer()
    {
        this(((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())));
    }

    public TSerializer(TProtocolFactory tprotocolfactory)
    {
        a = new ByteArrayOutputStream();
        b = new TIOStreamTransport(a);
        c = tprotocolfactory.getProtocol(b);
    }

    public byte[] serialize(TBase tbase)
        throws TException
    {
        a.reset();
        tbase.write(c);
        return a.toByteArray();
    }

    public String toString(TBase tbase)
        throws TException
    {
        return new String(serialize(tbase));
    }

    public String toString(TBase tbase, String s)
        throws TException
    {
        try
        {
            tbase = new String(serialize(tbase), s);
        }
        // Misplaced declaration of an exception variable
        catch (TBase tbase)
        {
            throw new TException((new StringBuilder()).append("JVM DOES NOT SUPPORT ENCODING: ").append(s).toString());
        }
        return tbase;
    }
}
