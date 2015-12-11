// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.j.a.d.ac;
import com.j.a.d.ag;
import com.j.a.d.e;
import com.j.a.e.az;
import com.j.a.g.a.d;
import com.j.a.g.b;
import com.j.a.g.m;
import com.j.a.g.w;
import java.util.Map;

// Referenced classes of package com.j.a:
//            g

public class i
    implements android.app.Application.ActivityLifecycleCallbacks
{

    private d a;

    public i()
    {
        a = new d();
    }

    public static i a(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14 && (context.getApplicationContext() instanceof Application))
        {
            context = (Application)context.getApplicationContext();
            i j = new i();
            context.registerActivityLifecycleCallbacks(j);
            e.e().a(true);
            return j;
        } else
        {
            return null;
        }
    }

    public static void a(i j)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            Context context = e.e().o();
            if (context != null)
            {
                ((Application)context.getApplicationContext()).unregisterActivityLifecycleCallbacks(j);
                e.e().a(false);
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
        try
        {
            w.a((new StringBuilder()).append("Activity has been created: ").append(activity.getClass().getSimpleName()).toString());
            e.e().r();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            w.b("Activity null", activity);
        }
    }

    public void onActivityDestroyed(Activity activity)
    {
        try
        {
            String s = activity.getClass().getSimpleName();
            w.a((new StringBuilder()).append("Activity has been destroyed: ").append(s).toString());
            if (e.e().p().equals(activity) && !m.a(b.a))
            {
                a.a();
                e.e().n().a("appTerminate");
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            w.b("Problem destroying activity: ", activity);
        }
    }

    public void onActivityPaused(Activity activity)
    {
        try
        {
            w.a("Activity Paused");
            a = new d();
            a.a(new g(this));
            ac.a().c();
            if (e.e().p() != null && e.e().p() == activity)
            {
                e.e().c(false);
            }
            a.a(800);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            w.b("Error pausing: ", activity);
        }
    }

    public void onActivityResumed(Activity activity)
    {
        try
        {
            w.a((new StringBuilder()).append("Activity Resumed: ").append(activity.getClass().getSimpleName()).toString());
            if (e.e().p() != null && e.e().p() == activity)
            {
                e.e().c(true);
            }
            a.a();
            if (e.e().g())
            {
                ag.c().e();
            }
            e.e().b(activity);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            w.b("Error resuming", activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public void onActivityStarted(Activity activity)
    {
        try
        {
            String s = activity.getClass().getSimpleName();
            w.a((new StringBuilder()).append("Activity Started: ").append(s).toString());
            if (!m.a(b.a))
            {
                e.e().n().a("viewAppeared", s, null);
                e.e().n().b().put(s, Long.valueOf(System.currentTimeMillis()));
            }
            e.e().a(activity);
            e.e().b(activity);
            if (e.e().g() && !az.a().a && az.a().b() != null)
            {
                az.a().a(null);
            }
            ag.c().a((ViewGroup)activity.findViewById(0x1020002).getRootView());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            w.b("error starting activity", activity);
        }
    }

    public void onActivityStopped(Activity activity)
    {
        try
        {
            activity = activity.getClass().getSimpleName();
            w.a((new StringBuilder()).append("App Activity Stopped: ").append(activity).toString());
            if (!m.a(b.a))
            {
                e.e().n().a("viewDisappeared", activity, null);
                com.j.a.a.d.b(activity);
            }
            ag.c().i();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            w.b("Error stopping activity: ", activity);
        }
    }
}
