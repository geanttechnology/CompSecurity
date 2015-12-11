// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.app.Activity;
import android.content.Context;
import com.appsflyer.AppsFlyerLib;
import com.b.a.a.g;
import com.b.a.a.j;

public class c
{

    public c()
    {
    }

    public static void a(Activity activity)
    {
        activity = activity.getApplicationContext();
        long l = j.a().n();
        try
        {
            AppsFlyerLib.setAppsFlyerKey("goqwEy7LviekrDyemNqcKT");
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            g.a(com/offerup/android/utils/c.getSimpleName(), activity);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            g.c(com/offerup/android/utils/c.getSimpleName(), activity.toString());
            return;
        }
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        AppsFlyerLib.setAppUserId(Long.toString(l));
        AppsFlyerLib.sendTracking(activity);
        a(((Context) (activity)), "ou_open");
        return;
    }

    public static void a(Context context, String s)
    {
        try
        {
            AppsFlyerLib.sendTrackingWithEvent(context, s, "");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(com/offerup/android/utils/c.getSimpleName(), "Exception logging AppsFlyer data", context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.c(com/offerup/android/utils/c.getSimpleName(), context.toString());
        }
    }

    public static void a(Context context, String s, String s1)
    {
        try
        {
            AppsFlyerLib.sendTrackingWithEvent(context, s, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(com/offerup/android/utils/c.getSimpleName(), "Exception logging AppsFlyer data", context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.c(com/offerup/android/utils/c.getSimpleName(), context.toString());
        }
    }
}
