// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.database.Cursor;
import co.vine.android.api.VineRecipient;

// Referenced classes of package co.vine.android.provider:
//            VineDatabaseSQL

public static final class _cls9
{

    public static final int INDEX_ACCEPT_OOM_CONVERSATIONS = 18;
    public static final int INDEX_AVATAR_URL = 2;
    public static final int INDEX_BLOCKED = 3;
    public static final int INDEX_BLOCKING = 4;
    public static final int INDEX_DESCRIPTION = 5;
    public static final int INDEX_EXPLICIT = 7;
    public static final int INDEX_FOLLOWER_COUNT = 8;
    public static final int INDEX_FOLLOWING_COUNT = 9;
    public static final int INDEX_FOLLOW_STATUS = 15;
    public static final int INDEX_FRIENDSHIP = 10;
    public static final int INDEX_ID = 0;
    public static final int INDEX_IS_LAST = 17;
    public static final int INDEX_LAST_SECTION_REFRESH = 23;
    public static final int INDEX_LIKE_COUNT = 11;
    public static final int INDEX_LOCATION = 6;
    public static final int INDEX_LOOP_COUNT = 25;
    public static final int INDEX_ORDER = 16;
    public static final int INDEX_POST_COUNT = 12;
    public static final int INDEX_PROFILE_BACKGROUND = 19;
    public static final int INDEX_SECTION_INDEX = 20;
    public static final int INDEX_SECTION_TITLE = 22;
    public static final int INDEX_SECTION_TYPE = 21;
    public static final int INDEX_TYPE = 24;
    public static final int INDEX_USERNAME = 13;
    public static final int INDEX_USER_ID = 1;
    public static final int INDEX_VERIFIED = 14;
    public static final String PROJECTION[] = {
        "_id", "user_id", "avatar_url", "blocked", "blocking", "description", "location", "explicit", "follower_count", "following_count", 
        "following_flag", "like_count", "post_count", "username", "verified", "follow_status", "order_id", "is_last", "accepts_oon_conversations", "profile_background", 
        "section_index", "section_type", "section_title", "last_section_refresh", "type", "loop_count"
    };

    public static VineRecipient getVineRecipient(Cursor cursor)
    {
        VineRecipient vinerecipient = VineRecipient.fromUser(cursor.getString(13), cursor.getLong(1), cursor.getInt(19), -1L);
        vinerecipient.avatarUrl = cursor.getString(2);
        vinerecipient.lastFriendRefresh = cursor.getLong(23);
        vinerecipient.sectionTitle = cursor.getString(22);
        vinerecipient.friendIndex = cursor.getLong(20);
        vinerecipient.sectionIndex = (int)(vinerecipient.friendIndex >> 32);
        return vinerecipient;
    }


    public _cls9()
    {
    }
}
