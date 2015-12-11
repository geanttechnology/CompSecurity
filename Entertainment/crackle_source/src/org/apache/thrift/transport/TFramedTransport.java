// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.ByteArrayInputStream;
import org.apache.thrift.TByteArrayOutputStream;

// Referenced classes of package org.apache.thrift.transport:
//            TTransport, TTransportException, TTransportFactory

public class TFramedTransport extends TTransport
{
    public static class Factory extends TTransportFactory
    {

        public TTransport getTransport(TTransport ttransport)
        {
            return new TFramedTransport(ttransport);
        }

        public Factory()
        {
        }
    }


    private TTransport a;
    private final TByteArrayOutputStream b = new TByteArrayOutputStream(1024);
    private ByteArrayInputStream c;

    public TFramedTransport(TTransport ttransport)
    {
        a = null;
        c = null;
        a = ttransport;
    }

    public void close()
    {
        a.close();
    }

    public void flush()
        throws TTransportException
    {
        byte abyte0[] = b.get();
        int i = b.len();
        b.reset();
        byte byte0 = (byte)(i >> 24 & 0xff);
        byte byte1 = (byte)(i >> 16 & 0xff);
        byte byte2 = (byte)(i >> 8 & 0xff);
        byte byte3 = (byte)(i & 0xff);
        a.write(new byte[] {
            byte0, byte1, byte2, byte3
        }, 0, 4);
        a.write(abyte0, 0, i);
        a.flush();
    }

    public boolean isOpen()
    {
        return a.isOpen();
    }

    public void open()
        throws TTransportException
    {
        a.open();
    }

    public int read(byte abyte0[], int i, int j)
        throws TTransportException
    {
        if (c != null)
        {
            int k = c.read(abyte0, i, j);
            if (k > 0)
            {
                return k;
            }
        }
        byte abyte1[] = new byte[4];
        a.readAll(abyte1, 0, 4);
        int l = abyte1[0];
        byte byte0 = abyte1[1];
        byte byte1 = abyte1[2];
        l = abyte1[3] & 0xff | ((l & 0xff) << 24 | (byte0 & 0xff) << 16 | (byte1 & 0xff) << 8);
        if (l < 0)
        {
            throw new TTransportException((new StringBuilder()).append("Read a negative frame size (").append(l).append(")!").toString());
        } else
        {
            byte abyte2[] = new byte[l];
            a.readAll(abyte2, 0, l);
            c = new ByteArrayInputStream(abyte2);
            return c.read(abyte0, i, j);
        }
    }

    public void write(byte abyte0[], int i, int j)
        throws TTransportException
    {
        b.write(abyte0, i, j);
    }
}
