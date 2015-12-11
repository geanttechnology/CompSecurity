// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;

// Referenced classes of package co.vine.android.provider:
//            Vine, VineDatabaseHelper, HybridPostCursorExplore, HybridPostCursor

public class VineProvider extends ContentProvider
{

    private static final int ACTIVITY = 33;
    private static final int ACTIVITY_WITH_FOLLOW_REQUESTS = 34;
    private static final int ACTIVITY_WITH_FOLLOW_REQUESTS_ALL = 35;
    private static final int CHANNELS = 8;
    private static final int COMMENTS = 4;
    private static final int CONVERSATION = 118;
    private static final int CONVERSATION_MESSAGE_USER = 113;
    private static final int CONVERSATION_RECIPIENTS = 114;
    private static final int CONVERSATION_RECIPIENTS_USERS_VIEW = 120;
    private static final int CONVERSATION_SINGLE = 119;
    private static final int EDITIONS = 401;
    private static final int FILTER_VINE_FRIENDS = 117;
    private static final int HIDE_PROFILE_REPOSTS = 116;
    private static final int INBOX = 115;
    private static final int LIKES = 5;
    private static final boolean LOGGABLE;
    private static final int MESSAGES = 111;
    private static final int MESSAGES_SINGLE = 112;
    private static final int NOTIFICATIONS = 109;
    private static final int POSTS = 6;
    private static final int POST_GROUPS_VIEW_ALL_TIMELINE = 23;
    private static final int POST_GROUPS_VIEW_ALL_TIMELINE_ON_THE_RISE = 26;
    private static final int POST_GROUPS_VIEW_ALL_TIMELINE_POPULAR_NOW = 27;
    private static final int POST_GROUPS_VIEW_ALL_TIMELINE_SINGLE = 29;
    private static final int POST_GROUPS_VIEW_ALL_TIMELINE_TAG = 28;
    private static final int POST_GROUPS_VIEW_ALL_TIMELINE_USER = 24;
    private static final int POST_GROUPS_VIEW_ALL_TIMELINE_USER_LIKES = 25;
    private static final int POST_GROUPS_VIEW_ARBITRARY_TIMELINE = 32;
    private static final int POST_GROUPS_VIEW_TIMELINE = 20;
    private static final int POST_GROUPS_VIEW_TIMELINE_CHANNEL_POPULAR = 30;
    private static final int POST_GROUPS_VIEW_TIMELINE_CHANNEL_RECENT = 31;
    private static final int POST_GROUPS_VIEW_TIMELINE_USER = 21;
    private static final int POST_GROUPS_VIEW_TIMELINE_USER_LIKES = 22;
    private static final int PUT_RECENT_TAG = 301;
    private static final int RECENT_TAG = 110;
    private static final int SETTINGS = 3;
    private static final String TAG = "VineProvider";
    private static final int TAG_SEARCH_RESULTS = 7;
    private static final int UPDATE_RECENT_TAG = 501;
    private static final int USER = 1;
    private static final int USER_GROUPS_VIEW_ALL_FOLLOW = 102;
    private static final int USER_GROUPS_VIEW_FIND_FRIENDS_ADDRESS = 104;
    private static final int USER_GROUPS_VIEW_FIND_FRIENDS_TWITTER = 105;
    private static final int USER_GROUPS_VIEW_FOLLOWERS = 101;
    private static final int USER_GROUPS_VIEW_FOLLOWING = 100;
    private static final int USER_GROUPS_VIEW_FRIENDS = 103;
    private static final int USER_GROUPS_VIEW_LIKERS = 106;
    private static final int USER_GROUPS_VIEW_REVINERS = 108;
    private static final int USER_GROUPS_VIEW_USER_SEARCH_RESULTS = 107;
    private static final int USER_ID = 2;
    private static final UriMatcher sUriMatcher;

    public VineProvider()
    {
    }

    public int delete(Uri uri, String s, String as[])
    {
        return 0;
    }

    public String getType(Uri uri)
    {
        switch (sUriMatcher.match(uri))
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown URL ").append(uri).toString());

        case 1: // '\001'
            return "vnd.android.cursor.dir/vnd.vine.android.users";

        case 2: // '\002'
            return "vnd.android.cursor.item/vnd.vine.android.users";

        case 3: // '\003'
            return "vnd.android.cursor.item/vnd.vine.android.settings";

        case 100: // 'd'
        case 101: // 'e'
            return "vnd.android.cursor.dir/vnd.vine.android.users.groups";
        }
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        Uri uri1;
        String s;
        SQLiteDatabase sqlitedatabase;
        long l;
        uri1 = null;
        sqlitedatabase = VineDatabaseHelper.getDatabaseHelper(getContext()).getWritableDatabase();
        if (LOGGABLE)
        {
            Log.d("VineProvider", (new StringBuilder()).append("INSERT: uri ").append(uri).append(" -> ").append(sUriMatcher.match(uri)).toString());
        }
        l = -1L;
        s = "";
        sUriMatcher.match(uri);
        JVM INSTR tableswitch 301 301: default 96
    //                   301 120;
           goto _L1 _L2
_L1:
        contentvalues = s;
_L4:
        if (l >= 0L)
        {
            uri1 = uri.buildUpon().appendPath(contentvalues).build();
        }
        return uri1;
_L2:
        String s1 = contentvalues.getAsString("tag_id");
        long l1 = sqlitedatabase.insert("tag_recently_used", null, contentvalues);
        contentvalues = s1;
        l = l1;
        if (LOGGABLE)
        {
            Log.d("VineProvider", (new StringBuilder()).append("Tag inserted to recently-used with rowId=").append(l1).toString());
            contentvalues = s1;
            l = l1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onCreate()
    {
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        Object obj;
        String s2;
        SQLiteDatabase sqlitedatabase;
        String s3;
        SQLiteQueryBuilder sqlitequerybuilder;
        int j;
        s3 = uri.getQueryParameter("limit");
        try
        {
            sqlitedatabase = VineDatabaseHelper.getDatabaseHelper(getContext()).getReadableDatabase();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            CrashUtil.logException(((Throwable) (obj)), "Failed to get a readable database on query.", new Object[0]);
            sqlitedatabase = VineDatabaseHelper.getDatabaseHelper(getContext()).getWritableDatabase();
        }
        sqlitequerybuilder = new SQLiteQueryBuilder();
        if (LOGGABLE)
        {
            Log.d("VineProvider", (new StringBuilder()).append("QUERY: uri ").append(uri).append(" -> ").append(sUriMatcher.match(uri)).toString());
        }
        j = sUriMatcher.match(uri);
        j;
        JVM INSTR lookupswitch 43: default 444
    //                   1: 526
    //                   2: 544
    //                   3: 590
    //                   4: 654
    //                   5: 638
    //                   6: 606
    //                   7: 2895
    //                   8: 2913
    //                   20: 1292
    //                   21: 1360
    //                   22: 1428
    //                   23: 1496
    //                   24: 1698
    //                   25: 1925
    //                   26: 2127
    //                   27: 2329
    //                   28: 2517
    //                   29: 2731
    //                   30: 2929
    //                   31: 3033
    //                   32: 3355
    //                   100: 672
    //                   101: 742
    //                   102: 812
    //                   103: 909
    //                   104: 1051
    //                   105: 980
    //                   106: 1122
    //                   107: 1263
    //                   108: 1192
    //                   109: 3466
    //                   110: 3584
    //                   111: 3607
    //                   112: 3623
    //                   113: 3741
    //                   114: 3795
    //                   115: 3903
    //                   116: 3977
    //                   117: 4018
    //                   118: 3674
    //                   119: 3690
    //                   120: 3849
    //                   401: 622;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44
_L1:
        s2 = null;
        obj = null;
_L45:
        if (!TextUtils.isEmpty(s1))
        {
            obj = s1;
        }
        int i;
        try
        {
            as = sqlitequerybuilder.query(sqlitedatabase, as, s, as1, s2, null, ((String) (obj)), s3);
            as.setNotificationUri(getContext().getContentResolver(), uri);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            CrashUtil.log("Cannot execute {} - {}: {} {} {} {} {}.", new Object[] {
                uri, Integer.valueOf(j), sqlitedatabase.toString(), sqlitequerybuilder.getTables(), s, s2, obj
            });
            throw new RuntimeException(as);
        }
        return as;
_L2:
        sqlitequerybuilder.setTables("users");
        obj = "username ASC";
        s2 = null;
          goto _L45
_L3:
        sqlitequerybuilder.setTables("users");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("user_id=").append(uri.getLastPathSegment()).toString());
        obj = "username ASC";
        s2 = null;
          goto _L45
_L4:
        sqlitequerybuilder.setTables("settings");
        s2 = null;
        obj = null;
          goto _L45
_L7:
        sqlitequerybuilder.setTables("posts");
        s2 = null;
        obj = null;
          goto _L45
_L44:
        sqlitequerybuilder.setTables("editions");
        s2 = null;
        obj = null;
          goto _L45
_L6:
        sqlitequerybuilder.setTables("likes");
        s2 = null;
        obj = null;
          goto _L45
_L5:
        sqlitequerybuilder.setTables("comments");
        obj = "comment_id ASC";
        s2 = null;
          goto _L45
_L23:
        sqlitequerybuilder.setTables("user_groups_view");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("tag=").append(uri.getLastPathSegment()).append(" AND ").append("type").append('=').append(1).toString());
        s2 = "user_id";
        obj = "order_id DESC";
          goto _L45
_L24:
        sqlitequerybuilder.setTables("user_groups_view");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("tag=").append(uri.getLastPathSegment()).append(" AND ").append("type").append('=').append(2).toString());
        s2 = "user_id";
        obj = "order_id DESC";
          goto _L45
_L25:
        sqlitequerybuilder.setTables("user_groups_view");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("tag=").append(uri.getLastPathSegment()).append(" AND (").append("type").append('=').append(2).append(" OR ").append("type").append('=').append(1).append(")").toString());
        s2 = "user_id";
        obj = "_id ASC";
          goto _L45
_L26:
        sqlitequerybuilder.setTables("user_groups_view");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("tag=").append(uri.getLastPathSegment()).append(" AND ").append("type").append('=').append(10).toString());
        s2 = "user_id";
        obj = "_id ASC";
          goto _L45
_L28:
        sqlitequerybuilder.setTables("user_groups_view");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("tag=").append(uri.getLastPathSegment()).append(" AND ").append("type").append('=').append(6).toString());
        s2 = "user_id";
        obj = "_id ASC";
          goto _L45
_L27:
        sqlitequerybuilder.setTables("user_groups_view");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("tag=").append(uri.getLastPathSegment()).append(" AND ").append("type").append('=').append(7).toString());
        s2 = "user_id";
        obj = "_id ASC";
          goto _L45
_L29:
        sqlitequerybuilder.setTables("user_groups_view");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("tag=").append(uri.getLastPathSegment()).append(" AND ").append("type").append('=').append(5).toString());
        s2 = "user_id";
        obj = "order_id DESC";
          goto _L45
_L31:
        sqlitequerybuilder.setTables("user_groups_view");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("tag=").append(uri.getLastPathSegment()).append(" AND ").append("type").append('=').append(9).toString());
        s2 = "user_id";
        obj = "order_id DESC";
          goto _L45
_L30:
        sqlitequerybuilder.setTables("user_groups_view");
        sqlitequerybuilder.appendWhere("type=8");
        s2 = "user_id";
        obj = "_id ASC";
          goto _L45
_L10:
        sqlitequerybuilder.setTables("post_groups_view");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("tag=").append(uri.getLastPathSegment()).append(" AND ").append("post_type").append('=').append(1).toString());
        obj = "sort_id DESC";
        s2 = null;
          goto _L45
_L11:
        sqlitequerybuilder.setTables("post_groups_view");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("tag=").append(uri.getLastPathSegment()).append(" AND ").append("post_type").append('=').append(2).toString());
        obj = "sort_id DESC";
        s2 = null;
          goto _L45
_L12:
        sqlitequerybuilder.setTables("post_groups_view");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("tag=").append(uri.getLastPathSegment()).append(" AND ").append("post_type").append('=').append(3).toString());
        obj = "sort_id DESC";
        s2 = null;
          goto _L45
_L13:
        if (BuildUtil.isOldDeviceOrLowEndDevice(getContext()))
        {
            sqlitequerybuilder.setTables("post_groups_view");
            as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostGroupsViewQuery.PROJECTION, "tag=? AND post_type = ?", new String[] {
                uri.getLastPathSegment(), String.valueOf(1)
            }, null, null, "sort_id DESC");
            if (s3 != null)
            {
                i = Integer.parseInt(s3);
            } else
            {
                i = 0;
            }
            as = new HybridPostCursorExplore(as, i);
            as.prepare(getContext());
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;
        }
        sqlitequerybuilder.setTables("post_comments_likes_view");
        as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostCommentsLikesQuery.PROJECTION, "tag=? AND post_type = ?", new String[] {
            uri.getLastPathSegment(), String.valueOf(1)
        }, null, null, "sort_id DESC, comment_id ASC, like_id");
        if (s3 != null)
        {
            i = Integer.parseInt(s3);
        } else
        {
            i = 0;
        }
        as = new HybridPostCursor(as, i);
        as.prepare(getContext());
        as.setNotificationUri(getContext().getContentResolver(), uri);
        return as;
_L14:
        as = uri.getQueryParameter("hide_profile_reposts");
        s = uri.getLastPathSegment();
        if ("0".equals(as))
        {
            as = String.valueOf(2);
        } else
        {
            as = String.valueOf(10);
        }
        if (BuildUtil.isOldDeviceOrLowEndDevice(getContext()))
        {
            sqlitequerybuilder.setTables("post_groups_view");
            as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostGroupsViewQuery.PROJECTION, "tag=? AND post_type=?", new String[] {
                s, as
            }, null, null, "sort_id DESC");
            if (s3 != null)
            {
                i = Integer.parseInt(s3);
            } else
            {
                i = 0;
            }
            as = new HybridPostCursorExplore(as, i);
            as.prepare(getContext());
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;
        }
        sqlitequerybuilder.setTables("post_comments_likes_view");
        as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostCommentsLikesQuery.PROJECTION, "tag=? AND post_type=?", new String[] {
            s, as
        }, null, null, "sort_id DESC, comment_id ASC, like_id");
        if (s3 != null)
        {
            i = Integer.parseInt(s3);
        } else
        {
            i = 0;
        }
        as = new HybridPostCursor(as, i);
        as.prepare(getContext());
        as.setNotificationUri(getContext().getContentResolver(), uri);
        return as;
_L15:
        if (BuildUtil.isOldDeviceOrLowEndDevice(getContext()))
        {
            sqlitequerybuilder.setTables("post_groups_view");
            as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostGroupsViewQuery.PROJECTION, "tag=? AND post_type = ?", new String[] {
                uri.getLastPathSegment(), String.valueOf(3)
            }, null, null, "sort_id DESC");
            if (s3 != null)
            {
                i = Integer.parseInt(s3);
            } else
            {
                i = 0;
            }
            as = new HybridPostCursorExplore(as, i);
            as.prepare(getContext());
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;
        }
        sqlitequerybuilder.setTables("post_comments_likes_view");
        as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostCommentsLikesQuery.PROJECTION, "tag=? AND post_type = ?", new String[] {
            uri.getLastPathSegment(), String.valueOf(3)
        }, null, null, "sort_id DESC, comment_id ASC, like_id");
        if (s3 != null)
        {
            i = Integer.parseInt(s3);
        } else
        {
            i = 0;
        }
        as = new HybridPostCursor(as, i);
        as.prepare(getContext());
        as.setNotificationUri(getContext().getContentResolver(), uri);
        return as;
_L16:
        if (BuildUtil.isOldDeviceOrLowEndDevice(getContext()))
        {
            sqlitequerybuilder.setTables("post_groups_view");
            as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostGroupsViewQuery.PROJECTION, "tag=? AND post_type = ?", new String[] {
                uri.getLastPathSegment(), String.valueOf(4)
            }, null, null, "sort_id DESC");
            if (s3 != null)
            {
                i = Integer.parseInt(s3);
            } else
            {
                i = 0;
            }
            as = new HybridPostCursorExplore(as, i);
            as.prepare(getContext());
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;
        }
        sqlitequerybuilder.setTables("post_comments_likes_view");
        as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostCommentsLikesQuery.PROJECTION, "tag=? AND post_type = ?", new String[] {
            uri.getLastPathSegment(), String.valueOf(4)
        }, null, null, "sort_id ASC, post_id DESC, comment_id ASC, like_id");
        if (s3 != null)
        {
            i = Integer.parseInt(s3);
        } else
        {
            i = 0;
        }
        as = new HybridPostCursor(as, i);
        as.prepare(getContext());
        as.setNotificationUri(getContext().getContentResolver(), uri);
        return as;
_L17:
        if (BuildUtil.isOldDeviceOrLowEndDevice(getContext()))
        {
            sqlitequerybuilder.setTables("post_groups_view");
            as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostGroupsViewQuery.PROJECTION, "post_type = ?", new String[] {
                String.valueOf(5)
            }, null, null, "sort_id DESC");
            if (s3 != null)
            {
                i = Integer.parseInt(s3);
            } else
            {
                i = 0;
            }
            as = new HybridPostCursorExplore(as, i);
            as.prepare(getContext());
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;
        }
        sqlitequerybuilder.setTables("post_comments_likes_view");
        as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostCommentsLikesQuery.PROJECTION, "post_type = ?", new String[] {
            String.valueOf(5)
        }, null, null, "sort_id ASC, post_id DESC, comment_id ASC, like_id");
        if (s3 != null)
        {
            i = Integer.parseInt(s3);
        } else
        {
            i = 0;
        }
        as = new HybridPostCursor(as, i);
        as.prepare(getContext());
        as.setNotificationUri(getContext().getContentResolver(), uri);
        return as;
_L18:
        if (BuildUtil.isOldDeviceOrLowEndDevice(getContext()))
        {
            sqlitequerybuilder.setTables("post_groups_view");
            as = uri.getQueryParameter("tag_name");
            as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostGroupsViewQuery.PROJECTION, "tag=? AND post_type = ?", new String[] {
                as, String.valueOf(6)
            }, null, null, "sort_id DESC");
            if (s3 != null)
            {
                i = Integer.parseInt(s3);
            } else
            {
                i = 0;
            }
            as = new HybridPostCursorExplore(as, i);
            as.prepare(getContext());
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;
        }
        sqlitequerybuilder.setTables("post_comments_likes_view");
        as = uri.getQueryParameter("tag_name");
        as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostCommentsLikesQuery.PROJECTION, "tag=? AND post_type = ?", new String[] {
            as, String.valueOf(6)
        }, null, null, "sort_id DESC, comment_id ASC, like_id");
        if (s3 != null)
        {
            i = Integer.parseInt(s3);
        } else
        {
            i = 0;
        }
        as = new HybridPostCursor(as, i);
        as.prepare(getContext());
        as.setNotificationUri(getContext().getContentResolver(), uri);
        return as;
_L19:
        if (BuildUtil.isOldDeviceOrLowEndDevice(getContext()))
        {
            sqlitequerybuilder.setTables("post_groups_view");
            as = uri.getLastPathSegment();
            as = new HybridPostCursorExplore(sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostGroupsViewQuery.PROJECTION, "post_id=? AND post_type=?", new String[] {
                as, String.valueOf(7)
            }, null, null, "sort_id DESC"));
            as.prepare(getContext());
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;
        } else
        {
            sqlitequerybuilder.setTables("post_comments_likes_view");
            as = uri.getLastPathSegment();
            as = new HybridPostCursor(sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostCommentsLikesQuery.PROJECTION, "post_id=? AND post_type=?", new String[] {
                as, String.valueOf(7)
            }, null, null, "sort_id DESC, comment_id ASC, like_id"));
            as.prepare(getContext());
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;
        }
_L8:
        sqlitequerybuilder.setTables("tag_search_results");
        obj = "_id ASC";
        s2 = null;
          goto _L45
_L9:
        sqlitequerybuilder.setTables("channels");
        s2 = null;
        obj = null;
          goto _L45
_L20:
        if (!BuildUtil.isOldDeviceOrLowEndDevice(getContext())) goto _L47; else goto _L46
_L46:
        sqlitequerybuilder.setTables("post_groups_view");
        as = uri.getQueryParameter("channel_id");
        as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostGroupsViewQuery.PROJECTION, "post_type = ? AND tag = ?", new String[] {
            String.valueOf(8), as
        }, null, null, "sort_id DESC");
        if (s3 != null)
        {
            i = Integer.parseInt(s3);
        } else
        {
            i = 0;
        }
        as = new HybridPostCursorExplore(as, i);
        as.prepare(getContext());
        as.setNotificationUri(getContext().getContentResolver(), uri);
          goto _L21
_L47:
        sqlitequerybuilder.setTables("post_comments_likes_view");
        as = uri.getQueryParameter("channel_id");
        as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostCommentsLikesQuery.PROJECTION, "post_type = ? AND tag = ?", new String[] {
            String.valueOf(8), as
        }, null, null, "sort_id ASC, post_id DESC, comment_id ASC, like_id");
        if (s3 != null)
        {
            i = Integer.parseInt(s3);
        } else
        {
            i = 0;
        }
        as = new HybridPostCursor(as, i);
        as.prepare(getContext());
        as.setNotificationUri(getContext().getContentResolver(), uri);
        return as;
_L21:
        if (BuildUtil.isOldDeviceOrLowEndDevice(getContext()))
        {
            sqlitequerybuilder.setTables("post_groups_view");
            as = uri.getQueryParameter("channel_id");
            as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostGroupsViewQuery.PROJECTION, "post_type = ? AND tag = ?", new String[] {
                String.valueOf(9), as
            }, null, null, "sort_id DESC");
            if (s3 != null)
            {
                i = Integer.parseInt(s3);
            } else
            {
                i = 0;
            }
            as = new HybridPostCursorExplore(as, i);
            as.prepare(getContext());
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;
        }
        sqlitequerybuilder.setTables("post_comments_likes_view");
        as = uri.getQueryParameter("channel_id");
        as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostCommentsLikesQuery.PROJECTION, "post_type = ? AND tag = ?", new String[] {
            String.valueOf(9), as
        }, null, null, "sort_id DESC, comment_id ASC, like_id");
        if (s3 != null)
        {
            i = Integer.parseInt(s3);
        } else
        {
            i = 0;
        }
        as = new HybridPostCursor(as, i);
        as.prepare(getContext());
        as.setNotificationUri(getContext().getContentResolver(), uri);
        return as;
_L22:
        obj = uri.getQueryParameter("tag_name");
        if (!BuildUtil.isOldDeviceOrLowEndDevice(getContext())) goto _L49; else goto _L48
_L48:
        sqlitequerybuilder.setTables("post_groups_view");
        obj = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostGroupsViewQuery.PROJECTION, "post_type = ? AND tag = ?", new String[] {
            String.valueOf(11), obj
        }, null, null, "sort_id DESC");
        if (s3 != null)
        {
            i = Integer.parseInt(s3);
        } else
        {
            i = 0;
        }
        obj = new HybridPostCursorExplore(((Cursor) (obj)), i);
        ((HybridPostCursorExplore) (obj)).prepare(getContext());
        ((HybridPostCursorExplore) (obj)).setNotificationUri(getContext().getContentResolver(), uri);
_L32:
        sqlitequerybuilder.setTables("notifications");
        s2 = null;
        obj = null;
          goto _L45
_L49:
        sqlitequerybuilder.setTables("post_comments_likes_view");
        as = sqlitequerybuilder.query(sqlitedatabase, VineDatabaseSQL.PostCommentsLikesQuery.PROJECTION, "post_type = ? AND tag = ?", new String[] {
            String.valueOf(11), obj
        }, null, null, "sort_id ASC, post_id DESC, comment_id ASC, like_id");
        if (s3 != null)
        {
            i = Integer.parseInt(s3);
        } else
        {
            i = 0;
        }
        as = new HybridPostCursor(as, i);
        as.prepare(getContext());
        as.setNotificationUri(getContext().getContentResolver(), uri);
        return as;
_L33:
        sqlitequerybuilder.setTables("tag_recently_used");
        return sqlitequerybuilder.query(sqlitedatabase, as, s, as1, null, null, s1);
_L34:
        sqlitequerybuilder.setTables("messages");
        s2 = null;
        obj = null;
          goto _L45
_L35:
        obj = uri.getQueryParameter("message_id");
        sqlitequerybuilder.setTables("messages");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("message_id=").append(((String) (obj))).toString());
        s2 = null;
        obj = null;
          goto _L45
_L41:
        sqlitequerybuilder.setTables("conversations");
        s2 = null;
        obj = null;
          goto _L45
_L42:
        obj = uri.getQueryParameter("conversation_id");
        sqlitequerybuilder.setTables("conversations");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("conversation_id=").append(((String) (obj))).toString());
        s2 = null;
        obj = null;
          goto _L45
_L36:
        s = uri.getQueryParameter("conversation_row_id");
        sqlitequerybuilder.setTables("message_users_view");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("conversation_row_id=").append(s).toString());
        s = "deleted=0";
        s2 = null;
        obj = null;
          goto _L45
_L37:
        obj = uri.getQueryParameter("conversation_row_id");
        sqlitequerybuilder.setTables("conversation_recipients");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("conversation_row_id=").append(((String) (obj))).toString());
        s2 = "user_row_id";
        obj = null;
          goto _L45
_L43:
        obj = uri.getQueryParameter("conversation_row_id");
        sqlitequerybuilder.setTables("conversation_recipients_users_view");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("conversation_row_id=").append(((String) (obj))).toString());
        s2 = "user_row_id";
        obj = null;
          goto _L45
_L38:
        sqlitequerybuilder.setTables("inbox_view");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("is_hidden=").append(uri.getQueryParameter("hidden")).append(" AND ").append("network_type").append('=').append(uri.getQueryParameter("network_type")).toString());
        s2 = null;
        obj = null;
          goto _L45
_L39:
        obj = uri.getLastPathSegment();
        s = "user_id=?";
        as1 = new String[1];
        as1[0] = String.valueOf(obj);
        sqlitequerybuilder.setTables("users");
        s2 = null;
        obj = null;
          goto _L45
_L40:
        sqlitequerybuilder.setTables("user_groups_view");
        s2 = Uri.decode(uri.getQueryParameter("filter"));
        obj = uri.getQueryParameter("group_type");
        if (TextUtils.isEmpty(s2)) goto _L1; else goto _L50
_L50:
        s2 = (new StringBuilder()).append("%").append(s2).append("%").toString();
        s = (new StringBuilder()).append("tag=").append(uri.getLastPathSegment()).append(" AND ").append("type").append("=").append(((String) (obj))).append(" AND (").append("username").append(" LIKE ? OR ").append("description").append(" LIKE ?)").toString();
        as1 = new String[2];
        as1[0] = s2;
        as1[1] = s2;
        s2 = null;
        obj = null;
          goto _L45
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = VineDatabaseHelper.getDatabaseHelper(getContext()).getWritableDatabase();
        if (LOGGABLE)
        {
            Log.d("VineProvider", (new StringBuilder()).append("UPDATE: uri ").append(uri).append(" -> ").append(sUriMatcher.match(uri)).toString());
        }
        switch (sUriMatcher.match(uri))
        {
        default:
            return 0;

        case 501: 
            sqlitedatabase.update("tag_recently_used", contentvalues, s, as);
            break;
        }
        return 0;
    }

    static 
    {
        boolean flag;
        if (BuildUtil.isLogsOn() || Log.isLoggable("VineProvider", 3))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        LOGGABLE = flag;
        sUriMatcher = new UriMatcher(-1);
        sUriMatcher.addURI(Vine.AUTHORITY, "users", 1);
        sUriMatcher.addURI(Vine.AUTHORITY, "users/id/#", 2);
        sUriMatcher.addURI(Vine.AUTHORITY, "settings", 3);
        sUriMatcher.addURI(Vine.AUTHORITY, "comments", 4);
        sUriMatcher.addURI(Vine.AUTHORITY, "likes", 5);
        sUriMatcher.addURI(Vine.AUTHORITY, "posts", 6);
        sUriMatcher.addURI(Vine.AUTHORITY, "user_groups_view/following/#", 100);
        sUriMatcher.addURI(Vine.AUTHORITY, "user_groups_view/followers/#", 101);
        sUriMatcher.addURI(Vine.AUTHORITY, "user_groups_view/all_follow/#", 102);
        sUriMatcher.addURI(Vine.AUTHORITY, "user_groups_view/friends/#", 103);
        sUriMatcher.addURI(Vine.AUTHORITY, "user_groups_view/find_friends_twitter/#", 105);
        sUriMatcher.addURI(Vine.AUTHORITY, "user_groups_view/find_friends_address/#", 104);
        sUriMatcher.addURI(Vine.AUTHORITY, "user_groups_view/likers/#", 106);
        sUriMatcher.addURI(Vine.AUTHORITY, "user_groups_view/reviners/#", 108);
        sUriMatcher.addURI(Vine.AUTHORITY, "user_groups_view/user_search_results", 107);
        sUriMatcher.addURI(Vine.AUTHORITY, "post_groups_view/timeline/#", 20);
        sUriMatcher.addURI(Vine.AUTHORITY, "post_groups_view/user_profile/#", 21);
        sUriMatcher.addURI(Vine.AUTHORITY, "post_groups_view/user_likes/#", 22);
        sUriMatcher.addURI(Vine.AUTHORITY, "tag_search_results", 7);
        sUriMatcher.addURI(Vine.AUTHORITY, "tag_recently_used", 110);
        sUriMatcher.addURI(Vine.AUTHORITY, "users/hide_profile_reposts/#", 116);
        sUriMatcher.addURI(Vine.AUTHORITY, "channels", 8);
        sUriMatcher.addURI(Vine.AUTHORITY, "post_comments_likes_view/all_timeline/#", 23);
        sUriMatcher.addURI(Vine.AUTHORITY, "post_comments_likes_view/all_timeline_user/#", 24);
        sUriMatcher.addURI(Vine.AUTHORITY, "post_comments_likes_view/all_timeline_user_likes/#", 25);
        sUriMatcher.addURI(Vine.AUTHORITY, "post_comments_likes_view/all_timeline_on_the_rise/#", 26);
        sUriMatcher.addURI(Vine.AUTHORITY, "post_comments_likes_view/all_timeline_popular/#", 27);
        sUriMatcher.addURI(Vine.AUTHORITY, "post_comments_likes_view/all_timeline_tag/#", 28);
        sUriMatcher.addURI(Vine.AUTHORITY, "post_comments_likes_view/post/#", 29);
        sUriMatcher.addURI(Vine.AUTHORITY, "post_comments_likes_view/timeline_channel_popular/#", 30);
        sUriMatcher.addURI(Vine.AUTHORITY, "post_comments_likes_view/timeline_channel_recent/#", 31);
        sUriMatcher.addURI(Vine.AUTHORITY, "post_comments_likes_view/timelines/#", 32);
        sUriMatcher.addURI(Vine.AUTHORITY, "conversations", 118);
        sUriMatcher.addURI(Vine.AUTHORITY, "conversations/conversation", 119);
        sUriMatcher.addURI(Vine.AUTHORITY, "messages", 111);
        sUriMatcher.addURI(Vine.AUTHORITY, "messages/message", 112);
        sUriMatcher.addURI(Vine.AUTHORITY, "message_users_view/conversation", 113);
        sUriMatcher.addURI(Vine.AUTHORITY, "conversation_recipients/conversation", 114);
        sUriMatcher.addURI(Vine.AUTHORITY, "conversation_recipients_users_view/conversation", 120);
        sUriMatcher.addURI(Vine.AUTHORITY, "inbox_view", 115);
        sUriMatcher.addURI(Vine.AUTHORITY, "user_groups_view/friends/filter/#", 117);
        sUriMatcher.addURI(Vine.AUTHORITY, "tag_recently_used/put_tag", 301);
        sUriMatcher.addURI(Vine.AUTHORITY, "tag_recently_used/update_tag", 501);
        sUriMatcher.addURI(Vine.AUTHORITY, "editions", 401);
    }
}
