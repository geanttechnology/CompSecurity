// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

// Referenced classes of package com.bumptech.glide.load.data:
//            DataFetcher

public class ByteArrayFetcher
    implements DataFetcher
{

    private final byte bytes[];
    private final String id;

    public ByteArrayFetcher(byte abyte0[], String s)
    {
        bytes = abyte0;
        id = s;
    }

    public void cancel()
    {
    }

    public void cleanup()
    {
    }

    public String getId()
    {
        return id;
    }

    public InputStream loadData(Priority priority)
    {
        return new ByteArrayInputStream(bytes);
    }

    public volatile Object loadData(Priority priority)
        throws Exception
    {
        return loadData(priority);
    }
}
