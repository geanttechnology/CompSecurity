// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.model;

import com.groupon.Channel;
import com.groupon.util.ImageUrl;
import java.util.List;

public class DetailsHeader
{

    public String acceptedPaymentMethods;
    public String boughtCountMessage;
    public String boughtLabel;
    public Channel channel;
    public String dealId;
    public float dealImageHeight;
    public List dealImageList;
    public String dealLocation;
    public String dealTitle;
    public String discount;
    public boolean displayBought;
    public boolean displayConnectedMarketplace;
    public boolean displayDiscount;
    public boolean displayLimitedAvailability;
    public boolean displayLoadingView;
    public boolean displayMobileOnly;
    public boolean displayReservationMessage;
    public boolean hideDiscountValueContainer;
    public int imageCarouselPosition;
    public boolean imageRotationState;
    public ImageUrl largeImageUrl;
    public String nowPriceHtml;
    public String price;
    public String regularPrice;
    public boolean urgencyPricingAvailable;
    public String value;
    public String wasPriceLabel;

    public DetailsHeader()
    {
    }
}
