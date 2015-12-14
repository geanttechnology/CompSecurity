// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import java.io.Closeable;
import java.io.InputStream;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            e

public final class i
    implements Closeable
{

    final e a;
    private final String b;
    private final long c;
    private final InputStream d[];

    private i(e e1, String s, long l, InputStream ainputstream[])
    {
        a = e1;
        super();
        b = s;
        c = l;
        d = ainputstream;
    }

    i(e e1, String s, long l, InputStream ainputstream[], e._cls1 _pcls1)
    {
        this(e1, s, l, ainputstream);
    }

    public InputStream a(int j)
    {
        return d[j];
    }

    public void close()
    {
        InputStream ainputstream[] = d;
        int k = ainputstream.length;
        for (int j = 0; j < k; j++)
        {
            e.a(ainputstream[j]);
        }

    }
}
