// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProductOffer
{

    private String name;
    private String target;
    private String url;

    public ProductOffer()
    {
    }

    public static ArrayList getProductOffers(JSONObject jsonobject)
    {
        ArrayList arraylist = new ArrayList();
        Object obj = jsonobject.optJSONArray("specialOffers");
        if (obj == null)
        {
            jsonobject = jsonobject.optJSONArray("financingOffers");
        } else
        {
            jsonobject = ((JSONObject) (obj));
        }
        if (jsonobject != null)
        {
            for (int i = 0; i < jsonobject.length(); i++)
            {
                obj = jsonobject.optJSONObject(i);
                ProductOffer productoffer = new ProductOffer();
                productoffer.name = ((JSONObject) (obj)).optString("name");
                productoffer.target = ((JSONObject) (obj)).optString("target");
                productoffer.url = ((JSONObject) (obj)).optString("url");
                arraylist.add(productoffer);
            }

        }
        return arraylist;
    }

    public String getName()
    {
        return name;
    }

    public String getTarget()
    {
        return target;
    }

    public String getUrl()
    {
        return url;
    }
}
