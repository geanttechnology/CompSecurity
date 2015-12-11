// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;

class bbc
{

    bbr a;
    byte b[];
    final int c = 239;

    public bbc(int i)
    {
        a();
    }

    public void a()
    {
        b = new byte[c];
        a = bbr.a(b);
    }

    public void a(int i, long l)
    {
        a.a(i, l);
    }

    public void a(int i, String s)
    {
        a.a(i, s);
    }

    public byte[] b()
    {
        int i = a.a();
        if (i < 0)
        {
            throw new IOException();
        }
        if (i == 0)
        {
            return b;
        } else
        {
            byte abyte0[] = new byte[b.length - i];
            System.arraycopy(b, 0, abyte0, 0, abyte0.length);
            return abyte0;
        }
    }
}
