// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.vandalsoftware.io;

import java.io.Closeable;
import java.io.InputStream;

// Referenced classes of package com.vandalsoftware.io:
//            DiskLruCache, IoUtils

public static final class <init>
    implements Closeable
{

    private final InputStream ins[];
    private final String paths[];

    public void close()
    {
        InputStream ainputstream[] = ins;
        int j = ainputstream.length;
        for (int i = 0; i < j; i++)
        {
            IoUtils.closeQuietly(ainputstream[i]);
        }

    }

    public InputStream getInputStream(int i)
    {
        return ins[i];
    }

    public String getPath(int i)
    {
        return paths[i];
    }

    private (InputStream ainputstream[], String as[])
    {
        ins = ainputstream;
        paths = as;
    }

    paths(InputStream ainputstream[], String as[], paths paths1)
    {
        this(ainputstream, as);
    }
}
