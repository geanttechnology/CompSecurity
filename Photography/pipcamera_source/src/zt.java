// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class zt
{

    private final Set a = new HashSet();
    private final Application b;

    zt(Application application)
    {
        b = application;
    }

    private void a()
    {
        android.app.Application.ActivityLifecycleCallbacks activitylifecyclecallbacks;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); b.unregisterActivityLifecycleCallbacks(activitylifecyclecallbacks))
        {
            activitylifecyclecallbacks = (android.app.Application.ActivityLifecycleCallbacks)iterator.next();
        }

    }

    static void a(zt zt1)
    {
        zt1.a();
    }

    static boolean a(zt zt1, zu zu)
    {
        return zt1.a(zu);
    }

    private boolean a(zu zu)
    {
        if (b != null)
        {
            zu = new android.app.Application.ActivityLifecycleCallbacks(zu) {

                final zu a;
                final zt b;

                public void onActivityCreated(Activity activity, Bundle bundle)
                {
                    a.onActivityCreated(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity)
                {
                    a.onActivityDestroyed(activity);
                }

                public void onActivityPaused(Activity activity)
                {
                    a.onActivityPaused(activity);
                }

                public void onActivityResumed(Activity activity)
                {
                    a.onActivityResumed(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
                {
                    a.onActivitySaveInstanceState(activity, bundle);
                }

                public void onActivityStarted(Activity activity)
                {
                    a.onActivityStarted(activity);
                }

                public void onActivityStopped(Activity activity)
                {
                    a.onActivityStopped(activity);
                }

            
            {
                b = zt.this;
                a = zu1;
                super();
            }
            };
            b.registerActivityLifecycleCallbacks(zu);
            a.add(zu);
            return true;
        } else
        {
            return false;
        }
    }
}
