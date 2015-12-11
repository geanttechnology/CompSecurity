// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpreviews;

import gu;
import java.io.Serializable;

public class ReviewResults
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private int rating;
    private String reviewId;
    private String reviewText;
    private int sentiment;
    private String submissionTime;
    private String title;
    private String userLocation;
    private String userNickname;

    public ReviewResults()
    {
    }

    public int getRating()
    {
        return rating;
    }

    public String getReviewId()
    {
        return reviewId;
    }

    public String getReviewText()
    {
        return reviewText;
    }

    public int getSentiment()
    {
        return sentiment;
    }

    public String getSubmissionTime()
    {
        return submissionTime;
    }

    public String getTitle()
    {
        return title;
    }

    public String getUserLocation()
    {
        return userLocation;
    }

    public String getUserNickname()
    {
        return userNickname;
    }

    public void setRating(int i)
    {
        rating = i;
    }

    public void setReviewId(String s)
    {
        reviewId = s;
    }

    public void setReviewText(String s)
    {
        reviewText = s;
    }

    public void setSentiment(int i)
    {
        sentiment = i;
    }

    public void setSubmissionTime(String s)
    {
        submissionTime = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setUserLocation(String s)
    {
        userLocation = s;
    }

    public void setUserNickname(String s)
    {
        userNickname = s;
    }
}
