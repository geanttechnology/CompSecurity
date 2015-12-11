// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Date;

// Referenced classes of package com.groupon.db.models:
//            AbstractCoupon, CouponDetail

public class CouponSummary extends AbstractCoupon
{

    public String channel;
    public Date modificationDate;
    public Long primaryKey;
    public String remoteId;

    public CouponSummary()
    {
    }

    public CouponSummary(CouponDetail coupondetail, String s)
    {
        super(coupondetail);
        channel = s;
        modificationDate = coupondetail.modificationDate;
        primaryKey = coupondetail.primaryKey;
        remoteId = coupondetail.remoteId;
    }
}
