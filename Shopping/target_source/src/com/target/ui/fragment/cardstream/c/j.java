// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.c;

import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class j
{
    static class a
    {

        public boolean hasThrottleTimeExpired;
        public boolean isRunningNow;
        public boolean isScheduledToRun;

        public String toString()
        {
            return (new StringBuilder()).append("OnExecuteActionConditions{isRunningNow=").append(isRunningNow).append(", hasThrottleTimeExpired=").append(hasThrottleTimeExpired).append(", isScheduledToRun=").append(isScheduledToRun).append('}').toString();
        }

        private a(a a1)
        {
            isRunningNow = a.a(a1).booleanValue();
            hasThrottleTimeExpired = a.b(a1).booleanValue();
            isScheduledToRun = a.c(a1).booleanValue();
        }

    }

    static class a.a
    {

        private Boolean hasThrottleTimeExpired;
        private Boolean isRunningNow;
        private Boolean isScheduledToRun;

        static Boolean a(a.a a1)
        {
            return a1.isRunningNow;
        }

        static Boolean b(a.a a1)
        {
            return a1.hasThrottleTimeExpired;
        }

        private void b()
        {
            int i = 0;
            Boolean aboolean[] = new Boolean[3];
            aboolean[0] = isRunningNow;
            aboolean[1] = hasThrottleTimeExpired;
            aboolean[2] = isScheduledToRun;
            for (int k = aboolean.length; i < k; i++)
            {
                if (aboolean[i] == null)
                {
                    throw new IllegalArgumentException("One or more fields not set!");
                }
            }

        }

        static Boolean c(a.a a1)
        {
            return a1.isScheduledToRun;
        }

        public a.a a(boolean flag)
        {
            isRunningNow = Boolean.valueOf(flag);
            return this;
        }

        public a a()
        {
            b();
            return new a(this);
        }

        public a.a b(boolean flag)
        {
            hasThrottleTimeExpired = Boolean.valueOf(flag);
            return this;
        }

        public a.a c(boolean flag)
        {
            isScheduledToRun = Boolean.valueOf(flag);
            return this;
        }

        a.a()
        {
        }
    }

    public static class b
    {

        private static final String LOG_TAG = "ThrottlingTaskRunner";
        private final g.a mClock;
        private final ScheduledExecutorService mExecutor;
        private final String mName;
        private final a mState = new a();
        private final Runnable mTaskToRun;
        private final long mThrottleDelayInMillis;

        static long a(b b1, long l)
        {
            return b1.b(l);
        }

        static a a(b b1)
        {
            return b1.mState;
        }

        private void a(a a1)
        {
            com.target.a.a.b.a("ThrottlingTaskRunner", String.format("Invalid conditions for throttled execution: conditions=%s, state=%s", new Object[] {
                a1, mState
            }));
        }

        private void a(Runnable runnable)
        {
            mExecutor.execute(c(runnable));
        }

        private long b(long l)
        {
            return mClock.a() + l;
        }

        static long b(b b1)
        {
            return b1.mThrottleDelayInMillis;
        }

        private void b(Runnable runnable)
        {
            synchronized (mState)
            {
                runnable = c(runnable);
                long l = d();
                com.target.a.a.b.c("ThrottlingTaskRunner", (new StringBuilder()).append("Scheduling task for time: ").append(new Date(System.currentTimeMillis() + l)).toString());
                mState.mScheduledTask = mExecutor.schedule(runnable, l, TimeUnit.MILLISECONDS);
            }
            return;
            runnable;
            a1;
            JVM INSTR monitorexit ;
            throw runnable;
        }

        private a c()
        {
            a a1 = mState;
            a1;
            JVM INSTR monitorenter ;
            a a2;
            Exception exception;
            boolean flag;
            if (mClock.a() >= mState.mNextAllowedTime)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a2 = (new a.a()).a(mState.mIsRunning).c(mState.a()).b(flag).a();
            a1;
            JVM INSTR monitorexit ;
            return a2;
            exception;
            a1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private Runnable c(Runnable runnable)
        {
            return runnable. new Runnable() {

                final b this$0;
                final Runnable val$toWrap;

                public void run()
                {
                    synchronized (b.a(b.this))
                    {
                        b.a(b.this).mIsRunning = true;
                        b.a(b.this).mScheduledTask = null;
                        b.a(b.this).mNextAllowedTime = b.a(b.this, b.b(b.this));
                        com.target.a.a.b.d("ThrottlingTaskRunner", (new StringBuilder()).append("Set new allowed time for ").append(b.c(b.this)).append(" to ").append(new Date(b.a(b.this).mNextAllowedTime)).append(" from state maint. runnable").toString());
                    }
                    toWrap.run();
                    synchronized (b.a(b.this))
                    {
                        b.a(b.this).mIsRunning = false;
                    }
                    return;
                    exception1;
                    a1;
                    JVM INSTR monitorexit ;
                    throw exception1;
                    exception2;
                    a1;
                    JVM INSTR monitorexit ;
                    throw exception2;
                    Exception exception;
                    exception;
                    com.target.a.a.b.a("ThrottlingTaskRunner", "Error while running task: ", exception);
                    throw new RuntimeException(exception);
                    Exception exception3;
                    exception3;
                    synchronized (b.a(b.this))
                    {
                        b.a(b.this).mIsRunning = false;
                    }
                    throw exception3;
                    exception4;
                    a2;
                    JVM INSTR monitorexit ;
                    throw exception4;
                }

            
            {
                this$0 = final_b1;
                toWrap = Runnable.this;
                super();
            }
            };
        }

        static String c(b b1)
        {
            return b1.mName;
        }

        private long d()
        {
            long l;
            synchronized (mState)
            {
                l = mClock.a();
                l = Math.max(mState.mNextAllowedTime - l, 0L);
            }
            return l;
            exception;
            a1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a()
        {
            a a1 = mState;
            a1;
            JVM INSTR monitorenter ;
            Object obj;
            String s;
            int i;
            obj = c();
            i = j.a(((a) (obj)));
            s = (new StringBuilder()).append(" for ").append(mName).append(", state=").append(mState).toString();
            i;
            JVM INSTR tableswitch -1 3: default 206
        //                       -1 198
        //                       0 88
        //                       1 115
        //                       2 88
        //                       3 163;
               goto _L1 _L2 _L1 _L3 _L1 _L4
_L1:
            com.target.a.a.b.d("ThrottlingTaskRunner", (new StringBuilder()).append("Not executing or scheduling").append(s).toString());
_L5:
            a1;
            JVM INSTR monitorexit ;
            return;
_L3:
            com.target.a.a.b.d("ThrottlingTaskRunner", (new StringBuilder()).append("Executing Runnable").append(s).toString());
            mState.mIsRunning = true;
            a(mTaskToRun);
              goto _L5
            obj;
            a1;
            JVM INSTR monitorexit ;
            throw obj;
_L4:
            com.target.a.a.b.d("ThrottlingTaskRunner", (new StringBuilder()).append("Scheduling Runnable").append(s).toString());
            b(mTaskToRun);
              goto _L5
_L2:
            a(((a) (obj)));
              goto _L5
        }

        public void a(long l)
        {
            synchronized (mState)
            {
                b();
                mState.mNextAllowedTime = b(l);
            }
            return;
            exception;
            a1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void b()
        {
            synchronized (mState)
            {
                if (mState.a() || mState.mIsRunning)
                {
                    mState.b();
                    mState.mIsRunning = false;
                }
            }
            return;
            exception;
            a1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public b(Runnable runnable, ScheduledExecutorService scheduledexecutorservice, g.a a1, long l, String s)
        {
            mTaskToRun = runnable;
            mExecutor = scheduledexecutorservice;
            mClock = a1;
            mThrottleDelayInMillis = l;
            mName = s;
        }
    }

    private static class b.a
    {

        boolean mIsRunning;
        long mNextAllowedTime;
        Future mScheduledTask;

        boolean a()
        {
            return mScheduledTask != null;
        }

        void b()
        {
            if (mScheduledTask != null)
            {
                mScheduledTask.cancel(false);
                mScheduledTask = null;
            }
        }

        public String toString()
        {
            return (new StringBuilder()).append("MutableState{mScheduledTask=").append(mScheduledTask).append(", mIsRunning=").append(mIsRunning).append(", mNextAllowedTime=").append(new Date(mNextAllowedTime)).append('}').toString();
        }

        private b.a()
        {
        }

    }

    public static class c
    {

        private final g.a mClock;
        private final ScheduledExecutorService mExecutor;

        public b a(Runnable runnable, long l, String s)
        {
            return new b(runnable, mExecutor, mClock, l, s);
        }

        public c(ScheduledExecutorService scheduledexecutorservice, g.a a1)
        {
            mExecutor = scheduledexecutorservice;
            mClock = a1;
        }
    }


    static int a(a a1)
    {
        if (a1.isRunningNow && a1.isScheduledToRun)
        {
            return -1;
        }
        if (!a1.isRunningNow && !a1.isScheduledToRun)
        {
            return !a1.hasThrottleTimeExpired ? 3 : 1;
        } else
        {
            return 2;
        }
    }
}
