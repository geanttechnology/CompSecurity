// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.os.Bundle;

class bsl
    implements android.app.Application.ActivityLifecycleCallbacks
{

    final bsm a;
    final bsk b;

    bsl(bsk bsk, bsm bsm1)
    {
        b = bsk;
        a = bsm1;
        super();
    }

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
}
