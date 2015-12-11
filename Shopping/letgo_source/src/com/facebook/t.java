// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.kc;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            k, Profile

final class t
{

    private final SharedPreferences a = k.f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);

    t()
    {
    }

    Profile a()
    {
        Object obj;
        obj = a.getString("com.facebook.ProfileManager.CachedProfile", null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        obj = new Profile(JSONObjectInstrumentation.init(((String) (obj))));
        return ((Profile) (obj));
        JSONException jsonexception;
        jsonexception;
        return null;
    }

    void a(Profile profile)
    {
        kc.a(profile, "profile");
        profile = profile.c();
        if (profile != null)
        {
            android.content.SharedPreferences.Editor editor = a.edit();
            if (!(profile instanceof JSONObject))
            {
                profile = profile.toString();
            } else
            {
                profile = JSONObjectInstrumentation.toString((JSONObject)profile);
            }
            editor.putString("com.facebook.ProfileManager.CachedProfile", profile).apply();
        }
    }

    void b()
    {
        a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }
}
