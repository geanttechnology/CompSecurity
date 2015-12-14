// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.github.kevinsawicki.http.HttpRequest;
import com.socialin.android.apiv3.model.AddCoinsResponse;
import com.socialin.android.apiv3.model.AddDesignParams;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.AvatarResponse;
import com.socialin.android.apiv3.model.BannersResponse;
import com.socialin.android.apiv3.model.BlogsResponse;
import com.socialin.android.apiv3.model.CampaignsResponse;
import com.socialin.android.apiv3.model.Comment;
import com.socialin.android.apiv3.model.CommentsResponse;
import com.socialin.android.apiv3.model.ConnectionsResponse;
import com.socialin.android.apiv3.model.ContestItemsResponse;
import com.socialin.android.apiv3.model.ContestsResponse;
import com.socialin.android.apiv3.model.FollowersResponse;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.ItemsResponse;
import com.socialin.android.apiv3.model.LocationsResponse;
import com.socialin.android.apiv3.model.MemboxesResponse;
import com.socialin.android.apiv3.model.NotificationResponse;
import com.socialin.android.apiv3.model.RatesResponse;
import com.socialin.android.apiv3.model.RecentTagsResponse;
import com.socialin.android.apiv3.model.RepostsResponse;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.ShopBannersResponse;
import com.socialin.android.apiv3.model.ShopItemsListResponse;
import com.socialin.android.apiv3.model.StatusObj;
import com.socialin.android.apiv3.model.Stream;
import com.socialin.android.apiv3.model.StreamsResponse;
import com.socialin.android.apiv3.model.TagsResponse;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.UsernameResponse;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.model.ViewerUsersResponse;
import com.socialin.android.apiv3.model.WhatsNewResponse;
import com.socialin.android.apiv3.model.parsers.NewsResponseParser;
import com.socialin.android.apiv3.model.parsers.ResponseParserFactory;
import com.socialin.android.apiv3.model.stripe.StripeChargeParams;
import com.socialin.android.apiv3.model.stripe.StripeChargeResponse;
import com.socialin.android.apiv3.model.stripe.StripeTokenParams;
import com.socialin.android.apiv3.model.stripe.StripeTokenResponse;
import com.socialin.android.apiv3.request.GetItemsParams;
import com.socialin.android.apiv3.request.GetTagsParams;
import com.socialin.android.apiv3.request.GetUserDesignsParams;
import com.socialin.android.apiv3.request.GetUsersParams;
import com.socialin.android.apiv3.request.LocationParams;
import com.socialin.android.apiv3.request.NotificationSettingsParams;
import com.socialin.android.apiv3.request.ParamWithPageLimit;
import com.socialin.android.apiv3.request.SignupParams;
import com.socialin.android.apiv3.request.UploadParams;
import com.socialin.android.d;
import com.socialin.android.util.e;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.a;
import com.socialin.asyncnet.b;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import myobfuscated.aj.g;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3:
//            SocialinV3, a

public class SocialinApiV3
{

    private static final String ADD_BLOCKED_USER = "blocks/add/";
    private static final String ADD_COINS = "users/balance/add.json";
    private static final String ADD_COMMENT = "photos/comments/add/";
    private static final String ADD_CONNECTION = "connections/add.json";
    private static final String ADD_DESIGN = "designs/add.json";
    private static final String ADD_DESIGN_COMMENT = "designs/comments/add/";
    private static final String ADD_FOLLOWING = "following/add/";
    private static final String ADD_PHOTO = "photos/add.json";
    private static final String ADD_STREAM = "streams/add.json";
    private static final String ADD_STREAM_DESIGN = "streams/designs/add/";
    private static final String ADD_STREAM_PHOTO = "streams/photos/add/";
    private static final String ADD_TAG_FOLLOWING = "users/tags/add";
    private static final String ADD_USER_COVER = "users/cover/add.json";
    private static final String ADD_VOTE = "contests/votes/add/";
    private static final String ALIPAY_PAYMENTS = "users/payments/";
    private static final g CACHED_URLS = new g(2000);
    private static final String CHARGE_ALIPAY = "charges/add.json";
    private static final String CHECK_OUT_SHOP_ITEM = "apps/add/";
    private static final SparseArray EDGE_TO_SIZE_KEY;
    private static final String GCM_REGISTER = "users/devices/add.json";
    private static final String GCM_UNREGISTER = "users/devices/remove.json";
    private static final String GET_ALIPAY_TOKEN = "token/show.json";
    private static final String GET_APPS = "apps.json";
    private static final String GET_BLOGS = "posts/categories/show/all.json";
    private static final String GET_CARDS_PHOTOS = "cards.json?type=photos";
    private static final String GET_CARDS_USERS = "cards.json?type=users";
    private static final String GET_CONTESTS = "contests.json";
    private static final String GET_CONTEST_ITEMS = "contests/show/";
    private static final String GET_DESIGN = "designs/show/";
    private static final String GET_DESIGN_STREAMS = "designs/streams/show/";
    private static final String GET_MY_DESIGNS = "users/designs/show/me.json";
    private static final String GET_NOTIFICATIONS = "notifications/show/me.json";
    private static final String GET_OWNER_BLOCKED_USERS = "blocks/show/me.json";
    private static final String GET_OWNER_CONNECTION = "connections/show/me.json";
    private static final String GET_OWNER_FOLLOWERS = "followers/show/me.json";
    private static final String GET_OWNER_NETWORK_PHOTOS = "photos/following/show/me.json";
    private static final String GET_OWNER_PHOTOS = "users/photos/show/me.json";
    private static final String GET_OWNER_TAGS = "users/tags/me.json";
    private static final String GET_OWNER_TAGS_GROUPED = "users/photos/tags/me.json";
    private static final String GET_OWNER_USER = "users/show/me.json";
    private static final String GET_PHOTO = "photos/show/";
    private static final String GET_PHOTOS = "photos/show/{type}.json";
    private static final String GET_PHOTO_COMMENTS = "photos/comments/show/";
    private static final String GET_PHOTO_LIKES = "photos/likes/show/";
    private static final String GET_PHOTO_MEMBOXES = "photos/streams/show/";
    private static final String GET_PHOTO_REPOSTS = "photos/reposts/show/";
    private static final String GET_PHOTO_STREAMS = "photos/streams/show/";
    private static final String GET_POPULAR_DESIGNS = "designs/show/popular.json";
    private static final String GET_POPULAR_PHOTOS = "photos/show/popular.json";
    private static final String GET_RECENT_PHOTOS = "photos/show/recent.json";
    private static final String GET_SETTINGS = "settings";
    private static final String GET_SHOP_ITEMS = "apps.json";
    private static final String GET_STICKER_STREAM = "streams/show/sticker";
    private static final String GET_STREAM_PHOTOS = "streams/show/";
    private static final String GET_TAGS_GROUPED = "tags/show/{type}.json";
    private static final String GET_USERS = "users/show/{type}.json";
    private static final String GET_USER_DESIGNS = "users/designs/show/";
    private static final String GET_USER_PHOTOS_LOC_GROUPED = "users/photos/places/";
    private static final String GET_USER_PHOTOS_LOC_GROUPED_ME = "users/photos/places/me.json";
    private static final String GET_USER_RECENT_TAGS = "tags/show/";
    private static final String GET_USER_SHOP_ITEMS = "apps/show/me.json";
    private static final String GET_VIEWER_BLOCKED_USERS = "blocks/show/";
    private static final String GET_VIEWER_FOLLOWERS = "followers/show/";
    private static final String GET_VIEWER_FOLLOWING = "following/show/";
    private static final String GET_VIEWER_PHOTOS = "users/photos/show/";
    private static final String GET_VIEWER_STREAMS = "users/streams/show/";
    private static final String GET_VIEWER_TAGS_GROUPED = "users/photos/tags/";
    private static final String GET_VIEWER_USER = "users/show/";
    private static final String GET_WHATS_NEW_ITEMS = "whatsnew.json";
    private static final String INVITE_TEMPLATE_URL = "http://picsart.com/template/invites";
    private static final String LIKE_DESIGN = "designs/likes/add/";
    private static final String LIKE_PHOTO = "photos/likes/add/";
    private static final int MAX_ITEMS_PER_PAGE = 300;
    private static final int MAX_URLS_TO_CACHE = 2000;
    private static final String POPULAR_USERS = "users/show/popular.json";
    private static final String REMOVE_BLOCKED_USER = "blocks/remove/";
    private static final String REMOVE_COMMENT = "photos/comments/remove/";
    private static final String REMOVE_CONNECTION = "connections/remove.json";
    private static final String REMOVE_DESIGN = "designs/remove/";
    private static final String REMOVE_DESIGN_COMMENT = "designs/comments/remove/";
    private static final String REMOVE_FOLLOWING = "following/remove/";
    private static final String REMOVE_PHOTO = "photos/remove/";
    private static final String REMOVE_SHOP_ITEM = "apps/remove/";
    private static final String REMOVE_STREAM = "streams/remove/";
    private static final String REMOVE_STREAM_DESIGN = "streams/designs/remove/";
    private static final String REMOVE_STREAM_PHOTO = "streams/photos/remove/";
    private static final String REMOVE_TAG_FOLLOWING = "users/tags/remove";
    private static final String RENAME_STREAM = "streams/rename/";
    private static final String REPORT_DESIGN = "designs/reports/add/";
    private static final String REPORT_PHOTO = "photos/reports/add/";
    private static final String REPOST_PHOTO = "photos/reposts/";
    private static final String RESET_PASSWORD = "users/reset.json";
    private static final String SAVE_ALIPAY_TOKEN = "token/add.json";
    private static final String SEARCH_INSIDE_FOLLOWING = "following/show/me.json";
    private static final String SEARCH_PHOTOS = "photos/search.json";
    private static final String SEARCH_TAGS = "tags/suggestions.json";
    private static final String SEARCH_TAGS_BY_LOCATION = "tags/places/suggestions.json";
    private static final String SEARCH_USERS = "users/search.json";
    private static final String SHOW_BLOG_ITEM = "posts/show";
    private static final String SIGNIN = "users/signin.json";
    private static final String SIGN_UP = "users/signup.json";
    private static final List SORTED_SIZE_KEYS;
    public static final int SQUARE_THUMB_SIZE;
    public static final int TAG_KEY = 0x2f0e24fb;
    private static final String UNLIKE_DESIGN = "designs/likes/remove/";
    private static final String UNLIKE_PHOTO = "photos/likes/remove/";
    private static final String UPDATE = "users/update.json";
    private static final String UPDATE_AVATAR = "users/photo/add.json";
    private static final String UPDATE_PHOTO = "photos/update/";
    private static final String USER_NAME_CHECK = "users/revise/username.json";
    private static final String USER_SUGGESTIONS = "users/suggestions.json";
    private static SocialinApiV3 instance;
    static String versionCode = "0";
    private String apiBackupUrl;
    private String apiBaseUrl;
    private String apiKey;
    private String fourSquareUrl;
    private String notificationUrl;
    private String uploadUrl;

    private SocialinApiV3(String s)
    {
        fourSquareUrl = "";
        apiBaseUrl = s;
        s = apiBaseUrl;
        apiBackupUrl = s;
        uploadUrl = s;
    }

    public static SocialinApiV3 getInstance()
    {
        if (instance == null)
        {
            instance = new SocialinApiV3("https://api.picsart.com/");
            try
            {
                versionCode = String.valueOf(SocialinV3.getInstance().getContext().getPackageManager().getPackageInfo(SocialinV3.getInstance().getContext().getPackageName(), 128).versionCode);
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                namenotfoundexception.printStackTrace();
            }
        }
        return instance;
    }

    private static List getLargerSizeKeys(int i, int j)
    {
        j = Math.max(i, j);
        ArrayList arraylist = new ArrayList();
        Iterator iterator = SORTED_SIZE_KEYS.iterator();
        i = 1;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            int k = ((Integer)iterator.next()).intValue();
            if (j <= k)
            {
                if (i != 0)
                {
                    i = 0;
                } else
                {
                    arraylist.add(EDGE_TO_SIZE_KEY.get(k));
                }
            }
        } while (true);
        return arraylist;
    }

    public static String getPhotoURL(ImageItem imageitem, int i, int j)
    {
        return getPhotoUrl(imageitem, getSizeKey(i, j));
    }

    public static String getPhotoURL(String s, int i, int j)
    {
        return getPhotoUrl(s, getSizeKey(i, j));
    }

    private static String getPhotoUrl(ImageItem imageitem, String s)
    {
        com.socialin.android.apiv3.a a1 = new com.socialin.android.apiv3.a(imageitem, s, (byte)0);
        String s2 = (String)CACHED_URLS.b(a1);
        String s1 = s2;
        if (s2 == null)
        {
            s1 = (new StringBuilder()).append(imageitem.getUrl()).append(s).append(".jpg").toString();
            CACHED_URLS.b(a1, s1);
        }
        return s1;
    }

    private static String getPhotoUrl(String s, String s1)
    {
        com.socialin.android.apiv3.a a1 = new com.socialin.android.apiv3.a(s, s1);
        String s3 = (String)CACHED_URLS.b(a1);
        String s2 = s3;
        if (s3 == null)
        {
            s2 = (new StringBuilder()).append(s).append(s1).append(".jpg").toString();
            CACHED_URLS.b(a1, s2);
        }
        return s2;
    }

    private static String getSizeKey(int i, int j)
    {
        i = Math.max(i, j);
        String s1 = (String)EDGE_TO_SIZE_KEY.get(((Integer)SORTED_SIZE_KEYS.get(SORTED_SIZE_KEYS.size() - 1)).intValue());
        Iterator iterator = SORTED_SIZE_KEYS.iterator();
        String s;
        do
        {
            s = s1;
            if (!iterator.hasNext())
            {
                break;
            }
            j = ((Integer)iterator.next()).intValue();
            if (i > j)
            {
                continue;
            }
            s = (String)EDGE_TO_SIZE_KEY.get(j);
            break;
        } while (true);
        return s;
    }

    public int addBlockedUser(long l, String s, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("blocks/add/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("blocks/add/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("blocks/add/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int addComment(long l, String s, boolean flag, String s1, com.socialin.asyncnet.d d1)
    {
        String s2;
        a a1;
        if (flag)
        {
            s2 = "designs/comments/add/";
        } else
        {
            s2 = "photos/comments/add/";
        }
        a1 = new a((new StringBuilder()).append(apiBaseUrl).append(s2).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/Comment), "POST");
        a1.b("text", s);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append(s2).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append(s2).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s1, d1, false);
        return ((Request) (a1)).d;
    }

    public int addConnection(String s, com.socialin.asyncnet.d d1, String s1, String s2, String s3, String s4)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("connections/add.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.b("provider", s2);
        a1.b("id", String.valueOf(s1));
        a1.b("token", s3);
        a1.b("data", s4);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("connections/add.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("connections/add.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int addDesign(AddDesignParams adddesignparams, com.socialin.asyncnet.d d1, String s)
    {
        String s1 = (new StringBuilder()).append(apiBaseUrl).append("designs/add.json").append(getApiKeyParamStr(apiKey)).toString();
        a a1 = new a(s1, ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ImageItem), "POST");
        a1.b("title", adddesignparams.title);
        a1.b("desc", adddesignparams.desc);
        a1.b("tags", adddesignparams.tags);
        a1.b("is_mature", String.valueOf(adddesignparams.isMature));
        a1.b("is_public", String.valueOf(adddesignparams.isPublic));
        a1.b("path", adddesignparams.imagePath);
        Object obj = adddesignparams.location;
        if (obj != null)
        {
            a1.b("location_place", ((Adress) (obj)).place);
            a1.b("location_street", ((Adress) (obj)).street);
            a1.b("location_city", ((Adress) (obj)).city);
            a1.b("location_state", ((Adress) (obj)).state);
            a1.b("location_zip", ((Adress) (obj)).zip);
            a1.b("location_country", ((Adress) (obj)).country);
            a1.b("location_lat", ((Adress) (obj)).getLatitudeString());
            a1.b("location_lon", ((Adress) (obj)).getLongitudeString());
        }
        a1.e = 0x30d40;
        a1.f = 0x30d40;
        obj = new File(adddesignparams.photoPath);
        a1.a("photo", ((File) (obj)).getName(), "image/*", ((File) (obj)));
        adddesignparams = new File(adddesignparams.packPath);
        a1.a("pack", adddesignparams.getName(), "image/*", adddesignparams);
        a1.a = s1;
        a1.b = s1;
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int addFollowing(String s, String s1, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("following/add/").append(s).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("following/add/").append(s).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("following/add/").append(s).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s1, d1, false);
        return ((Request) (a1)).d;
    }

    public int addPhoto(UploadParams uploadparams, String s, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(uploadUrl).append("photos/add.json").append(getApiKeyParamStr(uploadparams.apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ImageItem), "POST");
        if (!TextUtils.isEmpty(uploadparams.id))
        {
            a1.b("id", uploadparams.id);
        }
        a1.b("title", uploadparams.title);
        a1.b("desc", uploadparams.desc);
        a1.b("tags", uploadparams.tags);
        a1.b("is_mature", String.valueOf(uploadparams.isMature));
        a1.b("is_public", String.valueOf(uploadparams.isPublic));
        a1.b("path", uploadparams.imagePath);
        a1.b("type", uploadparams.type);
        a1.b("is_original", String.valueOf(uploadparams.isOriginal));
        a1.b("timestamp", uploadparams.timestamp);
        Adress adress = uploadparams.location;
        if (adress != null)
        {
            a1.b("location_place", adress.place);
            a1.b("location_street", adress.street);
            a1.b("location_city", adress.city);
            a1.b("location_state", adress.state);
            a1.b("location_zip", adress.zip);
            a1.b("location_country", adress.country);
            a1.b("location_lat", adress.getLatitudeString());
            a1.b("location_lon", adress.getLongitudeString());
        }
        a1.e = 0x30d40;
        a1.f = 0x30d40;
        a1.a = (new StringBuilder()).append(uploadUrl).append("photos/add.json").append(getApiKeyParamStr(uploadparams.apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("photos/add.json").append(getApiKeyParamStr(uploadparams.apiKey)).toString();
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int addStream(String s, String s1, String s2, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("streams/add.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/Stream), "POST");
        a1.b("title", s);
        a1.b("desc", s1);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("streams/add.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("streams/add.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s2, d1, false);
        return ((Request) (a1)).d;
    }

    public int addStreamPhoto(long l, long l1, boolean flag, String s, com.socialin.asyncnet.d d1)
    {
        Object obj = (new StringBuilder()).append(apiBaseUrl);
        String s1;
        if (flag)
        {
            s1 = "streams/designs/add/";
        } else
        {
            s1 = "streams/photos/add/";
        }
        s1 = ((StringBuilder) (obj)).append(s1).append(String.valueOf(l)).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        obj = new a(s1, ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        ((Request) (obj)).b("photo_id", String.valueOf(l1));
        obj.a = s1;
        obj.b = s1;
        obj.c = 3;
        prepare(((Request) (obj)));
        b.a().a(((Request) (obj)), s, d1, false);
        return ((Request) (obj)).d;
    }

    public int addTagFollowing(long l, String s, String s1, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/tags/add.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("users/tags/add.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("users/tags/add.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b("tag", s);
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s1, d1, false);
        return ((Request) (a1)).d;
    }

    public int addVote(String s, com.socialin.asyncnet.d d1, long l, int i, String s1)
    {
        s1 = new a((new StringBuilder()).append(apiBaseUrl).append("contests/votes/add/").append(s1).append(".json").append(getApiKeyParamStr(apiKey)).append("&contest_version=").append(String.valueOf(getContestVersion())).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        s1.b("photo_id", String.valueOf(l));
        if (i > 0)
        {
            s1.b("vote_place", String.valueOf(i));
        }
        prepare(s1);
        b.a().a(s1, s, d1, false);
        return ((Request) (s1)).d;
    }

    public int apps(String s, String s1, String s2, String s3, com.socialin.asyncnet.d d1, int i, long l, boolean flag)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("apps.json").toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/AppProps), "GET");
        a1.b("app", s);
        a1.b("market", s1);
        if (s1.contains("china"))
        {
            a1.b("paid", "true");
        }
        a1.a(l);
        a1.a(i);
        if (s2 != null)
        {
            a1.b("type", s2);
        }
        if (flag)
        {
            a1.b("onAppStartup", "true");
        }
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("apps.json").toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("apps.json").toString();
        a1.c = 5;
        prepare(a1);
        b.a().a(a1, s3, d1, false);
        return ((Request) (a1)).d;
    }

    public int banners(String s, String s1, String s2, com.socialin.asyncnet.d d1, int i, long l)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("apps.json").toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/BannersResponse), "GET");
        a1.b("app", s);
        a1.b("market", s1);
        a1.a(l);
        a1.a(i);
        a1.b("type", "banners");
        prepare(a1);
        b.a().a(a1, s2, d1, false);
        return ((Request) (a1)).d;
    }

    public int campaigns(String s, String s1, String s2, com.socialin.asyncnet.d d1, int i, long l)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("apps.json").toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/CampaignsResponse), "GET");
        a1.b("app", s);
        a1.b("market", s1);
        a1.a(l);
        a1.a(i);
        a1.b("type", "campaigns");
        prepare(a1);
        b.a().a(a1, s2, d1, false);
        return ((Request) (a1)).d;
    }

    public int checkUsername(String s, com.socialin.asyncnet.d d1, String s1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/revise/username.json").toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/UsernameResponse), "POST");
        a1.b("username", s);
        b.a().a(a1, s1, d1, false);
        return ((Request) (a1)).d;
    }

    public int checkoutShopItem(String s, com.socialin.asyncnet.d d1, String s1, String s2, String s3, int i)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("apps/add/").append(s1).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/Response), "POST");
        a1.b("amount", s2);
        a1.b("data", s3);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("apps/add/").append(s1).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("apps/add/").append(s1).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public Request createGcmRegisterRequest(String s)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/devices/add.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.b("device", s);
        prepare(a1);
        return a1;
    }

    public Request createNotificationsRequest(String s, String s1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("notifications/show/me.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/NotificationResponse), "GET");
        if (!TextUtils.isEmpty(s))
        {
            a1.b("since_id", s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            a1.b("not_send", s1);
        }
        a1.a = (new StringBuilder()).append(notificationUrl).append("notifications/show/me.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("notifications/show/me.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 1;
        prepare(a1);
        return a1;
    }

    public Request createSigninRequest(String s, String s1, String s2, String s3)
    {
        s3 = new a((new StringBuilder()).append(apiBaseUrl).append("users/signin.json").toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/User), "POST");
        s3.b("provider", s);
        s3.b("username", s1);
        s3.b("password", s2);
        s3.a = (new StringBuilder()).append(apiBaseUrl).append("users/signin.json").toString();
        s3.b = (new StringBuilder()).append(apiBackupUrl).append("users/signin.json").toString();
        s3.e = 0x30d40;
        s3.c = 5;
        prepare(s3);
        return s3;
    }

    public Request createSigninRequestFb(String s, String s1, String s2, String s3)
    {
        s3 = new a((new StringBuilder()).append(apiBaseUrl).append("users/signin.json").toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/User), "POST");
        s3.b("provider", s);
        s3.b("token", s1);
        s3.b("auth", s2);
        s3.a = (new StringBuilder()).append(apiBaseUrl).append("users/signin.json").toString();
        s3.b = (new StringBuilder()).append(apiBackupUrl).append("users/signin.json").toString();
        s3.e = 0x30d40;
        s3.c = 5;
        prepare(s3);
        return s3;
    }

    public String getApiKey()
    {
        return apiKey;
    }

    public String getApiKeyParamStr(String s)
    {
        String s1 = "?";
        if (!TextUtils.isEmpty(s))
        {
            s1 = (new StringBuilder()).append("?").append("key=").append(s).toString();
        }
        return s1;
    }

    public int getBlogs(String s, com.socialin.asyncnet.d d1, ParamWithPageLimit paramwithpagelimit)
    {
        String s2 = "?v=0";
        String s1 = s2;
        if (paramwithpagelimit != null)
        {
            s1 = s2;
            if (paramwithpagelimit.offset >= 0)
            {
                s1 = (new StringBuilder()).append("?v=0").append("&offset=").append(paramwithpagelimit.offset).toString();
            }
        }
        s2 = s1;
        if (paramwithpagelimit != null)
        {
            s2 = s1;
            if (paramwithpagelimit.limit > 0)
            {
                s2 = (new StringBuilder()).append(s1).append("&limit=").append(paramwithpagelimit.limit).toString();
            }
        }
        paramwithpagelimit = new a((new StringBuilder()).append(apiBaseUrl).append("posts/categories/show/all.json").append(s2).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/BlogsResponse), "GET");
        prepare(paramwithpagelimit);
        b.a().a(paramwithpagelimit, s, d1, false);
        return ((Request) (paramwithpagelimit)).d;
    }

    public int getContestItems(String s, com.socialin.asyncnet.d d1, int i, String s1, String s2, int j, int k, 
            long l)
    {
        String s4 = "?v=1";
        if (!TextUtils.isEmpty(apiKey))
        {
            s4 = (new StringBuilder()).append("?v=1").append("&key=").append(apiKey).toString();
        }
        String s3 = s4;
        if (!TextUtils.isEmpty(s2))
        {
            s3 = (new StringBuilder()).append(s4).append("&order=").append(s2).toString();
        }
        s2 = s3;
        if (j >= 0)
        {
            s2 = (new StringBuilder()).append(s3).append("&offset=").append(j).toString();
        }
        s3 = s2;
        if (k > 0)
        {
            s3 = (new StringBuilder()).append(s2).append("&limit=").append(k).toString();
        }
        s2 = (new StringBuilder()).append(s3).append("&contest_version=").append(getContestVersion()).toString();
        s1 = new a((new StringBuilder()).append(apiBaseUrl).append("contests/show/").append(s1).append(".json").append(s2).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ContestItemsResponse), "GET", i);
        prepare(s1);
        b.a().a(s1, s, d1, false);
        return ((Request) (s1)).d;
    }

    public int getContestRateItems(String s, com.socialin.asyncnet.d d1, String s1)
    {
        String s2 = "?order=bucket";
        if (!TextUtils.isEmpty(apiKey))
        {
            s2 = (new StringBuilder()).append("?order=bucket").append("&key=").append(apiKey).toString();
        }
        s1 = new a((new StringBuilder()).append(apiBaseUrl).append("contests/show/").append(s1).append(".json").append(s2).append("&contest_version=").append(String.valueOf(getContestVersion())).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ContestItemsResponse), "GET");
        prepare(s1);
        b.a().a(s1, s, d1, false);
        return ((Request) (s1)).d;
    }

    public int getContestVersion()
    {
        return 3;
    }

    public int getContests(String s, com.socialin.asyncnet.d d1, int i, String s1, int j, int k, long l)
    {
        String s3 = (new StringBuilder()).append("").append("?contest_version=").append(getContestVersion()).toString();
        String s2 = s3;
        if (!TextUtils.isEmpty(apiKey))
        {
            s2 = (new StringBuilder()).append(s3).append("&key=").append(apiKey).toString();
        }
        s3 = s2;
        if (!TextUtils.isEmpty(s1))
        {
            s3 = (new StringBuilder()).append(s2).append("&type=").append(s1).toString();
        }
        s1 = s3;
        if (j >= 0)
        {
            s1 = (new StringBuilder()).append(s3).append("&offset=").append(j).toString();
        }
        s2 = s1;
        if (k > 0)
        {
            s2 = (new StringBuilder()).append(s1).append("&limit=").append(k).toString();
        }
        s1 = new a((new StringBuilder()).append(apiBaseUrl).append("contests.json").append(s2).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ContestsResponse), "GET", i);
        s1.a(l);
        prepare(s1);
        b.a().a(s1, s, d1, false);
        return ((Request) (s1)).d;
    }

    public int getExploreCards(GetItemsParams getitemsparams, String s, com.socialin.asyncnet.d d1, int i, boolean flag)
    {
        String s1 = (new StringBuilder()).append(apiBaseUrl).append("cards.json?type=photos").toString();
        String s2 = (new StringBuilder()).append(s1).append("&location_lat=").append(String.valueOf(getitemsparams.latitude)).append("&location_lon=").append(String.valueOf(getitemsparams.longitude)).toString();
        s1 = s2;
        if (!TextUtils.isEmpty(apiKey))
        {
            s1 = (new StringBuilder()).append(s2).append("&key=").append(apiKey).toString();
        }
        s2 = (new StringBuilder()).append(s1).append("&market=").append(SocialinV3.market).toString();
        s1 = s2;
        if (getitemsparams.offset >= 0)
        {
            s1 = (new StringBuilder()).append(s2).append("&offset=").append(getitemsparams.offset).toString();
        }
        s2 = s1;
        if (getitemsparams.limit > 0)
        {
            s2 = (new StringBuilder()).append(s1).append("&limit=").append(getitemsparams.limit).toString();
        }
        getitemsparams = new a(s2, ResponseParserFactory.createCardResponseParser(flag), "GET", i);
        getitemsparams.i = true;
        prepare(getitemsparams);
        b.a().a(getitemsparams, s, d1, false);
        return ((Request) (getitemsparams)).d;
    }

    public String getFourSquareUrl()
    {
        return fourSquareUrl;
    }

    public int getNetworkPhotos(int i, int j, long l, String s, com.socialin.asyncnet.d d1, int k)
    {
        String s1 = "";
        if (i >= 0)
        {
            s1 = (new StringBuilder()).append("").append("&offset=").append(i).toString();
        }
        Object obj = s1;
        if (j > 0)
        {
            obj = (new StringBuilder()).append(s1).append("&limit=").append(j).toString();
        }
        s1 = ((String) (obj));
        if (l >= 0L)
        {
            s1 = (new StringBuilder()).append(((String) (obj))).append("&since_id=").append(l).toString();
        }
        obj = new a((new StringBuilder()).append(apiBaseUrl).append("photos/following/show/me.json").append(getApiKeyParamStr(apiKey)).append(s1).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ItemsResponse), "GET", k);
        obj.a = (new StringBuilder()).append(apiBaseUrl).append("photos/following/show/me.json").append(getApiKeyParamStr(apiKey)).append(s1).toString();
        obj.b = (new StringBuilder()).append(apiBackupUrl).append("photos/following/show/me.json").append(getApiKeyParamStr(apiKey)).append(s1).toString();
        obj.c = 3;
        prepare(((Request) (obj)));
        b.a().a(((Request) (obj)), s, d1, false);
        return ((Request) (obj)).d;
    }

    public int getNotifications(String s, String s1, String s2, com.socialin.asyncnet.d d1)
    {
        s = createNotificationsRequest(s, s1);
        b.a().a(s, s2, d1, false);
        return ((Request) (s)).d;
    }

    public int getOwnerBlockedUsers(String s, com.socialin.asyncnet.d d1, int i)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("blocks/show/me.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ViewerUsersResponse), "GET", i);
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getOwnerConnections(String s, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("connections/show/me.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ConnectionsResponse), "GET");
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("connections/show/me.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("connections/show/me.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getOwnerDesigns(ParamWithPageLimit paramwithpagelimit, String s, com.socialin.asyncnet.d d1)
    {
        String s1 = "";
        if (paramwithpagelimit.offset >= 0)
        {
            s1 = (new StringBuilder()).append("").append("&offset=").append(paramwithpagelimit.offset).toString();
        }
        String s2 = s1;
        if (paramwithpagelimit.limit > 0)
        {
            s2 = (new StringBuilder()).append(s1).append("&limit=").append(paramwithpagelimit.limit).toString();
        }
        paramwithpagelimit = new a((new StringBuilder()).append(apiBaseUrl).append("users/designs/show/me.json").append(getApiKeyParamStr(apiKey)).append(s2).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ItemsResponse), "GET");
        b.a().a(paramwithpagelimit, s, d1, false);
        return ((Request) (paramwithpagelimit)).d;
    }

    public int getOwnerFollowers(String s, com.socialin.asyncnet.d d1, int i)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("followers/show/me.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/FollowersResponse), "GET", i);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("followers/show/me.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("followers/show/me.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getOwnerItems(int i, int j, int k, long l, String s, com.socialin.asyncnet.d d1, 
            int i1)
    {
        Object obj = (new StringBuilder("&is_mature=")).append(k).toString();
        String s1 = ((String) (obj));
        if (i >= 0)
        {
            s1 = (new StringBuilder()).append(((String) (obj))).append("&offset=").append(i).toString();
        }
        obj = s1;
        if (j > 0)
        {
            obj = (new StringBuilder()).append(s1).append("&limit=").append(j).toString();
        }
        s1 = ((String) (obj));
        if (l >= 0L)
        {
            s1 = (new StringBuilder()).append(((String) (obj))).append("&since_id=").append(l).toString();
        }
        obj = new a((new StringBuilder()).append(apiBaseUrl).append("users/photos/show/me.json").append(getApiKeyParamStr(apiKey)).append(s1).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ItemsResponse), "GET", i1);
        obj.a = (new StringBuilder()).append(apiBaseUrl).append("users/photos/show/me.json").append(getApiKeyParamStr(apiKey)).append(s1).toString();
        obj.b = (new StringBuilder()).append(apiBackupUrl).append("users/photos/show/me.json").append(getApiKeyParamStr(apiKey)).append(s1).toString();
        obj.c = 3;
        prepare(((Request) (obj)));
        b.a().a(((Request) (obj)), s, d1, false);
        return ((Request) (obj)).d;
    }

    public int getOwnerTags(String s, com.socialin.asyncnet.d d1, int i)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/tags/me.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/TagsResponse), "GET", i);
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getOwnerUser(String s, com.socialin.asyncnet.d d1)
    {
        return getOwnerUser(s, d1, true);
    }

    public int getOwnerUser(String s, com.socialin.asyncnet.d d1, boolean flag)
    {
        String s1;
        a a1;
        if (!flag)
        {
            s1 = (new StringBuilder("&time=")).append(System.currentTimeMillis()).toString();
        } else
        {
            s1 = "";
        }
        a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/show/me.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/User), "GET", 3);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("users/show/me.json").append(getApiKeyParamStr(apiKey)).append(s1).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("users/show/me.json").append(getApiKeyParamStr(apiKey)).append(s1).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getPhoto(long l, boolean flag, String s, com.socialin.asyncnet.d d1)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(apiBaseUrl);
        Object obj;
        if (flag)
        {
            obj = "designs/show/";
        } else
        {
            obj = "photos/show/";
        }
        obj = stringbuilder.append(((String) (obj))).append(l).append(".json").toString();
        obj = new a((new StringBuilder()).append(((String) (obj))).append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ImageItem), "GET");
        prepare(((Request) (obj)));
        b.a().a(((Request) (obj)), s, d1, false);
        return ((Request) (obj)).d;
    }

    public int getPhotoComments(long l, String s, com.socialin.asyncnet.d d1, int i, int j)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("photos/comments/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).append("&offset=").append(i).append("&limit=").append(j).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/CommentsResponse), "GET");
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getPhotoDetails(long l, boolean flag, int i, String s, com.socialin.asyncnet.d d1)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(apiBaseUrl);
        Object obj;
        if (flag)
        {
            obj = "designs/show/";
        } else
        {
            obj = "photos/show/";
        }
        obj = stringbuilder.append(((String) (obj))).append(l).append(".json").toString();
        obj = (new StringBuilder()).append(((String) (obj))).append(getApiKeyParamStr(apiKey)).toString();
        obj = new a((new StringBuilder()).append(((String) (obj))).append("&full=").append(i).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ImageItem), "GET");
        prepare(((Request) (obj)));
        b.a().a(((Request) (obj)), s, d1, false);
        return ((Request) (obj)).d;
    }

    public int getPhotoLikes(long l, String s, com.socialin.asyncnet.d d1, int i, int j)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("photos/likes/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).append("&offset=").append(i).append("&limit=").append(j).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/RatesResponse), "GET");
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getPhotoMemboxes(long l, String s, com.socialin.asyncnet.d d1, int i, int j)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("photos/streams/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).append("&offset=").append(i).append("&limit=").append(j).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/MemboxesResponse), "GET");
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getPhotoReposts(long l, String s, com.socialin.asyncnet.d d1, int i, int j)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("photos/reposts/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).append("&offset=").append(i).append("&limit=").append(j).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/RepostsResponse), "GET");
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getPhotoStreams(long l, boolean flag, String s, com.socialin.asyncnet.d d1)
    {
        String s1;
        a a1;
        if (flag)
        {
            s1 = "designs/streams/show/";
        } else
        {
            s1 = "photos/streams/show/";
        }
        a1 = new a((new StringBuilder()).append(apiBaseUrl).append(s1).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StreamsResponse), "GET");
        a1.a = (new StringBuilder()).append(apiBaseUrl).append(s1).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append(s1).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getPhotos(String s, int i, int j, long l, int k, String s1, 
            com.socialin.asyncnet.d d1, int i1, long l1)
    {
        String s3 = (new StringBuilder()).append(apiBaseUrl).append("photos/show/{type}.json".replace("{type}", s)).toString();
        String s2;
        if (!TextUtils.isEmpty(apiKey))
        {
            s3 = (new StringBuilder()).append(s3).append("?key=").append(apiKey).toString();
            s = (new StringBuilder("&is_mature=")).append(k).toString();
        } else
        {
            s = (new StringBuilder("?is_mature=")).append(k).toString();
        }
        s2 = s;
        if (i >= 0)
        {
            s2 = (new StringBuilder()).append(s).append("&offset=").append(i).toString();
        }
        s = s2;
        if (j > 0)
        {
            s = (new StringBuilder()).append(s2).append("&limit=").append(j).toString();
        }
        s2 = s;
        if (l > 0L)
        {
            s2 = (new StringBuilder()).append(s).append("&max_id=").append(l).toString();
        }
        s = new a((new StringBuilder()).append(s3).append(s2).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ItemsResponse), "GET", i1);
        s.a(l1);
        prepare(s);
        b.a().a(s, s1, d1, false);
        return ((Request) (s)).d;
    }

    public int getPhotosLocGrouped(long l, boolean flag, int i, int j, int k, String s, 
            com.socialin.asyncnet.d d1)
    {
        Object obj = new StringBuilder();
        if (flag)
        {
            ((StringBuilder) (obj)).append(apiBaseUrl).append("users/photos/places/me.json");
        } else
        {
            ((StringBuilder) (obj)).append(apiBaseUrl).append("users/photos/places/").append(l).append(".json");
        }
        ((StringBuilder) (obj)).append('?');
        if (i >= 0)
        {
            ((StringBuilder) (obj)).append("offset=").append(i);
        }
        if (j > 0)
        {
            ((StringBuilder) (obj)).append("&limit=").append(j);
        }
        if (!TextUtils.isEmpty(apiKey))
        {
            ((StringBuilder) (obj)).append("&key=").append(apiKey);
        }
        ((StringBuilder) (obj)).append("&is_mature=").append(k);
        obj = new a(((StringBuilder) (obj)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/LocationsResponse), "GET");
        prepare(((Request) (obj)));
        b.a().a(((Request) (obj)), s, d1, false);
        return ((Request) (obj)).d;
    }

    public int getPicsartNews(String s, String s1, String s2, com.socialin.asyncnet.d d1, int i, long l)
    {
        s2 = new a((new StringBuilder()).append(apiBaseUrl).append("apps.json?type=news&app=com.picsart.studio&market=").append(s2).toString(), NewsResponseParser.getInstance(), "GET", i);
        s2.a(l);
        if (s != null)
        {
            s2.b("since_id", s);
        }
        prepare(s2);
        b.a().a(s2, s1, d1, false);
        return ((Request) (s2)).d;
    }

    public int getPopularDesigns(ParamWithPageLimit paramwithpagelimit, String s, com.socialin.asyncnet.d d1, int i, long l)
    {
        String s2 = "?v=0";
        if (paramwithpagelimit.offset >= 0)
        {
            s2 = (new StringBuilder()).append("?v=0").append("&offset=").append(paramwithpagelimit.offset).toString();
        }
        String s1 = s2;
        if (paramwithpagelimit.limit > 0)
        {
            s1 = (new StringBuilder()).append(s2).append("&limit=").append(paramwithpagelimit.limit).toString();
        }
        s2 = s1;
        if (paramwithpagelimit.lastId > 0L)
        {
            s2 = (new StringBuilder()).append(s1).append("&since_id=").append(paramwithpagelimit.lastId).toString();
        }
        paramwithpagelimit = new a((new StringBuilder()).append(apiBaseUrl).append("designs/show/popular.json").append(s2).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ItemsResponse), "GET", i);
        paramwithpagelimit.a(l);
        b.a().a(paramwithpagelimit, s, d1, false);
        return ((Request) (paramwithpagelimit)).d;
    }

    public int getPopularItems(int i, int j, int k, String s, com.socialin.asyncnet.d d1, int l, long l1)
    {
        String s1 = "";
        if (!TextUtils.isEmpty(apiKey))
        {
            s1 = (new StringBuilder()).append("").append("key=").append(apiKey).toString();
        }
        Object obj = s1;
        if (i >= 0)
        {
            obj = (new StringBuilder()).append(s1).append("&offset=").append(i).toString();
        }
        s1 = ((String) (obj));
        if (j > 0)
        {
            s1 = (new StringBuilder()).append(((String) (obj))).append("&limit=").append(j).toString();
        }
        obj = s1;
        if (k >= 0)
        {
            obj = (new StringBuilder()).append(s1).append("&is_mature=").append(k).toString();
        }
        s1 = ((String) (obj));
        if (TextUtils.isEmpty(apiKey))
        {
            s1 = ((String) (obj));
            if (((String) (obj)).length() > 0)
            {
                s1 = ((String) (obj)).substring(1);
            }
        }
        obj = new a((new StringBuilder()).append(apiBaseUrl).append("photos/show/popular.json?").append(s1).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ItemsResponse), "GET", l);
        ((Request) (obj)).a(l1);
        prepare(((Request) (obj)));
        b.a().a(((Request) (obj)), s, d1, false);
        return ((Request) (obj)).d;
    }

    public int getRecentItems(int i, int j, int k, long l, String s, com.socialin.asyncnet.d d1, 
            int i1, long l1)
    {
        String s1 = "";
        if (!TextUtils.isEmpty(apiKey))
        {
            s1 = (new StringBuilder()).append("").append("key=").append(apiKey).toString();
        }
        Object obj = s1;
        if (i >= 0)
        {
            obj = (new StringBuilder()).append(s1).append("&offset=").append(i).toString();
        }
        s1 = ((String) (obj));
        if (j > 0)
        {
            s1 = (new StringBuilder()).append(((String) (obj))).append("&limit=").append(j).toString();
        }
        obj = s1;
        if (k >= 0)
        {
            obj = (new StringBuilder()).append(s1).append("&is_mature=").append(k).toString();
        }
        s1 = ((String) (obj));
        if (l > 0L)
        {
            s1 = (new StringBuilder()).append(((String) (obj))).append("&max_id=").append(l).toString();
        }
        obj = s1;
        if (TextUtils.isEmpty(apiKey))
        {
            obj = s1;
            if (s1.length() > 0)
            {
                obj = s1.substring(1);
            }
        }
        obj = new a((new StringBuilder()).append(apiBaseUrl).append("photos/show/recent.json?").append(((String) (obj))).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ItemsResponse), "GET", i1);
        ((Request) (obj)).a(l1);
        prepare(((Request) (obj)));
        b.a().a(((Request) (obj)), s, d1, false);
        return ((Request) (obj)).d;
    }

    public int getShopBanners(String s, com.socialin.asyncnet.d d1, int i, String s1)
    {
        s1 = (new StringBuilder("?app=com.picsart.studio&market=")).append(s1).append("&type=banners_shop").toString();
        s1 = new a((new StringBuilder()).append(apiBaseUrl).append("apps.json").append(s1).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ShopBannersResponse), "GET", i);
        prepare(s1);
        b.a().a(s1, s, d1, false);
        return ((Request) (s1)).d;
    }

    public int getShopItems(String s, com.socialin.asyncnet.d d1, int i, String s1, String s2, String s3, int j, 
            int k)
    {
        StringBuilder stringbuilder = (new StringBuilder("?app=com.picsart.studio&market=")).append(s1).append("&type=apps");
        if (s2 == null || "all".equalsIgnoreCase(s2))
        {
            s1 = "";
        } else
        {
            s1 = (new StringBuilder("&price=")).append(s2).toString();
        }
        s2 = stringbuilder.append(s1).append("&offset=").append(k).append("&limit=").append(j);
        if (s3 == null)
        {
            s1 = "";
        } else
        {
            s1 = (new StringBuilder("&tag=")).append(s3).toString();
        }
        s1 = s2.append(s1).toString();
        s1 = new a((new StringBuilder()).append(apiBaseUrl).append("apps.json").append(s1).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ShopItemsListResponse), "GET", i);
        prepare(s1);
        b.a().a(s1, s, d1, false);
        return ((Request) (s1)).d;
    }

    public int getStickerStream(String s, com.socialin.asyncnet.d d1, int i)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("streams/show/sticker.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/Stream), "GET", i);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("streams/show/sticker.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBaseUrl).append("streams/show/sticker.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getStreamPhotos(long l, int i, String s, com.socialin.asyncnet.d d1, int j)
    {
        String s1 = (new StringBuilder("&is_mature=")).append(i).toString();
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("streams/show/").append(String.valueOf(l)).append(".json").append(getApiKeyParamStr(apiKey)).append(s1).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/Stream), "GET", j);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("streams/show/").append(String.valueOf(l)).append(".json").append(getApiKeyParamStr(apiKey)).append(s1).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("streams/show/").append(String.valueOf(l)).append(".json").append(getApiKeyParamStr(apiKey)).append(s1).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getTagsGrouped(String s, int i, int j, String s1, com.socialin.asyncnet.d d1, int k, long l)
    {
        String s2 = (new StringBuilder()).append(apiBaseUrl).append("tags/show/{type}.json".replace("{type}", s)).append("?").toString();
        s = s2;
        if (!TextUtils.isEmpty(apiKey))
        {
            s = (new StringBuilder()).append(s2).append("key=").append(apiKey).toString();
        }
        s2 = s;
        if (i >= 0)
        {
            s2 = (new StringBuilder()).append(s).append("&offset=").append(i).toString();
        }
        s = s2;
        if (j > 0)
        {
            s = (new StringBuilder()).append(s2).append("&limit=").append(j).toString();
        }
        s = new a(s, ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/TagsResponse), "GET", k);
        s.a(l);
        prepare(s);
        b.a().a(s, s1, d1, false);
        return ((Request) (s)).d;
    }

    public int getUserCards(GetItemsParams getitemsparams, String s, com.socialin.asyncnet.d d1, int i, boolean flag)
    {
        String s2 = (new StringBuilder()).append(apiBaseUrl).append("cards.json?type=users").toString();
        String s1 = s2;
        if (!TextUtils.isEmpty(apiKey))
        {
            s1 = (new StringBuilder()).append(s2).append("&key=").append(apiKey).toString();
        }
        s1 = (new StringBuilder()).append(s1).append("&location_lat=").append(String.valueOf(getitemsparams.latitude)).append("&location_lon=").append(String.valueOf(getitemsparams.longitude)).toString();
        s2 = (new StringBuilder()).append(s1).append("&market=").append(SocialinV3.market).toString();
        s1 = s2;
        if (getitemsparams.offset >= 0)
        {
            s1 = (new StringBuilder()).append(s2).append("&offset=").append(getitemsparams.offset).toString();
        }
        s2 = s1;
        if (getitemsparams.limit > 0)
        {
            s2 = (new StringBuilder()).append(s1).append("&limit=").append(getitemsparams.limit).toString();
        }
        getitemsparams = new a(s2, ResponseParserFactory.createCardResponseParser(flag), "GET", i);
        getitemsparams.i = true;
        prepare(getitemsparams);
        b.a().a(getitemsparams, s, d1, false);
        return ((Request) (getitemsparams)).d;
    }

    public int getUserDesigns(GetUserDesignsParams getuserdesignsparams, String s, com.socialin.asyncnet.d d1)
    {
        String s1 = "";
        if (getuserdesignsparams.offset >= 0)
        {
            s1 = (new StringBuilder()).append("").append("&offset=").append(getuserdesignsparams.offset).toString();
        }
        String s2 = s1;
        if (getuserdesignsparams.limit > 0)
        {
            s2 = (new StringBuilder()).append(s1).append("&limit=").append(getuserdesignsparams.limit).toString();
        }
        getuserdesignsparams = new a((new StringBuilder()).append(apiBaseUrl).append("users/designs/show/").append(getuserdesignsparams.userId).append(".json").append(getApiKeyParamStr(apiKey)).append(s2).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ItemsResponse), "GET");
        b.a().a(getuserdesignsparams, s, d1, false);
        return ((Request) (getuserdesignsparams)).d;
    }

    public int getUserPhotosByLocation(String s, long l, long l1, int i, int j, 
            String s1, com.socialin.asyncnet.d d1, int k)
    {
        String s2 = (new StringBuilder("&place=")).append(s).toString();
        s = s2;
        if (l1 > 0L)
        {
            s = (new StringBuilder()).append(s2).append("&max_id=").append(l1).toString();
        }
        s2 = s;
        if (i >= 0)
        {
            s2 = (new StringBuilder()).append(s).append("&offset=").append(i).toString();
        }
        s = s2;
        if (j >= 0)
        {
            s = (new StringBuilder()).append(s2).append("&limit=").append(j).toString();
        }
        if (SocialinV3.getInstance().isRegistered() && l == SocialinV3.getInstance().getUser().id)
        {
            s2 = "users/photos/places/me.json";
        } else
        {
            s2 = (new StringBuilder("users/photos/places/")).append(l).append(".json").toString();
        }
        s = new a((new StringBuilder()).append(apiBaseUrl).append(s2).append(getApiKeyParamStr(apiKey)).append(s).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ItemsResponse), "GET", k);
        prepare(s);
        b.a().a(s, s1, d1, false);
        return ((Request) (s)).d;
    }

    public int getUserPhotosByTag(long l, String s, long l1, String s1, int i, 
            int j, com.socialin.asyncnet.d d1, int k)
    {
        String s2 = (new StringBuilder("&tag=")).append(s).toString();
        s = s2;
        if (l > 0L)
        {
            s = (new StringBuilder()).append(s2).append("&max_id=").append(l).toString();
        }
        s2 = s;
        if (i >= 0)
        {
            s2 = (new StringBuilder()).append(s).append("&offset=").append(i).toString();
        }
        if (j >= 0)
        {
            s = (new StringBuilder()).append(s2).append("&limit=").append(j).toString();
        } else
        {
            s = s2;
        }
        if (l1 <= 0L || l1 == SocialinV3.getInstance().getUser().id)
        {
            s2 = (new StringBuilder()).append(apiBaseUrl).append("users/photos/tags/me.json").toString();
        } else
        {
            s2 = (new StringBuilder()).append(apiBaseUrl).append("users/photos/tags/").append(l1).append(".json").toString();
        }
        s = new a((new StringBuilder()).append(s2).append(getApiKeyParamStr(apiKey)).append(s).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ItemsResponse), "GET", k);
        prepare(s);
        b.a().a(s, s1, d1, false);
        return ((Request) (s)).d;
    }

    public int getUserRecentTags(long l, String s, com.socialin.asyncnet.d d1, int i)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("tags/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/RecentTagsResponse), "GET", i);
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getUserShopItems(String s, com.socialin.asyncnet.d d1, int i)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("apps/show/me.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ShopItemsListResponse), "GET", i);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("apps/show/me.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("apps/show/me.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getUserSuggestions(String s, int i, int j, String s1, com.socialin.asyncnet.d d1, int k)
    {
        String s2;
        if (s != null)
        {
            s2 = (new StringBuilder("?q=")).append(s).toString();
        } else
        {
            s2 = (new StringBuilder("?v=")).append((int)Math.ceil(Math.random() * 5D)).toString();
        }
        s = s2;
        if (i >= 0)
        {
            s = (new StringBuilder()).append(s2).append("&offset=").append(i).toString();
        }
        s2 = s;
        if (j > 0)
        {
            s2 = (new StringBuilder()).append(s).append("&limit=").append(j).toString();
        }
        s = s2;
        if (apiKey != null)
        {
            s = (new StringBuilder()).append(s2).append("&key=").append(apiKey).toString();
        }
        s = new a((new StringBuilder()).append(apiBaseUrl).append("users/suggestions.json").append(s).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ViewerUsersResponse), "GET", k);
        prepare(s);
        b.a().a(s, s1, d1, false);
        return ((Request) (s)).d;
    }

    public int getUsers(String s, int i, int j, int k, String s1, com.socialin.asyncnet.d d1, int l, 
            long l1)
    {
        String s3 = (new StringBuilder()).append(apiBaseUrl).append("users/show/{type}.json".replace("{type}", s)).toString();
        String s2;
        if (!TextUtils.isEmpty(apiKey))
        {
            s3 = (new StringBuilder()).append(s3).append("?key=").append(apiKey).toString();
            s = (new StringBuilder("&is_mature=")).append(k).toString();
        } else
        {
            s = (new StringBuilder("?is_mature=")).append(k).toString();
        }
        s2 = s;
        if (i >= 0)
        {
            s2 = (new StringBuilder()).append(s).append("&offset=").append(i).toString();
        }
        s = s2;
        if (j > 0)
        {
            s = (new StringBuilder()).append(s2).append("&limit=").append(j).toString();
        }
        s = (new StringBuilder()).append(s).append("&paging=1").toString();
        s = (new StringBuilder()).append(s).append("&format=new").toString();
        s = new a((new StringBuilder()).append(s3).append(s).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ViewerUsersResponse), "GET", l);
        s.a(l1);
        prepare(s);
        b.a().a(s, s1, d1, false);
        return ((Request) (s)).d;
    }

    public int getViewerBlockedUsers(long l, String s, com.socialin.asyncnet.d d1, int i)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("blocks/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ViewerUsersResponse), "GET", i);
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getViewerFollowers(long l, int i, int j, String s, String s1, com.socialin.asyncnet.d d1, 
            int k)
    {
        String s3 = "";
        if (i >= 0)
        {
            s3 = (new StringBuilder()).append("").append("&offset=").append(i).toString();
        }
        String s2 = s3;
        if (j > 0)
        {
            s2 = (new StringBuilder()).append(s3).append("&limit=").append(j).toString();
        }
        s3 = s2;
        if (s != null)
        {
            s3 = s2;
            if (!s.trim().equals(""))
            {
                try
                {
                    s3 = (new StringBuilder()).append(s2).append("&user=").append(URLEncoder.encode(s, e.a.name())).toString();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                    s3 = s2;
                }
            }
        }
        s = new a((new StringBuilder()).append(apiBaseUrl).append("followers/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).append(s3).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/FollowersResponse), "GET", k);
        s.a = (new StringBuilder()).append(apiBaseUrl).append("followers/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).append(s3).toString();
        s.b = (new StringBuilder()).append(apiBackupUrl).append("followers/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).append(s3).toString();
        s.c = 3;
        prepare(s);
        b.a().a(s, s1, d1, false);
        return ((Request) (s)).d;
    }

    public int getViewerFollowings(long l, int i, int j, String s, String s1, com.socialin.asyncnet.d d1, 
            int k)
    {
        String s3 = "";
        if (i >= 0)
        {
            s3 = (new StringBuilder()).append("").append("&offset=").append(i).toString();
        }
        String s2 = s3;
        if (j > 0)
        {
            s2 = (new StringBuilder()).append(s3).append("&limit=").append(j).toString();
        }
        s3 = s2;
        if (s != null)
        {
            s3 = s2;
            if (!s.trim().equals(""))
            {
                try
                {
                    s3 = (new StringBuilder()).append(s2).append("&user=").append(URLEncoder.encode(s, e.a.name())).toString();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                    s3 = s2;
                }
            }
        }
        s = new a((new StringBuilder()).append(apiBaseUrl).append("following/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).append(s3).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/FollowersResponse), "GET", k);
        s.a = (new StringBuilder()).append(apiBaseUrl).append("following/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).append(s3).toString();
        s.b = (new StringBuilder()).append(apiBackupUrl).append("following/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).append(s3).toString();
        s.c = 3;
        prepare(s);
        b.a().a(s, s1, d1, false);
        return ((Request) (s)).d;
    }

    public int getViewerItems(long l, int i, int j, int k, int i1, long l1, String s, com.socialin.asyncnet.d d1, int j1)
    {
        Object obj = "";
        if (i >= 0)
        {
            obj = (new StringBuilder()).append("").append("&offset=").append(i).toString();
        }
        String s1 = ((String) (obj));
        if (j > 0)
        {
            s1 = (new StringBuilder()).append(((String) (obj))).append("&limit=").append(j).toString();
        }
        obj = s1;
        if (l1 >= 0L)
        {
            obj = (new StringBuilder()).append(s1).append("&since_id=").append(l1).toString();
        }
        s1 = (new StringBuilder()).append(((String) (obj))).append("&interesting=").append(k).toString();
        s1 = (new StringBuilder()).append(s1).append("&is_mature=").append(i1).toString();
        obj = new a((new StringBuilder()).append(apiBaseUrl).append("users/photos/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).append(s1).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ItemsResponse), "GET", j1);
        obj.a = (new StringBuilder()).append(apiBaseUrl).append("users/photos/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).append(s1).toString();
        obj.b = (new StringBuilder()).append(apiBackupUrl).append("users/photos/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).append(s1).toString();
        obj.c = 3;
        prepare(((Request) (obj)));
        b.a().a(((Request) (obj)), s, d1, false);
        return ((Request) (obj)).d;
    }

    public int getViewerStreams(long l, String s, com.socialin.asyncnet.d d1, int i)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/streams/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StreamsResponse), "GET", i);
        String s1 = getApiKeyParamStr(apiKey);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("users/streams/show/").append(l).append(".json").append(s1).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("users/streams/show/").append(l).append(".json").append(s1).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int getViewerTags(long l, int i, int j, int k, String s, com.socialin.asyncnet.d d1, 
            int i1)
    {
        String s1 = (new StringBuilder("&is_mature=")).append(k).toString();
        Object obj = s1;
        if (i >= 0)
        {
            obj = (new StringBuilder()).append(s1).append("&offset=").append(i).toString();
        }
        s1 = ((String) (obj));
        if (j >= 0)
        {
            s1 = (new StringBuilder()).append(((String) (obj))).append("&limit=").append(j).toString();
        }
        obj = new a((new StringBuilder()).append(apiBaseUrl).append("users/photos/tags/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).append(s1).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/TagsResponse), "GET", i1);
        prepare(((Request) (obj)));
        b.a().a(((Request) (obj)), s, d1, false);
        return ((Request) (obj)).d;
    }

    public int getViewerUser(long l, String s, String s1, com.socialin.asyncnet.d d1, int i)
    {
        a a1;
        if (l > 0L)
        {
            s = (new StringBuilder()).append(apiBaseUrl).append("users/show/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        } else
        if (s != null)
        {
            s = (new StringBuilder()).append(apiBaseUrl).append("users/show/").append(s).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        } else
        {
            s = (new StringBuilder()).append(apiBaseUrl).append("users/show/.json").append(getApiKeyParamStr(apiKey)).toString();
        }
        a1 = new a(s, ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ViewerUser), "GET", i);
        a1.a = s;
        a1.b = s;
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s1, d1, false);
        return ((Request) (a1)).d;
    }

    public int getWhatsNewItems(String s, com.socialin.asyncnet.d d1, ParamWithPageLimit paramwithpagelimit)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(apiBaseUrl).append("whatsnew.jsonversion=").append(versionCode);
        if (paramwithpagelimit.lastId > 0L)
        {
            paramwithpagelimit = (new StringBuilder("&since_id=")).append(paramwithpagelimit.lastId).toString();
        } else
        {
            paramwithpagelimit = "";
        }
        paramwithpagelimit = new a(stringbuilder.append(paramwithpagelimit).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/WhatsNewResponse), "GET");
        prepare(paramwithpagelimit);
        b.a().a(paramwithpagelimit, s, d1, false);
        return ((Request) (paramwithpagelimit)).d;
    }

    public int likePhoto(long l, boolean flag, String s, com.socialin.asyncnet.d d1)
    {
        String s1;
        a a1;
        if (flag)
        {
            s1 = "designs/likes/add/";
        } else
        {
            s1 = "photos/likes/add/";
        }
        a1 = new a((new StringBuilder()).append(apiBaseUrl).append(s1).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.a = (new StringBuilder()).append(apiBaseUrl).append(s1).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append(s1).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int newGetPopUsers(int i, int j, String s, com.socialin.asyncnet.d d1, int k)
    {
        Object obj = (new StringBuilder()).append(apiBaseUrl).append("users/show/popular.json").toString();
        obj = new a((new StringBuilder()).append(((String) (obj))).append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ViewerUsersResponse), "GET", k);
        prepare(((Request) (obj)));
        b.a().a(((Request) (obj)), s, d1, false);
        return ((Request) (obj)).d;
    }

    public void prepare(Request request)
    {
    }

    public int removeBlockedUser(long l, String s, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("blocks/remove/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("blocks/remove/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("blocks/remove/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int removeComment(long l, String s, boolean flag, String s1, com.socialin.asyncnet.d d1)
    {
        String s2;
        a a1;
        if (flag)
        {
            s2 = "designs/comments/remove/";
        } else
        {
            s2 = "photos/comments/remove/";
        }
        a1 = new a((new StringBuilder()).append(apiBaseUrl).append(s2).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.b("comment_id", s);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append(s2).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append(s2).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s1, d1, false);
        return ((Request) (a1)).d;
    }

    public int removeConnection(String s, com.socialin.asyncnet.d d1, String s1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("connections/remove.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.b("provider", s1);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("connections/remove.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("connections/remove.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int removeDevice(String s, com.socialin.asyncnet.d d1, String s1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/devices/remove.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.b("device", s);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("users/devices/remove.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("users/devices/remove.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s1, d1, false);
        return 0;
    }

    public int removeFollowing(long l, String s, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("following/remove/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("following/remove/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("following/remove/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int removePhoto(long l, boolean flag, String s, com.socialin.asyncnet.d d1)
    {
        String s1;
        a a1;
        if (flag)
        {
            s1 = "designs/remove/";
        } else
        {
            s1 = "photos/remove/";
        }
        a1 = new a((new StringBuilder()).append(apiBaseUrl).append(s1).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.a = (new StringBuilder()).append(apiBaseUrl).append(s1).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append(s1).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int removeShopItem(String s, com.socialin.asyncnet.d d1, String s1, int i)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("apps/remove/").append(s1).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/Response), "POST");
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("apps/remove/").append(s1).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("apps/remove/").append(s1).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int removeStream(long l, String s, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("streams/remove/").append(String.valueOf(l)).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int removeStreamPhoto(long l, long l1, boolean flag, String s, com.socialin.asyncnet.d d1)
    {
        Object obj = (new StringBuilder()).append(apiBaseUrl);
        String s1;
        if (flag)
        {
            s1 = "streams/designs/remove/";
        } else
        {
            s1 = "streams/photos/remove/";
        }
        s1 = ((StringBuilder) (obj)).append(s1).append(String.valueOf(l)).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        obj = new a(s1, ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        ((Request) (obj)).b("photo_id", String.valueOf(l1));
        obj.a = s1;
        obj.b = s1;
        obj.c = 3;
        prepare(((Request) (obj)));
        b.a().a(((Request) (obj)), s, d1, false);
        return ((Request) (obj)).d;
    }

    public int removeTagFollowing(long l, String s, String s1, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/tags/remove.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("users/tags/remove.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("users/tags/remove.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b("tag", s);
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s1, d1, false);
        return ((Request) (a1)).d;
    }

    public int renameStream(long l, String s, String s1, String s2, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("streams/rename/").append(String.valueOf(l)).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/Stream), "POST");
        a1.b("title", s);
        a1.b("desc", s1);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("streams/rename/").append(String.valueOf(l)).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("streams/rename/").append(String.valueOf(l)).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s2, d1, false);
        return ((Request) (a1)).d;
    }

    public int reportPhoto(long l, String s, String s1, String s2, String s3, String s4, 
            String s5, String s6, String s7, boolean flag, boolean flag1, String s8, boolean flag2, 
            String s9, com.socialin.asyncnet.d d1)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(apiBaseUrl);
        Object obj;
        if (flag2)
        {
            obj = "designs/reports/add/";
        } else
        {
            obj = "photos/reports/add/";
        }
        obj = new a(stringbuilder.append(((String) (obj))).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        ((Request) (obj)).b("type", s);
        if (s1 != null)
        {
            ((Request) (obj)).b("material_url", s1);
            ((Request) (obj)).b("description ", s2);
            ((Request) (obj)).b("first_name", s3);
            ((Request) (obj)).b("last_name", s4);
            ((Request) (obj)).b("address", s5);
            ((Request) (obj)).b("phone", s6);
            ((Request) (obj)).b("email", s7);
            if (flag)
            {
                s = "1";
            } else
            {
                s = "0";
            }
            ((Request) (obj)).b("is_owner", s);
            if (flag1)
            {
                s = "1";
            } else
            {
                s = "0";
            }
            ((Request) (obj)).b("is_accurate", s);
            ((Request) (obj)).b("signature", s8);
        }
        prepare(((Request) (obj)));
        b.a().a(((Request) (obj)), s9, d1, false);
        return ((Request) (obj)).d;
    }

    public int repostPhoto(long l, String s, com.socialin.asyncnet.d d1)
    {
        String s1 = (new StringBuilder()).append("").append("add/").toString();
        s1 = (new StringBuilder()).append(s1).append(l).append(".json").toString();
        s1 = (new StringBuilder()).append(s1).append(getApiKeyParamStr(apiKey)).toString();
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("photos/reposts/").append(s1).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("photos/reposts/").append(s1).toString();
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int requestAddCoins(String s, com.socialin.asyncnet.d d1, String s1, String s2, int i)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/balance/add.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/AddCoinsResponse), "POST");
        a1.b("amount", s1);
        a1.b("data", s2);
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("users/balance/add.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("users/balance/add.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public String requestForInviteTemplate(String s, long l)
    {
        String s1 = "http://picsart.com/template/invites?";
        if (!TextUtils.isEmpty(s))
        {
            s1 = (new StringBuilder()).append("http://picsart.com/template/invites?").append("type=").append(s).toString();
        }
        s = s1;
        if (l >= 0L)
        {
            s = (new StringBuilder()).append(s1).append("userid=").append(l).toString();
        }
        s = new BufferedInputStream((new HttpRequest(s, "GET")).f());
        try
        {
            s = (new Scanner(s, "UTF-8")).useDelimiter("\\A").next();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public int resetPassword(String s, String s1, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/reset.json").toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        if (TextUtils.isEmpty(s))
        {
            a1.b("user", s1);
        } else
        if (TextUtils.isEmpty(s1))
        {
            a1.b("user", s);
        } else
        {
            throw new IllegalStateException("username or email maust not be null or empty");
        }
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("users/reset.json").toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("users/reset.json").toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, null, d1, false);
        return ((Request) (a1)).d;
    }

    public int retrieveStripeToken(String s, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/payments/token/show.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/stripe/StripeTokenResponse), "GET");
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int saveStripeToken(String s, StripeTokenParams stripetokenparams, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/payments/token/add.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/Response), "POST");
        a1.b("stripe_token", stripetokenparams.tokenValue);
        a1.b("provider", stripetokenparams.provider);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int searchInsideFollowings(String s, com.socialin.asyncnet.d d1, GetUsersParams getusersparams)
    {
        String s1 = (new StringBuilder("?key=")).append(apiKey).toString();
        String s2 = s1;
        if (getusersparams != null)
        {
            s2 = s1;
            if (getusersparams.offset >= 0)
            {
                s2 = (new StringBuilder()).append(s1).append("&offset=").append(getusersparams.offset).toString();
            }
            s1 = s2;
            if (getusersparams.limit > 0)
            {
                s1 = (new StringBuilder()).append(s2).append("&limit=").append(getusersparams.limit).toString();
            }
            s2 = s1;
            if (!TextUtils.isEmpty(getusersparams.username))
            {
                try
                {
                    s2 = (new StringBuilder()).append(s1).append("&user=").append(URLEncoder.encode(getusersparams.username, e.a.name())).toString();
                }
                // Misplaced declaration of an exception variable
                catch (GetUsersParams getusersparams)
                {
                    getusersparams.printStackTrace();
                    s2 = s1;
                }
            }
        }
        getusersparams = new a((new StringBuilder()).append(apiBaseUrl).append("following/show/me.json").append(s2).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ViewerUsersResponse), "GET");
        prepare(getusersparams);
        b.a().a(getusersparams, s, d1, false);
        return ((Request) (getusersparams)).d;
    }

    public int searchItems(GetItemsParams getitemsparams, String s, com.socialin.asyncnet.d d1, int i)
    {
        Object obj = (new StringBuilder("?is_mature=")).append(getitemsparams.contentRating).toString();
        Object obj1 = obj;
        if (getitemsparams.offset >= 0)
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append("&offset=").append(getitemsparams.offset).toString();
        }
        obj = obj1;
        if (getitemsparams.limit > 0)
        {
            obj = (new StringBuilder()).append(((String) (obj1))).append("&limit=").append(getitemsparams.limit).toString();
        }
        obj1 = obj;
        if (getitemsparams.searchQuery != null)
        {
            try
            {
                obj1 = (new StringBuilder()).append(((String) (obj))).append("&q=").append(URLEncoder.encode(getitemsparams.searchQuery, e.a.name())).toString();
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                unsupportedencodingexception.printStackTrace();
                unsupportedencodingexception = ((UnsupportedEncodingException) (obj));
            }
        }
        obj = obj1;
        if (getitemsparams.searchTag != null)
        {
            obj = (new StringBuilder()).append(((String) (obj1))).append("&tag=").append(getitemsparams.searchTag).toString();
        }
        obj1 = obj;
        if (getitemsparams.searchLocation != null)
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append("&location=").append(getitemsparams.searchLocation).toString();
        }
        obj = obj1;
        if (getitemsparams.searchNear != null)
        {
            obj = (new StringBuilder()).append(((String) (obj1))).append("&near=").append(getitemsparams.searchNear).toString();
        }
        obj1 = obj;
        if (getitemsparams.userId > 0L)
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append("&user_id=").append(getitemsparams.userId).toString();
        }
        obj = obj1;
        if (getitemsparams.interesting > 0)
        {
            obj = (new StringBuilder()).append(((String) (obj1))).append("&interesting=").append(getitemsparams.interesting).toString();
        }
        obj1 = obj;
        if (getitemsparams.recent > 0)
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append("&recent=").append(getitemsparams.recent).toString();
        }
        obj = obj1;
        if (getitemsparams.lastId > 0L)
        {
            obj = (new StringBuilder()).append(((String) (obj1))).append("&max_id=").append(getitemsparams.lastId).toString();
        }
        getitemsparams = ((GetItemsParams) (obj));
        if (!TextUtils.isEmpty(apiKey))
        {
            getitemsparams = (new StringBuilder()).append(((String) (obj))).append("&key=").append(apiKey).toString();
        }
        obj = (new StringBuilder()).append(apiBaseUrl).append("photos/search.json").append(getitemsparams);
        if (d.b)
        {
            getitemsparams = (new StringBuilder("&t=")).append(System.currentTimeMillis()).toString();
        } else
        {
            getitemsparams = "";
        }
        getitemsparams = new a(((StringBuilder) (obj)).append(getitemsparams).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ItemsResponse), "GET", i);
        prepare(getitemsparams);
        b.a().a(getitemsparams, s, d1, false);
        return ((Request) (getitemsparams)).d;
    }

    public int searchTags(GetTagsParams gettagsparams, String s, com.socialin.asyncnet.d d1, int i)
    {
        String s1;
        String s2;
        try
        {
            s1 = URLEncoder.encode(gettagsparams.tag, e.a.name());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            d.b("SocialinApi", "searchTags", unsupportedencodingexception);
            unsupportedencodingexception = gettagsparams.tag;
        }
        s2 = (new StringBuilder("?tag=")).append(s1).toString();
        s1 = s2;
        if (gettagsparams.offset >= 0)
        {
            s1 = (new StringBuilder()).append(s2).append("&offset=").append(gettagsparams.offset).toString();
        }
        s2 = s1;
        if (gettagsparams.limit > 0)
        {
            s2 = (new StringBuilder()).append(s1).append("&limit=").append(gettagsparams.limit).toString();
        }
        gettagsparams = s2;
        if (!TextUtils.isEmpty(apiKey))
        {
            gettagsparams = (new StringBuilder()).append(s2).append("&key=").append(apiKey).toString();
        }
        gettagsparams = new a((new StringBuilder()).append(apiBaseUrl).append("tags/suggestions.json").append(gettagsparams).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/TagsResponse), "GET", i);
        prepare(gettagsparams);
        b.a().a(gettagsparams, s, d1, false);
        return ((Request) (gettagsparams)).d;
    }

    public int searchTagsByLocation(String s, com.socialin.asyncnet.d d1, LocationParams locationparams)
    {
        String s1 = "";
        if (locationparams != null)
        {
            String s2 = (new StringBuilder("?coordinates=")).append(locationparams.longitude).append(",").append(locationparams.latitude).toString();
            s1 = s2;
            if (!TextUtils.isEmpty(locationparams.locationCategoryId))
            {
                s1 = s2;
                if (!"null".equals(locationparams.locationCategoryId))
                {
                    s1 = (new StringBuilder()).append(s2).append("&location_category_id=").append(locationparams.locationCategoryId).toString();
                }
            }
        }
        locationparams = new a((new StringBuilder()).append(apiBaseUrl).append("tags/places/suggestions.json").append(s1).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/TagsResponse), "GET");
        prepare(locationparams);
        b.a().a(locationparams, s, d1, false);
        return ((Request) (locationparams)).d;
    }

    public int searchUsers(GetUsersParams getusersparams, String s, com.socialin.asyncnet.d d1, int i)
    {
        String s2 = "";
        String s1 = s2;
        char c;
        try
        {
            if (getusersparams.query != null)
            {
                s1 = (new StringBuilder("?q=")).append(URLEncoder.encode(getusersparams.query, e.a.name())).toString();
            }
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
            unsupportedencodingexception = s2;
        }
        if ("".equals(s1))
        {
            c = '?';
        } else
        {
            c = '&';
        }
        s2 = s1;
        if (getusersparams.fbIds != null)
        {
            s2 = (new StringBuilder()).append(s1).append(c).append("fb=").append(getusersparams.fbIds).toString();
        }
        s1 = s2;
        if (getusersparams.twitterIds != null)
        {
            s1 = (new StringBuilder()).append(s2).append(c).append("tw=").append(getusersparams.twitterIds).toString();
        }
        s2 = s1;
        if (getusersparams.instagramIds != null)
        {
            s2 = (new StringBuilder()).append(s1).append(c).append("is=").append(getusersparams.instagramIds).toString();
        }
        s1 = s2;
        if (getusersparams.username != null)
        {
            s1 = (new StringBuilder()).append(s2).append(c).append("username=").append(getusersparams.username).toString();
        }
        s2 = s1;
        if (getusersparams.near != null)
        {
            s2 = (new StringBuilder()).append(s1).append(c).append("near=").append(getusersparams.near).toString();
        }
        s1 = s2;
        if (getusersparams.offset >= 0)
        {
            s1 = (new StringBuilder()).append(s2).append('&').append("offset=").append(getusersparams.offset).toString();
        }
        s2 = s1;
        if (getusersparams.limit > 0)
        {
            s2 = (new StringBuilder()).append(s1).append('&').append("limit=").append(getusersparams.limit).toString();
        }
        s1 = s2;
        if (apiKey != null)
        {
            s1 = (new StringBuilder()).append(s2).append('&').append("key=").append(apiKey).toString();
        }
        s2 = s1;
        if (getusersparams.isFollowing != null)
        {
            s2 = (new StringBuilder()).append(s1).append('&').append("is_following=").append(getusersparams.isFollowing).toString();
        }
        getusersparams = new a((new StringBuilder()).append(apiBaseUrl).append("users/search.json").append(s2).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/ViewerUsersResponse), "GET", i);
        prepare(getusersparams);
        b.a().a(getusersparams, s, d1, false);
        return ((Request) (getusersparams)).d;
    }

    public void setApiBackupUrl(String s)
    {
        apiBackupUrl = s;
    }

    public void setApiBaseUrl(String s)
    {
        apiBaseUrl = s;
    }

    public void setApiKey(String s)
    {
        apiKey = s;
    }

    public void setFourSquareUrl(String s)
    {
        fourSquareUrl = s;
    }

    public void setNotificationUrl(String s)
    {
        notificationUrl = s;
    }

    public void setUploadUrl(String s)
    {
        uploadUrl = s;
    }

    public int settings(String s, String s1, String s2, String s3, com.socialin.asyncnet.d d1, int i, long l, boolean flag)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("settings").toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/Settings), "GET");
        a1.b("app", s);
        a1.b("market", s1);
        if (s1.contains("china"))
        {
            a1.b("paid", "true");
        }
        a1.a(l);
        a1.a(i);
        if (s2 != null)
        {
            a1.b("type", s2);
        }
        if (flag)
        {
            a1.b("onAppStartup", "true");
        }
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("settings").toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("settings").toString();
        a1.c = 5;
        prepare(a1);
        b.a().a(a1, s3, d1, false);
        return ((Request) (a1)).d;
    }

    public int shopChargeWithAliPay(String s, StripeChargeParams stripechargeparams, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/payments/charges/add.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/stripe/StripeChargeResponse), "POST");
        a1.b("stripe_token", stripechargeparams.tokenValue);
        a1.b("amount", String.valueOf(stripechargeparams.chargeValue));
        a1.b("currency", stripechargeparams.currency);
        a1.b("description", stripechargeparams.description);
        a1.b("provider", stripechargeparams.provider);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int signUp(SignupParams signupparams, com.socialin.asyncnet.d d1, String s)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/signup.json").toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/User), "POST");
        if (!TextUtils.isEmpty(signupparams.email))
        {
            a1.b("email", signupparams.email);
        }
        if (!TextUtils.isEmpty(signupparams.password))
        {
            a1.b("password", signupparams.password);
        }
        if (!TextUtils.isEmpty(signupparams.username))
        {
            a1.b("username", signupparams.username);
        }
        if (!TextUtils.isEmpty(signupparams.name))
        {
            a1.b("name", signupparams.name);
        }
        a1.b("provider", signupparams.provider);
        if (signupparams.photoUrl != null)
        {
            a1.b("photo", signupparams.photoUrl);
        }
        if (signupparams.photoPath != null)
        {
            a1.b("path", signupparams.photoPath);
        }
        a1.b("fb_id", signupparams.fbId);
        a1.b("fb_email", signupparams.fbEmail);
        a1.b("fb_url", signupparams.fbUrl);
        a1.b("fb_token", signupparams.fbToken);
        a1.b("fb_name", signupparams.fbName);
        a1.b("tw_token", signupparams.twUserToken);
        a1.b("tw_id", signupparams.twUserId);
        a1.b("tw_screen_name", signupparams.twUserScreenName);
        a1.b("tw_name", signupparams.twUserName);
        a1.b("tw_secret", signupparams.twUserTokenSecret);
        a1.b("gg_token", signupparams.gpUserToken);
        a1.b("gg_id", signupparams.gpUserId);
        if (!TextUtils.isEmpty(signupparams.gpEmail))
        {
            a1.b("gg_email", signupparams.gpEmail);
        }
        a1.b("gg_name", signupparams.gpUserName);
        a1.b("gg_url", signupparams.gpUrl);
        if (signupparams.fbData != null)
        {
            a1.b("fb_data", signupparams.fbData.toString());
        }
        if (signupparams.twitterData != null)
        {
            a1.b("tw_data", signupparams.twitterData.toString());
        }
        if (signupparams.googlePlusData != null)
        {
            a1.b("gg_data", signupparams.googlePlusData.toString());
        }
        signupparams = signupparams.adress;
        if (signupparams != null)
        {
            a1.b("location_place", ((Adress) (signupparams)).place);
            a1.b("location_street", ((Adress) (signupparams)).street);
            a1.b("location_city", ((Adress) (signupparams)).city);
            a1.b("location_state", ((Adress) (signupparams)).state);
            a1.b("location_zip", ((Adress) (signupparams)).zip);
            a1.b("location_country", ((Adress) (signupparams)).country);
            a1.b("location_lat", signupparams.getLatitudeString());
            a1.b("location_lon", signupparams.getLongitudeString());
        }
        a1.e = 0x1d4c0;
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("users/signup.json").toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("users/signup.json").toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int signin(String s, String s1, String s2, com.socialin.asyncnet.d d1, String s3)
    {
        if (s.equals("android"))
        {
            s = createSigninRequest(s, s1, s2, s3);
        } else
        {
            s = createSigninRequestFb(s, s1, s2, s3);
        }
        b.a().a(s, s3, d1, false);
        return ((Request) (s)).d;
    }

    public int unlikePhoto(long l, boolean flag, String s, com.socialin.asyncnet.d d1)
    {
        String s1;
        a a1;
        if (flag)
        {
            s1 = "designs/likes/remove/";
        } else
        {
            s1 = "photos/likes/remove/";
        }
        a1 = new a((new StringBuilder()).append(apiBaseUrl).append(s1).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.a = (new StringBuilder()).append(apiBaseUrl).append(s1).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append(s1).append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int unpostPhoto(long l, String s, com.socialin.asyncnet.d d1)
    {
        String s1 = (new StringBuilder()).append("").append("remove/").toString();
        s1 = (new StringBuilder()).append(s1).append(l).append(".json").toString();
        s1 = (new StringBuilder()).append(s1).append(getApiKeyParamStr(apiKey)).toString();
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("photos/reposts/").append(s1).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("photos/reposts/").append(s1).toString();
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int update(String s, String s1, String s2, String s3, String s4, String s5, int i, 
            Adress adress, NotificationSettingsParams notificationsettingsparams, String s6, String s7, com.socialin.asyncnet.d d1, String s8)
    {
        String s9 = (new StringBuilder("users/update.json")).append(getApiKeyParamStr(apiKey)).toString();
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append(s9).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        if (s != null)
        {
            a1.b("email", s);
        }
        if (s1 != null)
        {
            a1.b("name", s1);
        }
        if (s2 != null)
        {
            a1.b("username", s2);
        }
        if (s3 != null)
        {
            a1.b("password", s3);
        }
        if (s4 != null)
        {
            a1.b("password_confirm", s4);
        }
        if (s5 != null)
        {
            a1.b("photo", s5);
        }
        if (i != -1)
        {
            a1.b("is_mature", String.valueOf(i));
        }
        if (adress != null)
        {
            a1.b("location_city", adress.city);
            a1.b("location_country", adress.country);
            a1.b("location_place", adress.place);
            a1.b("location_state", adress.state);
            a1.b("location_street", adress.street);
            a1.b("location_zip", adress.zip);
            a1.b("location_lat", adress.getLatitudeString());
            a1.b("location_lon", adress.getLongitudeString());
        }
        if (notificationsettingsparams != null)
        {
            a1.b("like_added", String.valueOf(notificationsettingsparams.likeMe));
            a1.b("friend_like_added", String.valueOf(notificationsettingsparams.like));
            a1.b("user_photo_reposted", String.valueOf(notificationsettingsparams.repostMe));
            a1.b("photo_reposted", String.valueOf(notificationsettingsparams.repostOther));
            a1.b("photo_added", String.valueOf(notificationsettingsparams.publish));
            a1.b("comment_added", String.valueOf(notificationsettingsparams.comment));
            a1.b("mention_added", String.valueOf(notificationsettingsparams.mention));
            a1.b("follower_added", String.valueOf(notificationsettingsparams.followMe));
            a1.b("following_added", String.valueOf(notificationsettingsparams.follow));
            a1.b("facebook_added", String.valueOf(notificationsettingsparams.suggestFb));
            a1.b("twitter_added", String.valueOf(notificationsettingsparams.suggestTwitter));
        }
        if (s6 != null)
        {
            a1.b("cover", s6);
        }
        if (s7 != null)
        {
            a1.b("status_message", s7);
        }
        a1.a = (new StringBuilder()).append(apiBaseUrl).append(s9).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append(s9).toString();
        a1.e = 0x30d40;
        a1.c = 5;
        prepare(a1);
        b.a().a(a1, s8, d1, false);
        return ((Request) (a1)).d;
    }

    public int updateAvatar(String s, String s1, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/photo/add.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/AvatarResponse), "POST");
        a1.b("path", s);
        a1.e = 0x1d4c0;
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("users/photo/add.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("users/photo/add.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s1, d1, false);
        return ((Request) (a1)).d;
    }

    public int updatePhoto(long l, String s, String s1, String s2, int i, int j, 
            Adress adress, com.socialin.asyncnet.d d1, String s3)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("photos/update/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        if (s != null)
        {
            a1.b("title", s);
        }
        if (s1 != null)
        {
            a1.b("desc", s1);
        }
        if (s2 != null)
        {
            a1.b("tags", s2);
        }
        if (j >= 0)
        {
            a1.b("is_public", String.valueOf(j));
        }
        a1.b("is_mature", String.valueOf(i));
        s = adress;
        if (adress == null)
        {
            s = new Adress();
        }
        a1.b("location_city", ((Adress) (s)).city);
        a1.b("location_country", ((Adress) (s)).country);
        a1.b("location_lat", s.getLatitudeString());
        a1.b("location_lon", s.getLongitudeString());
        a1.b("location_place", ((Adress) (s)).place);
        a1.b("location_state", ((Adress) (s)).state);
        a1.b("location_street", ((Adress) (s)).street);
        a1.b("location_zip", ((Adress) (s)).zip);
        a1.b("contest_version", String.valueOf(getContestVersion()));
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("photos/update/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("photos/update/").append(l).append(".json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s3, d1, false);
        return ((Request) (a1)).d;
    }

    public int updateUserCover(String s, String s1, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("users/cover/add.json").append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/AvatarResponse), "POST");
        a1.b("path", s);
        a1.e = 0x1d4c0;
        a1.a = (new StringBuilder()).append(apiBaseUrl).append("users/cover/add.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.b = (new StringBuilder()).append(apiBackupUrl).append("users/cover/add.json").append(getApiKeyParamStr(apiKey)).toString();
        a1.c = 3;
        prepare(a1);
        b.a().a(a1, s1, d1, false);
        return ((Request) (a1)).d;
    }

    public int uploadPhoto(UploadParams uploadparams, String s, com.socialin.asyncnet.d d1)
    {
        a a1 = new a((new StringBuilder()).append(uploadparams.serverUrl).append(getApiKeyParamStr(apiKey)).toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/StatusObj), "POST");
        a1.b("path", uploadparams.imagePath);
        a1.c = 3;
        a1.e = 0x30d40;
        a1.f = 0x30d40;
        prepare(a1);
        b.a().a(a1, s, d1, false);
        return ((Request) (a1)).d;
    }

    public int whatsNew(String s, String s1, String s2, long l, String s3, com.socialin.asyncnet.d d1, 
            int i, long l1)
    {
        a a1 = new a((new StringBuilder()).append(apiBaseUrl).append("apps.json").toString(), ResponseParserFactory.createSimpleResponseParser(com/socialin/android/apiv3/model/WhatsNewResponse), "GET");
        a1.b("app", s);
        a1.b("market", s1);
        a1.a(l1);
        a1.a(i);
        a1.b("type", "whats_new");
        if (!TextUtils.isEmpty(s3))
        {
            a1.b("version", s3);
        } else
        {
            a1.b("version", versionCode);
        }
        if (l > 0L)
        {
            a1.b("since_id", String.valueOf(l));
        }
        prepare(a1);
        b.a().a(a1, s2, d1, false);
        return ((Request) (a1)).d;
    }

    static 
    {
        EDGE_TO_SIZE_KEY = new SparseArray() {

            
            {
                put(120, "q");
                put(240, "m");
                put(640, "z");
                put(1024, "b");
            }
        };
        SORTED_SIZE_KEYS = new ArrayList(EDGE_TO_SIZE_KEY.size());
        for (int i = 0; i < EDGE_TO_SIZE_KEY.size(); i++)
        {
            SORTED_SIZE_KEYS.add(Integer.valueOf(EDGE_TO_SIZE_KEY.keyAt(i)));
        }

        Collections.sort(SORTED_SIZE_KEYS);
        SQUARE_THUMB_SIZE = ((Integer)SORTED_SIZE_KEYS.get(0)).intValue();
    }
}
