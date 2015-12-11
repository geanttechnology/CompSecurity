// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpreviews;

import gu;
import java.io.Serializable;

public class RepresentativeQuotes
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String highlightedQuote;
    private String id;
    private String quote;
    private String reviewId;
    private String userNickname;

    public RepresentativeQuotes()
    {
    }

    public String getHighlightedQuote()
    {
        return highlightedQuote;
    }

    public String getId()
    {
        return id;
    }

    public String getQuote()
    {
        return quote;
    }

    public String getReviewId()
    {
        return reviewId;
    }

    public String getUserNickname()
    {
        return userNickname;
    }

    public void setHighlightedQuote(String s)
    {
        highlightedQuote = s;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setQuote(String s)
    {
        quote = s;
    }

    public void setReviewId(String s)
    {
        reviewId = s;
    }

    public void setUserNickname(String s)
    {
        userNickname = s;
    }
}
