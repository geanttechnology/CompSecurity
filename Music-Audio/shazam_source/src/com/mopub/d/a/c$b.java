// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d.a;

import java.io.FilterInputStream;
import java.io.InputStream;

// Referenced classes of package com.mopub.d.a:
//            c

private static final class m extends FilterInputStream
{

    private int a;

    static int a(tStream tstream)
    {
        return tstream.a;
    }

    public final int read()
    {
        int i = super.read();
        if (i != -1)
        {
            a = a + 1;
        }
        return i;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        i = super.read(abyte0, i, j);
        if (i != -1)
        {
            a = a + i;
        }
        return i;
    }

    private m(InputStream inputstream)
    {
        super(inputstream);
        a = 0;
    }

    m(InputStream inputstream, byte byte0)
    {
        this(inputstream);
    }
}
