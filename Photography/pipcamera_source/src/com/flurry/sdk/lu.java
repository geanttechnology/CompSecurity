// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;

// Referenced classes of package com.flurry.sdk:
//            lw, kg, jp

public class lu
{

    private static final String a = com/flurry/sdk/lu.getSimpleName();
    private static String b = "com.google.android.gms.common.GooglePlayServicesUtil";
    private static String c = "com.google.android.gms.ads.identifier.AdvertisingIdClient";

    public lu()
    {
    }

    static String a(Object obj, String s)
    {
        try
        {
            obj = (String)lw.a(obj, "getId").a();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            kg.b(a, (new StringBuilder()).append("GOOGLE PLAY SERVICES ERROR: ").append(((Exception) (obj)).getMessage()).toString());
            kg.b(a, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return s;
        }
        return ((String) (obj));
    }

    public static boolean a(Context context)
    {
        int i;
        try
        {
            context = ((Context) (lw.a(null, "isGooglePlayServicesAvailable").a(Class.forName(b)).a(android/content/Context, context).a()));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            kg.b(a, (new StringBuilder()).append("GOOGLE PLAY SERVICES EXCEPTION: ").append(context.getMessage()).toString());
            kg.b(a, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return false;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        i = ((Integer)context).intValue();
        if (i == 0)
        {
            return true;
        }
        return false;
    }

    static boolean a(Object obj, boolean flag)
    {
        boolean flag1;
        try
        {
            obj = (Boolean)lw.a(obj, "isLimitAdTrackingEnabled").a();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            kg.b(a, (new StringBuilder()).append("GOOGLE PLAY SERVICES ERROR: ").append(((Exception) (obj)).getMessage()).toString());
            kg.b(a, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return flag;
        }
        flag1 = flag;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        flag1 = ((Boolean) (obj)).booleanValue();
        return flag1;
    }

    public static jp b(Context context)
    {
        if (context == null)
        {
            return null;
        }
        try
        {
            context = ((Context) (lw.a(null, "getAdvertisingIdInfo").a(Class.forName(c)).a(android/content/Context, context).a()));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            kg.b(a, (new StringBuilder()).append("GOOGLE PLAY SERVICES ERROR: ").append(context.getMessage()).toString());
            kg.b(a, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return null;
        }
        return new jp(a(context, ((String) (null))), a(context, false));
    }

}
