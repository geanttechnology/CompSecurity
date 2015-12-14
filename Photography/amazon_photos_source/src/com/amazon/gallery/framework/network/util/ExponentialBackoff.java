// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.util;

import android.os.SystemClock;
import java.util.Random;

public class ExponentialBackoff
{

    private int modifier;
    private ThreadLocal random;
    private int retryLimit;

    public ExponentialBackoff(int i, int j)
    {
        random = new ThreadLocal() {

            final ExponentialBackoff this$0;

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            protected Random initialValue()
            {
                return new Random(Thread.currentThread().getId() * SystemClock.uptimeMillis());
            }

            
            {
                this$0 = ExponentialBackoff.this;
                super();
            }
        };
        modifier = i;
        retryLimit = j;
    }

    public long get(int i)
    {
        float f = (1 << Math.min(i, retryLimit)) * modifier;
        return (long)(((Random)random.get()).nextFloat() * f);
    }

    public int getRetryLimit()
    {
        return retryLimit;
    }
}
