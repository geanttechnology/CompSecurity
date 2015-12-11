// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.net.Uri;
import android.provider.BaseColumns;

// Referenced classes of package co.vine.android.provider:
//            Vine

public static final class s
    implements BaseColumns, s, , s
{

    public static final Uri CONTENT_URI;
    public static final Uri CONTENT_URI_FIND_USER_LIKES;
    public static final Uri CONTENT_URI_TIMELINE;
    public static final Uri CONTENT_URI_USER_PROFILE;
    public static final String IS_LAST = "is_last";
    public static final String POST_ID = "post_id";
    public static final String SORT_ORDER_DEFAULT = "sort_id DESC";
    public static final String TABLE_NAME = "post_groups_view";

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_groups_view").toString());
        CONTENT_URI_TIMELINE = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_groups_view").append("/timeline").toString());
        CONTENT_URI_USER_PROFILE = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_groups_view").append("/user_profile").toString());
        CONTENT_URI_FIND_USER_LIKES = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_groups_view").append("/user_likes").toString());
    }

    public s()
    {
    }
}
