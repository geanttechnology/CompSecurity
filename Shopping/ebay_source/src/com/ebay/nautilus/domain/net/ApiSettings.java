// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.dcs.DcsPropUrl;
import com.ebay.nautilus.domain.dcs.DcsState;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.util.SingleValueCache;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public final class ApiSettings extends Enum
    implements DcsPropUrl
{

    private static final ApiSettings $VALUES[];
    public static final ApiSettings accessTokenUrl;
    public static final ApiSettings addressBookServiceUrl;
    public static final ApiSettings apls2ErrorUrl;
    public static final ApiSettings apls2TrafficUrl;
    public static final ApiSettings attributeExtractionApi;
    public static final ApiSettings catalogContentApi;
    public static final ApiSettings categoryService;
    public static final ApiSettings collectionDetailUrl;
    public static final ApiSettings currencyConversionApiUrl;
    public static final ApiSettings dcs;
    public static final ApiSettings dealsExperienceService;
    public static final ApiSettings eventDetailsService;
    public static final ApiSettings eventsService;
    public static final ApiSettings experimentationApiUrl;
    public static final ApiSettings feedHiddenFollowUrl;
    public static final ApiSettings feedUrl;
    public static final ApiSettings finding20Api;
    public static final ApiSettings finding20ApiSecure;
    public static final ApiSettings fingerprintServiceUrl;
    public static final ApiSettings fundingInstrumentServiceUrl;
    public static final ApiSettings guidesAndReviewsServiceUrl;
    public static final ApiSettings ldsApi;
    public static final ApiSettings myEbaySvcApi;
    public static final ApiSettings pdsApiUrl;
    private static boolean qaValuesLoaded;
    public static final ApiSettings recommendationApiUrl;
    public static final ApiSettings rlForEbaySvcUrl;
    public static final ApiSettings searchServiceApi;
    public static final ApiSettings searchServiceApiV2;
    public static final ApiSettings searchServiceOAuthApiV2;
    public static final ApiSettings shippingRecsApi;
    public static final ApiSettings shopcaseApiUrl;
    public static final ApiSettings shoppingApiUrl;
    public static final ApiSettings shoppingCartApiUrl;
    public static final ApiSettings shortFormEulaUrl;
    private static final SingleValueCache siteSpeedUriCache = new SingleValueCache();
    public static final ApiSettings symbanApiUrl;
    public static final ApiSettings tradingApiUrl;
    public static final ApiSettings trendingUrl;
    public static final ApiSettings unifiedMetadataUrl;
    public static final ApiSettings unifiedStreamUrl;
    public static final ApiSettings userAuthenticationApi;
    public static final ApiSettings ussChannelsUrl;
    public static final ApiSettings ussDealsUrl;
    public static final ApiSettings viewListingServiceUrl;
    public static final ApiSettings xoExperienceService;
    private final String defaultValue;
    private final String key;
    private String qaValue;

    private ApiSettings(String s, int i, String s1)
    {
        this(s, i, s1, s1);
    }

    private ApiSettings(String s, int i, String s1, String s2)
    {
        super(s, i);
        key = (new StringBuilder()).append("ApiSettings.").append(name()).toString();
        defaultValue = s1;
        qaValue = s2;
    }

    private static void checkForOverridePropertiesFile()
    {
        com/ebay/nautilus/domain/net/ApiSettings;
        JVM INSTR monitorenter ;
        boolean flag = qaValuesLoaded;
        if (!flag) goto _L2; else goto _L1
_L1:
        com/ebay/nautilus/domain/net/ApiSettings;
        JVM INSTR monitorexit ;
        return;
_L2:
        qaValuesLoaded = true;
        Object obj;
        Object obj2;
        obj = Environment.getExternalStorageDirectory();
        if (!((File) (obj)).exists())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new File(((File) (obj)), "ebay.properties");
        if (!((File) (obj)).exists() || !((File) (obj)).canRead())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = new FileInputStream(((File) (obj)));
        obj = new Properties();
        ((Properties) (obj)).load(((java.io.InputStream) (obj2)));
        ((FileInputStream) (obj2)).close();
        obj2 = ((Properties) (obj)).stringPropertyNames().iterator();
_L3:
        String s;
        String s1;
        if (!((Iterator) (obj2)).hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        s = (String)((Iterator) (obj2)).next();
        s1 = ((Properties) (obj)).getProperty(s);
        try
        {
            valueOf(s).qaValue = s1;
            Log.w("ApiSettings", (new StringBuilder()).append("Properties file overrides ").append(s).append(" to ").append(s1).toString());
        }
        catch (IllegalArgumentException illegalargumentexception) { }
          goto _L3
        Object obj1;
        obj1;
        Log.e("ApiSettings", (new StringBuilder()).append("checkForOverridePropertiesFile exception ").append(obj1).toString());
        if (true) goto _L1; else goto _L4
_L4:
        obj1;
        throw obj1;
    }

    public static String get(DcsPropUrl dcspropurl)
    {
        dcspropurl = getUrl(dcspropurl);
        if (dcspropurl != null)
        {
            return dcspropurl.toString();
        } else
        {
            return null;
        }
    }

    public static String getAutoFillRequest(String s, String s1)
    {
        return Uri.parse("http://include.ebaystatic.com/autofill/f").buildUpon().appendPath(s).appendPath(s1).build().toString();
    }

    public static Uri getSiteSpeedUri(EbayCountry ebaycountry)
    {
        Uri uri;
        Uri uri1;
        SingleValueCache singlevaluecache;
        if (ebaycountry == null)
        {
            ebaycountry = EbaySite.US;
        } else
        {
            ebaycountry = ebaycountry.getSite();
        }
        singlevaluecache = siteSpeedUriCache;
        singlevaluecache;
        JVM INSTR monitorenter ;
        uri1 = (Uri)siteSpeedUriCache.get(ebaycountry);
        uri = uri1;
        if (uri1 != null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        uri = Uri.parse(String.format("https://sofe.%s/ws/web/SojPagePerf", new Object[] {
            ebaycountry.getDomain()
        }));
        siteSpeedUriCache.put(ebaycountry, uri);
        singlevaluecache;
        JVM INSTR monitorexit ;
        return uri;
        ebaycountry;
        singlevaluecache;
        JVM INSTR monitorexit ;
        throw ebaycountry;
    }

    public static URL getUrl(DcsPropUrl dcspropurl)
    {
        return DeviceConfiguration.getAsync().get(dcspropurl);
    }

    public static ApiSettings valueOf(String s)
    {
        return (ApiSettings)Enum.valueOf(com/ebay/nautilus/domain/net/ApiSettings, s);
    }

    public static ApiSettings[] values()
    {
        return (ApiSettings[])$VALUES.clone();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        if (NautilusKernel.isQaMode())
        {
            checkForOverridePropertiesFile();
            return qaValue;
        } else
        {
            return defaultValue;
        }
    }

    public String key()
    {
        return key;
    }

    static 
    {
        tradingApiUrl = new ApiSettings("tradingApiUrl", 0, "https://api.ebay.com/ws/api.dll", "http://api4.qa.ebay.com/ws/api.dll");
        shoppingApiUrl = new ApiSettings("shoppingApiUrl", 1, "https://api.ebay.com/shopping", "http://api4.qa.ebay.com/ws/svc/Shopping");
        recommendationApiUrl = new ApiSettings("recommendationApiUrl", 2, "https://api.ebay.com/marketing/merch/v1/recommendation", "http://api4.qa.ebay.com/marketing/merch/v1/recommendation");
        shoppingCartApiUrl = new ApiSettings("shoppingCartApiUrl", 3, "https://svcs.ebay.com/services/checkout/v1/CartApplicationServiceV1", "http://api4.qa.ebay.com/services/checkout/v1/CartApplicationServiceV1");
        shopcaseApiUrl = new ApiSettings("shopcaseApiUrl", 4, "https://api.ebay.com/shopcase/v2", "http://api4.qa.ebay.com/shopcase/v2");
        currencyConversionApiUrl = new ApiSettings("currencyConversionApiUrl", 5, "https://svcs.ebay.com/Billing/v1/BillingCurrencyRateServiceV1");
        apls2TrafficUrl = new ApiSettings("apls2TrafficUrl", 6, "https://svcs.ebay.com/services/mobile/apls/v1/traffic");
        apls2ErrorUrl = new ApiSettings("apls2ErrorUrl", 7, "https://svcs.ebay.com/services/mobile/apls/v1/error");
        experimentationApiUrl = new ApiSettings("experimentationApiUrl", 8, "https://svcs.ebay.com/services/mobile/mes/v2/treatments", "http://api4.qa.ebay.com/services/mobile/mes/v2/treatments");
        addressBookServiceUrl = new ApiSettings("addressBookServiceUrl", 9, "https://mobixo.ebay.com/services/addressbookservice/v1/AddressBookService", "http://api4.qa.ebay.com/services/addressbookservice/v1/AddressBookService");
        fundingInstrumentServiceUrl = new ApiSettings("fundingInstrumentServiceUrl", 10, "https://fiappsvc.ebay.com/fiappsvc", "http://api4.qa.ebay.com/fiappsvc");
        myEbaySvcApi = new ApiSettings("myEbaySvcApi", 11, "https://svcs.ebay.com/ws/spf", "http://api4.qa.ebay.com/ws/spf/MyEbayApplicationService");
        symbanApiUrl = new ApiSettings("symbanApiUrl", 12, "https://api.ebay.com/core/notificationinbox/v1/notification", "https://api4.qa.ebay.com/core/notificationinbox/v1/notification");
        accessTokenUrl = new ApiSettings("accessTokenUrl", 13, "https://idauth.ebay.com/idauth/site/token", "http://api4.qa.ebay.com/idauth/site/token");
        searchServiceApi = new ApiSettings("searchServiceApi", 14, "https://api.ebay.com/buying/search/v1", "http://api4.qa.ebay.com/buying/search/v1");
        searchServiceApiV2 = new ApiSettings("searchServiceApiV2", 15, "https://api.ebay.com/buying/search/v2", "http://api4.qa.ebay.com/buying/search/v2");
        searchServiceOAuthApiV2 = new ApiSettings("searchServiceOAuthApiV2", 16, "https://api.ebay.com/search/v2", "http://api4.qa.ebay.com/search/v2");
        rlForEbaySvcUrl = new ApiSettings("rlForEbaySvcUrl", 17, "http://rlforebay.redlaser.com");
        finding20Api = new ApiSettings("finding20Api", 18, "https://svcs.ebay.com/services/search/FindingService/v1", "https://api4.qa.ebay.com/services/search/FindingService/v1");
        finding20ApiSecure = new ApiSettings("finding20ApiSecure", 19, "https://svcs.ebay.com/services/search/FindingService/v1", "https://api4.qa.ebay.com/services/search/FindingService/v1");
        viewListingServiceUrl = new ApiSettings("viewListingServiceUrl", 20, "https://api.ebay.com/buy/listing/v1/listingdetails", "http://api4.qa.ebay.com/buy/listing/v1/listingdetails/");
        shortFormEulaUrl = new ApiSettings("shortFormEulaUrl", 21, "https://svcs.ebay.com/services/buying/userAgreements/v1/shortFormNotice", "http://mobiusragrmnt.stg.stratus.qa.ebay.com/usragrmnt/buying/userAgreements/v1/ShortFormNotice");
        trendingUrl = new ApiSettings("trendingUrl", 22, "https://api.ebay.com/trending/v1/topic", "http://www.trndsvc.stratus.qa.ebay.com/trending/v1/topic");
        unifiedMetadataUrl = new ApiSettings("unifiedMetadataUrl", 23, "https://svcs.ebay.com/services/classification/UnifiedMetadataService/v1");
        ldsApi = new ApiSettings("ldsApi", 24, "https://api.ebay.com/selling/ListingDraftService/v1", "http://api4.qa.ebay.com/ws/spf/listing/ListingDraftService/v1");
        attributeExtractionApi = new ApiSettings("attributeExtractionApi", 25, "https://svcs.ebay.com/attr");
        catalogContentApi = new ApiSettings("catalogContentApi", 26, "https://svcs.ebay.com/services/catalog/CatalogContentService/v1", "http://catalogcontentservice.vip.qa.ebay.com/ws/spf");
        shippingRecsApi = new ApiSettings("shippingRecsApi", 27, "https://svcs.ebay.com/services/Shipping/ShippingRecommendationService/v1");
        unifiedStreamUrl = new ApiSettings("unifiedStreamUrl", 28, "https://api.ebay.com/buy/unifiedstream/v1/content", "https://api4.qa.ebay.com/buy/unifiedstream/v1/content");
        ussChannelsUrl = new ApiSettings("ussChannelsUrl", 29, "https://api.ebay.com/buy/unifiedstream/v1/content/channel", "https://api4.qa.ebay.com/buy/unifiedstream/v1/content/channel");
        ussDealsUrl = new ApiSettings("ussDealsUrl", 30, "https://api.ebay.com/buy/unifiedstream/v1/content/deal", "https://api4.qa.ebay.com/buy/unifiedstream/v1/content/deal");
        collectionDetailUrl = new ApiSettings("collectionDetailUrl", 31, "https://api.ebay.com/social/collection/v1/collection/", "http://clnsvc.qa.ebay.com/social/collection/v1/collection/");
        feedUrl = new ApiSettings("feedUrl", 32, "https://api.ebay.com/social/feeds/v1/feed", "http://www.mecs.stg.stratus.qa.ebay.com/social/feeds/v1/feed");
        feedHiddenFollowUrl = new ApiSettings("feedHiddenFollowUrl", 33, "https://api.ebay.com/social/feeds/v1/hidden_follow", "http://www.mecs.stg.stratus.qa.ebay.com/social/feeds/v1/hidden_follow");
        fingerprintServiceUrl = new ApiSettings("fingerprintServiceUrl", 34, "https://api.ebay.com/device/v1/fingerprint", "http://api4.qa.ebay.com/device/v1/fingerprint");
        guidesAndReviewsServiceUrl = new ApiSettings("guidesAndReviewsServiceUrl", 35, "https://api.ebay.com/buy/review/v1", "http://api4.qa.ebay.com/buy/review/v1");
        dcs = new ApiSettings("dcs", 36, "https://mobidcs.ebay.com/services/mobile/v1/DeviceConfigurationService", "http://api4.qa.ebay.com/services/mobile/v1/DeviceConfigurationService");
        eventsService = new ApiSettings("eventsService", 37, "http://www.ebay.com/rps/finditems", "http://www.qa.ebay.com/rps/finditems");
        eventDetailsService = new ApiSettings("eventDetailsService", 38, "https://api.ebay.com/deals_and_events/v1/event", "https://api4.qa.ebay.com/deals_and_events/v1/event");
        pdsApiUrl = new ApiSettings("pdsApiUrl", 39, "https://svcs.ebay.com/services/mobileor/v1/CommonMobileAppService", "https://api4.qa.ebay.com/services/mobileor/v1/CommonMobileAppService");
        userAuthenticationApi = new ApiSettings("userAuthenticationApi", 40, "https://mobiuas.ebay.com/services/mobile/v1/UserAuthenticationService", "http://api4.qa.ebay.com/services/mobile/v1/UserAuthenticationService");
        xoExperienceService = new ApiSettings("xoExperienceService", 41, "https://xoneor.vip.ebay.com/experience/checkout/v1", "http://api4.qa.ebay.com/experience/checkout/v1");
        categoryService = new ApiSettings("categoryService", 42, "https://svcs.ebay.com/ws/spf", "http://appns1.qa.ebay.com/ws/spf");
        dealsExperienceService = new ApiSettings("dealsExperienceService", 43, "http://rppces.qa.ebay.com/experience/deals/v1", "http://rppces.qa.ebay.com/experience/deals/v1");
        $VALUES = (new ApiSettings[] {
            tradingApiUrl, shoppingApiUrl, recommendationApiUrl, shoppingCartApiUrl, shopcaseApiUrl, currencyConversionApiUrl, apls2TrafficUrl, apls2ErrorUrl, experimentationApiUrl, addressBookServiceUrl, 
            fundingInstrumentServiceUrl, myEbaySvcApi, symbanApiUrl, accessTokenUrl, searchServiceApi, searchServiceApiV2, searchServiceOAuthApiV2, rlForEbaySvcUrl, finding20Api, finding20ApiSecure, 
            viewListingServiceUrl, shortFormEulaUrl, trendingUrl, unifiedMetadataUrl, ldsApi, attributeExtractionApi, catalogContentApi, shippingRecsApi, unifiedStreamUrl, ussChannelsUrl, 
            ussDealsUrl, collectionDetailUrl, feedUrl, feedHiddenFollowUrl, fingerprintServiceUrl, guidesAndReviewsServiceUrl, dcs, eventsService, eventDetailsService, pdsApiUrl, 
            userAuthenticationApi, xoExperienceService, categoryService, dealsExperienceService
        });
    }
}
