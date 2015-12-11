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
    private String categoryId;
    private String displayName;

    public static ArrayList loadBreadCrumbDetails(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray != null)
        {
            for (int i = 0; i < jsonarray.length(); i++)
            {
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                  = new <init>();
                if (jsonobject != null)
                {
                    .categoryId = jsonobject.optString("categoryId");
                    .displayName = jsonobject.optString("displayName");
                }
                arraylist.add();
            }

        }
        return arraylist;
    }

    public String getCategoryId()
    {
        return categoryId;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setCategoryId(String s)
    {
        categoryId = s;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public ()
    {
    }
}
