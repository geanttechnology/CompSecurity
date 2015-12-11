// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.favseller;

import java.net.URL;

public class FavoriteSeller
{

    public String feedbackRatingStar;
    public int feedbackScore;
    public URL myWorldSmallImg;
    public URL myWorldUrl;
    public String notes;
    public String positiveFeedbackPercent;
    public String sellerId;
    public boolean topRatedSeller;

    public FavoriteSeller()
    {
    }

    public String toString()
    {
        return sellerId;
    }
}
