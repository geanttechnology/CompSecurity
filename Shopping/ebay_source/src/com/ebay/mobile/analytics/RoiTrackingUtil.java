// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;

import android.app.Activity;
import android.text.TextUtils;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.ItemCurrency;

// Referenced classes of package com.ebay.mobile.analytics:
//            TrackingType

public final class RoiTrackingUtil
{
    public static final class RoiItemData
    {

        public static String NO_TRANSACTION_ID = "0";
        private final String iafToken;
        private final String itemId;
        private final ItemCurrency orderTotal;
        private final String primaryCategoryId;
        private final String quantity;
        private final String secondaryCategoryId;
        private final String sellerName;
        private final String uniqueTransactionId;

        final void add(TrackingData trackingdata)
        {
            trackingdata.addKeyValuePair("iafToken", iafToken);
            trackingdata.addKeyValuePair("sellerName", sellerName);
            trackingdata.addKeyValuePair("itm", itemId);
            trackingdata.addKeyValuePair("bti", uniqueTransactionId);
            trackingdata.addKeyValuePair("quan", quantity);
            if (!ItemCurrency.isEmpty(orderTotal))
            {
                trackingdata.addKeyValuePair("orderTotal.currencyId", orderTotal.code);
                trackingdata.addKeyValuePair("orderTotal.amount", orderTotal.value);
            }
            trackingdata.addKeyValuePair("leaf", primaryCategoryId);
            trackingdata.addKeyValuePair("secondaryCategoryId", secondaryCategoryId);
        }

        protected void verifyRequired()
        {
            if (TextUtils.isEmpty(iafToken))
            {
                throw new NullPointerException("iafToken");
            }
            if (TextUtils.isEmpty(sellerName))
            {
                throw new NullPointerException("sellerName");
            }
            if (TextUtils.isEmpty(itemId))
            {
                throw new NullPointerException("itemId");
            }
            if (TextUtils.isEmpty(quantity))
            {
                throw new NullPointerException("quantity");
            }
            if (TextUtils.isEmpty(primaryCategoryId))
            {
                throw new NullPointerException("primaryCategoryId");
            } else
            {
                return;
            }
        }


        public RoiItemData(String s, String s1, String s2, String s3, ItemCurrency itemcurrency, String s4, String s5)
        {
            iafToken = s;
            sellerName = s1;
            itemId = s2;
            uniqueTransactionId = NO_TRANSACTION_ID;
            quantity = s3;
            orderTotal = itemcurrency;
            primaryCategoryId = s4;
            secondaryCategoryId = s5;
            verifyRequired();
        }

        public RoiItemData(String s, String s1, String s2, String s3, String s4, ItemCurrency itemcurrency, String s5, 
                String s6)
        {
            iafToken = s;
            sellerName = s1;
            itemId = s2;
            uniqueTransactionId = s3;
            quantity = s4;
            orderTotal = itemcurrency;
            primaryCategoryId = s5;
            secondaryCategoryId = s6;
            verifyRequired();
            if (TextUtils.isEmpty(s3))
            {
                throw new NullPointerException("uniqueTransactionId");
            } else
            {
                return;
            }
        }
    }


    public static final String ORDER_TOTAL_CURRENCY_CODE = "orderTotal.currencyId";
    public static final String ORDER_TOTAL_CURRENCY_VALUE = "orderTotal.amount";
    private static final String ROI_EVENT = "ROIEvent";
    public static final String ROI_TRANSACTION_TYPE = "roiTransactionType";
    public static final String ROI_TRANSACTION_TYPE_BID = "BID-MobileApp";
    public static final String ROI_TRANSACTION_TYPE_BIN = "BIN-MobileApp";
    public static final String ROI_TRANSACTION_TYPE_BO = "BO-MobileApp";
    public static final String ROI_TRANSACTION_TYPE_REG = "Reg-MobileApp";
    public static final String ROI_TRANSACTION_TYPE_REGSELL = "RegSell-MobileApp";
    public static final String ROI_TRANSACTION_TYPE_SELL = "Sell-MobileApp";
    public static final String SECONDARY_CATEGORY_ID = "secondaryCategoryId";
    public static final String SELLER_NAME = "sellerName";
    public static final String USER_NAME = "userName";

    private RoiTrackingUtil()
    {
    }

    public static void trackRoi(Activity activity, String s, EbaySite ebaysite, RoiItemData roiitemdata)
    {
        trackRoi(new com.ebay.mobile.analytics.model.TrackingData.SendHelper(activity), s, ebaysite, null, roiitemdata);
    }

    public static void trackRoi(Activity activity, String s, EbaySite ebaysite, String s1)
    {
        trackRoi(new com.ebay.mobile.analytics.model.TrackingData.SendHelper(activity), s, ebaysite, s1, null);
    }

    public static void trackRoi(com.ebay.mobile.analytics.model.TrackingData.SendHelper sendhelper, String s, EbaySite ebaysite, String s1, RoiItemData roiitemdata)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new NullPointerException("transactionType");
        }
        if (ebaysite == null)
        {
            throw new NullPointerException("site");
        }
        if (s1 == null && roiitemdata == null)
        {
            throw new NullPointerException("userId or itemData");
        }
        TrackingData trackingdata = new TrackingData("ROIEvent", TrackingType.ROI);
        trackingdata.addKeyValuePair("roiTransactionType", s);
        trackingdata.addKeyValuePair("shipsiteid", ebaysite.id);
        trackingdata.addKeyValuePair("userName", s1);
        if (roiitemdata != null)
        {
            roiitemdata.add(trackingdata);
        }
        sendhelper.send(trackingdata);
    }
}
