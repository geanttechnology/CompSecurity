// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import android.app.ActivityManager;
import java.util.List;

// Referenced classes of package com.amazon.analytics:
//            TailwindActivityManager

class TailwindActivityManagerImpl
    implements TailwindActivityManager
{

    private final ActivityManager activityManager;

    public TailwindActivityManagerImpl(ActivityManager activitymanager)
    {
        activityManager = activitymanager;
    }

    public List getRunningAppProcesses()
    {
        return activityManager.getRunningAppProcesses();
    }
}
