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

    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.vine.android.users";
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.vine.android.users";
    public static final Uri CONTENT_URI;
    public static final Uri CONTENT_URI_HIDE_PROFILE_REPOSTS;
    public static final int LIMIT_DEFAULT = 400;
    public static final String QUERY_HIDE_PROFILE_REPOSTS = "hide_profile_reposts";
    public static final String SORT_ORDER_DEFAULT = "username ASC";
    public static final String SORT_ORDER_LAST_REFRESH = "last_refresh DESC";
    public static final String TABLE_NAME = "users";

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("users").toString());
        CONTENT_URI_HIDE_PROFILE_REPOSTS = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("users").append("/hide_profile_reposts").toString());
    }

    public lumns()
    {
    }
}
