// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.AllBiddersData;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.ItemTransactionVariation;
import com.ebay.common.model.OrderShippingInfo;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.inventory.LocationDetails;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.AfterSalesWebViewActivity;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.EbnOrderDetailsActivity;
import com.ebay.mobile.activities.OrderSummaryActivity;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.mobile.activities.UserDetailActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.bestoffer.SellerReviewOffersActivity;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.dcs.DcsString;
import com.ebay.mobile.sell.shippinglabel.ShippingLabelActivity;
import com.ebay.mobile.sell.widget.TextImageButton;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayNowUtil;
import com.ebay.mobile.util.EbayPhoneNumberUtil;
import com.ebay.mobile.util.PickupUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ItemViewBaseActivity;
import com.ebay.mobile.viewitem.ItemViewLeaveFeedbackActivity;
import com.ebay.mobile.viewitem.ItemViewShipmentTrackingDetails;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemShippingInfo;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.BestOffer;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.OrderPickupStatus;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import com.ebay.nautilus.domain.data.ShipmentTrackingScanDetail;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.util.DelimitedStringBuilder;
import com.ebay.nautilus.shell.app.FwActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemActionsFragment, ViewItemFragmentBiddingUtil, ViewItemFragmentSellerUtil, ViewItemFragmentUtil, 
//            ViewItemFragmentPaymentUtil, ViewItemFragmentBestOfferUtil

public class ActionsFactory
{
    public static abstract class Action extends Enum
    {

        private static final Action $VALUES[];
        public static final Action ADD_TRACKING_DETAILS;
        public static final Action AFTER_SALES;
        public static final Action BID_THIS_AMOUNT;
        public static final Action BUY_ANOTHER;
        public static final Action CANCEL;
        public static final Action CONTACT_USER;
        public static final Action EBAY_NOW_ORDER_DETAILS;
        public static final Action END_LISTING;
        public static final Action INCREASE_MAX_BID;
        public static final Action IN_STORE_PICKUP_ORDER_DETAILS;
        public static final Action LEAVE_FEEDBACK;
        public static final Action MAKE_OFFER;
        public static final Action MARK_AS_PAID;
        public static final Action MARK_AS_SHIPPED;
        public static final Action MARK_AS_UNPAID;
        public static final Action MARK_AS_UNSHIPPED;
        public static final Action MORE_OPTIONS;
        public static final Action PAYMENT_OPTIONS;
        public static final Action PAY_NOW;
        public static final Action PRINT_SHIPPING_LABEL;
        public static final Action RELIST_ITEM;
        public static final Action REVIEW_OFFER;
        public static final Action REVISE_LISTING;
        public static final Action SELLERS_OTHER_ITEMS;
        public static final Action SELL_ONE_LIKE_THIS;
        public static final Action SELL_SIMILAR;
        public static final Action SEND_REMINDER;
        public static final Action SET_AUTO_BID;
        public static final Action SHOW_RELISTED_ITEM;
        public static final Action TRACK_PACKAGE;
        public static final Action VIEW_OFFERS;

        public static Action valueOf(String s)
        {
            return (Action)Enum.valueOf(com/ebay/mobile/viewitem/fragments/ActionsFactory$Action, s);
        }

        public static Action[] values()
        {
            return (Action[])$VALUES.clone();
        }

        public void execute(ActionsFactory actionsfactory)
        {
            execute(actionsfactory, null);
        }

        public abstract void execute(ActionsFactory actionsfactory, Object obj);

        static 
        {
            INCREASE_MAX_BID = new Action("INCREASE_MAX_BID", 0) {

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
                    ViewItemFragmentBiddingUtil.placeBidAmount(actionsfactory.fragment, actionsfactory.item, actionsfactory.viewData, null, 105, null, null);
                }

            };
            BID_THIS_AMOUNT = new Action("BID_THIS_AMOUNT", 1) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    ViewItemFragmentBiddingUtil.placeBid(actionsfactory.fragment, actionsfactory.item, actionsfactory.viewData, null, 106, null, null);
                }

            };
            SET_AUTO_BID = new Action("SET_AUTO_BID", 2) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).append(" with value: ").append(obj).toString());
                    }
                    obj = (Double)obj;
                    if (Item.isValidBid(actionsfactory.item, ((Double) (obj)).doubleValue()))
                    {
                        obj = new ItemCurrency(actionsfactory.item.minimumToBid.lowerBound.getCurrencyCode(), Double.toString(((Double) (obj)).doubleValue()));
                        ViewItemFragmentBiddingUtil.placeBid(actionsfactory.fragment, actionsfactory.item, actionsfactory.viewData, ((ItemCurrency) (obj)), 106, null, null);
                        return;
                    } else
                    {
                        ViewItemFragmentBiddingUtil.placeBidAmount(actionsfactory.fragment, actionsfactory.item, actionsfactory.viewData, ((Double) (obj)), 105, null, null);
                        return;
                    }
                }

            };
            PAY_NOW = new Action("PAY_NOW", 3) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    ViewItemFragmentPaymentUtil.payForItems(actionsfactory.fragment, actionsfactory.item, actionsfactory.viewData, 1, Boolean.valueOf(false), 107, null, null);
                }

            };
            PAYMENT_OPTIONS = new Action("PAYMENT_OPTIONS", 4) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    actionsfactory.fragment.handlePaymentOptions();
                }

            };
            MAKE_OFFER = new Action("MAKE_OFFER", 5) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).append(" with value: ").append(obj).toString());
                    }
                    ViewItemFragmentBestOfferUtil.makeBestOffer(actionsfactory.fragment, actionsfactory.item, actionsfactory.viewData, (Double)obj, 102, null, null);
                }

            };
            REVIEW_OFFER = new Action("REVIEW_OFFER", 6) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    byte byte0 = 103;
                    if (actionsfactory.item.isSeller)
                    {
                        byte0 = 104;
                    }
                    ViewItemFragmentBestOfferUtil.reviewOffer(actionsfactory.fragment, actionsfactory.item, actionsfactory.viewData, actionsfactory.item.isSeller, byte0, null, null);
                }

            };
            VIEW_OFFERS = new Action("VIEW_OFFERS", 7) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    SellerReviewOffersActivity.StartActivity(actionsfactory.fragment.getActivity(), actionsfactory.viewData, 112);
                }

            };
            CONTACT_USER = new Action("CONTACT_USER", 8) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    ViewItemFragmentUtil.contactUser(actionsfactory.fragment, actionsfactory.item, actionsfactory.viewData, 0);
                }

            };
            LEAVE_FEEDBACK = new Action("LEAVE_FEEDBACK", 9) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    ItemViewLeaveFeedbackActivity.StartActivity(actionsfactory.fragment.getActivity(), actionsfactory.viewData, 0);
                }

            };
            REVISE_LISTING = new Action("REVISE_LISTING", 10) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    ViewItemFragmentSellerUtil.reviseListing(actionsfactory.fragment, actionsfactory.item, 108);
                }

            };
            END_LISTING = new Action("END_LISTING", 11) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    ViewItemFragmentSellerUtil.endListing(actionsfactory.fragment, actionsfactory.viewItemDataManager, actionsfactory.item);
                }

            };
            RELIST_ITEM = new Action("RELIST_ITEM", 12) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    ViewItemFragmentSellerUtil.relistItem(actionsfactory.fragment, actionsfactory.item, 109);
                }

            };
            SEND_REMINDER = new Action("SEND_REMINDER", 13) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    ViewItemFragmentSellerUtil.sendPaymentReminder(actionsfactory.fragment, actionsfactory.item);
                }

            };
            MARK_AS_PAID = new Action("MARK_AS_PAID", 14) {

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
            MARK_AS_SHIPPED = new Action("MARK_AS_SHIPPED", 15) {

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
            MARK_AS_UNPAID = new Action("MARK_AS_UNPAID", 16) {

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
            MARK_AS_UNSHIPPED = new Action("MARK_AS_UNSHIPPED", 17) {

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
            ADD_TRACKING_DETAILS = new Action("ADD_TRACKING_DETAILS", 18) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    ViewItemFragmentSellerUtil.addShipmentTrackingDetails(actionsfactory.fragment, actionsfactory.item, 110);
                }

            };
            SHOW_RELISTED_ITEM = new Action("SHOW_RELISTED_ITEM", 19) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    ViewItemFragmentUtil.showRelistedItem(actionsfactory.fragment, actionsfactory.item);
                }

            };
            EBAY_NOW_ORDER_DETAILS = new Action("EBAY_NOW_ORDER_DETAILS", 20) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    EbnOrderDetailsActivity.StartActivity(actionsfactory.fragment.getActivity(), actionsfactory.viewData, new SourceIdentification(((BaseActivity)actionsfactory.fragment.getActivity()).getTrackingEventName()));
                }

            };
            IN_STORE_PICKUP_ORDER_DETAILS = new Action("IN_STORE_PICKUP_ORDER_DETAILS", 21) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    Item item1 = actionsfactory.item;
                    BaseActivity baseactivity = (BaseActivity)actionsfactory.fragment.getActivity();
                    Intent intent = new Intent(baseactivity, com/ebay/mobile/activities/OrderSummaryActivity);
                    intent.putExtra("order_id", item1.orderId);
                    intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(baseactivity.getTrackingEventName()));
                    obj = null;
                    actionsfactory = ((ActionsFactory) (obj));
                    if (item1.iTransaction.orderShippingInfo != null)
                    {
                        actionsfactory = ((ActionsFactory) (obj));
                        if (item1.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate != null)
                        {
                            actionsfactory = item1.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate;
                        }
                    }
                    if (actionsfactory != null)
                    {
                        intent.putExtra("est_delivery_date", actionsfactory.getTime());
                    }
                    if (item1.inventoryInfo != null)
                    {
                        actionsfactory = item1.inventoryInfo.getSelectedStore();
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
                            if (item1.iTransaction.orderShippingInfo == null)
                            {
                                i = 0;
                            } else
                            {
                                i = ActionsFactory.daysToOffsetStoreHours(item1.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate);
                            }
                            intent.putExtra("hours_offset", i);
                        }
                    }
                    intent.setFlags(0x4000000);
                    baseactivity.startActivity(intent);
                }

            };
            SELL_SIMILAR = new Action("SELL_SIMILAR", 22) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    ViewItemFragmentSellerUtil.sellSimilar(actionsfactory.fragment, actionsfactory.item, 111);
                }

            };
            SELL_ONE_LIKE_THIS = new Action("SELL_ONE_LIKE_THIS", 23) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    ViewItemFragmentUtil.sellOneLikeThis(actionsfactory.fragment, actionsfactory.item);
                }

            };
            SELLERS_OTHER_ITEMS = new Action("SELLERS_OTHER_ITEMS", 24) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    ActivityStarter.startSellerItemsSearchResultList(actionsfactory.fragment.getBaseActivity(), actionsfactory.item.sellerUserId, actionsfactory.viewData.searchOtherCountries, null);
                }

            };
            TRACK_PACKAGE = new Action("TRACK_PACKAGE", 25) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    if (ViewItemActionsFragment.verboseLogger.isLoggable)
                    {
                        ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("Handled: ").append(toString()).toString());
                    }
                    ItemViewShipmentTrackingDetails.StartActivity(actionsfactory.fragment.getActivity(), actionsfactory.viewData, null, 0);
                }

            };
            PRINT_SHIPPING_LABEL = new Action("PRINT_SHIPPING_LABEL", 26) {

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
                    long l = actionsfactory.item.id;
                    long l1 = actionsfactory.item.transactionId.longValue();
                    if (actionsfactory.item.pictureUrls != null && !actionsfactory.item.pictureUrls.isEmpty())
                    {
                        actionsfactory = (String)actionsfactory.item.pictureUrls.get(0);
                    } else
                    {
                        actionsfactory = null;
                    }
                    ShippingLabelActivity.startActivity(((android.app.Fragment) (obj)), l, l1, actionsfactory);
                }

            };
            AFTER_SALES = new Action("AFTER_SALES", 27) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    AfterSalesWebViewActivity.startActivity(actionsfactory.fragment, actionsfactory.item, ActionsFactory.getAfterSalesType(actionsfactory.item));
                }

            };
            CANCEL = new Action("CANCEL", 28) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    AfterSalesWebViewActivity.startActivity(actionsfactory.fragment, actionsfactory.item, com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.CANCEL_ENTRY);
                }

            };
            MORE_OPTIONS = new Action("MORE_OPTIONS", 29) {

                public void execute(ActionsFactory actionsfactory, Object obj)
                {
                    AfterSalesWebViewActivity.startActivity(actionsfactory.fragment, actionsfactory.item, com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.NOT_APPLICABLE);
                }

            };
            BUY_ANOTHER = new Action("BUY_ANOTHER", 30) {

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
            $VALUES = (new Action[] {
                INCREASE_MAX_BID, BID_THIS_AMOUNT, SET_AUTO_BID, PAY_NOW, PAYMENT_OPTIONS, MAKE_OFFER, REVIEW_OFFER, VIEW_OFFERS, CONTACT_USER, LEAVE_FEEDBACK, 
                REVISE_LISTING, END_LISTING, RELIST_ITEM, SEND_REMINDER, MARK_AS_PAID, MARK_AS_SHIPPED, MARK_AS_UNPAID, MARK_AS_UNSHIPPED, ADD_TRACKING_DETAILS, SHOW_RELISTED_ITEM, 
                EBAY_NOW_ORDER_DETAILS, IN_STORE_PICKUP_ORDER_DETAILS, SELL_SIMILAR, SELL_ONE_LIKE_THIS, SELLERS_OTHER_ITEMS, TRACK_PACKAGE, PRINT_SHIPPING_LABEL, AFTER_SALES, CANCEL, MORE_OPTIONS, 
                BUY_ANOTHER
            });
        }

        private Action(String s, int i)
        {
            super(s, i);
        }

    }

    static abstract class State extends Enum
    {

        private static final State $VALUES[];
        public static final State BEST_OFFER;
        public static final State BEST_OFFER_DECLINED;
        public static final State BEST_OFFER_EXPIRED;
        public static final State BEST_OFFER_MULTI_OFFERS;
        public static final State BEST_OFFER_NEGOTIATION;
        public static final State BIDDING;
        public static final State BOUGHT;
        public static final State BOUGHT_AND_PAID;
        public static final State EBAY_NOW;
        public static final State ENDED;
        public static final State PICKUP;
        public static final State REFUNDED;
        public static final State SELLER_ENDED;
        public static final State SELLER_PAID_OR_SHIP_TO_FUND;
        public static final State SELLER_SCHEDULED_OR_ACTIVE;
        public static final State SELLER_SHIPPED;
        public static final State SELLER_SOLD;
        protected String afterSalesHeaderOverride;
        protected List buttonsContainer;
        protected SpannableStringBuilder headerText;
        protected List statsContainer;
        protected android.view.View.OnClickListener subHeaderButtonListener;
        protected Integer subHeaderButtonResource;
        protected String subHeaderText;

        private static void addMarkUnmarkPaidButton(ActionsFactory actionsfactory, Resources resources, List list, Item item1)
        {
            if (item1.isShowMarkAsPaid)
            {
                list.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0704cb), Action.MARK_AS_PAID));
            } else
            if (item1.isShowMarkAsUnPaid)
            {
                list.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0704cc), Action.MARK_AS_UNPAID));
                return;
            }
        }

        private static void addMarkUnmarkShippedButton(ActionsFactory actionsfactory, Resources resources, List list, Item item1)
        {
            if (item1.isShowMarkAsShipped)
            {
                list.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0704ce), Action.MARK_AS_SHIPPED));
            } else
            if (item1.isShowMarkAsUnShipped)
            {
                list.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0704cd), Action.MARK_AS_UNSHIPPED));
                return;
            }
        }

        private static void addSellSimilarButton(ActionsFactory actionsfactory, Resources resources, List list)
        {
            list.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0704e5), Action.SELL_SIMILAR));
        }

        private static String getFirstTrackingScanDetail(Context context, ArrayList arraylist)
        {
            StringBuilder stringbuilder = new StringBuilder();
            if (arraylist == null) goto _L2; else goto _L1
_L1:
            arraylist = ((ShipmentTrackingDetail)arraylist.get(0)).scanDetails;
            if (arraylist == null || arraylist.isEmpty()) goto _L2; else goto _L3
_L3:
            arraylist = (ShipmentTrackingScanDetail)arraylist.get(0);
            if (!TextUtils.isEmpty(((ShipmentTrackingScanDetail) (arraylist)).eventDesc))
            {
                stringbuilder.append(((ShipmentTrackingScanDetail) (arraylist)).eventDesc);
            }
            if (TextUtils.isEmpty(((ShipmentTrackingScanDetail) (arraylist)).eventCity) || TextUtils.isEmpty(((ShipmentTrackingScanDetail) (arraylist)).eventStateOrProvince)) goto _L5; else goto _L4
_L4:
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("\n");
            }
            stringbuilder.append(((ShipmentTrackingScanDetail) (arraylist)).eventCity).append(", ").append(((ShipmentTrackingScanDetail) (arraylist)).eventStateOrProvince);
_L7:
            if (((ShipmentTrackingScanDetail) (arraylist)).eventTime != null)
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append("\n");
                }
                long l = EbayResponse.currentHostTime();
                long l1 = ((ShipmentTrackingScanDetail) (arraylist)).eventTime.getTime();
                stringbuilder.append(context.getResources().getString(0x7f070b59, new Object[] {
                    Util.formatDayHourMinSec(context, l - l1, true)
                }));
            }
_L2:
            return stringbuilder.toString();
_L5:
            if (!TextUtils.isEmpty(((ShipmentTrackingScanDetail) (arraylist)).eventCity))
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append("\n");
                }
                stringbuilder.append(((ShipmentTrackingScanDetail) (arraylist)).eventCity);
            } else
            if (!TextUtils.isEmpty(((ShipmentTrackingScanDetail) (arraylist)).eventStateOrProvince))
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append("\n");
                }
                stringbuilder.append(((ShipmentTrackingScanDetail) (arraylist)).eventStateOrProvince);
            }
            if (true) goto _L7; else goto _L6
_L6:
        }

        private static void showItemShippedButtons(ActionsFactory actionsfactory, Resources resources, List list, Item item1)
        {
            if (item1.isShowEnterTrackingNumber)
            {
                int j = 0x7f070499;
                int i = j;
                if (!item1.isGspItem)
                {
                    i = j;
                    if (item1.iTransaction != null)
                    {
                        i = j;
                        if (!TextUtils.isEmpty(item1.iTransaction.getShipmentTrackingNumber()))
                        {
                            i = 0x7f0704b7;
                        }
                    }
                }
                list.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(i), Action.ADD_TRACKING_DETAILS));
            }
            if (item1.isShowLeaveFeedback)
            {
                list.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0705d8), Action.LEAVE_FEEDBACK));
            }
            list.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070267), Action.CONTACT_USER));
        }

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/ebay/mobile/viewitem/fragments/ActionsFactory$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        public void addHeaderOverride(String s, Item item1, Resources resources)
        {
            int i = Util.getAfterSalesHeaderResId(item1.iTransaction, item1.isSeller, 0, s);
            if (i != -1)
            {
                afterSalesHeaderOverride = resources.getString(i);
                return;
            } else
            {
                afterSalesHeaderOverride = null;
                return;
            }
        }

        protected abstract void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup);

        public View getView(Context context, ViewGroup viewgroup)
        {
            View view = LayoutInflater.from(context).inflate(0x7f03027e, viewgroup, false);
            if (headerText != null && headerText.length() > 0)
            {
                viewgroup = (TextView)view.findViewById(0x7f1004a1);
                viewgroup.setText(headerText, android.widget.TextView.BufferType.SPANNABLE);
                viewgroup.setVisibility(0);
            }
            if (TextUtils.isEmpty(afterSalesHeaderOverride))
            {
                viewgroup = headerText;
            } else
            {
                viewgroup = afterSalesHeaderOverride;
            }
            if (!TextUtils.isEmpty(viewgroup))
            {
                TextView textview = (TextView)view.findViewById(0x7f1004a1);
                textview.setText(viewgroup);
                textview.setVisibility(0);
            }
            if (!TextUtils.isEmpty(subHeaderText))
            {
                ((TextView)view.findViewById(0x7f1004a2)).setText(subHeaderText);
                view.findViewById(0x7f100867).setVisibility(0);
            }
            if (subHeaderButtonResource != null)
            {
                viewgroup = (ImageView)view.findViewById(0x7f100868);
                viewgroup.setImageResource(subHeaderButtonResource.intValue());
                viewgroup.setOnClickListener(subHeaderButtonListener);
                viewgroup.setVisibility(0);
                view.findViewById(0x7f100867).setVisibility(0);
            }
            if (statsContainer.size() > 0)
            {
                viewgroup = (ViewGroup)view.findViewById(0x7f100869);
                viewgroup.removeAllViews();
                for (Iterator iterator = statsContainer.iterator(); iterator.hasNext(); viewgroup.addView((View)iterator.next())) { }
                viewgroup.setVisibility(0);
            }
            if (buttonsContainer.size() > 0)
            {
                viewgroup = (LinearLayout)view.findViewById(0x7f10086a);
                android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)viewgroup.getLayoutParams();
                layoutparams.topMargin = (int)context.getResources().getDimension(0x7f090072);
                viewgroup.removeAllViews();
                View view1;
                for (context = buttonsContainer.iterator(); context.hasNext(); viewgroup.addView(view1))
                {
                    view1 = (View)context.next();
                    view1.setLayoutParams(layoutparams);
                }

                viewgroup.setVisibility(0);
            }
            return view;
        }

        boolean hasAddedButtonsToView()
        {
            return buttonsContainer.size() > 0;
        }

        public void update(ActionsFactory actionsfactory, ViewGroup viewgroup)
        {
            ViewItemDataManager viewitemdatamanager = actionsfactory.viewItemDataManager;
            Item item1 = actionsfactory.item;
            Object obj = actionsfactory.fragment.getActivity();
            if (obj != null)
            {
                Object obj1 = new ContextThemeWrapper(((Context) (obj)), 0x7f0a007f);
                obj = LayoutInflater.from(((Context) (obj))).cloneInContext(((Context) (obj1)));
                obj1 = actionsfactory.fragment.getResources();
                headerText = new SpannableStringBuilder();
                subHeaderText = null;
                subHeaderButtonResource = null;
                subHeaderButtonListener = null;
                statsContainer = new ArrayList();
                buttonsContainer = new ArrayList();
                doUpdate(actionsfactory, viewitemdatamanager, item1, ((LayoutInflater) (obj)), ((Resources) (obj1)), viewgroup);
            }
        }

        static 
        {
            BIDDING = new State("BIDDING", 0) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    boolean flag1 = DeviceConfiguration.getAsync().get(DcsBoolean.VI_featureNewBidFlow);
                    if (!item1.isReserveMet)
                    {
                        headerText.append(resources.getString(0x7f070cca));
                    }
                    if (item1.isOutbid)
                    {
                        headerText.clear();
                        headerText.append(resources.getString(0x7f070cce));
                    }
                    if (headerText.length() == 0)
                    {
                        headerText.append(resources.getString(0x7f070cc9));
                    }
                    Activity activity = actionsfactory.fragment.getActivity();
                    Object obj;
                    ItemCurrency itemcurrency;
                    boolean flag;
                    if (item1.isDisplayPriceCurrencyCode)
                    {
                        obj = Item.getApproximateString(activity, item1.convertedCurrentPrice).toString();
                    } else
                    {
                        obj = null;
                    }
                    if (!flag1)
                    {
                        statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f070278), item1.displayCurrentPrice, ((String) (obj))));
                    } else
                    {
                        LinearLayout linearlayout = (LinearLayout)layoutinflater.inflate(0x7f030283, null, false);
                        ((TextView)linearlayout.findViewById(0x7f1002ef)).setText(item1.displayCurrentPrice);
                        if (obj != null)
                        {
                            TextView textview = (TextView)linearlayout.findViewById(0x7f1002f0);
                            textview.setText(((CharSequence) (obj)));
                            textview.setVisibility(0);
                        }
                        if (item1.bidCount > 0)
                        {
                            obj = (TextView)linearlayout.findViewById(0x7f100895);
                            ((TextView) (obj)).setText(String.format(resources.getQuantityString(0x7f08001b, item1.bidCount), new Object[] {
                                Integer.valueOf(item1.bidCount)
                            }));
                            ((TextView) (obj)).setVisibility(0);
                        }
                        obj = new ArrayList();
                        ((List) (obj)).add(linearlayout);
                        statsContainer.add(Util.createViewItemStatFullWidth(layoutinflater, viewgroup, ((List) (obj))));
                    }
                    itemcurrency = item1.getMaxBid(viewitemdatamanager, actionsfactory.viewData.nameValueList);
                    if (itemcurrency != null && (flag1 || !item1.isOutbid))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        obj = null;
                        viewitemdatamanager = ((ViewItemDataManager) (obj));
                        if (item1.isDisplayPriceCurrencyCode)
                        {
                            ItemCurrency itemcurrency1 = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), itemcurrency);
                            viewitemdatamanager = ((ViewItemDataManager) (obj));
                            if (itemcurrency1 != null)
                            {
                                viewitemdatamanager = Item.getApproximateString(activity, itemcurrency1).toString();
                            }
                        }
                        obj = EbayCurrencyUtil.formatDisplay(itemcurrency, item1.getCurrencyUtilFlag());
                        statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f070cdc), ((String) (obj)), viewitemdatamanager));
                    }
                    if (item1.endDate != null)
                    {
                        statsContainer.add(Util.createViewItemStatCountDown(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f070b5a), item1.endDate, true));
                    }
                    if (item1.isOutbid)
                    {
                        if (!flag1)
                        {
                            layoutinflater = null;
                            viewgroup = actionsfactory.fragment.priceEditor;
                            viewitemdatamanager = layoutinflater;
                            if (viewgroup != null)
                            {
                                viewitemdatamanager = layoutinflater;
                                if (!viewgroup.isEmpty())
                                {
                                    viewitemdatamanager = viewgroup.getText().toString();
                                }
                            }
                            item1 = resources.getString(0x7f07018f, new Object[] {
                                EbayCurrencyUtil.formatDisplay(item1.minimumToBid.lowerBound, item1.getCurrencyUtilFlag())
                            });
                            buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, item1, Action.BID_THIS_AMOUNT, true));
                            actionsfactory = ActionsFactory.getCompoundActionArea(actionsfactory, resources.getString(0x7f0705dd), resources.getString(0x7f07079b), Action.SET_AUTO_BID);
                            if (!TextUtils.isEmpty(viewitemdatamanager))
                            {
                                item1 = (PriceView)actionsfactory.findViewById(0x7f1008a0);
                                if (item1 != null)
                                {
                                    item1.setPriceRaw(viewitemdatamanager);
                                    item1.requestFocus();
                                }
                            }
                            buttonsContainer.add(actionsfactory);
                            return;
                        } else
                        {
                            buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070480), Action.INCREASE_MAX_BID, true));
                            return;
                        }
                    }
                    item1 = buttonsContainer;
                    if (flag1)
                    {
                        viewitemdatamanager = resources.getString(0x7f070480);
                    } else
                    {
                        viewitemdatamanager = resources.getString(0x7f07047f);
                    }
                    item1.add(ActionsFactory.getActionButton(actionsfactory, viewitemdatamanager, Action.INCREASE_MAX_BID));
                }

            };
            BEST_OFFER = new State("BEST_OFFER", 1) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    BestOffer bestoffer = item1.newestBestOffer(MyApp.getPrefs().getCurrentUser());
                    Activity activity = actionsfactory.fragment.getActivity();
                    boolean flag = "Accepted".equals(bestoffer.status);
                    int i = 0x7f070732;
                    if (flag)
                    {
                        i = 0x7f070705;
                    }
                    if (item1.isSeller)
                    {
                        i = 0x7f07070e;
                    }
                    headerText.append(resources.getString(i));
                    if (flag)
                    {
                        String s3 = EbayCurrencyUtil.formatDisplay(bestoffer.currentOffer, 0);
                        String s = null;
                        viewitemdatamanager = s;
                        if (item1.isDisplayPriceCurrencyCode)
                        {
                            ItemCurrency itemcurrency = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), bestoffer.currentOffer.toItemCurrency());
                            viewitemdatamanager = s;
                            if (itemcurrency != null)
                            {
                                viewitemdatamanager = Item.getApproximateString(activity, itemcurrency).toString();
                            }
                        }
                        String s4 = item1.displayPriceShipping;
                        String s1 = null;
                        s = s1;
                        if (item1.isDisplayPriceCurrencyCode)
                        {
                            ItemCurrency itemcurrency2 = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), item1.displayPriceShippingCurrency);
                            s = s1;
                            if (itemcurrency2 != null)
                            {
                                s = (new StringBuilder()).append("+ ").append(EbayCurrencyUtil.formatDisplay(itemcurrency2, 0)).toString();
                            }
                        }
                        s1 = null;
                        if (item1.isDisplayPriceCurrencyCode)
                        {
                            s1 = ActionsFactory.getConvertedPriceAndShipping(activity, viewitemdatamanager, s);
                        }
                        statsContainer.add(Util.createViewItemStatPrice(layoutinflater, viewgroup, s3, s4, s1, false));
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f0708c4), Integer.toString(bestoffer.quantity)));
                    } else
                    {
                        String s2 = EbayCurrencyUtil.formatDisplay(bestoffer.currentOffer, item1.getCurrencyUtilFlag());
                        Object obj = null;
                        viewitemdatamanager = obj;
                        if (item1.isDisplayPriceCurrencyCode)
                        {
                            ItemCurrency itemcurrency1 = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), bestoffer.currentOffer.toItemCurrency());
                            viewitemdatamanager = obj;
                            if (itemcurrency1 != null)
                            {
                                viewitemdatamanager = Item.getApproximateString(activity, itemcurrency1).toString();
                            }
                        }
                        statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f07044d), s2, viewitemdatamanager));
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f0708c4), Integer.toString(bestoffer.quantity)));
                        statsContainer.add(Util.createViewItemStatCountDown(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f07057c), bestoffer.expirationDate, true));
                    }
                    if (!TextUtils.isEmpty(bestoffer.sellerMessage))
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f070733), bestoffer.sellerMessage));
                    }
                    if (!TextUtils.isEmpty(bestoffer.buyerMessage))
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f070733), bestoffer.buyerMessage));
                    }
                    if (item1.isSeller)
                    {
                        if (item1.isShowRevise)
                        {
                            buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070939), Action.REVISE_LISTING));
                        }
                    } else
                    if (flag)
                    {
                        if (item1.isTransacted)
                        {
                            buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070764), Action.PAY_NOW, true));
                        }
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f07070c), Action.CONTACT_USER));
                        return;
                    }
                }

            };
            BEST_OFFER_EXPIRED = new State("BEST_OFFER_EXPIRED", 2) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    String s;
                    Activity activity;
                    BestOffer bestoffer = item1.newestBestOffer(MyApp.getPrefs().getCurrentUser());
                    activity = actionsfactory.fragment.getActivity();
                    String s1;
                    int i;
                    boolean flag;
                    int j;
                    if (item1.remainingBestOffersForBuyer(bestoffer.buyerId) == 0)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    if (item1.remainingBestOffersForBuyer(bestoffer.buyerId) == 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    j = 0x7f070513;
                    if (i != 0)
                    {
                        j = 0x7f070512;
                    }
                    headerText.append(resources.getString(j));
                    if (i != 0) goto _L2; else goto _L1
_L1:
                    viewitemdatamanager = null;
                    if (!item1.isBinOnly) goto _L4; else goto _L3
_L3:
                    s1 = item1.displayPrice;
                    s = s1;
                    if (item1.isDisplayPriceCurrencyCode)
                    {
                        viewitemdatamanager = Item.getApproximateString(activity, item1.convertedBuyItNowPrice).toString();
                        s = s1;
                    }
_L6:
                    statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f0707b1), s, viewitemdatamanager));
_L2:
                    s1 = EbayCurrencyUtil.formatDisplay(bestoffer.currentOffer, item1.getCurrencyUtilFlag());
                    s = null;
                    viewitemdatamanager = s;
                    if (item1.isDisplayPriceCurrencyCode)
                    {
                        item1 = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), bestoffer.currentOffer.toItemCurrency());
                        viewitemdatamanager = s;
                        if (item1 != null)
                        {
                            viewitemdatamanager = Item.getApproximateString(activity, item1).toString();
                        }
                    }
                    statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f07071a), s1, viewitemdatamanager));
                    if (bestoffer.quantity > 1)
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f0708c4), Integer.toString(bestoffer.quantity)));
                    }
                    if (bestoffer.expirationDate != null)
                    {
                        viewitemdatamanager = Util.getFormattedDateTimeStringFromDate(activity, bestoffer.expirationDate);
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0704d4), viewitemdatamanager));
                    }
                    if (i == 0)
                    {
                        i = 0x7f0701a7;
                        if (flag)
                        {
                            i = 0x7f0701a9;
                        }
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(i), Action.MAKE_OFFER));
                    }
                    return;
_L4:
                    String s2 = item1.displayCurrentPrice;
                    s = s2;
                    if (item1.isDisplayPriceCurrencyCode)
                    {
                        viewitemdatamanager = Item.getApproximateString(activity, item1.convertedCurrentPrice).toString();
                        s = s2;
                    }
                    if (true) goto _L6; else goto _L5
_L5:
                }

            };
            BEST_OFFER_DECLINED = new State("BEST_OFFER_DECLINED", 3) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    BestOffer bestoffer = item1.newestBestOffer(MyApp.getPrefs().getCurrentUser());
                    Activity activity = actionsfactory.fragment.getActivity();
                    int i;
                    boolean flag;
                    boolean flag1;
                    int j;
                    if (item1.remainingBestOffersForBuyer(bestoffer.buyerId) == 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (item1.remainingBestOffersForBuyer(bestoffer.buyerId) == 1)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    j = 0x7f070281;
                    if (item1.isSeller)
                    {
                        i = j;
                        if (!bestoffer.codeType.equals("BuyerBestOffer"))
                        {
                            i = j;
                            if (!bestoffer.codeType.equals("BuyerCounterOffer"))
                            {
                                i = 0x7f070709;
                            }
                        }
                    } else
                    {
                        i = j;
                        if (!bestoffer.codeType.equals("SellerCounterOffer"))
                        {
                            i = 0x7f070712;
                            if (flag1)
                            {
                                i = 0x7f070713;
                            } else
                            if (flag)
                            {
                                i = 0x7f070711;
                                if (item1.isSeller)
                                {
                                    i = 0x7f07070a;
                                }
                            }
                        }
                    }
                    headerText.append(resources.getString(i));
                    if (item1.isSeller)
                    {
                        String s1 = EbayCurrencyUtil.formatDisplay(bestoffer.currentOffer, item1.getCurrencyUtilFlag());
                        Object obj = null;
                        viewitemdatamanager = obj;
                        if (item1.isDisplayPriceCurrencyCode)
                        {
                            ItemCurrency itemcurrency = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), bestoffer.currentOffer.toItemCurrency());
                            viewitemdatamanager = obj;
                            if (itemcurrency != null)
                            {
                                viewitemdatamanager = Item.getApproximateString(activity, itemcurrency).toString();
                            }
                        }
                        statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f07044d), s1, viewitemdatamanager));
                    } else
                    if (!flag)
                    {
                        viewitemdatamanager = null;
                        String s;
                        String s3;
                        if (item1.isBinOnly)
                        {
                            String s2 = item1.displayPrice;
                            s = s2;
                            if (item1.isDisplayPriceCurrencyCode)
                            {
                                viewitemdatamanager = Item.getApproximateString(activity, item1.convertedBuyItNowPrice).toString();
                                s = s2;
                            }
                        } else
                        {
                            String s4 = item1.displayCurrentPrice;
                            s = s4;
                            if (item1.isDisplayPriceCurrencyCode)
                            {
                                viewitemdatamanager = Item.getApproximateString(activity, item1.convertedCurrentPrice).toString();
                                s = s4;
                            }
                        }
                        statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f0707b1), s, viewitemdatamanager));
                        s3 = EbayCurrencyUtil.formatDisplay(bestoffer.currentOffer, item1.getCurrencyUtilFlag());
                        s = null;
                        viewitemdatamanager = s;
                        if (item1.isDisplayPriceCurrencyCode)
                        {
                            ItemCurrency itemcurrency1 = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), bestoffer.currentOffer.toItemCurrency());
                            viewitemdatamanager = s;
                            if (itemcurrency1 != null)
                            {
                                viewitemdatamanager = Item.getApproximateString(activity, itemcurrency1).toString();
                            }
                        }
                        statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f07071a), s3, viewitemdatamanager));
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f0708c4), Integer.toString(bestoffer.quantity)));
                    }
                    if (!TextUtils.isEmpty(bestoffer.sellerMessage))
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f07018a), bestoffer.sellerMessage));
                    }
                    if (!TextUtils.isEmpty(bestoffer.buyerMessage))
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f070733), bestoffer.buyerMessage));
                    }
                    if (item1.isSeller)
                    {
                        if (item1.isShowRevise)
                        {
                            buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070939), Action.REVISE_LISTING));
                        }
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0703c1), Action.END_LISTING));
                    } else
                    if (!flag)
                    {
                        viewitemdatamanager = ActionsFactory.getCompoundActionArea(actionsfactory, null, resources.getString(0x7f070721), Action.MAKE_OFFER, true);
                        buttonsContainer.add(viewitemdatamanager);
                    }
                    if (item1.isSeller && item1.isShowSellSimilar)
                    {
                        State.addSellSimilarButton(actionsfactory, resources, buttonsContainer);
                    }
                }

            };
            BEST_OFFER_NEGOTIATION = new State("BEST_OFFER_NEGOTIATION", 4) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    BestOffer bestoffer;
                    int i;
                    boolean flag;
                    bestoffer = item1.newestBestOffer(MyApp.getPrefs().getCurrentUser());
                    Activity activity = actionsfactory.fragment.getActivity();
                    String s;
                    Object obj;
                    String s1;
                    String s2;
                    ItemCurrency itemcurrency;
                    if (item1.remainingBestOffersForBuyer(bestoffer.buyerId) == 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    i = 0x7f070722;
                    if (flag)
                    {
                        i = 0x7f070723;
                    }
                    if (!item1.isSeller) goto _L2; else goto _L1
_L1:
                    i = 0x7f070707;
                    if (!"BuyerBestOffer".equals(bestoffer.codeType)) goto _L4; else goto _L3
_L3:
                    i = 0x7f07070b;
_L2:
                    headerText.append(resources.getString(i));
                    s1 = EbayCurrencyUtil.formatDisplay(bestoffer.currentOffer, 0);
                    s = null;
                    viewitemdatamanager = s;
                    if (item1.isDisplayPriceCurrencyCode)
                    {
                        obj = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), bestoffer.currentOffer.toItemCurrency());
                        viewitemdatamanager = s;
                        if (obj != null)
                        {
                            viewitemdatamanager = Item.getApproximateString(activity, ((ItemCurrency) (obj))).toString();
                        }
                    }
                    s2 = item1.displayPriceShipping;
                    obj = null;
                    s = ((String) (obj));
                    if (item1.isDisplayPriceCurrencyCode)
                    {
                        itemcurrency = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), item1.displayPriceShippingCurrency);
                        s = ((String) (obj));
                        if (itemcurrency != null)
                        {
                            s = (new StringBuilder()).append("+ ").append(EbayCurrencyUtil.formatDisplay(itemcurrency, 0)).toString();
                        }
                    }
                    obj = null;
                    if (item1.isDisplayPriceCurrencyCode)
                    {
                        obj = ActionsFactory.getConvertedPriceAndShipping(activity, viewitemdatamanager, s);
                    }
                    statsContainer.add(Util.createViewItemStatPrice(layoutinflater, viewgroup, s1, s2, ((String) (obj)), false));
                    statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f0708c4), Integer.toString(bestoffer.quantity)));
                    if (item1.endDate != null)
                    {
                        statsContainer.add(Util.createViewItemStatCountDown(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f070b5a), item1.endDate, true));
                    }
                    if (!TextUtils.isEmpty(bestoffer.sellerMessage))
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f070733), bestoffer.sellerMessage));
                    }
                    if (!TextUtils.isEmpty(bestoffer.buyerMessage))
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f070733), bestoffer.buyerMessage));
                    }
                    buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0701af), Action.REVIEW_OFFER, true));
                    if (item1.isSeller)
                    {
                        if (item1.isShowRevise)
                        {
                            buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070939), Action.REVISE_LISTING));
                        }
                        if (item1.isShowSellSimilar)
                        {
                            State.addSellSimilarButton(actionsfactory, resources, buttonsContainer);
                        }
                    }
                    return;
_L4:
                    if ("SellerCounterOffer".equals(bestoffer.codeType))
                    {
                        i = 0x7f07070e;
                    } else
                    if (flag)
                    {
                        i = 0x7f070708;
                    }
                    if (true) goto _L2; else goto _L5
_L5:
                }

            };
            BEST_OFFER_MULTI_OFFERS = new State("BEST_OFFER_MULTI_OFFERS", 5) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    int i = item1.numberOfPendingBestOffersForSeller();
                    headerText.append(resources.getQuantityString(0x7f080024, i, new Object[] {
                        Integer.valueOf(i)
                    }));
                    buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070936), Action.VIEW_OFFERS, true));
                    if (item1.isSeller)
                    {
                        if (item1.isShowRevise)
                        {
                            buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070939), Action.REVISE_LISTING));
                        }
                        if (item1.isShowSellSimilar)
                        {
                            State.addSellSimilarButton(actionsfactory, resources, buttonsContainer);
                        }
                    }
                }

            };
            BOUGHT = new State("BOUGHT", 6) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    Activity activity = actionsfactory.fragment.getActivity();
                    int i = 0x7f070262;
                    int k = 0;
                    viewitemdatamanager = item1.newestBestOffer(MyApp.getPrefs().getCurrentUser());
                    Object obj;
                    String s1;
                    int j;
                    boolean flag;
                    if (viewitemdatamanager != null && ((BestOffer) (viewitemdatamanager)).status != null && ((BestOffer) (viewitemdatamanager)).status.equals("Accepted"))
                    {
                        i = 0x7f070705;
                        j = k;
                    } else
                    if ("PaymentPending".equals(item1.paidStatus))
                    {
                        i = 0x7f070767;
                        j = 1;
                    } else
                    {
                        j = k;
                        if (item1.isTransactedAsBin)
                        {
                            i = 0x7f070cdf;
                            j = k;
                        }
                    }
                    k = i;
                    if (ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                    {
                        k = Util.getAfterSalesHeaderResId(item1.iTransaction, item1.isSeller, i, actionsfactory.fragment.overrideStatus);
                    }
                    headerText.append(resources.getString(k));
                    obj = null;
                    s1 = null;
                    viewitemdatamanager = s1;
                    if (item1.isTransacted)
                    {
                        String s = item1.displayPrice;
                        obj = s;
                        viewitemdatamanager = s1;
                        String s2;
                        if (item1.isDisplayPriceCurrencyCode)
                        {
                            if (!TextUtils.isEmpty(item1.displayPriceConverted))
                            {
                                viewitemdatamanager = item1.displayPriceConverted;
                                obj = s;
                            } else
                            {
                                viewitemdatamanager = EbayCurrencyUtil.formatDisplay(ActionsFactory.getTotalConvertedCurrency(item1.iTransaction), 0);
                                obj = s;
                            }
                        }
                    }
                    s2 = item1.displayPriceShipping;
                    s = null;
                    if (item1.isDisplayPriceCurrencyCode)
                    {
                        s = item1.displayPriceShippingConverted;
                    }
                    s1 = null;
                    if (item1.isDisplayPriceCurrencyCode)
                    {
                        s1 = ActionsFactory.getConvertedPriceAndShipping(activity, viewitemdatamanager, s);
                    }
                    viewitemdatamanager = statsContainer;
                    if (!TextUtils.isEmpty(s2) && item1.isVatIncluded())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    viewitemdatamanager.add(Util.createViewItemStatPrice(layoutinflater, viewgroup, ((String) (obj)), s2, s1, flag));
                    if (item1.iTransaction != null)
                    {
                        statsContainer.add(Util.createViewItemStatFormattedDate(activity, layoutinflater, viewgroup, resources.getString(0x7f07093b), item1.iTransaction.createdDate));
                    }
                    if (item1.quantityPurchased > 1)
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0708c4), Integer.toString(item1.quantityPurchased)));
                    }
                    if (item1.iTransaction != null && item1.iTransaction.variation != null && item1.iTransaction.variation.nameValueList != null && !item1.iTransaction.variation.nameValueList.isEmpty())
                    {
                        viewitemdatamanager = new DelimitedStringBuilder(",");
                        for (obj = item1.iTransaction.variation.nameValueList.iterator(); ((Iterator) (obj)).hasNext(); viewitemdatamanager.append(((NameValue)((Iterator) (obj)).next()).getValue())) { }
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070740), viewitemdatamanager.toString()));
                    }
                    if (j == 0)
                    {
                        if (item1.isShowPaymentOptions)
                        {
                            buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070766), Action.PAYMENT_OPTIONS));
                        } else
                        {
                            buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070764), Action.PAY_NOW, true));
                        }
                    }
                    if (item1.isShowBuyAnother && item1.quantity > 1 && item1.getQuantityAvailable(null) > 0 && (activity instanceof ItemViewActivity))
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0701b6), Action.BUY_ANOTHER));
                    }
                    if (ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, ActionsFactory.getAfterSalesReentryButtonText(item1, resources.getString(0x7f07088a), resources), Action.AFTER_SALES));
                    }
                    if (DeviceConfiguration.getAsync().get(DcsBoolean.ContactSeller))
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f07070c), Action.CONTACT_USER));
                    }
                    if (item1.isShowLeaveFeedback)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0705d8), Action.LEAVE_FEEDBACK));
                    }
                    if (item1.isShowSellLike)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0704e4), Action.SELL_ONE_LIKE_THIS));
                    }
                    if (MyApp.getDeviceConfiguration().isAfterSalesEnabled())
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f07088a), Action.MORE_OPTIONS));
                    }
                }

            };
            BOUGHT_AND_PAID = new State("BOUGHT_AND_PAID", 7) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    Activity activity;
                    activity = actionsfactory.fragment.getActivity();
                    Object obj = null;
                    viewitemdatamanager = obj;
                    if (item1.tracking != null)
                    {
                        viewitemdatamanager = obj;
                        if (item1.tracking.details != null)
                        {
                            viewitemdatamanager = obj;
                            if (!item1.tracking.details.isEmpty())
                            {
                                viewitemdatamanager = item1.tracking.details;
                            }
                        }
                    }
                    int i = 0x7f07075d;
                    if (item1.isShipped)
                    {
                        i = 0x7f07028a;
                    }
                    if (item1.isDelivered)
                    {
                        i = 0x7f070cd8;
                    }
                    int j = i;
                    if (ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                    {
                        j = Util.getAfterSalesHeaderResId(item1.iTransaction, item1.isSeller, i, actionsfactory.fragment.overrideStatus);
                    }
                    headerText.append(resources.getString(j));
                    if (item1.iTransaction != null && item1.iTransaction.createdDate != null)
                    {
                        statsContainer.add(Util.createViewItemStatFormattedDate(activity, layoutinflater, viewgroup, resources.getString(0x7f07093b), item1.iTransaction.createdDate));
                    }
                    if (!item1.isShipped && item1.iTransaction != null && item1.iTransaction.paidTime != null)
                    {
                        String s = (String)DateFormat.format(Util.getDeliveryDateFormat(activity, false), item1.iTransaction.paidTime);
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070495), s));
                    }
                    if (item1.quantityPurchased > 1)
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0708c4), Integer.toString(item1.quantityPurchased)));
                    }
                    if (item1.iTransaction != null && item1.iTransaction.variation != null && item1.iTransaction.variation.nameValueList != null && !item1.iTransaction.variation.nameValueList.isEmpty())
                    {
                        DelimitedStringBuilder delimitedstringbuilder = new DelimitedStringBuilder(",");
                        for (Iterator iterator = item1.iTransaction.variation.nameValueList.iterator(); iterator.hasNext(); delimitedstringbuilder.append(((NameValue)iterator.next()).getValue())) { }
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070740), delimitedstringbuilder.toString()));
                    }
                    if (item1.iTransaction == null || item1.iTransaction.orderShippingInfo == null || !item1.isDelivered) goto _L2; else goto _L1
_L1:
                    String s1 = Util.getFormattedDateTimeStringFromDate(activity, item1.iTransaction.orderShippingInfo.actualDeliveryDate);
                    statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070288), s1));
_L4:
                    if (item1.iTransaction != null && item1.iTransaction.selectedShippingOption != null && item1.isShipped && item1.iTransaction.selectedShippingOption.shippingServiceName != null)
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070a6e), ViewItemShippingInfo.getPrettyShippingServiceName(item1.site, item1.iTransaction.selectedShippingOption.shippingServiceName)));
                    }
                    if (item1.buyerAddress != null)
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070b6b), item1.buyerAddress));
                    }
                    if (item1.isShipped && item1.iTransaction != null && item1.iTransaction.shipmentTrackingDetails != null && item1.iTransaction.shipmentTrackingDetails.size() > 0 && ((com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails)item1.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber != null)
                    {
                        statsContainer.add(Util.createViewItemStatCopiable(activity, layoutinflater, viewgroup, resources.getString(0x7f070b7e), ((com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails)item1.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber));
                    }
                    if (viewitemdatamanager != null)
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, "", State.getFirstTrackingScanDetail(activity, viewitemdatamanager)));
                    }
                    if (item1.isShowBuyAnother && item1.quantity > 1 && item1.getQuantityAvailable(null) > 0 && (activity instanceof ItemViewActivity))
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0701b6), Action.BUY_ANOTHER));
                    }
                    if (ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, ActionsFactory.getAfterSalesReentryButtonText(item1, resources.getString(0x7f07088a), resources), Action.AFTER_SALES));
                    }
                    if (item1.isShowTrackPackage && viewitemdatamanager != null)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070ab8), Action.TRACK_PACKAGE));
                    }
                    if (item1.isShowLeaveFeedback)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0705d8), Action.LEAVE_FEEDBACK));
                    }
                    if (DeviceConfiguration.getAsync().get(DcsBoolean.ContactSeller))
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f07070c), Action.CONTACT_USER));
                    }
                    if (item1.isShowSellLike)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0704e4), Action.SELL_ONE_LIKE_THIS));
                    }
                    if (MyApp.getDeviceConfiguration().isAfterSalesEnabled())
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f07088a), Action.MORE_OPTIONS));
                    }
                    return;
_L2:
                    if (item1.iTransaction != null && item1.iTransaction.orderShippingInfo != null && item1.iTransaction.orderShippingInfo.estimatedMinDeliveryDate != null && item1.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate != null)
                    {
                        String s2 = Util.getDeliveryDateString(activity, item1.iTransaction.orderShippingInfo.estimatedMinDeliveryDate, item1.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate);
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0703eb), s2));
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            };
            ENDED = new State("ENDED", 8) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    int i = 0x7f070503;
                    if (item1.relistedId != null)
                    {
                        i = 0x7f0704c8;
                    }
                    headerText.append(resources.getString(i));
                    if (!item1.isBinOnly && !item1.finalized)
                    {
                        headerText.clear();
                    }
                    if (item1.relistedId != null)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f07050d), Action.SHOW_RELISTED_ITEM, true));
                    }
                    if (item1.isShowSimilar)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070a02), Action.SELLERS_OTHER_ITEMS));
                    }
                    if (item1.isShowSellLike)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0704e4), Action.SELL_ONE_LIKE_THIS));
                    }
                }

            };
            REFUNDED = new State("REFUNDED", 9) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    int i;
                    int j;
                    if (item1.isSeller)
                    {
                        i = 0x7f0709f8;
                    } else
                    {
                        i = 0x7f0709f7;
                    }
                    if (item1.isTotalAmountRefunded)
                    {
                        if (item1.isSeller)
                        {
                            i = 0x7f0709f6;
                        } else
                        {
                            i = 0x7f0709f5;
                        }
                    }
                    j = i;
                    if (ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                    {
                        j = Util.getAfterSalesHeaderResId(item1.iTransaction, item1.isSeller, i, actionsfactory.fragment.overrideStatus);
                    }
                    headerText.append(resources.getString(j));
                    if (item1.isShowBuyAnother && item1.quantity > 1 && item1.getQuantityAvailable(null) > 0 && (actionsfactory.fragment.getActivity() instanceof ItemViewActivity))
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0701b6), Action.BUY_ANOTHER));
                    }
                    if (ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, ActionsFactory.getAfterSalesReentryButtonText(item1, resources.getString(0x7f07088a), resources), Action.AFTER_SALES));
                    }
                    if (item1.isShowLeaveFeedback)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0705d8), Action.LEAVE_FEEDBACK));
                    }
                    if (item1.isShowSellSimilar)
                    {
                        State.addSellSimilarButton(actionsfactory, resources, buttonsContainer);
                    }
                    if (MyApp.getDeviceConfiguration().isAfterSalesEnabled() && !item1.isSeller)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f07088a), Action.MORE_OPTIONS));
                    }
                }

            };
            SELLER_SCHEDULED_OR_ACTIVE = new State("SELLER_SCHEDULED_OR_ACTIVE", 10) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    Activity activity = actionsfactory.fragment.getActivity();
                    int k = 0x7f070125;
                    int i = k;
                    if (item1.endDate != null)
                    {
                        i = k;
                        if (!item1.isGTC)
                        {
                            i = k;
                            if (item1.endDate.getTime() - System.currentTimeMillis() <= 0x36ee80L)
                            {
                                i = 0x7f0703c6;
                            }
                        }
                    }
                    headerText.append(resources.getString(i));
                    if (item1.isScheduled)
                    {
                        headerText.clear();
                        viewitemdatamanager = Util.getFormattedDateTimeStringFromDate(activity, item1.startDate).replace(' ', '\240');
                        headerText.append(resources.getString(0x7f070950, new Object[] {
                            viewitemdatamanager
                        }));
                    }
                    if (!item1.isScheduled && item1.isActive)
                    {
                        if (item1.endDate != null && !item1.isGTC)
                        {
                            statsContainer.add(Util.createViewItemStatCountDown(activity, layoutinflater, viewgroup, resources.getString(0x7f070b5a), item1.endDate, true));
                        }
                        if (!item1.isBinOnly)
                        {
                            int j = 0x7f070278;
                            if (item1.bidCount < 1)
                            {
                                j = 0x7f070b2c;
                            }
                            String s1 = item1.displayCurrentPrice;
                            String s = null;
                            viewitemdatamanager = s;
                            if (item1.isDisplayPriceCurrencyCode)
                            {
                                viewitemdatamanager = s;
                                if (item1.convertedCurrentPrice != null)
                                {
                                    viewitemdatamanager = Item.getApproximateString(activity, item1.convertedCurrentPrice).toString();
                                }
                            }
                            List list = statsContainer;
                            String s2 = resources.getString(j);
                            long l;
                            if (item1.isReserveMet)
                            {
                                s = null;
                            } else
                            {
                                s = resources.getString(0x7f07091b);
                            }
                            list.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, s2, s1, viewitemdatamanager, s));
                            if (item1.isBidWithBin)
                            {
                                s = item1.displayPrice;
                                viewitemdatamanager = null;
                                if (item1.isDisplayPriceCurrencyCode)
                                {
                                    viewitemdatamanager = Item.getApproximateString(activity, item1.convertedBuyItNowPrice).toString();
                                }
                                statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f0701b7), s, viewitemdatamanager));
                            }
                            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070190), Integer.toString(item1.bidCount)));
                            if (item1.allBidders != null)
                            {
                                statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0704a0), Integer.toString(item1.allBidders.countBidders())));
                            }
                        }
                        if (item1.isBinOnly)
                        {
                            s = item1.displayPrice;
                            viewitemdatamanager = null;
                            if (item1.isDisplayPriceCurrencyCode)
                            {
                                viewitemdatamanager = Item.getApproximateString(activity, item1.convertedBuyItNowPrice).toString();
                            }
                            statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f0701b7), s, viewitemdatamanager));
                            if (item1.quantitySold > 1)
                            {
                                statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0708c6), Integer.toString(item1.quantitySold)));
                            }
                            if (item1.quantity - item1.quantitySold > 0)
                            {
                                statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070911), Integer.toString(item1.quantity - item1.quantitySold)));
                            }
                        }
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070702), Integer.toString(item1.watchCount)));
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070701), Integer.toString(item1.hitCount)));
                        if (item1.endDate != null && !item1.isGTC)
                        {
                            l = (item1.endDate.getTime() - item1.startDate.getTime()) / 0x5265c00L;
                            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f07029e), (new com.ebay.nautilus.domain.data.BaseCommonType.TimeDuration(com.ebay.nautilus.domain.data.BaseCommonType.TimeDurationUnitEnum.CALENDAR_DAY, l)).toString(resources)));
                        }
                        statsContainer.add(Util.createViewItemStatFormattedDate(activity, layoutinflater, viewgroup, resources.getString(0x7f070b29), item1.startDate));
                    }
                    if (item1.offers != null && item1.offers.size() > 0)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070936), Action.VIEW_OFFERS, true));
                    }
                    if (item1.isShowRevise)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070939), Action.REVISE_LISTING));
                    }
                    buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0703c1), Action.END_LISTING));
                    if (item1.isShowSellSimilar)
                    {
                        State.addSellSimilarButton(actionsfactory, resources, buttonsContainer);
                    }
                }

            };
            SELLER_ENDED = new State("SELLER_ENDED", 11) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    headerText.append(resources.getString(0x7f0704c7));
                    if (!item1.isBinOnly && !item1.finalized)
                    {
                        headerText.clear();
                    }
                    viewitemdatamanager = Util.getFormattedDateTimeStringFromDate(actionsfactory.fragment.getActivity(), item1.startDate);
                    statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0705df), viewitemdatamanager));
                    if (item1.endDate != null)
                    {
                        viewitemdatamanager = Util.getFormattedDateTimeStringFromDate(actionsfactory.fragment.getActivity(), item1.endDate);
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0703b8), viewitemdatamanager));
                        long l = (item1.endDate.getTime() - item1.startDate.getTime()) / 0x5265c00L;
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f07029e), (new com.ebay.nautilus.domain.data.BaseCommonType.TimeDuration(com.ebay.nautilus.domain.data.BaseCommonType.TimeDurationUnitEnum.CALENDAR_DAY, l)).toString(resources)));
                    }
                    statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070702), Integer.toString(item1.watchCount)));
                    statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070701), Integer.toString(item1.hitCount)));
                    buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0704de), Action.RELIST_ITEM));
                    if (item1.isShowSellSimilar)
                    {
                        State.addSellSimilarButton(actionsfactory, resources, buttonsContainer);
                    }
                }

            };
            SELLER_SOLD = new State("SELLER_SOLD", 12) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    int k = 0x7f07049e;
                    if (!"PaymentPending".equals(item1.paidStatus)) goto _L2; else goto _L1
_L1:
                    int i = 0x7f070767;
_L5:
                    k = i;
                    if (ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                    {
                        k = Util.getAfterSalesHeaderResId(item1.iTransaction, item1.isSeller, i, actionsfactory.fragment.overrideStatus);
                    }
                    headerText.append(resources.getString(k));
                    Object obj = resources.getString(0x7f0704a3);
                    long l;
                    if (item1.iTransaction.buyerFeedbackPrivate)
                    {
                        viewitemdatamanager = item1.iTransaction.buyerUserId;
                    } else
                    {
                        viewitemdatamanager = item1.iTransaction.buyerUserId;
                        int j;
                        if (item1.iTransaction.buyerFeedbackScore == null)
                        {
                            j = 0;
                        } else
                        {
                            j = item1.iTransaction.buyerFeedbackScore.intValue();
                        }
                        viewitemdatamanager = resources.getString(0x7f07050c, new Object[] {
                            viewitemdatamanager, Integer.valueOf(j)
                        });
                    }
                    viewitemdatamanager = Util.createViewItemStat(layoutinflater, viewgroup, ((String) (obj)), viewitemdatamanager, null, ActionsFactory.getBuyerClickListener(actionsfactory, item1));
                    obj = (TextView)viewitemdatamanager.findViewById(0x7f1008cc);
                    if (obj != null)
                    {
                        ((TextView) (obj)).setTextColor(actionsfactory.fragment.tertiaryColor);
                    }
                    statsContainer.add(viewitemdatamanager);
                    statsContainer.add(Util.createViewItemStatFormattedDate(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f07093b), item1.iTransaction.createdDate));
                    l = ((new Date()).getTime() - item1.iTransaction.createdDate.getTime()) / 0x5265c00L;
                    statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0704b1), Long.toString(l)));
                    if (item1.isShowPaymentReminder && com.ebay.mobile.Item.PaymentReminderState.STATE_SENT.equals(item1.paymentReminderState))
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070912), item1.paymentReminderSentDate));
                    }
                    i = item1.quantitySold;
                    if (item1.isTransacted)
                    {
                        i = item1.quantityPurchased;
                    }
                    if (i > 1)
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0708c4), Integer.toString(i)));
                    }
                    if (!item1.iTransaction.variation.nameValueList.isEmpty())
                    {
                        viewitemdatamanager = new DelimitedStringBuilder(",");
                        static class _cls4
                        {

                            static final int $SwitchMap$com$ebay$mobile$Item$PaymentReminderState[];
                            static final int $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[];

                            static 
                            {
                                $SwitchMap$com$ebay$mobile$Item$PaymentReminderState = new int[com.ebay.mobile.Item.PaymentReminderState.values().length];
                                try
                                {
                                    $SwitchMap$com$ebay$mobile$Item$PaymentReminderState[com.ebay.mobile.Item.PaymentReminderState.STATE_SENT.ordinal()] = 1;
                                }
                                catch (NoSuchFieldError nosuchfielderror7) { }
                                try
                                {
                                    $SwitchMap$com$ebay$mobile$Item$PaymentReminderState[com.ebay.mobile.Item.PaymentReminderState.STATE_ENABLED.ordinal()] = 2;
                                }
                                catch (NoSuchFieldError nosuchfielderror6) { }
                                try
                                {
                                    $SwitchMap$com$ebay$mobile$Item$PaymentReminderState[com.ebay.mobile.Item.PaymentReminderState.STATE_DISABLED.ordinal()] = 3;
                                }
                                catch (NoSuchFieldError nosuchfielderror5) { }
                                $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType = new int[com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.values().length];
                                try
                                {
                                    $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.NOT_APPLICABLE.ordinal()] = 1;
                                }
                                catch (NoSuchFieldError nosuchfielderror4) { }
                                try
                                {
                                    $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.CANCEL.ordinal()] = 2;
                                }
                                catch (NoSuchFieldError nosuchfielderror3) { }
                                try
                                {
                                    $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.CASE.ordinal()] = 3;
                                }
                                catch (NoSuchFieldError nosuchfielderror2) { }
                                try
                                {
                                    $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.INQUIRY.ordinal()] = 4;
                                }
                                catch (NoSuchFieldError nosuchfielderror1) { }
                                try
                                {
                                    $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.RETURN.ordinal()] = 5;
                                }
                                catch (NoSuchFieldError nosuchfielderror)
                                {
                                    return;
                                }
                            }
                        }

                        for (Iterator iterator = item1.iTransaction.variation.nameValueList.iterator(); iterator.hasNext(); viewitemdatamanager.append(((NameValue)iterator.next()).getValue())) { }
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070740), viewitemdatamanager.toString()));
                    }
                    if (ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, ActionsFactory.getAfterSalesReentryButtonText(item1, resources.getString(0x7f07088a), resources), Action.AFTER_SALES));
                    }
                    if (item1.isShowPaymentReminder && com.ebay.mobile.Item.PaymentReminderState.STATE_ENABLED.equals(item1.paymentReminderState))
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070769), Action.SEND_REMINDER));
                    }
                    buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070267), Action.CONTACT_USER));
                    if (item1.isShowLeaveFeedback)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0705d8), Action.LEAVE_FEEDBACK));
                    }
                    State.addMarkUnmarkPaidButton(actionsfactory, resources, buttonsContainer, item1);
                    State.addMarkUnmarkShippedButton(actionsfactory, resources, buttonsContainer, item1);
                    buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0704de), Action.RELIST_ITEM));
                    if (item1.isShowSellSimilar)
                    {
                        State.addSellSimilarButton(actionsfactory, resources, buttonsContainer);
                    }
                    if (ActionsFactory.isCancelEnabled(item1) && !ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, ActionsFactory.getAfterSalesReentryButtonText(item1, resources.getString(0x7f070885), resources), Action.CANCEL));
                    }
                      goto _L3
_L2:
                    i = k;
                    if (item1.isShowPaymentReminder)
                    {
                        i = k;
                        if (!ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                        {
                            switch (_cls4..SwitchMap.com.ebay.mobile.Item.PaymentReminderState[item1.paymentReminderState.ordinal()])
                            {
                            default:
                                i = k;
                                break;

                            case 1: // '\001'
                                subHeaderText = resources.getString(0x7f07076f);
                                i = k;
                                break;

                            case 2: // '\002'
                                subHeaderText = null;
                                i = k;
                                break;

                            case 3: // '\003'
                                subHeaderText = resources.getString(0x7f07076e);
                                i = k;
                                break;
                            }
                        }
                    }
                    if (true)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
_L3:
                    return;
                    if (true) goto _L5; else goto _L4
_L4:
                }

            };
            SELLER_PAID_OR_SHIP_TO_FUND = new State("SELLER_PAID_OR_SHIP_TO_FUND", 13) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    int i = 0x7f070507;
                    if (item1.isShipToFundItem)
                    {
                        i = 0x7f0704bd;
                        if (item1.isShipped)
                        {
                            i = 0x7f070491;
                        }
                        subHeaderText = resources.getString(0x7f0704be);
                        subHeaderButtonResource = Integer.valueOf(0x7f02024a);
                        subHeaderButtonListener = resources.getString(0x7f0704f2). new android.view.View.OnClickListener() {

                            final State._cls14 this$0;
                            final Activity val$activity;
                            final String val$shipToFunInfoTitle;

                            public void onClick(View view)
                            {
                                view = DeviceConfiguration.getAsync().get(DcsString.ShipToFundInfoUrl);
                                if (!TextUtils.isEmpty(view))
                                {
                                    ShowWebViewActivity.start(activity, view, shipToFunInfoTitle, "ShipToFundInfo");
                                }
                            }

            
            {
                this$0 = final__pcls14;
                activity = activity1;
                shipToFunInfoTitle = String.this;
                super();
            }
                        };
                    }
                    int k = i;
                    if (ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                    {
                        k = Util.getAfterSalesHeaderResId(item1.iTransaction, item1.isSeller, i, actionsfactory.fragment.overrideStatus);
                    }
                    headerText.append(resources.getString(k));
                    Object obj = Util.getDeliveryDateFormat(actionsfactory.fragment.getActivity(), false);
                    statsContainer.add(Util.createViewItemStatFormattedDate(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f07093b), item1.iTransaction.createdDate));
                    if (item1.iTransaction.paidTime != null)
                    {
                        statsContainer.add(Util.createViewItemStatFormattedDate(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f0704d6), item1.iTransaction.paidTime));
                        com.ebay.nautilus.domain.content.PaymentReminderStorageUtil.PaymentReminderStorageParams paymentreminderstorageparams = new com.ebay.nautilus.domain.content.PaymentReminderStorageUtil.PaymentReminderStorageParams();
                        paymentreminderstorageparams.id = item1.id;
                        int j;
                        long l;
                        if (item1.iTransaction != null && item1.iTransaction.createdDate != null)
                        {
                            l = item1.iTransaction.createdDate.getTime();
                        } else
                        {
                            l = 0L;
                        }
                        paymentreminderstorageparams.transactionCreationDate = l;
                        paymentreminderstorageparams.variationSpecifics = actionsfactory.viewData.nameValueList;
                        viewitemdatamanager.deleteItemFromPaymentReminderStorage(paymentreminderstorageparams);
                    }
                    if (item1.isShipToFundItem && item1.iTransaction.expectedReleaseDate != null)
                    {
                        viewitemdatamanager = (String)DateFormat.format(((CharSequence) (obj)), item1.iTransaction.expectedReleaseDate);
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0704bb), viewitemdatamanager));
                    }
                    viewitemdatamanager = ActionsFactory.getShippingServiceName(item1);
                    if (!TextUtils.isEmpty(viewitemdatamanager))
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070a6e), ViewItemShippingInfo.getPrettyShippingServiceName(item1.site, viewitemdatamanager)));
                    }
                    if (!TextUtils.isEmpty(item1.buyerAddress))
                    {
                        viewitemdatamanager = ActionsFactory.getBuyerAddressView(actionsfactory, viewgroup, item1);
                        if (viewitemdatamanager != null)
                        {
                            statsContainer.add(viewitemdatamanager);
                        }
                    }
                    if (item1.isShipped && item1.iTransaction.shipmentTrackingDetails != null && item1.iTransaction.shipmentTrackingDetails.size() > 0 && ((com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails)item1.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber != null)
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070b7e), ((com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails)item1.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber, null, true, null));
                    }
                    if (!TextUtils.isEmpty(item1.iTransaction.buyerCheckoutMessage))
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0701be), item1.iTransaction.buyerCheckoutMessage));
                    }
                    if (!TextUtils.isEmpty(item1.iTransaction.buyerPhone))
                    {
                        viewitemdatamanager = EbayPhoneNumberUtil.formatPhoneNumber(item1.iTransaction.buyerPhone, item1.iTransaction.buyerCountry);
                        if (!TextUtils.isEmpty(viewitemdatamanager))
                        {
                            statsContainer.add(Util.createViewItemStatPhone(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f0704d7), viewitemdatamanager));
                        }
                    }
                    j = item1.quantitySold;
                    if (item1.isTransacted)
                    {
                        j = item1.quantityPurchased;
                    }
                    if (j > 1)
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0708c4), Integer.toString(j)));
                    }
                    if (!item1.iTransaction.variation.nameValueList.isEmpty())
                    {
                        viewitemdatamanager = new DelimitedStringBuilder(",");
                        for (obj = item1.iTransaction.variation.nameValueList.iterator(); ((Iterator) (obj)).hasNext(); viewitemdatamanager.append(((NameValue)((Iterator) (obj)).next()).getValue())) { }
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070740), viewitemdatamanager.toString()));
                    }
                    if (ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, ActionsFactory.getAfterSalesReentryButtonText(item1, resources.getString(0x7f07088a), resources), Action.AFTER_SALES));
                    }
                    if (item1.isShipped)
                    {
                        State.showItemShippedButtons(actionsfactory, resources, buttonsContainer, item1);
                    } else
                    {
                        if (item1.isShowLeaveFeedback)
                        {
                            buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0705d8), Action.LEAVE_FEEDBACK));
                        }
                        State.addMarkUnmarkPaidButton(actionsfactory, resources, buttonsContainer, item1);
                        State.addMarkUnmarkShippedButton(actionsfactory, resources, buttonsContainer, item1);
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070267), Action.CONTACT_USER));
                    }
                    buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0704de), Action.RELIST_ITEM));
                    if (item1.isShowSellSimilar)
                    {
                        State.addSellSimilarButton(actionsfactory, resources, buttonsContainer);
                    }
                    if (item1.isShowCreateShippingLabel)
                    {
                        viewitemdatamanager = new Intent("android.intent.action.SEND");
                        viewitemdatamanager.setType("message/rfc822");
                        boolean flag;
                        if (actionsfactory.fragment.getActivity().getPackageManager().queryIntentActivities(viewitemdatamanager, 0).size() > 0)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (flag)
                        {
                            buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0707c2), Action.PRINT_SHIPPING_LABEL));
                        }
                    }
                    if (ActionsFactory.isCancelEnabled(item1) && !ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, ActionsFactory.getAfterSalesReentryButtonText(item1, resources.getString(0x7f070885), resources), Action.CANCEL));
                    }
                }

            };
            SELLER_SHIPPED = new State("SELLER_SHIPPED", 14) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    Object obj = null;
                    ArrayList arraylist = obj;
                    if (item1.tracking != null)
                    {
                        arraylist = obj;
                        if (item1.tracking.details != null)
                        {
                            arraylist = obj;
                            if (!item1.tracking.details.isEmpty())
                            {
                                arraylist = item1.tracking.details;
                            }
                        }
                    }
                    int i = 0x7f0704f3;
                    if (item1.isDelivered)
                    {
                        i = 0x7f070cd8;
                    }
                    int j = i;
                    if (ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                    {
                        j = Util.getAfterSalesHeaderResId(item1.iTransaction, item1.isSeller, i, actionsfactory.fragment.overrideStatus);
                    }
                    headerText.append(resources.getString(j));
                    if (!item1.isDelivered)
                    {
                        statsContainer.add(Util.createViewItemStatFormattedDate(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f07093b), item1.iTransaction.createdDate));
                        if (item1.iTransaction.paidTime != null)
                        {
                            statsContainer.add(Util.createViewItemStatFormattedDate(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f0704d6), item1.iTransaction.paidTime));
                            com.ebay.nautilus.domain.content.PaymentReminderStorageUtil.PaymentReminderStorageParams paymentreminderstorageparams = new com.ebay.nautilus.domain.content.PaymentReminderStorageUtil.PaymentReminderStorageParams();
                            paymentreminderstorageparams.id = item1.id;
                            long l;
                            if (item1.iTransaction != null && item1.iTransaction.createdDate != null)
                            {
                                l = item1.iTransaction.createdDate.getTime();
                            } else
                            {
                                l = 0L;
                            }
                            paymentreminderstorageparams.transactionCreationDate = l;
                            paymentreminderstorageparams.variationSpecifics = actionsfactory.viewData.nameValueList;
                            viewitemdatamanager.deleteItemFromPaymentReminderStorage(paymentreminderstorageparams);
                        }
                        if (item1.iTransaction.orderShippingInfo != null && item1.iTransaction.orderShippingInfo.shippedDate != null)
                        {
                            statsContainer.add(Util.createViewItemStatFormattedDate(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f0704ee), item1.iTransaction.orderShippingInfo.shippedDate));
                        }
                        viewitemdatamanager = ActionsFactory.getShippingServiceName(item1);
                        if (!TextUtils.isEmpty(viewitemdatamanager))
                        {
                            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070a6e), ViewItemShippingInfo.getPrettyShippingServiceName(item1.site, viewitemdatamanager)));
                        }
                    } else
                    {
                        viewitemdatamanager = (String)DateFormat.format(Util.getDeliveryDateFormat(actionsfactory.fragment.getActivity(), true), item1.iTransaction.orderShippingInfo.actualDeliveryDate);
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070288), viewitemdatamanager));
                    }
                    if (!TextUtils.isEmpty(item1.buyerAddress))
                    {
                        viewitemdatamanager = ActionsFactory.getBuyerAddressView(actionsfactory, viewgroup, item1);
                        if (viewitemdatamanager != null)
                        {
                            statsContainer.add(viewitemdatamanager);
                        }
                    }
                    if (item1.isShipped && item1.iTransaction.shipmentTrackingDetails != null && item1.iTransaction.shipmentTrackingDetails.size() > 0 && ((com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails)item1.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber != null)
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070b7e), ((com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails)item1.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber));
                    }
                    if (arraylist != null)
                    {
                        viewitemdatamanager = State.getFirstTrackingScanDetail(actionsfactory.fragment.getActivity(), arraylist);
                        if (!TextUtils.isEmpty(viewitemdatamanager))
                        {
                            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, "", viewitemdatamanager));
                        }
                    }
                    if (ActionsFactory.hasAfterSalesStarted(item1.iTransaction))
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, ActionsFactory.getAfterSalesReentryButtonText(item1, resources.getString(0x7f07088a), resources), Action.AFTER_SALES));
                    }
                    if (item1.isShowTrackPackage && arraylist != null)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f070ab8), Action.TRACK_PACKAGE));
                    }
                    State.showItemShippedButtons(actionsfactory, resources, buttonsContainer, item1);
                    State.addMarkUnmarkPaidButton(actionsfactory, resources, buttonsContainer, item1);
                    State.addMarkUnmarkShippedButton(actionsfactory, resources, buttonsContainer, item1);
                    buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0704de), Action.RELIST_ITEM));
                    if (item1.isShowSellSimilar)
                    {
                        State.addSellSimilarButton(actionsfactory, resources, buttonsContainer);
                    }
                }

            };
            EBAY_NOW = new State("EBAY_NOW", 15) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    Activity activity;
                    activity = actionsfactory.fragment.getActivity();
                    headerText.append(EbayNowUtil.getDeliveryStatusText(activity, item1.iTransaction, item1.tracking));
                    if (!"Cancelled".equals(item1.iTransaction.orderStatus)) goto _L2; else goto _L1
_L1:
                    String s1 = EbayCurrencyUtil.formatDisplay(item1.iTransaction.transactionPrice, 0);
                    String s = item1.displayPriceShippingConverted;
                    viewitemdatamanager = s;
                    if (TextUtils.isEmpty(s))
                    {
                        viewitemdatamanager = item1.displayPriceShipping;
                    }
                    statsContainer.add(Util.createViewItemStatPrice(layoutinflater, viewgroup, s1, viewitemdatamanager));
                    statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0703eb), EbayNowUtil.getCancelledReason(activity, item1.iTransaction)));
_L4:
                    if (item1.iTransaction.shipmentTrackingDetails != null && item1.iTransaction.shipmentTrackingDetails.size() > 0 && ((com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails)item1.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber != null)
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070b7e), ((com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails)item1.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber));
                    }
                    buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0704d5), Action.EBAY_NOW_ORDER_DETAILS));
                    buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f07070c), Action.CONTACT_USER));
                    if (item1.isShowLeaveFeedback)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0705d8), Action.LEAVE_FEEDBACK));
                    }
                    return;
_L2:
                    boolean flag;
                    if (EbayNowUtil.getOrderState(item1.iTransaction, item1.tracking) == com.ebay.mobile.util.EbayNowUtil.EbnOrderState.PENDING)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag && item1.iTransaction.paidTime != null)
                    {
                        viewitemdatamanager = (String)DateFormat.format(Util.getDeliveryDateFormat(activity, false), item1.iTransaction.paidTime);
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070495), viewitemdatamanager));
                    }
                    if (item1.isDelivered)
                    {
                        viewitemdatamanager = (String)DateFormat.format(Util.getDeliveryDateFormat(activity, true), item1.iTransaction.orderShippingInfo.actualDeliveryDate);
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070288), viewitemdatamanager));
                    }
                    if (!item1.isDelivered)
                    {
                        Date date = item1.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate;
                        viewitemdatamanager = date;
                        if (item1.tracking != null)
                        {
                            viewitemdatamanager = date;
                            if (item1.tracking.estimatedDeliveryDate != null)
                            {
                                viewitemdatamanager = item1.tracking.estimatedDeliveryDate;
                            }
                        }
                        if (viewitemdatamanager != null)
                        {
                            viewitemdatamanager = Util.formattedTimeAndDate(resources.getString(0x7f07038d), viewitemdatamanager);
                            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0703eb), viewitemdatamanager));
                        }
                    }
                    if (!flag && item1.iTransaction.selectedShippingOption.shippingServiceName != null)
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070a6e), ViewItemShippingInfo.getPrettyShippingServiceName(item1.site, item1.iTransaction.selectedShippingOption.shippingServiceName)));
                    }
                    if (item1.buyerAddress != null)
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070b6b), item1.buyerAddress));
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            };
            PICKUP = new State("PICKUP", 16) {

                public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item1, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
                {
                    int i = 0;
                    viewitemdatamanager = actionsfactory.fragment.getActivity();
                    headerText.append(PickupUtil.getOrderStatusText(viewitemdatamanager, item1.iTransaction, null));
                    if (item1.iTransaction.pickupStatus == OrderPickupStatus.PendingMerchantConfirmation && item1.iTransaction.orderShippingInfo != null && item1.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate != null)
                    {
                        subHeaderText = resources.getString(0x7f070181, new Object[] {
                            DateFormat.getMediumDateFormat(viewitemdatamanager).format(item1.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate)
                        });
                    }
                    String s = PickupUtil.getPickupCode(item1.iTransaction.merchantPickupCode);
                    if (!TextUtils.isEmpty(s))
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070794), s));
                    }
                    if (item1.inventoryInfo != null)
                    {
                        StoreAvailability storeavailability = item1.inventoryInfo.getSelectedStore();
                        if (storeavailability != null)
                        {
                            if (storeavailability.address != null)
                            {
                                statsContainer.add(Util.createViewItemStatCopiable(viewitemdatamanager, layoutinflater, viewgroup, resources.getString(0x7f070796), PickupUtil.formatStoreAddress(storeavailability.address)));
                            }
                            if (!TextUtils.isEmpty(storeavailability.phone))
                            {
                                statsContainer.add(Util.createViewItemStatPhone(viewitemdatamanager, layoutinflater, viewgroup, resources.getString(0x7f070773), storeavailability.phone));
                            }
                            if (storeavailability.hours != null)
                            {
                                if (item1.iTransaction.orderShippingInfo != null)
                                {
                                    i = ActionsFactory.daysToOffsetStoreHours(item1.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate);
                                }
                                viewitemdatamanager = PickupUtil.formatStoreHours(viewitemdatamanager, storeavailability.hours, i);
                                if (!TextUtils.isEmpty(viewitemdatamanager))
                                {
                                    statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070193), viewitemdatamanager));
                                }
                            }
                        }
                    }
                    buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0704d5), Action.IN_STORE_PICKUP_ORDER_DETAILS));
                    if (item1.isShowLeaveFeedback)
                    {
                        buttonsContainer.add(ActionsFactory.getActionButton(actionsfactory, resources.getString(0x7f0705d8), Action.LEAVE_FEEDBACK));
                    }
                }

            };
            $VALUES = (new State[] {
                BIDDING, BEST_OFFER, BEST_OFFER_EXPIRED, BEST_OFFER_DECLINED, BEST_OFFER_NEGOTIATION, BEST_OFFER_MULTI_OFFERS, BOUGHT, BOUGHT_AND_PAID, ENDED, REFUNDED, 
                SELLER_SCHEDULED_OR_ACTIVE, SELLER_ENDED, SELLER_SOLD, SELLER_PAID_OR_SHIP_TO_FUND, SELLER_SHIPPED, EBAY_NOW, PICKUP
            });
        }






        private State(String s, int i)
        {
            super(s, i);
            headerText = new SpannableStringBuilder();
            subHeaderText = null;
            afterSalesHeaderOverride = null;
            subHeaderButtonResource = null;
            subHeaderButtonListener = null;
            statsContainer = null;
            buttonsContainer = null;
        }

    }


    public static final String ACTIONS_BUTTON_TAG = "actions_button_";
    private String afterSalesStatusOverride;
    ViewItemActionsFragment fragment;
    private Item item;
    private State state;
    private ViewItemViewData viewData;
    private final ViewItemDataManager viewItemDataManager;

    public ActionsFactory(ViewItemActionsFragment viewitemactionsfragment, Item item1, ViewItemViewData viewitemviewdata, ViewItemDataManager viewitemdatamanager)
    {
        state = null;
        afterSalesStatusOverride = null;
        fragment = viewitemactionsfragment;
        item = item1;
        viewData = viewitemviewdata;
        viewItemDataManager = viewitemdatamanager;
    }

    private static int daysToOffsetStoreHours(Date date)
    {
        int i = 0;
        if (date != null)
        {
            i = PickupUtil.getDaysModifierFromFulfillmentTime(Long.valueOf(date.getTime() - EbayResponse.getHostTime(System.currentTimeMillis())));
        }
        return i;
    }

    private static View getActionButton(ActionsFactory actionsfactory, String s, Action action)
    {
        return getActionButton(actionsfactory, s, action, false);
    }

    private static View getActionButton(ActionsFactory actionsfactory, String s, Action action, boolean flag)
    {
        ViewGroup viewgroup;
        TextImageButton textimagebutton;
        if (flag)
        {
            viewgroup = (ViewGroup)LayoutInflater.from(actionsfactory.fragment.getActivity()).inflate(0x7f03027d, null);
        } else
        {
            viewgroup = (ViewGroup)LayoutInflater.from(actionsfactory.fragment.getActivity()).inflate(0x7f03027c, null);
        }
        textimagebutton = (TextImageButton)viewgroup.findViewById(0x7f100089);
        textimagebutton.setText(s);
        textimagebutton.setTag((new StringBuilder()).append("actions_button_").append(action.ordinal()).toString());
        textimagebutton.setOnClickListener(new android.view.View.OnClickListener(action, actionsfactory) {

            final Action val$action;
            final ActionsFactory val$factory;

            public void onClick(View view)
            {
                action.execute(factory);
            }

            
            {
                action = action1;
                factory = actionsfactory;
                super();
            }
        });
        return viewgroup;
    }

    private static String getAfterSalesReentryButtonText(Item item1, String s, Resources resources)
    {
        item1 = getAfterSalesType(item1);
        switch (_cls4..SwitchMap.com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType[item1.ordinal()])
        {
        case 1: // '\001'
        default:
            return s;

        case 2: // '\002'
            return resources.getString(0x7f070886);

        case 3: // '\003'
            return resources.getString(0x7f070888);

        case 4: // '\004'
            return resources.getString(0x7f07088b);

        case 5: // '\005'
            return resources.getString(0x7f07088c);
        }
    }

    private static com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType getAfterSalesType(Item item1)
    {
        com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType aftersalestype;
        ItemTransaction itemtransaction;
        aftersalestype = com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.NOT_APPLICABLE;
        itemtransaction = item1.iTransaction;
        item1 = aftersalestype;
        if (itemtransaction == null) goto _L2; else goto _L1
_L1:
        if (TextUtils.isEmpty(itemtransaction.returnStatus) || TextUtils.equals(itemtransaction.returnStatus, "NotApplicable")) goto _L4; else goto _L3
_L3:
        if (!itemtransaction.returnStatus.contains("Escalated")) goto _L6; else goto _L5
_L5:
        item1 = com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.CASE;
_L2:
        return item1;
_L6:
        return com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.RETURN;
_L4:
        if (!TextUtils.isEmpty(itemtransaction.inquiryStatus) && !TextUtils.equals(itemtransaction.inquiryStatus, "NotApplicable"))
        {
            if (itemtransaction.inquiryStatus.contains("Escalated"))
            {
                return com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.CASE;
            } else
            {
                return com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.INQUIRY;
            }
        }
        item1 = aftersalestype;
        if (!TextUtils.isEmpty(itemtransaction.cancelStatus))
        {
            item1 = aftersalestype;
            if (!TextUtils.equals(itemtransaction.cancelStatus, "NotApplicable"))
            {
                return com.ebay.mobile.activities.AfterSalesWebViewActivity.AfterSalesType.CANCEL;
            }
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    private static View getBuyerAddressView(ActionsFactory actionsfactory, ViewGroup viewgroup, Item item1)
    {
label0:
        {
            Object obj1 = null;
            Object obj = obj1;
            if (actionsfactory != null)
            {
                obj = obj1;
                if (actionsfactory.fragment != null)
                {
                    obj = obj1;
                    if (viewgroup != null)
                    {
                        obj = obj1;
                        if (item1 != null)
                        {
                            String s = item1.buyerAddress;
                            obj = s;
                            if (item1.iTransaction != null)
                            {
                                obj = s;
                                if (item1.iTransaction.multiLeg)
                                {
                                    obj = new SpannableStringBuilder();
                                    if (!TextUtils.isEmpty(item1.iTransaction.multiLegName))
                                    {
                                        ((SpannableStringBuilder) (obj)).append(item1.iTransaction.multiLegName).append("\n");
                                    }
                                    if (!TextUtils.isEmpty(item1.iTransaction.multiLegReferenceId))
                                    {
                                        ((SpannableStringBuilder) (obj)).append(actionsfactory.fragment.getString(0x7f0708e0, new Object[] {
                                            item1.iTransaction.multiLegReferenceId
                                        })).append("\n");
                                    }
                                    if (!TextUtils.isEmpty(item1.iTransaction.multiLegStreet1))
                                    {
                                        ((SpannableStringBuilder) (obj)).append(item1.iTransaction.multiLegStreet1).append("\n");
                                    }
                                    if (!TextUtils.isEmpty(item1.iTransaction.multiLegStreet2))
                                    {
                                        ((SpannableStringBuilder) (obj)).append(item1.iTransaction.multiLegStreet2).append("\n");
                                    }
                                    ((SpannableStringBuilder) (obj)).append(com.ebay.nautilus.domain.data.Address.AddressFields.getCityStatePostalString(item1.iTransaction.multiLegCityName, item1.iTransaction.multiLegStateOrProvince, item1.iTransaction.multiLegPostalCode, item1.iTransaction.multiLegCountry, false)).append("\n");
                                    if (!TextUtils.isEmpty(item1.iTransaction.multiLegCountry))
                                    {
                                        ((SpannableStringBuilder) (obj)).append(item1.iTransaction.multiLegCountry);
                                    }
                                    obj = ((SpannableStringBuilder) (obj)).toString();
                                }
                            }
                            viewgroup = Util.createViewItemStat(actionsfactory.fragment.inflater, viewgroup, actionsfactory.fragment.resources.getString(0x7f0704a4), ((CharSequence) (obj)), null, getBuyerClickListener(actionsfactory, item1));
                            item1 = (TextView)viewgroup.findViewById(0x7f1008cc);
                            obj = viewgroup;
                            if (item1 != null)
                            {
                                obj = viewgroup;
                                if (item1.getText() != null)
                                {
                                    obj = viewgroup;
                                    if (item1.getText().length() > 0)
                                    {
                                        int i = item1.getText().toString().indexOf("\n");
                                        if (i <= 0)
                                        {
                                            break label0;
                                        }
                                        obj = new SpannableStringBuilder(item1.getText());
                                        ((SpannableStringBuilder) (obj)).setSpan(new ForegroundColorSpan(actionsfactory.fragment.tertiaryColor), 0, i, 33);
                                        item1.setText(((CharSequence) (obj)), android.widget.TextView.BufferType.SPANNABLE);
                                        obj = viewgroup;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return ((View) (obj));
        }
        item1.setTextColor(actionsfactory.fragment.tertiaryColor);
        return viewgroup;
    }

    private static android.view.View.OnClickListener getBuyerClickListener(ActionsFactory actionsfactory, Item item1)
    {
        return new android.view.View.OnClickListener(actionsfactory, item1) {

            final ActionsFactory val$factory;
            final Item val$item;

            public void onClick(View view)
            {
                UserDetailActivity.StartActivityForBuyer(factory.fragment.getActivity(), factory.fragment.viewData, item.iTransaction.buyerUserId, null, null);
            }

            
            {
                factory = actionsfactory;
                item = item1;
                super();
            }
        };
    }

    private static View getCompoundActionArea(ActionsFactory actionsfactory, String s, String s1, Action action)
    {
        return getCompoundActionArea(actionsfactory, s, s1, action, false);
    }

    private static View getCompoundActionArea(ActionsFactory actionsfactory, String s, String s1, Action action, boolean flag)
    {
        View view;
        Button button;
        if (flag)
        {
            view = LayoutInflater.from(actionsfactory.fragment.getActivity()).inflate(0x7f030287, null);
        } else
        {
            view = LayoutInflater.from(actionsfactory.fragment.getActivity()).inflate(0x7f030286, null);
        }
        if (!TextUtils.isEmpty(s))
        {
            TextView textview = (TextView)view.findViewById(0x7f10089f);
            textview.setText(s);
            textview.setVisibility(0);
        }
        s = (PriceView)view.findViewById(0x7f1008a0);
        s.setCurrency(EbaySite.getInstanceFromId(actionsfactory.item.site).getCurrency().getCurrencyCode());
        button = (Button)view.findViewById(0x7f100089);
        button.setText(s1);
        button.setOnClickListener(new android.view.View.OnClickListener(action, actionsfactory, s) {

            final Action val$action;
            final PriceView val$amountEditor;
            final ActionsFactory val$factory;

            public void onClick(View view1)
            {
                action.execute(factory, Double.valueOf(amountEditor.getPrice()));
            }

            
            {
                action = action1;
                factory = actionsfactory;
                amountEditor = priceview;
                super();
            }
        });
        return view;
    }

    static String getConvertedPriceAndShipping(Context context, String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append(s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            stringbuilder.append(" ").append(s1);
        }
        return String.format(context.getString(0x7f070170), new Object[] {
            stringbuilder.toString()
        });
    }

    private static String getShippingServiceName(Item item1)
    {
        String s;
        if (item1 == null)
        {
            s = null;
        } else
        {
            String s1 = item1.iTransaction.selectedShippingOption.shippingServiceName;
            s = s1;
            if (item1.iTransaction.multiLeg)
            {
                s = s1;
                if (!TextUtils.isEmpty(item1.iTransaction.multiLegServiceName))
                {
                    return item1.iTransaction.multiLegServiceName;
                }
            }
        }
        return s;
    }

    public static State getStateForItem(Item item1, ViewItemViewData viewitemviewdata, ViewItemDataManager viewitemdatamanager)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = MyApp.getPrefs().getCurrentUser();
        if (!item1.isTransactedViaEbn) goto _L2; else goto _L1
_L1:
        viewitemdatamanager = State.EBAY_NOW;
_L4:
        if (ViewItemActionsFragment.verboseLogger.isLoggable)
        {
            ViewItemActionsFragment.verboseLogger.log((new StringBuilder()).append("ActionsFactory state = ").append(viewitemdatamanager).toString());
        }
        return viewitemdatamanager;
_L2:
        if (!item1.isSeller && item1.isTransacted && (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.ISPU.longName.equals(item1.iTransaction.selectedMethod) || com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO.altName.equals(item1.iTransaction.selectedMethod)))
        {
            viewitemdatamanager = State.PICKUP;
            continue; /* Loop/switch isn't completed */
        }
        if (item1.isRefunded)
        {
            viewitemdatamanager = State.REFUNDED;
            continue; /* Loop/switch isn't completed */
        }
        if (item1.isShowPayNow || item1.isShowPaymentOptions)
        {
            viewitemdatamanager = State.BOUGHT;
            continue; /* Loop/switch isn't completed */
        }
        if (!item1.isSeller && item1.isTransacted)
        {
            viewitemdatamanager = State.BOUGHT;
            if (item1.isPaid)
            {
                viewitemdatamanager = State.BOUGHT_AND_PAID;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!item1.isSeller && item1.isAuctionEnded && viewitemviewdata.finalized)
        {
            viewitemdatamanager = State.ENDED;
            continue; /* Loop/switch isn't completed */
        }
        if (!item1.isSeller && !item1.isAuctionEnded && !item1.isBinOnly && viewitemdatamanager.isInMyEbayBidList(item1.id, viewitemviewdata.nameValueList))
        {
            viewitemdatamanager = State.BIDDING;
            continue; /* Loop/switch isn't completed */
        }
        if (item1.bestOfferEnabled && item1.offers != null && !item1.offers.isEmpty() && !item1.isTransacted && (isItemBestOfferWorthyForBuyer(item1, viewitemviewdata) || item1.isSeller && (item1.quantity > 1 && viewitemviewdata.kind != com.ebay.common.ConstantsCommon.ItemKind.Selling && viewitemviewdata.kind != com.ebay.common.ConstantsCommon.ItemKind.Found || item1.quantity == 1) && (item1.numberOfPendingBestOffersForSeller() > 0 || item1.numberOfUniqueBuyersWithOffersForSeller() == 1)))
        {
            obj1 = item1.newestBestOffer(((String) (obj1)));
            if (obj1 != null)
            {
                viewitemviewdata = State.BEST_OFFER;
                if (item1.isSeller && item1.numberOfUniqueBuyersWithOffersForSeller() > 1)
                {
                    viewitemdatamanager = State.BEST_OFFER_MULTI_OFFERS;
                    continue; /* Loop/switch isn't completed */
                }
                if (item1.isSeller && item1.isAuctionEnded)
                {
                    viewitemdatamanager = State.SELLER_ENDED;
                    continue; /* Loop/switch isn't completed */
                }
                if (!item1.isSeller && "SellerCounterOffer".equals(((BestOffer) (obj1)).codeType) && ((BestOffer) (obj1)).status.equals("Retracted"))
                {
                    viewitemdatamanager = null;
                    continue; /* Loop/switch isn't completed */
                }
                if (item1.isSeller && !item1.isAuctionEnded && (item1.isOfferListAllExpired() || item1.isOfferListAllDeclined()))
                {
                    viewitemdatamanager = State.SELLER_SCHEDULED_OR_ACTIVE;
                    continue; /* Loop/switch isn't completed */
                }
                if ("Expired".equals(((BestOffer) (obj1)).status))
                {
                    viewitemdatamanager = State.BEST_OFFER_EXPIRED;
                    continue; /* Loop/switch isn't completed */
                }
                if ("Declined".equals(((BestOffer) (obj1)).status))
                {
                    viewitemdatamanager = State.BEST_OFFER_DECLINED;
                    continue; /* Loop/switch isn't completed */
                }
                if (!"SellerCounterOffer".equals(((BestOffer) (obj1)).codeType))
                {
                    viewitemdatamanager = viewitemviewdata;
                    if (!item1.isSeller)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    if (!"BuyerBestOffer".equals(((BestOffer) (obj1)).codeType))
                    {
                        viewitemdatamanager = viewitemviewdata;
                        if (!"BuyerCounterOffer".equals(((BestOffer) (obj1)).codeType))
                        {
                            continue; /* Loop/switch isn't completed */
                        }
                    }
                }
                viewitemdatamanager = State.BEST_OFFER_NEGOTIATION;
                continue; /* Loop/switch isn't completed */
            }
        }
        viewitemdatamanager = obj;
        if (item1.isSeller)
        {
            viewitemdatamanager = State.SELLER_SCHEDULED_OR_ACTIVE;
            if (item1.isAuctionEnded || com.ebay.common.ConstantsCommon.ItemKind.Sold.equals(viewitemviewdata.kind))
            {
                if (item1.isShipped && !item1.isShipToFundItem)
                {
                    viewitemdatamanager = State.SELLER_SHIPPED;
                } else
                if (item1.isPaid)
                {
                    viewitemdatamanager = State.SELLER_PAID_OR_SHIP_TO_FUND;
                } else
                if (item1.isTransacted)
                {
                    viewitemdatamanager = State.SELLER_SOLD;
                } else
                {
                    viewitemdatamanager = State.SELLER_ENDED;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static ItemCurrency getTotalConvertedCurrency(ItemTransaction itemtransaction)
    {
        ItemCurrency itemcurrency1 = itemtransaction.convertedTransactionPrice;
        ItemCurrency itemcurrency = itemcurrency1;
        if (itemtransaction.quantityPurchased > 1)
        {
            itemcurrency = (new CurrencyAmount(itemcurrency1)).multiplyBy(itemtransaction.quantityPurchased).toItemCurrency();
        }
        return itemcurrency;
    }

    private static boolean hasAfterSalesStarted(ItemTransaction itemtransaction)
    {
        if (itemtransaction != null && MyApp.getDeviceConfiguration().isAfterSalesEnabled())
        {
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (itemtransaction.cancelStatus != null && !TextUtils.equals(itemtransaction.cancelStatus, "NotApplicable"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (itemtransaction.returnStatus != null && !TextUtils.equals(itemtransaction.returnStatus, "NotApplicable"))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (itemtransaction.inquiryStatus != null && !TextUtils.equals(itemtransaction.inquiryStatus, "NotApplicable"))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag || flag2 || flag1)
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isCancelEnabled(Item item1)
    {
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        boolean flag;
        if (EbayResponse.currentHostTime() - item1.iTransaction.createdDate.getTime() < 0x9a7ec800L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return dcshelper.isAfterSalesEnabled() && !hasAfterSalesStarted(item1.iTransaction) && flag && !item1.isShipped;
    }

    static boolean isItemBestOfferWorthyForBuyer(Item item1, ViewItemViewData viewitemviewdata)
    {
        boolean flag;
        if (item1 == null || viewitemviewdata == null || item1.isSeller)
        {
            flag = false;
        } else
        {
            boolean flag1 = true;
            flag = flag1;
            if (item1.quantity > 1)
            {
                flag = flag1;
                if (!item1.isAuctionEnded)
                {
                    flag = flag1;
                    if (viewitemviewdata.kind == com.ebay.common.ConstantsCommon.ItemKind.Found)
                    {
                        return false;
                    }
                }
            }
        }
        return flag;
    }

    public View getView(ViewGroup viewgroup)
    {
        View view = null;
        state = getStateForItem(item, viewData, viewItemDataManager);
        if (state != null)
        {
            state.update(this, viewgroup);
            if (afterSalesStatusOverride != null)
            {
                state.addHeaderOverride(afterSalesStatusOverride, item, fragment.resources);
            }
            view = state.getView(fragment.getActivity(), viewgroup);
        }
        return view;
    }

    boolean hasAddedButtonsToView()
    {
        return state != null && state.hasAddedButtonsToView();
    }

    public void setAfterSalesStatusOverride(String s)
    {
        afterSalesStatusOverride = s;
    }

    public void setItemData(Item item1, ViewItemViewData viewitemviewdata)
    {
        item = item1;
        viewData = viewitemviewdata;
    }















}
