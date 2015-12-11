// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.ebay.common.analytics.MimsUtil;
import com.ebay.common.content.EbayBroadcast;
import com.ebay.common.content.EbayCguid;
import com.ebay.common.content.EbayCguidGetter;
import com.ebay.common.content.EbayCguidPersister;
import com.ebay.common.util.SharedPreferencesCompat;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.util.FwLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.SecretKeySpec;

public class Preferences
    implements EbayCguidPersister
{

    public static final String ACTOR_ID = "mims_actor_id";
    private static final String CA_SECURITY_TOKEN = "Pref_CA_SecurityToken";
    private static final String CA_SECURITY_TOKEN_EXPIRATION = "Pref_CA_SecurityTokenExpiration";
    public static final String EBN_LAST_SCHEDULED_CART = "lastSuccessfulScheduledCartId";
    private static final String ENABLE_HOT_ITEMS = "enable_hot_items";
    public static final String IAF_TOKEN = "iaf_token";
    private static final String KNOWN_USERS = "known_users";
    private static final String LOG_TAG = "Preferences";
    public static final String MACHINE_GROUP_ID = "mg_id_ref";
    private static final String PREF_AUCTION_TYPE = "PrefAuctionType";
    private static final String PREF_AUCTION_TYPE_DEFAULT = "-1";
    private static final String PREF_AUTO_DETECT_COUNTRY = "autodetectCountry";
    private static final String PREF_CGUID_EXPIRES_LINKED = "coreCguidExpires";
    private static final String PREF_CGUID_EXPIRES_UNLINKED = "coreCguidExpiresUnlinked";
    private static final String PREF_CGUID_GUID_LINKED = "coreCguidGuid";
    private static final String PREF_CGUID_GUID_UNLINKED = "coreCguidGuidUnlinked";
    private static final String PREF_COMPLETED_ITEMS = "CompletedItems";
    private static final String PREF_COMPLETED_ITEMS_DEFAULT = "false";
    private static final String PREF_CURRENT_COUNTRY = "currentEbayCountry";
    public static final String PREF_DEVELOPER_OPTIONS_ENABLED = "developerOptions";
    public static final String PREF_DEVELOPER_OPTION_AWOL_NOTIFICATION = "developerOptionNotificationAwol";
    public static final String PREF_DEVELOPER_OPTION_INVERT_THEME = "developerOptionInvertTheme";
    public static final String PREF_DEVELOPER_OPTION_SEARCH_URL = "developerOptionSearchUrl";
    public static final String PREF_DISPLAY_UPLOAD_NOTIFICATION_ALERT = "displayUploadNotificationInfo";
    private static final String PREF_EBAY_WARN_TIME = "PrefWarnTime";
    private static final String PREF_EBAY_WARN_TIME_DEFAULT = "10";
    public static final String PREF_FIRST_LOGIN_PER_USER = "firstLogin";
    private static final String PREF_HIGH_PRICE = "PrefHiPrice";
    private static final String PREF_HIGH_PRICE_DEFAULT = "";
    public static final String PREF_HOME_LAST_CHANNEL = "homeLastChannelIndex";
    public static final String PREF_INSTALLED_VERSION = "installedVersion";
    public static final String PREF_INSTALLED_VERSION_CODE = "installedVersionCode";
    public static final String PREF_LAST_CHARITY_KEYWORD_SEARCH = "searchLastCharityKeywords";
    public static final String PREF_LAST_FEEDBACK_LEFT_AS_BUYER = "lastFeedbackLeftAsBuyer";
    public static final String PREF_LAST_FEEDBACK_LEFT_AS_SELLER = "lastFeedbackLeftAsSeller";
    public static final String PREF_LAST_KEYWORD_SEARCH = "searchLastKeywords";
    public static final String PREF_LAST_SAVED_SEARCH_PROVIDER = "lastSavedSearchProvider";
    public static final String PREF_LAST_SAVED_SEARCH_USER = "lastSavedSearchUser";
    public static final String PREF_LAST_SIGNIN_ENTERED = "lastSigninEntered";
    private static final String PREF_LOW_PRICE = "PrefLoPrice";
    private static final String PREF_LOW_PRICE_DEFAULT = "";
    private static final String PREF_MAXIMUM_DISTANCE = "PrefMaximumDistance";
    private static final String PREF_MAXIMUM_DISTANCE_DEFAULT = "0";
    private static final String PREF_MEC_APP_NONCE = "mecAppNonce";
    private static final String PREF_MEC_DEVICE_NONCE = "mecDeviceNonce";
    private static final String PREF_MEC_DEVICE_REF_TOKEN = "mecDeviceRegToken";
    private static final String PREF_MEC_DEVICE_REF_TOKEN_EXPIRATION = "mecDeviceRegTokenExpiration";
    private static final String PREF_MEC_EXPRESS_CHECKOUT_USERNAME = "mecExpressCheckoutUserName";
    private static final String PREF_MEC_MS_UUID = "mecMsUuid";
    private static final String PREF_MEC_PARTNER_CONTINGENCY = "mecPartnerContingency";
    private static final String PREF_NOTIFICATIONS_BUYING_TONE = "notification_buying_tone";
    private static final String PREF_NOTIFICATIONS_FLASH_LED = "notifications_flash_led";
    private static final boolean PREF_NOTIFICATIONS_FLASH_LED_DEFAULT = false;
    private static final String PREF_NOTIFICATIONS_GENERAL_TONE = "notifications_general_tone";
    private static final String PREF_NOTIFICATIONS_ITEM_SOLD_TONE = "notifications_item_sold_tone";
    public static final String PREF_NOTIFICATIONS_LAST_SERVICE_FAILURE = "notifications_timestamp_of_last_service_failure";
    private static final String PREF_NOTIFICATIONS_PLAY_SOUND = "notifications_play_sound";
    private static final boolean PREF_NOTIFICATIONS_PLAY_SOUND_DEFAULT = true;
    private static final String PREF_NOTIFICATIONS_SAVED_SEARCH_TONE = "notifications_saved_search_tone";
    private static final String PREF_NOTIFICATIONS_VIBRATE = "notifications_vibrate";
    private static final boolean PREF_NOTIFICATIONS_VIBRATE_DEFAULT = true;
    private static final String PREF_NOTIFIED_LIST = "NotifiedList";
    public static final String PREF_PAYPAL_ACCOUNT_STATUS = "payPalAccountStatus";
    public static final String PREF_PAYPAL_CHECKOUT_AUTH_TOKEN = "checkoutPayPalAuthToken";
    public static final String PREF_PAYPAL_CHECKOUT_FUNDING_SOURCE_ID = "checkoutPayPalFundingSourceId";
    public static final String PREF_PAYPAL_CHECKOUT_SESSION_ID = "checkoutPayPalSessionId";
    public static final String PREF_PAYPAL_CHECKOUT_VISITOR_ID = "checkoutPayPalVisitorId";
    public static final String PREF_RATEAPP_BANNER_START = "rateAppBannerStart";
    public static final String PREF_RATEAPP_BIN_ACTION = "rateAppBinAction";
    public static final String PREF_RATEAPP_INSTALL_DATE = "rateAppInstallDate";
    public static final String PREF_RATEAPP_LAUNCH_COUNT = "rateAppLaunchCount";
    public static final String PREF_RATEAPP_LIST_ACTION = "rateAppListAction";
    public static final String PREF_RATEAPP_USER_SAID_NO = "rateAppUserSaidNo";
    public static final String PREF_RATEAPP_USER_SAID_YES = "rateAppUserSaidYes";
    public static final String PREF_RATE_APP_SKIP_COUNT_NAME = "rateAppSkipCount";
    private static final String PREF_SEARCH_CATEGORY = "PrefSearchCategory";
    private static final String PREF_SEARCH_COUNTRY_AND_POSTAL_CODE = "searchPostalCode";
    public static final String PREF_SEARCH_OTHER_COUNTRIES = "PrefSearchOtherCountries";
    private static final String PREF_SEARCH_SORTING_TYPE = "PrefSortingType";
    private static final String PREF_SEARCH_SORTING_TYPE_DEFAULT = "-1";
    private static final String PREF_SEARCH_VIEW = "PrefSearchResultView";
    private static final String PREF_SHIPPING_COST_COUNTRY = "shipping_cost_country";
    private static final String PREF_SHIPPING_COST_COUNTRY_DEFAULT = null;
    private static final String PREF_SHIPPING_COST_POSTAL_CODE = "shipping_cost_postal_code";
    private static final String PREF_SHIPPING_COST_POSTAL_CODE_DEFAULT = null;
    private static final String PREF_SHIP_TO_COUNTRY_AND_POSTAL_CODE = "shipToPostalCode";
    public static final String PREF_SHOW_IMPROVE_LOCATION_DIALOG = "showImproveLocationDialog";
    public static final String PREF_SIGNIN_PASSWORD_SHOW = "showSigninPassword";
    public static final String PREF_USER_BUSINESS_TYPE = "sellerBusinessType";
    private static final String PREF_USER_NAME_HISTORY = "PrefUserNameHistory";
    public static final String SYNC_AUTH_CHANGED = "syncAuthChanged";
    public static final String SYNC_COUNTRY_CHANGED = "syncCountryChanged";
    private static final String TRACKING_LIST = "tracking_list";
    public static final String USER_IS_PPA = "user_is_ppa";
    public static final String USER_NAME = "user_name";
    public static final SecretKeySpec USER_TOKEN_ENCRYPTION_KEY = new SecretKeySpec(USER_TOKEN_ENCRYPTION_KEY_BYTES, "AES");
    private static final byte USER_TOKEN_ENCRYPTION_KEY_BYTES[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
        10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 
        20, 21, 22, 23
    };
    public final boolean appPreviouslyExisted;
    private final SharedPreferences pref;
    private final String prefsName;
    private String userName;

    public Preferences(Context context, boolean flag)
    {
        userName = null;
        StringBuilder stringbuilder = (new StringBuilder()).append("com.ebay.dataservice");
        String s;
        if (flag)
        {
            s = ".qa.prefs";
        } else
        {
            s = ".prefs";
        }
        prefsName = stringbuilder.append(s).toString();
        pref = context.getSharedPreferences(prefsName, 0);
        if (!pref.getAll().isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        appPreviouslyExisted = flag;
    }

    public Preferences(SharedPreferences sharedpreferences)
    {
        userName = null;
        prefsName = "com.ebay.dataservice.prefs";
        pref = sharedpreferences;
        appPreviouslyExisted = false;
    }

    private void clearPrefString(String s)
    {
        android.content.SharedPreferences.Editor editor = pref.edit();
        editor.putString(s, "");
        SharedPreferencesCompat.apply(editor);
    }

    private static final String decrypt(String s)
    {
        s = EbayUtil.decrypt(Base64.decode(s, 0), USER_TOKEN_ENCRYPTION_KEY);
        return new String(s, 0, s.length);
    }

    private final String encrypt(String s)
    {
        return Base64.encodeToString(EbayUtil.encrypt(s.getBytes(), USER_TOKEN_ENCRYPTION_KEY), 2);
    }

    private String[] getPrefStrings(String s)
    {
        return EbayUtil.listToArray(EbayUtil.unflattenString(pref.getString(s, "")));
    }

    private String qualifiedPrefKey(String s)
    {
        return qualifiedPrefKey(s, getCurrentUser());
    }

    private String qualifiedPrefKey(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(prefsName).append('.');
        if (s1.length() != 0)
        {
            stringbuilder.append(s1);
            stringbuilder.append(".");
        }
        stringbuilder.append(s);
        return stringbuilder.toString();
    }

    private HashMap recoverKnownUsers()
    {
        HashMap hashmap = null;
        String as[] = pref.getString(unqualified_pref_key("known_users"), "").split("~");
        for (int i = 0; i < as.length;)
        {
            HashMap hashmap1 = hashmap;
            if (as[i].length() > 0)
            {
                String as1[] = as[i].split(",");
                hashmap1 = hashmap;
                if (hashmap == null)
                {
                    hashmap1 = new HashMap();
                }
                hashmap1.put(as1[0], as1[1]);
            }
            i++;
            hashmap = hashmap1;
        }

        return hashmap;
    }

    private void saveKnownUsers(HashMap hashmap)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        Object obj;
        for (hashmap = hashmap.entrySet().iterator(); hashmap.hasNext(); stringbuilder.append(s).append(',').append(((String) (obj))).append('~'))
        {
            obj = (java.util.Map.Entry)hashmap.next();
            s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = (String)((java.util.Map.Entry) (obj)).getValue();
        }

        hashmap = pref.edit();
        hashmap.putString(unqualified_pref_key("known_users"), stringbuilder.toString());
        SharedPreferencesCompat.apply(hashmap);
    }

    private void setAuthentication(Authentication authentication)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1;
        android.content.SharedPreferences.Editor editor;
        String s2;
        obj1 = unqualified_pref_key("user_name");
        s2 = unqualified_pref_key("iaf_token");
        editor = pref.edit();
        if (authentication == null) goto _L2; else goto _L1
_L1:
        String s1;
        s1 = authentication.user;
        String s = encrypt(authentication.iafToken);
        editor.putString(((String) (obj1)), s1);
        editor.putString(s2, s);
        obj1 = recoverKnownUsers();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (((HashMap) (obj1)).containsKey(s1))
        {
            break MISSING_BLOCK_LABEL_118;
        }
        Object obj;
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj = new HashMap();
        ((HashMap) (obj)).put(s1, s1);
        saveKnownUsers(((HashMap) (obj)));
        MimsUtil.addIdentity(MimsUtil.PROVIDER_ID_MARKETPLACE, s1);
        obj = s1;
_L5:
        if (!editor.commit()) goto _L4; else goto _L3
_L3:
        if (authentication != null)
        {
            s1 = ((String) (obj));
        } else
        {
            s1 = "";
        }
        userName = s1;
        DeviceConfiguration.getNoSync().setUser(((String) (obj)));
        if (authentication == null)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        authentication = authentication.iafToken;
_L6:
        ContentSyncManager.notifyUpdate(authentication, "syncAuthChanged");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        obj = null;
        editor.remove(((String) (obj1)));
        editor.remove(s2);
        MimsUtil.initializeMimsProviders();
          goto _L5
        authentication;
        throw authentication;
        authentication = null;
          goto _L6
    }

    private String unqualified_pref_key(String s)
    {
        return (new StringBuilder(prefsName)).append('.').append(s).toString();
    }

    public final void addPrefString(String s, String s1)
    {
        Object obj = EbayUtil.unflattenString(pref.getString(s, ""));
        if (((List) (obj)).contains(s1))
        {
            ((List) (obj)).remove(s1);
        }
        ((List) (obj)).add(0, s1);
        s1 = EbayUtil.flattenString(((List) (obj)));
        obj = pref.edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString(s, s1);
        SharedPreferencesCompat.apply(((android.content.SharedPreferences.Editor) (obj)));
    }

    public void addPrefStringsUserNameHistory(String s)
    {
        addUnqualifiedPrefString("PrefUserNameHistory", s);
    }

    public void addQualifiedPrefString(String s, String s1)
    {
        addPrefString(qualifiedPrefKey(s), s1);
    }

    protected void addUnqualifiedPrefString(String s, String s1)
    {
        addPrefString(unqualified_pref_key(s), s1);
    }

    final void clearCurrentCountry()
    {
        android.content.SharedPreferences.Editor editor = pref.edit();
        editor.remove("currentEbayCountry");
        editor.commit();
        DeviceConfiguration.getNoSync().setCountry(null);
    }

    public void clearMecExpressCheckout()
    {
        removeUserPref("mecExpressCheckoutUserName");
    }

    public void clearMecSettings()
    {
        removeUserPref("mecAppNonce");
        removeUserPref("mecDeviceNonce");
        removeUserPref("mecDeviceRegToken");
        removeUserPref("mecDeviceRegTokenExpiration");
        removeUserPref("mecExpressCheckoutUserName");
    }

    public void clearPayPalCheckoutSettings()
    {
        removeUserPref("checkoutPayPalAuthToken");
        removeUserPref("checkoutPayPalSessionId");
        removeUserPref("checkoutPayPalVisitorId");
        removeUserPref("checkoutPayPalFundingSourceId");
        MimsUtil.removeIdentity(MimsUtil.PROVIDER_ID_PAYPAL, null);
    }

    public final void clearPostalCode()
    {
        removeGlobalPref("shipToPostalCode");
        removeGlobalPref("searchPostalCode");
    }

    public void clearQualifiedPrefString(String s)
    {
        clearPrefString(qualifiedPrefKey(s));
    }

    protected void clearUnqualifiedPrefString(String s)
    {
        clearPrefString(unqualified_pref_key(s));
    }

    public final boolean containsUserPref(String s)
    {
        s = qualifiedPrefKey(s);
        return pref.contains(s);
    }

    public String getAssetPath(String s)
    {
        Object obj = getCurrentCountry();
        if (obj == null)
        {
            return null;
        }
        if (((EbayCountry) (obj)).isSite())
        {
            obj = ((EbayCountry) (obj)).site.idString;
        } else
        {
            obj = "GBH";
        }
        return (new StringBuilder()).append(((String) (obj))).append('/').append(s).toString();
    }

    public final Authentication getAuthentication()
    {
        this;
        JVM INSTR monitorenter ;
        String s2;
        String s3;
        String s1 = unqualified_pref_key("user_name");
        String s = unqualified_pref_key("iaf_token");
        s2 = pref.getString(s1, null);
        s3 = pref.getString(s, null);
        Authentication authentication;
        Object obj1;
        obj1 = null;
        authentication = obj1;
        boolean flag;
        if (TextUtils.isEmpty(s2))
        {
            break MISSING_BLOCK_LABEL_81;
        }
        flag = TextUtils.isEmpty(s3);
        authentication = obj1;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        authentication = new Authentication(s2, decrypt(s3));
_L2:
        this;
        JVM INSTR monitorexit ;
        return authentication;
        Object obj;
        obj;
        Log.e("Preferences", "Exception decrypting user token", ((Throwable) (obj)));
        obj = obj1;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    public String getCaSecurityToken()
    {
        return new String(Base64.decode(getUserPref("Pref_CA_SecurityToken", ""), 0));
    }

    public long getCaSecurityTokenExpiration()
    {
        return Long.parseLong(getUserPref("Pref_CA_SecurityTokenExpiration", "0"));
    }

    public EbayCguid getCguid(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (EbayCguidGetter.debugLogger.isLoggable)
        {
            FwLog.logMethod(EbayCguidGetter.debugLogger, new Object[0]);
        }
          goto _L1
_L5:
        Object obj;
        String s;
        String s1;
        String s2;
        s1 = pref.getString(s, "");
        s2 = pref.getString(((String) (obj)), "");
        s = null;
        obj = s;
        if (TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        obj = s;
        if (!TextUtils.isEmpty(s2))
        {
            obj = new EbayCguid(s1, s2);
        }
        this;
        JVM INSTR monitorexit ;
        return ((EbayCguid) (obj));
_L3:
        s = "coreCguidGuidUnlinked";
        obj = "coreCguidExpiresUnlinked";
        continue; /* Loop/switch isn't completed */
        obj;
        throw obj;
_L1:
        if (!flag) goto _L3; else goto _L2
_L2:
        s = "coreCguidGuid";
        obj = "coreCguidExpires";
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean getCountryAutoDetected()
    {
        return getGlobalPref("autodetectCountry", true);
    }

    public final EbayCountry getCurrentCountry()
    {
        EbayCountry ebaycountry1 = getCurrentCountryIfSet();
        EbayCountry ebaycountry = ebaycountry1;
        if (ebaycountry1 == null)
        {
            ebaycountry = EbayCountryManager.detectCountry();
        }
        return ebaycountry;
    }

    public final EbayCountry getCurrentCountryIfSet()
    {
        return EbayCountry.deserialize(pref.getString("currentEbayCountry", null));
    }

    public final EbaySite getCurrentSite()
    {
        return getCurrentCountry().site;
    }

    public final String getCurrentUser()
    {
        if (userName == null)
        {
            Object obj = getAuthentication();
            if (obj != null)
            {
                obj = ((Authentication) (obj)).user;
            } else
            {
                obj = "";
            }
            userName = ((String) (obj));
        }
        return userName;
    }

    public boolean getDisplayUploadNotificationAlert()
    {
        return getUserPref("displayUploadNotificationInfo", true);
    }

    public String getEulaPath()
    {
        return getAssetPath("eula.html");
    }

    public String getEulaUrl()
    {
        return (new StringBuilder()).append("file:///android_asset/").append(getAssetPath("eula.html")).toString();
    }

    public final int getGlobalPref(String s, int i)
    {
        return pref.getInt(unqualified_pref_key(s), i);
    }

    public final String getGlobalPref(String s, String s1)
    {
        return pref.getString(unqualified_pref_key(s), s1);
    }

    public final boolean getGlobalPref(String s, boolean flag)
    {
        return pref.getBoolean(unqualified_pref_key(s), flag);
    }

    public int getLastHomeChannel()
    {
        return getGlobalPref("homeLastChannelIndex", 0x7fffffff);
    }

    public String getLicenseUrl()
    {
        return "file:///android_asset/license.html";
    }

    public String getMecAppNonce()
    {
        return getUserPref("mecAppNonce", ((String) (null)));
    }

    public String getMecDeviceNonce()
    {
        return getUserPref("mecDeviceNonce", ((String) (null)));
    }

    public String getMecDeviceReferenceToken()
    {
        return getUserPref("mecDeviceRegToken", ((String) (null)));
    }

    public Long getMecDeviceReferenceTokenExpiration()
    {
        Long long1 = null;
        String s = getUserPref("mecDeviceRegTokenExpiration", ((String) (null)));
        if (s != null)
        {
            long1 = Long.valueOf(Long.parseLong(s));
        }
        return long1;
    }

    public String getMecExpressCheckoutUserName()
    {
        return getUserPref("mecExpressCheckoutUserName", ((String) (null)));
    }

    public String getMecMsUuid()
    {
        return getUserPref("mecMsUuid", ((String) (null)));
    }

    public String getMecPartnerContingency()
    {
        return getUserPref("mecPartnerContingency", ((String) (null)));
    }

    public String getNotificationsBuyingDefaultTone()
    {
        return "android.resource://com.ebay.mobile/2131099650";
    }

    public String getNotificationsBuyingTone()
    {
        return getUserPref("notification_buying_tone", getNotificationsBuyingDefaultTone());
    }

    public String getNotificationsGeneralDefaultTone()
    {
        return "android.resource://com.ebay.mobile/2131099650";
    }

    public String getNotificationsGeneralTone()
    {
        return getUserPref("notifications_general_tone", getNotificationsGeneralDefaultTone());
    }

    public String getNotificationsSavedSearchDefaultTone()
    {
        return "android.resource://com.ebay.mobile/2131099652";
    }

    public String getNotificationsSavedSearchTone()
    {
        return getUserPref("notifications_saved_search_tone", getNotificationsSavedSearchDefaultTone());
    }

    public String getNotificationsSellingDefaultTone()
    {
        return "android.resource://com.ebay.mobile/2131099651";
    }

    public String getNotificationsSellingTone()
    {
        return getUserPref("notifications_item_sold_tone", getNotificationsSellingDefaultTone());
    }

    public String getPayPalAccountStatus()
    {
        return getUserPref("payPalAccountStatus", "");
    }

    public String getPayPalCheckoutAuthToken()
    {
        return getUserPref("checkoutPayPalAuthToken", ((String) (null)));
    }

    public String getPayPalCheckoutFundingSourceId()
    {
        return getUserPref("checkoutPayPalFundingSourceId", ((String) (null)));
    }

    public String getPayPalCheckoutSessionId()
    {
        return getUserPref("checkoutPayPalSessionId", ((String) (null)));
    }

    public String getPayPalCheckoutVisitorId()
    {
        return getUserPref("checkoutPayPalVisitorId", ((String) (null)));
    }

    public final PostalCodeSpecification getPostalCode()
    {
        PostalCodeSpecification postalcodespecification = null;
        String s = getUserPref("searchPostalCode", ((String) (null)));
        String s1 = getGlobalPref("shipToPostalCode", ((String) (null)));
        if ((s != null || s1 != null) && s != null && !s.equals(s1))
        {
            setGlobalPref(s, "shipToPostalCode");
        }
        if (!TextUtils.isEmpty(s))
        {
            postalcodespecification = new PostalCodeSpecification(s);
        }
        return postalcodespecification;
    }

    public final SharedPreferences getPref()
    {
        return pref;
    }

    public boolean getPrefCompletedItems()
    {
        return Boolean.parseBoolean(getUserPref("CompletedItems", "false"));
    }

    public boolean getPrefHotSearchEnable()
    {
        return Boolean.parseBoolean(getUserPref("enable_hot_items", "false"));
    }

    public int getPrefSearchView(int i)
    {
        return getUserPref("PrefSearchResultView", i);
    }

    public String getPrefStringAuctionTypeId()
    {
        return getUserPref("PrefAuctionType", "-1");
    }

    public String getPrefStringEndingWarnTime()
    {
        return getUserPref("PrefWarnTime", "10");
    }

    public String getPrefStringHighPrice()
    {
        return getUserPref("PrefHiPrice", "");
    }

    public String getPrefStringLowPrice()
    {
        return getUserPref("PrefLoPrice", "");
    }

    public String getPrefStringMaximumDistance()
    {
        return getUserPref("PrefMaximumDistance", "0");
    }

    public String getPrefStringSearchCategorydId()
    {
        return getUserPref("PrefSearchCategory", "-1");
    }

    public String getPrefStringSearchSortSpecificationId()
    {
        return getUserPref("PrefSortingType", "-1");
    }

    public String[] getPrefStringsUserNameHistory()
    {
        return getUnqualifiedPrefStrings("PrefUserNameHistory");
    }

    public String[] getQualifiedPrefStrings(String s)
    {
        return getPrefStrings(qualifiedPrefKey(s));
    }

    public final PostalCodeSpecification getShipToPostalCode()
    {
        PostalCodeSpecification postalcodespecification = null;
        String s1 = getGlobalPref("shipToPostalCode", ((String) (null)));
        String s = s1;
        if (s1 == null)
        {
            String s2 = getUserPref("searchPostalCode", ((String) (null)));
            s = s2;
            if (s2 != null)
            {
                setGlobalPref(s2, "shipToPostalCode");
                s = s2;
            }
        }
        if (!TextUtils.isEmpty(s))
        {
            postalcodespecification = new PostalCodeSpecification(s);
        }
        return postalcodespecification;
    }

    public boolean getShowImproveLocationDialog()
    {
        return getUserPref("showImproveLocationDialog", true);
    }

    protected String[] getUnqualifiedPrefStrings(String s)
    {
        return getPrefStrings(unqualified_pref_key(s));
    }

    public boolean getUserIsPpa()
    {
        return getUserPref("user_is_ppa", false);
    }

    public final int getUserPref(String s, int i)
    {
        return pref.getInt(qualifiedPrefKey(s), i);
    }

    public final long getUserPref(String s, long l)
    {
        return pref.getLong(qualifiedPrefKey(s), l);
    }

    public final String getUserPref(String s, String s1)
    {
        return pref.getString(qualifiedPrefKey(s), s1);
    }

    public final boolean getUserPref(String s, boolean flag)
    {
        return pref.getBoolean(qualifiedPrefKey(s), flag);
    }

    public boolean hasPayPalAccount()
    {
        return !getPayPalAccountStatus().equals("");
    }

    public boolean isMecDeviceRefTokenExpired()
    {
        Long long1 = getMecDeviceReferenceTokenExpiration();
        return long1 == null || long1.longValue() < System.currentTimeMillis();
    }

    public boolean isMecExpressCheckoutEnabled()
    {
        return getMecExpressCheckoutUserName() != null;
    }

    public boolean isNotificationLedFlashEnabled()
    {
        return getUserPref("notifications_flash_led", false);
    }

    public boolean isNotificationSoundEnabled()
    {
        return getUserPref("notifications_play_sound", true);
    }

    public boolean isNotificationVibrationEnabled()
    {
        return getUserPref("notifications_vibrate", true);
    }

    public final boolean isSignedIn()
    {
        return getAuthentication() != null;
    }

    public boolean isTheSamsungCurse()
    {
        boolean flag = false;
        if (!pref.edit().commit())
        {
            flag = true;
        }
        return flag;
    }

    public String recoverCountry()
    {
        return getUserPref("shipping_cost_country", PREF_SHIPPING_COST_COUNTRY_DEFAULT);
    }

    public String recoverNotifiedList()
    {
        return getUserPref("NotifiedList", "");
    }

    public String recoverPostalCode()
    {
        return getUserPref("shipping_cost_postal_code", PREF_SHIPPING_COST_POSTAL_CODE_DEFAULT);
    }

    public String recoverTrackingList()
    {
        return getUserPref("tracking_list", "");
    }

    public final void removeGlobalPref(String s)
    {
        android.content.SharedPreferences.Editor editor = pref.edit();
        editor.remove(unqualified_pref_key(s));
        SharedPreferencesCompat.apply(editor);
    }

    public final void removeUserPref(String s)
    {
        s = qualifiedPrefKey(s);
        if (pref.contains(s))
        {
            android.content.SharedPreferences.Editor editor = pref.edit();
            editor.remove(s);
            SharedPreferencesCompat.apply(editor);
        }
    }

    public void saveCountry(String s)
    {
        setUserPref(s, "shipping_cost_country");
    }

    public void saveNotifiedList(String s)
    {
        setUserPref(s, "NotifiedList");
    }

    public void savePostalCode(String s)
    {
        setUserPref(s, "shipping_cost_postal_code");
    }

    protected void saveTrackingList(String s)
    {
        setUserPref(s, "tracking_list");
    }

    public void setCaSecurityToken(String s)
    {
        setUserPref(Base64.encodeToString(s.getBytes(), 2), "Pref_CA_SecurityToken");
    }

    public void setCaSecurityTokenExpiration(long l)
    {
        setUserPref(Long.toString(l), "Pref_CA_SecurityTokenExpiration");
    }

    public void setCguid(boolean flag, EbayCguid ebaycguid)
    {
        this;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor;
        if (EbayCguidGetter.debugLogger.isLoggable)
        {
            FwLog.logMethod(EbayCguidGetter.debugLogger, new Object[] {
                ebaycguid
            });
        }
        editor = pref.edit();
        String s;
        String s1;
        String s2;
        if (flag)
        {
            s1 = "coreCguidGuid";
            s = "coreCguidExpires";
        } else
        {
            s1 = "coreCguidGuidUnlinked";
            s = "coreCguidExpiresUnlinked";
        }
        if (ebaycguid == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        s2 = ebaycguid.toString();
        ebaycguid = ebaycguid.getExpirationDate();
        editor.putString(s1, s2);
        editor.putString(s, ebaycguid);
_L1:
        editor.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        editor.remove(s1);
        editor.remove(s);
          goto _L1
        ebaycguid;
        throw ebaycguid;
    }

    public void setCountryAutoDetected(boolean flag)
    {
        setGlobalPref(flag, "autodetectCountry");
    }

    final void setCurrentCountry(EbayCountry ebaycountry)
    {
        while (ebaycountry == null || ebaycountry.site == null || ebaycountry.equals(getCurrentCountryIfSet())) 
        {
            return;
        }
        android.content.SharedPreferences.Editor editor = pref.edit();
        editor.putString("currentEbayCountry", ebaycountry.serialize());
        editor.commit();
        DeviceConfiguration.getNoSync().setCountry(ebaycountry);
        EbayBroadcast.sendSiteChangedBroadcast(MyApp.getApp(), ebaycountry.site);
        EbayBroadcast.sendCountryChangedBroadcast(MyApp.getApp(), ebaycountry);
        ContentSyncManager.notifyUpdate(ebaycountry, "syncCountryChanged");
    }

    public void setDisplayUploadNotificationAlert(boolean flag)
    {
        setUserPref(flag, "displayUploadNotificationInfo");
    }

    public final void setGlobalPref(int i, String s)
    {
        android.content.SharedPreferences.Editor editor = pref.edit();
        editor.putInt(unqualified_pref_key(s), i);
        SharedPreferencesCompat.apply(editor);
    }

    public final void setGlobalPref(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = pref.edit();
        editor.putString(unqualified_pref_key(s1), s);
        SharedPreferencesCompat.apply(editor);
    }

    public final void setGlobalPref(boolean flag, String s)
    {
        android.content.SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(unqualified_pref_key(s), flag);
        SharedPreferencesCompat.apply(editor);
    }

    public void setLastHomeChannel(int i)
    {
        setGlobalPref(i, "homeLastChannelIndex");
    }

    public void setMecAppNonce(String s)
    {
        setUserPref(s, "mecAppNonce");
    }

    public void setMecDeviceNonce(String s)
    {
        setUserPref(s, "mecDeviceNonce");
    }

    public void setMecDeviceRefTokenExpiration(long l)
    {
        setUserPref(Long.toString(l), "mecDeviceRegTokenExpiration");
    }

    public void setMecDeviceReferenceToken(String s)
    {
        setUserPref(s, "mecDeviceRegToken");
    }

    public void setMecExpressCheckoutUserName(String s)
    {
        if (s != null)
        {
            setUserPref(s, "mecExpressCheckoutUserName");
        }
    }

    public void setMecMsUuid(String s)
    {
        setUserPref(s, "mecMsUuid");
    }

    public void setMecPartnerContingency(String s)
    {
        setUserPref(s, "mecPartnerContingency");
    }

    public void setNotificationLedFlashEnabled(Boolean boolean1)
    {
        setUserPref(boolean1.booleanValue(), "notifications_flash_led");
    }

    public void setNotificationsBuyingTone(Uri uri)
    {
        if (uri != null)
        {
            uri = uri.toString();
        } else
        {
            uri = "";
        }
        setUserPref(uri, "notification_buying_tone");
    }

    public void setNotificationsGeneralTone(Uri uri)
    {
        if (uri != null)
        {
            uri = uri.toString();
        } else
        {
            uri = "";
        }
        setUserPref(uri, "notifications_general_tone");
    }

    public void setNotificationsSavedSearchTone(Uri uri)
    {
        if (uri != null)
        {
            uri = uri.toString();
        } else
        {
            uri = "";
        }
        setUserPref(uri, "notifications_saved_search_tone");
    }

    public void setNotificationsSellingTone(Uri uri)
    {
        if (uri != null)
        {
            uri = uri.toString();
        } else
        {
            uri = "";
        }
        setUserPref(uri, "notifications_item_sold_tone");
    }

    public void setNotificationsSoundEnabled(Boolean boolean1)
    {
        setUserPref(boolean1.booleanValue(), "notifications_play_sound");
    }

    public void setNotificationsVibrationEnabled(Boolean boolean1)
    {
        setUserPref(boolean1.booleanValue(), "notifications_vibrate");
    }

    public void setPayPalAccountStatus(String s)
    {
        setUserPref(s, "payPalAccountStatus");
    }

    public void setPayPalCheckoutAuthToken(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            setUserPref(s, "checkoutPayPalAuthToken");
        }
    }

    public void setPayPalCheckoutFundingSourceId(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            setUserPref(s, "checkoutPayPalFundingSourceId");
        }
    }

    public void setPayPalCheckoutSessionId(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            setUserPref(s, "checkoutPayPalSessionId");
        }
    }

    public void setPayPalCheckoutVisitorId(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            setUserPref(s, "checkoutPayPalVisitorId");
        }
    }

    public final void setPostalCode(PostalCodeSpecification postalcodespecification)
    {
        setPostalCode(postalcodespecification, null);
    }

    public final void setPostalCode(PostalCodeSpecification postalcodespecification, String s)
    {
        if (postalcodespecification != null && !TextUtils.isEmpty(postalcodespecification.countryCode) && postalcodespecification.countryCode.indexOf('\n') == -1)
        {
            String s1 = postalcodespecification.toString();
            setGlobalPref(s1, "searchPostalCode");
            postalcodespecification = s;
            if (s == null)
            {
                postalcodespecification = getCurrentUser();
            }
            s = pref.edit();
            s.putString(qualifiedPrefKey("searchPostalCode", postalcodespecification), s1);
            SharedPreferencesCompat.apply(s);
            setGlobalPref(s1, "shipToPostalCode");
            return;
        } else
        {
            removeUserPref("searchPostalCode");
            return;
        }
    }

    public void setPrefCompletedItems(boolean flag)
    {
        setUserPref(Boolean.toString(flag), "CompletedItems");
    }

    public void setPrefHotSearchEnable(boolean flag)
    {
        setUserPref(Boolean.toString(flag), "enable_hot_items");
    }

    public void setPrefSearchView(int i)
    {
        setUserPref(i, "PrefSearchResultView");
    }

    public void setPrefStringAuctionType(String s)
    {
        setUserPref(s, "PrefAuctionType");
    }

    public void setPrefStringEndingWarnTime(String s)
    {
        setUserPref(s, "PrefWarnTime");
    }

    public void setPrefStringHighPrice(String s)
    {
        setUserPref(s, "PrefHiPrice");
    }

    public void setPrefStringLowPrice(String s)
    {
        setUserPref(s, "PrefLoPrice");
    }

    public void setPrefStringMaximumDistance(String s)
    {
        setUserPref(s, "PrefMaximumDistance");
    }

    public void setPrefStringSearchCategoryId(String s)
    {
        setUserPref(s, "PrefSearchCategory");
    }

    public void setPrefStringSearchSortType(String s)
    {
        setUserPref(s, "PrefSortingType");
    }

    public void setQualifiedPrefStrings(String s, List list)
    {
        list = EbayUtil.flattenString(list);
        android.content.SharedPreferences.Editor editor = pref.edit();
        editor.putString(qualifiedPrefKey(s), list);
        SharedPreferencesCompat.apply(editor);
    }

    public final void setShipToPostalCode(PostalCodeSpecification postalcodespecification)
    {
        if (postalcodespecification != null && !TextUtils.isEmpty(postalcodespecification.countryCode) && postalcodespecification.countryCode.indexOf('\n') == -1)
        {
            setGlobalPref(postalcodespecification.toString(), "shipToPostalCode");
        }
    }

    public void setShowImproveLocationDialog(boolean flag)
    {
        setUserPref(flag, "showImproveLocationDialog");
    }

    public void setUserIsPpa(boolean flag)
    {
        setUserPref(flag, "user_is_ppa");
    }

    public final void setUserPref(int i, String s)
    {
        android.content.SharedPreferences.Editor editor = pref.edit();
        editor.putInt(qualifiedPrefKey(s), i);
        SharedPreferencesCompat.apply(editor);
    }

    public final void setUserPref(long l, String s)
    {
        android.content.SharedPreferences.Editor editor = pref.edit();
        editor.putLong(qualifiedPrefKey(s), l);
        SharedPreferencesCompat.apply(editor);
    }

    public final void setUserPref(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = pref.edit();
        editor.putString(qualifiedPrefKey(s1), s);
        SharedPreferencesCompat.apply(editor);
    }

    public final void setUserPref(boolean flag, String s)
    {
        android.content.SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(qualifiedPrefKey(s), flag);
        SharedPreferencesCompat.apply(editor);
    }

    protected final Authentication signIn(String s, String s1)
    {
        s = signInHelper(s, s1);
        setAuthentication(s);
        return s;
    }

    public final Authentication signInHelper(String s, String s1)
    {
        Object obj = null;
        Authentication authentication = obj;
        if (!TextUtils.isEmpty(s))
        {
            authentication = obj;
            if (!TextUtils.isEmpty(s1))
            {
                authentication = new Authentication(s.toLowerCase(Locale.getDefault()), s1);
            }
        }
        return authentication;
    }

    public final void signOut()
    {
        clearPayPalCheckoutSettings();
        setCguid(true, null);
        setAuthentication(null);
    }

}
