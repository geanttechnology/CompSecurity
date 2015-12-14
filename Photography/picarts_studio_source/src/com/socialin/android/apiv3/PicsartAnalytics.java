// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.github.kevinsawicki.http.a;
import com.socialin.asyncnet.Request;
import java.util.HashMap;

// Referenced classes of package com.socialin.android.apiv3:
//            SocialinV3

public class PicsartAnalytics
{

    public static final String EVENT_PREFIX = "i:";
    private static final String LOG_TAG = "picsart_analytics";
    private static String deviceId = "";
    public static String serverUrl = "https://analytics.picsart.com/";
    private static String versionCode = "";

    public PicsartAnalytics()
    {
    }

    private static String _encode(String s)
    {
        String s1;
        try
        {
            s1 = a.a(s.trim());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return s;
        }
        return s1;
    }

    public static void logEvent(String s)
    {
        logEvent(s, null);
    }

    public static void logEvent(String s, HashMap hashmap)
    {
    }

    public static void logPurchaseEvent(String s, String s1, String s2, String s3)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("shop_item_uid", s);
        hashmap.put("description", s2);
        hashmap.put("price", s3);
        hashmap.put("name", s1);
        logEvent("i:shopPurchase", hashmap);
    }

    private static void prepare(Request request)
    {
        request.d("Accept", "application/json");
        request.c("Content-Type", "application/json");
        request.c("platform", "android");
        request.c("versionCode", versionCode);
        request.c("deviceid", deviceId);
    }

    static 
    {
        try
        {
            deviceId = SocialinV3.getInstance().getDeviceId();
            versionCode = String.valueOf(SocialinV3.getInstance().getContext().getPackageManager().getPackageInfo(SocialinV3.getInstance().getContext().getPackageName(), 128).versionCode);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
        }
    }
}
