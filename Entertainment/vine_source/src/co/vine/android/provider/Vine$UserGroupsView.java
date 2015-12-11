// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.net.Uri;
import android.provider.BaseColumns;

// Referenced classes of package co.vine.android.provider:
//            Vine

public static final class s
    implements BaseColumns, s, s, s
{

    public static final Uri CONTENT_URI;
    public static final Uri CONTENT_URI_ALL_FOLLOW;
    public static final Uri CONTENT_URI_FIND_FRIENDS_ADDRESS;
    public static final Uri CONTENT_URI_FIND_FRIENDS_TWITTER;
    public static final Uri CONTENT_URI_FOLLOWERS;
    public static final Uri CONTENT_URI_FOLLOWING;
    public static final Uri CONTENT_URI_FRIENDS;
    public static final Uri CONTENT_URI_FRIENDS_FILTER;
    public static final Uri CONTENT_URI_LIKERS;
    public static final Uri CONTENT_URI_REVINERS;
    public static final Uri CONTENT_URI_USER_SEARCH_RESULTS;
    public static final String SORT_ORDER_DEFAULT = "_id ASC";
    public static final String SORT_ORDER_DEFAULT_IS_LAST = "_id DESC";
    public static final String SORT_ORDER_DEFINED_ASCENDING = "order_id ASC";
    public static final String SORT_ORDER_DEFINED_DESCENDING = "order_id DESC";
    public static final String SORT_ORDER_DEFINED_DESCENDING_IS_LAST = "order_id ASC";
    public static final String SORT_ORDER_DEFINED_LAST = "order_id ASC";
    public static final String SORT_ORDER_FRIEND_REFRESH_FIRST = "last_section_refresh DESC";
    public static final String SORT_ORDER_FRIEND_REFRESH_FIRST_THEN_FRIEND_INDEX = "last_section_refresh DESC, section_index ASC";
    static final String TABLE_NAME = "user_groups_view";
    public static final String USER_ID = "user_id";

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("user_groups_view").toString());
        CONTENT_URI_FOLLOWERS = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("user_groups_view").append("/followers").toString());
        CONTENT_URI_FOLLOWING = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("user_groups_view").append("/following").toString());
        CONTENT_URI_ALL_FOLLOW = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("user_groups_view").append("/all_follow").toString());
        CONTENT_URI_FRIENDS = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("user_groups_view").append("/friends").toString());
        CONTENT_URI_FRIENDS_FILTER = Uri.withAppendedPath(CONTENT_URI_FRIENDS, "filter");
        CONTENT_URI_FIND_FRIENDS_TWITTER = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("user_groups_view").append("/find_friends_twitter").toString());
        CONTENT_URI_FIND_FRIENDS_ADDRESS = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("user_groups_view").append("/find_friends_address").toString());
        CONTENT_URI_LIKERS = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("user_groups_view").append("/likers").toString());
        CONTENT_URI_REVINERS = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("user_groups_view").append("/reviners").toString());
        CONTENT_URI_USER_SEARCH_RESULTS = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("user_groups_view").append("/user_search_results").toString());
    }

    public s()
    {
    }
}
