// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.groupon.Channel;
import com.groupon.abtest.SearchAbTestHelper;
import com.groupon.abtest.TabOrderAbTestHelper;
import com.groupon.db.models.CouponCategory;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Location;
import com.groupon.db.models.MarketRateResult;
import com.groupon.db.models.Option;
import com.groupon.db.models.WidgetSummary;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.models.DateTimeFinderReservationDetails;
import com.groupon.models.GenericAmount;
import com.groupon.models.Place;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.category.Category;
import com.groupon.models.country.Country;
import com.groupon.models.deal.SharedDealInfoConverter;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.models.dealsearch.DealSearchResponse;
import com.groupon.models.gift.GiftingRecord;
import com.groupon.models.mobilescheduler.MobileSchedulerData;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.order.Order;
import com.groupon.models.payment.AbstractPaymentMethod;
import com.groupon.service.LocalizedMobileAppService;
import com.groupon.service.LoginService;
import com.groupon.service.ProximityNotificationService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.sso.SSOHelper;
import com.groupon.util.BuyUtils;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DivisionUtil;
import com.groupon.util.GlobalSearchUtil;
import com.groupon.util.ImageUrl;
import com.groupon.util.SmuggleUtil;
import com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            Splash, DealDetails, EditCreditCard, EditCreditCardJapan, 
//            EditCreditCardEu, EditMaestro, Carousel, MyGroupons, 
//            Login, PurchaseEu, Purchase, AboutGroupon, 
//            BugReport, BusinessTipsPage, BookingDealCalendarActivity, CancelOrder, 
//            GlobalSearchResult, Cities, Countries, CouponCategoriesActivity, 
//            CouponInstoreOnlinePage, CouponDetailsDealImageCarousel, CouponDetails, CouponSearch, 
//            CustomerService, DealImageCarousel, DealSubsetActivity, BusinessSpecialPage, 
//            DeliveryAddresses, EditElv, EditIsracard, EditOrder, 
//            EditSepa, EmailSubscriptions, ExternalPurchase, FavoriteDealTypes, 
//            GeneralThirdPartyDealWebViewActivity, GiftCodes, Gifting, GiftingThemeSelection, 
//            GlobalSearch, GoodsCategories, GoodsMultiOption, SnapGroceryDetails, 
//            Groupon, GrouponInventoryWebApp, GrouponLocationSelection, GrouponWebView, 
//            HotelDetails, IncentiveTickets, ThirdPartyLinkoutDealWebViewActivity, LiveChatActivity, 
//            GrouponSSO, GrouponBucks, MarketRatePurchase, MarketRateReservation, 
//            MarketRateThanks, BusinessDetailPage, MobileScheduler, MultiOptionActivity, 
//            MyCreditCards, PoGSearch, PoGWebview, PreconfiguredAbTests, 
//            QaDiscussionsActivity, QaDiscussionsNativeActivity, RedeemWebview, Redeem, 
//            SecretAdminSettings, OktaAuthentication, SelectRoom, Settings, 
//            ShippingAddress, ShippingAddressLATAM, ShippingAddressEu, ShowOnMap, 
//            SimpleMarkUpActivity, SnapOfferGridActivity, StockCategories, Thanks, 
//            TravelerNameActivity, BookingMetaData

public class IntentFactory
{
    public static final class Payments extends Enum
    {

        private static final Payments $VALUES[];
        public static final Payments ALIPAY;
        public static final Payments AUEASYPAY;
        public static final Payments DOTPAY;
        public static final Payments ELV;
        public static final Payments GOOGLEWALLET;
        public static final Payments IDEAL;
        public static final Payments IPAY88;
        public static final Payments ISRACARD;
        public static final Payments MAESTRO;
        public static final Payments MAESTROUK;
        public static final Payments MASTERCARDPE;
        public static final Payments MDEBITCL;
        public static final Payments MONECLICKCL;
        public static final Payments MWEBPAYCL;
        public static final Payments PAYPAL;
        public static final Payments PAYPALMX;
        public static final Payments PSEMOBILECO;
        public static final Payments SEPADIRECTDEBIT;
        public static final Payments VISANETPE;
        private final String paymentId;
        private final String paymentType;

        public static Payments paymentValueOf(String s)
        {
            try
            {
                s = valueOf(s.toUpperCase().replaceAll("-", ""));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            return s;
        }

        public static Payments valueOf(String s)
        {
            return (Payments)Enum.valueOf(com/groupon/activity/IntentFactory$Payments, s);
        }

        public static Payments[] values()
        {
            return (Payments[])$VALUES.clone();
        }

        public String getPaymentId()
        {
            return paymentId;
        }

        public String getPaymentType()
        {
            return paymentType;
        }

        static 
        {
            IDEAL = new Payments("IDEAL", 0, "ECommerce", "ideal");
            PAYPAL = new Payments("PAYPAL", 1, "ECommerce", "paypal");
            PAYPALMX = new Payments("PAYPALMX", 2, "ECommerce", "paypal-mx");
            IPAY88 = new Payments("IPAY88", 3, "ECommerce", "ipay88");
            DOTPAY = new Payments("DOTPAY", 4, "ECommerce", "dotpay");
            MAESTRO = new Payments("MAESTRO", 5, "CreditCard", "maestro");
            MAESTROUK = new Payments("MAESTROUK", 6, "CreditCard", "maestrouk");
            ELV = new Payments("ELV", 7, "CreditCard", "elv");
            ISRACARD = new Payments("ISRACARD", 8, "CreditCard", "isracard");
            SEPADIRECTDEBIT = new Payments("SEPADIRECTDEBIT", 9, "CreditCard", "sepadirectdebit");
            AUEASYPAY = new Payments("AUEASYPAY", 10, "ECommerce", "auEasyPay");
            MONECLICKCL = new Payments("MONECLICKCL", 11, "ECommerce", "m-oneclick-cl");
            MDEBITCL = new Payments("MDEBITCL", 12, "ECommerce", "m-debit-cl");
            MWEBPAYCL = new Payments("MWEBPAYCL", 13, "ECommerce", "m-webpay-cl");
            PSEMOBILECO = new Payments("PSEMOBILECO", 14, "ECommerce", "pse-mobile-co");
            VISANETPE = new Payments("VISANETPE", 15, "ECommerce", "visanet-pe");
            MASTERCARDPE = new Payments("MASTERCARDPE", 16, "ECommerce", "mastercard-pe");
            ALIPAY = new Payments("ALIPAY", 17, "ECommerce", "alipay");
            GOOGLEWALLET = new Payments("GOOGLEWALLET", 18, "ECommerce", "google-wallet");
            $VALUES = (new Payments[] {
                IDEAL, PAYPAL, PAYPALMX, IPAY88, DOTPAY, MAESTRO, MAESTROUK, ELV, ISRACARD, SEPADIRECTDEBIT, 
                AUEASYPAY, MONECLICKCL, MDEBITCL, MWEBPAYCL, PSEMOBILECO, VISANETPE, MASTERCARDPE, ALIPAY, GOOGLEWALLET
            });
        }

        private Payments(String s, int i, String s1, String s2)
        {
            super(s, i);
            paymentType = s1;
            paymentId = s2;
        }
    }


    private static final String APAC_APP = "com.groupon.tigers";
    public static final String GO_TO_CAROUSEL_ON_UP_BACK_PRESS = "goToCarouselOnUpOrBackPress";
    private AbTestService abTestService;
    protected Context context;
    protected CurrentCountryManager currentCountryManager;
    private DeviceInfoUtil deviceInfoUtil;
    private GlobalSearchUtil globalSearchUtil;
    private LoginService loginService;
    private SearchAbTestHelper searchAbTestHelper;
    private SharedDealInfoConverter sharedDealInfoConverter;
    private SmuggleUtil smuggleUtil;
    private TabOrderAbTestHelper tabOrderAbTestHelper;

    public IntentFactory()
    {
    }

    private Intent addComeFromSplashFlagIfNecessary(Intent intent)
    {
        if (intent != null && (context instanceof Splash))
        {
            intent.putExtra("COMING_FROM_SPLASH", true);
        }
        return intent;
    }

    private static Intent asRedirect(Intent intent)
    {
        intent.addFlags(32768);
        intent.addFlags(0x10000000);
        return intent;
    }

    private Intent createDealIntent()
    {
        return new Intent(context, com/groupon/activity/DealDetails);
    }

    private Intent createEditCreditCardIntent()
    {
        Context context1 = context;
        Object obj;
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            obj = com/groupon/activity/EditCreditCard;
        } else
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            obj = com/groupon/activity/EditCreditCardJapan;
        } else
        {
            obj = com/groupon/activity/EditCreditCardEu;
        }
        return new Intent(context1, ((Class) (obj)));
    }

    private Intent createMaestroIntent()
    {
        return new Intent(context, com/groupon/activity/EditMaestro);
    }

    private boolean isNearbyEnabledDivision()
    {
        return ((DivisionUtil)RoboGuice.getInjector(context).getInstance(com/groupon/util/DivisionUtil)).isNearbyAllowedForCurrentDivision();
    }

    private Intent newHotelsIntent()
    {
        boolean flag;
        if (abTestService.isVariantEnabledAndUSCA("getawaysUSCA1506", "singleTab") || !searchAbTestHelper.isUniversalSearchChannelSelectorEnabled() && abTestService.isVariantEnabledAndUSCA("getawaysUSCA1506", "singleTabWithWidget"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return newGetawaysIntent();
        } else
        {
            return addComeFromSplashFlagIfNecessary((new Intent(context, com/groupon/activity/Carousel)).putExtra("channel", Channel.HOTELS));
        }
    }

    private Intent newMyGrouponIntentActivityClearTop()
    {
        return newLoginIntent(context, new Intent(context, com/groupon/activity/MyGroupons)).addFlags(0x4000000);
    }

    private Intent newRegisterIntent(Intent intent)
    {
        return (new Intent(context, com/groupon/activity/Login)).putExtra("next", intent);
    }

    private Date parseDate(String s)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd", deviceInfoUtil.getDeviceLocale());
        try
        {
            s = simpledateformat.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    protected Intent addExtrasToNewAnyChannelIntent(Channel channel, String s, String s1)
    {
        return addComeFromSplashFlagIfNecessary((new Intent(context, com/groupon/activity/Carousel)).putExtra("channel", channel).putExtra("tracking", s).putExtra("title", s1));
    }

    public Intent createDealIntent(MarketRateResult marketrateresult, Channel channel, boolean flag, com.groupon.util.ViewUtils.Size size)
    {
        return createDealIntent().putExtra("shared_deal_info", sharedDealInfoConverter.convertFrom(marketrateresult, size)).putExtra("dealId", marketrateresult.remoteId).putExtra("isDeepLinked", flag).putExtra("channel", channel);
    }

    public Intent createDealIntent(String s, Channel channel, boolean flag)
    {
        return createDealIntent().putExtra("dealId", s).putExtra("isDeepLinked", flag).putExtra("channel", channel);
    }

    public Intent createDealIntent(String s, String s1, Channel channel, boolean flag)
    {
        return createDealIntent().putExtra("dealId", s).putExtra("optionId", s1).putExtra("isDeepLinked", flag).putExtra("channel", channel);
    }

    protected Intent createPurchaseIntent()
    {
        Context context1 = context;
        Object obj;
        if (!currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            obj = com/groupon/activity/PurchaseEu;
        } else
        {
            obj = com/groupon/activity/Purchase;
        }
        return new Intent(context1, ((Class) (obj)));
    }

    public Intent createPurchaseIntent(Deal deal, String s, String s1, boolean flag, boolean flag1, DateTimeFinderReservationDetails datetimefinderreservationdetails)
    {
        Context context1 = context;
        Object obj;
        if (!currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            obj = com/groupon/activity/PurchaseEu;
        } else
        {
            obj = com/groupon/activity/Purchase;
        }
        obj = new Intent(context1, ((Class) (obj)));
        ((Intent) (obj)).putExtra("dealId", deal.remoteId);
        ((Intent) (obj)).putExtra("optionId", s);
        ((Intent) (obj)).putExtra("flow", "checkout");
        ((Intent) (obj)).putExtra("is_lottery_deal", deal.isApplyButton);
        ((Intent) (obj)).putExtra("mobile_only", flag);
        ((Intent) (obj)).putExtra("redirect_to_enter_code", flag1);
        ((Intent) (obj)).putExtra("defaultOptionId", s1);
        if (datetimefinderreservationdetails != null)
        {
            deal = new Bundle(1);
            deal.putParcelable("reservation_details", datetimefinderreservationdetails);
            ((Intent) (obj)).putExtra("reservation_details_bundle", deal);
        }
        return ((Intent) (obj));
    }

    public Intent externalUrlIntent(String s)
    {
        return new Intent("android.intent.action.VIEW", Uri.parse(s));
    }

    public Intent new3DSecurePaymentIntent(AbstractPaymentMethod abstractpaymentmethod)
    {
        Payments payments;
        abstractpaymentmethod = abstractpaymentmethod.getName();
        payments = Payments.paymentValueOf(abstractpaymentmethod);
        if (payments == null) goto _L2; else goto _L1
_L1:
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$Channel[];
            static final int $SwitchMap$com$groupon$activity$IntentFactory$Payments[];

            static 
            {
                $SwitchMap$com$groupon$Channel = new int[Channel.values().length];
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.SHOPPING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.GOODS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.TRAVEL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.GETAWAYS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.HOTELS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.MARKET_RATE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.OCCASIONS.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.NEARBY.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.FEATURED.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.COUPONS.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$groupon$activity$IntentFactory$Payments = new int[Payments.values().length];
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[Payments.MAESTRO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[Payments.MAESTROUK.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.groupon.activity.IntentFactory.Payments[payments.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 46
    //                   2 46;
           goto _L2 _L3 _L3
_L2:
        return null;
_L3:
        return createMaestroIntent().putExtra("card_type", abstractpaymentmethod);
    }

    public Intent newAPACDownloadIntent()
    {
        return newMarketDownloadIntent("com.groupon.tigers");
    }

    public Intent newAboutGrouponIntent()
    {
        return new Intent(context, com/groupon/activity/AboutGroupon);
    }

    public Intent newAnyChannelIntent(Channel channel, String s)
    {
        String s1 = channel.toString();
        if (!Strings.notEmpty(s1))
        {
            s1 = "";
        }
        return addExtrasToNewAnyChannelIntent(channel, s1, s);
    }

    public Intent newApplicationExitIntent()
    {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(0x10000000);
        return intent;
    }

    public Intent newBugReportIntent(String s, String s1)
    {
        return (new Intent(context, com/groupon/activity/BugReport)).putExtra("activity_name", s).putExtra("bitmap", s1);
    }

    public Intent newBusinessTipsIntent(String s)
    {
        return (new Intent(context, com/groupon/activity/BusinessTipsPage)).putExtra("business_id", s);
    }

    public Intent newCalendarBookingIntent(Deal deal, Channel channel, String s, Date date, Date date1, boolean flag)
    {
        Intent intent = new Intent(context, com/groupon/activity/BookingDealCalendarActivity);
        deal = deal.remoteId;
        intent.putExtra("dealId", deal);
        intent.putExtra("optionId", s);
        intent.putExtra("check_in_date", date);
        intent.putExtra("check_out_date", date1);
        intent.putExtra("redirect_to_enter_code", flag);
        intent.putExtra("channel", channel);
        return newLoginIntent(context, intent, deal, s, channel);
    }

    public Intent newCalendarBookingIntentWithClearTop(String s, String s1, Channel channel)
    {
        Intent intent = new Intent(context, com/groupon/activity/BookingDealCalendarActivity);
        intent.putExtra("dealId", s);
        intent.putExtra("optionId", s1);
        intent.setFlags(0x4000000);
        return newLoginIntent(context, intent, s, s1, channel);
    }

    public Intent newCameraCapture(File file)
    {
        return (new Intent("android.media.action.IMAGE_CAPTURE")).putExtra("output", Uri.fromFile(file));
    }

    public Intent newCancelOrderIntent()
    {
        return new Intent(context, com/groupon/activity/CancelOrder);
    }

    public transient Intent newCarouselChannelIntent(Channel channel, String as[])
    {
        return newCarouselChannelIntentWithDealSmuggling(channel, as);
    }

    public transient Intent newCarouselChannelIntentWithDealSmuggling(Channel channel, String as[])
    {
        Channel channel1;
label0:
        {
            if (channel != null)
            {
                channel1 = channel;
                if (channel.isNavigableTo())
                {
                    break label0;
                }
            }
            channel1 = Channel.FEATURED;
        }
        _cls1..SwitchMap.com.groupon.Channel[channel1.ordinal()];
        JVM INSTR tableswitch 1 10: default 80
    //                   1 105
    //                   2 113
    //                   3 121
    //                   4 121
    //                   5 129
    //                   6 137
    //                   7 145
    //                   8 153
    //                   9 161
    //                   10 179;
           goto _L1 _L2 _L3 _L4 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        channel = null;
_L12:
        if (channel != null && as != null)
        {
            smuggleUtil.addDealsToBeSmuggledToIntent(channel, channel1, Arrays.asList(as));
        }
        return channel;
_L2:
        channel = newShoppingIntent();
        continue; /* Loop/switch isn't completed */
_L3:
        channel = newGoodsIntent();
        continue; /* Loop/switch isn't completed */
_L4:
        channel = newGetawaysIntent();
        continue; /* Loop/switch isn't completed */
_L5:
        channel = newHotelsIntent();
        continue; /* Loop/switch isn't completed */
_L6:
        channel = newHotelsIntent();
        continue; /* Loop/switch isn't completed */
_L7:
        channel = newOccasionsChannelIntent();
        continue; /* Loop/switch isn't completed */
_L8:
        channel = newNearbyDealsIntent();
        continue; /* Loop/switch isn't completed */
_L9:
        channel = addExtrasToNewAnyChannelIntent(Channel.FEATURED, Channel.FEATURED.toString(), null);
        continue; /* Loop/switch isn't completed */
_L10:
        channel = newCouponIntent();
        if (true) goto _L12; else goto _L11
_L11:
    }

    public Intent newCarouselIntent()
    {
        Object obj = null;
        if (context instanceof Splash)
        {
            obj = tabOrderAbTestHelper.getTabOrderVariant();
            if (obj != null)
            {
                obj = Channel.safeValueOf(((com.groupon.abtest.TabOrderAbTestHelper.TabOrderVariant) (obj)).getDefaultChannel());
            } else
            {
                obj = null;
            }
        }
        if (obj == null)
        {
            obj = Channel.FEATURED;
        }
        return newCarouselChannelIntent(((Channel) (obj)), new String[0]);
    }

    public Intent newCarouselIntentOpenNavigationDrawer()
    {
        Intent intent = newCarouselIntent().putExtra("open_navigation_drawer", true);
        Channel channel = (Channel)intent.getParcelableExtra("channel");
        intent.removeExtra("channel");
        return newLoginIntent(context, intent).putExtra("channel", channel);
    }

    public Intent newCategoryCarouselGlobalSearchResultIntent(Channel channel, Category category, int i, boolean flag, boolean flag1)
    {
        Intent intent = new Intent(context, com/groupon/activity/GlobalSearchResult);
        intent.putExtra("search_term", category.friendlyName);
        Place place = new Place();
        Bundle bundle = new Bundle();
        bundle.putParcelable("selected_place", place);
        intent.putExtra("selected_place_bundle", bundle);
        intent.putExtra("sourceChannel", channel);
        intent.putExtra("global_search_channel_filter", globalSearchUtil.filterStringForChannel(channel));
        intent.putExtra("carousel_origin_channel", channel);
        intent.putExtra("selected_category_item", category);
        intent.putExtra("selected_category_id", i);
        intent.putExtra("category_carousel", flag);
        intent.putExtra("isDeepLinked", flag1);
        return intent;
    }

    public Intent newConfirmGetawaysPurchaseIntent(String s, Channel channel, String s1, BookingMetaData bookingmetadata, boolean flag)
    {
        return (new Intent(context, com/groupon/activity/Purchase)).putExtra("getaways_booking", bookingmetadata).putExtra("dealId", s).putExtra("channel", channel).putExtra("optionId", s1).putExtra("redirect_to_enter_code", flag);
    }

    public Intent newCountryOrDivisionSelector()
    {
        Context context1 = context;
        Object obj;
        if (currentCountryManager.getCurrentCountry() != null)
        {
            obj = com/groupon/activity/Cities;
        } else
        {
            obj = com/groupon/activity/Countries;
        }
        return new Intent(context1, ((Class) (obj)));
    }

    public Intent newCountrySelector()
    {
        return new Intent(context, com/groupon/activity/Countries);
    }

    public Intent newCouponCategoryFilterPageIntent(CouponCategory couponcategory)
    {
        CouponInstoreOnlinePage.PageType pagetype;
        if (couponcategory.instoreCouponsCount == 0 && couponcategory.onlineCouponsCount > 0)
        {
            pagetype = CouponInstoreOnlinePage.PageType.ONLINE;
        } else
        {
            pagetype = CouponInstoreOnlinePage.PageType.INSTORE;
        }
        return newCouponCategoryOrMerchantFilterPageIntent(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_CATEGORY, pagetype, couponcategory.getTitle(), couponcategory.getSlug(), couponcategory.getRemoteId());
    }

    public Intent newCouponCategoryNavigateIntent()
    {
        return (new Intent(context, com/groupon/activity/CouponCategoriesActivity)).putExtra("channel", Channel.COUPONS).putExtra("db_channel", (new StringBuilder()).append(Channel.COUPONS.toString()).append(com/groupon/activity/CouponCategoriesActivity.getSimpleName()).toString());
    }

    public Intent newCouponCategoryOrMerchantFilterPageIntent(com.groupon.v3.view.list_view.CouponListItemType.ListItemType listitemtype, CouponInstoreOnlinePage.PageType pagetype, String s, String s1, String s2)
    {
        return (new Intent(context, com/groupon/activity/CouponInstoreOnlinePage)).putExtra("couponFilterId", s2).putExtra("couponFilterItemType", listitemtype).putExtra("couponFilterStarterTab", pagetype).putExtra("couponFilterPagerTitle", s).putExtra("couponFilterPagerSlug", s1);
    }

    public Intent newCouponDetailsDealImageCarouselIntent(ArrayList arraylist, int i, String s, JsonEncodedNSTField jsonencodednstfield, Channel channel)
    {
        return (new Intent(context, com/groupon/activity/CouponDetailsDealImageCarousel)).putExtra("deal_image_big_urls", arraylist).putExtra("deal_details_image_current_position", i).putExtra("coupon_toast_message", s).putExtra("impression_metadata", jsonencodednstfield).putExtra("channel", channel);
    }

    public Intent newCouponDetailsIntent(String s, Channel channel)
    {
        return (new Intent(context, com/groupon/activity/CouponDetails)).putExtra("couponId", s).putExtra("channel", channel);
    }

    protected Intent newCouponIntent()
    {
        return addComeFromSplashFlagIfNecessary((new Intent(context, com/groupon/activity/Carousel)).putExtra("channel", Channel.COUPONS));
    }

    public Intent newCouponMerchantFilterPageIntent(CouponMerchant couponmerchant)
    {
        CouponInstoreOnlinePage.PageType pagetype;
        if (couponmerchant.instoreCouponsCount == 0 && couponmerchant.onlineCouponsCount > 0)
        {
            pagetype = CouponInstoreOnlinePage.PageType.ONLINE;
        } else
        {
            pagetype = CouponInstoreOnlinePage.PageType.INSTORE;
        }
        return newCouponMerchantFilterPageIntent(couponmerchant, pagetype);
    }

    public Intent newCouponMerchantFilterPageIntent(CouponMerchant couponmerchant, CouponInstoreOnlinePage.PageType pagetype)
    {
        return newCouponCategoryOrMerchantFilterPageIntent(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_MERCHANT, pagetype, couponmerchant.getTitle(), couponmerchant.getSlug(), couponmerchant.getRemoteId());
    }

    public Intent newCouponSearchIntent()
    {
        return new Intent(context, com/groupon/activity/CouponSearch);
    }

    public Intent newCustomerServiceIntent()
    {
        return newLoginIntent(context, new Intent(context, com/groupon/activity/CustomerService));
    }

    public Intent newDealImageCarouselIntent(ArrayList arraylist, int i, String s, Channel channel, String s1)
    {
        return (new Intent(context, com/groupon/activity/DealImageCarousel)).putExtra("deal_image_big_urls", arraylist).putExtra("deal_details_image_current_position", i).putExtra("dealId", s).putExtra("dealTitle", s1).putExtra("channel", channel);
    }

    public Intent newDealIntent(Deal deal, Channel channel)
    {
        return createDealIntent().putExtra("dealId", deal.remoteId).putExtra("channel", channel).putExtra("isDeepLinked", false);
    }

    public Intent newDealIntent(DealSummary dealsummary)
    {
        return createDealIntent().putExtra("dealId", dealsummary.remoteId).putExtra("channel", dealsummary.getChannel()).putExtra("isDeepLinked", false);
    }

    public Intent newDealIntent(DealSummary dealsummary, Channel channel, com.groupon.util.ViewUtils.Size size)
    {
        return createDealIntent().putExtra("shared_deal_info", sharedDealInfoConverter.convertFrom(dealsummary, size)).putExtra("dealId", dealsummary.remoteId).putExtra("channel", channel).putExtra("isDeepLinked", false);
    }

    public Intent newDealIntent(DealSummary dealsummary, Option option, Channel channel, com.groupon.util.ViewUtils.Size size)
    {
        Country country = currentCountryManager.getCurrentCountry();
        boolean flag;
        if (country != null && country.isJapan())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return createDealIntent().putExtra("shared_deal_info", sharedDealInfoConverter.convertFrom(dealsummary, option, size, flag)).putExtra("dealId", dealsummary.remoteId).putExtra("optionId", option.remoteId).putExtra("channel", channel).putExtra("isDeepLinked", false);
    }

    public Intent newDealIntent(MarketRateResult marketrateresult, Channel channel, boolean flag, Date date, Date date1, com.groupon.util.ViewUtils.Size size)
    {
        return createDealIntent(marketrateresult, channel, flag, size).putExtra("check_in_date", date).putExtra("check_out_date", date1);
    }

    public Intent newDealIntent(DealSearchResponse dealsearchresponse, Channel channel, boolean flag)
    {
        return createDealIntent().putExtra("dealId", dealsearchresponse.id).putExtra("channel", channel).putExtra("isDeepLinked", flag);
    }

    public Intent newDealIntent(String s, Channel channel, boolean flag)
    {
        return createDealIntent(s, channel, flag);
    }

    public Intent newDealIntent(String s, Channel channel, boolean flag, boolean flag1)
    {
        return createDealIntent(s, channel, flag).putExtra("isFromMyGroupons", flag1);
    }

    public Intent newDealIntentFromWidget(DealSummary dealsummary, Channel channel, int i, com.groupon.util.ViewUtils.Size size)
    {
        return createDealIntent().putExtra("shared_deal_info", sharedDealInfoConverter.convertFrom(dealsummary, size)).putExtra("dealId", dealsummary.remoteId).putExtra("channel", channel).putExtra("isDeepLinked", false).putExtra("num_deal_activities_on_stack", i);
    }

    public Intent newDealIntentWithActivityClearTop(String s, String s1)
    {
        return newDealIntentWithOption(s, s1, false).addFlags(0x4000000);
    }

    public Intent newDealIntentWithExplicitOption(String s, Channel channel, String s1)
    {
        return createDealIntent(s, s1, channel, false).putExtra("explicit_option_selected", true);
    }

    public Intent newDealIntentWithOption(Deal deal, Channel channel, String s, int i)
    {
        return newDealIntent(deal, channel).putExtra("optionId", s).putExtra("num_deal_activities_on_stack", i);
    }

    public Intent newDealIntentWithOption(DealSummary dealsummary, Option option, Channel channel, int i, com.groupon.util.ViewUtils.Size size)
    {
        return newDealIntent(dealsummary, option, channel, size).putExtra("num_deal_activities_on_stack", i);
    }

    public Intent newDealIntentWithOption(String s, String s1, boolean flag)
    {
        return createDealIntent(s, s1, ((Channel) (null)), false).putExtra("explicit_option_selected", true).putExtra("isFromMyGroupons", flag);
    }

    public Intent newDealSubsetIntent(WidgetSummary widgetsummary, Channel channel)
    {
        Object obj5 = widgetsummary.moreAssetsDealsUrl;
        Object obj4 = widgetsummary.type;
        Object obj3 = widgetsummary.displayName;
        Object obj2 = widgetsummary.campaign;
        Object obj1 = widgetsummary.requestId;
        Object obj = widgetsummary.treatment;
        String s = widgetsummary.scenarioId;
        Intent intent = new Intent(context, com/groupon/activity/DealSubsetActivity);
        if (obj5 != null)
        {
            widgetsummary = ((WidgetSummary) (obj5));
        } else
        {
            widgetsummary = "";
        }
        obj5 = intent.putExtra("partial_deal_subset_url", widgetsummary);
        if (obj4 != null)
        {
            widgetsummary = ((WidgetSummary) (obj4));
        } else
        {
            widgetsummary = "";
        }
        obj4 = ((Intent) (obj5)).putExtra("subset_id", widgetsummary);
        if (obj3 != null)
        {
            widgetsummary = ((WidgetSummary) (obj3));
        } else
        {
            widgetsummary = "";
        }
        obj3 = ((Intent) (obj4)).putExtra("title", widgetsummary);
        if (obj2 != null)
        {
            widgetsummary = ((WidgetSummary) (obj2));
        } else
        {
            widgetsummary = "";
        }
        obj2 = ((Intent) (obj3)).putExtra("widget_campaign", widgetsummary);
        if (obj1 != null)
        {
            widgetsummary = ((WidgetSummary) (obj1));
        } else
        {
            widgetsummary = "";
        }
        obj1 = ((Intent) (obj2)).putExtra("widget_request_id", widgetsummary);
        if (obj != null)
        {
            widgetsummary = ((WidgetSummary) (obj));
        } else
        {
            widgetsummary = "";
        }
        obj = ((Intent) (obj1)).putExtra("widget_treatment", widgetsummary);
        if (s != null)
        {
            widgetsummary = s;
        } else
        {
            widgetsummary = "";
        }
        widgetsummary = ((Intent) (obj)).putExtra("widget_scenario_id", widgetsummary);
        if (channel == null)
        {
            channel = Channel.UNKNOWN;
        }
        return widgetsummary.putExtra("originating_channel", channel).putExtra("num_deal_subset_activities_on_stack", 0);
    }

    public Intent newDealSubsetIntent(WidgetSummary widgetsummary, Channel channel, String s)
    {
        return newDealSubsetIntent(widgetsummary, channel).putExtra("slot_id", s);
    }

    public Intent newDealSubsetIntent(DeepLinkData deeplinkdata)
    {
        return (new Intent(context, com/groupon/activity/DealSubsetActivity)).putExtra("partial_deal_subset_url", deeplinkdata.toString()).putExtra("subset_id", "").putExtra("title", deeplinkdata.getParam("x_client_consumed_title")).putExtra("widget_campaign", "").putExtra("widget_request_id", "").putExtra("widget_treatment", "").putExtra("widget_scenario_id", "").putExtra("originating_channel", Channel.UNKNOWN).putExtra("num_deal_subset_activities_on_stack", 0);
    }

    public Intent newDeepLinkSpecialIntent(String s, String s1)
    {
        return (new Intent(context, com/groupon/activity/BusinessSpecialPage)).putExtra("special_id", s).putExtra("business_id", s1);
    }

    public Intent newDeliveryAddressesIntent(String s, String s1, Channel channel)
    {
        return newDeliveryAddressesIntent(s, s1, channel, 0, null, null);
    }

    public Intent newDeliveryAddressesIntent(String s, String s1, Channel channel, int i, String s2, String s3)
    {
        return (new Intent(context, com/groupon/activity/DeliveryAddresses)).putExtra("dealId", s).putExtra("optionId", s1).putExtra("channel", channel).putExtra("num_items_in_cart", i).putExtra("max_cart_discount", s2).putExtra("cart_deal_image_url", s3);
    }

    public Intent newECommerceIntent(Order order, int i, Class class1)
    {
        class1 = new Intent(context, class1);
        Bundle bundle = new Bundle();
        bundle.putParcelable("order", order);
        bundle.putInt("payment_quantity", i);
        class1.putExtras(bundle);
        return class1;
    }

    public Intent newEditCreditCardIntent(BillingRecord billingrecord)
    {
        return newLoginIntent(context, createEditCreditCardIntent().putExtra("CREDIT_CARD", billingrecord));
    }

    public Intent newEditCreditCardIntent(String s, String s1, List list, Channel channel, Bundle bundle)
    {
        s1 = newLoginIntent(context, createEditCreditCardIntent().putExtra("dealId", s).putExtra("cart_uuid", s1));
        if (list != null)
        {
            s = (String[])list.toArray(new String[list.size()]);
        } else
        {
            s = null;
        }
        return s1.putExtra("available_cc_payment_methods_for_deal", s).putExtra("creditCardConsentRequirements", bundle).putExtra("channel", channel);
    }

    public Intent newEditCreditCardIntent(List list, Channel channel, Bundle bundle)
    {
        return newEditCreditCardIntent(null, null, list, channel, bundle);
    }

    public Intent newEditElvIntent()
    {
        return new Intent(context, com/groupon/activity/EditElv);
    }

    public Intent newEditIsracardIntent()
    {
        return new Intent(context, com/groupon/activity/EditIsracard);
    }

    public Intent newEditOrderIntent(String s, String s1)
    {
        return newLoginIntent(context, new Intent(context, com/groupon/activity/EditOrder)).putExtra("dealId", s).putExtra("orderID", s1);
    }

    public Intent newEditSepaIntent()
    {
        return new Intent(context, com/groupon/activity/EditSepa);
    }

    public Intent newEmailSubscriptionsIntent()
    {
        return newLoginIntent(context, new Intent(context, com/groupon/activity/EmailSubscriptions));
    }

    public Intent newExternalPurchaseIntent(String s, String s1, String s2)
    {
        Intent intent = new Intent(context, com/groupon/activity/ExternalPurchase);
        intent.putExtra("dealId", s);
        intent.putExtra("optionId", s1);
        intent.putExtra("quantity", s2);
        return intent;
    }

    public Intent newExternalUrlIntent(String s, String s1, Channel channel, String s2)
    {
        s = externalUrlIntent(s);
        Intent intent = newLoginIntent(context, s);
        if (intent != s)
        {
            intent.putExtra("dealId", s1).putExtra("optionId", s2).putExtra("channel", channel).putExtra("comingFromCheckout", true);
        }
        return intent;
    }

    public Intent newFavoriteDealTypesIntent()
    {
        return newLoginIntent(context, new Intent(context, com/groupon/activity/FavoriteDealTypes));
    }

    public Intent newGeneralThirdPartyDealWebViewIntent(String s)
    {
        return (new Intent(context, com/groupon/activity/GeneralThirdPartyDealWebViewActivity)).putExtra("linkout_deal_url", s);
    }

    public Intent newGetawaysIntent()
    {
        if (currentCountryManager.getCurrentCountry().isTravelChannelEnabled())
        {
            Intent intent = new Intent(context, com/groupon/activity/Carousel);
            Channel channel;
            if (currentCountryManager.getCurrentCountry().isUSACompatible())
            {
                channel = Channel.GETAWAYS;
            } else
            {
                channel = Channel.TRAVEL;
            }
            return addComeFromSplashFlagIfNecessary(intent.putExtra("channel", channel));
        } else
        {
            return newCarouselIntent();
        }
    }

    public Intent newGiftCodesIntent(String s, String s1, Channel channel)
    {
        return newGiftCodesIntent(s, s1, channel, 0, null, null);
    }

    public Intent newGiftCodesIntent(String s, String s1, Channel channel, int i, String s2, String s3)
    {
        return newLoginIntent(context, (new Intent(context, com/groupon/activity/GiftCodes)).putExtra("dealId", s).putExtra("optionId", s1).putExtra("channel", channel).putExtra("num_items_in_cart", i)).putExtra("max_cart_discount", s2).putExtra("cart_deal_image_url", s3);
    }

    public Intent newGiftingIntent(Context context1, GiftingRecord giftingrecord, String s, Intent intent, boolean flag)
    {
        return newLoginIntent(context1, (new Intent(context1, com/groupon/activity/Gifting)).putExtra("giftingRecord", giftingrecord).putExtra("dealId", s).putExtra("next", intent).putExtra("isGiftableDeal", flag));
    }

    public Intent newGiftingThemeSelectionIntent()
    {
        return new Intent(context, com/groupon/activity/GiftingThemeSelection);
    }

    public Intent newGlobalSearchIntent(Channel channel)
    {
        return (new Intent(context, com/groupon/activity/GlobalSearch)).putExtra("sourceChannel", channel);
    }

    public Intent newGlobalSearchIntent(Channel channel, String s)
    {
        return newGlobalSearchIntent(channel).putExtra("search_term", s);
    }

    public Intent newGlobalSearchIntent(Channel channel, String s, boolean flag)
    {
        return newGlobalSearchIntent(channel, s).putExtra("wasDeepLinked", flag);
    }

    public Intent newGlobalSearchResultIntent(DeepLinkData deeplinkdata)
    {
        Place place = new Place();
        Bundle bundle = new Bundle();
        bundle.putParcelable("selected_place", place);
        return (new Intent(context, com/groupon/activity/GlobalSearchResult)).putExtra("deep_link_with_api_parameters", deeplinkdata.toString()).putExtra("sourceChannel", Channel.UNKNOWN).putExtra("search_term", "").putExtra("selected_place", place).putExtra("selected_place_bundle", bundle).putExtra("current_category_id", "");
    }

    public Intent newGoodsCategoriesIntent(int i, int j)
    {
        return (new Intent(context, com/groupon/activity/GoodsCategories)).putExtra("lat", i).putExtra("lng", j);
    }

    public Intent newGoodsIntent()
    {
        if (currentCountryManager.getCurrentCountry().isShoppingChannelEnabled())
        {
            return addExtrasToNewAnyChannelIntent(Channel.GOODS, Channel.GOODS.toString(), null);
        } else
        {
            return newCarouselIntent();
        }
    }

    public Intent newGoodsIntent(boolean flag)
    {
        return newGoodsIntent().putExtra("isDeepLinked", flag);
    }

    public Intent newGoodsMultiOptionIntent(String s, Channel channel, int i)
    {
        if (i == 1 || i == 2)
        {
            return (new Intent(context, com/groupon/activity/GoodsMultiOption)).putExtra("dealId", s).putExtra("channel", channel).putExtra("traitCount", i);
        } else
        {
            return null;
        }
    }

    public Intent newGoodsMultiOptionIntent(String s, Channel channel, int i, int j)
    {
        return newGoodsMultiOptionIntent(s, channel, i).putExtra("num_deal_activities_on_stack", j);
    }

    public Intent newGroceryDetailIntent(String s, String s1, Channel channel)
    {
        return (new Intent(context, com/groupon/activity/SnapGroceryDetails)).putExtra("groceryId", s).putExtra("channel", channel).putExtra("productName", s1);
    }

    public Intent newGrouponIntent(String s, boolean flag, int i)
    {
        s = (new Intent(context, com/groupon/activity/Groupon)).putExtra("dealId", s).putExtra("isUsedMyGroupon", flag);
        if (i != -1)
        {
            s.putExtra("my_groupons_tab_position", i);
        }
        return newLoginIntent(context, s);
    }

    public Intent newGrouponInventoryWebAppIntent(String s)
    {
        return newLoginIntent(context, (new Intent(context, com/groupon/activity/GrouponInventoryWebApp)).putExtra("dealId", s));
    }

    public Intent newGrouponLocationSelectionIntent(String s, HashMap hashmap)
    {
        return (new Intent(context, com/groupon/activity/GrouponLocationSelection)).putExtra("groupon_id", s).putExtra("location_address_id_pairs", hashmap);
    }

    public Intent newGrouponSupportIntent(String s)
    {
        return (new Intent("android.intent.action.VIEW")).setData(Uri.parse(context.getString(0x7f0804e5, new Object[] {
            s
        })));
    }

    public Intent newGrouponSupportWithoutIdIntent()
    {
        return (new Intent("android.intent.action.VIEW")).setData(Uri.parse(context.getString(0x7f0804e5)));
    }

    public Intent newGrouponWebViewIntent(String s, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        Intent intent = new Intent(context, com/groupon/activity/GrouponWebView);
        intent.putExtra("url", s).putExtra("needs_location", flag1).putExtra("needs_x_cookies", flag2).putExtra("isDeepLinked", flag4).putExtra("hide_header", flag3);
        s = intent;
        if (flag)
        {
            s = newLoginIntent(context, intent);
        }
        return s;
    }

    public Intent newHotelDealDetailsIntent(MarketRateResult marketrateresult, String s, String s1, int i, int j, boolean flag, Channel channel, 
            String s2, com.groupon.util.ViewUtils.Size size)
    {
        return (new Intent(context, com/groupon/activity/HotelDetails)).putExtra("shared_deal_info", sharedDealInfoConverter.convertFrom(marketrateresult, size)).putExtra("id", marketrateresult.remoteId).putExtra("uuid", marketrateresult.uuid).putExtra("productType", marketrateresult.productType).putExtra("channel_id", s2).putExtra("check_in_date", s).putExtra("check_out_date", s1).putExtra("adults", i).putExtra("children", j).putExtra("search_flow", flag).putExtra("channel", channel).putExtra("hasRaO", marketrateresult.hasRaO);
    }

    public Intent newHotelSearchIntent(Channel channel)
    {
        return newHotelSearchIntent(channel, false);
    }

    public Intent newHotelSearchIntent(Channel channel, boolean flag)
    {
        return (new Intent(context, com/groupon/activity/GlobalSearch)).putExtra("sourceChannel", channel).putExtra("channel", Channel.MARKET_RATE).putExtra("show_nearby_tonight", flag);
    }

    public Intent newIncentiveTicketsIntent(boolean flag, String s)
    {
        return (new Intent(context, com/groupon/activity/IncentiveTickets)).putExtra("comingFromCheckout", flag).putExtra("incentive_ticket_type", s);
    }

    public Intent newIncentiveTicketsIntent(boolean flag, String s, boolean flag1, String s1)
    {
        return newIncentiveTicketsIntent(flag, s).putExtra("isUsingGiftCodes", flag1).putExtra("dealId", s1);
    }

    public Intent newLinkoutDealWebviewIntent(String s, String s1)
    {
        return (new Intent(context, com/groupon/activity/ThirdPartyLinkoutDealWebViewActivity)).putExtra("external_deal_provider_name", s).putExtra("linkout_deal_url", s1);
    }

    public Intent newLiveChatIntent()
    {
        return new Intent(context, com/groupon/activity/LiveChatActivity);
    }

    public Intent newLocalizedMobileAppServiceIntent(LocationInfo locationinfo)
    {
        return (new Intent(context, com/groupon/service/LocalizedMobileAppService)).putExtra("com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo", locationinfo);
    }

    public Intent newLoginIntent(Context context1)
    {
        return newLoginIntent(context1, null);
    }

    public Intent newLoginIntent(Context context1, Intent intent)
    {
        if (((LoginService)RoboGuice.getInjector(context1).getInstance(com/groupon/service/LoginService)).isLoggedIn())
        {
            return intent;
        }
        List list = SSOHelper.getAccountsExcludeOwnAppAccount(context1, currentCountryManager.getCurrentCountry().isoName);
        if (list != null && !list.isEmpty())
        {
            context1 = (new Intent(context1, com/groupon/activity/GrouponSSO)).putExtra("credential", (Parcelable)list.get(0));
        } else
        {
            context1 = new Intent(context1, com/groupon/activity/Login);
        }
        if (intent != null)
        {
            context1.putExtra("next", intent);
        }
        return context1;
    }

    public Intent newLoginIntent(Context context1, Intent intent, String s, String s1, Channel channel)
    {
        return newLoginIntent(context1, intent).putExtra("dealId", s).putExtra("optionId", s1).putExtra("channel", channel);
    }

    public Intent newLoginIntent(Context context1, Intent intent, String s, String s1, Boolean boolean1)
    {
        return (new Intent(context1, com/groupon/activity/Login)).putExtra("next", intent).putExtra("dealId", s).putExtra("optionId", s1).putExtra("comingFromCheckout", boolean1);
    }

    public Intent newLoginIntentWithBackNavigationToCarousel(Context context1, Intent intent)
    {
        return newLoginIntent(context1, intent).putExtra("goToCarouselOnUpOrBackPress", true);
    }

    public Intent newMarketDownloadIntent()
    {
        return Intent.createChooser(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(context.getPackageName()).toString())), context.getString(0x7f080302));
    }

    public Intent newMarketDownloadIntent(String s)
    {
        return Intent.createChooser(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(s).toString())), context.getString(0x7f080302));
    }

    public Intent newMarketRateGBucksIntent(GenericAmount genericamount, String s)
    {
        return (new Intent(context, com/groupon/activity/GrouponBucks)).putExtra("g_bucks", genericamount).putExtra("g_bucks_disclaimer", s);
    }

    public Intent newMarketRatePurchaseIntent(String s, String s1, String s2, String s3, Channel channel, String s4, String s5, 
            String s6, BookingMetaData bookingmetadata)
    {
        return MarketRatePurchase.instantiate(context, s5, s4, s, s1, s2, s3, channel, s6, bookingmetadata);
    }

    public Intent newMarketRateReservationIntent(String s, String s1)
    {
        return (new Intent(context, com/groupon/activity/MarketRateReservation)).putExtra("reservation_id", s).putExtra("hotel_timezone_identifier", s1);
    }

    public Intent newMarketRateThanksIntent(String s, boolean flag, Channel channel)
    {
        return (new Intent(context, com/groupon/activity/MarketRateThanks)).putExtra("hotel_name", s).putExtra("order_still_processing", flag).putExtra("sourceChannel", channel);
    }

    public Intent newMerchantPageIntent(String s)
    {
        return (new Intent(context, com/groupon/activity/BusinessDetailPage)).putExtra("business_id", s).putExtra("is_list_offers", false);
    }

    public Intent newMobileSchedulerIntent(MobileSchedulerData mobileschedulerdata, Channel channel, boolean flag, boolean flag1, boolean flag2, Intent intent)
    {
        return newMobileSchedulerIntentWithPredefinedReservation(mobileschedulerdata, null, channel, flag, flag1, flag2, intent);
    }

    public Intent newMobileSchedulerIntentWithPredefinedReservation(MobileSchedulerData mobileschedulerdata, DateTimeFinderReservationDetails datetimefinderreservationdetails, Channel channel, boolean flag, boolean flag1, boolean flag2, Intent intent)
    {
        ObjectMapper objectmapper = new ObjectMapper();
        try
        {
            mobileschedulerdata = (new Intent(context, com/groupon/activity/MobileScheduler)).putExtra("json", objectmapper.writeValueAsString(mobileschedulerdata)).putExtra("is_gdt", flag).putExtra("from_thank_you", flag1).putExtra("is_prepurchase_booking", flag2).putExtra("channel", channel).putExtra("next", intent);
        }
        // Misplaced declaration of an exception variable
        catch (MobileSchedulerData mobileschedulerdata)
        {
            Ln.e(mobileschedulerdata, "Impossible to write the mobile scheduler as a string.", new Object[0]);
            return null;
        }
        if (datetimefinderreservationdetails == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        channel = new Bundle(1);
        channel.putParcelable("reservation_details", datetimefinderreservationdetails);
        mobileschedulerdata.putExtra("reservation_details_bundle", channel);
        return mobileschedulerdata;
    }

    public Intent newMultiOptionIntent(Channel channel, String s, Intent intent)
    {
        return (new Intent(context, com/groupon/activity/MultiOptionActivity)).putExtra("channel", channel).putExtra("dealId", s).putExtra("next", intent);
    }

    public Intent newMultiOptionIntent(Channel channel, String s, Date date, Date date1, boolean flag, boolean flag1, Intent intent)
    {
        return (new Intent(context, com/groupon/activity/MultiOptionActivity)).putExtra("channel", channel).putExtra("dealId", s).putExtra("check_in_date", date).putExtra("check_out_date", date1).putExtra("mobile_only", flag).putExtra("redirect_to_enter_code", flag1).putExtra("next", intent);
    }

    public Intent newMyCreditCardIntent()
    {
        return newMyCreditCardIntent(false);
    }

    public Intent newMyCreditCardIntent(String s, String s1, Channel channel, int i, String s2, String s3, String s4, 
            HashMap hashmap, Bundle bundle)
    {
        return newMyCreditCardIntent(s, s1, channel, false, false, false, i, s2, s3, s4, hashmap, bundle);
    }

    public Intent newMyCreditCardIntent(String s, String s1, Channel channel, boolean flag, boolean flag1, boolean flag2, int i, 
            String s2, String s3, String s4, HashMap hashmap, Bundle bundle)
    {
        return newLoginIntent(context, (new Intent(context, com/groupon/activity/MyCreditCards)).putExtra("dealId", s).putExtra("optionId", s1).putExtra("channel", channel).putExtra("is_gdt", flag).putExtra("is_shopping_cart_flow", flag1).putExtra("is_currency_code_usd", flag2).putExtra("num_items_in_cart", i).putExtra("max_cart_discount", s2).putExtra("cart_deal_image_url", s3).putExtra("cart_uuid", s4).putExtra("available_payment_methods_for_deal", hashmap).putExtra("creditCardConsentRequirements", bundle));
    }

    public Intent newMyCreditCardIntent(boolean flag)
    {
        return newLoginIntent(context, (new Intent(context, com/groupon/activity/MyCreditCards)).putExtra("is_market_rate_deal", flag));
    }

    public Intent newMyGrouponIntent(Channel channel)
    {
        return newLoginIntent(context, (new Intent(context, com/groupon/activity/MyGroupons)).putExtra("channel", channel));
    }

    public Intent newMyGrouponIntentActivityClearTop(boolean flag)
    {
        return newMyGrouponIntentActivityClearTop().putExtra("from_cancel_order", flag);
    }

    public Intent newMyGrouponsIntent()
    {
        return newMyGrouponsIntent(-1);
    }

    public Intent newMyGrouponsIntent(int i)
    {
        Intent intent = new Intent(context, com/groupon/activity/MyGroupons);
        if (i != -1)
        {
            intent.putExtra("my_groupons_tab_position", i);
        }
        return newLoginIntent(context, intent);
    }

    public Intent newNearbyDealsIntent()
    {
        if (isNearbyEnabledDivision())
        {
            return addComeFromSplashFlagIfNecessary((new Intent(context, com/groupon/activity/Carousel)).putExtra("channel", Channel.NEARBY));
        } else
        {
            return newCarouselIntent();
        }
    }

    public Intent newOccasionsChannelIntent()
    {
        return newAnyChannelIntent(Channel.OCCASIONS, null);
    }

    public Intent newPhotoPicker()
    {
        return new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }

    public Intent newPoGSearch(DeepLinkData deeplinkdata)
    {
        Object obj1 = deeplinkdata.getParam("context");
        Object obj = deeplinkdata.getParam("url");
        boolean flag = Boolean.parseBoolean(deeplinkdata.getParam("needsAuth"));
        boolean flag1 = Boolean.parseBoolean(deeplinkdata.getParam("displayCoachMark"));
        Intent intent = new Intent(context, com/groupon/activity/PoGSearch);
        deeplinkdata = ((DeepLinkData) (obj1));
        if (obj1 == null)
        {
            deeplinkdata = "";
        }
        obj1 = intent.putExtra("context", deeplinkdata);
        deeplinkdata = ((DeepLinkData) (obj));
        if (obj == null)
        {
            deeplinkdata = "";
        }
        obj = ((Intent) (obj1)).putExtra("url", deeplinkdata).putExtra("display_coach_mark", flag1);
        deeplinkdata = ((DeepLinkData) (obj));
        if (flag)
        {
            deeplinkdata = ((DeepLinkData) (obj));
            if (!loginService.isLoggedIn())
            {
                deeplinkdata = newLoginIntent(context, ((Intent) (obj)));
            }
        }
        return deeplinkdata;
    }

    public Intent newPoGWebView(String s, DeepLinkData deeplinkdata)
    {
        boolean flag = Boolean.parseBoolean(deeplinkdata.getParam("needsAuth"));
        Object obj = deeplinkdata.getParam("context");
        String s1 = deeplinkdata.getParam("url");
        Intent intent = new Intent(context, com/groupon/activity/PoGWebview);
        deeplinkdata = ((DeepLinkData) (obj));
        if (obj == null)
        {
            deeplinkdata = "";
        }
        obj = intent.putExtra("context", deeplinkdata);
        deeplinkdata = s1;
        if (s1 == null)
        {
            deeplinkdata = "";
        }
        deeplinkdata = ((Intent) (obj)).putExtra("url", deeplinkdata).putExtra("survey_id", s);
        s = deeplinkdata;
        if (flag)
        {
            s = deeplinkdata;
            if (!loginService.isLoggedIn())
            {
                s = newLoginIntent(context, deeplinkdata);
            }
        }
        return s;
    }

    public Intent newPoGWebview(String s, String s1, String s2)
    {
        return (new Intent(context, com/groupon/activity/PoGWebview)).putExtra("placeId", s).putExtra("url", s2).putExtra("context", s1);
    }

    public Intent newPreconfigedABTestsIntent()
    {
        return new Intent(context, com/groupon/activity/PreconfiguredAbTests);
    }

    public Intent newProximityBasedNotificationClearGeofenceOnAbtestChangeIntent()
    {
        return (new Intent(context, com/groupon/service/ProximityNotificationService)).setAction("com.groupon.CLEAR_GEOFENCE_ABTEST_CHANGE");
    }

    public Intent newProximityBasedNotificationServiceDistanceActivityCheckIntent(LocationInfo locationinfo)
    {
        return (new Intent(context, com/groupon/service/ProximityNotificationService)).setAction("com.groupon.DISTANCE_ACTIVITY_CHECK").putExtra("com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo", locationinfo);
    }

    public Intent newProximityBasedNotificationServiceGeofenceTriggered(String s, String s1)
    {
        return (new Intent(context, com/groupon/service/ProximityNotificationService)).setAction("com.groupon.GEOFENCE_TRIGGERED").putExtra("transition_type", s).putExtra("transition_geofence_uuid", s1);
    }

    public Intent newProximityBasedNotificationServiceSetGeofenceIntent(int i, int j)
    {
        return (new Intent(context, com/groupon/service/ProximityNotificationService)).setAction("com.groupon.SET_GEOFENCE").putExtra("activity_name", i).putExtra("activity_confidence", j);
    }

    public Intent newPurchaseIntentWithPredefinedReservation(Deal deal, String s, String s1, Channel channel, boolean flag, boolean flag1, DateTimeFinderReservationDetails datetimefinderreservationdetails)
    {
        s1 = createPurchaseIntent(deal, s, s1, flag, flag1, datetimefinderreservationdetails);
        return newLoginIntent(context, s1, deal.remoteId, s, channel);
    }

    public Intent newPurchaseLoginIntent(Deal deal, String s, Channel channel, boolean flag, boolean flag1)
    {
        Intent intent = createPurchaseIntent(deal, s, null, flag, flag1, null);
        return newLoginIntent(context, intent, deal.remoteId, s, channel);
    }

    public Intent newPurchaseLoginIntent(Deal deal, String s, String s1, Channel channel, boolean flag, boolean flag1)
    {
        s1 = createPurchaseIntent(deal, s, s1, flag, flag1, null);
        return newLoginIntent(context, s1, deal.remoteId, s, channel);
    }

    public Intent newPurchaseLoginIntent(String s, String s1, Channel channel)
    {
        Intent intent = createPurchaseIntent();
        intent.putExtra("dealId", s);
        intent.putExtra("optionId", s1);
        intent.putExtra("channel", channel);
        return newLoginIntent(context, intent, s, s1, channel);
    }

    public Intent newPurchaseLoginIntent(String s, String s1, Channel channel, boolean flag)
    {
        Intent intent = createPurchaseIntent();
        intent.putExtra("dealId", s);
        intent.putExtra("optionId", s1);
        intent.putExtra("channel", channel);
        intent.putExtra("isDeepLinked", flag);
        return newLoginIntent(context, intent, s, s1, channel);
    }

    public Intent newQaDiscussionsIntent(String s)
    {
        return (new Intent(context, com/groupon/activity/QaDiscussionsActivity)).putExtra("dealId", s);
    }

    public Intent newQaDiscussionsNativeIntent(String s)
    {
        return (new Intent(context, com/groupon/activity/QaDiscussionsNativeActivity)).putExtra("dealId", s);
    }

    public Intent newRedeemIntent(boolean flag, String s)
    {
        Context context1 = context;
        Context context2 = context;
        Object obj;
        if (flag)
        {
            obj = com/groupon/activity/RedeemWebview;
        } else
        {
            obj = com/groupon/activity/Redeem;
        }
        return newLoginIntent(context1, (new Intent(context2, ((Class) (obj)))).putExtra("dealId", s));
    }

    public Intent newSecretAdminSettingsIntent()
    {
        return new Intent(context, com/groupon/activity/SecretAdminSettings);
    }

    public Intent newSecretAdminSettingsWithOktaAuthenticationIntent()
    {
        if (Ln.isDebugEnabled())
        {
            return new Intent(context, com/groupon/activity/SecretAdminSettings);
        } else
        {
            return new Intent(context, com/groupon/activity/OktaAuthentication);
        }
    }

    public Intent newSelectRoomIntent(List list, String s, String s1, String s2, String s3, Channel channel, String s4, 
            BookingMetaData bookingmetadata, String s5)
    {
        return (new Intent(context, com/groupon/activity/SelectRoom)).putExtra("hotel_inventory", (ArrayList)list).putExtra("hotel_name", s).putExtra("hotel_location", s1).putExtra("hotel_image_url", s2).putExtra("g_bucks_disclaimer", s3).putExtra("channel", channel).putExtra("id", s4).putExtra("getaways_booking", bookingmetadata).putExtra("productType", s5);
    }

    public Intent newSettingsIntent()
    {
        return new Intent(context, com/groupon/activity/Settings);
    }

    public Intent newSettingsLoginIntent()
    {
        return newLoginIntent(context, newSettingsIntent());
    }

    public Intent newShippingAddressIntent(DealBreakdownAddress dealbreakdownaddress)
    {
        Context context1 = context;
        Object obj;
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            obj = com/groupon/activity/ShippingAddress;
        } else
        if (currentCountryManager.getCurrentCountry().isLATAMCompatible())
        {
            obj = com/groupon/activity/ShippingAddressLATAM;
        } else
        {
            obj = com/groupon/activity/ShippingAddressEu;
        }
        return (new Intent(context1, ((Class) (obj)))).putExtra("shippingAddress", dealbreakdownaddress).putExtra("firstShippingAddress", dealbreakdownaddress);
    }

    public Intent newShippingAddressIntent(DealBreakdownAddress dealbreakdownaddress, DealBreakdownAddress dealbreakdownaddress1, boolean flag)
    {
        return newShippingAddressIntent(dealbreakdownaddress, dealbreakdownaddress1, flag, null, null, null, 0, null, null, null);
    }

    public Intent newShippingAddressIntent(DealBreakdownAddress dealbreakdownaddress, DealBreakdownAddress dealbreakdownaddress1, boolean flag, String s, String s1, Channel channel, int i, 
            String s2, String s3, String s4)
    {
        Context context1 = context;
        Object obj;
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            obj = com/groupon/activity/ShippingAddress;
        } else
        if (currentCountryManager.getCurrentCountry().isLATAMCompatible())
        {
            obj = com/groupon/activity/ShippingAddressLATAM;
        } else
        {
            obj = com/groupon/activity/ShippingAddressEu;
        }
        obj = new Intent(context1, ((Class) (obj)));
        if (dealbreakdownaddress != null)
        {
            ((Intent) (obj)).putExtra("firstShippingAddress", dealbreakdownaddress);
        }
        if (dealbreakdownaddress1 != null)
        {
            ((Intent) (obj)).putExtra("secondShippingAddress", dealbreakdownaddress1);
        }
        ((Intent) (obj)).putExtra("is_master_address", flag);
        ((Intent) (obj)).putExtra("dealId", s);
        ((Intent) (obj)).putExtra("optionId", s1);
        ((Intent) (obj)).putExtra("channel", channel);
        ((Intent) (obj)).putExtra("num_items_in_cart", i);
        ((Intent) (obj)).putExtra("cart_uuid", s4);
        ((Intent) (obj)).putExtra("max_cart_discount", s2);
        ((Intent) (obj)).putExtra("cart_deal_image_url", s3);
        return newLoginIntent(context, ((Intent) (obj)));
    }

    public Intent newShippingAddressIntent(DealBreakdownAddress dealbreakdownaddress, boolean flag, String s, String s1, Channel channel)
    {
        return newShippingAddressIntent(dealbreakdownaddress, flag, s, s1, channel, 0, null, null);
    }

    public Intent newShippingAddressIntent(DealBreakdownAddress dealbreakdownaddress, boolean flag, String s, String s1, Channel channel, int i, String s2, 
            String s3)
    {
        Context context1 = context;
        Object obj;
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            obj = com/groupon/activity/ShippingAddress;
        } else
        if (currentCountryManager.getCurrentCountry().isLATAMCompatible())
        {
            obj = com/groupon/activity/ShippingAddressLATAM;
        } else
        {
            obj = com/groupon/activity/ShippingAddressEu;
        }
        return (new Intent(context1, ((Class) (obj)))).putExtra("dealId", s).putExtra("optionId", s1).putExtra("channel", channel).putExtra("num_items_in_cart", i).putExtra("max_cart_discount", s2).putExtra("cart_deal_image_url", s3).putExtra("shippingAddress", dealbreakdownaddress).putExtra("firstShippingAddress", dealbreakdownaddress).putExtra("isShippingAddress", flag);
    }

    public Intent newShoppingIntent()
    {
        if (currentCountryManager.getCurrentCountry().isShoppingChannelEnabled())
        {
            return addExtrasToNewAnyChannelIntent(Channel.SHOPPING, Channel.SHOPPING.toString(), null);
        } else
        {
            return newCarouselIntent();
        }
    }

    public Intent newShowOnMapIntent(Location location, String s, int i)
    {
        return (new Intent(context, com/groupon/activity/ShowOnMap)).putExtra("lat", location.lat).putExtra("lng", location.lng).putExtra("locationIndex", i).putExtra("vendorName", s);
    }

    public Intent newShowOnMapIntent(Collection collection, String s, int i)
    {
        long al[] = new long[collection.size()];
        int j = 0;
        for (collection = collection.iterator(); collection.hasNext();)
        {
            al[j] = ((Location)collection.next()).primaryKey.longValue();
            j++;
        }

        return (new Intent(context, com/groupon/activity/ShowOnMap)).putExtra("locationIds", al).putExtra("locationIndex", i).putExtra("vendorName", s);
    }

    public Intent newSignUpDivisionSelector()
    {
        return newCountryOrDivisionSelector().putExtra("return_selected_division", true);
    }

    public Intent newSignUpIntent()
    {
        if (((LoginService)RoboGuice.getInjector(context).getInstance(com/groupon/service/LoginService)).isLoggedIn())
        {
            return newSettingsLoginIntent();
        } else
        {
            return newRegisterIntent(newCarouselIntent());
        }
    }

    public Intent newSimpleMarkUpActivity(String s)
    {
        return (new Intent(context, com/groupon/activity/SimpleMarkUpActivity)).setData(Uri.parse(s));
    }

    public Intent newSnapOfferGridIntent(String s, Channel channel)
    {
        return (new Intent(context, com/groupon/activity/SnapOfferGridActivity)).putExtra("channel", channel).putExtra("db_channel", s);
    }

    public Intent newSpecialIntent(String s, String s1, boolean flag)
    {
        return newLoginIntent(context, (new Intent(context, com/groupon/activity/BusinessSpecialPage)).putExtra("special_id", s).putExtra("business_id", s1).putExtra("isDeepLinked", false).putExtra("is_claim_special_clicked", flag));
    }

    public Intent newSplashIntent()
    {
        return newSplashIntent(null);
    }

    public Intent newSplashIntent(Intent intent)
    {
        Intent intent1 = new Intent(context, com/groupon/activity/Splash);
        if (intent != null && (intent.getComponent() == null || !Strings.equals(com/groupon/activity/Splash.getName(), intent.getComponent().getClassName())))
        {
            intent.putExtra("COMING_FROM_SPLASH", true);
            intent1.putExtra("next", intent);
        }
        return intent1;
    }

    public Intent newStockCategoriesIntent(String s, String s1)
    {
        return (new Intent(context, com/groupon/activity/StockCategories)).putExtra("dealId", s).putExtra("optionId", s1);
    }

    public Intent newThanksIntent()
    {
        return newLoginIntent(context, new Intent(context, com/groupon/activity/Thanks));
    }

    public Intent newThanksIntent(String s, String s1, Channel channel)
    {
        return newLoginIntent(context, (new Intent(context, com/groupon/activity/Thanks)).putExtra("dealId", s).putExtra("optionId", s1).putExtra("channel", channel));
    }

    public Intent newThanksIntentWithNoMyGrouponsLink(String s)
    {
        return newLoginIntent(context, new Intent(context, com/groupon/activity/Thanks)).putExtra("thanks_hide_my_groupons", true).putExtra("dealId", s);
    }

    public Intent newTravelerNameIntent(String s, ImageUrl imageurl, BookingMetaData bookingmetadata)
    {
        return TravelerNameActivity.instantiate(context, s, imageurl, bookingmetadata);
    }

    public Intent nextActivityFromWidgetDealClick(DealSummary dealsummary, Channel channel)
    {
        return nextActivityFromWidgetDealClick(dealsummary, channel, 0);
    }

    public Intent nextActivityFromWidgetDealClick(DealSummary dealsummary, Channel channel, int i)
    {
        return nextActivityFromWidgetDealClick(dealsummary, channel, i, null);
    }

    public Intent nextActivityFromWidgetDealClick(DealSummary dealsummary, Channel channel, int i, com.groupon.util.ViewUtils.Size size)
    {
        if (((BuyUtils)RoboGuice.getInjector(context).getInstance(com/groupon/util/BuyUtils)).showOptionsWithImages(dealsummary, abTestService, currentCountryManager))
        {
            int j;
            boolean flag;
            if (!currentCountryManager.getCurrentCountry().isJapan())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            j = dealsummary.optionDimensionsCount(flag, currentCountryManager.getCurrentCountry().isUSACompatible());
            return newGoodsMultiOptionIntent(dealsummary.remoteId, channel, j, i);
        } else
        {
            return newDealIntentFromWidget(dealsummary, channel, i, size);
        }
    }

    public Intent redirectToCountries()
    {
        return asRedirect(newCountrySelector());
    }

    public Intent redirectToSplash(Intent intent)
    {
        return intent.setClass(context, com/groupon/activity/Splash);
    }
}
