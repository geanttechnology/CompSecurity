// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.io;

import java.io.OutputStream;

public class c extends OutputStream
{

    protected final OutputStream a;

    public c(OutputStream outputstream)
    {
        a = outputstream;
    }

    public final void close()
    {
    }

    public void flush()
    {
        a.flush();
    }

    public void write(int i)
    {
        a.write(i);
    }

    public void write(byte abyte0[])
    {
        a.write(abyte0);
    }

    public void write(byte abyte0[], int i, int j)
    {
        a.write(abyte0, i, j);
    }
}
