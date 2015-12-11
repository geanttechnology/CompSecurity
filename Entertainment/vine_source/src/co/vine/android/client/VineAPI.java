// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import co.vine.android.api.VineClientFlags;
import co.vine.android.network.HttpOperation;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.Util;
import com.edisonwang.android.slog.SLog;
import com.google.gdata.util.common.base.PercentEscaper;
import java.util.Locale;
import org.apache.http.HttpRequest;

// Referenced classes of package co.vine.android.client:
//            AppController, Session

public class VineAPI
{

    public static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
    private static PercentEscaper ENCODER;
    public static final int ERROR_VERIFICATION_REQURED = 616;
    public static final int GLOBAL_SIZE = 20;
    public static final String HOST_VINE = "vine.co";
    public static final char PATH_SEPARATOR = 47;
    public static final String RESOURCE_ACCEPT_OUT_OF_NETWORK_CONVERSATIONS = "acceptsOutOfNetworkConversations";
    public static final String RESOURCE_ACTIVITY_COUNTS = "activityCounts";
    public static final String RESOURCE_AUTHENTICATE = "authenticate";
    public static final String RESOURCE_BLOCKED = "blocked";
    public static final String RESOURCE_CHANNELS = "channels";
    public static final String RESOURCE_CLIENT_FLAGS = "clientflags";
    public static final String RESOURCE_CLIENT_PROFILE = "clientprofiles";
    public static final String RESOURCE_COMMENTS = "comments";
    public static final String RESOURCE_COMPLAINTS = "complaints";
    public static final String RESOURCE_CONTACTS = "contacts";
    public static final String RESOURCE_CONVERSATIONS = "conversations";
    public static final String RESOURCE_DEVICE_TOKEN = "deviceToken";
    public static final String RESOURCE_EDITION = "edition";
    public static final String RESOURCE_EDITIONS = "editions";
    public static final String RESOURCE_EXPLICIT = "explicit";
    public static final String RESOURCE_FAVORITES = "favorites";
    public static final String RESOURCE_FEATURED = "featured";
    public static final String RESOURCE_FOLLOWERS = "followers";
    public static final String RESOURCE_FOLLOWING = "following";
    public static final String RESOURCE_FOLLOW_REQUESTS = "followRequests";
    public static final String RESOURCE_FRIENDS = "friends";
    public static final String RESOURCE_GRAPH = "graph";
    public static final String RESOURCE_GROUPED = "grouped";
    public static final String RESOURCE_IGNORED = "ignored";
    public static final String RESOURCE_LIKES = "likes";
    public static final String RESOURCE_LOOPS = "loops";
    public static final String RESOURCE_ME = "me";
    public static final String RESOURCE_MESSAGES = "messages";
    public static final String RESOURCE_NOTIFICATIONS = "notifications";
    public static final String RESOURCE_OUT_OF_NETWORK = "outOfNetwork";
    public static final String RESOURCE_POPULAR_NOW = "popular";
    public static final String RESOURCE_POSTS = "posts";
    public static final String RESOURCE_PREFERENCES = "preferences";
    public static final String RESOURCE_PROFILES = "profiles";
    public static final String RESOURCE_PROFILE_BACKGROUND = "profileBackground";
    public static final String RESOURCE_REACTIVATE = "reactivate";
    public static final String RESOURCE_REPOST = "repost";
    public static final String RESOURCE_REPOSTS = "reposts";
    public static final String RESOURCE_REQUESTS = "requests";
    public static final String RESOURCE_SEARCH = "search";
    public static final String RESOURCE_SETTINGS = "settings";
    public static final String RESOURCE_SHARE = "share";
    public static final String RESOURCE_SHARED = "s";
    public static final String RESOURCE_SUGGESTED = "suggested";
    public static final String RESOURCE_TAGS = "tags";
    public static final String RESOURCE_TIMELINES = "timelines";
    public static final String RESOURCE_TRENDING = "trending";
    public static final String RESOURCE_TWITTER = "twitter";
    public static final String RESOURCE_USERS = "users";
    public static final String RESOURCE_VANITY = "vanity";
    public static final String RESOURCE_VERIFY_EMAIL = "verifyEmail";
    public static final String RESOURCE_VERIFY_PHONE_NUMBER = "verifyPhoneNumber";
    public static final String RESOURCE_VIEWED = "viewed";
    public static final String SCHEME_HTTP = "http://";
    public static final String SCHEME_HTTPS = "https://";
    public static final String SECRET_AUTH_HEADER = "X-Vine-Auth";
    public static final String X_VINE_CLIENT = "X-Vine-Client";
    private static VineAPI mApi;
    private String mAccountName;
    private String mAmazonUrl;
    private String mBaseUrl;
    private String mConfigUrl;
    private final Context mContext;
    private String mExploreUrl;
    private String mLocale;
    private String mMediaUrl;
    private String mRtcUrl;
    private Session mSession;
    private String mTwitterUrl;
    private String mXVineClientHeader;

    private VineAPI(Context context, Resources resources)
    {
        mContext = context;
        refreshHostUrls(null, resources);
        refreshLocale();
        if (!TextUtils.isEmpty("2.1.5"))
        {
            if (BuildUtil.isExplore())
            {
                context = "-gb";
            } else
            {
                context = "";
            }
            mXVineClientHeader = (new StringBuilder()).append("android").append(context).append("/").append("2.1.5").toString();
            return;
        } else
        {
            mXVineClientHeader = null;
            return;
        }
    }

    public static int addParam(StringBuilder stringbuilder, String s, long al[], int i, int j)
    {
        if (al != null && i < al.length && j > 0)
        {
            prefixParam(stringbuilder, s);
            int k = Math.min(i + j, al.length);
            for (j = i; j < k; j++)
            {
                stringbuilder.append(al[j]);
                if (j < k - 1)
                {
                    stringbuilder.append(',');
                }
            }

            return k - i;
        } else
        {
            return 0;
        }
    }

    public static void addParam(StringBuilder stringbuilder, String s, double d)
    {
        prefixParam(stringbuilder, s).append(d);
    }

    public static void addParam(StringBuilder stringbuilder, String s, int i)
    {
        prefixParam(stringbuilder, s).append(i);
    }

    public static void addParam(StringBuilder stringbuilder, String s, long l)
    {
        prefixParam(stringbuilder, s).append(l);
    }

    public static void addParam(StringBuilder stringbuilder, String s, String s1)
    {
        prefixParam(stringbuilder, s).append(encode(s1));
    }

    public static void addParam(StringBuilder stringbuilder, String s, boolean flag)
    {
        prefixParam(stringbuilder, s).append(flag);
    }

    public static transient StringBuilder buildUponUrl(String s, Object aobj[])
    {
        s = new StringBuilder(s);
        if (aobj != null)
        {
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                Object obj = aobj[i];
                s.append('/');
                s.append(obj);
            }

        }
        return s;
    }

    public static String encode(String s)
    {
        if (s == null)
        {
            return "";
        }
        if (ENCODER == null)
        {
            ENCODER = new PercentEscaper("-._~", false);
        }
        return ENCODER.escape(s);
    }

    public static VineAPI getInstance(Context context)
    {
        if (mApi == null)
        {
            Resources resources1 = context.getApplicationContext().getResources();
            Resources resources = resources1;
            if (resources1 == null)
            {
                resources = context.getResources();
            }
            if (resources == null)
            {
                throw new IllegalStateException("Context does not have resources attached.");
            }
            mApi = new VineAPI(context.getApplicationContext(), resources);
        }
        return mApi;
    }

    private String getSessionKey()
    {
        return AppController.getInstance(mContext).getActiveSessionReadOnly().getSessionKey();
    }

    private static StringBuilder prefixParam(StringBuilder stringbuilder, String s)
    {
        if (stringbuilder.indexOf("?") == -1)
        {
            stringbuilder.append('?');
        } else
        {
            stringbuilder.append('&');
        }
        return stringbuilder.append(s).append('=');
    }

    public void addClientHeaders(HttpRequest httprequest)
    {
        if (!TextUtils.isEmpty(mXVineClientHeader))
        {
            httprequest.addHeader("X-Vine-Client", mXVineClientHeader);
            String s = Util.getLocale();
            if (!TextUtils.isEmpty(s))
            {
                httprequest.addHeader("Accept-Language", s);
            }
            if (!BuildUtil.isProduction())
            {
                httprequest.addHeader("X-Vine-Auth", getAuthHeaderSecret());
                return;
            }
        }
    }

    public void addContentTypeHeader(HttpOperation httpoperation, String s)
    {
        httpoperation.getHttpRequest().addHeader("content-type", s);
    }

    public void addSessionKeyAuthHeader(HttpOperation httpoperation)
    {
        httpoperation.getHttpRequest().addHeader("vine-session-id", getSessionKey());
    }

    public void addSessionKeyAuthHeader(HttpOperation httpoperation, String s)
    {
        httpoperation.getHttpRequest().addHeader("vine-session-id", s);
    }

    public transient StringBuilder buildUrl(Object aobj[])
    {
        return buildUponUrl(mBaseUrl, aobj);
    }

    public String getAmazonUrl()
    {
        return mAmazonUrl;
    }

    public String getAuthHeaderSecret()
    {
        return mContext.getResources().getString(0x7f0e004f);
    }

    public String getBaseUrl()
    {
        return mBaseUrl;
    }

    public String getConfigUrl()
    {
        return mConfigUrl;
    }

    public String getExploreUrl()
    {
        return mExploreUrl;
    }

    public String getMediaUrl()
    {
        return mMediaUrl;
    }

    public String getRtcUrl()
    {
        return mRtcUrl;
    }

    public String getTwitterUrl()
    {
        return mTwitterUrl;
    }

    public String getVineClientHeader()
    {
        return mXVineClientHeader;
    }

    public void refreshHostUrls(VineClientFlags vineclientflags, Resources resources)
    {
        Object obj = mContext;
        Resources resources1 = resources;
        if (resources == null)
        {
            resources1 = mContext.getResources();
        }
        String s;
        if (vineclientflags == null)
        {
            vineclientflags = Util.getDefaultSharedPrefs(((Context) (obj)));
            s = vineclientflags.getString("client_flags_api_host", null);
            obj = vineclientflags.getString("client_flags_rtc_host", null);
            resources = vineclientflags.getString("client_flags_media_host", null);
            vineclientflags = vineclientflags.getString("client_flags_explore_host", null);
        } else
        {
            s = vineclientflags.apiHost;
            obj = vineclientflags.rtcHost;
            resources = vineclientflags.mediaHost;
            vineclientflags = vineclientflags.exploreHost;
        }
        if (s != null)
        {
            s = (new StringBuilder()).append("https://").append(s).toString();
        } else
        {
            s = BuildUtil.getBaseUrl(resources1);
        }
        mBaseUrl = s;
        mAmazonUrl = resources1.getString(0x7f0e004b);
        mTwitterUrl = resources1.getString(0x7f0e0251);
        if (obj != null)
        {
            obj = (new StringBuilder()).append("https://").append(((String) (obj))).toString();
        } else
        {
            obj = BuildUtil.getRtcUrl(resources1);
        }
        mRtcUrl = ((String) (obj));
        if (resources != null)
        {
            resources = (new StringBuilder()).append("https://").append(resources).toString();
        } else
        {
            resources = BuildUtil.getMediaUrl(resources1);
        }
        mMediaUrl = resources;
        if (vineclientflags != null)
        {
            vineclientflags = (new StringBuilder()).append("http://").append(vineclientflags).toString();
        } else
        {
            vineclientflags = BuildUtil.getExploreUrl(resources1);
        }
        mExploreUrl = vineclientflags;
        mExploreUrl = (new StringBuilder()).append(mExploreUrl).append(BuildUtil.getExplorePath(resources1)).toString();
        mConfigUrl = BuildUtil.getConfigUrl(resources1);
        SLog.d((new StringBuilder()).append("hosts=").append(mBaseUrl).append(", ").append(mRtcUrl).append(", ").append(mExploreUrl).append(", ").append(mMediaUrl).toString());
    }

    public void refreshLocale()
    {
        String s = Locale.getDefault().getCountry();
        if (!TextUtils.isEmpty(s))
        {
            mLocale = s;
            return;
        } else
        {
            mLocale = null;
            return;
        }
    }
}
