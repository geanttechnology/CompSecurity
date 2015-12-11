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
    public static final String SORT_ORDER_DEFAULT = "_id ASC";
    public static final String SORT_ORDER_DEFAULT_IS_LAST = "_id DESC";
    public static final String TABLE_NAME = "tag_search_results";

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("tag_search_results").toString());
    }

    public ()
    {
    }
}
