// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.net.Uri;
import android.provider.BaseColumns;

// Referenced classes of package co.vine.android.provider:
//            Vine

public static final class 
    implements BaseColumns, 
{

    public static final Uri CONTENT_URI;
    public static final Uri CONTENT_URI_PUT_TAG;
    public static final Uri CONTENT_URI_UPDATE_RECENT_TAG;
    public static final String SORT_ORDER_DEFAULT = "_id DESC";
    public static final String SORT_ORDER_NEWEST_FIRST = "last_used_timestamp DESC";
    public static final String TABLE_NAME = "tag_recently_used";

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("tag_recently_used").toString());
        CONTENT_URI_PUT_TAG = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("tag_recently_used").append("/put_tag").toString());
        CONTENT_URI_UPDATE_RECENT_TAG = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("tag_recently_used").append("/update_tag").toString());
    }

    public ()
    {
    }
}
