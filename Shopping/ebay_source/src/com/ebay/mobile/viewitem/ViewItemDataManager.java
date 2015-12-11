// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.util.Pair;
import com.ebay.common.CurrencyConversionCache;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.content.EbayCguidGetter;
import com.ebay.common.model.AllBiddersData;
import com.ebay.common.model.EbayProduct;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.ItemTransactionVariation;
import com.ebay.common.model.OrderShippingInfo;
import com.ebay.common.model.Payment;
import com.ebay.common.model.PlaceOfferResult;
import com.ebay.common.model.Refund;
import com.ebay.common.model.ShippingCostsTaxJurisdiction;
import com.ebay.common.model.cart.Incentive;
import com.ebay.common.model.cart.ItemIncentives;
import com.ebay.common.model.cart.RewardsIncentive;
import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.inventory.LocationDetails;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.common.net.api.currency.CurrencyConversionDataManager;
import com.ebay.common.net.api.inventory.GetLocationDetailsRequest;
import com.ebay.common.net.api.inventory.GetLocationDetailsResponse;
import com.ebay.common.net.api.inventory.LookupAvailabilityRequest;
import com.ebay.common.net.api.inventory.LookupAvailabilityResponse;
import com.ebay.common.net.api.local.EbayNowInventoryLookupDataManager;
import com.ebay.common.net.api.shipping.GetOrderShippingInfoRequest;
import com.ebay.common.net.api.shipping.GetOrderShippingInfoResponse;
import com.ebay.common.net.api.shipping.GetShipmentTrackingRequest;
import com.ebay.common.net.api.shipping.GetShipmentTrackingResponse;
import com.ebay.common.net.api.shopping.FindProductsRequest;
import com.ebay.common.net.api.shopping.FindProductsResponse;
import com.ebay.common.net.api.trading.CompleteSaleRequest;
import com.ebay.common.net.api.trading.CompleteSaleResponse;
import com.ebay.common.net.api.trading.EndItemRequest;
import com.ebay.common.net.api.trading.GetBestOffersRequest;
import com.ebay.common.net.api.trading.GetBestOffersResponse;
import com.ebay.common.net.api.trading.GetItemTransactionsRequest;
import com.ebay.common.net.api.trading.GetItemTransactionsResponse;
import com.ebay.common.net.api.trading.GetOrdersRequest;
import com.ebay.common.net.api.trading.GetOrdersResponse;
import com.ebay.common.net.api.trading.LeaveFeedbackParameters;
import com.ebay.common.net.api.trading.LeaveFeedbackRequest;
import com.ebay.common.net.api.trading.PlaceOfferRequest;
import com.ebay.common.net.api.trading.PlaceOfferResponse;
import com.ebay.common.net.api.trading.RespondToBestOfferRequest;
import com.ebay.common.net.api.trading.RespondToBestOfferResponse;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.util.EbaySettings;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.Item;
import com.ebay.mobile.ItemViewPayPalable;
import com.ebay.mobile.ItemViewShipping;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.bestoffer.BestOfferTracking;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.dcs.DcsInteger;
import com.ebay.mobile.dcs.DcsLong;
import com.ebay.mobile.experimentation.ExperimentationUtil;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.recents.RecentsDataManager;
import com.ebay.mobile.shoppingcart.LocalizedCartMessage;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.LocationUtil;
import com.ebay.mobile.util.PickupUtil;
import com.ebay.mobile.viewitem.fragments.ViewItemFragmentUtil;
import com.ebay.mobile.viewitem.message.PlaceOfferResultStatus;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;
import com.ebay.nautilus.domain.content.PaymentReminderStorageUtil;
import com.ebay.nautilus.domain.content.ServiceContentOverride;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.content.dm.CategoriesDataManager;
import com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager;
import com.ebay.nautilus.domain.content.dm.MyEbaySellingDataManager;
import com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.EbayItemIdAndVariationSpecifics;
import com.ebay.nautilus.domain.data.EbayTransactedItemSpecifics;
import com.ebay.nautilus.domain.data.ErrorMessageDetails;
import com.ebay.nautilus.domain.data.ImmutableNameValue;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.data.ProductListingDetails;
import com.ebay.nautilus.domain.data.SellingListRefinement;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.data.ShoppingCart;
import com.ebay.nautilus.domain.data.UserDefinedList;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.DataRequest;
import com.ebay.nautilus.domain.net.DataResponse;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.api.experimentation.ExperimentationDataManager;
import com.ebay.nautilus.domain.net.api.lds.ListingCategoryFilters;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.viewlisting.GetViewListingRequest;
import com.ebay.nautilus.domain.net.api.viewlisting.GetViewListingResponse;
import com.ebay.nautilus.domain.net.api.viewlisting.Listing;
import com.ebay.nautilus.domain.net.api.viewlisting.ListingDetails;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.FwLog;
import com.google.android.gms.maps.model.LatLng;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.mobile.viewitem:
//            BiddingDataManager, ViewItemViewData, ViewItemShippingInfo, ItemViewBiddingUpdater, 
//            ItemViewBidTracking, ShippingDetailsDataManager, ItemViewBaseActivity, ItemMapper

public class ViewItemDataManager extends DataManager
    implements com.ebay.common.net.api.currency.CurrencyConversionDataManager.Observer, BiddingDataManager.Observer, ShippingDetailsDataManager.Observer, com.ebay.nautilus.domain.content.dm.AddressDataManager.Observer, com.ebay.nautilus.domain.content.dm.CategoriesDataManager.Observer, com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager.Observer, com.ebay.nautilus.domain.content.dm.MyEbaySellingDataManager.Observer, com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.Observer, com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Observer, com.ebay.nautilus.domain.content.dm.UserContextDataManager.Observer, com.ebay.nautilus.domain.net.api.experimentation.ExperimentationDataManager.Observer
{
    public static final class ActionHandled extends Enum
    {

        private static final ActionHandled $VALUES[];
        public static final ActionHandled BEST_OFFER;
        public static final ActionHandled BIDDING_HISTORY;
        public static final ActionHandled BID_CHANGE;
        public static final ActionHandled BOPIS_AVAILABILITY;
        public static final ActionHandled CART_UPDATED;
        public static final ActionHandled CURRENCY_RATE_UPDATED;
        public static final ActionHandled FEEDBACK_LEFT;
        public static final ActionHandled GET_BEST_OFFERS;
        public static final ActionHandled GET_ITEM_FLAGS_REFRESHED;
        public static final ActionHandled GET_ORDERS;
        public static final ActionHandled GET_SHIPMENT_TRACKING;
        public static final ActionHandled INITIAL_LOAD;
        public static final ActionHandled ITEM_ADDED_TO_CART;
        public static final ActionHandled ITEM_DESCRIPTION;
        public static final ActionHandled ITEM_ENDED_BY_SELLER;
        public static final ActionHandled MARK_PAID_OR_UNPAID;
        public static final ActionHandled MARK_SHIPPED_OR_UNSHIPPED;
        public static final ActionHandled PAYMENT_REMINDER_SENT;
        public static final ActionHandled PRODUCT_INFO;
        public static final ActionHandled RESPOND_BEST_OFFER;
        public static final ActionHandled SHIPMENT_TRACKING;
        public static final ActionHandled SHIPPING_COSTS;
        public static final ActionHandled WATCH_CHANGED;

        public static ActionHandled valueOf(String s)
        {
            return (ActionHandled)Enum.valueOf(com/ebay/mobile/viewitem/ViewItemDataManager$ActionHandled, s);
        }

        public static ActionHandled[] values()
        {
            return (ActionHandled[])$VALUES.clone();
        }

        static 
        {
            INITIAL_LOAD = new ActionHandled("INITIAL_LOAD", 0);
            WATCH_CHANGED = new ActionHandled("WATCH_CHANGED", 1);
            ITEM_ENDED_BY_SELLER = new ActionHandled("ITEM_ENDED_BY_SELLER", 2);
            SHIPMENT_TRACKING = new ActionHandled("SHIPMENT_TRACKING", 3);
            MARK_PAID_OR_UNPAID = new ActionHandled("MARK_PAID_OR_UNPAID", 4);
            MARK_SHIPPED_OR_UNSHIPPED = new ActionHandled("MARK_SHIPPED_OR_UNSHIPPED", 5);
            BOPIS_AVAILABILITY = new ActionHandled("BOPIS_AVAILABILITY", 6);
            ITEM_ADDED_TO_CART = new ActionHandled("ITEM_ADDED_TO_CART", 7);
            CART_UPDATED = new ActionHandled("CART_UPDATED", 8);
            CURRENCY_RATE_UPDATED = new ActionHandled("CURRENCY_RATE_UPDATED", 9);
            BID_CHANGE = new ActionHandled("BID_CHANGE", 10);
            ITEM_DESCRIPTION = new ActionHandled("ITEM_DESCRIPTION", 11);
            PRODUCT_INFO = new ActionHandled("PRODUCT_INFO", 12);
            SHIPPING_COSTS = new ActionHandled("SHIPPING_COSTS", 13);
            FEEDBACK_LEFT = new ActionHandled("FEEDBACK_LEFT", 14);
            GET_SHIPMENT_TRACKING = new ActionHandled("GET_SHIPMENT_TRACKING", 15);
            GET_BEST_OFFERS = new ActionHandled("GET_BEST_OFFERS", 16);
            BEST_OFFER = new ActionHandled("BEST_OFFER", 17);
            RESPOND_BEST_OFFER = new ActionHandled("RESPOND_BEST_OFFER", 18);
            GET_ORDERS = new ActionHandled("GET_ORDERS", 19);
            BIDDING_HISTORY = new ActionHandled("BIDDING_HISTORY", 20);
            PAYMENT_REMINDER_SENT = new ActionHandled("PAYMENT_REMINDER_SENT", 21);
            GET_ITEM_FLAGS_REFRESHED = new ActionHandled("GET_ITEM_FLAGS_REFRESHED", 22);
            $VALUES = (new ActionHandled[] {
                INITIAL_LOAD, WATCH_CHANGED, ITEM_ENDED_BY_SELLER, SHIPMENT_TRACKING, MARK_PAID_OR_UNPAID, MARK_SHIPPED_OR_UNSHIPPED, BOPIS_AVAILABILITY, ITEM_ADDED_TO_CART, CART_UPDATED, CURRENCY_RATE_UPDATED, 
                BID_CHANGE, ITEM_DESCRIPTION, PRODUCT_INFO, SHIPPING_COSTS, FEEDBACK_LEFT, GET_SHIPMENT_TRACKING, GET_BEST_OFFERS, BEST_OFFER, RESPOND_BEST_OFFER, GET_ORDERS, 
                BIDDING_HISTORY, PAYMENT_REMINDER_SENT, GET_ITEM_FLAGS_REFRESHED
            });
        }

        private ActionHandled(String s, int i)
        {
            super(s, i);
        }
    }

    private final class AddShipmentTrackingTask extends AsyncTask
    {

        private final EbayTradingApi api;
        private final long itemId;
        private final Boolean markAsPaid;
        private final Boolean shipped;
        final ViewItemDataManager this$0;
        public final ShipmentTracking tracking;
        private final Long transactionId;

        protected transient Content doInBackground(Void avoid[])
        {
            ResultStatusOwner resultstatusowner;
            Object obj;
label0:
            {
                avoid = null;
                resultstatusowner = new ResultStatusOwner();
                obj = new CompleteSaleRequest(api, itemId, transactionId, tracking, shipped, markAsPaid);
                obj = (CompleteSaleResponse)safeSendRequest(((Request) (obj)), resultstatusowner);
                if (((CompleteSaleResponse) (obj)).getResultStatus() != ResultStatus.CANCELED)
                {
                    if (resultstatusowner.getResultStatus().hasError() || tracking == null || tracking.details == null)
                    {
                        break label0;
                    }
                    avoid = (Item)_content.getData();
                    String s;
                    boolean flag;
                    if (!tracking.details.isEmpty())
                    {
                        obj = (ShipmentTrackingDetail)tracking.details.get(0);
                        ((Item) (avoid)).iTransaction.setShipmentTrackingNumber(((ShipmentTrackingDetail) (obj)).trackingNumber);
                        ((Item) (avoid)).iTransaction.setShippingCarrierUsed(((ShipmentTrackingDetail) (obj)).carrier);
                    } else
                    {
                        ((Item) (avoid)).iTransaction.setShipmentTrackingNumber(null);
                        ((Item) (avoid)).iTransaction.setShippingCarrierUsed(null);
                    }
                    avoid.tracking = tracking;
                    obj = userCache;
                    s = avoid.getIdString();
                    avoid = Long.toString(((Item) (avoid)).transactionId.longValue());
                    if (!tracking.details.isEmpty())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    ((UserCache) (obj)).setShipped(s, avoid, flag);
                    avoid = new Content(_content.getData(), resultstatusowner.getResultStatus());
                }
                return avoid;
            }
            if (EbayErrorUtil.carrierInvalid(((CompleteSaleResponse) (obj)).getResultStatus().getMessages()))
            {
                avoid = new EbayResponseError();
                avoid.severity = 1;
                avoid.longMessage = getContext().getString(0x7f070144);
                avoid.shortMessage = getContext().getString(0x7f07049c);
                resultstatusowner.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    avoid
                });
            }
            return new Content(null, resultstatusowner.getResultStatus());
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleAddShipmentTrackingResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleAddShipmentTrackingResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public AddShipmentTrackingTask(EbayTradingApi ebaytradingapi, long l, Long long1, ShipmentTracking shipmenttracking, Boolean boolean1, 
                Boolean boolean2)
        {
            this$0 = ViewItemDataManager.this;
            super();
            api = ebaytradingapi;
            itemId = l;
            transactionId = long1;
            tracking = shipmenttracking;
            shipped = boolean1;
            markAsPaid = boolean2;
        }
    }

    public final class AddToCartInfo
    {

        public int buyableCount;
        public String cartId;
        public Content item;
        final ViewItemDataManager this$0;

        public AddToCartInfo()
        {
            this$0 = ViewItemDataManager.this;
            super();
        }

        public AddToCartInfo(int i, String s, Content content)
        {
            this$0 = ViewItemDataManager.this;
            super();
            buyableCount = i;
            cartId = s;
            item = content;
        }
    }

    public class BidEvent
    {

        boolean changed;
        boolean ended;
        boolean finalized;
        final ViewItemDataManager this$0;
        boolean vibrate;

        public BidEvent(Item item, String s, int i, ItemCurrency itemcurrency, ItemCurrency itemcurrency1, boolean flag, 
                boolean flag1, CurrencyConversionRate currencyconversionrate)
        {
            this$0 = ViewItemDataManager.this;
            super();
            ended = false;
            finalized = false;
            changed = false;
            vibrate = false;
            s = getHighBidderFromMessage(item, s, new CurrencyAmount(itemcurrency));
            CurrencyAmount currencyamount = new CurrencyAmount(item.currentPrice);
            CurrencyAmount currencyamount1 = new CurrencyAmount(itemcurrency);
            boolean flag2;
            if (!currencyamount.equals(currencyamount1))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            changed = flag2;
            if (!item.isAuctionEnded && ViewItemDataManager.isAuctionEndingWithinX(0x493e0L, item) && (!currencyamount.equals(currencyamount1) || item.bidCount == 0 && i > 0))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            vibrate = flag2;
            item.bidCount = i;
            if (currencyconversionrate != null)
            {
                setCurrentAndConvertedPrice(new CurrencyAmount(itemcurrency), currencyconversionrate, item);
            }
            item.minimumToBid = computeActualMinToBid(item, itemcurrency1);
            if (changed)
            {
                item.highBidderUserId = s;
            }
            ended = flag;
            finalized = flag1;
        }
    }

    private final class EndItemTask extends AsyncTask
    {

        private final EbayTradingApi api;
        private final long itemId;
        private final String reason;
        final ViewItemDataManager this$0;

        protected transient ResultStatus doInBackground(Void avoid[])
        {
            avoid = new ResultStatusOwner();
            EndItemRequest enditemrequest = new EndItemRequest(api, itemId, reason);
            safeSendRequest(enditemrequest, avoid);
            if (avoid.getResultStatus() != ResultStatus.CANCELED && !avoid.getResultStatus().hasError())
            {
                ((Item)_content.getData()).listingStatus = "Completed";
                if ("SellToHighBidder".equals(reason))
                {
                    ViewItemViewData viewitemviewdata = getViewData();
                    viewitemviewdata.keyParams = new KeyParams(itemId, Long.valueOf(0L));
                    viewitemviewdata.kind = com.ebay.common.ConstantsCommon.ItemKind.Sold;
                    viewDataMap.put(viewitemviewdata.keyParams, viewitemviewdata);
                }
            }
            return avoid.getResultStatus();
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleEndItemResult(this, null);
        }

        protected void onPostExecute(ResultStatus resultstatus)
        {
            super.onPostExecute(resultstatus);
            handleEndItemResult(this, resultstatus);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        public EndItemTask(EbayTradingApi ebaytradingapi, long l, String s)
        {
            this$0 = ViewItemDataManager.this;
            super();
            api = ebaytradingapi;
            itemId = l;
            reason = s;
        }
    }

    private final class GetBestOffersTask extends AsyncTask
    {

        private final EbayTradingApi api;
        private final boolean initialLoad;
        private final long itemId;
        final ViewItemDataManager this$0;
        private final ViewItemViewData viewData;

        protected transient Content doInBackground(Content acontent[])
        {
label0:
            {
                Object obj = null;
                Content content = obj;
                if (acontent[0] != null)
                {
                    content = obj;
                    if (acontent[0].getData() != null)
                    {
                        ResultStatus resultstatus = doGetBestOffers(api, itemId, initialLoad, (Item)acontent[0].getData());
                        content = obj;
                        if (resultstatus != ResultStatus.CANCELED)
                        {
                            if (!resultstatus.hasError())
                            {
                                break label0;
                            }
                            content = new Content(null, resultstatus);
                        }
                    }
                }
                return content;
            }
            return acontent[0];
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadDataResult(TaskId.GET_BEST_OFFERS, viewData, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            if (initialLoad)
            {
                handleLoadDataResult(TaskId.GET_BEST_OFFERS, viewData, content);
                return;
            } else
            {
                handleGetBestOffersResult(this, content);
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public GetBestOffersTask(EbayTradingApi ebaytradingapi, long l, boolean flag, ViewItemViewData viewitemviewdata)
        {
            this$0 = ViewItemDataManager.this;
            super();
            api = ebaytradingapi;
            itemId = l;
            initialLoad = flag;
            viewData = viewitemviewdata;
            addTaskToList(TaskId.GET_BEST_OFFERS);
        }
    }

    private final class GetIncentivesTask extends AsyncTask
    {

        final ViewItemDataManager this$0;
        private final ViewItemViewData viewData;

        protected transient Content doInBackground(Content acontent[])
        {
            ResultStatus resultstatus = setupItemIncentives((Item)acontent[0].getData());
            if (resultstatus == ResultStatus.CANCELED)
            {
                return null;
            }
            if (resultstatus.hasError())
            {
                acontent = new Content(null, resultstatus);
            } else
            {
                acontent = acontent[0];
            }
            return acontent;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadDataResult(TaskId.GET_INCENTIVES, viewData, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleLoadDataResult(TaskId.GET_INCENTIVES, viewData, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public GetIncentivesTask(ViewItemViewData viewitemviewdata)
        {
            this$0 = ViewItemDataManager.this;
            super();
            viewData = viewitemviewdata;
            addTaskToList(TaskId.GET_INCENTIVES);
        }
    }

    private final class GetItemTransactionsTask extends AsyncTask
    {

        final ViewItemDataManager this$0;
        private final ViewItemViewData viewData;

        protected transient Content doInBackground(Content acontent[])
        {
            Object obj;
label0:
            {
                Content content = null;
                obj = (Item)acontent[0].getData();
                long l = ((Item) (obj)).transactionId.longValue();
                Object obj1 = new GetItemTransactionsRequest(EbayApiUtil.getTradingApi(getContext(), auth), ((Item) (obj)).id, l);
                obj = new ResultStatusOwner();
                obj1 = (GetItemTransactionsResponse)safeSendRequest(((Request) (obj1)), ((ResultStatusOwner) (obj)));
                if (((ResultStatusOwner) (obj)).getResultStatus() != ResultStatus.CANCELED)
                {
                    if (((ResultStatusOwner) (obj)).getResultStatus().hasError())
                    {
                        break label0;
                    }
                    getItemTransactionsHandling(((GetItemTransactionsResponse) (obj1)), viewData, l, acontent[0]);
                    content = acontent[0];
                }
                return content;
            }
            return new Content(null, ((ResultStatusOwner) (obj)).getResultStatus());
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadDataResult(TaskId.GET_ITEM_TRANSACTIONS, viewData, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleLoadDataResult(TaskId.GET_ITEM_TRANSACTIONS, viewData, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public GetItemTransactionsTask(ViewItemViewData viewitemviewdata)
        {
            this$0 = ViewItemDataManager.this;
            super();
            viewData = viewitemviewdata;
            addTaskToList(TaskId.GET_ITEM_TRANSACTIONS);
        }
    }

    private final class GetLocationDetailsTask extends AsyncTask
    {

        final ViewItemDataManager this$0;
        private final ViewItemViewData viewData;

        protected transient Content doInBackground(Content acontent[])
        {
            Item item = (Item)acontent[0].getData();
            if (item.isTransacted && !TextUtils.isEmpty(item.iTransaction.storeId))
            {
                Object obj = new GetLocationDetailsRequest(item.sellerUserId, item.iTransaction.storeId);
                ResultStatusOwner resultstatusowner = new ResultStatusOwner();
                obj = (GetLocationDetailsResponse)safeSendRequest(((Request) (obj)), resultstatusowner);
                if (resultstatusowner.getResultStatus() != ResultStatus.CANCELED)
                {
                    getLocationDetailsHandling(((GetLocationDetailsResponse) (obj)), item, item.mskuSelections);
                }
            }
            return acontent[0];
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadDataResult(TaskId.GET_LOCATION_DETAILS, viewData, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleLoadDataResult(TaskId.GET_LOCATION_DETAILS, viewData, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public GetLocationDetailsTask(ViewItemViewData viewitemviewdata)
        {
            this$0 = ViewItemDataManager.this;
            super();
            viewData = viewitemviewdata;
            addTaskToList(TaskId.GET_LOCATION_DETAILS);
        }
    }

    private final class GetOrderShippingInfoTask extends AsyncTask
    {

        final ViewItemDataManager this$0;
        private final ViewItemViewData viewData;

        protected transient Content doInBackground(Content acontent[])
        {
label0:
            {
                Content content = null;
                ResultStatus resultstatus = getOrderShippingInfo((Item)acontent[0].getData());
                if (resultstatus != ResultStatus.CANCELED)
                {
                    if (!resultstatus.hasError())
                    {
                        break label0;
                    }
                    content = new Content(null, resultstatus);
                }
                return content;
            }
            return acontent[0];
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadDataResult(TaskId.GET_ORDER_SHIPPING_INFO, viewData, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleLoadDataResult(TaskId.GET_ORDER_SHIPPING_INFO, viewData, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public GetOrderShippingInfoTask(ViewItemViewData viewitemviewdata)
        {
            this$0 = ViewItemDataManager.this;
            super();
            viewData = viewitemviewdata;
            addTaskToList(TaskId.GET_ORDER_SHIPPING_INFO);
        }
    }

    private final class GetOrdersTask extends AsyncTask
    {

        private final EbayTradingApi api;
        private final String iafToken;
        private final Locale locale;
        private final String orderId;
        final ViewItemDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            Object obj = null;
            ResultStatusOwner resultstatusowner = new ResultStatusOwner();
            avoid = new GetOrdersRequest(api, iafToken, locale, orderId);
            GetOrdersResponse getordersresponse = (GetOrdersResponse)safeSendRequest(avoid, resultstatusowner);
            avoid = obj;
            if (resultstatusowner.getResultStatus() != ResultStatus.CANCELED)
            {
                avoid = obj;
                if (!resultstatusowner.getResultStatus().hasError())
                {
                    avoid = new Content(getordersresponse.orders, resultstatusowner.getResultStatus());
                }
            }
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleGetOrdersResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleGetOrdersResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public GetOrdersTask(EbayTradingApi ebaytradingapi, String s, Locale locale1, String s1)
        {
            this$0 = ViewItemDataManager.this;
            super();
            iafToken = s;
            api = ebaytradingapi;
            orderId = s1;
            locale = locale1;
        }
    }

    private final class GetProductInfoTask extends AsyncTask
    {

        private final EbayShoppingApi api;
        private final String productId;
        private final boolean reportError;
        final ViewItemDataManager this$0;

        protected transient Content doInBackground(Content acontent[])
        {
            Object obj;
            Object obj1;
            Object obj2;
            ResultStatusOwner resultstatusowner;
            boolean flag1;
            obj1 = null;
            obj2 = null;
            flag1 = false;
            resultstatusowner = new ResultStatusOwner();
            obj = new FindProductsRequest(api, productId, "Reference");
            obj = (FindProductsResponse)safeSendRequest(((Request) (obj)), resultstatusowner);
            if (resultstatusowner.getResultStatus() == ResultStatus.CANCELED) goto _L2; else goto _L1
_L1:
            boolean flag;
            if (resultstatusowner.getResultStatus().hasError())
            {
                break MISSING_BLOCK_LABEL_227;
            }
            obj1 = ((EbayProduct)((FindProductsResponse) (obj)).products.get(0)).detailsUrl;
            flag = flag1;
            obj = obj2;
            if (TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                break MISSING_BLOCK_LABEL_153;
            }
            obj = new DataRequest(new URL(((String) (obj1))));
            ((Item)acontent[0].getData()).productDescription = ((DataResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(getEbayContext(), ((Request) (obj)))).getText();
            obj = acontent[0];
            flag = flag1;
_L3:
            obj1 = obj;
            if (obj == null)
            {
                obj1 = obj;
                if (reportError)
                {
                    if (!flag)
                    {
                        acontent = resultstatusowner.getResultStatus();
                    } else
                    {
                        acontent = ResultStatus.UNKNOWN;
                    }
                    obj1 = new Content(null, acontent);
                }
            }
_L2:
            return ((Content) (obj1));
            acontent;
            ViewItemDataManager.logTag.logAsError((new StringBuilder()).append("product info failure for URL ").append(((String) (obj1))).toString(), acontent);
            flag = true;
            obj = obj2;
              goto _L3
            flag = flag1;
            obj = obj2;
            if (reportError)
            {
                obj = new Content(null, resultstatusowner.getResultStatus());
                flag = flag1;
            }
              goto _L3
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            removeTaskFromList(TaskId.GET_PRODUCT_INFO);
            handleProductInfoResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleProductInfoResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public GetProductInfoTask(EbayShoppingApi ebayshoppingapi, String s, boolean flag)
        {
            this$0 = ViewItemDataManager.this;
            super();
            api = ebayshoppingapi;
            productId = s;
            reportError = flag;
            addTaskToList(TaskId.GET_PRODUCT_INFO);
        }
    }

    private final class GetShipmentTrackingTask extends AsyncTask
    {

        private final String iafToken;
        private final boolean initialLoad;
        private final long itemId;
        private final boolean realTime;
        private final EbaySite site;
        final ViewItemDataManager this$0;
        private final Long transactionId;
        private final ViewItemViewData viewData;

        protected transient Content doInBackground(Content acontent[])
        {
            ResultStatusOwner resultstatusowner = new ResultStatusOwner();
            Object obj = new GetShipmentTrackingRequest(iafToken, site, itemId, transactionId.longValue(), realTime, viewData.useEventTimeHack);
            obj = (GetShipmentTrackingResponse)safeSendRequest(((Request) (obj)), resultstatusowner);
            if (!resultstatusowner.getResultStatus().hasError())
            {
                ((Item)acontent[0].getData()).tracking = ((GetShipmentTrackingResponse) (obj)).tracking;
                return acontent[0];
            } else
            {
                return new Content(null, resultstatusowner.getResultStatus());
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            if (initialLoad)
            {
                handleLoadDataResult(TaskId.GET_SHIPMENT_TRACKING, viewData, content);
                return;
            } else
            {
                handleGetShipmentTrackingResult(this, content);
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public GetShipmentTrackingTask(String s, EbaySite ebaysite, long l, Long long1, boolean flag, 
                ViewItemViewData viewitemviewdata)
        {
            this(s, ebaysite, l, long1, false, flag, viewitemviewdata);
        }

        public GetShipmentTrackingTask(String s, EbaySite ebaysite, long l, Long long1, boolean flag, 
                boolean flag1, ViewItemViewData viewitemviewdata)
        {
            this$0 = ViewItemDataManager.this;
            super();
            iafToken = s;
            site = ebaysite;
            itemId = l;
            transactionId = long1;
            initialLoad = flag;
            realTime = flag1;
            viewData = viewitemviewdata;
            addTaskToList(TaskId.GET_SHIPMENT_TRACKING);
        }
    }

    private final class GetStoreAvailabilityTask extends AsyncTask
    {

        private boolean onVipLoad;
        private final ArrayList selections;
        final ViewItemDataManager this$0;
        private final ViewItemViewData viewData;

        protected transient Content doInBackground(Content acontent[])
        {
            getStoreAvailability((Item)acontent[0].getData(), viewData.searchRefinedPostalCode, selections);
            return acontent[0];
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            if (onVipLoad)
            {
                handleLoadDataResult(TaskId.GET_STOREAVAILABILITY, viewData, null);
                return;
            } else
            {
                handleGetStoreAvailabilityResult(this, null);
                return;
            }
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            if (onVipLoad)
            {
                handleLoadDataResult(TaskId.GET_STOREAVAILABILITY, viewData, content);
                return;
            } else
            {
                handleGetStoreAvailabilityResult(this, content);
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public GetStoreAvailabilityTask(ArrayList arraylist, ViewItemViewData viewitemviewdata, boolean flag)
        {
            this$0 = ViewItemDataManager.this;
            super();
            onVipLoad = false;
            selections = arraylist;
            onVipLoad = flag;
            viewData = viewitemviewdata;
            if (flag)
            {
                addTaskToList(TaskId.GET_STOREAVAILABILITY);
            }
        }
    }

    private final class GetViewListingTask extends AsyncTask
    {

        Content content;
        final Integer quantity;
        final EbaySite site;
        final TaskId taskId;
        final ViewItemDataManager this$0;
        final ItemCurrency unitPrice;
        final ViewItemViewData viewData;

        protected transient Content doInBackground(KeyParams akeyparams[])
        {
            Object obj;
            Object obj2 = null;
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            Object obj1;
            String s;
            StringBuilder stringbuilder;
            boolean flag;
            boolean flag1;
            if (deviceconfiguration.get(DcsNautilusBoolean.PROX) && deviceconfiguration.get(DcsBoolean.payments_payUponInvoiceEnabled))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = deviceconfiguration.get(DcsBoolean.VI_feature_EEK);
            obj = ViewItemDataManager.primaryAddress;
            if (TextUtils.isEmpty(viewData.searchRefinedPostalCode)) goto _L2; else goto _L1
_L1:
            obj = new Address();
            ((Address) (obj)).addressFields.country = site.localeCountry;
            ((Address) (obj)).addressFields.postalCode = viewData.searchRefinedPostalCode;
_L4:
            obj1 = null;
            s = EbayIdentity.getDeviceIdString(getContext());
            if (auth != null)
            {
                obj1 = EbayCguidGetter.get(getEbayContext(), MyApp.getPrefs(), site, auth.iafToken);
            }
            stringbuilder = new StringBuilder();
            stringbuilder.append("guid=").append(s);
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                stringbuilder.append(",cguid=").append(((String) (obj1)));
            }
            stringbuilder.append(",pageid=2047935");
            akeyparams = new GetViewListingRequest(MyApp.getPrefs().getCurrentCountry(), auth, akeyparams[0].itemId, location, ((Address) (obj)), s, stringbuilder.toString(), viewData.trackingCorrelationId, unitPrice, quantity, flag1, flag, deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.App.B.ebayPlus));
            obj = new ResultStatusOwner();
            obj1 = (GetViewListingResponse)safeSendRequest(akeyparams, ((ResultStatusOwner) (obj)));
            akeyparams = obj2;
            if (((ResultStatusOwner) (obj)).getResultStatus() != ResultStatus.CANCELED)
            {
                akeyparams = new Content(((GetViewListingResponse) (obj1)).details, ((ResultStatusOwner) (obj)).getResultStatus());
            }
            return akeyparams;
_L2:
            if (viewData.primaryAddress != null)
            {
                obj = viewData.primaryAddress;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((KeyParams[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$TaskId[];
                static final int $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[];

                static 
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action = new int[com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action.ADD_TO_CART.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action.GET_CART.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action.GET_AND_VALIDATE_CART.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$TaskId = new int[TaskId.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$TaskId[TaskId.GET_ITEM_FLAGS.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$TaskId[TaskId.GET_SHIPPING_COSTS_SINGLE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$TaskId[TaskId.GET_VIEW_LISTING.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.TaskId[taskId.ordinal()])
            {
            default:
                handleLoadDataResult(taskId, viewData, null);
                return;

            case 1: // '\001'
                handleVlsFlagsResult(taskId, null);
                return;

            case 2: // '\002'
                handleShippingCostsSingleResult(taskId, null);
                break;
            }
        }

        protected void onPostExecute(Content content1)
        {
            super.onPostExecute(content1);
            if (content1.getStatus().hasError())
            {
                break MISSING_BLOCK_LABEL_497;
            }
            _cls1..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.TaskId[taskId.ordinal()];
            JVM INSTR tableswitch 1 3: default 52
        //                       1 430
        //                       2 329
        //                       3 104;
               goto _L1 _L2 _L3 _L4
_L1:
            Object obj;
            Item item;
            boolean flag;
            boolean flag1;
            switch (_cls1..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.TaskId[taskId.ordinal()])
            {
            default:
                handleLoadDataResult(taskId, viewData, content);
                return;

            case 1: // '\001'
                handleVlsFlagsResult(taskId, content);
                return;

            case 2: // '\002'
                handleShippingCostsSingleResult(taskId, content);
                break;
            }
            break MISSING_BLOCK_LABEL_547;
_L4:
            obj = (ListingDetails)content1.getData();
            if (obj == null || ((ListingDetails) (obj)).listing == null || ((ListingDetails) (obj)).listing.itemVariations == null || ((ListingDetails) (obj)).listing.itemVariations.isEmpty())
            {
                content1 = new ResultStatusOwner();
                content1.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    new ErrorMessageDetails()
                });
                content = new Content(null, content1.getResultStatus());
            } else
            {
                ItemMapper.mapGetViewListingToItem(getContext(), (ListingDetails)content1.getData(), (Item)content.getData(), viewData);
                content1 = (Item)content.getData();
                if (params.transactionId != null)
                {
                    content1.transactionId = params.transactionId;
                }
                if (auth != null)
                {
                    content1.user = getUserName();
                }
                synthesizeAccretiveData(viewData, content1);
                postInitialCallMainThreadWork(content, viewData);
                postGetListingHandling(content, viewData);
            }
              goto _L1
_L3:
            flag1 = false;
            item = (Item)content.getData();
            flag = flag1;
            obj = item;
            if (quantity != null)
            {
                flag = flag1;
                obj = item;
                if (quantity.intValue() > 1)
                {
                    obj = new Item();
                    flag = true;
                }
            }
            ItemMapper.mapShipping(getContext(), ((ListingDetails)content1.getData()).listing, ((Item) (obj)));
            if (flag)
            {
                ((Item)content.getData()).shippingInfoUpdated = ((Item) (obj)).shippingInfo;
            }
              goto _L1
_L2:
            obj = new Item();
            ItemMapper.mapGetViewListingToItem(getContext(), (ListingDetails)content1.getData(), ((Item) (obj)), viewData);
            ((Item)content.getData()).isReserveMet = ((Item) (obj)).isReserveMet;
            ((Item)content.getData()).buyItNowAvailable = ((Item) (obj)).buyItNowAvailable;
              goto _L1
            content = new Content(null, content1.getStatus());
              goto _L1
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        protected GetViewListingTask(ViewItemViewData viewitemviewdata, EbaySite ebaysite, Content content1, TaskId taskid)
        {
            this(viewitemviewdata, ebaysite, content1, taskid, null, null);
        }

        protected GetViewListingTask(ViewItemViewData viewitemviewdata, EbaySite ebaysite, Content content1, TaskId taskid, ItemCurrency itemcurrency, Integer integer)
        {
            this$0 = ViewItemDataManager.this;
            super();
            viewData = viewitemviewdata;
            site = ebaysite;
            content = content1;
            unitPrice = itemcurrency;
            quantity = integer;
            taskId = taskid;
            addTaskToList(taskid);
        }
    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return new KeyParams(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public final String countryCode;
        public final long itemId;
        public final Locale locale;
        public final Long transactionId;

        public ViewItemDataManager createManager(EbayContext ebaycontext)
        {
            ebaycontext = new ViewItemDataManager(ebaycontext, this);
            ebaycontext.create();
            return ebaycontext;
        }

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null)
                {
                    return false;
                }
                if (getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (KeyParams)obj;
                if (itemId != ((KeyParams) (obj)).itemId || (transactionId != null ? !transactionId.equals(((KeyParams) (obj)).transactionId) : ((KeyParams) (obj)).transactionId != null) || (!locale.equals(((KeyParams) (obj)).locale) || !countryCode.equals(((KeyParams) (obj)).countryCode)))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            int j = super.hashCode();
            int k = Long.valueOf(itemId).hashCode();
            int i;
            if (transactionId == null)
            {
                i = -1;
            } else
            {
                i = transactionId.hashCode();
            }
            return (((j * 31 + k) * 31 + i) * 31 + countryCode.hashCode()) * 31 + locale.hashCode();
        }

        public String toString()
        {
            return (new StringBuilder()).append("ItemKey [id=").append(itemId).append(";transactionId=").append(transactionId).append(";locale=").append(locale).append(";country=").append(countryCode).append("]").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeLong(itemId);
            if (transactionId != null)
            {
                parcel.writeInt(1);
                parcel.writeLong(transactionId.longValue());
            } else
            {
                parcel.writeInt(0);
            }
            parcel.writeSerializable(locale);
            parcel.writeString(countryCode);
        }


        public KeyParams(long l, Long long1)
        {
            if (ViewItemDataManager.logTag.isLoggable)
            {
                ViewItemDataManager.logTag.log((new StringBuilder()).append("KeyParams: itemId=").append(l).append(";transactionId=").append(long1).toString());
            }
            itemId = l;
            countryCode = MyApp.getPrefs().getCurrentCountry().getCountryCode();
            locale = Locale.getDefault();
            transactionId = long1;
        }

        KeyParams(Parcel parcel)
        {
            itemId = parcel.readLong();
            Long long1;
            if (parcel.readInt() != 0)
            {
                long1 = Long.valueOf(parcel.readLong());
            } else
            {
                long1 = null;
            }
            transactionId = long1;
            locale = (Locale)parcel.readSerializable();
            countryCode = parcel.readString();
        }
    }

    private final class LeaveFeedbackTask extends AsyncTask
    {

        private final EbayTradingApi api;
        private final LeaveFeedbackParameters parameters;
        final ViewItemDataManager this$0;

        protected transient Content doInBackground(Content acontent[])
        {
            Object obj;
label0:
            {
                Content content = null;
                LeaveFeedbackRequest leavefeedbackrequest = new LeaveFeedbackRequest(api, parameters);
                obj = new ResultStatusOwner();
                safeSendRequest(leavefeedbackrequest, ((ResultStatusOwner) (obj)));
                if (((ResultStatusOwner) (obj)).getResultStatus() != ResultStatus.CANCELED)
                {
                    if (((ResultStatusOwner) (obj)).getResultStatus().hasError())
                    {
                        break label0;
                    }
                    content = acontent[0];
                    ((Item)content.getData()).feedbackLeft = true;
                    acontent = ((Item)content.getData()).getIdString();
                    obj = String.valueOf(((Item)content.getData()).transactionId);
                    userCache.addToLeftFeedback(acontent, ((String) (obj)));
                    ServiceContentOverride.setFeedbackLeft(((Item)content.getData()).id, ((String) (obj)));
                }
                return content;
            }
            return new Content(null, ((ResultStatusOwner) (obj)).getResultStatus());
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleLeaveFeedbackResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleLeaveFeedbackResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public LeaveFeedbackTask(EbayTradingApi ebaytradingapi, LeaveFeedbackParameters leavefeedbackparameters)
        {
            this$0 = ViewItemDataManager.this;
            super();
            api = ebaytradingapi;
            parameters = leavefeedbackparameters;
            addTaskToList(TaskId.LEAVE_FEEDBACK);
        }
    }

    private final class MakeOfferTask extends AsyncTask
    {

        private final String action;
        private final EbayTradingApi api;
        private final String bestOfferId;
        private final String bestOfferTermsToSeller;
        private final ItemCurrency bid;
        private final long itemId;
        private final ArrayList options;
        private final int quantity;
        private final boolean requestTrackingPartnerCode;
        final ViewItemDataManager this$0;

        protected transient Content doInBackground(Content acontent[])
        {
            Object obj;
            PlaceOfferInfo placeofferinfo;
            ResultStatusOwner resultstatusowner;
            PlaceOfferResponse placeofferresponse;
            obj = null;
            placeofferinfo = new PlaceOfferInfo();
            placeofferinfo.item = acontent[0];
            acontent = new PlaceOfferRequest(api, itemId, action, bid, quantity, options, bestOfferId, bestOfferTermsToSeller, requestTrackingPartnerCode, false);
            resultstatusowner = new ResultStatusOwner();
            placeofferresponse = (PlaceOfferResponse)safeSendRequest(acontent, resultstatusowner);
            if (resultstatusowner.getResultStatus() == ResultStatus.CANCELED)
            {
                return null;
            }
            placeofferinfo.response = placeofferresponse;
            if (resultstatusowner.getResultStatus().hasError()) goto _L2; else goto _L1
_L1:
            acontent = new Content(placeofferinfo, resultstatusowner.getResultStatus());
_L4:
            return acontent;
_L2:
            if (Util.checkForIAFTokenError(placeofferresponse))
            {
                acontent = new Content(null, resultstatusowner.getResultStatus());
            } else
            if (EbayErrorUtil.userAccessLevelUpgradeRequired(placeofferresponse.getResultStatus().getMessages()))
            {
                placeofferinfo.resultStatus = new PlaceOfferResultStatus(502, true, null);
                acontent = new Content(placeofferinfo, resultstatusowner.getResultStatus());
            } else
            {
                List list = placeofferresponse.getResultStatus().getMessages();
                acontent = obj;
                if (list != null)
                {
                    acontent = obj;
                    if (list.size() > 0)
                    {
                        acontent = (com.ebay.nautilus.kernel.content.ResultStatus.Message)list.get(list.size() - 1);
                        placeofferinfo.resultStatus.putMessage(ResultStatus.getSafeLongMessage(getEbayContext(), acontent));
                        if (!(acontent instanceof EbayResponseError) || !((EbayResponseError)acontent).code.equals("21917143"))
                        {
                            BestOfferTracking.trackState(getEbayContext(), "OBME", Long.valueOf(itemId), null, placeofferresponse.result.bestOfferId);
                        }
                        acontent = new Content(placeofferinfo, resultstatusowner.getResultStatus());
                    }
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleMakeOfferResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleMakeOfferResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public MakeOfferTask(EbayTradingApi ebaytradingapi, long l, String s, ItemCurrency itemcurrency, int i, 
                ArrayList arraylist, String s1, String s2, boolean flag)
        {
            this$0 = ViewItemDataManager.this;
            super();
            api = ebaytradingapi;
            itemId = l;
            action = s;
            bid = itemcurrency;
            quantity = i;
            options = arraylist;
            bestOfferId = s1;
            bestOfferTermsToSeller = s2;
            requestTrackingPartnerCode = flag;
            addTaskToList(TaskId.MAKE_OFFER);
        }
    }

    private final class MarkPaidTask extends AsyncTask
    {

        private final EbayTradingApi api;
        private final long itemId;
        private final Boolean markAsPaid;
        final ViewItemDataManager this$0;
        public final ShipmentTracking tracking;
        private final Long transactionId;

        protected transient Content doInBackground(Content acontent[])
        {
            ResultStatusOwner resultstatusowner;
label0:
            {
                Object obj = null;
                resultstatusowner = new ResultStatusOwner();
                CompleteSaleRequest completesalerequest = new CompleteSaleRequest(api, itemId, transactionId, tracking, null, markAsPaid);
                safeSendRequest(completesalerequest, resultstatusowner);
                if (resultstatusowner.getResultStatus() != ResultStatus.CANCELED)
                {
                    if (resultstatusowner.getResultStatus().hasError() || acontent == null || acontent[0] == null || acontent[0].getData() == null)
                    {
                        break label0;
                    }
                    obj = (Item)acontent[0].getData();
                    boolean flag;
                    if (markAsPaid.booleanValue())
                    {
                        acontent = "PaidWithPayPal";
                    } else
                    {
                        acontent = "NotPaid";
                    }
                    obj.paidStatus = acontent;
                    userCache.addToPaidStatus(((Item) (obj)).getIdString(), Long.toString(((Item) (obj)).transactionId.longValue()), ((Item) (obj)).paidStatus, null);
                    obj.isPaid = markAsPaid.booleanValue();
                    if (!((Item) (obj)).isPaid)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    obj.isShowMarkAsPaid = flag;
                    obj.isShowMarkAsUnPaid = ((Item) (obj)).isPaid;
                    obj = new Content(obj, resultstatusowner.getResultStatus());
                }
                return ((Content) (obj));
            }
            return new Content(null, resultstatusowner.getResultStatus());
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleMarkPaidResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleMarkPaidResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public MarkPaidTask(EbayTradingApi ebaytradingapi, long l, Long long1, ShipmentTracking shipmenttracking, Boolean boolean1)
        {
            this$0 = ViewItemDataManager.this;
            super();
            api = ebaytradingapi;
            itemId = l;
            transactionId = long1;
            tracking = shipmenttracking;
            markAsPaid = boolean1;
        }
    }

    private final class MarkShippedTask extends AsyncTask
    {

        private final EbayTradingApi api;
        private final long itemId;
        private final Boolean shipped;
        final ViewItemDataManager this$0;
        public final ShipmentTracking tracking;
        private final Long transactionId;

        protected transient Content doInBackground(Content acontent[])
        {
            ResultStatusOwner resultstatusowner;
label0:
            {
                Content content = null;
                resultstatusowner = new ResultStatusOwner();
                CompleteSaleRequest completesalerequest = new CompleteSaleRequest(api, itemId, transactionId, tracking, shipped, null);
                safeSendRequest(completesalerequest, resultstatusowner);
                if (resultstatusowner.getResultStatus() != ResultStatus.CANCELED)
                {
                    if (resultstatusowner.getResultStatus().hasError() || acontent == null || acontent[0] == null || acontent[0].getData() == null)
                    {
                        break label0;
                    }
                    acontent = (Item)acontent[0].getData();
                    userCache.setShipped(acontent.getIdString(), Long.toString(((Item) (acontent)).transactionId.longValue()), shipped.booleanValue());
                    if (!shipped.booleanValue())
                    {
                        if (((Item) (acontent)).iTransaction.shippedTime != null)
                        {
                            ((Item) (acontent)).iTransaction.shippedTime = null;
                        }
                        if (!TextUtils.isEmpty(((Item) (acontent)).iTransaction.getShipmentTrackingNumber()))
                        {
                            ((Item) (acontent)).iTransaction.shipmentTrackingDetails = new ArrayList();
                        }
                    }
                    content = new Content(acontent, resultstatusowner.getResultStatus());
                }
                return content;
            }
            return new Content(null, resultstatusowner.getResultStatus());
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleMarkShippedResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleMarkShippedResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public MarkShippedTask(EbayTradingApi ebaytradingapi, long l, Long long1, ShipmentTracking shipmenttracking, Boolean boolean1)
        {
            this$0 = ViewItemDataManager.this;
            super();
            api = ebaytradingapi;
            itemId = l;
            transactionId = long1;
            tracking = shipmenttracking;
            shipped = boolean1;
        }
    }

    public static interface Observer
    {

        public abstract void onBidUpdated(ViewItemDataManager viewitemdatamanager, Content content);

        public abstract void onCartChanged(ViewItemDataManager viewitemdatamanager, Content content, ActionHandled actionhandled);

        public abstract void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ActionHandled actionhandled, boolean flag);

        public abstract void onGetOrdersCompleted(ViewItemDataManager viewitemdatamanager, Content content);

        public abstract void onPlaceOfferCompleted(ViewItemDataManager viewitemdatamanager, Content content);

        public abstract void onRespondBestOfferCompleted(ViewItemDataManager viewitemdatamanager, Content content);
    }

    public final class PlaceOfferInfo
    {

        public String action;
        public Content item;
        public PlaceOfferResponse response;
        public PlaceOfferResultStatus resultStatus;
        final ViewItemDataManager this$0;

        public PlaceOfferInfo()
        {
            this$0 = ViewItemDataManager.this;
            super();
            resultStatus = new PlaceOfferResultStatus();
        }

        public PlaceOfferInfo(Content content, PlaceOfferResultStatus placeofferresultstatus)
        {
            this$0 = ViewItemDataManager.this;
            super();
            item = content;
            resultStatus = placeofferresultstatus;
        }
    }

    private final class PlaceOfferTask extends AsyncTask
    {

        private final String action;
        private final EbayTradingApi api;
        private final String bestOfferId;
        private final String bestOfferTermsToSeller;
        private final ItemCurrency bid;
        private final String bidSource;
        private final boolean incrementalBid;
        public boolean isBidAction;
        public boolean isPurchaseAction;
        private boolean isUserConsentRequired;
        private final long itemId;
        private final ArrayList options;
        private final int quantity;
        private final String referrer;
        private final boolean requestTrackingPartnerCode;
        final ViewItemDataManager this$0;
        private final ItemCurrency totalCostWithShipping;

        protected transient Content doInBackground(Content acontent[])
        {
            Object obj;
            PlaceOfferInfo placeofferinfo;
            ResultStatusOwner resultstatusowner;
            Object obj2;
            obj = null;
            placeofferinfo = new PlaceOfferInfo();
            placeofferinfo.item = acontent[0];
            placeofferinfo.action = action;
            PlaceOfferRequest placeofferrequest = new PlaceOfferRequest(api, itemId, action, bid, quantity, options, bestOfferId, bestOfferTermsToSeller, requestTrackingPartnerCode, isUserConsentRequired);
            resultstatusowner = new ResultStatusOwner();
            obj2 = (PlaceOfferResponse)safeSendRequest(placeofferrequest, resultstatusowner);
            if (resultstatusowner.getResultStatus() == ResultStatus.CANCELED)
            {
                return null;
            }
            placeofferinfo.response = ((PlaceOfferResponse) (obj2));
            if (!"Decline".equals(action) && !"Accept".equals(action) && !"Counter".equals(action)) goto _L2; else goto _L1
_L1:
            if (!resultstatusowner.getResultStatus().hasError())
            {
                acontent = new Content(placeofferinfo, resultstatusowner.getResultStatus());
            } else
            {
                acontent = new Content(null, resultstatusowner.getResultStatus());
            }
_L6:
            return acontent;
_L2:
            Object obj1;
            Item item;
            HashSet hashset;
            int i;
            if (obj2 != null && ((PlaceOfferResponse) (obj2)).result != null && ((PlaceOfferResponse) (obj2)).result.suggestedBidValues != null && ((PlaceOfferResponse) (obj2)).result.suggestedBidValues.size() > 0)
            {
                ((Item)acontent[0].getData()).powerBidValues = ((PlaceOfferResponse) (obj2)).result.suggestedBidValues;
            }
            if (!resultstatusowner.getResultStatus().hasError())
            {
                placeofferinfo.resultStatus = placeOfferComplete(this, ((PlaceOfferResponse) (obj2)), acontent[0]);
                acontent = new Content(placeofferinfo, resultstatusowner.getResultStatus());
                continue; /* Loop/switch isn't completed */
            }
            if (Util.checkForIAFTokenError(((EbayResponse) (obj2))))
            {
                acontent = new Content(null, resultstatusowner.getResultStatus());
                continue; /* Loop/switch isn't completed */
            }
            if (EbayErrorUtil.userAccessLevelUpgradeRequired(((PlaceOfferResponse) (obj2)).getResultStatus().getMessages()))
            {
                placeofferinfo.resultStatus = new PlaceOfferResultStatus(502, true, null);
                acontent = new Content(placeofferinfo, resultstatusowner.getResultStatus());
                continue; /* Loop/switch isn't completed */
            }
            item = (Item)acontent[0].getData();
            boolean flag = action.equals("Purchase");
            obj1 = ItemViewCommonProgressAndError.LayoutState.SERVICE_ERROR;
            acontent = ((Content []) (obj));
            if (ItemViewCommonProgressAndError.LayoutState.CONNECTION_ERROR == obj1)
            {
                continue; /* Loop/switch isn't completed */
            }
            acontent = ((Content []) (obj));
            if (!((PlaceOfferResponse) (obj2)).getResultStatus().hasMessage())
            {
                continue; /* Loop/switch isn't completed */
            }
            acontent = ((PlaceOfferResponse) (obj2)).getResultStatus().getMessages();
            hashset = new HashSet(acontent.size());
            obj = null;
            obj1 = acontent.iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                Object obj3 = (com.ebay.nautilus.kernel.content.ResultStatus.Message)((Iterator) (obj1)).next();
                if (obj3 instanceof EbayResponseError)
                {
                    obj3 = (EbayResponseError)obj3;
                    hashset.add(((EbayResponseError) (obj3)).code);
                    if (((EbayResponseError) (obj3)).code != null && ((EbayResponseError) (obj3)).code.equals("12210"))
                    {
                        obj = ((EbayResponseError) (obj3)).longMessage;
                    }
                }
            } while (true);
            com.ebay.nautilus.kernel.content.ResultStatus.Message message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)acontent.get(0);
            obj1 = MyApp.getDisplayableServiceError(getEbayContext(), resultstatusowner.getResultStatus());
            if (hashset.contains("36"))
            {
                acontent = getContext().getString(0x7f0703cf);
            } else
            {
                acontent = ((Content []) (obj1));
                if (!flag)
                {
label0:
                    {
                        if ((item == null || !item.isAuctionEnded) && !hashset.contains("12243") && !hashset.contains("12234"))
                        {
                            break label0;
                        }
                        acontent = getContext().getString(0x7f07017b);
                    }
                }
            }
_L4:
            i = message.getId();
            if (12310 == i)
            {
                obj1 = getEbayContext();
                obj2 = message.getLongMessage(((EbayContext) (obj1)));
                obj = acontent;
                if (!TextUtils.isEmpty(((CharSequence) (obj2))))
                {
                    obj = Html.fromHtml(((String) (obj2))).toString().replaceAll("Filter Id:", "").trim();
                }
                acontent = ((Content []) (obj));
                if (TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    acontent = message.getShortMessage(((EbayContext) (obj1)));
                }
            } else
            if (0x14e6c6e == i)
            {
                acontent = getContext().getString(0x7f0709f0);
            }
            placeofferinfo.resultStatus = new PlaceOfferResultStatus(503, false, acontent);
            acontent = new Content(placeofferinfo, resultstatusowner.getResultStatus());
            continue; /* Loop/switch isn't completed */
            acontent = ((Content []) (obj1));
            if (!hashset.contains("12210")) goto _L4; else goto _L3
_L3:
            acontent = new PlaceOfferResultStatus(505, true, null);
            obj1 = acontent.getBundle();
            obj2 = ((PlaceOfferResponse) (obj2)).result;
            if (obj2 != null && ((PlaceOfferResult) (obj2)).currentPrice != null)
            {
                ((Bundle) (obj1)).putParcelable("current_price", ((PlaceOfferResult) (obj2)).currentPrice);
            }
            if (((PlaceOfferResult) (obj2)).minimumToBid != null)
            {
                item.minimumToBid = computeActualMinToBid(item, ((PlaceOfferResult) (obj2)).minimumToBid);
            }
            placeofferinfo.resultStatus = acontent;
            ((Bundle) (obj1)).putString("bidTooLowErrorMessage", ((String) (obj)));
            return new Content(placeofferinfo, resultstatusowner.getResultStatus());
            if (true) goto _L6; else goto _L5
_L5:
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handlePlaceOfferResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handlePlaceOfferResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }









        public PlaceOfferTask(EbayTradingApi ebaytradingapi, long l, String s, ItemCurrency itemcurrency, int i, 
                ArrayList arraylist, String s1, String s2, boolean flag, ItemCurrency itemcurrency1, String s3, String s4, 
                boolean flag1, boolean flag2)
        {
            this$0 = ViewItemDataManager.this;
            super();
            isUserConsentRequired = false;
            api = ebaytradingapi;
            itemId = l;
            action = s;
            isBidAction = "Bid".equals(s);
            isPurchaseAction = "Purchase".equals(s);
            bid = itemcurrency;
            quantity = i;
            options = arraylist;
            bestOfferId = s1;
            bestOfferTermsToSeller = s2;
            requestTrackingPartnerCode = flag;
            totalCostWithShipping = itemcurrency1;
            bidSource = s3;
            referrer = s4;
            incrementalBid = flag1;
            isUserConsentRequired = flag2;
            addTaskToList(TaskId.PLACE_OFFER);
        }
    }

    private static class PostViewItemLite extends Handler
        implements Runnable
    {

        public static final long oneMinute = 60000L;
        public static final long oneSecond = 1000L;
        private final WeakReference biddingUpdater;
        private final Item item;

        private long getNextViewItemLitePostDelayMs()
        {
            if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
            {
                FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[0]);
            }
            long l = 1000L;
            if ((ItemViewBiddingUpdater)biddingUpdater.get() != null)
            {
                l = ViewItemDataManager.getNextViewItemLiteDelayMs(item.getAuctionTimeRemainingMs());
            }
            return l;
        }

        public void run()
        {
            if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
            {
                FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[0]);
            }
            ItemViewBiddingUpdater itemviewbiddingupdater = (ItemViewBiddingUpdater)biddingUpdater.get();
            if (itemviewbiddingupdater != null && ItemViewBiddingUpdater.UpdateMode.POLLING == itemviewbiddingupdater.updateMode)
            {
                itemviewbiddingupdater.sendViewItemLite(true);
            }
        }


        public PostViewItemLite(ItemViewBiddingUpdater itemviewbiddingupdater, Item item1)
        {
            biddingUpdater = new WeakReference(itemviewbiddingupdater);
            item = item1;
        }
    }

    public final class RespondBestOfferInfo
    {

        public String action;
        public Content item;
        public RespondToBestOfferResponse response;
        final ViewItemDataManager this$0;

        public RespondBestOfferInfo()
        {
            this$0 = ViewItemDataManager.this;
            super();
        }

        public RespondBestOfferInfo(Content content, PlaceOfferResultStatus placeofferresultstatus)
        {
            this$0 = ViewItemDataManager.this;
            super();
            item = content;
        }
    }

    private final class RespondBestOfferTask extends AsyncTask
    {

        private final String action;
        private final EbayTradingApi api;
        private final long bestOfferId;
        private final String counterOfferCode;
        private final Double counterOfferPrice;
        private final int counterOfferQuantity;
        private final long itemId;
        private final String sellerResponse;
        final ViewItemDataManager this$0;

        protected transient Content doInBackground(Content acontent[])
        {
            Object obj;
            ResultStatusOwner resultstatusowner;
label0:
            {
                obj = null;
                resultstatusowner = new ResultStatusOwner();
                Object obj1 = new RespondToBestOfferRequest(api, action, itemId, bestOfferId, sellerResponse, counterOfferPrice, counterOfferCode, counterOfferQuantity);
                obj1 = (RespondToBestOfferResponse)safeSendRequest(((Request) (obj1)), resultstatusowner);
                if (((RespondToBestOfferResponse) (obj1)).getResultStatus() != ResultStatus.CANCELED)
                {
                    obj = new RespondBestOfferInfo();
                    obj.response = ((RespondToBestOfferResponse) (obj1));
                    obj.action = action;
                    if (resultstatusowner.getResultStatus().hasError())
                    {
                        break label0;
                    }
                    obj.item = acontent[0];
                    obj = new Content(obj, ResultStatus.SUCCESS);
                }
                return ((Content) (obj));
            }
            return new Content(obj, resultstatusowner.getResultStatus());
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleRespondBestOfferResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleRespondBestOfferResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public RespondBestOfferTask(EbayTradingApi ebaytradingapi, String s, long l, long l1, 
                String s1, Double double1, String s2, int i)
        {
            this$0 = ViewItemDataManager.this;
            super();
            api = ebaytradingapi;
            action = s;
            itemId = l;
            bestOfferId = l1;
            sellerResponse = s1;
            counterOfferPrice = double1;
            counterOfferCode = s2;
            counterOfferQuantity = i;
            addTaskToList(TaskId.RESPOND_BEST_OFFER);
        }
    }

    private final class SetPaymentReminderStatusTask extends AsyncTask
    {

        private final ArrayList nameValuePair;
        final ViewItemDataManager this$0;

        protected transient Content doInBackground(Content acontent[])
        {
            Object obj1 = null;
            Object obj2 = null;
            boolean flag1 = false;
            Object obj = obj1;
            Content acontent1[] = obj2;
            boolean flag = flag1;
            if (acontent != null)
            {
                obj = obj1;
                acontent1 = obj2;
                flag = flag1;
                if (acontent[0].getData() != null)
                {
                    Content content = acontent[0];
                    acontent = (Item)acontent[0].getData();
                    com.ebay.nautilus.domain.content.PaymentReminderStorageUtil.PaymentReminderStorageParams paymentreminderstorageparams = new com.ebay.nautilus.domain.content.PaymentReminderStorageUtil.PaymentReminderStorageParams();
                    paymentreminderstorageparams.id = ((Item) (acontent)).id;
                    long l;
                    boolean flag2;
                    if (((Item) (acontent)).iTransaction != null && ((Item) (acontent)).iTransaction.createdDate != null)
                    {
                        l = ((Item) (acontent)).iTransaction.createdDate.getTime();
                    } else
                    {
                        l = 0L;
                    }
                    paymentreminderstorageparams.transactionCreationDate = l;
                    paymentreminderstorageparams.variationSpecifics = nameValuePair;
                    flag2 = PaymentReminderStorageUtil.setStatusToSent(paymentreminderstorageparams);
                    obj = content;
                    acontent1 = acontent;
                    flag = flag2;
                    if (flag2)
                    {
                        l = PaymentReminderStorageUtil.getPaymentReminderSentDate(paymentreminderstorageparams);
                        if (l > 0L)
                        {
                            acontent.paymentReminderSentDate = (String)DateFormat.format(Util.getDeliveryDateFormat(getContext(), false), l);
                        }
                        acontent.updatePaymentReminderState(true);
                        flag = flag2;
                        acontent1 = acontent;
                        obj = content;
                    }
                }
            }
            if (obj == null || !flag)
            {
                acontent = new ResultStatusOwner();
                obj = new EbayResponseError();
                obj.severity = 1;
                obj.longMessage = getContext().getString(0x7f070143);
                acontent.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    obj
                });
                obj = new Content(acontent1, acontent.getResultStatus());
            }
            return ((Content) (obj));
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleSetPaymentReminderStatusResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public SetPaymentReminderStatusTask(ArrayList arraylist)
        {
            this$0 = ViewItemDataManager.this;
            super();
            nameValuePair = arraylist;
        }
    }

    public static class SimpleViewItemDataManagerObserver
        implements Observer
    {

        public void onBidUpdated(ViewItemDataManager viewitemdatamanager, Content content)
        {
        }

        public void onCartChanged(ViewItemDataManager viewitemdatamanager, Content content, ActionHandled actionhandled)
        {
        }

        public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ActionHandled actionhandled, boolean flag)
        {
        }

        public void onGetOrdersCompleted(ViewItemDataManager viewitemdatamanager, Content content)
        {
        }

        public void onPlaceOfferCompleted(ViewItemDataManager viewitemdatamanager, Content content)
        {
        }

        public void onRespondBestOfferCompleted(ViewItemDataManager viewitemdatamanager, Content content)
        {
        }

        public SimpleViewItemDataManagerObserver()
        {
        }
    }

    private static final class TaskId extends Enum
    {

        private static final TaskId $VALUES[];
        public static final TaskId ADD_SHIPMENT_TRACKING;
        public static final TaskId BIDDING_HISTORY;
        public static final TaskId CONVERT_CURRENCY;
        public static final TaskId EBAY_DETAILS;
        public static final TaskId END_ITEM;
        public static final TaskId GET_ADDRESSES;
        public static final TaskId GET_BEST_OFFERS;
        public static final TaskId GET_BIDLIST;
        public static final TaskId GET_DM_ADDRESSES;
        public static final TaskId GET_INCENTIVES;
        public static final TaskId GET_ITEM_FLAGS;
        public static final TaskId GET_ITEM_TRANSACTIONS;
        public static final TaskId GET_LOCATION_DETAILS;
        public static final TaskId GET_ORDERS;
        public static final TaskId GET_ORDER_SHIPPING_INFO;
        public static final TaskId GET_PRODUCT_INFO;
        public static final TaskId GET_SHIPMENT_TRACKING;
        public static final TaskId GET_SHIPPING_COSTS_SINGLE;
        public static final TaskId GET_SHOPPING_CART;
        public static final TaskId GET_SOLDLIST;
        public static final TaskId GET_STOREAVAILABILITY;
        public static final TaskId GET_VIEW_LISTING;
        public static final TaskId GET_WATCHLIST;
        public static final TaskId GET_WONLIST;
        public static final TaskId LEAVE_FEEDBACK;
        public static final TaskId MAKE_OFFER;
        public static final TaskId MARK_PAID;
        public static final TaskId MARK_SHIPPED;
        public static final TaskId PLACE_OFFER;
        public static final TaskId RESPOND_BEST_OFFER;
        public static final TaskId VIEW_ITEM_LITE;
        private boolean requiredSuccess;

        public static TaskId valueOf(String s)
        {
            return (TaskId)Enum.valueOf(com/ebay/mobile/viewitem/ViewItemDataManager$TaskId, s);
        }

        public static TaskId[] values()
        {
            return (TaskId[])$VALUES.clone();
        }

        static 
        {
            GET_ADDRESSES = new TaskId("GET_ADDRESSES", 0, true);
            GET_STOREAVAILABILITY = new TaskId("GET_STOREAVAILABILITY", 1);
            GET_ITEM_FLAGS = new TaskId("GET_ITEM_FLAGS", 2);
            END_ITEM = new TaskId("END_ITEM", 3);
            GET_SHIPPING_COSTS_SINGLE = new TaskId("GET_SHIPPING_COSTS_SINGLE", 4);
            ADD_SHIPMENT_TRACKING = new TaskId("ADD_SHIPMENT_TRACKING", 5);
            MARK_PAID = new TaskId("MARK_PAID", 6);
            MARK_SHIPPED = new TaskId("MARK_SHIPPED", 7);
            EBAY_DETAILS = new TaskId("EBAY_DETAILS", 8, true);
            GET_ITEM_TRANSACTIONS = new TaskId("GET_ITEM_TRANSACTIONS", 9, true);
            GET_INCENTIVES = new TaskId("GET_INCENTIVES", 10);
            GET_BEST_OFFERS = new TaskId("GET_BEST_OFFERS", 11);
            GET_LOCATION_DETAILS = new TaskId("GET_LOCATION_DETAILS", 12);
            GET_ORDER_SHIPPING_INFO = new TaskId("GET_ORDER_SHIPPING_INFO", 13);
            PLACE_OFFER = new TaskId("PLACE_OFFER", 14);
            GET_PRODUCT_INFO = new TaskId("GET_PRODUCT_INFO", 15);
            MAKE_OFFER = new TaskId("MAKE_OFFER", 16);
            LEAVE_FEEDBACK = new TaskId("LEAVE_FEEDBACK", 17);
            GET_SHIPMENT_TRACKING = new TaskId("GET_SHIPMENT_TRACKING", 18);
            RESPOND_BEST_OFFER = new TaskId("RESPOND_BEST_OFFER", 19);
            VIEW_ITEM_LITE = new TaskId("VIEW_ITEM_LITE", 20, true);
            GET_ORDERS = new TaskId("GET_ORDERS", 21);
            BIDDING_HISTORY = new TaskId("BIDDING_HISTORY", 22);
            CONVERT_CURRENCY = new TaskId("CONVERT_CURRENCY", 23);
            GET_VIEW_LISTING = new TaskId("GET_VIEW_LISTING", 24, true);
            GET_WATCHLIST = new TaskId("GET_WATCHLIST", 25, true);
            GET_BIDLIST = new TaskId("GET_BIDLIST", 26, true);
            GET_SOLDLIST = new TaskId("GET_SOLDLIST", 27, true);
            GET_WONLIST = new TaskId("GET_WONLIST", 28, true);
            GET_DM_ADDRESSES = new TaskId("GET_DM_ADDRESSES", 29, true);
            GET_SHOPPING_CART = new TaskId("GET_SHOPPING_CART", 30, true);
            $VALUES = (new TaskId[] {
                GET_ADDRESSES, GET_STOREAVAILABILITY, GET_ITEM_FLAGS, END_ITEM, GET_SHIPPING_COSTS_SINGLE, ADD_SHIPMENT_TRACKING, MARK_PAID, MARK_SHIPPED, EBAY_DETAILS, GET_ITEM_TRANSACTIONS, 
                GET_INCENTIVES, GET_BEST_OFFERS, GET_LOCATION_DETAILS, GET_ORDER_SHIPPING_INFO, PLACE_OFFER, GET_PRODUCT_INFO, MAKE_OFFER, LEAVE_FEEDBACK, GET_SHIPMENT_TRACKING, RESPOND_BEST_OFFER, 
                VIEW_ITEM_LITE, GET_ORDERS, BIDDING_HISTORY, CONVERT_CURRENCY, GET_VIEW_LISTING, GET_WATCHLIST, GET_BIDLIST, GET_SOLDLIST, GET_WONLIST, GET_DM_ADDRESSES, 
                GET_SHOPPING_CART
            });
        }


        private TaskId(String s, int i)
        {
            super(s, i);
            requiredSuccess = false;
        }

        private TaskId(String s, int i, boolean flag)
        {
            super(s, i);
            requiredSuccess = flag;
        }
    }

    public class ViewItemLiteInfo
    {

        public BidEvent bidEvent;
        public Item item;
        public ItemCurrency price;
        final ViewItemDataManager this$0;

        public ViewItemLiteInfo()
        {
            this$0 = ViewItemDataManager.this;
            super();
        }
    }

    private final class ViewItemLiteTask extends AsyncTask
    {

        private final boolean continuePolling;
        private final long itemId;
        final ViewItemDataManager this$0;

        private ItemCurrency getPowerBidValueAsItemCurrency(JSONObject jsonobject)
        {
            if (jsonobject == null || jsonobject.length() == 0)
            {
                return null;
            }
            try
            {
                jsonobject = new ItemCurrency(jsonobject.getString("CurrencyCode"), jsonobject.getString("Amount"));
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                ViewItemDataManager.logTag.logAsWarning("getPowerBidValueAsItemCurrency exception ", jsonobject);
                return null;
            }
            return jsonobject;
        }

        protected transient Content doInBackground(Content acontent[])
        {
            Object obj3;
            long l2;
            if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
            {
                FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[0]);
            }
            obj3 = null;
            l2 = System.nanoTime();
            Object obj;
            boolean flag4;
            obj = Uri.parse(ApiSettings.get(EbaySettings.viewItemLite)).buildUpon();
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("item", String.valueOf(itemId));
            flag4 = DeviceConfiguration.getAsync().get(DcsBoolean.VI_featureNewBidFlow);
            if (!flag4)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("pbv", "1");
            obj = ((android.net.Uri.Builder) (obj)).build().toString();
            Object obj1 = new URL(((String) (obj)));
            obj = new DataRequest(((URL) (obj1)));
            obj = ((DataResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(getEbayContext(), ((Request) (obj)))).getText();
            if (obj == null || acontent[0] == null) goto _L2; else goto _L1
_L1:
            obj = new JSONObject(((String) (obj)));
            if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
            {
                FwLog.println(ItemViewBiddingUpdater.fwLogItemViewBidding, (new StringBuilder()).append("GetViewItemLite json: ").append(obj).toString());
            }
            obj = ((JSONObject) (obj)).getJSONObject("ViewItemLiteResponse");
            if (!((JSONObject) (obj)).has("Error")) goto _L4; else goto _L3
_L3:
            if (!ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable) goto _L2; else goto _L5
_L5:
            acontent = ((JSONObject) (obj)).getJSONArray("Error").getJSONObject(0);
            FwLog.println(ItemViewBiddingUpdater.fwLogItemViewBidding, (new StringBuilder()).append("Error ").append(acontent.getString("Id")).toString());
            Object obj2;
            obj = null;
            obj2 = obj3;
_L10:
            if (postViewItemLite == null || lastObserverUnregistered) goto _L7; else goto _L6
_L6:
            if (!continuePolling || obj != null && ((BidEvent) (obj)).finalized) goto _L9; else goto _L8
_L8:
            long l1 = postViewItemLite.getNextViewItemLitePostDelayMs();
            long l = l1;
            if (!ViewItemDataManager.logTagBidInterval.isLoggable)
            {
                l = l1 - TimeUnit.MILLISECONDS.convert(System.nanoTime() - l2, TimeUnit.NANOSECONDS);
            }
            l = Math.max(l, 5L);
            if (!ViewItemDataManager.logTagBidInterval.isLoggable && ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
            {
                FwLog.println(ItemViewBiddingUpdater.fwLogItemViewBidding, (new StringBuilder()).append(this).append(" try to send another ViewItemLite in ").append(l).append("ms (").append(l / 1000L).append("s)").toString());
            }
            postViewItemLite.postDelayed(postViewItemLite, l);
_L28:
            return ((Content) (obj2));
            acontent;
            try
            {
                Log.e(getClass().getSimpleName(), (new StringBuilder()).append("failed encoding URL ").append(((String) (obj))).toString());
                throw new RuntimeException(acontent);
            }
            // Misplaced declaration of an exception variable
            catch (Content acontent[])
            {
                obj = null;
            }
_L29:
            if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
            {
                ItemViewBiddingUpdater.fwLogItemViewBidding.logAsError("ViewItemLiteTask exception ", acontent);
            }
            ViewItemDataManager.logTag.logAsWarning("ViewItemLiteTask exception ", acontent);
            obj2 = obj3;
              goto _L10
_L4:
            obj = ((JSONObject) (obj)).getJSONArray("Item");
            if (((JSONArray) (obj)).length() <= 0) goto _L2; else goto _L11
_L11:
            boolean flag5;
            boolean flag6;
            obj1 = ((JSONArray) (obj)).getJSONObject(0);
            flag5 = ((JSONObject) (obj1)).getBoolean("IsEnded");
            flag6 = ((JSONObject) (obj1)).getBoolean("IsFinalized");
            ItemCurrency itemcurrency;
            ItemCurrency itemcurrency1;
            JSONObject ajsonobject[];
            Object obj4;
            JSONObject jsonobject;
            JSONObject jsonobject1;
            int i;
            boolean flag;
            int j;
            boolean flag1;
            boolean flag2;
            int k;
            boolean flag3;
            if (((JSONObject) (obj1)).has("IsReserve") && ((JSONObject) (obj1)).getBoolean("IsReserve"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag) goto _L13; else goto _L12
_L12:
            if (!((JSONObject) (obj1)).has("IsReserveMet") || !((JSONObject) (obj1)).getBoolean("IsReserveMet")) goto _L13; else goto _L14
_L14:
            flag3 = true;
_L31:
            k = ((JSONObject) (obj1)).getInt("BidCount");
            obj = ((JSONObject) (obj1)).getJSONObject("CurrentPrice");
            itemcurrency = new ItemCurrency(((JSONObject) (obj)).getString("CurrencyCode"), ((JSONObject) (obj)).getString("Amount"));
            obj2 = ((JSONObject) (obj1)).getJSONObject("MinimumToBid");
            itemcurrency1 = new ItemCurrency(((JSONObject) (obj)).getString("CurrencyCode"), ((JSONObject) (obj2)).getString("Amount"));
            if (((JSONObject) (obj1)).getLong("Id") != itemId) goto _L2; else goto _L15
_L15:
            flag2 = false;
            flag1 = false;
            obj2 = (Item)acontent[0].getData();
            j = ((flag2) ? 1 : 0);
            if (!flag4) goto _L17; else goto _L16
_L16:
            obj4 = ((JSONObject) (obj1)).getJSONObject("PowerBidVal1");
            jsonobject = ((JSONObject) (obj1)).getJSONObject("PowerBidVal2");
            jsonobject1 = ((JSONObject) (obj1)).getJSONObject("PowerBidVal3");
            obj = new ArrayList();
            ajsonobject = new JSONObject[3];
            ajsonobject[0] = ((JSONObject) (obj4));
            ajsonobject[1] = jsonobject;
            ajsonobject[2] = jsonobject1;
            j = ajsonobject.length;
            i = 0;
_L30:
            if (i >= j) goto _L19; else goto _L18
_L18:
            obj4 = getPowerBidValueAsItemCurrency(ajsonobject[i]);
            if (obj4 == null) goto _L21; else goto _L20
_L20:
            ((List) (obj)).add(obj4);
              goto _L21
_L19:
            j = ((flag2) ? 1 : 0);
            if (((List) (obj)).size() <= 0) goto _L17; else goto _L22
_L22:
            if (((Item) (obj2)).powerBidValues == null)
            {
                break MISSING_BLOCK_LABEL_1429;
            }
            i = ((flag1) ? 1 : 0);
            if (((Item) (obj2)).powerBidValues.size() == 0)
            {
                break MISSING_BLOCK_LABEL_1429;
            }
_L32:
            obj2;
            JVM INSTR monitorenter ;
            obj2.powerBidValues = ((List) (obj));
            obj2;
            JVM INSTR monitorexit ;
            j = i;
            if (!ViewItemDataManager.logTag.isLoggable) goto _L17; else goto _L23
_L23:
            ViewItemDataManager.logTag.log((new StringBuilder()).append("Power bid values set to ").append(((Item) (obj2)).powerBidValues.toString()).toString());
            j = i;
_L17:
            obj = null;
            if (((JSONObject) (obj1)).has("HighBidder"))
            {
                obj = ((JSONObject) (obj1)).getJSONObject("HighBidder").getString("Name");
            }
            obj1 = new BidEvent((Item)acontent[0].getData(), ((String) (obj)), k, itemcurrency, itemcurrency1, flag5, flag6, currencyConversionRate);
            obj2.bidCount = k;
            obj2.highBidderUserId = getHighBidderFromMessage(((String) (obj)), new CurrencyAmount(itemcurrency), ((Item) (obj2)));
            obj2.isUserHighBidder = ((Item) (obj2)).isHighBidder();
            if (!flag4)
            {
                break MISSING_BLOCK_LABEL_1033;
            }
            obj2.isAuctionEnded = flag5;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_1045;
            }
            obj2.isReserveMet = flag3;
            flag = true;
            if (!((BidEvent) (obj1)).finalized) goto _L25; else goto _L24
_L24:
            if (biddingUpdater != null)
            {
                biddingUpdater.stop(getContext());
            }
            i = ((flag) ? 1 : 0);
            if (!((Item) (obj2)).isUserHighBidder)
            {
                break MISSING_BLOCK_LABEL_1139;
            }
            i = ((flag) ? 1 : 0);
            if (!((Item) (obj2)).isReserveMet)
            {
                break MISSING_BLOCK_LABEL_1139;
            }
            i = ((flag) ? 1 : 0);
            if (!((Item) (obj2)).isListingTypeBid)
            {
                break MISSING_BLOCK_LABEL_1139;
            }
            obj2.paidStatus = "NotPaid";
            obj2.transactionId = Long.valueOf(0L);
            i = ((flag) ? 1 : 0);
_L27:
            obj = obj1;
            obj2 = obj3;
            if (i == 0) goto _L10; else goto _L26
_L26:
            obj = new ViewItemLiteInfo();
            obj.item = (Item)acontent[0].getData();
            obj.bidEvent = ((BidEvent) (obj1));
            ((ViewItemLiteInfo) (obj)).item.bidCount = k;
            if (currencyConversionRate == null)
            {
                obj.price = itemcurrency;
            }
            obj2 = new Content(obj);
            obj = obj1;
              goto _L10
            acontent;
            obj2;
            JVM INSTR monitorexit ;
            throw acontent;
_L25:
            if (((BidEvent) (obj1)).changed || j != 0)
            {
                break MISSING_BLOCK_LABEL_1254;
            }
            if (!flag4)
            {
                break MISSING_BLOCK_LABEL_1260;
            }
            flag3 = ((BidEvent) (obj1)).ended;
            if (!flag3)
            {
                break MISSING_BLOCK_LABEL_1260;
            }
            i = 1;
              goto _L27
            i = 0;
              goto _L27
_L9:
            if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
            {
                FwLog.println(ItemViewBiddingUpdater.fwLogItemViewBidding, (new StringBuilder()).append("removing callback continuePolling=").append(continuePolling).toString());
            }
            postViewItemLite.removeCallbacksAndMessages(postViewItemLite);
            postViewItemLite = null;
            return ((Content) (obj2));
_L7:
            if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
            {
                ItemViewBiddingUpdater.fwLogItemViewBidding.log((new StringBuilder()).append("Not scheduling next interval postViewItemLite=").append(postViewItemLite).append(";lastObserverUnregistered=").append(lastObserverUnregistered).toString());
                return ((Content) (obj2));
            }
              goto _L28
            acontent;
            obj = obj1;
              goto _L29
_L2:
            obj = null;
            obj2 = obj3;
              goto _L10
_L21:
            i++;
              goto _L30
_L13:
            flag3 = false;
              goto _L31
            i = 1;
              goto _L32
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Content[])aobj);
        }

        public String getHighBidderFromMessage(String s, CurrencyAmount currencyamount, Item item)
        {
            if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
            {
                FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[0]);
            }
            Object obj = getMaxBid(item);
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = new CurrencyAmount(((ItemCurrency) (obj)));
            }
            if (obj == null || 1 == currencyamount.compareTo(((CurrencyAmount) (obj))))
            {
                return s;
            }
            if (currencyamount.compareTo(((CurrencyAmount) (obj))) != 0)
            {
                return getUserName();
            } else
            {
                return item.highBidderUserId;
            }
        }

        protected void onCancelled()
        {
            super.onCancelled();
            if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
            {
                FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[0]);
            }
            handleViewItemLiteResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
            {
                FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[0]);
            }
            handleViewItemLiteResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public ViewItemLiteTask(long l, boolean flag)
        {
            this$0 = ViewItemDataManager.this;
            super();
            itemId = l;
            continuePolling = flag;
        }
    }


    public static final int MEB_CLEAR_NONE = 0;
    public static final int MEB_CLEAR_SELLING = 1;
    private static final String PAYPAL_PAYMENT_NAME = "PayPal";
    public static final int PPA_SHOPPING_CART_ERROR_CODE = 1;
    private static Map dirtyItems = new HashMap();
    private static final ArrayList errorCodeIgnoreList = new ArrayList(Arrays.asList(new Integer[] {
        Integer.valueOf(0), Integer.valueOf(113), Integer.valueOf(118), Integer.valueOf(401), Integer.valueOf(3021)
    }));
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("VIPDM", 3, "Log VIP DM");
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTagBidInterval = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("VIPBidInterval", 3, "Bid Interval");
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTagNoIP = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("VIPNoIP", 3, "Force NO IP");
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTagTimeLeft = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("TimeLeft", 3, "Log TimeLeft logic");
    private static Address primaryAddress;
    private Content _content;
    private AddShipmentTrackingTask addShipmentTrackingTask;
    private AddressDataManager addressDataManager;
    private Authentication auth;
    private HashMap bidItems;
    private BiddingDataManager biddingDataManagerObserving;
    private final BiddingDataManager biddingDm;
    private ItemViewBiddingUpdater biddingUpdater;
    private CategoriesDataManager categoriesDataManager;
    private com.ebay.nautilus.domain.content.dm.CategoriesDataManager.SiteCategories categoryInfo;
    private CurrencyConversionDataManager currencyConversionDataManager;
    private CurrencyConversionRate currencyConversionRate;
    private final EbayNowInventoryLookupDataManager ebayNowInventoryDm;
    private EndItemTask endItemTask;
    private ExperimentationDataManager experimentationDataManager;
    private GetBestOffersTask getBestOffersTask;
    private GetIncentivesTask getIncentivesTask;
    private GetItemTransactionsTask getItemTransactionsTask;
    private GetLocationDetailsTask getLocationDetailsTask;
    private GetOrderShippingInfoTask getOrderShippingInfoTask;
    private GetOrdersTask getOrdersTask;
    private GetProductInfoTask getProductInfoTask;
    private GetShipmentTrackingTask getShipmentTrackingTask;
    private GetViewListingTask getShippingCostsTask;
    private GetStoreAvailabilityTask getStoreAvailabilityTask;
    private GetViewListingTask getViewListingTask;
    private final Handler handler = new Handler();
    private volatile List inFlightTasks;
    private boolean isIgnoreAuthChanges;
    private boolean lastObserverUnregistered;
    private LeaveFeedbackTask leaveFeedbackTask;
    private final Location location;
    private final Object lock = new Object();
    private MakeOfferTask makeOfferTask;
    private MarkPaidTask markPaidTask;
    private MarkShippedTask markShippedTask;
    private MyEbayBuyingDataManager myEbayBuyingDataManager;
    private MyEbaySellingDataManager myEbaySellingDataManager;
    private MyEbayWatchingDataManager myEbayWatchingDataManager;
    private final KeyParams params;
    private PlaceOfferTask placeOfferTask;
    private PostViewItemLite postViewItemLite;
    private RecentsDataManager recentsDataManager;
    private boolean refreshWonList;
    private RespondBestOfferTask respondBestOfferTask;
    private ShippingDetailsDataManager shippingDetailsDataManager;
    private ShoppingCartDataManagerBase shoppingCartDataManager;
    private HashMap soldItems;
    private List userAddresses;
    private final UserCache userCache = new UserCache(getContext(), getEbayContext());
    private UserContextDataManager userContextDataManager;
    private final Map viewDataMap = new HashMap();
    private ViewItemLiteTask viewItemLiteTask;
    private HashMap watchItemsActive;
    private HashMap watchItemsEnded;
    private HashMap wonItems;

    ViewItemDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/mobile/viewitem/ViewItemDataManager$Observer);
        _content = null;
        refreshWonList = false;
        watchItemsActive = null;
        watchItemsEnded = null;
        bidItems = null;
        wonItems = null;
        soldItems = null;
        getStoreAvailabilityTask = null;
        endItemTask = null;
        addShipmentTrackingTask = null;
        markPaidTask = null;
        markShippedTask = null;
        getItemTransactionsTask = null;
        getIncentivesTask = null;
        getBestOffersTask = null;
        getLocationDetailsTask = null;
        getOrderShippingInfoTask = null;
        placeOfferTask = null;
        getProductInfoTask = null;
        makeOfferTask = null;
        leaveFeedbackTask = null;
        getShipmentTrackingTask = null;
        respondBestOfferTask = null;
        viewItemLiteTask = null;
        getOrdersTask = null;
        getViewListingTask = null;
        getShippingCostsTask = null;
        auth = null;
        isIgnoreAuthChanges = false;
        inFlightTasks = new ArrayList();
        lastObserverUnregistered = false;
        params = keyparams;
        biddingDm = (BiddingDataManager)BiddingDataManager.get(ebaycontext, new BiddingDataManager.KeyParams(keyparams.itemId, null));
        ebayNowInventoryDm = (EbayNowInventoryLookupDataManager)EbayNowInventoryLookupDataManager.get(ebaycontext, EbayNowInventoryLookupDataManager.KEY);
        location = LocationUtil.getLastKnownLocation((Context)ebaycontext.getExtension(android/content/Context));
        DeviceConfiguration.getAsync();
    }

    private void addItemToRecentlyViewedList(Content content)
    {
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        if (auth != null && content != null && deviceconfiguration.get(DcsBoolean.RecentlyViewed) && recentsDataManager != null)
        {
            content = (Item)content.getData();
            if (content != null)
            {
                recentsDataManager.addLastViewedItem(((Item) (content)).id, ((Item) (content)).primaryCategoryId);
            }
        }
    }

    private Content addItemToShoppingCartHandling(Content content)
    {
        if (_content == null || _content.getData() == null || content == null)
        {
            return null;
        }
        AddToCartInfo addtocartinfo = new AddToCartInfo();
        addtocartinfo.item = _content;
        Integer integer = null;
        ShoppingCart shoppingcart = (ShoppingCart)content.getData();
        Item item = (Item)_content.getData();
        Object obj;
        boolean flag;
        if (item.isMultiSku)
        {
            obj = item.getVariationId(getViewData().nameValueList);
        } else
        {
            obj = null;
        }
        if (shoppingcart != null && shoppingcart.getItemById(item.id, ((String) (obj))) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            if (MyApp.getPrefs().getUserIsPpa())
            {
                content = new EbayResponseError();
                content.severity = 1;
                content.code = String.valueOf(1);
            } else
            {
                integer = getAddToCartError(content, item, ((String) (obj)));
                obj = LocalizedCartMessage.getDisplayableErrorMessageFromErrorCode(getEbayContext(), integer);
                content = ((Content) (obj));
                if (obj == null)
                {
                    content = getContext().getString(0x7f070a8b);
                }
                obj = new EbayResponseError();
                obj.severity = 1;
                obj.code = String.valueOf(integer.intValue());
                obj.longMessage = content;
                content = ((Content) (obj));
            }
        } else
        {
            item.inCart = true;
            addtocartinfo.cartId = Long.toString(shoppingcart.cartId);
            addtocartinfo.buyableCount = shoppingcart.summary.totalBuyableItems;
            content = integer;
        }
        if (content != null)
        {
            content = ResultStatus.create(Arrays.asList(new EbayResponseError[] {
                content
            }));
        } else
        {
            content = ResultStatus.SUCCESS;
        }
        updateItemState(item);
        return new Content(addtocartinfo, content);
    }

    private void addTaskToList(TaskId taskid)
    {
        synchronized (lock)
        {
            inFlightTasks.add(taskid);
            if (logTag.isLoggable)
            {
                logTag.log((new StringBuilder()).append("addTaskToList (").append(taskid).append(") results in ").append(inFlightTasks.toString()).toString());
            }
        }
        return;
        taskid;
        obj;
        JVM INSTR monitorexit ;
        throw taskid;
    }

    private void cancelPendingTasks()
    {
        if (getItemTransactionsTask != null)
        {
            getItemTransactionsTask.cancel(true);
            getItemTransactionsTask = null;
        }
        if (getStoreAvailabilityTask != null)
        {
            getStoreAvailabilityTask.cancel(true);
            getStoreAvailabilityTask = null;
        }
        if (getIncentivesTask != null)
        {
            getIncentivesTask.cancel(true);
            getIncentivesTask = null;
        }
        if (getBestOffersTask != null)
        {
            getBestOffersTask.cancel(true);
            getBestOffersTask = null;
        }
        if (getLocationDetailsTask != null)
        {
            getLocationDetailsTask.cancel(true);
            getLocationDetailsTask = null;
        }
        if (getOrderShippingInfoTask != null)
        {
            getOrderShippingInfoTask.cancel(true);
            getOrderShippingInfoTask = null;
        }
        if (getViewListingTask != null)
        {
            getViewListingTask.cancel(true);
            getViewListingTask = null;
        }
        if (getShippingCostsTask != null)
        {
            getShippingCostsTask.cancel(true);
            getShippingCostsTask = null;
        }
    }

    private void clearCache()
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                params.toString()
            });
        }
        _content = null;
    }

    private com.ebay.mobile.Item.BidBounds computeActualMinToBid(Item item, ItemCurrency itemcurrency)
    {
        boolean flag;
        if (!isInMyEbayBidList(item.id, getViewData().nameValueList))
        {
            item = new CurrencyAmount(itemcurrency);
            flag = true;
        } else
        {
            Object obj = null;
            ItemCurrency itemcurrency1 = getMaxBid(item);
            item = obj;
            if (itemcurrency1 != null)
            {
                item = new CurrencyAmount(itemcurrency1);
            }
            itemcurrency = new CurrencyAmount(itemcurrency);
            if (item != null && itemcurrency.compareTo(item) <= 0)
            {
                flag = false;
            } else
            {
                item = itemcurrency;
                flag = true;
            }
        }
        return new com.ebay.mobile.Item.BidBounds(item, flag);
    }

    private void consultMyEbayForPaidStatus(Item item, List list)
    {
        boolean flag1 = false;
        list = new EbayTransactedItemSpecifics(item.id, item.transactionId, list);
        boolean flag = flag1;
        if (wonItems != null)
        {
            MyEbayListItem myebaylistitem = (MyEbayListItem)wonItems.get(list);
            flag = flag1;
            if (myebaylistitem != null)
            {
                flag = flag1;
                if (myebaylistitem.transaction != null)
                {
                    flag = setPaidStatus(item, myebaylistitem);
                }
            }
        }
        if (!flag && soldItems != null)
        {
            list = (MyEbayListItem)soldItems.get(list);
            if (list != null && ((MyEbayListItem) (list)).transaction != null)
            {
                setPaidStatus(item, list);
            }
        }
    }

    private void dispatchExternalDmCallComplete(TaskId taskid)
    {
        handleLoadDataResult(taskid, getViewData(), _content);
    }

    private ResultStatus doGetBestOffers(EbayTradingApi ebaytradingapi, long l, boolean flag, Item item)
    {
        ResultStatusOwner resultstatusowner = new ResultStatusOwner();
        boolean flag1 = true;
        if (flag)
        {
            if (com.ebay.common.view.util.EbayCountryManager.Default.supportsBestOffer(MyApp.getPrefs().getCurrentCountry()) && item.bestOfferEnabled && item.bestOfferCount > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1)
        {
            ebaytradingapi = (GetBestOffersResponse)safeSendRequest(new GetBestOffersRequest(ebaytradingapi, l), resultstatusowner);
            if (resultstatusowner.getResultStatus() != ResultStatus.CANCELED && !resultstatusowner.getResultStatus().hasError())
            {
                item.offers = ((GetBestOffersResponse) (ebaytradingapi)).offers;
            }
        }
        return resultstatusowner.getResultStatus();
    }

    public static boolean doNameValueListsMatch(List list, ArrayList arraylist)
    {
        if (arraylist != null || list != null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int j;
        if (arraylist == null && list != null || arraylist != null && list == null)
        {
            return false;
        }
        if (list.size() != arraylist.size())
        {
            return false;
        }
        j = 0;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            ImmutableNameValue immutablenamevalue = (ImmutableNameValue)iterator.next();
            String s = immutablenamevalue.name;
            List list1 = immutablenamevalue.values;
            Iterator iterator1 = arraylist.iterator();
            int i = j;
            do
            {
                j = i;
                if (!iterator1.hasNext())
                {
                    break;
                }
                Object obj = (NameValue)iterator1.next();
                if (((NameValue) (obj)).getName().equals(s) && ((NameValue) (obj)).getNumValues() == immutablenamevalue.values.size())
                {
                    boolean flag = true;
                    obj = ((NameValue) (obj)).getValues().iterator();
                    do
                    {
                        j = ((flag) ? 1 : 0);
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        if (list1.contains((String)((Iterator) (obj)).next()))
                        {
                            continue;
                        }
                        j = 0;
                        break;
                    } while (true);
                    if (j != 0)
                    {
                        i++;
                    }
                }
            } while (true);
        } while (true);
        if (j == list.size()) goto _L1; else goto _L3
_L3:
        return false;
    }

    private static boolean doesItemOnlyAcceptMerchantCreditCards(String s)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (TextUtils.isEmpty(s))
            {
                break label0;
            }
            flag = flag1;
            if (s.contains("PayPal"))
            {
                break label0;
            }
            if (!s.contains("VisaMC") && !s.contains("Discover"))
            {
                flag = flag1;
                if (!s.contains("AmEx"))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    private static boolean doesItemShipToUser(Item item)
    {
        boolean flag2 = true;
        boolean flag;
        boolean flag1;
        if (item.isLocalPickupOnly || item.isShowEbayNow || item.inventoryInfo != null && item.inventoryInfo.getAvailabilities() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && primaryAddress != null)
        {
            flag1 = item.isValidShippingAddress(primaryAddress);
        } else
        {
            flag1 = flag2;
            if (!flag)
            {
                flag1 = flag2;
                if (!TextUtils.isEmpty(item.buyerCountryCode))
                {
                    return item.isValidShippingCountry(item.buyerCountryCode);
                }
            }
        }
        return flag1;
    }

    private void fillAppropriateMapForWatchlist(String s, UserDefinedList userdefinedlist, boolean flag)
    {
        if (flag)
        {
            if (watchItemsActive == null)
            {
                watchItemsActive = new HashMap();
            } else
            {
                watchItemsActive.clear();
            }
        } else
        if (watchItemsEnded == null)
        {
            watchItemsEnded = new HashMap();
        } else
        {
            watchItemsEnded.clear();
        }
        if (userdefinedlist != null && userdefinedlist.list != null && !userdefinedlist.list.isEmpty())
        {
            for (s = userdefinedlist.list.iterator(); s.hasNext();)
            {
                userdefinedlist = (MyEbayListItem)s.next();
                if (flag)
                {
                    watchItemsActive.put(new EbayItemIdAndVariationSpecifics(userdefinedlist), userdefinedlist);
                } else
                {
                    watchItemsEnded.put(new EbayItemIdAndVariationSpecifics(userdefinedlist), userdefinedlist);
                }
            }

        }
    }

    private Integer getAddToCartError(Content content, Item item, String s)
    {
        s = Integer.valueOf(0);
        item = s;
        if (content != null)
        {
            item = s;
            if (content.getStatus().hasError())
            {
                item = Integer.valueOf(content.getStatus().getFirstError().getId());
            }
        }
        content = item;
        if (errorCodeIgnoreList.contains(item))
        {
            content = Integer.valueOf(0);
        }
        return content;
    }

    private static String getBuyerCountryCode(Item item)
    {
        item = getBuyerPostalCodeSpec(item);
        if (item != null)
        {
            return ((PostalCodeSpecification) (item)).countryCode;
        } else
        {
            return null;
        }
    }

    private static String getBuyerLocation(Resources resources, Item item)
    {
label0:
        {
            Object obj = getBuyerPostalCodeSpec(item);
            item = null;
            if (obj != null)
            {
                item = EbayCountryManager.getCountryName(resources, ((PostalCodeSpecification) (obj)).countryCode);
                obj = ((PostalCodeSpecification) (obj)).stateOrProvince;
                resources = ((Resources) (obj));
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    resources = ((String) (obj)).trim();
                }
                if (!TextUtils.isEmpty(resources))
                {
                    break label0;
                }
            }
            return item;
        }
        return (new StringBuilder()).append(resources).append(", ").append(item).toString();
    }

    private static PostalCodeSpecification getBuyerPostalCodeSpec(Item item)
    {
        if (item.iTransaction != null)
        {
            PostalCodeSpecification postalcodespecification = new PostalCodeSpecification();
            postalcodespecification.postalCode = item.iTransaction.buyerPostalCode;
            postalcodespecification.countryCode = item.iTransaction.buyerCountry;
            postalcodespecification.stateOrProvince = item.iTransaction.buyerStateOrProvince;
            item = postalcodespecification;
        } else
        {
            item = MyApp.getPrefs().getShipToPostalCode();
        }
        if (item != null && "AA".equals(((PostalCodeSpecification) (item)).countryCode))
        {
            item.countryCode = "APO/FPO";
        }
        return item;
    }

    private static String getBuyingOptionsVerbiage(Context context, Item item)
    {
        String s1 = context.getString(0x7f0701c8);
        String s2 = ItemViewPayPalable.getUsePayPalError(context, item);
        String s;
        if ("Half".equals(item.listingType))
        {
            s = context.getString(0x7f0701c6);
        } else
        {
            if ("LeadGeneration".equals(item.listingType))
            {
                return context.getString(0x7f0701c7);
            }
            if (item.isLiveAuction)
            {
                return context.getString(0x7f0701c5);
            }
            s = s1;
            if (item.isBusinessTypeOkForPurchase())
            {
                s = s1;
                if (!TextUtils.isEmpty(s2))
                {
                    if (item.autoPay)
                    {
                        return (new StringBuilder()).append(context.getString(0x7f07017f)).append("\n\n").append(s2).toString();
                    } else
                    {
                        return s2;
                    }
                }
            }
        }
        return s;
    }

    private ItemCurrency getCachedCurrencyPrice(Item item, ItemCurrency itemcurrency)
    {
        if (itemcurrency == null)
        {
            return null;
        } else
        {
            return Item.getCachedCurrencyPrice(getEbayContext(), itemcurrency, currencyConversionRate);
        }
    }

    private static ItemCurrency getConvertedBinPrice(Item item)
    {
        if (item.convertedBuyItNowPrice != null)
        {
            return item.convertedBuyItNowPrice;
        } else
        {
            return item.convertedCurrentPrice;
        }
    }

    private ItemCurrency getConvertedCurrentPriceOfItem(Item item)
    {
        NautilusKernel.verifyMain();
        String s = MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode();
        if (item.isScheduled && item.startPrice != null)
        {
            if (item.convertedStartPrice != null && item.convertedStartPrice.code.equals(s))
            {
                return item.convertedStartPrice;
            } else
            {
                return getCachedCurrencyPrice(item, item.startPrice);
            }
        }
        if (item.isListingTypeBin && item.buyItNowPrice != null)
        {
            if (getConvertedBinPrice(item) != null && getConvertedBinPrice(item).code.equals(s))
            {
                return getConvertedBinPrice(item);
            } else
            {
                return getCachedCurrencyPrice(item, item.buyItNowPrice);
            }
        }
        if (item.convertedCurrentPrice != null && item.convertedCurrentPrice.code.equals(s))
        {
            return item.convertedCurrentPrice;
        } else
        {
            return getCachedCurrencyPrice(item, item.currentPrice);
        }
    }

    private static ItemCurrency getCurrentPriceOfItem(Item item, ViewItemViewData viewitemviewdata)
    {
        Object obj = null;
        if (!item.isScheduled || item.startPrice == null) goto _L2; else goto _L1
_L1:
        ItemCurrency itemcurrency = item.startPrice;
_L4:
        viewitemviewdata = itemcurrency;
        if (itemcurrency == null)
        {
            if (!item.isListingTypeBin)
            {
                break; /* Loop/switch isn't completed */
            }
            viewitemviewdata = item.buyItNowPrice;
        }
        return viewitemviewdata;
_L2:
        itemcurrency = obj;
        if (item.isMultiSku)
        {
            itemcurrency = obj;
            if (viewitemviewdata != null)
            {
                itemcurrency = obj;
                if (!item.needsToSelectMultiSku(viewitemviewdata.nameValueList))
                {
                    itemcurrency = item.getVariationPrice(viewitemviewdata.nameValueList);
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        return item.currentPrice;
    }

    private String getHighBidderFromMessage(Item item, String s, CurrencyAmount currencyamount)
    {
        Object obj = getMaxBid(item);
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = new CurrencyAmount(((ItemCurrency) (obj)));
        }
        if (obj == null || 1 == currencyamount.compareTo(((CurrencyAmount) (obj))))
        {
            return s;
        }
        if (currencyamount.compareTo(((CurrencyAmount) (obj))) != 0)
        {
            return item.user;
        } else
        {
            return item.highBidderUserId;
        }
    }

    private static boolean getIsShowFastAndFree(Item item)
    {
        boolean flag1 = false;
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        boolean flag = flag1;
        if (!item.isShowItemCard)
        {
            flag = flag1;
            if (deviceconfiguration.get(DcsBoolean.FastAndFree))
            {
                item = ViewItemShippingInfo.getCarrierShippingOptions(item);
                flag = flag1;
                if (!item.isEmpty())
                {
                    flag = ((ShippingCostsShippingOption)item.get(0)).fastAndFree;
                }
            }
        }
        return flag;
    }

    private void getItemIncentivesCouponsHandling(com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesResponse getitemincentivesresponse, Item item)
    {
        item.coupons = "";
        ItemIncentives itemincentives = getitemincentivesresponse.getItemIncentives();
        for (getitemincentivesresponse = Integer.valueOf(0); getitemincentivesresponse.intValue() < itemincentives.incentives.size(); getitemincentivesresponse = Integer.valueOf(getitemincentivesresponse.intValue() + 1))
        {
            Incentive incentive = (Incentive)itemincentives.incentives.get(getitemincentivesresponse.intValue());
            item.coupons = (new StringBuilder()).append(item.coupons).append(incentive.displayMsg).toString();
            if (getitemincentivesresponse.intValue() < itemincentives.incentives.size() - 1)
            {
                item.coupons = (new StringBuilder()).append(item.coupons).append("\n").toString();
            }
        }

        getitemincentivesresponse = Integer.valueOf(item.coupons.length());
        if (getitemincentivesresponse.intValue() > 0 && ('.' == item.coupons.charAt(getitemincentivesresponse.intValue() - 1) || ',' == item.coupons.charAt(getitemincentivesresponse.intValue() - 1)))
        {
            item.coupons = item.coupons.substring(0, getitemincentivesresponse.intValue() - 1);
        }
    }

    private void getItemIncentivesRewardsHandling(com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesResponse getitemincentivesresponse, Item item)
    {
        item.bucksRewards = "";
        item.nectarRewards = "";
        ItemIncentives itemincentives = getitemincentivesresponse.getItemIncentives();
        BigDecimal bigdecimal = new BigDecimal(0.01D);
        getitemincentivesresponse = Integer.valueOf(0);
        while (getitemincentivesresponse.intValue() < itemincentives.rewards.size()) 
        {
            Object obj = (RewardsIncentive)itemincentives.rewards.get(getitemincentivesresponse.intValue());
            if (((RewardsIncentive) (obj)).isBucks())
            {
                if (((RewardsIncentive) (obj)).amount.getValueAsBigDecimal().compareTo(bigdecimal) >= 0)
                {
                    if (item.bucksRewards.length() > 0)
                    {
                        item.bucksRewards = (new StringBuilder()).append(item.bucksRewards).append(", ").toString();
                    }
                    item.bucksRewards = (new StringBuilder()).append(item.bucksRewards).append(EbayCurrencyUtil.formatDisplay(((RewardsIncentive) (obj)).amount, 0)).toString();
                }
            } else
            if (((RewardsIncentive) (obj)).isNectarPoints())
            {
                com.ebay.common.model.cart.RewardsIncentive.RewardsDetail rewardsdetail1 = null;
                com.ebay.common.model.cart.RewardsIncentive.RewardsDetail rewardsdetail = null;
                Iterator iterator = ((RewardsIncentive) (obj)).rewardsDetails.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    obj = (com.ebay.common.model.cart.RewardsIncentive.RewardsDetail)iterator.next();
                    if (((com.ebay.common.model.cart.RewardsIncentive.RewardsDetail) (obj)).isBaseOffer())
                    {
                        rewardsdetail1 = ((com.ebay.common.model.cart.RewardsIncentive.RewardsDetail) (obj));
                    } else
                    if (((com.ebay.common.model.cart.RewardsIncentive.RewardsDetail) (obj)).isBoosterOffer())
                    {
                        rewardsdetail = ((com.ebay.common.model.cart.RewardsIncentive.RewardsDetail) (obj));
                    }
                } while (true);
                obj = getContext().getResources();
                if (rewardsdetail1 != null && rewardsdetail1.promotionAmount != null)
                {
                    int i = (int)rewardsdetail1.promotionAmount.doubleValue();
                    item.nectarRewards = String.format(((Resources) (obj)).getQuantityString(0x7f080022, i), new Object[] {
                        Integer.valueOf(i)
                    });
                    if (rewardsdetail != null && rewardsdetail.promotionAmount != null)
                    {
                        int j = (int)rewardsdetail.promotionAmount.doubleValue();
                        item.nectarRewards = (new StringBuilder()).append(item.nectarRewards).append(String.format(((Resources) (obj)).getQuantityString(0x7f080021, j), new Object[] {
                            Integer.valueOf(j)
                        })).toString();
                    }
                }
            }
            getitemincentivesresponse = Integer.valueOf(getitemincentivesresponse.intValue() + 1);
        }
    }

    private static String getItemPaymentMethods(Item item)
    {
        if (TextUtils.isEmpty(item.availablePaymentMethods))
        {
            StringBuilder stringbuilder = new StringBuilder();
            String s;
            for (Iterator iterator = item.paymentMethods.iterator(); iterator.hasNext(); stringbuilder.append(s))
            {
                s = (String)iterator.next();
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(",");
                }
            }

            item.availablePaymentMethods = stringbuilder.toString();
        }
        return item.availablePaymentMethods;
    }

    private void getItemTransactionsHandling(GetItemTransactionsResponse getitemtransactionsresponse, ViewItemViewData viewitemviewdata, long l, Content content)
    {
        Item item = (Item)content.getData();
        item.iTransaction = getitemtransactionsresponse.getItemTransaction();
        item.isTransacted = true;
        if (item.site != null && getOrderShippingInfoTask == null)
        {
            getOrderShippingInfoTask = new GetOrderShippingInfoTask(viewitemviewdata);
            executeOnThreadPool(getOrderShippingInfoTask, new Content[] {
                content
            });
        }
        if (item.paymentMethods.isEmpty())
        {
            item.paymentMethods = item.iTransaction.paymentMethods;
        }
        if (item.iTransaction != null && item.iTransaction.selectedShippingOption != null && "NotSelected".equals(item.iTransaction.selectedShippingOption.shippingServiceName))
        {
            item.iTransaction.selectedShippingOption.shippingServiceName = null;
        }
        if (item.iTransaction != null && item.iTransaction.variation != null)
        {
            item.mskuSelections = item.iTransaction.variation.nameValueList;
        }
        if (item.iTransaction != null)
        {
            setPaidStatus(item, viewitemviewdata);
        }
        if (shouldMakeStoreLocationCall(item, viewitemviewdata) && getLocationDetailsTask == null)
        {
            getLocationDetailsTask = new GetLocationDetailsTask(viewitemviewdata);
            executeOnThreadPool(getLocationDetailsTask, new Content[] {
                content
            });
        }
        getitemtransactionsresponse = new com.ebay.nautilus.domain.content.PaymentReminderStorageUtil.PaymentReminderStorageParams();
        getitemtransactionsresponse.id = item.id;
        boolean flag;
        if (item.iTransaction != null && item.iTransaction.createdDate != null)
        {
            l = item.iTransaction.createdDate.getTime();
        } else
        {
            l = 0L;
        }
        getitemtransactionsresponse.transactionCreationDate = l;
        getitemtransactionsresponse.variationSpecifics = viewitemviewdata.nameValueList;
        if (DeviceConfiguration.getAsync().get(DcsBoolean.sellerPaymentReminder) && item.isSeller && Item.getPaidStatus(item) == com.ebay.mobile.Item.PaidStatus.NOT_PAID)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowPaymentReminder = flag;
        item.isPaymentReminderActivationTimeElaspsed = shouldDisplayPaymentReminder(item);
        l = PaymentReminderStorageUtil.getPaymentReminderSentDate(getitemtransactionsresponse);
        if (l > 0L)
        {
            item.paymentReminderSentDate = (String)DateFormat.format(Util.getDeliveryDateFormat(getContext(), false), l);
        }
        item.updatePaymentReminderState(PaymentReminderStorageUtil.isReminderSent(getitemtransactionsresponse));
    }

    private void getLocationDetailsHandling(GetLocationDetailsResponse getlocationdetailsresponse, Item item, ArrayList arraylist)
    {
        if (getlocationdetailsresponse != null && getlocationdetailsresponse.locationDetails != null && getlocationdetailsresponse.locationDetails.address != null)
        {
            item.isInventoryCallFail = false;
            if (item.inventoryInfo == null)
            {
                item.inventoryInfo = new InventoryInfo();
            }
            item.inventoryInfo.setSelectedStore(new StoreAvailability(getlocationdetailsresponse.locationDetails));
            item.inventoryInfo.setSellerUserId(item.sellerUserId);
            InventoryInfo inventoryinfo = item.inventoryInfo;
            if (item.isMultiSku)
            {
                getlocationdetailsresponse = item.getVariationSKU(arraylist);
            } else
            {
                getlocationdetailsresponse = item.sku;
            }
            inventoryinfo.setItemSku(getlocationdetailsresponse);
            return;
        } else
        {
            item.isInventoryCallFail = true;
            return;
        }
    }

    public static Pair getLogisticsPlanTypeAndEstimatedDeliveryDate(Item item)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        if (!item.isBopisable) goto _L2; else goto _L1
_L1:
        Date date;
        obj = com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.ISPU;
        date = obj1;
_L4:
        return new Pair(obj, date);
_L2:
        date = obj1;
        if (!item.isPudoable)
        {
            continue; /* Loop/switch isn't completed */
        }
        com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type type = com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO;
        item = item.shippingInfo.pudoOptions;
        date = obj1;
        obj = type;
        if (item == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        item = item.iterator();
        do
        {
            date = obj1;
            obj = type;
            if (!item.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (ShippingCostsShippingOption)item.next();
        } while (((ShippingCostsShippingOption) (obj)).logisticsPlanType == null || ((ShippingCostsShippingOption) (obj)).logisticsPlanType != com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.PUDO);
        date = ((ShippingCostsShippingOption) (obj)).estimatedDeliveryMaxTime;
        obj = type;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static long getNextViewItemLiteDelayMs(long l)
    {
        long l1;
        l1 = 1000L;
        if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
        {
            ItemViewBiddingUpdater.fwLogItemViewBidding.log((new StringBuilder()).append("timeRemainingMs=").append(l).toString());
        }
        if (l <= 0x5265c00L) goto _L2; else goto _L1
_L1:
        l1 = 0x927c0L;
_L4:
        l = l1;
        if (logTagBidInterval.isLoggable)
        {
            l = l1;
            if (l1 > 60000L)
            {
                l = 60000L;
            }
        }
        return l;
_L2:
        if (l > 0x36ee80L)
        {
            l1 = 0x493e0L;
        } else
        if (l > 0x2bf20L)
        {
            l1 = 60000L;
        } else
        if (l > 0x1d4c0L)
        {
            l1 = 10000L;
        } else
        if (l > 60000L)
        {
            l1 = 5000L;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private ResultStatus getOrderShippingInfo(Item item)
    {
        Object obj = new GetOrderShippingInfoRequest(auth.iafToken, EbaySite.getInstanceFromId(item.site), item.getIdString(), Long.toString(item.transactionId.longValue()));
        ResultStatusOwner resultstatusowner = new ResultStatusOwner();
        obj = (GetOrderShippingInfoResponse)safeSendRequest(((Request) (obj)), resultstatusowner);
        if (resultstatusowner.getResultStatus() != ResultStatus.CANCELED && !resultstatusowner.getResultStatus().hasError())
        {
            getOrderShippinginfoHandling(((GetOrderShippingInfoResponse) (obj)), item);
        }
        return resultstatusowner.getResultStatus();
    }

    private void getOrderShippinginfoHandling(GetOrderShippingInfoResponse getordershippinginforesponse, Item item)
    {
        getordershippinginforesponse = getordershippinginforesponse.info;
        if (item != null && item.iTransaction != null && ((OrderShippingInfo) (getordershippinginforesponse)).estimatedMaxDeliveryDate != null && ((OrderShippingInfo) (getordershippinginforesponse)).estimatedMinDeliveryDate != null)
        {
            item.iTransaction.orderShippingInfo = getordershippinginforesponse;
        } else
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "Error loading order shipping info");
            return;
        }
    }

    private Address getPrimaryAddress()
    {
        return getPrimaryAddress(auth, userAddresses);
    }

    public static Address getPrimaryAddress(Authentication authentication, List list)
    {
        Object obj = null;
        Address address = obj;
        if (authentication != null)
        {
            address = obj;
            if (list != null)
            {
                authentication = list.iterator();
                do
                {
                    address = obj;
                    if (!authentication.hasNext())
                    {
                        break;
                    }
                    address = (Address)authentication.next();
                } while (!address.isDefault());
            }
        }
        return address;
    }

    private static String getSalesTaxPercent(Item item, ViewItemViewData viewitemviewdata)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        if (!item.isTransacted) goto _L2; else goto _L1
_L1:
        viewitemviewdata = Float.valueOf(item.iTransaction.salesTaxPercent);
_L4:
        item = obj;
        if (viewitemviewdata != null)
        {
            item = obj;
            if (0.0F < viewitemviewdata.floatValue())
            {
                item = (new DecimalFormat("#.##")).format(viewitemviewdata);
            }
        }
        return item;
_L2:
        PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getShipToPostalCode();
        viewitemviewdata = obj1;
        if (postalcodespecification == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        viewitemviewdata = obj1;
        if (TextUtils.isEmpty(postalcodespecification.stateOrProvince))
        {
            continue; /* Loop/switch isn't completed */
        }
        viewitemviewdata = obj1;
        if (item.shippingInfo.taxTable == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        Iterator iterator = item.shippingInfo.taxTable.iterator();
        ShippingCostsTaxJurisdiction shippingcoststaxjurisdiction;
        do
        {
            viewitemviewdata = obj1;
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            shippingcoststaxjurisdiction = (ShippingCostsTaxJurisdiction)iterator.next();
        } while (!postalcodespecification.stateOrProvince.equals(shippingcoststaxjurisdiction.jurisdictionId));
        viewitemviewdata = Float.valueOf(shippingcoststaxjurisdiction.salesTaxPercent);
        item.isSalesTaxAppliedToShipping = shippingcoststaxjurisdiction.shippingIncludedInTax;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void getShoppingCartHandling(Content content, Item item)
    {
        PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getShipToPostalCode();
        if (postalcodespecification != null)
        {
            item.cartCountry = postalcodespecification.countryCode;
        }
        if (content != null)
        {
            ShoppingCart shoppingcart = (ShoppingCart)content.getData();
            boolean flag;
            if (item.isMultiSku)
            {
                content = item.getVariationId(getViewData().nameValueList);
            } else
            {
                content = null;
            }
            if (shoppingcart.getItemById(item.id, content) != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            item.inCart = flag;
            if (shoppingcart != null && shoppingcart.shippingAddress != null)
            {
                item.cartCountry = shoppingcart.shippingAddress.country;
            }
        }
    }

    private void getStoreAvailability(Item item, String s, ArrayList arraylist)
    {
label0:
        {
            Object obj1 = item.sku;
            Object obj = obj1;
            if (item.isMultiSku)
            {
                obj = obj1;
                if (!item.needsToSelectMultiSku(arraylist))
                {
                    obj = item.getVariationSKU(arraylist);
                }
            }
            EbayCountry ebaycountry = MyApp.getPrefs().getCurrentCountry();
            Object obj2 = ebaycountry.site.id;
            obj1 = com.ebay.common.net.api.inventory.LookupAvailabilityRequest.Unit.KM;
            if (((String) (obj2)).equals(EbaySite.UK.id) || ((String) (obj2)).equals(EbaySite.US.id))
            {
                obj1 = com.ebay.common.net.api.inventory.LookupAvailabilityRequest.Unit.MILE;
            }
            obj2 = getLogisticsPlanTypeAndEstimatedDeliveryDate(item);
            Object obj3 = DeviceConfiguration.getAsync();
            int i = ((DeviceConfiguration) (obj3)).get(DcsInteger.StorePickerSearchRadius);
            if (isAvailableForPickupAndDropoff(item))
            {
                i = ((DeviceConfiguration) (obj3)).get(DcsInteger.StorePickerSearchRadiusPudo);
            }
            obj3 = LocationUtil.getAvailableLocation(getContext(), s, item.site);
            if (obj3 != null)
            {
                obj1 = new LookupAvailabilityRequest(item.sellerUserId, ((String) (obj)), ((com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation) (obj3)), Integer.valueOf(i), ((com.ebay.common.net.api.inventory.LookupAvailabilityRequest.Unit) (obj1)), ebaycountry.getCountryCode(), (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type)((Pair) (obj2)).first, (Date)((Pair) (obj2)).second);
                obj = new ResultStatusOwner();
                obj1 = (LookupAvailabilityResponse)safeSendRequest(((Request) (obj1)), ((ResultStatusOwner) (obj)));
                if (((ResultStatusOwner) (obj)).getResultStatus() != ResultStatus.CANCELED)
                {
                    if (((ResultStatusOwner) (obj)).getResultStatus().hasError())
                    {
                        break label0;
                    }
                    getStoreAvailabilityHandling(((LookupAvailabilityResponse) (obj1)), item, s, arraylist);
                }
            }
            return;
        }
        item.isInventoryCallFail = true;
    }

    private void getStoreAvailabilityHandling(LookupAvailabilityResponse lookupavailabilityresponse, Item item, String s, ArrayList arraylist)
    {
        List list = lookupavailabilityresponse.getAvailabilities();
        Object obj;
        Object obj1;
        int i;
        if (!item.isMultiSku)
        {
            Pair pair;
            DeviceConfiguration deviceconfiguration;
            boolean flag;
            if (list == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            item.isInventoryCallFail = flag;
        } else
        {
            item.isInventoryCallFail = false;
        }
        if (list == null)
        {
            i = 0;
        } else
        {
            i = list.size();
        }
        item.storesWithItem = i;
        obj1 = LocationUtil.getAvailableLocation(getContext(), s, item.site);
        lookupavailabilityresponse = null;
        obj = lookupavailabilityresponse;
        if (obj1 != null)
        {
            obj = lookupavailabilityresponse;
            if (((com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation) (obj1)).getLatitude() != null)
            {
                obj = lookupavailabilityresponse;
                if (((com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation) (obj1)).getLongitude() != null)
                {
                    obj = new LatLng(((com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation) (obj1)).getLatitude().doubleValue(), ((com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation) (obj1)).getLongitude().doubleValue());
                }
            }
        }
        lookupavailabilityresponse = com.ebay.common.model.inventory.InventoryInfo.ListDerivation.UNKNOWN;
        if (!TextUtils.isEmpty(s))
        {
            lookupavailabilityresponse = com.ebay.common.model.inventory.InventoryInfo.ListDerivation.SEARCH_POSTAL_CODE;
        } else
        if (obj != null)
        {
            lookupavailabilityresponse = com.ebay.common.model.inventory.InventoryInfo.ListDerivation.LATLNG;
        } else
        {
            lookupavailabilityresponse = com.ebay.common.model.inventory.InventoryInfo.ListDerivation.POSTAL_CODE;
        }
        pair = getLogisticsPlanTypeAndEstimatedDeliveryDate(item);
        deviceconfiguration = DeviceConfiguration.getAsync();
        if (obj1 == null)
        {
            s = null;
        } else
        {
            s = ((com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation) (obj1)).getPostalCode();
        }
        i = deviceconfiguration.get(DcsInteger.BopisGeocoderBiasBoxSize);
        obj1 = item.sellerUserId;
        if (item.isMultiSku)
        {
            arraylist = item.getVariationSKU(arraylist);
        } else
        {
            arraylist = item.sku;
        }
        item.inventoryInfo = new InventoryInfo(s, ((LatLng) (obj)), i, list, lookupavailabilityresponse, ((String) (obj1)), arraylist, (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type)pair.first, (Date)pair.second, item.site);
    }

    private ViewItemViewData getViewData()
    {
        ViewItemViewData viewitemviewdata1 = (ViewItemViewData)viewDataMap.get(params);
        ViewItemViewData viewitemviewdata = viewitemviewdata1;
        if (viewitemviewdata1 == null)
        {
            viewitemviewdata = new ViewItemViewData(getContext());
        }
        return viewitemviewdata;
    }

    private void handleShippingCostsSingleResult(TaskId taskid, Content content)
    {
        if (TaskId.GET_SHIPPING_COSTS_SINGLE == taskid)
        {
            getShippingCostsTask = null;
        }
        removeTaskFromList(taskid);
        if (content == null)
        {
            return;
        } else
        {
            onDataChanged((Observer)dispatcher, content, ActionHandled.SHIPPING_COSTS, true);
            return;
        }
    }

    private void handleVlsFlagsResult(TaskId taskid, Content content)
    {
        if (TaskId.GET_ITEM_FLAGS == taskid)
        {
            getViewListingTask = null;
        }
        removeTaskFromList(taskid);
        if (content == null)
        {
            return;
        }
        if (content.getStatus() != ResultStatus.SUCCESS)
        {
            taskid = new Content(null, content.getStatus());
        } else
        {
            taskid = content;
            updateItemState((Item)taskid.getData());
            _content = taskid;
        }
        onDataChanged((Observer)dispatcher, taskid, ActionHandled.GET_ITEM_FLAGS_REFRESHED, true);
    }

    private static boolean isAuctionEndedLessThanXMsAgo(long l, Item item)
    {
label0:
        {
            boolean flag = false;
            if (item.endDate != null)
            {
                long l1 = item.getAuctionTimeRemainingMs();
                if (l1 >= 0L || l1 <= -l)
                {
                    break label0;
                }
                flag = true;
            }
            return flag;
        }
        return false;
    }

    private static boolean isAuctionEndingWithinX(long l, Item item)
    {
label0:
        {
            boolean flag = false;
            if (item.endDate != null)
            {
                long l1 = item.getAuctionTimeRemainingMs();
                if (l1 >= l || 0L > l1)
                {
                    break label0;
                }
                flag = true;
            }
            return flag;
        }
        return false;
    }

    private static boolean isAvailableForPickupAndDropoff(Item item)
    {
        return item.availableForPickupAndDropoff || item.iTransaction != null && item.iTransaction.selectedMethod != null && com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO.altName.equals(item.iTransaction.selectedMethod);
    }

    private static boolean isAvailableForPickupInStore(Item item)
    {
        return item.availableForPickupInStore || item.iTransaction != null && item.iTransaction.selectedMethod != null && com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.ISPU.longName.equals(item.iTransaction.selectedMethod);
    }

    public static boolean isBestOffer(Item item)
    {
        String s = MyApp.getPrefs().getCurrentUser();
        return item != null && item.bestOfferEnabled && item.offers != null && !item.offers.isEmpty() && !item.isTransacted && (!item.isSeller || item.numberOfPendingBestOffersForSeller() > 0) && item.newestBestOffer(s) != null;
    }

    private static boolean isBopisable(Context context, Item item, ViewItemViewData viewitemviewdata)
    {
        boolean flag;
        boolean flag1;
        if (MyApp.getPrefs().isSignedIn() && MyApp.getPrefs().getUserIsPpa())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && PickupUtil.debugLogger.isLoggable)
        {
            PickupUtil.debugLogger.log("User is PPA; hide bopis");
        }
        flag1 = isAvailableForPickupInStore(item);
        if (PickupUtil.debugLogger.isLoggable)
        {
            PickupUtil.debugLogger.log((new StringBuilder()).append("Item available for pickup: ").append(flag1).toString());
        }
        if (item.isInventoryCallFail && PickupUtil.debugLogger.isLoggable)
        {
            PickupUtil.debugLogger.log("Inventory call failed; hide bopis");
        }
        return !flag && !item.isInventoryCallFail && flag1 && MyApp.getDeviceConfiguration().isBopisEnabled();
    }

    private static boolean isBopisableAndPurchasedViaBopis(Context context, Item item, ViewItemViewData viewitemviewdata)
    {
        return item.isBopisable && item.isTransacted && com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.ISPU.longName.equals(item.iTransaction.selectedMethod);
    }

    private static boolean isCartable(Item item, boolean flag)
    {
        boolean flag3 = true;
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        boolean flag4 = dcshelper.isMecOrMec2Enabled(item.site);
        if (dcshelper.getConfig().get(DcsBoolean.UseViewListingServiceCartableFlag) && flag)
        {
            return item.isListingCartable;
        }
        Object obj1 = item.currentPrice;
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = obj1;
            if (item.buyItNowPrice != null)
            {
                obj = item.buyItNowPrice;
            }
        }
        if (obj == null)
        {
            logTag.logAsError("isCartable: item price could not be determined, item is not cartable");
            return false;
        }
        obj = ((ItemCurrency) (obj)).code;
        obj1 = MyApp.getPrefs().getCurrentSite();
        String s = ((EbaySite) (obj1)).getCurrency().getCurrencyCode();
        boolean flag1;
        boolean flag2;
        if (!MyApp.getPrefs().isSignedIn() || getBuyerCountryCode(item) == null || item.isValidShippingCountry(getBuyerCountryCode(item)))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag = ((EbaySite) (obj1)).name.equalsIgnoreCase(item.site);
        if (EbaySite.US.equals(obj1) && EbaySite.MOTOR.name.equals(item.site))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag4 && !item.isAuctionEnded && (item.isListingTypeBin || item.isBidWithBin) && item.isSellerAcceptsPayPal && (flag || flag2) && flag1 && TextUtils.equals(((CharSequence) (obj)), s) && !isExcludedCategory(dcshelper.getShoppingCartExcludedItemCategories(), item.primaryCategoryIdPath))
        {
            flag = flag3;
        } else
        {
            flag = false;
        }
        return flag;
    }

    private static boolean isEbayNowAvailable(Item item, ViewItemViewData viewitemviewdata)
    {
        return DeviceConfiguration.getAsync().get(DcsBoolean.eBayNow) && item.availableForEbayNow;
    }

    private static boolean isExcludedCategory(Set set, String s)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (set == null) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L3
_L3:
        int i;
        int j;
        s = s.split(":");
        j = s.length;
        i = 0;
_L8:
        flag = flag1;
        if (i >= j) goto _L2; else goto _L4
_L4:
        if (!set.contains(s[i])) goto _L6; else goto _L5
_L5:
        flag = true;
_L2:
        return flag;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private boolean isHideTimeLeft(Item item)
    {
        boolean flag1 = false;
        if (item.hotnessEndTime > 0L && EbayResponse.currentHostTime() <= item.hotnessEndTime)
        {
            if (isItemEndingMoreThanXHours(item.hotnessEndTime, 0x5265c00L))
            {
                if (logTagTimeLeft.isLoggable)
                {
                    logTagTimeLeft.log("Hiding time left due to hotness signal end time > 24 hours");
                }
                flag1 = true;
            }
        } else
        {
            boolean flag;
            boolean flag2;
            if ("Half".equals(item.listingType) || "GTC".equals(item.listingDuration) || item.isClassifiedItem())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag || item.endDate == null || item.isBinOnly && isItemEndingMoreThanXHours(item.endDate.getTime(), 0x5265c00L))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag1 = flag2;
            if (flag2)
            {
                flag1 = flag2;
                if (logTagTimeLeft.isLoggable)
                {
                    if (flag)
                    {
                        logTagTimeLeft.log("Hiding time left due to item type (GTC, Half, Classified, or null endDate)");
                        return flag2;
                    }
                    if (item.endDate == null)
                    {
                        logTagTimeLeft.log("Hiding time left due to null endDate");
                        return flag2;
                    } else
                    {
                        logTagTimeLeft.log("Hiding time left due to BIN only and > 24 hours to end time");
                        return flag2;
                    }
                }
            }
        }
        return flag1;
    }

    private boolean isInventoryCallPossible(Item item, ViewItemViewData viewitemviewdata, boolean flag)
    {
        boolean flag1;
        if (!item.isAuctionEnded)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return (item.isBopisable || item.isPudoable) && LocationUtil.getAvailableLocation(getContext(), viewitemviewdata.searchRefinedPostalCode, item.site) != null && (flag1 || flag) && !item.needsToSelectMultiSku(item.mskuSelections) && (!TextUtils.isEmpty(item.getVariationSKU(item.mskuSelections)) || !TextUtils.isEmpty(item.sku) || item.isPudoable);
    }

    private boolean isItemEndingMoreThanXHours(long l, long l1)
    {
        return l - EbayResponse.currentHostTime() > l1;
    }

    private boolean isItemTransacted(Map map, ViewItemViewData viewitemviewdata)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (map != null)
        {
            ArrayList arraylist = new ArrayList();
            map = map.keySet().iterator();
            do
            {
                if (!map.hasNext())
                {
                    break;
                }
                EbayTransactedItemSpecifics ebaytransacteditemspecifics = (EbayTransactedItemSpecifics)map.next();
                if (ebaytransacteditemspecifics.id == params.itemId && (!((Item)_content.getData()).isMultiSku || ebaytransacteditemspecifics.variationSpecifics != null && doNameValueListsMatch(ebaytransacteditemspecifics.variationSpecifics, viewitemviewdata.nameValueList)) && ebaytransacteditemspecifics.transactionId != null && viewitemviewdata.keyParams != null)
                {
                    arraylist.add(ebaytransacteditemspecifics);
                }
            } while (true);
            flag = flag1;
            if (arraylist.size() == 1)
            {
                map = (EbayTransactedItemSpecifics)arraylist.get(0);
                viewitemviewdata.keyParams = new KeyParams(params.itemId, ((EbayTransactedItemSpecifics) (map)).transactionId);
                viewDataMap.put(viewitemviewdata.keyParams, viewitemviewdata);
                ((Item)_content.getData()).transactionId = ((EbayTransactedItemSpecifics) (map)).transactionId;
                if (getItemTransactionsTask == null)
                {
                    getItemTransactionsTask = new GetItemTransactionsTask(viewitemviewdata);
                    executeOnThreadPool(getItemTransactionsTask, new Content[] {
                        _content
                    });
                }
                flag = true;
            }
        }
        return flag;
    }

    private boolean isMainThread()
    {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private static boolean isPudoable(Context context, Item item, ViewItemViewData viewitemviewdata)
    {
        boolean flag;
        boolean flag1;
        if (MyApp.getPrefs().isSignedIn() && MyApp.getPrefs().getUserIsPpa())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && PickupUtil.debugLogger.isLoggable)
        {
            PickupUtil.debugLogger.log("User is PPA; hide PUDO");
        }
        flag1 = isAvailableForPickupAndDropoff(item);
        if (PickupUtil.debugLogger.isLoggable)
        {
            PickupUtil.debugLogger.log((new StringBuilder()).append("Item available for pickup: ").append(flag1).toString());
        }
        if (item.isInventoryCallFail && PickupUtil.debugLogger.isLoggable)
        {
            PickupUtil.debugLogger.log("Inventory call failed; hide PUDO");
        }
        return !flag && !item.isInventoryCallFail && flag1 && MyApp.getDeviceConfiguration().isPudoEnabled();
    }

    private static boolean isPudoableAndPurchasedViaPudo(Context context, Item item, ViewItemViewData viewitemviewdata)
    {
        return item.isPudoable && item.isTransacted && com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO.altName.equals(item.iTransaction.selectedMethod);
    }

    private static boolean isSellingSupported(Item item)
    {
        EbayCountry ebaycountry;
        boolean flag;
        if ("Chinese".equals(item.listingType) || "FixedPriceItem".equals(item.listingType) || "PersonalOffer".equals(item.listingType) || "StoresFixedPrice".equals(item.listingType))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ebaycountry = MyApp.getPrefs().getCurrentCountry();
        return MyApp.getDeviceConfiguration().isSellingEnabled() && (ebaycountry.site.name.equals(item.site) || com.ebay.common.view.util.EbayCountryManager.Default.supportsMotorsSelling(ebaycountry) && EbaySite.MOTOR.name.equals(item.site)) && ListingCategoryFilters.categoryOkForNewListing(ebaycountry.site.id, item.primaryCategoryIdPath) && flag;
    }

    private boolean isShowTimeDueToDealTimer(Item item)
    {
label0:
        {
            if (item.hotnessEndTime > 0L && EbayResponse.currentHostTime() <= item.hotnessEndTime)
            {
                if (!isItemEndingMoreThanXHours(item.hotnessEndTime, 0x5265c00L))
                {
                    break label0;
                }
                if (logTagTimeLeft.isLoggable)
                {
                    logTagTimeLeft.log("Hiding time left due to hotness signal end time > 24 hours");
                }
            }
            return false;
        }
        return true;
    }

    private boolean isTaskListEmpty()
    {
        boolean flag;
        synchronized (lock)
        {
            flag = inFlightTasks.isEmpty();
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static boolean itemIsBuyable(Item item)
    {
        return !item.isTransacted && !item.isSeller && !item.isAuctionEnded && !item.isScheduled;
    }

    private boolean loadBidders(Item item)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (biddingDataManagerObserving != null)
        {
            flag = flag1;
            if (item != null)
            {
                if (getViewData().waitForBidding)
                {
                    addTaskToList(TaskId.BIDDING_HISTORY);
                }
                biddingDataManagerObserving.loadBidders(this, item);
                flag = true;
            }
        }
        return flag;
    }

    private boolean loadFully(ViewItemViewData viewitemviewdata, boolean flag)
    {
        NautilusKernel.verifyMain();
        return loadFully(viewitemviewdata, flag, 0);
    }

    private boolean loadFully(ViewItemViewData viewitemviewdata, boolean flag, int i)
    {
        boolean flag1;
        if (getViewListingTask == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            return false;
        }
        if (auth != null)
        {
            if ((i & 1) != 0 && myEbaySellingDataManager != null)
            {
                addTaskToList(TaskId.GET_SOLDLIST);
                myEbaySellingDataManager.forceReloadSoldList();
            }
            if (refreshWonList && myEbayBuyingDataManager != null)
            {
                addTaskToList(TaskId.GET_WONLIST);
                myEbayBuyingDataManager.forceReloadWonList();
                refreshWonList = false;
            }
        }
        viewDataMap.put(params, viewitemviewdata);
        Object obj = new Item();
        obj.id = params.itemId;
        obj.transactionId = params.transactionId;
        obj = new Content(obj);
        GetViewListingTask getviewlistingtask = new GetViewListingTask(viewitemviewdata, MyApp.getPrefs().getCurrentSite(), ((Content) (obj)), TaskId.GET_VIEW_LISTING);
        getViewListingTask = getviewlistingtask;
        executeOnThreadPool(getviewlistingtask, new KeyParams[] {
            params
        });
        updateMyEbay(auth);
        if (getShipmentTrackingTask == null && auth != null && params.transactionId != null)
        {
            getShipmentTrackingTask = new GetShipmentTrackingTask(auth.iafToken, MyApp.getPrefs().getCurrentSite(), params.itemId, params.transactionId, true, viewitemviewdata.useRealtimeShipmentTracking, viewitemviewdata);
            executeOnThreadPool(getShipmentTrackingTask, new Content[] {
                obj
            });
        }
        resetObserveBiddingDataManager(flag);
        return true;
    }

    private com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum mapLogisticsPlanStringToEnum(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        if (s.startsWith("EBN"))
        {
            return com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.EBN;
        }
        if (s.startsWith("PUDO"))
        {
            return com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.PUDO;
        }
        if (s.startsWith("ISPU"))
        {
            return com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.ISPU;
        } else
        {
            return com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.SHIP_TO_HOME;
        }
    }

    public static void markDirty(KeyParams keyparams)
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                keyparams.toString()
            });
        }
        if (dirtyItems == null)
        {
            dirtyItems = new HashMap();
        }
        dirtyItems.put(keyparams.toString(), Boolean.valueOf(true));
        if (logTag.isLoggable)
        {
            String s;
            for (keyparams = dirtyItems.keySet().iterator(); keyparams.hasNext(); logTag.log(s))
            {
                s = (String)keyparams.next();
            }

        }
    }

    private void onDataChanged(Observer observer, Content content, ActionHandled actionhandled, boolean flag)
    {
        onDataChanged(observer, content, actionhandled, flag, false);
    }

    private void onDataChanged(Observer observer, Content content, ActionHandled actionhandled, boolean flag, boolean flag1)
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                actionhandled
            });
        }
        Object obj = null;
        Item item = obj;
        if (content != null)
        {
            item = obj;
            if (content.getData() != null)
            {
                item = (Item)content.getData();
            }
        }
        if (!flag1 && item != null)
        {
            updateItemState(item);
        }
        if (content == null)
        {
            content = ResultStatus.UNKNOWN;
        } else
        {
            content = content.getStatus();
        }
        observer.onDataChanged(this, new Content(item, content), actionhandled, flag);
    }

    private PlaceOfferResultStatus placeOfferComplete(PlaceOfferTask placeoffertask, PlaceOfferResponse placeofferresponse, Content content)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        if (placeofferresponse == null) goto _L2; else goto _L1
_L1:
        obj = obj1;
        if (placeofferresponse.result == null) goto _L2; else goto _L3
_L3:
        PlaceOfferResult placeofferresult;
        boolean flag = placeoffertask.action.equals("Purchase");
        Item item = (Item)content.getData();
        placeofferresult = placeofferresponse.result;
        char c = '\uFFFF';
        if (!flag)
        {
            if (placeofferresult.minimumToBid != null)
            {
                item.minimumToBid = computeActualMinToBid(item, placeofferresult.minimumToBid);
            }
            if (!placeofferresult.highBidder.equals(item.user))
            {
                c = '\u01F8';
            }
            if (placeofferresult.currentPrice != null)
            {
                item.currentPrice = placeofferresult.currentPrice;
            }
            if (item.currentPrice != null || item.minimumToBid != null)
            {
                content = placeofferresult.highBidder;
                ItemViewBidTracking.Roi roi;
                boolean flag1;
                if (item.currentPrice != null)
                {
                    placeofferresponse = new CurrencyAmount(item.currentPrice);
                } else
                {
                    placeofferresponse = item.minimumToBid.lowerBound;
                }
                item.highBidderUserId = getHighBidderFromMessage(item, content, placeofferresponse);
            }
            item.isReserveMet = placeofferresult.reserveMet;
            obj = ItemViewBidTracking.BidStateType.BID;
            if (isInMyEbayBidList(item.id, getViewData().nameValueList))
            {
                placeofferresponse = "IncreaseBid";
            } else
            {
                placeofferresponse = "PlaceBid";
            }
            (new TrackingData(placeofferresponse, TrackingType.EVENT)).send(getEbayContext());
            item.bidCount = item.bidCount + 1;
            ServiceContentOverride.setBidCount(item.id, item.bidCount);
        } else
        {
            MyApp.getPrefs().setUserPref(true, "rateAppBinAction");
            item.transactionId = Long.valueOf(Long.parseLong(placeofferresult.transactionId));
            item.quantity = item.quantity - placeoffertask.quantity;
            item.paidStatus = "NotPaid";
            obj = ItemViewBidTracking.BidStateType.BIN;
        }
        if (item.minimumToBid == null)
        {
            placeofferresponse = null;
        } else
        if (placeofferresult.minimumToBid != null)
        {
            if (!(new CurrencyAmount(placeofferresult.minimumToBid)).toItemCurrency().equals(placeoffertask.bid))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            placeofferresponse = Boolean.valueOf(flag);
        } else
        {
            placeofferresponse = null;
        }
        if (item.quantity > 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        content = null;
        if (TextUtils.isEmpty(placeofferresult.bidTransactionId)) goto _L5; else goto _L4
_L4:
        content = placeofferresult.bidTransactionId;
_L7:
        roi = new ItemViewBidTracking.Roi(placeoffertask.api.iafToken, placeoffertask.totalCostWithShipping);
        roi.roiUrl = placeofferresult.roiUrl;
        flag1 = isInMyEbayBidList(item.id, getViewData().nameValueList);
        ItemViewBidTracking.sendBidState(getEbayContext(), item, placeoffertask.referrer, placeoffertask.bidSource, placeoffertask.incrementalBid, flag, placeoffertask.quantity, ((ItemViewBidTracking.BidStateType) (obj)), roi, content, flag1, item.watched, placeofferresponse);
        obj = new PlaceOfferResultStatus(c, true, null);
_L2:
        return ((PlaceOfferResultStatus) (obj));
_L5:
        if (!TextUtils.isEmpty(placeofferresult.transactionId))
        {
            content = placeofferresult.transactionId;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void postGetListingHandling(Content content, ViewItemViewData viewitemviewdata)
    {
        Item item = (Item)content.getData();
        item.locale = Locale.getDefault();
        item.countryCode = MyApp.getPrefs().getCurrentCountry().getCountryCode();
        if (auth != null)
        {
            EbayTradingApi ebaytradingapi = EbayApiUtil.getTradingApi(getContext(), auth);
            item.userDisputes.clear();
            if (item.transactionId != null && getItemTransactionsTask == null)
            {
                getItemTransactionsTask = new GetItemTransactionsTask(viewitemviewdata);
                executeOnThreadPool(getItemTransactionsTask, new Content[] {
                    content
                });
            }
            if (getIncentivesTask == null)
            {
                getIncentivesTask = new GetIncentivesTask(viewitemviewdata);
                executeOnThreadPool(getIncentivesTask, new Content[] {
                    content
                });
            }
            if (getBestOffersTask == null)
            {
                getBestOffersTask = new GetBestOffersTask(ebaytradingapi, item.id, true, viewitemviewdata);
                executeOnThreadPool(getBestOffersTask, new Content[] {
                    content
                });
            }
        }
        updateItemState(item);
        if (shouldMakeInventoryCall(item, viewitemviewdata) && getStoreAvailabilityTask == null)
        {
            getStoreAvailabilityTask = new GetStoreAvailabilityTask(item.mskuSelections, viewitemviewdata, true);
            executeOnThreadPool(getStoreAvailabilityTask, new Content[] {
                content
            });
        }
    }

    private void postInitialCallMainThreadWork(Content content, ViewItemViewData viewitemviewdata)
    {
        boolean flag1 = false;
        viewitemviewdata = null;
        if (content != null)
        {
            viewitemviewdata = (Item)content.getData();
        }
        EbayContext ebaycontext = getEbayContext();
        if (viewitemviewdata != null)
        {
            content = EbaySite.getInstanceFromId(((Item) (viewitemviewdata)).site);
            EbayCurrency ebaycurrency = MyApp.getPrefs().getCurrentCountry().getCurrency();
            String s = ebaycurrency.getCurrencyCode();
            if (!content.getCurrency().getCurrencyCode().equals(s))
            {
                if (CurrencyConversionCache.willFetch(ebaycontext, content.getCurrency().getCurrencyCode(), ebaycurrency.getCurrencyCode()))
                {
                    CurrencyConversionCache.loadConversionRate(ebaycontext, this, content.getCurrency().getCurrencyCode(), ebaycurrency.getCurrencyCode(), null);
                    addTaskToList(TaskId.CONVERT_CURRENCY);
                } else
                {
                    viewitemviewdata.convertedCurrentPrice = getConvertedCurrentPriceOfItem(viewitemviewdata);
                }
            }
            if (auth != null)
            {
                EbayTradingApi ebaytradingapi = EbayApiUtil.getTradingApi(getContext(), auth);
                if (!TextUtils.isEmpty(((Item) (viewitemviewdata)).primaryCategoryIdPath))
                {
                    categoriesDataManager = (CategoriesDataManager)observeDm(new com.ebay.nautilus.domain.content.dm.CategoriesDataManager.KeyParams(MyApp.getPrefs().getCurrentSite()));
                    categoriesDataManager.loadData(this, ebaytradingapi);
                }
                if (MyApp.getDeviceConfiguration().isShoppingCartEnabled())
                {
                    addTaskToList(TaskId.GET_SHOPPING_CART);
                    shoppingCartDataManager.loadData(false, this);
                }
                if (((Item) (viewitemviewdata)).site != null && !ItemViewShipping.isSitePopulated(((Item) (viewitemviewdata)).site))
                {
                    content = new ShippingDetailsDataManager.KeyParams(content);
                    boolean flag = flag1;
                    if (shippingDetailsDataManager != null)
                    {
                        flag = flag1;
                        if (!shippingDetailsDataManager.getParams().equals(content))
                        {
                            flag = true;
                        }
                    }
                    if (flag)
                    {
                        unObserveDm(shippingDetailsDataManager);
                        shippingDetailsDataManager = null;
                    }
                    if (shippingDetailsDataManager == null)
                    {
                        shippingDetailsDataManager = (ShippingDetailsDataManager)observeDm(content);
                    }
                    addTaskToList(TaskId.EBAY_DETAILS);
                    shippingDetailsDataManager.loadData(this, EbayApiUtil.getTradingApi(getContext(), auth));
                }
            }
            if (((Item) (viewitemviewdata)).bidCount > 0)
            {
                loadBidders(viewitemviewdata);
            }
        }
    }

    private void removeTaskFromList(TaskId taskid)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = inFlightTasks.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (taskid == (TaskId)iterator.next())
            {
                iterator.remove();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_53;
        taskid;
        obj;
        JVM INSTR monitorexit ;
        throw taskid;
        if (logTag.isLoggable)
        {
            logTag.log((new StringBuilder()).append("removeTaskFromList (").append(taskid.name()).append(") results in ").append(inFlightTasks.toString()).toString());
        }
        obj;
        JVM INSTR monitorexit ;
    }

    private void resetObserveBiddingDataManager(boolean flag)
    {
        BiddingDataManager.KeyParams keyparams = new BiddingDataManager.KeyParams(params.itemId, null);
        boolean flag1;
        if (biddingDataManagerObserving == null || flag || !((BiddingDataManager.KeyParams)biddingDataManagerObserving.getParams()).equals(keyparams))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (biddingDataManagerObserving != null && (flag || !((BiddingDataManager.KeyParams)biddingDataManagerObserving.getParams()).equals(keyparams)))
        {
            unObserveDm(biddingDataManagerObserving);
        }
        if (flag1)
        {
            biddingDataManagerObserving = (BiddingDataManager)observeDm(keyparams);
            if (flag)
            {
                biddingDataManagerObserving.flush();
            }
        }
    }

    private static boolean sellerRequiresPaypalOnly(Item item)
    {
        boolean flag;
        boolean flag1;
label0:
        {
            boolean flag2 = false;
            flag = false;
            item = item.paymentMethods.iterator();
            do
            {
                flag1 = flag2;
                if (!item.hasNext())
                {
                    break label0;
                }
                if (!((String)item.next()).contains("PayPal"))
                {
                    break;
                }
                flag = true;
            } while (true);
            flag1 = true;
        }
        return flag && !flag1;
    }

    private boolean setIsShowSimilar(Item item)
    {
        boolean flag;
        boolean flag1;
        if (item.primaryCategoryId != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!item.isSeller && flag && item.isAuctionEnded)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1 && logTag.isLoggable)
        {
            if (!flag)
            {
                FwLog.println(logTag, "Sellers Other Items button hidden due to primaryCategoryId == -1");
            }
            if (item.isSeller)
            {
                FwLog.println(logTag, "Sellers Other Items button hidden due to user is seller of item");
            }
            if (!item.isActive)
            {
                FwLog.println(logTag, "Sellers Other Items button hidden due to item being inactive");
            }
        }
        return flag1;
    }

    private void setPaidStatus(Item item, ViewItemViewData viewitemviewdata)
    {
        if (item.paidStatus == null || com.ebay.mobile.Item.PaidStatus.NOT_PAID.name().equals(item.paidStatus) || "BuyerHasNotCompletedCheckout".equals(item.paidStatus) && !item.iTransaction.paymentMethodUsed.equals("PayPal"))
        {
            if (item.iTransaction.paymentMethodUsed != null && !item.iTransaction.paymentMethodUsed.equals("PayPal"))
            {
                if (item.iTransaction.checkoutStatus.equals("CheckoutComplete"))
                {
                    item.paidStatus = "PaymentPending";
                } else
                {
                    item.paidStatus = "NotPaid";
                }
            } else
            if ("Complete".equals(item.iTransaction.completeStatus))
            {
                item.paidStatus = "PaidWithPayPal";
            } else
            if ("Pending".equals(item.iTransaction.completeStatus))
            {
                item.paidStatus = "PaymentPending";
            } else
            {
                item.paidStatus = "NotPaid";
            }
            if (!item.paidStatus.equals("PaidWithPayPal") && viewitemviewdata.myEbayListItem != null && viewitemviewdata.myEbayListItem.transaction != null && ItemTransaction.isPaid(viewitemviewdata.myEbayListItem.transaction.paidStatus))
            {
                item.paidStatus = viewitemviewdata.myEbayListItem.transaction.paidStatus;
            }
        }
        if (!ItemTransaction.isPaid(item.paidStatus))
        {
            if (item.isMultiSku)
            {
                viewitemviewdata = item.mskuSelections;
            } else
            {
                viewitemviewdata = null;
            }
            consultMyEbayForPaidStatus(item, viewitemviewdata);
        }
        item.isPaid = ItemTransaction.isPaid(item.paidStatus);
    }

    private boolean setPaidStatus(Item item, MyEbayListItem myebaylistitem)
    {
        boolean flag = false;
        String s = myebaylistitem.transaction.paidStatus;
        if (ItemTransaction.isPaid(s) || ItemTransaction.isPaidUsingTradingQuirk(s, myebaylistitem.transaction.paidTime))
        {
            item.paidStatus = "PaidWithPayPal";
            flag = true;
        } else
        if (ItemTransaction.isPaymentPending(s))
        {
            item.paidStatus = "PaymentPending";
            return true;
        }
        return flag;
    }

    private void setPromotionalSaleOriginalPrice(Item item, Date date, Date date1, ItemCurrency itemcurrency)
    {
        item.promotionalSaleStartTime = date;
        item.promotionalSaleEndTime = date1;
        long l = EbayResponse.currentHostTime();
        if (item.promotionalSaleStartTime != null && item.promotionalSaleEndTime != null && l >= date.getTime() && l <= date1.getTime())
        {
            item.promotionalSaleOriginalPrice = itemcurrency;
            return;
        } else
        {
            item.promotionalSaleOriginalPrice = null;
            return;
        }
    }

    private boolean setShowFeedback(Item item, ViewItemViewData viewitemviewdata)
    {
        while (!item.isTransacted || userCache.hasLeftFeedback(item.getIdString(), String.valueOf(item.transactionId)) || item.feedbackLeft && viewitemviewdata.feedbackLeft || item.itemHasClosedUnpaidItemDispute()) 
        {
            return false;
        }
        return true;
    }

    private ResultStatus setupItemIncentives(Item item)
    {
        Object obj;
        Object obj1;
        EbaySite ebaysite;
        Object obj4;
        Object obj5;
        ebaysite = MyApp.getPrefs().getCurrentSite();
        obj4 = MyApp.getDeviceConfiguration();
        Object obj2 = ((DcsHelper) (obj4)).getConfig();
        obj = new ResultStatusOwner();
        obj1 = null;
        if (auth != null)
        {
            obj1 = EbayApiUtil.getCartApi(getContext(), auth);
        }
        boolean flag;
        boolean flag1;
        if (((DcsHelper) (obj4)).isMecOrMec2Enabled(item.site) && obj1 != null && !item.isAuctionEnded && !item.isSeller)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((DeviceConfiguration) (obj2)).get(DcsBoolean.IncentivesRewards) && flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj5 = Boolean.valueOf(flag1);
        if (((DeviceConfiguration) (obj2)).get(DcsBoolean.Coupons) && flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj4 = Boolean.valueOf(flag1);
        if (!((DeviceConfiguration) (obj2)).get(DcsBoolean.IncentiveServiceV1)) goto _L2; else goto _L1
_L1:
        if (((Boolean) (obj5)).booleanValue())
        {
            obj = new com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesRequest(((com.ebay.common.net.api.cart.EbayCartApi) (obj1)), ebaysite.getCurrency().getCurrencyCode(), item.getIdString(), null, item.getVariationId(item.mskuSelections), Integer.valueOf(1), Boolean.valueOf(true), true);
            obj2 = new ResultStatusOwner();
            obj5 = (com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesResponse)safeSendRequest(((Request) (obj)), ((ResultStatusOwner) (obj2)));
            obj = obj2;
            if (((ResultStatusOwner) (obj2)).getResultStatus() != ResultStatus.CANCELED)
            {
                obj = obj2;
                if (!((ResultStatusOwner) (obj2)).getResultStatus().hasError())
                {
                    getItemIncentivesRewardsHandling(((com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesResponse) (obj5)), item);
                    obj = obj2;
                }
            }
        }
        if (((ResultStatusOwner) (obj)).getResultStatus().hasError())
        {
            return ((ResultStatusOwner) (obj)).getResultStatus();
        }
        if (((Boolean) (obj4)).booleanValue())
        {
            obj = new com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesRequest(((com.ebay.common.net.api.cart.EbayCartApi) (obj1)), ebaysite.getCurrency().getCurrencyCode(), item.getIdString(), null, item.getVariationId(item.mskuSelections), Integer.valueOf(1), Boolean.valueOf(false), true);
            obj1 = new ResultStatusOwner();
            com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesResponse getitemincentivesresponse = (com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesResponse)safeSendRequest(((Request) (obj)), ((ResultStatusOwner) (obj1)));
            obj = obj1;
            if (((ResultStatusOwner) (obj1)).getResultStatus() != ResultStatus.CANCELED)
            {
                obj = obj1;
                if (!((ResultStatusOwner) (obj1)).getResultStatus().hasError())
                {
                    getItemIncentivesCouponsHandling(getitemincentivesresponse, item);
                    obj = obj1;
                }
            }
        }
_L4:
        return ((ResultStatusOwner) (obj)).getResultStatus();
_L2:
        Object obj3 = new ArrayList();
        if (((Boolean) (obj5)).booleanValue())
        {
            ((ArrayList) (obj3)).add(com.ebay.common.net.api.cart.GetItemIncentives.ItemIncentiveType.REWARD);
        }
        if (((Boolean) (obj4)).booleanValue())
        {
            ((ArrayList) (obj3)).add(com.ebay.common.net.api.cart.GetItemIncentives.ItemIncentiveType.COUPON);
        }
        if (((Boolean) (obj5)).booleanValue() || ((Boolean) (obj4)).booleanValue())
        {
            obj = new com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesRequest(((com.ebay.common.net.api.cart.EbayCartApi) (obj1)), ebaysite.getCurrency().getCurrencyCode(), item.getIdString(), null, item.getVariationId(item.mskuSelections), Integer.valueOf(1), (com.ebay.common.net.api.cart.GetItemIncentives.ItemIncentiveType[])((ArrayList) (obj3)).toArray(new com.ebay.common.net.api.cart.GetItemIncentives.ItemIncentiveType[((ArrayList) (obj3)).size()]), true);
            obj1 = new ResultStatusOwner();
            obj3 = (com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesResponse)safeSendRequest(((Request) (obj)), ((ResultStatusOwner) (obj1)));
            obj = obj1;
            if (((ResultStatusOwner) (obj1)).getResultStatus() != ResultStatus.CANCELED)
            {
                obj = obj1;
                if (!((ResultStatusOwner) (obj1)).getResultStatus().hasError())
                {
                    getItemIncentivesCouponsHandling(((com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesResponse) (obj3)), item);
                    getItemIncentivesRewardsHandling(((com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesResponse) (obj3)), item);
                    obj = obj1;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean shouldDisplayPaymentReminder(Item item)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (item.iTransaction != null)
        {
            flag = flag1;
            if (item.iTransaction.createdDate != null)
            {
                DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
                flag = flag1;
                if (System.currentTimeMillis() - item.iTransaction.createdDate.getTime() > deviceconfiguration.get(DcsLong.sellerPaymentReminderActivationTime))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private boolean shouldMakeInventoryCall(Item item, ViewItemViewData viewitemviewdata)
    {
        if ((item.transactionId == null || item.iTransaction != null) && (item.iTransaction == null || !item.iTransaction.isInProcess()))
        {
            StoreAvailability storeavailability;
            if (item.inventoryInfo != null)
            {
                storeavailability = item.inventoryInfo.getSelectedStore();
            } else
            {
                storeavailability = null;
            }
            if (item.iTransaction == null && item.storesWithItem == -1 && storeavailability == null && isInventoryCallPossible(item, viewitemviewdata, false))
            {
                return true;
            }
        }
        return false;
    }

    private boolean shouldMakeStoreLocationCall(Item item, ViewItemViewData viewitemviewdata)
    {
        boolean flag = true;
        if (!item.isPudoable && item.iTransaction != null && item.iTransaction.isInProcess())
        {
            return false;
        }
        StoreAvailability storeavailability;
        if (item.inventoryInfo != null)
        {
            storeavailability = item.inventoryInfo.getSelectedStore();
        } else
        {
            storeavailability = null;
        }
        if (item.iTransaction == null || storeavailability != null || !isInventoryCallPossible(item, viewitemviewdata, true))
        {
            flag = false;
        }
        return flag;
    }

    private static boolean showAddToCart(Item item)
    {
        return MyApp.getDeviceConfiguration().isShoppingCartEnabled() && itemIsBuyable(item) && !item.isShowBuyingOptions && (!item.isBidOnly || item.isShowBuyAnother) && !item.isFreight && item.isCartable && !item.inCart;
    }

    private static boolean showBuyItNowWithoutRegardToCart(Context context, Item item)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (itemIsBuyable(item) && !showBuyingOptions(context, item))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((item.isListingTypeBin || item.isBidWithBin) && !item.isListingHalfOrLeadGeneration())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (item.quantitySold == item.quantity)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag && flag1 && (!flag2 || item.ignoreQuantity))
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (logTag.isLoggable)
        {
            if (!flag)
            {
                FwLog.println(logTag, "showBuyItNowWithoutRegardToCart: !showBuyingOptions()");
            }
            if (!flag1)
            {
                FwLog.println(logTag, "showBuyItNowWithoutRegardToCart: type failure");
            }
            if (flag2)
            {
                FwLog.println(logTag, "showBuyItNowWithoutRegardToCart: no quantity left");
            }
        }
        return flag3;
    }

    private static boolean showBuyingOptions(Context context, Item item)
    {
        boolean flag1;
        boolean flag2;
        flag1 = itemIsBuyable(item);
        if (!flag1 && logTag.isLoggable)
        {
            FwLog.println(logTag, "showBuyingOptions: !isTransacted && !isSeller && !isAuctionEnded && !isScheduled");
        }
        flag2 = flag1;
        if (!flag1) goto _L2; else goto _L1
_L1:
        if (item.isBusinessTypeOkForPurchase()) goto _L4; else goto _L3
_L3:
        flag2 = flag1;
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "showBuyingOptions: sellerBusinessType of user and listing type of commercial incompatibile");
            flag2 = flag1;
        }
_L2:
        return flag2;
_L4:
        if (!item.isLiveAuction)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag1;
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "showBuyingOptions: live auction");
            return flag1;
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (item.isClassifiedItem())
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag;
        if (item.autoPay && !ItemViewPayPalable.canUsePaypalOptimistic(MyApp.getPrefs().isSignedIn(), context, item))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!doesItemShipToUser(item) || flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag1;
        if (!flag1)
        {
            flag2 = flag1;
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "showBuyingOptions: either IP and no PayPal or item doesn't ship to buyer country");
                return flag1;
            }
        }
        if (true) goto _L2; else goto _L6
_L6:
        flag2 = flag1;
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "showBuyingOptions: Classified item");
            return flag1;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    private static boolean showViewInCart(Item item)
    {
        return MyApp.getDeviceConfiguration().isShoppingCartEnabled() && item.isCartable && item.inCart && (!item.isPaid || item.isShowBuyAnother) && !item.isFreight;
    }

    private void startViewItemLite(Content content)
    {
        if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
        {
            FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[0]);
        }
        if (content != null && content.getData() != null && !((Item)content.getData()).finalized)
        {
            if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
            {
                ItemViewBiddingUpdater.fwLogItemViewBidding.log((new StringBuilder()).append("startViewItemLite kicking off ViewItemLite for item id=").append(((Item)content.getData()).id).toString());
            }
            biddingUpdater = new ItemViewBiddingUpdater(this, (Item)content.getData());
            postViewItemLite = new PostViewItemLite(biddingUpdater, (Item)content.getData());
            biddingUpdater.start(getContext());
        } else
        if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
        {
            ItemViewBiddingUpdater.fwLogItemViewBidding.log((new StringBuilder()).append("startViewItemLite did not kick off ViewItemLite for item id=").append(((Item)content.getData()).id).toString());
            return;
        }
    }

    private Item synthesizeAccretiveData(ViewItemViewData viewitemviewdata, Item item)
    {
        boolean flag2 = true;
        List list;
        int i;
        boolean flag;
        boolean flag1;
        if ("eBayMotors".equals(item.site) && !TextUtils.isEmpty(item.primaryCategoryIdPath) && item.primaryCategoryIdPath.length() >= 4 && "6000".equals(item.primaryCategoryIdPath.substring(0, 4)))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        item.isMotors = flag1;
        flag = false;
        viewitemviewdata = item.getItemSpecficByName("Year");
        i = ((flag) ? 1 : 0);
        if (!viewitemviewdata.isEmpty())
        {
            try
            {
                i = Integer.parseInt((String)viewitemviewdata.get(0));
            }
            // Misplaced declaration of an exception variable
            catch (ViewItemViewData viewitemviewdata)
            {
                i = ((flag) ? 1 : 0);
            }
        }
        item.year = i;
        viewitemviewdata = null;
        list = item.getItemSpecficByName("VIN");
        if (!list.isEmpty())
        {
            viewitemviewdata = (String)list.get(0);
        } else
        {
            List list1 = item.getItemSpecficByName("VIN Number");
            if (!list1.isEmpty())
            {
                viewitemviewdata = (String)list1.get(0);
            }
        }
        item.vin = viewitemviewdata;
        if (!EbaySite.MOTOR.name.equals(item.site) || TextUtils.isEmpty(item.primaryCategoryIdPath)) goto _L2; else goto _L1
_L1:
        flag1 = flag2;
        if (item.primaryCategoryIdPath.contains("6001")) goto _L4; else goto _L3
_L3:
        if (!item.primaryCategoryIdPath.contains("6024")) goto _L2; else goto _L5
_L5:
        flag1 = flag2;
_L4:
        item.isMotorsVehicle = flag1;
        return item;
_L2:
        flag1 = false;
        if (true) goto _L4; else goto _L6
_L6:
    }

    private void updateItemState(Item item)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1;
        ViewItemViewData viewitemviewdata;
        Context context;
        context = getContext();
        obj1 = context.getResources();
        viewitemviewdata = getViewData();
        Item.getNotSelectedStrings(context);
        Object obj;
        DeviceConfiguration deviceconfiguration;
        Iterator iterator;
        int i;
        long l;
        boolean flag;
        if (item.iTransaction != null && (item.iTransaction.buyerUserId.equals(item.user) || item.iTransaction.sellerUserId.equals(item.user)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isTransacted = flag;
        if (!item.isTransacted)
        {
            item.iTransaction = null;
        }
        deviceconfiguration = DeviceConfiguration.getAsync();
        item.isShowFastAndFree = getIsShowFastAndFree(item);
        if (item.topRatedListing && deviceconfiguration.get(DcsBoolean.TopRatedListing))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowTopRatedListing = flag;
        if (!item.isTransacted)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        if (viewitemviewdata.feedbackLeft || userCache.hasLeftFeedback(item.getIdString(), String.valueOf(item.transactionId)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.feedbackLeft = flag;
        if (item.isGspItem)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        if (item.shippingInfo != null && item.shippingInfo.importCharge != null && deviceconfiguration.get(DcsBoolean.GSP))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isGspItem = flag;
        if (item.iTransaction == null) goto _L2; else goto _L1
_L1:
        obj = new PostalCodeSpecification();
        obj.postalCode = item.iTransaction.buyerPostalCode;
        obj.countryCode = item.iTransaction.buyerCountry;
        obj.stateOrProvince = item.iTransaction.buyerStateOrProvince;
_L21:
        if (item.variations.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isMultiSku = flag;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_308;
        }
        if ("AA".equals(((PostalCodeSpecification) (obj)).countryCode))
        {
            obj.countryCode = "APO/FPO";
        }
        item.buyerPostalCodeSpec = ((PostalCodeSpecification) (obj));
        if (item.buyerPostalCodeSpec == null) goto _L4; else goto _L3
_L3:
        obj = item.buyerPostalCodeSpec.countryCode;
_L52:
        item.buyerCountryCode = ((String) (obj));
        item.buyerLocation = getBuyerLocation(((Resources) (obj1)), item);
        if (item.isTransacted)
        {
            setPaidStatus(item, viewitemviewdata);
        }
        item.fastAndFreeText = Util.getFastAndFreeText();
        if (item.iTransaction != null && !TextUtils.equals(item.iTransaction.orderId, (new StringBuilder()).append(item.id).append("-").append(item.transactionId).toString()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isPartOfOrder = flag;
        if (!TextUtils.isEmpty(item.user) && !TextUtils.isEmpty(item.sellerUserId) && item.user.compareToIgnoreCase(item.sellerUserId) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isSeller = flag;
        if (item.iTransaction == null) goto _L6; else goto _L5
_L5:
        i = item.iTransaction.quantityPurchased;
_L53:
        item.quantityPurchased = i;
        if (item.isSeller && item.startDate != null && item.startDate.getTime() > EbayResponse.currentHostTime())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isScheduled = flag;
        item.currentPrice = getCurrentPriceOfItem(item, viewitemviewdata);
        if (!TextUtils.isEmpty(item.conditionDescription) && deviceconfiguration.get(DcsBoolean.CONDITION_DESCRIPTION))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowConditionDescription = flag;
        if (item.user != null && item.user.equals(item.highBidderUserId))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isUserHighBidder = flag;
        item.gspTermsAndConditionsUrl = ItemViewBaseActivity.getGspTermsAndConditionsUrl(item);
        if (deviceconfiguration.get(DcsBoolean.ShipToFund) && item.iTransaction != null && item.iTransaction.expectedReleaseDate != null && "PaymentHold".equals(item.iTransaction.paymentHoldStatus))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShipToFundItem = flag;
        item.endItemEarlyUrl = ViewItemFragmentUtil.getEndItemEarlyUrl();
        item.displayPriceColor = Item.computeDisplayPriceColor(item, viewitemviewdata.defaultForegroundColorId, viewitemviewdata.kind, item.isBidWithBin);
        item.salesTaxPercent = getSalesTaxPercent(item, viewitemviewdata);
        item.isEbayNowAvailable = isEbayNowAvailable(item, viewitemviewdata);
        if (item.isEbayNowAvailable && !ViewItemShippingInfo.getEbayNowShippingOptions(item).isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowEbayNow = flag;
        item.isAvailableForPickupInStore = isAvailableForPickupInStore(item);
        item.isBopisableAndPurchasedViaBopis = isBopisableAndPurchasedViaBopis(context, item, viewitemviewdata);
        if (item.iTransaction != null && item.iTransaction.isEbayNow)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isTransactedViaEbn = flag;
        item.isAvailableForPickupAndDropoff = isAvailableForPickupAndDropoff(item);
        item.isSellerAcceptsPayPal = Util.getPaymentMethodsAsLocalizedString(item.paymentMethods).contains("PayPal");
        item.isSellerRequirePayPal = sellerRequiresPaypalOnly(item);
        item.depositAmountString = Item.convertDepositAmountToString(item);
        if ("Freight".equals(item.shippingType) || "FreightFlat".equals(item.shippingType))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isFreight = flag;
        item.isBopisable = isBopisable(context, item, viewitemviewdata);
        item.isPudoable = isPudoable(context, item, viewitemviewdata);
        item.isPudoableAndPurchasedViaPudo = isPudoableAndPurchasedViaPudo(context, item, viewitemviewdata);
        if (!item.isTransacted && !item.isSeller && !item.isAuctionEnded && !item.isScheduled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isBuyable = flag;
        item.isShowBuyingOptions = showBuyingOptions(context, item);
        item.isShowBuyAnother = item.showBuyAnother(context, viewitemviewdata);
        item.isShowAddToCart = showAddToCart(item);
        item.isShowViewInCart = showViewInCart(item);
        item.isShowBuyItNow = showBuyItNowWithoutRegardToCart(context, item);
        if (!item.isScheduled && (!item.isSeller || item.isActive))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowShare = flag;
        item.isShowSimilar = setIsShowSimilar(item);
        item.isShowLeaveFeedback = setShowFeedback(item, viewitemviewdata);
        obj = EbaySite.getInstanceFromId(item.site);
        if (obj == null) goto _L8; else goto _L7
_L7:
        if (((EbaySite) (obj)).idInt == EbaySite.IN.idInt) goto _L8; else goto _L9
_L9:
        i = 1;
_L54:
        if (i == 0) goto _L11; else goto _L10
_L10:
        if (!item.isTransacted || TextUtils.isEmpty(item.iTransaction.getShipmentTrackingNumber()) || !userCache.isShipped(item.getIdString(), Long.toString(item.transactionId.longValue()))) goto _L11; else goto _L12
_L12:
        flag = true;
_L55:
        item.isShowTrackPackage = flag;
        if (item.isTransacted && (userCache.isShipped(item.getIdString(), Long.toString(item.transactionId.longValue())) || item.iTransaction.shippedTime != null || !TextUtils.isEmpty(item.iTransaction.getShipmentTrackingNumber())))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShipped = flag;
        if (item.isTransacted && item.iTransaction != null && item.iTransaction.orderShippingInfo != null && item.iTransaction.orderShippingInfo.actualDeliveryDate != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isDelivered = flag;
        item.isSellingSupported = isSellingSupported(item);
        if (isSellingSupported(item) && item.isSeller)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowSellSimilar = flag;
        if (isSellingSupported(item) && item.isSeller && item.isAuctionEnded && TextUtils.isEmpty(item.relistedId))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowRelist = flag;
        if (!item.watched && !item.isAuctionEnded && !item.isScheduled && viewitemviewdata.kind != com.ebay.common.ConstantsCommon.ItemKind.Sold && viewitemviewdata.kind != com.ebay.common.ConstantsCommon.ItemKind.Lost && viewitemviewdata.kind != com.ebay.common.ConstantsCommon.ItemKind.Won && viewitemviewdata.kind != com.ebay.common.ConstantsCommon.ItemKind.WishList && viewitemviewdata.kind != com.ebay.common.ConstantsCommon.ItemKind.CustomList)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowWatch = flag;
        item.isShowUnwatch = item.watched;
        flag = false;
        Long.parseLong(item.relistedId);
        flag = true;
_L51:
        item.isShowViewRelistedItem = flag;
        if (isSellingSupported(item) && !item.isTransacted && item.isSeller && !item.isAuctionEnded)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowRevise = flag;
        if (isSellingSupported(item) && !item.isSeller)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowSellLike = flag;
        if (item.isSeller && !item.isTransacted && item.isActive && !item.isScheduled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowEndItem = flag;
        if (item.isSeller && item.isTransacted && !item.isPaid)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowMarkAsPaid = flag;
        if (item.isSeller && item.isPaid && item.isTransacted && item.paidStatus != null && !"PaidWithPayPal".equals(item.paidStatus) && !"PaymentPendingWithPayPal".equals(item.paidStatus))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowMarkAsUnPaid = flag;
        if (item.isSeller && item.isTransacted && !item.isShipped && i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowMarkAsShipped = flag;
        if (item.isSeller && item.isTransacted && item.isShipped && i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowMarkAsUnShipped = flag;
        if (item.isSeller && item.isTransacted && item.isShipped && i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowEnterTrackingNumber = flag;
        if (!item.isTransacted) goto _L14; else goto _L13
_L13:
        item.isRefunded = "Refunded".equals(item.paidStatus);
        if (item.iTransaction.refunds == null || item.iTransaction.refunds.size() <= 0) goto _L14; else goto _L15
_L15:
        item.isRefunded = true;
        obj = new BigDecimal(0);
        obj1 = obj;
        if (item.iTransaction.payments == null) goto _L17; else goto _L16
_L16:
        obj1 = obj;
        if (item.iTransaction.payments.size() <= 0) goto _L17; else goto _L18
_L18:
        iterator = item.iTransaction.payments.iterator();
_L20:
        obj1 = obj;
        if (!iterator.hasNext()) goto _L17; else goto _L19
_L19:
        obj = ((BigDecimal) (obj)).add(new BigDecimal(((Payment)iterator.next()).amount.value));
          goto _L20
_L2:
        obj = MyApp.getPrefs().getShipToPostalCode();
          goto _L21
_L17:
        obj = new BigDecimal(0);
        for (Iterator iterator1 = item.iTransaction.refunds.iterator(); iterator1.hasNext();)
        {
            obj = ((BigDecimal) (obj)).add(new BigDecimal(((Refund)iterator1.next()).refundAmount.value));
        }

        if (((BigDecimal) (obj1)).compareTo(((BigDecimal) (obj)).abs()) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isTotalAmountRefunded = flag;
_L14:
        if (viewitemviewdata.kind == com.ebay.common.ConstantsCommon.ItemKind.Won && !ItemTransaction.isPaidFor(item.paidStatus) && !item.isRefunded && (item.isFreight || !ItemViewPayPalable.canUsePaypal(context, item)) && !item.itemHasClosedUnpaidItemDispute())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowPaymentOptions = flag;
        if (item.paidStatus != null && viewitemviewdata.kind == com.ebay.common.ConstantsCommon.ItemKind.Won && !ItemTransaction.isPaidFor(item.paidStatus) && !item.isRefunded && !item.isFreight && !item.isListingHalfOrLeadGeneration() && ItemViewPayPalable.canUsePaypal(context, item) && !item.itemHasClosedUnpaidItemDispute())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowPayNow = flag;
        if (item.isFreight && !item.isValidShippingCountry(item.buyerCountryCode))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isFreightButExcluded = flag;
        if (!item.isTransacted && !item.isSeller && !item.isAuctionEnded && !item.isScheduled && !TextUtils.isEmpty(item.sellerVacationNote))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowSellerVacationNote = flag;
        if (item.isBuyable && !item.isShowBuyingOptions && !item.finalized && (item.isBidWithBin || item.isBidOnly) && (viewitemviewdata.kind == com.ebay.common.ConstantsCommon.ItemKind.Bidding || isInMyEbayBidList(item.id, viewitemviewdata.nameValueList)) && item.isUserHighBidder && !item.isListingHalfOrLeadGeneration())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowIncreaseBid = flag;
        if (item.isBuyable && !item.isShowBuyingOptions && !item.finalized && (item.isBidWithBin || item.isBidOnly) && !isInMyEbayBidList(item.id, viewitemviewdata.nameValueList) && !item.isListingHalfOrLeadGeneration())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowPlaceBid = flag;
        if (item.isBuyable && !item.isShowBuyingOptions && !item.finalized && (item.isBidWithBin || item.isBidOnly) && viewitemviewdata.kind != com.ebay.common.ConstantsCommon.ItemKind.Bidding && !isInMyEbayBidList(item.id, viewitemviewdata.nameValueList) && !item.isListingHalfOrLeadGeneration())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowBidAmount = flag;
        if (!item.isSeller && (item.isShowBuyItNow || item.isShowAddToCart || item.isShowViewInCart) && item.canMakeFirstOffer(item.user) && com.ebay.common.view.util.EbayCountryManager.Default.supportsBestOffer(MyApp.getPrefs().getCurrentCountry()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowMakeOffer = flag;
        obj1 = null;
        obj = obj1;
        if (!item.isTransacted) goto _L23; else goto _L22
_L22:
        if (TextUtils.isEmpty(item.iTransaction.orderLineItemId)) goto _L25; else goto _L24
_L24:
        obj = item.iTransaction.orderLineItemId;
_L23:
        item.orderId = ((String) (obj));
        item.buyingOptionsVerbiage = getBuyingOptionsVerbiage(context, item);
        item.isShipsToUser = doesItemShipToUser(item);
        if (TextUtils.isEmpty(item.availablePaymentMethods))
        {
            getItemPaymentMethods(item);
        }
        if (!item.isTransacted && viewitemviewdata.kind != com.ebay.common.ConstantsCommon.ItemKind.Selling)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isMultiSkuSelectable = flag;
        if (item.isFreight || item.shippingInfo.orderedOptions == null || item.shippingInfo.orderedOptions.isEmpty() || doesItemOnlyAcceptMerchantCreditCards(item.availablePaymentMethods) || !ItemViewPayPalable.canUsePaypal(context, item))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isAutopayUnavailable = flag;
        obj = null;
        if (item.isFreightButExcluded)
        {
            obj = context.getString(0x7f07068c);
        }
        item.freightErrorMessage = ((String) (obj));
        obj = MyApp.getPrefs().getCurrentCountry();
        if (3 != ((EbayCountry) (obj)).getSiteId() && 77 != ((EbayCountry) (obj)).getSiteId()) goto _L27; else goto _L26
_L26:
        if (!item.dpiSoldOnEbay && !item.isStpButMarkdown) goto _L29; else goto _L28
_L28:
        item.stpSavingsWasLabel = context.getString(0x7f07050e);
_L46:
        if (item.isMultiSku)
        {
            item.minVariationPrice = item.getMinVariationPrice(null);
            item.maxVariationPrice = item.getMaxVariationPrice(null);
        }
        if (item.isActive && isInMyEbayBidList(item.id, viewitemviewdata.nameValueList) && !TextUtils.equals(item.highBidderUserId, item.user))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isOutbid = flag;
        if (!item.isTransacted || item.iTransaction.buyerName == null && item.iTransaction.buyerStreet == null && item.iTransaction.buyerCityName == null && item.iTransaction.buyerStateOrProvince == null && item.iTransaction.buyerPostalCode == null) goto _L31; else goto _L30
_L30:
        obj = new StringBuilder();
        if (item.iTransaction.buyerName != null)
        {
            ((StringBuilder) (obj)).append(item.iTransaction.buyerName).append('\n');
        }
        if (item.iTransaction.buyerStreet == null) goto _L33; else goto _L32
_L32:
        ((StringBuilder) (obj)).append(item.iTransaction.buyerStreet).append('\n');
_L48:
        if (item.iTransaction.buyerCityName != null)
        {
            ((StringBuilder) (obj)).append(item.iTransaction.buyerCityName).append(',');
        }
        if (item.iTransaction.buyerStateOrProvince != null)
        {
            ((StringBuilder) (obj)).append(' ').append(item.iTransaction.buyerStateOrProvince).append(' ');
        }
        if (item.iTransaction.buyerPostalCode != null)
        {
            ((StringBuilder) (obj)).append(item.iTransaction.buyerPostalCode).append('\n');
        }
        if (item.iTransaction.buyerCountryName != null)
        {
            ((StringBuilder) (obj)).append(item.iTransaction.buyerCountryName);
        }
        obj1 = ((StringBuilder) (obj)).toString();
        if (((String) (obj1)).endsWith("\n") || ((String) (obj1)).endsWith(",")) goto _L35; else goto _L34
_L34:
        obj = obj1;
        if (!((String) (obj1)).endsWith(" ")) goto _L36; else goto _L35
_L35:
        obj = ((String) (obj1)).substring(0, ((String) (obj1)).length());
_L36:
        item.buyerAddress = ((String) (obj));
_L31:
        if (item.isTransacted && item.isBinOnly)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isTransactedAsBin = flag;
        if (item.isProductReviewsAvailable && !deviceconfiguration.get(DcsBoolean.eBayViewItemProductReviews))
        {
            item.isProductReviewsAvailable = false;
        }
        if (item.isTransacted || item.isFreight || !item.isShipsToUser || !item.isLocalPickupOnly && (item.shippingInfo.orderedOptions == null || item.shippingInfo.orderedOptions.size() <= 0))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        item.isShowItemCard = flag;
        if (!item.isShowItemCard)
        {
            break MISSING_BLOCK_LABEL_3153;
        }
        if (!item.isEbnOnly && !item.isIspuOnly && !item.isEbayPlusEligible)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        item.isShowItemCardSingle = flag;
        item.isHideTimeLeft = isHideTimeLeft(item);
        obj = ViewItemShippingInfo.getCarrierShippingOptions(item);
        if (item.shippingInfo.shipToHomeOptions == null || obj == null) goto _L38; else goto _L37
_L37:
        if (((List) (obj)).size() != 0) goto _L39; else goto _L38
_L38:
        if (item.isIspuOnly || item.isEbnOnly || item.isLocalPickupOnly || item.isBopisable || item.availableForEbayNow || item.availableForPickupInStore || item.isLocalPickup)
        {
            break MISSING_BLOCK_LABEL_4176;
        }
          goto _L39
_L49:
        item.isLocalOptionsOnly = flag;
        if (item.isLocalOptionsOnly)
        {
            item.isShowItemCardSingle = true;
        }
        obj = MyApp.getDeviceConfiguration().buyerProtectionUrl(item.topRatedListing);
        if (item.isBuyerProtectionEligible && !TextUtils.isEmpty(((CharSequence) (obj))))
        {
            flag = true;
        } else
        {
            flag = false;
        }
label0:
        {
            item.isBuyerProtectionEligible = flag;
            if (item.isUserConsentRequired || categoryInfo == null || categoryInfo.categoriesIdsRequiringConsent == null)
            {
                break label0;
            }
            obj = categoryInfo.categoriesIdsRequiringConsent.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                l = ((Long)((Iterator) (obj)).next()).longValue();
            } while (TextUtils.isEmpty(item.primaryCategoryIdPath) || !item.primaryCategoryIdPath.contains(String.valueOf(l)));
            item.isUserConsentRequired = true;
        }
        if (item.isSeller && item.isTransacted && deviceconfiguration.get(DcsBoolean.PrintShippingLabel) && !item.iTransaction.isEbayNow && item.iTransaction.buyerCountry.equals("US") && !item.isPartOfOrder && !item.isLocalPickupOnly)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isShowCreateShippingLabel = flag;
        if (logTagNoIP.isLoggable)
        {
            item.autoPay = false;
        }
        if (!deviceconfiguration.get(DcsBoolean.VI_featureNewBidFlow))
        {
            break MISSING_BLOCK_LABEL_3522;
        }
        if (!deviceconfiguration.get(DcsBoolean.VI_featureNewBidFlowReviewRequired) && !item.isGspItem)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        item.isShowReviewBid = flag;
        item.isShowTitleBidFlow = deviceconfiguration.get(DcsBoolean.VI_featureNewBidFlowShowTitle);
        if (!deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.App.B.ebayPlus) || !item.isEbayPlusEligible || item.eBayPlusShippingOption != null) goto _L41; else goto _L40
_L40:
        if (item.shippingInfo == null) goto _L43; else goto _L42
_L42:
        obj = item.shippingInfo.getEbayPlusOption();
_L50:
        item.eBayPlusShippingOption = ((ShippingCostsShippingOption) (obj));
        if (item.eBayPlusShippingOption == null) goto _L41; else goto _L44
_L44:
        item.isEbayPlusInWindow = item.eBayPlusShippingOption.isHandlingTimeSameDayAvailable;
        item.isShowEbayPlusPromo = item.eBayPlusShippingOption.isEligibleForEbayPlusPromo;
        if (!item.isShowEbayPlusPromo)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        item.isEbayPlusMember = flag;
        item.eBayPlusOrderTodayEndTime = item.eBayPlusShippingOption.sameDayCutOff;
        if (item.isShowEbayPlusPromo)
        {
            item.shippingInfo.removeEbayPlusOptions();
        }
_L41:
        if (isMainThread())
        {
            item.setupDisplayStrings(getEbayContext(), viewitemviewdata);
        }
        this;
        JVM INSTR monitorexit ;
        return;
_L25:
        obj = obj1;
        if (TextUtils.isEmpty(item.iTransaction.orderId)) goto _L23; else goto _L45
_L45:
        obj = item.iTransaction.orderId;
          goto _L23
_L29:
        if (!item.dpiSoldOffEbay)
        {
            break MISSING_BLOCK_LABEL_3764;
        }
        item.stpSavingsWasLabel = context.getString(0x7f07050f);
          goto _L46
        item;
        throw item;
label1:
        {
            if (3 != ((EbayCountry) (obj)).getSiteId())
            {
                break label1;
            }
            item.stpSavingsWasLabel = context.getString(0x7f070cf2);
        }
          goto _L46
        item.stpSavingsWasLabel = context.getString(0x7f070cf3);
          goto _L46
_L27:
        item.stpSavingsWasLabel = context.getString(0x7f07050e);
          goto _L46
_L33:
        if (item.iTransaction.buyerStreet1 == null) goto _L48; else goto _L47
_L47:
        ((StringBuilder) (obj)).append(item.iTransaction.buyerStreet1).append('\n');
        if (item.iTransaction.buyerStreet2 != null)
        {
            ((StringBuilder) (obj)).append(item.iTransaction.buyerStreet2).append('\n');
        }
          goto _L48
_L39:
        flag = false;
          goto _L49
_L43:
        obj = null;
          goto _L50
        obj;
          goto _L51
_L4:
        obj = null;
          goto _L52
_L6:
        i = 1;
          goto _L53
_L8:
        i = 0;
          goto _L54
_L11:
        flag = false;
          goto _L55
        flag = true;
          goto _L49
    }

    private void updateMyEbay(Authentication authentication)
    {
        if (authentication != null)
        {
            if (myEbayWatchingDataManager != null)
            {
                unObserveDm(myEbayWatchingDataManager);
            }
            if (myEbayBuyingDataManager != null)
            {
                unObserveDm(myEbayBuyingDataManager);
            }
            myEbayWatchingDataManager = (MyEbayWatchingDataManager)observeDm(new com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.KeyParams(authentication.user));
            addTaskToList(TaskId.GET_WATCHLIST);
            myEbayWatchingDataManager.loadWatchList();
            addTaskToList(TaskId.GET_BIDLIST);
            addTaskToList(TaskId.GET_WONLIST);
            myEbayBuyingDataManager = (MyEbayBuyingDataManager)observeDm(new com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager.KeyParams(authentication.user));
            myEbayBuyingDataManager.setObserving(this, false, true, true, false, false);
            addTaskToList(TaskId.GET_SOLDLIST);
            myEbaySellingDataManager = (MyEbaySellingDataManager)observeDm(new com.ebay.nautilus.domain.content.dm.MyEbaySellingDataManager.KeyParams(authentication.user));
            myEbaySellingDataManager.setObserving(this, false, false, true, false, false);
        }
    }

    private void userSignedOut()
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        if (myEbayWatchingDataManager != null)
        {
            unObserveDm(myEbayWatchingDataManager);
            myEbayWatchingDataManager = null;
        }
        if (myEbayBuyingDataManager != null)
        {
            unObserveDm(myEbayBuyingDataManager);
            myEbayBuyingDataManager = null;
        }
        if (myEbaySellingDataManager != null)
        {
            unObserveDm(myEbaySellingDataManager);
            myEbaySellingDataManager = null;
        }
        if (biddingDataManagerObserving != null)
        {
            unObserveDm(biddingDataManagerObserving);
            biddingDataManagerObserving = null;
        }
        if (recentsDataManager != null)
        {
            unObserveDm(recentsDataManager);
            recentsDataManager = null;
        }
        userAddresses = null;
        primaryAddress = null;
        bidItems = null;
        soldItems = null;
        wonItems = null;
        watchItemsActive = null;
        watchItemsEnded = null;
        _content = null;
    }

    public void addItemToCart(Long long1, String s, InventoryInfo inventoryinfo, int i)
    {
        NautilusKernel.verifyMain();
        Object obj = null;
        String s1 = obj;
        if (inventoryinfo != null)
        {
            s1 = obj;
            if (inventoryinfo.getSelectedStore() != null)
            {
                s1 = inventoryinfo.getSelectedStore().locationId;
            }
        }
        shoppingCartDataManager.addItemToCart(long1, s, s1, i, this);
    }

    public void addItemToRecentlyViewed()
    {
        addItemToRecentlyViewedList(_content);
    }

    public void addShipmentTracking(EbayTradingApi ebaytradingapi, Long long1, long l, ShipmentTracking shipmenttracking, Boolean boolean1, Boolean boolean2)
    {
        NautilusKernel.verifyMain();
        if (addShipmentTrackingTask != null)
        {
            return;
        } else
        {
            addShipmentTrackingTask = new AddShipmentTrackingTask(ebaytradingapi, long1.longValue(), Long.valueOf(l), shipmenttracking, boolean1, boolean2);
            executeOnThreadPool(addShipmentTrackingTask, new Void[0]);
            return;
        }
    }

    public void create()
    {
        userContextDataManager = (UserContextDataManager)observeDm(UserContextDataManager.KEY);
        currencyConversionDataManager = (CurrencyConversionDataManager)observeDm(CurrencyConversionDataManager.KEY);
        experimentationDataManager = (ExperimentationDataManager)observeDm(ExperimentationUtil.AEAPP_KEY);
        addressDataManager = (AddressDataManager)observeDm(new com.ebay.nautilus.domain.content.dm.AddressDataManager.KeyParams("Shipping"));
        com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi serviceapi;
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Payments.B.shopCaseCart))
        {
            serviceapi = com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi.SHOPCASE;
        } else
        {
            serviceapi = com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi.ECAS;
        }
        shoppingCartDataManager = (ShoppingCartDataManagerBase)observeDm(new com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.KeyParams(serviceapi));
        if (auth != null)
        {
            recentsDataManager = (RecentsDataManager)observeDm(new com.ebay.mobile.recents.RecentsDataManager.KeyParams(auth.iafToken));
        }
    }

    public void deleteItemFromPaymentReminderStorage(com.ebay.nautilus.domain.content.PaymentReminderStorageUtil.PaymentReminderStorageParams paymentreminderstorageparams)
    {
        PaymentReminderStorageUtil.deleteItem(paymentreminderstorageparams);
    }

    public boolean forceReloadData(ViewItemViewData viewitemviewdata)
    {
        NautilusKernel.verifyMain();
        return loadFully(viewitemviewdata, true);
    }

    public boolean forceReloadData(ViewItemViewData viewitemviewdata, int i)
    {
        NautilusKernel.verifyMain();
        return loadFully(viewitemviewdata, true, i);
    }

    public void forceReloadWonList()
    {
        refreshWonList = true;
    }

    public void getBestOffers(EbayTradingApi ebaytradingapi, long l, ViewItemViewData viewitemviewdata)
    {
        NautilusKernel.verifyMain();
        if (getBestOffersTask == null)
        {
            getBestOffersTask = new GetBestOffersTask(ebaytradingapi, l, false, viewitemviewdata);
            executeOnThreadPool(getBestOffersTask, new Content[] {
                _content
            });
        }
    }

    public CurrencyConversionRate getCurrencyConversionRate()
    {
        return currencyConversionRate;
    }

    public Handler getHandler()
    {
        return handler;
    }

    public List getInFlightTasks()
    {
        return Collections.unmodifiableList(inFlightTasks);
    }

    public void getItemForFlags(long l)
    {
        NautilusKernel.verifyMain();
        if (getViewListingTask == null)
        {
            GetViewListingTask getviewlistingtask = new GetViewListingTask(getViewData(), MyApp.getPrefs().getCurrentSite(), _content, TaskId.GET_ITEM_FLAGS);
            getViewListingTask = getviewlistingtask;
            executeOnThreadPool(getviewlistingtask, new KeyParams[] {
                params
            });
        }
    }

    public ItemCurrency getMaxBid(Item item)
    {
        Object obj = null;
        MyEbayListItem myebaylistitem = getMyEbayBidItem(item.id, getViewData().nameValueList);
        item = obj;
        if (myebaylistitem != null)
        {
            item = obj;
            if (!ItemCurrency.isEmpty(myebaylistitem.maxBidPrice))
            {
                item = myebaylistitem.maxBidPrice;
            }
        }
        return item;
    }

    public final MyEbayListItem getMyEbayBidItem(long l, List list)
    {
        list = new EbayItemIdAndVariationSpecifics(l, list);
        if (bidItems != null)
        {
            return (MyEbayListItem)bidItems.get(list);
        } else
        {
            return null;
        }
    }

    public void getOrders(EbayTradingApi ebaytradingapi, String s, Locale locale, String s1)
    {
        NautilusKernel.verifyMain();
        if (getOrdersTask == null)
        {
            getOrdersTask = new GetOrdersTask(ebaytradingapi, s, locale, s1);
            executeOnThreadPool(getOrdersTask, new Void[0]);
        }
    }

    public KeyParams getParams()
    {
        return params;
    }

    public volatile Object getParams()
    {
        return getParams();
    }

    public void getProductInfo(EbayShoppingApi ebayshoppingapi, long l, String s, boolean flag)
    {
        NautilusKernel.verifyMain();
        if (getProductInfoTask == null && !TextUtils.isEmpty(s) && _content != null)
        {
            Item item = (Item)_content.getData();
            if (item != null && (item.productListingDetails == null || item.productListingDetails.includePrefilledItemInformation))
            {
                getProductInfoTask = new GetProductInfoTask(ebayshoppingapi, s, flag);
                executeOnThreadPool(getProductInfoTask, new Content[] {
                    _content
                });
            }
        }
    }

    public void getShipmentTracking(String s, EbaySite ebaysite, long l, Long long1, boolean flag, ViewItemViewData viewitemviewdata)
    {
        NautilusKernel.verifyMain();
        if (getShipmentTrackingTask == null)
        {
            getShipmentTrackingTask = new GetShipmentTrackingTask(s, ebaysite, l, long1, flag, viewitemviewdata);
            executeOnThreadPool(getShipmentTrackingTask, new Content[] {
                _content
            });
        }
    }

    public void getShippingCosts(PostalCodeSpecification postalcodespecification, int i, ItemCurrency itemcurrency)
    {
        NautilusKernel.verifyMain();
        if (getShippingCostsTask == null)
        {
            postalcodespecification = getViewData();
            EbaySite ebaysite = MyApp.getPrefs().getCurrentSite();
            Content content = _content;
            TaskId taskid = TaskId.GET_SHIPPING_COSTS_SINGLE;
            if (itemcurrency == null)
            {
                itemcurrency = null;
            }
            postalcodespecification = new GetViewListingTask(postalcodespecification, ebaysite, content, taskid, itemcurrency, Integer.valueOf(i));
            getShippingCostsTask = postalcodespecification;
            executeOnThreadPool(postalcodespecification, new KeyParams[] {
                params
            });
        }
    }

    public void getStoreAvailability(ViewItemViewData viewitemviewdata)
    {
        NautilusKernel.verifyMain();
        if (getStoreAvailabilityTask != null)
        {
            return;
        } else
        {
            getStoreAvailabilityTask = new GetStoreAvailabilityTask(viewitemviewdata.nameValueList, viewitemviewdata, false);
            executeOnThreadPool(getStoreAvailabilityTask, new Content[] {
                _content
            });
            return;
        }
    }

    public String getUserName()
    {
        String s = "";
        if (auth != null)
        {
            s = auth.user;
        }
        return s;
    }

    public void getViewItemLite(long l, boolean flag)
    {
        NautilusKernel.verifyMain();
        if (viewItemLiteTask == null)
        {
            viewItemLiteTask = new ViewItemLiteTask(l, flag);
            executeOnThreadPool(viewItemLiteTask, new Content[] {
                _content
            });
        }
    }

    void handleAddShipmentTrackingResult(AddShipmentTrackingTask addshipmenttrackingtask, Content content)
    {
        if (addShipmentTrackingTask == addshipmenttrackingtask)
        {
            addShipmentTrackingTask = null;
        }
        if (content == null)
        {
            return;
        } else
        {
            onDataChanged((Observer)dispatcher, content, ActionHandled.SHIPMENT_TRACKING, isLoadingComplete());
            return;
        }
    }

    void handleEndItemResult(EndItemTask enditemtask, ResultStatus resultstatus)
    {
        if (endItemTask == enditemtask)
        {
            endItemTask = null;
        }
        if (resultstatus == null)
        {
            return;
        }
        enditemtask = _content;
        if (resultstatus.hasError())
        {
            enditemtask = new Content(null, resultstatus);
        }
        onDataChanged((Observer)dispatcher, enditemtask, ActionHandled.ITEM_ENDED_BY_SELLER, isLoadingComplete());
    }

    void handleGetBestOffersResult(GetBestOffersTask getbestofferstask, Content content)
    {
        if (getBestOffersTask == getbestofferstask)
        {
            getBestOffersTask = null;
        }
        removeTaskFromList(TaskId.GET_BEST_OFFERS);
        if (content == null)
        {
            return;
        } else
        {
            onDataChanged((Observer)dispatcher, content, ActionHandled.GET_BEST_OFFERS, true);
            return;
        }
    }

    void handleGetOrdersResult(GetOrdersTask getorderstask, Content content)
    {
        if (getOrdersTask == getorderstask)
        {
            getOrdersTask = null;
        }
        if (content == null)
        {
            return;
        } else
        {
            ((Observer)dispatcher).onGetOrdersCompleted(this, content);
            return;
        }
    }

    void handleGetShipmentTrackingResult(GetShipmentTrackingTask getshipmenttrackingtask, Content content)
    {
        if (getShipmentTrackingTask == getshipmenttrackingtask)
        {
            getShipmentTrackingTask = null;
        }
        removeTaskFromList(TaskId.GET_SHIPMENT_TRACKING);
        if (content == null)
        {
            return;
        } else
        {
            onDataChanged((Observer)dispatcher, content, ActionHandled.GET_SHIPMENT_TRACKING, true);
            return;
        }
    }

    void handleGetStoreAvailabilityResult(GetStoreAvailabilityTask getstoreavailabilitytask, Content content)
    {
        if (getStoreAvailabilityTask == getstoreavailabilitytask)
        {
            getStoreAvailabilityTask = null;
        }
        if (content == null)
        {
            return;
        } else
        {
            onDataChanged((Observer)dispatcher, content, ActionHandled.BOPIS_AVAILABILITY, isLoadingComplete());
            return;
        }
    }

    void handleLeaveFeedbackResult(LeaveFeedbackTask leavefeedbacktask, Content content)
    {
        if (leaveFeedbackTask == leavefeedbacktask)
        {
            leaveFeedbackTask = null;
        }
        removeTaskFromList(TaskId.LEAVE_FEEDBACK);
        if (content == null)
        {
            return;
        }
        if (content.getData() != null)
        {
            updateItemState((Item)content.getData());
        }
        onDataChanged((Observer)dispatcher, content, ActionHandled.FEEDBACK_LEFT, true);
    }

    void handleLoadDataResult(TaskId taskid, ViewItemViewData viewitemviewdata, Content content)
    {
        Object obj;
        obj = null;
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                taskid
            });
        }
        if (!isTaskListEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (TaskId.GET_ITEM_TRANSACTIONS == taskid)
        {
            getItemTransactionsTask = null;
        } else
        if (TaskId.GET_STOREAVAILABILITY == taskid)
        {
            getStoreAvailabilityTask = null;
        } else
        if (TaskId.GET_INCENTIVES == taskid)
        {
            getIncentivesTask = null;
        } else
        if (TaskId.GET_BEST_OFFERS == taskid)
        {
            getBestOffersTask = null;
        } else
        if (TaskId.GET_LOCATION_DETAILS == taskid)
        {
            getLocationDetailsTask = null;
        } else
        if (TaskId.GET_ORDER_SHIPPING_INFO == taskid)
        {
            getOrderShippingInfoTask = null;
        } else
        if (TaskId.GET_VIEW_LISTING == taskid)
        {
            getViewListingTask = null;
        } else
        if (TaskId.GET_SHIPMENT_TRACKING == taskid)
        {
            getShipmentTrackingTask = null;
        }
        removeTaskFromList(taskid);
        if (content != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (logTag.isLoggable)
        {
            logTag.logAsWarning((new StringBuilder()).append("handleLoadDataResult, result is null short circuit for taskId=").append(taskid).toString());
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!taskid.requiredSuccess && content.getStatus().hasError() && logTag.isLoggable)
        {
            logTag.logAsWarning((new StringBuilder()).append("handleLoadDataResult: api call failed but not required taskId=").append(taskid).toString());
        }
        if (content.getStatus().hasError() && taskid.requiredSuccess)
        {
            if (logTag.isLoggable)
            {
                logTag.log("handleLoadDataResult error, canceling tasks and dispatching");
            }
            cancelPendingTasks();
            synchronized (lock)
            {
                inFlightTasks.clear();
            }
            _content = null;
            onDataChanged((Observer)dispatcher, content, ActionHandled.INITIAL_LOAD, true);
            return;
        }
        break MISSING_BLOCK_LABEL_332;
        viewitemviewdata;
        taskid;
        JVM INSTR monitorexit ;
        throw viewitemviewdata;
        if (content.getStatus().hasError())
        {
            break; /* Loop/switch isn't completed */
        }
        _content = content;
        taskid = content;
_L6:
        if (isTaskListEmpty())
        {
            content = obj;
            if (taskid != null)
            {
                content = (Item)taskid.getData();
            }
            if (content == null || viewitemviewdata == null || !viewitemviewdata.isTransactionLookupIndicated || viewitemviewdata.keyParams == null || params.transactionId != null || viewitemviewdata.keyParams.transactionId != null || (soldItems == null || soldItems.isEmpty()) && (wonItems == null || wonItems.isEmpty()) || viewitemviewdata.kind == com.ebay.common.ConstantsCommon.ItemKind.Selling || viewitemviewdata.kind == com.ebay.common.ConstantsCommon.ItemKind.Bidding || viewitemviewdata.kind == com.ebay.common.ConstantsCommon.ItemKind.Found && (((Item) (content)).quantity != 1 || ((Item) (content)).quantitySold != 1) && (!isBestOffer(content) && !((Item) (content)).isSeller || ((Item) (content)).quantity != 1) || !isItemTransacted(soldItems, viewitemviewdata) && !isItemTransacted(wonItems, viewitemviewdata))
            {
                if (content != null)
                {
                    if (!((Item) (content)).watched)
                    {
                        content.watched = isInMyEbayWatchList(new EbayItemIdAndVariationSpecifics(((Item) (content)).id, viewitemviewdata.nameValueList));
                    }
                    updateItemState(content);
                    _content = taskid;
                    if (!((Item) (content)).isBinOnly && !((Item) (content)).isTransacted && (!((Item) (content)).finalized || !viewitemviewdata.finalized))
                    {
                        startViewItemLite(taskid);
                    }
                }
                viewitemviewdata.waitForBidding = false;
                if (logTag.isLoggable)
                {
                    FwLog.println(logTag, "dispatching onDataChanged");
                }
                onDataChanged((Observer)dispatcher, taskid, ActionHandled.INITIAL_LOAD, true);
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
        taskid = content;
        if (isTaskListEmpty())
        {
            taskid = content;
            if (_content != null)
            {
                taskid = _content;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L1; else goto _L7
_L7:
    }

    void handleMakeOfferResult(MakeOfferTask makeoffertask, Content content)
    {
        if (makeOfferTask == makeoffertask)
        {
            makeOfferTask = null;
        }
        removeTaskFromList(TaskId.MAKE_OFFER);
        if (content == null)
        {
            return;
        }
        if (content.getData() != null && ((PlaceOfferInfo)content.getData()).item != null && ((PlaceOfferInfo)content.getData()).item.getData() != null)
        {
            updateItemState((Item)((PlaceOfferInfo)content.getData()).item.getData());
        }
        ((Observer)dispatcher).onPlaceOfferCompleted(this, content);
    }

    void handleMarkPaidResult(MarkPaidTask markpaidtask, Content content)
    {
        if (markPaidTask == markpaidtask)
        {
            markPaidTask = null;
        }
        if (content == null)
        {
            return;
        } else
        {
            ((Observer)dispatcher).onDataChanged(this, content, ActionHandled.MARK_PAID_OR_UNPAID, true);
            return;
        }
    }

    void handleMarkShippedResult(MarkShippedTask markshippedtask, Content content)
    {
        if (markShippedTask == markshippedtask)
        {
            markShippedTask = null;
        }
        if (content == null)
        {
            return;
        }
        if (content.getData() != null)
        {
            updateItemState((Item)content.getData());
        }
        onDataChanged((Observer)dispatcher, content, ActionHandled.MARK_SHIPPED_OR_UNSHIPPED, isLoadingComplete());
    }

    void handlePlaceOfferResult(PlaceOfferTask placeoffertask, Content content)
    {
        if (placeOfferTask == placeoffertask)
        {
            placeOfferTask = null;
        }
        removeTaskFromList(TaskId.PLACE_OFFER);
        if (content != null)
        {
            if (myEbayBuyingDataManager != null && placeoffertask.isBidAction && !content.getStatus().hasError())
            {
                myEbayBuyingDataManager.forceReloadBidList();
            }
            if (myEbayBuyingDataManager != null && placeoffertask.isPurchaseAction && !content.getStatus().hasError())
            {
                myEbayBuyingDataManager.forceReloadWonList();
            }
            if (content.getData() != null && ((PlaceOfferInfo)content.getData()).item != null && ((PlaceOfferInfo)content.getData()).item.getData() != null)
            {
                updateItemState((Item)((PlaceOfferInfo)content.getData()).item.getData());
            }
            ((Observer)dispatcher).onPlaceOfferCompleted(this, content);
            if (!content.getStatus().hasError())
            {
                onDataChanged((Observer)dispatcher, ((PlaceOfferInfo)content.getData()).item, ActionHandled.BID_CHANGE, isLoadingComplete());
                return;
            }
        }
    }

    void handleProductInfoResult(AsyncTask asynctask, Content content)
    {
        if (getProductInfoTask == asynctask)
        {
            getProductInfoTask = null;
        }
        removeTaskFromList(TaskId.GET_PRODUCT_INFO);
        if (content == null)
        {
            return;
        } else
        {
            onDataChanged((Observer)dispatcher, content, ActionHandled.PRODUCT_INFO, true);
            return;
        }
    }

    void handleRespondBestOfferResult(RespondBestOfferTask respondbestoffertask, Content content)
    {
        if (respondBestOfferTask == respondbestoffertask)
        {
            respondBestOfferTask = null;
        }
        removeTaskFromList(TaskId.RESPOND_BEST_OFFER);
        if (content == null)
        {
            return;
        }
        if (content.getData() != null && ((RespondBestOfferInfo)content.getData()).item != null && ((RespondBestOfferInfo)content.getData()).item.getData() != null)
        {
            updateItemState((Item)((RespondBestOfferInfo)content.getData()).item.getData());
        }
        ((Observer)dispatcher).onRespondBestOfferCompleted(this, content);
    }

    void handleSetPaymentReminderStatusResult(SetPaymentReminderStatusTask setpaymentreminderstatustask, Content content)
    {
        if (content == null)
        {
            return;
        } else
        {
            onDataChanged((Observer)dispatcher, content, ActionHandled.PAYMENT_REMINDER_SENT, true);
            return;
        }
    }

    void handleUpdateCartResult(Content content)
    {
        if (content == null)
        {
            return;
        } else
        {
            updateItemState((Item)((AddToCartInfo)content.getData()).item.getData());
            ((Observer)dispatcher).onCartChanged(this, content, ActionHandled.CART_UPDATED);
            return;
        }
    }

    void handleViewItemLiteResult(ViewItemLiteTask viewitemlitetask, Content content)
    {
        if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
        {
            FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[0]);
        }
        if (viewItemLiteTask == viewitemlitetask)
        {
            viewItemLiteTask = null;
        }
        removeTaskFromList(TaskId.VIEW_ITEM_LITE);
        if (content == null)
        {
            return;
        }
        viewitemlitetask = (ViewItemLiteInfo)content.getData();
        if (((ViewItemLiteInfo) (viewitemlitetask)).price != null)
        {
            setCurrentAndConvertedPrice(new CurrencyAmount(((ViewItemLiteInfo) (viewitemlitetask)).price), currencyConversionRate, ((ViewItemLiteInfo) (viewitemlitetask)).item);
        }
        ((ViewItemLiteInfo) (viewitemlitetask)).item.finalized = ((ViewItemLiteInfo) (viewitemlitetask)).bidEvent.finalized;
        updateItemState(((ViewItemLiteInfo) (viewitemlitetask)).item);
        if (biddingDataManagerObserving != null)
        {
            biddingDataManagerObserving.loadBidders(this, ((ViewItemLiteInfo) (viewitemlitetask)).item);
        }
        ((Observer)dispatcher).onBidUpdated(this, content);
    }

    public boolean isInMyEbayBidList(long l, List list)
    {
        list = new EbayItemIdAndVariationSpecifics(l, list);
        return bidItems != null && bidItems.containsKey(list);
    }

    public boolean isInMyEbayWatchList(EbayItemIdAndVariationSpecifics ebayitemidandvariationspecifics)
    {
        boolean flag;
        if (watchItemsActive != null && watchItemsActive.containsKey(ebayitemidandvariationspecifics))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        while (flag || watchItemsEnded != null && watchItemsEnded.containsKey(ebayitemidandvariationspecifics)) 
        {
            return true;
        }
        return false;
    }

    public boolean isLoadingComplete()
    {
        return isTaskListEmpty();
    }

    public void leaveFeedback(EbayTradingApi ebaytradingapi, LeaveFeedbackParameters leavefeedbackparameters)
    {
        NautilusKernel.verifyMain();
        if (leaveFeedbackTask == null)
        {
            leaveFeedbackTask = new LeaveFeedbackTask(ebaytradingapi, leavefeedbackparameters);
            executeOnThreadPool(leaveFeedbackTask, new Content[] {
                _content
            });
        }
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public boolean loadData(Observer observer, ViewItemViewData viewitemviewdata)
    {
        return loadData(observer, viewitemviewdata, null);
    }

    public boolean loadData(Observer observer, ViewItemViewData viewitemviewdata, Authentication authentication)
    {
        boolean flag3;
label0:
        {
            if (logTag.isLoggable)
            {
                FwLog.logMethod(logTag, new Object[] {
                    viewitemviewdata.toString()
                });
            }
            NautilusKernel.verifyMain();
            boolean flag4 = false;
            Boolean boolean1;
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (_content != null && _content.getData() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && dirtyItems != null)
            {
                boolean1 = (Boolean)dirtyItems.get(params.toString());
            } else
            {
                boolean1 = null;
            }
            if (boolean1 != null && boolean1.booleanValue())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (authentication != null)
            {
                isIgnoreAuthChanges = true;
                auth = authentication;
            }
            if (logTag.isLoggable && flag1)
            {
                logTag.log((new StringBuilder()).append(params.toString()).append(" dirty; force reload").toString());
            }
            flag2 = flag;
            if (!flag)
            {
                break label0;
            }
            if (!flag1 && (((Item)_content.getData()).user == null || ((Item)_content.getData()).user.equals(MyApp.getPrefs().getCurrentUser())) && (((Item)_content.getData()).user != null || !MyApp.getPrefs().isSignedIn()) && (TextUtils.isEmpty(((Item)_content.getData()).countryCode) || ((Item)_content.getData()).countryCode.equals(MyApp.getPrefs().getCurrentCountry().getCountryCode())))
            {
                flag2 = flag;
                if (((Item)_content.getData()).locale == null)
                {
                    break label0;
                }
                flag2 = flag;
                if (((Item)_content.getData()).locale.equals(Locale.getDefault()))
                {
                    break label0;
                }
            }
            flag2 = false;
            Item.clearNotSelectedStrings(getContext());
        }
        if (dirtyItems != null)
        {
            dirtyItems.remove(params.toString());
        }
        if (flag2)
        {
            authentication = (Item)_content.getData();
            flag3 = flag4;
            if (viewitemviewdata.shippingCostsPostalCode != null)
            {
                flag3 = flag4;
                if (!viewitemviewdata.shippingCostsPostalCode.equals(((Item) (authentication)).shippingCostsPostalCode))
                {
                    flag3 = loadFully(viewitemviewdata, true);
                }
            }
            viewDataMap.put(params, viewitemviewdata);
        } else
        if (getViewListingTask == null)
        {
            flag3 = loadFully(viewitemviewdata, true);
        } else
        {
            flag3 = true;
        }
        if (flag3 || observer == null) goto _L2; else goto _L1
_L1:
        if (logTag.isLoggable)
        {
            logTag.log("loadData; !loadStarted so calling onDataChanged");
        }
        onDataChanged(observer, _content, ActionHandled.INITIAL_LOAD, isLoadingComplete(), true);
        if (_content == null || postViewItemLite != null) goto _L4; else goto _L3
_L3:
        observer = (Item)_content.getData();
        if (observer != null && !((Item) (observer)).isBinOnly && !((Item) (observer)).isAuctionEnded)
        {
            startViewItemLite(_content);
        }
_L2:
        lastObserverUnregistered = false;
        return flag3;
_L4:
        if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
        {
            observer = "_content is null";
            if (_content != null)
            {
                observer = "postViewItemLite not null";
            }
            ItemViewBiddingUpdater.fwLogItemViewBidding.log((new StringBuilder()).append("VIPDM: loadData() returned cache but didn't start ViewItemLite reason=").append(observer).toString());
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void makeOffer(EbayTradingApi ebaytradingapi, long l, String s, ItemCurrency itemcurrency, int i, ArrayList arraylist, 
            String s1, String s2, boolean flag)
    {
        NautilusKernel.verifyMain();
        if (makeOfferTask != null)
        {
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        if (PlaceOfferRequest.AVAILABLE_ACTIONS.contains(s))
        {
            break MISSING_BLOCK_LABEL_131;
        }
        throw new IllegalArgumentException((new StringBuilder()).append("Invalid action: ").append(s).toString());
        ebaytradingapi;
        s = new ResultStatusOwner();
        itemcurrency = new EbayResponseError();
        itemcurrency.severity = 1;
        itemcurrency.longMessage = ebaytradingapi.getMessage();
        s.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
            itemcurrency
        });
        ((Observer)dispatcher).onPlaceOfferCompleted(this, new Content(null, s.getResultStatus()));
        return;
        if (ItemCurrency.isEmpty(itemcurrency))
        {
            throw new NullPointerException("bid");
        }
        if ((s.equals("Accept") || s.equals("Decline") || s.equals("Counter")) && TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("bestOfferId required");
        } else
        {
            makeOfferTask = new MakeOfferTask(ebaytradingapi, l, s, itemcurrency, i, arraylist, s1, s2, flag);
            executeOnThreadPool(makeOfferTask, new Content[] {
                _content
            });
            return;
        }
    }

    public void markDirty()
    {
        markDirty(params);
    }

    public void markItemPaid(EbayTradingApi ebaytradingapi, long l, Long long1, ShipmentTracking shipmenttracking, Boolean boolean1)
    {
        NautilusKernel.verifyMain();
        if (markPaidTask != null)
        {
            return;
        } else
        {
            markPaidTask = new MarkPaidTask(ebaytradingapi, l, long1, shipmenttracking, boolean1);
            executeOnThreadPool(markPaidTask, new Content[] {
                _content
            });
            return;
        }
    }

    public void markItemShipped(EbayTradingApi ebaytradingapi, long l, Long long1, ShipmentTracking shipmenttracking, Boolean boolean1)
    {
        NautilusKernel.verifyMain();
        if (markShippedTask != null)
        {
            return;
        } else
        {
            markShippedTask = new MarkShippedTask(ebaytradingapi, l, long1, shipmenttracking, boolean1);
            executeOnThreadPool(markShippedTask, new Content[] {
                _content
            });
            return;
        }
    }

    public void onActiveCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent)
    {
    }

    public void onActiveListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent)
    {
    }

    public void onAddToWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, Content content)
    {
        if (content == null)
        {
            return;
        }
        myebaywatchingdatamanager = _content;
        if (_content != null && !content.getStatus().hasError())
        {
            ((Item)_content.getData()).watched = true;
        } else
        {
            myebaywatchingdatamanager = new Content(null, content.getStatus());
        }
        onDataChanged((Observer)dispatcher, myebaywatchingdatamanager, ActionHandled.WATCH_CHANGED, true);
    }

    public void onAddressDeleted(AddressDataManager addressdatamanager, Content content)
    {
    }

    public void onAddressPrimary(AddressDataManager addressdatamanager, Content content)
    {
    }

    public void onAddressUpdated(AddressDataManager addressdatamanager, Content content)
    {
    }

    public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
    {
        flag = true;
        if (logTag.isLoggable)
        {
            addressdatamanager = logTag;
            if (content == null || content.getData() == null)
            {
                flag = false;
            }
            FwLog.logMethod(addressdatamanager, new Object[] {
                Boolean.valueOf(flag)
            });
        }
        if (content != null && content.getData() != null)
        {
            userAddresses = (List)content.getData();
            primaryAddress = getPrimaryAddress();
        }
        if (inFlightTasks.contains(TaskId.GET_DM_ADDRESSES))
        {
            dispatchExternalDmCallComplete(TaskId.GET_DM_ADDRESSES);
            return;
        } else
        {
            handleLoadDataResult(TaskId.GET_DM_ADDRESSES, getViewData(), _content);
            return;
        }
    }

    public void onBidderChanged(BiddingDataManager biddingdatamanager, BiddingDataManager.BidderContent biddercontent)
    {
        biddingdatamanager = getViewData();
        if (biddercontent == null || biddercontent.item == null) goto _L2; else goto _L1
_L1:
        biddercontent.item.allBidders = (AllBiddersData)biddercontent.getData();
        if (!((ViewItemViewData) (biddingdatamanager)).waitForBidding && isTaskListEmpty()) goto _L4; else goto _L3
_L3:
        dispatchExternalDmCallComplete(TaskId.BIDDING_HISTORY);
_L6:
        return;
_L4:
        biddingdatamanager = _content;
        if (biddingdatamanager != null && biddingdatamanager.getData() != null)
        {
            ((Item)biddingdatamanager.getData()).allBidders = biddercontent.item.allBidders;
        } else
        {
            biddingdatamanager = new Content(biddercontent.item);
        }
        onDataChanged((Observer)dispatcher, biddingdatamanager, ActionHandled.BIDDING_HISTORY, isTaskListEmpty());
        return;
_L2:
        if (((ViewItemViewData) (biddingdatamanager)).waitForBidding)
        {
            dispatchExternalDmCallComplete(TaskId.BIDDING_HISTORY);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onBiddingCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent)
    {
    }

    public void onBiddingListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent)
    {
        if (!listcontent.getStatus().hasError())
        {
            if (bidItems == null)
            {
                bidItems = new HashMap();
            } else
            {
                bidItems.clear();
            }
            myebaybuyingdatamanager = listcontent.getList();
            if (myebaybuyingdatamanager != null && !myebaybuyingdatamanager.isEmpty())
            {
                EbayItemIdAndVariationSpecifics ebayitemidandvariationspecifics;
                for (myebaybuyingdatamanager = myebaybuyingdatamanager.iterator(); myebaybuyingdatamanager.hasNext(); bidItems.put(ebayitemidandvariationspecifics, listcontent))
                {
                    listcontent = (MyEbayListItem)myebaybuyingdatamanager.next();
                    ebayitemidandvariationspecifics = new EbayItemIdAndVariationSpecifics(((MyEbayListItem) (listcontent)).id, ((MyEbayListItem) (listcontent)).nameValueList);
                }

            }
        }
        dispatchExternalDmCallComplete(TaskId.GET_BIDLIST);
    }

    public void onBuyingOffersCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent)
    {
    }

    public void onBuyingOffersListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent)
    {
    }

    public void onCategoriesChanged(CategoriesDataManager categoriesdatamanager, Content content)
    {
        if (!content.getStatus().hasError() && content != null && content.getData() != null && ((com.ebay.nautilus.domain.content.dm.CategoriesDataManager.SiteCategories)content.getData()).categoriesIdsRequiringConsent != null)
        {
            categoryInfo = (com.ebay.nautilus.domain.content.dm.CategoriesDataManager.SiteCategories)content.getData();
        }
        unObserveDm(categoriesdatamanager);
        categoriesDataManager = null;
    }

    public void onCheckoutSessionComplete(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, Content content)
    {
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        markDirty();
        currencyConversionRate = null;
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                s
            });
        }
        if (!isIgnoreAuthChanges)
        {
            usercontextdatamanager = usercontextdatamanager.getCurrentUser();
            if (usercontextdatamanager == null)
            {
                userSignedOut();
            }
            auth = usercontextdatamanager;
        }
        if (auth != null)
        {
            if (recentsDataManager != null)
            {
                unObserveDm(recentsDataManager);
            }
            recentsDataManager = (RecentsDataManager)observeDm(new com.ebay.mobile.recents.RecentsDataManager.KeyParams(auth.iafToken));
        }
    }

    public void onFilteredListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent, SellingListRefinement sellinglistrefinement)
    {
    }

    public void onImageChanged(BiddingDataManager biddingdatamanager, BiddingDataManager.ImageContent imagecontent)
    {
    }

    protected void onLastObserverUnregistered()
    {
        if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
        {
            FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[0]);
        }
        if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
        {
            ItemViewBiddingUpdater.fwLogItemViewBidding.log((new StringBuilder()).append("onLastObserverUnregistered item id=").append(params.itemId).toString());
        }
        lastObserverUnregistered = true;
        if (biddingUpdater != null)
        {
            if (biddingUpdater.updateMode == ItemViewBiddingUpdater.UpdateMode.POLLING)
            {
                biddingUpdater.stop(getContext());
            }
            biddingUpdater = null;
        }
        if (postViewItemLite != null)
        {
            postViewItemLite.removeCallbacksAndMessages(postViewItemLite);
            postViewItemLite = null;
        }
        viewDataMap.remove(params);
        biddingDataManagerObserving = null;
        if (dirtyItems != null && dirtyItems.remove(params.toString()) != null)
        {
            clearCache();
        }
    }

    public void onNotWonCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent)
    {
    }

    public void onNotWonListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent)
    {
    }

    public void onRateChanged(CurrencyConversionDataManager currencyconversiondatamanager, CurrencyConversionRate currencyconversionrate)
    {
        currencyConversionRate = currencyconversionrate;
        dispatchExternalDmCallComplete(TaskId.CONVERT_CURRENCY);
    }

    public void onRateLoadComplete(CurrencyConversionDataManager currencyconversiondatamanager, ResultStatus resultstatus, CurrencyConversionRate currencyconversionrate, com.ebay.common.net.api.currency.CurrencyConversionRequest.ConversionRequestParams conversionrequestparams)
    {
        currencyConversionRate = currencyconversionrate;
        dispatchExternalDmCallComplete(TaskId.CONVERT_CURRENCY);
    }

    public void onRemoveAllFromWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, ResultStatus resultstatus)
    {
        if (!resultstatus.hasError())
        {
            if (watchItemsActive != null)
            {
                watchItemsActive.clear();
            }
            if (watchItemsEnded != null)
            {
                watchItemsEnded.clear();
                return;
            }
        }
    }

    public void onRemoveFromNotWonListComplete(MyEbayBuyingDataManager myebaybuyingdatamanager, Content content)
    {
    }

    public void onRemoveFromSoldListComplete(MyEbaySellingDataManager myebaysellingdatamanager, Content content)
    {
    }

    public void onRemoveFromUnsoldListComplete(MyEbaySellingDataManager myebaysellingdatamanager, Content content)
    {
    }

    public void onRemoveFromWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, Content content)
    {
        if (content == null)
        {
            return;
        }
        if (watchItemsActive != null)
        {
            myebaywatchingdatamanager = (EbayItemIdAndVariationSpecifics[])content.getData();
            int k = myebaywatchingdatamanager.length;
            for (int i = 0; i < k; i++)
            {
                Object obj = myebaywatchingdatamanager[i];
                watchItemsActive.remove(obj);
            }

        }
        if (watchItemsEnded != null)
        {
            myebaywatchingdatamanager = (EbayItemIdAndVariationSpecifics[])content.getData();
            int l = myebaywatchingdatamanager.length;
            for (int j = 0; j < l; j++)
            {
                Object obj1 = myebaywatchingdatamanager[j];
                watchItemsEnded.remove(obj1);
            }

        }
        Content content1 = _content;
        if (!content.getStatus().hasError())
        {
            content = (Item)_content.getData();
            content.watched = false;
            myebaywatchingdatamanager = content1;
            if (DeviceConfiguration.getAsync().get(DcsBoolean.LocalNotifications))
            {
                (new ItemCache(getContext())).deleteLocalNotificationsItem(((Item) (content)).id);
                myebaywatchingdatamanager = content1;
            }
        } else
        {
            myebaywatchingdatamanager = new Content(null, content.getStatus());
        }
        onDataChanged((Observer)dispatcher, myebaywatchingdatamanager, ActionHandled.WATCH_CHANGED, true);
    }

    public void onRemoveFromWonListComplete(MyEbayBuyingDataManager myebaybuyingdatamanager, Content content)
    {
    }

    public void onScheduledCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent)
    {
    }

    public void onScheduledListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent)
    {
    }

    public void onShippingDetailsChanged(ShippingDetailsDataManager shippingdetailsdatamanager, Content content)
    {
        dispatchExternalDmCallComplete(TaskId.EBAY_DETAILS);
        if (content != null && content.getData() != null && _content != null && _content.getData() != null)
        {
            ItemViewShipping.addShippingNamesSiteMap(((Item)_content.getData()).site, (Map)content.getData());
        }
    }

    public void onShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action, Content content)
    {
        switch (_cls1..SwitchMap.com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action[action.ordinal()])
        {
        default:
            if (!content.getStatus().hasError())
            {
                shoppingcartdatamanagerbase = (ShoppingCart)content.getData();
                if (shoppingcartdatamanagerbase != null && _content != null)
                {
                    action = (Item)_content.getData();
                    getShoppingCartHandling(content, action);
                    content = new AddToCartInfo();
                    content.buyableCount = ((ShoppingCart) (shoppingcartdatamanagerbase)).summary.totalBuyableItems;
                    content.cartId = Long.toString(((ShoppingCart) (shoppingcartdatamanagerbase)).cartId);
                    updateItemState(action);
                    content.item = new Content(action);
                    if (!inFlightTasks.contains(TaskId.GET_SHOPPING_CART))
                    {
                        handleUpdateCartResult(new Content(content));
                    }
                }
            }
            if (inFlightTasks.contains(TaskId.GET_SHOPPING_CART))
            {
                dispatchExternalDmCallComplete(TaskId.GET_SHOPPING_CART);
            }
            return;

        case 1: // '\001'
            shoppingcartdatamanagerbase = addItemToShoppingCartHandling(content);
            ((Observer)dispatcher).onCartChanged(this, shoppingcartdatamanagerbase, ActionHandled.ITEM_ADDED_TO_CART);
            return;
        }
    }

    public void onShoppingCartLoading(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action)
    {
    }

    public void onSoldCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent)
    {
    }

    public void onSoldListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent)
    {
        if (!listcontent.getStatus().hasError())
        {
            if (soldItems == null)
            {
                soldItems = new HashMap();
            } else
            {
                soldItems.clear();
            }
            myebaysellingdatamanager = listcontent.getList();
            if (myebaysellingdatamanager != null && !myebaysellingdatamanager.isEmpty())
            {
                EbayTransactedItemSpecifics ebaytransacteditemspecifics;
                for (myebaysellingdatamanager = myebaysellingdatamanager.iterator(); myebaysellingdatamanager.hasNext(); soldItems.put(ebaytransacteditemspecifics, listcontent))
                {
                    listcontent = (MyEbayListItem)myebaysellingdatamanager.next();
                    ebaytransacteditemspecifics = new EbayTransactedItemSpecifics(((MyEbayListItem) (listcontent)).id, Long.valueOf(Long.parseLong(((MyEbayListItem) (listcontent)).transaction.transactionId)), ((MyEbayListItem) (listcontent)).nameValueList);
                }

            }
        }
        if (!inFlightTasks.isEmpty())
        {
            dispatchExternalDmCallComplete(TaskId.GET_SOLDLIST);
        }
    }

    public void onTreatmentsAvailable(ExperimentationDataManager experimentationdatamanager, List list)
    {
    }

    public void onUnsoldCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent)
    {
    }

    public void onUnsoldListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent)
    {
    }

    public void onUserSignedInStatusChanged(UserContextDataManager usercontextdatamanager, String s, String s1, String s2)
    {
    }

    public void onWatchingListChanged(MyEbayWatchingDataManager myebaywatchingdatamanager, String s, DatedContent datedcontent)
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                s
            });
        }
        if ("active".equals(s) || "ended".equals(s))
        {
            if (!datedcontent.getStatus().hasError())
            {
                fillAppropriateMapForWatchlist(s, (UserDefinedList)datedcontent.getData(), "active".equals(s));
            }
            dispatchExternalDmCallComplete(TaskId.GET_WATCHLIST);
        }
    }

    public void onWonCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent)
    {
    }

    public void onWonListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent)
    {
        if (!listcontent.getStatus().hasError())
        {
            if (wonItems == null)
            {
                wonItems = new HashMap();
            } else
            {
                wonItems.clear();
            }
            myebaybuyingdatamanager = listcontent.getList();
            if (myebaybuyingdatamanager != null && !myebaybuyingdatamanager.isEmpty())
            {
                EbayTransactedItemSpecifics ebaytransacteditemspecifics;
                for (myebaybuyingdatamanager = myebaybuyingdatamanager.iterator(); myebaybuyingdatamanager.hasNext(); wonItems.put(ebaytransacteditemspecifics, listcontent))
                {
                    listcontent = (MyEbayListItem)myebaybuyingdatamanager.next();
                    ebaytransacteditemspecifics = new EbayTransactedItemSpecifics(((MyEbayListItem) (listcontent)).id, Long.valueOf(Long.parseLong(((MyEbayListItem) (listcontent)).transaction.transactionId)), ((MyEbayListItem) (listcontent)).nameValueList);
                }

            }
        }
        dispatchExternalDmCallComplete(TaskId.GET_WONLIST);
    }

    public void placeOffer(EbayTradingApi ebaytradingapi, long l, String s, ItemCurrency itemcurrency, int i, ArrayList arraylist, 
            String s1, String s2, boolean flag, ItemCurrency itemcurrency1)
    {
        placeOffer(ebaytradingapi, l, s, itemcurrency, i, arraylist, s1, s2, flag, itemcurrency1, null, null, false, false);
    }

    public void placeOffer(EbayTradingApi ebaytradingapi, long l, String s, ItemCurrency itemcurrency, int i, ArrayList arraylist, 
            String s1, String s2, boolean flag, ItemCurrency itemcurrency1, String s3, String s4, boolean flag1, 
            boolean flag2)
    {
        NautilusKernel.verifyMain();
        if (placeOfferTask != null)
        {
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        if (PlaceOfferRequest.AVAILABLE_ACTIONS.contains(s))
        {
            break MISSING_BLOCK_LABEL_131;
        }
        throw new IllegalArgumentException((new StringBuilder()).append("Invalid action: ").append(s).toString());
        ebaytradingapi;
        s = new ResultStatusOwner();
        itemcurrency = new EbayResponseError();
        itemcurrency.severity = 1;
        itemcurrency.longMessage = ebaytradingapi.getMessage();
        s.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
            itemcurrency
        });
        ((Observer)dispatcher).onPlaceOfferCompleted(this, new Content(null, s.getResultStatus()));
        return;
        if (ItemCurrency.isEmpty(itemcurrency))
        {
            throw new NullPointerException("bid");
        }
        if ((s.equals("Accept") || s.equals("Decline") || s.equals("Counter")) && TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("bestOfferId required");
        } else
        {
            placeOfferTask = new PlaceOfferTask(ebaytradingapi, l, s, itemcurrency, i, arraylist, s1, s2, flag, itemcurrency1, s3, s4, flag1, flag2);
            executeOnThreadPool(placeOfferTask, new Content[] {
                _content
            });
            return;
        }
    }

    public void refreshCart(ViewItemViewData viewitemviewdata)
    {
        NautilusKernel.verifyMain();
        viewDataMap.put(params, viewitemviewdata);
        shoppingCartDataManager.loadData(false, this);
    }

    public void respondToBestOffer(EbayTradingApi ebaytradingapi, String s, long l, long l1, String s1, 
            Double double1, String s2, int i)
    {
        NautilusKernel.verifyMain();
        if (respondBestOfferTask == null)
        {
            respondBestOfferTask = new RespondBestOfferTask(ebaytradingapi, s, l, l1, s1, double1, s2, i);
            executeOnThreadPool(respondBestOfferTask, new Content[] {
                _content
            });
        }
    }

    public void sellerEndItem(EbayTradingApi ebaytradingapi, long l, String s)
    {
        NautilusKernel.verifyMain();
        if (endItemTask != null)
        {
            return;
        } else
        {
            endItemTask = new EndItemTask(ebaytradingapi, l, s);
            executeOnThreadPool(endItemTask, new Void[0]);
            return;
        }
    }

    public final void setBidItemMaxPrice(long l, List list, ItemCurrency itemcurrency)
    {
        if (bidItems == null)
        {
            bidItems = new HashMap();
        }
        Object obj = new EbayItemIdAndVariationSpecifics(l, list);
        obj = (MyEbayListItem)bidItems.get(obj);
        if (obj != null)
        {
            obj.maxBidPrice = itemcurrency;
            return;
        } else
        {
            MyEbayListItem myebaylistitem = new MyEbayListItem();
            myebaylistitem.id = l;
            myebaylistitem.maxBidPrice = itemcurrency;
            list = new EbayItemIdAndVariationSpecifics(l, list);
            bidItems.put(list, myebaylistitem);
            return;
        }
    }

    protected final void setCurrentAndConvertedPrice(CurrencyAmount currencyamount, CurrencyConversionRate currencyconversionrate, Item item)
    {
        if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
        {
            FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[0]);
        }
        item.currentPrice = currencyamount.toItemCurrency();
        currencyconversionrate = Item.convertCurrency(getEbayContext(), item.currentPrice, currencyconversionrate);
        currencyamount = currencyconversionrate;
        if (currencyconversionrate == null)
        {
            currencyamount = item.currentPrice;
        }
        item.convertedCurrentPrice = currencyamount;
    }

    public void setPaymentReminderStatusToSent(ArrayList arraylist)
    {
        NautilusKernel.verifyMain();
        executeOnThreadPool(new SetPaymentReminderStatusTask(arraylist), new Content[] {
            _content
        });
    }

    public boolean watchItem(Observer observer, EbayItemIdAndVariationSpecifics ebayitemidandvariationspecifics, boolean flag)
    {
        NautilusKernel.verifyMain();
        boolean flag2 = false;
        boolean flag1 = flag2;
        if (auth != null)
        {
            flag1 = flag2;
            if (myEbayWatchingDataManager != null)
            {
                if (flag)
                {
                    myEbayWatchingDataManager.addToWatchList(this, new EbayItemIdAndVariationSpecifics[] {
                        ebayitemidandvariationspecifics
                    });
                } else
                {
                    myEbayWatchingDataManager.removeFromWatchList(this, new EbayItemIdAndVariationSpecifics[] {
                        ebayitemidandvariationspecifics
                    });
                }
                flag1 = true;
            }
        }
        return flag1;
    }





























/*
    static PostViewItemLite access$3102(ViewItemDataManager viewitemdatamanager, PostViewItemLite postviewitemlite)
    {
        viewitemdatamanager.postViewItemLite = postviewitemlite;
        return postviewitemlite;
    }

*/

















}
