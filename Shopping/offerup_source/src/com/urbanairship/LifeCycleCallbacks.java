// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.app.Activity;
import android.app.Application;

public abstract class LifeCycleCallbacks
{

    private final android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new _cls1();
    private final Application application;
    private boolean isRegistered;

    public LifeCycleCallbacks(Application application1)
    {
        isRegistered = false;
        application = application1;
    }

    public void onActivityPaused(Activity activity)
    {
    }

    public void onActivityResumed(Activity activity)
    {
    }

    public void onActivityStarted(Activity activity)
    {
    }

    public void onActivityStopped(Activity activity)
    {
    }

    public void register()
    {
        if (!isRegistered)
        {
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            isRegistered = true;
        }
    }

    public void unregister()
    {
        if (isRegistered)
        {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            isRegistered = false;
        }
    }

    private class _cls1
        implements android.app.Application.ActivityLifecycleCallbacks
    {

        final LifeCycleCallbacks this$0;

        public void onActivityCreated(Activity activity, Bundle bundle)
        {
        }

        public void onActivityDestroyed(Activity activity)
        {
        }

        public void onActivityPaused(Activity activity)
        {
            LifeCycleCallbacks.this.onActivityPaused(activity);
        }

        public void onActivityResumed(Activity activity)
        {
            LifeCycleCallbacks.this.onActivityResumed(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
        {
        }

        public void onActivityStarted(Activity activity)
        {
            LifeCycleCallbacks.this.onActivityStarted(activity);
        }

        public void onActivityStopped(Activity activity)
        {
            LifeCycleCallbacks.this.onActivityStopped(activity);
        }

        _cls1()
        {
            this$0 = LifeCycleCallbacks.this;
            super();
        }
    }

}
