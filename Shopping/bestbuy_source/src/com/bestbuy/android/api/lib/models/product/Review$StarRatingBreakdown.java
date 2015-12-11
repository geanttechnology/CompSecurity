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
    private int count;
    private double percent0To100;
    private int score;

    public static ArrayList loadStarRatingBreakdownData(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
              = new <init>();
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject != null)
            {
                .count = jsonobject.optInt("count");
                .percent0To100 = jsonobject.optDouble("percent0To100");
                .score = jsonobject.optInt("score");
                arraylist.add();
            }
        }

        return arraylist;
    }

    public int getCount()
    {
        return count;
    }

    public double getPercent0To100()
    {
        return percent0To100;
    }

    public int getScore()
    {
        return score;
    }

    public ()
    {
    }
}
