// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            Wire

class LoggingOutputStream extends OutputStream
{

    private final OutputStream out;
    private final Wire wire;

    public LoggingOutputStream(OutputStream outputstream, Wire wire1)
    {
        out = outputstream;
        wire = wire1;
    }

    public void close()
        throws IOException
    {
        try
        {
            out.close();
            return;
        }
        catch (IOException ioexception)
        {
            wire.output((new StringBuilder()).append("[close] I/O error: ").append(ioexception.getMessage()).toString());
            throw ioexception;
        }
    }

    public void flush()
        throws IOException
    {
        try
        {
            out.flush();
            return;
        }
        catch (IOException ioexception)
        {
            wire.output((new StringBuilder()).append("[flush] I/O error: ").append(ioexception.getMessage()).toString());
            throw ioexception;
        }
    }

    public void write(int i)
        throws IOException
    {
        try
        {
            wire.output(i);
            return;
        }
        catch (IOException ioexception)
        {
            wire.output((new StringBuilder()).append("[write] I/O error: ").append(ioexception.getMessage()).toString());
            throw ioexception;
        }
    }

    public void write(byte abyte0[])
        throws IOException
    {
        try
        {
            wire.output(abyte0);
            out.write(abyte0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            wire.output((new StringBuilder()).append("[write] I/O error: ").append(abyte0.getMessage()).toString());
        }
        throw abyte0;
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        try
        {
            wire.output(abyte0, i, j);
            out.write(abyte0, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            wire.output((new StringBuilder()).append("[write] I/O error: ").append(abyte0.getMessage()).toString());
        }
        throw abyte0;
    }
}
