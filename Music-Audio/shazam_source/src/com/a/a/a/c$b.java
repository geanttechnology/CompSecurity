// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.FilterInputStream;
import java.io.InputStream;

// Referenced classes of package com.a.a.a:
//            c

private static final class tream extends FilterInputStream
{

    private int a;

    static int a(InputStream inputstream)
    {
        return inputstream.a;
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

    private tream(InputStream inputstream)
    {
        super(inputstream);
        a = 0;
    }

    tream(InputStream inputstream, byte byte0)
    {
        this(inputstream);
    }
}
