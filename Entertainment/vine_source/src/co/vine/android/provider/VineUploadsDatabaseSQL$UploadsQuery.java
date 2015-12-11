// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;


// Referenced classes of package co.vine.android.provider:
//            VineUploadsDatabaseSQL

public static final class 
{

    public static final int INDEX_CAPTCHA_URL = 13;
    public static final int INDEX_CONVERSATION_ROW_ID = 10;
    public static final int INDEX_HASH = 2;
    public static final int INDEX_ID = 0;
    public static final int INDEX_IS_PRIVATE = 9;
    public static final int INDEX_MAX_LOOPS = 14;
    public static final int INDEX_MESSAGE_ROW_ID = 15;
    public static final int INDEX_OWNER_ID = 12;
    public static final int INDEX_PATH = 1;
    public static final int INDEX_POST_INFO = 4;
    public static final int INDEX_REFERENCE = 11;
    public static final int INDEX_STATUS = 3;
    public static final int INDEX_THUMBNAIL_PATH = 6;
    public static final int INDEX_THUMBNAIL_URL = 7;
    public static final int INDEX_UPLOAD_TIME = 8;
    public static final int INDEX_VIDEO_URL = 5;
    public static final String PROJECTION[] = {
        "_id", "path", "hash", "status", "post_info", "video_url", "thumbnail_path", "thumbnail_url", "upload_time", "is_private", 
        "conversation_row_id", "reference", "owner_id", "captcha_url", "max_loops", "message_row"
    };


    public ()
    {
    }
}
