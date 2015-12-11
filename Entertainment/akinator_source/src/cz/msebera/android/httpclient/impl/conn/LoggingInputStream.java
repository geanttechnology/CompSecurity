// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            Wire

class LoggingInputStream extends InputStream
{

    private final InputStream in;
    private final Wire wire;

    public LoggingInputStream(InputStream inputstream, Wire wire1)
    {
        in = inputstream;
        wire = wire1;
    }

    public int available()
        throws IOException
    {
        int i;
        try
        {
            i = in.available();
        }
        catch (IOException ioexception)
        {
            wire.input((new StringBuilder()).append("[available] I/O error : ").append(ioexception.getMessage()).toString());
            throw ioexception;
        }
        return i;
    }

    public void close()
        throws IOException
    {
        try
        {
            in.close();
            return;
        }
        catch (IOException ioexception)
        {
            wire.input((new StringBuilder()).append("[close] I/O error: ").append(ioexception.getMessage()).toString());
            throw ioexception;
        }
    }

    public void mark(int i)
    {
        super.mark(i);
    }

    public boolean markSupported()
    {
        return false;
    }

    public int read()
        throws IOException
    {
        int i;
        try
        {
            i = in.read();
        }
        catch (IOException ioexception)
        {
            wire.input((new StringBuilder()).append("[read] I/O error: ").append(ioexception.getMessage()).toString());
            throw ioexception;
        }
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        wire.input("end of stream");
        return i;
        wire.input(i);
        return i;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        int i;
        try
        {
            i = in.read(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            wire.input((new StringBuilder()).append("[read] I/O error: ").append(abyte0.getMessage()).toString());
            throw abyte0;
        }
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        wire.input("end of stream");
        return i;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        wire.input(abyte0, 0, i);
        return i;
        return i;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        try
        {
            j = in.read(abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            wire.input((new StringBuilder()).append("[read] I/O error: ").append(abyte0.getMessage()).toString());
            throw abyte0;
        }
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        wire.input("end of stream");
        return j;
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        wire.input(abyte0, i, j);
        return j;
        return j;
    }

    public void reset()
        throws IOException
    {
        super.reset();
    }

    public long skip(long l)
        throws IOException
    {
        try
        {
            l = super.skip(l);
        }
        catch (IOException ioexception)
        {
            wire.input((new StringBuilder()).append("[skip] I/O error: ").append(ioexception.getMessage()).toString());
            throw ioexception;
        }
        return l;
    }
}
