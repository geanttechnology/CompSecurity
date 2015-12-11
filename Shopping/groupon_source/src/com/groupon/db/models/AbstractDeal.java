// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import com.groupon.Channel;
import com.groupon.util.ImageUrl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.db.models:
//            AttrsContainer, PositionInterface

public class AbstractDeal extends AttrsContainer
    implements PositionInterface
{

    private static final String AVAILABLE = "available";
    private static final String EXPIRED = "expired";
    private static final String SOLD_OUT = "sold_out";
    public String announcementTitle;
    public String area_name;
    public ArrayList badges;
    public ArrayList bookableSegments;
    private volatile HashSet channelList;
    public HashSet channels;
    public String connectedMarketPlaceDisplayText;
    public String defaultOptionId;
    public int derivedActualPosition;
    public int derivedDiscountPercent;
    public boolean derivedHasBookableOrSchedulableOptions;
    public boolean derivedHasHasExternalUrl;
    public String derivedImageUrl;
    public boolean derivedIsGLiveDeal;
    public String derivedLocationCity;
    public String derivedLocationName;
    public String derivedLocationNeighborhood;
    public String derivedMerchantName;
    public String derivedMerchantRecommendationPercentMessage;
    public String derivedMerchantRecommendationTotalMessage;
    public int derivedMinimumPurchaseQuantity;
    public Date derivedOptionEndRedemptionAt;
    public int derivedOptionsCount;
    public int derivedPriceAmount;
    public String derivedPriceCurrencyCode;
    public String derivedPriceFormattedAmount;
    public Date derivedPricingMetadataOfferBeginsAt;
    public Date derivedPricingMetadataOfferEndsAt;
    public String derivedPricingMetadataOfferLabel;
    public String derivedPricingMetadataOfferLabelDescriptive;
    public String derivedPricingMetadataOfferType;
    public ArrayList derivedRedemptionLocations;
    public int derivedRegularPriceAmount;
    public String derivedRegularPriceCurrencyCode;
    public String derivedRegularPriceFormattedAmount;
    public int derivedTrackingPosition;
    public int derivedValueAmount;
    public String derivedValueCurrencyCode;
    public String derivedValueFormattedAmount;
    public HashMap displayOptions;
    public String divisionName;
    public Date endAt;
    public Date endRedemptionAt;
    public String firstOptionTitle;
    public double grouponRating;
    public boolean hasImagesForOptions;
    public Date incentiveExpiryDate;
    public String incentiveLongMessage;
    public String incentivePromoCode;
    public String incentivePromotionType;
    public String incentiveShortMessage;
    public boolean isConnectedMarketPlaceDeal;
    public boolean isSoldOut;
    public boolean isTravelBookableDeal;
    public String largeImageUrl;
    public int optionDimensionsCount;
    public int optionLocationCount;
    public String redemptionLocation;
    public HashSet secondLevelDealCategories;
    public String sidebarImageUrl;
    public int soldQuantity;
    public String soldQuantityMessage;
    public String status;
    public String title;
    public String uuid;

    public AbstractDeal()
    {
        title = "";
        announcementTitle = "";
        largeImageUrl = "";
        sidebarImageUrl = "";
        soldQuantityMessage = "";
        endAt = null;
        isSoldOut = false;
        status = "";
        soldQuantity = 0;
        grouponRating = 0.0D;
        endRedemptionAt = null;
        area_name = "";
        uuid = "";
        divisionName = "";
        isTravelBookableDeal = false;
        redemptionLocation = "";
        displayOptions = new HashMap();
        channels = new HashSet();
        badges = new ArrayList();
        bookableSegments = new ArrayList();
        derivedRedemptionLocations = new ArrayList();
        secondLevelDealCategories = new HashSet();
        derivedMinimumPurchaseQuantity = 0;
        derivedDiscountPercent = 0;
        optionLocationCount = 0;
        derivedLocationName = "";
        derivedLocationNeighborhood = "";
        derivedLocationCity = "";
        derivedPriceAmount = 0;
        derivedPriceFormattedAmount = "";
        derivedPriceCurrencyCode = "";
        derivedPricingMetadataOfferLabelDescriptive = "";
        derivedPricingMetadataOfferLabel = "";
        derivedPricingMetadataOfferType = "";
        derivedValueAmount = 0;
        derivedValueFormattedAmount = "";
        derivedValueCurrencyCode = "";
        derivedRegularPriceAmount = 0;
        derivedRegularPriceFormattedAmount = "";
        derivedRegularPriceCurrencyCode = "";
        derivedPricingMetadataOfferBeginsAt = null;
        derivedPricingMetadataOfferEndsAt = null;
        optionDimensionsCount = -1;
        hasImagesForOptions = false;
        defaultOptionId = null;
        derivedMerchantName = "";
        derivedMerchantRecommendationPercentMessage = "";
        derivedMerchantRecommendationTotalMessage = "";
        derivedOptionEndRedemptionAt = null;
        incentivePromotionType = "";
        incentivePromoCode = "";
        incentiveShortMessage = "";
        incentiveLongMessage = "";
        incentiveExpiryDate = null;
        derivedIsGLiveDeal = false;
        firstOptionTitle = "";
        isConnectedMarketPlaceDeal = false;
        connectedMarketPlaceDisplayText = "";
        derivedImageUrl = "";
    }

    public HashSet getChannelList()
    {
        if (channelList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (channelList == null)
        {
            channelList = new HashSet();
            Channel channel;
            for (Iterator iterator = channels.iterator(); iterator.hasNext(); channelList.add(channel))
            {
                channel = Channel.safeValueOf((String)iterator.next());
            }

        }
        break MISSING_BLOCK_LABEL_74;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
_L2:
        return channelList;
    }

    public String getDealStatus()
    {
        boolean flag1 = false;
        boolean flag2 = Strings.equalsIgnoreCase("closed", status);
        boolean flag;
        if (endRedemptionAt != null && (new Date()).after(endRedemptionAt))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag2 || flag)
        {
            flag1 = true;
        }
        if (flag1)
        {
            return "expired";
        }
        if (isSoldOut)
        {
            return "sold_out";
        } else
        {
            return "available";
        }
    }

    public boolean getDisplayOption(String s, boolean flag)
    {
        s = (Boolean)displayOptions.get(s);
        if (s == null)
        {
            return flag;
        } else
        {
            return s.booleanValue();
        }
    }

    public ImageUrl getImageUrl()
    {
        if (Strings.notEmpty(derivedImageUrl))
        {
            return new ImageUrl(derivedImageUrl, true);
        } else
        {
            return new ImageUrl(largeImageUrl);
        }
    }

    public int getPosition()
    {
        return derivedActualPosition;
    }

    public int getTrackingPosition()
    {
        return derivedTrackingPosition;
    }

    public int optionDimensionsCount(boolean flag, boolean flag1)
    {
        boolean flag2 = true;
        String s;
        Iterator iterator;
        if (flag1)
        {
            s = Channel.GOODS.name();
        } else
        {
            s = Channel.SHOPPING.name();
        }
        iterator = channels.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (Strings.equalsIgnoreCase((String)iterator.next(), s))
            {
                flag2 = false;
            }
        } while (true);
        if (flag2 && flag)
        {
            return -1;
        } else
        {
            return optionDimensionsCount;
        }
    }
}
