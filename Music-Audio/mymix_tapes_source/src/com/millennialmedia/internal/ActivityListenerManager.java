// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ActivityListenerManager
{
    public static class ActivityListener
    {

        public void onCreated(Activity activity)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.TAG, "Activity created");
            }
        }

        public void onDestroyed(Activity activity)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.TAG, "Activity destroyed");
            }
        }

        public void onPaused(Activity activity)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.TAG, "Activity paused");
            }
        }

        public void onResumed(Activity activity)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.TAG, "Activity resumed");
            }
        }

        public void onStarted(Activity activity)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.TAG, "Activity started");
            }
        }

        public void onStopped(Activity activity)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.TAG, "Activity stopped");
            }
        }

        public ActivityListener()
        {
        }
    }

    private static class ActivityState
    {

        private List activityListenerRefs;
        private LifecycleState lifecycleState;

        LifecycleState getLifecycleState()
        {
            return lifecycleState;
        }

        List getListeners()
        {
            ArrayList arraylist = new ArrayList();
            if (activityListenerRefs != null)
            {
                for (Iterator iterator = activityListenerRefs.iterator(); iterator.hasNext();)
                {
                    ActivityListener activitylistener = (ActivityListener)((WeakReference)iterator.next()).get();
                    if (activitylistener == null)
                    {
                        iterator.remove();
                    } else
                    {
                        arraylist.add(activitylistener);
                    }
                }

            }
            return arraylist;
        }

        void registerListener(ActivityListener activitylistener)
        {
            if (activityListenerRefs == null)
            {
                activityListenerRefs = new ArrayList();
            }
            activityListenerRefs.add(new WeakReference(activitylistener));
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Registered activity listener: ").append(activitylistener).toString());
            }
        }

        void unregisterListener(ActivityListener activitylistener)
        {
label0:
            {
                if (activityListenerRefs == null)
                {
                    break label0;
                }
                Iterator iterator = activityListenerRefs.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                } while (activitylistener != ((WeakReference)iterator.next()).get());
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Unregistered activity listener: ").append(activitylistener).toString());
                }
                iterator.remove();
            }
        }


/*
        static LifecycleState access$202(ActivityState activitystate, LifecycleState lifecyclestate)
        {
            activitystate.lifecycleState = lifecyclestate;
            return lifecyclestate;
        }

*/

        ActivityState()
        {
            lifecycleState = LifecycleState.UNKNOWN;
        }
    }

    public static final class LifecycleState extends Enum
    {

        private static final LifecycleState $VALUES[];
        public static final LifecycleState CREATED;
        public static final LifecycleState DESTROYED;
        public static final LifecycleState PAUSED;
        public static final LifecycleState RESUMED;
        public static final LifecycleState STARTED;
        public static final LifecycleState STOPPED;
        public static final LifecycleState UNKNOWN;

        public static LifecycleState valueOf(String s)
        {
            return (LifecycleState)Enum.valueOf(com/millennialmedia/internal/ActivityListenerManager$LifecycleState, s);
        }

        public static LifecycleState[] values()
        {
            return (LifecycleState[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new LifecycleState("UNKNOWN", 0);
            CREATED = new LifecycleState("CREATED", 1);
            STARTED = new LifecycleState("STARTED", 2);
            RESUMED = new LifecycleState("RESUMED", 3);
            PAUSED = new LifecycleState("PAUSED", 4);
            STOPPED = new LifecycleState("STOPPED", 5);
            DESTROYED = new LifecycleState("DESTROYED", 6);
            $VALUES = (new LifecycleState[] {
                UNKNOWN, CREATED, STARTED, RESUMED, PAUSED, STOPPED, DESTROYED
            });
        }

        private LifecycleState(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/millennialmedia/internal/ActivityListenerManager.getSimpleName();
    private static volatile Map activities = new HashMap();

    public ActivityListenerManager()
    {
    }

    private static ActivityState getActivityState(int i, boolean flag)
    {
        ActivityState activitystate1 = (ActivityState)activities.get(Integer.valueOf(i));
        ActivityState activitystate = activitystate1;
        if (activitystate1 == null)
        {
            activitystate = activitystate1;
            if (flag)
            {
                activitystate = new ActivityState();
                activities.put(Integer.valueOf(i), activitystate);
            }
        }
        return activitystate;
    }

    public static LifecycleState getLifecycleState(int i)
    {
        LifecycleState lifecyclestate = LifecycleState.UNKNOWN;
        ActivityState activitystate = getActivityState(i, false);
        if (activitystate != null)
        {
            lifecyclestate = activitystate.getLifecycleState();
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Lifecycle state <").append(lifecyclestate).append("> for activity ID <").append(i).append(">").toString());
        }
        return lifecyclestate;
    }

    public static LifecycleState getLifecycleState(Activity activity)
    {
        if (activity != null)
        {
            return getLifecycleState(activity.hashCode());
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "Lifecycle state <UNKNOWN> for null activity");
        }
        return LifecycleState.UNKNOWN;
    }

    public static void init()
    {
        android.app.Application.ActivityLifecycleCallbacks activitylifecyclecallbacks = new android.app.Application.ActivityLifecycleCallbacks() {

            public void onActivityCreated(Activity activity, Bundle bundle)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Activity onCreate called for activity ID: ").append(activity.hashCode()).toString());
                }
                bundle = ActivityListenerManager.getActivityState(activity.hashCode(), true);
                bundle.lifecycleState = LifecycleState.CREATED;
                ActivityListener activitylistener;
                for (bundle = bundle.getListeners().iterator(); bundle.hasNext(); activitylistener.onCreated(activity))
                {
                    activitylistener = (ActivityListener)bundle.next();
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Calling onCreated of activity listener <").append(activitylistener).append("> for activity ID <").append(activity.hashCode()).append(">").toString());
                    }
                }

            }

            public void onActivityDestroyed(Activity activity)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Activity onDestroy called for activity ID: ").append(activity.hashCode()).toString());
                }
                Object obj = ActivityListenerManager.getActivityState(activity.hashCode(), false);
                if (obj == null)
                {
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Unable to find activity state for activity ID: ").append(activity.hashCode()).toString());
                    }
                    return;
                }
                obj.lifecycleState = LifecycleState.DESTROYED;
                ActivityListener activitylistener;
                for (obj = ((ActivityState) (obj)).getListeners().iterator(); ((Iterator) (obj)).hasNext(); activitylistener.onDestroyed(activity))
                {
                    activitylistener = (ActivityListener)((Iterator) (obj)).next();
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Calling onDestroyed of activity listener <").append(activitylistener).append("> for activity ID <").append(activity.hashCode()).append(">").toString());
                    }
                }

                ActivityListenerManager.activities.remove(Integer.valueOf(activity.hashCode()));
            }

            public void onActivityPaused(Activity activity)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Activity onPause called for activity ID: ").append(activity.hashCode()).toString());
                }
                Object obj = ActivityListenerManager.getActivityState(activity.hashCode(), true);
                obj.lifecycleState = LifecycleState.PAUSED;
                ActivityListener activitylistener;
                for (obj = ((ActivityState) (obj)).getListeners().iterator(); ((Iterator) (obj)).hasNext(); activitylistener.onPaused(activity))
                {
                    activitylistener = (ActivityListener)((Iterator) (obj)).next();
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Calling onPaused of activity listener <").append(activitylistener).append("> for activity ID <").append(activity.hashCode()).append(">").toString());
                    }
                }

            }

            public void onActivityResumed(Activity activity)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Activity onResume called for activity ID: ").append(activity.hashCode()).toString());
                }
                Object obj = ActivityListenerManager.getActivityState(activity.hashCode(), true);
                obj.lifecycleState = LifecycleState.RESUMED;
                ActivityListener activitylistener;
                for (obj = ((ActivityState) (obj)).getListeners().iterator(); ((Iterator) (obj)).hasNext(); activitylistener.onResumed(activity))
                {
                    activitylistener = (ActivityListener)((Iterator) (obj)).next();
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Calling onResumed of activity listener <").append(activitylistener).append("> for activity ID <").append(activity.hashCode()).append(">").toString());
                    }
                }

            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Activity onSaveInstanceState called for activity ID: ").append(activity.hashCode()).toString());
                }
            }

            public void onActivityStarted(Activity activity)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Activity onStart called for activity ID: ").append(activity.hashCode()).toString());
                }
                Object obj = ActivityListenerManager.getActivityState(activity.hashCode(), true);
                obj.lifecycleState = LifecycleState.STARTED;
                ActivityListener activitylistener;
                for (obj = ((ActivityState) (obj)).getListeners().iterator(); ((Iterator) (obj)).hasNext(); activitylistener.onStarted(activity))
                {
                    activitylistener = (ActivityListener)((Iterator) (obj)).next();
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Calling onStarted of activity listener <").append(activitylistener).append("> for activity ID <").append(activity.hashCode()).append(">").toString());
                    }
                }

            }

            public void onActivityStopped(Activity activity)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Activity onStop called for activity ID: ").append(activity.hashCode()).toString());
                }
                Object obj = ActivityListenerManager.getActivityState(activity.hashCode(), true);
                obj.lifecycleState = LifecycleState.STOPPED;
                ActivityListener activitylistener;
                for (obj = ((ActivityState) (obj)).getListeners().iterator(); ((Iterator) (obj)).hasNext(); activitylistener.onStopped(activity))
                {
                    activitylistener = (ActivityListener)((Iterator) (obj)).next();
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(ActivityListenerManager.TAG, (new StringBuilder()).append("Calling onStopped of activity listener <").append(activitylistener).append("> for activity ID <").append(activity.hashCode()).append(">").toString());
                    }
                }

            }

        };
        EnvironmentUtils.getApplication().registerActivityLifecycleCallbacks(activitylifecyclecallbacks);
    }

    public static void registerListener(int i, ActivityListener activitylistener)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Attempting to register activity listener.\n\tactivity ID: ").append(i).append("\n\tactivity listener: ").append(activitylistener).toString());
        }
        if (activitylistener == null)
        {
            MMLog.e(TAG, "Unable to register activity listener, provided instance is null");
            return;
        } else
        {
            getActivityState(i, true).registerListener(activitylistener);
            return;
        }
    }

    public static void unregisterListener(int i, ActivityListener activitylistener)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Attempting to unregister activity listener.\n\tactivity ID: ").append(i).append("\n\tactivity listener: ").append(activitylistener).toString());
        }
        ActivityState activitystate;
        if (activitylistener != null)
        {
            if ((activitystate = getActivityState(i, false)) != null)
            {
                activitystate.unregisterListener(activitylistener);
                return;
            }
        }
    }




}
