// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.dcs.DcsPropUrl;
import com.ebay.nautilus.domain.dcs.DcsState;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.NautilusKernel;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public final class EbaySettings extends Enum
    implements DcsPropUrl
{

    private static final EbaySettings $VALUES[];
    public static final EbaySettings appListApi;
    public static final EbaySettings applicationProcessSvc;
    public static final EbaySettings autoCompleteQueryService;
    public static final EbaySettings autoSuggestionUrl;
    public static final EbaySettings cal;
    public static final EbaySettings cartServicesUrl;
    public static final EbaySettings catalogMatchProductService;
    public static final EbaySettings categoriesConfigUrl;
    public static final EbaySettings clientAlertApi;
    public static final EbaySettings commonMobileAppSvcUrl;
    public static final EbaySettings deTradingApiImageUpload;
    public static final EbaySettings dealsApiUrlFormat;
    public static final EbaySettings ebncdsvcUrl;
    public static final EbaySettings findItemService;
    public static final EbaySettings findProductService;
    public static final EbaySettings findingUserSettingsApi;
    public static final EbaySettings followBaseUrl;
    public static final EbaySettings fundRaisingFindingUrl;
    public static final EbaySettings fundRaisingUrl;
    public static final EbaySettings fundRaisingUserUrl;
    public static final EbaySettings garageService;
    public static final EbaySettings gmAdapterApi;
    public static final EbaySettings idMap;
    public static final EbaySettings interestBaseUrl;
    public static final EbaySettings localLookupUrl;
    public static final EbaySettings merchantInventoryLookupUrl;
    public static final EbaySettings metadataUrl;
    public static final EbaySettings mmlConfigUrl;
    public static final EbaySettings mobileTrackingServiceApi;
    public static final EbaySettings mvlConfigUrl;
    public static final EbaySettings notificationApi;
    public static final EbaySettings paisaPayMobileWebXoUrl;
    public static final EbaySettings printShippingLabelUrl;
    public static final EbaySettings productApi;
    public static final EbaySettings productStatisticsUrl;
    public static final EbaySettings promoCardsConfigUrl;
    private static boolean qaValuesLoaded;
    public static final EbaySettings rtm;
    public static final EbaySettings rtmAds;
    public static final EbaySettings scanToWinConfigUrl;
    public static final EbaySettings shippingApi;
    public static final EbaySettings ssoApiBase;
    public static final EbaySettings ssoSiteSpecificApiBase;
    public static final EbaySettings videoManagerConfigUrl;
    public static final EbaySettings viewItemLite;
    private final String defaultValue;
    private final String key;
    private String qaValue;

    private EbaySettings(String s, int i, String s1)
    {
        this(s, i, s1, s1);
    }

    private EbaySettings(String s, int i, String s1, String s2)
    {
        super(s, i);
        key = (new StringBuilder()).append("ApiSettings.").append(name()).toString();
        defaultValue = s1;
        qaValue = s2;
    }

    private static void checkForOverridePropertiesFile()
    {
        com/ebay/common/util/EbaySettings;
        JVM INSTR monitorenter ;
        boolean flag = qaValuesLoaded;
        if (!flag) goto _L2; else goto _L1
_L1:
        com/ebay/common/util/EbaySettings;
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
            Log.w("EbaySettings", (new StringBuilder()).append("Properties file overrides ").append(s).append(" to ").append(s1).toString());
        }
        catch (IllegalArgumentException illegalargumentexception) { }
          goto _L3
        Object obj1;
        obj1;
        Log.e("EbaySettings", (new StringBuilder()).append("checkForOverridePropertiesFile exception ").append(obj1).toString());
        if (true) goto _L1; else goto _L4
_L4:
        obj1;
        throw obj1;
    }

    public static String get(DcsPropUrl dcspropurl)
    {
        return ApiSettings.get(dcspropurl);
    }

    public static String getAutoCompleteQuery(String s, String s1, String s2, boolean flag, boolean flag1)
    {
        s = Uri.parse(ApiSettings.get(autoCompleteQueryService)).buildUpon().appendQueryParameter("fetchSize", s).appendQueryParameter("dictionaryName", s1);
        if (flag)
        {
            s.appendQueryParameter("filter(0).propertyName", "CATALOGSTATUS").appendQueryParameter("filter(0).operator", "eq").appendQueryParameter("filter(0).operand", "1");
        }
        if (flag1)
        {
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            s.appendQueryParameter((new StringBuilder()).append("filter(").append(i).append(").propertyName").toString(), "CHILDST").appendQueryParameter((new StringBuilder()).append("filter(").append(i).append(").operator").toString(), "eq").appendQueryParameter((new StringBuilder()).append("filter(").append(i).append(").operand").toString(), "1");
        }
        return s.appendQueryParameter("queryTerm", s2).build().toString();
    }

    public static String getAutoFillRequest(String s, String s1)
    {
        return ApiSettings.getAutoFillRequest(s, s1);
    }

    public static String getAutoSuggestionQuery(int i, String s)
    {
        return Uri.parse(ApiSettings.get(autoSuggestionUrl)).buildUpon().appendQueryParameter("sId", (new StringBuilder()).append("").append(i).toString()).appendQueryParameter("_dg", "1").appendQueryParameter("kwd", s).appendQueryParameter("_cb", "0").build().toString();
    }

    public static String getClientAlertGetAlerts(String s, String s1)
    {
        return Uri.parse(ApiSettings.get(clientAlertApi)).buildUpon().appendQueryParameter("callname", "GetUserAlerts").appendQueryParameter("SessionID", s).appendQueryParameter("SessionData", s1).build().toString();
    }

    public static String getClientAlertLogin(String s)
    {
        return Uri.parse(ApiSettings.get(clientAlertApi)).buildUpon().appendQueryParameter("callname", "Login").appendQueryParameter("ClientAlertsAuthToken", s).build().toString();
    }

    public static String getImageUrlFromMd5(long l, String s)
    {
        if (l <= 0L || s == null || s.trim().equals(""))
        {
            return null;
        }
        String s1 = s;
        if (s.startsWith("S"))
        {
            s1 = s.substring(1, s.length());
        }
        s = new StringBuilder("http://thumbs");
        s.append(l % 4L + 1L);
        if (NautilusKernel.isQaMode())
        {
            s.append(".qa.ebaystatic.com");
        } else
        {
            s.append(".ebaystatic.com");
        }
        s.append("/m/");
        s.append(s1);
        s.append("/140.jpg");
        return s.toString();
    }

    public static String getUpdateContactInfoUrl(String s)
    {
        Object obj = MyApp.getPrefs().getCurrentCountry();
        if (!NautilusKernel.isQaMode()) goto _L2; else goto _L1
_L1:
        ((EbayCountry) (obj)).getSiteId();
        JVM INSTR lookupswitch 20: default 188
    //                   2: 219
    //                   3: 338
    //                   15: 212
    //                   16: 205
    //                   23: 261
    //                   71: 254
    //                   77: 240
    //                   101: 289
    //                   123: 310
    //                   146: 303
    //                   186: 247
    //                   193: 233
    //                   201: 268
    //                   203: 282
    //                   205: 275
    //                   207: 296
    //                   210: 226
    //                   211: 317
    //                   212: 324
    //                   216: 331;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23
_L3:
        obj = "https://reg.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
_L24:
        return String.format(((String) (obj)), new Object[] {
            s
        });
_L7:
        obj = "https://reg.uk.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L6:
        obj = "https://reg.au.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L4:
        obj = "https://reg.ca.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L20:
        obj = "https://reg.cafr.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L15:
        obj = "https://reg.ch.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L10:
        obj = "https://reg.de.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L14:
        obj = "https://reg.es.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L9:
        obj = "https://reg.fr.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L8:
        obj = "https://reg.befr.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L16:
        obj = "https://reg.hk.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L18:
        obj = "https://reg.ie.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L17:
        obj = "https://reg.in.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L11:
        obj = "https://reg.it.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L19:
        obj = "https://reg.my.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L13:
        obj = "https://reg.nl.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L12:
        obj = "https://reg.benl.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L21:
        obj = "https://reg.ph.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L22:
        obj = "https://reg.pl.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L23:
        obj = "https://reg.sg.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        continue; /* Loop/switch isn't completed */
_L5:
        obj = "https://reg.uk.paradise.qa.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
        if (true) goto _L24; else goto _L2
_L2:
        switch (((EbayCountry) (obj)).getSiteId())
        {
        default:
            obj = "https://reg.ebay.com/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 16: // '\020'
            obj = "https://reg.ebay.at/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 15: // '\017'
            obj = "https://reg.ebay.com.au/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 2: // '\002'
            obj = "https://reg.ebay.ca/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 210: 
            obj = "https://reg.cafr.ebay.ca/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 193: 
            obj = "https://reg.ebay.ch/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 77: // 'M'
            obj = "https://reg.ebay.de/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 186: 
            obj = "https://reg.ebay.es/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 71: // 'G'
            obj = "https://reg.ebay.fr/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 23: // '\027'
            obj = "https://reg.befr.ebay.be/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 201: 
            obj = "https://reg.ebay.com.hk/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 205: 
            obj = "https://reg.ebay.iereg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 203: 
            obj = "https://reg.ebay.in/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 101: // 'e'
            obj = "https://reg.ebay.it/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 207: 
            obj = "https://reg.ebay.com.my/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 146: 
            obj = "https://reg.ebay.nl/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 123: // '{'
            obj = "https://reg.benl.ebay.be/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 211: 
            obj = "https://reg.ebay.ph/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 212: 
            obj = "https://reg.ebay.pl/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 216: 
            obj = "https://reg.ebay.com.sg/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;

        case 3: // '\003'
            obj = "https://reg.ebay.co.uk/reg/UpdateContactInfo?flow=%s&srcAppId=2571&rmvHdr=true";
            break;
        }
        if (true) goto _L24; else goto _L25
_L25:
    }

    public static String getViewItemLiteReq(String s)
    {
        return Uri.parse(ApiSettings.get(viewItemLite)).buildUpon().appendQueryParameter("item", s).build().toString();
    }

    public static EbaySettings valueOf(String s)
    {
        return (EbaySettings)Enum.valueOf(com/ebay/common/util/EbaySettings, s);
    }

    public static EbaySettings[] values()
    {
        return (EbaySettings[])$VALUES.clone();
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
        findingUserSettingsApi = new EbaySettings("findingUserSettingsApi", 0, "https://svcs.ebay.com/services/search/FindingUserSettingsService/v1", "https://api4.qa.ebay.com/services/search/FindingUserSettingsService/v1");
        notificationApi = new EbaySettings("notificationApi", 1, "https://svcs.ebay.com/mobile/DeviceNotificationService/v1", "http://api4.qa.ebay.com/mobile/DeviceNotificationService/v1");
        appListApi = new EbaySettings("appListApi", 2, "https://svcs.ebay.com/services/mobile/v1/MessagesForTheDayService", "http://api4.qa.ebay.com/services/mobile/v1/MessagesForTheDayService");
        productApi = new EbaySettings("productApi", 3, "https://svcs.ebay.com/services/marketplacecatalog/ProductService/v1", "http://apifind.qa.ebay.com/services/marketplacecatalog/ProductService/v1");
        cartServicesUrl = new EbaySettings("cartServicesUrl", 4, "https://mobixo4.ebay.com/services/cartservice/v4/CartService", "https://api4.qa.ebay.com/services/cartservice/v4/CartService");
        ebncdsvcUrl = new EbaySettings("ebncdsvcUrl", 5, "https://svcs.ebay.com/buy/shipping/v2/deliveries", "http://api4.qa.ebay.com/ebnsvc/v2");
        applicationProcessSvc = new EbaySettings("applicationProcessSvc", 6, "https://svcs.ebay.com/services/mobileor/v1/IPhoneApplicationProcessService", "https://api4.qa.ebay.com/services/mobileor/v1/IPhoneApplicationProcessService");
        idMap = new EbaySettings("idMap", 7, "http://rover.ebay.com/idmap/1?pid=ema&site=-1&psv=&m=1010&cb=cb", "http://api4.qa.ebay.com/idmap/1?pid=ema&site=-1&psv=&m=1010&cb=cb");
        shippingApi = new EbaySettings("shippingApi", 8, "https://svcs.ebay.com/services/Shipping/CoreShippingService/v10", "http://api4.qa.ebay.com/services/Shipping/CoreShippingService/v10");
        cal = new EbaySettings("cal", 9, "https://mobilog.ebay.com/mobile/ApplicationLoggingService/v1", "http://api4.qa.ebay.com/mobile/ApplicationLoggingService/v1");
        commonMobileAppSvcUrl = new EbaySettings("commonMobileAppSvcUrl", 10, "https://svcs.ebay.com/services/mobileor/v2/CommonMobileAppServiceV2", "https://api4.qa.ebay.com/services/mobileor/v2/CommonMobileAppServiceV2");
        gmAdapterApi = new EbaySettings("gmAdapterApi", 11, "https://mobileclient.paypal.com/GMAdapter/", "https://www.stage2mobile08.paypal.com:10521/GMAdapter/");
        dealsApiUrlFormat = new EbaySettings("dealsApiUrlFormat", 12, "http://anywhere.ebay.com/services/feed/deals/deals.php?siteid=%1$d&version=3&dealdetail=%2$d&type=%3$d", null);
        clientAlertApi = new EbaySettings("clientAlertApi", 13, "https://clientalerts.ebay.com/ws/ecasvc/ClientAlerts");
        rtm = new EbaySettings("rtm", 14, "https://svcs.ebay.com/services/mobileor/v1/CommonMobileAppService", "https://api4.qa.ebay.com/services/mobileor/v1/CommonMobileAppService");
        rtmAds = new EbaySettings("rtmAds", 15, "https://svcs.ebay.com/services/mobileor/v2/CommonMobileAppServiceV2", "http://api4.qa.ebay.com/services/mobileor/v2/CommonMobileAppServiceV2");
        viewItemLite = new EbaySettings("viewItemLite", 16, "http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItemLite", "http://cgi.qa.ebay.com/ws/eBayISAPI.dll?ViewItemLite");
        autoCompleteQueryService = new EbaySettings("autoCompleteQueryService", 17, "https://autocomplete.ebay.com/services/search/AutoCompleteQueryService/v1?X-EBAY-SOA-SERVICE-NAME=AutoCompleteQueryService&X-EBAY-SOA-OPERATION-NAME=queryDictionary&X-EBAY-SOA-RESPONSE-DATA-FORMAT=JSON");
        autoSuggestionUrl = new EbaySettings("autoSuggestionUrl", 18, "https://autosug.ebay.com/autosug");
        mobileTrackingServiceApi = new EbaySettings("mobileTrackingServiceApi", 19, "https://svcs.ebay.com/services/mobile/v1/MobileTrackingService", "http://mobitrack.qa.ebay.com/services/mobile/v1/MobileTrackingService");
        productStatisticsUrl = new EbaySettings("productStatisticsUrl", 20, "https://svcs.ebay.com/services/search/ProductStatisticsService/v1", "http://apifinding.qa.ebay.com/services/search/ProductStatisticsService/v1");
        findProductService = new EbaySettings("findProductService", 21, "https://svcs.ebay.com/services/search/FindProductService/v1", "http://apifinding.qa.ebay.com/ws/spf/FindProductService/v1");
        findItemService = new EbaySettings("findItemService", 22, "https://svcs.ebay.com/services/search/FindItemService/v1", "http://apifinding.qa.ebay.com/ws/spf/FindItemService/v1");
        catalogMatchProductService = new EbaySettings("catalogMatchProductService", 23, "https://svcs.ebay.com/services/catalog/v1/CatalogMatchProductService", "http://catalogmatchproductservice.vip.qa.ebay.com/ws/spf/CatalogMatchProductService");
        ssoApiBase = new EbaySettings("ssoApiBase", 24, "https://auth.ebay.com/ws/eBayISAPI.dll", "https://tidesauth.vip.qa.ebay.com/ws/eBayISAPI.dll");
        ssoSiteSpecificApiBase = new EbaySettings("ssoSiteSpecificApiBase", 25, "https://auth.%s/ws/eBayISAPI.dll", "https://tidesauth.vip.qa.%s/ws/eBayISAPI.dll");
        deTradingApiImageUpload = new EbaySettings("deTradingApiImageUpload", 26, "https://lfnapi.ebay.com/ws/api.dll", "http://api4.qa.ebay.com/ws/api.dll");
        fundRaisingFindingUrl = new EbaySettings("fundRaisingFindingUrl", 27, "https://svcs.ebay.com/services/fundraising/FundRaisingFindingService/v1", "http://api4.qa.ebay.com/services/fundraising/FundRaisingFindingService/v1");
        fundRaisingUserUrl = new EbaySettings("fundRaisingUserUrl", 28, "https://svcs.ebay.com/services/fundraising/FundRaisingUserService/v1", "http://api4.qa.ebay.com/services/fundraising/FundRaisingUserService/v1");
        fundRaisingUrl = new EbaySettings("fundRaisingUrl", 29, "https://svcs.ebay.com/services/fundraising/FundRaisingService/v3", "http://api4.qa.ebay.com/services/fundraising/FundRaisingService/v3");
        scanToWinConfigUrl = new EbaySettings("scanToWinConfigUrl", 30, "http://apigrid.ebay.com/mobile/motors/scantowininfo2.xml");
        videoManagerConfigUrl = new EbaySettings("videoManagerConfigUrl", 31, "http://apigrid.ebay.com/mobile/motors/videos1.xml");
        metadataUrl = new EbaySettings("metadataUrl", 32, "https://svcs.ebay.com/services/marketplacecatalog/ProductMetadataService/v1");
        mvlConfigUrl = new EbaySettings("mvlConfigUrl", 33, "http://apigrid.ebay.com/mobile/motors/mvl.db.gz");
        mmlConfigUrl = new EbaySettings("mmlConfigUrl", 34, "http://apigrid.ebay.com/mobile/motors/mml.db.gz");
        categoriesConfigUrl = new EbaySettings("categoriesConfigUrl", 35, "http://apigrid.ebay.com/mobile/motors/android_motors_categories.xml");
        garageService = new EbaySettings("garageService", 36, "https://mobimotor.ebay.com/ws/spf/MyGarageServiceV1", "http://api4.qa.ebay.com/ws/spf/MyGarageServiceV1");
        promoCardsConfigUrl = new EbaySettings("promoCardsConfigUrl", 37, "http://apigrid.ebay.com/mobile/motors/carcardsconfig.plist");
        merchantInventoryLookupUrl = new EbaySettings("merchantInventoryLookupUrl", 38, "https://api.ebay.com/selling/inventorylookup/v1/shallowcheck?client=mobile", "http://api4.qa.ebay.com/selling/merchantinventorylookup/v1/real_time_inventory_check/shallow/");
        localLookupUrl = new EbaySettings("localLookupUrl", 39, "https://api.ebay.com/selling/inventorylookup/v1/", "http://api4.qa.ebay.com/selling/inventorylookup/v1/");
        paisaPayMobileWebXoUrl = new EbaySettings("paisaPayMobileWebXoUrl", 40, "https://m.ebay.in/mobinxo/ReviewOrder?srcApp=ANDR&_trksid=p2059707.m2931.l5787");
        printShippingLabelUrl = new EbaySettings("printShippingLabelUrl", 41, "https://api.ebay.com/sell/logistics/v1/", "http://api4.qa.ebay.com/sell/logistics/v1/");
        followBaseUrl = new EbaySettings("followBaseUrl", 42, "https://api.ebay.com/social/follow/v1/", "http://follow.qa.ebay.com/social/follow/v1/");
        interestBaseUrl = new EbaySettings("interestBaseUrl", 43, "https://api.ebay.com/social/interests/v1/", "http://www.feedsvcr.stg.stratus.qa.ebay.com/social/interests/v1/");
        $VALUES = (new EbaySettings[] {
            findingUserSettingsApi, notificationApi, appListApi, productApi, cartServicesUrl, ebncdsvcUrl, applicationProcessSvc, idMap, shippingApi, cal, 
            commonMobileAppSvcUrl, gmAdapterApi, dealsApiUrlFormat, clientAlertApi, rtm, rtmAds, viewItemLite, autoCompleteQueryService, autoSuggestionUrl, mobileTrackingServiceApi, 
            productStatisticsUrl, findProductService, findItemService, catalogMatchProductService, ssoApiBase, ssoSiteSpecificApiBase, deTradingApiImageUpload, fundRaisingFindingUrl, fundRaisingUserUrl, fundRaisingUrl, 
            scanToWinConfigUrl, videoManagerConfigUrl, metadataUrl, mvlConfigUrl, mmlConfigUrl, categoriesConfigUrl, garageService, promoCardsConfigUrl, merchantInventoryLookupUrl, localLookupUrl, 
            paisaPayMobileWebXoUrl, printShippingLabelUrl, followBaseUrl, interestBaseUrl
        });
    }
}
