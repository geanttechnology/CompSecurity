// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss;


public final class RSSUtils
{

    private RSSUtils()
    {
    }

    private static int combins(int i, int j)
    {
        int j1 = 1;
        int k;
        int l;
        int i1;
        int k1;
        if (i - j > j)
        {
            k = j;
            l = i - j;
        } else
        {
            k = i - j;
            l = j;
        }
        j = 1;
        i1 = i;
        i = j1;
        do
        {
            j1 = i;
            k1 = j;
            if (i1 <= l)
            {
                break;
            }
            k1 = j * i1;
            j1 = i;
            j = k1;
            if (i <= k)
            {
                j = k1 / i;
                j1 = i + 1;
            }
            i1--;
            i = j1;
        } while (true);
        for (; j1 <= k; j1++)
        {
            k1 /= j1;
        }

        return k1;
    }

    public static int getRSSvalue(int ai[], int i, boolean flag)
    {
        int l2 = ai.length;
        int l = ai.length;
        int k = 0;
        int j;
        int j1;
        for (j = 0; k < l; j = j1 + j)
        {
            j1 = ai[k];
            k++;
        }

        int i2 = 0;
        k = 0;
        l = 0;
        int l1 = j;
        j = k;
        k = l;
        do
        {
            if (i2 >= l2 - 1)
            {
                break;
            }
            int i1 = k | 1 << i2;
            int j2 = 1;
            k = j;
            j = i1;
            while (j2 < ai[i2]) 
            {
                int k1 = combins(l1 - j2 - 1, l2 - i2 - 2);
                i1 = k1;
                if (flag)
                {
                    i1 = k1;
                    if (j == 0)
                    {
                        i1 = k1;
                        if (l1 - j2 - (l2 - i2 - 1) >= l2 - i2 - 1)
                        {
                            i1 = k1 - combins(l1 - j2 - (l2 - i2), l2 - i2 - 2);
                        }
                    }
                }
                if (l2 - i2 - 1 > 1)
                {
                    k1 = l1 - j2 - (l2 - i2 - 2);
                    int k2 = 0;
                    for (; k1 > i; k1--)
                    {
                        k2 += combins(l1 - j2 - k1 - 1, l2 - i2 - 3);
                    }

                    k1 = i1 - (l2 - 1 - i2) * k2;
                } else
                {
                    k1 = i1;
                    if (l1 - j2 > i)
                    {
                        k1 = i1 - 1;
                    }
                }
                k += k1;
                j2++;
                j &= ~(1 << i2);
            }
            i2++;
            l1 -= j2;
            i1 = k;
            k = j;
            j = i1;
        } while (true);
        return j;
    }
}
