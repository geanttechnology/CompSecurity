// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.app.Activity;
import com.millennialmedia.MMLog;

// Referenced classes of package com.millennialmedia.internal:
//            ActivityListenerManager

public static class 
{

    public void onCreated(Activity activity)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ActivityListenerManager.access$000(), "Activity created");
        }
    }

    public void onDestroyed(Activity activity)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ActivityListenerManager.access$000(), "Activity destroyed");
        }
    }

    public void onPaused(Activity activity)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ActivityListenerManager.access$000(), "Activity paused");
        }
    }

    public void onResumed(Activity activity)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ActivityListenerManager.access$000(), "Activity resumed");
        }
    }

    public void onStarted(Activity activity)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ActivityListenerManager.access$000(), "Activity started");
        }
    }

    public void onStopped(Activity activity)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ActivityListenerManager.access$000(), "Activity stopped");
        }
    }

    public ()
    {
    }
}
