// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;


public final class x
{

    final String a;
    final int b;
    final String c;
    final String d;

    public x(String s, int i, String s1, String s2)
    {
        if (s == null)
        {
            throw new NullPointerException("host == null");
        }
        if (s1 == null)
        {
            throw new NullPointerException("userAgent == null");
        } else
        {
            a = s;
            b = i;
            c = s1;
            d = s2;
            return;
        }
    }
}
