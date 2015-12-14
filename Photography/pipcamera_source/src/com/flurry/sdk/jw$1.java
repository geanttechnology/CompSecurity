// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package com.flurry.sdk:
//            jw, jv, kg

class it>
    implements android.app.cation.ActivityLifecycleCallbacks
{

    final jw a;

    protected void a(Activity activity,  )
    {
        jv jv1 = new jv();
        jv1.a = activity;
        jv1.b = ;
        jv1.b();
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
        kg.a(3, jw.d(), (new StringBuilder()).append("onActivityCreated for activity:").append(activity).toString());
        a(activity, a);
    }

    public void onActivityDestroyed(Activity activity)
    {
        kg.a(3, jw.d(), (new StringBuilder()).append("onActivityDestroyed for activity:").append(activity).toString());
        a(activity, b);
    }

    public void onActivityPaused(Activity activity)
    {
        kg.a(3, jw.d(), (new StringBuilder()).append("onActivityPaused for activity:").append(activity).toString());
        a(activity, c);
    }

    public void onActivityResumed(Activity activity)
    {
        kg.a(3, jw.d(), (new StringBuilder()).append("onActivityResumed for activity:").append(activity).toString());
        a(activity, d);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
        kg.a(3, jw.d(), (new StringBuilder()).append("onActivitySaveInstanceState for activity:").append(activity).toString());
        a(activity, g);
    }

    public void onActivityStarted(Activity activity)
    {
        kg.a(3, jw.d(), (new StringBuilder()).append("onActivityStarted for activity:").append(activity).toString());
        a(activity, e);
    }

    public void onActivityStopped(Activity activity)
    {
        kg.a(3, jw.d(), (new StringBuilder()).append("onActivityStopped for activity:").append(activity).toString());
        a(activity, f);
    }

    (jw jw1)
    {
        a = jw1;
        super();
    }
}
