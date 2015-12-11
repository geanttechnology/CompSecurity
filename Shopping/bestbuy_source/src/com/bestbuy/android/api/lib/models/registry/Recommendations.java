// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Recommendations
    implements Serializable
{

    private static String TAG = com/bestbuy/android/api/lib/models/registry/Recommendations.getSimpleName();
    private static final long serialVersionUID = 1L;
    private ArrayList skuList;
    private int total;

    public Recommendations()
    {
        skuList = new ArrayList();
    }

    public static Recommendations parseRecommendationsData(JSONObject jsonobject)
    {
        Recommendations recommendations = new Recommendations();
        if (jsonobject != null)
        {
            recommendations.total = jsonobject.optInt("num_found");
            jsonobject = jsonobject.optJSONArray("documents");
            if (jsonobject != null && jsonobject.length() > 0)
            {
                for (int i = 0; i < jsonobject.length(); i++)
                {
                    JSONObject jsonobject1 = jsonobject.optJSONObject(i);
                    recommendations.skuList.add(jsonobject1.optString("skuid"));
                }

            }
        }
        return recommendations;
    }

    public ArrayList getSkuList()
    {
        return skuList;
    }

    public int getTotal()
    {
        return total;
    }

    public void setSkuList(ArrayList arraylist)
    {
        skuList = arraylist;
    }

    public void setTotal(int i)
    {
        total = i;
    }

}
