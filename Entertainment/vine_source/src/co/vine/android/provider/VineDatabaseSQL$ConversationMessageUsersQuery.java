// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;


// Referenced classes of package co.vine.android.provider:
//            VineDatabaseSQL

public static final class 
{

    public static final int INDEX_AUTHOR_AVATAR = 28;
    public static final int INDEX_AUTHOR_USER_ID = 26;
    public static final int INDEX_AUTHOR_USER_NAME = 27;
    public static final int INDEX_CONVERSATION_ID = 19;
    public static final int INDEX_CONVERSATION_ROW_ID = 1;
    public static final int INDEX_DELETED = 14;
    public static final int INDEX_EPHEMERAL = 12;
    public static final int INDEX_ERROR_CODE = 17;
    public static final int INDEX_ERROR_MESSAGE = 18;
    public static final int INDEX_HIDDEN = 22;
    public static final int INDEX_ID = 0;
    public static final int INDEX_IS_LAST = 8;
    public static final int INDEX_LOCAL_START_TIME = 13;
    public static final int INDEX_MAX_LOOPS = 10;
    public static final int INDEX_MESSAGE = 5;
    public static final int INDEX_MESSAGE_ID = 2;
    public static final int INDEX_NETWORK_TYPE = 20;
    public static final int INDEX_POST_DESCRIPTION = 30;
    public static final int INDEX_POST_ENTITIES = 29;
    public static final int INDEX_POST_ID = 15;
    public static final int INDEX_POST_SHARE_URL = 31;
    public static final int INDEX_SENDER_AVATAR_URL = 24;
    public static final int INDEX_SENDER_PROFILE_BACKGROUND = 25;
    public static final int INDEX_SENDER_USER_NAME = 23;
    public static final int INDEX_THUMBNAIL_URL = 7;
    public static final int INDEX_TIMESTAMP = 4;
    public static final int INDEX_UNREAD_COUNT = 21;
    public static final int INDEX_UPLOAD_PATH = 16;
    public static final int INDEX_USER_ID = 3;
    public static final int INDEX_VANISHED = 9;
    public static final int INDEX_VANISHED_DATE = 11;
    public static final int INDEX_VIDEO_URL = 6;
    public static final String PROJECTION[] = {
        "_id", "conversation_row_id", "message_id", "user_row_id", "timestamp", "message", "video_url", "thumbnail_url", "is_last", "vanished", 
        "max_loops", "vanished_date", "ephemeral", "local_start_time", "deleted", "post_id", "upload_path", "error_code", "error_reason", "conversation_id", 
        "network_type", "unread_message_count", "is_hidden", "sender_user_name", "sender_avatar", "sender_profile_background", "author_user_id", "author_user_name", "author_avatar", "post_entities", 
        "post_description", "post_share_url"
    };


    public ()
    {
    }
}
