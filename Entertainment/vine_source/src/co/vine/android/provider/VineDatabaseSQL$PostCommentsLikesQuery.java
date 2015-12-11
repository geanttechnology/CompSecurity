// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import java.util.HashMap;

// Referenced classes of package co.vine.android.provider:
//            VineDatabaseSQL

public static final class 
{

    public static final int INDEX_AVATAR_URL = 15;
    public static final int INDEX_COMMENT = 35;
    public static final int INDEX_COMMENTS_COUNT = 26;
    public static final int INDEX_COMMENT_ENTITIES = 43;
    public static final int INDEX_COMMENT_ID = 34;
    public static final int INDEX_COMMENT_IS_LAST = 42;
    public static final int INDEX_COMMENT_USER_AVATAR_URL = 36;
    public static final int INDEX_COMMENT_USER_LOCATION = 39;
    public static final int INDEX_COMMENT_USER_TIMESTAMP = 38;
    public static final int INDEX_COMMENT_USER_USERNAME = 40;
    public static final int INDEX_COMMENT_USER_USER_ID = 37;
    public static final int INDEX_COMMENT_USER_VERIFIED = 41;
    public static final int INDEX_DESCRIPTION = 8;
    public static final int INDEX_ENTITIES = 21;
    public static final int INDEX_FOURSQUARE_VENUE_ID = 9;
    public static final int INDEX_ID = 0;
    public static final int INDEX_IS_LAST = 14;
    public static final int INDEX_LIKES_COUNT = 24;
    public static final int INDEX_LIKE_ID = 27;
    public static final int INDEX_LIKE_USER_AVATAR_URL = 28;
    public static final int INDEX_LIKE_USER_LOCATION = 31;
    public static final int INDEX_LIKE_USER_TIMESTAMP = 30;
    public static final int INDEX_LIKE_USER_USERNAME = 32;
    public static final int INDEX_LIKE_USER_USER_ID = 29;
    public static final int INDEX_LIKE_USER_VERIFIED = 33;
    public static final int INDEX_LOCATION = 18;
    public static final int INDEX_LOOPS = 45;
    public static final int INDEX_METADATA_FLAGS = 10;
    public static final int INDEX_MY_REPOST_ID = 2;
    public static final int INDEX_ON_FIRE = 47;
    public static final int INDEX_POST_FLAGS = 11;
    public static final int INDEX_POST_ID = 1;
    public static final int INDEX_POST_LAST_REFRESH = 48;
    public static final int INDEX_REPOSTER_ID = 23;
    public static final int INDEX_REPOST_DATA = 22;
    public static final int INDEX_REVINERS_COUNT = 25;
    public static final int INDEX_SHARE_URL = 5;
    public static final int INDEX_SORT_ID = 49;
    public static final int INDEX_TAG = 13;
    public static final int INDEX_TAGS = 3;
    public static final int INDEX_THUMBNAIL_URL = 4;
    public static final int INDEX_TIMESTAMP = 17;
    public static final int INDEX_TYPE = 12;
    public static final int INDEX_USERNAME = 19;
    public static final int INDEX_USER_BACKGROUND_COLOR = 44;
    public static final int INDEX_USER_ID = 16;
    public static final int INDEX_VELOCITY = 46;
    public static final int INDEX_VENUE_DATA = 20;
    public static final int INDEX_VIDEO_LOW_URL = 6;
    public static final int INDEX_VIDEO_URL = 7;
    public static final HashMap LOOKUP;
    public static final String PROJECTION[] = {
        "_id", "post_id", "my_repost_id", "tags", "thumbnail_url", "share_url", "video_low_uRL", "video_url", "description", "foursquare_venue_id", 
        "metadata_flags", "post_flags", "post_type", "tag", "is_last", "avatar_url", "user_id", "timestamp", "location", "username", 
        "venue_data", "entities", "repost_data", "reposter_id", "likes_count", "reviners_count", "comments_count", "like_id", "like_user_avatar_url", "like_user_user_id", 
        "like_user_timestamp", "like_user_location", "like_user_username", "like_user_verified", "comment_id", "comment", "comment_user_avatar_url", "comment_user_user_id", "comment_user_timestamp", "comment_user_location", 
        "comment_user_username", "comment_user_verified", "comment_is_last", "comment_entities", "user_background_color", "loops", "velocity", "on_fire", "last_refresh", "sort_id"
    };

    static 
    {
        LOOKUP = new HashMap(43);
        LOOKUP.put("_id", Integer.valueOf(0));
        LOOKUP.put("post_id", Integer.valueOf(1));
        LOOKUP.put("my_repost_id", Integer.valueOf(2));
        LOOKUP.put("tags", Integer.valueOf(3));
        LOOKUP.put("thumbnail_url", Integer.valueOf(4));
        LOOKUP.put("share_url", Integer.valueOf(5));
        LOOKUP.put("video_low_uRL", Integer.valueOf(6));
        LOOKUP.put("video_url", Integer.valueOf(7));
        LOOKUP.put("description", Integer.valueOf(8));
        LOOKUP.put("foursquare_venue_id", Integer.valueOf(9));
        LOOKUP.put("metadata_flags", Integer.valueOf(10));
        LOOKUP.put("post_flags", Integer.valueOf(11));
        LOOKUP.put("post_type", Integer.valueOf(12));
        LOOKUP.put("tag", Integer.valueOf(13));
        LOOKUP.put("sort_id", Integer.valueOf(49));
        LOOKUP.put("is_last", Integer.valueOf(14));
        LOOKUP.put("avatar_url", Integer.valueOf(15));
        LOOKUP.put("user_id", Integer.valueOf(16));
        LOOKUP.put("timestamp", Integer.valueOf(17));
        LOOKUP.put("location", Integer.valueOf(18));
        LOOKUP.put("username", Integer.valueOf(19));
        LOOKUP.put("venue_data", Integer.valueOf(20));
        LOOKUP.put("entities", Integer.valueOf(21));
        LOOKUP.put("repost_data", Integer.valueOf(22));
        LOOKUP.put("reposter_id", Integer.valueOf(23));
        LOOKUP.put("likes_count", Integer.valueOf(24));
        LOOKUP.put("reviners_count", Integer.valueOf(25));
        LOOKUP.put("comments_count", Integer.valueOf(26));
        LOOKUP.put("like_id", Integer.valueOf(27));
        LOOKUP.put("like_user_avatar_url", Integer.valueOf(28));
        LOOKUP.put("like_user_user_id", Integer.valueOf(29));
        LOOKUP.put("like_user_timestamp", Integer.valueOf(30));
        LOOKUP.put("like_user_location", Integer.valueOf(31));
        LOOKUP.put("like_user_username", Integer.valueOf(32));
        LOOKUP.put("like_user_verified", Integer.valueOf(33));
        LOOKUP.put("comment_id", Integer.valueOf(34));
        LOOKUP.put("comment", Integer.valueOf(35));
        LOOKUP.put("comment_user_avatar_url", Integer.valueOf(36));
        LOOKUP.put("comment_user_user_id", Integer.valueOf(37));
        LOOKUP.put("comment_user_timestamp", Integer.valueOf(38));
        LOOKUP.put("comment_user_location", Integer.valueOf(39));
        LOOKUP.put("comment_user_username", Integer.valueOf(40));
        LOOKUP.put("comment_user_verified", Integer.valueOf(41));
        LOOKUP.put("comment_is_last", Integer.valueOf(42));
        LOOKUP.put("comment_entities", Integer.valueOf(43));
        LOOKUP.put("user_background_color", Integer.valueOf(44));
        LOOKUP.put("loops", Integer.valueOf(45));
        LOOKUP.put("velocity", Integer.valueOf(46));
        LOOKUP.put("on_fire", Integer.valueOf(47));
        LOOKUP.put("last_refresh", Integer.valueOf(48));
    }

    public ()
    {
    }
}
