// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import android.support.v7.aqk;
import java.io.Closeable;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal:
//            DiskLruCache, Util

public final class <init>
    implements Closeable
{

    private final String key;
    private final long lengths[];
    private final long sequenceNumber;
    private final aqk sources[];
    final DiskLruCache this$0;

    public void close()
    {
        aqk aaqk[] = sources;
        int j = aaqk.length;
        for (int i = 0; i < j; i++)
        {
            Util.closeQuietly(aaqk[i]);
        }

    }

    public sources edit()
        throws IOException
    {
        return DiskLruCache.access$2200(DiskLruCache.this, key, sequenceNumber);
    }

    public long getLength(int i)
    {
        return lengths[i];
    }

    public aqk getSource(int i)
    {
        return sources[i];
    }

    public String key()
    {
        return key;
    }


    private (String s, long l, aqk aaqk[], long al[])
    {
        this$0 = DiskLruCache.this;
        super();
        key = s;
        sequenceNumber = l;
        sources = aaqk;
        lengths = al;
    }

    lengths(String s, long l, aqk aaqk[], long al[], lengths lengths1)
    {
        this(s, l, aaqk, al);
    }
}
