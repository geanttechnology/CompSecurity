// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.Intent;
import android.content.res.Resources;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.OrderShippingInfo;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.inventory.LocationDetails;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.Item;
import com.ebay.mobile.activities.AfterSalesWebViewActivity;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.EbnOrderDetailsActivity;
import com.ebay.mobile.activities.OrderSummaryActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.bestoffer.SellerReviewOffersActivity;
import com.ebay.mobile.sell.shippinglabel.ShippingLabelActivity;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ItemViewBaseActivity;
import com.ebay.mobile.viewitem.ItemViewLeaveFeedbackActivity;
import com.ebay.mobile.viewitem.ItemViewShipmentTrackingDetails;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.ArrayList;
import java.util.Date;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment, ViewItemFragmentBiddingUtil, ViewItemFragmentSellerUtil, 
//            ViewItemFragmentUtil, ViewItemFragmentPaymentUtil, ViewItemFragmentBestOfferUtil

public static abstract class <init> extends Enum
{

    private static final BUY_ANOTHER $VALUES[];
    public static final BUY_ANOTHER ADD_TRACKING_DETAILS;
    public static final BUY_ANOTHER AFTER_SALES;
    public static final BUY_ANOTHER BID_THIS_AMOUNT;
    public static final BUY_ANOTHER BUY_ANOTHER;
    public static final BUY_ANOTHER CANCEL;
    public static final BUY_ANOTHER CONTACT_USER;
    public static final BUY_ANOTHER EBAY_NOW_ORDER_DETAILS;
    public static final BUY_ANOTHER END_LISTING;
    public static final BUY_ANOTHER INCREASE_MAX_BID;
    public static final BUY_ANOTHER IN_STORE_PICKUP_ORDER_DETAILS;
    public static final BUY_ANOTHER LEAVE_FEEDBACK;
    public static final BUY_ANOTHER MAKE_OFFER;
    public static final BUY_ANOTHER MARK_AS_PAID;
    public static final BUY_ANOTHER MARK_AS_SHIPPED;
    public static final BUY_ANOTHER MARK_AS_UNPAID;
    public static final BUY_ANOTHER MARK_AS_UNSHIPPED;
    public static final BUY_ANOTHER MORE_OPTIONS;
    public static final BUY_ANOTHER PAYMENT_OPTIONS;
    public static final BUY_ANOTHER PAY_NOW;
    public static final BUY_ANOTHER PRINT_SHIPPING_LABEL;
    public static final BUY_ANOTHER RELIST_ITEM;
    public static final BUY_ANOTHER REVIEW_OFFER;
    public static final BUY_ANOTHER REVISE_LISTING;
    public static final BUY_ANOTHER SELLERS_OTHER_ITEMS;
    public static final BUY_ANOTHER SELL_ONE_LIKE_THIS;
    public static final BUY_ANOTHER SELL_SIMILAR;
    public static final BUY_ANOTHER SEND_REMINDER;
    public static final BUY_ANOTHER SET_AUTO_BID;
    public static final BUY_ANOTHER SHOW_RELISTED_ITEM;
    public static final BUY_ANOTHER TRACK_PACKAGE;
    public static final BUY_ANOTHER VIEW_OFFERS;

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/ebay/mobile/viewitem/fragments/ActionsFactory$Action, s);
    }

    public static <init>[] values()
    {
        return (<init>[])$VALUES.clone();
    }

    public void execute(ActionsFactory actionsfactory)
    {
        execute(actionsfactory, null);
    }

    public abstract void execute(ActionsFactory actionsfactory, Object obj);

    static 
    {
        INCREASE_MAX_BID = new ActionsFactory.Action("INCREASE_MAX_BID", 0) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                obj = new TrackingData("VIewItemIncreaseBidTap", TrackingType.EVENT);
                if (actionsfactory.fragment.item != null)
                {
                    ((TrackingData) (obj)).addKeyValuePair("itm", actionsfactory.fragment.item.getIdString());
                }
                ((TrackingData) (obj)).send(actionsfactory.fragment.getActivity());
                ViewItemFragmentBiddingUtil.placeBidAmount(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), ActionsFactory.access$100(actionsfactory), null, 105, null, null);
            }

        };
        BID_THIS_AMOUNT = new ActionsFactory.Action("BID_THIS_AMOUNT", 1) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                ViewItemFragmentBiddingUtil.placeBid(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), ActionsFactory.access$100(actionsfactory), null, 106, null, null);
            }

        };
        SET_AUTO_BID = new ActionsFactory.Action("SET_AUTO_BID", 2) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).append(" with value: ").append(obj).toString());
                }
                obj = (Double)obj;
                if (Item.isValidBid(ActionsFactory.access$1900(actionsfactory), ((Double) (obj)).doubleValue()))
                {
                    obj = new ItemCurrency(ActionsFactory.access$1900(actionsfactory).minimumToBid.lowerBound.getCurrencyCode(), Double.toString(((Double) (obj)).doubleValue()));
                    ViewItemFragmentBiddingUtil.placeBid(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), ActionsFactory.access$100(actionsfactory), ((ItemCurrency) (obj)), 106, null, null);
                    return;
                } else
                {
                    ViewItemFragmentBiddingUtil.placeBidAmount(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), ActionsFactory.access$100(actionsfactory), ((Double) (obj)), 105, null, null);
                    return;
                }
            }

        };
        PAY_NOW = new ActionsFactory.Action("PAY_NOW", 3) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                ViewItemFragmentPaymentUtil.payForItems(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), ActionsFactory.access$100(actionsfactory), 1, Boolean.valueOf(false), 107, null, null);
            }

        };
        PAYMENT_OPTIONS = new ActionsFactory.Action("PAYMENT_OPTIONS", 4) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                actionsfactory.fragment.handlePaymentOptions();
            }

        };
        MAKE_OFFER = new ActionsFactory.Action("MAKE_OFFER", 5) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).append(" with value: ").append(obj).toString());
                }
                ViewItemFragmentBestOfferUtil.makeBestOffer(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), ActionsFactory.access$100(actionsfactory), (Double)obj, 102, null, null);
            }

        };
        REVIEW_OFFER = new ActionsFactory.Action("REVIEW_OFFER", 6) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                byte byte0 = 103;
                if (ActionsFactory.access$1900(actionsfactory).isSeller)
                {
                    byte0 = 104;
                }
                ViewItemFragmentBestOfferUtil.reviewOffer(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), ActionsFactory.access$100(actionsfactory), ActionsFactory.access$1900(actionsfactory).isSeller, byte0, null, null);
            }

        };
        VIEW_OFFERS = new ActionsFactory.Action("VIEW_OFFERS", 7) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                SellerReviewOffersActivity.StartActivity(actionsfactory.fragment.getActivity(), ActionsFactory.access$100(actionsfactory), 112);
            }

        };
        CONTACT_USER = new ActionsFactory.Action("CONTACT_USER", 8) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                ViewItemFragmentUtil.contactUser(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), ActionsFactory.access$100(actionsfactory), 0);
            }

        };
        LEAVE_FEEDBACK = new ActionsFactory.Action("LEAVE_FEEDBACK", 9) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                ItemViewLeaveFeedbackActivity.StartActivity(actionsfactory.fragment.getActivity(), ActionsFactory.access$100(actionsfactory), 0);
            }

        };
        REVISE_LISTING = new ActionsFactory.Action("REVISE_LISTING", 10) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                ViewItemFragmentSellerUtil.reviseListing(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), 108);
            }

        };
        END_LISTING = new ActionsFactory.Action("END_LISTING", 11) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                ViewItemFragmentSellerUtil.endListing(actionsfactory.fragment, ActionsFactory.access$1800(actionsfactory), ActionsFactory.access$1900(actionsfactory));
            }

        };
        RELIST_ITEM = new ActionsFactory.Action("RELIST_ITEM", 12) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                ViewItemFragmentSellerUtil.relistItem(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), 109);
            }

        };
        SEND_REMINDER = new ActionsFactory.Action("SEND_REMINDER", 13) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                ViewItemFragmentSellerUtil.sendPaymentReminder(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory));
            }

        };
        MARK_AS_PAID = new ActionsFactory.Action("MARK_AS_PAID", 14) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                obj = actionsfactory.fragment.getResources();
                ViewItemFragmentUtil.showDialog(actionsfactory.fragment, ((Resources) (obj)).getString(0x7f070600), null, ((Resources) (obj)).getString(0x7f070738), ((Resources) (obj)).getString(0x7f0701cc), 0);
            }

        };
        MARK_AS_SHIPPED = new ActionsFactory.Action("MARK_AS_SHIPPED", 15) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                obj = actionsfactory.fragment.getResources();
                ViewItemFragmentUtil.showDialog(actionsfactory.fragment, ((Resources) (obj)).getString(0x7f070603), null, ((Resources) (obj)).getString(0x7f070738), ((Resources) (obj)).getString(0x7f0701cc), 1);
            }

        };
        MARK_AS_UNPAID = new ActionsFactory.Action("MARK_AS_UNPAID", 16) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                obj = actionsfactory.fragment.getResources();
                ViewItemFragmentUtil.showDialog(actionsfactory.fragment, ((Resources) (obj)).getString(0x7f070601), null, ((Resources) (obj)).getString(0x7f070738), ((Resources) (obj)).getString(0x7f0701cc), 2);
            }

        };
        MARK_AS_UNSHIPPED = new ActionsFactory.Action("MARK_AS_UNSHIPPED", 17) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                obj = actionsfactory.fragment.getResources();
                ViewItemFragmentUtil.showDialog(actionsfactory.fragment, ((Resources) (obj)).getString(0x7f070602), null, ((Resources) (obj)).getString(0x7f070738), ((Resources) (obj)).getString(0x7f0701cc), 3);
            }

        };
        ADD_TRACKING_DETAILS = new ActionsFactory.Action("ADD_TRACKING_DETAILS", 18) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                ViewItemFragmentSellerUtil.addShipmentTrackingDetails(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), 110);
            }

        };
        SHOW_RELISTED_ITEM = new ActionsFactory.Action("SHOW_RELISTED_ITEM", 19) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                ViewItemFragmentUtil.showRelistedItem(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory));
            }

        };
        EBAY_NOW_ORDER_DETAILS = new ActionsFactory.Action("EBAY_NOW_ORDER_DETAILS", 20) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                EbnOrderDetailsActivity.StartActivity(actionsfactory.fragment.getActivity(), ActionsFactory.access$100(actionsfactory), new SourceIdentification(((BaseActivity)actionsfactory.fragment.getActivity()).getTrackingEventName()));
            }

        };
        IN_STORE_PICKUP_ORDER_DETAILS = new ActionsFactory.Action("IN_STORE_PICKUP_ORDER_DETAILS", 21) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                Item item = ActionsFactory.access$1900(actionsfactory);
                BaseActivity baseactivity = (BaseActivity)actionsfactory.fragment.getActivity();
                Intent intent = new Intent(baseactivity, com/ebay/mobile/activities/OrderSummaryActivity);
                intent.putExtra("order_id", item.orderId);
                intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(baseactivity.getTrackingEventName()));
                obj = null;
                actionsfactory = ((ActionsFactory) (obj));
                if (item.iTransaction.orderShippingInfo != null)
                {
                    actionsfactory = ((ActionsFactory) (obj));
                    if (item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate != null)
                    {
                        actionsfactory = item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate;
                    }
                }
                if (actionsfactory != null)
                {
                    intent.putExtra("est_delivery_date", actionsfactory.getTime());
                }
                if (item.inventoryInfo != null)
                {
                    actionsfactory = item.inventoryInfo.getSelectedStore();
                    if (actionsfactory != null)
                    {
                        obj = new LocationDetails();
                        obj.name = ((StoreAvailability) (actionsfactory)).name;
                        obj.address = ((StoreAvailability) (actionsfactory)).address;
                        obj.pickupInstructions = ((StoreAvailability) (actionsfactory)).pickupInstructions;
                        obj.hours = ((StoreAvailability) (actionsfactory)).hours;
                        obj.utcHours = ((StoreAvailability) (actionsfactory)).utcHours;
                        obj.phone = ((StoreAvailability) (actionsfactory)).phone;
                        obj.url = ((StoreAvailability) (actionsfactory)).url;
                        obj.utcOffset = ((StoreAvailability) (actionsfactory)).utcOffset;
                        intent.putExtra("store_details", ((android.os.Parcelable) (obj)));
                        int i;
                        if (item.iTransaction.orderShippingInfo == null)
                        {
                            i = 0;
                        } else
                        {
                            i = ActionsFactory.access$1700(item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate);
                        }
                        intent.putExtra("hours_offset", i);
                    }
                }
                intent.setFlags(0x4000000);
                baseactivity.startActivity(intent);
            }

        };
        SELL_SIMILAR = new ActionsFactory.Action("SELL_SIMILAR", 22) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                ViewItemFragmentSellerUtil.sellSimilar(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), 111);
            }

        };
        SELL_ONE_LIKE_THIS = new ActionsFactory.Action("SELL_ONE_LIKE_THIS", 23) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                ViewItemFragmentUtil.sellOneLikeThis(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory));
            }

        };
        SELLERS_OTHER_ITEMS = new ActionsFactory.Action("SELLERS_OTHER_ITEMS", 24) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                ActivityStarter.startSellerItemsSearchResultList(actionsfactory.fragment.getBaseActivity(), ActionsFactory.access$1900(actionsfactory).sellerUserId, ActionsFactory.access$100(actionsfactory).searchOtherCountries, null);
            }

        };
        TRACK_PACKAGE = new ActionsFactory.Action("TRACK_PACKAGE", 25) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                ItemViewShipmentTrackingDetails.StartActivity(actionsfactory.fragment.getActivity(), ActionsFactory.access$100(actionsfactory), null, 0);
            }

        };
        PRINT_SHIPPING_LABEL = new ActionsFactory.Action("PRINT_SHIPPING_LABEL", 26) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                obj = actionsfactory.fragment.getActivity();
                if (!Util.hasNetwork() && obj != null && (obj instanceof ItemViewBaseActivity))
                {
                    actionsfactory = (ItemViewBaseActivity)obj;
                    actionsfactory.showButterBarMessage(0, actionsfactory.getNetworkErrorToastString(), false);
                    return;
                }
                obj = actionsfactory.fragment;
                long l = ActionsFactory.access$1900(actionsfactory).id;
                long l1 = ActionsFactory.access$1900(actionsfactory).transactionId.longValue();
                if (ActionsFactory.access$1900(actionsfactory).pictureUrls != null && !ActionsFactory.access$1900(actionsfactory).pictureUrls.isEmpty())
                {
                    actionsfactory = (String)ActionsFactory.access$1900(actionsfactory).pictureUrls.get(0);
                } else
                {
                    actionsfactory = null;
                }
                ShippingLabelActivity.startActivity(((android.app.Fragment) (obj)), l, l1, actionsfactory);
            }

        };
        AFTER_SALES = new ActionsFactory.Action("AFTER_SALES", 27) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                AfterSalesWebViewActivity.startActivity(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), ActionsFactory.access$2100(ActionsFactory.access$1900(actionsfactory)));
            }

        };
        CANCEL = new ActionsFactory.Action("CANCEL", 28) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                AfterSalesWebViewActivity.startActivity(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.CANCEL_ENTRY);
            }

        };
        MORE_OPTIONS = new ActionsFactory.Action("MORE_OPTIONS", 29) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                AfterSalesWebViewActivity.startActivity(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.NOT_APPLICABLE);
            }

        };
        BUY_ANOTHER = new ActionsFactory.Action("BUY_ANOTHER", 30) {

            public void execute(ActionsFactory actionsfactory, Object obj)
            {
                if (ViewItemActionsFragment.verboseLogger.isLoggable)
                {
                    ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                }
                if (actionsfactory.fragment.getActivity() instanceof ItemViewActivity)
                {
                    ((ItemViewActivity)actionsfactory.fragment.getActivity()).doBuyAnother();
                }
            }

        };
        $VALUES = (new .VALUES[] {
            INCREASE_MAX_BID, BID_THIS_AMOUNT, SET_AUTO_BID, PAY_NOW, PAYMENT_OPTIONS, MAKE_OFFER, REVIEW_OFFER, VIEW_OFFERS, CONTACT_USER, LEAVE_FEEDBACK, 
            REVISE_LISTING, END_LISTING, RELIST_ITEM, SEND_REMINDER, MARK_AS_PAID, MARK_AS_SHIPPED, MARK_AS_UNPAID, MARK_AS_UNSHIPPED, ADD_TRACKING_DETAILS, SHOW_RELISTED_ITEM, 
            EBAY_NOW_ORDER_DETAILS, IN_STORE_PICKUP_ORDER_DETAILS, SELL_SIMILAR, SELL_ONE_LIKE_THIS, SELLERS_OTHER_ITEMS, TRACK_PACKAGE, PRINT_SHIPPING_LABEL, AFTER_SALES, CANCEL, MORE_OPTIONS, 
            BUY_ANOTHER
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }

    _cls9(String s, int i, _cls9 _pcls9)
    {
        this(s, i);
    }
}
