// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.search;

import gu;
import java.io.Serializable;

public class SuggestQueryInfo
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String correctedQuery;
    private boolean correctlySpelled;
    private String didYouMean;
    private String showingResultsFor;

    public SuggestQueryInfo()
    {
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

    public void setCorrectedQuery(String s)
    {
        correctedQuery = s;
    }

    public void setCorrectlySpelled(boolean flag)
    {
        correctlySpelled = flag;
    }

    public void setDidYouMean(String s)
    {
        didYouMean = s;
    }

    public void setShowingResultsFor(String s)
    {
        showingResultsFor = s;
    }
}
