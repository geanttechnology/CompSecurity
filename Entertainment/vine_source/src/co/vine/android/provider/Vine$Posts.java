// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.net.Uri;
import android.provider.BaseColumns;

// Referenced classes of package co.vine.android.provider:
//            Vine

public static final class stColumns
    implements BaseColumns, lumns, stColumns
{

    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.vine.android.post";
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.vine.android.posts";
    public static final Uri CONTENT_URI;
    public static final int LIMIT_DEFAULT = 400;
    public static final String SORT_LAST_REFRESH = "last_refresh DESC";
    public static final String SORT_ORDER_DEFAULT = "timestamp DESC";
    public static final String TABLE_NAME = "posts";

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("posts").toString());
    }

    public stColumns()
    {
    }
}
