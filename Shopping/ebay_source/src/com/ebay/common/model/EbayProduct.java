// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;


public class EbayProduct
{

    public String detailsUrl;
    public String epid;
    public String stockPhotoUrl;
    public String title;

    public EbayProduct()
    {
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Title: ").append(title).append("\nStockPhotoURL: ").append(stockPhotoUrl).append("\nepid: ").append(epid);
        stringbuilder.append("\ndetailsUrl: ").append(detailsUrl);
        return stringbuilder.toString();
    }
}
