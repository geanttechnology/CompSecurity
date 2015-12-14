// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.io.Closeable;
import okio.r;

// Referenced classes of package com.squareup.okhttp.internal:
//            Util, DiskLruCache

public final class <init>
    implements Closeable
{

    private final String key;
    private final long lengths[];
    private final long sequenceNumber;
    private final r sources[];
    final DiskLruCache this$0;

    public void close()
    {
        r ar[] = sources;
        int j = ar.length;
        for (int i = 0; i < j; i++)
        {
            Util.closeQuietly(ar[i]);
        }

    }

    public sources edit()
    {
        return DiskLruCache.access$1900(DiskLruCache.this, key, sequenceNumber);
    }

    public long getLength(int i)
    {
        return lengths[i];
    }

    public r getSource(int i)
    {
        return sources[i];
    }

    public String getString(int i)
    {
        return DiskLruCache.access$2000(getSource(i));
    }

    private (String s, long l, r ar[], long al[])
    {
        this$0 = DiskLruCache.this;
        super();
        key = s;
        sequenceNumber = l;
        sources = ar;
        lengths = al;
    }

    lengths(String s, long l, r ar[], long al[], lengths lengths1)
    {
        this(s, l, ar, al);
    }
}
