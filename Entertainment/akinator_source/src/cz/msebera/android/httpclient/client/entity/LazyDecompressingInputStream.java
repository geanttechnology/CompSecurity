// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.entity;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package cz.msebera.android.httpclient.client.entity:
//            DecompressingEntity

class LazyDecompressingInputStream extends InputStream
{

    private final DecompressingEntity decompressingEntity;
    private final InputStream wrappedStream;
    private InputStream wrapperStream;

    public LazyDecompressingInputStream(InputStream inputstream, DecompressingEntity decompressingentity)
    {
        wrappedStream = inputstream;
        decompressingEntity = decompressingentity;
    }

    private void initWrapper()
        throws IOException
    {
        if (wrapperStream == null)
        {
            wrapperStream = decompressingEntity.decorate(wrappedStream);
        }
    }

    public int available()
        throws IOException
    {
        initWrapper();
        return wrapperStream.available();
    }

    public void close()
        throws IOException
    {
        if (wrapperStream != null)
        {
            wrapperStream.close();
        }
        wrappedStream.close();
        return;
        Exception exception;
        exception;
        wrappedStream.close();
        throw exception;
    }

    public boolean markSupported()
    {
        return false;
    }

    public int read()
        throws IOException
    {
        initWrapper();
        return wrapperStream.read();
    }

    public int read(byte abyte0[])
        throws IOException
    {
        initWrapper();
        return wrapperStream.read(abyte0);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        initWrapper();
        return wrapperStream.read(abyte0, i, j);
    }

    public long skip(long l)
        throws IOException
    {
        initWrapper();
        return wrapperStream.skip(l);
    }
}
