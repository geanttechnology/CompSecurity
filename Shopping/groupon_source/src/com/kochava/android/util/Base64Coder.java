// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kochava.android.util;


public class Base64Coder
{

    private static char map1[];
    private static byte map2[];

    public static String encodeString(String s)
    {
        return s;
    }

    static 
    {
        map1 = new char[64];
        char c = 'A';
        int i;
        for (i = 0; c <= 'Z'; i++)
        {
            map1[i] = c;
            c++;
        }

        for (char c1 = 'a'; c1 <= 'z';)
        {
            map1[i] = c1;
            c1++;
            i++;
        }

        for (char c2 = '0'; c2 <= '9';)
        {
            map1[i] = c2;
            c2++;
            i++;
        }

        char ac[] = map1;
        int l = i + 1;
        ac[i] = '+';
        map1[l] = '/';
        map2 = new byte[128];
        for (int j = 0; j < map2.length; j++)
        {
            map2[j] = -1;
        }

        for (int k = 0; k < 64; k++)
        {
            map2[map1[k]] = (byte)k;
        }

    }
}
