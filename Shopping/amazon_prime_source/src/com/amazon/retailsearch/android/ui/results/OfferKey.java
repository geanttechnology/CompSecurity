// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;


public class OfferKey
{

    private final String asin;
    private final String merchantId;

    public OfferKey(String s, String s1)
    {
        asin = s;
        merchantId = s1;
    }

    private int hashCodeOf(String s)
    {
        if (s == null)
        {
            return 0;
        } else
        {
            return s.hashCode();
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof OfferKey))
        {
            if (((OfferKey) (obj = (OfferKey)obj)).asin != null && ((OfferKey) (obj)).merchantId != null && asin != null && merchantId != null && asin.equals(((OfferKey) (obj)).asin) && merchantId.equals(((OfferKey) (obj)).merchantId))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return (hashCodeOf(asin) + 31) * 31 + hashCodeOf(merchantId);
    }
}
