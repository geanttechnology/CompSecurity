// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpreviews;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

public class DistilledReviewSummary
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private double averageRating;
    private ArrayList bestFeatures;
    private double overallScore;
    private double percentPositive;
    private ArrayList representativeQuotes;
    private boolean topRated;
    private int totalOpinions;
    private double totalRatings;
    private ArrayList worstFeatures;

    public DistilledReviewSummary()
    {
    }

    public double getAverageRating()
    {
        return averageRating;
    }

    public ArrayList getBestFeatures()
    {
        return bestFeatures;
    }

    public double getOverallScore()
    {
        return overallScore;
    }

    public double getPercentPositive()
    {
        return percentPositive;
    }

    public ArrayList getRepresentativeQuotes()
    {
        return representativeQuotes;
    }

    public int getTotalOpinions()
    {
        return totalOpinions;
    }

    public double getTotalRatings()
    {
        return totalRatings;
    }

    public ArrayList getWorstFeatures()
    {
        return worstFeatures;
    }

    public boolean isTopRated()
    {
        return topRated;
    }

    public void setAverageRating(double d)
    {
        averageRating = d;
    }

    public void setBestFeatures(ArrayList arraylist)
    {
        bestFeatures = arraylist;
    }

    public void setOverallScore(double d)
    {
        overallScore = d;
    }

    public void setPercentPositive(double d)
    {
        percentPositive = d;
    }

    public void setRepresentativeQuotes(ArrayList arraylist)
    {
        representativeQuotes = arraylist;
    }

    public void setTopRated(boolean flag)
    {
        topRated = flag;
    }

    public void setTotalOpinions(int i)
    {
        totalOpinions = i;
    }

    public void setTotalRatings(double d)
    {
        totalRatings = d;
    }

    public void setWorstFeatures(ArrayList arraylist)
    {
        worstFeatures = arraylist;
    }
}
