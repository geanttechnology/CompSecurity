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
    private String displayName;
    private double percent0To1;
    private double percent0To100;
    private int rangeMax;
    private double score;

    public static ArrayList loadFeatureRatingData(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
              = new <init>();
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject != null)
            {
                .displayName = jsonobject.optString("displayName", "");
                .percent0To1 = jsonobject.optDouble("percent0To1");
                .percent0To100 = jsonobject.optDouble("percent0To100");
                .rangeMax = jsonobject.optInt("rangeMax");
                .score = jsonobject.optDouble("score");
                arraylist.add();
            }
        }

        return arraylist;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public double getPercent0To1()
    {
        return percent0To1;
    }

    public double getPercent0To100()
    {
        return percent0To100;
    }

    public int getRangeMax()
    {
        return rangeMax;
    }

    public double getScore()
    {
        return score;
    }

    public ()
    {
    }
}
