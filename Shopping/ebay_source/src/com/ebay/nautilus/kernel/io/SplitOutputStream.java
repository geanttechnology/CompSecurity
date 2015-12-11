// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.io;

import java.io.IOException;
import java.io.OutputStream;

public class SplitOutputStream extends OutputStream
{

    boolean closed;
    private final OutputStream one;
    private final OutputStream two;

    public SplitOutputStream(OutputStream outputstream, OutputStream outputstream1)
    {
        one = outputstream;
        two = outputstream1;
    }

    public void close()
        throws IOException
    {
        if (!closed) goto _L2; else goto _L1
_L1:
        return;
_L2:
        IOException ioexception;
        IOException ioexception1;
        ioexception = null;
        try
        {
            one.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception) { }
        two.close();
        ioexception1 = ioexception;
_L4:
        closed = true;
        if (ioexception1 != null)
        {
            throw ioexception1;
        }
        if (true) goto _L1; else goto _L3
_L3:
        IOException ioexception2;
        ioexception2;
        ioexception1 = ioexception;
        if (ioexception == null)
        {
            ioexception1 = ioexception2;
        }
          goto _L4
    }

    public void flush()
        throws IOException
    {
        one.flush();
        two.flush();
    }

    public void write(int i)
        throws IOException
    {
        one.write(i);
        two.write(i);
    }

    public void write(byte abyte0[])
        throws IOException
    {
        if (abyte0 != null)
        {
            write(abyte0, 0, abyte0.length);
        }
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        one.write(abyte0, i, j);
        two.write(abyte0, i, j);
    }
}
