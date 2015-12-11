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
    private String price;
    private String type;

    public static ArrayList loadContractOptionsData(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject != null)
            {
                  = new <init>();
                .price = jsonobject.optString("price");
                .type = jsonobject.optString("type");
                arraylist.add();
            }
        }

        return arraylist;
    }

    public String getPrice()
    {
        return price;
    }

    public String getType()
    {
        return type;
    }

    public ()
    {
    }
}
