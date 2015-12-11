// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import c.a.a.a.a.c.a.a;
import java.util.Random;

class RandomBackoff
    implements a
{

    final a backoff;
    final double jitterPercent;
    final Random random;

    public RandomBackoff(a a1, double d)
    {
        this(a1, d, new Random());
    }

    public RandomBackoff(a a1, double d, Random random1)
    {
        if (d < 0.0D || d > 1.0D)
        {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        }
        if (a1 == null)
        {
            throw new NullPointerException("backoff must not be null");
        }
        if (random1 == null)
        {
            throw new NullPointerException("random must not be null");
        } else
        {
            backoff = a1;
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
