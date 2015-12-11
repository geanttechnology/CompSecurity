// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.database.Cursor;
import co.vine.android.api.VineRecipient;
import java.util.HashMap;

public class VineDatabaseSQL
{
    public static final class ChannelsQuery
    {

        public static final int INDEX_BACKGROUND_COLOR = 4;
        public static final int INDEX_CHANNEL = 2;
        public static final int INDEX_CHANNEL_ID = 1;
        public static final int INDEX_FONT_COLOR = 5;
        public static final int INDEX_ICON_FULL_URL = 8;
        public static final int INDEX_ID = 0;
        public static final int INDEX_IS_LAST = 7;
        public static final int INDEX_LAST_USED_TIMESTAMP = 6;
        public static final int INDEX_RETINA_ICON_FULL_URL = 9;
        public static final int INDEX_TIMESTAMP = 3;
        public static final String PROJECTION[] = {
            "_id", "channel_id", "channel", "timestamp", "background_color", "font_color", "last_used_timestamp", "is_last", "icon_full_url", "retina_icon_full_url"
        };


        public ChannelsQuery()
        {
        }
    }

    public static final class CommentsQuery
    {

        public static final int INDEX_AVATAR_URL = 3;
        public static final int INDEX_COMMENT = 9;
        public static final int INDEX_COMMENT_ID = 1;
        public static final int INDEX_ENTITIES = 10;
        public static final int INDEX_ID = 0;
        public static final int INDEX_IS_LAST = 11;
        public static final int INDEX_LOCATION = 7;
        public static final int INDEX_POST_ID = 2;
        public static final int INDEX_TIMESTAMP = 6;
        public static final int INDEX_USERNAME = 5;
        public static final int INDEX_USER_ID = 4;
        public static final int INDEX_VERIFIED = 8;
        public static final String PROJECTION[] = {
            "_id", "comment_id", "post_id", "avatar_url", "user_id", "username", "timestamp", "location", "verified", "comment", 
            "entities", "is_last"
        };


        public CommentsQuery()
        {
        }
    }

    public static final class ConversationMessageUsersQuery
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


        public ConversationMessageUsersQuery()
        {
        }
    }

    public static final class ConversationRecipientsQuery
    {

        public static final int INDEX_CONVERSATION_ROW_ID = 1;
        public static final int INDEX_ID = 0;
        public static final int INDEX_USER_ROW_ID = 2;
        public static final String PROJECTION[] = {
            "_id", "conversation_row_id", "user_row_id"
        };


        public ConversationRecipientsQuery()
        {
        }
    }

    public static final class ConversationRecipientsUsersViewQuery
    {

        public static final int INDEX_CONVERSATION_ROW_ID = 1;
        public static final int INDEX_EMAIL = 5;
        public static final int INDEX_ID = 0;
        public static final int INDEX_PHONE_NUMBER = 4;
        public static final int INDEX_USERNAME = 3;
        public static final int INDEX_USERS_PROFILE_BACKGROUND = 7;
        public static final int INDEX_USER_ID = 6;
        public static final int INDEX_USER_ROW_ID = 2;
        public static final String PROJECTION[] = {
            "_id", "conversation_row_id", "user_row_id", "username", "phone_number", "email_address", "user_id", "profile_background"
        };


        public ConversationRecipientsUsersViewQuery()
        {
        }
    }

    public static final class EditionsQuery
    {

        public static final int INDEX_EDITION_CODE = 1;
        public static final int INDEX_EDITION_NAME = 2;
        public static final int INDEX_ID = 0;
        public static final String PROJECTION[] = {
            "_id", "edition_code", "edition_name"
        };


        public EditionsQuery()
        {
        }
    }

    public static final class InboxQuery
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


        public InboxQuery()
        {
        }
    }

    public static final class LikesQuery
    {

        public static final int INDEX_AVATAR_URL = 3;
        public static final int INDEX_ID = 0;
        public static final int INDEX_LIKE_ID = 1;
        public static final int INDEX_LOCATION = 7;
        public static final int INDEX_POST_ID = 2;
        public static final int INDEX_TIMESTAMP = 6;
        public static final int INDEX_USERNAME = 5;
        public static final int INDEX_USER_ID = 4;
        public static final String PROJECTION[] = {
            "_id", "like_id", "post_id", "avatar_url", "user_id", "username", "timestamp", "location", "verified"
        };


        public LikesQuery()
        {
        }
    }

    public static final class MessagesQuery
    {

        public static final int INDEX_CONVERSATION_ROW_ID = 1;
        public static final int INDEX_DELETED = 14;
        public static final int INDEX_EPHEMERAL = 12;
        public static final int INDEX_ERROR_CODE = 17;
        public static final int INDEX_ERROR_REASON = 18;
        public static final int INDEX_ID = 0;
        public static final int INDEX_IS_LAST = 8;
        public static final int INDEX_LOCAL_START_TIME = 13;
        public static final int INDEX_MAX_LOOPS = 10;
        public static final int INDEX_MESSAGE = 5;
        public static final int INDEX_MESSAGE_ID = 2;
        public static final int INDEX_POST_ID = 15;
        public static final int INDEX_THUMBNAIL_URL = 7;
        public static final int INDEX_TIMESTAMP = 4;
        public static final int INDEX_UPLOAD_PATH = 16;
        public static final int INDEX_USER_ID = 3;
        public static final int INDEX_VANISHED = 9;
        public static final int INDEX_VANISHED_DATE = 11;
        public static final int INDEX_VIDEO_URL = 6;
        public static final String PROJECTION[] = {
            "_id", "conversation_row_id", "message_id", "user_row_id", "timestamp", "message", "video_url", "thumbnail_url", "is_last", "vanished", 
            "max_loops", "vanished_date", "ephemeral", "local_start_time", "deleted", "post_id", "upload_path", "error_code", "error_reason"
        };


        public MessagesQuery()
        {
        }
    }

    public static final class NotificationsQuery
    {

        public static final int INDEX_AVATAR_URL = 6;
        public static final int INDEX_CLEARED = 4;
        public static final int INDEX_CONVERSATION_ROW_ID = 5;
        public static final int INDEX_ID = 0;
        public static final int INDEX_MESSAGE = 3;
        public static final int INDEX_NOTIFICATION_ID = 1;
        public static final int INDEX_TYPE = 2;
        public static final String PROJECTION[] = {
            "_id", "notification_id", "notification_type", "message", "cleared", "conversation_row_id", "avatar_url"
        };


        public NotificationsQuery()
        {
        }
    }

    public static final class PageCursorsQuery
    {

        public static final int INDEX_ANCHOR = 6;
        public static final int INDEX_ID = 0;
        public static final int INDEX_KIND = 3;
        public static final int INDEX_NEXT_PAGE = 4;
        public static final int INDEX_PREVIOUS_PAGE = 5;
        public static final int INDEX_REVERSED = 7;
        public static final int INDEX_TAG = 2;
        public static final int INDEX_TYPE = 1;
        public static final String PROJECTION[] = {
            "_id", "type", "tag", "kind", "next_page", "previous_page", "anchor", "reversed"
        };


        public PageCursorsQuery()
        {
        }
    }

    public static final class PostCommentsLikesQuery
    {

        public static final int INDEX_AVATAR_URL = 15;
        public static final int INDEX_COMMENT = 35;
        public static final int INDEX_COMMENTS_COUNT = 26;
        public static final int INDEX_COMMENT_ENTITIES = 43;
        public static final int INDEX_COMMENT_ID = 34;
        public static final int INDEX_COMMENT_IS_LAST = 42;
        public static final int INDEX_COMMENT_USER_AVATAR_URL = 36;
        public static final int INDEX_COMMENT_USER_LOCATION = 39;
        public static final int INDEX_COMMENT_USER_TIMESTAMP = 38;
        public static final int INDEX_COMMENT_USER_USERNAME = 40;
        public static final int INDEX_COMMENT_USER_USER_ID = 37;
        public static final int INDEX_COMMENT_USER_VERIFIED = 41;
        public static final int INDEX_DESCRIPTION = 8;
        public static final int INDEX_ENTITIES = 21;
        public static final int INDEX_FOURSQUARE_VENUE_ID = 9;
        public static final int INDEX_ID = 0;
        public static final int INDEX_IS_LAST = 14;
        public static final int INDEX_LIKES_COUNT = 24;
        public static final int INDEX_LIKE_ID = 27;
        public static final int INDEX_LIKE_USER_AVATAR_URL = 28;
        public static final int INDEX_LIKE_USER_LOCATION = 31;
        public static final int INDEX_LIKE_USER_TIMESTAMP = 30;
        public static final int INDEX_LIKE_USER_USERNAME = 32;
        public static final int INDEX_LIKE_USER_USER_ID = 29;
        public static final int INDEX_LIKE_USER_VERIFIED = 33;
        public static final int INDEX_LOCATION = 18;
        public static final int INDEX_LOOPS = 45;
        public static final int INDEX_METADATA_FLAGS = 10;
        public static final int INDEX_MY_REPOST_ID = 2;
        public static final int INDEX_ON_FIRE = 47;
        public static final int INDEX_POST_FLAGS = 11;
        public static final int INDEX_POST_ID = 1;
        public static final int INDEX_POST_LAST_REFRESH = 48;
        public static final int INDEX_REPOSTER_ID = 23;
        public static final int INDEX_REPOST_DATA = 22;
        public static final int INDEX_REVINERS_COUNT = 25;
        public static final int INDEX_SHARE_URL = 5;
        public static final int INDEX_SORT_ID = 49;
        public static final int INDEX_TAG = 13;
        public static final int INDEX_TAGS = 3;
        public static final int INDEX_THUMBNAIL_URL = 4;
        public static final int INDEX_TIMESTAMP = 17;
        public static final int INDEX_TYPE = 12;
        public static final int INDEX_USERNAME = 19;
        public static final int INDEX_USER_BACKGROUND_COLOR = 44;
        public static final int INDEX_USER_ID = 16;
        public static final int INDEX_VELOCITY = 46;
        public static final int INDEX_VENUE_DATA = 20;
        public static final int INDEX_VIDEO_LOW_URL = 6;
        public static final int INDEX_VIDEO_URL = 7;
        public static final HashMap LOOKUP;
        public static final String PROJECTION[] = {
            "_id", "post_id", "my_repost_id", "tags", "thumbnail_url", "share_url", "video_low_uRL", "video_url", "description", "foursquare_venue_id", 
            "metadata_flags", "post_flags", "post_type", "tag", "is_last", "avatar_url", "user_id", "timestamp", "location", "username", 
            "venue_data", "entities", "repost_data", "reposter_id", "likes_count", "reviners_count", "comments_count", "like_id", "like_user_avatar_url", "like_user_user_id", 
            "like_user_timestamp", "like_user_location", "like_user_username", "like_user_verified", "comment_id", "comment", "comment_user_avatar_url", "comment_user_user_id", "comment_user_timestamp", "comment_user_location", 
            "comment_user_username", "comment_user_verified", "comment_is_last", "comment_entities", "user_background_color", "loops", "velocity", "on_fire", "last_refresh", "sort_id"
        };

        static 
        {
            LOOKUP = new HashMap(43);
            LOOKUP.put("_id", Integer.valueOf(0));
            LOOKUP.put("post_id", Integer.valueOf(1));
            LOOKUP.put("my_repost_id", Integer.valueOf(2));
            LOOKUP.put("tags", Integer.valueOf(3));
            LOOKUP.put("thumbnail_url", Integer.valueOf(4));
            LOOKUP.put("share_url", Integer.valueOf(5));
            LOOKUP.put("video_low_uRL", Integer.valueOf(6));
            LOOKUP.put("video_url", Integer.valueOf(7));
            LOOKUP.put("description", Integer.valueOf(8));
            LOOKUP.put("foursquare_venue_id", Integer.valueOf(9));
            LOOKUP.put("metadata_flags", Integer.valueOf(10));
            LOOKUP.put("post_flags", Integer.valueOf(11));
            LOOKUP.put("post_type", Integer.valueOf(12));
            LOOKUP.put("tag", Integer.valueOf(13));
            LOOKUP.put("sort_id", Integer.valueOf(49));
            LOOKUP.put("is_last", Integer.valueOf(14));
            LOOKUP.put("avatar_url", Integer.valueOf(15));
            LOOKUP.put("user_id", Integer.valueOf(16));
            LOOKUP.put("timestamp", Integer.valueOf(17));
            LOOKUP.put("location", Integer.valueOf(18));
            LOOKUP.put("username", Integer.valueOf(19));
            LOOKUP.put("venue_data", Integer.valueOf(20));
            LOOKUP.put("entities", Integer.valueOf(21));
            LOOKUP.put("repost_data", Integer.valueOf(22));
            LOOKUP.put("reposter_id", Integer.valueOf(23));
            LOOKUP.put("likes_count", Integer.valueOf(24));
            LOOKUP.put("reviners_count", Integer.valueOf(25));
            LOOKUP.put("comments_count", Integer.valueOf(26));
            LOOKUP.put("like_id", Integer.valueOf(27));
            LOOKUP.put("like_user_avatar_url", Integer.valueOf(28));
            LOOKUP.put("like_user_user_id", Integer.valueOf(29));
            LOOKUP.put("like_user_timestamp", Integer.valueOf(30));
            LOOKUP.put("like_user_location", Integer.valueOf(31));
            LOOKUP.put("like_user_username", Integer.valueOf(32));
            LOOKUP.put("like_user_verified", Integer.valueOf(33));
            LOOKUP.put("comment_id", Integer.valueOf(34));
            LOOKUP.put("comment", Integer.valueOf(35));
            LOOKUP.put("comment_user_avatar_url", Integer.valueOf(36));
            LOOKUP.put("comment_user_user_id", Integer.valueOf(37));
            LOOKUP.put("comment_user_timestamp", Integer.valueOf(38));
            LOOKUP.put("comment_user_location", Integer.valueOf(39));
            LOOKUP.put("comment_user_username", Integer.valueOf(40));
            LOOKUP.put("comment_user_verified", Integer.valueOf(41));
            LOOKUP.put("comment_is_last", Integer.valueOf(42));
            LOOKUP.put("comment_entities", Integer.valueOf(43));
            LOOKUP.put("user_background_color", Integer.valueOf(44));
            LOOKUP.put("loops", Integer.valueOf(45));
            LOOKUP.put("velocity", Integer.valueOf(46));
            LOOKUP.put("on_fire", Integer.valueOf(47));
            LOOKUP.put("last_refresh", Integer.valueOf(48));
        }

        public PostCommentsLikesQuery()
        {
        }
    }

    public static final class PostGroupsQuery
    {

        public static final int INDEX_POST_ID = 0;
        public static final int INDEX_SORT_ID = 3;
        public static final int INDEX_TAG = 2;
        public static final int INDEX_TYPE = 1;
        public static final String PROJECTION[] = {
            "post_id", "post_type", "tag", "sort_id"
        };


        public PostGroupsQuery()
        {
        }
    }

    public static final class PostGroupsViewQuery
    {

        public static final int INDEX_AVATAR_URL = 15;
        public static final int INDEX_COMMENTS_COUNT = 26;
        public static final int INDEX_DESCRIPTION = 8;
        public static final int INDEX_ENTITIES = 21;
        public static final int INDEX_FOURSQUARE_VENUE_ID = 9;
        public static final int INDEX_ID = 0;
        public static final int INDEX_IS_LAST = 14;
        public static final int INDEX_LAST_REFRESH = 31;
        public static final int INDEX_LIKES_COUNT = 24;
        public static final int INDEX_LOCATION = 18;
        public static final int INDEX_LOOPS = 28;
        public static final int INDEX_METADATA_FLAGS = 10;
        public static final int INDEX_MY_REPOST_ID = 2;
        public static final int INDEX_ON_FIRE = 30;
        public static final int INDEX_POST_FLAGS = 11;
        public static final int INDEX_POST_ID = 1;
        public static final int INDEX_REPOSTER_ID = 23;
        public static final int INDEX_REPOST_DATA = 22;
        public static final int INDEX_REVINERS_COUNT = 25;
        public static final int INDEX_SHARE_URL = 5;
        public static final int INDEX_SORT_ID = 32;
        public static final int INDEX_TAG = 13;
        public static final int INDEX_TAGS = 3;
        public static final int INDEX_THUMBNAIL_URL = 4;
        public static final int INDEX_TIMESTAMP = 17;
        public static final int INDEX_TYPE = 12;
        public static final int INDEX_USERNAME = 19;
        public static final int INDEX_USER_BACKGROUND_COLOR = 27;
        public static final int INDEX_USER_ID = 16;
        public static final int INDEX_VELOCITY = 29;
        public static final int INDEX_VENUE_DATA = 20;
        public static final int INDEX_VIDEO_LOW_URL = 6;
        public static final int INDEX_VIDEO_URL = 7;
        public static final String PROJECTION[] = {
            "_id", "post_id", "my_repost_id", "tags", "thumbnail_url", "share_url", "video_low_uRL", "video_url", "description", "foursquare_venue_id", 
            "metadata_flags", "post_flags", "post_type", "tag", "is_last", "avatar_url", "user_id", "timestamp", "location", "username", 
            "venue_data", "entities", "repost_data", "reposter_id", "likes_count", "reviners_count", "comments_count", "user_background_color", "loops", "velocity", 
            "on_fire", "last_refresh", "sort_id"
        };


        public PostGroupsViewQuery()
        {
        }
    }

    public static final class PostsQuery
    {

        public static final int INDEX_AVATAR_URL = 11;
        public static final int INDEX_COMMENTS_COUNT = 18;
        public static final int INDEX_DESCRIPTION = 7;
        public static final int INDEX_FOURSQUARE_VENUE_ID = 8;
        public static final int INDEX_ID = 0;
        public static final int INDEX_LAST_REFRESH = 21;
        public static final int INDEX_LIKES_COUNT = 16;
        public static final int INDEX_LOCATION = 15;
        public static final int INDEX_LOOPS = 22;
        public static final int INDEX_METADATA_FLAGS = 9;
        public static final int INDEX_ON_FIRE = 24;
        public static final int INDEX_POST_FLAGS = 10;
        public static final int INDEX_POST_ID = 1;
        public static final int INDEX_REVINERS_COUNT = 17;
        public static final int INDEX_SHARE_URL = 4;
        public static final int INDEX_TAGS = 2;
        public static final int INDEX_THUMBNAIL_URL = 3;
        public static final int INDEX_TIMESTAMP = 14;
        public static final int INDEX_USERNAME = 13;
        public static final int INDEX_USER_BACKGROUND_COLOR = 19;
        public static final int INDEX_USER_ID = 12;
        public static final int INDEX_VELOCITY = 23;
        public static final int INDEX_VENUE_DATA = 20;
        public static final int INDEX_VIDEO_LOW_URL = 5;
        public static final int INDEX_VIDEO_URL = 6;
        public static final String PROJECTION[] = {
            "_id", "post_id", "tags", "thumbnail_url", "share_url", "video_low_uRL", "video_url", "description", "foursquare_venue_id", "metadata_flags", 
            "post_flags", "avatar_url", "user_id", "username", "timestamp", "location", "likes_count", "reviners_count", "comments_count", "user_background_color", 
            "venue_data", "last_refresh", "loops", "velocity", "on_fire"
        };


        public PostsQuery()
        {
        }
    }

    public static final class TableQuery
    {

        public static final int INDEX_ID = 0;
        public static final String PROJECTION[] = {
            "_id"
        };


        public TableQuery()
        {
        }
    }

    public static final class TagsQuery
    {

        public static final int INDEX_ID = 0;
        public static final int INDEX_IS_LAST = 4;
        public static final int INDEX_LAST_USED_TIMESTAMP = 3;
        public static final int INDEX_TAG_ID = 1;
        public static final int INDEX_TAG_NAME = 2;
        public static final String PROJECTION[] = {
            "_id", "tag_id", "tag_name", "last_used_timestamp", "is_last"
        };


        public TagsQuery()
        {
        }
    }

    public static final class TagsRecentlyUsedQuery
    {

        public static final int INDEX_ID = 0;
        public static final int INDEX_LAST_USED_TIMESTAMP = 3;
        public static final int INDEX_TAG_ID = 1;
        public static final int INDEX_TAG_NAME = 2;
        public static final String PROJECTION[] = {
            "_id", "tag_id", "tag_name", "last_used_timestamp"
        };


        public TagsRecentlyUsedQuery()
        {
        }
    }

    public static final class UserGroupsQuery
    {

        public static final int INDEX_USER_ID = 0;
        public static final String PROJECTION[] = {
            "user_id"
        };


        public UserGroupsQuery()
        {
        }
    }

    public static final class UsersQuery
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


        public UsersQuery()
        {
        }
    }


    public static final String AS = " AS ";
    public static final String CHANNELS_TABLE_SQL = "CREATE TABLE  channels (_id INTEGER PRIMARY KEY,channel_id INT UNIQUE NOT NULL,channel TEXT NOT NULL,timestamp INT,background_color TEXT,font_color TEXT,last_used_timestamp INT,is_last INT,icon_full_url TEXT,retina_icon_full_url TEXT);";
    public static final String COMMENTS_TABLE_SQL = "CREATE TABLE  comments (_id INTEGER PRIMARY KEY,comment_id INT UNIQUE NOT NULL,post_id INT NOT NULL,avatar_url TEXT,comment TEXT,user_id INT,username TEXT,timestamp INT,location TEXT,verified INT,entities BLOB,is_last INT,last_refresh INT);";
    public static final String CONVERSATIONS_TABLE_SQL = "CREATE TABLE  conversations (_id INTEGER PRIMARY KEY,conversation_id INT NOT NULL,network_type INT NOT NULL, unread_message_count INT, is_hidden INT DEFAULT 0, last_message INT, last_message_timestamp INT, is_last INT);";
    public static final String CONVERSATION_MESSAGE_USERS_VIEW_SQL = "CREATE VIEW message_users_view AS SELECT m._id AS _id,m.conversation_row_id AS conversation_row_id,m.message_id AS message_id,m.user_row_id AS user_row_id,m.message AS message,m.timestamp AS timestamp,m.video_url AS video_url,m.thumbnail_url AS thumbnail_url,m.is_last AS is_last,m.vanished AS vanished,m.max_loops AS max_loops,m.vanished_date AS vanished_date,m.ephemeral AS ephemeral,m.local_start_time AS local_start_time,m.deleted AS deleted,m.post_id AS post_id,m.upload_path AS upload_path,m.error_code AS error_code,m.error_reason AS error_reason,c.conversation_id AS conversation_id,c.network_type AS network_type,c.is_hidden AS is_hidden,c.unread_message_count AS unread_message_count,user.username AS sender_user_name,user.avatar_url AS sender_avatar,user.profile_background AS sender_profile_background,post.user_id AS author_user_id,post.username AS author_user_name,post.avatar_url AS author_avatar,post.entities AS post_entities,post.description AS post_description,post.share_url AS post_share_url FROM messages AS  m LEFT JOIN users AS user ON m.user_row_id=user._id LEFT JOIN conversations AS c ON m.conversation_row_id=c._id LEFT JOIN (SELECT p.post_id, p.user_id, p.username, p.avatar_url, p.entities, p.description, p.share_url FROM messages AS m LEFT JOIN post_comments_likes_view AS p ON m.post_id=p.post_id GROUP BY p.post_id) AS post ON m.post_id=post.post_id;";
    public static final String CONVERSATION_RECIPIENTS_TABLE_SQL = "CREATE TABLE conversation_recipients (_id INTEGER PRIMARY KEY,conversation_row_id INT NOT NULL,user_row_id INT NOT NULL, UNIQUE (conversation_row_id,user_row_id) ON CONFLICT IGNORE);";
    public static final String CONVERSATION_RECIPIENTS_USERS_VIEW = "CREATE VIEW  conversation_recipients_users_view AS SELECT conversation_recipients._id AS _id,conversation_recipients.conversation_row_id AS conversation_row_id,conversation_recipients.user_row_id AS user_row_id,user.username AS username,user.user_id AS user_id,user.phone_number AS phone_number,user.email_address AS email_address,user.profile_background AS profile_background FROM conversation_recipients LEFT JOIN users AS user ON conversation_recipients.user_row_id=user._id;";
    public static final String CREATE_TABLE = "CREATE TABLE ";
    public static final String CREATE_VIEW = "CREATE VIEW ";
    public static final String EDITIONS_TABLE_SQL = "CREATE TABLE  editions (_id INTEGER PRIMARY KEY,edition_code TEXT,edition_name TEXT);";
    public static final String INBOX_VIEW_SQL = "CREATE VIEW inbox_view AS SELECT cr._id AS _id,cr.conversation_row_id AS conversation_row_id,( SELECT COUNT(*) FROM conversation_recipients where conversation_row_id = cr.conversation_row_id group by conversation_row_id) AS recipients_count,m.timestamp AS timestamp,m.error_reason AS error_reason,c.network_type AS network_type,c.unread_message_count AS unread_message_count,c.is_hidden AS is_hidden,c.last_message AS last_message,c.is_last AS is_last,u.username AS username,u._id AS user_row_id,u.user_id AS user_id,u.following_flag AS following_flag,u.avatar_url AS avatar_url,u.profile_background AS profile_background FROM conversation_recipients AS cr JOIN users AS u ON cr.user_row_id= u._id JOIN messages AS m ON c.last_message=m._id JOIN conversations AS c ON c._id =cr.conversation_row_id GROUP BY cr.conversation_row_id ORDER BY timestamp DESC;";
    public static final String LIKES_TABLE_SQL = "CREATE TABLE  likes (_id INTEGER PRIMARY KEY,like_id INT UNIQUE NOT NULL,post_id INT NOT NULL,avatar_url TEXT,user_id INT,username TEXT,timestamp INT,location TEXT,verified INT,last_refresh INT);";
    public static final String MESSAGES_TABLE_SQL = "CREATE TABLE  messages (_id INTEGER PRIMARY KEY,conversation_row_id INT NOT NULL,message_id INT NOT NULL,user_row_id INT NOT NULL,timestamp INT,message TEXT,video_url TEXT,thumbnail_url TEXT, is_last INT,vanished INT,max_loops INT,vanished_date INT,ephemeral INT,local_start_time INT,deleted INT,post_id INT,upload_path TEXT,error_code INT,error_reason TEXT);";
    public static final String NOTIFICATIONS_TABLE_SQL = "CREATE TABLE  notifications (_id INTEGER PRIMARY KEY,notification_id INT UNIQUE NOT NULL,notification_type INT,message TEXT,cleared INT, conversation_row_id INT, avatar_url TEXT);";
    public static final String PAGE_CURSOR_TABLE_SQL = "CREATE TABLE  page_cursors (_id INTEGER PRIMARY KEY,type INT,tag TEXT,kind INT,next_page INT,previous_page INT,anchor TEXT,reversed INT);";
    public static final String POSTS_TABLE_SQL = "CREATE TABLE  posts (_id INTEGER PRIMARY KEY,post_id INT NOT NULL,my_repost_id INT,tags BLOB,thumbnail_url TEXT,share_url TEXT,video_low_uRL TEXT,video_url TEXT,description TEXT,foursquare_venue_id TEXT,metadata_flags INT,post_flags INT,avatar_url TEXT,user_id INT,username TEXT,timestamp INT,location TEXT,venue_data BLOB,entities BLOB,likes_count INT,reviners_count INT,comments_count INT,user_background_color INT,last_refresh INT,loops INT,velocity INT,on_fire INT);";
    public static final String POST_COMMENTS_LIKES_VIEW_SQL = "CREATE VIEW  post_comments_likes_view AS  SELECT post_groups_view._id AS _id,post_groups_view.post_id AS post_id,post_groups_view.my_repost_id AS my_repost_id,post_groups_view.tags AS tags,post_groups_view.thumbnail_url AS thumbnail_url,post_groups_view.share_url AS share_url,post_groups_view.video_low_uRL AS video_low_uRL,post_groups_view.video_url AS video_url,post_groups_view.description AS description,post_groups_view.foursquare_venue_id AS foursquare_venue_id,post_groups_view.metadata_flags AS metadata_flags,post_groups_view.post_flags AS post_flags,post_groups_view.post_type AS post_type,post_groups_view.tag AS tag,post_groups_view.sort_id AS sort_id,post_groups_view.is_last AS is_last,post_groups_view.avatar_url AS avatar_url,post_groups_view.user_id AS user_id,post_groups_view.timestamp AS timestamp,post_groups_view.location AS location,post_groups_view.username AS username,post_groups_view.venue_data AS venue_data,post_groups_view.entities AS entities,post_groups_view.repost_data AS repost_data,post_groups_view.reposter_id AS reposter_id,post_groups_view.likes_count AS likes_count,post_groups_view.reviners_count AS reviners_count,post_groups_view.comments_count AS comments_count,post_groups_view.user_background_color AS user_background_color,post_groups_view.loops AS loops,post_groups_view.velocity AS velocity,post_groups_view.on_fire AS on_fire,post_groups_view.last_refresh AS last_refresh,likes.like_id AS like_id,likes.avatar_url AS like_user_avatar_url,likes.user_id AS like_user_user_id,likes.timestamp AS like_user_timestamp,likes.location AS like_user_location,likes.username AS like_user_username,likes.verified AS like_user_verified,null  AS comment_id,null  AS comment,null  AS comment_user_avatar_url,null  AS comment_user_user_id,null  AS comment_user_timestamp,null  AS comment_user_location,null  AS comment_user_username,null  AS comment_user_verified,null  AS comment_is_last,null  AS comment_entities FROM post_groups_view LEFT JOIN likes ON post_groups_view.post_id = likes.post_id UNION SELECT post_groups_view._id AS _id,post_groups_view.post_id AS post_id,post_groups_view.my_repost_id AS my_repost_id,post_groups_view.tags AS tags,post_groups_view.thumbnail_url AS thumbnail_url,post_groups_view.share_url AS share_url,post_groups_view.video_low_uRL AS video_low_uRL,post_groups_view.video_url AS video_url,post_groups_view.description AS description,post_groups_view.foursquare_venue_id AS foursquare_venue_id,post_groups_view.metadata_flags AS metadata_flags,post_groups_view.post_flags AS post_flags,post_groups_view.post_type AS post_type,post_groups_view.tag AS tag,post_groups_view.sort_id AS sort_id,post_groups_view.is_last AS is_last,post_groups_view.avatar_url AS avatar_url,post_groups_view.user_id AS user_id,post_groups_view.timestamp AS timestamp,post_groups_view.location AS location,post_groups_view.username AS username,post_groups_view.venue_data AS venue_data,post_groups_view.entities AS entities,post_groups_view.repost_data AS repost_data,post_groups_view.reposter_id AS reposter_id,post_groups_view.likes_count AS likes_count,post_groups_view.reviners_count AS reviners_count,post_groups_view.comments_count AS comments_count,post_groups_view.user_background_color AS user_background_color,post_groups_view.loops AS loops,post_groups_view.velocity AS velocity,post_groups_view.on_fire AS on_fire,post_groups_view.last_refresh AS last_refresh,null  AS like_id,null  AS like_user_avatar_url,null  AS like_user_user_id,null  AS like_user_timestamp,null  AS like_user_location,null  AS like_user_username,null  AS like_user_verified,comments.comment_id AS comment_id,comments.comment AS comment,comments.avatar_url AS comment_user_avatar_url,comments.user_id AS comment_user_user_id,comments.timestamp AS comment_user_timestamp,comments.location AS comment_user_location,comments.username AS comment_user_username,comments.verified AS comment_user_verified,comments.is_last AS comment_is_last,comments.entities AS comment_entities FROM post_groups_view LEFT JOIN comments ON post_groups_view.post_id = comments.post_id ";
    public static final String POST_GROUPS_TABLE_SQL = "CREATE TABLE  post_groups (_id INTEGER PRIMARY KEY,post_type INT,tag TEXT,post_id INT,is_last INT,repost_data BLOB,reposter_id INT,sort_id INT,g_flags INT);";
    public static final String POST_GROUPS_VIEW_SQL = "CREATE VIEW  post_groups_view AS SELECT post_groups._id AS _id,post_groups.post_type AS post_type,post_groups.tag AS tag,post_groups.post_id AS post_id,post_groups.is_last AS is_last,post_groups.g_flags AS g_flags,post_groups.sort_id AS sort_id,post_groups.repost_data AS repost_data,post_groups.reposter_id AS reposter_id,posts.username AS username,posts.avatar_url AS avatar_url,posts.thumbnail_url AS thumbnail_url,posts.metadata_flags AS metadata_flags,posts.user_id AS user_id,posts.my_repost_id AS my_repost_id,posts.timestamp AS timestamp,posts.location AS location,posts.tags AS tags,posts.share_url AS share_url,posts.video_low_uRL AS video_low_uRL,posts.video_url AS video_url,posts.video_low_uRL AS video_low_uRL,posts.description AS description,posts.foursquare_venue_id AS foursquare_venue_id,posts.post_flags AS post_flags,posts.venue_data AS venue_data,posts.entities AS entities,posts.likes_count AS likes_count,posts.reviners_count AS reviners_count,posts.comments_count AS comments_count,posts.user_background_color AS user_background_color,posts.loops AS loops,posts.velocity AS velocity,posts.on_fire AS on_fire,posts.last_refresh AS last_refresh FROM post_groups LEFT JOIN posts AS posts ON post_groups.post_id=posts.post_id;";
    public static final String SELECTION_COMMENTS_BY_POST_ID = "post_id=?";
    public static final String SELECTION_PAGE_CURSOR_KIND_TYPE_TAG = "kind=? AND type=? AND tag=?";
    public static final String SELECTION_POST_GROUP_TYPE = "post_type=?";
    public static final String SELECTION_POST_GROUP_TYPE_AND_TAG = "post_type=? AND tag=?";
    public static final String SELECTION_POST_ID = "post_id=?";
    public static final String SELECTION_POST_ID_AND_TYPE_AND_TAG = "post_id=? AND post_type=? AND tag=?";
    public static final String SELECTION_ROW_ID = "_id=?";
    public static final String SELECTION_USER_GROUP_TYPE = "type=?";
    public static final String SELECTION_USER_GROUP_TYPE_AND_TAG = "type=? AND tag=?";
    public static final String SELECTION_USER_ID = "user_id=?";
    public static final String SETTINGS_TABLE_SQL = "CREATE TABLE  settings (_id INTEGER PRIMARY KEY,name TEXT UNIQUE ON CONFLICT REPLACE,value TEXT);";
    public static final String TAGS_RECENTLY_USED_TABLE_SQL = "CREATE TABLE  tag_recently_used (_id INTEGER PRIMARY KEY,tag_id INT UNIQUE NOT NULL,tag_name TEXT NOT NULL,last_used_timestamp TEXT);";
    public static final String TAGS_TABLE_SQL = "CREATE TABLE  tag_search_results (_id INTEGER PRIMARY KEY,tag_id INT UNIQUE NOT NULL,tag_name TEXT NOT NULL,last_used_timestamp TEXT,is_last INT);";
    public static final String USERS_SECTION_TABLE_SQL = "CREATE TABLE  user_sections (_id INTEGER PRIMARY KEY,user_id INT, section_type INT, section_index INT, section_title TEXT, last_section_refresh INT);";
    public static final String USERS_TABLE_SQL = "CREATE TABLE  users (_id INTEGER PRIMARY KEY,user_id INT,avatar_url TEXT,blocked INT,blocking INT,hide_profile_reposts INT,description TEXT,location TEXT,explicit INT,follower_count INT,following_count INT,following_flag INT,like_count INT,post_count INT,username TEXT,email_address TEXT,phone_number TEXT,verified INT,follow_status INT,last_refresh INT,accepts_oon_conversations INT,profile_background INT, loop_count INT);";
    public static final String USER_GROUPS_TABLE_SQL = "CREATE TABLE  user_groups (_id INTEGER PRIMARY KEY,type INT,tag TEXT,user_id INT,is_last INT,g_flags INT,order_id INT);";
    public static final String USER_GROUPS_VIEW_SQL = "CREATE VIEW  user_groups_view AS SELECT user_groups._id AS _id,user_groups.type AS type,user_groups.tag AS tag,user_groups.user_id AS user_id,user_groups.is_last AS is_last,user_groups.g_flags AS g_flags,user_groups.order_id AS order_id,user.username AS username,user.user_id AS user_id,user.avatar_url AS avatar_url,user.blocked AS blocked,user.blocking AS blocking,user.description AS description,user.location AS location,user.explicit AS explicit,user.follower_count AS follower_count,user.following_count AS following_count,user.following_flag AS following_flag,user.like_count AS like_count,user.post_count AS post_count,user.follow_status AS follow_status,user.verified AS verified,user.accepts_oon_conversations AS accepts_oon_conversations,user.profile_background AS profile_background, user.loop_count AS loop_count, section.last_section_refresh AS last_section_refresh,section.section_index AS section_index,section.section_title AS section_title,section.section_type AS section_type FROM user_groups LEFT JOIN users AS user ON user_groups.user_id=user.user_id LEFT JOIN user_sections as section ON section.user_id=user.user_id ;";

    public VineDatabaseSQL()
    {
    }
}
