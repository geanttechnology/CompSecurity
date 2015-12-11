// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import android.net.Uri;
import com.sponsorpay.credentials.SPCredentials;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.sponsorpay.utils:
//            StringUtils, SponsorPayParametersProvider, HostInfo, SignatureTools, 
//            SponsorPayLogger

public class UrlBuilder
{

    private static final String ADVERTISING_ID_KEY = "google_ad_id";
    private static final String ADVERTISING_ID_LIMITED_TRACKING_ENABLED_KEY = "google_ad_id_limited_tracking_enabled";
    private static final String APPID_KEY = "appid";
    private static final String APP_BUNDLE_NAME_KEY = "app_bundle_name";
    private static final String APP_VERSION_KEY = "app_version";
    private static final String CARRIER_COUNTRY_KEY = "carrier_country";
    private static final String CARRIER_NAME_KEY = "carrier_name";
    private static final String CURRENCY_KEY = "currency";
    private static final String LANGUAGE_KEY = "language";
    private static final String MANUFACTURER_KEY = "manufacturer";
    private static final String NETWORK_CONNECTION_TYPE_KEY = "network_connection_type";
    private static final String OS_VERSION_KEY = "os_version";
    private static final String PHONE_VERSION_KEY = "phone_version";
    private static final String SCREEN_DENSITY_CATEGORY_KEY = "screen_density_category";
    private static final String SCREEN_DENSITY_X_KEY = "screen_density_x";
    private static final String SCREEN_DENSITY_Y_KEY = "screen_density_y";
    private static final String SCREEN_HEIGHT_KEY = "screen_height";
    private static final String SCREEN_WIDTH_KEY = "screen_width";
    private static final String SDK_RELEASE_VERSION_KEY = "sdk_version";
    private static final String TAG = "UrlBuilder";
    private static final String TIMESTAMP_KEY = "timestamp";
    public static final String URL_PARAM_ALLOW_CAMPAIGN_KEY = "allow_campaign";
    public static final String URL_PARAM_CURRENCY_NAME_KEY = "currency";
    public static final String URL_PARAM_OFFSET_KEY = "offset";
    private static final String URL_PARAM_SIGNATURE = "signature";
    public static final String URL_PARAM_VALUE_ON = "on";
    private static final String USERID_KEY = "uid";
    private SPCredentials mCredentials;
    private String mCurrency;
    private Map mExtraKeysValues;
    private String mResourceUrl;
    private boolean mShouldAddScreenMetrics;
    private boolean mShouldAddSignature;
    private boolean mShouldAddTimestamp;
    private boolean mShouldAddUserId;

    protected UrlBuilder(String s, SPCredentials spcredentials)
    {
        mShouldAddScreenMetrics = false;
        mShouldAddUserId = true;
        mShouldAddTimestamp = false;
        mShouldAddSignature = false;
        mResourceUrl = s;
        mCredentials = spcredentials;
    }

    private String getCurrentUnixTimestampAsString()
    {
        return String.valueOf(System.currentTimeMillis() / 1000L);
    }

    private Map getExtraKeys()
    {
        if (mExtraKeysValues == null)
        {
            mExtraKeysValues = new HashMap();
        }
        return mExtraKeysValues;
    }

    public static Map mapKeysToValues(String as[], String as1[])
    {
        if (as.length != as1.length)
        {
            throw new IllegalArgumentException("SponsorPay SDK: When specifying Custom Parameters using two arrays of Keys and Values, both must have the same length.");
        }
        HashMap hashmap = new HashMap(as.length);
        int i = 0;
        do
        {
            if (i >= as.length)
            {
                return hashmap;
            }
            String s = as[i];
            String s1 = as1[i];
            if (StringUtils.nullOrEmpty(s) || StringUtils.nullOrEmpty(s1))
            {
                throw new IllegalArgumentException("SponsorPay SDK: When specifying Custom Parameters using two arrays of Keys and Values, none of their elements can be empty or null.");
            }
            hashmap.put(s, s1);
            i++;
        } while (true);
    }

    public static UrlBuilder newBuilder(String s, SPCredentials spcredentials)
    {
        return new UrlBuilder(s, spcredentials);
    }

    public static void validateKeyValueParams(Map map)
    {
        if (map == null) goto _L2; else goto _L1
_L1:
        map = map.entrySet().iterator();
_L5:
        if (map.hasNext()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
        if (StringUtils.nullOrEmpty((String)entry.getKey()) || StringUtils.nullOrEmpty((String)entry.getValue()))
        {
            throw new IllegalArgumentException("SponsorPay SDK: Custom Parameters cannot have an empty or null Key or Value.");
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public UrlBuilder addExtraKeysValues(Map map)
    {
        if (map != null)
        {
            getExtraKeys().putAll(map);
        }
        return this;
    }

    public UrlBuilder addKeyValue(String s, String s1)
    {
        if (StringUtils.notNullNorEmpty(s))
        {
            getExtraKeys().put(s, s1);
        }
        return this;
    }

    public UrlBuilder addScreenMetrics()
    {
        mShouldAddScreenMetrics = true;
        return this;
    }

    public UrlBuilder addSignature()
    {
        mShouldAddSignature = true;
        mShouldAddTimestamp = true;
        return this;
    }

    public UrlBuilder addTimestamp()
    {
        mShouldAddTimestamp = true;
        return this;
    }

    public String buildUrl()
    {
        HashMap hashmap = new HashMap();
        Object obj = SponsorPayParametersProvider.getParameters();
        if (!((Map) (obj)).isEmpty())
        {
            hashmap.putAll(((Map) (obj)));
        }
        if (mShouldAddUserId)
        {
            hashmap.put("uid", mCredentials.getUserId());
        }
        obj = HostInfo.getHostInfo(null);
        hashmap.put("sdk_version", "6.5.2");
        hashmap.put("appid", mCredentials.getAppId());
        hashmap.put("os_version", ((HostInfo) (obj)).getOsVersion());
        hashmap.put("phone_version", ((HostInfo) (obj)).getPhoneVersion());
        hashmap.put("language", ((HostInfo) (obj)).getLanguageSetting());
        hashmap.put("carrier_name", ((HostInfo) (obj)).getCarrierName());
        hashmap.put("carrier_country", ((HostInfo) (obj)).getCarrierCountry());
        hashmap.put("network_connection_type", ((HostInfo) (obj)).getConnectionType());
        hashmap.put("manufacturer", ((HostInfo) (obj)).getManufacturer());
        hashmap.put("app_bundle_name", ((HostInfo) (obj)).getAppBundleName());
        hashmap.put("app_version", ((HostInfo) (obj)).getAppVersion());
        if (StringUtils.notNullNorEmpty(mCurrency))
        {
            hashmap.put("currency", mCurrency);
        }
        if (mShouldAddScreenMetrics)
        {
            hashmap.put("screen_width", ((HostInfo) (obj)).getScreenWidth());
            hashmap.put("screen_height", ((HostInfo) (obj)).getScreenHeight());
            hashmap.put("screen_density_x", ((HostInfo) (obj)).getScreenDensityX());
            hashmap.put("screen_density_y", ((HostInfo) (obj)).getScreenDensityY());
            hashmap.put("screen_density_category", ((HostInfo) (obj)).getScreenDensityCategory());
        }
        if (mExtraKeysValues != null)
        {
            validateKeyValueParams(mExtraKeysValues);
            hashmap.putAll(mExtraKeysValues);
        }
        if (mShouldAddTimestamp)
        {
            hashmap.put("timestamp", getCurrentUnixTimestampAsString());
        }
        Object obj1 = ((HostInfo) (obj)).getAdvertisingId();
        if (StringUtils.notNullNorEmpty(((String) (obj1))))
        {
            hashmap.put("google_ad_id", obj1);
            hashmap.put("google_ad_id_limited_tracking_enabled", ((HostInfo) (obj)).isAdvertisingIdLimitedTrackingEnabled().toString());
        } else
        {
            hashmap.put("google_ad_id", "");
            hashmap.put("google_ad_id_limited_tracking_enabled", "");
        }
        obj = Uri.parse(mResourceUrl).buildUpon();
        obj1 = hashmap.entrySet().iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                if (mShouldAddSignature)
                {
                    obj1 = mCredentials.getSecurityToken();
                    java.util.Map.Entry entry;
                    if (StringUtils.notNullNorEmpty(((String) (obj1))))
                    {
                        ((android.net.Uri.Builder) (obj)).appendQueryParameter("signature", SignatureTools.generateSignatureForParameters(hashmap, ((String) (obj1))));
                    } else
                    {
                        SponsorPayLogger.d("UrlBuilder", "It was impossible to add the signature, the SecretKey has not been provided");
                    }
                }
                return ((android.net.Uri.Builder) (obj)).build().toString();
            }
            entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
            ((android.net.Uri.Builder) (obj)).appendQueryParameter((String)entry.getKey(), (String)entry.getValue());
        } while (true);
    }

    public UrlBuilder sendUserId(boolean flag)
    {
        mShouldAddUserId = flag;
        return this;
    }

    public UrlBuilder setCurrency(String s)
    {
        mCurrency = s;
        return this;
    }
}
