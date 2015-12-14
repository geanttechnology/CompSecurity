// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import java.util.ArrayList;

// Referenced classes of package com.socialin.android.apiv3.model:
//            Response

public class NotificationResponse extends Response
{

    public static final String NOTIFICATION_SYS_TYPES[] = {
        "info", "info_dialog", "info_sys_notice", "update_available"
    };
    public static final String NOTIFICATION_TYPES[] = {
        "like_added", "friend_like_added", "photo_reposted", "user_photo_reposted", "mention_added", "comment_added", "reply_added", "photo_added", "photo_removed", "follower_added", 
        "following_added", "facebook_added", "twitter_added", "appboy_news", "user_tag_added"
    };
    public static final String NOTIFICATION_TYPE_APPBOY_NEWS = "appboy_news";
    public static final String NOTIFICATION_TYPE_COMMENT = "comment_added";
    public static final String NOTIFICATION_TYPE_COMMENT_MENTION = "mention_added";
    public static final String NOTIFICATION_TYPE_FACEBOOK_FRIEND_SUGGEST = "facebook_added";
    public static final String NOTIFICATION_TYPE_FOLLOWER_FOLLOW = "following_added";
    public static final String NOTIFICATION_TYPE_FOLLOW_ME = "follower_added";
    public static final String NOTIFICATION_TYPE_FRIEND_LIKE = "friend_like_added";
    public static final String NOTIFICATION_TYPE_LIKE = "like_added";
    public static final String NOTIFICATION_TYPE_MENTION_IN_PHOTO = "user_tag_added";
    public static final String NOTIFICATION_TYPE_PHOTO_REMOVE = "photo_removed";
    public static final String NOTIFICATION_TYPE_PUBLISH = "photo_added";
    public static final String NOTIFICATION_TYPE_REPLY = "reply_added";
    public static final String NOTIFICATION_TYPE_REPOST = "photo_reposted";
    public static final String NOTIFICATION_TYPE_TWITTER_FRIEND_SUGGEST = "twitter_added";
    public static final String NOTIFICATION_TYPE_UNLIKE = "like_removed";
    public static final String NOTIFICATION_TYPE_USER_REPOST = "user_photo_reposted";
    public static final int STATE_NOT_READ = 0;
    public static final int STATE_READ = 2;
    public static final int STATE_VIEWED = 1;
    public static final String SYS_ACTION_NONE = "none";
    public static final String SYS_ACTION_OPEN_DEEP_LINKING = "open_deep_linking";
    public static final String SYS_ACTION_OPEN_URL = "open_url";
    public static final String SYS_ACTION_START_ACTIVITY = "start_activity";
    public static final String SYS_TYPE_INFO = "info";
    public static final String SYS_TYPE_INFO_DIALOG = "info_dialog";
    public static final String SYS_TYPE_INFO_SYS_NOTICE = "info_sys_notice";
    public static final String SYS_TYPE_UPDATE = "update_available";
    public static final int USERNAMES_VISIBLE_COUNT = 3;
    public ArrayList response;

    public NotificationResponse()
    {
    }

}
