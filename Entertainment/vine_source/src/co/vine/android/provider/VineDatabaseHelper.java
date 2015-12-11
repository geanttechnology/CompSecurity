// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import co.vine.android.Friendships;
import co.vine.android.VineLoggingException;
import co.vine.android.api.VineChannel;
import co.vine.android.api.VineComment;
import co.vine.android.api.VineComparatorFactory;
import co.vine.android.api.VineConversation;
import co.vine.android.api.VineLike;
import co.vine.android.api.VinePagedData;
import co.vine.android.api.VinePost;
import co.vine.android.api.VinePrivateMessage;
import co.vine.android.api.VineRecipient;
import co.vine.android.api.VineRepost;
import co.vine.android.api.VineSingleNotification;
import co.vine.android.api.VineTag;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.LongSparseArray;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageUtils;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

// Referenced classes of package co.vine.android.provider:
//            DbResponse

public class VineDatabaseHelper extends SQLiteOpenHelper
{
    public static class VineViewedMessage
    {

        public final long conversationId;
        public final long localStartTime;
        public final long messageId;

        public VineViewedMessage(long l, long l1, long l2)
        {
            conversationId = l;
            messageId = l1;
            localStartTime = l2;
        }
    }


    private static final String CURRENT_ACCOUNT_KEY = "current_account";
    private static final String CURRENT_ACCOUNT_NAME = "current_name";
    private static final String CURRENT_USER_ID_KEY = "current_user_id";
    public static final int DATABASE_VERSION = 24;
    private static final String DB_NAME = "vine";
    private static final boolean LOGGABLE;
    private static final int MAX_ACTIVITY_TABLE_SIZE = 500;
    private static final int MAX_COMMENTS_TABLE_SIZE = 5000;
    private static final int MAX_LIKES_TABLE_SIZE = 5000;
    private static final int MAX_POST_TABLE_SIZE = 1000;
    private static final int MAX_USERS_TABLE_SIZE = 10000;
    public static final int SCHEMA_VERSION = 1;
    private static final String SEPARATOR = "-";
    public static final String SETTINGS_NAME_SELECTION = "name=?";
    private static final String TAG = "VineDH";
    private static final HashMap sHelperMap = new HashMap();
    private final Context mAppContext;
    private ContentResolver mContentResolver;

    private VineDatabaseHelper(Context context, String s)
    {
        super(context, s, null, 24);
        mContentResolver = context.getContentResolver();
        mAppContext = context.getApplicationContext();
    }

    private void dropTables(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("DROP VIEW IF EXISTS  user_groups_view;");
        sqlitedatabase.execSQL("DROP VIEW IF EXISTS  post_groups_view;");
        sqlitedatabase.execSQL("DROP VIEW IF EXISTS  post_comments_likes_view;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS users;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS settings;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS user_groups;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS comments;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS likes;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS posts;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS post_groups;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS page_cursors;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS tag_search_results;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS tag_search_results;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS channels;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS notifications;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS tag_recently_used;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS editions;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS messages;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS conversation_recipients;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS conversations;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS user_sections;");
        sqlitedatabase.execSQL("DROP VIEW IF EXISTS message_users_view;");
        sqlitedatabase.execSQL("DROP VIEW IF EXISTS inbox_view;");
        sqlitedatabase.execSQL("DROP VIEW IF EXISTS conversation_recipients_users_view;");
    }

    private void fillChannelValues(ContentValues contentvalues, VineChannel vinechannel)
    {
        contentvalues.put("channel_id", Long.valueOf(vinechannel.channelId));
        contentvalues.put("channel", vinechannel.channel);
        contentvalues.put("background_color", vinechannel.backgroundColor);
        contentvalues.put("font_color", vinechannel.fontColor);
        contentvalues.put("timestamp", Long.valueOf(vinechannel.created));
        contentvalues.put("icon_full_url", vinechannel.iconFullUrl);
        contentvalues.put("retina_icon_full_url", vinechannel.retinaIconFullUrl);
    }

    private void fillCommentValues(ContentValues contentvalues, VineComment vinecomment, long l)
    {
        contentvalues.put("comment_id", Long.valueOf(vinecomment.commentId));
        contentvalues.put("user_id", Long.valueOf(vinecomment.userId));
        contentvalues.put("post_id", Long.valueOf(vinecomment.postId));
        contentvalues.put("avatar_url", vinecomment.avatarUrl);
        contentvalues.put("comment", vinecomment.comment);
        contentvalues.put("timestamp", Long.valueOf(vinecomment.timestamp));
        contentvalues.put("location", vinecomment.location);
        contentvalues.put("username", vinecomment.username);
        contentvalues.put("verified", Boolean.valueOf(vinecomment.verified));
        if (vinecomment.entities != null)
        {
            contentvalues.put("entities", Util.toByteArray(vinecomment.entities));
        }
        contentvalues.put("last_refresh", Long.valueOf(l));
        contentvalues.put("is_last", Boolean.valueOf(vinecomment.isLast));
    }

    private void fillConversationValues(ContentValues contentvalues, Long long1, Integer integer, Boolean boolean1, long l, long l1)
    {
        if (long1 != null)
        {
            contentvalues.put("conversation_id", long1);
        }
        if (integer != null)
        {
            contentvalues.put("network_type", integer);
        }
        if (boolean1 != null)
        {
            int i;
            if (boolean1.booleanValue())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            contentvalues.put("is_hidden", Integer.valueOf(i));
        }
        if (l > -1L)
        {
            contentvalues.put("unread_message_count", Long.valueOf(l));
        }
        if (l1 > 0L)
        {
            contentvalues.put("last_message", Long.valueOf(l1));
        }
    }

    private void fillLikeValues(ContentValues contentvalues, VineLike vinelike, long l)
    {
        contentvalues.put("like_id", Long.valueOf(vinelike.likeId));
        contentvalues.put("user_id", Long.valueOf(vinelike.userId));
        contentvalues.put("post_id", Long.valueOf(vinelike.postId));
        contentvalues.put("avatar_url", vinelike.avatarUrl);
        contentvalues.put("timestamp", Long.valueOf(vinelike.created));
        contentvalues.put("location", vinelike.location);
        contentvalues.put("username", vinelike.username);
        contentvalues.put("verified", Integer.valueOf(vinelike.verified));
        contentvalues.put("last_refresh", Long.valueOf(l));
    }

    private void fillMessageValues(ContentValues contentvalues, long l, VinePrivateMessage vineprivatemessage)
    {
        contentvalues.put("conversation_row_id", Long.valueOf(l));
        contentvalues.put("message_id", Long.valueOf(vineprivatemessage.messageId));
        contentvalues.put("user_row_id", Long.valueOf(vineprivatemessage.userId));
        contentvalues.put("message", vineprivatemessage.message);
        contentvalues.put("timestamp", Long.valueOf(vineprivatemessage.created));
        if (!TextUtils.isEmpty(vineprivatemessage.videoUrl))
        {
            contentvalues.put("video_url", vineprivatemessage.videoUrl);
        }
        if (!TextUtils.isEmpty(vineprivatemessage.thumbnailUrl))
        {
            contentvalues.put("thumbnail_url", vineprivatemessage.thumbnailUrl);
        }
        contentvalues.put("is_last", Boolean.valueOf(vineprivatemessage.isLast));
        contentvalues.put("vanished", Boolean.valueOf(vineprivatemessage.vanished));
        contentvalues.put("max_loops", Integer.valueOf(vineprivatemessage.maxLoops));
        contentvalues.put("vanished_date", Long.valueOf(vineprivatemessage.vanishedDate));
        contentvalues.put("ephemeral", Boolean.valueOf(vineprivatemessage.ephemeral));
        contentvalues.put("local_start_time", Long.valueOf(vineprivatemessage.localStartTime));
        contentvalues.put("post_id", Long.valueOf(vineprivatemessage.postId));
        contentvalues.put("error_code", Integer.valueOf(vineprivatemessage.errorCode));
        contentvalues.put("error_reason", vineprivatemessage.errorReason);
        if (!TextUtils.isEmpty(vineprivatemessage.uploadPath))
        {
            contentvalues.put("upload_path", vineprivatemessage.uploadPath);
        }
    }

    private void fillNotificationValues(ContentValues contentvalues, VineSingleNotification vinesinglenotification, String s)
    {
        contentvalues.put("avatar_url", vinesinglenotification.avatarUrl);
        contentvalues.put("notification_id", Long.valueOf(vinesinglenotification.notificationId));
        contentvalues.put("notification_type", Integer.valueOf(vinesinglenotification.notificationType));
        contentvalues.put("conversation_row_id", Long.valueOf(vinesinglenotification.conversationRowId));
        contentvalues.put("message", s);
    }

    private void fillPostValues(ContentValues contentvalues, VinePost vinepost, long l)
        throws IOException
    {
        contentvalues.put("avatar_url", vinepost.avatarUrl);
        contentvalues.put("description", vinepost.description);
        contentvalues.put("foursquare_venue_id", vinepost.foursquareVenueId);
        contentvalues.put("metadata_flags", Integer.valueOf(vinepost.metadataFlags));
        contentvalues.put("location", vinepost.location);
        contentvalues.put("post_flags", Integer.valueOf(vinepost.postFlags));
        contentvalues.put("post_id", Long.valueOf(vinepost.postId));
        contentvalues.put("my_repost_id", Long.valueOf(vinepost.myRepostId));
        contentvalues.put("share_url", vinepost.shareUrl);
        contentvalues.put("thumbnail_url", vinepost.thumbnailUrl);
        contentvalues.put("video_url", vinepost.videoUrl);
        contentvalues.put("video_low_uRL", vinepost.videoLowURL);
        contentvalues.put("timestamp", Long.valueOf(vinepost.created));
        contentvalues.put("username", vinepost.username);
        contentvalues.put("user_id", Long.valueOf(vinepost.userId));
        contentvalues.put("likes_count", Integer.valueOf(vinepost.likesCount));
        contentvalues.put("reviners_count", Integer.valueOf(vinepost.revinersCount));
        contentvalues.put("comments_count", Integer.valueOf(vinepost.commentsCount));
        contentvalues.put("user_background_color", Integer.valueOf(vinepost.userBackgroundColor));
        contentvalues.put("tags", VinePost.getBytesFromTags(vinepost));
        contentvalues.put("loops", Long.valueOf(vinepost.loops));
        contentvalues.put("velocity", Double.valueOf(vinepost.velocity));
        contentvalues.put("on_fire", Boolean.valueOf(vinepost.onFire));
        if (vinepost.venueData != null)
        {
            contentvalues.put("venue_data", Util.toByteArray(vinepost.venueData));
        }
        if (vinepost.entities != null)
        {
            contentvalues.put("entities", Util.toByteArray(vinepost.entities));
        }
        contentvalues.put("last_refresh", Long.valueOf(l));
    }

    private void fillTagValues(ContentValues contentvalues, VineTag vinetag)
    {
        contentvalues.put("tag_id", Long.valueOf(vinetag.tagId));
        contentvalues.put("tag_name", vinetag.tagName);
        contentvalues.put("last_used_timestamp", Long.valueOf(System.currentTimeMillis()));
    }

    private void fillUserContentValues(ContentValues contentvalues, VineUser vineuser, long l)
    {
        contentvalues.put("user_id", Long.valueOf(vineuser.userId));
        contentvalues.put("avatar_url", vineuser.avatarUrl);
        contentvalues.put("username", vineuser.username);
        contentvalues.put("blocked", Integer.valueOf(vineuser.blocked));
        contentvalues.put("blocking", Integer.valueOf(vineuser.blocking));
        contentvalues.put("description", vineuser.description);
        contentvalues.put("location", vineuser.location);
        contentvalues.put("explicit", Integer.valueOf(vineuser.explicit));
        contentvalues.put("follower_count", Integer.valueOf(vineuser.followerCount));
        contentvalues.put("following_count", Integer.valueOf(vineuser.followingCount));
        if (!TextUtils.isEmpty(vineuser.email))
        {
            contentvalues.put("email_address", vineuser.email);
        }
        if (!TextUtils.isEmpty(vineuser.phoneNumber))
        {
            contentvalues.put("phone_number", vineuser.phoneNumber);
        }
        if (vineuser.following != -1)
        {
            contentvalues.put("following_flag", Integer.valueOf(vineuser.following));
        }
        contentvalues.put("like_count", Integer.valueOf(vineuser.likeCount));
        contentvalues.put("post_count", Integer.valueOf(vineuser.postCount));
        contentvalues.put("loop_count", Long.valueOf(vineuser.loopCount));
        contentvalues.put("verified", Integer.valueOf(vineuser.verified));
        contentvalues.put("follow_status", Integer.valueOf(vineuser.followStatus));
        contentvalues.put("last_refresh", Long.valueOf(l));
        if (vineuser.profileBackground > -1)
        {
            contentvalues.put("profile_background", Integer.valueOf(vineuser.profileBackground));
        }
        int i;
        if (vineuser.acceptsOutOfNetworkConversations)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("accepts_oon_conversations", Integer.valueOf(i));
    }

    public static VineDatabaseHelper getDatabaseHelper(Context context)
    {
        co/vine/android/provider/VineDatabaseHelper;
        JVM INSTR monitorenter ;
        VineDatabaseHelper vinedatabasehelper1;
        String s;
        s = getDatabaseName(1);
        vinedatabasehelper1 = (VineDatabaseHelper)sHelperMap.get(s);
        VineDatabaseHelper vinedatabasehelper;
        vinedatabasehelper = vinedatabasehelper1;
        if (vinedatabasehelper1 != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        vinedatabasehelper = new VineDatabaseHelper(context.getApplicationContext(), s);
        sHelperMap.put(s, vinedatabasehelper);
        co/vine/android/provider/VineDatabaseHelper;
        JVM INSTR monitorexit ;
        return vinedatabasehelper;
        context;
        throw context;
    }

    public static String getDatabaseName(int i)
    {
        return (new StringBuilder()).append("vine-").append(i).toString();
    }

    public static File getDatabasePath(Context context)
    {
        return context.getDatabasePath(getDatabaseName(1));
    }

    private long getLastChannelRowId()
    {
        Cursor cursor;
        cursor = getReadableDatabase().query("channels", VineDatabaseSQL.ChannelsQuery.PROJECTION, null, null, null, null, "channel_id DESC", "1");
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        long l;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_53;
        }
        l = cursor.getLong(0);
        cursor.close();
        return l;
        cursor.close();
        return 0L;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    private long getLastCommentRowId(long l)
    {
        Cursor cursor;
        cursor = getReadableDatabase().query("comments", VineDatabaseSQL.CommentsQuery.PROJECTION, "post_id =? ", new String[] {
            String.valueOf(l)
        }, null, null, "comment_id ASC", "1");
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        l = cursor.getLong(0);
        cursor.close();
        return l;
        cursor.close();
        return 0L;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    private long getLastConversationId(int i)
    {
        Cursor cursor;
        cursor = getReadableDatabase().query("conversations", new String[] {
            "_id"
        }, "last_message>0 AND network_type =? ", new String[] {
            String.valueOf(i)
        }, null, null, "last_message_timestamp ASC, _id DESC", "1");
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        long l;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        l = cursor.getLong(0);
        cursor.close();
        return l;
        cursor.close();
        return 0L;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    private long getLastMessageRowId(long l)
    {
        Cursor cursor;
        cursor = getReadableDatabase().query("messages", VineDatabaseSQL.MessagesQuery.PROJECTION, "conversation_row_id =? AND deleted != 1 ", new String[] {
            String.valueOf(l)
        }, null, null, "message_id ASC", "1");
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        l = cursor.getLong(0);
        cursor.close();
        return l;
        cursor.close();
        return 0L;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    private long getLastPostRowId(int i, String s)
    {
        s = getReadableDatabase().query("post_comments_likes_view", VineDatabaseSQL.PostCommentsLikesQuery.PROJECTION, "post_type=? AND tag=?", new String[] {
            String.valueOf(i), s
        }, null, null, "sort_id ASC", "1");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        long l;
        if (!s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_71;
        }
        l = s.getLong(0);
        s.close();
        return l;
        s.close();
        return 0L;
        Exception exception;
        exception;
        s.close();
        throw exception;
    }

    private long getLastTagRowId()
    {
        Cursor cursor;
        cursor = getReadableDatabase().query("tag_search_results", VineDatabaseSQL.TagsQuery.PROJECTION, null, null, null, null, "_id DESC", "1");
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        long l;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_53;
        }
        l = cursor.getLong(0);
        cursor.close();
        return l;
        cursor.close();
        return 0L;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    private long getLastUserRowId(int i, String s, String s1)
    {
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        String as[];
        long l;
        if (s != null)
        {
            String s2 = "type=? AND tag=?";
            as = new String[2];
            as[0] = String.valueOf(i);
            as[1] = s;
            s = s2;
        } else
        {
            s = "type=?";
            as = new String[1];
            as[0] = String.valueOf(i);
        }
        s = sqlitedatabase.query("user_groups_view", VineDatabaseSQL.UsersQuery.PROJECTION, s, as, null, null, s1, "1");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        if (!s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_110;
        }
        l = s.getLong(0);
        s.close();
        return l;
        s.close();
        return 0L;
        s1;
        s.close();
        throw s1;
    }

    private void mergePostGroups(Collection collection, int i, String s, LongSparseArray longsparsearray)
    {
        this;
        JVM INSTR monitorenter ;
        if (collection != null && i != -1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("mergePostGroups: ").append(collection.size()).append(", tagged by: ").append(s).append(", of type: ").append(i).toString());
        }
        obj = new LinkedHashMap();
        VinePost vinepost;
        for (collection = collection.iterator(); collection.hasNext(); ((LinkedHashMap) (obj)).put(Long.valueOf(vinepost.postId), vinepost))
        {
            vinepost = (VinePost)collection.next();
        }

        break MISSING_BLOCK_LABEL_131;
        collection;
        throw collection;
        Object obj1;
        collection = getWritableDatabase();
        obj1 = collection.query("post_groups", VineDatabaseSQL.PostGroupsQuery.PROJECTION, "post_type=?", new String[] {
            String.valueOf(i)
        }, null, null, null);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_222;
        }
        boolean flag1 = ((Cursor) (obj1)).moveToFirst();
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_222;
        }
        do
        {
            ((LinkedHashMap) (obj)).remove(Long.valueOf(((Cursor) (obj1)).getLong(0)));
            flag1 = ((Cursor) (obj1)).moveToNext();
        } while (flag1);
        ((Cursor) (obj1)).close();
        int j;
        boolean flag;
        j = 0;
        flag = false;
        if (((LinkedHashMap) (obj)).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_489;
        }
        collection.beginTransaction();
        obj1 = new ContentValues();
        ((ContentValues) (obj1)).put("post_type", Integer.valueOf(i));
        ((ContentValues) (obj1)).put("tag", s);
        s = ((LinkedHashMap) (obj)).values().iterator();
        j = ((flag) ? 1 : 0);
_L3:
        if (!s.hasNext())
        {
            break MISSING_BLOCK_LABEL_469;
        }
        obj = (VinePost)s.next();
        ((ContentValues) (obj1)).put("g_flags", Integer.valueOf(0));
        ((ContentValues) (obj1)).put("post_id", Long.valueOf(((VinePost) (obj)).postId));
        ((ContentValues) (obj1)).put("repost_data", Util.toByteArray(((VinePost) (obj)).repost));
        if (((VinePost) (obj)).repost == null)
        {
            break MISSING_BLOCK_LABEL_444;
        }
        ((ContentValues) (obj1)).put("reposter_id", Long.valueOf(((VinePost) (obj)).repost.userId));
_L4:
        if (longsparsearray == null)
        {
            break MISSING_BLOCK_LABEL_401;
        }
        ((ContentValues) (obj1)).put("sort_id", (Long)longsparsearray.get(((VinePost) (obj)).postId));
        long l = collection.insert("post_groups", "post_id", ((ContentValues) (obj1)));
        int k;
        if (l > 0L)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        j += k;
          goto _L3
        collection;
        ((Cursor) (obj1)).close();
        throw collection;
        ((ContentValues) (obj1)).remove("reposter_id");
          goto _L4
        s;
        safeFinishTransaction(collection);
        throw s;
        collection.setTransactionSuccessful();
        safeFinishTransaction(collection);
        mContentResolver.notifyChange(Vine.PostGroupsView.CONTENT_URI, null);
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Inserted new post groups: ").append(j).append(" of type ").append(i).toString());
        }
          goto _L1
    }

    private void mergeUserGroups(Collection collection, int i, String s, LongSparseArray longsparsearray, LongSparseArray longsparsearray1)
    {
        this;
        JVM INSTR monitorenter ;
        if (collection != null && i != -1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("mergeUserGroups: ").append(collection.size()).append(", tagged by: ").append(s).append(", of type: ").append(i).toString());
        }
        obj = new LinkedHashMap();
        VineUser vineuser;
        for (collection = collection.iterator(); collection.hasNext(); ((LinkedHashMap) (obj)).put(Long.valueOf(vineuser.userId), vineuser))
        {
            vineuser = (VineUser)collection.next();
        }

        break MISSING_BLOCK_LABEL_131;
        collection;
        throw collection;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        collection = sqlitedatabase.query("user_groups", VineDatabaseSQL.UserGroupsQuery.PROJECTION, "type=? AND tag=?", new String[] {
            String.valueOf(i), String.valueOf(s)
        }, null, null, null);
_L4:
        if (collection == null) goto _L1; else goto _L3
_L3:
        for (; collection.moveToNext(); ((LinkedHashMap) (obj)).remove(Long.valueOf(collection.getLong(0)))) { }
        break MISSING_BLOCK_LABEL_250;
        s;
        collection.close();
        throw s;
        collection = sqlitedatabase.query("user_groups", VineDatabaseSQL.UserGroupsQuery.PROJECTION, "type=?", new String[] {
            String.valueOf(i)
        }, null, null, null);
          goto _L4
        collection.close();
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Inserting new user groups: ").append(((LinkedHashMap) (obj)).size()).toString());
        }
        if (((LinkedHashMap) (obj)).size() <= 0) goto _L1; else goto _L5
_L5:
        sqlitedatabase.beginTransaction();
        collection = new ContentValues();
        collection.put("type", Integer.valueOf(i));
        if (s == null) goto _L7; else goto _L6
_L6:
        collection.put("tag", s);
          goto _L7
_L14:
        s = ((LinkedHashMap) (obj)).values().iterator();
_L13:
        if (!s.hasNext()) goto _L9; else goto _L8
_L8:
        obj = (VineUser)s.next();
        collection.put("g_flags", Integer.valueOf(0));
        collection.put("user_id", Long.valueOf(((VineUser) (obj)).userId));
        if (i == 0) goto _L11; else goto _L10
_L10:
        if (longsparsearray1.get(((VineUser) (obj)).userId) == null) goto _L11; else goto _L12
_L12:
        collection.put("order_id", (Long)longsparsearray1.get(((VineUser) (obj)).userId));
_L16:
        sqlitedatabase.insert("user_groups", "user_id", collection);
          goto _L13
        collection;
        safeFinishTransaction(sqlitedatabase);
        throw collection;
_L19:
        i = 0;
          goto _L14
_L11:
        if (longsparsearray == null) goto _L16; else goto _L15
_L15:
        if (longsparsearray.get(((VineUser) (obj)).userId) == null) goto _L16; else goto _L17
_L17:
        collection.put("tag", (Long)longsparsearray.get(((VineUser) (obj)).userId));
          goto _L16
_L9:
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        mContentResolver.notifyChange(Vine.UserGroupsView.CONTENT_URI, null);
          goto _L1
_L7:
        if (longsparsearray1 == null) goto _L19; else goto _L18
_L18:
        i = 1;
          goto _L14
    }

    private void mergetUserSection(SQLiteDatabase sqlitedatabase, ContentValues contentvalues, VineUser vineuser, long l, int i)
    {
        if (i < 0) goto _L2; else goto _L1
_L1:
        String as[];
        contentvalues.clear();
        contentvalues.put("section_type", Integer.valueOf(i));
        if (l > 0L)
        {
            contentvalues.put("last_section_refresh", Long.valueOf(l));
        }
        if (vineuser.friendIndex > 0L)
        {
            contentvalues.put("section_index", Long.valueOf(vineuser.friendIndex));
        }
        contentvalues.put("user_id", Long.valueOf(vineuser.userId));
        contentvalues.put("section_title", vineuser.sectionTitle);
        as = new String[2];
        as[0] = String.valueOf(vineuser.userId);
        as[1] = String.valueOf(i);
        vineuser = sqlitedatabase.query("user_sections", new String[] {
            "_id"
        }, "user_id=? AND section_type=?", as, null, null, null);
        if (vineuser == null) goto _L2; else goto _L3
_L3:
        if (!vineuser.moveToFirst()) goto _L5; else goto _L4
_L4:
        sqlitedatabase.update("user_sections", contentvalues, "user_id=? AND section_type=?", as);
_L7:
        vineuser.close();
_L2:
        return;
_L5:
        sqlitedatabase.insert("user_sections", null, contentvalues);
        if (true) goto _L7; else goto _L6
_L6:
        sqlitedatabase;
        vineuser.close();
        throw sqlitedatabase;
    }

    private void notifyByType(int i)
    {
        switch (i)
        {
        case 7: // '\007'
        default:
            notifyPostCommentsViewUris();
            return;

        case 8: // '\b'
            mContentResolver.notifyChange(Vine.PostCommentsLikesView.CONTENT_URI_ALL_TIMELINE_CHANNEL_POPULAR, null);
            return;

        case 9: // '\t'
            mContentResolver.notifyChange(Vine.PostCommentsLikesView.CONTENT_URI_ALL_TIMELINE_CHANNEL_RECENT, null);
            return;

        case 4: // '\004'
            mContentResolver.notifyChange(Vine.PostCommentsLikesView.CONTENT_URI_ALL_TIMELINE_ON_THE_RISE, null);
            return;

        case 5: // '\005'
            mContentResolver.notifyChange(Vine.PostCommentsLikesView.CONTENT_URI_ALL_TIMELINE_POPULAR_NOW, null);
            return;

        case 6: // '\006'
            mContentResolver.notifyChange(Vine.PostCommentsLikesView.CONTENT_URI_ALL_TIMELINE_TAG, null);
            return;
        }
    }

    private void notifyPostCommentsViewUris()
    {
        mContentResolver.notifyChange(Vine.PostCommentsLikesView.CONTENT_URI_ALL_TIMELINE, null);
        mContentResolver.notifyChange(Vine.PostCommentsLikesView.CONTENT_URI_ALL_TIMELINE_USER, null);
        mContentResolver.notifyChange(Vine.PostCommentsLikesView.CONTENT_URI_ALL_TIMELINE_USER_LIKES, null);
        mContentResolver.notifyChange(Vine.PostCommentsLikesView.CONTENT_URI_ALL_TIMELINE_SINGLE, null);
    }

    private void notifyVMUris()
    {
        mContentResolver.notifyChange(Vine.InboxView.CONTENT_URI, null);
        mContentResolver.notifyChange(Vine.ConversationMessageUsersView.CONTENT_URI, null);
        mContentResolver.notifyChange(Vine.Messages.CONTENT_URI, null);
        mContentResolver.notifyChange(Vine.Conversations.CONTENT_URI, null);
        mContentResolver.notifyChange(Vine.ConversationRecipients.CONTENT_URI, null);
    }

    private int removePostsFromGroup(int i)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        int j;
        sqlitedatabase.beginTransaction();
        j = sqlitedatabase.delete("post_groups", "post_type=?", new String[] {
            String.valueOf(i)
        });
        sqlitedatabase.setTransactionSuccessful();
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Clearing group ").append(i).append(" deleting ").append(j).append(" groups ").toString());
        }
        safeFinishTransaction(sqlitedatabase);
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception1;
        exception1;
        safeFinishTransaction(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private int removePostsFromGroupByPostId(int i, long l)
    {
        this;
        JVM INSTR monitorenter ;
        i = getWritableDatabase().delete("post_groups", "post_type=? AND post_id=?", new String[] {
            String.valueOf(i), String.valueOf(l)
        });
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    private void setValue(String s, long l)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("value", Long.valueOf(l));
        saveUserValue(s, contentvalues);
    }

    private void setValue(String s, String s1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("value", s1);
        saveUserValue(s, contentvalues);
    }

    public int addFollow(long l, long l1, long l2, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Cursor cursor;
        String as[];
        obj = getWritableDatabase();
        as = new String[1];
        as[0] = String.valueOf(l);
        cursor = ((SQLiteDatabase) (obj)).query("users", new String[] {
            "following_flag"
        }, "user_id=?", as, null, null, null);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (!cursor.moveToFirst()) goto _L4; else goto _L3
_L3:
        ArrayList arraylist;
        int k;
        int i = Friendships.setFriendship(cursor.getInt(0), 1);
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("following_flag", Integer.valueOf(i));
        k = ((SQLiteDatabase) (obj)).update("users", contentvalues, "user_id=?", as);
        obj = new VineUser();
        obj.userId = l;
        arraylist = new ArrayList(1);
        arraylist.add(obj);
        obj = null;
        if (l2 <= 0L)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        obj = new LongSparseArray(1);
        ((LongSparseArray) (obj)).put(l, Long.valueOf(l2));
        mergeUserGroups(arraylist, 1, String.valueOf(l1), null, ((LongSparseArray) (obj)));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        mContentResolver.notifyChange(Vine.UserGroupsView.CONTENT_URI_FOLLOWING, null);
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Followed user ").append(l).toString());
        }
        int j;
        j = k;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        cursor.close();
        j = k;
_L7:
        this;
        JVM INSTR monitorexit ;
        return j;
_L4:
        if (cursor == null) goto _L2; else goto _L5
_L5:
        cursor.close();
          goto _L2
        Exception exception;
        exception;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        cursor.close();
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        j = -1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public int addLike(VineLike vinelike, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        String as[];
        sqlitedatabase = getWritableDatabase();
        as = new String[1];
        as[0] = String.valueOf(vinelike.postId);
        int i;
        int j;
        j = 0;
        i = 0;
        Object obj;
        sqlitedatabase.beginTransaction();
        obj = sqlitedatabase.query("posts", new String[] {
            "metadata_flags"
        }, "post_id=?", as, null, null, null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        ContentValues contentvalues;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_170;
        }
        contentvalues = new ContentValues();
        contentvalues.put("metadata_flags", Integer.valueOf(((Cursor) (obj)).getInt(0) | 8));
        if (sqlitedatabase.update("posts", contentvalues, "post_id=?", as) > 0)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        i = j;
        if (!LOGGABLE)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        Log.d("VineDH", (new StringBuilder()).append("Updating like value in post: ").append(vinelike.postId).toString());
        i = j;
        j = i;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        ((Cursor) (obj)).close();
        j = i;
        obj = new ArrayList(1);
        ((ArrayList) (obj)).add(vinelike);
        i = mergeLikes(((Collection) (obj)), vinelike.postId, 0, 0);
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        if (!flag || j <= 0 && i <= 0)
        {
            break MISSING_BLOCK_LABEL_248;
        }
        notifyPostCommentsViewUris();
        this;
        JVM INSTR monitorexit ;
        return j;
        vinelike;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        ((Cursor) (obj)).close();
        throw vinelike;
        vinelike;
        safeFinishTransaction(sqlitedatabase);
        throw vinelike;
        vinelike;
        this;
        JVM INSTR monitorexit ;
        throw vinelike;
    }

    public boolean amFollowingUser(long l)
    {
        Cursor cursor;
        boolean flag;
        boolean flag1;
        cursor = getReadableDatabase().query("users", new String[] {
            "following_flag"
        }, "_id =? ", new String[] {
            String.valueOf(l)
        }, null, null, null);
        flag1 = false;
        flag = false;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        int i;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_75;
        }
        i = cursor.getInt(0);
        if (i == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (cursor != null)
        {
            cursor.close();
            flag1 = flag;
        }
        return flag1;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
    }

    public void cleanTagSearchResults()
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        int i;
        sqlitedatabase.beginTransaction();
        i = sqlitedatabase.delete("tag_search_results", null, null);
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Deleted ").append(i).append(" tag search result rows.").toString());
        }
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        mContentResolver.notifyChange(Vine.TagSearchResults.CONTENT_URI, null);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        safeFinishTransaction(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int cleanUp(long l)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        int i;
        sqlitedatabase.beginTransaction();
        sqlitedatabase.execSQL("DELETE FROM post_groups WHERE post_id IN (SELECT post_id FROM posts WHERE last_refresh < ?);", new String[] {
            String.valueOf(l)
        });
        i = sqlitedatabase.delete("posts", "last_refresh<?", new String[] {
            String.valueOf(l)
        });
        sqlitedatabase.setTransactionSuccessful();
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Cleanup performed, deleted ").append(i).append(" posts with last_refresh less ").append("than anchor: ").append(l).toString());
        }
        safeFinishTransaction(sqlitedatabase);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        notifyPostCommentsViewUris();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception1;
        exception1;
        safeFinishTransaction(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void cleanUserSearchResults()
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        int i;
        sqlitedatabase.beginTransaction();
        i = sqlitedatabase.delete("user_groups", "type=?", new String[] {
            String.valueOf(8)
        });
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Deleted ").append(i).append(" user search result rows.").toString());
        }
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        mContentResolver.notifyChange(Vine.UserGroupsView.CONTENT_URI_USER_SEARCH_RESULTS, null);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        safeFinishTransaction(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void clearAllData()
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("settings", null, null);
        sqlitedatabase.delete("user_groups", null, null);
        sqlitedatabase.delete("posts", null, null);
        sqlitedatabase.delete("likes", null, null);
        sqlitedatabase.delete("post_groups", null, null);
        sqlitedatabase.delete("comments", null, null);
        sqlitedatabase.delete("page_cursors", null, null);
        sqlitedatabase.delete("tag_search_results", null, null);
        sqlitedatabase.delete("channels", null, null);
        sqlitedatabase.delete("notifications", null, null);
        sqlitedatabase.delete("tag_recently_used", null, null);
        sqlitedatabase.delete("messages", null, null);
        sqlitedatabase.delete("conversation_recipients", null, null);
        sqlitedatabase.delete("conversations", null, null);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void clearCachedData()
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.beginTransaction();
        sqlitedatabase.delete("users", null, null);
        sqlitedatabase.delete("user_groups", null, null);
        sqlitedatabase.delete("posts", null, null);
        sqlitedatabase.delete("likes", null, null);
        sqlitedatabase.delete("post_groups", null, null);
        sqlitedatabase.delete("comments", null, null);
        sqlitedatabase.delete("page_cursors", null, null);
        sqlitedatabase.delete("tag_search_results", null, null);
        sqlitedatabase.delete("channels", null, null);
        sqlitedatabase.delete("notifications", null, null);
        sqlitedatabase.delete("tag_recently_used", null, null);
        sqlitedatabase.delete("messages", null, null);
        sqlitedatabase.delete("conversation_recipients", null, null);
        sqlitedatabase.delete("conversations", null, null);
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        safeFinishTransaction(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void clearCachedData(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        clearCachedData();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        notifyPostCommentsViewUris();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void clearFileCache()
    {
        Util.removeCache(mAppContext);
        ImageUtils.removeFiles(mAppContext);
    }

    public void clearUnreadCount(long l)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        int i;
        sqlitedatabase.beginTransaction();
        ContentValues contentvalues = new ContentValues(1);
        contentvalues.put("unread_message_count", Integer.valueOf(0));
        i = sqlitedatabase.update("conversations", contentvalues, "_id=?", new String[] {
            String.valueOf(l)
        });
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        mContentResolver.notifyChange(Vine.ConversationMessageUsersView.CONTENT_URI, null);
        mContentResolver.notifyChange(Vine.InboxView.CONTENT_URI, null);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        safeFinishTransaction(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public long createConversationRowId(HashSet hashset, int i)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        long l;
        sqlitedatabase.beginTransaction();
        ContentValues contentvalues = new ContentValues();
        fillConversationValues(contentvalues, Long.valueOf(-1L), Integer.valueOf(i), Boolean.valueOf(false), 0L, 0L);
        l = sqlitedatabase.insert("conversations", null, contentvalues);
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        mergeConversationRecipients(l, hashset);
        mContentResolver.notifyChange(Vine.InboxView.CONTENT_URI, null);
        this;
        JVM INSTR monitorexit ;
        return l;
        hashset;
        safeFinishTransaction(sqlitedatabase);
        throw hashset;
        hashset;
        this;
        JVM INSTR monitorexit ;
        throw hashset;
    }

    public long createNewUserFromNonUserIdRecipientInfo(String s, String s1, String s2)
    {
        s = new VineUser(s, null, null, null, -1L, -1L, 0, 0, 0, 0, 0, 0, 0, 0, 0, s2, s1, 0, 0, 0, 0, null, false, 0, 0, "", false, false, false, 0L);
        s1 = new ContentValues();
        fillUserContentValues(s1, s, System.currentTimeMillis());
        return getWritableDatabase().insertOrThrow("users", "last_refresh", s1);
    }

    public long createPreMergeConversationIdAndRecipientsIfNecessary(List list, int i)
    {
        HashSet hashset = new HashSet();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            VineRecipient vinerecipient = (VineRecipient)iterator.next();
            if (!vinerecipient.isFromUser())
            {
                long l1 = getUserRowIdForRecipient(vinerecipient);
                long l = l1;
                if (l1 <= 0L)
                {
                    list = null;
                    String s = null;
                    if (vinerecipient.isFromEmail())
                    {
                        list = vinerecipient.value;
                    } else
                    {
                        s = vinerecipient.value;
                    }
                    l = createNewUserFromNonUserIdRecipientInfo(vinerecipient.display, s, list);
                }
                vinerecipient.recipientId = l;
                hashset.add(Long.valueOf(l));
            } else
            {
                hashset.add(Long.valueOf(vinerecipient.recipientId));
            }
        }

        return createConversationRowId(hashset, i);
    }

    protected void createTables(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE  users (_id INTEGER PRIMARY KEY,user_id INT,avatar_url TEXT,blocked INT,blocking INT,hide_profile_reposts INT,description TEXT,location TEXT,explicit INT,follower_count INT,following_count INT,following_flag INT,like_count INT,post_count INT,username TEXT,email_address TEXT,phone_number TEXT,verified INT,follow_status INT,last_refresh INT,accepts_oon_conversations INT,profile_background INT, loop_count INT);");
        sqlitedatabase.execSQL("CREATE TABLE  settings (_id INTEGER PRIMARY KEY,name TEXT UNIQUE ON CONFLICT REPLACE,value TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE  user_sections (_id INTEGER PRIMARY KEY,user_id INT, section_type INT, section_index INT, section_title TEXT, last_section_refresh INT);");
        sqlitedatabase.execSQL("CREATE TABLE  user_groups (_id INTEGER PRIMARY KEY,type INT,tag TEXT,user_id INT,is_last INT,g_flags INT,order_id INT);");
        sqlitedatabase.execSQL("CREATE TABLE  comments (_id INTEGER PRIMARY KEY,comment_id INT UNIQUE NOT NULL,post_id INT NOT NULL,avatar_url TEXT,comment TEXT,user_id INT,username TEXT,timestamp INT,location TEXT,verified INT,entities BLOB,is_last INT,last_refresh INT);");
        sqlitedatabase.execSQL("CREATE VIEW  user_groups_view AS SELECT user_groups._id AS _id,user_groups.type AS type,user_groups.tag AS tag,user_groups.user_id AS user_id,user_groups.is_last AS is_last,user_groups.g_flags AS g_flags,user_groups.order_id AS order_id,user.username AS username,user.user_id AS user_id,user.avatar_url AS avatar_url,user.blocked AS blocked,user.blocking AS blocking,user.description AS description,user.location AS location,user.explicit AS explicit,user.follower_count AS follower_count,user.following_count AS following_count,user.following_flag AS following_flag,user.like_count AS like_count,user.post_count AS post_count,user.follow_status AS follow_status,user.verified AS verified,user.accepts_oon_conversations AS accepts_oon_conversations,user.profile_background AS profile_background, user.loop_count AS loop_count, section.last_section_refresh AS last_section_refresh,section.section_index AS section_index,section.section_title AS section_title,section.section_type AS section_type FROM user_groups LEFT JOIN users AS user ON user_groups.user_id=user.user_id LEFT JOIN user_sections as section ON section.user_id=user.user_id ;");
        sqlitedatabase.execSQL("CREATE TABLE  likes (_id INTEGER PRIMARY KEY,like_id INT UNIQUE NOT NULL,post_id INT NOT NULL,avatar_url TEXT,user_id INT,username TEXT,timestamp INT,location TEXT,verified INT,last_refresh INT);");
        sqlitedatabase.execSQL("CREATE TABLE  posts (_id INTEGER PRIMARY KEY,post_id INT NOT NULL,my_repost_id INT,tags BLOB,thumbnail_url TEXT,share_url TEXT,video_low_uRL TEXT,video_url TEXT,description TEXT,foursquare_venue_id TEXT,metadata_flags INT,post_flags INT,avatar_url TEXT,user_id INT,username TEXT,timestamp INT,location TEXT,venue_data BLOB,entities BLOB,likes_count INT,reviners_count INT,comments_count INT,user_background_color INT,last_refresh INT,loops INT,velocity INT,on_fire INT);");
        sqlitedatabase.execSQL("CREATE TABLE  post_groups (_id INTEGER PRIMARY KEY,post_type INT,tag TEXT,post_id INT,is_last INT,repost_data BLOB,reposter_id INT,sort_id INT,g_flags INT);");
        sqlitedatabase.execSQL("CREATE VIEW  post_groups_view AS SELECT post_groups._id AS _id,post_groups.post_type AS post_type,post_groups.tag AS tag,post_groups.post_id AS post_id,post_groups.is_last AS is_last,post_groups.g_flags AS g_flags,post_groups.sort_id AS sort_id,post_groups.repost_data AS repost_data,post_groups.reposter_id AS reposter_id,posts.username AS username,posts.avatar_url AS avatar_url,posts.thumbnail_url AS thumbnail_url,posts.metadata_flags AS metadata_flags,posts.user_id AS user_id,posts.my_repost_id AS my_repost_id,posts.timestamp AS timestamp,posts.location AS location,posts.tags AS tags,posts.share_url AS share_url,posts.video_low_uRL AS video_low_uRL,posts.video_url AS video_url,posts.video_low_uRL AS video_low_uRL,posts.description AS description,posts.foursquare_venue_id AS foursquare_venue_id,posts.post_flags AS post_flags,posts.venue_data AS venue_data,posts.entities AS entities,posts.likes_count AS likes_count,posts.reviners_count AS reviners_count,posts.comments_count AS comments_count,posts.user_background_color AS user_background_color,posts.loops AS loops,posts.velocity AS velocity,posts.on_fire AS on_fire,posts.last_refresh AS last_refresh FROM post_groups LEFT JOIN posts AS posts ON post_groups.post_id=posts.post_id;");
        sqlitedatabase.execSQL("CREATE VIEW  post_comments_likes_view AS  SELECT post_groups_view._id AS _id,post_groups_view.post_id AS post_id,post_groups_view.my_repost_id AS my_repost_id,post_groups_view.tags AS tags,post_groups_view.thumbnail_url AS thumbnail_url,post_groups_view.share_url AS share_url,post_groups_view.video_low_uRL AS video_low_uRL,post_groups_view.video_url AS video_url,post_groups_view.description AS description,post_groups_view.foursquare_venue_id AS foursquare_venue_id,post_groups_view.metadata_flags AS metadata_flags,post_groups_view.post_flags AS post_flags,post_groups_view.post_type AS post_type,post_groups_view.tag AS tag,post_groups_view.sort_id AS sort_id,post_groups_view.is_last AS is_last,post_groups_view.avatar_url AS avatar_url,post_groups_view.user_id AS user_id,post_groups_view.timestamp AS timestamp,post_groups_view.location AS location,post_groups_view.username AS username,post_groups_view.venue_data AS venue_data,post_groups_view.entities AS entities,post_groups_view.repost_data AS repost_data,post_groups_view.reposter_id AS reposter_id,post_groups_view.likes_count AS likes_count,post_groups_view.reviners_count AS reviners_count,post_groups_view.comments_count AS comments_count,post_groups_view.user_background_color AS user_background_color,post_groups_view.loops AS loops,post_groups_view.velocity AS velocity,post_groups_view.on_fire AS on_fire,post_groups_view.last_refresh AS last_refresh,likes.like_id AS like_id,likes.avatar_url AS like_user_avatar_url,likes.user_id AS like_user_user_id,likes.timestamp AS like_user_timestamp,likes.location AS like_user_location,likes.username AS like_user_username,likes.verified AS like_user_verified,null  AS comment_id,null  AS comment,null  AS comment_user_avatar_url,null  AS comment_user_user_id,null  AS comment_user_timestamp,null  AS comment_user_location,null  AS comment_user_username,null  AS comment_user_verified,null  AS comment_is_last,null  AS comment_entities FROM post_groups_view LEFT JOIN likes ON post_groups_view.post_id = likes.post_id UNION SELECT post_groups_view._id AS _id,post_groups_view.post_id AS post_id,post_groups_view.my_repost_id AS my_repost_id,post_groups_view.tags AS tags,post_groups_view.thumbnail_url AS thumbnail_url,post_groups_view.share_url AS share_url,post_groups_view.video_low_uRL AS video_low_uRL,post_groups_view.video_url AS video_url,post_groups_view.description AS description,post_groups_view.foursquare_venue_id AS foursquare_venue_id,post_groups_view.metadata_flags AS metadata_flags,post_groups_view.post_flags AS post_flags,post_groups_view.post_type AS post_type,post_groups_view.tag AS tag,post_groups_view.sort_id AS sort_id,post_groups_view.is_last AS is_last,post_groups_view.avatar_url AS avatar_url,post_groups_view.user_id AS user_id,post_groups_view.timestamp AS timestamp,post_groups_view.location AS location,post_groups_view.username AS username,post_groups_view.venue_data AS venue_data,post_groups_view.entities AS entities,post_groups_view.repost_data AS repost_data,post_groups_view.reposter_id AS reposter_id,post_groups_view.likes_count AS likes_count,post_groups_view.reviners_count AS reviners_count,post_groups_view.comments_count AS comments_count,post_groups_view.user_background_color AS user_background_color,post_groups_view.loops AS loops,post_groups_view.velocity AS velocity,post_groups_view.on_fire AS on_fire,post_groups_view.last_refresh AS last_refresh,null  AS like_id,null  AS like_user_avatar_url,null  AS like_user_user_id,null  AS like_user_timestamp,null  AS like_user_location,null  AS like_user_username,null  AS like_user_verified,comments.comment_id AS comment_id,comments.comment AS comment,comments.avatar_url AS comment_user_avatar_url,comments.user_id AS comment_user_user_id,comments.timestamp AS comment_user_timestamp,comments.location AS comment_user_location,comments.username AS comment_user_username,comments.verified AS comment_user_verified,comments.is_last AS comment_is_last,comments.entities AS comment_entities FROM post_groups_view LEFT JOIN comments ON post_groups_view.post_id = comments.post_id ");
        sqlitedatabase.execSQL("CREATE TABLE  page_cursors (_id INTEGER PRIMARY KEY,type INT,tag TEXT,kind INT,next_page INT,previous_page INT,anchor TEXT,reversed INT);");
        sqlitedatabase.execSQL("CREATE TABLE  tag_search_results (_id INTEGER PRIMARY KEY,tag_id INT UNIQUE NOT NULL,tag_name TEXT NOT NULL,last_used_timestamp TEXT,is_last INT);");
        sqlitedatabase.execSQL("CREATE TABLE  channels (_id INTEGER PRIMARY KEY,channel_id INT UNIQUE NOT NULL,channel TEXT NOT NULL,timestamp INT,background_color TEXT,font_color TEXT,last_used_timestamp INT,is_last INT,icon_full_url TEXT,retina_icon_full_url TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE  notifications (_id INTEGER PRIMARY KEY,notification_id INT UNIQUE NOT NULL,notification_type INT,message TEXT,cleared INT, conversation_row_id INT, avatar_url TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE  tag_recently_used (_id INTEGER PRIMARY KEY,tag_id INT UNIQUE NOT NULL,tag_name TEXT NOT NULL,last_used_timestamp TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE  editions (_id INTEGER PRIMARY KEY,edition_code TEXT,edition_name TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE  messages (_id INTEGER PRIMARY KEY,conversation_row_id INT NOT NULL,message_id INT NOT NULL,user_row_id INT NOT NULL,timestamp INT,message TEXT,video_url TEXT,thumbnail_url TEXT, is_last INT,vanished INT,max_loops INT,vanished_date INT,ephemeral INT,local_start_time INT,deleted INT,post_id INT,upload_path TEXT,error_code INT,error_reason TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE  conversations (_id INTEGER PRIMARY KEY,conversation_id INT NOT NULL,network_type INT NOT NULL, unread_message_count INT, is_hidden INT DEFAULT 0, last_message INT, last_message_timestamp INT, is_last INT);");
        sqlitedatabase.execSQL("CREATE VIEW message_users_view AS SELECT m._id AS _id,m.conversation_row_id AS conversation_row_id,m.message_id AS message_id,m.user_row_id AS user_row_id,m.message AS message,m.timestamp AS timestamp,m.video_url AS video_url,m.thumbnail_url AS thumbnail_url,m.is_last AS is_last,m.vanished AS vanished,m.max_loops AS max_loops,m.vanished_date AS vanished_date,m.ephemeral AS ephemeral,m.local_start_time AS local_start_time,m.deleted AS deleted,m.post_id AS post_id,m.upload_path AS upload_path,m.error_code AS error_code,m.error_reason AS error_reason,c.conversation_id AS conversation_id,c.network_type AS network_type,c.is_hidden AS is_hidden,c.unread_message_count AS unread_message_count,user.username AS sender_user_name,user.avatar_url AS sender_avatar,user.profile_background AS sender_profile_background,post.user_id AS author_user_id,post.username AS author_user_name,post.avatar_url AS author_avatar,post.entities AS post_entities,post.description AS post_description,post.share_url AS post_share_url FROM messages AS  m LEFT JOIN users AS user ON m.user_row_id=user._id LEFT JOIN conversations AS c ON m.conversation_row_id=c._id LEFT JOIN (SELECT p.post_id, p.user_id, p.username, p.avatar_url, p.entities, p.description, p.share_url FROM messages AS m LEFT JOIN post_comments_likes_view AS p ON m.post_id=p.post_id GROUP BY p.post_id) AS post ON m.post_id=post.post_id;");
        sqlitedatabase.execSQL("CREATE TABLE conversation_recipients (_id INTEGER PRIMARY KEY,conversation_row_id INT NOT NULL,user_row_id INT NOT NULL, UNIQUE (conversation_row_id,user_row_id) ON CONFLICT IGNORE);");
        sqlitedatabase.execSQL("CREATE VIEW inbox_view AS SELECT cr._id AS _id,cr.conversation_row_id AS conversation_row_id,( SELECT COUNT(*) FROM conversation_recipients where conversation_row_id = cr.conversation_row_id group by conversation_row_id) AS recipients_count,m.timestamp AS timestamp,m.error_reason AS error_reason,c.network_type AS network_type,c.unread_message_count AS unread_message_count,c.is_hidden AS is_hidden,c.last_message AS last_message,c.is_last AS is_last,u.username AS username,u._id AS user_row_id,u.user_id AS user_id,u.following_flag AS following_flag,u.avatar_url AS avatar_url,u.profile_background AS profile_background FROM conversation_recipients AS cr JOIN users AS u ON cr.user_row_id= u._id JOIN messages AS m ON c.last_message=m._id JOIN conversations AS c ON c._id =cr.conversation_row_id GROUP BY cr.conversation_row_id ORDER BY timestamp DESC;");
        sqlitedatabase.execSQL("CREATE VIEW  conversation_recipients_users_view AS SELECT conversation_recipients._id AS _id,conversation_recipients.conversation_row_id AS conversation_row_id,conversation_recipients.user_row_id AS user_row_id,user.username AS username,user.user_id AS user_id,user.phone_number AS phone_number,user.email_address AS email_address,user.profile_background AS profile_background FROM conversation_recipients LEFT JOIN users AS user ON conversation_recipients.user_row_id=user._id;");
    }

    public int deleteComment(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i = getWritableDatabase().delete("comments", "comment_id=?", new String[] {
            s
        });
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        mContentResolver.notifyChange(Vine.Comments.CONTENT_URI, null);
        notifyPostCommentsViewUris();
        if (!LOGGABLE) goto _L2; else goto _L1
_L1:
        if (i <= 0) goto _L4; else goto _L3
_L3:
        Log.d("VineDH", (new StringBuilder()).append("Deleting comment: ").append(s).toString());
_L2:
        this;
        JVM INSTR monitorexit ;
        return i;
_L4:
        Log.e("VineDH", (new StringBuilder()).append("Couldn't delete comment: ").append(s).toString());
        if (true) goto _L2; else goto _L5
_L5:
        s;
        throw s;
    }

    public void deleteConversation(long l, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        int i = 0;
        sqlitedatabase.beginTransaction();
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        i = sqlitedatabase.delete("conversations", "conversation_id=?", new String[] {
            String.valueOf(l)
        });
        int j;
        j = i;
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        j = i + sqlitedatabase.delete("conversations", "_id=?", new String[] {
            String.valueOf(l1)
        }) + sqlitedatabase.delete("messages", "conversation_row_id=?", new String[] {
            String.valueOf(l1)
        }) + sqlitedatabase.delete("conversation_recipients", "conversation_row_id=?", new String[] {
            String.valueOf(l1)
        });
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Deleted conversation ").append(l).toString());
        }
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        notifyVMUris();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        safeFinishTransaction(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void deleteMessage(long l)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        Object obj;
        int i;
        sqlitedatabase = getWritableDatabase();
        obj = new ContentValues();
        ((ContentValues) (obj)).put("deleted", Integer.valueOf(1));
        String s = String.valueOf(l);
        i = sqlitedatabase.update("messages", ((ContentValues) (obj)), "message_id=?", new String[] {
            s
        });
        obj = sqlitedatabase.query("messages", new String[] {
            "conversation_row_id", "is_last"
        }, "message_id=?", new String[] {
            s
        }, null, null, null);
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!((Cursor) (obj)).moveToFirst()) goto _L4; else goto _L3
_L3:
        l = ((Cursor) (obj)).getLong(0);
        boolean flag;
        if (((Cursor) (obj)).getInt(1) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (getNumberVisibleMessagesInConversation(l, sqlitedatabase) != 0) goto _L6; else goto _L5
_L5:
        setConversationHidden(l, true);
_L4:
        ((Cursor) (obj)).close();
_L2:
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        notifyVMUris();
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        if (!flag) goto _L4; else goto _L7
_L7:
        markLastMessage(l);
          goto _L4
        Exception exception;
        exception;
        ((Cursor) (obj)).close();
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int deletePost(long l)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        int j;
        sqlitedatabase.beginTransaction();
        j = sqlitedatabase.delete("posts", "post_id=?", new String[] {
            String.valueOf(l)
        });
        int i = 0;
        if (j <= 0) goto _L2; else goto _L1
_L1:
        i = sqlitedatabase.delete("post_groups", "post_id=?", new String[] {
            String.valueOf(l)
        });
          goto _L2
_L7:
        notifyPostCommentsViewUris();
_L8:
        if (!LOGGABLE) goto _L4; else goto _L3
_L3:
        if (i <= 0) goto _L6; else goto _L5
_L5:
        Log.d("VineDH", (new StringBuilder()).append("Removing the post: ").append(l).toString());
_L4:
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        this;
        JVM INSTR monitorexit ;
        return j;
_L6:
        Log.e("VineDH", (new StringBuilder()).append("Couldn't delete post: ").append(l).toString());
          goto _L4
        Exception exception1;
        exception1;
        safeFinishTransaction(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        if (j <= 0 && i <= 0) goto _L8; else goto _L7
    }

    public int deletePushNotifications(int i)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        if (i == 2)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        obj1 = (new StringBuilder()).append("notification_type");
        if (i != 0)
        {
            obj = "=?";
        } else
        {
            obj = "<>?";
        }
        obj1 = ((StringBuilder) (obj1)).append(((String) (obj))).toString();
        obj = getWritableDatabase();
        ((SQLiteDatabase) (obj)).beginTransaction();
        i = ((SQLiteDatabase) (obj)).delete("notifications", ((String) (obj1)), new String[] {
            String.valueOf(18)
        });
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        this;
        JVM INSTR monitorexit ;
        return 0 + i;
        Exception exception1;
        exception1;
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public long determineBestConversationRowIdForRecipient(VineRecipient vinerecipient)
    {
        return determineBestConversationRowIdForUserRowId(getUserRowIdForRecipient(vinerecipient));
    }

    public long determineBestConversationRowIdForUserRemoteId(long l)
    {
        return determineBestConversationRowIdForUserRowId(getUserRowIdForUserRemoteId(l));
    }

    public long determineBestConversationRowIdForUserRowId(long l)
    {
        Cursor cursor;
        SQLiteDatabase sqlitedatabase;
        long l1;
        long l2;
        sqlitedatabase = getReadableDatabase();
        cursor = sqlitedatabase.query("conversation_recipients", new String[] {
            "conversation_row_id"
        }, "user_row_id =?", new String[] {
            String.valueOf(l)
        }, null, null, null);
        l1 = -1L;
        l2 = l1;
        if (cursor == null) goto _L2; else goto _L1
_L1:
        l = l1;
        if (!cursor.moveToNext()) goto _L4; else goto _L3
_L3:
        Object obj;
        l = cursor.getLong(0);
        obj = sqlitedatabase.query("conversation_recipients", new String[] {
            "_id"
        }, "conversation_row_id =? ", new String[] {
            String.valueOf(l)
        }, null, null, null);
        if (obj == null) goto _L1; else goto _L5
_L5:
        if (((Cursor) (obj)).getCount() != 1) goto _L7; else goto _L6
_L6:
        l1 = l;
        ((Cursor) (obj)).close();
        l = l1;
        if (obj == null) goto _L4; else goto _L8
_L8:
        ((Cursor) (obj)).close();
        l = l1;
_L4:
        l2 = l;
        if (cursor != null)
        {
            cursor.close();
            l2 = l;
        }
_L2:
        return l2;
_L7:
        if (obj == null) goto _L1; else goto _L9
_L9:
        ((Cursor) (obj)).close();
          goto _L1
        obj;
        if (cursor != null)
        {
            cursor.close();
        }
        throw obj;
        Exception exception;
        exception;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        ((Cursor) (obj)).close();
        throw exception;
    }

    public long determineOrCreateBestConversationRowIdForRecipients(List list, int i)
    {
        long l = -1L;
        if (list.size() == 1)
        {
            l = determineBestConversationRowIdForRecipient((VineRecipient)list.get(0));
        }
        long l1 = l;
        if (l <= 0L)
        {
            l1 = createPreMergeConversationIdAndRecipientsIfNecessary(list, i);
        }
        return l1;
    }

    public void expireTimeline(int i)
    {
        this;
        JVM INSTR monitorenter ;
        removePostsFromGroup(i);
        notifyPostCommentsViewUris();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int getCommentsCount(long l)
    {
        int i = 0;
        this;
        JVM INSTR monitorenter ;
        Cursor cursor = getWritableDatabase().query("comments", VineDatabaseSQL.CommentsQuery.PROJECTION, "post_id=?", new String[] {
            String.valueOf(l)
        }, null, null, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        i = cursor.getCount();
        cursor.close();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception1;
        exception1;
        cursor.close();
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getConversationNetworkType(long l)
    {
        Cursor cursor;
label0:
        {
            int i = 1;
            cursor = getReadableDatabase().query("conversations", new String[] {
                "network_type"
            }, "_id =? ", new String[] {
                String.valueOf(l)
            }, null, null, null, "1");
            if (cursor != null)
            {
                if (!cursor.moveToFirst())
                {
                    break label0;
                }
                i = cursor.getInt(0);
                cursor.close();
            }
            return i;
        }
        cursor.close();
        return 1;
    }

    public ArrayList getConversationRecipientsFromConversationRowId(long l)
    {
        Object obj;
        Cursor cursor;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = getReadableDatabase();
        cursor = sqlitedatabase.query("conversation_recipients", new String[] {
            "user_row_id"
        }, "conversation_row_id =? ", new String[] {
            String.valueOf(l)
        }, null, null, null);
        obj = null;
        if (cursor == null) goto _L2; else goto _L1
_L1:
        obj = new ArrayList();
_L6:
        if (!cursor.moveToNext()) goto _L4; else goto _L3
_L3:
        Cursor cursor1;
        l = cursor.getLong(0);
        cursor1 = sqlitedatabase.query("users", new String[] {
            "user_id"
        }, "_id=?", new String[] {
            String.valueOf(l)
        }, null, null, null);
        if (cursor1 == null) goto _L6; else goto _L5
_L5:
        if (cursor1.moveToFirst())
        {
            ((ArrayList) (obj)).add(VineRecipient.fromUser(null, cursor1.getLong(0), 0, l));
        }
        cursor1.close();
          goto _L6
        obj;
_L8:
        cursor.close();
        throw obj;
        obj;
        cursor1.close();
        throw obj;
_L4:
        cursor.close();
_L2:
        return ((ArrayList) (obj));
        obj;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public long getConversationRemoteId(long l)
    {
        this;
        JVM INSTR monitorenter ;
        Cursor cursor = getReadableDatabase().query("conversations", new String[] {
            "conversation_id"
        }, "_id =?", new String[] {
            String.valueOf(l)
        }, null, null, null, "1");
        if (cursor == null) goto _L2; else goto _L1
_L1:
        l = -1L;
        if (cursor.moveToFirst())
        {
            l = cursor.getLong(0);
        }
        cursor.close();
_L4:
        this;
        JVM INSTR monitorexit ;
        return l;
_L2:
        l = -1L;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public long getConversationRowId(long l)
    {
        this;
        JVM INSTR monitorenter ;
        Cursor cursor = getReadableDatabase().query("conversations", new String[] {
            "_id"
        }, "conversation_id =?", new String[] {
            String.valueOf(l)
        }, null, null, null, "1");
        if (cursor == null) goto _L2; else goto _L1
_L1:
        l = -1L;
        if (cursor.moveToFirst())
        {
            l = cursor.getLong(0);
        }
        cursor.close();
_L4:
        this;
        JVM INSTR monitorexit ;
        return l;
_L2:
        l = -1L;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public String getDisplayForUser(long l)
    {
        String s;
        Cursor cursor;
        cursor = getReadableDatabase().query("users", new String[] {
            "username"
        }, "_id =? ", new String[] {
            String.valueOf(l)
        }, null, null, null);
        s = null;
        Object obj = null;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        s = obj;
        if (cursor.moveToFirst())
        {
            s = cursor.getString(0);
        }
        cursor.close();
        return s;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    public long getLastMessageIdInConversation(long l)
    {
        this;
        JVM INSTR monitorenter ;
        Cursor cursor = getWritableDatabase().query("messages", new String[] {
            "message_id"
        }, "conversation_row_id =? ", new String[] {
            String.valueOf(l)
        }, null, null, "message_id DESC", "1");
        long l1;
        l = -1L;
        l1 = l;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        if (cursor.moveToFirst())
        {
            l = cursor.getLong(0);
        }
        cursor.close();
        l1 = l;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public VinePrivateMessage getMessageFromMessageRow(long l)
    {
        VinePrivateMessage vineprivatemessage;
        Object obj;
        Cursor cursor;
        Object obj1;
        vineprivatemessage = null;
        obj1 = null;
        obj = getReadableDatabase();
        cursor = null;
        obj = ((SQLiteDatabase) (obj)).query("message_users_view", VineDatabaseSQL.ConversationMessageUsersQuery.PROJECTION, "_id=?", new String[] {
            String.valueOf(l)
        }, null, null, null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        vineprivatemessage = obj1;
        if (((Cursor) (obj)).moveToFirst())
        {
            vineprivatemessage = new VinePrivateMessage(((Cursor) (obj)));
        }
        cursor = ((Cursor) (obj));
        ((Cursor) (obj)).close();
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return vineprivatemessage;
        Exception exception;
        exception;
        cursor = ((Cursor) (obj));
        ((Cursor) (obj)).close();
        cursor = ((Cursor) (obj));
        throw exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
    }

    public Cursor getMessagesForConversationRowId(long l)
    {
        return getReadableDatabase().query("message_users_view", VineDatabaseSQL.ConversationMessageUsersQuery.PROJECTION, "conversation_row_id=? AND error_code <> 0", new String[] {
            String.valueOf(l)
        }, null, null, "message_id ASC");
    }

    public ArrayList getMessagesThatWereViewed()
    {
        Cursor cursor = getWritableDatabase().query("message_users_view", new String[] {
            "conversation_id", "message_id", "local_start_time"
        }, "local_start_time!=0", null, null, null, "message_id DESC", "1");
        ArrayList arraylist = new ArrayList();
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        try
        {
            for (; cursor.moveToNext(); arraylist.add(new VineViewedMessage(cursor.getLong(0), cursor.getLong(1), cursor.getLong(2)))) { }
            break MISSING_BLOCK_LABEL_117;
        }
        catch (Exception exception1) { }
        finally
        {
            cursor.close();
            throw exception;
        }
        SLog.e("Error while getting viewed messages.");
        cursor.close();
        return arraylist;
        cursor.close();
        return arraylist;
    }

    public long getNewMessageId()
    {
        Cursor cursor = getReadableDatabase().query("messages", new String[] {
            "message_id"
        }, null, null, null, null, "message_id DESC", "1");
        long l = 1L;
        long l1 = l;
        if (cursor != null)
        {
            if (cursor.moveToFirst())
            {
                l = cursor.getLong(0) + 1L;
            }
            cursor.close();
            l1 = l;
        }
        return l1;
    }

    public int getNextPageCursor(int i, int j, String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        String s1;
        Exception exception;
        String s2;
        if (flag)
        {
            s1 = "previous_page";
        } else
        {
            s1 = "next_page";
        }
        s2 = s;
        if (s == null)
        {
            s2 = "";
        }
          goto _L1
_L3:
        s = String.valueOf(s2);
        s = sqlitedatabase.query("page_cursors", new String[] {
            s1
        }, "kind=? AND type=? AND tag=?", new String[] {
            String.valueOf(i), String.valueOf(j), s
        }, null, null, null);
        i = -1;
        j = i;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (s.moveToFirst())
        {
            i = s.getInt(0);
        }
        s.close();
        j = i;
        this;
        JVM INSTR monitorexit ;
        return j;
        exception;
        s.close();
        throw exception;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
_L1:
        if (true) goto _L3; else goto _L2
_L2:
    }

    public ArrayList getNotifications(int i)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        SQLiteDatabase sqlitedatabase;
        if (i == 18)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        obj1 = (new StringBuilder()).append("notification_type");
        if (i != 0)
        {
            obj = "=?";
        } else
        {
            obj = "<>?";
        }
        obj1 = ((StringBuilder) (obj1)).append(((String) (obj))).toString();
        sqlitedatabase = getReadableDatabase();
        obj = new ArrayList();
        obj1 = sqlitedatabase.query("notifications", VineDatabaseSQL.NotificationsQuery.PROJECTION, ((String) (obj1)), new String[] {
            String.valueOf(18)
        }, null, null, "notification_id DESC", "10");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        for (; ((Cursor) (obj1)).moveToNext(); ((ArrayList) (obj)).add(new VineSingleNotification(((Cursor) (obj1))))) { }
        break MISSING_BLOCK_LABEL_138;
        obj;
        throw obj;
        ((Cursor) (obj1)).close();
        this;
        JVM INSTR monitorexit ;
        return ((ArrayList) (obj));
    }

    public int getNumberVisibleMessagesInConversation(long l, SQLiteDatabase sqlitedatabase)
    {
        int i;
        i = 0;
        sqlitedatabase = sqlitedatabase.query("messages", new String[] {
            "_id"
        }, "conversation_row_id =? AND deleted != 1", new String[] {
            String.valueOf(l)
        }, null, null, null);
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        i = sqlitedatabase.getCount();
        sqlitedatabase.close();
        return i;
        Exception exception;
        exception;
        sqlitedatabase.close();
        throw exception;
    }

    public Cursor getOldestSortId(int i)
    {
        this;
        JVM INSTR monitorenter ;
        Cursor cursor = getReadableDatabase().query("post_groups", new String[] {
            "sort_id"
        }, "post_type=?", new String[] {
            String.valueOf(i)
        }, null, null, "CAST (sort_id AS INTEGER) DESC", "1");
        this;
        JVM INSTR monitorexit ;
        return cursor;
        Exception exception;
        exception;
        throw exception;
    }

    public long getPageAnchor(int i, int j, String s)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        s = String.valueOf(s);
        s = sqlitedatabase.query("page_cursors", new String[] {
            "anchor"
        }, "kind=? AND type=? AND tag=?", new String[] {
            String.valueOf(i), String.valueOf(j), s
        }, null, null, null);
        long l;
        long l1;
        l1 = -1L;
        l = l1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        l = l1;
        if (s.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        l = l1;
        if (s.moveToFirst())
        {
            l = s.getLong(0);
        }
        s.close();
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        s.close();
        throw exception;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public VinePost getPost(long l)
    {
        Cursor cursor;
        cursor = getReadableDatabase().query("post_comments_likes_view", VineDatabaseSQL.PostCommentsLikesQuery.PROJECTION, "post_id =? ", new String[] {
            String.valueOf(l)
        }, null, null, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        VinePost vinepost;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_59;
        }
        vinepost = VinePost.from(cursor);
        cursor.close();
        return vinepost;
        cursor.close();
        return null;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    public int getPreviousPageCursor(int i, int j, String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        String s1;
        Exception exception;
        String s2;
        if (flag)
        {
            s1 = "next_page";
        } else
        {
            s1 = "previous_page";
        }
        s2 = s;
        if (s == null)
        {
            s2 = "";
        }
          goto _L1
_L3:
        s = String.valueOf(s2);
        s = sqlitedatabase.query("page_cursors", new String[] {
            s1
        }, "kind=? AND type=? AND tag=?", new String[] {
            String.valueOf(i), String.valueOf(j), s
        }, null, null, null);
        i = -1;
        j = i;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        if (s.moveToFirst())
        {
            i = s.getInt(s.getColumnIndex(s1));
        }
        s.close();
        j = i;
        this;
        JVM INSTR monitorexit ;
        return j;
        exception;
        s.close();
        throw exception;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
_L1:
        if (true) goto _L3; else goto _L2
_L2:
    }

    public long getUserRemoteIdForUserRowId(long l)
    {
        Cursor cursor;
        long l1;
        cursor = getReadableDatabase().query("users", new String[] {
            "user_id"
        }, "_id =? ", new String[] {
            String.valueOf(l)
        }, null, null, null);
        l = -1L;
        l1 = l;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (cursor.moveToFirst())
        {
            l = cursor.getLong(0);
        }
        cursor.close();
        l1 = l;
        return l1;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    public long getUserRowIdForRecipient(VineRecipient vinerecipient)
    {
        if (vinerecipient.recipientId > 0L)
        {
            return vinerecipient.recipientId;
        }
        if (vinerecipient.isFromUser() && vinerecipient.userId > 0L)
        {
            return getUserRowIdForUserRemoteId(vinerecipient.userId);
        }
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        String s = null;
        long l;
        if (vinerecipient.isFromEmail())
        {
            s = "email_address";
        } else
        if (vinerecipient.isFromPhone())
        {
            s = "phone_number";
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        s = (new StringBuilder()).append(s).append("=? AND ").append("user_id").append("= -1").toString();
        vinerecipient = vinerecipient.value;
        vinerecipient = sqlitedatabase.query("users", new String[] {
            "_id"
        }, s, new String[] {
            vinerecipient
        }, null, null, null);
        if (vinerecipient == null)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        if (!vinerecipient.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_173;
        }
        l = vinerecipient.getLong(0);
        vinerecipient.close();
        return l;
        vinerecipient.close();
        return -1L;
        Exception exception;
        exception;
        vinerecipient.close();
        throw exception;
    }

    public long getUserRowIdForUserRemoteId(long l)
    {
        Cursor cursor;
        long l1;
        cursor = getReadableDatabase().query("users", new String[] {
            "_id"
        }, "user_id =? ", new String[] {
            String.valueOf(l)
        }, null, null, null);
        l = -1L;
        l1 = l;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        if (cursor.moveToFirst())
        {
            l = cursor.getLong(0);
        }
        cursor.close();
        l1 = l;
        return l1;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    public void markChannelLastUsedTimestamp(long l)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("last_used_timestamp", Long.valueOf(System.currentTimeMillis()));
        sqlitedatabase.update("channels", contentvalues, "channel_id=?", new String[] {
            String.valueOf(l)
        });
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void markLastChannel()
    {
        this;
        JVM INSTR monitorenter ;
        long l = getLastChannelRowId();
        if (l != 0L) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        ContentValues contentvalues;
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Tagging the oldest channel with row id: ").append(l).toString());
        }
        obj = getWritableDatabase();
        contentvalues = new ContentValues();
        contentvalues.put("is_last", Integer.valueOf(0));
        ((SQLiteDatabase) (obj)).beginTransaction();
        ((SQLiteDatabase) (obj)).update("channels", contentvalues, "is_last=1", null);
        contentvalues.put("is_last", Integer.valueOf(1));
        ((SQLiteDatabase) (obj)).update("channels", contentvalues, "_id=?", new String[] {
            String.valueOf(l)
        });
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        mContentResolver.notifyChange(Vine.Channels.CONTENT_URI, null);
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
        Exception exception;
        exception;
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        throw exception;
    }

    public void markLastComment(long l)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = getLastCommentRowId(l);
        if (l1 != 0L) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        ContentValues contentvalues;
        obj = getWritableDatabase();
        contentvalues = new ContentValues();
        contentvalues.put("is_last", Integer.valueOf(0));
        ((SQLiteDatabase) (obj)).beginTransaction();
        ((SQLiteDatabase) (obj)).update("comments", contentvalues, "is_last=1 AND post_id=?", new String[] {
            String.valueOf(l)
        });
        contentvalues.put("is_last", Integer.valueOf(1));
        ((SQLiteDatabase) (obj)).update("comments", contentvalues, "_id=?", new String[] {
            String.valueOf(l1)
        });
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
        Exception exception;
        exception;
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        throw exception;
    }

    public void markLastConversation(int i)
    {
        this;
        JVM INSTR monitorenter ;
        long l = getLastConversationId(i);
        if (l != 0L) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        ContentValues contentvalues;
        obj = getWritableDatabase();
        contentvalues = new ContentValues();
        contentvalues.put("is_last", Integer.valueOf(0));
        ((SQLiteDatabase) (obj)).beginTransaction();
        ((SQLiteDatabase) (obj)).update("conversations", contentvalues, "is_last=1 AND network_type=?", new String[] {
            String.valueOf(i)
        });
        contentvalues.put("is_last", Integer.valueOf(1));
        ((SQLiteDatabase) (obj)).update("conversations", contentvalues, "_id=?", new String[] {
            String.valueOf(l)
        });
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
        Exception exception;
        exception;
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        throw exception;
    }

    public void markLastMessage(long l)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = getLastMessageRowId(l);
        if (l1 != 0L) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        ContentValues contentvalues;
        obj = getWritableDatabase();
        contentvalues = new ContentValues();
        contentvalues.put("is_last", Integer.valueOf(0));
        ((SQLiteDatabase) (obj)).beginTransaction();
        ((SQLiteDatabase) (obj)).update("messages", contentvalues, "is_last=1 AND conversation_row_id=?", new String[] {
            String.valueOf(l)
        });
        contentvalues.put("is_last", Integer.valueOf(1));
        ((SQLiteDatabase) (obj)).update("messages", contentvalues, "_id=?", new String[] {
            String.valueOf(l1)
        });
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
        Exception exception;
        exception;
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        throw exception;
    }

    public void markLastPost(int i, String s)
    {
        this;
        JVM INSTR monitorenter ;
        long l = getLastPostRowId(i, s);
        if (l != 0L) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = getWritableDatabase();
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Tagging the oldest post of type: ").append(i).append(" and tag: ").append(s).append(" row id: ").append(l).toString());
        }
        s = new ContentValues();
        s.put("is_last", Integer.valueOf(0));
        sqlitedatabase.beginTransaction();
        sqlitedatabase.update("post_groups", s, "is_last=1", null);
        s.put("is_last", Integer.valueOf(1));
        sqlitedatabase.update("post_groups", s, "_id=?", new String[] {
            String.valueOf(l)
        });
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        notifyPostCommentsViewUris();
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
        s;
        safeFinishTransaction(sqlitedatabase);
        throw s;
    }

    public void markLastTag()
    {
        this;
        JVM INSTR monitorenter ;
        long l = getLastTagRowId();
        if (l != 0L) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        ContentValues contentvalues;
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Tagging the oldest tag with row id: ").append(l).toString());
        }
        obj = getWritableDatabase();
        contentvalues = new ContentValues();
        contentvalues.put("is_last", Integer.valueOf(0));
        ((SQLiteDatabase) (obj)).beginTransaction();
        ((SQLiteDatabase) (obj)).update("tag_search_results", contentvalues, "is_last=1", null);
        contentvalues.put("is_last", Integer.valueOf(1));
        ((SQLiteDatabase) (obj)).update("tag_search_results", contentvalues, "_id=?", new String[] {
            String.valueOf(l)
        });
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        mContentResolver.notifyChange(Vine.TagSearchResults.CONTENT_URI, null);
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
        Exception exception;
        exception;
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        throw exception;
    }

    public void markLastUser(int i, String s)
    {
        this;
        JVM INSTR monitorenter ;
        markLastUser(i, s, "order_id ASC");
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void markLastUser(int i, String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        long l = getLastUserRowId(i, s, s1);
        if (l != 0L) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Tagging the oldest user of type: ").append(i).append(" row id: ").append(l).toString());
        }
        s = getWritableDatabase();
        s1 = new ContentValues();
        s1.put("is_last", Integer.valueOf(0));
        s.beginTransaction();
        s.update("user_groups", s1, "is_last=1", null);
        s1.put("is_last", Integer.valueOf(1));
        s.update("user_groups", s1, "_id=?", new String[] {
            String.valueOf(l)
        });
        s.setTransactionSuccessful();
        safeFinishTransaction(s);
        mContentResolver.notifyChange(Vine.UserGroupsView.CONTENT_URI, null);
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
        s1;
        safeFinishTransaction(s);
        throw s1;
    }

    public int mergeChannels(Collection collection, int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        int k;
        boolean flag;
        k = 0;
        flag = false;
        if (collection.isEmpty()) goto _L2; else goto _L1
_L1:
        sqlitedatabase.beginTransaction();
        ContentValues contentvalues;
        sqlitedatabase.delete("channels", null, null);
        contentvalues = new ContentValues();
        collection = collection.iterator();
        k = ((flag) ? 1 : 0);
_L3:
        if (collection.hasNext())
        {
            VineChannel vinechannel = (VineChannel)collection.next();
            contentvalues.clear();
            fillChannelValues(contentvalues, vinechannel);
            break MISSING_BLOCK_LABEL_92;
        }
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        break; /* Loop/switch isn't completed */
_L4:
        savePageCursor(2, 0, null, i, j, 0L, true);
_L5:
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Inserted ").append(k).append(" new channels.").toString());
        }
        mContentResolver.notifyChange(Vine.Channels.CONTENT_URI, null);
        this;
        JVM INSTR monitorexit ;
        return k;
        collection;
        safeFinishTransaction(sqlitedatabase);
        throw collection;
        collection;
        this;
        JVM INSTR monitorexit ;
        throw collection;
        int l;
        if (sqlitedatabase.insert("channels", null, contentvalues) > 0L)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        k += l;
        if (true) goto _L3; else goto _L2
_L2:
        if (i <= 0 && j <= 0) goto _L5; else goto _L4
    }

    public long mergeConversation(long l, VineConversation vineconversation, int i, int j, int k, long l1)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        l = mergeMessages(l, vineconversation, i, j, k, l1);
        if (vineconversation.users == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        arraylist = new ArrayList();
        vineconversation = vineconversation.users.iterator();
_L2:
        do
        {
            if (!vineconversation.hasNext())
            {
                break MISSING_BLOCK_LABEL_96;
            }
            l1 = getUserRowIdForUserRemoteId(((Long)vineconversation.next()).longValue());
        } while (l1 <= -1L);
        arraylist.add(Long.valueOf(l1));
        if (true) goto _L2; else goto _L1
_L1:
        vineconversation;
        throw vineconversation;
        mergeConversationRecipients(l, arraylist);
        this;
        JVM INSTR monitorexit ;
        return l;
    }

    public void mergeConversationRecipients(long l, Collection collection)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        boolean flag;
        i = 0;
        flag = false;
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("mergeConversations, count=").append(collection.size()).toString());
        }
        if (collection.isEmpty()) goto _L2; else goto _L1
_L1:
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues;
        sqlitedatabase.beginTransaction();
        contentvalues = new ContentValues();
        contentvalues.put("conversation_row_id", Long.valueOf(l));
        collection = collection.iterator();
        i = ((flag) ? 1 : 0);
_L4:
        if (collection.hasNext())
        {
            contentvalues.put("user_row_id", (Long)collection.next());
            break MISSING_BLOCK_LABEL_123;
        }
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
_L2:
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        mContentResolver.notifyChange(Vine.InboxView.CONTENT_URI, null);
        this;
        JVM INSTR monitorexit ;
        return;
        collection;
        safeFinishTransaction(sqlitedatabase);
        throw collection;
        collection;
        this;
        JVM INSTR monitorexit ;
        throw collection;
        int j;
        if (sqlitedatabase.insert("conversation_recipients", null, contentvalues) > 0L)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        i += j;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public long mergeConversationWithLocalId(long l, long l1, int i)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        ContentValues contentvalues;
        sqlitedatabase = getWritableDatabase();
        contentvalues = new ContentValues();
        fillConversationValues(contentvalues, Long.valueOf(l1), Integer.valueOf(i), null, 0L, 0L);
        sqlitedatabase.beginTransaction();
        l1 = l;
        if (sqlitedatabase.update("conversations", contentvalues, "_id=?", new String[] {
    String.valueOf(l)
}) <= 0)
        {
            l1 = sqlitedatabase.insert("conversations", null, contentvalues);
        }
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception1;
        exception1;
        safeFinishTransaction(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public long mergeConversationWithRemoteId(long l, Integer integer, Boolean boolean1, long l1, long l2)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        Object obj;
        sqlitedatabase.beginTransaction();
        obj = sqlitedatabase.query("conversations", new String[] {
            "_id"
        }, "conversation_id=?", new String[] {
            String.valueOf(l)
        }, null, null, "1");
        long l3;
        long l4 = -1L;
        l3 = l4;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        l3 = l4;
        if (((Cursor) (obj)).moveToFirst())
        {
            ContentValues contentvalues = new ContentValues();
            fillConversationValues(contentvalues, Long.valueOf(l), integer, boolean1, l1, l2);
            sqlitedatabase.update("conversations", contentvalues, "conversation_id=?", new String[] {
                String.valueOf(l)
            });
            l3 = ((Cursor) (obj)).getLong(0);
        }
        ((Cursor) (obj)).close();
        long l5;
        l5 = l3;
        if (l3 != -1L)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        obj = new ContentValues();
        fillConversationValues(((ContentValues) (obj)), Long.valueOf(l), integer, boolean1, l1, l2);
        l = sqlitedatabase.insert("conversations", null, ((ContentValues) (obj)));
        l5 = l;
        if (l != -1L)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        throw new RuntimeException("Failed to insert conversation.");
        integer;
        safeFinishTransaction(sqlitedatabase);
        throw integer;
        integer;
        this;
        JVM INSTR monitorexit ;
        throw integer;
        integer;
        ((Cursor) (obj)).close();
        throw integer;
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        this;
        JVM INSTR monitorexit ;
        return l5;
    }

    public void mergeEditions(ArrayList arraylist)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("editions", null, null);
        int i;
        boolean flag;
        i = 0;
        flag = false;
        if (arraylist.isEmpty())
        {
            break MISSING_BLOCK_LABEL_129;
        }
        sqlitedatabase.beginTransaction();
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        arraylist = arraylist.iterator();
        i = ((flag) ? 1 : 0);
        while (arraylist.hasNext()) 
        {
            Pair pair = (Pair)arraylist.next();
            contentvalues.put("edition_code", (String)pair.first);
            contentvalues.put("edition_name", (String)pair.second);
            i = (int)((long)i + sqlitedatabase.insert("editions", null, contentvalues));
        }
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        mContentResolver.notifyChange(Vine.Editions.CONTENT_URI, null);
        this;
        JVM INSTR monitorexit ;
        return;
        arraylist;
        safeFinishTransaction(sqlitedatabase);
        throw arraylist;
        arraylist;
        this;
        JVM INSTR monitorexit ;
        throw arraylist;
    }

    public void mergeInbox(long l, co.vine.android.api.VineParsers.VinePagedInbox vinepagedinbox, int i, int j, long l1, 
            int k, int i1)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (vinepagedinbox.participants != null && !vinepagedinbox.participants.isEmpty())
        {
            mergeUsers(vinepagedinbox.participants, i1, null, 0, 0, null);
        }
        for (vinepagedinbox = vinepagedinbox.items.iterator(); vinepagedinbox.hasNext(); mergeConversation(l, (VineConversation)vinepagedinbox.next(), k, 0, 0, 0L)) { }
        break MISSING_BLOCK_LABEL_79;
        vinepagedinbox;
        throw vinepagedinbox;
        if (i <= 0 && j <= 0 && l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        savePageCursor(6, k, null, i, j, l1, false);
        this;
        JVM INSTR monitorexit ;
    }

    public int mergeLikes(Collection collection, long l, int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        LongSparseArray longsparsearray;
        obj = getWritableDatabase();
        longsparsearray = new LongSparseArray(collection.size());
        obj1 = new LongSparseArray(collection.size());
        VineLike vinelike1;
        for (collection = collection.iterator(); collection.hasNext(); longsparsearray.put(vinelike1.likeId, vinelike1))
        {
            vinelike1 = (VineLike)collection.next();
            vinelike1.postId = l;
        }

        break MISSING_BLOCK_LABEL_91;
        collection;
        throw collection;
        collection = ((SQLiteDatabase) (obj)).query("likes", VineDatabaseSQL.LikesQuery.PROJECTION, null, null, null, null, null);
        if (collection == null)
        {
            break MISSING_BLOCK_LABEL_176;
        }
_L1:
        Object obj2;
        long l2;
        do
        {
            if (!collection.moveToNext())
            {
                break MISSING_BLOCK_LABEL_170;
            }
            l2 = collection.getLong(1);
            obj2 = (VineLike)longsparsearray.removeKey(l2);
        } while (obj2 == null);
        ((LongSparseArray) (obj1)).put(l2, obj2);
          goto _L1
        obj;
        collection.close();
        throw obj;
        collection.close();
        int j1;
        int k = longsparsearray.size() + ((LongSparseArray) (obj1)).size();
        collection = new LongSparseArray(k);
        obj2 = new ArrayList(k);
        j1 = longsparsearray.size();
        int i1 = 0;
_L15:
        if (i1 >= j1) goto _L3; else goto _L2
_L2:
        VineLike vinelike3 = (VineLike)longsparsearray.valueAt(i1);
        if (vinelike3.user != null)
        {
            ((ArrayList) (obj2)).add(vinelike3.user);
            collection.put(vinelike3.user.userId, Long.valueOf(vinelike3.likeId));
        }
          goto _L4
_L3:
        int l1 = ((LongSparseArray) (obj1)).size();
        i1 = 0;
_L16:
        if (i1 >= l1) goto _L6; else goto _L5
_L5:
        VineLike vinelike4 = (VineLike)((LongSparseArray) (obj1)).valueAt(i1);
        if (vinelike4.user != null)
        {
            ((ArrayList) (obj2)).add(vinelike4.user);
            collection.put(vinelike4.user.userId, Long.valueOf(vinelike4.likeId));
        }
          goto _L7
_L6:
        if (!((ArrayList) (obj2)).isEmpty())
        {
            mergeUsers(((Collection) (obj2)), 5, String.valueOf(l), i, j, collection);
        }
        j = 0;
        i = 0;
        l = System.currentTimeMillis();
        if (j1 <= 0) goto _L9; else goto _L8
_L8:
        ((SQLiteDatabase) (obj)).beginTransaction();
        collection = new ContentValues();
        j = 0;
_L17:
        if (j >= j1)
        {
            break MISSING_BLOCK_LABEL_460;
        }
        VineLike vinelike2 = (VineLike)longsparsearray.valueAt(j);
        collection.clear();
        fillLikeValues(collection, vinelike2, l);
        break MISSING_BLOCK_LABEL_439;
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        j = i;
_L9:
        i1 = 0;
        i = 0;
        if (l1 <= 0)
        {
            break MISSING_BLOCK_LABEL_616;
        }
        ((SQLiteDatabase) (obj)).beginTransaction();
        collection = new ContentValues();
        i1 = 0;
_L11:
        if (i1 >= l1)
        {
            break; /* Loop/switch isn't completed */
        }
        VineLike vinelike = (VineLike)((LongSparseArray) (obj1)).valueAt(i1);
        collection.clear();
        fillLikeValues(collection, vinelike, l);
        k1 = ((SQLiteDatabase) (obj)).update("likes", collection, "like_id=?", new String[] {
            String.valueOf(vinelike.likeId)
        });
        if (k1 > 0)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        i += k1;
        i1++;
        if (true) goto _L11; else goto _L10
        collection;
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        throw collection;
_L10:
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        i1 = i;
        l1 = 0;
        flag = false;
        i2 = 0;
        k1 = 0;
        i = i2;
        if (j <= 0) goto _L13; else goto _L12
_L12:
        collection = ((SQLiteDatabase) (obj)).query("likes", VineDatabaseSQL.TableQuery.PROJECTION, null, null, null, null, null);
        i = i2;
        if (collection == null) goto _L13; else goto _L14
_L14:
        i = ((flag) ? 1 : 0);
        if (!collection.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_860;
        }
        i2 = collection.getCount();
        i = ((flag) ? 1 : 0);
        if (i2 <= 5000)
        {
            break MISSING_BLOCK_LABEL_860;
        }
        obj1 = ((SQLiteDatabase) (obj)).rawQuery("SELECT last_refresh FROM likes ORDER BY last_refresh DESC LIMIT 1 OFFSET 2500", null);
        ((SQLiteDatabase) (obj)).beginTransaction();
        i = l1;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_849;
        }
        i = k1;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_842;
        }
        l = ((Cursor) (obj1)).getLong(0);
        k1 = ((SQLiteDatabase) (obj)).delete("likes", "last_refresh<?", new String[] {
            String.valueOf(l)
        });
        i = k1;
        if (!LOGGABLE)
        {
            break MISSING_BLOCK_LABEL_842;
        }
        Log.d("s", (new StringBuilder()).append("Due to reaching maximum table size (").append(i2).append(" with a max of ").append(5000).append("), deleted ").append(k1).append(" likes, all less than refresh time ").append(l).toString());
        i = k1;
        ((Cursor) (obj1)).close();
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        collection.close();
          goto _L13
_L18:
        mContentResolver.notifyChange(Vine.Likes.CONTENT_URI, null);
_L19:
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Inserted ").append(j).append(" likes and updated ").append(i1).append(".").toString());
        }
        this;
        JVM INSTR monitorexit ;
        return j;
        collection;
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        throw collection;
        exception2;
        ((Cursor) (obj1)).close();
        throw exception2;
        exception1;
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        throw exception1;
        exception;
        collection.close();
        throw exception;
_L4:
        i1++;
          goto _L15
_L7:
        i1++;
          goto _L16
        Exception exception;
        Exception exception1;
        Exception exception2;
        int k1;
        boolean flag;
        int i2;
        if (((SQLiteDatabase) (obj)).insert("likes", null, collection) > 0L)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        i += i1;
        j++;
          goto _L17
_L13:
        if (j <= 0 && i1 <= 0 && i <= 0) goto _L19; else goto _L18
    }

    public long mergeMessage(long l, VinePrivateMessage vineprivatemessage)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        long l1;
        long l2;
        l2 = -1L;
        l1 = -1L;
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        fillMessageValues(contentvalues, l, vineprivatemessage);
        l = l1;
        if (-1L != -1L)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        l = l1;
        Cursor cursor;
        if (vineprivatemessage.messageId <= 0L)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        l = vineprivatemessage.messageId;
        cursor = mContentResolver.query(Vine.Messages.CONTENT_URI, VineDatabaseSQL.MessagesQuery.PROJECTION, "message_id=?", new String[] {
            String.valueOf(l)
        }, null);
        l = l1;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        l = l1;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_192;
        }
        l = cursor.getLong(13);
        if (l > vineprivatemessage.localStartTime)
        {
            contentvalues.put("local_start_time", Long.valueOf(l));
        }
        sqlitedatabase.beginTransaction();
        l = sqlitedatabase.update("messages", contentvalues, "message_id=?", new String[] {
            String.valueOf(vineprivatemessage.messageId)
        });
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        cursor.close();
        l1 = l2;
        if (-1L != -1L) goto _L2; else goto _L1
_L1:
        l1 = l2;
        if (l > 0L) goto _L2; else goto _L3
_L3:
        contentvalues.put("deleted", "0");
        l1 = sqlitedatabase.insert("messages", null, contentvalues);
          goto _L2
_L4:
        mContentResolver.notifyChange(Vine.ConversationMessageUsersView.CONTENT_URI, null);
        mContentResolver.notifyChange(Vine.InboxView.CONTENT_URI, null);
_L5:
        this;
        JVM INSTR monitorexit ;
        return l1;
        vineprivatemessage;
        safeFinishTransaction(sqlitedatabase);
        throw vineprivatemessage;
        vineprivatemessage;
        this;
        JVM INSTR monitorexit ;
        throw vineprivatemessage;
_L2:
        if (l1 <= 0L && l <= 0L) goto _L5; else goto _L4
    }

    public long mergeMessageWithMessageRow(long l, long l1, VinePrivateMessage vineprivatemessage)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        long l2 = -1L;
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        fillMessageValues(contentvalues, l1, vineprivatemessage);
        long l3;
        sqlitedatabase.beginTransaction();
        l3 = sqlitedatabase.update("messages", contentvalues, "_id=?", new String[] {
            String.valueOf(l)
        });
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        l1 = l2;
        if (l3 > 0L) goto _L2; else goto _L1
_L1:
        contentvalues.put("deleted", "0");
        l1 = sqlitedatabase.insert("messages", null, contentvalues);
          goto _L2
_L3:
        mContentResolver.notifyChange(Vine.ConversationMessageUsersView.CONTENT_URI, null);
        mContentResolver.notifyChange(Vine.InboxView.CONTENT_URI, null);
_L4:
        if (l1 <= 0L)
        {
            l1 = l;
        }
        this;
        JVM INSTR monitorexit ;
        return l1;
        vineprivatemessage;
        safeFinishTransaction(sqlitedatabase);
        throw vineprivatemessage;
        vineprivatemessage;
        this;
        JVM INSTR monitorexit ;
        throw vineprivatemessage;
_L2:
        if (l1 <= 0L && l3 <= 0L) goto _L4; else goto _L3
    }

    public long mergeMessages(long l, VineConversation vineconversation, int i, int j, int k, long l1)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        Object obj2;
        long l4;
        obj2 = new LinkedHashMap();
        obj1 = new LinkedHashMap();
        obj = new HashMap();
        l4 = mergeConversationWithRemoteId(vineconversation.conversationId, Integer.valueOf(i), null, vineconversation.unreadMessageCount, 0L);
        long l2;
        long l3;
        l2 = 0x7fffffffffffffffL;
        l3 = l2;
        Object obj3;
        if (vineconversation.messages == null)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        obj3 = vineconversation.messages.iterator();
_L1:
        l3 = l2;
        Object obj4;
        if (!((Iterator) (obj3)).hasNext())
        {
            break MISSING_BLOCK_LABEL_228;
        }
        obj4 = (VinePrivateMessage)((Iterator) (obj3)).next();
        l3 = l2;
        if (((VinePrivateMessage) (obj4)).messageId < l2)
        {
            l3 = ((VinePrivateMessage) (obj4)).messageId;
        }
        if (((HashMap) (obj)).containsKey(Long.valueOf(((VinePrivateMessage) (obj4)).userId)))
        {
            break MISSING_BLOCK_LABEL_204;
        }
        l2 = getUserRowIdForUserRemoteId(((VinePrivateMessage) (obj4)).userId);
        ((HashMap) (obj)).put(Long.valueOf(((VinePrivateMessage) (obj4)).userId), Long.valueOf(l2));
_L2:
        obj4.userId = l2;
        ((LinkedHashMap) (obj2)).put(Long.valueOf(((VinePrivateMessage) (obj4)).messageId), obj4);
        l2 = l3;
          goto _L1
        vineconversation;
        throw vineconversation;
        l2 = ((Long)((HashMap) (obj)).get(Long.valueOf(((VinePrivateMessage) (obj4)).userId))).longValue();
          goto _L2
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("mergeMessages, count=").append(((LinkedHashMap) (obj2)).size()).toString());
        }
        obj = getWritableDatabase();
        int i1;
        i1 = 1;
        i = 1;
        obj3 = ((SQLiteDatabase) (obj)).query("messages", VineDatabaseSQL.MessagesQuery.PROJECTION, "conversation_row_id =? ", new String[] {
            String.valueOf(l4)
        }, null, null, "message_id DESC", "1");
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_355;
        }
        VinePrivateMessage vineprivatemessage;
        int j1;
        int k1;
        boolean flag;
        if (((Cursor) (obj3)).moveToFirst())
        {
            if (l3 <= ((Cursor) (obj3)).getLong(2))
            {
                i = 1;
            } else
            {
                i = 0;
            }
        }
        ((Cursor) (obj3)).close();
        i1 = i;
        obj3 = mContentResolver.query(Vine.Messages.CONTENT_URI, VineDatabaseSQL.MessagesQuery.PROJECTION, null, null, null);
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_440;
        }
_L3:
        do
        {
            if (!((Cursor) (obj3)).moveToNext())
            {
                break MISSING_BLOCK_LABEL_433;
            }
            obj4 = (VinePrivateMessage)((LinkedHashMap) (obj2)).remove(Long.valueOf(((Cursor) (obj3)).getLong(2)));
        } while (obj4 == null);
        ((LinkedHashMap) (obj1)).put(Long.valueOf(((VinePrivateMessage) (obj4)).messageId), obj4);
          goto _L3
        ((Cursor) (obj3)).close();
        j1 = 0;
        i = 0;
        flag = false;
        k1 = 0;
        obj3 = new ArrayList();
        if (((LinkedHashMap) (obj2)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_721;
        }
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Inserting new messages, count=").append(((LinkedHashMap) (obj2)).size()).toString());
        }
        ((SQLiteDatabase) (obj)).beginTransaction();
        obj4 = new ContentValues();
        obj2 = ((LinkedHashMap) (obj2)).values().iterator();
_L5:
        if (!((Iterator) (obj2)).hasNext())
        {
            break MISSING_BLOCK_LABEL_681;
        }
        vineprivatemessage = (VinePrivateMessage)((Iterator) (obj2)).next();
        ((ContentValues) (obj4)).clear();
        fillMessageValues(((ContentValues) (obj4)), l4, vineprivatemessage);
        ((ContentValues) (obj4)).put("deleted", Integer.valueOf(0));
        l2 = ((SQLiteDatabase) (obj)).insert("messages", null, ((ContentValues) (obj4)));
        if (l2 > 0L)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        j1 = i + j1;
        if (vineprivatemessage.messageId == vineconversation.lastMessage)
        {
            updateConversationWithLastMessage(l4, l2, vineprivatemessage.created);
        }
        i = j1;
        if (vineprivatemessage.post == null) goto _L5; else goto _L4
_L4:
        ((ArrayList) (obj3)).add(vineprivatemessage.post);
        i = j1;
          goto _L5
        vineconversation;
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        throw vineconversation;
        mergePosts(((Collection) (obj3)), 12, String.valueOf(l), 0, 0, 0, 0L, true);
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        setConversationHidden(l4, false);
        j1 = i;
        i = ((flag) ? 1 : 0);
        if (((LinkedHashMap) (obj1)).isEmpty()) goto _L7; else goto _L6
_L6:
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Updating existing messages, count=").append(((LinkedHashMap) (obj1)).size()).toString());
        }
        ((SQLiteDatabase) (obj)).beginTransaction();
        vineconversation = new ContentValues();
        obj1 = ((LinkedHashMap) (obj1)).values().iterator();
        i = k1;
_L9:
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_918;
        }
        obj2 = (VinePrivateMessage)((Iterator) (obj1)).next();
        vineconversation.clear();
        fillMessageValues(vineconversation, l4, ((VinePrivateMessage) (obj2)));
        if (((SQLiteDatabase) (obj)).update("messages", vineconversation, "message_id=?", new String[] {
    String.valueOf(((VinePrivateMessage) (obj2)).messageId)
}) > 0)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        k1 = i + k1;
        i = k1;
        if (((VinePrivateMessage) (obj2)).post == null) goto _L9; else goto _L8
_L8:
        ((ArrayList) (obj3)).add(((VinePrivateMessage) (obj2)).post);
        i = k1;
          goto _L9
        vineconversation;
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        throw vineconversation;
        mergePosts(((Collection) (obj3)), 12, String.valueOf(l), 0, 0, 0, 0L, true);
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        safeFinishTransaction(((SQLiteDatabase) (obj)));
          goto _L7
_L12:
        savePageCursor(7, 0, String.valueOf(l4), j, k, l1, false);
        break; /* Loop/switch isn't completed */
_L14:
        mContentResolver.notifyChange(Vine.Messages.CONTENT_URI, null);
        mContentResolver.notifyChange(Vine.ConversationMessageUsersView.CONTENT_URI, null);
        mContentResolver.notifyChange(Vine.InboxView.CONTENT_URI, null);
_L15:
        this;
        JVM INSTR monitorexit ;
        return l4;
_L11:
        SLog.d("Deleting messages for conversation row id {}, non contiguous", Long.valueOf(l4));
        i1 = ((SQLiteDatabase) (obj)).delete("messages", "conversation_row_id =? AND message_id <? AND message_id > ?", new String[] {
            String.valueOf(l4), String.valueOf(l3), "0"
        });
        continue; /* Loop/switch isn't completed */
_L7:
        k1 = 0;
        if (i1 == 0) goto _L11; else goto _L10
_L10:
        i1 = k1;
        if (j <= 0 && k <= 0 && l1 <= 0L) goto _L13; else goto _L12
_L13:
        if (j1 <= 0 && i <= 0 && i1 <= 0) goto _L15; else goto _L14
    }

    public DbResponse mergePosts(Collection collection, int i, String s, int j, int k, int l, long l1, boolean flag)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        LongSparseArray longsparsearray;
        LongSparseArray longsparsearray1;
        sqlitedatabase = getWritableDatabase();
        longsparsearray1 = new LongSparseArray(collection.size());
        longsparsearray = new LongSparseArray(collection.size());
        VinePost vinepost;
        for (Iterator iterator = collection.iterator(); iterator.hasNext(); longsparsearray1.put(vinepost.postId, vinepost))
        {
            vinepost = (VinePost)iterator.next();
        }

        break MISSING_BLOCK_LABEL_88;
        collection;
        throw collection;
        if (!Util.isPopularTimeline(i)) goto _L2; else goto _L1
_L1:
        Object obj1 = new LongSparseArray(collection.size());
        if (j != 1 && j != 2) goto _L4; else goto _L3
_L3:
        j = 1;
        removePostsFromGroup(i);
_L10:
        Object obj2 = collection.iterator();
_L6:
        Object obj = obj1;
        if (!((Iterator) (obj2)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        ((LongSparseArray) (obj1)).put(((VinePost)((Iterator) (obj2)).next()).postId, Long.valueOf(j));
        j++;
        if (true) goto _L6; else goto _L5
_L4:
        obj = getOldestSortId(i);
        if (obj == null) goto _L8; else goto _L7
_L7:
        if (!((Cursor) (obj)).moveToFirst()) goto _L8; else goto _L9
_L9:
        j = ((Cursor) (obj)).getInt(0) + 1;
          goto _L10
_L2:
        obj1 = new LongSparseArray(collection.size());
        obj2 = collection.iterator();
_L11:
        obj = obj1;
        if (!((Iterator) (obj2)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (VinePost)((Iterator) (obj2)).next();
        ((LongSparseArray) (obj1)).put(((VinePost) (obj)).postId, Long.valueOf(VineComparatorFactory.get(i).getOrderId(obj)));
        if (true) goto _L11; else goto _L5
_L5:
        int i1;
        int j1;
        i1 = 1;
        j1 = 1;
        if (TextUtils.isEmpty(s) || Util.isPopularTimeline(i)) goto _L13; else goto _L12
_L12:
        obj1 = "post_type=? AND tag=?";
        obj2 = new String[2];
        obj2[0] = String.valueOf(i);
        obj2[1] = s;
_L18:
        obj1 = sqlitedatabase.query("post_groups_view", VineDatabaseSQL.PostGroupsQuery.PROJECTION, ((String) (obj1)), ((String []) (obj2)), null, null, "sort_id DESC");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_427;
        }
        j = j1;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_416;
        }
        j = j1;
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_416;
        }
        long l2 = ((Cursor) (obj1)).getLong(3);
        int k1;
        int i2;
        boolean flag2;
        if (l1 < l2)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        ((Cursor) (obj1)).close();
        i1 = j;
        obj1 = sqlitedatabase.query("posts", new String[] {
            "post_id"
        }, null, null, null, null, null);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_523;
        }
        if (!((Cursor) (obj1)).moveToFirst()) goto _L15; else goto _L14
_L14:
        l2 = ((Cursor) (obj1)).getLong(0);
        obj2 = (VinePost)longsparsearray1.removeKey(l2);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_502;
        }
        longsparsearray.put(l2, obj2);
        flag2 = ((Cursor) (obj1)).moveToNext();
        if (flag2) goto _L14; else goto _L15
_L15:
        ((Cursor) (obj1)).close();
        if (!LOGGABLE || !longsparsearray1.isEmpty() || !longsparsearray.isEmpty()) goto _L17; else goto _L16
_L16:
        Log.d("VineDH", "No new posts to merge or update");
        collection = new DbResponse(0, 0, 2);
_L41:
        this;
        JVM INSTR monitorexit ;
        return collection;
_L13:
        obj1 = "post_type=?";
        obj2 = new String[1];
        obj2[0] = String.valueOf(i);
          goto _L18
        collection;
        ((Cursor) (obj1)).close();
        throw collection;
        collection;
        ((Cursor) (obj1)).close();
        throw collection;
_L17:
        obj1 = new LongSparseArray(collection.size());
        obj2 = new ArrayList(collection.size());
        j1 = longsparsearray1.size();
        j = 0;
_L46:
        if (j >= j1) goto _L20; else goto _L19
_L19:
        VinePost vinepost1 = (VinePost)longsparsearray1.valueAt(j);
        if (vinepost1.user != null)
        {
            ((ArrayList) (obj2)).add(vinepost1.user);
            ((LongSparseArray) (obj1)).put(vinepost1.userId, Long.valueOf(vinepost1.postId));
        }
          goto _L21
_L20:
        mergeUsers(((Collection) (obj2)), 4, null, 0, 0, ((LongSparseArray) (obj1)), null);
        l2 = System.currentTimeMillis();
        j1 = 0;
        j = 0;
        i2 = longsparsearray1.size();
        if (i2 <= 0) goto _L23; else goto _L22
_L22:
        sqlitedatabase.beginTransaction();
        obj1 = new ContentValues();
        j1 = 0;
_L47:
        if (j1 >= i2) goto _L25; else goto _L24
_L24:
        obj2 = (VinePost)longsparsearray1.valueAt(j1);
        ((ContentValues) (obj1)).clear();
        if (((VinePost) (obj2)).likes == null) goto _L27; else goto _L26
_L26:
        k1 = ((VinePost) (obj2)).likes.count;
_L48:
        obj2.likesCount = k1;
        if (((VinePost) (obj2)).comments == null) goto _L29; else goto _L28
_L28:
        k1 = ((VinePost) (obj2)).comments.count;
_L49:
        obj2.commentsCount = k1;
        fillPostValues(((ContentValues) (obj1)), ((VinePost) (obj2)), l2);
        String as[];
        int j2;
        int k2;
        boolean flag1;
        if (sqlitedatabase.insert("posts", null, ((ContentValues) (obj1))) > 0L)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        j += k1;
        if (((VinePost) (obj2)).likes != null && ((VinePost) (obj2)).likes.items != null && !((VinePost) (obj2)).likes.items.isEmpty())
        {
            mergeLikes(((VinePost) (obj2)).likes.items, ((VinePost) (obj2)).postId, -1, -1);
        }
          goto _L30
_L25:
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        j1 = j;
_L23:
        k1 = 0;
        j = 0;
        k2 = longsparsearray.size();
        if (k2 <= 0)
        {
            break MISSING_BLOCK_LABEL_1209;
        }
        sqlitedatabase.beginTransaction();
        obj1 = new ContentValues();
        k1 = 0;
_L33:
        if (k1 >= k2)
        {
            break MISSING_BLOCK_LABEL_1194;
        }
        obj2 = (VinePost)longsparsearray.valueAt(k1);
        ((ContentValues) (obj1)).clear();
        if (((VinePost) (obj2)).likes == null) goto _L32; else goto _L31
_L31:
        j2 = ((VinePost) (obj2)).likes.count;
_L34:
        obj2.likesCount = j2;
        if (((VinePost) (obj2)).comments == null)
        {
            break MISSING_BLOCK_LABEL_1182;
        }
        j2 = ((VinePost) (obj2)).comments.count;
_L35:
        obj2.commentsCount = j2;
        fillPostValues(((ContentValues) (obj1)), ((VinePost) (obj2)), l2);
        if (sqlitedatabase.update("posts", ((ContentValues) (obj1)), "post_id=?", new String[] {
    String.valueOf(((VinePost) (obj2)).postId)
}) > 0)
        {
            j2 = 1;
        } else
        {
            j2 = 0;
        }
        j += j2;
        if (((VinePost) (obj2)).likes != null && ((VinePost) (obj2)).likes.items != null && !((VinePost) (obj2)).likes.items.isEmpty())
        {
            mergeLikes(((VinePost) (obj2)).likes.items, ((VinePost) (obj2)).postId, -1, -1);
        }
        k1++;
          goto _L33
        collection;
        safeFinishTransaction(sqlitedatabase);
        throw collection;
_L32:
        j2 = 0;
          goto _L34
        j2 = 0;
          goto _L35
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        k1 = j;
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Inserted ").append(j1).append(" posts, and updated ").append(k1).append(" with lastRefresh time ").append(l2).toString());
        }
          goto _L36
_L50:
        savePageCursor(2, i, s, k, l, l1, false);
        break; /* Loop/switch isn't completed */
_L54:
        j2 = 0;
        k2 = 0;
        flag1 = false;
        l = 0;
        j = ((flag1) ? 1 : 0);
        if (j1 <= 0) goto _L38; else goto _L37
_L37:
        j = ((flag1) ? 1 : 0);
        if (i1 == 0) goto _L38; else goto _L39
_L39:
        obj1 = sqlitedatabase.query("posts", VineDatabaseSQL.TableQuery.PROJECTION, null, null, null, null, null);
        j = ((flag1) ? 1 : 0);
        if (obj1 == null) goto _L38; else goto _L40
_L40:
        j = k2;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_1571;
        }
        i1 = ((Cursor) (obj1)).getCount();
        j = k2;
        if (i1 <= 1000)
        {
            break MISSING_BLOCK_LABEL_1571;
        }
        as = sqlitedatabase.rawQuery("SELECT last_refresh FROM posts ORDER BY last_refresh DESC LIMIT 1 OFFSET 500", null);
        sqlitedatabase.beginTransaction();
        j = j2;
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_1560;
        }
        j = l;
        if (!as.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_1553;
        }
        l1 = as.getLong(0);
        sqlitedatabase.execSQL("DELETE FROM post_groups WHERE post_id IN (SELECT post_id FROM posts WHERE last_refresh < ?);", new String[] {
            String.valueOf(l1)
        });
        l = sqlitedatabase.delete("posts", "last_refresh<?", new String[] {
            String.valueOf(l1)
        });
        j = l;
        if (!LOGGABLE)
        {
            break MISSING_BLOCK_LABEL_1553;
        }
        Log.d("s", (new StringBuilder()).append("Due to reaching maximum table size (").append(i1).append(" with a max of ").append(1000).append("), deleted ").append(l).append(" posts groups all less than last refresh id ").append(l1).append(".").toString());
        j = l;
        as.close();
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        ((Cursor) (obj1)).close();
          goto _L38
_L55:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_1609;
        }
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_1599;
        }
        mergePostGroups(collection, i, s, ((LongSparseArray) (obj)));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_1609;
        }
        notifyByType(i);
_L56:
        collection = new DbResponse(j1, k1, k);
          goto _L41
        collection;
        safeFinishTransaction(sqlitedatabase);
        throw collection;
_L53:
        if (TextUtils.isEmpty(s)) goto _L43; else goto _L42
_L42:
        obj1 = "post_type=? AND tag=? AND post_id<?";
        as = new String[3];
        as[0] = String.valueOf(i);
        as[1] = s;
        as[2] = String.valueOf(l1);
_L45:
        j = sqlitedatabase.delete("posts", "post_id<?", new String[] {
            String.valueOf(i)
        });
        k = sqlitedatabase.delete("post_groups", ((String) (obj1)), as);
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Non contiguous timeline detected, deleted ").append(j).append(" posts and ").append(k).append(" with id less than anchor: ").append(l1).append(" of type ").append(i).append(" and tag ").append(s).toString());
        }
          goto _L44
_L43:
        obj1 = "post_type=? AND post_id<?";
        as = new String[2];
        as[0] = String.valueOf(i);
        as[1] = String.valueOf(l1);
          goto _L45
        collection;
        as.close();
        throw collection;
        collection;
        safeFinishTransaction(sqlitedatabase);
        throw collection;
        collection;
        ((Cursor) (obj1)).close();
        throw collection;
_L8:
        j = 1;
          goto _L10
_L21:
        j++;
          goto _L46
_L30:
        j1++;
          goto _L47
_L27:
        k1 = 0;
          goto _L48
_L29:
        k1 = 0;
          goto _L49
_L36:
        if (l1 <= 0L && k <= 0 && l <= 0) goto _L51; else goto _L50
_L51:
        if (i1 == 0) goto _L53; else goto _L52
_L52:
        k = 1;
          goto _L54
_L38:
        if (j1 <= 0 && k1 <= 0 && j <= 0) goto _L56; else goto _L55
_L44:
        k = 4;
          goto _L54
    }

    public ArrayList mergePushNotification(VineSingleNotification vinesinglenotification, String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        Object obj2;
        int j;
        String s1;
        Object obj;
        Object obj1;
        if (i == 18)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        s1 = s;
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        s1 = vinesinglenotification.comment;
        sqlitedatabase = getWritableDatabase();
        obj1 = null;
        obj = null;
        obj2 = (new StringBuilder()).append("notification_id=?");
        if (j != 0)
        {
            s = " AND notification_type=?";
        } else
        {
            s = "";
        }
        obj2 = ((StringBuilder) (obj2)).append(s).toString();
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        s = new String[2];
        s[0] = String.valueOf(vinesinglenotification.notificationId);
        s[1] = String.valueOf(i);
_L1:
        obj2 = sqlitedatabase.query("notifications", VineDatabaseSQL.NotificationsQuery.PROJECTION, ((String) (obj2)), s, null, null, "notification_id DESC");
        sqlitedatabase.beginTransaction();
        s = obj1;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        s = obj;
        if (((Cursor) (obj2)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_196;
        }
        s = new ContentValues();
        fillNotificationValues(s, vinesinglenotification, s1);
        if (sqlitedatabase.insert("notifications", null, s) > 0L)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        s = obj;
        if (0 + j <= 0)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        s = getNotifications(i);
        ((Cursor) (obj2)).close();
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        this;
        JVM INSTR monitorexit ;
        return s;
        s = new String[1];
        s[0] = String.valueOf(vinesinglenotification.notificationId);
          goto _L1
        vinesinglenotification;
        throw vinesinglenotification;
        vinesinglenotification;
        ((Cursor) (obj2)).close();
        throw vinesinglenotification;
        vinesinglenotification;
        safeFinishTransaction(sqlitedatabase);
        throw vinesinglenotification;
    }

    public void mergeRecipientsWithUsersAndRemoveUnusedRecipients(long l, ArrayList arraylist, ArrayList arraylist1)
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj = new HashSet();
        obj1 = new HashMap();
        VineUser vineuser;
        for (arraylist1 = arraylist1.iterator(); arraylist1.hasNext(); ((HashMap) (obj1)).put(Long.valueOf(vineuser.userId), vineuser))
        {
            vineuser = (VineUser)arraylist1.next();
        }

        arraylist1 = getWritableDatabase();
        obj2 = arraylist1.query("conversation_recipients", new String[] {
            "user_row_id"
        }, "conversation_row_id =? ", new String[] {
            String.valueOf(l)
        }, null, null, null);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        ((Cursor) (obj2)).moveToPosition(-1);
        for (; ((Cursor) (obj2)).moveToNext(); ((HashSet) (obj)).add(Long.valueOf(((Cursor) (obj2)).getLong(0)))) { }
        break MISSING_BLOCK_LABEL_163;
        arraylist;
        ((Cursor) (obj2)).close();
        throw arraylist;
        ((Cursor) (obj2)).close();
        arraylist1.beginTransaction();
        arraylist = arraylist.iterator();
_L2:
        do
        {
            if (!arraylist.hasNext())
            {
                break MISSING_BLOCK_LABEL_323;
            }
            obj2 = (VineRecipient)arraylist.next();
        } while (obj2 == null);
        if (((VineRecipient) (obj2)).userId <= 0L || ((VineRecipient) (obj2)).recipientId <= 0L) goto _L2; else goto _L1
_L1:
        ContentValues contentvalues;
        VineUser vineuser1;
        contentvalues = new ContentValues();
        vineuser1 = (VineUser)((HashMap) (obj1)).get(Long.valueOf(((VineRecipient) (obj2)).userId));
        if (vineuser1 == null) goto _L2; else goto _L3
_L3:
        fillUserContentValues(contentvalues, vineuser1, System.currentTimeMillis());
        arraylist1.update("users", contentvalues, "_id=? ", new String[] {
            String.valueOf(((VineRecipient) (obj2)).recipientId)
        });
        ((HashSet) (obj)).remove(Long.valueOf(((VineRecipient) (obj2)).recipientId));
          goto _L2
        arraylist;
        safeFinishTransaction(arraylist1);
        throw arraylist;
        arraylist1.setTransactionSuccessful();
        safeFinishTransaction(arraylist1);
        if (((HashSet) (obj)).size() <= 0) goto _L5; else goto _L4
_L4:
        arraylist1.beginTransaction();
        int i = 0;
        int j;
        j = ((HashSet) (obj)).size();
        arraylist = new String[j];
        obj1 = new StringBuilder();
        ((StringBuilder) (obj1)).append(" IN (");
        obj = ((HashSet) (obj)).iterator();
_L8:
        if (!((Iterator) (obj)).hasNext()) goto _L7; else goto _L6
_L6:
        Long long1 = (Long)((Iterator) (obj)).next();
        ((StringBuilder) (obj1)).append("?");
        arraylist[i] = long1.toString();
        if (i == j - 1)
        {
            break MISSING_BLOCK_LABEL_548;
        }
        ((StringBuilder) (obj1)).append(", ");
        break MISSING_BLOCK_LABEL_548;
_L7:
        ((StringBuilder) (obj1)).append(")");
        String s = ((StringBuilder) (obj1)).toString();
        arraylist1.delete("users", (new StringBuilder()).append("_id").append(s).toString(), arraylist);
        arraylist1.delete("conversation_recipients", (new StringBuilder()).append("user_row_id").append(s).toString(), arraylist);
        arraylist1.setTransactionSuccessful();
        safeFinishTransaction(arraylist1);
_L5:
        return;
        arraylist;
        safeFinishTransaction(arraylist1);
        throw arraylist;
        i++;
          goto _L8
    }

    public int mergeSearchedTags(Collection collection, int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        Object obj2;
        obj = getWritableDatabase();
        obj2 = new HashMap(collection.size());
        obj1 = new HashMap(collection.size());
        VineTag vinetag1;
        for (collection = collection.iterator(); collection.hasNext(); ((HashMap) (obj2)).put(Long.valueOf(vinetag1.tagId), vinetag1))
        {
            vinetag1 = (VineTag)collection.next();
        }

        break MISSING_BLOCK_LABEL_89;
        collection;
        throw collection;
        collection = ((SQLiteDatabase) (obj)).query("tag_search_results", new String[] {
            "tag_id"
        }, null, null, null, null, null);
        if (collection == null)
        {
            break MISSING_BLOCK_LABEL_196;
        }
_L1:
        VineTag vinetag2;
        long l1;
        do
        {
            if (!collection.moveToNext())
            {
                break MISSING_BLOCK_LABEL_190;
            }
            l1 = collection.getLong(collection.getColumnIndex("tag_id"));
            vinetag2 = (VineTag)((HashMap) (obj2)).remove(Long.valueOf(l1));
        } while (vinetag2 == null);
        ((HashMap) (obj1)).put(Long.valueOf(l1), vinetag2);
          goto _L1
        obj;
        collection.close();
        throw obj;
        collection.close();
        int k;
        int l;
        int i1;
        boolean flag;
        l = 0;
        k = 0;
        flag = false;
        i1 = 0;
        if (((HashMap) (obj2)).isEmpty()) goto _L3; else goto _L2
_L2:
        ((SQLiteDatabase) (obj)).beginTransaction();
        collection = new ContentValues();
        obj2 = ((HashMap) (obj2)).values().iterator();
_L11:
        if (!((Iterator) (obj2)).hasNext()) goto _L5; else goto _L4
_L4:
        VineTag vinetag3 = (VineTag)((Iterator) (obj2)).next();
        collection.clear();
        fillTagValues(collection, vinetag3);
          goto _L6
_L5:
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        l = k;
_L3:
        k = ((flag) ? 1 : 0);
        if (((HashMap) (obj1)).isEmpty()) goto _L8; else goto _L7
_L7:
        ((SQLiteDatabase) (obj)).beginTransaction();
        collection = new ContentValues();
        obj1 = ((HashMap) (obj1)).values().iterator();
        k = i1;
_L10:
        if (!((Iterator) (obj1)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        VineTag vinetag = (VineTag)((Iterator) (obj1)).next();
        collection.clear();
        fillTagValues(collection, vinetag);
        i1 = ((SQLiteDatabase) (obj)).update("tag_search_results", collection, "tag_id=?", new String[] {
            String.valueOf(vinetag.tagId)
        });
        if (i1 > 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        k += i1;
        if (true) goto _L10; else goto _L9
        collection;
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        throw collection;
_L9:
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        safeFinishTransaction(((SQLiteDatabase) (obj)));
          goto _L8
_L14:
        savePageCursor(4, 0, null, i, j, 0L, true);
_L15:
        mContentResolver.notifyChange(Vine.TagSearchResults.CONTENT_URI, null);
_L13:
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Inserted ").append(l).append(" and updated ").append(k).append(" tags.").toString());
        }
        this;
        JVM INSTR monitorexit ;
        return l;
        collection;
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        throw collection;
_L6:
        if (((SQLiteDatabase) (obj)).insert("tag_search_results", "tag_id", collection) > 0L)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        k += l;
          goto _L11
_L8:
        if (l <= 0 && k <= 0) goto _L13; else goto _L12
_L12:
        if (i <= 0 && j <= 0) goto _L15; else goto _L14
    }

    public Uri mergeSuggestedTag(VineTag vinetag)
    {
        this;
        JVM INSTR monitorenter ;
        Uri uri;
        Object obj;
        uri = null;
        obj = null;
        Cursor cursor;
        long l = vinetag.tagId;
        cursor = mContentResolver.query(Vine.TagsRecentlyUsed.CONTENT_URI, VineDatabaseSQL.TagsRecentlyUsedQuery.PROJECTION, "tag_id=?", new String[] {
            String.valueOf(l)
        }, "_id DESC");
        if (cursor == null) goto _L2; else goto _L1
_L1:
        ContentValues contentvalues = new ContentValues();
        if (cursor.getCount() >= 1) goto _L4; else goto _L3
_L3:
        fillTagValues(contentvalues, vinetag);
        uri = mContentResolver.insert(Vine.TagsRecentlyUsed.CONTENT_URI_PUT_TAG, contentvalues);
_L6:
        cursor.close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return uri;
_L4:
        uri = obj;
        if (!cursor.moveToFirst()) goto _L6; else goto _L5
_L5:
        long l1 = vinetag.tagId;
        contentvalues.put("last_used_timestamp", Long.valueOf(System.currentTimeMillis()));
        mContentResolver.update(Vine.TagsRecentlyUsed.CONTENT_URI_UPDATE_RECENT_TAG, contentvalues, "tag_id=?", new String[] {
            String.valueOf(l1)
        });
        uri = obj;
          goto _L6
        vinetag;
        throw vinetag;
    }

    public long mergeUserAndGetResultingRowId(VineUser vineuser)
    {
        ContentValues contentvalues;
        SQLiteDatabase sqlitedatabase;
        contentvalues = new ContentValues();
        fillUserContentValues(contentvalues, vineuser, System.currentTimeMillis());
        sqlitedatabase = getWritableDatabase();
        long l = vineuser.userId;
        vineuser = sqlitedatabase.query("users", new String[] {
            "_id"
        }, "user_id=?", new String[] {
            String.valueOf(l)
        }, null, null, null);
        if (vineuser == null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        long l1;
        if (!vineuser.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_119;
        }
        l1 = vineuser.getLong(0);
        sqlitedatabase.update("users", contentvalues, "_id=?", new String[] {
            String.valueOf(l1)
        });
        vineuser.close();
        return l1;
        vineuser.close();
        return sqlitedatabase.insertOrThrow("users", null, contentvalues);
        Exception exception;
        exception;
        vineuser.close();
        throw exception;
    }

    public int mergeUsers(Collection collection, int i, String s, int j, int k, LongSparseArray longsparsearray)
    {
        this;
        JVM INSTR monitorenter ;
        i = mergeUsers(collection, i, s, j, k, null, longsparsearray);
        this;
        JVM INSTR monitorexit ;
        return i;
        collection;
        throw collection;
    }

    public int mergeUsers(Collection collection, int i, String s, int j, int k, LongSparseArray longsparsearray, long l, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        i = mergeUsers(collection, i, s, j, k, null, longsparsearray, l, i1);
        this;
        JVM INSTR monitorexit ;
        return i;
        collection;
        throw collection;
    }

    public int mergeUsers(Collection collection, int i, String s, int j, int k, LongSparseArray longsparsearray, LongSparseArray longsparsearray1)
    {
        this;
        JVM INSTR monitorenter ;
        i = mergeUsers(collection, i, s, j, k, longsparsearray, longsparsearray1, -1L, -1);
        this;
        JVM INSTR monitorexit ;
        return i;
        collection;
        throw collection;
    }

    public int mergeUsers(Collection collection, int i, String s, int j, int k, LongSparseArray longsparsearray, LongSparseArray longsparsearray1, 
            long l, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        Object obj;
        LongSparseArray longsparsearray2;
        sqlitedatabase = getWritableDatabase();
        longsparsearray2 = new LongSparseArray(collection.size());
        obj = new LongSparseArray(collection.size());
        VineUser vineuser;
        for (Iterator iterator = collection.iterator(); iterator.hasNext(); longsparsearray2.put(vineuser.userId, vineuser))
        {
            vineuser = (VineUser)iterator.next();
        }

        break MISSING_BLOCK_LABEL_88;
        collection;
        throw collection;
        Object obj2 = sqlitedatabase.query("users", new String[] {
            "user_id"
        }, null, null, null, null, null);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_183;
        }
_L1:
        VineUser vineuser1;
        long l2;
        do
        {
            if (!((Cursor) (obj2)).moveToNext())
            {
                break MISSING_BLOCK_LABEL_176;
            }
            l2 = ((Cursor) (obj2)).getLong(0);
            vineuser1 = (VineUser)longsparsearray2.removeKey(l2);
        } while (vineuser1 == null);
        ((LongSparseArray) (obj)).put(l2, vineuser1);
          goto _L1
        collection;
        ((Cursor) (obj2)).close();
        throw collection;
        ((Cursor) (obj2)).close();
        int j1;
        int k1;
        int i2;
        boolean flag;
        k1 = 0;
        j1 = 0;
        flag = false;
        i2 = 0;
        int j2;
        l2 = System.currentTimeMillis();
        j2 = longsparsearray2.size();
        if (j2 <= 0)
        {
            break MISSING_BLOCK_LABEL_328;
        }
        sqlitedatabase.beginTransaction();
        obj2 = new ContentValues();
        k1 = 0;
_L3:
        if (k1 >= j2)
        {
            break; /* Loop/switch isn't completed */
        }
        vineuser1 = (VineUser)longsparsearray2.valueAt(k1);
        ((ContentValues) (obj2)).clear();
        fillUserContentValues(((ContentValues) (obj2)), vineuser1, l2);
        Object obj1;
        int l1;
        int k2;
        if (sqlitedatabase.insert("users", "user_id", ((ContentValues) (obj2))) > 0L)
        {
            l1 = 1;
        } else
        {
            l1 = 0;
        }
        j1 += l1;
        mergetUserSection(sqlitedatabase, ((ContentValues) (obj2)), vineuser1, l, i1);
        k1++;
        if (true) goto _L3; else goto _L2
_L2:
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        k1 = j1;
        k2 = ((LongSparseArray) (obj)).size();
        j1 = ((flag) ? 1 : 0);
        if (k2 <= 0)
        {
            break MISSING_BLOCK_LABEL_489;
        }
        sqlitedatabase.beginTransaction();
        obj1 = new ContentValues();
        l1 = 0;
        j1 = i2;
_L5:
        if (l1 >= k2)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = (VineUser)((LongSparseArray) (obj)).valueAt(l1);
        ((ContentValues) (obj1)).clear();
        fillUserContentValues(((ContentValues) (obj1)), ((VineUser) (obj2)), l2);
        if (sqlitedatabase.update("users", ((ContentValues) (obj1)), "user_id=?", new String[] {
    String.valueOf(((VineUser) (obj2)).userId)
}) > 0)
        {
            i2 = 1;
        } else
        {
            i2 = 0;
        }
        j1 += i2;
        mergetUserSection(sqlitedatabase, ((ContentValues) (obj1)), ((VineUser) (obj2)), l, i1);
        l1++;
        if (true) goto _L5; else goto _L4
        collection;
        safeFinishTransaction(sqlitedatabase);
        throw collection;
_L4:
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        i2 = 0;
        flag = false;
        k2 = 0;
        l1 = 0;
        i1 = k2;
        if (k1 <= 0) goto _L7; else goto _L6
_L6:
        obj = sqlitedatabase.query("users", VineDatabaseSQL.TableQuery.PROJECTION, null, null, null, null, null);
        i1 = k2;
        if (obj == null) goto _L7; else goto _L8
_L8:
        i1 = ((flag) ? 1 : 0);
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_760;
        }
        k2 = ((Cursor) (obj)).getCount();
        i1 = ((flag) ? 1 : 0);
        if (k2 <= 10000)
        {
            break MISSING_BLOCK_LABEL_760;
        }
        obj1 = sqlitedatabase.rawQuery("SELECT last_refresh FROM users ORDER BY last_refresh DESC LIMIT 1 OFFSET 5000", null);
        sqlitedatabase.beginTransaction();
        i1 = i2;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_749;
        }
        i1 = l1;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_742;
        }
        l = ((Cursor) (obj1)).getLong(0);
        sqlitedatabase.execSQL("DELETE FROM user_groups WHERE user_id IN (SELECT user_id FROM users WHERE last_refresh < ?);", new String[] {
            String.valueOf(l)
        });
        l1 = sqlitedatabase.delete("users", "last_refresh<?", new String[] {
            String.valueOf(l)
        });
        i1 = l1;
        if (!LOGGABLE)
        {
            break MISSING_BLOCK_LABEL_742;
        }
        Log.d("s", (new StringBuilder()).append("Due to reaching maximum table size (").append(k2).append(" with a max of ").append(10000).append("), deleted ").append(l1).append(" users, all less than last refresh of ").append(l).toString());
        i1 = l1;
        ((Cursor) (obj1)).close();
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        ((Cursor) (obj)).close();
          goto _L7
_L9:
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_810;
        }
        mergeUserGroups(collection, i, s, longsparsearray, longsparsearray1);
        if (j <= 0 && k <= 0)
        {
            break MISSING_BLOCK_LABEL_810;
        }
        savePageCursor(1, i, s, j, k, 0L, true);
        mContentResolver.notifyChange(Vine.UserGroupsView.CONTENT_URI, null);
        mContentResolver.notifyChange(Vine.UserGroupsView.CONTENT_URI_FIND_FRIENDS_TWITTER, null);
        mContentResolver.notifyChange(Vine.UserGroupsView.CONTENT_URI_FIND_FRIENDS_ADDRESS, null);
        mContentResolver.notifyChange(Vine.UserGroupsView.CONTENT_URI_LIKERS, null);
        mContentResolver.notifyChange(Vine.UserGroupsView.CONTENT_URI_FOLLOWERS, null);
        mContentResolver.notifyChange(Vine.UserGroupsView.CONTENT_URI_FOLLOWING, null);
        mContentResolver.notifyChange(Vine.UserGroupsView.CONTENT_URI_FRIENDS, null);
        mContentResolver.notifyChange(Vine.UserGroupsView.CONTENT_URI_USER_SEARCH_RESULTS, null);
_L10:
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Inserted ").append(k1).append(" new users and updating ").append(j1).append(" of type ").append(i).append(".").toString());
        }
        this;
        JVM INSTR monitorexit ;
        return k1;
        collection;
        safeFinishTransaction(sqlitedatabase);
        throw collection;
        collection;
        ((Cursor) (obj1)).close();
        throw collection;
        collection;
        safeFinishTransaction(sqlitedatabase);
        throw collection;
        collection;
        ((Cursor) (obj)).close();
        throw collection;
_L7:
        if (k1 <= 0 && j1 <= 0 && i1 <= 0) goto _L10; else goto _L9
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        createTables(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Upgrading from ").append(i).append(" to ").append(j).toString());
        }
        dropTables(sqlitedatabase);
        createTables(sqlitedatabase);
    }

    public void permaDeleteMessageFromRowId(long l)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        (new ContentValues()).put("deleted", Integer.valueOf(1));
        if (sqlitedatabase.delete("messages", "_id=?", new String[] {
    String.valueOf(l)
}) > 0)
        {
            notifyVMUris();
        }
    }

    public void removeAccount()
    {
        setValue("current_account", ((String) (null)));
        setValue("current_user_id", 0L);
        setValue("current_name", ((String) (null)));
    }

    public int removeFollow(long l, boolean flag, boolean flag1)
    {
        this;
        JVM INSTR monitorenter ;
        Cursor cursor;
        SQLiteDatabase sqlitedatabase;
        String as[];
        sqlitedatabase = getWritableDatabase();
        as = new String[1];
        as[0] = String.valueOf(l);
        cursor = sqlitedatabase.query("users", new String[] {
            "following_flag"
        }, "user_id=?", as, null, null, null);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (!cursor.moveToFirst()) goto _L4; else goto _L3
_L3:
        int i;
        i = Friendships.unsetFriendship(cursor.getInt(0), 1);
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("following_flag", Integer.valueOf(i));
        i = sqlitedatabase.update("users", contentvalues, "user_id=?", as);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        removeUserWithType(l, 1, flag1, Vine.UserGroupsView.CONTENT_URI_FOLLOWING);
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Unfollowed user ").append(l).toString());
        }
        cursor.close();
_L6:
        this;
        JVM INSTR monitorexit ;
        return i;
_L4:
        cursor.close();
          goto _L2
        Exception exception1;
        exception1;
        cursor.close();
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        i = -1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int removeLike(long l, long l1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        int i;
        int j;
        i = 0;
        j = 0;
        Cursor cursor;
        String as[];
        sqlitedatabase.beginTransaction();
        as = new String[1];
        as[0] = String.valueOf(l);
        cursor = sqlitedatabase.query("posts", new String[] {
            "metadata_flags"
        }, "post_id=?", as, null, null, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        i = j;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_168;
        }
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("metadata_flags", Integer.valueOf(cursor.getInt(0) & -9));
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Removing like in post: ").append(l).toString());
        }
        i = sqlitedatabase.update("posts", contentvalues, "post_id=?", as);
        int k;
        if (i > 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        cursor.close();
        j = sqlitedatabase.delete("likes", "post_id=? AND user_id=?", new String[] {
            String.valueOf(l), String.valueOf(l1)
        });
        k = removePostsFromGroupByPostId(3, l);
        sqlitedatabase.setTransactionSuccessful();
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Deleted self like for post: ").append(l).toString());
        }
        safeFinishTransaction(sqlitedatabase);
        if (!flag || i <= 0 && j + k <= 0)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        notifyPostCommentsViewUris();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception2;
        exception2;
        cursor.close();
        throw exception2;
        Exception exception1;
        exception1;
        safeFinishTransaction(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void removeNotificationForConversation(long l)
    {
        getWritableDatabase().delete("notifications", "conversation_row_id=?", new String[] {
            String.valueOf(l)
        });
    }

    public void removeNotificationsForNotificationId(int i)
    {
        getWritableDatabase().delete("notifications", "notification_id=?", new String[] {
            String.valueOf(i)
        });
    }

    public void removePostsByReposterId(long l)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        i = getWritableDatabase().delete("post_groups", "reposter_id=? AND post_type =?", new String[] {
            String.valueOf(l), String.valueOf(1)
        });
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Deleted ").append(i).append(" posts with reposterId=").append(l).toString());
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        mContentResolver.notifyChange(Vine.PostGroupsView.CONTENT_URI, null);
        mContentResolver.notifyChange(Vine.PostCommentsLikesView.CONTENT_URI, null);
        mContentResolver.notifyChange(Vine.PostCommentsLikesView.CONTENT_URI_ALL_TIMELINE, null);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int removePostsFromGroupByUser(long l, int i, String s)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        ArrayList arraylist;
        Cursor cursor;
        sqlitedatabase = getWritableDatabase();
        cursor = sqlitedatabase.query("post_groups_view", VineDatabaseSQL.PostGroupsQuery.PROJECTION, "user_id=? AND post_type=? AND tag=?", new String[] {
            String.valueOf(l), String.valueOf(i), s
        }, null, null, null);
        arraylist = new ArrayList();
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        boolean flag;
        if (cursor.moveToFirst())
        {
            do
            {
                arraylist.add(String.valueOf(cursor.getLong(0)));
                flag = cursor.moveToNext();
            } while (flag);
        }
        cursor.close();
        Object obj;
        int k;
        obj = new StringBuilder();
        k = arraylist.size();
        int j = 0;
_L2:
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        ((StringBuilder) (obj)).append("?");
        if (j >= k - 1 || k == 1)
        {
            break MISSING_BLOCK_LABEL_408;
        }
        ((StringBuilder) (obj)).append(",");
        break MISSING_BLOCK_LABEL_408;
        s;
        cursor.close();
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        sqlitedatabase.beginTransaction();
        String as[] = new String[arraylist.size()];
        arraylist.add(String.valueOf(i));
        obj = (new StringBuilder()).append(" IN (").append(((StringBuilder) (obj)).toString()).append(") AND ").append("post_type").append("=?").toString();
        j = sqlitedatabase.delete("post_groups", (new StringBuilder()).append("post_id").append(((String) (obj))).toString(), (String[])arraylist.toArray(as));
        sqlitedatabase.setTransactionSuccessful();
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Due to unfollowing ").append(l).append(" deleting ").append(j).append(" groups ").append(" , of type ").append(i).append(" and tag ").append(s).toString());
        }
        safeFinishTransaction(sqlitedatabase);
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_392;
        }
        notifyPostCommentsViewUris();
        this;
        JVM INSTR monitorexit ;
        return j;
        s;
        safeFinishTransaction(sqlitedatabase);
        throw s;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void removeUserSectionsWithType(int i)
    {
        getWritableDatabase().delete("user_sections", "section_type=?", new String[] {
            String.valueOf(i)
        });
    }

    public boolean removeUserWithType(long l, int i, boolean flag, Uri uri)
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        if (getWritableDatabase().delete("user_groups", "type=? AND user_id=?", new String[] {
            String.valueOf(i), String.valueOf(l)
        }) <= 0) goto _L2; else goto _L1
_L1:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        mContentResolver.notifyChange(uri, null);
        flag = flag1;
        if (!LOGGABLE)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        Log.d("VineDH", (new StringBuilder()).append("Deleted user with userId=").append(l).append(" of type=").append(i).toString());
        flag = flag1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        uri;
        throw uri;
    }

    public void removeUsersByGroup(int i)
    {
        this;
        JVM INSTR monitorenter ;
        int j = getWritableDatabase().delete("user_groups", "type=?", new String[] {
            String.valueOf(i)
        });
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Deleted ").append(j).append(" users of type ").append(i).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int revine(VineRepost vinerepost, long l, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        int i;
        boolean flag1;
        i = 0;
        flag1 = false;
        Object obj;
        String as[];
        sqlitedatabase.beginTransaction();
        as = new String[1];
        as[0] = String.valueOf(vinerepost.postId);
        obj = sqlitedatabase.query("posts", new String[] {
            "metadata_flags"
        }, "post_id=?", as, null, null, null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        i = ((flag1) ? 1 : 0);
        if (((Cursor) (obj)).getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_210;
        }
        i = ((flag1) ? 1 : 0);
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_210;
        }
        ContentValues contentvalues1 = new ContentValues();
        contentvalues1.put("metadata_flags", Integer.valueOf(((Cursor) (obj)).getInt(0) | 0x10));
        contentvalues1.put("my_repost_id", Long.valueOf(vinerepost.repostId));
        ((Cursor) (obj)).close();
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Revined post ").append(vinerepost.postId).toString());
        }
        i = sqlitedatabase.update("posts", contentvalues1, "post_id=?", as);
        Cursor cursor;
        if (i > 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        ((Cursor) (obj)).close();
        long l1 = vinerepost.postId;
        cursor = sqlitedatabase.query("post_groups", new String[] {
            "repost_data"
        }, "post_id=? AND post_type=? AND tag=?", new String[] {
            String.valueOf(l1), String.valueOf(2), String.valueOf(l)
        }, null, null, null);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (cursor.getCount() <= 0 || !cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_572;
        }
        obj = (VineRepost)Util.fromByteArray(cursor.getBlob(0));
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj.repostId = vinerepost.repostId;
_L5:
        ContentValues contentvalues2 = new ContentValues();
        contentvalues2.put("repost_data", Util.toByteArray(obj));
        contentvalues2.put("sort_id", Long.valueOf(vinerepost.repostId));
        sqlitedatabase.update("post_groups", contentvalues2, "post_id=? AND post_type=? AND tag=?", new String[] {
            String.valueOf(vinerepost.postId), String.valueOf(2), String.valueOf(l)
        });
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Updated repost data for post ").append(((VineRepost) (obj)).postId).append(" with repost id ").append(((VineRepost) (obj)).repostId).append(" for user timeline.").toString());
        }
_L6:
        cursor.close();
_L2:
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        if (!flag || i <= 0)
        {
            break MISSING_BLOCK_LABEL_497;
        }
        notifyPostCommentsViewUris();
        this;
        JVM INSTR monitorexit ;
        return i;
        vinerepost;
        ((Cursor) (obj)).close();
        throw vinerepost;
        vinerepost;
        safeFinishTransaction(sqlitedatabase);
        throw vinerepost;
        vinerepost;
        this;
        JVM INSTR monitorexit ;
        throw vinerepost;
_L4:
        obj = new VineRepost();
        obj.repostId = vinerepost.repostId;
        obj.postId = vinerepost.postId;
          goto _L5
        vinerepost;
        cursor.close();
        throw vinerepost;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("post_type", Integer.valueOf(2));
        contentvalues.put("post_id", Long.valueOf(vinerepost.postId));
        contentvalues.put("sort_id", Long.valueOf(vinerepost.repostId));
        contentvalues.put("tag", Long.valueOf(l));
        contentvalues.put("repost_data", Util.toByteArray(vinerepost));
        sqlitedatabase.insert("post_groups", "post_id", contentvalues);
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Inserted repost data for post ").append(vinerepost.postId).append(" with repost id ").append(vinerepost.repostId).append(" for user timeline.").toString());
        }
          goto _L6
    }

    public void safeFinishTransaction(SQLiteDatabase sqlitedatabase)
    {
        if (!sqlitedatabase.inTransaction())
        {
            break MISSING_BLOCK_LABEL_11;
        }
        sqlitedatabase.endTransaction();
_L1:
        return;
        sqlitedatabase;
        throw sqlitedatabase;
        SQLiteFullException sqlitefullexception;
        sqlitefullexception;
        long l = -1L;
        long l1 = Util.getCacheSize(mAppContext);
        l = l1;
_L2:
        AppController.clearFileCache(mAppContext);
        VineLoggingException vineloggingexception1;
        try
        {
            CrashUtil.logException(new VineLoggingException(), "Db full, cleaned cache from {} to {}.", new Object[] {
                Long.valueOf(l), Long.valueOf(Util.getCacheSize(mAppContext))
            });
        }
        catch (VineLoggingException vineloggingexception)
        {
            CrashUtil.logException(new VineLoggingException(), "Db full, cleaned cache from {} to unknown.", new Object[] {
                Long.valueOf(l)
            });
        }
        if (sqlitedatabase.inTransaction())
        {
            sqlitedatabase.endTransaction();
            return;
        }
          goto _L1
        vineloggingexception1;
        CrashUtil.logException(sqlitefullexception);
          goto _L2
        sqlitedatabase;
        if (sqlitedatabase.getMessage().contains("(code 1)")) goto _L1; else goto _L3
_L3:
        throw sqlitedatabase;
        sqlitedatabase;
        if (!sqlitedatabase.getMessage().contains("already-closed"))
        {
            throw sqlitedatabase;
        }
          goto _L1
    }

    public int savePageCursor(int i, int j, String s, int k, int l, long l1, 
            boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        String s1;
        s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        String as[];
        as = new String[3];
        as[0] = String.valueOf(i);
        as[1] = String.valueOf(j);
        as[2] = s1;
        ContentValues contentvalues;
        s = sqlitedatabase.query("page_cursors", VineDatabaseSQL.PageCursorsQuery.PROJECTION, "kind=? AND type=? AND tag=?", as, null, null, null);
        contentvalues = new ContentValues();
        contentvalues.put("kind", Integer.valueOf(i));
        contentvalues.put("type", Integer.valueOf(j));
        contentvalues.put("tag", s1);
        contentvalues.put("next_page", Integer.valueOf(k));
        contentvalues.put("previous_page", Integer.valueOf(l));
        contentvalues.put("anchor", Long.valueOf(l1));
        contentvalues.put("reversed", Boolean.valueOf(flag));
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.getCount() != 1) goto _L4; else goto _L3
_L3:
        int i1 = sqlitedatabase.update("page_cursors", contentvalues, "kind=? AND type=? AND tag=?", as);
        if (i1 > 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        i1 = 0 + i1;
_L5:
        s.close();
_L6:
        if (!LOGGABLE || i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_316;
        }
        Log.d("VineDH", (new StringBuilder()).append("Saved pagecursor of kind: ").append(i).append(" type: ").append(j).append(" tag: ").append(s1).append(" next:").append(k).append(" prev: ").append(l).append(" anchor: ").append(l1).append(" reverse: ").append(flag).toString());
        this;
        JVM INSTR monitorexit ;
        return i1;
_L4:
        long l2 = sqlitedatabase.insert("page_cursors", "_id", contentvalues);
        if (l2 > 0L)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        i1 = 0 + i1;
          goto _L5
        Exception exception;
        exception;
        s.close();
        throw exception;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        l2 = sqlitedatabase.insert("page_cursors", "_id", contentvalues);
        if (l2 > 0L)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        i1 = 0 + i1;
          goto _L6
    }

    public int saveUserValue(String s, ContentValues contentvalues)
    {
        int i = 0;
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase.update("settings", contentvalues, "name=?", new String[] {
            s
        }) != 0) goto _L2; else goto _L1
_L1:
        long l;
        contentvalues.put("name", s);
        l = sqlitedatabase.insert("settings", "name", contentvalues);
        if (l != 0L) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        if (mContentResolver == null)
        {
            mContentResolver = mAppContext.getContentResolver();
        }
        mContentResolver.notifyChange(Vine.Settings.CONTENT_URI, null);
        i = 1;
        if (true) goto _L3; else goto _L4
_L4:
        s;
        throw s;
    }

    public void setConversationHidden(long l, boolean flag)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("is_hidden", Integer.valueOf(i));
        i = sqlitedatabase.update("conversations", contentvalues, "_id=?", new String[] {
            String.valueOf(l)
        });
        Log.d("VineDH", (new StringBuilder()).append("Marked conversation ").append(l).append(" hidden value ").append(flag).append(" updated rows: ").append(i).toString());
    }

    public void setMessageError(long l, int i, String s)
    {
        if (l > 0L)
        {
            SQLiteDatabase sqlitedatabase = getWritableDatabase();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("error_code", Integer.valueOf(i));
            contentvalues.put("error_reason", s);
            if (sqlitedatabase.update("messages", contentvalues, "_id=?", new String[] {
    String.valueOf(l)
}) > 0)
            {
                notifyVMUris();
            }
        }
    }

    public void setMessageError(String s, int i, String s1)
    {
        if (!TextUtils.isEmpty(s))
        {
            SQLiteDatabase sqlitedatabase = getWritableDatabase();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("error_code", Integer.valueOf(i));
            contentvalues.put("error_reason", s1);
            if (sqlitedatabase.update("messages", contentvalues, "upload_path=?", new String[] {
    s
}) > 0)
            {
                notifyVMUris();
            }
        }
    }

    public boolean setShouldHideProfileRevines(long l, boolean flag)
    {
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("hide_profile_reposts", Integer.valueOf(i));
        sqlitedatabase.beginTransaction();
        i = sqlitedatabase.update("users", contentvalues, "user_id=?", new String[] {
            String.valueOf(l)
        });
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        Exception exception;
        return i > 0;
        exception;
        safeFinishTransaction(sqlitedatabase);
        throw exception;
    }

    public boolean shouldHideProfileRevines(long l)
    {
        Object obj;
        boolean flag;
        obj = getReadableDatabase();
        flag = false;
        boolean flag1 = false;
        obj = ((SQLiteDatabase) (obj)).query("users", new String[] {
            "hide_profile_reposts"
        }, "user_id=?", new String[] {
            String.valueOf(l)
        }, null, null, null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        flag = flag1;
        int i;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_80;
        }
        i = ((Cursor) (obj)).getInt(0);
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((Cursor) (obj)).close();
        return flag;
        Exception exception;
        exception;
        ((Cursor) (obj)).close();
        throw exception;
    }

    public int unRevine(long l, long l1, boolean flag, boolean flag1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = getWritableDatabase();
        int i;
        int j;
        i = 0;
        j = 0;
        Object obj1;
        String as[];
        ((SQLiteDatabase) (obj)).beginTransaction();
        as = new String[1];
        as[0] = String.valueOf(l);
        obj1 = ((SQLiteDatabase) (obj)).query("posts", new String[] {
            "metadata_flags"
        }, "post_id=?", as, null, null, null);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        i = j;
        if (((Cursor) (obj1)).getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        i = j;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_194;
        }
        ContentValues contentvalues1 = new ContentValues();
        contentvalues1.put("metadata_flags", Integer.valueOf(((Cursor) (obj1)).getInt(0) & 0xffffffef));
        contentvalues1.put("my_repost_id", Integer.valueOf(0));
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Unrevined post ").append(l).toString());
        }
        i = ((SQLiteDatabase) (obj)).update("posts", contentvalues1, "post_id=?", as);
        boolean flag2;
        if (i > 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        ((Cursor) (obj1)).close();
        j = ((SQLiteDatabase) (obj)).delete("post_groups", "post_id=? AND post_type=? AND tag=?", new String[] {
            String.valueOf(l), String.valueOf(2), String.valueOf(l1)
        });
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Deleted ").append(j).append(" with tag ").append(l1).append(" and type ").append(2).append(" and post id ").append(l).append(" due to unrevining.").toString());
        }
        flag2 = flag;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_401;
        }
        obj1 = ((SQLiteDatabase) (obj)).query("posts", new String[] {
            "user_id"
        }, "post_id=?", new String[] {
            String.valueOf(l)
        }, null, null, null);
        flag2 = flag;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_401;
        }
        if (((Cursor) (obj1)).moveToFirst())
        {
            flag = amFollowingUser(getUserRowIdForUserRemoteId(((Cursor) (obj1)).getLong(0)));
        }
        ((Cursor) (obj1)).close();
        flag2 = flag;
        if (flag2)
        {
            break MISSING_BLOCK_LABEL_572;
        }
        int i1 = ((SQLiteDatabase) (obj)).delete("post_groups", "post_id=? AND post_type=?", new String[] {
            String.valueOf(l), String.valueOf(1)
        });
        if (LOGGABLE)
        {
            Log.d("VineDH", (new StringBuilder()).append("Deleted ").append(j + i1).append(" for type ").append(1).append(" and post id ").append(l).append(" due to unrevining.").toString());
        }
_L1:
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_519;
        }
        notifyPostCommentsViewUris();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        ((Cursor) (obj1)).close();
        throw exception;
        obj1;
        safeFinishTransaction(((SQLiteDatabase) (obj)));
        throw obj1;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        exception;
        ((Cursor) (obj1)).close();
        throw exception;
        ContentValues contentvalues = new ContentValues();
        contentvalues.putNull("repost_data");
        int k = ((SQLiteDatabase) (obj)).update("post_groups", contentvalues, "post_id=? AND post_type=?", new String[] {
            String.valueOf(l), String.valueOf(1)
        });
        Log.d("VineDH", (new StringBuilder()).append("Removed   ").append(k).append(" repost data for type ").append(1).append(" and post id ").append(l).append(" due to unrevining.").toString());
          goto _L1
    }

    public void updateConversationWithLastMessage(long l, long l1, long l2)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        int i;
        sqlitedatabase.beginTransaction();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("last_message", Long.valueOf(l1));
        contentvalues.put("last_message_timestamp", Long.valueOf(l2));
        i = sqlitedatabase.update("conversations", contentvalues, "_id=? ", new String[] {
            String.valueOf(l)
        });
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        mContentResolver.notifyChange(Vine.InboxView.CONTENT_URI, null);
        mContentResolver.notifyChange(Vine.Conversations.CONTENT_URI, null);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        safeFinishTransaction(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void updateMessageLoopStartTime(long l, long l1)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = getWritableDatabase();
        sqlitedatabase.beginTransaction();
        int i;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("local_start_time", Long.valueOf(l));
        i = sqlitedatabase.update("messages", contentvalues, "message_id=?", new String[] {
            String.valueOf(l1)
        });
        if (!SLog.sLogsOn)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        if (i != 1)
        {
            flag = false;
        }
        SLog.d("Updated {} local start time to {} ? {}.", Long.valueOf(l1), Long.valueOf(l), Boolean.valueOf(flag));
        sqlitedatabase.setTransactionSuccessful();
        safeFinishTransaction(sqlitedatabase);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        safeFinishTransaction(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void updateUserFollowingFlag(long l, boolean flag)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("following_flag", Integer.valueOf(i));
        sqlitedatabase.update("users", contentvalues, "user_id=?", new String[] {
            String.valueOf(l)
        });
    }

    static 
    {
        boolean flag;
        if (BuildUtil.isLogsOn() || Log.isLoggable("VineDH", 3))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        LOGGABLE = flag;
    }
}
