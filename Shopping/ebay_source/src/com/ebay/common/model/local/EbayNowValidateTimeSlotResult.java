// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.local;


public class EbayNowValidateTimeSlotResult
{
    public static class Product
    {

        public String sku;

        public Product()
        {
        }
    }


    public Product products[];
    public String reservationToken;
    public String sellerEiasToken;
    public String sellerId;
    public String storeId;

    public EbayNowValidateTimeSlotResult()
    {
    }
}
