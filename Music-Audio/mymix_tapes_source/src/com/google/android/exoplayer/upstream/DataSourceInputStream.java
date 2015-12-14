// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            DataSource, DataSpec

public final class DataSourceInputStream extends InputStream
{

    private boolean closed;
    private final DataSource dataSource;
    private final DataSpec dataSpec;
    private boolean opened;
    private final byte singleByteArray[] = new byte[1];

    public DataSourceInputStream(DataSource datasource, DataSpec dataspec)
    {
        opened = false;
        closed = false;
        dataSource = datasource;
        dataSpec = dataspec;
    }

    private void checkOpened()
        throws IOException
    {
        if (!opened)
        {
            dataSource.open(dataSpec);
            opened = true;
        }
    }

    public void close()
        throws IOException
    {
        if (!closed)
        {
            dataSource.close();
            closed = true;
        }
    }

    public void open()
        throws IOException
    {
        checkOpened();
    }

    public int read()
        throws IOException
    {
        if (read(singleByteArray) == -1)
        {
            return -1;
        } else
        {
            return singleByteArray[0] & 0xff;
        }
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        boolean flag;
        if (!closed)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        checkOpened();
        return dataSource.read(abyte0, i, j);
    }

    public long skip(long l)
        throws IOException
    {
        boolean flag;
        if (!closed)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        checkOpened();
        return super.skip(l);
    }
}
