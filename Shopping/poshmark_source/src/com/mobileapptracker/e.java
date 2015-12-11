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
//            MATParameters, MATEvent, MATPreloadData, MATEncryption

final class e
{

    private static MATParameters a;

    public static String a(MATEvent matevent)
    {
        com/mobileapptracker/e;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder;
        a = MATParameters.getInstance();
        stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder("connection_type=")).append(a.getConnectionType()).toString());
        a(stringbuilder, "age", a.getAge());
        a(stringbuilder, "altitude", a.getAltitude());
        a(stringbuilder, "android_id", a.getAndroidId());
        a(stringbuilder, "android_id_md5", a.getAndroidIdMd5());
        a(stringbuilder, "android_id_sha1", a.getAndroidIdSha1());
        a(stringbuilder, "android_id_sha256", a.getAndroidIdSha256());
        a(stringbuilder, "app_ad_tracking", a.getAppAdTrackingEnabled());
        a(stringbuilder, "app_name", a.getAppName());
        a(stringbuilder, "app_version", a.getAppVersion());
        a(stringbuilder, "app_version_name", a.getAppVersionName());
        a(stringbuilder, "country_code", a.getCountryCode());
        a(stringbuilder, "device_brand", a.getDeviceBrand());
        a(stringbuilder, "device_carrier", a.getDeviceCarrier());
        a(stringbuilder, "device_cpu_type", a.getDeviceCpuType());
        a(stringbuilder, "device_cpu_subtype", a.getDeviceCpuSubtype());
        a(stringbuilder, "device_model", a.getDeviceModel());
        a(stringbuilder, "device_id", a.getDeviceId());
        a(stringbuilder, "existing_user", a.getExistingUser());
        a(stringbuilder, "facebook_user_id", a.getFacebookUserId());
        a(stringbuilder, "gender", a.getGender());
        a(stringbuilder, "google_aid", a.getGoogleAdvertisingId());
        a(stringbuilder, "google_ad_tracking_disabled", a.getGoogleAdTrackingLimited());
        a(stringbuilder, "google_user_id", a.getGoogleUserId());
        a(stringbuilder, "insdate", a.getInstallDate());
        a(stringbuilder, "installer", a.getInstaller());
        a(stringbuilder, "install_referrer", a.getInstallReferrer());
        a(stringbuilder, "is_paying_user", a.getIsPayingUser());
        a(stringbuilder, "language", a.getLanguage());
        a(stringbuilder, "last_open_log_id", a.getLastOpenLogId());
        a(stringbuilder, "latitude", a.getLatitude());
        a(stringbuilder, "longitude", a.getLongitude());
        a(stringbuilder, "mac_address", a.getMacAddress());
        a(stringbuilder, "mat_id", a.getMatId());
        a(stringbuilder, "mobile_country_code", a.getMCC());
        a(stringbuilder, "mobile_network_code", a.getMNC());
        a(stringbuilder, "open_log_id", a.getOpenLogId());
        a(stringbuilder, "os_version", a.getOsVersion());
        a(stringbuilder, "sdk_plugin", a.getPluginName());
        a(stringbuilder, "android_purchase_status", a.getPurchaseStatus());
        a(stringbuilder, "referrer_delay", a.getReferrerDelay());
        a(stringbuilder, "screen_density", a.getScreenDensity());
        a(stringbuilder, "screen_layout_size", (new StringBuilder()).append(a.getScreenWidth()).append("x").append(a.getScreenHeight()).toString());
        a(stringbuilder, "sdk_version", a.getSdkVersion());
        a(stringbuilder, "truste_tpid", a.getTRUSTeId());
        a(stringbuilder, "twitter_user_id", a.getTwitterUserId());
        a(stringbuilder, "conversion_user_agent", a.getUserAgent());
        a(stringbuilder, "user_email_md5", a.getUserEmailMd5());
        a(stringbuilder, "user_email_sha1", a.getUserEmailSha1());
        a(stringbuilder, "user_email_sha256", a.getUserEmailSha256());
        a(stringbuilder, "user_id", a.getUserId());
        a(stringbuilder, "user_name_md5", a.getUserNameMd5());
        a(stringbuilder, "user_name_sha1", a.getUserNameSha1());
        a(stringbuilder, "user_name_sha256", a.getUserNameSha256());
        a(stringbuilder, "user_phone_md5", a.getPhoneNumberMd5());
        a(stringbuilder, "user_phone_sha1", a.getPhoneNumberSha1());
        a(stringbuilder, "user_phone_sha256", a.getPhoneNumberSha256());
        a(stringbuilder, "attribute_sub1", matevent.getAttribute1());
        a(stringbuilder, "attribute_sub2", matevent.getAttribute2());
        a(stringbuilder, "attribute_sub3", matevent.getAttribute3());
        a(stringbuilder, "attribute_sub4", matevent.getAttribute4());
        a(stringbuilder, "attribute_sub5", matevent.getAttribute5());
        a(stringbuilder, "content_id", matevent.getContentId());
        a(stringbuilder, "content_type", matevent.getContentType());
        if (matevent.getCurrencyCode() == null)
        {
            break MISSING_BLOCK_LABEL_1018;
        }
        a(stringbuilder, "currency_code", matevent.getCurrencyCode());
_L1:
        if (matevent.getDate1() != null)
        {
            a(stringbuilder, "date1", Long.toString(matevent.getDate1().getTime() / 1000L));
        }
        if (matevent.getDate2() != null)
        {
            a(stringbuilder, "date2", Long.toString(matevent.getDate2().getTime() / 1000L));
        }
        if (matevent.getLevel() != 0)
        {
            a(stringbuilder, "level", Integer.toString(matevent.getLevel()));
        }
        if (matevent.getQuantity() != 0)
        {
            a(stringbuilder, "quantity", Integer.toString(matevent.getQuantity()));
        }
        if (matevent.getRating() != 0.0D)
        {
            a(stringbuilder, "rating", Double.toString(matevent.getRating()));
        }
        a(stringbuilder, "search_string", matevent.getSearchString());
        a(stringbuilder, "advertiser_ref_id", matevent.getRefId());
        a(stringbuilder, "revenue", Double.toString(matevent.getRevenue()));
        matevent = stringbuilder.toString();
        com/mobileapptracker/e;
        JVM INSTR monitorexit ;
        return matevent;
        a(stringbuilder, "currency_code", a.getCurrencyCode());
          goto _L1
        matevent;
        throw matevent;
    }

    public static String a(MATEvent matevent, MATPreloadData matpreloaddata, boolean flag)
    {
        a = MATParameters.getInstance();
        StringBuilder stringbuilder = (new StringBuilder("https://")).append(a.getAdvertiserId()).append(".");
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
        a(stringbuilder, "package_name", a.getPackageName());
        a(stringbuilder, "referral_source", a.getReferralSource());
        a(stringbuilder, "referral_url", a.getReferralUrl());
        a(stringbuilder, "site_id", a.getSiteId());
        a(stringbuilder, "tracking_id", a.getTrackingId());
        if (matevent.getEventId() != 0)
        {
            a(stringbuilder, "site_event_id", Integer.toString(matevent.getEventId()));
        }
        if (!a.getAction().equals("session"))
        {
            a(stringbuilder, "site_event_name", matevent.getEventName());
        }
        if (matpreloaddata != null)
        {
            stringbuilder.append("&attr_set=1");
            a(stringbuilder, "publisher_id", matpreloaddata.publisherId);
            a(stringbuilder, "offer_id", matpreloaddata.offerId);
            a(stringbuilder, "publisher_ref_id", matpreloaddata.publisherReferenceId);
            a(stringbuilder, "publisher_sub_publisher", matpreloaddata.publisherSubPublisher);
            a(stringbuilder, "publisher_sub_site", matpreloaddata.publisherSubSite);
            a(stringbuilder, "publisher_sub_campaign", matpreloaddata.publisherSubCampaign);
            a(stringbuilder, "publisher_sub_adgroup", matpreloaddata.publisherSubAdgroup);
            a(stringbuilder, "publisher_sub_ad", matpreloaddata.publisherSubAd);
            a(stringbuilder, "publisher_sub_keyword", matpreloaddata.publisherSubKeyword);
            a(stringbuilder, "advertiser_sub_publisher", matpreloaddata.advertiserSubPublisher);
            a(stringbuilder, "advertiser_sub_site", matpreloaddata.advertiserSubSite);
            a(stringbuilder, "advertiser_sub_campaign", matpreloaddata.advertiserSubCampaign);
            a(stringbuilder, "advertiser_sub_adgroup", matpreloaddata.advertiserSubAdgroup);
            a(stringbuilder, "advertiser_sub_ad", matpreloaddata.advertiserSubAd);
            a(stringbuilder, "advertiser_sub_keyword", matpreloaddata.advertiserSubKeyword);
            a(stringbuilder, "publisher_sub1", matpreloaddata.publisherSub1);
            a(stringbuilder, "publisher_sub2", matpreloaddata.publisherSub2);
            a(stringbuilder, "publisher_sub3", matpreloaddata.publisherSub3);
            a(stringbuilder, "publisher_sub4", matpreloaddata.publisherSub4);
            a(stringbuilder, "publisher_sub5", matpreloaddata.publisherSub5);
        }
        matevent = a.getAllowDuplicates();
        if (matevent != null && Integer.parseInt(matevent) == 1)
        {
            stringbuilder.append("&skip_dup=1");
        }
        if (flag)
        {
            stringbuilder.append("&debug=1");
        }
        return stringbuilder.toString();
    }

    public static String a(String s, MATEncryption matencryption)
    {
        com/mobileapptracker/e;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder;
        Object obj;
        stringbuilder = new StringBuilder(s);
        obj = MATParameters.getInstance();
        a = ((MATParameters) (obj));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_149;
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
        obj = a.getAndroidId();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        if (!s.contains("&android_id="))
        {
            a(stringbuilder, "android_id", ((String) (obj)));
        }
        obj = a.getInstallReferrer();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        if (!s.contains("&install_referrer="))
        {
            a(stringbuilder, "install_referrer", ((String) (obj)));
        }
        obj = a.getUserAgent();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        if (!s.contains("&conversion_user_agent="))
        {
            a(stringbuilder, "conversion_user_agent", ((String) (obj)));
        }
        if (!s.contains("&system_date="))
        {
            a(stringbuilder, "system_date", Long.toString((new Date()).getTime() / 1000L));
        }
        s = stringbuilder.toString();
        matencryption = MATEncryption.bytesToHex(matencryption.encrypt(s));
        s = matencryption;
_L2:
        com/mobileapptracker/e;
        JVM INSTR monitorexit ;
        return s;
        matencryption;
        matencryption.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    public static JSONObject a(JSONArray jsonarray, String s, String s1, JSONArray jsonarray1)
    {
        com/mobileapptracker/e;
        JVM INSTR monitorenter ;
        JSONObject jsonobject = new JSONObject();
        if (jsonarray == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        jsonobject.put("data", jsonarray);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        jsonobject.put("store_iap_data", s);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        jsonobject.put("store_iap_signature", s1);
        if (jsonarray1 == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        jsonobject.put("user_emails", jsonarray1);
_L2:
        com/mobileapptracker/e;
        JVM INSTR monitorexit ;
        return jsonobject;
        jsonarray;
        Log.d("MobileAppTracker", "Could not build JSON body of request");
        jsonarray.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        jsonarray;
        throw jsonarray;
    }

    private static void a(StringBuilder stringbuilder, String s, String s1)
    {
        com/mobileapptracker/e;
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
        com/mobileapptracker/e;
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
