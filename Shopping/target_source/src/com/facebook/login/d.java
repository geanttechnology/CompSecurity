// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.a.a;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Map;
import org.json.JSONObject;

class d
{

    private final a a;
    private String b;
    private String c;

    d(Context context, String s)
    {
        b = s;
        a = com.facebook.a.a.c(context, s);
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

    static Bundle a(String s)
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

    public String a()
    {
        return b;
    }

    public void a(String s, String s1)
    {
        s = a(s);
        s.putString("3_method", s1);
        a.a("fb_mobile_login_method_start", null, s);
    }

    public void a(String s, String s1, String s2)
    {
        Bundle bundle = a("");
        bundle.putString("2_result", LoginClient.Result.a.c.a());
        bundle.putString("5_error_message", s1);
        bundle.putString("3_method", s2);
        a.a(s, null, bundle);
    }

    public void a(String s, String s1, String s2, String s3, String s4, Map map)
    {
        Bundle bundle = a(s);
        if (s2 != null)
        {
            bundle.putString("2_result", s2);
        }
        if (s3 != null)
        {
            bundle.putString("5_error_message", s3);
        }
        if (s4 != null)
        {
            bundle.putString("4_error_code", s4);
        }
        if (map != null && !map.isEmpty())
        {
            s = new JSONObject(map);
            if (!(s instanceof JSONObject))
            {
                s = s.toString();
            } else
            {
                s = JSONObjectInstrumentation.toString((JSONObject)s);
            }
            bundle.putString("6_extras", s);
        }
        bundle.putString("3_method", s1);
        a.a("fb_mobile_login_method_complete", null, bundle);
    }
}
