// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpfeaturereviews;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

public class FeatureReviewsResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String next;
    private ArrayList results;

    public FeatureReviewsResponse()
    {
    }

    public String getNext()
    {
        return next;
    }

    public ArrayList getResults()
    {
        return results;
    }

    public void setNext(String s)
    {
        next = s;
    }

    public void setResults(ArrayList arraylist)
    {
        results = arraylist;
    }
}
