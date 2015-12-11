// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK.libcore;

import java.io.Closeable;
import java.io.InputStream;

// Referenced classes of package com.twinprime.TwinPrimeSDK.libcore:
//            DiskLruCache

public final class <init>
    implements Closeable
{

    private final InputStream ins[];
    private final String key;
    private final long sequenceNumber;
    final DiskLruCache this$0;

    public void close()
    {
        InputStream ainputstream[] = ins;
        int j = ainputstream.length;
        for (int i = 0; i < j; i++)
        {
            DiskLruCache.access$1500(ainputstream[i]);
        }

    }

    public InputStream getInputStream(int i)
    {
        return ins[i];
    }

    private (String s, long l, InputStream ainputstream[])
    {
        this$0 = DiskLruCache.this;
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
