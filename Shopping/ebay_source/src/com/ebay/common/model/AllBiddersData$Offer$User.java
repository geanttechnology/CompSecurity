// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import java.util.Date;

// Referenced classes of package com.ebay.common.model:
//            AllBiddersData

public static class Info
{

    public boolean IdVerified;
    public boolean aboutMePage;
    public ngSummary biddingSummary;
    public Info buyerInfo;
    public boolean eBayGoodStanding;
    public String email;
    public boolean feedbackPrivate;
    public String feedbackRatingStar;
    public int feedbackScore;
    public boolean newUser;
    public float positiveFeedbackPercent;
    public Date registrationDate;
    public String site;
    public String status;
    public boolean userAnonymized;
    public String userId;
    public boolean userIdChanged;
    public Date userIdLastChanged;
    public String vatStatus;

    public Info()
    {
        biddingSummary = new ngSummary();
        buyerInfo = new Info();
    }
}
