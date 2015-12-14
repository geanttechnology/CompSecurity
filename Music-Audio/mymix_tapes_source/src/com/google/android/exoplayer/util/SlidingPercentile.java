// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class SlidingPercentile
{
    private static class Sample
    {

        public int index;
        public float value;
        public int weight;

        private Sample()
        {
        }

    }


    private static final Comparator INDEX_COMPARATOR = new Comparator() {

        public int compare(Sample sample, Sample sample1)
        {
            return sample.index - sample1.index;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((Sample)obj, (Sample)obj1);
        }

    };
    private static final int MAX_RECYCLED_SAMPLES = 5;
    private static final int SORT_ORDER_BY_INDEX = 1;
    private static final int SORT_ORDER_BY_VALUE = 0;
    private static final int SORT_ORDER_NONE = -1;
    private static final Comparator VALUE_COMPARATOR = new Comparator() {

        public int compare(Sample sample, Sample sample1)
        {
            if (sample.value < sample1.value)
            {
                return -1;
            }
            return sample1.value >= sample.value ? 0 : 1;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((Sample)obj, (Sample)obj1);
        }

    };
    private int currentSortOrder;
    private final int maxWeight;
    private int nextSampleIndex;
    private int recycledSampleCount;
    private final Sample recycledSamples[] = new Sample[5];
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

    public void addSample(int i, float f)
    {
        ensureSortedByIndex();
        Sample sample;
        int k;
        if (recycledSampleCount > 0)
        {
            Sample asample[] = recycledSamples;
            int j = recycledSampleCount - 1;
            recycledSampleCount = j;
            sample = asample[j];
        } else
        {
            sample = new Sample();
        }
        k = nextSampleIndex;
        nextSampleIndex = k + 1;
        sample.index = k;
        sample.weight = i;
        sample.value = f;
        samples.add(sample);
        totalWeight = totalWeight + i;
        do
        {
            if (totalWeight <= maxWeight)
            {
                break;
            }
            i = totalWeight - maxWeight;
            sample = (Sample)samples.get(0);
            if (sample.weight <= i)
            {
                totalWeight = totalWeight - sample.weight;
                samples.remove(0);
                if (recycledSampleCount < 5)
                {
                    Sample asample1[] = recycledSamples;
                    i = recycledSampleCount;
                    recycledSampleCount = i + 1;
                    asample1[i] = sample;
                }
            } else
            {
                sample.weight = sample.weight - i;
                totalWeight = totalWeight - i;
            }
        } while (true);
    }

    public float getPercentile(float f)
    {
        ensureSortedByValue();
        float f1 = totalWeight;
        int j = 0;
        for (int i = 0; i < samples.size(); i++)
        {
            Sample sample = (Sample)samples.get(i);
            j += sample.weight;
            if ((float)j >= f * f1)
            {
                return sample.value;
            }
        }

        if (samples.isEmpty())
        {
            return (0.0F / 0.0F);
        } else
        {
            return ((Sample)samples.get(samples.size() - 1)).value;
        }
    }

}
