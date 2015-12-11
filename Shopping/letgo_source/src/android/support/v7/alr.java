// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class alr
{
    private static class a
    {

        private final Set a = new HashSet();
        private final Application b;

        private void a()
        {
            android.app.Application.ActivityLifecycleCallbacks activitylifecyclecallbacks;
            for (Iterator iterator = a.iterator(); iterator.hasNext(); b.unregisterActivityLifecycleCallbacks(activitylifecyclecallbacks))
            {
                activitylifecyclecallbacks = (android.app.Application.ActivityLifecycleCallbacks)iterator.next();
            }

        }

        static void a(a a1)
        {
            a1.a();
        }

        static boolean a(a a1, b b1)
        {
            return a1.a(b1);
        }

        private boolean a(b b1)
        {
            if (b != null)
            {
                b1 = new android.app.Application.ActivityLifecycleCallbacks(this, b1) {

                    final b a;
                    final a b;

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
                b = a1;
                a = b1;
                super();
            }
                };
                b.registerActivityLifecycleCallbacks(b1);
                a.add(b1);
                return true;
            } else
            {
                return false;
            }
        }

        a(Application application)
        {
            b = application;
        }
    }

    public static abstract class b
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

        public b()
        {
        }
    }


    private final Application a;
    private a b;

    public alr(Context context)
    {
        a = (Application)context.getApplicationContext();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            b = new a(a);
        }
    }

    public void a()
    {
        if (b != null)
        {
            a.a(b);
        }
    }

    public boolean a(b b1)
    {
        return b != null && a.a(b, b1);
    }
}
