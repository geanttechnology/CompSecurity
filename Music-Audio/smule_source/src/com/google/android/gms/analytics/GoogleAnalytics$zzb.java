// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package com.google.android.gms.analytics:
//            GoogleAnalytics

class zzED
    implements android.app.LifecycleCallbacks
{

    final GoogleAnalytics zzED;

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
        zzED.zzl(activity);
    }

    public void onActivityStopped(Activity activity)
    {
        zzED.zzm(activity);
    }

    (GoogleAnalytics googleanalytics)
    {
        zzED = googleanalytics;
        super();
    }
}
