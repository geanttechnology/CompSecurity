// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models.mygroupons;

import java.util.ArrayList;
import java.util.Date;
import roboguice.util.Strings;

public class AbstractMyGrouponItem
{

    public static final String AVAILABILITY_AVAILABLE = "available";
    public static final String AVAILABILITY_EXPIRED = "expired";
    public static final String AVAILABILITY_PENDING = "pending";
    public static final String AVAILABILITY_PURCHASED = "purchased";
    public static final String AVAILABILITY_REDEEMED = "redeemed";
    public static final String AVAILABILITY_REFUNDED = "refunded";
    public static final String AVAILABILITY_REFUND_PENDING = "refund_pending";
    public static final String GROUPON_ITEM_INTERNAL_ID = "groupon_item_internal_id";
    public static final String STATUS_FAILED = "failed";
    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_SUCCEEDED = "succeeded";
    public String availability;
    public boolean bookable;
    public String bookingType;
    public Date checkInDate;
    public Date checkOutDate;
    public String credit;
    public Date customerRedeemedAt;
    public String dealId;
    public String dealOptionId;
    public int dealTimezoneOffsetInSeconds;
    public ArrayList derivedRedemptionLocations;
    public Date expiresAt;
    public String giftFromName;
    public String giftRecipientEmail;
    public String giftRecipientName;
    public boolean hasRetainedValue;
    public boolean hasTrackableShipments;
    public String hotelName;
    public String hotelTimezoneIdentifier;
    public String instructions;
    public boolean isCustomerRedeemed;
    public boolean isGift;
    public boolean isGiftClaimed;
    public boolean isMarketRate;
    public boolean isMerchantRedeemed;
    public boolean isRewardDeal;
    public boolean isSelectable;
    public String largeImageUrl;
    public String localBookingInfoStatus;
    public boolean located;
    public String merchantId;
    public Date modificationDate;
    public String name;
    public String orderId;
    public Long primaryKey;
    public Date purchaseDate;
    public String purchaseStatus;
    public String purchaseStatusMarketRate;
    public Date purchasedAt;
    public String redemptionCode;
    public String reservationId;
    public String sidebarImageUrl;
    public String status;
    public String statusMessage;
    public String subTitle;
    public String timezone;
    public String timezoneIdentifier;
    public int timezoneOffsetInSeconds;
    public String title;
    public String url;
    public String uuid;
    public String verificationCode;
    public Date voucherReleaseAt;

    public AbstractMyGrouponItem()
    {
        uuid = "";
        availability = "";
        expiresAt = null;
        verificationCode = "";
        redemptionCode = "";
        customerRedeemedAt = null;
        purchaseStatus = "";
        purchasedAt = null;
        voucherReleaseAt = null;
        isMarketRate = false;
        isCustomerRedeemed = false;
        isMerchantRedeemed = false;
        hasRetainedValue = false;
        located = false;
        giftFromName = "";
        giftRecipientName = "";
        giftRecipientEmail = "";
        isGift = false;
        isGiftClaimed = false;
        hasTrackableShipments = false;
        isSelectable = true;
        title = "";
        subTitle = "";
        url = "";
        name = "";
        instructions = "";
        sidebarImageUrl = "";
        largeImageUrl = "";
        checkInDate = null;
        checkOutDate = null;
        localBookingInfoStatus = "";
        purchaseStatusMarketRate = "";
        purchaseDate = null;
        statusMessage = "";
        status = "";
        credit = "";
        dealId = "";
        dealOptionId = "";
        merchantId = "";
        reservationId = "";
        hotelName = "";
        hotelTimezoneIdentifier = "";
        timezoneIdentifier = "";
        timezone = "";
        bookingType = "";
        bookable = false;
        isRewardDeal = false;
        dealTimezoneOffsetInSeconds = 0;
        timezoneOffsetInSeconds = 0;
        orderId = "";
        derivedRedemptionLocations = new ArrayList();
    }

    public boolean isReceivedGift()
    {
        return Strings.notEmpty(giftFromName) && Strings.isEmpty(giftRecipientName);
    }

    public boolean isSentGift()
    {
        return Strings.isEmpty(giftFromName) && Strings.notEmpty(giftRecipientName);
    }
}
