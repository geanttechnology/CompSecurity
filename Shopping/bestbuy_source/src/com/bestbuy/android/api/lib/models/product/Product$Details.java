// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class value
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String link;
    private String name;
    private String value;

    public static ArrayList getDetailsList(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            value value1 = new <init>();
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject != null)
            {
                value1.name = jsonobject.optString("displayName");
                value1.value = jsonobject.optString("value");
                if (jsonobject.optJSONObject("link") != null)
                {
                    value1.link = jsonobject.optJSONObject("link").optString("url");
                }
            }
            arraylist.add(value1);
        }

        return arraylist;
    }

    public String getDisplayName()
    {
        return name;
    }

    public String getLink()
    {
        return link;
    }

    public String getValue()
    {
        return value;
    }

    public ()
    {
        link = "";
    }

    public link(String s, String s1)
    {
        link = "";
        name = s;
        value = s1;
    }
}
