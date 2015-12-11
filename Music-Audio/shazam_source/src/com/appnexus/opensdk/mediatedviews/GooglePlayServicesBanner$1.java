// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.appnexus.opensdk.b.b;
import com.google.android.gms.ads.e;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            GooglePlayServicesBanner

class a
    implements android.app.leCallbacks
{

    final GooglePlayServicesBanner a;

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public void onActivityDestroyed(Activity activity)
    {
        if (GooglePlayServicesBanner.access$000(a) == activity)
        {
            b.b(b.c, "GooglePlayServicesBanner - onActivityDestroyed");
            if (GooglePlayServicesBanner.access$100(a) != null)
            {
                GooglePlayServicesBanner.access$100(a).a();
            }
        }
        activity.getApplication().unregisterActivityLifecycleCallbacks(this);
    }

    public void onActivityPaused(Activity activity)
    {
        if (GooglePlayServicesBanner.access$000(a) == activity)
        {
            b.b(b.c, "GooglePlayServicesBanner - onActivityPaused");
            if (GooglePlayServicesBanner.access$100(a) != null)
            {
                GooglePlayServicesBanner.access$100(a).b();
            }
        }
    }

    public void onActivityResumed(Activity activity)
    {
        if (GooglePlayServicesBanner.access$000(a) == activity)
        {
            b.b(b.c, "GooglePlayServicesBanner - onActivityResumed");
            if (GooglePlayServicesBanner.access$100(a) != null)
            {
                GooglePlayServicesBanner.access$100(a).c();
            }
        }
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

    (GooglePlayServicesBanner googleplayservicesbanner)
    {
        a = googleplayservicesbanner;
        super();
    }
}
