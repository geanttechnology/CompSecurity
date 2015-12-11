// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.util.android;

import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class Clock
{
    public static interface ClockEventListener
    {

        public abstract void onTick(String s);
    }


    private final Vector clockEventListeners = new Vector();
    private final long interval;
    private final String name;
    private Timer timer;

    public Clock(String s, long l)
    {
        name = s;
        interval = l;
    }

    private void dispatchClockEvent()
    {
        Vector vector = clockEventListeners;
        vector;
        JVM INSTR monitorenter ;
        for (Iterator iterator = clockEventListeners.iterator(); iterator.hasNext(); ((ClockEventListener)iterator.next()).onTick(name)) { }
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        vector;
        JVM INSTR monitorexit ;
        throw exception;
        vector;
        JVM INSTR monitorexit ;
    }

    public void addClockEventListener(ClockEventListener clockeventlistener)
    {
        clockEventListeners.add(clockeventlistener);
    }

    public void removeClockEventListener(ClockEventListener clockeventlistener)
    {
        clockEventListeners.remove(clockeventlistener);
    }

    public void start()
    {
        timer = new Timer();
        timer.schedule(new TimerTask() {

            final Clock this$0;

            public void run()
            {
                dispatchClockEvent();
            }

            
            {
                this$0 = Clock.this;
                super();
            }
        }, 0L, interval);
    }

    public void stop()
    {
        timer.cancel();
    }

}
