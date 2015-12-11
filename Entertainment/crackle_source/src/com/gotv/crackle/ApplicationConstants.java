// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.os.Build;

// Referenced classes of package com.gotv.crackle:
//            Application

public class ApplicationConstants
{

    public static final String ADD_TO_QUEUE = "http://%s/queue/%s/add/member/%s/%s/%s?format=%s";
    public static final String ANDROID_HANDSET_3G_STREAM = "AndroidHandset_3G.m3u8";
    public static final String ANDROID_HANDSET_WIFI_STREAM = "AndroidHandset_Wifi.m3u8";
    public static final String ANDROID_TABLET_3G_STREAM = "AndroidTablet_3G.m3u8";
    public static final String ANDROID_TABLET_WIFI_STREAM = "AndroidTablet_Wifi.m3u8";
    private static final String BASE_URL_COUSY_US_PROD = "amazon-api-us.crackle.com/Service.svc";
    private static final String BASE_URL_FANHATTAN_US_PROD = "fanhattan-api-us.crackle.com/Service.svc";
    private static final String BASE_URL_US_PROD = "android-api-us.crackle.com/Service.svc";
    private static final String BASE_URL_US_STAGING = "staging-api-us.crackle.com/Service.svc";
    public static final String BROWSE_API_URL = "http://%s/browse/%s/%s/%s/%s/%s?format=%s";
    public static final String CATEGORY_MOVIES = "movies";
    public static final String CATEGORY_SHOWS = "shows";
    public static final String CATEGORY_WATCHLIST = "watchlists";
    public static final String CHANNEL_DETAILS_URL = "http://%s/details/channel/%s/%s?format=%s";
    public static final String CHANNEL_FOLDER_URL = "http://%s/channel/%s/folders/%s?format=%s";
    public static final String CHANNEL_TYPE_COLLECTIONS = "586";
    public static final String CHANNEL_TYPE_EPISODE = "Episode";
    public static final String CHANNEL_TYPE_MOVIES = "82";
    public static final String CHANNEL_TYPE_ORIGINALS = "46";
    public static final String CHANNEL_TYPE_TELEVISION = "114";
    public static final String CHROMECAST_STREAM = "AppleTV.m3u8";
    public static final String CLEAR_QUEUE = "http://%s/queue/%s/empty/member/%s?format=%s";
    public static final String CONVIVA_PRODUCTION_KEY = "d8cfa9b855476b04fa2d1dfa7c9154c09b55f9ca";
    public static final boolean CONVIVA_STAGING = false;
    public static final String CONVIVA_STAGING_KEY = "21bc6e9159598658d20e920b00605bc7ce93eb78";
    public static final String COUSY_ANDROID_STREAM = "PS3_Trilithium.m3u8";
    public static final String CREATE_ACCOUNT_URL = "https://%s/register?format=%s";
    public static final String CUSTOM_USER_AGENT_STRING;
    public static final boolean DEBUG_LOGGING = false;
    public static final String DRM_PORTAL_NAME = "crackle";
    public static final String DRM_SERVER_PRODUCTION = "http://www.crackle.com/widevine/widevineproxy.ashx";
    public static final String DRM_SERVER_STAGING = "http://54.215.16.71/cgi-bin/GetEMMs_prod.cgi";
    public static final boolean DRM_USE_STAGING = false;
    public static final String EXPIRES_DATE_FORMAT = "MMM d, yyyy";
    public static final String EXPIRES_DATE_FORMAT_LATAM = "d MMM, yyyy";
    public static final String EXTRA_DEEP_LINK_KEY_CHANNEL_ID = "chId";
    public static final String EXTRA_DEEP_LINK_KEY_MEDIA_ID = "mId";
    public static final int FEATURED_LIST_NUMBER_OF_ITEMS = 50;
    public static final String FEATURED_LIST_URL = "http://%s/featured/%s/%s/%s/%d?format=%s";
    public static final String FILTER_URL = "http://%s/browse/%s/filters?format=%s";
    public static final boolean FORCE_UPDATE_ENABLED = true;
    public static final String FORESEE_APP_KEY = "Zt4BsqwzhiMSoYl2UxrhfQ==";
    public static final String FORESEE_SURVEY_ID = "android_app";
    public static final String FORGOT_PASSWORD_URL = "https://%s/password/%s?format=json";
    public static final String GENRES_URL = "http://%s/genres/%s/primary/%s?format=%s";
    public static final String GET_ALLOWED_LOCATIONS_URL = (new StringBuilder()).append("https://").append(getBaseURL()).append("/appconfig?format=%s").toString();
    public static final String GET_FACEBOOK_USER_ACCOUNT_DETAILS = "https://%s/facebookuser/%s/%s?format=%s";
    public static final String GET_LOCATION_URL = (new StringBuilder()).append("http://").append(getBaseURL()).append("/geo/country?format=%s").toString();
    public static final String GET_PLAY_PROGRESS_BULK = "http://%s/pauseresume/list/member/%s/%s?format=json";
    public static final String GET_QUEUE = "http://%s/queue/%s/list/member/%s/%s?format=%s";
    public static final String GET_WATCHLISTS = "http://%s/watchlist/%s/%s?format=%s";
    public static final String HASOFFERS_ADVERTISER_ID = "8696";
    public static final String HASOFFERS_CONVERSION_KEY = "12f35680326fede605db9084a28b0b56";
    public static final String HASOFFERS_FIRST_VIDEO_COMPLETE = "75completion";
    public static final String HASOFFERS_REGISTRATION = "registration";
    public static final int HOME_TAB_ID = 0;
    private static final String HTTP = "http://";
    private static final String HTTPS = "https://";
    public static final String INMOBI_APP_ID = "02781975-1a4e-4a4f-9687-6ba9bad5967d";
    public static final String JSON_DATE_FORMAT = "M/d/yyyy";
    public static final String JSON_DATE_FORMAT_WITH_TIME = "M/d/yyyy h:mm:ss a";
    public static final int MAX_IMAGE_CACHE = 20;
    public static final String MEDIA_DETAILS_URL = "http://%s/details/media/%s/%s?format=%s";
    public static final String MILLENNNIAL_GOAL_ID = "30976";
    public static final int MOVIES_TAB_ID = 1;
    public static final String NIELSEN_APPID = "P15403C25-0FDA-4473-8700-6848752FF0F4";
    public static final String NIELSEN_SFCODE = "US";
    public static final String OMNITURE_TRACKING_DEV_ACCOUNT = "crackledev";
    public static final String OMNITURE_TRACKING_DEV_ACCOUNT_LATAM = "cracklestaginglatam";
    public static final String OMNITURE_TRACKING_PROD_ACCOUNT = "crackleprod";
    public static final String OMNITURE_TRACKING_PROD_ACCOUNT_LATAM = "crackleprodlatam";
    public static final String PHONE_VENDOR_ID = "24";
    public static final String PHONE_VENDOR_KEY = "QWXRHTCJPOGKBJKO";
    public static final int POPULAR_LIST_NUMBER_OF_ITEMS = 50;
    public static final String POPULAR_LIST_URL = "http://%s/popular/%s/%s/%s/%d?format=%s";
    public static final int RECENT_LIST_NUMBER_OF_ITEMS = 50;
    public static final String RECENT_LIST_URL = "http://%s/recent/%s/%s/%s/%d?format=%s";
    public static final String REMOVE_FROM_QUEUE = "http://%s/queue/%s/remove/member/%s/%s/%s?format=%s";
    public static final String ROOT_CHANNEL_EXTRA = "ROOT_CHANNEL";
    public static final String SEARCH_URL = "http://%s/search/media/%s/%s?format=%s";
    public static final String SERVICE = "/Service.svc";
    public static final String SESSIONM_ADD_TO_QUEUE = "addToMyQueue";
    public static final String SESSIONM_COMPLETE_MOVIE = "completeMovie";
    public static final String SESSIONM_COMPLETE_SHOW = "completeShow";
    public static final String SESSIONM_DAILY_TAP_IN = "Launched Crackle";
    public static final String SESSIONM_KEY = "f9af3a3731f371a3b2b88a2a61f71521aee8a1b1";
    public static final String SESSIONM_REGISTER = "register";
    public static final String SESSIONM_SHARING = "share";
    public static final String SESSIONM_VIEW_MOVIE = "watchedMovie";
    public static final String SESSIONM_VIEW_SHOW = "watchedShow";
    public static final String SET_PLAY_PROGRESS_ITEM = "http://%s/pauseresume/media/%s/set/%s/member/%s/%s?format=json";
    public static final int SHOWS_TAB_ID = 2;
    public static final String SLIDE_SHOW_URL = "http://%s/slideshow/%s/%s?format=%s";
    public static final String SOCIAL_DELETE = "http://%s/fb/delete/%s?format=%s";
    public static final String SOCIAL_PUBLISH = "http://%s/fb/publish?format=%s";
    public static final String SOCIAL_SETTINGS = "http://%s/setsocial?format=%s";
    public static final String SOCIAL_SSO_URL = "http://%s/fb/sso?format=%s";
    public static final boolean STAGING_ENABLED = false;
    public static final int TAB_COUNT = 4;
    public static final String TAG = "CrackleTag";
    public static final boolean TEST_ADS_ENABLED = false;
    public static final String USER_PROFILE_URL = "https://%s/profile/%s?format=%s";
    public static final String VERIFY_ACCOUNT_URL = "https://%s/login?format=%s";
    public static final String VERSION_CHECK_URL = (new StringBuilder()).append("http://").append(getBaseURL()).append("/appdeviceconfiglist?format=%s").toString();
    public static final int WATCHLISTS_TAB_ID = 3;

    public ApplicationConstants()
    {
    }

    public static String getBaseURL()
    {
        if (Application.isAmazonFireTV())
        {
            return "amazon-api-us.crackle.com/Service.svc";
        }
        if (Application.isFanhattan())
        {
            return "fanhattan-api-us.crackle.com/Service.svc";
        } else
        {
            return "android-api-us.crackle.com/Service.svc";
        }
    }

    public static String getFreeWheelHomeSiteSection()
    {
        if (Application.isAmazonFireTV())
        {
            return "crackle_amazon_tv%s_home";
        }
        if (Application.isFanhattan())
        {
            return "crackle_fanhattan_tv_home";
        } else
        {
            return "crackle_android_%s_app%s_home";
        }
    }

    public static String getFreeWheelLaunchSiteSection()
    {
        if (Application.isAmazonFireTV())
        {
            return "crackle_amazon_tv%s_launch";
        }
        if (Application.isFanhattan())
        {
            return "crackle_fanhattan_tv_launch";
        } else
        {
            return "crackle_android_%s_app%s_launch";
        }
    }

    public static String getFreeWheelMoviesSiteSection()
    {
        if (Application.isAmazonFireTV())
        {
            return "crackle_amazon_tv%s_movies";
        }
        if (Application.isFanhattan())
        {
            return "crackle_fanhattan_tv_movies";
        } else
        {
            return "crackle_android_%s_app%s_movies";
        }
    }

    public static String getFreeWheelShowsSiteSection()
    {
        if (Application.isAmazonFireTV())
        {
            return "crackle_amazon_tv%s_shows";
        }
        if (Application.isFanhattan())
        {
            return "crackle_fanhattan_tv_shows";
        } else
        {
            return "crackle_android_%s_app%s_shows";
        }
    }

    public static String getFreeWheelWatchSiteSection()
    {
        if (Application.isAmazonFireTV())
        {
            return "crackle_amazon_tv%s_watch";
        }
        if (Application.isFanhattan())
        {
            return "crackle_fanhattan_tv_watch";
        } else
        {
            return "crackle_android_%s_app%s_watch";
        }
    }

    public static String getVendorID()
    {
        if (Application.getInstance().isTablet())
        {
            if (Application.isAmazonFireTV())
            {
                return "58";
            }
            if (Application.isFanhattan())
            {
                return "57";
            } else
            {
                return "25";
            }
        } else
        {
            return "24";
        }
    }

    public static String getVendorKey()
    {
        if (Application.getInstance().isTablet())
        {
            if (Application.isAmazonFireTV())
            {
                return "JLMLKPUFQNZYTZQX";
            }
            if (Application.isFanhattan())
            {
                return "QWMJCYOZUYONPXPR";
            } else
            {
                return "MIRNPSEZYDAQASLX";
            }
        } else
        {
            return "QWXRHTCJPOGKBJKO";
        }
    }

    static 
    {
        CUSTOM_USER_AGENT_STRING = (new StringBuilder()).append("Android ").append(android.os.Build.VERSION.RELEASE).append("; ").append(Build.MODEL).append("; ").append("Crackle ").append(Application.getInstance().getVersion()).toString();
    }
}
