// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.deal;

import com.groupon.Channel;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Image;
import com.groupon.db.models.MarketRateResult;
import com.groupon.db.models.Option;
import com.groupon.db.models.Price;
import com.groupon.util.ImageUrl;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.deal:
//            SharedDealInfo

public class SharedDealInfoConverter
{

    public SharedDealInfoConverter()
    {
    }

    private String getOptionImageUrl(Option option, boolean flag)
    {
        option = option.images;
        if (option.size() > 0)
        {
            option = option.iterator();
            Object obj;
            do
            {
                obj = (Image)option.next();
            } while (option.hasNext() && Strings.isEmpty(((Image) (obj)).url));
            if (obj == null || Strings.isEmpty(((Image) (obj)).url))
            {
                return "";
            }
            obj = (new StringBuilder()).append(((Image) (obj)).url);
            if (!flag)
            {
                option = "t954x610.jpg";
            } else
            {
                option = "";
            }
            return ((StringBuilder) (obj)).append(option).toString();
        } else
        {
            return "";
        }
    }

    public SharedDealInfo convertFrom(Deal deal, Channel channel)
    {
        SharedDealInfo shareddealinfo = new SharedDealInfo();
        shareddealinfo.channel = channel;
        shareddealinfo.displayTimer = deal.getDisplayOption("timer", true);
        shareddealinfo.displayBought = deal.getDisplayOption("quantity", true);
        shareddealinfo.displayDiscount = deal.getDisplayOption("discount", true);
        shareddealinfo.displayMobileOnly = deal.getDisplayOption("platformExclusive", false);
        shareddealinfo.divisionName = deal.divisionName;
        shareddealinfo.announcementTitle = deal.announcementTitle;
        shareddealinfo.areaName = deal.area_name;
        shareddealinfo.defaultOptionId = deal.defaultOptionId;
        shareddealinfo.derivedDiscountPercent = deal.derivedDiscountPercent;
        shareddealinfo.derivedLocationCity = deal.derivedLocationCity;
        shareddealinfo.derivedLocationName = deal.derivedLocationName;
        shareddealinfo.derivedLocationNeighborhood = deal.derivedLocationNeighborhood;
        shareddealinfo.derivedMerchantName = deal.derivedMerchantName;
        shareddealinfo.derivedMinimumPurchaseQuantity = deal.derivedMinimumPurchaseQuantity;
        shareddealinfo.derivedOptionEndRedemptionAt = deal.derivedOptionEndRedemptionAt;
        shareddealinfo.derivedPriceAmount = deal.derivedPriceAmount;
        shareddealinfo.derivedPriceCurrencyCode = deal.derivedRegularPriceCurrencyCode;
        shareddealinfo.derivedPriceFormattedAmount = deal.derivedPriceFormattedAmount;
        shareddealinfo.derivedPricingMetadataOfferBeginsAt = deal.derivedPricingMetadataOfferBeginsAt;
        shareddealinfo.derivedPricingMetadataOfferEndsAt = deal.derivedPricingMetadataOfferEndsAt;
        shareddealinfo.derivedPricingMetadataOfferLabelDescriptive = deal.derivedPricingMetadataOfferLabelDescriptive;
        shareddealinfo.derivedPricingMetadataOfferLabel = deal.derivedPricingMetadataOfferLabel;
        shareddealinfo.derivedPricingMetadataOfferType = deal.derivedPricingMetadataOfferType;
        shareddealinfo.derivedValueAmount = deal.derivedValueAmount;
        shareddealinfo.derivedValueCurrencyCode = deal.derivedValueCurrencyCode;
        shareddealinfo.derivedValueFormattedAmount = deal.derivedValueFormattedAmount;
        shareddealinfo.derivedRegularPriceAmount = deal.derivedRegularPriceAmount;
        shareddealinfo.derivedRegularPriceFormattedAmount = deal.derivedRegularPriceFormattedAmount;
        shareddealinfo.derivedRegularPriceCurrencyCode = deal.derivedRegularPriceCurrencyCode;
        shareddealinfo.divisionName = deal.divisionName;
        shareddealinfo.endAt = deal.endAt;
        shareddealinfo.endRedemptionAt = deal.endRedemptionAt;
        shareddealinfo.grouponRating = deal.grouponRating;
        shareddealinfo.hasImagesForOptions = deal.hasImagesForOptions;
        shareddealinfo.incentiveExpiryDate = deal.incentiveExpiryDate;
        shareddealinfo.incentivePromoCode = deal.incentivePromoCode;
        shareddealinfo.incentiveShortMessage = deal.incentiveShortMessage;
        shareddealinfo.isSoldOut = deal.isSoldOut;
        shareddealinfo.isTravelBookableDeal = deal.isTravelBookableDeal;
        shareddealinfo.largeImageUrl = deal.getImageUrl();
        shareddealinfo.optionDimensionsCount = deal.optionDimensionsCount;
        shareddealinfo.optionLocationCount = deal.optionLocationCount;
        shareddealinfo.remoteId = deal.remoteId;
        shareddealinfo.sidebarImageUrl = deal.sidebarImageUrl;
        shareddealinfo.soldQuantity = deal.soldQuantity;
        shareddealinfo.soldQuantityMessage = deal.soldQuantityMessage;
        shareddealinfo.status = deal.status;
        shareddealinfo.title = deal.title;
        shareddealinfo.optionTitle = deal.firstOptionTitle;
        shareddealinfo.uuid = deal.uuid;
        shareddealinfo.derivedHasBookableOrSchedulableOptions = deal.derivedHasBookableOrSchedulableOptions;
        shareddealinfo.derivedHasHasExternalUrl = deal.derivedHasHasExternalUrl;
        shareddealinfo.derivedOptionsCount = deal.derivedOptionsCount;
        deal = deal.getChannelList();
        shareddealinfo.channels = (Channel[])deal.toArray(new Channel[deal.size()]);
        return shareddealinfo;
    }

    public SharedDealInfo convertFrom(DealSummary dealsummary, Option option, com.groupon.util.ViewUtils.Size size, boolean flag)
    {
        dealsummary = convertFrom(dealsummary, size);
        dealsummary.optionTitle = option.getTitle();
        size = option.getValue();
        dealsummary.derivedValueAmount = ((Price) (size)).amount;
        dealsummary.derivedValueCurrencyCode = ((Price) (size)).currencyCode;
        dealsummary.derivedValueFormattedAmount = ((Price) (size)).formattedAmount;
        size = option.getPrice();
        dealsummary.derivedPriceAmount = ((Price) (size)).amount;
        dealsummary.derivedPriceCurrencyCode = ((Price) (size)).currencyCode;
        dealsummary.derivedPriceFormattedAmount = ((Price) (size)).formattedAmount;
        dealsummary.derivedMinimumPurchaseQuantity = option.getMinimumPurchaseQuantity();
        dealsummary.largeImageUrl = new ImageUrl(getOptionImageUrl(option, flag), false);
        return dealsummary;
    }

    public SharedDealInfo convertFrom(DealSummary dealsummary, com.groupon.util.ViewUtils.Size size)
    {
        SharedDealInfo shareddealinfo = new SharedDealInfo();
        shareddealinfo.channel = dealsummary.getChannel();
        shareddealinfo.displayTimer = dealsummary.getDisplayOption("timer", true);
        shareddealinfo.displayBought = dealsummary.getDisplayOption("quantity", true);
        shareddealinfo.displayDiscount = dealsummary.getDisplayOption("discount", true);
        shareddealinfo.displayMobileOnly = dealsummary.getDisplayOption("platformExclusive", false);
        shareddealinfo.divisionName = dealsummary.divisionName;
        shareddealinfo.announcementTitle = dealsummary.announcementTitle;
        shareddealinfo.areaName = dealsummary.area_name;
        shareddealinfo.defaultOptionId = dealsummary.defaultOptionId;
        shareddealinfo.derivedDiscountPercent = dealsummary.derivedDiscountPercent;
        shareddealinfo.derivedLocationCity = dealsummary.derivedLocationCity;
        shareddealinfo.derivedLocationName = dealsummary.derivedLocationName;
        shareddealinfo.derivedLocationNeighborhood = dealsummary.derivedLocationNeighborhood;
        shareddealinfo.derivedMerchantName = dealsummary.derivedMerchantName;
        shareddealinfo.derivedMinimumPurchaseQuantity = dealsummary.derivedMinimumPurchaseQuantity;
        shareddealinfo.derivedOptionEndRedemptionAt = dealsummary.derivedOptionEndRedemptionAt;
        shareddealinfo.derivedPriceAmount = dealsummary.derivedPriceAmount;
        shareddealinfo.derivedPriceCurrencyCode = dealsummary.derivedPriceCurrencyCode;
        shareddealinfo.derivedPriceFormattedAmount = dealsummary.derivedPriceFormattedAmount;
        shareddealinfo.derivedPricingMetadataOfferBeginsAt = dealsummary.derivedPricingMetadataOfferBeginsAt;
        shareddealinfo.derivedPricingMetadataOfferEndsAt = dealsummary.derivedPricingMetadataOfferEndsAt;
        shareddealinfo.derivedPricingMetadataOfferLabelDescriptive = dealsummary.derivedPricingMetadataOfferLabelDescriptive;
        shareddealinfo.derivedPricingMetadataOfferLabel = dealsummary.derivedPricingMetadataOfferLabel;
        shareddealinfo.derivedPricingMetadataOfferType = dealsummary.derivedPricingMetadataOfferType;
        shareddealinfo.derivedValueAmount = dealsummary.derivedValueAmount;
        shareddealinfo.derivedValueCurrencyCode = dealsummary.derivedValueCurrencyCode;
        shareddealinfo.derivedValueFormattedAmount = dealsummary.derivedValueFormattedAmount;
        shareddealinfo.derivedRegularPriceAmount = dealsummary.derivedRegularPriceAmount;
        shareddealinfo.derivedRegularPriceFormattedAmount = dealsummary.derivedRegularPriceFormattedAmount;
        shareddealinfo.derivedRegularPriceCurrencyCode = dealsummary.derivedRegularPriceCurrencyCode;
        shareddealinfo.divisionName = dealsummary.divisionName;
        shareddealinfo.endAt = dealsummary.endAt;
        shareddealinfo.endRedemptionAt = dealsummary.endRedemptionAt;
        shareddealinfo.grouponRating = dealsummary.grouponRating;
        shareddealinfo.hasImagesForOptions = dealsummary.hasImagesForOptions;
        shareddealinfo.incentiveExpiryDate = dealsummary.incentiveExpiryDate;
        shareddealinfo.incentivePromoCode = dealsummary.incentivePromoCode;
        shareddealinfo.incentiveShortMessage = dealsummary.incentiveShortMessage;
        shareddealinfo.isSoldOut = dealsummary.isSoldOut;
        shareddealinfo.isTravelBookableDeal = dealsummary.isTravelBookableDeal;
        shareddealinfo.largeImageUrl = dealsummary.getImageUrl();
        shareddealinfo.optionDimensionsCount = dealsummary.optionDimensionsCount;
        shareddealinfo.optionLocationCount = dealsummary.optionLocationCount;
        shareddealinfo.remoteId = dealsummary.remoteId;
        shareddealinfo.sidebarImageUrl = dealsummary.sidebarImageUrl;
        shareddealinfo.soldQuantity = dealsummary.soldQuantity;
        shareddealinfo.soldQuantityMessage = dealsummary.soldQuantityMessage;
        shareddealinfo.status = dealsummary.status;
        shareddealinfo.title = dealsummary.title;
        shareddealinfo.optionTitle = dealsummary.firstOptionTitle;
        shareddealinfo.uuid = dealsummary.uuid;
        if (size != null)
        {
            shareddealinfo.dealImageWidth = size.getWidth();
            shareddealinfo.dealImageHeight = size.getHeight();
        }
        shareddealinfo.derivedHasBookableOrSchedulableOptions = dealsummary.derivedHasBookableOrSchedulableOptions;
        shareddealinfo.derivedHasHasExternalUrl = dealsummary.derivedHasHasExternalUrl;
        shareddealinfo.derivedOptionsCount = dealsummary.derivedOptionsCount;
        size = dealsummary.getChannelList();
        shareddealinfo.channels = (Channel[])size.toArray(new Channel[size.size()]);
        shareddealinfo.secondLevelDealCategories = dealsummary.secondLevelDealCategories;
        return shareddealinfo;
    }

    public SharedDealInfo convertFrom(MarketRateResult marketrateresult, com.groupon.util.ViewUtils.Size size)
    {
        SharedDealInfo shareddealinfo = new SharedDealInfo();
        shareddealinfo.title = marketrateresult.title;
        shareddealinfo.announcementTitle = marketrateresult.announcementTitle;
        shareddealinfo.derivedValueAmount = marketrateresult.derivedDisplayValueAmount;
        shareddealinfo.derivedValueCurrencyCode = marketrateresult.derivedDisplayValueCurrencyCode;
        shareddealinfo.derivedValueFormattedAmount = marketrateresult.derivedDisplayValueFormattedAmount;
        shareddealinfo.derivedPriceAmount = marketrateresult.derivedAvgMinPriceNet;
        shareddealinfo.derivedPriceCurrencyCode = marketrateresult.derivedAvgMinPriceCurrencyCode;
        shareddealinfo.derivedMinimumPurchaseQuantity = 1;
        shareddealinfo.largeImageUrl = new ImageUrl(marketrateresult.derivedImageUrl);
        if (size != null)
        {
            shareddealinfo.dealImageWidth = size.getWidth();
            shareddealinfo.dealImageHeight = size.getHeight();
        }
        shareddealinfo.channel = Channel.safeValueOf(marketrateresult.channel);
        shareddealinfo.channels = (new Channel[] {
            shareddealinfo.channel
        });
        return shareddealinfo;
    }
}
