// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.oned.OneDReader;

public abstract class AbstractRSSReader extends OneDReader
{

    private static final int MAX_AVG_VARIANCE = 51;
    private static final float MAX_FINDER_PATTERN_RATIO = 0.8928571F;
    private static final int MAX_INDIVIDUAL_VARIANCE = 115;
    private static final float MIN_FINDER_PATTERN_RATIO = 0.7916667F;
    private final int dataCharacterCounters[] = new int[8];
    private final int decodeFinderCounters[] = new int[4];
    private final int evenCounts[];
    private final float evenRoundingErrors[] = new float[4];
    private final int oddCounts[];
    private final float oddRoundingErrors[] = new float[4];

    public AbstractRSSReader()
    {
        oddCounts = new int[dataCharacterCounters.length / 2];
        evenCounts = new int[dataCharacterCounters.length / 2];
    }

    public static int count(int ai[])
    {
        int i = 0;
        int k = ai.length;
        int j = 0;
        for (; i < k; i++)
        {
            j += ai[i];
        }

        return j;
    }

    public static void decrement(int ai[], float af[])
    {
        int j = 0;
        float f = af[0];
        for (int i = 1; i < ai.length;)
        {
            float f1 = f;
            if (af[i] < f)
            {
                f1 = af[i];
                j = i;
            }
            i++;
            f = f1;
        }

        ai[j] = ai[j] - 1;
    }

    public static void increment(int ai[], float af[])
    {
        int j = 0;
        float f = af[0];
        for (int i = 1; i < ai.length;)
        {
            float f1 = f;
            if (af[i] > f)
            {
                f1 = af[i];
                j = i;
            }
            i++;
            f = f1;
        }

        ai[j] = ai[j] + 1;
    }

    public static boolean isFinderPattern(int ai[])
    {
        int i = ai[0] + ai[1];
        int k = ai[2];
        int i1 = ai[3];
        float f = (float)i / (float)(k + i + i1);
        if (f >= 0.7916667F && f <= 0.8928571F)
        {
            int j = 0x7fffffff;
            int k1 = 0x80000000;
            int i2 = ai.length;
            for (int l = 0; l < i2;)
            {
                int l1 = ai[l];
                int j1 = k1;
                if (l1 > k1)
                {
                    j1 = l1;
                }
                if (l1 < j)
                {
                    j = l1;
                }
                l++;
                k1 = j1;
            }

            return k1 < j * 10;
        } else
        {
            return false;
        }
    }

    public static int parseFinderValue(int ai[], int ai1[][])
    {
        for (int i = 0; i < ai1.length; i++)
        {
            if (patternMatchVariance(ai, ai1[i], 115) < 51)
            {
                return i;
            }
        }

        throw NotFoundException.getNotFoundInstance();
    }

    public final int[] getDataCharacterCounters()
    {
        return dataCharacterCounters;
    }

    public final int[] getDecodeFinderCounters()
    {
        return decodeFinderCounters;
    }

    public final int[] getEvenCounts()
    {
        return evenCounts;
    }

    public final float[] getEvenRoundingErrors()
    {
        return evenRoundingErrors;
    }

    public final int[] getOddCounts()
    {
        return oddCounts;
    }

    public final float[] getOddRoundingErrors()
    {
        return oddRoundingErrors;
    }
}
