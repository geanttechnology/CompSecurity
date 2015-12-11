// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpreviews;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

public class ReviewFeaturesDetails
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String expandedFeature;
    private String feature;
    private int negativeReviewsMentioned;
    private double percentPositive;
    private int positiveReviewsMentioned;
    private ArrayList representativeQuotes;
    private String reviewDetailUrl;
    private double score;
    private ArrayList tags;
    private int totalMentions;
    private int totalReviewsMentioned;

    public ReviewFeaturesDetails()
    {
    }

    public String getExpandedFeature()
    {
        return expandedFeature;
    }

    public String getFeature()
    {
        return feature;
    }

    public int getNegativeReviewsMentioned()
    {
        return negativeReviewsMentioned;
    }

    public double getPercentPositive()
    {
        return percentPositive;
    }

    public int getPositiveReviewsMentioned()
    {
        return positiveReviewsMentioned;
    }

    public ArrayList getRepresentativeQuotes()
    {
        return representativeQuotes;
    }

    public String getReviewDetailUrl()
    {
        return reviewDetailUrl;
    }

    public double getScore()
    {
        return score;
    }

    public ArrayList getTags()
    {
        return tags;
    }

    public int getTotalMentions()
    {
        return totalMentions;
    }

    public int getTotalReviewsMentioned()
    {
        return totalReviewsMentioned;
    }

    public void setExpandedFeature(String s)
    {
        expandedFeature = s;
    }

    public void setFeature(String s)
    {
        feature = s;
    }

    public void setNegativeReviewsMentioned(int i)
    {
        negativeReviewsMentioned = i;
    }

    public void setPercentPositive(double d)
    {
        percentPositive = d;
    }

    public void setPositiveReviewsMentioned(int i)
    {
        positiveReviewsMentioned = i;
    }

    public void setRepresentativeQuotes(ArrayList arraylist)
    {
        representativeQuotes = arraylist;
    }

    public void setReviewDetailUrl(String s)
    {
        reviewDetailUrl = s;
    }

    public void setScore(double d)
    {
        score = d;
    }

    public void setTags(ArrayList arraylist)
    {
        tags = arraylist;
    }

    public void setTotalMentions(int i)
    {
        totalMentions = i;
    }

    public void setTotalReviewsMentioned(int i)
    {
        totalReviewsMentioned = i;
    }
}
