// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby.pricewatch;

import gs;
import org.json.JSONException;
import org.json.JSONObject;

public class PriceWatchRequest
{

    private static final String TAG = com/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchRequest.getSimpleName();
    private String itemId;
    private boolean watchForDrop;
    private double watchForPrice;

    public PriceWatchRequest(String s, boolean flag, double d)
    {
        itemId = s;
        watchForDrop = flag;
        watchForPrice = d;
    }

    public String getItemID()
    {
        return itemId;
    }

    public JSONObject getJSONData()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("item_id", itemId);
            jsonobject.put("watch_for_drop", watchForDrop);
            jsonobject.put("watch_for_price", watchForPrice);
        }
        catch (JSONException jsonexception)
        {
            gs.e(TAG, (new StringBuilder()).append("Could not build JSON object from PriceWatchRequest: ").append(jsonexception.getLocalizedMessage()).toString());
            return jsonobject;
        }
        return jsonobject;
    }

    public double getWatchForPrice()
    {
        return watchForPrice;
    }

    public boolean isWatchForDrop()
    {
        return watchForDrop;
    }

}
