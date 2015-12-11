// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import com.ebay.nautilus.domain.dcs.DcsPropString;
import com.ebay.nautilus.domain.dcs.DcsState;

public final class DcsString extends Enum
    implements DcsPropString
{

    private static final DcsString $VALUES[];
    public static final DcsString BopisTermsLink;
    public static final DcsString BuyerRegistrationFpaUrl;
    public static final DcsString BuyerRegistrationPpaUrl;
    public static final DcsString ChromeEndpoint;
    public static final DcsString CortexicaEndpoint;
    public static final DcsString DCSCategoryBrowseAssetType;
    public static final DcsString DealsUrl;
    public static final DcsString DealsUrlScope;
    public static final DcsString EbayNowTermsOfServiceUrl;
    public static final DcsString EndItemEarlyWarning;
    public static final DcsString EpChannelId;
    public static final DcsString FeedUrl;
    public static final DcsString ForgotPasswordUrl;
    public static final DcsString GspBuyerTAndC;
    public static final DcsString GspConsumerRights;
    public static final DcsString GspSellerTAndC;
    public static final DcsString MAINTENANCE_WINDOW;
    public static final DcsString MEC2_LIST;
    public static final DcsString MEC_LIST;
    public static final DcsString MecAddressValidationCountries;
    public static final DcsString MepClientBlacklistExperimentName;
    public static final DcsString MepClientBlacklistTreatmentName;
    public static final DcsString PaisaPayList;
    public static final DcsString PickupFeatureLink;
    public static final DcsString PpaUpgradeUrl;
    public static final DcsString RtmAppPackageList;
    public static final DcsString RtmCampaignDisableList;
    public static final DcsString RtmPlacementDisableList;
    public static final DcsString SellerRegistrationUrl;
    public static final DcsString ShipToFundInfoUrl;
    public static final DcsString ShoppingCartExcludedItemCategories;
    public static final DcsString TopRatedSeller3Url;
    public static final DcsString TopRatedSeller3XOUrl;
    public static final DcsString WebviewLandingDomainWhitelist;
    public static final DcsString categoryBrowseAssetHostURL;
    public static final DcsString ebayGivingCharityInfo;
    public static final DcsString ebayGivingLearnMore;
    public static final DcsString iAppsList;
    public static final DcsString searchFollowNotificationToggleTypes;
    public static final DcsString viewItemBuyBarOverride;
    private final String defaultValue;

    private DcsString(String s, int i)
    {
        super(s, i);
        defaultValue = null;
    }

    private DcsString(String s, int i, String s1)
    {
        super(s, i);
        defaultValue = s1;
    }

    public static DcsString valueOf(String s)
    {
        return (DcsString)Enum.valueOf(com/ebay/mobile/dcs/DcsString, s);
    }

    public static DcsString[] values()
    {
        return (DcsString[])$VALUES.clone();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        com.ebay.nautilus.domain.EbayCountry ebaycountry = dcsstate.ebayCountry;
        dcsstate = dcsstate.site;
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$dcs$DcsString[];

            static 
            {
                $SwitchMap$com$ebay$mobile$dcs$DcsString = new int[DcsString.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.GspConsumerRights.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.GspSellerTAndC.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.GspBuyerTAndC.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.ebayGivingLearnMore.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.ebayGivingCharityInfo.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.ShoppingCartExcludedItemCategories.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.ShipToFundInfoUrl.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.RtmPlacementDisableList.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.RtmCampaignDisableList.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.RtmAppPackageList.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.EpChannelId.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.MepClientBlacklistExperimentName.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.MepClientBlacklistTreatmentName.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.WebviewLandingDomainWhitelist.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.BopisTermsLink.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.EndItemEarlyWarning.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.BuyerRegistrationPpaUrl.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.BuyerRegistrationFpaUrl.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.SellerRegistrationUrl.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.ForgotPasswordUrl.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.PpaUpgradeUrl.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.EbayNowTermsOfServiceUrl.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsString[DcsString.FeedUrl.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.mobile.dcs.DcsString[ordinal()])
        {
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        default:
            return defaultValue;

        case 15: // '\017'
            return com.ebay.common.view.util.EbayCountryManager.Default.inStorePickupTermsOfServiceUrlFormat(ebaycountry);

        case 2: // '\002'
            return com.ebay.common.view.util.EbayCountryManager.Default.getSellerGspTermsAndConditionsDefault(dcsstate);

        case 3: // '\003'
            return com.ebay.common.view.util.EbayCountryManager.Default.getBuyerGspTermsAndConditionsDefault(dcsstate);

        case 16: // '\020'
            return com.ebay.common.view.util.EbayCountryManager.Default.getEndItemEarlyUrlDefault(dcsstate);

        case 7: // '\007'
            return com.ebay.common.view.util.EbayCountryManager.Default.shipToFundInfoUrl(ebaycountry);

        case 17: // '\021'
            return com.ebay.common.view.util.EbayCountryManager.Default.ppaRegistrationUrl(ebaycountry);

        case 18: // '\022'
            return com.ebay.common.view.util.EbayCountryManager.Default.fpaRegistrationUrl(ebaycountry);

        case 19: // '\023'
            return com.ebay.common.view.util.EbayCountryManager.Default.sellerRegistrationUrl(ebaycountry);

        case 20: // '\024'
            return com.ebay.common.view.util.EbayCountryManager.Default.forgotPasswordUrl(ebaycountry);

        case 21: // '\025'
            return com.ebay.common.view.util.EbayCountryManager.Default.ppaUpgradeUrl(ebaycountry);

        case 22: // '\026'
            return com.ebay.common.view.util.EbayCountryManager.Default.eBayNowTermsOfServiceUrlFormat(ebaycountry);

        case 23: // '\027'
            return com.ebay.common.view.util.EbayCountryManager.Default.feedUrl(ebaycountry);
        }
    }

    public String key()
    {
        switch (_cls1..SwitchMap.com.ebay.mobile.dcs.DcsString[ordinal()])
        {
        default:
            return name();

        case 1: // '\001'
            return "GSP.ConsumerRights";

        case 2: // '\002'
            return "GSP.sellerTAndC";

        case 3: // '\003'
            return "GSP.buyerTAndC";

        case 4: // '\004'
            return "ebayGiving.LearnMore";

        case 5: // '\005'
            return "ebayGiving.CharityInfo";

        case 6: // '\006'
            return "ShoppingCart.excludedItemCategories";

        case 7: // '\007'
            return "ShipToFund.infoUrl";

        case 8: // '\b'
            return "RTM.placementDisableList";

        case 9: // '\t'
            return "RTM.campaignDisableList";

        case 10: // '\n'
            return "RTM.appPackageList";

        case 11: // '\013'
            return "EP.channelID";

        case 12: // '\f'
            return "mep.client.blacklist.experiment.name";

        case 13: // '\r'
            return "mep.client.blacklist.treatment.name";

        case 14: // '\016'
            return "webview.domains.whitelist";
        }
    }

    static 
    {
        viewItemBuyBarOverride = new DcsString("viewItemBuyBarOverride", 0);
        BopisTermsLink = new DcsString("BopisTermsLink", 1);
        PickupFeatureLink = new DcsString("PickupFeatureLink", 2);
        CortexicaEndpoint = new DcsString("CortexicaEndpoint", 3, "https://appapi.cortexica.com");
        ChromeEndpoint = new DcsString("ChromeEndpoint", 4, "https://platform.chromedata.com:443/AutomotiveDescriptionService/AutomotiveDescriptionService6");
        GspConsumerRights = new DcsString("GspConsumerRights", 5, "{${prefCountry} = 'AU': 'http://pages.ebay.com.au/help/sell/your-return-policy.html#warranties'}");
        TopRatedSeller3Url = new DcsString("TopRatedSeller3Url", 6, "{${prefCountry} = 'DE': 'http://pages.ebay.de/ebay-garantie/m-app-ebp.html?lang=%s'}");
        TopRatedSeller3XOUrl = new DcsString("TopRatedSeller3XOUrl", 7, "{${prefCountry} = 'DE': 'http://pages.ebay.de/ebay-garantie-ebp/m-app-ebp.html?lang=%s'}");
        GspSellerTAndC = new DcsString("GspSellerTAndC", 8);
        GspBuyerTAndC = new DcsString("GspBuyerTAndC", 9);
        EndItemEarlyWarning = new DcsString("EndItemEarlyWarning", 10);
        MEC2_LIST = new DcsString("MEC2_LIST", 11, "US, Australia, Austria, Belgium_Dutch, Belgium_French, Canada, CanadaFrench, France, Germany, Ireland, Italy, Netherlands, Spain, Switzerland, UK, India, Malaysia, Philippines, Poland, Singapore, eBayMotors, Russia");
        MEC_LIST = new DcsString("MEC_LIST", 12, "US, Australia, Austria, Belgium_Dutch, Belgium_French, Canada, CanadaFrench, France, Germany, Ireland, Italy, Netherlands, Spain, Switzerland, UK, India, Malaysia, Philippines, Poland, Singapore, eBayMotors, Russia");
        PaisaPayList = new DcsString("PaisaPayList", 13);
        ebayGivingLearnMore = new DcsString("ebayGivingLearnMore", 14, "http://givingworks.ebay.com/about.html");
        ebayGivingCharityInfo = new DcsString("ebayGivingCharityInfo", 15, "http://donations.ebay.com/charity/charity.jsp?NP_ID=");
        ShoppingCartExcludedItemCategories = new DcsString("ShoppingCartExcludedItemCategories", 16, "");
        ShipToFundInfoUrl = new DcsString("ShipToFundInfoUrl", 17);
        MecAddressValidationCountries = new DcsString("MecAddressValidationCountries", 18, "");
        RtmPlacementDisableList = new DcsString("RtmPlacementDisableList", 19, "");
        RtmCampaignDisableList = new DcsString("RtmCampaignDisableList", 20, "");
        RtmAppPackageList = new DcsString("RtmAppPackageList", 21, "");
        EpChannelId = new DcsString("EpChannelId", 22, "MobileApp");
        MepClientBlacklistExperimentName = new DcsString("MepClientBlacklistExperimentName", 23, "");
        MepClientBlacklistTreatmentName = new DcsString("MepClientBlacklistTreatmentName", 24, "");
        iAppsList = new DcsString("iAppsList", 25);
        MAINTENANCE_WINDOW = new DcsString("MAINTENANCE_WINDOW", 26);
        BuyerRegistrationPpaUrl = new DcsString("BuyerRegistrationPpaUrl", 27);
        BuyerRegistrationFpaUrl = new DcsString("BuyerRegistrationFpaUrl", 28);
        SellerRegistrationUrl = new DcsString("SellerRegistrationUrl", 29);
        ForgotPasswordUrl = new DcsString("ForgotPasswordUrl", 30);
        PpaUpgradeUrl = new DcsString("PpaUpgradeUrl", 31);
        EbayNowTermsOfServiceUrl = new DcsString("EbayNowTermsOfServiceUrl", 32);
        FeedUrl = new DcsString("FeedUrl", 33);
        DealsUrl = new DcsString("DealsUrl", 34);
        DealsUrlScope = new DcsString("DealsUrlScope", 35);
        WebviewLandingDomainWhitelist = new DcsString("WebviewLandingDomainWhitelist", 36, "");
        categoryBrowseAssetHostURL = new DcsString("categoryBrowseAssetHostURL", 37, "http://p.ebaystatic.com/aw/categories/browse/v2/");
        DCSCategoryBrowseAssetType = new DcsString("DCSCategoryBrowseAssetType", 38, "jpg");
        searchFollowNotificationToggleTypes = new DcsString("searchFollowNotificationToggleTypes", 39, "PUSH");
        $VALUES = (new DcsString[] {
            viewItemBuyBarOverride, BopisTermsLink, PickupFeatureLink, CortexicaEndpoint, ChromeEndpoint, GspConsumerRights, TopRatedSeller3Url, TopRatedSeller3XOUrl, GspSellerTAndC, GspBuyerTAndC, 
            EndItemEarlyWarning, MEC2_LIST, MEC_LIST, PaisaPayList, ebayGivingLearnMore, ebayGivingCharityInfo, ShoppingCartExcludedItemCategories, ShipToFundInfoUrl, MecAddressValidationCountries, RtmPlacementDisableList, 
            RtmCampaignDisableList, RtmAppPackageList, EpChannelId, MepClientBlacklistExperimentName, MepClientBlacklistTreatmentName, iAppsList, MAINTENANCE_WINDOW, BuyerRegistrationPpaUrl, BuyerRegistrationFpaUrl, SellerRegistrationUrl, 
            ForgotPasswordUrl, PpaUpgradeUrl, EbayNowTermsOfServiceUrl, FeedUrl, DealsUrl, DealsUrlScope, WebviewLandingDomainWhitelist, categoryBrowseAssetHostURL, DCSCategoryBrowseAssetType, searchFollowNotificationToggleTypes
        });
    }
}
