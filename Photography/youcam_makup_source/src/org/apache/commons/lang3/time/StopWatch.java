// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.time;


// Referenced classes of package org.apache.commons.lang3.time:
//            DurationFormatUtils

public class StopWatch
{

    private static final long NANO_2_MILLIS = 0xf4240L;
    private State runningState;
    private SplitState splitState;
    private long startTime;
    private long startTimeMillis;
    private long stopTime;

    public StopWatch()
    {
        runningState = State.UNSTARTED;
        splitState = SplitState.UNSPLIT;
    }

    public long getNanoTime()
    {
        if (runningState == State.STOPPED || runningState == State.SUSPENDED)
        {
            return stopTime - startTime;
        }
        if (runningState == State.UNSTARTED)
        {
            return 0L;
        }
        if (runningState == State.RUNNING)
        {
            return System.nanoTime() - startTime;
        } else
        {
            throw new RuntimeException("Illegal running state has occurred.");
        }
    }

    public long getSplitNanoTime()
    {
        if (splitState != SplitState.SPLIT)
        {
            throw new IllegalStateException("Stopwatch must be split to get the split time. ");
        } else
        {
            return stopTime - startTime;
        }
    }

    public long getSplitTime()
    {
        return getSplitNanoTime() / 0xf4240L;
    }

    public long getStartTime()
    {
        if (runningState == State.UNSTARTED)
        {
            throw new IllegalStateException("Stopwatch has not been started");
        } else
        {
            return startTimeMillis;
        }
    }

    public long getTime()
    {
        return getNanoTime() / 0xf4240L;
    }

    public boolean isStarted()
    {
        return runningState.isStarted();
    }

    public boolean isStopped()
    {
        return runningState.isStopped();
    }

    public boolean isSuspended()
    {
        return runningState.isSuspended();
    }

    public void reset()
    {
        runningState = State.UNSTARTED;
        splitState = SplitState.UNSPLIT;
    }

    public void resume()
    {
        if (runningState != State.SUSPENDED)
        {
            throw new IllegalStateException("Stopwatch must be suspended to resume. ");
        } else
        {
            startTime = startTime + (System.nanoTime() - stopTime);
            runningState = State.RUNNING;
            return;
        }
    }

    public void split()
    {
        if (runningState != State.RUNNING)
        {
            throw new IllegalStateException("Stopwatch is not running. ");
        } else
        {
            stopTime = System.nanoTime();
            splitState = SplitState.SPLIT;
            return;
        }
    }

    public void start()
    {
        if (runningState == State.STOPPED)
        {
            throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
        }
        if (runningState != State.UNSTARTED)
        {
            throw new IllegalStateException("Stopwatch already started. ");
        } else
        {
            startTime = System.nanoTime();
            startTimeMillis = System.currentTimeMillis();
            runningState = State.RUNNING;
            return;
        }
    }

    public void stop()
    {
        if (runningState != State.RUNNING && runningState != State.SUSPENDED)
        {
            throw new IllegalStateException("Stopwatch is not running. ");
        }
        if (runningState == State.RUNNING)
        {
            stopTime = System.nanoTime();
        }
        runningState = State.STOPPED;
    }

    public void suspend()
    {
        if (runningState != State.RUNNING)
        {
            throw new IllegalStateException("Stopwatch must be running to suspend. ");
        } else
        {
            stopTime = System.nanoTime();
            runningState = State.SUSPENDED;
            return;
        }
    }

    public String toSplitString()
    {
        return DurationFormatUtils.formatDurationHMS(getSplitTime());
    }

    public String toString()
    {
        return DurationFormatUtils.formatDurationHMS(getTime());
    }

    public void unsplit()
    {
        if (splitState != SplitState.SPLIT)
        {
            throw new IllegalStateException("Stopwatch has not been split. ");
        } else
        {
            splitState = SplitState.UNSPLIT;
            return;
        }
    }

    /* member class not found */
    class State {}


    /* member class not found */
    class SplitState {}

}
