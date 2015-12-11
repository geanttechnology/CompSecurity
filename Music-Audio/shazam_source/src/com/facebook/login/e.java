// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.a.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{

    public final a a;
    String b;
    public String c;

    e(Context context, String s)
    {
        b = s;
        a = com.facebook.a.a.a(context, s);
        try
        {
            context = context.getPackageManager();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        context = context.getPackageInfo("com.facebook.katana", 0);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        c = ((PackageInfo) (context)).versionName;
    }

    public static Bundle a(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", s);
        bundle.putString("3_method", "");
        bundle.putString("2_result", "");
        bundle.putString("5_error_message", "");
        bundle.putString("4_error_code", "");
        bundle.putString("6_extras", "");
        return bundle;
    }

    public final void a(String s, String s1, String s2)
    {
        Bundle bundle = a("");
        bundle.putString("2_result", LoginClient.Result.a.c.d);
        bundle.putString("5_error_message", s1);
        bundle.putString("3_method", s2);
        a.b(s, bundle);
    }

    public final void a(String s, Map map, LoginClient.Result.a a1, Map map1, Exception exception)
    {
        Bundle bundle;
        bundle = a(s);
        if (a1 != null)
        {
            bundle.putString("2_result", a1.d);
        }
        if (exception != null && exception.getMessage() != null)
        {
            bundle.putString("5_error_message", exception.getMessage());
        }
        s = null;
        if (!map.isEmpty())
        {
            s = new JSONObject(map);
        }
        map = s;
        if (map1 == null) goto _L2; else goto _L1
_L1:
        if (s == null)
        {
            s = new JSONObject();
        }
        for (map = map1.entrySet().iterator(); map.hasNext(); s.put((String)a1.getKey(), a1.getValue()))
        {
            a1 = (java.util.Map.Entry)map.next();
        }

          goto _L3
        map;
        map = s;
_L2:
        if (map != null)
        {
            bundle.putString("6_extras", map.toString());
        }
        a.b("fb_mobile_login_complete", bundle);
        return;
_L3:
        map = s;
        if (true) goto _L2; else goto _L4
_L4:
    }
}
