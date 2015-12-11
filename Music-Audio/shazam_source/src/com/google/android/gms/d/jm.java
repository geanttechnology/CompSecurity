// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.w;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            jj, jc

public final class jm
    implements android.app.Application.ActivityLifecycleCallbacks
{

    private final jc a;
    private final Map b = new HashMap();

    public jm(jc jc1)
    {
        w.a(jc1);
        a = jc1;
    }

    private jj a(Activity activity, int i)
    {
        w.a(activity);
        jj jj2 = (jj)b.get(activity);
        jj jj1 = jj2;
        if (jj2 == null)
        {
            if (i == 0)
            {
                jj1 = new jj(true);
            } else
            {
                jj1 = new jj(true, i);
            }
            jj1.a(activity.getClass().getCanonicalName());
            b.put(activity, jj1);
        }
        return jj1;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle)
    {
        int i;
        if (bundle != null)
        {
            if ((bundle = bundle.getBundle("com.google.android.gms.measurement.screen_view")) != null && (i = bundle.getInt("id")) > 0)
            {
                activity = a(activity, i);
                activity.a(bundle.getString("name"));
                activity.a(bundle.getInt("referrer_id"));
                activity.b(bundle.getString("referrer_name"));
                activity.a(bundle.getBoolean("interstitial"));
                activity.g = true;
                return;
            }
        }
    }

    public final void onActivityDestroyed(Activity activity)
    {
        b.remove(activity);
    }

    public final void onActivityPaused(Activity activity)
    {
    }

    public final void onActivityResumed(Activity activity)
    {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
        if (bundle != null)
        {
            if ((activity = (jj)b.get(activity)) != null)
            {
                Bundle bundle1 = new Bundle();
                bundle1.putInt("id", ((jj) (activity)).b);
                bundle1.putString("name", ((jj) (activity)).a);
                bundle1.putInt("referrer_id", ((jj) (activity)).c);
                bundle1.putString("referrer_name", ((jj) (activity)).d);
                bundle1.putBoolean("interstitial", ((jj) (activity)).f);
                bundle.putBundle("com.google.android.gms.measurement.screen_view", bundle1);
                return;
            }
        }
    }

    public final void onActivityStarted(Activity activity)
    {
        jc.a aa[];
        jj jj1;
        jc jc1;
        boolean flag;
        flag = false;
        jj1 = a(activity, 0);
        jc1 = a;
        w.a(jj1);
        int i;
        if (!jj1.g)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0) goto _L2; else goto _L1
_L1:
        if (jc1.b != null)
        {
            jj1.a(jc1.b.b);
            jj1.b(jc1.b.a);
        }
        aa = jc1.a();
        for (i = 0; i < aa.length; i++)
        {
            aa[i].a(jj1, activity);
        }

        jj1.g = true;
        if (TextUtils.isEmpty(jj1.a)) goto _L4; else goto _L3
_L3:
        activity = aa;
_L6:
        if (jc1.b != null && jc1.b.b == jj1.b)
        {
            jc1.b = jj1;
        } else
        {
            jc1.b = null;
            jc1.b = jj1;
            Object obj = activity;
            int j = ((flag) ? 1 : 0);
            if (activity == null)
            {
                obj = jc1.a();
                j = ((flag) ? 1 : 0);
            }
            while (j < obj.length) 
            {
                obj[j].a(jj1);
                j++;
            }
        }
_L4:
        return;
_L2:
        activity = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void onActivityStopped(Activity activity)
    {
    }
}
