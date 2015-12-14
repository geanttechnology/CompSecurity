// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android;

import android.app.Application;
import android.content.Context;

public class ActivityLifecycleManager
{

    private final Application application;
    private ActivityLifecycleCallbacksWrapper callbacksWrapper;

    public ActivityLifecycleManager(Context context)
    {
        application = (Application)context.getApplicationContext();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            callbacksWrapper = new ActivityLifecycleCallbacksWrapper(application);
        }
    }

    public boolean registerCallbacks(Callbacks callbacks)
    {
        return callbacksWrapper != null && callbacksWrapper.registerLifecycleCallbacks(callbacks);
    }

    public void resetCallbacks()
    {
        if (callbacksWrapper != null)
        {
            callbacksWrapper.clearCallbacks();
        }
    }

    private class ActivityLifecycleCallbacksWrapper
    {

        private final Application application;
        private final Set registeredCallbacks = new HashSet();

        private void clearCallbacks()
        {
            android.app.Application.ActivityLifecycleCallbacks activitylifecyclecallbacks;
            for (Iterator iterator = registeredCallbacks.iterator(); iterator.hasNext(); application.unregisterActivityLifecycleCallbacks(activitylifecyclecallbacks))
            {
                activitylifecyclecallbacks = (android.app.Application.ActivityLifecycleCallbacks)iterator.next();
            }

        }

        private boolean registerLifecycleCallbacks(final Callbacks callbacks)
        {
            if (application != null)
            {
                callbacks = new android.app.Application.ActivityLifecycleCallbacks() {

                    final ActivityLifecycleCallbacksWrapper this$0;
                    final Callbacks val$callbacks;

                    public void onActivityCreated(Activity activity, Bundle bundle)
                    {
                        callbacks.onActivityCreated(activity, bundle);
                    }

                    public void onActivityDestroyed(Activity activity)
                    {
                        callbacks.onActivityDestroyed(activity);
                    }

                    public void onActivityPaused(Activity activity)
                    {
                        callbacks.onActivityPaused(activity);
                    }

                    public void onActivityResumed(Activity activity)
                    {
                        callbacks.onActivityResumed(activity);
                    }

                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
                    {
                        callbacks.onActivitySaveInstanceState(activity, bundle);
                    }

                    public void onActivityStarted(Activity activity)
                    {
                        callbacks.onActivityStarted(activity);
                    }

                    public void onActivityStopped(Activity activity)
                    {
                        callbacks.onActivityStopped(activity);
                    }

                
                {
                    this$0 = ActivityLifecycleCallbacksWrapper.this;
                    callbacks = callbacks1;
                    super();
                }

                    private class Callbacks
                    {

                        public void onActivityCreated(Activity activity, Bundle bundle)
                        {
                        }

                        public void onActivityDestroyed(Activity activity)
                        {
                        }

                        public void onActivityPaused(Activity activity)
                        {
                        }

                        public void onActivityResumed(Activity activity)
                        {
                        }

                        public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
                        {
                        }

                        public void onActivityStarted(Activity activity)
                        {
                        }

                        public void onActivityStopped(Activity activity)
                        {
                        }

                        public Callbacks()
                        {
                        }
                    }

                };
                application.registerActivityLifecycleCallbacks(callbacks);
                registeredCallbacks.add(callbacks);
                return true;
            } else
            {
                return false;
            }
        }



        ActivityLifecycleCallbacksWrapper(Application application1)
        {
            application = application1;
        }
    }

}
