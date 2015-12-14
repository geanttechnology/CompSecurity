// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.jraf.android.util.activitylifecyclecallbackscompat;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;

// Referenced classes of package org.acra.jraf.android.util.activitylifecyclecallbackscompat:
//            ActivityLifecycleCallbacksCompat

public class MainLifecycleDispatcher
    implements ActivityLifecycleCallbacksCompat
{

    private static final MainLifecycleDispatcher INSTANCE = new MainLifecycleDispatcher();
    private ArrayList mActivityLifecycleCallbacks;

    private MainLifecycleDispatcher()
    {
        mActivityLifecycleCallbacks = new ArrayList();
    }

    private Object[] collectActivityLifecycleCallbacks()
    {
        Object aobj[] = null;
        synchronized (mActivityLifecycleCallbacks)
        {
            if (mActivityLifecycleCallbacks.size() > 0)
            {
                aobj = mActivityLifecycleCallbacks.toArray();
            }
        }
        return aobj;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static MainLifecycleDispatcher get()
    {
        return INSTANCE;
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
        Object aobj[] = collectActivityLifecycleCallbacks();
        if (aobj != null)
        {
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                ((ActivityLifecycleCallbacksCompat)aobj[i]).onActivityCreated(activity, bundle);
            }

        }
    }

    public void onActivityDestroyed(Activity activity)
    {
        Object aobj[] = collectActivityLifecycleCallbacks();
        if (aobj != null)
        {
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                ((ActivityLifecycleCallbacksCompat)aobj[i]).onActivityDestroyed(activity);
            }

        }
    }

    public void onActivityPaused(Activity activity)
    {
        Object aobj[] = collectActivityLifecycleCallbacks();
        if (aobj != null)
        {
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                ((ActivityLifecycleCallbacksCompat)aobj[i]).onActivityPaused(activity);
            }

        }
    }

    public void onActivityResumed(Activity activity)
    {
        Object aobj[] = collectActivityLifecycleCallbacks();
        if (aobj != null)
        {
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                ((ActivityLifecycleCallbacksCompat)aobj[i]).onActivityResumed(activity);
            }

        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
        Object aobj[] = collectActivityLifecycleCallbacks();
        if (aobj != null)
        {
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                ((ActivityLifecycleCallbacksCompat)aobj[i]).onActivitySaveInstanceState(activity, bundle);
            }

        }
    }

    public void onActivityStarted(Activity activity)
    {
        Object aobj[] = collectActivityLifecycleCallbacks();
        if (aobj != null)
        {
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                ((ActivityLifecycleCallbacksCompat)aobj[i]).onActivityStarted(activity);
            }

        }
    }

    public void onActivityStopped(Activity activity)
    {
        Object aobj[] = collectActivityLifecycleCallbacks();
        if (aobj != null)
        {
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                ((ActivityLifecycleCallbacksCompat)aobj[i]).onActivityStopped(activity);
            }

        }
    }

    void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacksCompat activitylifecyclecallbackscompat)
    {
        synchronized (mActivityLifecycleCallbacks)
        {
            mActivityLifecycleCallbacks.add(activitylifecyclecallbackscompat);
        }
        return;
        activitylifecyclecallbackscompat;
        arraylist;
        JVM INSTR monitorexit ;
        throw activitylifecyclecallbackscompat;
    }

    void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacksCompat activitylifecyclecallbackscompat)
    {
        synchronized (mActivityLifecycleCallbacks)
        {
            mActivityLifecycleCallbacks.remove(activitylifecyclecallbackscompat);
        }
        return;
        activitylifecyclecallbackscompat;
        arraylist;
        JVM INSTR monitorexit ;
        throw activitylifecyclecallbackscompat;
    }

}
