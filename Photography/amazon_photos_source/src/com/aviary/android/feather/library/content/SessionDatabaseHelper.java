// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.content;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.headless.moa.JSONWriter;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaMetadata;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;

public class SessionDatabaseHelper extends SQLiteOpenHelper
{
    public static final class ActionColumns
        implements BaseColumns
    {

        public static final String ACTION = "action_action";
        public static final String BITMAP_PTR = "action_bitmap_ptr";
        public static final String RECIPE = "action_recipe";
        public static final String SESSION_ID = "action_session_id";
        static final String TABLE_NAME = "actions";
        public static final String _ID = "action_id";

        public ActionColumns()
        {
        }
    }

    public static final class ActionWrapper
    {

        public final String actions;
        public final long bitmapPtr;
        public final long id;
        public final long sessionId;

        public String toString()
        {
            return String.format(Locale.US, "ActionWrapper{id: %d, session_id: %d, bitmap_ptr: %d, actions: %s}", new Object[] {
                Long.valueOf(id), Long.valueOf(sessionId), Long.valueOf(bitmapPtr), actions
            });
        }

        public ActionWrapper(long l, long l1, long l2, byte abyte0[])
        {
            id = l;
            sessionId = l1;
            bitmapPtr = l2;
            actions = new String(abyte0);
        }
    }

    static final class SessionColumns
        implements BaseColumns
    {

        public static final String CREATION_TIME = "session_creation_time";
        public static final String DATA = "session_data";
        public static final String MEGAPIXELS = "session_mp";
        public static final String ORIENTATION = "session_orientation";
        static final String TABLE_NAME = "sessions";
        public static final String _ID = "session_id";

        SessionColumns()
        {
        }
    }

    public static final class SessionWrapper
    {

        public final long creationTime;
        public final Uri data;
        public final long id;
        public final int megapixels;
        public final int orientation;

        public String toString()
        {
            return String.format(Locale.US, "SessionWrapper{id: %d, data: %s, mp: %d, orientation: %d, time: %d", new Object[] {
                Long.valueOf(id), data, Integer.valueOf(megapixels), Integer.valueOf(orientation), Long.valueOf(creationTime)
            });
        }

        public SessionWrapper(long l, Uri uri, int i, int j, long l1)
        {
            id = l;
            data = uri;
            megapixels = i;
            orientation = j;
            creationTime = l1;
        }
    }


    static final long MAX_AGE = 0x5265c00L;
    static final String NAME = "aviary.sessions.sqlite";
    static final int VERSION = 1;
    static com.aviary.android.feather.common.log.LoggerFactory.Logger logger = LoggerFactory.getLogger("SessionDatabaseHelper");

    public SessionDatabaseHelper(Context context)
    {
        super(context, "aviary.sessions.sqlite", null, 1);
    }

    private void printDatabaseStats()
    {
        logger.info("=== DATABASE STATS ===");
        Object obj = getReadableDatabase();
        Object obj1 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        long l = ((Calendar) (obj1)).getTimeInMillis();
        logger.verbose("current time: %d (%s)", new Object[] {
            Long.valueOf(l), ((Calendar) (obj1)).getTime().toString()
        });
        obj1 = ((SQLiteDatabase) (obj)).query("sessions", null, null, null, null, null, null);
        if (obj1 != null)
        {
            logger.verbose((new StringBuilder()).append("total sessions: ").append(((Cursor) (obj1)).getCount()).toString(), new Object[0]);
            if (((Cursor) (obj1)).moveToFirst())
            {
                do
                {
                    int i = ((Cursor) (obj1)).getColumnIndex("session_id");
                    int j = ((Cursor) (obj1)).getColumnIndex("session_data");
                    int k = ((Cursor) (obj1)).getColumnIndex("session_creation_time");
                    long l1 = ((Cursor) (obj1)).getLong(i);
                    String s = ((Cursor) (obj1)).getString(j);
                    j = ((Cursor) (obj1)).getInt(k);
                    Cursor cursor = ((SQLiteDatabase) (obj)).rawQuery((new StringBuilder()).append("SELECT COUNT(*) as _count FROM actions WHERE action_session_id=").append(l1).toString(), null);
                    i = 0;
                    if (cursor.moveToFirst())
                    {
                        i = cursor.getInt(0);
                    }
                    IOUtils.closeSilently(cursor);
                    logger.verbose("session: %d, uri: %s, created: %d, actions: %d", new Object[] {
                        Long.valueOf(l1), s, Integer.valueOf(j), Integer.valueOf(i)
                    });
                } while (((Cursor) (obj1)).moveToNext());
            }
            IOUtils.closeSilently(((Cursor) (obj1)));
        }
        obj = ((SQLiteDatabase) (obj)).query("sessions", null, (new StringBuilder()).append("session_creation_time<").append((l - 0x5265c00L) / 1000L).toString(), null, null, null, null);
        if (obj != null)
        {
            logger.warn((new StringBuilder()).append("we need to delete: ").append(((Cursor) (obj)).getCount()).append(" loitering sessions").toString());
            ((Cursor) (obj)).close();
        }
    }

    private void printSessionStats(long l)
    {
        logger.info("=== SESSION STATS %d ===", new Object[] {
            Long.valueOf(l)
        });
        Object obj = getReadableDatabase();
        Object obj1 = new SQLiteQueryBuilder();
        ((SQLiteQueryBuilder) (obj1)).setTables("actions");
        long l1;
        long l2;
        for (obj = ((SQLiteQueryBuilder) (obj1)).query(((SQLiteDatabase) (obj)), null, "action_session_id=?", new String[] {
    String.valueOf(l)
}, null, null, "action_id ASC"); ((Cursor) (obj)).moveToNext(); logger.verbose("id: %d, session: %d, ptr: %d (0x%x), actions: %s", new Object[] {
    Long.valueOf(l), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2), obj1
}))
        {
            l = ((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndex("action_id"));
            l1 = ((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndex("action_session_id"));
            l2 = ((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndex("action_bitmap_ptr"));
            obj1 = new String(((Cursor) (obj)).getBlob(((Cursor) (obj)).getColumnIndex("action_action")), Charset.forName("UTF-8"));
        }

        IOUtils.closeSilently(((Cursor) (obj)));
    }

    private void purgeDatabase()
    {
        logger.info("purgeDatabase");
        long l = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
        int i = getWritableDatabase().delete("sessions", (new StringBuilder()).append("session_creation_time<").append((l - 0x5265c00L) / 1000L).toString(), null);
        logger.warn((new StringBuilder()).append("deleted ").append(i).append(" loitering sessions").toString());
    }

    public int deleteActions(long l)
    {
        logger.info("deleteActions(session: %d)", new Object[] {
            Long.valueOf(l)
        });
        int i = getWritableDatabase().delete("actions", (new StringBuilder()).append("action_session_id=").append(l).toString(), null);
        logger.verbose("deleted %d actions", new Object[] {
            Integer.valueOf(i)
        });
        return i;
    }

    public int deleteActionsFrom(long l, long l1)
    {
        logger.info("deleteActionsFrom(session: %d, action: %d)", new Object[] {
            Long.valueOf(l), Long.valueOf(l1)
        });
        int i = getWritableDatabase().delete("actions", "action_session_id=? AND action_id>?", new String[] {
            String.valueOf(l), String.valueOf(l1)
        });
        logger.verbose("deleted %d actions", new Object[] {
            Integer.valueOf(i)
        });
        return i;
    }

    public int deleteSession(long l)
    {
        logger.info("delete(session: %d)", new Object[] {
            Long.valueOf(l)
        });
        int i = getWritableDatabase().delete("sessions", (new StringBuilder()).append("session_id=").append(l).toString(), null);
        logger.verbose("deleted %d sessions", new Object[] {
            Integer.valueOf(i)
        });
        return i;
    }

    public long findActionByBitmap(long l, long l1)
    {
        Object obj;
        obj = getReadableDatabase();
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("actions");
        obj = sqlitequerybuilder.query(((SQLiteDatabase) (obj)), new String[] {
            "action_id"
        }, "action_session_id=? AND action_bitmap_ptr=?", new String[] {
            String.valueOf(l), String.valueOf(l1)
        }, null, null, null);
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_90;
        }
        l = ((Cursor) (obj)).getLong(0);
        IOUtils.closeSilently(((Cursor) (obj)));
        return l;
        IOUtils.closeSilently(((Cursor) (obj)));
        return -1L;
        Exception exception;
        exception;
        IOUtils.closeSilently(((Cursor) (obj)));
        throw exception;
    }

    public ActionWrapper findActionGreaterThan(long l, long l1)
    {
        Object obj = getReadableDatabase();
        Object obj1 = new SQLiteQueryBuilder();
        ((SQLiteQueryBuilder) (obj1)).setTables("actions");
        obj1 = ((SQLiteQueryBuilder) (obj1)).query(((SQLiteDatabase) (obj)), new String[] {
            "action_id", "action_session_id", "action_bitmap_ptr", "action_action"
        }, "action_session_id=? AND action_id>?", new String[] {
            String.valueOf(l), String.valueOf(l1)
        }, null, null, "action_id ASC", "0, 1");
        obj = null;
        if (((Cursor) (obj1)).moveToFirst())
        {
            obj = new ActionWrapper(((Cursor) (obj1)).getLong(0), ((Cursor) (obj1)).getLong(1), ((Cursor) (obj1)).getLong(2), ((Cursor) (obj1)).getBlob(3));
        }
        IOUtils.closeSilently(((Cursor) (obj1)));
        return ((ActionWrapper) (obj));
    }

    public SessionWrapper findSession(long l)
    {
        Object obj = getReadableDatabase();
        Object obj1 = new SQLiteQueryBuilder();
        ((SQLiteQueryBuilder) (obj1)).setTables("sessions");
        obj1 = ((SQLiteQueryBuilder) (obj1)).query(((SQLiteDatabase) (obj)), new String[] {
            "session_id", "session_data", "session_mp", "session_orientation", "session_creation_time"
        }, "session_id=?", new String[] {
            String.valueOf(l)
        }, null, null, null);
        obj = null;
        if (((Cursor) (obj1)).moveToFirst())
        {
            obj = new SessionWrapper(((Cursor) (obj1)).getLong(0), Uri.parse(((Cursor) (obj1)).getString(1)), ((Cursor) (obj1)).getInt(2), ((Cursor) (obj1)).getInt(3), ((Cursor) (obj1)).getLong(4));
        }
        IOUtils.closeSilently(((Cursor) (obj1)));
        return ((SessionWrapper) (obj));
    }

    public long load(String s, int i, int j)
    {
        SQLiteDatabase sqlitedatabase;
        ContentValues contentvalues;
        logger.info("load(uri: %s, megapixels: %d, orientation: %d)", new Object[] {
            s, Integer.valueOf(i), Integer.valueOf(j)
        });
        sqlitedatabase = getWritableDatabase();
        contentvalues = new ContentValues();
        contentvalues.put("session_data", s);
        contentvalues.put("session_mp", Integer.valueOf(i));
        contentvalues.put("session_orientation", Integer.valueOf(j));
        long l;
        sqlitedatabase.beginTransaction();
        l = sqlitedatabase.insert("sessions", null, contentvalues);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        logger.verbose("result: %d", new Object[] {
            Long.valueOf(l)
        });
        purgeDatabase();
        printDatabaseStats();
        return l;
        s;
        sqlitedatabase.endTransaction();
        throw s;
    }

    public void onConfigure(SQLiteDatabase sqlitedatabase)
    {
        logger.info("onConfigure");
        if (!sqlitedatabase.isReadOnly())
        {
            sqlitedatabase.execSQL("PRAGMA foreign_keys=ON;");
            sqlitedatabase.execSQL("PRAGMA encoding=\"UTF-8\";");
        }
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        logger.info("onCreate");
        String s = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER NOT NULL DEFAULT 0, %s INTEGER NOT NULL DEFAULT 0, %s INTEGER NOT NULL DEFAULT (strftime('%%s', datetime(current_timestamp))))", new Object[] {
            "sessions", "session_id", "session_data", "session_mp", "session_orientation", "session_creation_time"
        });
        String s1 = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s BLOB, %s BLOB, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE)", new Object[] {
            "actions", "action_id", "action_session_id", "action_bitmap_ptr", "action_action", "action_recipe", "action_session_id", "sessions", "session_id"
        });
        logger.info(s);
        logger.info(s1);
        sqlitedatabase.execSQL(s);
        sqlitedatabase.execSQL(s1);
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        super.onOpen(sqlitedatabase);
        logger.info("onOpen: %s", new Object[] {
            sqlitedatabase.getPath()
        });
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        logger.info("onUpgrade from %d to %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    public long push(long l, long l1, MoaActionList moaactionlist)
    {
        logger.info("push(session:%d, bitmap: 0x%x)", new Object[] {
            Long.valueOf(l), Long.valueOf(l1)
        });
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        String s = "";
        if (moaactionlist != null)
        {
            try
            {
                s = JSONWriter.encode(moaactionlist, new MoaMetadata());
            }
            // Misplaced declaration of an exception variable
            catch (MoaActionList moaactionlist)
            {
                moaactionlist.printStackTrace();
                s = "";
            }
        }
        moaactionlist = new ContentValues();
        moaactionlist.put("action_session_id", Long.valueOf(l));
        moaactionlist.put("action_bitmap_ptr", Long.valueOf(l1));
        moaactionlist.put("action_action", s);
        moaactionlist.putNull("action_recipe");
        l1 = sqlitedatabase.insert("actions", null, moaactionlist);
        logger.verbose("result: %d", new Object[] {
            Long.valueOf(l1)
        });
        printSessionStats(l);
        return l1;
    }

}
