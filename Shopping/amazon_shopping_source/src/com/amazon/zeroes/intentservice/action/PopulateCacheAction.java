// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.action;

import android.content.Intent;
import com.amazon.zeroes.intentservice.Metrics;
import com.amazon.zeroes.intentservice.ZeroesService;
import com.amazon.zeroes.intentservice.persistence.ZeroesCache;
import com.amazon.zeroes.intentservice.utils.ZeroesMeasurementUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.zeroes.intentservice.action:
//            ZeroesAction

public class PopulateCacheAction
    implements ZeroesAction
{

    public static final String ACTION_REQUEST;
    public static final String EXTRA_ITEMS;
    private final ZeroesCache cache;
    private final JSONObject items;

    public PopulateCacheAction(Intent intent, ZeroesCache zeroescache)
        throws JSONException
    {
        cache = zeroescache;
        items = new JSONObject(intent.getStringExtra(EXTRA_ITEMS));
    }

    public void act(ZeroesService zeroesservice)
    {
        if (cache == null)
        {
            throw new NullPointerException("The cache can't be null");
        }
        if (items.has("balance"))
        {
            try
            {
                long l = items.getLong("balance");
                cache.put("balance", Long.toString(l), 0x1b7740L);
            }
            // Misplaced declaration of an exception variable
            catch (ZeroesService zeroesservice)
            {
                Metrics.putMeasurement(ZeroesMeasurementUtils.fromThrowable(zeroesservice));
            }
        }
        if (items.has("bundles"))
        {
            try
            {
                zeroesservice = items.getJSONArray("bundles");
                cache.put("bundles", zeroesservice.toString(), 0x5265c00L);
            }
            // Misplaced declaration of an exception variable
            catch (ZeroesService zeroesservice)
            {
                Metrics.putMeasurement(ZeroesMeasurementUtils.fromThrowable(zeroesservice));
            }
        }
        if (!items.has("preferences"))
        {
            break MISSING_BLOCK_LABEL_140;
        }
        zeroesservice = items.getJSONObject("preferences");
        cache.put("preferences", zeroesservice.toString(), 0x5265c00L);
        return;
        zeroesservice;
        Metrics.putMeasurement(ZeroesMeasurementUtils.fromThrowable(zeroesservice));
        return;
    }

    static 
    {
        ACTION_REQUEST = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".PopulateCache").toString();
        EXTRA_ITEMS = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".items").toString();
    }
}
