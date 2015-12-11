// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


public final class hk
{

    private static final char a[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    private static final char b[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F'
    };
    private final String c;

    public static char[] a(byte abyte0[])
    {
        int j = 0;
        char ac[] = a;
        int k = abyte0.length;
        char ac1[] = new char[k << 1];
        for (int i = 0; i < k; i++)
        {
            int l = j + 1;
            ac1[j] = ac[(abyte0[i] & 0xf0) >>> 4];
            j = l + 1;
            ac1[l] = ac[abyte0[i] & 0xf];
        }

        return ac1;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(super.toString()).append("[charsetName=").append(c).append("]").toString();
    }

}
