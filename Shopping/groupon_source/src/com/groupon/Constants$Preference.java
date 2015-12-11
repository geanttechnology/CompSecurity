// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;


// Referenced classes of package com.groupon:
//            Constants

public static class 
{

    public static final String ACCESS_TOKEN = "accessToken";
    public static final String ACCESS_TOKEN_CONFIGURED = "accessTokenConfigured";
    public static final String ADD_PRECONFIGURED_VARIANT = "addPreconfiguredVariant";
    public static final String ADMIN_MENU_ENABLED = "adminMenuEnabled";
    public static final String ADVERTISING_ID = "advertisingId";
    public static final String ADVERTISING_ID_LAST_UPDATE = "advertisingIdLastUpdate";
    public static final String APP_LAUNCHED = "appLaunched";
    public static final String APP_STARTUP_COUNTER = "skipCounter";
    public static final String ATTRIBUTION_CID = "attributionCid";
    public static final String ATTRIBUTION_DEEPLINK_TIMESTAMP = "attributionDeepLinkTimestamp";
    public static final String ATTRIBUTION_DOWNLOAD_CID = "attributionDownloadCid";
    public static final String ATTRIBUTION_DOWNLOAD_ID = "attributionDownloadId";
    public static final String ATTRIBUTION_DOWNLOAD_URL = "attributionDownloadUrl";
    public static final String ATTRIBUTION_FIRST_LAUNCH_RECORDED = "attributionFirstLaunchRecorded";
    public static final String ATTRIBUTION_ID = "attributionId";
    public static final String ATTRIBUTION_LAST_APP_OPEN_TIMESTAMP = "attributionLastAppOpenTimestamp";
    public static final String ATTRIBUTION_TYPE = "attributionType";
    public static final String BASE_PAYMENT_URL_RU = "base_payment_url_ru";
    public static final String BASE_URL = "baseUrl";
    public static final String BASE_URL_AS = "base_url_as";
    public static final String BASE_URL_BOOKING_ENGINE = "base_url_booking_engine";
    public static final String BASE_URL_CL = "base_url_cl";
    public static final String BASE_URL_EU = "base_url_eu";
    public static final String BASE_URL_GDT = "base_url_gdt";
    public static final String BASE_URL_IN = "base_url_in";
    public static final String BASE_URL_JP = "base_url_jp";
    public static final String BASE_URL_MARKET_RATE = "base_url_market_rate";
    public static final String BASE_URL_RAPI = "baseRapiUrl";
    public static final String BASE_URL_RU = "base_url_ru";
    public static final String CATEGORIES_CONTAINER_VISIBILITY = "categoriesContainerVisibility";
    public static final String CATEGORY_FACET_GROUP_FILTERS = "categoryFacetGroupFilters";
    public static final String CATEGORY_ID = "categoryId";
    public static final String CATEGORY_MODE = "categoryMode";
    public static final String CATEGORY_NAME = "categoryName";
    public static final String CHECK_FOR_LEAKED_ACTIVITIES = "checkForLeakedActivities";
    public static final String CONSUMER_ID = "consumerId";
    public static final String COUNTRY_SELECTED = "countrySelected";
    public static final String CREDITS_AVAILABLE_AMOUNT = "amount";
    public static final String CREDITS_AVAILABLE_FORMATTED_AMOUNT = "formattedAmount";
    public static final String CURRENT_BILLING_RECORD_ID = "currentBillingRecordId";
    public static final String CUSTOM_FIELDS = "customFields";
    public static final String DEALTYPES = "dealTypes";
    public static final String DEAL_NOTIFICATION = "dealNotification";
    public static final String DEAL_TYPE_SUCCESS_TOOLTIP_COUNT = "dealTypeSuccessTooltipCount";
    public static final String DEBUG_LOGGING = "debugLogging";
    public static final String DEFAULT_PREFERENCE_FILE_NAME = "default";
    public static final String EAGERLY_APPLY_REWARD_POINTS = "eagerlyApplyRewardPoints";
    public static final String EMAIL = "email";
    public static final String EMAIL_PREFILL = "emailPrefill";
    public static final String ENABLE_POG_TEST_WEBVIEW = "enable_pog_test_webview";
    public static final String FACEBOOK_LOGIN_ENABLED = "facebookLoginEnabled";
    public static final String FIRST_NAME = "firstName";
    public static final String FIRST_TIME_USER = "first_time_user";
    public static final String FORCE_SHOW_ONBOARDING = "forceShowOnBoarding";
    public static final String FRESH_INSTALL = "freshInstall";
    public static final String FRESH_INSTALL_VERSION = "freshInstallVersion";
    public static final String G1_PUSH_TOKEN_UPLOADED = "g1PushTokenUploaded";
    public static final String GCM_APP_INFO = "gcmAppInfo";
    public static final String GCM_APP_VERSION = "gcmAppVersion";
    public static final String GCM_HAD_TOKEN = "gcmHadToken";
    public static final String GCM_REG_ID = "gcmRegId";
    public static final String GCM_TOKEN_UPLOADED = "gcmTokenUploaded";
    public static final String GCM_UPLOADED_TOKEN = "gcmUploadedToken";
    public static final String GENDER = "gender";
    public static final String GOOGLE_WALLET_SANDBOX_ENABLED = "googleWalletSandboxEnabled";
    public static final String HAS_LOGGED_IN_ATLEAST_ONCE = "hasLoggedInAtleastOnce";
    public static final String HAS_SEEN_COUPONS_INTRO_SCREEN = "hasSeenCouponsIntroScreen";
    public static final String HAS_SEEN_WIDGET_DIALOG = "hasSeenWidgetDialog";
    public static final String HIDE_PREVIOUSLY_SEEN_DEALS_FROM_NOTIFICATIONS = "hidePreviouslySeenDealsFromNotifications";
    public static final String INCLUDE_API_LOGS = "includeApiLogs";
    public static final String INSTALL_DATE = "InstallDate";
    public static final String IN_APP_MESSAGE_FORCE_UPDATE = "inAppMessageForceUpdate";
    public static final String IN_APP_MESSAGE_HISTORY = "inAppMessageHistory";
    public static final String IS_AUTO_REFUND_ENABLED = "isAutoRefundEnabled";
    public static final String IS_FEED_ENABLED = "isFeedEnabled";
    public static final String LAST_DEAL_SHORT_TITLE_NOTIFIED = "lastDealShortTitleNotified";
    public static final String LAST_NAME = "lastName";
    public static final String LAST_SUGGESTED_UPGRADE_ALERT_TIME = "lastSuggestedUpgradeAlertTime";
    public static final String LAST_VERSION = "lastVersion";
    public static final String LIMIT_AD_TRACKING = "limitAdTracking";
    public static final String LOCALIZED_MOBILE_APP_ENABLED_BY_USER = "localizedMobileApp";
    public static final String LOCALIZED_MOBILE_APP_NOTIFICATION_TIMER = "localiizedMobileAppNotificationTimer";
    public static final String LOCATION_CHANGED_INFO_JSON = "locationChangedInfoJson";
    public static final String LOCATION_CHANGED_IN_APP_MESSAGE_ID = "locationChangedInAppMessageId";
    public static final String LOCATION_CHANGED_NEEDS_TO_SHOW_DIALOG = "locationChangedNeedsToShowDialog";
    public static final String LOCATION_CHANGED_POSSIBLE_NEW_DIVISION = "locationChangedPossibleNewDivision";
    public static final String LOCATION_CHANGED_TIMER = "locationChangedTimer";
    public static final String LOGIN_SPLASH_TARGET = "skipTarget";
    public static final String NOTIFICATION_TIME = "notificationTime";
    public static final String NST_URL = "nst_url";
    public static final String ONBOARD_FACEBOOK = "onboardFacebook";
    public static final String OPT_IN_VIA_WIDGET = "optInViaWidget";
    public static final String PREFERRED_SHIPPING_ADDR1 = "preferredShippingAddr1";
    public static final String PREFERRED_SHIPPING_ADDR2 = "preferredShippingAddr2";
    public static final String PREFERRED_SHIPPING_CITY = "preferredShippingCity";
    public static final String PREFERRED_SHIPPING_COUNTRY = "preferredShippingCountry";
    public static final String PREFERRED_SHIPPING_LOCATION_ID = "preferredShippingLocationId";
    public static final String PREFERRED_SHIPPING_NAME = "preferredShippingName";
    public static final String PREFERRED_SHIPPING_POSTAL_CODE = "preferredShippingPostalCode";
    public static final String PREFERRED_SHIPPING_STATE = "preferredShippingState";
    public static final String PREFILLED_ZIPCODE = "prefilledZipcode";
    public static final String PREF_KEY_ADVANCED = "pref_key_advanced";
    public static final String PREF_KEY_CORE_SERVICES_TIMESTAMP = "coreServicesTimestamp";
    public static final String PREF_KEY_DIVISION_SERVICE = "DivisionsService";
    public static final String PREF_KEY_DIVISION_SERVICE_V2 = "DivisionServiceV2";
    public static final String PREF_KEY_GENERAL = "pref_key_general";
    public static final String PREF_KEY_REPORT_A_BUG = "pref_key_report_a_bug";
    public static final String PREF_KEY_SETTINGS_SCREEN_ROOT = "pref_screen_root";
    public static final String PRIMARY_EMAIL_ADDRESS = "primaryEmailAddress";
    public static final String PROXIMITY_ACTIVITY_POLL_TIME = "proximityActivityPollTime";
    public static final String PROXIMITY_ENDPOINT_MUTE_UNTIL = "proximityEndpointMuteUntil";
    public static final String PROXIMITY_ENDPOINT_MUTE_UNTIL_IN_LONG = "proximityEndpointMuteUntilInLong";
    public static final String PROXIMITY_GEOFENCE_SET_TIME = "proximityGeofenceSetTime";
    public static final String PROXIMITY_LOCATION_INFO_JSON = "proximityLocationInfoJson";
    public static final String PROXIMITY_NOTIFICATION_ENABLED_BY_USER = "proximityNotificationEnabled";
    public static final String PROXIMITY_NOTIFICATION_SEEN_BY_USER = "proximityNotificationSeenByUser";
    public static final String PROXY_CLIENT_HEADER = "Odo-Client-UUID";
    public static final String PROXY_CLIENT_UUID = "proxyClientUUID";
    public static final String PROXY_IP = "proxyIp";
    public static final String PROXY_PORT = "proxyPort";
    public static final String PULL_NOTIFICATION_DOWNLOADED = "pullNotificationDownloaded";
    public static final String RECENTLY_SEARCHED_TERMS = "recentlySearchedTerms_";
    public static final String RECENTLY_SEARCHED_TERMS_CATEGORIES = "recentlySearchedTermsCategories_";
    public static final String RECENTLY_SEARCHED_TERMS_COUNT = "recentlySearchedTermsCount";
    public static final String REFERRAL_CODE = "referralCode";
    public static final String REPORT_A_BUG_EMAIL = "reportABugEmail";
    public static final String SELECTED_SHIPPING_ADDRESS = "selectedShippingAddress";
    public static final String SHIPPING_INFO_INVALID = "shippingInfoInvalid";
    public static final String SHOW_ACTIVITY_REFRESH_MENU_ITEM = "showActivityRefreshMenuItem";
    public static final String SHOW_ONBOARDING = "showOnBoarding";
    public static final String SHOW_TRACKING_INFO = "showTrackingInfo";
    public static final String SILENT_NOTIFICATIONS = "silentNotifications";
    public static final String SUBCATEGORY_ID = "subcategoryId";
    public static final String USER_ID = "userId";
    public static final String VALID_BILLING_RECORD_COUNT_AT_LOGIN = "billingRecordCountAtLogin";
    public static final String VIEW_LOGS = "viewLogs";
    public static final String WEB_BASE_URL_GDT = "web_base_url_gdt";
    public static final String WIDGET_DATETIME = "widgetDatetime";
    public static final String WIDGET_HAS_BEEN_INSTALLED = "widgetHasBeenInstalled";
    public static final String WIDGET_PREVIEW = "widgetPreview";
    public static final String WIDGET_PREVIEW_FALSE = "false";
    public static final String WIDGET_PREVIEW_TRUE = "true";
    public static final String WIDGET_PREVIEW_UNDEFINED = "";
    public static final String WIDGET_TYPE = "widgetType";
    public static final String WIDGET_TYPE_DEFAULT = "default";
    public static final String WIDGET_TYPE_GOODS = "goods";
    public static final String WIDGET_TYPE_NONE = "none";
    public static final String WIDGET_TYPE_SMALL_DEAL_CARD_LIST = "smallDealCardList";
    public static final String ZIP_CODE = "zip_code";

    private ()
    {
    }
}
