// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.net.Uri;
import android.provider.BaseColumns;

// Referenced classes of package co.vine.android.provider:
//            VineUploadProvider

public class VineUploads
{
    public static final class Uploads
        implements BaseColumns, UploadsColumns
    {

        public static final Uri CONTENT_URI;
        public static final String PATH_DELETE_UPLOAD = "uploads/delete_upload";
        public static final String PATH_PUT_HASH = "uploads/put_hash";
        public static final String PATH_PUT_MESSAGE_ROW_ID = "uploads/put_message_row_id";
        public static final String PATH_PUT_NEW_UPLOAD = "uploads/put_new_upload";
        public static final String PATH_PUT_POST_INFO = "uploads/put_post_info";
        public static final String PATH_PUT_STATUS = "uploads/put_status";
        public static final String PATH_PUT_UPLOAD_TIME = "uploads/put_upload_time";
        public static final String PATH_PUT_URIS = "uploads/put_uris";
        public static final String PATH_PUT_VALUES = "uploads/put_values";
        public static final String PATH_REFERENCE = "uploads/reference";
        public static final String PATH_UPLOAD = "uploads/upload";
        public static final String QUERY_CAPTCHA_URL = "captcha_url";
        public static final String QUERY_HASH = "hash";
        public static final String QUERY_MESSAGE_ROW_ID = "message_row_id";
        public static final String QUERY_PATH = "path";
        public static final String QUERY_POST_INFO = "post_info";
        public static final String QUERY_REFERENCE = "reference";
        public static final String QUERY_STATUS = "status";
        public static final String QUERY_THUMBNAIL_URL = "thumbnail_url";
        public static final String QUERY_UPLOAD_TIME = "upload_time";
        public static final String QUERY_VIDEO_URL = "video_url";
        public static final String SORT_ORDER_DEFAULT = "_id ASC";
        public static final String TABLE_NAME = "uploads";

        static 
        {
            CONTENT_URI = Uri.parse((new StringBuilder()).append(VineUploadProvider.CONTENT_AUTHORITY).append("uploads").toString());
        }

        public Uploads()
        {
        }
    }

    public static interface UploadsColumns
    {

        public static final String CAPTCHA_URL = "captcha_url";
        public static final String CONVERSATION_ROW_ID = "conversation_row_id";
        public static final String HASH = "hash";
        public static final String IS_PRIVATE = "is_private";
        public static final String MAX_LOOPS = "max_loops";
        public static final String MESSAGE_ROW_ID = "message_row";
        public static final String OWNER_ID = "owner_id";
        public static final String PATH = "path";
        public static final String POST_INFO = "post_info";
        public static final String REFERENCE = "reference";
        public static final String STATUS = "status";
        public static final String THUMBNAIL_PATH = "thumbnail_path";
        public static final String THUMBNAIL_URL = "thumbnail_url";
        public static final String UPLOAD_TIME = "upload_time";
        public static final String VIDEO_URL = "video_url";
    }


    public VineUploads()
    {
    }
}
