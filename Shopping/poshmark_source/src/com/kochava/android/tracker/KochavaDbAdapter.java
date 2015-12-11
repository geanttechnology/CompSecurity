// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kochava.android.tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.kochava.android.util.Base64Coder;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.kochava.android.tracker:
//            Global

public class KochavaDbAdapter
{
    private static class KochavaDatabaseHelper extends SQLiteOpenHelper
    {

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL,created_at INTEGER NOT NULL);");
            } else
            {
                SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL,created_at INTEGER NOT NULL);");
            }
            if (Global.DEBUG)
            {
                Log.e("KochavaDbAdapter", "DATABASE_CREATE_2 : CREATE TABLE keys (id STRING NOT NULL PRIMARY KEY, data STRING NOT NULL);");
            }
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.execSQL("CREATE TABLE keys (id STRING NOT NULL PRIMARY KEY, data STRING NOT NULL);");
            } else
            {
                SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE keys (id STRING NOT NULL PRIMARY KEY, data STRING NOT NULL);");
            }
            if (Global.DEBUG)
            {
                Log.e("KochavaDbAdapter", "DATABASE_CREATE_2 : Done");
            }
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.execSQL("CREATE INDEX IF NOT EXISTS time_idx ON events (created_at);");
                return;
            } else
            {
                SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE INDEX IF NOT EXISTS time_idx ON events (created_at);");
                return;
            }
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            if (Global.DEBUG)
            {
                Log.e("KochavaDbAdapter", (new StringBuilder("Upgrading database from version ")).append(i).append(" to ").append(j).toString());
            }
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.execSQL("DROP TABLE events");
            } else
            {
                SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE events");
            }
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL,created_at INTEGER NOT NULL);");
            } else
            {
                SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL,created_at INTEGER NOT NULL);");
            }
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.execSQL("CREATE INDEX IF NOT EXISTS time_idx ON events (created_at);");
                return;
            } else
            {
                SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE INDEX IF NOT EXISTS time_idx ON events (created_at);");
                return;
            }
        }

        KochavaDatabaseHelper(Context context)
        {
            super(context, "KochavaFeatureTracker", null, 2);
        }
    }


    private static final String DATABASE_CREATE = "CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL,created_at INTEGER NOT NULL);";
    private static final String DATABASE_CREATE_2 = "CREATE TABLE keys (id STRING NOT NULL PRIMARY KEY, data STRING NOT NULL);";
    private static final String DATABASE_INDEX = "CREATE INDEX IF NOT EXISTS time_idx ON events (created_at);";
    private static final String DATABASE_NAME = "KochavaFeatureTracker";
    private static final String DATABASE_TABLE = "events";
    private static final String DATABASE_TABLE_2 = "keys";
    private static final int DATABASE_VERSION = 2;
    public static final String KEY_CREATED_AT = "created_at";
    public static final String KEY_DATA = "data";
    private static final String LOGTAG = "KochavaDbAdapter";
    private KochavaDatabaseHelper kDb;

    public KochavaDbAdapter(Context context)
    {
        kDb = new KochavaDatabaseHelper(context);
    }

    public int addEvent(JSONObject jsonobject)
    {
        this;
        JVM INSTR monitorenter ;
        if (Global.DEBUG)
        {
            Log.e("KochavaDbAdapter", "addEvent");
        }
        JSONObject jsonobject1;
        JSONObject jsonobject2;
        Object obj;
        Object obj1;
        int j;
        obj1 = null;
        obj = null;
        j = -1;
        jsonobject2 = obj;
        jsonobject1 = obj1;
        SQLiteDatabase sqlitedatabase = kDb.getWritableDatabase();
        jsonobject2 = obj;
        jsonobject1 = obj1;
        ContentValues contentvalues = new ContentValues();
        jsonobject2 = obj;
        jsonobject1 = obj1;
        if (jsonobject instanceof JSONObject) goto _L2; else goto _L1
_L1:
        jsonobject2 = obj;
        jsonobject1 = obj1;
        jsonobject = jsonobject.toString();
_L7:
        jsonobject2 = obj;
        jsonobject1 = obj1;
        contentvalues.put("data", jsonobject);
        jsonobject2 = obj;
        jsonobject1 = obj1;
        contentvalues.put("created_at", Long.valueOf(System.currentTimeMillis()));
        jsonobject2 = obj;
        jsonobject1 = obj1;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L4; else goto _L3
_L3:
        jsonobject2 = obj;
        jsonobject1 = obj1;
        sqlitedatabase.insert("events", null, contentvalues);
_L8:
        jsonobject2 = obj;
        jsonobject1 = obj1;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L6; else goto _L5
_L5:
        jsonobject2 = obj;
        jsonobject1 = obj1;
        jsonobject = sqlitedatabase.rawQuery("SELECT * FROM events", null);
_L11:
        jsonobject2 = jsonobject;
        jsonobject1 = jsonobject;
        int i = jsonobject.getCount();
        j = i;
        kDb.close();
        i = j;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        jsonobject.close();
        i = j;
_L10:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        jsonobject2 = obj;
        jsonobject1 = obj1;
        jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
          goto _L7
_L4:
        jsonobject2 = obj;
        jsonobject1 = obj1;
        SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "events", null, contentvalues);
          goto _L8
        jsonobject;
        jsonobject1 = jsonobject2;
        if (!Global.DEBUG)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        jsonobject1 = jsonobject2;
        Log.e("KochavaDbAdapter", "addEvent", jsonobject);
        kDb.close();
        i = j;
        if (jsonobject2 == null) goto _L10; else goto _L9
_L9:
        jsonobject2.close();
        i = j;
          goto _L10
        jsonobject;
        this;
        JVM INSTR monitorexit ;
        throw jsonobject;
_L6:
        jsonobject2 = obj;
        jsonobject1 = obj1;
        jsonobject = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "SELECT * FROM events", null);
          goto _L11
        jsonobject;
        kDb.close();
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_350;
        }
        jsonobject1.close();
        throw jsonobject;
          goto _L7
    }

    public void cleanupEvents(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (Global.DEBUG)
        {
            Log.e("KochavaDbAdapter", "cleanupEvent");
        }
        SQLiteDatabase sqlitedatabase;
        String s;
        sqlitedatabase = kDb.getWritableDatabase();
        s = (new StringBuilder("created_at <= ")).append(l).toString();
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        sqlitedatabase.delete("events", s, null);
_L3:
        kDb.close();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "events", s, null);
          goto _L3
        Object obj;
        obj;
        if (Global.DEBUG)
        {
            Log.e("KochavaDbAdapter", "cleanupEvents", ((Throwable) (obj)));
        }
        kDb.close();
          goto _L4
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        kDb.close();
        throw obj;
          goto _L3
    }

    public String generateDataString()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Cursor cursor;
        String s;
        Cursor cursor1;
        Object obj1;
        String s1;
        Object obj2;
        Object obj3;
        JSONArray jsonarray;
        jsonarray = null;
        cursor = null;
        obj3 = null;
        obj2 = null;
        s1 = null;
        s = null;
        cursor1 = cursor;
        obj = s1;
        obj1 = jsonarray;
        SQLiteDatabase sqlitedatabase = kDb.getReadableDatabase();
        cursor1 = cursor;
        obj = s1;
        obj1 = jsonarray;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        cursor1 = cursor;
        obj = s1;
        obj1 = jsonarray;
        cursor = sqlitedatabase.rawQuery("SELECT * FROM events ORDER BY created_at ASC", null);
_L21:
        cursor1 = cursor;
        obj = s1;
        obj1 = cursor;
        jsonarray = new JSONArray();
_L15:
        cursor1 = cursor;
        obj = s;
        obj1 = cursor;
        if (cursor.moveToNext()) goto _L4; else goto _L3
_L3:
        s1 = ((String) (obj2));
        cursor1 = cursor;
        obj = s;
        obj1 = cursor;
        if (jsonarray.length() <= 0) goto _L6; else goto _L5
_L5:
        cursor1 = cursor;
        obj = s;
        obj1 = cursor;
        if (!Global.DEBUG) goto _L8; else goto _L7
_L7:
        cursor1 = cursor;
        obj = s;
        obj1 = cursor;
        obj2 = new StringBuilder("[JSON DATA VER 4] : ");
        cursor1 = cursor;
        obj = s;
        obj1 = cursor;
        if (jsonarray instanceof JSONArray) goto _L10; else goto _L9
_L9:
        cursor1 = cursor;
        obj = s;
        obj1 = cursor;
        s1 = jsonarray.toString();
_L16:
        cursor1 = cursor;
        obj = s;
        obj1 = cursor;
        Log.e("KochavaDbAdapter", ((StringBuilder) (obj2)).append(s1).toString());
_L8:
        cursor1 = cursor;
        obj = s;
        obj1 = cursor;
        if (jsonarray instanceof JSONArray) goto _L12; else goto _L11
_L11:
        cursor1 = cursor;
        obj = s;
        obj1 = cursor;
        s1 = jsonarray.toString();
_L17:
        cursor1 = cursor;
        obj = s;
        obj1 = cursor;
        s1 = Base64Coder.encodeString(s1);
_L6:
        kDb.close();
        obj1 = s1;
        obj2 = s;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        cursor.close();
        obj2 = s;
        obj1 = s1;
_L19:
        if (obj2 == null || obj1 == null) goto _L14; else goto _L13
_L13:
        obj = (new StringBuilder(String.valueOf(obj2))).append("=").append(((String) (obj1))).toString();
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L2:
        cursor1 = cursor;
        obj = s1;
        obj1 = jsonarray;
        cursor = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "SELECT * FROM events ORDER BY created_at ASC", null);
        continue; /* Loop/switch isn't completed */
_L4:
        s1 = s;
        cursor1 = cursor;
        obj = s;
        obj1 = cursor;
        if (!cursor.isLast())
        {
            break MISSING_BLOCK_LABEL_403;
        }
        cursor1 = cursor;
        obj = s;
        obj1 = cursor;
        s1 = cursor.getString(cursor.getColumnIndex("created_at"));
        cursor1 = cursor;
        obj = s1;
        obj1 = cursor;
        jsonarray.put(JSONObjectInstrumentation.init(cursor.getString(cursor.getColumnIndex("data"))));
        s = s1;
          goto _L15
        obj;
        s = s1;
          goto _L15
_L10:
        cursor1 = cursor;
        obj = s;
        obj1 = cursor;
        s1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
          goto _L16
_L12:
        cursor1 = cursor;
        obj = s;
        obj1 = cursor;
        s1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
          goto _L17
        SQLiteException sqliteexception;
        sqliteexception;
        obj1 = cursor1;
        if (!Global.DEBUG)
        {
            break MISSING_BLOCK_LABEL_514;
        }
        obj1 = cursor1;
        Log.e("KochavaDbAdapter", "generateDataString", sqliteexception);
        kDb.close();
        obj1 = obj3;
        obj2 = obj;
        if (cursor1 == null) goto _L19; else goto _L18
_L18:
        cursor1.close();
        obj1 = obj3;
        obj2 = obj;
          goto _L19
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        kDb.close();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_575;
        }
        ((Cursor) (obj1)).close();
        throw exception;
_L14:
        return null;
        if (true) goto _L21; else goto _L20
_L20:
    }

    public String getApplicationData(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        if (s.trim().length() != 0)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        this;
        JVM INSTR monitorexit ;
        return "";
        String s1;
        String s2;
        String s3;
        Object obj;
        obj = null;
        s3 = null;
        s2 = s3;
        s1 = obj;
        SQLiteDatabase sqlitedatabase = kDb.getReadableDatabase();
        s2 = s3;
        s1 = obj;
        s = (new StringBuilder("SELECT * FROM keys WHERE id='")).append(s).append("'").toString();
        s2 = s3;
        s1 = obj;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        s2 = s3;
        s1 = obj;
        s = sqlitedatabase.rawQuery(s, null);
_L4:
        s2 = s;
        s1 = s;
        if (!s.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = s;
        s1 = s;
        s3 = s.getString(s.getColumnIndex("data"));
        kDb.close();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        s.close();
        this;
        JVM INSTR monitorexit ;
        return s3;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        s2 = s3;
        s1 = obj;
        s = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, s, null);
        if (true) goto _L4; else goto _L3
        s;
        s1 = s2;
        if (!Global.DEBUG)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        s1 = s2;
        Log.e("KochavaDbAdapter", "generateDataString", s);
        kDb.close();
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        s2.close();
_L6:
        this;
        JVM INSTR monitorexit ;
        return null;
        s;
        kDb.close();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        s1.close();
        throw s;
_L3:
        kDb.close();
        if (s == null) goto _L6; else goto _L5
_L5:
        s.close();
          goto _L6
    }

    public void insertApplicationData(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        if (s.trim().length() != 0)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        SQLiteDatabase sqlitedatabase;
        ContentValues contentvalues;
        sqlitedatabase = kDb.getWritableDatabase();
        contentvalues = new ContentValues();
        contentvalues.put("id", s);
        contentvalues.put("data", s1);
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        sqlitedatabase.insert("keys", null, contentvalues);
_L3:
        kDb.close();
        if (true)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        throw new NullPointerException();
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "keys", null, contentvalues);
          goto _L3
        s;
        if (Global.DEBUG)
        {
            Log.e("KochavaDbAdapter", "addEvent", s);
        }
        kDb.close();
        if (true) goto _L5; else goto _L4
_L4:
        throw new NullPointerException();
        s;
        kDb.close();
        if (true)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        throw new NullPointerException();
        throw s;
          goto _L3
    }

    public void updateApplicationData(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        if (s.trim().length() != 0)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        SQLiteDatabase sqlitedatabase;
        ContentValues contentvalues;
        sqlitedatabase = kDb.getWritableDatabase();
        contentvalues = new ContentValues();
        contentvalues.put("data", s1);
        s = (new StringBuilder("id='")).append(s).append("'").toString();
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        sqlitedatabase.update("keys", contentvalues, s, null);
_L3:
        kDb.close();
        if (true)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        throw new NullPointerException();
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        SQLiteInstrumentation.update((SQLiteDatabase)sqlitedatabase, "keys", contentvalues, s, null);
          goto _L3
        s;
        if (Global.DEBUG)
        {
            Log.e("KochavaDbAdapter", "addEvent", s);
        }
        kDb.close();
        if (true) goto _L5; else goto _L4
_L4:
        throw new NullPointerException();
        s;
        kDb.close();
        if (true)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        throw new NullPointerException();
        throw s;
          goto _L3
    }
}
