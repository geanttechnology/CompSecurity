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
    private String availability;
    private String description;
    private String displayName;
    private String imageUrl;

    public static ArrayList loadFreeBonusContent(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject == null)
            {
                continue;
            }
              = new <init>();
            .displayName = jsonobject.optString("displayName");
            .description = jsonobject.optString("description");
            .availability = jsonobject.optString("availabilityMessage");
            jsonobject = jsonobject.optJSONObject("primaryImage");
            if (jsonobject != null)
            {
                .imageUrl = jsonobject.optString("url");
            }
            arraylist.add();
        }

        return arraylist;
    }

    public String getAvailability()
    {
        return availability;
    }

    public String getDescription()
    {
        return description;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public ()
    {
    }
}
