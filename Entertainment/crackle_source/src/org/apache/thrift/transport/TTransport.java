// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


// Referenced classes of package org.apache.thrift.transport:
//            TTransportException

public abstract class TTransport
{

    public TTransport()
    {
    }

    public abstract void close();

    public void flush()
        throws TTransportException
    {
    }

    public abstract boolean isOpen();

    public abstract void open()
        throws TTransportException;

    public boolean peek()
    {
        return isOpen();
    }

    public abstract int read(byte abyte0[], int i, int j)
        throws TTransportException;

    public int readAll(byte abyte0[], int i, int j)
        throws TTransportException
    {
        int k;
        int l;
        for (k = 0; k < j; k += l)
        {
            l = read(abyte0, i + k, j - k);
            if (l <= 0)
            {
                throw new TTransportException((new StringBuilder()).append("Cannot read. Remote side has closed. Tried to read ").append(j).append(" bytes, but only got ").append(k).append(" bytes.").toString());
            }
        }

        return k;
    }

    public void write(byte abyte0[])
        throws TTransportException
    {
        write(abyte0, 0, abyte0.length);
    }

    public abstract void write(byte abyte0[], int i, int j)
        throws TTransportException;
}
