// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.net.Uri;
import android.provider.BaseColumns;

// Referenced classes of package co.vine.android.provider:
//            Vine

public static final class olumns
    implements BaseColumns, olumns
{

    public static final Uri CONTENT_URI;
    public static final int NETWORK_TYPE_IN = 1;
    public static final int NETWORK_TYPE_OUT = 2;
    public static final String QUERY_CONVERSATION_ID = "conversation_id";
    public static final String SORT_ORDER_DEFAULT = "last_message_timestamp DESC";
    public static final String SORT_ORDER_DEFAULT_IS_LAST = "last_message_timestamp ASC, _id DESC";
    public static final String TABLE_NAME = "conversations";

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("conversations").toString());
    }

    public olumns()
    {
    }
}
