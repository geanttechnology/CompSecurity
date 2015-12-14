// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.app.Activity;
import android.os.Bundle;
import com.millennialmedia.MMLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.millennialmedia.internal:
//            ActivityListenerManager

static final class tivityListener
    implements android.app.cleCallbacks
{

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Activity onCreate called for activity ID: ").append(activity.hashCode()).toString());
        }
        bundle = ActivityListenerManager.access$100(activity.hashCode(), true);
        tivityState.access._mth202(bundle, fecycleState.CREATED);
        tivityListener tivitylistener;
        for (bundle = bundle.getListeners().iterator(); bundle.hasNext(); tivitylistener.onCreated(activity))
        {
            tivitylistener = (tivityListener)bundle.next();
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Calling onCreated of activity listener <").append(tivitylistener).append("> for activity ID <").append(activity.hashCode()).append(">").toString());
            }
        }

    }

    public void onActivityDestroyed(Activity activity)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Activity onDestroy called for activity ID: ").append(activity.hashCode()).toString());
        }
        Object obj = ActivityListenerManager.access$100(activity.hashCode(), false);
        if (obj == null)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Unable to find activity state for activity ID: ").append(activity.hashCode()).toString());
            }
            return;
        }
        tivityState.access._mth202(((tivityState) (obj)), fecycleState.DESTROYED);
        tivityListener tivitylistener;
        for (obj = ((tivityState) (obj)).getListeners().iterator(); ((Iterator) (obj)).hasNext(); tivitylistener.onDestroyed(activity))
        {
            tivitylistener = (tivityListener)((Iterator) (obj)).next();
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Calling onDestroyed of activity listener <").append(tivitylistener).append("> for activity ID <").append(activity.hashCode()).append(">").toString());
            }
        }

        ActivityListenerManager.access$300().remove(Integer.valueOf(activity.hashCode()));
    }

    public void onActivityPaused(Activity activity)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Activity onPause called for activity ID: ").append(activity.hashCode()).toString());
        }
        Object obj = ActivityListenerManager.access$100(activity.hashCode(), true);
        tivityState.access._mth202(((tivityState) (obj)), fecycleState.PAUSED);
        tivityListener tivitylistener;
        for (obj = ((tivityState) (obj)).getListeners().iterator(); ((Iterator) (obj)).hasNext(); tivitylistener.onPaused(activity))
        {
            tivitylistener = (tivityListener)((Iterator) (obj)).next();
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Calling onPaused of activity listener <").append(tivitylistener).append("> for activity ID <").append(activity.hashCode()).append(">").toString());
            }
        }

    }

    public void onActivityResumed(Activity activity)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Activity onResume called for activity ID: ").append(activity.hashCode()).toString());
        }
        Object obj = ActivityListenerManager.access$100(activity.hashCode(), true);
        tivityState.access._mth202(((tivityState) (obj)), fecycleState.RESUMED);
        tivityListener tivitylistener;
        for (obj = ((tivityState) (obj)).getListeners().iterator(); ((Iterator) (obj)).hasNext(); tivitylistener.onResumed(activity))
        {
            tivitylistener = (tivityListener)((Iterator) (obj)).next();
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Calling onResumed of activity listener <").append(tivitylistener).append("> for activity ID <").append(activity.hashCode()).append(">").toString());
            }
        }

    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Activity onSaveInstanceState called for activity ID: ").append(activity.hashCode()).toString());
        }
    }

    public void onActivityStarted(Activity activity)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Activity onStart called for activity ID: ").append(activity.hashCode()).toString());
        }
        Object obj = ActivityListenerManager.access$100(activity.hashCode(), true);
        tivityState.access._mth202(((tivityState) (obj)), fecycleState.STARTED);
        tivityListener tivitylistener;
        for (obj = ((tivityState) (obj)).getListeners().iterator(); ((Iterator) (obj)).hasNext(); tivitylistener.onStarted(activity))
        {
            tivitylistener = (tivityListener)((Iterator) (obj)).next();
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Calling onStarted of activity listener <").append(tivitylistener).append("> for activity ID <").append(activity.hashCode()).append(">").toString());
            }
        }

    }

    public void onActivityStopped(Activity activity)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Activity onStop called for activity ID: ").append(activity.hashCode()).toString());
        }
        Object obj = ActivityListenerManager.access$100(activity.hashCode(), true);
        tivityState.access._mth202(((tivityState) (obj)), fecycleState.STOPPED);
        tivityListener tivitylistener;
        for (obj = ((tivityState) (obj)).getListeners().iterator(); ((Iterator) (obj)).hasNext(); tivitylistener.onStopped(activity))
        {
            tivitylistener = (tivityListener)((Iterator) (obj)).next();
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Calling onStopped of activity listener <").append(tivitylistener).append("> for activity ID <").append(activity.hashCode()).append(">").toString());
            }
        }

    }

    tivityListener()
    {
    }
}
