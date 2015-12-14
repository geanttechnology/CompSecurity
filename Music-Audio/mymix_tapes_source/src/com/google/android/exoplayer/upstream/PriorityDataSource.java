// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            DataSource, NetworkLock, DataSpec

public final class PriorityDataSource
    implements DataSource
{

    private final int priority;
    private final DataSource upstream;

    public PriorityDataSource(int i, DataSource datasource)
    {
        priority = i;
        upstream = (DataSource)Assertions.checkNotNull(datasource);
    }

    public void close()
        throws IOException
    {
        upstream.close();
    }

    public long open(DataSpec dataspec)
        throws IOException
    {
        NetworkLock.instance.proceedOrThrow(priority);
        return upstream.open(dataspec);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        NetworkLock.instance.proceedOrThrow(priority);
        return upstream.read(abyte0, i, j);
    }
}
