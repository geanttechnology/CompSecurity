// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.time;


// Referenced classes of package org.apache.commons.lang3.time:
//            DurationFormatUtils

public class StopWatch
{

    private int runningState;
    private int splitState;
    private long startTime;
    private long startTimeMillis;
    private long stopTime;

    public StopWatch()
    {
        runningState = 0;
        splitState = 10;
    }

    public long getNanoTime()
    {
        if (runningState == 2 || runningState == 3)
        {
            return stopTime - startTime;
        }
        if (runningState == 0)
        {
            return 0L;
        }
        if (runningState == 1)
        {
            return System.nanoTime() - startTime;
        } else
        {
            throw new RuntimeException("Illegal running state has occured. ");
        }
    }

    public long getTime()
    {
        return getNanoTime() / 0xf4240L;
    }

    public void reset()
    {
        runningState = 0;
        splitState = 10;
    }

    public void start()
    {
        if (runningState == 2)
        {
            throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
        }
        if (runningState != 0)
        {
            throw new IllegalStateException("Stopwatch already started. ");
        } else
        {
            startTime = System.nanoTime();
            startTimeMillis = System.currentTimeMillis();
            runningState = 1;
            return;
        }
    }

    public void stop()
    {
        if (runningState != 1 && runningState != 3)
        {
            throw new IllegalStateException("Stopwatch is not running. ");
        }
        if (runningState == 1)
        {
            stopTime = System.nanoTime();
        }
        runningState = 2;
    }

    public String toString()
    {
        return DurationFormatUtils.formatDurationHMS(getTime());
    }
}
