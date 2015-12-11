// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.deals;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class CustomOfferDeals
{

    private static final String TAG = com/bestbuy/android/api/lib/models/deals/CustomOfferDeals.getSimpleName();
    private String skuId;

    public CustomOfferDeals()
    {
    }

    public static ArrayList getCustomOfferSkuList(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray != null && jsonarray.length() > 0)
        {
            for (int i = 0; i < jsonarray.length(); i++)
            {
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                if (jsonobject != null)
                {
                    CustomOfferDeals customofferdeals = new CustomOfferDeals();
                    customofferdeals.skuId = jsonobject.optString("skuId");
                    arraylist.add(customofferdeals);
                }
            }

        }
        return arraylist;
    }

    public String getSkuId()
    {
        return skuId;
    }

}
