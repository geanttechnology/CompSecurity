// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;


// Referenced classes of package co.vine.android.provider:
//            VineDatabaseSQL

public static final class _cls9
{

    public static final int INBOX_FOLLOWING_FLAG = 11;
    public static final int INDEX_AVATAR_URL = 12;
    public static final int INDEX_CONVERSATION_ROW_ID = 1;
    public static final int INDEX_ERROR = 15;
    public static final int INDEX_ID = 0;
    public static final int INDEX_IS_HIDDEN = 5;
    public static final int INDEX_IS_LAST = 7;
    public static final int INDEX_LAST_MESSAGE_ROW_ID = 6;
    public static final int INDEX_NETWORK_TYPE = 3;
    public static final int INDEX_PROFILE_BACKGROUND = 13;
    public static final int INDEX_RECIPIENTS_COUNT = 14;
    public static final int INDEX_TIMESTAMP = 2;
    public static final int INDEX_UNREAD_COUNT = 4;
    public static final int INDEX_USERNAME = 8;
    public static final int INDEX_USER_ID = 10;
    public static final int INDEX_USER_ROW_ID = 9;
    public static final String PROJECTION[] = {
        "_id", "conversation_row_id", "timestamp", "network_type", "unread_message_count", "is_hidden", "last_message", "is_last", "username", "user_row_id", 
        "user_id", "following_flag", "avatar_url", "profile_background", "recipients_count", "error_reason"
    };


    public _cls9()
    {
    }
}
