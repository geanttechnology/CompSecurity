// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.search;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class SuggestedSearch
    implements Serializable
{

    private static String TAG = com/bestbuy/android/api/lib/models/search/SuggestedSearch.getSimpleName();
    private static final long serialVersionUID = 1L;

    public SuggestedSearch()
    {
    }

    public static ArrayList getSuggestionsList(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray != null)
        {
            for (int i = 0; i < jsonarray.length(); i++)
            {
                arraylist.add(jsonarray.optJSONObject(i).optString("term"));
            }

        }
        return arraylist;
    }

}
