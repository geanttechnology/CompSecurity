// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;

import android.app.Application;

// Referenced classes of package org.chromium.base:
//            ObserverList, ApplicationStatus

public class BaseChromiumApplication extends Application
{

    ObserverList a;

    public BaseChromiumApplication()
    {
        a = new ObserverList();
    }

    static ObserverList a(BaseChromiumApplication basechromiumapplication)
    {
        return basechromiumapplication.a;
    }

    public void onCreate()
    {
        super.onCreate();
        ApplicationStatus.a(this);
        registerActivityLifecycleCallbacks(new _cls1());
    }

    private class _cls1
        implements android.app.Application.ActivityLifecycleCallbacks
    {

        private static boolean b;
        final BaseChromiumApplication a;

        public void onActivityCreated(Activity activity, Bundle bundle)
        {
            bundle = activity.getWindow().getCallback();
            class _cls1 extends WindowCallbackWrapper
            {

                private Activity a;
                private _cls1 b;

                public void onWindowFocusChanged(boolean flag)
                {
                    super.onWindowFocusChanged(flag);
                    for (Iterator iterator = BaseChromiumApplication.a(b.a).iterator(); iterator.hasNext(); ((WindowFocusChangedListener)iterator.next()).a(a, flag)) { }
                }

                _cls1(android.view.Window.Callback callback, Activity activity)
                {
                    b = _cls1.this;
                    a = activity;
                    super(callback);
                }

                private class WindowFocusChangedListener
                {

                    public abstract void a(Activity activity, boolean flag);
                }

            }

            activity.getWindow().setCallback(new _cls1(bundle, activity));
        }

        public void onActivityDestroyed(Activity activity)
        {
            if (!b && !(activity.getWindow().getCallback() instanceof WindowCallbackWrapper))
            {
                throw new AssertionError();
            } else
            {
                return;
            }
        }

        public void onActivityPaused(Activity activity)
        {
            if (!b && !(activity.getWindow().getCallback() instanceof WindowCallbackWrapper))
            {
                throw new AssertionError();
            } else
            {
                return;
            }
        }

        public void onActivityResumed(Activity activity)
        {
            if (!b && !(activity.getWindow().getCallback() instanceof WindowCallbackWrapper))
            {
                throw new AssertionError();
            } else
            {
                return;
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
        {
            if (!b && !(activity.getWindow().getCallback() instanceof WindowCallbackWrapper))
            {
                throw new AssertionError();
            } else
            {
                return;
            }
        }

        public void onActivityStarted(Activity activity)
        {
            if (!b && !(activity.getWindow().getCallback() instanceof WindowCallbackWrapper))
            {
                throw new AssertionError();
            } else
            {
                return;
            }
        }

        public void onActivityStopped(Activity activity)
        {
            if (!b && !(activity.getWindow().getCallback() instanceof WindowCallbackWrapper))
            {
                throw new AssertionError();
            } else
            {
                return;
            }
        }

        static 
        {
            boolean flag;
            if (!org/chromium/base/BaseChromiumApplication.desiredAssertionStatus())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            b = flag;
        }

        _cls1()
        {
            a = BaseChromiumApplication.this;
            super();
        }
    }

}
