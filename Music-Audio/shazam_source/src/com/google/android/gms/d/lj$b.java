// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.io.FilterInputStream;
import java.io.InputStream;

// Referenced classes of package com.google.android.gms.d:
//            lj

private static final class <init> extends FilterInputStream
{

    private int a;

    static int a(<init> <init>1)
    {
        return <init>1.a;
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

    private (InputStream inputstream)
    {
        super(inputstream);
        a = 0;
    }

    a(InputStream inputstream, byte byte0)
    {
        this(inputstream);
    }
}
