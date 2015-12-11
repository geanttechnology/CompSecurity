// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.b;

import android.content.Context;
import android.content.Intent;
import com.shazam.android.widget.c.d;
import com.shazam.i.b.ay.a.a;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public final class b
{

    private static final d a = com.shazam.i.b.ay.a.a.a();

    private static Intent a(Context context, Intent intent, boolean flag)
    {
        Intent intent1 = new Intent("android.intent.action.VIEW");
        intent1.setPackage(context.getPackageName());
        intent1.setData(com.shazam.android.k.f.a.a(com.shazam.android.k.f.a.l, new Object[0]));
        intent1.addFlags(0x10000000);
        intent1.putExtra("com.shazam.android.FirstTimeUser.ON_SUCCESS_INTENT", intent);
        intent1.putExtra("com.shazam.android.extras.FROM_LAUNCH", flag);
        return intent1;
    }

    public static void a(Context context)
    {
        a(context, null, "startup", true);
    }

    public static void a(Context context, Intent intent)
    {
        a(context, intent, "startup", false);
    }

    public static void a(Context context, Intent intent, String s)
    {
        a(context, intent, s, false);
    }

    private static void a(Context context, Intent intent, String s, boolean flag)
    {
        d d1 = a;
        intent = a(context, intent, flag);
        com.shazam.android.k.f.i.a a1 = new com.shazam.android.k.f.i.a();
        a1.a = com.shazam.model.analytics.AnalyticsInfo.Builder.a().a(DefinedEventParameterKey.ORIGIN, s).b();
        d1.a(context, intent, a1.a());
    }

    public static void a(Context context, String s, boolean flag)
    {
        a(context, null, s, flag);
    }

    public static Intent b(Context context, Intent intent)
    {
        return a(context, intent, false);
    }

    public static void b(Context context)
    {
        a(context, null, "startup", false);
    }

}
