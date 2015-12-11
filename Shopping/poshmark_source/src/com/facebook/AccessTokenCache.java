// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.internal.Validate;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            FacebookSdk, AccessToken, LegacyTokenHelper

class AccessTokenCache
{
    static class SharedPreferencesTokenCachingStrategyFactory
    {

        public LegacyTokenHelper create()
        {
            return new LegacyTokenHelper(FacebookSdk.getApplicationContext());
        }

        SharedPreferencesTokenCachingStrategyFactory()
        {
        }
    }


    static final String CACHED_ACCESS_TOKEN_KEY = "com.facebook.AccessTokenManager.CachedAccessToken";
    private final SharedPreferences sharedPreferences;
    private LegacyTokenHelper tokenCachingStrategy;
    private final SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory;

    public AccessTokenCache()
    {
        this(FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new SharedPreferencesTokenCachingStrategyFactory());
    }

    AccessTokenCache(SharedPreferences sharedpreferences, SharedPreferencesTokenCachingStrategyFactory sharedpreferencestokencachingstrategyfactory)
    {
        sharedPreferences = sharedpreferences;
        tokenCachingStrategyFactory = sharedpreferencestokencachingstrategyfactory;
    }

    private AccessToken getCachedAccessToken()
    {
        AccessToken accesstoken = null;
        String s = sharedPreferences.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
        if (s != null)
        {
            try
            {
                accesstoken = AccessToken.createFromJSONObject(JSONObjectInstrumentation.init(s));
            }
            catch (JSONException jsonexception)
            {
                return null;
            }
        }
        return accesstoken;
    }

    private AccessToken getLegacyAccessToken()
    {
        Object obj = null;
        android.os.Bundle bundle = getTokenCachingStrategy().load();
        AccessToken accesstoken = obj;
        if (bundle != null)
        {
            accesstoken = obj;
            if (LegacyTokenHelper.hasTokenInformation(bundle))
            {
                accesstoken = AccessToken.createFromLegacyCache(bundle);
            }
        }
        return accesstoken;
    }

    private LegacyTokenHelper getTokenCachingStrategy()
    {
        if (tokenCachingStrategy != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (tokenCachingStrategy == null)
        {
            tokenCachingStrategy = tokenCachingStrategyFactory.create();
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return tokenCachingStrategy;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean hasCachedAccessToken()
    {
        return sharedPreferences.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    private boolean shouldCheckLegacyToken()
    {
        return FacebookSdk.isLegacyTokenUpgradeSupported();
    }

    public void clear()
    {
        sharedPreferences.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (shouldCheckLegacyToken())
        {
            getTokenCachingStrategy().clear();
        }
    }

    public AccessToken load()
    {
        AccessToken accesstoken = null;
        if (hasCachedAccessToken())
        {
            accesstoken = getCachedAccessToken();
        } else
        if (shouldCheckLegacyToken())
        {
            AccessToken accesstoken1 = getLegacyAccessToken();
            accesstoken = accesstoken1;
            if (accesstoken1 != null)
            {
                save(accesstoken1);
                getTokenCachingStrategy().clear();
                return accesstoken1;
            }
        }
        return accesstoken;
    }

    public void save(AccessToken accesstoken)
    {
        Validate.notNull(accesstoken, "accessToken");
        android.content.SharedPreferences.Editor editor;
        accesstoken = accesstoken.toJSONObject();
        editor = sharedPreferences.edit();
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
}
