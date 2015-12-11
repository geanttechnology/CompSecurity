// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import d.ab;
import java.io.Closeable;

// Referenced classes of package com.squareup.okhttp.internal:
//            Util, DiskLruCache

public final class <init>
    implements Closeable
{

    private final String key;
    private final long lengths[];
    private final long sequenceNumber;
    private final ab sources[];
    final DiskLruCache this$0;

    public final void close()
    {
        ab aab[] = sources;
        int j = aab.length;
        for (int i = 0; i < j; i++)
        {
            Util.closeQuietly(aab[i]);
        }

    }

    public final sources edit()
    {
        return DiskLruCache.access$2200(DiskLruCache.this, key, sequenceNumber);
    }

    public final long getLength(int i)
    {
        return lengths[i];
    }

    public final ab getSource(int i)
    {
        return sources[i];
    }

    public final String key()
    {
        return key;
    }


    private (String s, long l, ab aab[], long al[])
    {
        this$0 = DiskLruCache.this;
        super();
        key = s;
        sequenceNumber = l;
        sources = aab;
        lengths = al;
    }

    lengths(String s, long l, ab aab[], long al[], lengths lengths1)
    {
        this(s, l, aab, al);
    }
}
