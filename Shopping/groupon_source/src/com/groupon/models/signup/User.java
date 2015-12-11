// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.signup;

import com.groupon.db.models.DealType;
import com.groupon.models.billingrecord.BillingRecord;

// Referenced classes of package com.groupon.models.signup:
//            CreditsAvailable, Flags

public class User
{

    public BillingRecord billingRecords[];
    public String consumerId;
    public CreditsAvailable creditsAvailable;
    public DealType dealTypes[];
    public String emailVerifiedAt;
    public String facebookToken;
    public String firstName;
    public Flags flags;
    public String id;
    public String lastName;
    public boolean legalTermsAccepted;
    public String maskedName;
    public String merchants[];
    public String primaryEmailAddress;
    public String referralCode;
    public String rewardPointsAvailable;
    public String timeZone;

    public User()
    {
    }
}
