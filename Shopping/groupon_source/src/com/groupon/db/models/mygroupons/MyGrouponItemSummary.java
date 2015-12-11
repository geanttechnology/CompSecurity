// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models.mygroupons;

import com.groupon.db.models.Location;
import com.groupon.db.models.Shipment;
import com.groupon.util.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.groupon.db.models.mygroupons:
//            AbstractMyGrouponItem, MyGrouponItem

public class MyGrouponItemSummary extends AbstractMyGrouponItem
{

    public String category;
    public String remoteId;
    public String shipmentsListTrackUrl;

    public MyGrouponItemSummary()
    {
    }

    public MyGrouponItemSummary(MyGrouponItem mygrouponitem)
    {
        uuid = mygrouponitem.uuid;
        isSelectable = mygrouponitem.isSelectable;
        dealTimezoneOffsetInSeconds = mygrouponitem.dealTimezoneOffsetInSeconds;
        hotelTimezoneIdentifier = mygrouponitem.hotelTimezoneIdentifier;
        timezoneIdentifier = mygrouponitem.timezoneIdentifier;
        statusMessage = mygrouponitem.statusMessage;
        purchaseStatusMarketRate = mygrouponitem.purchaseStatusMarketRate;
        customerRedeemedAt = mygrouponitem.customerRedeemedAt;
        voucherReleaseAt = mygrouponitem.voucherReleaseAt;
        timezoneOffsetInSeconds = mygrouponitem.timezoneOffsetInSeconds;
        localBookingInfoStatus = mygrouponitem.localBookingInfoStatus;
        hotelName = mygrouponitem.hotelName;
        availability = mygrouponitem.availability;
        expiresAt = mygrouponitem.expiresAt;
        instructions = mygrouponitem.instructions;
        name = mygrouponitem.name;
        redemptionCode = mygrouponitem.redemptionCode;
        verificationCode = mygrouponitem.verificationCode;
        title = mygrouponitem.title;
        subTitle = mygrouponitem.subTitle;
        checkInDate = mygrouponitem.checkInDate;
        checkOutDate = mygrouponitem.checkOutDate;
        purchaseDate = mygrouponitem.purchaseDate;
        purchasedAt = mygrouponitem.purchasedAt;
        purchaseStatus = mygrouponitem.purchaseStatus;
        status = mygrouponitem.status;
        credit = mygrouponitem.credit;
        remoteId = mygrouponitem.remoteId;
        dealId = mygrouponitem.dealId;
        dealOptionId = mygrouponitem.dealOptionId;
        merchantId = mygrouponitem.merchantId;
        reservationId = mygrouponitem.reservationId;
        url = mygrouponitem.url;
        largeImageUrl = mygrouponitem.largeImageUrl;
        sidebarImageUrl = mygrouponitem.sidebarImageUrl;
        timezone = mygrouponitem.timezone;
        bookingType = mygrouponitem.bookingType;
        bookable = mygrouponitem.bookable;
        isRewardDeal = mygrouponitem.isRewardDeal;
        isMarketRate = mygrouponitem.isMarketRate;
        hasRetainedValue = mygrouponitem.hasRetainedValue;
        isMerchantRedeemed = mygrouponitem.isMerchantRedeemed;
        isCustomerRedeemed = mygrouponitem.isCustomerRedeemed;
        located = mygrouponitem.located;
        isGift = mygrouponitem.isGift;
        isGiftClaimed = mygrouponitem.isGiftClaimed;
        category = mygrouponitem.category;
        giftFromName = mygrouponitem.giftFromName;
        giftRecipientName = mygrouponitem.giftRecipientName;
        giftRecipientEmail = mygrouponitem.giftRecipientEmail;
        hasTrackableShipments = mygrouponitem.hasTrackableShipments;
        orderId = mygrouponitem.orderId;
        if (!mygrouponitem.getShipments().isEmpty())
        {
            shipmentsListTrackUrl = ((Shipment)mygrouponitem.getShipments().get(0)).trackingUrl;
        }
        derivedRedemptionLocations = new ArrayList();
        Location location;
        for (mygrouponitem = mygrouponitem.getRedemptionLocations().iterator(); mygrouponitem.hasNext(); derivedRedemptionLocations.add(new GeoPoint(location)))
        {
            location = (Location)mygrouponitem.next();
        }

    }
}
