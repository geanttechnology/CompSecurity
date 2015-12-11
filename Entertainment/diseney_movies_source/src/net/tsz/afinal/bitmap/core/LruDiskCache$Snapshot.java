// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.bitmap.core;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package net.tsz.afinal.bitmap.core:
//            LruDiskCache

public final class <init>
    implements Closeable
{

    private final InputStream ins[];
    private final String key;
    private final long sequenceNumber;
    final LruDiskCache this$0;

    public void close()
    {
        InputStream ainputstream[] = ins;
        int j = ainputstream.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            LruDiskCache.closeQuietly(ainputstream[i]);
            i++;
        } while (true);
    }

    public tly edit()
        throws IOException
    {
        return LruDiskCache.access$5(LruDiskCache.this, key, sequenceNumber);
    }

    public InputStream getInputStream(int i)
    {
        return ins[i];
    }

    public String getString(int i)
        throws IOException
    {
        return LruDiskCache.access$6(getInputStream(i));
    }

    private (String s, long l, InputStream ainputstream[])
    {
        this$0 = LruDiskCache.this;
        super();
        key = s;
        sequenceNumber = l;
        ins = ainputstream;
    }

    ins(String s, long l, InputStream ainputstream[], ins ins1)
    {
        this(s, l, ainputstream);
    }
}
