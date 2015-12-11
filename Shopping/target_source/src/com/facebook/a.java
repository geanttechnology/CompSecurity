// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.internal.p;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            i, AccessToken, p

class com.facebook.a
{
    static class a
    {

        public com.facebook.p a()
        {
            return new com.facebook.p(i.f());
        }

        a()
        {
        }
    }


    private final SharedPreferences a;
    private final a b;
    private com.facebook.p c;

    public com.facebook.a()
    {
        this(i.f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new a());
    }

    com.facebook.a(SharedPreferences sharedpreferences, a a1)
    {
        a = sharedpreferences;
        b = a1;
    }

    private boolean c()
    {
        return a.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    private AccessToken d()
    {
        AccessToken accesstoken = null;
        String s = a.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
        if (s != null)
        {
            try
            {
                accesstoken = AccessToken.a(JSONObjectInstrumentation.init(s));
            }
            catch (JSONException jsonexception)
            {
                return null;
            }
        }
        return accesstoken;
    }

    private boolean e()
    {
        return i.c();
    }

    private AccessToken f()
    {
        Object obj = null;
        android.os.Bundle bundle = g().a();
        AccessToken accesstoken = obj;
        if (bundle != null)
        {
            accesstoken = obj;
            if (p.a(bundle))
            {
                accesstoken = AccessToken.a(bundle);
            }
        }
        return accesstoken;
    }

    private com.facebook.p g()
    {
        if (c != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (c == null)
        {
            c = b.a();
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return c;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public AccessToken a()
    {
        AccessToken accesstoken = null;
        if (c())
        {
            accesstoken = d();
        } else
        if (e())
        {
            AccessToken accesstoken1 = f();
            accesstoken = accesstoken1;
            if (accesstoken1 != null)
            {
                a(accesstoken1);
                g().b();
                return accesstoken1;
            }
        }
        return accesstoken;
    }

    public void a(AccessToken accesstoken)
    {
        p.a(accesstoken, "accessToken");
        android.content.SharedPreferences.Editor editor;
        accesstoken = accesstoken.j();
        editor = a.edit();
        if (accesstoken instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        accesstoken = accesstoken.toString();
_L1:
        editor.putString("com.facebook.AccessTokenManager.CachedAccessToken", accesstoken).apply();
        return;
        try
        {
            accesstoken = JSONObjectInstrumentation.toString((JSONObject)accesstoken);
        }
        // Misplaced declaration of an exception variable
        catch (AccessToken accesstoken)
        {
            return;
        }
          goto _L1
    }

    public void b()
    {
        a.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (e())
        {
            g().b();
        }
    }
}
