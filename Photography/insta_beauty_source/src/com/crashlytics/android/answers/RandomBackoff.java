// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import bvi;
import java.util.Random;

class RandomBackoff
    implements bvi
{

    final bvi backoff;
    final double jitterPercent;
    final Random random;

    public RandomBackoff(bvi bvi1, double d)
    {
        this(bvi1, d, new Random());
    }

    public RandomBackoff(bvi bvi1, double d, Random random1)
    {
        if (d < 0.0D || d > 1.0D)
        {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        }
        if (bvi1 == null)
        {
            throw new NullPointerException("backoff must not be null");
        }
        if (random1 == null)
        {
            throw new NullPointerException("random must not be null");
        } else
        {
            backoff = bvi1;
            jitterPercent = d;
            random = random1;
            return;
        }
    }

    public long getDelayMillis(int i)
    {
        return (long)(randomJitter() * (double)backoff.getDelayMillis(i));
    }

    double randomJitter()
    {
        double d = 1.0D - jitterPercent;
        return d + ((jitterPercent + 1.0D) - d) * random.nextDouble();
    }
}
