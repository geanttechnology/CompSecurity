// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;


final class k
{

    int a;
    int b;
    int c;
    final int d[] = new int[10];

    k()
    {
    }

    final void a(int i, int j, int l)
    {
        if (i >= d.length)
        {
            return;
        }
        int i1 = 1 << i;
        a = a | i1;
        if ((j & 1) != 0)
        {
            b = b | i1;
        } else
        {
            b = b & ~i1;
        }
        if ((j & 2) != 0)
        {
            c = i1 | c;
        } else
        {
            c = ~i1 & c;
        }
        d[i] = l;
    }
}
