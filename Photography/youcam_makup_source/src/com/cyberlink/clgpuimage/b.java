// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;


public class b
{

    public static String a(char ac[])
    {
        ac = (char[])ac.clone();
        for (int i = 0; i < ac.length; i++)
        {
            ac[i] = (char)(ac[i] ^ 0xc8);
            if (ac[i] < '!' || ac[i] > '~')
            {
                continue;
            }
            ac[i] = (char)(ac[i] + 47);
            if (ac[i] > '~')
            {
                ac[i] = (char)(ac[i] - 94);
            }
        }

        return new String(ac);
    }
}
