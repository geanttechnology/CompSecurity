// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import com.mopub.common.b.a;

public final class i
{
    public static final class a
    {

        public final String a;
        public final boolean b;

        public a(String s, boolean flag)
        {
            a = s;
            b = flag;
        }
    }


    private static String a = "com.google.android.gms.common.GooglePlayServicesUtil";
    private static String b = "com.google.android.gms.ads.identifier.AdvertisingIdClient";

    private static String a(Object obj)
    {
        try
        {
            obj = (String)com.mopub.common.b.a.a(obj, "getId").a();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        return ((String) (obj));
    }

    public static boolean a(Context context)
    {
        int j;
        try
        {
            context = ((Context) (com.mopub.common.b.a.a(null, "isGooglePlayServicesAvailable").a(Class.forName(a)).a(android/content/Context, context).a()));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        j = ((Integer)context).intValue();
        if (j == 0)
        {
            return true;
        }
        return false;
    }

    public static a b(Context context)
    {
        if (context == null)
        {
            return null;
        }
        try
        {
            context = ((Context) (com.mopub.common.b.a.a(null, "getAdvertisingIdInfo").a(Class.forName(b)).a(android/content/Context, context).a()));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.mopub.common.c.a.b("Unable to obtain Google AdvertisingIdClient.Info via reflection.");
            return null;
        }
        return new a(a(context), b(context));
    }

    private static boolean b(Object obj)
    {
        boolean flag;
        try
        {
            obj = (Boolean)com.mopub.common.b.a.a(obj, "isLimitAdTrackingEnabled").a();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        flag = ((Boolean) (obj)).booleanValue();
        return flag;
        return false;
    }

}
