// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
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
import com.edisonwang.android.slog.SLog;
import java.util.Arrays;
import java.util.Set;

// Referenced classes of package co.vine.android.provider:
//            VineUploadDatabaseHelper

public class VineUploadProvider extends ContentProvider
{

    private static final int ALL_UPLOADS = 1;
    public static final String AUTHORITY = BuildUtil.getAuthority(".provider.VineUploadProvider");
    public static final String CONTENT_AUTHORITY = (new StringBuilder()).append("content://").append(AUTHORITY).append("/").toString();
    private static final int DELETE_ALL_UPLOADS = 5;
    private static final int DELETE_UPLOAD = 4;
    private static final int GET_LAST_PATH = 3;
    private static final boolean LOGGABLE;
    private static final int PUT_HASH = 7;
    private static final int PUT_MESSAGE_ROW_ID = 14;
    private static final int PUT_NEW_UPLOAD = 6;
    private static final int PUT_POST_INFO = 10;
    private static final int PUT_STATUS = 8;
    private static final int PUT_UPLOAD_TIME = 11;
    private static final int PUT_URIS = 9;
    private static final int PUT_VALUES = 12;
    private static final int REFERENCE = 13;
    public static final String SCHEME = "content";
    private static final String TAG = "VineUploadProvider";
    private static final int UPLOAD = 2;
    private static final UriMatcher sUriMatcher;

    public VineUploadProvider()
    {
    }

    public int delete(Uri uri, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase;
        int i;
        i = 0;
        sqlitedatabase = VineUploadDatabaseHelper.getDatabaseHelper(getContext()).getWritableDatabase();
        if (LOGGABLE)
        {
            Log.d("VineUploadProvider", (new StringBuilder()).append("QUERY: uri ").append(uri).append(" -> ").append(sUriMatcher.match(uri)).toString());
        }
        sUriMatcher.match(uri);
        JVM INSTR tableswitch 4 5: default 92
    //                   4 114
    //                   5 128;
           goto _L1 _L2 _L3
_L1:
        if (i > 0)
        {
            getContext().getContentResolver().notifyChange(VineUploads.Uploads.CONTENT_URI, null);
        }
        return i;
_L2:
        i = sqlitedatabase.delete("uploads", s, as);
        continue; /* Loop/switch isn't completed */
_L3:
        i = sqlitedatabase.delete("uploads", "1", null);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public String getType(Uri uri)
    {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        SQLiteDatabase sqlitedatabase;
        long l;
        l = -1L;
        sqlitedatabase = VineUploadDatabaseHelper.getDatabaseHelper(getContext()).getWritableDatabase();
        if (LOGGABLE)
        {
            Log.d("VineUploadProvider", (new StringBuilder()).append("QUERY: uri ").append(uri).append(" -> ").append(sUriMatcher.match(uri)).toString());
        }
        sUriMatcher.match(uri);
        JVM INSTR tableswitch 6 6: default 88
    //                   6 111;
           goto _L1 _L2
_L1:
        if (l >= 0L)
        {
            getContext().getContentResolver().notifyChange(VineUploads.Uploads.CONTENT_URI, null);
        }
        return null;
_L2:
        long l1 = sqlitedatabase.insert("uploads", null, contentvalues);
        l = l1;
        if (LOGGABLE)
        {
            Log.d("VineUploadProvider", (new StringBuilder()).append("Upload inserted with rowId=").append(l1).toString());
            l = l1;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean onCreate()
    {
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        Object obj;
        SQLiteQueryBuilder sqlitequerybuilder;
        try
        {
            obj = VineUploadDatabaseHelper.getDatabaseHelper(getContext()).getReadableDatabase();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            CrashUtil.logException(((Throwable) (obj)), "Failed to get a readable database on query.", new Object[0]);
            obj = VineUploadDatabaseHelper.getDatabaseHelper(getContext()).getWritableDatabase();
        }
        sqlitequerybuilder = new SQLiteQueryBuilder();
        if (LOGGABLE)
        {
            Log.d("VineUploadProvider", (new StringBuilder()).append("QUERY: uri ").append(uri).append(" -> ").append(sUriMatcher.match(uri)).toString());
        }
        sUriMatcher.match(uri);
        JVM INSTR lookupswitch 3: default 108
    //                   1: 175
    //                   2: 216
    //                   13: 277;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_277;
_L1:
        sqlitequerybuilder.setTables("uploads");
_L5:
        String s2;
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
_L2:
        s2 = uri.getLastPathSegment();
        sqlitequerybuilder.setTables("uploads");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("owner_id=").append(s2).toString());
        if (true) goto _L5; else goto _L3
_L3:
        sqlitequerybuilder.setTables("uploads");
        as = uri.getLastPathSegment();
        uri = uri.getQueryParameter("path");
        if (!TextUtils.isEmpty(uri))
        {
            return sqlitequerybuilder.query(((SQLiteDatabase) (obj)), VineUploadsDatabaseSQL.UploadsQuery.PROJECTION, "path=? AND owner_id=?", new String[] {
                uri, as
            }, null, null, "_id ASC", "1");
        } else
        {
            return null;
        }
        sqlitequerybuilder.setTables("uploads");
        as = uri.getLastPathSegment();
        uri = uri.getQueryParameter("reference");
        if (!TextUtils.isEmpty(uri))
        {
            return sqlitequerybuilder.query(((SQLiteDatabase) (obj)), VineUploadsDatabaseSQL.UploadsQuery.PROJECTION, "reference=? AND owner_id=?", new String[] {
                uri, as
            }, null, null, "_id ASC");
        } else
        {
            return null;
        }
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        ContentValues contentvalues1;
        int i;
        i = 0;
        contentvalues1 = contentvalues;
        if (contentvalues == null)
        {
            contentvalues1 = new ContentValues();
        }
        contentvalues = VineUploadDatabaseHelper.getDatabaseHelper(getContext()).getWritableDatabase();
        if (LOGGABLE)
        {
            Log.d("VineUploadProvider", (new StringBuilder()).append("QUERY: uri ").append(uri).append(" -> ").append(sUriMatcher.match(uri)).toString());
        }
        sUriMatcher.match(uri);
        JVM INSTR tableswitch 7 14: default 128
    //                   7 193
    //                   8 249
    //                   9 324
    //                   10 401
    //                   11 457
    //                   12 513
    //                   13 128
    //                   14 529;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L1 _L8
_L1:
        String s1;
        String s2;
        String s3;
        try
        {
            if (!contentvalues1.keySet().isEmpty())
            {
                i = contentvalues.update("uploads", contentvalues1, s, as);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            if (LOGGABLE)
            {
                SLog.d("Cannot execute update with db={}, tablename={}, selection={}, selectionArgs={}", new String[] {
                    contentvalues.toString(), "uploads", s, Arrays.toString(as)
                });
            }
            throw new RuntimeException(uri);
        }
        if (i > 0 && String.valueOf(2).equals(uri.getQueryParameter("status")))
        {
            getContext().getContentResolver().notifyChange(VineUploads.Uploads.CONTENT_URI, null);
        }
        return i;
_L2:
        s1 = uri.getQueryParameter("path");
        s2 = uri.getQueryParameter("hash");
        SLog.d("PUT_HASH path={}, hash={}", s1, s2);
        s = "path=?";
        as = new String[1];
        as[0] = s1;
        contentvalues1.put("hash", s2);
        continue; /* Loop/switch isn't completed */
_L3:
        s1 = uri.getQueryParameter("path");
        s2 = uri.getQueryParameter("status");
        s3 = uri.getQueryParameter("captcha_url");
        SLog.d("PUT_STATUS path={}, status={}", s1, s2);
        s = "path=?";
        as = new String[1];
        as[0] = s1;
        contentvalues1.put("status", s2);
        contentvalues1.put("captcha_url", s3);
        continue; /* Loop/switch isn't completed */
_L4:
        s1 = uri.getQueryParameter("path");
        s2 = uri.getQueryParameter("video_url");
        s3 = uri.getQueryParameter("thumbnail_url");
        SLog.d("PUT_URIS path={}, videoUrl={}, thumbnailUrl={}", s1, s2, s3);
        s = "path=?";
        as = new String[1];
        as[0] = s1;
        contentvalues1.put("video_url", s2);
        contentvalues1.put("thumbnail_url", s3);
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = uri.getQueryParameter("path");
        s2 = uri.getQueryParameter("post_info");
        SLog.d("PUT_POST_INFO path={}, postInfo={}", s1, s2);
        s = "path=?";
        as = new String[1];
        as[0] = s1;
        contentvalues1.put("post_info", s2);
        continue; /* Loop/switch isn't completed */
_L6:
        s1 = uri.getQueryParameter("path");
        s2 = uri.getQueryParameter("upload_time");
        SLog.d("PUT_UPLOAD_TIME path={}, uploadTime={}", s1, s2);
        s = "path=?";
        as = new String[1];
        as[0] = s1;
        contentvalues1.put("upload_time", s2);
        continue; /* Loop/switch isn't completed */
_L7:
        SLog.d("PUT_VALUES selectionArgs={}, values={}", as, contentvalues1.toString());
        continue; /* Loop/switch isn't completed */
_L8:
        s1 = uri.getQueryParameter("path");
        s2 = uri.getQueryParameter("message_row_id");
        SLog.d("PUT_MESSAGE_ROW_ID path={}, id={}", s1, s2);
        s = "path=?";
        as = new String[1];
        as[0] = s1;
        contentvalues1.put("message_row", s2);
        if (true) goto _L1; else goto _L9
_L9:
    }

    static 
    {
        boolean flag;
        if (BuildUtil.isLogsOn() || Log.isLoggable("VineUploadProvider", 3))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        LOGGABLE = flag;
        sUriMatcher = new UriMatcher(-1);
        sUriMatcher.addURI(AUTHORITY, "uploads/#", 1);
        sUriMatcher.addURI(AUTHORITY, "uploads/upload/#", 2);
        sUriMatcher.addURI(AUTHORITY, "uploads/reference/#", 13);
        sUriMatcher.addURI(AUTHORITY, "uploads/delete_upload", 4);
        sUriMatcher.addURI(AUTHORITY, "uploads/put_new_upload", 6);
        sUriMatcher.addURI(AUTHORITY, "uploads/put_hash", 7);
        sUriMatcher.addURI(AUTHORITY, "uploads/put_status", 8);
        sUriMatcher.addURI(AUTHORITY, "uploads/put_uris", 9);
        sUriMatcher.addURI(AUTHORITY, "uploads/put_post_info", 10);
        sUriMatcher.addURI(AUTHORITY, "uploads/put_upload_time", 11);
        sUriMatcher.addURI(AUTHORITY, "uploads/put_values", 12);
        sUriMatcher.addURI(AUTHORITY, "uploads/put_message_row_id", 14);
    }
}
