// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ao extends FilterInputStream
{

    private final long a;
    private long b;

    public ao(InputStream inputstream, long l)
    {
        super(inputstream);
        a = l;
    }

    private int a(int i)
    {
        b = b + (long)i;
        if (b > a)
        {
            throw new IOException((new StringBuilder()).append("Size limit exceeded: ").append(a).append(" bytes, read ").append(b).append(" bytes!").toString());
        } else
        {
            return i;
        }
    }

    public void close()
    {
        in = null;
    }

    public int read()
    {
        return a(super.read());
    }

    public int read(byte abyte0[])
    {
        return a(super.read(abyte0));
    }

    public int read(byte abyte0[], int i, int j)
    {
        return a(super.read(abyte0, i, j));
    }
}
