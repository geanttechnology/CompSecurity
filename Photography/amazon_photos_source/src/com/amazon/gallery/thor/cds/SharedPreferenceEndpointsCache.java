// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.amazon.clouddrive.configuration.Endpoints;
import com.amazon.clouddrive.configuration.EndpointsCache;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import java.util.concurrent.TimeUnit;

public class SharedPreferenceEndpointsCache
    implements EndpointsCache
{

    private final long mCacheLifeSpanMS;
    private final Context mContext;
    private final SharedPreferences mSharedPreferences;

    public SharedPreferenceEndpointsCache(Context context, String s, long l, TimeUnit timeunit)
    {
        mContext = context;
        mSharedPreferences = context.getSharedPreferences((new StringBuilder()).append("endpoints_cache_").append(s).toString(), 0);
        mCacheLifeSpanMS = timeunit.toMillis(l);
    }

    private boolean areEndpointsValid(String s, String s1, String s2)
    {
        return s != null && s.equals(mSharedPreferences.getString("cachedAccount", "")) && s1 != null && s2 != null;
    }

    public boolean cacheHasExpired()
    {
        return SystemClock.elapsedRealtime() >= mSharedPreferences.getLong("cacheTimestamp", 0L);
    }

    public Endpoints getEndpoints()
    {
        Endpoints endpoints = null;
        String s = (new MAPAccountManager(mContext)).getAccount();
        String s1 = mSharedPreferences.getString("cachedMetaDataEndpoint", null);
        String s2 = mSharedPreferences.getString("cachedContentEndpoint", null);
        if (areEndpointsValid(s, s1, s2))
        {
            endpoints = new Endpoints(s1, s2);
        }
        return endpoints;
    }

    public void setEndpoints(Endpoints endpoints)
    {
        MAPAccountManager mapaccountmanager = new MAPAccountManager(mContext);
        mSharedPreferences.edit().putString("cachedAccount", mapaccountmanager.getAccount()).putLong("cacheTimestamp", SystemClock.elapsedRealtime() + mCacheLifeSpanMS).putString("cachedMetaDataEndpoint", endpoints.getMetaDataEndpoint()).putString("cachedContentEndpoint", endpoints.getContentEndpoint()).apply();
    }
}
