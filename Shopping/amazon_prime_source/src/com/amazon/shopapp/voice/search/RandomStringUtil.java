// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search;

import java.util.Random;

public class RandomStringUtil
{

    private static final String ALPHA_NUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random RANDOM = new Random();

    public RandomStringUtil()
    {
    }

    public static String generate(int i)
    {
        return generate(i, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", RANDOM);
    }

    public static String generate(int i, String s, Random random)
    {
        char ac[] = new char[i];
        for (int j = 0; j < i; j++)
        {
            ac[j] = s.charAt(random.nextInt(s.length()));
        }

        return new String(ac);
    }

}
