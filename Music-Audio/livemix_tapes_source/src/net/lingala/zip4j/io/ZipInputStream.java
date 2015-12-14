// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.io;

import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.unzip.UnzipEngine;

// Referenced classes of package net.lingala.zip4j.io:
//            BaseInputStream

public class ZipInputStream extends InputStream
{

    private BaseInputStream is;

    public ZipInputStream(BaseInputStream baseinputstream)
    {
        is = baseinputstream;
    }

    public int available()
        throws IOException
    {
        return is.available();
    }

    public void close()
        throws IOException
    {
        close(false);
    }

    public void close(boolean flag)
        throws IOException
    {
        try
        {
            is.close();
        }
        catch (ZipException zipexception)
        {
            throw new IOException(zipexception.getMessage());
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (is.getUnzipEngine() != null)
        {
            is.getUnzipEngine().checkCRC();
        }
    }

    public int read()
        throws IOException
    {
        int i = is.read();
        if (i != -1)
        {
            is.getUnzipEngine().updateCRC(i);
        }
        return i;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        j = is.read(abyte0, i, j);
        if (j > 0 && is.getUnzipEngine() != null)
        {
            is.getUnzipEngine().updateCRC(abyte0, i, j);
        }
        return j;
    }

    public long skip(long l)
        throws IOException
    {
        return is.skip(l);
    }
}
