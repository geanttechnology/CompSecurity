// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.stats;


public class TicToc
{
    private static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State STARTED;
        public static final State STOPPED;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/newrelic/agent/android/stats/TicToc$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            STOPPED = new State("STOPPED", 0);
            STARTED = new State("STARTED", 1);
            $VALUES = (new State[] {
                STOPPED, STARTED
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private long endTime;
    private long startTime;
    private State state;

    public TicToc()
    {
    }

    public void tic()
    {
        state = State.STARTED;
        startTime = System.currentTimeMillis();
    }

    public long toc()
    {
        endTime = System.currentTimeMillis();
        if (state == State.STARTED)
        {
            state = State.STOPPED;
            return endTime - startTime;
        } else
        {
            return -1L;
        }
    }
}
