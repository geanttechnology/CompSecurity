// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.f.b.a.a.a.a;


public abstract class b
{

    private final int a = 3;
    protected final byte b = 61;
    protected final int c = 0;
    protected byte d[];
    protected int e;
    protected boolean f;
    protected int g;
    protected int h;
    private final int i = 4;
    private final int j;
    private int k;

    protected b(int l)
    {
        j = l;
    }

    protected final void a(int l)
    {
label0:
        {
            if (d == null || d.length < e + l)
            {
                if (d != null)
                {
                    break label0;
                }
                d = new byte[8192];
                e = 0;
                k = 0;
            }
            return;
        }
        byte abyte0[] = new byte[d.length * 2];
        System.arraycopy(d, 0, abyte0, 0, d.length);
        d = abyte0;
    }

    abstract void a(byte abyte0[], int l, int i1);

    protected abstract boolean a(byte byte0);

    public final byte[] b(byte abyte0[])
    {
        d = null;
        e = 0;
        k = 0;
        g = 0;
        h = 0;
        f = false;
        byte abyte1[] = abyte0;
        if (abyte0 != null)
        {
            if (abyte0.length == 0)
            {
                abyte1 = abyte0;
            } else
            {
                a(abyte0, 0, abyte0.length);
                a(abyte0, 0, -1);
                abyte0 = new byte[e - k];
                int i1 = abyte0.length;
                abyte1 = abyte0;
                if (d != null)
                {
                    int l;
                    if (d != null)
                    {
                        l = e - k;
                    } else
                    {
                        l = 0;
                    }
                    l = Math.min(l, i1);
                    System.arraycopy(d, k, abyte0, 0, l);
                    k = l + k;
                    abyte1 = abyte0;
                    if (k >= e)
                    {
                        d = null;
                        return abyte0;
                    }
                }
            }
        }
        return abyte1;
    }

    protected final boolean c(byte abyte0[])
    {
        if (abyte0 != null)
        {
            int i1 = abyte0.length;
            int l = 0;
            while (l < i1) 
            {
                byte byte0 = abyte0[l];
                if (61 == byte0 || a(byte0))
                {
                    return true;
                }
                l++;
            }
        }
        return false;
    }

    public final long d(byte abyte0[])
    {
        long l1 = (long)(((abyte0.length + a) - 1) / a) * (long)i;
        long l = l1;
        if (c > 0)
        {
            l = l1 + ((((long)c + l1) - 1L) / (long)c) * (long)j;
        }
        return l;
    }
}
