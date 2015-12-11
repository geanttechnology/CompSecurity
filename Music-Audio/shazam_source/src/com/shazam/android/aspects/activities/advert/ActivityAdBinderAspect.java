// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities.advert;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.shazam.android.advert.ShazamAdView;
import com.shazam.android.aspects.b.a.b;
import com.shazam.android.aspects.c.a.a;
import com.shazam.android.widget.tagging.n;
import com.shazam.android.widget.tagging.o;

public class ActivityAdBinderAspect extends b
{

    private ShazamAdView shazamAdView;

    public ActivityAdBinderAspect()
    {
    }

    public static boolean isAdVisible(Activity activity)
    {
        return activity.findViewById(0x7f110004) != null && activity.findViewById(0x7f110004).getVisibility() == 0;
    }

    public static void notifyFabOfAdVisibility(Activity activity, boolean flag)
    {
label0:
        {
            activity = n.a(activity);
            if (activity != null)
            {
                if (!flag)
                {
                    break label0;
                }
                activity.d();
            }
            return;
        }
        activity.e();
    }

    public void onDestroy(a a1)
    {
        shazamAdView.f();
    }

    public void onPause(a a1)
    {
        shazamAdView.d();
    }

    public void onPostCreate(a a1, Bundle bundle)
    {
        shazamAdView = (ShazamAdView)a1.findViewById(0x7f110004);
        if (shazamAdView != null)
        {
            if (a1 instanceof com.shazam.android.advert.h.a)
            {
                shazamAdView.setAdvertSiteIdKeyProvider((com.shazam.android.advert.h.a)a1);
            }
            if (a1 instanceof com.shazam.android.advert.n)
            {
                shazamAdView.setExtraTargetParamsProvider((com.shazam.android.advert.n)a1);
            }
            if ((com.shazam.android.advert.b.a)a1.getClass().getAnnotation(com/shazam/android/advert/b/a) == null)
            {
                throw new RuntimeException();
            }
        }
    }

    public void onResume(a a1)
    {
        shazamAdView.b();
    }

    public void onStart(a a1)
    {
        ShazamAdView.a();
    }

    public void onStop(a a1)
    {
        ShazamAdView.e();
    }
}
