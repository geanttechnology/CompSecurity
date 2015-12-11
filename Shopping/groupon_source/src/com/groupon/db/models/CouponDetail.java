// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Date;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.db.models:
//            AbstractCoupon, CouponMerchant

public class CouponDetail extends AbstractCoupon
{
    private static class MerchantLogo
    {

        public String hiresLogoUrl;
        public String logoUrl;

        private MerchantLogo()
        {
        }
    }


    public String buttonAction;
    public String code;
    public CouponMerchant couponMerchant;
    public String customLogoUrl;
    public String description;
    public Date endsAt;
    public MerchantLogo merchantLogo;
    public Date modificationDate;
    public String prettyEndsOn;
    public Long primaryKey;
    public String remoteId;
    public String restrictions;
    public Date startsAt;
    public String trackingUrl;

    public CouponDetail()
    {
        description = "";
        code = "";
        restrictions = "";
        trackingUrl = "";
        startsAt = null;
        endsAt = null;
        buttonAction = "";
        customLogoUrl = "";
        prettyEndsOn = "";
    }

    public void afterJsonDeserializationPostProcessor()
    {
        derivedMerchantHiresLogoUrl = merchantLogo.hiresLogoUrl;
        derivedMerchantLogoUrl = merchantLogo.logoUrl;
    }

    public String getImageUrl()
    {
        if (Strings.notEmpty(productImageUrl))
        {
            return (new StringBuilder()).append("https://").append(productImageUrl).toString();
        }
        if (Strings.notEmpty(derivedMerchantHiresLogoUrl))
        {
            return derivedMerchantHiresLogoUrl;
        } else
        {
            return derivedMerchantLogoUrl;
        }
    }

    public String getImageUrlOnline()
    {
        if (Strings.notEmpty(derivedMerchantHiresLogoUrl))
        {
            return derivedMerchantHiresLogoUrl;
        } else
        {
            return derivedMerchantLogoUrl;
        }
    }
}
