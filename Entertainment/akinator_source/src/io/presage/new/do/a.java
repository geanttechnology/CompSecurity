// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.new.do;

import android.app.Activity;
import android.os.Bundle;
import io.presage.utils.e;
import java.util.ArrayList;
import java.util.List;

public class io.presage.new.do.a
    implements android.app.Application.ActivityLifecycleCallbacks
{
    public static interface a
    {

        public abstract void a(Activity activity);
    }

    public static interface b
    {

        public abstract void a();
    }


    private a a;
    private b b;
    private List c;
    private Activity d;

    public io.presage.new.do.a()
    {
        c = new ArrayList();
        d = null;
    }

    final Activity a()
    {
        return d;
    }

    public final void a(a a1)
    {
        a = a1;
    }

    public final void a(b b1)
    {
        b = b1;
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public void onActivityDestroyed(Activity activity)
    {
    }

    public void onActivityPaused(Activity activity)
    {
        e.b(new String[] {
            io/presage/new/do/a.getName(), activity.getClass().getName(), "paused"
        });
        if (activity.equals(d))
        {
            d = null;
        }
    }

    public void onActivityResumed(Activity activity)
    {
        e.b(new String[] {
            io/presage/new/do/a.getName(), activity.getClass().getName(), "resumed"
        });
        d = activity;
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public void onActivityStarted(Activity activity)
    {
        e.b(new String[] {
            io/presage/new/do/a.getName(), activity.getClass().getName(), "started"
        });
        c.add(activity);
        if (c.size() == 1 && a != null)
        {
            a.a(activity);
        }
    }

    public void onActivityStopped(Activity activity)
    {
        e.b(new String[] {
            io/presage/new/do/a.getName(), activity.getClass().getName(), "stopped"
        });
        c.remove(activity);
        if (c.isEmpty() && b != null)
        {
            b.a();
        }
    }
}
