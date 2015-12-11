// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.appnexus.opensdk.b.b;
import com.google.android.gms.ads.a.d;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            GooglePlayDFPBanner

class a
    implements android.app.fecycleCallbacks
{

    final GooglePlayDFPBanner a;

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public void onActivityDestroyed(Activity activity)
    {
        if (GooglePlayDFPBanner.access$000(a) == activity)
        {
            b.b(b.c, "GooglePlayDFPBanner - onActivityDestroyed");
            if (GooglePlayDFPBanner.access$100(a) != null)
            {
                GooglePlayDFPBanner.access$100(a).a();
            }
        }
        activity.getApplication().unregisterActivityLifecycleCallbacks(this);
    }

    public void onActivityPaused(Activity activity)
    {
        if (GooglePlayDFPBanner.access$000(a) == activity)
        {
            b.b(b.c, "GooglePlayDFPBanner - onActivityPaused");
            if (GooglePlayDFPBanner.access$100(a) != null)
            {
                GooglePlayDFPBanner.access$100(a).b();
            }
        }
    }

    public void onActivityResumed(Activity activity)
    {
        if (GooglePlayDFPBanner.access$000(a) == activity)
        {
            b.b(b.c, "GooglePlayDFPBanner - onActivityResumed");
            if (GooglePlayDFPBanner.access$100(a) != null)
            {
                GooglePlayDFPBanner.access$100(a).c();
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

    (GooglePlayDFPBanner googleplaydfpbanner)
    {
        a = googleplaydfpbanner;
        super();
    }
}
