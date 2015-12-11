// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby.pricewatch;

import org.json.JSONObject;

public class PriceWatchResponse
{

    private String listId;
    private String status;

    public PriceWatchResponse()
    {
        status = "";
        listId = "";
    }

    public static PriceWatchResponse loadData(JSONObject jsonobject)
    {
        PriceWatchResponse pricewatchresponse = new PriceWatchResponse();
        pricewatchresponse.status = jsonobject.optString("status");
        pricewatchresponse.listId = jsonobject.optString("list_id");
        return pricewatchresponse;
    }

    public String getListId()
    {
        return listId;
    }

    public String getStatus()
    {
        return status;
    }
}
