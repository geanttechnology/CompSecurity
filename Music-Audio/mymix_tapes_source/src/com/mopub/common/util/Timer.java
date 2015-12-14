// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.util;

import java.util.concurrent.TimeUnit;

public class Timer
{
    private static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State STARTED;
        public static final State STOPPED;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/mopub/common/util/Timer$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            STARTED = new State("STARTED", 0);
            STOPPED = new State("STOPPED", 1);
            $VALUES = (new State[] {
                STARTED, STOPPED
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private long mStartTimeNanos;
    private State mState;
    private long mStopTimeNanos;

    public Timer()
    {
        mState = State.STOPPED;
    }

    public long getTime()
    {
        long l;
        if (mState == State.STARTED)
        {
            l = System.nanoTime();
        } else
        {
            l = mStopTimeNanos;
        }
        return TimeUnit.MILLISECONDS.convert(l - mStartTimeNanos, TimeUnit.NANOSECONDS);
    }

    public void start()
    {
        mStartTimeNanos = System.nanoTime();
        mState = State.STARTED;
    }

    public void stop()
    {
        if (mState != State.STARTED)
        {
            throw new IllegalStateException("EventTimer was not started.");
        } else
        {
            mState = State.STOPPED;
            mStopTimeNanos = System.nanoTime();
            return;
        }
    }
}
