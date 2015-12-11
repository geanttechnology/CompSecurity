// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.net.Uri;
import android.provider.BaseColumns;

// Referenced classes of package co.vine.android.provider:
//            Vine

public static final class lumns
    implements BaseColumns, lumns
{

    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.vine.android.users.groups";
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.vine.android.users.groups";
    public static final Uri CONTENT_URI;
    public static final String SORT_ORDER_DEFAULT = "type DESC";
    static final String TABLE_NAME = "user_groups";
    public static final int TAG_UNSPECIFIED = -1;
    public static final int TYPE_USER_COMMENTS = 3;
    public static final int TYPE_USER_FIND_FRIENDS_ADDRESS = 7;
    public static final int TYPE_USER_FIND_FRIENDS_TWITTER = 6;
    public static final int TYPE_USER_FOLLOWER = 2;
    public static final int TYPE_USER_FOLLOWING = 1;
    public static final int TYPE_USER_FRIENDS = 10;
    public static final int TYPE_USER_LIKERS = 5;
    public static final int TYPE_USER_NOTIFICATION = 12;
    public static final int TYPE_USER_OUT_OF_NETWORK = 11;
    public static final int TYPE_USER_POSTS = 4;
    public static final int TYPE_USER_REVINERS = 9;
    public static final int TYPE_USER_SEARCH_RESULTS = 8;
    public static final int TYPE_USER_UNDEFINED = -1;

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("user_groups").toString());
    }

    public lumns()
    {
    }
}
