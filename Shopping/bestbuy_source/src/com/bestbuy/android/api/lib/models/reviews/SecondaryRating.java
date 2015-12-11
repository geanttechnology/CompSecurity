// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.reviews;

import java.util.ArrayList;
import org.json.JSONObject;

public class SecondaryRating
{

    private String displayType;
    private String id;
    private String label;
    private String maxLabel;
    private String minLabel;
    private String ratingKey;
    private int value;
    private String valueLabel;
    private int valueRange;

    public SecondaryRating()
    {
    }

    public static ArrayList loadSecondaryRatingData(JSONObject jsonobject, ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        for (int i = 0; i < arraylist.size(); i++)
        {
            String s = (String)arraylist.get(i);
            JSONObject jsonobject1 = jsonobject.optJSONObject(s);
            if (jsonobject1 != null)
            {
                SecondaryRating secondaryrating = new SecondaryRating();
                secondaryrating.ratingKey = s;
                secondaryrating.value = jsonobject1.optInt("Value");
                secondaryrating.valueLabel = jsonobject1.optString("ValueLabel");
                secondaryrating.maxLabel = jsonobject1.optString("MaxLabel");
                secondaryrating.label = jsonobject1.optString("Label");
                secondaryrating.id = jsonobject1.optString("Id");
                secondaryrating.valueRange = jsonobject1.optInt("ValueRange");
                secondaryrating.minLabel = jsonobject1.optString("MinLabel");
                secondaryrating.displayType = jsonobject1.optString("DisplayType");
                arraylist1.add(secondaryrating);
            }
        }

        return arraylist1;
    }

    public String getDisplayType()
    {
        return displayType;
    }

    public String getId()
    {
        return id;
    }

    public String getLabel()
    {
        return label;
    }

    public String getMaxLabel()
    {
        return maxLabel;
    }

    public String getMinLabel()
    {
        return minLabel;
    }

    public String getRatingKey()
    {
        return ratingKey;
    }

    public int getValue()
    {
        return value;
    }

    public String getValueLabel()
    {
        return valueLabel;
    }

    public int getValueRange()
    {
        return valueRange;
    }
}
