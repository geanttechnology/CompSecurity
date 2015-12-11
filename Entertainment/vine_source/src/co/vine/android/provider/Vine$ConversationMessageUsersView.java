// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.net.Uri;
import android.provider.BaseColumns;

// Referenced classes of package co.vine.android.provider:
//            Vine

public static final class 
    implements BaseColumns, , 
{

    public static final String AUTHOR_AVATAR = "author_avatar";
    public static final String AUTHOR_USER_ID = "author_user_id";
    public static final String AUTHOR_USER_NAME = "author_user_name";
    public static final Uri CONTENT_URI;
    public static final Uri CONTENT_URI_CONVERSATION;
    public static final String POST_DESCRIPTION = "post_description";
    public static final String POST_ENTITIES = "post_entities";
    public static final String POST_SHARE_URL = "post_share_url";
    public static final String SENDER_AVATAR = "sender_avatar";
    public static final String SENDER_PROFILE_BACKGROUND = "sender_profile_background";
    public static final String SENDER_USER_NAME = "sender_user_name";
    public static final String SORT_ORDER_DEFAULT = "timestamp ASC";
    public static final String TABLE_NAME = "message_users_view";

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("message_users_view").toString());
        CONTENT_URI_CONVERSATION = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("message_users_view").append("/conversation").toString());
    }

    public ()
    {
    }
}
