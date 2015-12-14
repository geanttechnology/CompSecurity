// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.impl;

import android.os.SystemClock;

class RollingStat
{

    private static final int WINDOWS = 60;
    private final short mStat[] = new short[60];

    public RollingStat()
    {
    }

    int getSum(int i)
    {
        long l1 = SystemClock.uptimeMillis() / 1000L;
        int i1 = (int)((l1 - (long)i) % 60L);
        int j1 = (int)(l1 / 60L & 255L);
        int k = 0;
        for (int j = 0; j < i;)
        {
            short word0 = mStat[(i1 + j) % 60];
            int l = k;
            if ((word0 >> 8 & 0xff) == j1)
            {
                l = k + (word0 & 0xff);
            }
            j++;
            k = l;
        }

        return k;
    }

    void incrementStats(int i)
    {
        long l = SystemClock.uptimeMillis() / 1000L;
        int j = (int)(l % 60L);
        int k = (int)(l / 60L & 255L);
        short word0 = mStat[j];
        if (k == (word0 >> 8 & 0xff))
        {
            i = (word0 & 0xff) + i;
        }
        mStat[j] = (short)(k << 8 | i);
    }
}
