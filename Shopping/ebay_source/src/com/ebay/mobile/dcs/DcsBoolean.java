// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import com.ebay.nautilus.domain.dcs.DcsPropBoolean;
import com.ebay.nautilus.domain.dcs.DcsState;

public final class DcsBoolean extends Enum
    implements DcsPropBoolean
{

    private static final DcsBoolean $VALUES[];
    public static final DcsBoolean AplsLogErrorMessages;
    public static final DcsBoolean AplsLogErrorMessagesWithV2;
    public static final DcsBoolean AutoSearches;
    public static final DcsBoolean BOPIS;
    public static final DcsBoolean BuyerGuarantee;
    public static final DcsBoolean C2DM;
    public static final DcsBoolean CONDITION_DESCRIPTION;
    public static final DcsBoolean ContactSeller;
    public static final DcsBoolean Coupons;
    public static final DcsBoolean CurrencyConversion;
    public static final DcsBoolean Deals;
    public static final DcsBoolean DraftsInMyEbay;
    public static final DcsBoolean EU_BASE_UNIT_PRICE;
    public static final DcsBoolean FastAndFree;
    public static final DcsBoolean Feed;
    public static final DcsBoolean ForgotPasswordInWebView;
    public static final DcsBoolean GCM;
    public static final DcsBoolean GSP;
    public static final DcsBoolean GoogleNowCards;
    public static final DcsBoolean IncentiveServiceV1;
    public static final DcsBoolean IncentivesRewards;
    public static final DcsBoolean IncentivesVouchers;
    public static final DcsBoolean IncentivesVouchersErrorSuppression;
    public static final DcsBoolean JellyBeanNotifications;
    public static final DcsBoolean KillSwitch;
    public static final DcsBoolean LOG_REQUEST_ERRORS;
    public static final DcsBoolean LargeSearchImages;
    public static final DcsBoolean LocalNotifications;
    public static final DcsBoolean MEC;
    public static final DcsBoolean MEC2;
    public static final DcsBoolean MecAddressValidation;
    public static final DcsBoolean MecAlternativePaymentMethods;
    public static final DcsBoolean MecAlwaysOfferGuestXo;
    public static final DcsBoolean MecBankTransfer;
    public static final DcsBoolean MecDisableMessageToSellerForBopis;
    public static final DcsBoolean MecDisplayTreatmentForBopis;
    public static final DcsBoolean MecGuestXo;
    public static final DcsBoolean MecRememberMeCheckboxSetting;
    public static final DcsBoolean MepClientDisable;
    public static final DcsBoolean Motors;
    public static final DcsBoolean MotorsCommunity;
    public static final DcsBoolean MotorsEvents;
    public static final DcsBoolean MotorsSell;
    public static final DcsBoolean MotorsVideos;
    public static final DcsBoolean MyEbaySellerTotals;
    public static final DcsBoolean NotificationQuietTimes;
    public static final DcsBoolean NotificationTracking;
    public static final DcsBoolean NotificationsToneMutable;
    public static final DcsBoolean OCS;
    public static final DcsBoolean PUDOImmediatePayHack;
    public static final DcsBoolean PaisaPay;
    public static final DcsBoolean PlaceOfferRoi;
    public static final DcsBoolean Polling;
    public static final DcsBoolean PostTransactionWebFlow;
    public static final DcsBoolean PrintShippingLabel;
    public static final DcsBoolean PslPrinting;
    public static final DcsBoolean RLKeywordFallback;
    public static final DcsBoolean RTB;
    public static final DcsBoolean RTC;
    public static final DcsBoolean RTM;
    public static final DcsBoolean RecentlyViewed;
    public static final DcsBoolean RefineDisplayCatHisto;
    public static final DcsBoolean RelatedSearches;
    public static final DcsBoolean SSO;
    public static final DcsBoolean SearchAdsShowWebView;
    public static final DcsBoolean SearchEEKEnabled;
    public static final DcsBoolean SearchEnableFollowBar;
    public static final DcsBoolean SearchExpansionEnabled;
    public static final DcsBoolean SearchLocalOnlyConstraint;
    public static final DcsBoolean SearchRefineLocking;
    public static final DcsBoolean SearchRefinementInStorePickup;
    public static final DcsBoolean SearchServiceUvcc;
    public static final DcsBoolean SearchSmartDisplay;
    public static final DcsBoolean SearchUseOAuthEndpoint;
    public static final DcsBoolean SearchUsePickupDropOffHack;
    public static final DcsBoolean SearchUseSearchService;
    public static final DcsBoolean SearchUseSearchServiceV2;
    public static final DcsBoolean Sell;
    public static final DcsBoolean SellAutoRelist;
    public static final DcsBoolean SellAutoRelistGuidance;
    public static final DcsBoolean SellConditionDescEnabled;
    public static final DcsBoolean SellEftWebview;
    public static final DcsBoolean SellHardGoodsPriceGuidance;
    public static final DcsBoolean SellSoftGoodsPriceGuidance;
    public static final DcsBoolean ShipToFund;
    public static final DcsBoolean ShoppingCart;
    public static final DcsBoolean ShoppingCartInvertCurrencyConversionDisplay;
    public static final DcsBoolean SignInWithEmailOrUsername;
    public static final DcsBoolean StorePickerAutocomplete;
    public static final DcsBoolean Symban;
    public static final DcsBoolean TopRatedListing;
    public static final DcsBoolean TopRatedSeller1;
    public static final DcsBoolean TopRatedSeller3;
    public static final DcsBoolean TrafficMonitorRecordImageLoads;
    public static final DcsBoolean TrafficMonitorSendData;
    public static final DcsBoolean UseMyCurrentLocation;
    public static final DcsBoolean UseShoppingCartMultipleCurrency;
    public static final DcsBoolean UseViewListingServiceCartableFlag;
    public static final DcsBoolean VI_auctionEndEarlyWarning;
    public static final DcsBoolean VI_featureNewBidAnimations;
    public static final DcsBoolean VI_featureNewBidFlow;
    public static final DcsBoolean VI_featureNewBidFlowReviewRequired;
    public static final DcsBoolean VI_featureNewBidFlowShowTitle;
    public static final DcsBoolean VI_feature_EEK;
    public static final DcsBoolean VI_feature_QuantitySold;
    public static final DcsBoolean VI_feature_hotnessCharitySignal;
    public static final DcsBoolean VI_feature_liveAuctionsShipping;
    public static final DcsBoolean VI_feature_merchOnScroll;
    public static final DcsBoolean Verticals_dealsNotifications;
    public static final DcsBoolean advertisingId;
    public static final DcsBoolean appIndexingReferrerTracking;
    public static final DcsBoolean checkoutConvertCartToSiteCurrency;
    public static final DcsBoolean checkoutMerchandiseItems;
    public static final DcsBoolean connectSignInModalDialog;
    public static final DcsBoolean connection_SiteSpecificSso;
    public static final DcsBoolean connection_eulaBanner;
    public static final DcsBoolean connection_eulaSeparationHasOccurred;
    public static final DcsBoolean crashlytics;
    public static final DcsBoolean eBayNow;
    public static final DcsBoolean eBayViewItemProductReviews;
    public static final DcsBoolean ebayGiving;
    public static final DcsBoolean ebayGivingCheckout;
    public static final DcsBoolean ebayGivingProfile;
    public static final DcsBoolean ebayGivingSelling;
    public static final DcsBoolean ebayGivingShop;
    public static final DcsBoolean featureViewItemPaymentLogos;
    public static final DcsBoolean geoTracking;
    public static final DcsBoolean iApps;
    public static final DcsBoolean itemTitleTranslationEnabled;
    public static final DcsBoolean messagesUseImageCache;
    public static final DcsBoolean payments_hideRememberMeControls;
    public static final DcsBoolean payments_payUponInvoiceEnabled;
    public static final DcsBoolean providerMts;
    public static final DcsBoolean savedSearchNotificationDefault;
    public static final DcsBoolean savedSearchPolling;
    public static final DcsBoolean searchSavedSearchUseFollowInterest;
    public static final DcsBoolean sellerPaymentReminder;
    public static final DcsBoolean showEEKRatings;
    public static final DcsBoolean showLauncherAppBadge;
    public static final DcsBoolean smeSupport;
    public static final DcsBoolean soaSendRlogId;
    public static final DcsBoolean useRealtimeShipTracking;
    public static final DcsBoolean viewItemEventTimeHack;
    public static final DcsBoolean viewItemLargerImages;
    public static final DcsBoolean viewItemUseMerchV2;
    private final Object defaultValue;

    private DcsBoolean(String s, int i)
    {
        super(s, i);
        defaultValue = Boolean.FALSE;
    }

    private DcsBoolean(String s, int i, String s1)
    {
        super(s, i);
        defaultValue = s1;
    }

    private DcsBoolean(String s, int i, boolean flag)
    {
        super(s, i);
        defaultValue = Boolean.valueOf(flag);
    }

    public static DcsBoolean valueOf(String s)
    {
        return (DcsBoolean)Enum.valueOf(com/ebay/mobile/dcs/DcsBoolean, s);
    }

    public static DcsBoolean[] values()
    {
        return (DcsBoolean[])$VALUES.clone();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[];

            static 
            {
                $SwitchMap$com$ebay$mobile$dcs$DcsBoolean = new int[DcsBoolean.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.SearchSmartDisplay.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.SearchLocalOnlyConstraint.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.SearchExpansionEnabled.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.SellConditionDescEnabled.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.ebayGivingSelling.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.ebayGivingProfile.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.ebayGivingShop.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.ebayGivingCheckout.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.MecAlwaysOfferGuestXo.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.MecAlternativePaymentMethods.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.MecRememberMeCheckboxSetting.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.MecDisableMessageToSellerForBopis.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.MecDisplayTreatmentForBopis.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.MecGuestXo.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.MecBankTransfer.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.MecAddressValidation.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.MepClientDisable.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.TrafficMonitorRecordImageLoads.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.TrafficMonitorSendData.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.soaSendRlogId.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.AplsLogErrorMessagesWithV2.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.AplsLogErrorMessages.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.UseShoppingCartMultipleCurrency.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsBoolean[DcsBoolean.Feed.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.mobile.dcs.DcsBoolean[ordinal()])
        {
        default:
            return defaultValue;

        case 24: // '\030'
            return Boolean.valueOf(com.ebay.common.view.util.EbayCountryManager.Default.isFeedEnabled(dcsstate.ebayCountry));
        }
    }

    public String key()
    {
        switch (_cls1..SwitchMap.com.ebay.mobile.dcs.DcsBoolean[ordinal()])
        {
        default:
            return name();

        case 1: // '\001'
            return "Search.Smart.Display";

        case 2: // '\002'
            return "Search.Local.Only.Constraint";

        case 3: // '\003'
            return "Search.Expansion.Enabled";

        case 4: // '\004'
            return "Sell.ConditionDescEnabled";

        case 5: // '\005'
            return "ebayGiving.Selling";

        case 6: // '\006'
            return "ebayGiving.Profile";

        case 7: // '\007'
            return "ebayGiving.Shop";

        case 8: // '\b'
            return "ebayGiving.Checkout";

        case 9: // '\t'
            return "MEC.alwaysOfferGuestXO";

        case 10: // '\n'
            return "MEC.alternativePaymentMethods";

        case 11: // '\013'
            return "MEC.rememberMeCheckboxSetting";

        case 12: // '\f'
            return "MEC.disableMessageToSellerForBOPIS";

        case 13: // '\r'
            return "MEC.displayTreatmentForBOPIS";

        case 14: // '\016'
            return "MEC.guestXO";

        case 15: // '\017'
            return "MEC.bankTransfer";

        case 16: // '\020'
            return "MEC.addressValidation";

        case 17: // '\021'
            return "mep.client.disable";

        case 18: // '\022'
            return "TrafficMonitor.recordImageLoads";

        case 19: // '\023'
            return "TrafficMonitor.sendData";

        case 20: // '\024'
            return "soa.sendRlogID";

        case 21: // '\025'
            return "APLS.logErrorMessagesWithV2";

        case 22: // '\026'
            return "APLS.logErrorMessages";

        case 23: // '\027'
            return "shoppingCart.multiple.currency";
        }
    }

    static 
    {
        RTB = new DcsBoolean("RTB", 0, true);
        RLKeywordFallback = new DcsBoolean("RLKeywordFallback", 1, true);
        KillSwitch = new DcsBoolean("KillSwitch", 2);
        Sell = new DcsBoolean("Sell", 3, "${prefCountry} in 'AU,AT,CA,FR,DE,IN,IE,IT,MY,PH,SG,ES,GB,US'");
        SearchUseSearchService = new DcsBoolean("SearchUseSearchService", 4, true);
        SearchUseSearchServiceV2 = new DcsBoolean("SearchUseSearchServiceV2", 5, true);
        SearchRefineLocking = new DcsBoolean("SearchRefineLocking", 6);
        SearchEEKEnabled = new DcsBoolean("SearchEEKEnabled", 7);
        SearchAdsShowWebView = new DcsBoolean("SearchAdsShowWebView", 8);
        SearchSmartDisplay = new DcsBoolean("SearchSmartDisplay", 9, true);
        SearchLocalOnlyConstraint = new DcsBoolean("SearchLocalOnlyConstraint", 10);
        SearchUsePickupDropOffHack = new DcsBoolean("SearchUsePickupDropOffHack", 11);
        SearchExpansionEnabled = new DcsBoolean("SearchExpansionEnabled", 12, true);
        SearchRefinementInStorePickup = new DcsBoolean("SearchRefinementInStorePickup", 13, true);
        SearchServiceUvcc = new DcsBoolean("SearchServiceUvcc", 14, false);
        SearchEnableFollowBar = new DcsBoolean("SearchEnableFollowBar", 15, true);
        SearchUseOAuthEndpoint = new DcsBoolean("SearchUseOAuthEndpoint", 16, false);
        LargeSearchImages = new DcsBoolean("LargeSearchImages", 17);
        UseMyCurrentLocation = new DcsBoolean("UseMyCurrentLocation", 18);
        SellEftWebview = new DcsBoolean("SellEftWebview", 19, true);
        RelatedSearches = new DcsBoolean("RelatedSearches", 20);
        RefineDisplayCatHisto = new DcsBoolean("RefineDisplayCatHisto", 21);
        AutoSearches = new DcsBoolean("AutoSearches", 22);
        OCS = new DcsBoolean("OCS", 23, "${prefCountry} in 'AT,AU,CA,DE,ES,FR,IT,GB,US'");
        SellHardGoodsPriceGuidance = new DcsBoolean("SellHardGoodsPriceGuidance", 24);
        SellSoftGoodsPriceGuidance = new DcsBoolean("SellSoftGoodsPriceGuidance", 25);
        SellConditionDescEnabled = new DcsBoolean("SellConditionDescEnabled", 26, true);
        ebayGivingSelling = new DcsBoolean("ebayGivingSelling", 27);
        Motors = new DcsBoolean("Motors", 28);
        MotorsSell = new DcsBoolean("MotorsSell", 29, "${prefCountry} = 'US'");
        MotorsCommunity = new DcsBoolean("MotorsCommunity", 30);
        MotorsEvents = new DcsBoolean("MotorsEvents", 31);
        MotorsVideos = new DcsBoolean("MotorsVideos", 32);
        GSP = new DcsBoolean("GSP", 33);
        TopRatedListing = new DcsBoolean("TopRatedListing", 34);
        TopRatedSeller1 = new DcsBoolean("TopRatedSeller1", 35);
        TopRatedSeller3 = new DcsBoolean("TopRatedSeller3", 36);
        MEC2 = new DcsBoolean("MEC2", 37, true);
        MEC = new DcsBoolean("MEC", 38, true);
        PaisaPay = new DcsBoolean("PaisaPay", 39);
        CONDITION_DESCRIPTION = new DcsBoolean("CONDITION_DESCRIPTION", 40);
        ebayGiving = new DcsBoolean("ebayGiving", 41);
        ebayGivingProfile = new DcsBoolean("ebayGivingProfile", 42);
        ebayGivingShop = new DcsBoolean("ebayGivingShop", 43);
        ebayGivingCheckout = new DcsBoolean("ebayGivingCheckout", 44);
        MecAlwaysOfferGuestXo = new DcsBoolean("MecAlwaysOfferGuestXo", 45);
        MecAlternativePaymentMethods = new DcsBoolean("MecAlternativePaymentMethods", 46);
        MecRememberMeCheckboxSetting = new DcsBoolean("MecRememberMeCheckboxSetting", 47, true);
        ShoppingCart = new DcsBoolean("ShoppingCart", 48);
        FastAndFree = new DcsBoolean("FastAndFree", 49);
        MecDisableMessageToSellerForBopis = new DcsBoolean("MecDisableMessageToSellerForBopis", 50, true);
        MecDisplayTreatmentForBopis = new DcsBoolean("MecDisplayTreatmentForBopis", 51, true);
        Verticals_dealsNotifications = new DcsBoolean("Verticals_dealsNotifications", 52, false);
        ShipToFund = new DcsBoolean("ShipToFund", 53);
        MecGuestXo = new DcsBoolean("MecGuestXo", 54);
        IncentiveServiceV1 = new DcsBoolean("IncentiveServiceV1", 55);
        MecBankTransfer = new DcsBoolean("MecBankTransfer", 56);
        MecAddressValidation = new DcsBoolean("MecAddressValidation", 57);
        RTM = new DcsBoolean("RTM", 58);
        MepClientDisable = new DcsBoolean("MepClientDisable", 59);
        providerMts = new DcsBoolean("providerMts", 60, true);
        geoTracking = new DcsBoolean("geoTracking", 61);
        advertisingId = new DcsBoolean("advertisingId", 62);
        showLauncherAppBadge = new DcsBoolean("showLauncherAppBadge", 63);
        Symban = new DcsBoolean("Symban", 64, true);
        iApps = new DcsBoolean("iApps", 65);
        EU_BASE_UNIT_PRICE = new DcsBoolean("EU_BASE_UNIT_PRICE", 66, true);
        GCM = new DcsBoolean("GCM", 67, true);
        Polling = new DcsBoolean("Polling", 68, true);
        LOG_REQUEST_ERRORS = new DcsBoolean("LOG_REQUEST_ERRORS", 69);
        TrafficMonitorRecordImageLoads = new DcsBoolean("TrafficMonitorRecordImageLoads", 70, true);
        TrafficMonitorSendData = new DcsBoolean("TrafficMonitorSendData", 71, true);
        soaSendRlogId = new DcsBoolean("soaSendRlogId", 72, true);
        AplsLogErrorMessagesWithV2 = new DcsBoolean("AplsLogErrorMessagesWithV2", 73, true);
        AplsLogErrorMessages = new DcsBoolean("AplsLogErrorMessages", 74);
        C2DM = new DcsBoolean("C2DM", 75);
        SSO = new DcsBoolean("SSO", 76, true);
        connection_SiteSpecificSso = new DcsBoolean("connection_SiteSpecificSso", 77, false);
        BuyerGuarantee = new DcsBoolean("BuyerGuarantee", 78, "${prefCountry} in 'GB,US,DE' | ${isGbh}");
        Coupons = new DcsBoolean("Coupons", 79, true);
        RTC = new DcsBoolean("RTC", 80, true);
        NotificationQuietTimes = new DcsBoolean("NotificationQuietTimes", 81, true);
        LocalNotifications = new DcsBoolean("LocalNotifications", 82, true);
        NotificationsToneMutable = new DcsBoolean("NotificationsToneMutable", 83, true);
        JellyBeanNotifications = new DcsBoolean("JellyBeanNotifications", 84, true);
        NotificationTracking = new DcsBoolean("NotificationTracking", 85, true);
        PlaceOfferRoi = new DcsBoolean("PlaceOfferRoi", 86);
        RecentlyViewed = new DcsBoolean("RecentlyViewed", 87, true);
        IncentivesVouchers = new DcsBoolean("IncentivesVouchers", 88, true);
        IncentivesRewards = new DcsBoolean("IncentivesRewards", 89, true);
        DraftsInMyEbay = new DcsBoolean("DraftsInMyEbay", 90, true);
        IncentivesVouchersErrorSuppression = new DcsBoolean("IncentivesVouchersErrorSuppression", 91);
        SignInWithEmailOrUsername = new DcsBoolean("SignInWithEmailOrUsername", 92, true);
        connectSignInModalDialog = new DcsBoolean("connectSignInModalDialog", 93);
        Deals = new DcsBoolean("Deals", 94, "${prefCountry} in 'AU,CA,IT,DE,MY,PH,SG,GB,US'");
        MyEbaySellerTotals = new DcsBoolean("MyEbaySellerTotals", 95);
        CurrencyConversion = new DcsBoolean("CurrencyConversion", 96, true);
        Feed = new DcsBoolean("Feed", 97);
        BOPIS = new DcsBoolean("BOPIS", 98);
        StorePickerAutocomplete = new DcsBoolean("StorePickerAutocomplete", 99, true);
        SellAutoRelistGuidance = new DcsBoolean("SellAutoRelistGuidance", 100);
        SellAutoRelist = new DcsBoolean("SellAutoRelist", 101);
        PrintShippingLabel = new DcsBoolean("PrintShippingLabel", 102, false);
        PslPrinting = new DcsBoolean("PslPrinting", 103, true);
        eBayNow = new DcsBoolean("eBayNow", 104);
        useRealtimeShipTracking = new DcsBoolean("useRealtimeShipTracking", 105, true);
        savedSearchPolling = new DcsBoolean("savedSearchPolling", 106, true);
        savedSearchNotificationDefault = new DcsBoolean("savedSearchNotificationDefault", 107);
        searchSavedSearchUseFollowInterest = new DcsBoolean("searchSavedSearchUseFollowInterest", 108, true);
        messagesUseImageCache = new DcsBoolean("messagesUseImageCache", 109, true);
        sellerPaymentReminder = new DcsBoolean("sellerPaymentReminder", 110, true);
        smeSupport = new DcsBoolean("smeSupport", 111, true);
        viewItemUseMerchV2 = new DcsBoolean("viewItemUseMerchV2", 112);
        checkoutMerchandiseItems = new DcsBoolean("checkoutMerchandiseItems", 113);
        payments_payUponInvoiceEnabled = new DcsBoolean("payments_payUponInvoiceEnabled", 114);
        payments_hideRememberMeControls = new DcsBoolean("payments_hideRememberMeControls", 115);
        eBayViewItemProductReviews = new DcsBoolean("eBayViewItemProductReviews", 116);
        ForgotPasswordInWebView = new DcsBoolean("ForgotPasswordInWebView", 117);
        PostTransactionWebFlow = new DcsBoolean("PostTransactionWebFlow", 118);
        ContactSeller = new DcsBoolean("ContactSeller", 119);
        UseViewListingServiceCartableFlag = new DcsBoolean("UseViewListingServiceCartableFlag", 120);
        UseShoppingCartMultipleCurrency = new DcsBoolean("UseShoppingCartMultipleCurrency", 121);
        ShoppingCartInvertCurrencyConversionDisplay = new DcsBoolean("ShoppingCartInvertCurrencyConversionDisplay", 122);
        checkoutConvertCartToSiteCurrency = new DcsBoolean("checkoutConvertCartToSiteCurrency", 123);
        PUDOImmediatePayHack = new DcsBoolean("PUDOImmediatePayHack", 124, true);
        GoogleNowCards = new DcsBoolean("GoogleNowCards", 125);
        showEEKRatings = new DcsBoolean("showEEKRatings", 126, true);
        appIndexingReferrerTracking = new DcsBoolean("appIndexingReferrerTracking", 127, true);
        connection_eulaBanner = new DcsBoolean("connection_eulaBanner", 128);
        connection_eulaSeparationHasOccurred = new DcsBoolean("connection_eulaSeparationHasOccurred", 129, true);
        crashlytics = new DcsBoolean("crashlytics", 130, true);
        VI_feature_QuantitySold = new DcsBoolean("VI_feature_QuantitySold", 131);
        viewItemLargerImages = new DcsBoolean("viewItemLargerImages", 132);
        viewItemEventTimeHack = new DcsBoolean("viewItemEventTimeHack", 133);
        featureViewItemPaymentLogos = new DcsBoolean("featureViewItemPaymentLogos", 134);
        VI_feature_EEK = new DcsBoolean("VI_feature_EEK", 135);
        VI_feature_hotnessCharitySignal = new DcsBoolean("VI_feature_hotnessCharitySignal", 136);
        VI_feature_liveAuctionsShipping = new DcsBoolean("VI_feature_liveAuctionsShipping", 137);
        VI_auctionEndEarlyWarning = new DcsBoolean("VI_auctionEndEarlyWarning", 138);
        VI_featureNewBidFlow = new DcsBoolean("VI_featureNewBidFlow", 139);
        VI_featureNewBidFlowReviewRequired = new DcsBoolean("VI_featureNewBidFlowReviewRequired", 140);
        VI_featureNewBidFlowShowTitle = new DcsBoolean("VI_featureNewBidFlowShowTitle", 141);
        VI_featureNewBidAnimations = new DcsBoolean("VI_featureNewBidAnimations", 142);
        VI_feature_merchOnScroll = new DcsBoolean("VI_feature_merchOnScroll", 143);
        itemTitleTranslationEnabled = new DcsBoolean("itemTitleTranslationEnabled", 144, false);
        $VALUES = (new DcsBoolean[] {
            RTB, RLKeywordFallback, KillSwitch, Sell, SearchUseSearchService, SearchUseSearchServiceV2, SearchRefineLocking, SearchEEKEnabled, SearchAdsShowWebView, SearchSmartDisplay, 
            SearchLocalOnlyConstraint, SearchUsePickupDropOffHack, SearchExpansionEnabled, SearchRefinementInStorePickup, SearchServiceUvcc, SearchEnableFollowBar, SearchUseOAuthEndpoint, LargeSearchImages, UseMyCurrentLocation, SellEftWebview, 
            RelatedSearches, RefineDisplayCatHisto, AutoSearches, OCS, SellHardGoodsPriceGuidance, SellSoftGoodsPriceGuidance, SellConditionDescEnabled, ebayGivingSelling, Motors, MotorsSell, 
            MotorsCommunity, MotorsEvents, MotorsVideos, GSP, TopRatedListing, TopRatedSeller1, TopRatedSeller3, MEC2, MEC, PaisaPay, 
            CONDITION_DESCRIPTION, ebayGiving, ebayGivingProfile, ebayGivingShop, ebayGivingCheckout, MecAlwaysOfferGuestXo, MecAlternativePaymentMethods, MecRememberMeCheckboxSetting, ShoppingCart, FastAndFree, 
            MecDisableMessageToSellerForBopis, MecDisplayTreatmentForBopis, Verticals_dealsNotifications, ShipToFund, MecGuestXo, IncentiveServiceV1, MecBankTransfer, MecAddressValidation, RTM, MepClientDisable, 
            providerMts, geoTracking, advertisingId, showLauncherAppBadge, Symban, iApps, EU_BASE_UNIT_PRICE, GCM, Polling, LOG_REQUEST_ERRORS, 
            TrafficMonitorRecordImageLoads, TrafficMonitorSendData, soaSendRlogId, AplsLogErrorMessagesWithV2, AplsLogErrorMessages, C2DM, SSO, connection_SiteSpecificSso, BuyerGuarantee, Coupons, 
            RTC, NotificationQuietTimes, LocalNotifications, NotificationsToneMutable, JellyBeanNotifications, NotificationTracking, PlaceOfferRoi, RecentlyViewed, IncentivesVouchers, IncentivesRewards, 
            DraftsInMyEbay, IncentivesVouchersErrorSuppression, SignInWithEmailOrUsername, connectSignInModalDialog, Deals, MyEbaySellerTotals, CurrencyConversion, Feed, BOPIS, StorePickerAutocomplete, 
            SellAutoRelistGuidance, SellAutoRelist, PrintShippingLabel, PslPrinting, eBayNow, useRealtimeShipTracking, savedSearchPolling, savedSearchNotificationDefault, searchSavedSearchUseFollowInterest, messagesUseImageCache, 
            sellerPaymentReminder, smeSupport, viewItemUseMerchV2, checkoutMerchandiseItems, payments_payUponInvoiceEnabled, payments_hideRememberMeControls, eBayViewItemProductReviews, ForgotPasswordInWebView, PostTransactionWebFlow, ContactSeller, 
            UseViewListingServiceCartableFlag, UseShoppingCartMultipleCurrency, ShoppingCartInvertCurrencyConversionDisplay, checkoutConvertCartToSiteCurrency, PUDOImmediatePayHack, GoogleNowCards, showEEKRatings, appIndexingReferrerTracking, connection_eulaBanner, connection_eulaSeparationHasOccurred, 
            crashlytics, VI_feature_QuantitySold, viewItemLargerImages, viewItemEventTimeHack, featureViewItemPaymentLogos, VI_feature_EEK, VI_feature_hotnessCharitySignal, VI_feature_liveAuctionsShipping, VI_auctionEndEarlyWarning, VI_featureNewBidFlow, 
            VI_featureNewBidFlowReviewRequired, VI_featureNewBidFlowShowTitle, VI_featureNewBidAnimations, VI_feature_merchOnScroll, itemTitleTranslationEnabled
        });
    }
}
