// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import co.vine.android.api.VineTag;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package co.vine.android.provider:
//            VineDatabaseHelper

public class VineSuggestionsProvider extends ContentProvider
{
    public static interface TagsQuery
    {

        public static final int INDEX_TAG_ID = 1;
        public static final int INDEX_TAG_NAME = 2;
        public static final String PROJECTION[] = {
            "_id", "tag_id", "tag_name"
        };

    }

    public static interface UsersQuery
    {

        public static final int INDEX_AVATAR_URL = 3;
        public static final int INDEX_USERNAME = 2;
        public static final int INDEX_USER_ID = 1;
        public static final String PROJECTION[] = {
            "_id", "user_id", "username", "avatar_url"
        };

    }


    public static final String AUTHORITY = BuildUtil.getAuthority(".provider.VineSuggestionsProvider");
    public static final String CONTENT_AUTHORITY = (new StringBuilder()).append("content://").append(AUTHORITY).append("/").toString();
    private static final boolean LOGGABLE;
    public static final String PATH_TAGS = "tags";
    public static final String PATH_USERS = "users";
    public static final String SCHEME = "content";
    private static final int SUGGEST_TAGS = 2;
    private static final int SUGGEST_USERS = 1;
    private static final String TAG = "VineSuggestProvider";
    public static final Uri TAGS_URI = Uri.parse((new StringBuilder()).append(CONTENT_AUTHORITY).append("tags").toString());
    public static final Uri USERS_URI = Uri.parse((new StringBuilder()).append(CONTENT_AUTHORITY).append("users").toString());
    private static final HashMap sTagsTypeAhead = new HashMap();
    private static final UriMatcher sUriMatcher;
    private static final HashMap sUsersTypeAhead = new HashMap();
    private AppController mAppController;

    public VineSuggestionsProvider()
    {
    }

    public static void addRealtimeTagSuggestions(String s, ArrayList arraylist)
    {
        synchronized (sTagsTypeAhead)
        {
            sTagsTypeAhead.put(s, arraylist);
        }
        return;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void addRealtimeUserSuggestions(String s, ArrayList arraylist)
    {
        synchronized (sUsersTypeAhead)
        {
            sUsersTypeAhead.put(s, arraylist);
        }
        return;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void clearRealtimeTagSuggestions()
    {
        synchronized (sTagsTypeAhead)
        {
            sTagsTypeAhead.clear();
        }
        return;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void clearRealtimeUserSuggestions()
    {
        synchronized (sUsersTypeAhead)
        {
            sUsersTypeAhead.clear();
        }
        return;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private Cursor getComposeTagSuggestions(String s, MatrixCursor matrixcursor)
    {
        Object obj;
        String as[];
        int i;
        i = 0;
        boolean flag1 = false;
        int j = mAppController.getTypeaheadMaxCompose();
        ContentResolver contentresolver;
        Uri uri;
        boolean flag;
        if (!TextUtils.isEmpty(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        contentresolver = getContext().getContentResolver();
        uri = Vine.TagsRecentlyUsed.CONTENT_URI;
        if (flag)
        {
            obj = "tag_name LIKE ?";
            as = new String[1];
            as[0] = (new StringBuilder()).append(s).append("%").toString();
        } else
        {
            obj = null;
            as = null;
        }
        as = contentresolver.query(uri, VineDatabaseSQL.TagsRecentlyUsedQuery.PROJECTION, ((String) (obj)), as, "last_used_timestamp DESC");
        obj = new HashSet();
        if (as == null) goto _L2; else goto _L1
_L1:
        i = ((flag1) ? 1 : 0);
_L6:
        if (!as.moveToNext()) goto _L4; else goto _L3
_L3:
        if (((HashSet) (obj)).contains(Long.valueOf(as.getLong(1)))) goto _L6; else goto _L5
_L5:
        if (i <= j) goto _L7; else goto _L4
_L4:
        as.close();
_L2:
        if (!flag || i > j) goto _L9; else goto _L8
_L8:
        s = getRealtimeTagSuggestions(s);
        if (s == null) goto _L9; else goto _L10
_L10:
        s = s.iterator();
_L13:
        if (!s.hasNext()) goto _L9; else goto _L11
_L11:
        as = (VineTag)s.next();
        if (((HashSet) (obj)).contains(Long.valueOf(((VineTag) (as)).tagId))) goto _L13; else goto _L12
_L12:
        if (i <= j)
        {
            break MISSING_BLOCK_LABEL_309;
        }
_L9:
        return matrixcursor;
_L7:
        android.database.MatrixCursor.RowBuilder rowbuilder = matrixcursor.newRow();
        rowbuilder.add(Integer.valueOf(i));
        rowbuilder.add(Long.valueOf(as.getLong(1)));
        rowbuilder.add(as.getString(2));
        ((HashSet) (obj)).add(Long.valueOf(as.getLong(1)));
        i++;
          goto _L6
        android.database.MatrixCursor.RowBuilder rowbuilder1 = matrixcursor.newRow();
        rowbuilder1.add(Integer.valueOf(i));
        rowbuilder1.add(Long.valueOf(((VineTag) (as)).tagId));
        rowbuilder1.add(((VineTag) (as)).tagName);
        i++;
          goto _L13
    }

    private Cursor getComposeUserSuggestions(String s, MatrixCursor matrixcursor, long l)
    {
        Object obj;
        String as[];
        int i;
        i = 0;
        boolean flag1 = false;
        int j = mAppController.getTypeaheadMaxCompose();
        ContentResolver contentresolver;
        Uri uri;
        boolean flag;
        if (!TextUtils.isEmpty(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        contentresolver = getContext().getContentResolver();
        uri = ContentUris.withAppendedId(Vine.UserGroupsView.CONTENT_URI_ALL_FOLLOW, l);
        if (flag)
        {
            obj = "username LIKE ?";
            as = new String[1];
            as[0] = (new StringBuilder()).append(s).append("%").toString();
        } else
        {
            obj = null;
            as = null;
        }
        as = contentresolver.query(uri, UsersQuery.PROJECTION, ((String) (obj)), as, "order_id DESC");
        obj = new HashSet();
        if (as == null) goto _L2; else goto _L1
_L1:
        i = ((flag1) ? 1 : 0);
_L6:
        if (!as.moveToNext()) goto _L4; else goto _L3
_L3:
        if (((HashSet) (obj)).contains(Long.valueOf(as.getLong(1)))) goto _L6; else goto _L5
_L5:
        if (i <= j) goto _L7; else goto _L4
_L4:
        as.close();
_L2:
        if (!flag || i > j) goto _L9; else goto _L8
_L8:
        s = getRealtimeUserSuggestions(s);
        if (s == null) goto _L9; else goto _L10
_L10:
        s = s.iterator();
_L13:
        if (!s.hasNext()) goto _L9; else goto _L11
_L11:
        as = (VineUser)s.next();
        if (((HashSet) (obj)).contains(Long.valueOf(((VineUser) (as)).userId))) goto _L13; else goto _L12
_L12:
        if (i <= j)
        {
            break MISSING_BLOCK_LABEL_336;
        }
_L9:
        return matrixcursor;
_L7:
        android.database.MatrixCursor.RowBuilder rowbuilder = matrixcursor.newRow();
        rowbuilder.add(Integer.valueOf(i));
        rowbuilder.add(Long.valueOf(as.getLong(1)));
        rowbuilder.add(as.getString(2));
        rowbuilder.add(as.getString(3));
        ((HashSet) (obj)).add(Long.valueOf(as.getLong(1)));
        i++;
          goto _L6
        android.database.MatrixCursor.RowBuilder rowbuilder1 = matrixcursor.newRow();
        rowbuilder1.add(Integer.valueOf(i));
        rowbuilder1.add(Long.valueOf(((VineUser) (as)).userId));
        rowbuilder1.add(((VineUser) (as)).username);
        rowbuilder1.add(((VineUser) (as)).avatarUrl);
        i++;
          goto _L13
    }

    public static ArrayList getRealtimeTagSuggestions(String s)
    {
        synchronized (sTagsTypeAhead)
        {
            s = (ArrayList)sTagsTypeAhead.get(s);
        }
        return s;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static ArrayList getRealtimeUserSuggestions(String s)
    {
        synchronized (sUsersTypeAhead)
        {
            s = (ArrayList)sUsersTypeAhead.get(s);
        }
        return s;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }

    public int delete(Uri uri, String s, String as[])
    {
        return 0;
    }

    public String getType(Uri uri)
    {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        return null;
    }

    public boolean onCreate()
    {
        mAppController = AppController.getInstance(getContext());
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        Object obj;
        SQLiteQueryBuilder sqlitequerybuilder;
        try
        {
            obj = VineDatabaseHelper.getDatabaseHelper(getContext()).getReadableDatabase();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            CrashUtil.logException(((Throwable) (obj)), "Failed to get a readable database on query.", new Object[0]);
            obj = VineDatabaseHelper.getDatabaseHelper(getContext()).getWritableDatabase();
        }
        sqlitequerybuilder = new SQLiteQueryBuilder();
        if (LOGGABLE)
        {
            Log.d("VineSuggestProvider", (new StringBuilder()).append("QUERY: uri ").append(uri).append(" -> ").append(sUriMatcher.match(uri)).toString());
        }
        switch (sUriMatcher.match(uri))
        {
        default:
            sqlitequerybuilder.setTables("user_groups_view");
            long l;
            try
            {
                as = sqlitequerybuilder.query(((SQLiteDatabase) (obj)), as, s, as1, null, null, s1);
                as.setNotificationUri(getContext().getContentResolver(), uri);
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri)
            {
                if (LOGGABLE)
                {
                    SLog.d("Cannot execute {} {}  {} {} {} {}", new String[] {
                        ((SQLiteDatabase) (obj)).toString(), sqlitequerybuilder.getTables(), s, null, s1
                    });
                }
                throw new RuntimeException(uri);
            }
            return as;

        case 1: // '\001'
            l = Long.parseLong(uri.getLastPathSegment());
            return getComposeUserSuggestions(s, new MatrixCursor(UsersQuery.PROJECTION), l);

        case 2: // '\002'
            return getComposeTagSuggestions(s, new MatrixCursor(TagsQuery.PROJECTION));
        }
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        return 0;
    }

    static 
    {
        boolean flag;
        if (BuildUtil.isLogsOn() || Log.isLoggable("VineSuggestProvider", 3))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        LOGGABLE = flag;
        sUriMatcher = new UriMatcher(-1);
        sUriMatcher.addURI(AUTHORITY, "users/#", 1);
        sUriMatcher.addURI(AUTHORITY, "tags", 2);
    }
}
