// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.net.Uri;
import android.provider.BaseColumns;

// Referenced classes of package co.vine.android.provider:
//            Vine

public static final class _cls9
    implements BaseColumns, _cls9, _cls9, _cls9, _cls9, _cls9, _cls9
{

    public static final String COMMENT_ENTITIES = "comment_entities";
    public static final String COMMENT_IS_LAST = "comment_is_last";
    public static final String COMMENT_USER_AVATAR_URL = "comment_user_avatar_url";
    public static final String COMMENT_USER_LOCATION = "comment_user_location";
    public static final String COMMENT_USER_TIMESTAMP = "comment_user_timestamp";
    public static final String COMMENT_USER_USERNAME = "comment_user_username";
    public static final String COMMENT_USER_USER_ID = "comment_user_user_id";
    public static final String COMMENT_USER_VERIFIED = "comment_user_verified";
    public static final Uri CONTENT_URI;
    public static final Uri CONTENT_URI_ALL_TIMELINE;
    public static final Uri CONTENT_URI_ALL_TIMELINE_CHANNEL_POPULAR;
    public static final Uri CONTENT_URI_ALL_TIMELINE_CHANNEL_RECENT;
    public static final Uri CONTENT_URI_ALL_TIMELINE_ON_THE_RISE;
    public static final Uri CONTENT_URI_ALL_TIMELINE_POPULAR_NOW;
    public static final Uri CONTENT_URI_ALL_TIMELINE_SINGLE;
    public static final Uri CONTENT_URI_ALL_TIMELINE_TAG;
    public static final Uri CONTENT_URI_ALL_TIMELINE_USER;
    public static final Uri CONTENT_URI_ALL_TIMELINE_USER_LIKES;
    public static final Uri CONTENT_URI_ARBITRARY_TIMELINE;
    public static final String IS_LAST = "is_last";
    public static final String LIKE_USER_AVATAR_URL = "like_user_avatar_url";
    public static final String LIKE_USER_LOCATION = "like_user_location";
    public static final String LIKE_USER_TIMESTAMP = "like_user_timestamp";
    public static final String LIKE_USER_USERNAME = "like_user_username";
    public static final String LIKE_USER_USER_ID = "like_user_user_id";
    public static final String LIKE_USER_VERIFIED = "like_user_verified";
    public static final String POST_ID = "post_id";
    public static final String REQUIRED_ORDER = "sort_id DESC, comment_id ASC, like_id";
    public static final String REQUIRED_ORDER_POPULAR = "sort_id ASC, post_id DESC, comment_id ASC, like_id";
    public static final String SORT_ORDER_DEFINED_LAST = "sort_id ASC";
    public static final String TABLE_NAME = "post_comments_likes_view";

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_comments_likes_view").toString());
        CONTENT_URI_ALL_TIMELINE = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_comments_likes_view").append("/all_timeline").toString());
        CONTENT_URI_ALL_TIMELINE_USER = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_comments_likes_view").append("/all_timeline_user").toString());
        CONTENT_URI_ALL_TIMELINE_USER_LIKES = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_comments_likes_view").append("/all_timeline_user_likes").toString());
        CONTENT_URI_ALL_TIMELINE_ON_THE_RISE = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_comments_likes_view").append("/all_timeline_on_the_rise").toString());
        CONTENT_URI_ALL_TIMELINE_POPULAR_NOW = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_comments_likes_view").append("/all_timeline_popular").toString());
        CONTENT_URI_ALL_TIMELINE_TAG = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_comments_likes_view").append("/all_timeline_tag").toString());
        CONTENT_URI_ALL_TIMELINE_SINGLE = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_comments_likes_view").append("/post").toString());
        CONTENT_URI_ALL_TIMELINE_CHANNEL_POPULAR = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_comments_likes_view").append("/timeline_channel_popular").toString());
        CONTENT_URI_ALL_TIMELINE_CHANNEL_RECENT = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_comments_likes_view").append("/timeline_channel_recent").toString());
        CONTENT_URI_ARBITRARY_TIMELINE = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_comments_likes_view").append("/timelines").toString());
    }

    public _cls9()
    {
    }
}
