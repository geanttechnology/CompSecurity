// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.util;


public class DecodeUtil
{

    public static int calculateInSampleSize(int i, int j, int k, int l)
    {
        int i1 = 1;
        boolean flag = true;
        if (j > l || i > k)
        {
            j /= 2;
            int j1 = i / 2;
            i = ((flag) ? 1 : 0);
            do
            {
                i1 = i;
                if (j / i <= l)
                {
                    break;
                }
                i1 = i;
                if (j1 / i <= k)
                {
                    break;
                }
                i *= 2;
            } while (true);
        }
        return i1;
    }
}
