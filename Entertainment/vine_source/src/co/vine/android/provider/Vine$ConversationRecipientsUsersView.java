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
    public static final Uri CONTENT_URI_CONVERSATION;
    public static final String CONVERSATION_ROW_ID = "conversation_row_id";
    public static final String SORT_ORDER_DEFAULT = "conversation_row_id DESC";
    public static final String TABLE_NAME = "conversation_recipients_users_view";
    public static final String USER_ROW_ID = "user_row_id";

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("conversation_recipients_users_view").toString());
        CONTENT_URI_CONVERSATION = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("conversation_recipients_users_view").append("/conversation").toString());
    }

    public ()
    {
    }
}
