// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.deeplink.imp;

import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.InvalidDeepLinkException;

public class ChannelDeepLink extends DeepLinkData
{

    final String COUPONS = "coupons";
    final String COUPON_CATEGORY = "category";
    final String COUPON_MERCHANT = "merchant";

    public ChannelDeepLink()
    {
    }

    public void validate()
        throws InvalidDeepLinkException
    {
        super.validate();
        if (getSpecifier().equals("coupons") && (getContentId().equals("merchant") || getContentId().equals("category")) && getSpecialId().isEmpty())
        {
            throw new InvalidDeepLinkException("Special id is not provided");
        } else
        {
            return;
        }
    }
}
