// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            yh

private static class <init> extends FilterInputStream
{

    private int a;

    static int a(m m)
    {
        return m.a;
    }

    public int read()
        throws IOException
    {
        int i = super.read();
        if (i != -1)
        {
            a = a + 1;
        }
        return i;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
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

    a(InputStream inputstream, a a1)
    {
        this(inputstream);
    }
}
