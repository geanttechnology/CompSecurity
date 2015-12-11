// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.reviews;

import java.util.ArrayList;
import org.json.JSONObject;

public class AdditionalField
{

    private String fieldName;
    private String id;
    private String label;
    private String value;

    public AdditionalField()
    {
    }

    public static ArrayList loadAdditionalFieldData(JSONObject jsonobject, ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        for (int i = 0; i < arraylist.size(); i++)
        {
            String s = (String)arraylist.get(i);
            JSONObject jsonobject1 = jsonobject.optJSONObject(s);
            if (jsonobject1 != null)
            {
                AdditionalField additionalfield = new AdditionalField();
                additionalfield.fieldName = s;
                additionalfield.label = jsonobject1.optString("Label");
                additionalfield.id = jsonobject1.optString("Id");
                arraylist1.add(additionalfield);
            }
        }

        return arraylist1;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public String getId()
    {
        return id;
    }

    public String getLabel()
    {
        return label;
    }

    public String getValue()
    {
        return value;
    }
}
