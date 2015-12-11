// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.x;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            wq, wj

public final class wt
    implements android.app.Application.ActivityLifecycleCallbacks
{

    private final wj a;
    private final Map b = new HashMap();

    public wt(wj wj1)
    {
        x.a(wj1);
        a = wj1;
    }

    wq a(Activity activity, int i)
    {
        x.a(activity);
        wq wq2 = (wq)b.get(activity);
        wq wq1 = wq2;
        if (wq2 == null)
        {
            if (i == 0)
            {
                wq1 = new wq(true);
            } else
            {
                wq1 = new wq(true, i);
            }
            wq1.a(activity.getClass().getCanonicalName());
            b.put(activity, wq1);
        }
        return wq1;
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
        if (bundle != null)
        {
            if ((bundle = bundle.getBundle("com.google.android.gms.measurement.screen_view")) != null)
            {
                int i = bundle.getInt("id");
                if (i <= 0)
                {
                    Log.w("com.google.android.gms.measurement.internal.ActivityLifecycleTracker", "Invalid screenId in saved activity state");
                    return;
                } else
                {
                    activity = a(activity, i);
                    activity.a(bundle.getString("name"));
                    activity.b(bundle.getInt("referrer_id"));
                    activity.b(bundle.getString("referrer_name"));
                    activity.b(bundle.getBoolean("interstitial"));
                    activity.h();
                    return;
                }
            }
        }
    }

    public void onActivityDestroyed(Activity activity)
    {
        b.remove(activity);
    }

    public void onActivityPaused(Activity activity)
    {
    }

    public void onActivityResumed(Activity activity)
    {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
        if (bundle != null)
        {
            if ((activity = (wq)b.get(activity)) != null)
            {
                Bundle bundle1 = new Bundle();
                bundle1.putInt("id", activity.c());
                bundle1.putString("name", activity.b());
                bundle1.putInt("referrer_id", activity.d());
                bundle1.putString("referrer_name", activity.e());
                bundle1.putBoolean("interstitial", activity.i());
                bundle.putBundle("com.google.android.gms.measurement.screen_view", bundle1);
                return;
            }
        }
    }

    public void onActivityStarted(Activity activity)
    {
        wq wq1 = a(activity, 0);
        a.a(wq1, activity);
    }

    public void onActivityStopped(Activity activity)
    {
    }
}
