// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.metrics;

import android.os.SystemClock;
import com.amazon.mixtape.utils.ISO8601;
import java.util.Date;

public interface MixtapeMetric
{
    public static class Counter
        implements MixtapeMetric
    {

        private long mCount;
        private final String mCounterName;
        private String mStartTimestamp;

        public void increment(long l)
        {
            mCount = mCount + l;
            mStartTimestamp = ISO8601.getUTCString(new Date());
        }

        public Counter(String s)
        {
            mCounterName = s;
            mStartTimestamp = ISO8601.getUTCString(new Date());
        }
    }

    public static class Event
        implements MixtapeMetric
    {

        private int mCount;
        private final String mEventName;
        private boolean mIsError;
        private String mStartTimestamp;

        public Event errored()
        {
            mIsError = true;
            return this;
        }

        public int getCount()
        {
            return mCount;
        }

        public String getEventName()
        {
            return mEventName;
        }

        public boolean isError()
        {
            return mIsError;
        }

        public Event setCount(int i)
        {
            mCount = i;
            return this;
        }

        public Event(String s)
        {
            mCount = 1;
            mEventName = s;
            mStartTimestamp = ISO8601.getUTCString(new Date());
        }
    }

    public static class Timer
        implements MixtapeMetric
    {

        private int mCount;
        private double mDuration;
        private final String mEventName;
        private long mFinishTime;
        private boolean mIsError;
        private long mStartTime;
        private String mStartTimestamp;

        public Timer failed()
        {
            mFinishTime = SystemClock.elapsedRealtime();
            mIsError = true;
            return this;
        }

        public Timer finished()
        {
            mFinishTime = SystemClock.elapsedRealtime();
            return this;
        }

        public int getCount()
        {
            return mCount;
        }

        public double getDuration()
        {
            if (mStartTime > 0L && mFinishTime > 0L)
            {
                return (double)(mFinishTime - mStartTime);
            } else
            {
                return mDuration;
            }
        }

        public String getEventName()
        {
            return mEventName;
        }

        public boolean isError()
        {
            return mIsError;
        }

        public Timer start()
        {
            mStartTime = SystemClock.elapsedRealtime();
            mStartTimestamp = ISO8601.getUTCString(new Date());
            return this;
        }

        public Timer(String s)
        {
            mStartTimestamp = null;
            mStartTime = -1L;
            mFinishTime = -1L;
            mEventName = s;
        }
    }

}
