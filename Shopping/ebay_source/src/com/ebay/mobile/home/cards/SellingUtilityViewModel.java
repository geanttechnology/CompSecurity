// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.RecordStatusEnum;
import java.util.Iterator;
import java.util.List;

public class SellingUtilityViewModel extends ViewModel
{

    public String activeItemType;
    public int awaitPayment;
    public String gmv;
    public double gmvAmount;
    public int gmvDuration;
    public int haveNewOffers;
    public boolean isActiveFailure;
    public boolean isAwaitingPaymentDisabled;
    public boolean isSoldFailure;
    public boolean isUnSoldFailure;
    public int listingsWithBids;
    public int noOfActiveItems;
    public int noOfSoldItems;
    public int noOfUnSoldItems;
    public int notRelisted;
    public int paidShipNow;
    public com.ebay.mobile.sell.lists.SellingListActivity.ListType sellListType;
    public String soldItemType;

    public SellingUtilityViewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        noOfActiveItems = 0;
        haveNewOffers = 0;
        listingsWithBids = 0;
        noOfSoldItems = 0;
        awaitPayment = 0;
        paidShipNow = 0;
        gmvAmount = 0.0D;
        gmv = EbayCurrencyUtil.formatDisplay(new ItemCurrency("USD", "0"), 2);
        gmvDuration = 60;
        noOfUnSoldItems = 0;
        notRelisted = 0;
        isActiveFailure = false;
        isSoldFailure = false;
        isUnSoldFailure = false;
        isAwaitingPaymentDisabled = false;
        contentgroup = contentgroup.contents.iterator();
        do
        {
            if (contentgroup.hasNext())
            {
                onclicklistener = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)contentgroup.next();
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).type == ContentTypeEnum.ACTIVE)
                {
                    boolean flag;
                    if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).status == RecordStatusEnum.FAILURE)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    isActiveFailure = flag;
                    if (!isActiveFailure && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).activeListingsSummary != null)
                    {
                        noOfActiveItems = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).activeListingsSummary.numberOfActiveListings;
                        haveNewOffers = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).activeListingsSummary.numberofListingsWithPendingOffers;
                        listingsWithBids = 0;
                    }
                } else
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).type == ContentTypeEnum.SOLD)
                {
                    boolean flag1;
                    if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).status == RecordStatusEnum.FAILURE || ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).soldListingsSummary != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).soldListingsSummary.hasMoreSold)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    isSoldFailure = flag1;
                    if (!isSoldFailure && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).soldListingsSummary != null)
                    {
                        noOfSoldItems = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).soldListingsSummary.numberOfSoldItems;
                        awaitPayment = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).soldListingsSummary.numberOfItemsAwaitingPayment;
                        paidShipNow = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).soldListingsSummary.numberOfSoldUnshippedItems;
                        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).soldListingsSummary.grossMerchandiseVolume != null)
                        {
                            gmvAmount = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).soldListingsSummary.grossMerchandiseVolume.value;
                            gmv = EbayCurrencyUtil.formatDisplay(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).soldListingsSummary.grossMerchandiseVolume.getAmount(), 2);
                        }
                        gmvDuration = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).soldListingsSummary.periodInDays;
                    }
                    isAwaitingPaymentDisabled = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).suppressAwaitingPayment;
                } else
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).type == ContentTypeEnum.UNSOLD)
                {
                    boolean flag2;
                    if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).status == RecordStatusEnum.FAILURE)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    isUnSoldFailure = flag2;
                    if (!isUnSoldFailure && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).unsoldListingsSummary != null)
                    {
                        noOfUnSoldItems = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener)).unsoldListingsSummary.numberOfUnsoldListings;
                        notRelisted = 0;
                    }
                }
            } else
            {
                return;
            }
        } while (true);
    }
}
