// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            bv, q, AppLovinSdkImpl, bw, 
//            bz, r, u, s, 
//            t, m, ax, cb, 
//            ce, cx

class cd extends bv
{

    cd(AppLovinSdkImpl applovinsdkimpl)
    {
        super("SubmitData", applovinsdkimpl);
    }

    void a(JSONObject jsonobject)
    {
        try
        {
            Object obj = q.a(jsonobject);
            jsonobject = f.getSettingsManager();
            jsonobject.a(bw.c, ((JSONObject) (obj)).getString("device_id"));
            jsonobject.a(bw.e, ((JSONObject) (obj)).getString("device_token"));
            jsonobject.a(bw.d, ((JSONObject) (obj)).getString("publisher_id"));
            jsonobject.b();
            q.a(((JSONObject) (obj)), f);
            if (((JSONObject) (obj)).has("adserver_parameters"))
            {
                obj = ((JSONObject) (obj)).getJSONObject("adserver_parameters").toString();
                jsonobject.a(bw.y, obj);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            g.e(e, "Unable to parse API response", jsonobject);
        }
    }

    void b(JSONObject jsonobject)
    {
        Object obj2 = f.getDataCollector();
        Object obj = ((r) (obj2)).b();
        Object obj1 = ((r) (obj2)).a();
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("model", ((u) (obj1)).a);
        jsonobject1.put("os", ((u) (obj1)).b);
        jsonobject1.put("brand", ((u) (obj1)).c);
        jsonobject1.put("sdk_version", ((u) (obj1)).e);
        jsonobject1.put("revision", ((u) (obj1)).d);
        jsonobject1.put("country_code", ((u) (obj1)).f);
        jsonobject1.put("carrier", ((u) (obj1)).g);
        jsonobject1.put("type", "android");
        obj2 = ((r) (obj2)).c();
        String s1 = ((s) (obj2)).b;
        boolean flag = ((s) (obj2)).a;
        if ((!flag || ((Boolean)f.getSettingsManager().a(bw.be)).booleanValue()) && AppLovinSdkUtils.isValidString(s1))
        {
            jsonobject1.put("idfa", s1);
        }
        jsonobject1.put("dnt", flag);
        obj1 = ((u) (obj1)).h;
        if (obj1 != null)
        {
            jsonobject1.put("locale", ((Locale) (obj1)).toString());
        }
        jsonobject.put("device_info", jsonobject1);
        jsonobject1 = new JSONObject();
        jsonobject1.put("package_name", ((t) (obj)).c);
        jsonobject1.put("app_name", ((t) (obj)).a);
        jsonobject1.put("app_version", ((t) (obj)).b);
        jsonobject1.put("installed_at", ((t) (obj)).d);
        jsonobject1.put("applovin_sdk_version", "6.1.4");
        obj = PreferenceManager.getDefaultSharedPreferences(h);
        obj1 = ((SharedPreferences) (obj)).getString("com.applovin.sdk.impl.isFirstRun", null);
        if (AppLovinSdkUtils.isValidString(((String) (obj1))))
        {
            jsonobject1.put("first_install", obj1);
            if (((String) (obj1)).equalsIgnoreCase(Boolean.toString(true)))
            {
                ((SharedPreferences) (obj)).edit().putString("com.applovin.sdk.impl.isFirstRun", Boolean.toString(false)).apply();
            }
        }
        obj = (String)f.a(bw.F);
        if (obj != null && ((String) (obj)).length() > 0)
        {
            jsonobject1.put("plugin_version", obj);
        }
        jsonobject.put("app_info", jsonobject1);
        if (((Boolean)f.a(bw.N)).booleanValue())
        {
            Map map = ((m)f.getTargetingData()).a();
            if (map != null && !map.isEmpty())
            {
                jsonobject.put("targeting", ax.a(map));
            }
            jsonobject.put("stats", f.b().b());
        }
    }

    void c(JSONObject jsonobject)
    {
        jsonobject = new ce(this, (new StringBuilder()).append("Repeat").append(e).toString(), bw.g, f, jsonobject);
        jsonobject.a(bw.k);
        jsonobject.run();
    }

    public void run()
    {
        try
        {
            g.i(e, "Submitting user data...");
            JSONObject jsonobject = new JSONObject();
            b(jsonobject);
            c(jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            g.e(e, "Unable to build JSON message with collected data", jsonexception);
        }
    }
}
