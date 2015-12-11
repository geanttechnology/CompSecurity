// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.jg;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.login:
//            c, LoginClient, a

class e
{

    private final jg a;
    private String b;
    private String c;

    e(Context context, String s)
    {
        b = s;
        a = jg.c(context, s);
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

    public void a(LoginClient.Request request)
    {
        Bundle bundle = a(request.e());
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("login_behavior", request.b().toString());
        jsonobject.put("request_code", LoginClient.d());
        jsonobject.put("permissions", TextUtils.join(",", request.a()));
        jsonobject.put("default_audience", request.c().toString());
        jsonobject.put("isReauthorize", request.f());
        if (c != null)
        {
            jsonobject.put("facebookVersion", c);
        }
        if (jsonobject instanceof JSONObject) goto _L2; else goto _L1
_L1:
        request = jsonobject.toString();
_L3:
        bundle.putString("6_extras", request);
_L4:
        a.a("fb_mobile_login_start", null, bundle);
        return;
_L2:
        request = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
          goto _L3
        request;
          goto _L4
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

    public void a(String s, Map map, LoginClient.Result.a a1, Map map1, Exception exception)
    {
        Bundle bundle = a(s);
        if (a1 != null)
        {
            bundle.putString("2_result", a1.a());
        }
        if (exception != null && exception.getMessage() != null)
        {
            bundle.putString("5_error_message", exception.getMessage());
        }
        if (!map.isEmpty())
        {
            s = new JSONObject(map);
        } else
        {
            s = null;
        }
        map = s;
        if (map1 != null)
        {
            if (s == null)
            {
                s = new JSONObject();
            }
            try
            {
                for (map = map1.entrySet().iterator(); map.hasNext(); s.put((String)a1.getKey(), a1.getValue()))
                {
                    a1 = (java.util.Map.Entry)map.next();
                }

                break MISSING_BLOCK_LABEL_178;
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                map = s;
            }
        }
        if (map != null)
        {
            if (!(map instanceof JSONObject))
            {
                s = map.toString();
            } else
            {
                s = JSONObjectInstrumentation.toString((JSONObject)map);
            }
            bundle.putString("6_extras", s);
        }
        a.a("fb_mobile_login_complete", null, bundle);
        return;
        map = s;
        break MISSING_BLOCK_LABEL_141;
    }

    public void b(String s, String s1)
    {
        a(s, s1, "");
    }
}
