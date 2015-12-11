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
    public static final Uri CONTENT_URI_SINGLE_MESSAGE;
    public static final String IS_LAST = "is_last";
    public static final String QUERY_CONVERSATION_ROW_ID = "conversation_row_id";
    public static final String QUERY_MESSAGE_ID = "message_id";
    public static final String SORT_ORDER_DEFAULT = "message_id ASC";
    public static final String SORT_ORDER_REVERSE = "message_id DESC";
    public static final String TABLE_NAME = "messages";

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("messages").toString());
        CONTENT_URI_SINGLE_MESSAGE = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("messages").append("/message").toString());
    }

    public olumns()
    {
    }
}
