// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.net.Uri;
import android.provider.BaseColumns;

// Referenced classes of package co.vine.android.provider:
//            Vine

public static final class olumns
    implements BaseColumns, olumns, olumns
{

    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.vine.android.comment";
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.vine.android.comments";
    public static final Uri CONTENT_URI;
    public static final int LIMIT_DEFAULT = 800;
    public static final String SORT_ORDER_DEFAULT = "comment_id ASC";
    public static final String SORT_ORDER_LAST_REFRESH = "last_refresh DESC";
    public static final String SORT_ORDER_REVERSE = "comment_id DESC";
    public static final String TABLE_NAME = "comments";
    public static final String VERIFIED = "verified";

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("comments").toString());
    }

    public olumns()
    {
    }
}
