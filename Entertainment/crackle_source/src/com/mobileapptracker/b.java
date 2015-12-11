// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mobileapptracker:
//            Parameters, Encryption

final class b
{

    private static Parameters a;

    public static String a()
    {
        com/mobileapptracker/b;
        JVM INSTR monitorenter ;
        Object obj;
        a = Parameters.getInstance();
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append((new StringBuilder("connection_type=")).append(a.getConnectionType()).toString());
        a(((StringBuilder) (obj)), "age", a.getAge());
        a(((StringBuilder) (obj)), "altitude", a.getAltitude());
        a(((StringBuilder) (obj)), "android_id", a.getAndroidId());
        a(((StringBuilder) (obj)), "app_ad_tracking", a.getAppAdTrackingEnabled());
        a(((StringBuilder) (obj)), "app_name", a.getAppName());
        a(((StringBuilder) (obj)), "app_version", a.getAppVersion());
        a(((StringBuilder) (obj)), "country_code", a.getCountryCode());
        a(((StringBuilder) (obj)), "currency_code", a.getCurrencyCode());
        a(((StringBuilder) (obj)), "device_brand", a.getDeviceBrand());
        a(((StringBuilder) (obj)), "device_carrier", a.getDeviceCarrier());
        a(((StringBuilder) (obj)), "device_cpu_type", a.getDeviceCpuType());
        a(((StringBuilder) (obj)), "device_cpu_subtype", a.getDeviceCpuSubtype());
        a(((StringBuilder) (obj)), "device_model", a.getDeviceModel());
        a(((StringBuilder) (obj)), "device_id", a.getDeviceId());
        a(((StringBuilder) (obj)), "attribute_sub1", a.getEventAttribute1());
        a(((StringBuilder) (obj)), "attribute_sub2", a.getEventAttribute2());
        a(((StringBuilder) (obj)), "attribute_sub3", a.getEventAttribute3());
        a(((StringBuilder) (obj)), "attribute_sub4", a.getEventAttribute4());
        a(((StringBuilder) (obj)), "attribute_sub5", a.getEventAttribute5());
        a(((StringBuilder) (obj)), "content_id", a.getEventContentId());
        a(((StringBuilder) (obj)), "content_type", a.getEventContentType());
        a(((StringBuilder) (obj)), "date1", a.getEventDate1());
        a(((StringBuilder) (obj)), "date2", a.getEventDate2());
        a(((StringBuilder) (obj)), "level", a.getEventLevel());
        a(((StringBuilder) (obj)), "quantity", a.getEventQuantity());
        a(((StringBuilder) (obj)), "rating", a.getEventRating());
        a(((StringBuilder) (obj)), "search_string", a.getEventSearchString());
        a(((StringBuilder) (obj)), "existing_user", a.getExistingUser());
        a(((StringBuilder) (obj)), "facebook_user_id", a.getFacebookUserId());
        a(((StringBuilder) (obj)), "gender", a.getGender());
        a(((StringBuilder) (obj)), "google_aid", a.getGoogleAdvertisingId());
        a(((StringBuilder) (obj)), "google_ad_tracking_disabled", a.getGoogleAdTrackingLimited());
        a(((StringBuilder) (obj)), "google_user_id", a.getGoogleUserId());
        a(((StringBuilder) (obj)), "insdate", a.getInstallDate());
        a(((StringBuilder) (obj)), "installer", a.getInstaller());
        a(((StringBuilder) (obj)), "install_log_id", a.getInstallLogId());
        a(((StringBuilder) (obj)), "install_referrer", a.getInstallReferrer());
        a(((StringBuilder) (obj)), "is_paying_user", a.getIsPayingUser());
        a(((StringBuilder) (obj)), "language", a.getLanguage());
        a(((StringBuilder) (obj)), "last_open_log_id", a.getLastOpenLogId());
        a(((StringBuilder) (obj)), "latitude", a.getLatitude());
        a(((StringBuilder) (obj)), "longitude", a.getLongitude());
        a(((StringBuilder) (obj)), "mac_address", a.getMacAddress());
        a(((StringBuilder) (obj)), "mat_id", a.getMatId());
        a(((StringBuilder) (obj)), "mobile_country_code", a.getMCC());
        a(((StringBuilder) (obj)), "mobile_network_code", a.getMNC());
        a(((StringBuilder) (obj)), "open_log_id", a.getOpenLogId());
        a(((StringBuilder) (obj)), "os_version", a.getOsVersion());
        a(((StringBuilder) (obj)), "sdk_plugin", a.getPluginName());
        a(((StringBuilder) (obj)), "android_purchase_status", a.getPurchaseStatus());
        a(((StringBuilder) (obj)), "advertiser_ref_id", a.getRefId());
        a(((StringBuilder) (obj)), "revenue", a.getRevenue());
        a(((StringBuilder) (obj)), "screen_density", a.getScreenDensity());
        a(((StringBuilder) (obj)), "screen_layout_size", (new StringBuilder()).append(a.getScreenWidth()).append("x").append(a.getScreenHeight()).toString());
        a(((StringBuilder) (obj)), "sdk_version", a.getSdkVersion());
        a(((StringBuilder) (obj)), "truste_tpid", a.getTRUSTeId());
        a(((StringBuilder) (obj)), "twitter_user_id", a.getTwitterUserId());
        a(((StringBuilder) (obj)), "update_log_id", a.getUpdateLogId());
        a(((StringBuilder) (obj)), "conversion_user_agent", a.getUserAgent());
        a(((StringBuilder) (obj)), "user_email", a.getUserEmail());
        a(((StringBuilder) (obj)), "user_id", a.getUserId());
        a(((StringBuilder) (obj)), "user_name", a.getUserName());
        obj = ((StringBuilder) (obj)).toString();
        com/mobileapptracker/b;
        JVM INSTR monitorexit ;
        return ((String) (obj));
        Exception exception;
        exception;
        throw exception;
    }

    public static String a(String s, Encryption encryption)
    {
        com/mobileapptracker/b;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder;
        Object obj;
        stringbuilder = new StringBuilder(s);
        obj = Parameters.getInstance();
        a = ((Parameters) (obj));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        obj = a.getGoogleAdvertisingId();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (!s.contains("&google_aid="))
        {
            a(stringbuilder, "google_aid", ((String) (obj)));
            a(stringbuilder, "google_ad_tracking_disabled", a.getGoogleAdTrackingLimited());
        }
        obj = a.getInstallReferrer();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        if (!s.contains("&install_referrer="))
        {
            a(stringbuilder, "install_referrer", ((String) (obj)));
        }
        if (!s.contains("&system_date="))
        {
            a(stringbuilder, "system_date", Long.toString((new Date()).getTime() / 1000L));
        }
        s = stringbuilder.toString();
        encryption = Encryption.bytesToHex(encryption.encrypt(s));
        s = encryption;
_L2:
        com/mobileapptracker/b;
        JVM INSTR monitorexit ;
        return s;
        encryption;
        encryption.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    public static String a(boolean flag, boolean flag1, boolean flag2)
    {
        a = Parameters.getInstance();
        StringBuilder stringbuilder = (new StringBuilder("https://")).append(a.getAdvertiserId()).append(".");
        String s;
        if (flag)
        {
            stringbuilder.append("debug.engine.mobileapptracking.com");
        } else
        {
            stringbuilder.append("engine.mobileapptracking.com");
        }
        stringbuilder.append("/serve?ver=").append(a.getSdkVersion());
        stringbuilder.append("&transaction_id=").append(UUID.randomUUID().toString());
        a(stringbuilder, "sdk", "android");
        a(stringbuilder, "action", a.getAction());
        a(stringbuilder, "advertiser_id", a.getAdvertiserId());
        a(stringbuilder, "site_event_id", a.getEventId());
        a(stringbuilder, "site_event_name", a.getEventName());
        a(stringbuilder, "package_name", a.getPackageName());
        a(stringbuilder, "referral_source", a.getReferralSource());
        a(stringbuilder, "referral_url", a.getReferralUrl());
        a(stringbuilder, "site_id", a.getSiteId());
        a(stringbuilder, "tracking_id", a.getTrackingId());
        if (flag1)
        {
            stringbuilder.append("&attr_set=1");
        }
        a(stringbuilder, "publisher_id", a.getPublisherId());
        a(stringbuilder, "offer_id", a.getOfferId());
        a(stringbuilder, "publisher_ref_id", a.getPublisherReferenceId());
        a(stringbuilder, "publisher_sub_publisher", a.getPublisherSubPublisher());
        a(stringbuilder, "publisher_sub_site", a.getPublisherSubSite());
        a(stringbuilder, "publisher_sub_campaign", a.getPublisherSubCampaign());
        a(stringbuilder, "publisher_sub_adgroup", a.getPublisherSubAdgroup());
        a(stringbuilder, "publisher_sub_ad", a.getPublisherSubAd());
        a(stringbuilder, "publisher_sub_keyword", a.getPublisherSubKeyword());
        a(stringbuilder, "advertiser_sub_publisher", a.getAdvertiserSubPublisher());
        a(stringbuilder, "advertiser_sub_site", a.getAdvertiserSubSite());
        a(stringbuilder, "advertiser_sub_campaign", a.getAdvertiserSubCampaign());
        a(stringbuilder, "advertiser_sub_adgroup", a.getAdvertiserSubAdgroup());
        a(stringbuilder, "advertiser_sub_ad", a.getAdvertiserSubAd());
        a(stringbuilder, "advertiser_sub_keyword", a.getAdvertiserSubKeyword());
        a(stringbuilder, "publisher_sub1", a.getPublisherSub1());
        a(stringbuilder, "publisher_sub2", a.getPublisherSub2());
        a(stringbuilder, "publisher_sub3", a.getPublisherSub3());
        a(stringbuilder, "publisher_sub4", a.getPublisherSub4());
        a(stringbuilder, "publisher_sub5", a.getPublisherSub5());
        s = a.getAllowDuplicates();
        if (s != null && Integer.parseInt(s) == 1)
        {
            stringbuilder.append("&skip_dup=1");
        }
        if (flag)
        {
            stringbuilder.append("&debug=1");
        }
        if (flag2)
        {
            stringbuilder.append("&post_conversion=1");
        }
        return stringbuilder.toString();
    }

    public static JSONObject a(JSONArray jsonarray, String s, String s1)
    {
        com/mobileapptracker/b;
        JVM INSTR monitorenter ;
        JSONObject jsonobject = new JSONObject();
        if (jsonarray == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        jsonobject.put("data", jsonarray);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        jsonobject.put("store_iap_data", s);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        jsonobject.put("store_iap_signature", s1);
_L2:
        com/mobileapptracker/b;
        JVM INSTR monitorexit ;
        return jsonobject;
        jsonarray;
        Log.d("MobileAppTracker", "Could not build JSON for event items or verification values");
        jsonarray.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        jsonarray;
        throw jsonarray;
    }

    private static void a(StringBuilder stringbuilder, String s, String s1)
    {
        com/mobileapptracker/b;
        JVM INSTR monitorenter ;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        boolean flag = s1.equals("");
        if (flag)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        stringbuilder.append((new StringBuilder("&")).append(s).append("=").append(URLEncoder.encode(s1, "UTF-8")).toString());
_L2:
        com/mobileapptracker/b;
        JVM INSTR monitorexit ;
        return;
        stringbuilder;
        Log.w("MobileAppTracker", (new StringBuilder("failed encoding value ")).append(s1).append(" for key ").append(s).toString());
        stringbuilder.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        stringbuilder;
        throw stringbuilder;
    }
}
