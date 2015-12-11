// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import com.urbanairship.Logger;

class ActivityState
{

    private static final int NONE = 2;
    private static final int STARTED = 0;
    private static final int STOPPED = 1;
    private final String activityName;
    private final boolean analyticsEnabled;
    private int autoInstrumentedState;
    private final int currentSdkVersion;
    private long lastModifiedTimeMS;
    private int manualInstrumentedState;
    private final int minSdkVersion;

    public ActivityState(String s, int i, int j, boolean flag)
    {
        autoInstrumentedState = 2;
        manualInstrumentedState = 2;
        lastModifiedTimeMS = 0L;
        activityName = s;
        minSdkVersion = i;
        currentSdkVersion = j;
        analyticsEnabled = flag;
        lastModifiedTimeMS = System.currentTimeMillis();
    }

    long getLastModifiedTime()
    {
        return lastModifiedTimeMS;
    }

    boolean isForeground()
    {
        if (currentSdkVersion < 14) goto _L2; else goto _L1
_L1:
        if (autoInstrumentedState != 0) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (manualInstrumentedState != 0)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    void setStarted(int i, long l)
    {
        if (i == 0)
        {
            if (manualInstrumentedState == 0 && analyticsEnabled)
            {
                Logger.warn((new StringBuilder("Activity ")).append(activityName).append(" already added without being removed first. Call Analytics.activityStopped(this) in every activity's onStop() method.").toString());
            }
            manualInstrumentedState = 0;
        } else
        {
            autoInstrumentedState = 0;
        }
        lastModifiedTimeMS = l;
    }

    void setStopped(int i, long l)
    {
        if (i == 0)
        {
            if (manualInstrumentedState != 0 && analyticsEnabled)
            {
                Logger.warn((new StringBuilder("Activity ")).append(activityName).append(" removed without being manually added first. Call Analytics.activityStarted(this) in every activity's onStart() method.").toString());
            } else
            if (currentSdkVersion >= 14 && autoInstrumentedState == 2 && analyticsEnabled)
            {
                Logger.warn((new StringBuilder("Activity ")).append(activityName).append(" removed in Analytics not during the activity's onStop() method.").toString());
            }
            manualInstrumentedState = 1;
        } else
        {
            if (minSdkVersion < 14 && manualInstrumentedState == 2 && analyticsEnabled)
            {
                Logger.warn((new StringBuilder("Activity ")).append(activityName).append(" was not manually added during onStart(). Call Analytics.activityStarted(this) in every activity's onStart() method.").toString());
            }
            autoInstrumentedState = 1;
        }
        lastModifiedTimeMS = l;
    }
}
