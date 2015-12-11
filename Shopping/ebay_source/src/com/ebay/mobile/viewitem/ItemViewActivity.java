// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.android.widget.ImageViewPager;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.DeepLinkUtil;
import com.ebay.common.Preferences;
import com.ebay.common.content.dm.AdRtmDataManager;
import com.ebay.common.model.AllBiddersData;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.common.model.mdns.PlatformNotificationsEvent;
import com.ebay.common.net.api.local.EbayNowInventoryLookupDataManager;
import com.ebay.common.rtm.RtmHelper;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.CheckoutItem;
import com.ebay.mobile.Item;
import com.ebay.mobile.ItemViewPayPalable;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.NfcCompat;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.Vehicle;
import com.ebay.mobile.activities.AddEditTrackingInfoActivity;
import com.ebay.mobile.activities.AdsWebViewActivity;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.EbnOrderDetailsActivity;
import com.ebay.mobile.activities.ErrorDialogActivity;
import com.ebay.mobile.activities.MyEbayLandingActivity;
import com.ebay.mobile.activities.PaisaPayWebViewActivity;
import com.ebay.mobile.activities.ReturnParamsWebViewActivity;
import com.ebay.mobile.activities.SignInActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.ads.GoogleTextAdLoader;
import com.ebay.mobile.ads.NativeAdLoader;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.appspeed.AppSpeedShim;
import com.ebay.mobile.bestoffer.BuyerMakeOfferActivity;
import com.ebay.mobile.bestoffer.BuyerRespondToCounterofferActivity;
import com.ebay.mobile.checkout.AddressListActivity;
import com.ebay.mobile.checkout.BaseCheckoutActivity;
import com.ebay.mobile.checkout.CheckoutActivity;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.mobile.common.eBayRating;
import com.ebay.mobile.connection.myebay.MyEbayBuyingActivity;
import com.ebay.mobile.connection.myebay.MyEbayWatchingActivity;
import com.ebay.mobile.crashlytics.CrashlyticsWrapper;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.dcs.DcsInteger;
import com.ebay.mobile.experimentation.Experiments;
import com.ebay.mobile.merch.MerchandiseFragment;
import com.ebay.mobile.myebay.ReminderItemsActivity;
import com.ebay.mobile.notifications.EbaySmartNotificationManager;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.notifications.NotificationTrackingUtil;
import com.ebay.mobile.notifications.PollService;
import com.ebay.mobile.search.SellerOfferResultFragmentActivity;
import com.ebay.mobile.sell.ListingFragmentActivity;
import com.ebay.mobile.sell.lists.SellingListActivity;
import com.ebay.mobile.sell.widget.TextImageButton;
import com.ebay.mobile.share.ShareItemsUtil;
import com.ebay.mobile.shoppingcart.ShoppingCartActivity;
import com.ebay.mobile.sitespeed.SiteSpeedActivityUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.AdUtil;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.LocationUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.mobile.viewitem.fragments.AboutSellerFragment;
import com.ebay.mobile.viewitem.fragments.MultiSkuCallback;
import com.ebay.mobile.viewitem.fragments.ViewItemActionsFragment;
import com.ebay.mobile.viewitem.fragments.ViewItemBiddingHistoryFragment;
import com.ebay.mobile.viewitem.fragments.ViewItemChooseVariationsFragment;
import com.ebay.mobile.viewitem.fragments.ViewItemShippingPaymentsReturnsFragment;
import com.ebay.mobile.viewitem.fragments.ViewItemSpecificsFragment;
import com.ebay.mobile.viewitem.fragments.ViewItemTitleAndPriceFragment;
import com.ebay.mobile.widget.EbayScrollView;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.BestOffer;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.EbayItemIdAndVariationSpecifics;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.data.ProductListingDetails;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.image.ConstructDipUrl;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.DelimitedStringBuilder;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.kernel.util.NumberUtil;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.shared.ui.FloatingActionBarScrollListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.maps.model.LatLng;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ViewItemDataManager, ViewItemViewData, ViewItemChooseVariationsActivity, 
//            ItemViewLeaveFeedbackActivity, ItemViewCommonProgressAndError, PpaUpgradeConfirmDialog, ItemViewBiddingActivity, 
//            ViewItemConfirmActivity, ViewItemShippingPaymentsReturnsActivity, ItemViewGetQuantityActivity, ItemViewDescriptionActivity, 
//            ItemViewCompatibilityActivity, ProductReviewsActivity, ViewItemPlaceBidActivity, ItemViewPlaceOfferActivity

public class ItemViewActivity extends ItemViewBaseActivity
    implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, android.view.View.OnClickListener, DialogFragmentCallback, com.ebay.common.net.api.local.EbayNowInventoryLookupDataManager.Observer, com.ebay.mobile.NfcCompat.OnBeamPushListener, ViewItemDataManager.Observer, MultiSkuCallback, com.ebay.mobile.viewitem.fragments.ViewItemActionsFragment.PaymentOptionsHandler, com.ebay.mobile.widget.EbayScrollView.OnScrollChangedListener
{
    private class AdRtmDataManagerObserver
        implements com.ebay.common.content.dm.AdRtmDataManager.Observer
    {

        final ItemViewActivity this$0;

        public void onAdsContextReady(List list, com.ebay.common.content.dm.AdRtmDataManager.AdRequestType adrequesttype)
        {
        }

        public void onAdsReady(RtmHelper rtmhelper, com.ebay.common.content.dm.AdRtmDataManager.AdRequestType adrequesttype)
        {
            if (AdUtil.logDfpAds.isLoggable)
            {
                FwLog.logMethod(AdUtil.logDfpAds, new Object[] {
                    adrequesttype
                });
            }
            if (!isFinishing()) goto _L2; else goto _L1
_L1:
            return;
_L2:
            static class _cls12
            {

                static final int $SwitchMap$com$ebay$common$content$dm$AdRtmDataManager$AdRequestType[];
                static final int $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[];
                static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

                static 
                {
                    $SwitchMap$com$ebay$common$content$dm$AdRtmDataManager$AdRequestType = new int[com.ebay.common.content.dm.AdRtmDataManager.AdRequestType.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$common$content$dm$AdRtmDataManager$AdRequestType[com.ebay.common.content.dm.AdRtmDataManager.AdRequestType.DISPLAY.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror49) { }
                    try
                    {
                        $SwitchMap$com$ebay$common$content$dm$AdRtmDataManager$AdRequestType[com.ebay.common.content.dm.AdRtmDataManager.AdRequestType.PLA.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror48) { }
                    try
                    {
                        $SwitchMap$com$ebay$common$content$dm$AdRtmDataManager$AdRequestType[com.ebay.common.content.dm.AdRtmDataManager.AdRequestType.NONE.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror47) { }
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[ViewItemDataManager.ActionHandled.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.ITEM_ADDED_TO_CART.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror46) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.CART_UPDATED.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror45) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror44) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.WATCH_CHANGED.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror43) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.ITEM_ENDED_BY_SELLER.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror42) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.SHIPMENT_TRACKING.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror41) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.MARK_PAID_OR_UNPAID.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror40) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.GET_ITEM_FLAGS_REFRESHED.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror39) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.BOPIS_AVAILABILITY.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror38) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.MARK_SHIPPED_OR_UNSHIPPED.ordinal()] = 10;
                    }
                    catch (NoSuchFieldError nosuchfielderror37) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.CURRENCY_RATE_UPDATED.ordinal()] = 11;
                    }
                    catch (NoSuchFieldError nosuchfielderror36) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.BIDDING_HISTORY.ordinal()] = 12;
                    }
                    catch (NoSuchFieldError nosuchfielderror35) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.BID_CHANGE.ordinal()] = 13;
                    }
                    catch (NoSuchFieldError nosuchfielderror34) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.PAYMENT_REMINDER_SENT.ordinal()] = 14;
                    }
                    catch (NoSuchFieldError nosuchfielderror33) { }
                    $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction = new int[UserAction.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.SELL_LIKE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror32) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.END_ITEM.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror31) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.MARK_SHIPPED.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror30) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.MARK_NOT_SHIPPED.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror29) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.TRACK_PACKAGE.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror28) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.EDIT_PACKAGE_TRACKING.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror27) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.ENTER_PACKAGE_TRACKING.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror26) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.LEAVE_FEEDBACK.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror25) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.MARK_AS_PAID.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror24) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.MARK_AS_UNPAID.ordinal()] = 10;
                    }
                    catch (NoSuchFieldError nosuchfielderror23) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.RELIST.ordinal()] = 11;
                    }
                    catch (NoSuchFieldError nosuchfielderror22) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.REVISE.ordinal()] = 12;
                    }
                    catch (NoSuchFieldError nosuchfielderror21) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.SHARE.ordinal()] = 13;
                    }
                    catch (NoSuchFieldError nosuchfielderror20) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.BUYING_OPTIONS.ordinal()] = 14;
                    }
                    catch (NoSuchFieldError nosuchfielderror19) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.BIDDING_ACTIVITY.ordinal()] = 15;
                    }
                    catch (NoSuchFieldError nosuchfielderror18) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.PLACE_BID.ordinal()] = 16;
                    }
                    catch (NoSuchFieldError nosuchfielderror17) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.PLACE_BID_AMOUNT.ordinal()] = 17;
                    }
                    catch (NoSuchFieldError nosuchfielderror16) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.BUY_IT_NOW.ordinal()] = 18;
                    }
                    catch (NoSuchFieldError nosuchfielderror15) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.BUY_ANOTHER.ordinal()] = 19;
                    }
                    catch (NoSuchFieldError nosuchfielderror14) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.WATCH.ordinal()] = 20;
                    }
                    catch (NoSuchFieldError nosuchfielderror13) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.UNWATCH.ordinal()] = 21;
                    }
                    catch (NoSuchFieldError nosuchfielderror12) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.BUYER_REVIEW_OFFER.ordinal()] = 22;
                    }
                    catch (NoSuchFieldError nosuchfielderror11) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.ADD_TO_CART.ordinal()] = 23;
                    }
                    catch (NoSuchFieldError nosuchfielderror10) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.VIEW_CART.ordinal()] = 24;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.PAY_NOW.ordinal()] = 25;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.PAYMENT_OPTIONS.ordinal()] = 26;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.VIEW_RELISTED_ITEM.ordinal()] = 27;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.EBN_ORDER_DETAILS.ordinal()] = 28;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.NONE.ordinal()] = 29;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.SPR.ordinal()] = 30;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.CHANGE_ADDRESS.ordinal()] = 31;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.MAKE_OFFER.ordinal()] = 32;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[UserAction.PLUS_SIGNUP.ordinal()] = 33;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls12..SwitchMap.com.ebay.common.content.dm.AdRtmDataManager.AdRequestType[adrequesttype.ordinal()])
            {
            default:
                return;

            case 2: // '\002'
                continue; /* Loop/switch isn't completed */

            case 1: // '\001'
                if (rtmhelper != null)
                {
                    adCampaignId = rtmhelper.getCampaignId();
                    adrequesttype = getDisplayAdViewToMeasure();
                    if (adrequesttype != null)
                    {
                        adrequesttype.post(rtmhelper. new Runnable() {

                            final AdRtmDataManagerObserver this$1;
                            final RtmHelper val$result;

                            public void run()
                            {
                                renderDisplayAdsView(result.getAds());
                            }

            
            {
                this$1 = final_adrtmdatamanagerobserver;
                result = RtmHelper.this;
                super();
            }
                        });
                        return;
                    }
                } else
                {
                    adCampaignId = null;
                    showDisplayAdsView(false);
                    return;
                }
                break;
            }
            continue; /* Loop/switch isn't completed */
            if (rtmhelper == null) goto _L1; else goto _L3
_L3:
            adsPla = rtmhelper.getAds();
            renderPlaAds(adsPla);
            return;
            if (true) goto _L1; else goto _L4
_L4:
        }

        private AdRtmDataManagerObserver()
        {
            this$0 = ItemViewActivity.this;
            super();
        }

    }

    private class AddressDataManagerObserver extends com.ebay.nautilus.domain.content.dm.AddressDataManager.SimpleObserver
    {

        final ItemViewActivity this$0;

        public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
        {
            if (!isFinishing())
            {
                if (content.getStatus().hasError())
                {
                    shippingAddresses = null;
                } else
                {
                    shippingAddresses = (List)content.getData();
                }
                viewData.primaryAddress = ViewItemDataManager.getPrimaryAddress(MyApp.getPrefs().getAuthentication(), shippingAddresses);
                viewData.shippingCostsPostalCode = ItemViewActivity.getShippingCostsPostalCode(viewData);
                showHideTranslucentProgress(true, true);
                if (sprFragment != null)
                {
                    sprFragment.setForceReRender();
                }
                viewItemDataManager.loadData(ItemViewActivity.this, viewData);
                if (flag)
                {
                    BaseCheckoutActivity.handleDefaultAddressChange(ItemViewActivity.this, (UserContextDataManager)DataManager.get(getEbayContext(), UserContextDataManager.KEY), shippingAddresses, true, "ViewItem");
                    return;
                }
            }
        }

        private AddressDataManagerObserver()
        {
            this$0 = ItemViewActivity.this;
            super();
        }

    }

    public static final class UserAction extends Enum
    {

        private static final UserAction $VALUES[];
        public static final UserAction ADD_TO_CART;
        public static final UserAction BIDDING_ACTIVITY;
        public static final UserAction BUYER_REVIEW_OFFER;
        public static final UserAction BUYING_OPTIONS;
        public static final UserAction BUY_ANOTHER;
        public static final UserAction BUY_IT_NOW;
        public static final UserAction CHANGE_ADDRESS;
        public static final UserAction EBN_ORDER_DETAILS;
        public static final UserAction EDIT_PACKAGE_TRACKING;
        public static final UserAction END_ITEM;
        public static final UserAction ENTER_PACKAGE_TRACKING;
        public static final UserAction LEAVE_FEEDBACK;
        public static final UserAction MAKE_OFFER;
        public static final UserAction MARK_AS_PAID;
        public static final UserAction MARK_AS_UNPAID;
        public static final UserAction MARK_NOT_SHIPPED;
        public static final UserAction MARK_SHIPPED;
        public static final UserAction NONE;
        public static final UserAction ORDER_SUMMARY;
        public static final UserAction PAYMENT_OPTIONS;
        public static final UserAction PAY_NOW;
        public static final UserAction PLACE_BID;
        public static final UserAction PLACE_BID_AMOUNT;
        public static final UserAction PLUS_SIGNUP;
        public static final UserAction RELIST;
        public static final UserAction REVISE;
        public static final UserAction SELL_LIKE;
        public static final UserAction SHARE;
        public static final UserAction SPR;
        public static final UserAction TRACK_PACKAGE;
        public static final UserAction UNWATCH;
        public static final UserAction VIEW_CART;
        public static final UserAction VIEW_RELISTED_ITEM;
        public static final UserAction WATCH;

        public static UserAction valueOf(String s)
        {
            return (UserAction)Enum.valueOf(com/ebay/mobile/viewitem/ItemViewActivity$UserAction, s);
        }

        public static UserAction[] values()
        {
            return (UserAction[])$VALUES.clone();
        }

        static 
        {
            NONE = new UserAction("NONE", 0);
            BIDDING_ACTIVITY = new UserAction("BIDDING_ACTIVITY", 1);
            PLACE_BID = new UserAction("PLACE_BID", 2);
            PLACE_BID_AMOUNT = new UserAction("PLACE_BID_AMOUNT", 3);
            BUY_IT_NOW = new UserAction("BUY_IT_NOW", 4);
            BUY_ANOTHER = new UserAction("BUY_ANOTHER", 5);
            WATCH = new UserAction("WATCH", 6);
            UNWATCH = new UserAction("UNWATCH", 7);
            SELL_LIKE = new UserAction("SELL_LIKE", 8);
            END_ITEM = new UserAction("END_ITEM", 9);
            MARK_SHIPPED = new UserAction("MARK_SHIPPED", 10);
            MARK_NOT_SHIPPED = new UserAction("MARK_NOT_SHIPPED", 11);
            MAKE_OFFER = new UserAction("MAKE_OFFER", 12);
            BUYER_REVIEW_OFFER = new UserAction("BUYER_REVIEW_OFFER", 13);
            ADD_TO_CART = new UserAction("ADD_TO_CART", 14);
            VIEW_CART = new UserAction("VIEW_CART", 15);
            PAY_NOW = new UserAction("PAY_NOW", 16);
            PAYMENT_OPTIONS = new UserAction("PAYMENT_OPTIONS", 17);
            TRACK_PACKAGE = new UserAction("TRACK_PACKAGE", 18);
            ENTER_PACKAGE_TRACKING = new UserAction("ENTER_PACKAGE_TRACKING", 19);
            EDIT_PACKAGE_TRACKING = new UserAction("EDIT_PACKAGE_TRACKING", 20);
            LEAVE_FEEDBACK = new UserAction("LEAVE_FEEDBACK", 21);
            MARK_AS_PAID = new UserAction("MARK_AS_PAID", 22);
            MARK_AS_UNPAID = new UserAction("MARK_AS_UNPAID", 23);
            RELIST = new UserAction("RELIST", 24);
            VIEW_RELISTED_ITEM = new UserAction("VIEW_RELISTED_ITEM", 25);
            REVISE = new UserAction("REVISE", 26);
            SHARE = new UserAction("SHARE", 27);
            BUYING_OPTIONS = new UserAction("BUYING_OPTIONS", 28);
            ORDER_SUMMARY = new UserAction("ORDER_SUMMARY", 29);
            EBN_ORDER_DETAILS = new UserAction("EBN_ORDER_DETAILS", 30);
            SPR = new UserAction("SPR", 31);
            CHANGE_ADDRESS = new UserAction("CHANGE_ADDRESS", 32);
            PLUS_SIGNUP = new UserAction("PLUS_SIGNUP", 33);
            $VALUES = (new UserAction[] {
                NONE, BIDDING_ACTIVITY, PLACE_BID, PLACE_BID_AMOUNT, BUY_IT_NOW, BUY_ANOTHER, WATCH, UNWATCH, SELL_LIKE, END_ITEM, 
                MARK_SHIPPED, MARK_NOT_SHIPPED, MAKE_OFFER, BUYER_REVIEW_OFFER, ADD_TO_CART, VIEW_CART, PAY_NOW, PAYMENT_OPTIONS, TRACK_PACKAGE, ENTER_PACKAGE_TRACKING, 
                EDIT_PACKAGE_TRACKING, LEAVE_FEEDBACK, MARK_AS_PAID, MARK_AS_UNPAID, RELIST, VIEW_RELISTED_ITEM, REVISE, SHARE, BUYING_OPTIONS, ORDER_SUMMARY, 
                EBN_ORDER_DETAILS, SPR, CHANGE_ADDRESS, PLUS_SIGNUP
            });
        }

        private UserAction(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Map ACTION_BUTTON_IDS = Collections.unmodifiableMap(new HashMap() {

        private static final long serialVersionUID = 1L;

            
            {
                put(UserAction.ENTER_PACKAGE_TRACKING, Integer.valueOf(0x7f100887));
                put(UserAction.EDIT_PACKAGE_TRACKING, Integer.valueOf(0x7f100888));
            }
    });
    public static final int ACTIVITY_RESULTS_MULTISKU_ACTION_DO_ADD_TO_CART = 9;
    public static final int ACTIVITY_RESULTS_SHIPPING_PAGE = 16;
    public static final int ACTIVITY_RESULTS_VIEW_CART = 17;
    private static final int ACTIVITY_RESULT_ADD_OR_EDIT_TRACKING_NUMBER = 5;
    private static final int ACTIVITY_RESULT_BUYER_MAKE_OFFER = 7;
    private static final int ACTIVITY_RESULT_BUYER_RESPOND_TO_COUNTEROFFER = 8;
    private static final int ACTIVITY_RESULT_CHANGE_SHIP_ADDRESS = 15;
    public static final int ACTIVITY_RESULT_CONFIRM = 12;
    static final int ACTIVITY_RESULT_EBAY_PLUS_SIGNUP = 21;
    private static final int ACTIVITY_RESULT_GET_QUANTITY = 13;
    static final int ACTIVITY_RESULT_ITEM_ENDED = 20;
    private static final int ACTIVITY_RESULT_LEAVE_FEEDBACK = 1;
    public static final int ACTIVITY_RESULT_MULTISKU_ACTION_DO_BIN = 3;
    public static final int ACTIVITY_RESULT_MULTISKU_ACTION_SPR = 4;
    public static final int ACTIVITY_RESULT_MULTISKU_ACTION_WATCH = 2;
    private static final int ACTIVITY_RESULT_PLACE_OFFER = 18;
    private static final int ACTIVITY_RESULT_RELIST = 10;
    public static final int ACTIVITY_RESULT_SIGN_IN = 11;
    public static final int ACTIVITY_RESULT_SPR = 19;
    private static final int ACTIVITY_RESULT_TRACK_PACKAGE = 6;
    private static final int ACTIVITY_RESULT_XO = 14;
    private static final int EBAY_PLUS_SIGNUP_SUCCESS_ID = 7;
    private static final int ENTER_TRACKING_ID = 6;
    private static final int ERROR_ID_MARK_PAID = 2;
    private static final int ERROR_ID_MARK_SHIPPED = 1;
    private static final int ERROR_ID_UNKNOWN = 666;
    private static final int ERROR_ID_WATCH_CHANGED = 3;
    public static final String INTENT_KEY_EBAY_PLUS_SIGNUP = "eplus";
    private static final int ITEM_DOES_NOT_SHIP_TO_YOU_ID = 5;
    private static final int MARK_AS_PAID_ID = 1;
    private static final int MARK_AS_SHIPPED_ID = 3;
    private static final int MARK_AS_UNPAID_ID = 2;
    private static final int MARK_AS_UNSHIPPED_ID = 4;
    private static final int MAX_BUY_BAR_BUTTONS = 2;
    public static final String PARAM_AUCTION_ENDED_OVERRIDE = "auction_ended_override";
    public static final String PARAM_CONDENSED_STATE = "condensed_state";
    public static final String PARAM_EBAY_LIST_ITEM = "ebay_list_item";
    public static final String PARAM_FEED_INTEREST_ID = "feed_interest_id";
    public static final String PARAM_INIT_LOAD_COMPLETE = "param_initial_load_complete";
    public static final String PARAM_IS_SELLERS_OTHER_ITEM = "is_sellers_other_item";
    public static final String PARAM_ITEM_END_DATE = "item_view_end_date";
    public static final String PARAM_ITEM_FEEDBACK_LEFT = "item_view_feedback_left";
    private static final String PARAM_ITEM_FROM_EBN_ORDER_DETAILS = "item_view_from_ebn_order_details";
    public static final String PARAM_ITEM_FROM_MY_EBAY_OR_REMINDERS = "item_view_from_my_ebay_or_reminders";
    private static final String PARAM_ITEM_FROM_ORDERS = "item_view_from_order_summary";
    public static final String PARAM_ITEM_ID = "item_view_id";
    public static final String PARAM_ITEM_KIND = "item_view_kind";
    public static final String PARAM_ITEM_ORIGINAL_RETAIL_PRICE = "item_view_original_retail_price";
    public static final String PARAM_ITEM_PRICING_TREATMENT = "item_view_pricing_treatment";
    public static final String PARAM_ITEM_SAVINGS_RATE = "item_view_savings_rate";
    private static final String PARAM_LAYOUT_STATE = "layout_state";
    public static final String PARAM_MERCH_REQUESTED = "merch_requested";
    public static final String PARAM_PLA_OR_TEXT_ADS = "pla_or_text_ads";
    private static final String PARAM_REFINED_POSTAL_CODE = "item_view_refined_postal_code";
    private static final String PARAM_REFINED_SEARCH_OTHER_COUNTRIES = "item_view_refined_search_other_countries";
    public static final String PARAM_REFRESH_BOOLEAN = "refresh_item";
    private static final String PARAM_SCROLL_Y = "scrollY";
    public static final String PARAM_SHOP_LOCALLY_REFINEMENT = "shop_locally_refinement";
    private static final String PARAM_STORE_FROM_ORDERS = "item_view_store_from_order_summary";
    public static final String PARAM_TRANSACTION_ID_AS_LONG = "item_view_tx_id";
    public static final String PARAM_UNIT_TEST = "item_view_unit_test";
    public static final String PARAM_USER_ACTION = "user_action";
    public static final String PARAM_VARIATION_VALUES = "param_variation_values";
    public static final String PARAM_VIEW_DATA = "param_view_data";
    public static final int REFINEMENT_TYPE_EBAY_NOW = 1;
    public static final int REFINEMENT_TYPE_PICKUP = 2;
    private static final com.ebay.common.content.dm.AdRtmDataManager.KeyParams adRtmDataManagerKey = new com.ebay.common.content.dm.AdRtmDataManager.KeyParams();
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("VIP", 3, "Log VIP");
    private AboutSellerFragment aboutSellerFragment;
    private ViewItemActionsFragment actionsFragment;
    private String adCampaignId;
    private AdRtmDataManager adRtmDataManager;
    private AdRtmDataManagerObserver adRtmDmObserver;
    private View adView;
    private AddressDataManager addressDataManager;
    private AddressDataManagerObserver addressDmObserver;
    private android.view.View.OnClickListener adsClickListener;
    public List adsPla;
    private String bidSource;
    private ViewItemBiddingHistoryFragment biddingHistoryFragment;
    private View buyItNowBottomButton;
    private TextImageButton cartButton;
    private TextView compatibleWithGarageList;
    private View compatibleWithLayout;
    private View descriptionLayout;
    private boolean forceMerch;
    private boolean fromEbnOrderDetails;
    public boolean fromMyEbayOrReminders;
    private boolean fromOrderSummary;
    private SearchAdView googleTextAdView;
    private int headerColor;
    private boolean incrementalBid;
    private boolean initialLoadComplete;
    private InventoryInfo inventoryInfo;
    private EbayNowInventoryLookupDataManager inventoryLookupDM;
    private boolean isAdsEnabledDisplay;
    private boolean isAdsEnabledGoogleText;
    private boolean isAdsEnabledPLA;
    private boolean isAuctionEndedOverride;
    private Boolean isCondensedView;
    private boolean isPullToRefresh;
    private boolean isUnitTest;
    private long itemId;
    private ViewItemSpecificsFragment itemSpecificsFragment;
    private ItemViewCommonProgressAndError.LayoutState layoutState;
    private MerchandiseFragment merchFragment;
    private volatile boolean merchRequested;
    private View productDetailsLayout;
    private final UserAction promotedAction;
    private boolean redirectPrevious;
    private String referrer;
    private Button retryButton;
    private TextView reviewsCount;
    private View reviewsLayout;
    private eBayRating reviewsRating;
    private int searchResultsRank;
    private List shippingAddresses;
    private boolean shouldSaveScrollPosition;
    private ViewItemShippingPaymentsReturnsFragment sprFragment;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ViewItemTitleAndPriceFragment titleAndPriceFragment;
    private Long transactionId;
    private final android.view.View.OnLayoutChangeListener updateBottomPaddingOnLayoutChange = new android.view.View.OnLayoutChangeListener() {

        final ItemViewActivity this$0;

        public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
                int k1, int l1)
        {
            Activity activity = (Activity)view.getContext();
            if (activity != null)
            {
                i = activity.getResources().getDimensionPixelSize(0x7f090072);
                final View scrollViewContent = activity.findViewById(0x7f1002f6);
                if ((ScrollView)activity.findViewById(0x7f100017) != null && scrollViewContent != null)
                {
                    if (view.isShown())
                    {
                        i = view.getHeight() + i;
                    } else
                    {
                        i = 0;
                    }
                    scrollViewContent.post(i. new Runnable() {

                        final _cls2 this$1;
                        final int val$bottomPadding;
                        final View val$scrollViewContent;

                        public void run()
                        {
                            scrollViewContent.setPadding(0, 0, 0, bottomPadding);
                        }

            
            {
                this$1 = final__pcls2;
                scrollViewContent = view;
                bottomPadding = I.this;
                super();
            }
                    });
                }
            }
        }

            
            {
                this$0 = ItemViewActivity.this;
                super();
            }
    };
    private UserAction userAction;
    private ViewItemChooseVariationsFragment variationsFragment;

    public ItemViewActivity()
    {
        userAction = UserAction.NONE;
        promotedAction = UserAction.NONE;
        layoutState = ItemViewCommonProgressAndError.LayoutState.PROGRESS;
        redirectPrevious = false;
        searchResultsRank = -1;
        incrementalBid = false;
        fromMyEbayOrReminders = false;
        fromOrderSummary = false;
        fromEbnOrderDetails = false;
        initialLoadComplete = false;
        shouldSaveScrollPosition = true;
        shippingAddresses = null;
        merchRequested = false;
        forceMerch = false;
    }

    private void CreateAndSubmitWatchTask(boolean flag, List list)
    {
        if (viewItemDataManager != null && viewItemDataManager.watchItem(this, new EbayItemIdAndVariationSpecifics(item.id, list), flag))
        {
            showHideTranslucentProgress(true, true);
        }
    }

    public static void StartActivity(Activity activity, long l, com.ebay.common.ConstantsCommon.ItemKind itemkind)
    {
        invalidateCache(l, (Long)null);
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewActivity);
        intent.putExtra("item_view_id", l);
        intent.putExtra("item_view_kind", itemkind.toString());
        activity.startActivity(intent);
    }

    public static void StartActivity(Activity activity, long l, com.ebay.common.ConstantsCommon.ItemKind itemkind, Intent intent)
    {
        invalidateCache(l, (Long)null);
        if (activity != null)
        {
            Intent intent1 = new Intent(activity, com/ebay/mobile/viewitem/ItemViewActivity);
            intent1.putExtra("item_view_id", l);
            intent1.putExtra("item_view_kind", itemkind.toString());
            intent1.putExtras(intent);
            activity.startActivity(intent1);
        }
    }

    public static void StartActivity(Activity activity, long l, String s, com.ebay.common.ConstantsCommon.ItemKind itemkind)
    {
        invalidateCache(l, s);
        StartActivity(activity, l, s, itemkind, ((InventoryInfo) (null)));
    }

    public static void StartActivity(Activity activity, long l, String s, com.ebay.common.ConstantsCommon.ItemKind itemkind, InventoryInfo inventoryinfo)
    {
        boolean flag = true;
        invalidateCache(l, s);
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewActivity);
        intent.putExtra("item_view_id", l);
        intent.putExtra("item_view_kind", itemkind.toString());
        intent.putExtra("transaction_id", s);
        intent.putExtra("item_view_feedback_left", true);
        if (inventoryinfo == null)
        {
            flag = false;
        }
        intent.putExtra("item_view_from_order_summary", flag);
        intent.putExtra("item_view_store_from_order_summary", inventoryinfo);
        activity.startActivity(intent);
    }

    public static void StartActivity(Activity activity, long l, Date date, com.ebay.common.ConstantsCommon.ItemKind itemkind, String s, String s1, int i, 
            String s2, boolean flag, boolean flag1, boolean flag2, ItemCurrency itemcurrency, boolean flag3)
    {
        Intent intent;
        invalidateCache(l, (Long)null);
        intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewActivity);
        intent.putExtra("item_view_id", l);
        intent.putExtra("item_view_kind", itemkind.toString());
        if (date != null)
        {
            intent.putExtra("item_view_end_date", date.getTime());
        }
        intent.putExtra("com.ebay.mobile.tracking.BidSource", s1);
        intent.putExtra("com.ebay.mobile.tracking.Referrer", s);
        if (i > 0)
        {
            intent.putExtra("com.ebay.mobile.tracking.SearchResultsRank", i);
        }
        if (itemcurrency != null)
        {
            intent.putExtra("item_view_original_retail_price", itemcurrency);
            intent.putExtra("item_view_pricing_treatment", "STP");
        }
        if (flag3)
        {
            intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("SearchResults", "plus"));
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        intent.putExtra("shop_locally_refinement", 2);
_L4:
        if (s2 != null)
        {
            intent.putExtra("item_view_refined_postal_code", s2);
        }
        intent.putExtra("item_view_refined_search_other_countries", flag2);
        activity.startActivity(intent);
        return;
_L2:
        if (flag1)
        {
            intent.putExtra("shop_locally_refinement", 1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void StartActivity(Activity activity, com.ebay.common.ConstantsCommon.ItemKind itemkind, long l, String s, String s1)
    {
        invalidateCache(l, (Long)null);
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewActivity);
        intent.putExtra("com.ebay.mobile.tracking.Referrer", s);
        intent.putExtra("com.ebay.mobile.tracking.BidSource", s1);
        intent.putExtra("item_view_id", l);
        if (itemkind == com.ebay.common.ConstantsCommon.ItemKind.SellersOther)
        {
            intent.putExtra("item_view_kind", com.ebay.common.ConstantsCommon.ItemKind.Found.toString());
            intent.putExtra("is_sellers_other_item", true);
        } else
        {
            intent.putExtra("item_view_kind", itemkind.toString());
            intent.setFlags(0x4000000);
        }
        activity.startActivity(intent);
    }

    public static void StartActivity(Activity activity, MyEbayListItem myebaylistitem, com.ebay.common.ConstantsCommon.ItemKind itemkind, String s, SourceIdentification sourceidentification)
    {
        StartActivity(activity, myebaylistitem, itemkind, s, false, sourceidentification, UserAction.NONE);
    }

    public static void StartActivity(Activity activity, MyEbayListItem myebaylistitem, com.ebay.common.ConstantsCommon.ItemKind itemkind, String s, SourceIdentification sourceidentification, UserAction useraction)
    {
        StartActivity(activity, myebaylistitem, itemkind, s, false, sourceidentification, useraction);
    }

    public static void StartActivity(Activity activity, MyEbayListItem myebaylistitem, com.ebay.common.ConstantsCommon.ItemKind itemkind, String s, boolean flag, SourceIdentification sourceidentification, UserAction useraction)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewActivity);
        intent.putExtra("item_view_id", myebaylistitem.id);
        intent.putExtra("item_view_kind", itemkind.toString());
        intent.putExtra("paramGoPrev", flag);
        intent.putExtra("com.ebay.mobile.tracking.BidSource", s);
        if (useraction != null && useraction != UserAction.NONE)
        {
            intent.putExtra("user_action", useraction.ordinal());
        }
        if (sourceidentification != null)
        {
            intent.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
        }
        if (myebaylistitem.endDate != null)
        {
            intent.putExtra("item_view_end_date", myebaylistitem.endDate.getTime());
        }
        if (myebaylistitem.transaction != null)
        {
            intent.putExtra("transaction_id", myebaylistitem.transaction.transactionId);
            intent.putExtra("item_view_feedback_left", myebaylistitem.transaction.feedbackLeft);
        }
        invalidateCache(intent.getLongExtra("item_view_id", 0L), intent.getStringExtra("transaction_id"));
        if (myebaylistitem.nameValueList != null)
        {
            intent.putParcelableArrayListExtra("param_variation_values", myebaylistitem.nameValueList);
        }
        if (activity.getClass().equals(com/ebay/mobile/connection/myebay/MyEbayWatchingActivity) || activity.getClass().equals(com/ebay/mobile/connection/myebay/MyEbayBuyingActivity) || activity.getClass().equals(com/ebay/mobile/myebay/ReminderItemsActivity) || activity.getClass().equals(com/ebay/mobile/sell/lists/SellingListActivity))
        {
            intent.putExtra("item_view_from_my_ebay_or_reminders", true);
        }
        activity.startActivity(intent);
    }

    public static void StartActivity(Activity activity, MyEbayListItem myebaylistitem, com.ebay.common.ConstantsCommon.ItemKind itemkind, boolean flag)
    {
        StartActivity(activity, myebaylistitem, itemkind, null, flag, null, UserAction.NONE);
    }

    public static void StartActivity(Activity activity, MyEbayListItem myebaylistitem, com.ebay.common.ConstantsCommon.ItemKind itemkind, boolean flag, UserAction useraction)
    {
        StartActivity(activity, myebaylistitem, itemkind, null, flag, null, useraction);
    }

    public static void StartActivity(Activity activity, Long long1, Long long2, List list)
    {
        invalidateCache(long1.longValue(), long2);
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewActivity);
        intent.putExtra("item_view_id", long1);
        if (long2 != null)
        {
            intent.putExtra("transaction_id", Long.toString(long2.longValue()));
            intent.putExtra("item_view_kind", com.ebay.common.ConstantsCommon.ItemKind.Won.toString());
        } else
        {
            intent.putExtra("item_view_kind", com.ebay.common.ConstantsCommon.ItemKind.Found.toString());
        }
        if (list != null)
        {
            intent.putParcelableArrayListExtra("param_variation_values", new ArrayList(list));
        }
        activity.startActivity(intent);
    }

    public static void StartActivityDealItem(Activity activity, long l, ItemCurrency itemcurrency, int i)
    {
        invalidateCache(l, (Long)null);
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewActivity);
        intent.putExtra("item_view_id", l);
        intent.putExtra("item_view_kind", com.ebay.common.ConstantsCommon.ItemKind.Deals.toString());
        if (itemcurrency != null)
        {
            intent.putExtra("item_view_original_retail_price", itemcurrency);
            intent.putExtra("item_view_pricing_treatment", "STP");
            intent.putExtra("item_view_savings_rate", i);
        }
        activity.startActivity(intent);
    }

    public static void StartActivityFromMEB(Activity activity, long l, String s, com.ebay.common.ConstantsCommon.ItemKind itemkind, Intent intent)
    {
        invalidateCache(l, s);
        Intent intent1 = new Intent(activity, com/ebay/mobile/viewitem/ItemViewActivity);
        intent1.putExtra("item_view_id", l);
        intent1.putExtra("item_view_kind", itemkind.toString());
        intent1.putExtra("transaction_id", s);
        if (intent != null)
        {
            intent1.putExtras(intent);
        }
        activity.startActivity(intent1);
    }

    public static void StartActivityFromMEB(Activity activity, MyEbayListItem myebaylistitem, String s, com.ebay.common.ConstantsCommon.ItemKind itemkind, Intent intent)
    {
        invalidateCache(myebaylistitem.id, s);
        Intent intent1 = new Intent(activity, com/ebay/mobile/viewitem/ItemViewActivity);
        intent1.putExtra("ebay_list_item", myebaylistitem);
        intent1.putExtra("item_view_id", myebaylistitem.id);
        intent1.putExtra("item_view_kind", itemkind.toString());
        intent1.putExtra("transaction_id", s);
        if (intent != null)
        {
            intent1.putExtras(intent);
        }
        activity.startActivity(intent1);
    }

    public static void UpdateTimeLeft(Context context, TextView textview, ViewItemViewData viewitemviewdata, Item item, boolean flag, boolean flag1)
    {
        int i = context.getResources().getColor(ThemeUtil.resolveThemeForegroundColorResId(context.getTheme(), 0x1010038));
        int j = context.getResources().getColor(0x7f0d0005);
        if (item.isScheduled)
        {
            textview.setText(item.getRenderedDate(context, viewitemviewdata.kind, item.startDate, i, j, flag, flag1));
            return;
        }
        if (item.endDate != null)
        {
            textview.setText(item.getRenderedDate(context, viewitemviewdata.kind, item.endDate, i, j, flag, flag1));
        }
        if (item.endDate == null || item.isHideTimeLeft)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        textview.setVisibility(i);
    }

    private boolean autopayUnavailable()
    {
        return item.isAutopayUnavailable;
    }

    private boolean buyBarSetupAddToCartButton(DcsHelper dcshelper)
    {
        boolean flag = false;
        View view = findViewById(0x7f1007c8);
        if (view != null)
        {
            int i;
            if (showAddToCart() && (!dcshelper.isVIPBuyBarOverrideEnabled() || !dcshelper.isVIPBuyBarOverridCartControlsDisabled()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                cartButton = (TextImageButton)view;
                if (item.inCart)
                {
                    dcshelper = UserAction.VIEW_CART;
                } else
                {
                    dcshelper = UserAction.ADD_TO_CART;
                }
                cartButton.setTag(dcshelper);
                setViewAction(view, dcshelper, null);
                ((TextImageButton)view).setText(getString(0x7f070128));
            }
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
        }
        return flag;
    }

    private boolean buyBarSetupPlaceBidButton()
    {
        boolean flag = false;
        View view = findViewById(0x7f1004d7);
        if (view != null)
        {
            flag = item.isShowBidAmount;
            if (flag)
            {
                setViewAction(view, UserAction.PLACE_BID_AMOUNT, null);
            }
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
        }
        return flag;
    }

    private boolean buyBarSetupViewInCartButton(DcsHelper dcshelper)
    {
        boolean flag = false;
        View view = findViewById(0x7f10089c);
        if (view != null)
        {
            int i;
            if (item.isShowViewInCart && !dcshelper.isVIPBuyBarOverridCartControlsDisabled() && !dcshelper.isVIPBuyBarOverridePayForItemEnabled())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                cartButton = (TextImageButton)view;
                setViewAction(view, UserAction.VIEW_CART, null);
                ((TextImageButton)view).setText(getString(0x7f070ba7));
            }
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
        }
        return flag;
    }

    private void buyerReviewCounteroffer()
    {
        BestOffer bestoffer = (BestOffer)item.offers.get(item.offers.size() - 1);
        Intent intent = new Intent(this, com/ebay/mobile/bestoffer/BuyerRespondToCounterofferActivity);
        intent.putExtra("item_view_id", itemId);
        intent.putExtra("item_view_tx_id", transactionId);
        intent.putExtra("view_item_view_data", viewData);
        intent.putExtra("offer", bestoffer);
        intent.putExtra("com.ebay.mobile.tracking.Referrer", referrer);
        intent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
        startActivityForResult(intent, 8);
    }

    private void callVlsForFlags(Item item)
    {
        if (viewItemDataManager != null)
        {
            showHideTranslucentProgress(true, true);
            viewItemDataManager.getItemForFlags(item.id);
        }
    }

    private void cartChanged(boolean flag)
    {
        if (flag)
        {
            updateLocalNotificationsItemAddedToCart();
        }
        ShoppingCartActivity.updateActionBarCount(this);
        render();
    }

    private void createFragments()
    {
        if (itemSpecificsFragment == null || aboutSellerFragment == null || sprFragment == null || variationsFragment == null || biddingHistoryFragment == null || actionsFragment == null || merchFragment == null)
        {
            FragmentManager fragmentmanager = getFragmentManager();
            FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();
            variationsFragment = (ViewItemChooseVariationsFragment)fragmentmanager.findFragmentById(0x7f100355);
            if (variationsFragment == null)
            {
                variationsFragment = new ViewItemChooseVariationsFragment();
                Bundle bundle1 = new Bundle();
                variationsFragment.setArguments(bundle1);
                variationsFragment.setGalleryPager(imageViewPager);
                fragmenttransaction.replace(0x7f100355, variationsFragment);
            }
            itemSpecificsFragment = (ViewItemSpecificsFragment)fragmentmanager.findFragmentById(0x7f100328);
            if (itemSpecificsFragment == null)
            {
                itemSpecificsFragment = new ViewItemSpecificsFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("expandable", true);
                bundle2.putInt("collapsed_size", 5);
                bundle2.putBoolean("see_all", false);
                itemSpecificsFragment.setArguments(bundle2);
                fragmenttransaction.replace(0x7f100328, itemSpecificsFragment);
            }
            aboutSellerFragment = (AboutSellerFragment)fragmentmanager.findFragmentById(0x7f10087c);
            if (aboutSellerFragment == null)
            {
                aboutSellerFragment = new AboutSellerFragment();
                Bundle bundle3 = new Bundle();
                aboutSellerFragment.setArguments(bundle3);
                fragmenttransaction.replace(0x7f10087c, aboutSellerFragment);
            }
            biddingHistoryFragment = (ViewItemBiddingHistoryFragment)fragmentmanager.findFragmentById(0x7f100877);
            if (biddingHistoryFragment == null)
            {
                biddingHistoryFragment = new ViewItemBiddingHistoryFragment();
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean("see_all", true);
                biddingHistoryFragment.setArguments(bundle4);
                fragmenttransaction.replace(0x7f100877, biddingHistoryFragment);
            }
            sprFragment = (ViewItemShippingPaymentsReturnsFragment)fragmentmanager.findFragmentById(0x7f10087b);
            if (sprFragment == null)
            {
                sprFragment = new ViewItemShippingPaymentsReturnsFragment();
                Bundle bundle5 = new Bundle();
                bundle5.putBoolean("see_all", false);
                sprFragment.setArguments(bundle5);
                fragmenttransaction.replace(0x7f10087b, sprFragment);
            }
            actionsFragment = (ViewItemActionsFragment)fragmentmanager.findFragmentById(0x7f10088f);
            if (actionsFragment == null)
            {
                actionsFragment = new ViewItemActionsFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean("expandable", true);
                bundle.putInt("collapsed_size", 10);
                bundle.putBoolean("see_all", false);
                actionsFragment.setArguments(bundle);
                fragmenttransaction.replace(0x7f10088f, actionsFragment);
            }
            fragmenttransaction.commit();
            createMerchFragment();
        }
    }

    private PlatformNotificationsEvent createLocalNotificationsEvent(ItemCache itemcache, com.ebay.common.model.mdns.NotificationPreference.EventType eventtype)
    {
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        String s = MyApp.getPrefs().getCurrentUser();
        PlatformNotificationsEvent platformnotificationsevent = new PlatformNotificationsEvent();
        platformnotificationsevent.itemId = String.valueOf(item.id);
        if (item.isMotors)
        {
            platformnotificationsevent.clientId = "AMOTORS";
        } else
        {
            platformnotificationsevent.clientId = "AEAPP";
        }
        platformnotificationsevent.endTime = item.endDate.toString();
        platformnotificationsevent.endTimestamp = item.endDate.getTime();
        platformnotificationsevent.eventType = eventtype.name();
        platformnotificationsevent.sellerUserId = item.sellerUserId;
        platformnotificationsevent.title = item.title.getContent(deviceconfiguration.get(DcsBoolean.itemTitleTranslationEnabled));
        platformnotificationsevent.username = s;
        if (EbaySmartNotificationManager.getCurrentConfiguration(this) == com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.GCM && EbayUtil.isGCMActive(this, s, "AEAPP"))
        {
            platformnotificationsevent.deviceId = itemcache.getGCMRegistrationId(s);
        } else
        if (EbaySmartNotificationManager.getCurrentConfiguration(this) == com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.C2DM && EbayUtil.isC2DMActive(this, s, "AEAPP"))
        {
            platformnotificationsevent.deviceId = itemcache.getRegistrationId(s);
        } else
        {
            platformnotificationsevent.deviceId = "";
        }
        platformnotificationsevent.viewed = false;
        platformnotificationsevent.timestamp = System.currentTimeMillis();
        if (item.pictureUrls != null && item.pictureUrls.size() > 0)
        {
            platformnotificationsevent.pictureUrl = (String)item.pictureUrls.get(0);
            platformnotificationsevent.galleryUrl = ConstructDipUrl.constructDynamicUrl(platformnotificationsevent.pictureUrl, "_26");
        }
        if (item.isBidWithBin)
        {
            platformnotificationsevent.itemType = com.ebay.common.model.mdns.PlatformNotificationsEvent.ItemListingType.BIDWITHBIN;
        } else
        {
            if (item.isBidOnly)
            {
                platformnotificationsevent.itemType = com.ebay.common.model.mdns.PlatformNotificationsEvent.ItemListingType.BIDONLY;
                return platformnotificationsevent;
            }
            if (item.isBinOnly)
            {
                platformnotificationsevent.itemType = com.ebay.common.model.mdns.PlatformNotificationsEvent.ItemListingType.BINONLY;
                return platformnotificationsevent;
            }
        }
        return platformnotificationsevent;
    }

    private void createMerchFragment()
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        if (merchFragment == null && deviceconfiguration.get(DcsBoolean.viewItemUseMerchV2))
        {
            merchFragment = MerchandiseFragment.attach(this, "MERCH_BELOW_FOLD_PRIMARY", 0x7f10088c, 0x18754L, null, false);
        }
    }

    private void createUi()
    {
        setupImageViewPager();
        descriptionLayout = findViewById(0x7f1005b0);
        descriptionLayout.setOnClickListener(this);
        retryButton = setupButton(0x7f10013f);
        setupButton(0x7f100140);
        compatibleWithLayout = findViewById(0x7f100870);
        compatibleWithLayout.setOnClickListener(this);
        compatibleWithGarageList = (TextView)findViewById(0x7f100871);
        View view = findViewById(0x7f1002fa);
        view.setVisibility(8);
        view.addOnLayoutChangeListener(updateBottomPaddingOnLayoutChange);
        if (getResources().getBoolean(0x7f0b0002))
        {
            ((EbayScrollView)findViewById(0x7f100017)).addOnScrollViewListener(new FloatingActionBarScrollListener(view));
        }
        reviewsCount = (TextView)findViewById(0x7f1004f7);
        reviewsRating = (eBayRating)findViewById(0x7f1004f6);
        reviewsRating.setFeedbackStarResources(0x7f02022b, 0x7f02022d, 0x7f02022b, 0x7f02022c);
        reviewsRating.setOnTouchListener(null);
        reviewsLayout = findViewById(0x7f1004f5);
        reviewsLayout.setOnClickListener(this);
        buyItNowBottomButton = findViewById(0x7f10087f);
        productDetailsLayout = findViewById(0x7f100872);
        if (DeviceConfiguration.getAsync().get(DcsBoolean.VI_feature_merchOnScroll))
        {
            EbayScrollView ebayscrollview = (EbayScrollView)findViewById(0x7f100017);
            if (ebayscrollview != null)
            {
                ebayscrollview.addOnScrollViewListener(this);
            }
        }
    }

    private void doBuyingOptions(int i)
    {
        boolean flag = true;
        if (item.isBusinessTypeOkForPurchase())
        {
            boolean flag1 = item.isClassifiedItem();
            flag = flag1;
            if (!flag1)
            {
                String s1 = getFreightErrorMessage();
                String s = s1;
                if (s1 == null)
                {
                    s = ItemViewPayPalable.getUsePayPalError(this, item);
                }
                if (!item.isShipsToUser || TextUtils.equals(s, getString(0x7f07068c)))
                {
                    if (MyApp.getPrefs().getUserIsPpa())
                    {
                        showDialogPpaUpgrade();
                        flag = flag1;
                    } else
                    {
                        showDialogItemDoesNotShipToYou(getString(0x7f07048f));
                        flag = flag1;
                    }
                } else
                {
                    flag = true;
                }
            }
        }
        if (flag)
        {
            ErrorDialogActivity.StartActivity(this, getString(i), item.buyingOptionsVerbiage, false);
        }
    }

    private void doPaymentOptions(int i)
    {
        if (TextUtils.equals(ItemViewPayPalable.getUsePayPalError(this, item), getString(0x7f07068c)))
        {
            if (MyApp.getPrefs().getUserIsPpa())
            {
                showDialogPpaUpgrade();
                return;
            } else
            {
                showDialogItemDoesNotShipToYou(getString(0x7f07048f));
                return;
            }
        } else
        {
            ErrorDialogActivity.StartActivity(this, getString(i), item.buyingOptionsVerbiage, false);
            return;
        }
    }

    private void enterOrEditPackageTracking()
    {
        if (item.iTransaction != null)
        {
            Intent intent = new Intent(this, com/ebay/mobile/activities/AddEditTrackingInfoActivity);
            intent.putExtra("number", item.iTransaction.getShipmentTrackingNumber());
            intent.putExtra("carrier", item.iTransaction.getShippingCarrierUsed());
            intent.putExtra("enter_vs_edit", true);
            startActivityForResult(intent, 5);
        }
    }

    private void finishWatchUnWatch(boolean flag)
    {
        if (flag && item.needsToSelectMultiSku(viewData.nameValueList))
        {
            ViewItemChooseVariationsActivity.startActivity(this, viewData, ViewItemChooseVariationsActivity.IntendedAction.WATCH);
        } else
        {
            Object obj;
            if (flag)
            {
                obj = UserAction.WATCH;
            } else
            {
                obj = UserAction.UNWATCH;
            }
            if (!needSignIn(((UserAction) (obj))))
            {
                CreateAndSubmitWatchTask(flag, viewData.nameValueList);
                if (flag)
                {
                    obj = "WatchItem";
                } else
                {
                    obj = "UnwatchItem";
                }
                trackItemViewEvent(((String) (obj)));
                return;
            }
        }
    }

    private android.view.View.OnClickListener getAdsClickListener()
    {
        if (adsClickListener == null)
        {
            adsClickListener = new android.view.View.OnClickListener() {

                final ItemViewActivity this$0;

                public void onClick(View view)
                {
                    Object obj = (com.ebay.common.rtm.RtmContent.Ad)view.getTag();
                    if (DeviceConfiguration.getAsync().get(DcsBoolean.SearchAdsShowWebView))
                    {
                        AdsWebViewActivity.start((Activity)view.getContext(), ((com.ebay.common.rtm.RtmContent.Ad) (obj)).externalLink.toString(), null, null);
                        return;
                    } else
                    {
                        obj = ((com.ebay.common.rtm.RtmContent.Ad) (obj)).externalLink;
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(((URL) (obj)).toExternalForm()));
                        view.getContext().startActivity(intent);
                        return;
                    }
                }

            
            {
                this$0 = ItemViewActivity.this;
                super();
            }
            };
        }
        return adsClickListener;
    }

    private View getDisplayAdViewToMeasure()
    {
        int i;
        if (actionsFragment != null && actionsFragment.hasContent())
        {
            i = 0x7f10088f;
        } else
        {
            i = getTitleAndPriceLayoutToUse();
        }
        return findViewById(i);
    }

    private void getDisplayAds()
    {
        if (AdUtil.logDfpAds.isLoggable)
        {
            FwLog.logMethod(AdUtil.logDfpAds, new Object[0]);
        }
        if (isAdsEnabledDisplay && adRtmDataManager != null)
        {
            Preferences preferences = MyApp.getPrefs();
            Object obj = preferences.getAuthentication();
            if (obj != null)
            {
                obj = ((Authentication) (obj)).iafToken;
            } else
            {
                obj = null;
            }
            adRtmDataManager.getViewItemDisplayAds(item.title.getSourceContent(), item.id, String.valueOf(item.primaryCategoryId), preferences, preferences.getCurrentSite(), ((String) (obj)), adRtmDmObserver);
        }
    }

    private String getFreightErrorMessage()
    {
        return item.freightErrorMessage;
    }

    private void getGoogleTextAds()
    {
        final LinearLayout googleTextAdContainer = (LinearLayout)findViewById(0x7f10088d);
        if (googleTextAdContainer.getWidth() == 0)
        {
            final int visibility = googleTextAdContainer.getVisibility();
            googleTextAdContainer.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final ItemViewActivity this$0;
                final LinearLayout val$googleTextAdContainer;
                final int val$visibility;

                public void onGlobalLayout()
                {
                    googleTextAdContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    googleTextAdContainer.setVisibility(visibility);
                    loadGoogleTextAds(googleTextAdContainer);
                }

            
            {
                this$0 = ItemViewActivity.this;
                googleTextAdContainer = linearlayout;
                visibility = i;
                super();
            }
            });
            googleTextAdContainer.setVisibility(0);
            return;
        } else
        {
            loadGoogleTextAds(googleTextAdContainer);
            return;
        }
    }

    private void getPlaAds()
    {
        if (AdUtil.logDfpAds.isLoggable)
        {
            FwLog.logMethod(AdUtil.logDfpAds, new Object[0]);
        }
        if (adsPla == null && isAdsEnabledPLA && adRtmDataManager != null)
        {
            Preferences preferences = MyApp.getPrefs();
            Object obj = preferences.getAuthentication();
            if (obj != null)
            {
                obj = ((Authentication) (obj)).iafToken;
            } else
            {
                obj = null;
            }
            adRtmDataManager.getViewItemPlaAds(item.title.getSourceContent(), item.id, String.valueOf(item.primaryCategoryId), preferences, preferences.getCurrentSite(), ((String) (obj)), adRtmDmObserver);
        }
    }

    public static PostalCodeSpecification getShippingCostsPostalCode(ViewItemViewData viewitemviewdata)
    {
        PostalCodeSpecification postalcodespecification = null;
        if (!TextUtils.isEmpty(viewitemviewdata.searchRefinedPostalCode))
        {
            postalcodespecification = new PostalCodeSpecification();
            postalcodespecification.countryCode = "US";
            postalcodespecification.postalCode = viewitemviewdata.searchRefinedPostalCode;
        }
        viewitemviewdata = postalcodespecification;
        if (postalcodespecification == null)
        {
            viewitemviewdata = MyApp.getPrefs().getShipToPostalCode();
        }
        return viewitemviewdata;
    }

    private void getStoreAvailability()
    {
        viewItemDataManager.getStoreAvailability(viewData);
        showHideTranslucentProgress(true);
    }

    private int getTitleAndPriceLayoutToUse()
    {
        return item == null || !item.isShowItemCard ? 0x7f10086d : 0x7f10086c;
    }

    private void handleAction(UserAction useraction, String s)
    {
        _cls12..SwitchMap.com.ebay.mobile.viewitem.ItemViewActivity.UserAction[useraction.ordinal()];
        JVM INSTR tableswitch 14 14: default 28
    //                   14 48;
           goto _L1 _L2
_L1:
        if (Util.hasNetwork()) goto _L2; else goto _L3
_L3:
        showButterBarMessage(useraction.ordinal(), getNetworkErrorToastString(), true);
_L5:
        return;
_L2:
        switch (_cls12..SwitchMap.com.ebay.mobile.viewitem.ItemViewActivity.UserAction[useraction.ordinal()])
        {
        case 2: // '\002'
        case 5: // '\005'
        case 12: // '\f'
        default:
            return;

        case 33: // '!'
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            sellLike();
            return;

        case 15: // '\017'
            startBiddingActivity();
            return;

        case 16: // '\020'
            if (item.isShowPlaceBid)
            {
                placeBid(s);
                return;
            }
            break;

        case 17: // '\021'
            if (item.isShowPlaceBid)
            {
                placeBidAmount(null);
                return;
            }
            break;

        case 18: // '\022'
            if (item.isShowBuyItNow)
            {
                doBin();
                return;
            }
            break;

        case 19: // '\023'
            if (item.isShowBuyAnother)
            {
                doBuyAnother();
                return;
            }
            break;

        case 20: // '\024'
            finishWatchUnWatch(true);
            return;

        case 21: // '\025'
            finishWatchUnWatch(false);
            return;

        case 3: // '\003'
            showDialog(getString(0x7f070603), null, getString(0x7f070738), getString(0x7f0701cc), 3);
            return;

        case 4: // '\004'
            showDialog(getString(0x7f070602), null, getString(0x7f070738), getString(0x7f0701cc), 4);
            return;

        case 22: // '\026'
            buyerReviewCounteroffer();
            return;

        case 23: // '\027'
            if (item.isShowAddToCart)
            {
                doAddToCart();
                return;
            }
            break;

        case 24: // '\030'
            if (item.isShowViewInCart)
            {
                doViewCart();
                return;
            }
            break;

        case 25: // '\031'
            payForItems(this, item, viewData, item.quantityPurchased, Boolean.valueOf(false), bidSource, referrer);
            return;

        case 26: // '\032'
            doPaymentOptions(0x7f070766);
            return;

        case 6: // '\006'
        case 7: // '\007'
            enterOrEditPackageTracking();
            return;

        case 8: // '\b'
            ItemViewLeaveFeedbackActivity.StartActivity(this, viewData, 1);
            return;

        case 9: // '\t'
            showDialog(null, getString(0x7f070600), getString(0x7f070738), getString(0x7f0701cc), 1);
            return;

        case 10: // '\n'
            showDialog(null, getString(0x7f070601), getString(0x7f070738), getString(0x7f0701cc), 2);
            return;

        case 11: // '\013'
            relistItem();
            return;

        case 27: // '\033'
            viewRelistedItem();
            return;

        case 13: // '\r'
            share();
            return;

        case 14: // '\016'
            doBuyingOptions(0x7f0701c4);
            return;

        case 28: // '\034'
            if (item.iTransaction != null && item.tracking != null)
            {
                showEbnOrderDetails();
                return;
            }
            break;

        case 30: // '\036'
            startSPRActivity();
            return;

        case 31: // '\037'
            s = getFreightErrorMessage();
            useraction = s;
            if (s == null)
            {
                useraction = ItemViewPayPalable.getUsePayPalError(this, item);
            }
            if (!item.isShipsToUser || TextUtils.equals(useraction, getString(0x7f07068c)))
            {
                startAddressBookActivity();
                return;
            }
            break;

        case 32: // ' '
            doMakeOffer();
            return;

        case 29: // '\035'
            break;
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (needSignIn(UserAction.PLUS_SIGNUP)) goto _L5; else goto _L6
_L6:
        startPlusSignupFlow();
        return;
    }

    private void handleConfirmComplete()
    {
        boolean flag;
label0:
        {
            flag = true;
            if (com.ebay.common.ConstantsCommon.ItemKind.Bidding != viewData.kind)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            boolean flag1 = false;
            if (item.isReserveMet)
            {
                viewItemDataManager.getViewItemLite(itemId, false);
            }
            if (item.isReserveMet)
            {
                flag = flag1;
                if (!item.buyItNowAvailable)
                {
                    break label0;
                }
            }
            callVlsForFlags(item);
            flag = flag1;
        }
_L1:
        if (flag)
        {
            issueRefresh();
            return;
        } else
        {
            render();
            return;
        }
        if (com.ebay.common.ConstantsCommon.ItemKind.Won == viewData.kind)
        {
            if (item.autoPay && !autopayUnavailable())
            {
                userAction = UserAction.PAY_NOW;
            } else
            {
                userAction = UserAction.NONE;
            }
        } else
        if (autopayUnavailable())
        {
            userAction = UserAction.NONE;
        } else
        {
            userAction = UserAction.PAY_NOW;
        }
          goto _L1
    }

    private void handleDeferredSignInAction()
    {
        UserAction useraction = userAction;
        String s;
        if (UserAction.PLACE_BID == userAction)
        {
            s = EbayCurrencyUtil.formatDisplay(item.minimumToBid.lowerBound, 0);
        } else
        {
            s = null;
        }
        handleAction(useraction, s);
        userAction = UserAction.NONE;
    }

    private void hideTranslucentProgress()
    {
        showHideTranslucentProgress(false);
        if (swipeRefreshLayout != null)
        {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    private void initialLoadViewSettings()
    {
        Object obj;
        if (MyApp.getPrefs().getAuthentication() != null && this.item.isTransacted)
        {
            obj = this.item.user;
            Item item;
            long l;
            if (this.item.iTransaction != null && com.ebay.common.ConstantsCommon.ItemKind.Won == viewData.kind && !((String) (obj)).equals(this.item.iTransaction.buyerUserId) || com.ebay.common.ConstantsCommon.ItemKind.Sold == viewData.kind && !((String) (obj)).equals(this.item.iTransaction.sellerUserId))
            {
                viewData.kind = com.ebay.common.ConstantsCommon.ItemKind.Found;
            } else
            if (com.ebay.common.ConstantsCommon.ItemKind.Found == viewData.kind && this.item.iTransaction != null && ((String) (obj)).equals(this.item.iTransaction.buyerUserId))
            {
                viewData.kind = com.ebay.common.ConstantsCommon.ItemKind.Won;
            } else
            if (com.ebay.common.ConstantsCommon.ItemKind.Found == viewData.kind && this.item.iTransaction != null && ((String) (obj)).equals(this.item.iTransaction.sellerUserId))
            {
                viewData.kind = com.ebay.common.ConstantsCommon.ItemKind.Sold;
            }
        }
        if (this.item.endDate == null)
        {
            l = getIntent().getLongExtra("item_view_end_date", 0L);
            item = this.item;
            if (l != 0L)
            {
                obj = new Date(l);
            } else
            {
                obj = null;
            }
            item.endDate = ((Date) (obj));
        }
        if (inventoryInfo != null && this.item.inventoryInfo == null)
        {
            this.item.inventoryInfo = inventoryInfo;
        }
    }

    public static void invalidateCache(long l, Long long1)
    {
        ViewItemDataManager.markDirty(new ViewItemDataManager.KeyParams(l, long1));
    }

    public static void invalidateCache(long l, String s)
    {
        Long long1;
        Object obj;
        obj = null;
        long1 = obj;
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_25;
        }
        long l1 = Long.parseLong(s);
        long1 = Long.valueOf(l1);
_L2:
        invalidateCache(l, long1);
        return;
        s;
        long1 = obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private boolean isActionable(UserAction useraction)
    {
        switch (_cls12..SwitchMap.com.ebay.mobile.viewitem.ItemViewActivity.UserAction[useraction.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
            return showSellLike();

        case 2: // '\002'
            return showEndItem();

        case 3: // '\003'
            return showMarkShipped();

        case 4: // '\004'
            return showMarkNotShipped();

        case 5: // '\005'
            return showTrackPackage();

        case 6: // '\006'
            return (actionsFragment == null || !actionsFragment.isShowingButtons()) && showEnterTrackingNumber() && showTrackPackage();

        case 7: // '\007'
            return (actionsFragment == null || !actionsFragment.isShowingButtons()) && showEnterTrackingNumber() && !showTrackPackage();

        case 8: // '\b'
            return showLeaveFeedback();

        case 9: // '\t'
            return showMarkAsPaid();

        case 10: // '\n'
            return showMarkAsUnPaid();

        case 11: // '\013'
            return showRelist();

        case 12: // '\f'
            return showRevise();

        case 13: // '\r'
            return item.isShowShare;
        }
    }

    private boolean isButtonVisibleOnBuyBar(int i)
    {
        View view;
        Object obj;
        boolean flag;
        boolean flag1;
        flag1 = false;
        obj = null;
        view = findViewById(0x7f1002fa);
        flag = flag1;
        if (view == null) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (view.getVisibility() != 0) goto _L2; else goto _L3
_L3:
        view = obj;
        i;
        JVM INSTR tableswitch 2131757182 2131757190: default 84
    //                   2131757182 118
    //                   2131757183 107
    //                   2131757184 151
    //                   2131757185 162
    //                   2131757186 184
    //                   2131757187 173
    //                   2131757188 86
    //                   2131757189 129
    //                   2131757190 140;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L11:
        break; /* Loop/switch isn't completed */
_L4:
        view = obj;
_L15:
        flag = flag1;
        if (view != null)
        {
            if (view.getVisibility() != 0)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = true;
        }
_L2:
        return flag;
_L6:
        view = findViewById(0x7f10089e);
        continue; /* Loop/switch isn't completed */
_L5:
        view = findViewById(0x7f1004d7);
        continue; /* Loop/switch isn't completed */
_L12:
        view = findViewById(0x7f1007c8);
        continue; /* Loop/switch isn't completed */
_L13:
        view = findViewById(0x7f10089c);
        continue; /* Loop/switch isn't completed */
_L7:
        view = findViewById(0x7f100899);
        continue; /* Loop/switch isn't completed */
_L8:
        view = findViewById(0x7f10089d);
        continue; /* Loop/switch isn't completed */
_L10:
        view = findViewById(0x7f10089b);
        continue; /* Loop/switch isn't completed */
_L9:
        view = findViewById(0x7f10089a);
        if (true) goto _L15; else goto _L14
_L14:
        return false;
    }

    private boolean isMultiSKUSelectable()
    {
        return item.isMultiSkuSelectable;
    }

    private boolean isProgressVisible()
    {
        return findViewById(0x7f100148).getVisibility() == 0;
    }

    private boolean isSellerAcceptedOffer(Intent intent)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (intent != null)
        {
            flag = flag1;
            if (item != null)
            {
                flag = flag1;
                if (item.isSeller)
                {
                    intent = (BestOffer)intent.getParcelableExtra("offer");
                    flag = flag1;
                    if (intent != null)
                    {
                        flag = flag1;
                        if ("Accepted".equals(((BestOffer) (intent)).status))
                        {
                            viewData.kind = com.ebay.common.ConstantsCommon.ItemKind.Sold;
                            invalidateCache(viewData.keyParams.itemId, (Long)null);
                            flag = true;
                            issueRefresh(true, 1);
                        }
                    }
                }
            }
        }
        return flag;
    }

    private boolean isTransactedMismatchDetected()
    {
        return transactionId != null && viewData.keyParams != null && viewData.keyParams.transactionId == null;
    }

    public static boolean isUseNewUi(Item item, boolean flag)
    {
        return !flag && item.isShowReviewBid;
    }

    private void issueRefresh()
    {
        issueRefresh(false, 0);
    }

    private void issueRefresh(boolean flag)
    {
        issueRefresh(flag, 0);
    }

    private void issueRefresh(boolean flag, int i)
    {
        networkErrorToast = null;
        showHideTranslucentProgress(true, true);
        layoutState = ItemViewCommonProgressAndError.LayoutState.NORMAL;
        initialLoadComplete = false;
        if (flag && item != null)
        {
            item.storesWithItem = -1;
        }
        if (flag)
        {
            resetTitleAndPriceFragment();
        }
        if (inventoryLookupDM != null)
        {
            inventoryLookupDM.clearData();
        }
        if (viewItemDataManager != null)
        {
            viewItemDataManager.forceReloadData(viewData, i);
        }
    }

    private void loadDisplayAds(final com.ebay.common.rtm.RtmContent.Ad ad)
    {
        com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder builder = AdUtil.getConfiguredAdRequestBuilder(ad);
        final NativeAdLoader adLoader = new NativeAdLoader(ad);
        adLoader.loadAd(this, builder.build(), new AdListener() {

            final ItemViewActivity this$0;
            final com.ebay.common.rtm.RtmContent.Ad val$ad;
            final NativeAdLoader val$adLoader;

            public void onAdFailedToLoad(int i)
            {
                super.onAdFailedToLoad(i);
                if (isFinishing())
                {
                    return;
                }
                if (AdUtil.logDfpAds.isLoggable)
                {
                    AdUtil.logDfpAds.logAsWarning(String.format("DFP onAdFailedToLoad:  %s", new Object[] {
                        Integer.valueOf(i)
                    }));
                }
                showDisplayAdsView(false);
            }

            public void onAdLoaded()
            {
                super.onAdLoaded();
                if (isFinishing())
                {
                    return;
                }
                if (AdUtil.logDfpAds.isLoggable)
                {
                    AdUtil.logDfpAds.log("DFP onAdLoaded");
                }
                Object obj = (LinearLayout)findViewById(0x7f10088b);
                if (adView != null)
                {
                    ((LinearLayout) (obj)).removeView(adView);
                    adView = null;
                }
                adView = adLoader.getAdView(ItemViewActivity.this, ((ViewGroup) (obj)));
                if (adView != null)
                {
                    ((LinearLayout) (obj)).addView(adView);
                    showDisplayAdsView(true);
                }
                obj = new TrackingData("RTMImpression", TrackingType.PAGE_IMPRESSION);
                ((TrackingData) (obj)).addKeyValuePair("campID", adCampaignId);
                ((TrackingData) (obj)).addKeyValuePair("adid", AdUtil.getAdUnitId(ad));
                ((TrackingData) (obj)).send(ItemViewActivity.this);
            }

            public void onAdOpened()
            {
                super.onAdOpened();
                TrackingData trackingdata = new TrackingData("AdClick", TrackingType.EVENT);
                trackingdata.addKeyValuePair("campID", adCampaignId);
                trackingdata.addKeyValuePair("adid", AdUtil.getAdUnitId(ad));
                trackingdata.addKeyValuePair("adtype", "1");
                trackingdata.addSourceIdentification(new SourceIdentification(getTrackingEventName(), "ad", "ad"));
                trackingdata.send(ItemViewActivity.this);
            }

            
            {
                this$0 = ItemViewActivity.this;
                adLoader = nativeadloader;
                ad = ad1;
                super();
            }
        });
    }

    private void loadGoogleTextAds(final ViewGroup textAdContainer)
    {
        final GoogleTextAdLoader textAdLoader = new GoogleTextAdLoader();
        String s = null;
        if (item.title != null)
        {
            s = item.title.getSourceContent();
        }
        textAdLoader.loadAd(this, textAdContainer, s, false, new AdListener() {

            final ItemViewActivity this$0;
            final ViewGroup val$textAdContainer;
            final GoogleTextAdLoader val$textAdLoader;

            public void onAdFailedToLoad(int i)
            {
                super.onAdFailedToLoad(i);
                showGoogleTextAdsView(false);
            }

            public void onAdLoaded()
            {
                super.onAdLoaded();
                if (googleTextAdView != null)
                {
                    textAdContainer.removeView(googleTextAdView);
                    googleTextAdView = null;
                }
                googleTextAdView = textAdLoader.textAdView;
                if (googleTextAdView != null)
                {
                    textAdContainer.addView(googleTextAdView);
                    showGoogleTextAdsView(true);
                }
            }

            
            {
                this$0 = ItemViewActivity.this;
                textAdContainer = viewgroup;
                textAdLoader = googletextadloader;
                super();
            }
        });
    }

    public static boolean payForItems(BaseActivity baseactivity, Item item, ViewItemViewData viewitemviewdata, int i, Boolean boolean1, String s, String s1)
    {
        if (ItemViewPayPalable.paisaPayIsAvailableForItem(item))
        {
            boolean1 = new Intent(baseactivity, com/ebay/mobile/activities/PaisaPayWebViewActivity);
            boolean1.putExtra("itemID", item.id);
            boolean1.putExtra("var", item.getVariationId(viewitemviewdata.nameValueList));
            boolean1.putExtra("quantity", i);
            boolean1.putExtra("back", true);
            baseactivity.startActivityForResult(boolean1, 14);
            return true;
        }
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        if (dcshelper.isMecOrMec2Enabled(item.site))
        {
            Intent intent = new Intent(baseactivity, com/ebay/mobile/checkout/CheckoutActivity);
            intent.putExtra("remember_me", dcshelper.isMec2Enabled(item.site));
            intent.putExtra("item", new CheckoutItem(item));
            intent.putExtra("refined_postal_code", viewitemviewdata.searchRefinedPostalCode);
            intent.putExtra("com.ebay.mobile.tracking.BidSource", s);
            intent.putExtra("com.ebay.mobile.tracking.Referrer", s1);
            s = new ItemTransaction();
            if (item.iTransaction != null && !boolean1.booleanValue())
            {
                s = item.iTransaction;
            } else
            {
                if (!boolean1.booleanValue())
                {
                    s.transactionId = Long.toString(item.transactionId.longValue());
                }
                s.quantityPurchased = i;
            }
            intent.putExtra("transaction", s);
            item = item.getVariationId(viewitemviewdata.nameValueList);
            if (boolean1.booleanValue())
            {
                intent.putExtra("variation_id", item);
            }
            intent.putParcelableArrayListExtra("variation_options", viewitemviewdata.nameValueList);
            baseactivity.startActivityForResult(intent, 14);
            return true;
        } else
        {
            return false;
        }
    }

    private void refreshButtonVisiblity()
    {
        Iterator iterator = ACTION_BUTTON_IDS.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)iterator.next();
            if (((java.util.Map.Entry) (obj)).getValue() != null && ((Integer)((java.util.Map.Entry) (obj)).getValue()).intValue() > 0)
            {
                UserAction useraction = (UserAction)((java.util.Map.Entry) (obj)).getKey();
                int i;
                if (useraction != promotedAction && isActionable(useraction))
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                obj = findViewById(((Integer)((java.util.Map.Entry) (obj)).getValue()).intValue());
                if (obj != null)
                {
                    if (i != 0)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    ((View) (obj)).setVisibility(i);
                    setViewAction(((View) (obj)), useraction, null);
                }
            }
        } while (true);
    }

    public static void refreshOtherActivities(Activity activity, Item item)
    {
        activity.runOnUiThread(new Runnable(item) {

            final Item val$item;

            public void run()
            {
                ContentSyncManager.notifyUpdate(item, com/ebay/mobile/Item.getName());
            }

            
            {
                item = item1;
                super();
            }
        });
    }

    private void relistItem()
    {
        Intent intent = new Intent(this, com/ebay/mobile/sell/ListingFragmentActivity);
        intent.putExtra("site", EbaySite.getInstanceFromId(item.site));
        intent.putExtra("source_item_id", item.idForDraftSource);
        intent.putExtra("listing_mode", "RelistItem");
        startActivityForResult(intent, 10);
    }

    private void render()
    {
        if (!isProgressVisible())
        {
            if (item.isListingTypeBid && com.ebay.common.ConstantsCommon.ItemKind.Won != viewData.kind && !item.isAuctionEnded && viewItemDataManager.isInMyEbayBidList(item.id, viewData.nameValueList))
            {
                viewData.kind = com.ebay.common.ConstantsCommon.ItemKind.Bidding;
            }
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, (new StringBuilder()).append("render: layoutState=").append(layoutState.name()).toString());
            }
            if (ItemViewCommonProgressAndError.LayoutState.NORMAL == layoutState)
            {
                findViewById(0x7f100016).setVisibility(0);
                if (actionsFragment != null)
                {
                    actionsFragment.render(item, viewData);
                    if (actionsFragment.hasContent())
                    {
                        findViewById(0x7f10088f).setVisibility(0);
                        findViewById(0x7f10088e).setVisibility(0);
                    }
                }
                int i;
                if (item.isShowSellerVacationNote)
                {
                    ((TextView)findViewById(0x7f100891)).setText(item.sellerVacationNote);
                    findViewById(0x7f100890).setVisibility(0);
                    findViewById(0x7f10088e).setVisibility(0);
                } else
                {
                    findViewById(0x7f100890).setVisibility(8);
                }
                i = 0;
                if (!item.isSeller && (isCondensedView == null || isCondensedView.booleanValue()) && (item.isAuctionEnded || item.isTransacted))
                {
                    renderCondensedView();
                } else
                {
                    i = renderPrimaryView();
                }
                SiteSpeedActivityUtil.primaryLoaded(this);
                if (i == 0)
                {
                    SiteSpeedActivityUtil.allLoaded(this);
                }
                if (merchFragment != null && (forceMerch || !DeviceConfiguration.getAsync().get(DcsBoolean.VI_feature_merchOnScroll) || !item.isSeller && !item.isActive))
                {
                    updateMerch();
                    forceMerch = false;
                }
                if (isAdsEnabledPLA && adsPla != null)
                {
                    renderPlaAds(adsPla);
                }
            }
            ItemViewCommonProgressAndError.showLayouts(this, layoutState);
            invalidateOptionsMenu();
        }
    }

    private void renderBuyBar()
    {
        LinearLayout linearlayout;
        boolean flag;
        if (actionsFragment != null && actionsFragment.isShowingButtons())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        linearlayout = (LinearLayout)findViewById(0x7f1002fa);
        if (!flag && setupBuyBar() > 0)
        {
            linearlayout.setVisibility(0);
            return;
        } else
        {
            linearlayout.setVisibility(8);
            return;
        }
    }

    private void renderCondensedView()
    {
        int j = 1;
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        isCondensedView = Boolean.valueOf(true);
        findViewById(0x7f1002f8).setVisibility(8);
        findViewById(0x7f1002f9).setVisibility(8);
        findViewById(0x7f100878).setVisibility(8);
        findViewById(0x7f10086c).setVisibility(8);
        findViewById(0x7f10086d).setVisibility(8);
        findViewById(0x7f100355).setVisibility(8);
        findViewById(0x7f100602).setVisibility(8);
        findViewById(0x7f100328).setVisibility(8);
        findViewById(0x7f100872).setVisibility(8);
        findViewById(0x7f100870).setVisibility(8);
        if (reviewsLayout != null)
        {
            reviewsLayout.setVisibility(8);
        }
        findViewById(0x7f1005b0).setVisibility(8);
        findViewById(0x7f100877).setVisibility(8);
        findViewById(0x7f10087b).setVisibility(8);
        findViewById(0x7f10087c).setVisibility(8);
        findViewById(0x7f10087d).setVisibility(8);
        FrameLayout framelayout = (FrameLayout)findViewById(0x7f1002f7);
        framelayout.removeAllViews();
        LayoutInflater.from(this).inflate(0x7f030288, framelayout, true);
        Object obj1 = null;
        Object obj;
        int i;
        int k;
        if (item.thumbnailImage != null)
        {
            obj = item.thumbnailImage.toString();
        } else
        {
            obj = obj1;
            if (item.pictureUrls != null)
            {
                obj = obj1;
                if (item.pictureUrls.size() > 0)
                {
                    obj = (String)item.pictureUrls.get(0);
                }
            }
        }
        if (obj != null)
        {
            ((RemoteImageView)framelayout.findViewById(0x7f1000d5)).setRemoteImageUrl(((String) (obj)));
        }
        i = j;
        if (!item.isHighBidder())
        {
            if (item.iTransaction != null && MyApp.getPrefs().getCurrentUser().equals(item.iTransaction.buyerUserId))
            {
                i = j;
            } else
            {
                i = 0;
            }
        }
        k = 0x7f0703c3;
        j = k;
        if (item.isTransacted)
        {
            j = k;
            if (i != 0)
            {
                j = 0x7f070196;
            }
        }
        ((TextView)framelayout.findViewById(0x7f1008a2)).setText(j);
        obj = DeviceConfiguration.getAsync();
        ((TextView)framelayout.findViewById(0x7f10005f)).setText(item.title.getContent(((DeviceConfiguration) (obj)).get(DcsBoolean.itemTitleTranslationEnabled)));
        if (item.isDisplayPriceCurrencyCode)
        {
            obj = item.displayCurrentPriceConverted;
        } else
        {
            obj = item.displayCurrentPrice;
        }
        ((TextView)framelayout.findViewById(0x7f1001b8)).setText(((CharSequence) (obj)));
        if (i == 0 && (!item.isBopisableAndPurchasedViaBopis || !item.isPudoableAndPurchasedViaPudo))
        {
            i = 0x7f070b8e;
            if (item.bidCount > 0 && item.isReserveMet || item.quantitySold >= item.quantity)
            {
                i = 0x7f070ad2;
            }
            if (item.isTransacted)
            {
                i = 0x7f070ad2;
                if (item.isBidOnly)
                {
                    i = 0x7f070bc2;
                }
            }
            ((TextView)framelayout.findViewById(0x7f1008a3)).setText(i);
        }
        framelayout.setOnClickListener(new android.view.View.OnClickListener() {

            final ItemViewActivity this$0;

            public void onClick(View view)
            {
                renderPrimaryView();
            }

            
            {
                this$0 = ItemViewActivity.this;
                super();
            }
        });
        framelayout.setVisibility(0);
        setupButtonsAndClickableLayouts();
    }

    private void renderDescription()
    {
        if (!TextUtils.isEmpty(item.shortDescription))
        {
            TextView textview = (TextView)findViewById(0x7f100876);
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
            spannablestringbuilder.append(item.shortDescription);
            spannablestringbuilder.setSpan(new ForegroundColorSpan(ThemeUtil.resolveThemeForegroundColor(getResources(), getTheme(), 0x1010036)), 0, spannablestringbuilder.length(), 33);
            textview.setText(spannablestringbuilder, android.widget.TextView.BufferType.SPANNABLE);
            textview.setVisibility(0);
        }
    }

    private void renderDisplayAdsView(final ArrayList ad)
    {
        if (AdUtil.logDfpAds.isLoggable)
        {
            FwLog.logMethod(AdUtil.logDfpAds, new Object[0]);
        }
        if (ad == null || ad.isEmpty())
        {
            showDisplayAdsView(false);
            if (AdUtil.logDfpAds.isLoggable)
            {
                AdUtil.logDfpAds.log("Ads RTM request:  no response Ad content");
            }
        } else
        {
            ad = (com.ebay.common.rtm.RtmContent.Ad)ad.get(0);
            if (ad == null)
            {
                showDisplayAdsView(false);
                if (AdUtil.logDfpAds.isLoggable)
                {
                    AdUtil.logDfpAds.log("Ads RTM request:  empty response Ad content");
                    return;
                }
            } else
            {
                if (AdUtil.logDfpAdsSizes.isLoggable)
                {
                    AdUtil.logDeviceDisplayAttributes(this);
                    AdUtil.logAdContentSize(this, findViewById(0x7f10088b));
                }
                final LinearLayout adContainer = (LinearLayout)findViewById(0x7f10088b);
                if (adContainer.getWidth() == 0)
                {
                    final int visibility = adContainer.getVisibility();
                    adContainer.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                        final ItemViewActivity this$0;
                        final com.ebay.common.rtm.RtmContent.Ad val$ad;
                        final LinearLayout val$adContainer;
                        final int val$visibility;

                        public void onGlobalLayout()
                        {
                            adContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            adContainer.setVisibility(visibility);
                            loadDisplayAds(ad);
                        }

            
            {
                this$0 = ItemViewActivity.this;
                adContainer = linearlayout;
                visibility = i;
                ad = ad1;
                super();
            }
                    });
                    adContainer.setVisibility(0);
                    return;
                } else
                {
                    loadDisplayAds(ad);
                    return;
                }
            }
        }
    }

    private void renderEbayPlusSignup()
    {
        int i = 0;
        View view = findViewById(0x7f100878);
        if (view != null)
        {
            if (item.isShowEbayPlusPromo)
            {
                TextView textview = (TextView)findViewById(0x7f10087a);
                textview.setText(Html.fromHtml(item.displayEbayPlusSignupDescription));
                textview.setContentDescription(textview.getText().toString());
                view.setVisibility(0);
                view.setOnClickListener(this);
            }
            if (!item.isShowEbayPlusPromo)
            {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    private int renderPrimaryView()
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        isCondensedView = Boolean.valueOf(false);
        View view = descriptionLayout;
        byte byte0;
        int i;
        int j;
        if (TextUtils.isEmpty(item.description))
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
        findViewById(0x7f1002f7).setVisibility(8);
        findViewById(0x7f10087d).setVisibility(0);
        j = updateGalleryPhotos(viewData);
        if (j > 0)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        view = findViewById(0x7f1002f8);
        if (byte0 != 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view = findViewById(0x7f1002f9);
        if (byte0 != 0)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
        renderEbayPlusSignup();
        if (titleAndPriceFragment != null)
        {
            titleAndPriceFragment.render(item, viewData);
            findViewById(getTitleAndPriceLayoutToUse()).setVisibility(0);
        }
        if (variationsFragment != null && item.isMultiSku)
        {
            variationsFragment.render(item, viewData);
            findViewById(0x7f100355).setVisibility(0);
        } else
        {
            findViewById(0x7f100355).setVisibility(8);
        }
        if (!item.isBinOnly && !item.isClassifiedItem() && biddingHistoryFragment != null)
        {
            biddingHistoryFragment.render(item, viewData);
            findViewById(0x7f100877).setVisibility(0);
        } else
        {
            findViewById(0x7f100877).setVisibility(8);
        }
        if (itemSpecificsFragment != null)
        {
            itemSpecificsFragment.render(item, viewData);
            findViewById(0x7f100328).setVisibility(0);
        }
        if (aboutSellerFragment != null && !item.isSeller)
        {
            findViewById(0x7f10087c).setVisibility(0);
            aboutSellerFragment.render(item, viewData);
        }
        if (sprFragment != null)
        {
            sprFragment.render(item, viewData);
            findViewById(0x7f10087b).setVisibility(0);
        }
        renderDescription();
        renderProductDetails();
        if (item.isMultiSku)
        {
            setupMultiSKU();
        }
        setupCompatibility();
        setupButtonsAndClickableLayouts();
        renderSellerOffer();
        if (item.isProductReviewsAvailable && reviewsLayout != null)
        {
            reviewsLayout.setVisibility(0);
        }
        return j;
    }

    private void renderProductDetails()
    {
        if (!TextUtils.isEmpty(item.productDescription) || !TextUtils.isEmpty(item.productId) && (item.productListingDetails == null || item.productListingDetails.includePrefilledItemInformation))
        {
            productDetailsLayout.setOnClickListener(this);
            productDetailsLayout.setVisibility(0);
        }
    }

    private void renderSellerOffer()
    {
        View view = findViewById(0x7f100602);
        if (item.isSmeOfferAvailable)
        {
            ((TextView)findViewById(0x7f10086e)).setText(item.smeOfferMsg);
            ((TextView)findViewById(0x7f10086f)).setText(getString(0x7f0709fd, new Object[] {
                item.smeSellerName
            }));
            view.setVisibility(0);
            view.setOnClickListener(this);
            return;
        } else
        {
            view.setVisibility(8);
            return;
        }
    }

    private void requestMerchOnScroll()
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        if (merchFragment != null && updateMerch())
        {
            merchRequested = true;
        }
    }

    private void resetTitleAndPriceFragment()
    {
        if (isFinishing())
        {
            return;
        }
        if (titleAndPriceFragment != null)
        {
            FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
            fragmenttransaction.remove(titleAndPriceFragment);
            try
            {
                fragmenttransaction.commitAllowingStateLoss();
            }
            catch (IllegalStateException illegalstateexception)
            {
                logTag.logAsWarning("resetTitleAndPriceFragment exception", illegalstateexception);
            }
            titleAndPriceFragment = null;
        }
        findViewById(0x7f10086c).setVisibility(8);
        findViewById(0x7f10086d).setVisibility(8);
    }

    private void sellLike()
    {
        if (!needSignIn(UserAction.SELL_LIKE))
        {
            Intent intent = new Intent(this, com/ebay/mobile/sell/ListingFragmentActivity);
            intent.putExtra("site", EbaySite.getInstanceFromId(item.site));
            intent.putExtra("source_item_id", item.getIdString());
            intent.putExtra("listing_mode", "SellLikeItem");
            startActivity(intent);
        }
    }

    private void setScrollPosition(final int scrollY)
    {
        if (scrollY > 0)
        {
            final EbayScrollView scrollView = (EbayScrollView)findViewById(0x7f100017);
            scrollView.post(new Runnable() {

                final ItemViewActivity this$0;
                final EbayScrollView val$scrollView;
                final int val$scrollY;

                public void run()
                {
                    scrollView.scrollTo(0, scrollY);
                }

            
            {
                this$0 = ItemViewActivity.this;
                scrollView = ebayscrollview;
                scrollY = i;
                super();
            }
            });
        }
    }

    private void setViewAction(View view, final UserAction action, final String extra)
    {
        if (view != null)
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final ItemViewActivity this$0;
                final UserAction val$action;
                final String val$extra;

                public void onClick(View view1)
                {
                    handleAction(action, extra);
                }

            
            {
                this$0 = ItemViewActivity.this;
                action = useraction;
                extra = s;
                super();
            }
            });
        }
    }

    private void setupActionButtons()
    {
        setupWatchButton();
        Object obj = buyItNowBottomButton;
        View view;
        int i;
        if (obj != null)
        {
            if (item.isShowBuyItNow && !isButtonVisibleOnBuyBar(0x7f10087f))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                ((View) (obj)).setOnClickListener(this);
                ((View) (obj)).setVisibility(0);
            } else
            {
                ((View) (obj)).setVisibility(8);
            }
        }
        obj = findViewById(0x7f100881);
        if (obj != null)
        {
            if (item.isShowViewInCart && !isButtonVisibleOnBuyBar(0x7f100881) && MyApp.getDeviceConfiguration().isVIPBuyBarOverridePayForItemEnabled())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                setViewAction(((View) (obj)), UserAction.BUY_IT_NOW, null);
            }
            if (i != 0)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((View) (obj)).setVisibility(i);
        }
        obj = null;
        if (actionsFragment != null)
        {
            obj = actionsFragment.findButton(com.ebay.mobile.viewitem.fragments.ActionsFactory.Action.SELL_ONE_LIKE_THIS);
        }
        view = findViewById(0x7f100889);
        if (showSellLike() && obj == null)
        {
            view.setVisibility(0);
            view.setOnClickListener(this);
        } else
        {
            view.setVisibility(8);
        }
        view = findViewById(0x7f100884);
        if (!item.isSeller)
        {
            obj = MyApp.getPrefs().getCurrentUser();
        } else
        {
            obj = null;
        }
        if (item.isShowMakeOffer && (!MyApp.getPrefs().isSignedIn() || obj != null && item.remainingBestOffersForBuyer(((String) (obj))) > 0))
        {
            view.setVisibility(0);
            view.setOnClickListener(this);
        } else
        {
            view.setVisibility(8);
        }
        obj = findViewById(0x7f10087e);
        if (item.isShowPlaceBid && !isButtonVisibleOnBuyBar(0x7f10087e))
        {
            ((View) (obj)).setVisibility(0);
            ((View) (obj)).setOnClickListener(this);
        } else
        {
            ((View) (obj)).setVisibility(8);
        }
        obj = findViewById(0x7f100885);
        if (item.isShowAddToCart && !isButtonVisibleOnBuyBar(0x7f100885))
        {
            ((View) (obj)).setVisibility(0);
            ((View) (obj)).setOnClickListener(this);
        } else
        {
            ((View) (obj)).setVisibility(8);
        }
        obj = findViewById(0x7f100886);
        if (item.isShowViewInCart && !isButtonVisibleOnBuyBar(0x7f100886))
        {
            ((View) (obj)).setVisibility(0);
            ((View) (obj)).setOnClickListener(this);
        } else
        {
            ((View) (obj)).setVisibility(8);
        }
        obj = findViewById(0x7f100883);
        if (item.isShowBuyingOptions && !isButtonVisibleOnBuyBar(0x7f100883))
        {
            setViewAction(((View) (obj)), UserAction.BUYING_OPTIONS, null);
            ((View) (obj)).setVisibility(0);
        } else
        {
            ((View) (obj)).setVisibility(8);
        }
        obj = null;
        if (actionsFragment != null)
        {
            obj = actionsFragment.findButton(com.ebay.mobile.viewitem.fragments.ActionsFactory.Action.BUY_ANOTHER);
        }
        view = findViewById(0x7f100882);
        if (item.isShowBuyAnother && obj == null && !isButtonVisibleOnBuyBar(0x7f100882))
        {
            setViewAction(view, UserAction.BUY_ANOTHER, null);
            view.setVisibility(0);
        } else
        {
            view.setVisibility(8);
        }
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.ViewItem.B.shareAsButton))
        {
            obj = findViewById(0x7f10088a);
            if (obj != null)
            {
                setViewAction(((View) (obj)), UserAction.SHARE, null);
                ((View) (obj)).setVisibility(0);
            }
        }
    }

    private Button setupButton(int i)
    {
        Button button = (Button)findViewById(i);
        if (button != null)
        {
            button.setOnClickListener(this);
        }
        return button;
    }

    private void setupButtonsAndClickableLayouts()
    {
        renderBuyBar();
        refreshButtonVisiblity();
        setupActionButtons();
    }

    private int setupBuyBar()
    {
        Object obj = MyApp.getDeviceConfiguration();
        int ai[];
        int k;
        int l;
        if (setupWatchButton())
        {
            k = 1;
        } else
        {
            k = 0;
        }
        ai = new int[7];
        int[] _tmp = ai;
        ai[0] = 0x7f10089d;
        ai[1] = 0x7f1004d7;
        ai[2] = 0x7f1007c8;
        ai[3] = 0x7f10089c;
        ai[4] = 0x7f10089b;
        ai[5] = 0x7f10089e;
        ai[6] = 0x7f10089a;
        l = ai.length;
        for (int i = 0; i < l; i++)
        {
            findViewById(ai[i]).setVisibility(8);
        }

        int i1 = 0;
        int j = i1;
        l = k;
        boolean flag;
        if (item.isBidWithBin)
        {
            j = i1;
            l = k;
            if (buyBarSetupPlaceBidButton())
            {
                l = k + 1;
                View view;
                if (l == 2)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
            }
        }
        k = j;
        i1 = l;
        if (j == 0)
        {
            k = j;
            i1 = l;
            if (buyBarSetupAddToCartButton(((DcsHelper) (obj))))
            {
                i1 = l + 1;
                if (i1 == 2)
                {
                    k = 1;
                } else
                {
                    k = 0;
                }
            }
        }
        flag = k;
        j = i1;
        if (k == 0)
        {
            flag = k;
            j = i1;
            if (buyBarSetupViewInCartButton(((DcsHelper) (obj))))
            {
                j = i1 + 1;
                if (j == 2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
        }
        view = findViewById(0x7f10089d);
        l = j;
        if (view != null)
        {
            if (!flag && item.isShowViewInCart && ((DcsHelper) (obj)).isVIPBuyBarOverridePayForItemEnabled())
            {
                k = 1;
            } else
            {
                k = 0;
            }
            l = j;
            if (k != 0)
            {
                setViewAction(view, UserAction.BUY_IT_NOW, null);
                l = j + 1;
            }
            if (k != 0)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            view.setVisibility(j);
        }
        if (l == 2)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        i1 = j;
        k = l;
        if (!item.isBidWithBin)
        {
            i1 = j;
            k = l;
            if (j == 0)
            {
                i1 = j;
                k = l;
                if (buyBarSetupPlaceBidButton())
                {
                    k = l + 1;
                    if (k == 2)
                    {
                        i1 = 1;
                    } else
                    {
                        i1 = 0;
                    }
                }
            }
        }
        obj = findViewById(0x7f10089b);
        j = k;
        if (obj != null)
        {
            if (item.isShowBuyingOptions && i1 == 0)
            {
                l = 1;
            } else
            {
                l = 0;
            }
            if (l != 0)
            {
                setViewAction(((View) (obj)), UserAction.BUYING_OPTIONS, null);
            }
            if (l != 0)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            ((View) (obj)).setVisibility(j);
            j = k;
            if (l != 0)
            {
                j = k + 1;
            }
        }
        if (j == 2)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        obj = findViewById(0x7f10089e);
        k = j;
        if (obj != null)
        {
            if (item.isShowBuyItNow && l == 0)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            if (k != 0)
            {
                setViewAction(((View) (obj)), UserAction.BUY_IT_NOW, null);
            }
            if (k != 0)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            ((View) (obj)).setVisibility(i1);
            if (k != 0)
            {
                k = j + 1;
            } else
            if (l != 0 && item.isShowBuyItNow)
            {
                buyItNowBottomButton.setOnClickListener(this);
                buyItNowBottomButton.setVisibility(0);
                k = j;
            } else
            {
                buyItNowBottomButton.setVisibility(8);
                k = j;
            }
        }
        if (k == 2)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        obj = findViewById(0x7f10089a);
        l = k;
        if (obj != null)
        {
            if (item.isShowBuyAnother && j == 0)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (j != 0)
            {
                setViewAction(((View) (obj)), UserAction.BUY_ANOTHER, null);
            }
            if (j != 0)
            {
                l = 0;
            } else
            {
                l = 8;
            }
            ((View) (obj)).setVisibility(l);
            l = k;
            if (j != 0)
            {
                l = k + 1;
            }
        }
        return l;
    }

    private void setupCompatibility()
    {
        boolean flag1 = false;
        int i;
        if (item.itemCompatibiltyList != null && item.itemCompatibiltyList.size() > 0)
        {
            Object obj1 = Item.getMatchingVehicles(item);
            boolean flag;
            if (!((ArrayList) (obj1)).isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                DelimitedStringBuilder delimitedstringbuilder = new DelimitedStringBuilder(", ");
                for (obj1 = ((ArrayList) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); delimitedstringbuilder.append(((Vehicle)((Iterator) (obj1)).next()).getName())) { }
                compatibleWithGarageList.setText(getString(0x7f0704ac, new Object[] {
                    delimitedstringbuilder.toString()
                }));
            }
            Object obj = compatibleWithGarageList;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((TextView) (obj)).setVisibility(i);
        }
        obj = compatibleWithLayout;
        if (item.itemCompatibiltyList != null && !item.itemCompatibiltyList.isEmpty())
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
    }

    public static void setupInventoryInfo(Context context, Item item, ViewItemViewData viewitemviewdata)
    {
        item.inventoryInfo = new InventoryInfo();
        item.inventoryInfo.setSellerUserId(item.sellerUserId);
        if (item.isMultiSku)
        {
            item.inventoryInfo.setItemSku(item.getVariationSKU(viewitemviewdata.nameValueList));
        } else
        {
            item.inventoryInfo.setItemSku(item.sku);
        }
        item.inventoryInfo.setSearchRefinedPostalCode(viewitemviewdata.searchRefinedPostalCode);
        item.inventoryInfo.setDerivation(com.ebay.common.model.inventory.InventoryInfo.ListDerivation.UNKNOWN);
        context = LocationUtil.getAvailableLocation(context, viewitemviewdata.searchRefinedPostalCode, item.site);
        if (context == null) goto _L2; else goto _L1
_L1:
        if (context.getLatitude() == null || context.getLongitude() == null) goto _L4; else goto _L3
_L3:
        viewitemviewdata = DeviceConfiguration.getAsync();
        item.inventoryInfo.setUserLocation(new LatLng(context.getLatitude().doubleValue(), context.getLongitude().doubleValue()), viewitemviewdata.get(DcsInteger.BopisGeocoderBiasBoxSize));
        context = MyApp.getPrefs().getPostalCode();
        if (context != null)
        {
            item.inventoryInfo.setPostalCode(((PostalCodeSpecification) (context)).postalCode);
        }
_L2:
        item.inventoryInfo.setForceInventoryLookup(true);
        item.inventoryInfo.site = item.site;
        return;
_L4:
        if (context.getPostalCode() != null)
        {
            item.inventoryInfo.setPostalCode(context.getPostalCode());
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void setupMultiSKU()
    {
        Object obj;
label0:
        {
            Object obj1;
            NameValue namevalue;
            if (viewData != null)
            {
                obj = viewData.nameValueList;
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                obj1 = obj;
                if (!((ArrayList) (obj)).isEmpty())
                {
                    break label0;
                }
            }
            obj1 = obj;
            if (!item.mskuSelections.isEmpty())
            {
                obj1 = item.mskuSelections;
            }
        }
        obj = new StringBuilder();
        if (obj1 != null && item.hasMultiSkuValues(((List) (obj1))))
        {
            for (obj1 = ((ArrayList) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((StringBuilder) (obj)).append(namevalue.getValue()))
            {
                namevalue = (NameValue)((Iterator) (obj1)).next();
                if (((StringBuilder) (obj)).length() > 0)
                {
                    ((StringBuilder) (obj)).append(", ");
                }
            }

        } else
        if (isMultiSKUSelectable())
        {
            ((StringBuilder) (obj)).append(getResources().getString(0x7f07099b));
        }
    }

    private void setupTitleAndPriceFragment()
    {
        while (isFinishing() || item == null || titleAndPriceFragment != null) 
        {
            return;
        }
        try
        {
            FragmentManager fragmentmanager = getFragmentManager();
            FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();
            titleAndPriceFragment = new ViewItemTitleAndPriceFragment();
            titleAndPriceFragment.setArguments(new Bundle());
            fragmenttransaction.replace(getTitleAndPriceLayoutToUse(), titleAndPriceFragment);
            fragmenttransaction.commitAllowingStateLoss();
            fragmentmanager.executePendingTransactions();
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            return;
        }
    }

    private boolean setupWatchButton()
    {
        Object obj;
        Object obj1;
        Object obj2;
        boolean flag;
        if (item.isShowWatch || item.isShowUnwatch)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj1 = (TextImageButton)findViewById(0x7f100899);
        obj2 = (TextImageButton)findViewById(0x7f100880);
        if (actionsFragment == null || !actionsFragment.isShowingButtons())
        {
            obj = obj1;
        } else
        {
            obj = obj2;
        }
        if (obj == obj1)
        {
            obj1 = obj2;
        }
        if (flag)
        {
            if (item.isShowWatch)
            {
                obj2 = UserAction.WATCH;
            } else
            {
                obj2 = UserAction.UNWATCH;
            }
            setViewAction(((View) (obj)), ((UserAction) (obj2)), null);
            if (item.isShowWatch)
            {
                obj2 = getString(0x7f070511);
            } else
            {
                obj2 = getString(0x7f07050b);
            }
            ((TextImageButton) (obj)).setText(((CharSequence) (obj2)));
            ((TextImageButton) (obj)).setVisibility(0);
        } else
        {
            ((TextImageButton) (obj)).setVisibility(8);
        }
        ((TextImageButton) (obj1)).setVisibility(8);
        return flag;
    }

    private void share()
    {
        TrackingData trackingdata = new TrackingData("Sharing", TrackingType.EVENT);
        if (item != null)
        {
            trackingdata.addKeyValuePair("itm", item.getIdString());
        }
        trackingdata.send(this);
        startActivity(Intent.createChooser(ShareItemsUtil.generateShareItemIntent(this, item), getString(0x7f070a54)));
    }

    private boolean showAddToCart()
    {
        return item.isShowAddToCart;
    }

    private void showDialog(String s, String s1, String s2, String s3, int i)
    {
        com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
        if (s != null)
        {
            builder.setTitle(s);
        }
        builder.setRetainInstance(false);
        builder.setMessage(s1);
        builder.setPositiveButton(s2);
        if (s3 != null)
        {
            builder.setNegativeButton(s3);
        }
        builder.createFromActivity(i).show(getFragmentManager(), null);
    }

    private void showDialogItemDoesNotShipToYou(String s)
    {
        showDialog(s, getString(0x7f07068c), getString(0x7f070738), getString(0x7f0701cc), 5);
    }

    private void showDialogOk(String s)
    {
        showDialog(getString(0x7f07049c), s, getString(0x7f070738), null, 0);
    }

    private void showDialogPpaUpgrade()
    {
        PpaUpgradeConfirmDialog.create(this, false).show();
    }

    private void showDisplayAdsView(boolean flag)
    {
        int i = 0;
        if (AdUtil.logDfpAds.isLoggable)
        {
            FwLog.logMethod(AdUtil.logDfpAds, new Object[0]);
        }
        if (!isFinishing())
        {
            LinearLayout linearlayout = (LinearLayout)findViewById(0x7f10088b);
            if (!flag)
            {
                i = 8;
            }
            linearlayout.setVisibility(i);
            if (!flag && adView != null)
            {
                linearlayout.removeView(adView);
                adView = null;
                return;
            }
        }
    }

    private void showEbnOrderDetails()
    {
        if (fromEbnOrderDetails)
        {
            finish();
            return;
        } else
        {
            EbnOrderDetailsActivity.StartActivity(this, viewData, new SourceIdentification(getTrackingEventName()));
            return;
        }
    }

    private boolean showEndItem()
    {
        return item.isShowEndItem;
    }

    private boolean showEnterTrackingNumber()
    {
        return item.isShowEnterTrackingNumber;
    }

    private boolean showErrorIfAuctionEnded()
    {
        boolean flag = item.isAuctionEnded;
        if (flag)
        {
            showDialogOk(getString(0x7f07049d));
        }
        return flag;
    }

    private void showGoogleTextAdsView(boolean flag)
    {
        if (!isFinishing())
        {
            LinearLayout linearlayout = (LinearLayout)findViewById(0x7f10088d);
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            linearlayout.setVisibility(i);
            if (!flag && googleTextAdView != null)
            {
                linearlayout.removeView(googleTextAdView);
                googleTextAdView = null;
                return;
            }
        }
    }

    private void showHideTranslucentProgress(boolean flag)
    {
        showHideTranslucentProgress(flag, false);
    }

    private void showHideTranslucentProgress(boolean flag, boolean flag1)
    {
        ItemViewCommonProgressAndError.LayoutState layoutstate;
        if (flag)
        {
            layoutstate = ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS;
        } else
        {
            layoutstate = ItemViewCommonProgressAndError.LayoutState.NORMAL;
        }
        layoutState = layoutstate;
        layoutstate = layoutState;
        if (flag1 || !initialLoadComplete || !isPullToRefresh)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ItemViewCommonProgressAndError.showLayouts(this, null, layoutstate, flag);
    }

    private boolean showLeaveFeedback()
    {
        return item.isShowLeaveFeedback;
    }

    private boolean showMarkAsPaid()
    {
        return item.isShowMarkAsPaid;
    }

    private boolean showMarkAsUnPaid()
    {
        return item.isShowMarkAsUnPaid;
    }

    private boolean showMarkNotShipped()
    {
        return item.isShowMarkAsUnShipped;
    }

    private boolean showMarkShipped()
    {
        return item.isShowMarkAsShipped;
    }

    private boolean showRelist()
    {
        return item.isShowRelist;
    }

    private boolean showRevise()
    {
        return item.isShowRevise;
    }

    private boolean showSellLike()
    {
        return item.isShowSellLike && !item.isAuctionEnded;
    }

    private boolean showTrackPackage()
    {
        return item.isShowTrackPackage;
    }

    private void startAddressBookActivity()
    {
        if (shippingAddresses != null)
        {
            Intent intent = new Intent(this, com/ebay/mobile/checkout/AddressListActivity);
            intent.setAction("android.intent.action.EDIT");
            intent.putExtra("xo_state_shipping_addresses", (Serializable)shippingAddresses);
            startActivityForResult(intent, 15);
        }
    }

    private void startBiddingActivity()
    {
        ItemViewBiddingActivity.StartActivity(this, viewData, item.thumbnailImage);
    }

    private void startConfirmation(boolean flag, ItemCurrency itemcurrency)
    {
        itemcurrency = new CurrencyAmount(itemcurrency);
        com.ebay.mobile.Item.BidBounds bidbounds = item.minimumToBid;
        boolean flag2 = false;
        boolean flag1 = flag2;
        if (bidbounds != null)
        {
            flag1 = flag2;
            if (bidbounds.lowerBound != null)
            {
                flag1 = bidbounds.lowerBound.equals(itemcurrency);
            }
        }
        ViewItemConfirmActivity.StartActivity(this, null, isUseNewUi(item, flag), viewData, 1, itemcurrency, flag, referrer, bidSource, flag1, fromMyEbayOrReminders, 12);
    }

    private void startPlusSignupFlow()
    {
        ReturnParamsWebViewActivity.start(this, DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.ViewItem.S.ebayPlusSignupLink), "", "EPlusSignupTap", Integer.valueOf(21), true, true, true);
    }

    private void startSPRActivity()
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = flag1;
        if (!item.isMultiSku) goto _L2; else goto _L1
_L1:
        if (item.isPudoable || item.isBopisable) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (!item.isEbayNowAvailable) goto _L2; else goto _L4
_L4:
        if (item.hasMultiSkuValues(viewData.nameValueList)) goto _L6; else goto _L5
_L5:
        flag = false;
        ViewItemChooseVariationsActivity.startActivity(this, viewData, ViewItemChooseVariationsActivity.IntendedAction.SPR);
_L2:
        if (flag)
        {
            ViewItemShippingPaymentsReturnsActivity.StartActivity(this, viewData, 19);
        }
        return;
_L6:
        flag = flag1;
        if (!item.isInventoryCallFail)
        {
            flag = flag1;
            if (item.inventoryInfo == null)
            {
                viewData.isLoadSprAfterInventoryCall = true;
                getStoreAvailability();
                flag = false;
            }
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    private void trackItemViewEvent(String s)
    {
        Object obj;
        boolean flag2 = getTrackingEventName().equals(s);
        StoreAvailability storeavailability;
        boolean flag;
        int i;
        boolean flag1;
        if (flag2)
        {
            obj = TrackingType.PAGE_IMPRESSION;
        } else
        {
            obj = TrackingType.EVENT;
        }
        obj = new TrackingData(s, "ViewItemFlags", ((TrackingType) (obj)));
        if (item == null) goto _L2; else goto _L1
_L1:
        if (flag2)
        {
            s = getIntent();
            ((TrackingData) (obj)).addSourceIdentification(s);
            ((TrackingData) (obj)).addKeyValuePair("iid", s.getStringExtra("feed_interest_id"));
            s.removeExtra("feed_interest_id");
            if (DeviceInfoUtil.isPortrait(this))
            {
                s = "p";
            } else
            {
                s = "l";
            }
            ((TrackingData) (obj)).addKeyValuePair("ort", s);
            if (item.isSmeOfferAvailable)
            {
                s = "1";
            } else
            {
                s = "0";
            }
            ((TrackingData) (obj)).addKeyValuePair("sop", s);
            if (item.isSmeOfferAvailable)
            {
                ((TrackingData) (obj)).addKeyValuePair("offer_id", item.smeOfferId);
                ((TrackingData) (obj)).addKeyValuePair("offer_type", item.smeOfferType);
            }
        }
        if (!item.isBopisable) goto _L4; else goto _L3
_L3:
        if (MyApp.getPrefs().getPostalCode() != null)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        ((TrackingData) (obj)).addKeyValuePair("saa", s);
        if (item.inventoryInfo == null || item.inventoryInfo.getAvailabilities() == null || item.inventoryInfo.getAvailabilities().size() <= 0) goto _L6; else goto _L5
_L5:
        flag1 = true;
        s = item.inventoryInfo.getAvailabilities().iterator();
        do
        {
            flag = flag1;
            if (!s.hasNext())
            {
                break;
            }
            storeavailability = (StoreAvailability)s.next();
            if (storeavailability == null || com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.OUT_OF_STOCK.equals(storeavailability.availability))
            {
                continue;
            }
            flag = false;
            break;
        } while (true);
        if (flag)
        {
            ((TrackingData) (obj)).addKeyValuePair("ostk", "1");
        }
        ((TrackingData) (obj)).addKeyValuePair("storeavlbl", "1");
_L8:
        ((TrackingData) (obj)).addKeyValuePair("mlocset", LocationUtil.getAvailableProvidersForTracking(this));
_L4:
        ((TrackingData) (obj)).addKeyValuePair("itm", item.getIdString());
        if (item.title != null)
        {
            ((TrackingData) (obj)).addKeyValuePair("itmtitle", item.title.getSourceContent());
        }
        ((TrackingData) (obj)).addKeyValuePair("shipsiteid", item.site);
        ((TrackingData) (obj)).addKeyValuePair("leaf", Long.toString(item.primaryCategoryId));
        s = item.currentPriceForType(getEbayContext(), viewData);
        if (s != null && ((ItemCurrency) (s)).value != null)
        {
            ((TrackingData) (obj)).addKeyValuePair("curprice", String.format(Locale.US, "%.2f", new Object[] {
                Double.valueOf(Double.parseDouble(((ItemCurrency) (s)).value))
            }));
        }
        if (item.isBidOnly || item.isBidWithBin)
        {
            ((TrackingData) (obj)).addKeyValuePair("bc", Integer.toString(item.bidCount));
            if (item.allBidders != null)
            {
                ((TrackingData) (obj)).addKeyValuePair("bdrs", Integer.toString(item.allBidders.countBidders()));
            }
            if (item.minimumToBid != null && item.currentPrice != null)
            {
                ((TrackingData) (obj)).addKeyValuePair("bi", Double.toString(item.minimumToBid.lowerBound.subtract(new CurrencyAmount(item.currentPrice)).getValueAsDouble()));
            }
        }
        if (item.productId != null)
        {
            ((TrackingData) (obj)).addKeyValuePair("pri", item.productId);
        }
        ((TrackingData) (obj)).addKeyValuePair("qtya", Integer.toString(item.getQuantityAvailable(viewData.nameValueList)));
        ((TrackingData) (obj)).addKeyValuePair("qtys", Integer.toString(item.quantitySold));
        ((TrackingData) (obj)).addKeyValuePair("SPR", Integer.toString(item.paymentReminderState.ordinal()));
        if (item.endDate != null)
        {
            ((TrackingData) (obj)).addKeyValuePair("tr", Long.toString((item.endDate.getTime() - System.currentTimeMillis()) / 1000L));
        }
        s = item.getVariationId(viewData.nameValueList);
        if (s != null)
        {
            ((TrackingData) (obj)).addKeyValuePair("var", s);
        }
        ((TrackingData) (obj)).addKeyValuePair("nw", Integer.toString(item.watchCount));
        if (searchResultsRank > 0)
        {
            ((TrackingData) (obj)).addKeyValuePair("srrank", Integer.toString(searchResultsRank));
        }
        if (showAddToCart())
        {
            ((TrackingData) (obj)).addFlag(117);
        }
        if (item.isShowFastAndFree)
        {
            ((TrackingData) (obj)).addFlag(145);
        }
        if (item.isActive)
        {
            ((TrackingData) (obj)).addFlag(23);
        }
        ((TrackingData) (obj)).addKeyValuePair("trknvpsvc", item.vlsResponseTrackingData);
        ((TrackingData) (obj)).addKeyValuePair("rq", item.vlsResponseTrackingCorrelationId);
        if (!TextUtils.isEmpty(item.shortDescription))
        {
            ((TrackingData) (obj)).addKeyValuePair("snp", "1");
        }
        if (item.isProductReviewsAvailable && item.productReviewCount > 0L)
        {
            ((TrackingData) (obj)).addKeyValuePair("PR", Long.toString(item.productReviewCount));
        }
        ((TrackingData) (obj)).addKeyValuePair("vls", "1");
        if (item.isEbayNowAvailable)
        {
            ((TrackingData) (obj)).addKeyValuePair("ebn", "1");
        }
        if (getResources().getBoolean(0x7f0b0002))
        {
            s = "0";
        } else
        {
            s = "1";
        }
        ((TrackingData) (obj)).addKeyValuePair("FL_bar", s);
        if (item.nectarRewards != null)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        ((TrackingData) (obj)).addKeyValuePair("Nectar", s);
        if (item.bucksRewards != null)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        ((TrackingData) (obj)).addKeyValuePair("eBayBucks", s);
        if (item.isPudoable)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        ((TrackingData) (obj)).addKeyValuePair("pudo", s);
        if (item.isEbayPlusLogoShown)
        {
            if (item.isEbayPlusMember)
            {
                s = "1";
            } else
            {
                s = "0";
            }
            ((TrackingData) (obj)).addKeyValuePair("Epm", s);
        }
_L2:
        s = getIntent();
        i = s.getIntExtra("noti_type_id", -1);
        if (i != -1)
        {
            NotificationTrackingUtil.addNotificationTracking(this, ((TrackingData) (obj)), s, NotificationPreference.idToName(i));
        }
        if (flag2)
        {
            ((TrackingData) (obj)).addExperimentServedTags(viewData.adsExperimentState);
        }
        ((TrackingData) (obj)).send(this);
        return;
_L6:
        ((TrackingData) (obj)).addKeyValuePair("storeavlbl", "0");
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void updateLocalNotificationsItemAddedToCart()
    {
        if (item != null && item.title != null)
        {
            Object obj = DeviceConfiguration.getAsync();
            obj = item.title.getContent(((DeviceConfiguration) (obj)).get(DcsBoolean.itemTitleTranslationEnabled));
            obj = new com.ebay.common.model.mdns.PlatformNotificationsEvent.CartItemEndingEvent(Long.valueOf(item.id), item.endDate, ((String) (obj)), item.galleryUrl);
            Intent intent = new Intent(this, com/ebay/mobile/notifications/PollService);
            intent.setAction("com.ebay.mobile.service.ADD_ITEM_LOCAL_NOTIFICATIONS_CART");
            intent.putExtra("cart_item_ending_events", ((android.os.Parcelable) (obj)));
            startService(intent);
        }
    }

    private boolean updateMerch()
    {
        boolean flag = false;
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        if (!item.isActive)
        {
            merchFragment.updatePlacementId(0x18755L);
        }
        if (!item.isSeller)
        {
            merchFragment.loadMerchandise(item.isTransacted, new long[] {
                item.id
            });
            flag = true;
        }
        return flag;
    }

    private void updateShoppingCart()
    {
        if (MyApp.getPrefs().isSignedIn() && MyApp.getDeviceConfiguration().isShoppingCartEnabled() && viewItemDataManager != null)
        {
            viewItemDataManager.refreshCart(viewData);
        }
    }

    private void userRefreshed()
    {
        AppSpeedShim appspeedshim = (AppSpeedShim)getShim(com/ebay/mobile/appspeed/AppSpeedShim);
        if (appspeedshim != null)
        {
            appspeedshim.reload();
        }
        if (viewItemDataManager != null)
        {
            showHideTranslucentProgress(true);
            if (sprFragment != null)
            {
                sprFragment.setForceReRender();
            }
            viewItemDataManager.forceReloadData(viewData);
        }
    }

    private void vibrateAndHighlightIfNeeded()
    {
        if (hasWindowFocus())
        {
            Util.vibratePhone(this);
            if (titleAndPriceFragment != null)
            {
                titleAndPriceFragment.highlightPrice();
            }
        }
    }

    private void viewRelistedItem()
    {
        try
        {
            StartActivity(this, Long.valueOf(Long.parseLong(item.relistedId)).longValue(), com.ebay.common.ConstantsCommon.ItemKind.Found);
            return;
        }
        catch (NumberFormatException numberformatexception)
        {
            return;
        }
    }

    public void deleteCachedItem()
    {
        if (viewItemDataManager != null)
        {
            viewItemDataManager.markDirty();
        }
    }

    public void doAddToCart()
    {
        sendAddToCartClickTracking();
        if (item.isIspuOnly && !MyApp.getDeviceConfiguration().isBopisEnabled())
        {
            showDialogOk(getString(0x7f0701c8));
        } else
        {
            if (item.needsToSelectMultiSku(viewData.nameValueList))
            {
                ViewItemChooseVariationsActivity.startActivity(this, viewData, ViewItemChooseVariationsActivity.IntendedAction.ADD_TO_CART);
                return;
            }
            if (!needSignIn(UserAction.ADD_TO_CART))
            {
                if (MyApp.getPrefs().getUserIsPpa())
                {
                    showDialogPpaUpgrade();
                    return;
                }
                if (viewItemDataManager != null)
                {
                    String s = item.getVariationId(viewData.nameValueList);
                    viewItemDataManager.addItemToCart(Long.valueOf(item.id), s, item.inventoryInfo, 1);
                    showHideTranslucentProgress(true, true);
                    layoutState = ItemViewCommonProgressAndError.LayoutState.NORMAL;
                    return;
                }
            }
        }
    }

    public void doBin()
    {
        doBin(false);
    }

    public void doBin(boolean flag)
    {
        sendBuyItNowClickTracking();
        if (item.isIspuOnly && !MyApp.getDeviceConfiguration().isBopisEnabled())
        {
            showDialogOk(getString(0x7f0701c8));
        } else
        {
            if (item.isAuctionEnded)
            {
                showDialogOk(getString(0x7f0704d3));
                return;
            }
            if (item.isShowBuyItNow || item.isShowBuyAnother)
            {
                if (item.needsToSelectMultiSku(viewData.nameValueList))
                {
                    ViewItemChooseVariationsActivity.startActivity(this, viewData, ViewItemChooseVariationsActivity.IntendedAction.BIN);
                    return;
                }
                if (!needSignIn(UserAction.BUY_IT_NOW))
                {
                    if (ItemViewPayPalable.canUseImmediatePayment(item))
                    {
                        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
                        if (!item.embeddedMobileCheckoutEnabled && !dcshelper.isMecOrMec2Enabled(item.site))
                        {
                            ErrorDialogActivity.StartActivity(this, getString(0x7f0701c4), getString(0x7f0701c8), false);
                            return;
                        }
                        if (!ItemViewPayPalable.canUsePaypal(this, item))
                        {
                            ErrorDialogActivity.StartActivity(this, getString(0x7f0701c4), getString(0x7f07017f), false);
                            return;
                        }
                    }
                    viewData.buyAnother = flag;
                    if (item.isBopisable && item.inventoryInfo == null)
                    {
                        setupInventoryInfo(this, item, viewData);
                    }
                    if (item.getQuantityAvailable(viewData.nameValueList) > 1)
                    {
                        ItemViewGetQuantityActivity.StartActivity(this, viewData, referrer, bidSource, fromMyEbayOrReminders, 13);
                        return;
                    }
                    if (ItemViewPayPalable.canUseImmediatePayment(item))
                    {
                        if (ItemViewPayPalable.canUsePaypal(this, item))
                        {
                            (new TrackingData("Autopay", TrackingType.EVENT)).send(this);
                            payForItems(this, item, viewData, item.quantityPurchased, Boolean.valueOf(true), bidSource, referrer);
                            return;
                        }
                    } else
                    {
                        startConfirmation(true, item.buyItNowPrice);
                        return;
                    }
                }
            }
        }
    }

    public void doBuyAnother()
    {
        if (item.isMultiSku)
        {
            viewData.buyAnother = true;
            ViewItemChooseVariationsActivity.startActivity(this, viewData, ViewItemChooseVariationsActivity.IntendedAction.BIN);
            return;
        } else
        {
            doBin(true);
            return;
        }
    }

    public void doMakeOffer()
    {
        if (!needSignIn(UserAction.MAKE_OFFER))
        {
            String s = MyApp.getPrefs().getCurrentUser();
            if (item.remainingBestOffersForBuyer(s) < 1)
            {
                showDialogOk(getString(0x7f070b78));
            } else
            if (!item.canMakeFirstOffer(s))
            {
                if (!item.bestOfferEnabled)
                {
                    showDialogOk(getString(0x7f07018b));
                }
                if (item.bestOfferPending(s))
                {
                    showDialogOk(getString(0x7f07018c));
                    return;
                }
            } else
            {
                Intent intent = new Intent(this, com/ebay/mobile/bestoffer/BuyerMakeOfferActivity);
                intent.putExtra("item_view_id", itemId);
                intent.putExtra("item_view_tx_id", transactionId);
                intent.putExtra("view_item_view_data", viewData);
                intent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
                intent.putExtra("com.ebay.mobile.tracking.Referrer", referrer);
                startActivityForResult(intent, 7);
                return;
            }
        }
    }

    public void doViewCart()
    {
        TrackingData trackingdata = new TrackingData("ViewInCart", TrackingType.EVENT);
        if (item != null)
        {
            trackingdata.addKeyValuePair("itm", item.getIdString());
        }
        trackingdata.send(this);
        if (!needSignIn(UserAction.VIEW_CART))
        {
            startActivityForResult(new Intent(this, com/ebay/mobile/shoppingcart/ShoppingCartActivity), 17);
        }
    }

    public String getBeamPushUrl()
    {
        return DeepLinkUtil.getStringForItemViewUrl(item, false);
    }

    public String getTrackingEventName()
    {
        return "ViewItem";
    }

    public void handleAddShipmentTrackingResult(int i, Intent intent)
    {
        if (i == -1)
        {
            Object obj = MyApp.getPrefs().getAuthentication();
            if (obj != null && viewItemDataManager != null)
            {
                i = intent.getIntExtra("state", -1);
                ShipmentTracking shipmenttracking = new ShipmentTracking();
                if (i != 0)
                {
                    shipmenttracking.addDetail(intent.getStringExtra("number"), intent.getStringExtra("carrier"));
                }
                intent = EbayApiUtil.getTradingApi(this, ((Authentication) (obj)));
                obj = viewItemDataManager;
                long l = itemId;
                long l1 = transactionId.longValue();
                boolean flag;
                if (!shipmenttracking.details.isEmpty())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ((ViewItemDataManager) (obj)).addShipmentTracking(intent, Long.valueOf(l), l1, shipmenttracking, Boolean.valueOf(flag), null);
                showHideTranslucentProgress(true, true);
            }
        }
    }

    public void handlePaymentOptions()
    {
        doPaymentOptions(0x7f070766);
    }

    public void hideProgress()
    {
        hideTranslucentProgress();
    }

    public boolean needSignIn(UserAction useraction)
    {
        boolean flag;
        if (!MyApp.getPrefs().isSignedIn())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            userAction = useraction;
            boolean flag1 = DeviceConfiguration.getAsync().get(DcsBoolean.connectSignInModalDialog);
            Object obj;
            if (flag1)
            {
                obj = com/ebay/mobile/activities/SignInModalActivity;
            } else
            {
                obj = com/ebay/mobile/activities/SignInActivity;
            }
            obj = new Intent(this, ((Class) (obj)));
            if (flag1)
            {
                ((Intent) (obj)).setFlags(0x20000);
            }
            ((Intent) (obj)).putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName()));
            if (useraction == UserAction.WATCH)
            {
                ((Intent) (obj)).putExtra("fromHome", true);
            }
            startActivityForResult(((Intent) (obj)), 11);
        }
        return flag;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (j != -1 || intent == null) goto _L2; else goto _L1
_L1:
        ViewItemViewData viewitemviewdata = (ViewItemViewData)intent.getParcelableExtra("view_item_view_data");
        if (!intent.hasExtra("transaction_id")) goto _L2; else goto _L3
_L3:
        long l = intent.getLongExtra("transaction_id", -1L);
        if (transactionId != null || l == -1L) goto _L2; else goto _L4
_L4:
        viewData.buyAnother = false;
        if (item == null) goto _L6; else goto _L5
_L5:
        reinitializeDataManager(viewitemviewdata, l);
_L22:
        return;
_L6:
        transactionId = Long.valueOf(l);
        return;
_L2:
        i;
        JVM INSTR lookupswitch 19: default 256
    //                   1: 1102
    //                   2: 661
    //                   3: 661
    //                   4: 661
    //                   5: 1093
    //                   6: 1420
    //                   7: 1133
    //                   8: 1133
    //                   9: 661
    //                   11: 390
    //                   12: 345
    //                   13: 345
    //                   14: 318
    //                   15: 272
    //                   16: 1376
    //                   18: 462
    //                   19: 1447
    //                   21: 1506
    //                   112: 1317;
           goto _L7 _L8 _L9 _L9 _L9 _L10 _L11 _L12 _L12 _L9 _L13 _L14 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L7:
        break; /* Loop/switch isn't completed */
_L20:
        break MISSING_BLOCK_LABEL_1506;
_L23:
        if (item != null)
        {
            refreshOtherActivities(this, item);
            return;
        }
          goto _L22
_L16:
        intent = getEbayContext();
        MyEbayLandingActivity.setWatchingInvalid(intent);
        MyEbayLandingActivity.setBuyingInvalid(intent);
        SellingListActivity.setSellingInvalid(intent);
        if (item != null)
        {
            invalidateCache(item.id, (Long)null);
        }
        issueRefresh(true);
          goto _L23
_L15:
        if (503 == j)
        {
            issueRefresh();
        } else
        if (j == -1)
        {
            issueRefresh(true);
        }
          goto _L23
_L14:
        if (j != 0)
        {
            if (-1 == j)
            {
                handleConfirmComplete();
            } else
            if (502 == j)
            {
                showDialogPpaUpgrade();
            } else
            {
                issueRefresh();
            }
        }
        viewData.buyAnother = false;
          goto _L23
_L13:
        boolean flag = true;
        i = ((flag) ? 1 : 0);
        if (-1 == j)
        {
            i = ((flag) ? 1 : 0);
            if (MyApp.getPrefs().isSignedIn())
            {
                i = 0;
                if (sprFragment != null)
                {
                    sprFragment.setForceReRender();
                }
                viewData.shippingCostsPostalCode = getShippingCostsPostalCode(viewData);
                issueRefresh(true);
            }
        }
        if (i != 0)
        {
            userAction = UserAction.NONE;
        }
          goto _L23
_L18:
        shouldSaveScrollPosition = true;
        if (-1 == j)
        {
            scrollToTop();
            intent = DeviceConfiguration.getAsync();
            if (item != null && intent.get(DcsBoolean.LocalNotifications))
            {
                intent = new ItemCache(this);
                intent.insertLocalNotificationsItem(createLocalNotificationsEvent(intent, com.ebay.common.model.mdns.NotificationPreference.EventType.BIDITEM));
            }
            if (item != null)
            {
                item.highBidderUserId = MyApp.getPrefs().getCurrentUser();
                if (!item.isReserveMet || item.buyItNowAvailable)
                {
                    callVlsForFlags(item);
                }
            }
            issueRefresh();
        } else
        if (j == 504)
        {
            scrollToTop();
            issueRefresh(true);
        } else
        if (j == 20)
        {
            intent = DeviceConfiguration.getAsync();
            isAuctionEndedOverride = true;
            if (item != null && !item.finalized && intent.get(DcsBoolean.VI_featureNewBidFlow))
            {
                scrollToTop();
                showHideTranslucentProgress(true, true);
            }
        } else
        if (j == 502)
        {
            showDialogPpaUpgrade();
        }
          goto _L23
_L9:
        if (-1 != j) goto _L25; else goto _L24
_L24:
        boolean flag1 = false;
        if (intent != null)
        {
            intent = (ViewItemViewData)intent.getParcelableExtra("view_item_view_data");
        } else
        {
            intent = null;
        }
        j = ((flag1) ? 1 : 0);
        if (intent != null)
        {
            j = ((flag1) ? 1 : 0);
            if (((ViewItemViewData) (intent)).nameValueList != null)
            {
                j = ((flag1) ? 1 : 0);
                if (!((ViewItemViewData) (intent)).nameValueList.equals(viewData.nameValueList))
                {
                    j = 1;
                    viewData = intent;
                }
            }
        }
        if (j == 0) goto _L25; else goto _L26
_L26:
        if (item != null) goto _L28; else goto _L27
_L27:
        if (3 == i)
        {
            userAction = UserAction.BUY_IT_NOW;
        } else
        if (9 == i)
        {
            userAction = UserAction.ADD_TO_CART;
        } else
        if (2 == i)
        {
            userAction = UserAction.WATCH;
        } else
        {
            userAction = UserAction.SPR;
        }
_L25:
        viewData.buyAnother = false;
          goto _L23
_L28:
        if (variationsFragment != null)
        {
            variationsFragment.render(item, viewData);
        }
        viewData.isLoadSprAfterInventoryCall = false;
        if (item.hasMultiSkuValues(viewData.nameValueList) && (item.isBopisable || item.isPudoable))
        {
            if (item.inventoryInfo != null && item.inventoryInfo.getSelectedStore() != null)
            {
                item.inventoryInfo = null;
            }
            intent = viewData;
            boolean flag3;
            if (i == 4)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            intent.isLoadSprAfterInventoryCall = flag3;
            viewData.isLoadStoreAvailabilities = true;
        }
        if (MyApp.getPrefs().isSignedIn())
        {
            updateShoppingCart();
            if (i != 2)
            {
                item.watched = viewItemDataManager.isInMyEbayWatchList(new EbayItemIdAndVariationSpecifics(item.id, viewData.nameValueList));
            }
        }
        switch (i)
        {
        case 2: // '\002'
            finishWatchUnWatch(true);
            break;

        case 3: // '\003'
            doBin(viewData.buyAnother);
            break;

        case 9: // '\t'
            doAddToCart();
            break;

        case 4: // '\004'
            if (!viewData.isLoadSprAfterInventoryCall)
            {
                ViewItemShippingPaymentsReturnsActivity.StartActivity(this, viewData, 19);
            }
            break;
        }
        if (true) goto _L25; else goto _L29
_L29:
_L10:
        handleAddShipmentTrackingResult(j, intent);
          goto _L23
_L8:
        if (-1 == j)
        {
            viewData.feedbackLeft = true;
            if (item != null)
            {
                item.feedbackLeft = true;
            }
        }
          goto _L23
_L12:
        if (-1 == j)
        {
            j = 0;
            boolean flag2 = false;
            if (intent != null)
            {
                if (intent.hasExtra("transaction_id"))
                {
                    viewData.kind = com.ebay.common.ConstantsCommon.ItemKind.Won;
                    i = ((flag2) ? 1 : 0);
                    if (item != null)
                    {
                        item.transactionId = Long.valueOf(Long.parseLong(intent.getStringExtra("transaction_id")));
                        reinitializeDataManager(viewData, item.transactionId.longValue());
                        i = 1;
                    }
                } else
                {
                    i = ((flag2) ? 1 : 0);
                    if (intent.hasExtra("view_item_view_data"))
                    {
                        ViewItemViewData viewitemviewdata1 = (ViewItemViewData)intent.getParcelableExtra("view_item_view_data");
                        i = ((flag2) ? 1 : 0);
                        if (viewitemviewdata1 != null)
                        {
                            viewData = viewitemviewdata1;
                            i = ((flag2) ? 1 : 0);
                        }
                    }
                }
                j = i;
                if (item != null)
                {
                    j = i;
                    if (intent.hasExtra("status"))
                    {
                        item.bestOfferStatus = intent.getStringExtra("status");
                        j = i;
                    }
                }
            }
            if (j == 0)
            {
                issueRefresh();
            }
            MyEbayLandingActivity.setBuyingInvalid(getEbayContext());
        }
          goto _L23
_L21:
        if (-1 == j)
        {
            if (item != null && intent != null && !intent.getBooleanExtra("pending", true))
            {
                item.bestOfferCount = 0;
            }
            SellingListActivity.setSellingInvalid(getEbayContext());
            if (!isSellerAcceptedOffer(intent))
            {
                issueRefresh(true, 1);
            }
        }
          goto _L23
_L17:
        if (intent != null && item != null && item.isMultiSku)
        {
            intent = (ViewItemViewData)intent.getParcelableExtra("view_item_view_data");
            if (intent != null)
            {
                viewData = intent;
            }
        }
          goto _L23
_L11:
        if (-1 == j && intent != null && intent.getBooleanExtra("refresh_item", false))
        {
            issueRefresh(true);
        }
          goto _L23
_L19:
        if (-1 == j && intent != null)
        {
            ViewItemViewData viewitemviewdata2 = (ViewItemViewData)intent.getParcelableExtra("view_item_view_data");
            if (viewitemviewdata2 != null)
            {
                viewData = viewitemviewdata2;
            }
            if (intent.getBooleanExtra("refresh_item", false) && sprFragment != null)
            {
                sprFragment.setForceReRender();
            }
        }
          goto _L23
        if (j == -1 && intent != null && "true".equals(intent.getStringExtra("eplus")))
        {
            showDialog(getString(0x7f070263), getString(0x7f07037f), getString(0x7f070738), null, 7);
        }
          goto _L23
    }

    public void onBeamPushComplete()
    {
        (new TrackingData("ShareBeam", TrackingType.PAGE_IMPRESSION)).send(this);
    }

    public void onBidUpdated(ViewItemDataManager viewitemdatamanager, Content content)
    {
        boolean flag = true;
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                content
            });
        }
        if (!isFinishing())
        {
            if (!content.getStatus().hasError())
            {
                if (((ViewItemDataManager.ViewItemLiteInfo)content.getData()).item != null)
                {
                    item = ((ViewItemDataManager.ViewItemLiteInfo)content.getData()).item;
                }
                if (item != null)
                {
                    boolean flag1 = DeviceConfiguration.getAsync().get(DcsBoolean.VI_featureNewBidFlow);
                    if (flag1 && (item.isAuctionEnded || isAuctionEndedOverride) && !item.finalized)
                    {
                        scrollToTop();
                        showHideTranslucentProgress(true, true);
                    }
                    long l = item.id;
                    viewitemdatamanager = item.transactionId;
                    boolean flag2 = item.isSeller;
                    boolean flag3 = item.isUserHighBidder;
                    if (!viewData.finalized && item.finalized)
                    {
                        viewData.finalized = true;
                        isCondensedView = Boolean.valueOf(true);
                        isAuctionEndedOverride = false;
                        if (flag3 && (!item.hasReservePrice || item.isReserveMet))
                        {
                            content = new ViewItemViewData();
                            content.keyParams = new ViewItemDataManager.KeyParams(viewData.keyParams.itemId, viewitemdatamanager);
                            content.kind = com.ebay.common.ConstantsCommon.ItemKind.Won;
                            if (!isFinishing())
                            {
                                reinitializeDataManager(content, viewitemdatamanager.longValue());
                                return;
                            }
                        } else
                        if (flag2)
                        {
                            viewData.kind = com.ebay.common.ConstantsCommon.ItemKind.Sold;
                            invalidateCache(l, (Long)null);
                            issueRefresh(true, 1);
                            return;
                        } else
                        {
                            issueRefresh(true);
                            return;
                        }
                    } else
                    {
                        if (((ViewItemDataManager.ViewItemLiteInfo)content.getData()).bidEvent.vibrate)
                        {
                            vibrateAndHighlightIfNeeded();
                        }
                        if (flag1)
                        {
                            render();
                            return;
                        }
                        if (actionsFragment == null || !actionsFragment.hasContent() || actionsFragment.priceEditor == null || !actionsFragment.priceEditor.hasFocus())
                        {
                            flag = false;
                        }
                        render();
                        if (flag && actionsFragment != null && actionsFragment.hasContent() && actionsFragment.priceEditor != null)
                        {
                            actionsFragment.priceEditor.requestFocus();
                            return;
                        }
                    }
                }
            } else
            {
                showMessage(0, content.getStatus());
                return;
            }
        }
    }

    public void onCartChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled)
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        while (isFinishing() || content == null) 
        {
            return;
        }
        if (!content.getStatus().hasError() && content.getData() != null && ((ViewItemDataManager.AddToCartInfo)content.getData()).item != null && ((ViewItemDataManager.AddToCartInfo)content.getData()).item.getData() != null)
        {
            viewitemdatamanager = (ViewItemDataManager.AddToCartInfo)content.getData();
            item = (Item)((ViewItemDataManager.AddToCartInfo)content.getData()).item.getData();
            switch (_cls12..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                hideTranslucentProgress();
                cartChanged(item.inCart);
                ShoppingCartActivity.wiggleActionBar(this);
                actionhandled = new TrackingData("ShoppingCartAction", TrackingType.EVENT);
                actionhandled.addKeyValuePair("addtocart", "1");
                actionhandled.addKeyValuePair("itm", (new StringBuilder()).append("").append(item.id).toString());
                actionhandled.addKeyValuePair("ebc", ((ViewItemDataManager.AddToCartInfo) (viewitemdatamanager)).cartId);
                content = item.currentPrice;
                viewitemdatamanager = content;
                if (content == null)
                {
                    viewitemdatamanager = content;
                    if (item.buyItNowPrice != null)
                    {
                        viewitemdatamanager = item.buyItNowPrice;
                    }
                }
                if (viewitemdatamanager != null)
                {
                    actionhandled.addKeyValuePair("chtpc", ((ItemCurrency) (viewitemdatamanager)).code);
                }
                actionhandled.send(this);
                return;

            case 2: // '\002'
                cartChanged(item.inCart);
                return;
            }
        }
        hideTranslucentProgress();
        boolean flag;
        switch (_cls12..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
        {
        default:
            showMessage(0, content.getStatus());
            return;

        case 1: // '\001'
        case 2: // '\002'
            flag = false;
            break;
        }
        viewitemdatamanager = content.getStatus().getFirstMessage();
        if (viewitemdatamanager instanceof EbayResponseError)
        {
            if (1 == Integer.parseInt(((EbayResponseError)viewitemdatamanager).code))
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        if (flag)
        {
            showDialogPpaUpgrade();
            return;
        } else
        {
            showMessage(0, content.getStatus());
            layoutState = ItemViewCommonProgressAndError.LayoutState.NORMAL;
            ItemViewCommonProgressAndError.showLayouts(this, layoutState);
            return;
        }
    }

    public void onClick(View view)
    {
        int i = view.getId();
        if (i != retryButton.getId() && !Util.hasNetwork())
        {
            showButterBarMessage(view.getId(), getNetworkErrorToastString(), true);
        } else
        {
            switch (i)
            {
            default:
                return;

            case 2131755327: 
                issueRefresh();
                return;

            case 2131755328: 
                finish();
                return;

            case 2131756464: 
                ItemViewDescriptionActivity.StartActivity(this, viewData, ItemViewDescriptionActivity.What.DESCRIPTION);
                return;

            case 2131757168: 
                ItemViewCompatibilityActivity.StartActivity(this, viewData);
                return;

            case 2131756277: 
                ProductReviewsActivity.StartActivity(this, viewData);
                return;

            case 2131757183: 
                doBin();
                return;

            case 2131756546: 
                SellerOfferResultFragmentActivity.startActivity(this, item.smeSellerName, item.smeOfferType, item.smeOfferId, null, new SourceIdentification(getTrackingEventName(), "sop"));
                return;

            case 2131757193: 
                sellLike();
                return;

            case 2131756247: 
            case 2131757182: 
                placeBidAmount(null);
                return;

            case 2131757188: 
                doMakeOffer();
                return;

            case 2131757170: 
                ItemViewDescriptionActivity.StartActivity(this, viewData, ItemViewDescriptionActivity.What.PRODUCT_DETAILS);
                return;

            case 2131757184: 
                finishWatchUnWatch(item.isShowWatch);
                return;

            case 2131757189: 
                doAddToCart();
                return;

            case 2131757190: 
                doViewCart();
                return;

            case 2131757176: 
                break;
            }
            if (!needSignIn(UserAction.PLUS_SIGNUP))
            {
                startPlusSignupFlow();
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        Intent intent;
        DeviceConfiguration deviceconfiguration;
        super.onCreate(bundle);
        setContentView(0x7f030130);
        setTitle("");
        intent = getIntent();
        redirectPrevious = intent.getBooleanExtra("paramGoPrev", false);
        deviceconfiguration = DeviceConfiguration.getAsync();
        int i = ThemeUtil.resolveThemeSecondaryColorResId(getTheme(), 0x7f01005e);
        headerColor = getResources().getColor(i);
        if (bundle != null) goto _L2; else goto _L1
_L1:
        String s;
        String s1;
        viewData = new ViewItemViewData(this);
        referrer = intent.getStringExtra("com.ebay.mobile.tracking.Referrer");
        bidSource = intent.getStringExtra("com.ebay.mobile.tracking.BidSource");
        searchResultsRank = intent.getIntExtra("com.ebay.mobile.tracking.SearchResultsRank", -1);
        s = intent.getStringExtra("transaction_id");
        bundle = intent.getStringExtra("item_id");
        s1 = intent.getStringExtra("item_kind");
        if (bundle == null || s1 == null) goto _L4; else goto _L3
_L3:
        viewData.kind = com.ebay.common.ConstantsCommon.ItemKind.valueOf(s1);
        itemId = Long.parseLong(bundle);
        if (TextUtils.isEmpty(s)) goto _L6; else goto _L5
_L5:
        transactionId = Long.valueOf(Long.parseLong(s));
_L8:
        invalidateCache(itemId, transactionId);
        s = intent.getStringExtra("user_action");
        if (!TextUtils.isEmpty(s))
        {
            userAction = UserAction.valueOf(s);
            int j = intent.getIntExtra("noti_sys_id", -1);
            if (j != -1)
            {
                ((NotificationManager)getSystemService("notification")).cancel(j);
            }
        }
        ServiceStarter.startUpdateNotificationCacheService(this, intent.getStringExtra("event_type"), bundle);
_L9:
        shouldSaveScrollPosition = true;
        viewData.searchOtherCountries = intent.getBooleanExtra("item_view_refined_search_other_countries", false);
        viewData.keyParams = new ViewItemDataManager.KeyParams(itemId, transactionId);
        viewData.shippingCostsPostalCode = getShippingCostsPostalCode(viewData);
        viewData.useRealtimeShipmentTracking = deviceconfiguration.get(DcsBoolean.useRealtimeShipTracking);
        if (!isUnitTest)
        {
            showHideTranslucentProgress(true, true);
            layoutState = ItemViewCommonProgressAndError.LayoutState.NORMAL;
        }
        isPullToRefresh = MyApp.getDeviceConfiguration().getConfig().get(com.ebay.nautilus.domain.dcs.DcsDomain.ViewItem.B.pullToRefresh);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(0x7f1002f5);
        int k;
        if (swipeRefreshLayout != null)
        {
            if (isPullToRefresh)
            {
                swipeRefreshLayout.setOnRefreshListener(this);
            } else
            {
                swipeRefreshLayout.setEnabled(false);
            }
        }
        CrashlyticsWrapper.log((new StringBuilder()).append("ItemViewActivity.onCreate() item id=").append(itemId).toString());
        addressDmObserver = new AddressDataManagerObserver();
        initDataManagers();
        createUi();
        createFragments();
        NfcCompat.registerForBeamPush(this, this);
        return;
_L6:
        s = intent.getStringExtra("event_type");
        if (TextUtils.isEmpty(s)) goto _L8; else goto _L7
_L7:
        switch (NotificationPreference.nameToId(s))
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 10: // '\n'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        case 33: // '!'
        case 34: // '"'
            viewData.isTransactionLookupIndicated = false;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        itemId = intent.getLongExtra("item_view_id", 0L);
        transactionId = NumberUtil.safeParseLong(s);
        k = intent.getIntExtra("user_action", UserAction.NONE.ordinal());
        userAction = UserAction.values()[k];
        fromMyEbayOrReminders = intent.getBooleanExtra("item_view_from_my_ebay_or_reminders", false);
        fromOrderSummary = intent.getBooleanExtra("item_view_from_order_summary", false);
        fromEbnOrderDetails = intent.getBooleanExtra("item_view_from_ebn_order_details", false);
        viewData.pricingTreatment = intent.getStringExtra("item_view_pricing_treatment");
        viewData.originalRetailPrice = (ItemCurrency)intent.getParcelableExtra("item_view_original_retail_price");
        viewData.savingsRate = intent.getIntExtra("item_view_savings_rate", 0);
        viewData.kind = com.ebay.common.ConstantsCommon.ItemKind.valueOf(intent.getStringExtra("item_view_kind"));
        viewData.nameValueList = intent.getParcelableArrayListExtra("param_variation_values");
        viewData.feedbackLeft = intent.getBooleanExtra("item_view_feedback_left", false);
        viewData.searchRefinedPostalCode = intent.getStringExtra("item_view_refined_postal_code");
        viewData.searchRefinedShopLocallyFlag = intent.getIntExtra("shop_locally_refinement", 0);
        viewData.myEbayListItem = (MyEbayListItem)intent.getParcelableExtra("ebay_list_item");
        inventoryInfo = (InventoryInfo)intent.getParcelableExtra("item_view_store_from_order_summary");
        isUnitTest = intent.getBooleanExtra("item_view_unit_test", false);
          goto _L9
_L2:
        referrer = bundle.getString("com.ebay.mobile.tracking.Referrer");
        bidSource = bundle.getString("com.ebay.mobile.tracking.BidSource");
        incrementalBid = bundle.getBoolean("com.ebay.mobile.tracking.IncrementalBid");
        viewData = (ViewItemViewData)bundle.getParcelable("param_view_data");
        fromMyEbayOrReminders = bundle.getBoolean("item_view_from_my_ebay_or_reminders");
        fromOrderSummary = bundle.getBoolean("item_view_from_order_summary");
        k = bundle.getInt("user_action", UserAction.NONE.ordinal());
        userAction = UserAction.values()[k];
        layoutState = ItemViewCommonProgressAndError.LayoutState.valueOf(bundle.getString("layout_state"));
        fromEbnOrderDetails = bundle.getBoolean("item_view_from_ebn_order_details");
        isAuctionEndedOverride = bundle.getBoolean("auction_ended_override");
        itemId = bundle.getLong("item_view_id");
        transactionId = Long.valueOf(bundle.getLong("item_view_tx_id", -1L));
        if (transactionId.longValue() == -1L)
        {
            transactionId = null;
        }
        isUnitTest = intent.getBooleanExtra("item_view_unit_test", false);
        setScrollPosition(bundle.getInt("scrollY"));
        initialLoadComplete = bundle.getBoolean("param_initial_load_complete", false);
        isCondensedView = Boolean.valueOf(bundle.getBoolean("condensed_state", false));
        merchRequested = bundle.getBoolean("merch_requested", false);
        if (deviceconfiguration.get(DcsBoolean.VI_feature_merchOnScroll))
        {
            merchRequested = false;
            forceMerch = true;
        }
        bundle = bundle.getSerializable("pla_or_text_ads");
        if (bundle != null && (bundle instanceof List))
        {
            adsPla = (List)bundle;
        }
          goto _L9
        if (true) goto _L8; else goto _L10
_L10:
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        Object obj;
        obj = null;
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                actionhandled, Boolean.valueOf(flag)
            });
        }
        if (!isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag1;
        boolean flag2;
label0:
        {
            super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
            flag2 = content.getStatus().hasError();
            boolean flag3 = DeviceConfiguration.getAsync().get(DcsBoolean.VI_featureNewBidFlow);
            flag1 = flag;
            if (flag2)
            {
                break label0;
            }
            if (actionhandled != ViewItemDataManager.ActionHandled.INITIAL_LOAD || !isTransactedMismatchDetected())
            {
                flag1 = flag;
                if (!flag3)
                {
                    break label0;
                }
                if (!isAuctionEndedOverride)
                {
                    flag1 = flag;
                    if (!item.isAuctionEnded)
                    {
                        break label0;
                    }
                }
                flag1 = flag;
                if (item.finalized)
                {
                    break label0;
                }
            }
            flag1 = false;
        }
        if (flag1)
        {
            hideTranslucentProgress();
        }
        if (flag2)
        {
            break; /* Loop/switch isn't completed */
        }
        switch (_cls12..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
        {
        default:
            return;

        case 3: // '\003'
            initialLoadComplete = true;
            if (item != null)
            {
                if (isTransactedMismatchDetected())
                {
                    reinitializeDataManager(viewData, transactionId.longValue());
                    return;
                }
                setupTitleAndPriceFragment();
                trackItemViewEvent(getTrackingEventName());
                if (reviewsLayout != null)
                {
                    if (item.isProductReviewsAvailable)
                    {
                        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.ViewItem.B.productReviewStarsInTitleSection))
                        {
                            findViewById(0x7f100873).setVisibility(8);
                        } else
                        {
                            reviewsRating.setValue(item.productReviewAverageRating);
                            reviewsCount.setText(getString(0x7f0708d2, new Object[] {
                                Long.valueOf(item.productReviewCount)
                            }));
                        }
                        reviewsLayout.setVisibility(0);
                    } else
                    {
                        reviewsLayout.setVisibility(8);
                    }
                }
                initialLoadViewSettings();
                if (!item.finalized && viewData.finalized)
                {
                    item.finalized = true;
                }
                layoutState = ItemViewCommonProgressAndError.LayoutState.NORMAL;
                if (!item.addToRecentlyViewed && !item.isSeller && !item.isTransacted && com.ebay.common.ConstantsCommon.ItemKind.RecentlyViewed != viewData.kind)
                {
                    viewItemDataManager.addItemToRecentlyViewed();
                    item.addToRecentlyViewed = true;
                }
                render();
                if (UserAction.NONE != userAction)
                {
                    handleDeferredSignInAction();
                }
                if (viewData.isLoadStoreAvailabilities)
                {
                    viewData.isLoadStoreAvailabilities = false;
                    getStoreAvailability();
                }
                if (isAdsEnabledDisplay)
                {
                    getDisplayAds();
                }
                if (isAdsEnabledPLA && adsPla == null)
                {
                    getPlaAds();
                }
                if (isAdsEnabledGoogleText && googleTextAdView == null)
                {
                    getGoogleTextAds();
                    return;
                }
            } else
            {
                hideTranslucentProgress();
                layoutState = ItemViewCommonProgressAndError.LayoutState.SERVICE_ERROR;
                ItemViewCommonProgressAndError.showLayouts(this, layoutState);
                return;
            }
            break;

        case 4: // '\004'
            setupWatchButton();
            return;

        case 5: // '\005'
            if (viewData.keyParams.transactionId != null && !viewData.keyParams.transactionId.equals(transactionId))
            {
                transactionId = viewData.keyParams.transactionId;
                reinitializeDataManager(viewData, transactionId.longValue());
            } else
            {
                issueRefresh(true);
            }
            refreshOtherActivities(this, item);
            SellingListActivity.setSellingInvalid(getEbayContext());
            return;

        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
            if (sprFragment != null)
            {
                sprFragment.setForceReRender();
            }
            render();
            refreshOtherActivities(this, item);
            if (actionhandled == ViewItemDataManager.ActionHandled.MARK_PAID_OR_UNPAID)
            {
                SellingListActivity.setSellingInvalid(getEbayContext());
            }
            if (viewData.isLoadSprAfterInventoryCall && actionhandled == ViewItemDataManager.ActionHandled.BOPIS_AVAILABILITY)
            {
                viewData.isLoadSprAfterInventoryCall = false;
                startSPRActivity();
                return;
            }
            break;

        case 10: // '\n'
            render();
            refreshOtherActivities(this, item);
            if (item.isShipped)
            {
                showDialog(getString(0x7f0703cc), null, getString(0x7f070738), getString(0x7f07015b), 6);
            }
            SellingListActivity.setSellingInvalid(getEbayContext());
            return;

        case 11: // '\013'
            render();
            return;

        case 12: // '\f'
            if (biddingHistoryFragment != null)
            {
                biddingHistoryFragment.render(item, viewData);
            }
            if (actionsFragment != null)
            {
                actionsFragment.render(item, viewData);
                return;
            }
            break;

        case 13: // '\r'
        case 14: // '\016'
            render();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (MyApp.getPrefs().isSignedIn() && EbayErrorUtil.userNotLoggedIn(content.getStatus().getMessages()))
        {
            EbayErrorHandler.handleResultStatus(this, actionhandled.ordinal(), content.getStatus());
        }
        _cls12..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()];
        JVM INSTR tableswitch 3 10: default 952
    //                   3 972
    //                   4 1064
    //                   5 1076
    //                   6 1089
    //                   7 1161
    //                   8 952
    //                   9 952
    //                   10 1173;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L4 _L4 _L10
_L4:
        showMessage(666, content.getStatus());
_L12:
        viewData.isLoadSprAfterInventoryCall = false;
        return;
_L5:
        if (content.getStatus().getFirstError() != null)
        {
            viewitemdatamanager = content.getStatus().getFirstError().getLongMessage(getEbayContext());
        } else
        {
            viewitemdatamanager = null;
        }
        if (viewitemdatamanager != null)
        {
            layoutState = ItemViewCommonProgressAndError.LayoutState.CUSTOM_ERROR;
            ItemViewCommonProgressAndError.setPrimaryErrorMessage(this, viewitemdatamanager);
        } else
        {
            layoutState = ItemViewCommonProgressAndError.LayoutState.SERVICE_ERROR;
        }
        if (!content.getStatus().canRetry())
        {
            ItemViewCommonProgressAndError.setOkNotRetry(this);
        }
        ItemViewCommonProgressAndError.showLayouts(this, layoutState);
        trackItemViewEvent(getTrackingEventName());
        continue; /* Loop/switch isn't completed */
_L6:
        showMessage(3, content.getStatus());
        continue; /* Loop/switch isn't completed */
_L7:
        DialogManager.createAlertDialog(this, 0x7f070140).show();
        continue; /* Loop/switch isn't completed */
_L8:
        if (content.getStatus().getFirstMessage() != null)
        {
            viewitemdatamanager = content.getStatus().getFirstMessage().getShortMessage(getEbayContext());
        } else
        {
            viewitemdatamanager = null;
        }
        actionhandled = obj;
        if (content.getStatus().getFirstMessage() != null)
        {
            actionhandled = content.getStatus().getFirstMessage().getLongMessage(getEbayContext());
        }
        ErrorDialogActivity.StartActivity(this, viewitemdatamanager, actionhandled, true);
        continue; /* Loop/switch isn't completed */
_L9:
        showMessage(2, content.getStatus());
        continue; /* Loop/switch isn't completed */
_L10:
        showMessage(1, content.getStatus());
        if (true) goto _L12; else goto _L11
_L11:
    }

    protected void onDestroy()
    {
        if (googleTextAdView != null)
        {
            googleTextAdView.destroy();
            googleTextAdView = null;
        }
        super.onDestroy();
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        boolean flag = false;
        if (j == 1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        dialogfragment = MyApp.getPrefs().getAuthentication();
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            if (dialogfragment != null && viewItemDataManager != null)
            {
                dialogfragment = EbayApiUtil.getTradingApi(this, dialogfragment);
                ViewItemDataManager viewitemdatamanager = viewItemDataManager;
                long l = itemId;
                Long long1 = transactionId;
                if (i == 1)
                {
                    flag = true;
                }
                viewitemdatamanager.markItemPaid(dialogfragment, l, long1, null, Boolean.valueOf(flag));
                showHideTranslucentProgress(true, true);
                return;
            }
            break;

        case 3: // '\003'
            if (dialogfragment != null && viewItemDataManager != null)
            {
                dialogfragment = EbayApiUtil.getTradingApi(this, dialogfragment);
                viewItemDataManager.markItemShipped(dialogfragment, itemId, transactionId, null, Boolean.valueOf(true));
                showHideTranslucentProgress(true, true);
                return;
            }
            break;

        case 4: // '\004'
            if (dialogfragment != null)
            {
                dialogfragment = EbayApiUtil.getTradingApi(this, dialogfragment);
                viewItemDataManager.markItemShipped(dialogfragment, itemId, transactionId, new ShipmentTracking(), Boolean.valueOf(false));
                showHideTranslucentProgress(true, true);
                return;
            }
            break;

        case 5: // '\005'
            if (!needSignIn(UserAction.CHANGE_ADDRESS))
            {
                startAddressBookActivity();
                return;
            }
            break;

        case 6: // '\006'
            dialogfragment = new Intent(this, com/ebay/mobile/activities/AddEditTrackingInfoActivity);
            dialogfragment.putExtra("enter_vs_edit", true);
            startActivityForResult(dialogfragment, 5);
            return;

        case 7: // '\007'
            scrollToTop();
            issueRefresh(true);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onDismissMessage(int i, boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj;
        UserAction auseraction[];
        int j;
        int k;
        obj = null;
        auseraction = UserAction.values();
        k = auseraction.length;
        j = 0;
_L7:
        UserAction useraction = obj;
        if (j >= k) goto _L4; else goto _L3
_L3:
        useraction = auseraction[j];
        if (useraction.ordinal() != i) goto _L5; else goto _L4
_L4:
        if (useraction == null)
        {
            break; /* Loop/switch isn't completed */
        }
        handleAction(useraction, null);
_L2:
        return;
_L5:
        j++;
        if (true) goto _L7; else goto _L6
_L6:
        onClick(findViewById(i));
        return;
    }

    public void onImageLoaded(String s, int i)
    {
        if (i == 0)
        {
            SiteSpeedActivityUtil.allLoaded(this);
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        if (inventoryLookupDM == null)
        {
            inventoryLookupDM = (EbayNowInventoryLookupDataManager)datamanagercontainer.initialize(EbayNowInventoryLookupDataManager.KEY, this);
        }
        addressDataManager = (AddressDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.AddressDataManager.KeyParams("Shipping"), addressDmObserver);
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        isAdsEnabledPLA = deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Ads.B.viShow20188);
        isAdsEnabledDisplay = deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Ads.B.viShow20221);
        isAdsEnabledGoogleText = deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Ads.B.vipShowDirectGoogleTextAd);
        if (isAdsEnabledPLA || isAdsEnabledDisplay || isAdsEnabledGoogleText)
        {
            viewData.adsExperimentState = Experiments.getAdsTreatment(MyApp.getPrefs().getCurrentSite(), getEbayContext());
            if (com.ebay.mobile.experimentation.Experiments.AdsExperimentDefinition.isActive(viewData.adsExperimentState, com.ebay.mobile.experimentation.Experiments.AdsExperimentDefinition.AdsPageSource.AdsOnVip))
            {
                if (isAdsEnabledPLA || isAdsEnabledDisplay)
                {
                    adRtmDmObserver = new AdRtmDataManagerObserver();
                    adRtmDataManager = (AdRtmDataManager)datamanagercontainer.initialize(adRtmDataManagerKey, adRtmDmObserver);
                }
            } else
            {
                isAdsEnabledGoogleText = false;
            }
        }
        viewItemDataManager = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this);
        if (logTag.isLoggable)
        {
            logTag.log((new StringBuilder()).append("onInitializeDataManagers, viewItemDataManager=").append(viewItemDataManager.toString()).toString());
        }
    }

    public void onInventoryLookupComplete(EbayNowInventoryLookupDataManager ebaynowinventorylookupdatamanager, ResultStatus resultstatus)
    {
    }

    public void onItemEnded()
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        while (isFinishing() || item == null || item.finalized || isAuctionEndedOverride || !item.isBidOnly && !item.isBidWithBin || !DeviceConfiguration.getAsync().get(DcsBoolean.VI_featureNewBidFlow)) 
        {
            return;
        }
        isAuctionEndedOverride = true;
        showHideTranslucentProgress(true, true);
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        referrer = intent.getStringExtra("com.ebay.mobile.tracking.Referrer");
        bidSource = intent.getStringExtra("com.ebay.mobile.tracking.BidSource");
        incrementalBid = false;
        setIntent(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131167827: 
            share();
            return true;

        case 2131167475: 
            userRefreshed();
            return true;
        }
    }

    protected void onPause()
    {
        super.onPause();
        if (googleTextAdView != null)
        {
            googleTextAdView.pause();
        }
        getDataManagerContainer().delete(new com.ebay.nautilus.domain.content.dm.AddressDataManager.KeyParams("Shipping"));
        addressDataManager = null;
        if (networkErrorToast != null)
        {
            networkErrorToast.cancel();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        boolean flag1 = true;
        boolean flag2 = super.onPrepareOptionsMenu(menu);
        boolean flag;
        if (!isProgressVisible())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!isPullToRefresh)
        {
            MenuItem menuitem2 = menu.findItem(0x7f0708f3);
            MenuItem menuitem = menuitem2;
            if (menuitem2 == null)
            {
                menuitem = menu.add(0, 0x7f0708f3, 0, getString(0x7f0708f3));
            }
            if (menuitem != null)
            {
                menuitem.setEnabled(flag);
            }
        }
        if (!DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.ViewItem.B.shareAsButton))
        {
            MenuItem menuitem3 = menu.findItem(0x7f070a53);
            MenuItem menuitem1 = menuitem3;
            if (menuitem3 == null)
            {
                menuitem1 = menu.add(0, 0x7f070a53, 0, getString(0x7f070a53));
            }
            if (menuitem1 != null)
            {
                if (flag && item != null)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                menuitem1.setEnabled(flag);
            }
        }
        return flag2;
    }

    public void onRefresh()
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        if (isFinishing())
        {
            return;
        } else
        {
            userRefreshed();
            return;
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (addressDataManager == null)
        {
            addressDataManager = (AddressDataManager)getDataManagerContainer().initialize(new com.ebay.nautilus.domain.content.dm.AddressDataManager.KeyParams("Shipping"), addressDmObserver);
        }
        if (googleTextAdView != null)
        {
            googleTextAdView.resume();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("com.ebay.mobile.tracking.BidSource", bidSource);
        bundle.putString("com.ebay.mobile.tracking.Referrer", referrer);
        bundle.putBoolean("com.ebay.mobile.tracking.IncrementalBid", incrementalBid);
        bundle.putBoolean("paramGoPrev", redirectPrevious);
        bundle.putBoolean("item_view_from_my_ebay_or_reminders", fromMyEbayOrReminders);
        bundle.putInt("user_action", userAction.ordinal());
        bundle.putString("layout_state", layoutState.toString());
        bundle.putBoolean("item_view_from_order_summary", fromOrderSummary);
        bundle.putBoolean("item_view_from_ebn_order_details", fromEbnOrderDetails);
        bundle.putBoolean("param_initial_load_complete", initialLoadComplete);
        bundle.putBoolean("auction_ended_override", isAuctionEndedOverride);
        bundle.putBoolean("merch_requested", merchRequested);
        if (shouldSaveScrollPosition)
        {
            bundle.putInt("scrollY", ((EbayScrollView)findViewById(0x7f100017)).getScrollY());
        }
        bundle.putLong("item_view_id", itemId);
        if (transactionId != null)
        {
            bundle.putLong("item_view_tx_id", transactionId.longValue());
        }
        bundle.putParcelable("param_view_data", viewData);
        if (isCondensedView != null)
        {
            bundle.putBoolean("condensed_state", isCondensedView.booleanValue());
        }
        if (adsPla != null && !adsPla.isEmpty())
        {
            bundle.putSerializable("pla_or_text_ads", (Serializable)adsPla);
        }
    }

    public void onScrollChanged(EbayScrollView ebayscrollview, int i, int j, int k, int l)
    {
        boolean flag = false;
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        if (swipeRefreshLayout != null && isPullToRefresh)
        {
            SwipeRefreshLayout swiperefreshlayout = swipeRefreshLayout;
            if (ebayscrollview.getScrollY() == 0)
            {
                flag = true;
            }
            swiperefreshlayout.setEnabled(flag);
        }
        if (!merchRequested && DeviceConfiguration.getAsync().get(DcsBoolean.VI_feature_merchOnScroll))
        {
            requestMerchOnScroll();
        }
    }

    protected void onStop()
    {
        if (imageViewPager != null)
        {
            imageViewPager.setAdapter(null);
        }
        super.onStop();
    }

    public void onVariationsSelected(ViewItemViewData viewitemviewdata)
    {
        if (viewitemviewdata != null)
        {
            viewData = viewitemviewdata;
            boolean flag2 = item.hasMultiSkuValues(viewData.nameValueList);
            if (item.isBopisable || item.isPudoable)
            {
                boolean flag1 = false;
                boolean flag = flag1;
                if (flag2)
                {
                    String s;
                    String s1;
                    if (item.inventoryInfo != null)
                    {
                        s = item.inventoryInfo.getItemSku();
                    } else
                    {
                        s = null;
                    }
                    s1 = item.getVariationSKU(viewitemviewdata.nameValueList);
                    flag = flag1;
                    if (s1 != null)
                    {
                        flag = flag1;
                        if (!s1.equals(s))
                        {
                            flag = true;
                        }
                    }
                }
                if (flag && !item.isInventoryCallFail)
                {
                    item.inventoryInfo = null;
                    getStoreAvailability();
                }
            }
            if (titleAndPriceFragment != null)
            {
                titleAndPriceFragment.render(item, viewitemviewdata);
            }
            if (itemSpecificsFragment != null)
            {
                itemSpecificsFragment.render(item, viewitemviewdata);
            }
            if (sprFragment != null)
            {
                sprFragment.setForceReRender();
                sprFragment.render(item, viewitemviewdata);
            }
            updateGalleryPhotos(viewitemviewdata);
            if (MyApp.getPrefs().isSignedIn())
            {
                updateShoppingCart();
                return;
            }
        }
    }

    public void placeBid(ItemCurrency itemcurrency)
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                itemcurrency
            });
        }
        if (!showErrorIfAuctionEnded() && !needSignIn(UserAction.PLACE_BID))
        {
            ItemCurrency itemcurrency1 = itemcurrency;
            if (itemcurrency == null)
            {
                itemcurrency1 = new ItemCurrency(item.minimumToBid.lowerBound.getCurrencyCode(), item.minimumToBid.lowerBound.getValueAsString());
            }
            startConfirmation(false, itemcurrency1);
        }
    }

    public void placeBid(String s)
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                s
            });
        }
        if (s != null)
        {
            placeBid(new ItemCurrency(item.minimumToBid.lowerBound.getCurrencyCode(), s));
        }
    }

    public void placeBidAmount(Double double1)
    {
label0:
        {
            if (logTag.isLoggable)
            {
                FwLog.logMethod(logTag, new Object[] {
                    double1
                });
            }
            if (!showErrorIfAuctionEnded() && !needSignIn(UserAction.PLACE_BID_AMOUNT))
            {
                shouldSaveScrollPosition = false;
                if (!DeviceConfiguration.getAsync().get(DcsBoolean.VI_featureNewBidFlow))
                {
                    break label0;
                }
                ViewItemPlaceBidActivity.startActivity(this, null, viewData, referrer, bidSource, 18, fromMyEbayOrReminders);
            }
            return;
        }
        ViewItemViewData viewitemviewdata = viewData;
        String s = referrer;
        if (double1 != null)
        {
            double1 = String.valueOf(double1);
        } else
        {
            double1 = null;
        }
        ItemViewPlaceOfferActivity.startActivity(this, null, viewitemviewdata, s, double1, bidSource, 18, fromMyEbayOrReminders);
    }

    public void reinitializeDataManager(ViewItemViewData viewitemviewdata, long l)
    {
        getDataManagerContainer().delete(viewData.keyParams);
        transactionId = Long.valueOf(l);
        viewData.kind = viewitemviewdata.kind;
        viewData.keyParams = new ViewItemDataManager.KeyParams(item.id, Long.valueOf(l));
        scrollToTop();
        initDataManagers();
        showHideTranslucentProgress(true, true);
    }

    public void reloadItemFromNetwork(Intent intent)
    {
        boolean flag;
        boolean flag1;
        int i;
        boolean flag2;
        boolean flag3;
        flag = true;
        flag3 = true;
        flag2 = false;
        i = ((flag2) ? 1 : 0);
        flag1 = flag;
        if (intent == null) goto _L2; else goto _L1
_L1:
        i = ((flag2) ? 1 : 0);
        flag1 = flag;
        if (item == null) goto _L2; else goto _L3
_L3:
        String s;
        s = intent.getStringExtra("transaction_id");
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_250;
        }
        long l = Long.parseLong(s);
        if (viewData.keyParams.transactionId == null) goto _L5; else goto _L4
_L4:
        flag = flag3;
        if (viewData.keyParams.transactionId.equals(Long.valueOf(l))) goto _L6; else goto _L5
_L5:
        ViewItemViewData viewitemviewdata;
        viewitemviewdata = new ViewItemViewData();
        viewitemviewdata.keyParams = new ViewItemDataManager.KeyParams(viewData.keyParams.itemId, Long.valueOf(l));
        if (item == null || !item.isSeller) goto _L8; else goto _L7
_L7:
        com.ebay.common.ConstantsCommon.ItemKind itemkind = com.ebay.common.ConstantsCommon.ItemKind.Sold;
_L9:
        viewitemviewdata.kind = itemkind;
        reinitializeDataManager(viewitemviewdata, l);
        flag = false;
_L6:
        i = ((flag2) ? 1 : 0);
        flag1 = flag;
        if (flag)
        {
            i = intent.getIntExtra("meb_flags", 0);
            flag1 = flag;
        }
_L2:
        if (flag1)
        {
            issueRefresh(true, i);
        }
        return;
_L8:
        itemkind = com.ebay.common.ConstantsCommon.ItemKind.Won;
          goto _L9
        NumberFormatException numberformatexception;
        numberformatexception;
        logTag.logAsError((new StringBuilder()).append("reloadItemFromNetwork error parzing transactionid=").append(s).toString());
        flag = flag3;
          goto _L6
        flag = flag3;
        if (intent.hasExtra("offer"))
        {
            flag = flag3;
            if (item.isSeller)
            {
                flag = flag3;
                if (isSellerAcceptedOffer(intent))
                {
                    flag = false;
                }
            }
        }
          goto _L6
    }

    public void renderPlaAds(List list)
    {
        if (AdUtil.logDfpAds.isLoggable)
        {
            FwLog.logMethod(AdUtil.logDfpAds, new Object[0]);
        }
        int i = getResources().getInteger(0x7f0c0006);
        int j = getResources().getInteger(0x7f0c0003);
        int k = DeviceConfiguration.getAsync().get(com.ebay.mobile.dcs.Dcs.Ads.I.viMaxLimitShown20188);
        Object obj = (TextView)findViewById(0x7f100562);
        ((TextView) (obj)).setVisibility(0);
        int l = getResources().getDimensionPixelSize(0x7f090141);
        int i1 = getResources().getDimensionPixelSize(0x7f090149);
        ((TextView) (obj)).setPadding(l, l, 0, 0);
        ((TextView) (obj)).setTextColor(headerColor);
        ((android.widget.LinearLayout.LayoutParams)((TextView) (obj)).getLayoutParams()).setMargins(0, 0, 0, i1);
        obj = list;
        k = Math.min(k, list.size());
        if (k < list.size())
        {
            obj = list.subList(0, k);
        }
        AdUtil.renderAds(findViewById(0x7f100561), ((List) (obj)), ((com.ebay.common.rtm.RtmContent.Ad)list.get(0)).isPla, getAdsClickListener(), i, k, j);
    }

    public void showProgress()
    {
        showHideTranslucentProgress(true, true);
    }





/*
    static View access$1102(ItemViewActivity itemviewactivity, View view)
    {
        itemviewactivity.adView = view;
        return view;
    }

*/




/*
    static String access$1302(ItemViewActivity itemviewactivity, String s)
    {
        itemviewactivity.adCampaignId = s;
        return s;
    }

*/







/*
    static List access$402(ItemViewActivity itemviewactivity, List list)
    {
        itemviewactivity.shippingAddresses = list;
        return list;
    }

*/







/*
    static SearchAdView access$902(ItemViewActivity itemviewactivity, SearchAdView searchadview)
    {
        itemviewactivity.googleTextAdView = searchadview;
        return searchadview;
    }

*/
}
