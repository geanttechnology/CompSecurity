// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.search;


public final class SellerOffer
{

    public final String legalText;
    public final String subTitle;
    public final String title;

    public SellerOffer(com.ebay.common.net.api.search.SearchServiceResponse.SellerOfferDetail sellerofferdetail)
    {
        title = sellerofferdetail.textMessage;
        subTitle = sellerofferdetail.subTitle;
        legalText = sellerofferdetail.legalTextMessage;
    }
}
