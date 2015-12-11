// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.solr;

import org.json.JSONObject;

public class SuggestQuery
{

    private String correctedQuery;
    private boolean correctlySpelled;
    private String didYouMean;
    private String showingResultsFor;

    public SuggestQuery()
    {
    }

    public static SuggestQuery loadData(JSONObject jsonobject)
    {
        SuggestQuery suggestquery = new SuggestQuery();
        suggestquery.didYouMean = jsonobject.optString("didYouMean");
        suggestquery.showingResultsFor = jsonobject.optString("showingResultsFor");
        suggestquery.correctedQuery = jsonobject.optString("correctedQuery");
        suggestquery.correctlySpelled = jsonobject.optBoolean("correctlySpelled");
        return suggestquery;
    }

    public String getCorrectedQuery()
    {
        return correctedQuery;
    }

    public String getDidYouMean()
    {
        return didYouMean;
    }

    public String getShowingResultsFor()
    {
        return showingResultsFor;
    }

    public boolean isCorrectlySpelled()
    {
        return correctlySpelled;
    }
}
