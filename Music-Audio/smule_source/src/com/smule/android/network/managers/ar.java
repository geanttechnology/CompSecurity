// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.smule.android.c.aa;
import com.smule.android.f.p;
import com.smule.android.network.core.b;
import com.smule.android.network.core.r;

// Referenced classes of package com.smule.android.network.managers:
//            ap, as

public class ar
{

    public static final String a = com/smule/android/network/managers/ar.getName();
    private static ar b;

    public ar()
    {
        b();
    }

    static int a(String s)
    {
        return b(s);
    }

    public static ar a()
    {
        if (b == null)
        {
            b = new ar();
        }
        return b;
    }

    public static void a(Boolean boolean1, Context context)
    {
        context = context.getSharedPreferences("SUBSCRIPTION_PREFERENCES", 0).edit();
        context.putBoolean("DO_PURCHASE_RESTORE", boolean1.booleanValue());
        p.a(context);
    }

    private static int b(String s)
    {
        return com.smule.android.network.core.b.d().e().getResources().getIdentifier(s, "string", com.smule.android.network.core.b.d().e().getPackageName());
    }

    private void b()
    {
        if (b("subscription_purchase_error") <= 0)
        {
            throw new IllegalStateException("No purchase error resource available.");
        } else
        {
            return;
        }
    }

    public Boolean a(Context context)
    {
        return Boolean.valueOf(context.getSharedPreferences("SUBSCRIPTION_PREFERENCES", 0).getBoolean("DO_PURCHASE_RESTORE", true));
    }

    public void a(Activity activity, boolean flag)
    {
        Context context = activity.getApplicationContext();
        if (a(context).booleanValue() && r.a(context) && !ap.a().b())
        {
            aa.a(a, "restorePurchases - attempting purchase restore");
            (new as(activity)).a();
        }
    }

    public void b(Activity activity, boolean flag)
    {
        aa.a(a, "restorePurchases - attempting purchase restore");
        (new as(activity)).a();
    }

}
