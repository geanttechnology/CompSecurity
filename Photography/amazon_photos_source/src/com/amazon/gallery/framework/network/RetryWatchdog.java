// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

public class RetryWatchdog
{

    private static int MIN_SIZE = 5000;
    private final BloomFilter bloomFilter;

    public RetryWatchdog(int i)
    {
        i = Math.max(i, MIN_SIZE);
        bloomFilter = BloomFilter.create(new Funnel() {

            final RetryWatchdog this$0;

            public void funnel(Object obj, PrimitiveSink primitivesink)
            {
                primitivesink.putString(obj.toString());
            }

            
            {
                this$0 = RetryWatchdog.this;
                super();
            }
        }, i);
    }

    public double expectedFalsePositiveProbability()
    {
        return bloomFilter.expectedFalsePositiveProbability();
    }

    public boolean mightContain(Object obj)
    {
        return bloomFilter.mightContain(obj);
    }

}
