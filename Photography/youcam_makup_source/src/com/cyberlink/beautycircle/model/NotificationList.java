// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.content.SharedPreferences;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.model.Model;
import java.util.ArrayList;
import java.util.Date;

public class NotificationList extends Model
{

    public static final String ACCOUNT_FB = "Facebook";
    public static final String ACCOUNT_WB = "Weibo";
    public static final String KEY_PEOPLE_CREATE_TIME = "Notify_People_Create_Time";
    public static final String KEY_YOU_CREATE_TIME = "Notify_You_Create_Time";
    public static final String SortByPeople = "Friend";
    public static final String SortByYou = "You";
    public static final String TYPE_ADD_POST = "AddPost";
    public static final String TYPE_CIRCLE_IN_POST = "CircleInPost";
    public static final String TYPE_COMMENTS_POST = "CommentPost";
    public static final String TYPE_CONSULTATION = "Consultation";
    public static final String TYPE_CREATE_CIRCLE = "CreateCircle";
    public static final String TYPE_FOLLOW_CIRCLE = "FollowCircle";
    public static final String TYPE_FOLLOW_USER = "FollowUser";
    public static final String TYPE_FREE_SAMPLE = "FreeSample";
    public static final String TYPE_JOIN_BC_FROM_FB = "JoinBCFromFB";
    public static final String TYPE_JOIN_BC_FROM_WB = "JoinBCFromWeibo";
    public static final String TYPE_LIKE_POST = "LikePost";
    public static final String TYPE_PEOPLE_FOLLOW_CIRCLE = "FriendFollowCircle";
    public static final String TYPE_PEOPLE_LIKE_POST = "FriendLikePost";
    public String accountSource;
    public String avatarUrl;
    public ArrayList circleIcons;
    public ArrayList circleNames;
    public ArrayList comments;
    public Date createTime;
    public ArrayList files;
    public ArrayList friendNames;
    public Long groupNum;
    public Long id;
    public ArrayList idList;
    public Boolean isRead;
    public String msg;
    public String notifyType;
    public Long receiverId;
    public Long refId;
    public Long senderId;
    public String senderName;

    public NotificationList()
    {
    }

    public static Long a(String s)
    {
        if (s != null && !s.isEmpty()) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        SharedPreferences sharedpreferences;
        sharedpreferences = Globals.D();
        if (!s.equals("Friend"))
        {
            continue; /* Loop/switch isn't completed */
        }
        s = "Notify_People_Create_Time";
_L4:
        return Long.valueOf(sharedpreferences.getLong(s, 0L));
        if (!s.equals("You")) goto _L1; else goto _L3
_L3:
        s = "Notify_You_Create_Time";
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static void a(String s, long l)
    {
        if (s != null && !s.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!s.equals("Friend"))
        {
            continue; /* Loop/switch isn't completed */
        }
        s = "Notify_People_Create_Time";
_L4:
        Globals.D().edit().putLong(s, l).commit();
        return;
        if (!s.equals("You")) goto _L1; else goto _L3
_L3:
        s = "Notify_You_Create_Time";
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public Long b_()
    {
        return id;
    }
}
