// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class 
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String color;
    private String format;
    private String price;
    private String productId;
    private String sku;
    private String state;
    private String url;

    public static ArrayList loadAlternateSKUData(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        while (i < jsonarray.length()) 
        {
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject != null)
            {
                  = new <init>();
                .sku = jsonobject.optString("sku");
                if (.sku == null || .sku.isEmpty())
                {
                    .sku = jsonobject.optString("skuId");
                }
                .color = jsonobject.optString("displayName");
                .state = jsonobject.optString("state");
                .productId = jsonobject.optString("productId");
                .format = jsonobject.optString("format");
                if (.format != null && !.format.isEmpty())
                {
                    .format = (new StringBuilder()).append(.format.substring(0, 1).toUpperCase()).append(.format.substring(1).toLowerCase()).toString();
                } else
                {
                    .price = jsonobject.optString("price");
                    .format = jsonobject.optString("type");
                }
                arraylist.add();
            }
            i++;
        }
        return arraylist;
    }

    public String getColor()
    {
        return color;
    }

    public String getFormat()
    {
        return format;
    }

    public String getPrice()
    {
        return price;
    }

    public String getProductId()
    {
        return productId;
    }

    public String getSku()
    {
        return sku;
    }

    public String getState()
    {
        return state;
    }

    public String getUrl()
    {
        return url;
    }

    public void setColor(String s)
    {
        color = s;
    }

    public void setFormat(String s)
    {
        format = s;
    }

    public void setProductId(String s)
    {
        productId = s;
    }

    public void setSku(String s)
    {
        sku = s;
    }

    public void setState(String s)
    {
        state = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public ()
    {
    }
}
