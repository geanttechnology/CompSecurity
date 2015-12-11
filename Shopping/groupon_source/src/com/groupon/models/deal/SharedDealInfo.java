// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.deal;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.Channel;
import com.groupon.models.support.ParcelableCreator;
import com.groupon.util.ImageUrl;
import java.util.Date;
import java.util.HashSet;

public class SharedDealInfo
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ParcelableCreator(com/groupon/models/deal/SharedDealInfo);
    public String announcementTitle;
    public String areaName;
    public Channel channel;
    public Channel channels[];
    public int dealImageHeight;
    public int dealImageWidth;
    public String defaultOptionId;
    public int derivedDiscountPercent;
    public boolean derivedHasBookableOrSchedulableOptions;
    public boolean derivedHasHasExternalUrl;
    public String derivedLocationCity;
    public String derivedLocationName;
    public String derivedLocationNeighborhood;
    public String derivedMerchantName;
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
    public int derivedRegularPriceAmount;
    public String derivedRegularPriceCurrencyCode;
    public String derivedRegularPriceFormattedAmount;
    public int derivedValueAmount;
    public String derivedValueCurrencyCode;
    public String derivedValueFormattedAmount;
    public boolean displayBought;
    public boolean displayDiscount;
    public boolean displayMobileOnly;
    public boolean displayTimer;
    public String divisionName;
    public Date endAt;
    public Date endRedemptionAt;
    public double grouponRating;
    public boolean hasImagesForOptions;
    public Date incentiveExpiryDate;
    public String incentivePromoCode;
    public String incentiveShortMessage;
    public boolean isSoldOut;
    public boolean isTravelBookableDeal;
    public ImageUrl largeImageUrl;
    public int optionDimensionsCount;
    public int optionLocationCount;
    public String optionTitle;
    public String remoteId;
    public HashSet secondLevelDealCategories;
    public String sidebarImageUrl;
    public int soldQuantity;
    public String soldQuantityMessage;
    public String status;
    public String title;
    public String uuid;

    public SharedDealInfo()
    {
    }

    public SharedDealInfo(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        channel = (Channel)parcel.readParcelable(com/groupon/Channel.getClassLoader());
        remoteId = parcel.readString();
        title = parcel.readString();
        optionTitle = parcel.readString();
        announcementTitle = parcel.readString();
        largeImageUrl = (ImageUrl)parcel.readParcelable(com/groupon/util/ImageUrl.getClassLoader());
        soldQuantityMessage = parcel.readString();
        endAt = (Date)parcel.readSerializable();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isSoldOut = flag;
        status = parcel.readString();
        soldQuantity = parcel.readInt();
        areaName = parcel.readString();
        uuid = parcel.readString();
        divisionName = parcel.readString();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        displayTimer = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        displayBought = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        displayDiscount = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        displayMobileOnly = flag;
        derivedMinimumPurchaseQuantity = parcel.readInt();
        derivedDiscountPercent = parcel.readInt();
        optionLocationCount = parcel.readInt();
        derivedLocationName = parcel.readString();
        derivedLocationNeighborhood = parcel.readString();
        derivedLocationCity = parcel.readString();
        derivedValueAmount = parcel.readInt();
        derivedValueFormattedAmount = parcel.readString();
        derivedValueCurrencyCode = parcel.readString();
        derivedRegularPriceAmount = parcel.readInt();
        derivedRegularPriceFormattedAmount = parcel.readString();
        derivedRegularPriceCurrencyCode = parcel.readString();
        derivedPriceAmount = parcel.readInt();
        derivedPriceFormattedAmount = parcel.readString();
        derivedPriceCurrencyCode = parcel.readString();
        derivedPricingMetadataOfferLabelDescriptive = parcel.readString();
        derivedPricingMetadataOfferLabel = parcel.readString();
        derivedPricingMetadataOfferBeginsAt = (Date)parcel.readSerializable();
        derivedPricingMetadataOfferEndsAt = (Date)parcel.readSerializable();
        derivedPricingMetadataOfferType = parcel.readString();
        optionDimensionsCount = parcel.readInt();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasImagesForOptions = flag;
        defaultOptionId = parcel.readString();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isTravelBookableDeal = flag;
        sidebarImageUrl = parcel.readString();
        derivedMerchantName = parcel.readString();
        grouponRating = parcel.readDouble();
        endRedemptionAt = (Date)parcel.readSerializable();
        derivedOptionEndRedemptionAt = (Date)parcel.readSerializable();
        incentivePromoCode = parcel.readString();
        incentiveShortMessage = parcel.readString();
        incentiveExpiryDate = (Date)parcel.readSerializable();
        dealImageWidth = parcel.readInt();
        dealImageHeight = parcel.readInt();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        derivedHasBookableOrSchedulableOptions = flag;
        derivedOptionsCount = parcel.readInt();
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        derivedHasHasExternalUrl = flag;
        channels = (Channel[])parcel.createTypedArray(Channel.CREATOR);
        secondLevelDealCategories = (HashSet)parcel.readSerializable();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeParcelable(channel, i);
        parcel.writeString(remoteId);
        parcel.writeString(title);
        parcel.writeString(optionTitle);
        parcel.writeString(announcementTitle);
        parcel.writeParcelable(largeImageUrl, i);
        parcel.writeString(soldQuantityMessage);
        parcel.writeSerializable(endAt);
        byte byte0;
        if (isSoldOut)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(status);
        parcel.writeInt(soldQuantity);
        parcel.writeString(areaName);
        parcel.writeString(uuid);
        parcel.writeString(divisionName);
        if (displayTimer)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (displayBought)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (displayDiscount)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (displayMobileOnly)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeInt(derivedMinimumPurchaseQuantity);
        parcel.writeInt(derivedDiscountPercent);
        parcel.writeInt(optionLocationCount);
        parcel.writeString(derivedLocationName);
        parcel.writeString(derivedLocationNeighborhood);
        parcel.writeString(derivedLocationCity);
        parcel.writeInt(derivedValueAmount);
        parcel.writeString(derivedValueFormattedAmount);
        parcel.writeString(derivedValueCurrencyCode);
        parcel.writeInt(derivedRegularPriceAmount);
        parcel.writeString(derivedRegularPriceFormattedAmount);
        parcel.writeString(derivedRegularPriceCurrencyCode);
        parcel.writeInt(derivedPriceAmount);
        parcel.writeString(derivedPriceFormattedAmount);
        parcel.writeString(derivedPriceCurrencyCode);
        parcel.writeString(derivedPricingMetadataOfferLabelDescriptive);
        parcel.writeString(derivedPricingMetadataOfferLabel);
        parcel.writeSerializable(derivedPricingMetadataOfferBeginsAt);
        parcel.writeSerializable(derivedPricingMetadataOfferEndsAt);
        parcel.writeString(derivedPricingMetadataOfferType);
        parcel.writeInt(optionDimensionsCount);
        if (hasImagesForOptions)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(defaultOptionId);
        if (isTravelBookableDeal)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(sidebarImageUrl);
        parcel.writeString(derivedMerchantName);
        parcel.writeDouble(grouponRating);
        parcel.writeSerializable(endRedemptionAt);
        parcel.writeSerializable(derivedOptionEndRedemptionAt);
        parcel.writeString(incentivePromoCode);
        parcel.writeString(incentiveShortMessage);
        parcel.writeSerializable(incentiveExpiryDate);
        parcel.writeInt(dealImageWidth);
        parcel.writeInt(dealImageHeight);
        if (derivedHasBookableOrSchedulableOptions)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeInt(derivedOptionsCount);
        if (derivedHasHasExternalUrl)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeTypedArray(channels, 0);
        parcel.writeSerializable(secondLevelDealCategories);
    }

}
