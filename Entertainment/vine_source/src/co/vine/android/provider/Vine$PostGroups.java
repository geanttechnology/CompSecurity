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

    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.vine.android.posts.groups";
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.vine.android.posts.groups";
    public static final Uri CONTENT_URI;
    public static final String SORT_ORDER_BY_SORT = "sort_id DESC";
    public static final String TABLE_NAME = "post_groups";
    public static final int TYPE_ARBITRARY_TIMELINE = 11;
    public static final int TYPE_CHANNELS_POPULAR = 8;
    public static final int TYPE_CHANNELS_RECENT = 9;
    public static final int TYPE_ON_THE_RISE = 4;
    public static final int TYPE_POPULAR_NOW = 5;
    public static final int TYPE_POSTS = 7;
    public static final int TYPE_TAG = 6;
    public static final int TYPE_TIMELINE = 1;
    public static final int TYPE_UNDEFINED = -1;
    public static final int TYPE_USER_LIKES = 3;
    public static final int TYPE_USER_TIMELINE = 2;
    public static final int TYPE_USER_TIMELINE_NO_REPOSTS = 10;
    public static final int TYPE_VM = 12;

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("post_groups").toString());
    }

    public lumns()
    {
    }
}
