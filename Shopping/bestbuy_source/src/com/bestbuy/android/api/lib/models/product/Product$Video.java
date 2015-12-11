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
    private String encoding;
    private int height;
    private String url;
    private int width;

    public static ArrayList loadVideoDetails(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            Object obj = jsonarray.optJSONObject(i);
              = new <init>();
            .height = ((JSONObject) (obj)).optInt("height");
            .width = ((JSONObject) (obj)).optInt("width");
            obj = ((JSONObject) (obj)).optJSONArray("formats");
            if (obj == null)
            {
                continue;
            }
            obj = ((JSONArray) (obj)).optJSONObject(0);
            if (obj != null)
            {
                .encoding = ((JSONObject) (obj)).optString("encoding");
                .url = ((JSONObject) (obj)).optString("url");
                arraylist.add();
            }
        }

        return arraylist;
    }

    public String getEncoding()
    {
        return encoding;
    }

    public int getHeight()
    {
        return height;
    }

    public String getUrl()
    {
        return url;
    }

    public int getWidth()
    {
        return width;
    }

    public ()
    {
    }
}
