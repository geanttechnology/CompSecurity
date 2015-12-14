// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;


// Referenced classes of package com.millennialmedia.google.gson.internal:
//            i

final class d
{

    private i a;
    private int b;
    private int c;
    private int d;

    d()
    {
    }

    final i a()
    {
        i j = a;
        if (j.a != null)
        {
            throw new IllegalStateException();
        } else
        {
            return j;
        }
    }

    final void a(int j)
    {
        b = Integer.highestOneBit(j) * 2 - 1 - j;
        d = 0;
        c = 0;
        a = null;
    }

    final void a(i j)
    {
        j.c = null;
        j.a = null;
        j.b = null;
        j.i = 1;
        if (b > 0 && (d & 1) == 0)
        {
            d = d + 1;
            b = b - 1;
            c = c + 1;
        }
        j.a = a;
        a = j;
        d = d + 1;
        if (b > 0 && (d & 1) == 0)
        {
            d = d + 1;
            b = b - 1;
            c = c + 1;
        }
        int j1 = 4;
        while ((d & j1 - 1) == j1 - 1) 
        {
            if (c == 0)
            {
                j = a;
                i k = j.a;
                i i1 = k.a;
                k.a = i1.a;
                a = k;
                k.b = i1;
                k.c = j;
                k.i = j.i + 1;
                i1.a = k;
                j.a = k;
            } else
            if (c == 1)
            {
                j = a;
                i l = j.a;
                a = l;
                l.c = j;
                l.i = j.i + 1;
                j.a = l;
                c = 0;
            } else
            if (c == 2)
            {
                c = 0;
            }
            j1 *= 2;
        }
    }
}
