// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class MarketRateDealImpressionExtraInfo extends JsonEncodedNSTField
{

    private String currencyCode;
    private String dealtype;
    private boolean potenialRaOOffer;
    private String price;
    private String quantity;

    public MarketRateDealImpressionExtraInfo(String s)
    {
        dealtype = s;
        potenialRaOOffer = false;
    }

    public MarketRateDealImpressionExtraInfo(String s, String s1, String s2, String s3)
    {
        dealtype = s;
        quantity = s1;
        price = s2;
        currencyCode = s3;
    }

    public MarketRateDealImpressionExtraInfo(String s, boolean flag)
    {
        dealtype = s;
        potenialRaOOffer = flag;
    }
}
