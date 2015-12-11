// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.b;

import java.util.Arrays;

public final class b
    implements Cloneable
{

    private final int a;
    private final int b;
    private final int c;
    private final int d[];

    public b(int i)
    {
        this(i, i);
    }

    public b(int i, int j)
    {
        if (i < 1 || j < 1)
        {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        } else
        {
            a = i;
            b = j;
            c = (i + 31) / 32;
            d = new int[c * j];
            return;
        }
    }

    private b(int i, int j, int k, int ai[])
    {
        a = i;
        b = j;
        c = k;
        d = ai;
    }

    public String a(String s, String s1)
    {
        return a(s, s1, "\n");
    }

    public String a(String s, String s1, String s2)
    {
        StringBuilder stringbuilder = new StringBuilder(b * (a + 1));
        for (int i = 0; i < b; i++)
        {
            int j = 0;
            while (j < a) 
            {
                String s3;
                if (a(j, i))
                {
                    s3 = s;
                } else
                {
                    s3 = s1;
                }
                stringbuilder.append(s3);
                j++;
            }
            stringbuilder.append(s2);
        }

        return stringbuilder.toString();
    }

    public void a()
    {
        int j = d.length;
        for (int i = 0; i < j; i++)
        {
            d[i] = 0;
        }

    }

    public void a(int i, int j, int k, int l)
    {
        int i1;
        if (j < 0 || i < 0)
        {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (l < 1 || k < 1)
        {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        i1 = i + k;
        l = j + l;
        if (l > b || i1 > a)
        {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
_L3:
        if (j < l)
        {
            int j1 = c;
            k = i;
            while (k < i1) 
            {
                int ai[] = d;
                int k1 = k / 32 + j * j1;
                ai[k1] = ai[k1] | 1 << (k & 0x1f);
                k++;
            }
        } else
        {
            return;
        }
        if (true) goto _L2; else goto _L1
_L2:
        j++;
        if (true) goto _L3; else goto _L1
_L1:
    }

    public boolean a(int i, int j)
    {
        int k = c;
        int l = i / 32;
        return (d[k * j + l] >>> (i & 0x1f) & 1) != 0;
    }

    public int b()
    {
        return a;
    }

    public void b(int i, int j)
    {
        j = c * j + i / 32;
        int ai[] = d;
        ai[j] = ai[j] | 1 << (i & 0x1f);
    }

    public int c()
    {
        return b;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return d();
    }

    public b d()
    {
        return new b(a, b, c, (int[])d.clone());
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof b)
        {
            if (a == ((b) (obj = (b)obj)).a && b == ((b) (obj)).b && c == ((b) (obj)).c && Arrays.equals(d, ((b) (obj)).d))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return (((a * 31 + a) * 31 + b) * 31 + c) * 31 + Arrays.hashCode(d);
    }

    public String toString()
    {
        return a("X ", "  ");
    }
}
