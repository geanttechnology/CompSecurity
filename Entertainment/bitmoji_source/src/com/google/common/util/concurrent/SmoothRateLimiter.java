// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.math.LongMath;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.common.util.concurrent:
//            RateLimiter

abstract class SmoothRateLimiter extends RateLimiter
{
    static final class SmoothBursty extends SmoothRateLimiter
    {

        final double maxBurstSeconds;

        double coolDownIntervalMicros()
        {
            return stableIntervalMicros;
        }

        void doSetRate(double d, double d1)
        {
            d1 = 0.0D;
            double d2 = maxPermits;
            maxPermits = maxBurstSeconds * d;
            if (d2 == (1.0D / 0.0D))
            {
                storedPermits = maxPermits;
                return;
            }
            if (d2 == 0.0D)
            {
                d = d1;
            } else
            {
                d = (storedPermits * maxPermits) / d2;
            }
            storedPermits = d;
        }

        long storedPermitsToWaitTime(double d, double d1)
        {
            return 0L;
        }

        SmoothBursty(RateLimiter.SleepingStopwatch sleepingstopwatch, double d)
        {
            super(sleepingstopwatch, null);
            maxBurstSeconds = d;
        }
    }

    static final class SmoothWarmingUp extends SmoothRateLimiter
    {

        private double coldFactor;
        private double slope;
        private double thresholdPermits;
        private final long warmupPeriodMicros;

        private double permitsToTime(double d)
        {
            return stableIntervalMicros + slope * d;
        }

        double coolDownIntervalMicros()
        {
            return (double)warmupPeriodMicros / maxPermits;
        }

        void doSetRate(double d, double d1)
        {
            d = maxPermits;
            double d2 = d1 * coldFactor;
            thresholdPermits = (0.5D * (double)warmupPeriodMicros) / d1;
            maxPermits = thresholdPermits + (2D * (double)warmupPeriodMicros) / (d1 + d2);
            slope = (d2 - d1) / (maxPermits - thresholdPermits);
            if (d == (1.0D / 0.0D))
            {
                storedPermits = 0.0D;
                return;
            }
            if (d == 0.0D)
            {
                d = maxPermits;
            } else
            {
                d = (storedPermits * maxPermits) / d;
            }
            storedPermits = d;
        }

        long storedPermitsToWaitTime(double d, double d1)
        {
            double d2 = d - thresholdPermits;
            long l = 0L;
            d = d1;
            if (d2 > 0.0D)
            {
                d = Math.min(d2, d1);
                l = (long)(((permitsToTime(d2) + permitsToTime(d2 - d)) * d) / 2D);
                d = d1 - d;
            }
            return (long)((double)l + stableIntervalMicros * d);
        }

        SmoothWarmingUp(RateLimiter.SleepingStopwatch sleepingstopwatch, long l, TimeUnit timeunit, double d)
        {
            super(sleepingstopwatch, null);
            warmupPeriodMicros = timeunit.toMicros(l);
            coldFactor = d;
        }
    }


    double maxPermits;
    private long nextFreeTicketMicros;
    double stableIntervalMicros;
    double storedPermits;

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingstopwatch)
    {
        super(sleepingstopwatch);
        nextFreeTicketMicros = 0L;
    }


    abstract double coolDownIntervalMicros();

    final double doGetRate()
    {
        return (double)TimeUnit.SECONDS.toMicros(1L) / stableIntervalMicros;
    }

    abstract void doSetRate(double d, double d1);

    final void doSetRate(double d, long l)
    {
        resync(l);
        double d1 = (double)TimeUnit.SECONDS.toMicros(1L) / d;
        stableIntervalMicros = d1;
        doSetRate(d, d1);
    }

    final long queryEarliestAvailable(long l)
    {
        return nextFreeTicketMicros;
    }

    final long reserveEarliestAvailable(int i, long l)
    {
        resync(l);
        l = nextFreeTicketMicros;
        double d = Math.min(i, storedPermits);
        double d1 = i;
        long l1 = storedPermitsToWaitTime(storedPermits, d);
        long l2 = (long)(stableIntervalMicros * (d1 - d));
        try
        {
            nextFreeTicketMicros = LongMath.checkedAdd(nextFreeTicketMicros, l1 + l2);
        }
        catch (ArithmeticException arithmeticexception)
        {
            nextFreeTicketMicros = 0x7fffffffffffffffL;
        }
        storedPermits = storedPermits - d;
        return l;
    }

    void resync(long l)
    {
        if (l > nextFreeTicketMicros)
        {
            storedPermits = Math.min(maxPermits, storedPermits + (double)(l - nextFreeTicketMicros) / coolDownIntervalMicros());
            nextFreeTicketMicros = l;
        }
    }

    abstract long storedPermitsToWaitTime(double d, double d1);
}
