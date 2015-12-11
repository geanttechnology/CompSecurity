// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;

// Referenced classes of package com.urbanairship.analytics:
//            ActivityState

class ActivityMonitor
{

    static final int AUTO_INSTRUMENTATION = 1;
    private static final int BACKGROUND_DELAY_MS = 2000;
    static final int MANUAL_INSTRUMENTATION = 0;
    private final SparseArray activityStates = new SparseArray();
    private final boolean analyticsEnabled;
    private final int currentSdkVersion;
    private boolean isForeground;
    private Listener listener;
    private final int minSdkVersion;

    ActivityMonitor(int i, int j, boolean flag)
    {
        isForeground = false;
        minSdkVersion = i;
        currentSdkVersion = j;
        analyticsEnabled = flag;
    }

    private ActivityState getActivityState(Activity activity)
    {
        ActivityState activitystate1 = (ActivityState)activityStates.get(activity.hashCode());
        ActivityState activitystate = activitystate1;
        if (activitystate1 == null)
        {
            activitystate = new ActivityState(activity.toString(), minSdkVersion, currentSdkVersion, analyticsEnabled);
            activityStates.put(activity.hashCode(), activitystate);
        }
        return activitystate;
    }

    void activityStarted(Activity activity, int i, long l)
    {
        getActivityState(activity).setStarted(i, l);
        updateForegroundState();
    }

    void activityStopped(Activity activity, int i, long l)
    {
        getActivityState(activity).setStopped(i, l);
        (new Handler(Looper.getMainLooper())).postDelayed(new _cls1(), 2000L);
    }

    void setListener(Listener listener1)
    {
        this;
        JVM INSTR monitorenter ;
        listener = listener1;
        this;
        JVM INSTR monitorexit ;
        return;
        listener1;
        this;
        JVM INSTR monitorexit ;
        throw listener1;
    }

    void updateForegroundState()
    {
        long l;
        long l1;
        boolean flag1;
        int i = 0;
        l1 = 0L;
        l = 0L;
        flag1 = false;
        while (i < activityStates.size()) 
        {
            ActivityState activitystate = (ActivityState)activityStates.valueAt(i);
            long l2;
            long l3;
            boolean flag;
            if (activitystate.isForeground())
            {
                flag1 = true;
                flag = flag1;
                l2 = l1;
                l3 = l;
                if (activitystate.getLastModifiedTime() > l)
                {
                    l3 = activitystate.getLastModifiedTime();
                    l2 = l1;
                    flag = flag1;
                }
            } else
            {
                flag = flag1;
                l2 = l1;
                l3 = l;
                if (activitystate.getLastModifiedTime() > l1)
                {
                    l2 = activitystate.getLastModifiedTime();
                    flag = flag1;
                    l3 = l;
                }
            }
            i++;
            flag1 = flag;
            l1 = l2;
            l = l3;
        }
        if (isForeground == flag1)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        isForeground = flag1;
        this;
        JVM INSTR monitorenter ;
        if (!flag1) goto _L2; else goto _L1
_L1:
        if (listener != null)
        {
            listener.onForeground(l);
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (listener != null)
        {
            listener.onBackground(l1);
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private class _cls1
        implements Runnable
    {

        final ActivityMonitor this$0;

        public void run()
        {
            updateForegroundState();
        }

        _cls1()
        {
            this$0 = ActivityMonitor.this;
            super();
        }
    }


    private class Listener
    {

        abstract void onBackground(long l);

        abstract void onForeground(long l);

        Listener()
        {
        }
    }

}
