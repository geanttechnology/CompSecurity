// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Referenced classes of package shared_presage.com.google.android.exoplayer.util:
//            d, e

public final class SlidingPercentile
{
    private static final class a
    {

        public int a;
        public int b;
        public float c;

        private a()
        {
        }

        a(byte byte0)
        {
            this();
        }
    }


    private static final Comparator INDEX_COMPARATOR = new d();
    private static final int MAX_RECYCLED_SAMPLES = 5;
    private static final int SORT_ORDER_BY_INDEX = 1;
    private static final int SORT_ORDER_BY_VALUE = 0;
    private static final int SORT_ORDER_NONE = -1;
    private static final Comparator VALUE_COMPARATOR = new e();
    private int currentSortOrder;
    private final int maxWeight;
    private int nextSampleIndex;
    private int recycledSampleCount;
    private final a recycledSamples[] = new a[5];
    private final ArrayList samples = new ArrayList();
    private int totalWeight;

    public SlidingPercentile(int i)
    {
        maxWeight = i;
        currentSortOrder = -1;
    }

    private void ensureSortedByIndex()
    {
        if (currentSortOrder != 1)
        {
            Collections.sort(samples, INDEX_COMPARATOR);
            currentSortOrder = 1;
        }
    }

    private void ensureSortedByValue()
    {
        if (currentSortOrder != 0)
        {
            Collections.sort(samples, VALUE_COMPARATOR);
            currentSortOrder = 0;
        }
    }

    public final void addSample(int i, float f)
    {
        ensureSortedByIndex();
        a a1;
        int k;
        if (recycledSampleCount > 0)
        {
            a aa[] = recycledSamples;
            int j = recycledSampleCount - 1;
            recycledSampleCount = j;
            a1 = aa[j];
        } else
        {
            a1 = new a((byte)0);
        }
        k = nextSampleIndex;
        nextSampleIndex = k + 1;
        a1.a = k;
        a1.b = i;
        a1.c = f;
        samples.add(a1);
        totalWeight = totalWeight + i;
        do
        {
            if (totalWeight <= maxWeight)
            {
                break;
            }
            i = totalWeight - maxWeight;
            a1 = (a)samples.get(0);
            if (a1.b <= i)
            {
                totalWeight = totalWeight - a1.b;
                samples.remove(0);
                if (recycledSampleCount < 5)
                {
                    a aa1[] = recycledSamples;
                    i = recycledSampleCount;
                    recycledSampleCount = i + 1;
                    aa1[i] = a1;
                }
            } else
            {
                a1.b = a1.b - i;
                totalWeight = totalWeight - i;
            }
        } while (true);
    }

    public final float getPercentile(float f)
    {
        ensureSortedByValue();
        float f1 = totalWeight;
        int i = 0;
        int j = 0;
        for (; i < samples.size(); i++)
        {
            a a1 = (a)samples.get(i);
            j += a1.b;
            if ((float)j >= f * f1)
            {
                return a1.c;
            }
        }

        if (samples.isEmpty())
        {
            return (0.0F / 0.0F);
        } else
        {
            return ((a)samples.get(samples.size() - 1)).c;
        }
    }

}
