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
    private String definition;
    private String displayName;
    private String value;

    public static ArrayList loadProductSpecificationData(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
              = new <init>();
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject != null)
            {
                .definition = jsonobject.optString("definition", "");
                .displayName = jsonobject.optString("displayName", "");
                .value = jsonobject.optString("value", "");
            }
            arraylist.add();
        }

        return arraylist;
    }

    public String getDefinition()
    {
        return definition;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getValue()
    {
        return value;
    }

    public ()
    {
    }
}
