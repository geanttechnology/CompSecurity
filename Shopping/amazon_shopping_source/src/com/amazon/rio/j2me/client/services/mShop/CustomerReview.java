// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            Date

public class CustomerReview
{

    private String authorName;
    private Boolean isVine;
    private int overallRating;
    private Date submissionDate;
    private String text;
    private String title;

    public CustomerReview()
    {
    }

    public void setAuthorName(String s)
    {
        authorName = s;
    }

    public void setIsVine(Boolean boolean1)
    {
        isVine = boolean1;
    }

    public void setOverallRating(int i)
    {
        overallRating = i;
    }

    public void setSubmissionDate(Date date)
    {
        submissionDate = date;
    }

    public void setText(String s)
    {
        text = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
