// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListingViewModel extends ViewModel
{

    public Date EndDate;
    public int bidCount;
    public String description;
    public int discountPercent;
    public com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum discountPriceType;
    public String eekDisplayText;
    public String imageUrl;
    public boolean isAlmostGone;
    public long itemId;
    public String listingId;
    public String percentOff;
    public String price;
    public String strikeThroughPrice;
    public String suggestedRetailPrice;
    public String title;

    public ListingViewModel(int i, MyEbayListItem myebaylistitem, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        discountPercent = 0;
        isAlmostGone = false;
        itemId = myebaylistitem.id;
        imageUrl = myebaylistitem.imageUrl;
        title = myebaylistitem.title;
        description = myebaylistitem.title;
        bidCount = myebaylistitem.bidCount;
        EndDate = myebaylistitem.endDate;
        price = EbayCurrencyUtil.formatDisplay(myebaylistitem.currentPrice, 2);
    }

    public ListingViewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing listing, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        discountPercent = 0;
        isAlmostGone = false;
        if (listing.title != null)
        {
            title = listing.title.content;
        }
        imageUrl = listing.imageUrl;
        if (listing.format == com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.AUCTION && listing.currentBidPrice != null)
        {
            price = formatAmount(listing.currentBidPrice, 2);
        }
        if (listing.format == com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.FIXED_PRICE && listing.lowestFixedPrice != null)
        {
            price = formatAmount(listing.lowestFixedPrice, 2);
        }
        onclicklistener = listing.discountPrices;
        if (onclicklistener != null)
        {
            onclicklistener = onclicklistener.iterator();
            if (onclicklistener.hasNext())
            {
                com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing.DiscountPrice discountprice = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing.DiscountPrice)onclicklistener.next();
                discountPriceType = discountprice.discountPriceEnum;
                if (discountprice.discountPercentage != null)
                {
                    Double double1 = discountprice.discountPercentage;
                    onclicklistener = double1;
                    if (double1.doubleValue() < 1.0D)
                    {
                        onclicklistener = Double.valueOf(double1.doubleValue() * 100D);
                    }
                    discountPercent = onclicklistener.intValue();
                }
                onclicklistener = discountprice.suggestedRetailPrice;
                if (onclicklistener != null)
                {
                    suggestedRetailPrice = EbayCurrencyUtil.formatDisplay(((com.ebay.nautilus.domain.data.BaseCommonType.Amount) (onclicklistener)).currency, ((com.ebay.nautilus.domain.data.BaseCommonType.Amount) (onclicklistener)).value, 2);
                }
                onclicklistener = discountprice.getDiscountProperties();
                List list = (List)onclicklistener.get("stp_text");
                if (list != null && list.size() > 0)
                {
                    strikeThroughPrice = ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)list.get(0)).stringValue;
                }
                list = (List)onclicklistener.get("percent_off_text");
                if (list != null && list.size() > 0)
                {
                    percentOff = ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)list.get(0)).stringValue;
                }
                onclicklistener = (List)onclicklistener.get("price_label");
                if (onclicklistener != null && onclicklistener.size() > 0 && "MAP".equals(((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)onclicklistener.get(0)).stringValue))
                {
                    discountPriceType = com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum.MINIMUM_ADVERTISED_PRICE;
                }
            }
        }
        if (listing.eekInfo != null)
        {
            onclicklistener = listing.eekInfo.displayText;
        } else
        {
            onclicklistener = null;
        }
        eekDisplayText = onclicklistener;
        listingId = listing.listingId;
        isAlmostGone = false;
    }

    private String formatAmount(com.ebay.nautilus.domain.data.BaseCommonType.Amount amount, int i)
    {
        return EbayCurrencyUtil.formatDisplay(amount.currency, amount.value, i);
    }

    public boolean isValid()
    {
        return listingId != null && title != null && imageUrl != null && (suggestedRetailPrice != null || price != null);
    }
}
