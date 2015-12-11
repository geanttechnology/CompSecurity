// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.google.android.gms.common:
//            GooglePlayServicesUtil

public final class b
{

    public static final int a;
    private static final b b = new b();

    b()
    {
    }

    public static int a(Context context)
    {
        int j = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        int i = j;
        if (GooglePlayServicesUtil.zzd(context, j))
        {
            i = 18;
        }
        return i;
    }

    public static Intent a(int i)
    {
        return GooglePlayServicesUtil.zzbc(i);
    }

    public static b a()
    {
        return b;
    }

    public static boolean a(Context context, int i)
    {
        return GooglePlayServicesUtil.zzd(context, i);
    }

    public static void b(Context context)
    {
        GooglePlayServicesUtil.zzac(context);
    }

    static 
    {
        a = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }
}
