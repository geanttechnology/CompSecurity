// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.disklrucache;

import java.io.File;

// Referenced classes of package com.bumptech.glide.disklrucache:
//            DiskLruCache

public final class <init>
{

    private final File files[];
    private final String key;
    private final long lengths[];
    private final long sequenceNumber;
    final DiskLruCache this$0;

    public File getFile(int i)
    {
        return files[i];
    }

    private (String s, long l, File afile[], long al[])
    {
        this$0 = DiskLruCache.this;
        super();
        key = s;
        sequenceNumber = l;
        files = afile;
        lengths = al;
    }

    lengths(String s, long l, File afile[], long al[], lengths lengths1)
    {
        this(s, l, afile, al);
    }
}
