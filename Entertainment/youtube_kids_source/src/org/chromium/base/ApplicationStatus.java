// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package org.chromium.base:
//            ObserverList, BaseChromiumApplication, ThreadUtils

public class ApplicationStatus
{

    private static Application a;
    private static Object b = new Object();
    private static Integer c;
    private static Activity d;
    private static ApplicationStateListener e;
    private static final Map f = new ConcurrentHashMap();
    private static final ObserverList g = new ObserverList();
    private static final ObserverList h = new ObserverList();
    private static boolean i;

    private ApplicationStatus()
    {
    }

    public static int a(Activity activity)
    {
        activity = (ActivityInfo)f.get(activity);
        if (activity != null)
        {
            return ((ActivityInfo) (activity)).a;
        } else
        {
            return 6;
        }
    }

    public static Context a()
    {
        if (a != null)
        {
            return a.getApplicationContext();
        } else
        {
            return null;
        }
    }

    static void a(int j)
    {
        nativeOnApplicationStateChange(j);
    }

    static void a(Activity activity, int j)
    {
        int k;
        if (activity == null)
        {
            throw new IllegalArgumentException("null activity is not supported");
        }
        if (d == null || j == 1 || j == 3 || j == 2)
        {
            d = activity;
        }
        k = d();
        if (j == 1)
        {
            if (!i && f.containsKey(activity))
            {
                throw new AssertionError();
            }
            f.put(activity, new ActivityInfo());
        }
        synchronized (b)
        {
            c = null;
        }
        obj = (ActivityInfo)f.get(activity);
        obj.a = j;
        for (obj = ((ActivityInfo) (obj)).b.iterator(); ((Iterator) (obj)).hasNext(); ((Iterator) (obj)).next()) { }
        break MISSING_BLOCK_LABEL_153;
        activity;
        obj;
        JVM INSTR monitorexit ;
        throw activity;
        for (Iterator iterator = g.iterator(); iterator.hasNext(); iterator.next()) { }
        int l = d();
        if (l != k)
        {
            for (Iterator iterator1 = h.iterator(); iterator1.hasNext(); ((ApplicationStateListener)iterator1.next()).a(l)) { }
        }
        if (j == 6)
        {
            f.remove(activity);
            if (activity == d)
            {
                d = null;
            }
        }
        return;
    }

    public static void a(ApplicationStateListener applicationstatelistener)
    {
        h.a(applicationstatelistener);
    }

    public static void a(BaseChromiumApplication basechromiumapplication)
    {
        a = basechromiumapplication;
        _cls1 _lcls1 = new _cls1();
        basechromiumapplication.a.a(_lcls1);
        basechromiumapplication.registerActivityLifecycleCallbacks(new _cls2());
    }

    static Activity b()
    {
        return d;
    }

    static Activity b(Activity activity)
    {
        d = activity;
        return activity;
    }

    static ApplicationStateListener b(ApplicationStateListener applicationstatelistener)
    {
        e = applicationstatelistener;
        return applicationstatelistener;
    }

    static ApplicationStateListener c()
    {
        return e;
    }

    private static int d()
    {
        int j;
        boolean flag1;
        j = 0;
        flag1 = true;
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        if (c != null) goto _L2; else goto _L1
_L1:
        Iterator iterator = f.values().iterator();
        boolean flag = false;
_L10:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        int k = ((ActivityInfo)iterator.next()).a;
        if (k == 4 || k == 5 || k == 6) goto _L6; else goto _L5
_L5:
        j = ((flag1) ? 1 : 0);
_L8:
        c = Integer.valueOf(j);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return c.intValue();
_L6:
        if (k == 4)
        {
            flag = true;
        } else
        if (k == 5)
        {
            j = 1;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (flag)
        {
            j = 2;
        } else
        if (j != 0)
        {
            j = 3;
        } else
        {
            j = 4;
        }
        if (true) goto _L8; else goto _L7
_L7:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private static native void nativeOnApplicationStateChange(int j);

    private static void registerThreadSafeNativeApplicationStateListener()
    {
        ThreadUtils.a(new _cls3());
    }

    static 
    {
        boolean flag;
        if (!org/chromium/base/ApplicationStatus.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = flag;
    }

    private class ActivityInfo
    {

        int a;
        ObserverList b;

        ActivityInfo()
        {
            a = 6;
            b = new ObserverList();
        }
    }


    private class ApplicationStateListener
    {

        public abstract void a(int j);
    }


    private class _cls1
        implements BaseChromiumApplication.WindowFocusChangedListener
    {

        public final void a(Activity activity, boolean flag)
        {
            int j;
            if (flag && activity != ApplicationStatus.b())
            {
                if ((j = ApplicationStatus.a(activity)) != 6 && j != 5)
                {
                    ApplicationStatus.b(activity);
                    return;
                }
            }
        }

        _cls1()
        {
        }
    }


    private class _cls2
        implements android.app.Application.ActivityLifecycleCallbacks
    {

        public final void onActivityCreated(Activity activity, Bundle bundle)
        {
            ApplicationStatus.a(activity, 1);
        }

        public final void onActivityDestroyed(Activity activity)
        {
            ApplicationStatus.a(activity, 6);
        }

        public final void onActivityPaused(Activity activity)
        {
            ApplicationStatus.a(activity, 4);
        }

        public final void onActivityResumed(Activity activity)
        {
            ApplicationStatus.a(activity, 3);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle)
        {
        }

        public final void onActivityStarted(Activity activity)
        {
            ApplicationStatus.a(activity, 2);
        }

        public final void onActivityStopped(Activity activity)
        {
            ApplicationStatus.a(activity, 5);
        }

        _cls2()
        {
        }
    }


    private class _cls3
        implements Runnable
    {

        public final void run()
        {
            if (ApplicationStatus.c() != null)
            {
                return;
            } else
            {
                class _cls1
                    implements ApplicationStateListener
                {

                    public final void a(int j)
                    {
                        ApplicationStatus.a(j);
                    }

                _cls1()
                {
                }
                }

                ApplicationStatus.b(new _cls1());
                ApplicationStatus.a(ApplicationStatus.c());
                return;
            }
        }

        _cls3()
        {
        }
    }

}
