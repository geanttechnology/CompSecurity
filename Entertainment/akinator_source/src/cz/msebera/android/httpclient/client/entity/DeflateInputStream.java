// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class DeflateInputStream extends InputStream
{
    static class DeflateStream extends InflaterInputStream
    {

        private boolean closed;

        public void close()
            throws IOException
        {
            if (closed)
            {
                return;
            } else
            {
                closed = true;
                inf.end();
                super.close();
                return;
            }
        }

        public DeflateStream(InputStream inputstream, Inflater inflater)
        {
            super(inputstream, inflater);
            closed = false;
        }
    }


    private InputStream sourceStream;

    public DeflateInputStream(InputStream inputstream)
        throws IOException
    {
        Object obj;
        PushbackInputStream pushbackinputstream;
        byte abyte0[];
        int i;
        obj = new byte[6];
        pushbackinputstream = new PushbackInputStream(inputstream, obj.length);
        i = pushbackinputstream.read(((byte []) (obj)));
        if (i == -1)
        {
            throw new IOException("Unable to read the response");
        }
        abyte0 = new byte[1];
        inputstream = new Inflater();
_L8:
        int j = inputstream.inflate(abyte0);
        if (j != 0) goto _L2; else goto _L1
_L1:
        DataFormatException dataformatexception;
        if (inputstream.finished())
        {
            throw new IOException("Unable to read the response");
        }
          goto _L3
_L6:
        pushbackinputstream.unread(((byte []) (obj)), 0, i);
        sourceStream = new DeflateStream(pushbackinputstream, new Inflater(true));
        inputstream.end();
        return;
_L3:
        if (!inputstream.needsDictionary()) goto _L4; else goto _L2
_L2:
        if (j != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            throw new IOException("Unable to read the response");
        }
        // Misplaced declaration of an exception variable
        catch (DataFormatException dataformatexception) { }
        finally
        {
            inputstream.end();
        }
        if (true) goto _L6; else goto _L5
        throw obj;
_L4:
        if (!inputstream.needsInput()) goto _L8; else goto _L7
_L7:
        inputstream.setInput(((byte []) (obj)));
          goto _L8
_L5:
        pushbackinputstream.unread(((byte []) (obj)), 0, i);
        sourceStream = new DeflateStream(pushbackinputstream, new Inflater());
        inputstream.end();
        return;
    }

    public int available()
        throws IOException
    {
        return sourceStream.available();
    }

    public void close()
        throws IOException
    {
        sourceStream.close();
    }

    public void mark(int i)
    {
        sourceStream.mark(i);
    }

    public boolean markSupported()
    {
        return sourceStream.markSupported();
    }

    public int read()
        throws IOException
    {
        return sourceStream.read();
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return sourceStream.read(abyte0);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        return sourceStream.read(abyte0, i, j);
    }

    public void reset()
        throws IOException
    {
        sourceStream.reset();
    }

    public long skip(long l)
        throws IOException
    {
        return sourceStream.skip(l);
    }
}
