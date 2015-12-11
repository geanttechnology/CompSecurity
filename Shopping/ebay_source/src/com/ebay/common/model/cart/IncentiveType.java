// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Locale;

public abstract class IncentiveType
    implements Serializable
{

    protected final String type;

    IncentiveType(String s)
    {
        String s1 = s;
        if (!TextUtils.isEmpty(s))
        {
            s1 = s.toLowerCase(Locale.US);
        }
        type = s1;
    }

    public boolean isCoupon()
    {
        return type != null && type.equals("coupon");
    }

    public boolean isGiftCard()
    {
        return type != null && type.equals("giftcard");
    }

    public boolean isGiftCertificate()
    {
        return type != null && type.equals("giftcertificate");
    }

    public boolean isReward()
    {
        return type != null && type.equals("reward");
    }

    public boolean isVoucher()
    {
        return type != null && type.equals("voucher");
    }
}
