// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import com.groupon.Channel;
import com.groupon.models.HasLargeImageUrl;
import com.groupon.util.SortableCard;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.groupon.db.models:
//            AbstractDeal, Deal, CategorizationItem, WidgetSummary

public class DealSummary extends AbstractDeal
    implements HasLargeImageUrl, SortableCard
{

    public String channel;
    public boolean derivedIsSmuggled;
    public Date modificationDate;
    public WidgetSummary parentWidgetSummary;
    public Long primaryKey;
    public String remoteId;

    public DealSummary()
    {
        derivedIsSmuggled = false;
    }

    public DealSummary(Deal deal, Channel channel1)
    {
        derivedIsSmuggled = false;
        if (channel1 != null)
        {
            channel1 = channel1.name();
        } else
        {
            channel1 = Channel.UNKNOWN.name();
        }
        channel = channel1;
        initDeal(deal);
    }

    public DealSummary(Deal deal, String s)
    {
        derivedIsSmuggled = false;
        channel = s;
        initDeal(deal);
    }

    private void initDeal(Deal deal)
    {
        remoteId = deal.remoteId;
        title = deal.title;
        announcementTitle = deal.announcementTitle;
        largeImageUrl = deal.largeImageUrl;
        soldQuantityMessage = deal.soldQuantityMessage;
        endAt = deal.endAt;
        isSoldOut = deal.isSoldOut;
        status = deal.status;
        soldQuantity = deal.soldQuantity;
        area_name = deal.area_name;
        uuid = deal.uuid;
        divisionName = deal.divisionName;
        displayOptions = deal.displayOptions;
        channels = deal.channels;
        derivedMinimumPurchaseQuantity = deal.derivedMinimumPurchaseQuantity;
        derivedDiscountPercent = deal.derivedDiscountPercent;
        optionLocationCount = deal.optionLocationCount;
        derivedLocationName = deal.derivedLocationName;
        derivedLocationNeighborhood = deal.derivedLocationNeighborhood;
        derivedLocationCity = deal.derivedLocationCity;
        derivedValueAmount = deal.derivedValueAmount;
        derivedValueFormattedAmount = deal.derivedValueFormattedAmount;
        derivedValueCurrencyCode = deal.derivedValueCurrencyCode;
        derivedRegularPriceAmount = deal.derivedRegularPriceAmount;
        derivedRegularPriceFormattedAmount = deal.derivedRegularPriceFormattedAmount;
        derivedRegularPriceCurrencyCode = deal.derivedRegularPriceCurrencyCode;
        derivedPriceAmount = deal.derivedPriceAmount;
        derivedPriceFormattedAmount = deal.derivedPriceFormattedAmount;
        derivedPriceCurrencyCode = deal.derivedPriceCurrencyCode;
        derivedPricingMetadataOfferLabelDescriptive = deal.derivedPricingMetadataOfferLabelDescriptive;
        derivedPricingMetadataOfferLabel = deal.derivedPricingMetadataOfferLabel;
        derivedPricingMetadataOfferBeginsAt = deal.derivedPricingMetadataOfferBeginsAt;
        derivedPricingMetadataOfferEndsAt = deal.derivedPricingMetadataOfferEndsAt;
        derivedPricingMetadataOfferType = deal.derivedPricingMetadataOfferType;
        optionDimensionsCount = deal.optionDimensionsCount;
        hasImagesForOptions = deal.hasImagesForOptions;
        parentWidgetSummary = deal.parentWidgetSummary;
        derivedRedemptionLocations = deal.derivedRedemptionLocations;
        defaultOptionId = deal.defaultOptionId;
        isTravelBookableDeal = deal.isTravelBookableDeal;
        sidebarImageUrl = deal.sidebarImageUrl;
        derivedMerchantName = deal.derivedMerchantName;
        grouponRating = deal.grouponRating;
        endRedemptionAt = deal.endRedemptionAt;
        derivedOptionEndRedemptionAt = deal.derivedOptionEndRedemptionAt;
        incentivePromotionType = deal.incentivePromotionType;
        incentivePromoCode = deal.incentivePromoCode;
        incentiveShortMessage = deal.incentiveShortMessage;
        incentiveLongMessage = deal.incentiveLongMessage;
        incentiveExpiryDate = deal.incentiveExpiryDate;
        derivedMerchantRecommendationPercentMessage = deal.derivedMerchantRecommendationPercentMessage;
        derivedMerchantRecommendationTotalMessage = deal.derivedMerchantRecommendationTotalMessage;
        firstOptionTitle = deal.firstOptionTitle;
        isConnectedMarketPlaceDeal = deal.isConnectedMarketPlaceDeal;
        connectedMarketPlaceDisplayText = deal.connectedMarketPlaceDisplayText;
        derivedActualPosition = deal.derivedActualPosition;
        derivedTrackingPosition = deal.derivedTrackingPosition;
        derivedImageUrl = deal.derivedImageUrl;
        badges = deal.badges;
        secondLevelDealCategories = deal.secondLevelDealCategories;
        bookableSegments = deal.bookableSegments;
        secondLevelDealCategories = getSecondLevelCategoriesFromDeal(deal);
        derivedHasBookableOrSchedulableOptions = deal.derivedHasBookableOrSchedulableOptions;
        derivedHasHasExternalUrl = deal.derivedHasHasExternalUrl;
        derivedOptionsCount = deal.derivedOptionsCount;
    }

    public int cardPosition()
    {
        return derivedActualPosition;
    }

    public DealSummary checkIfDerivedDealIsSmuggled(Set set)
    {
        derivedIsSmuggled = set.contains(remoteId);
        return this;
    }

    public Channel getChannel()
    {
        return Channel.safeValueOf(channel);
    }

    public HashSet getSecondLevelCategoriesFromDeal(Deal deal)
    {
        List list = null;
        HashSet hashset = new HashSet();
        deal = deal.getCategorizations();
        if (deal != null && deal.size() > 0 && deal.get(0) != null)
        {
            deal = (CategorizationItem)deal.get(0);
        } else
        {
            deal = null;
        }
        if (deal != null)
        {
            list = deal.getChildren();
        }
        if (list != null && list.size() > 0)
        {
            for (deal = list.iterator(); deal.hasNext(); hashset.add(((CategorizationItem)deal.next()).id)) { }
        }
        return hashset;
    }
}
