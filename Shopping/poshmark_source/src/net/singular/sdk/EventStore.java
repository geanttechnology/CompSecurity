// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Pair;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package net.singular.sdk:
//            ManifestHelper, SingularSQLiteHelper, SingularLog, CountersLogger

class EventStore
{

    private static String ALL_COLUMNS[] = {
        "_id", "json"
    };
    static final String EVENTS_TABLE = "events";
    static final String ID_COLUMN = "_id";
    static final String JSON_COLUMN = "json";
    private CountersLogger countersLogger;
    private final SingularLog log;
    private final long maxStoreSize;
    private final SingularSQLiteHelper singularSQLiteHelper;

    public EventStore(SingularLog singularlog, SingularSQLiteHelper singularsqlitehelper, ManifestHelper manifesthelper, CountersLogger counterslogger)
    {
        log = singularlog;
        singularSQLiteHelper = singularsqlitehelper;
        maxStoreSize = manifesthelper.tryToGetManifestAttributeLong("net.singular.max_event_store_size", 1000L);
        countersLogger = counterslogger;
    }

    private boolean deleteEvent(long l)
    {
        boolean flag = true;
        SQLiteDatabase sqlitedatabase;
        String as[];
        sqlitedatabase = singularSQLiteHelper.getWritableDatabase();
        as = new String[1];
        log.d("singular_sdk", String.format("EventStore deleteEvent: %d", new Object[] {
            Long.valueOf(l)
        }));
        as[0] = Long.toString(l);
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        int i = sqlitedatabase.delete("events", "_id = ?", as);
_L4:
        if (i != 1)
        {
            flag = false;
        }
        updateEventsCounter();
        return flag;
_L2:
        Exception exception;
        try
        {
            i = SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "events", "_id = ?", as);
        }
        catch (SQLiteException sqliteexception)
        {
            updateEventsCounter();
            return false;
        }
        finally
        {
            updateEventsCounter();
        }
        if (true) goto _L4; else goto _L3
_L3:
        throw exception;
    }

    private int getEventCount()
        throws SQLiteException
    {
        Object obj;
        obj = singularSQLiteHelper.getReadableDatabase();
        String as[] = ALL_COLUMNS;
        int i;
        if (!(obj instanceof SQLiteDatabase))
        {
            obj = ((SQLiteDatabase) (obj)).query("events", as, null, null, null, null, null);
        } else
        {
            obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "events", as, null, null, null, null, null);
        }
        i = ((Cursor) (obj)).getCount();
        ((Cursor) (obj)).close();
        return i;
        Exception exception;
        exception;
        ((Cursor) (obj)).close();
        throw exception;
    }

    private long getOldestEvent()
        throws SQLiteException
    {
        Object obj;
        obj = singularSQLiteHelper.getReadableDatabase();
        log.d("singular_sdk", String.format("EventStore: getOldestEvent", new Object[0]));
        String as[] = ALL_COLUMNS;
        long l;
        if (!(obj instanceof SQLiteDatabase))
        {
            obj = ((SQLiteDatabase) (obj)).query("events", as, null, null, null, null, "_id ASC", "1");
        } else
        {
            obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "events", as, null, null, null, null, "_id ASC", "1");
        }
        ((Cursor) (obj)).moveToFirst();
        l = ((Cursor) (obj)).getLong(0);
        ((Cursor) (obj)).close();
        return l;
        Exception exception;
        exception;
        ((Cursor) (obj)).close();
        throw exception;
    }

    public static void onCreate(SQLiteDatabase sqlitedatabase, SingularLog singularlog)
    {
        singularlog.d("singular_sdk", String.format("EventStore onCreate", new Object[0]));
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table events(_id INTEGER primary key autoincrement, json text not null);");
            return;
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table events(_id INTEGER primary key autoincrement, json text not null);");
            return;
        }
    }

    public static void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j, SingularLog singularlog)
    {
        singularlog.d("singular_sdk", String.format("EventStore onUpgrade", new Object[0]));
        if (i != j)
        {
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS events;");
            } else
            {
                SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE IF EXISTS events;");
            }
            onCreate(sqlitedatabase, singularlog);
        }
    }

    private void updateEventsCounter()
    {
        int i = getEventCount();
        if (countersLogger != null)
        {
            countersLogger.setCounter("events_waiting_in_queue", i);
        }
    }

    public boolean addEvent(JSONObject jsonobject)
    {
        SQLiteDatabase sqlitedatabase;
        ContentValues contentvalues;
        log.d("singular_sdk", "EventStore: addEvent called");
        sqlitedatabase = singularSQLiteHelper.getWritableDatabase();
        contentvalues = new ContentValues();
        if (jsonobject instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        jsonobject = jsonobject.toString();
_L1:
        boolean flag;
        contentvalues.put("json", jsonobject);
        if ((long)getEventCount() < maxStoreSize)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        flag = deleteEvent(getOldestEvent());
        if (!flag)
        {
            updateEventsCounter();
            return false;
        }
        break MISSING_BLOCK_LABEL_91;
        jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
          goto _L1
        countersLogger.increaseCounter("event_store_was_full");
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L3; else goto _L2
_L2:
        long l = sqlitedatabase.insert("events", null, contentvalues);
          goto _L4
_L8:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        countersLogger.increaseCounter("total_events_since_install");
        updateEventsCounter();
        return flag;
_L3:
        l = SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "events", null, contentvalues);
          goto _L4
_L6:
        flag = false;
        continue; /* Loop/switch isn't completed */
        jsonobject;
        log.e("singular_sdk", "Failed saving event to DB", jsonobject);
        updateEventsCounter();
        return false;
        jsonobject;
        updateEventsCounter();
        throw jsonobject;
_L4:
        if (l == -1L) goto _L6; else goto _L5
_L5:
        flag = true;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean deleteAllEvents()
    {
        SQLiteDatabase sqlitedatabase = singularSQLiteHelper.getWritableDatabase();
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        sqlitedatabase.delete("events", "1", null);
_L4:
        updateEventsCounter();
        return true;
_L2:
        Exception exception;
        try
        {
            SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "events", "1", null);
        }
        catch (SQLiteException sqliteexception)
        {
            updateEventsCounter();
            return false;
        }
        finally
        {
            updateEventsCounter();
        }
        if (true) goto _L4; else goto _L3
_L3:
        throw exception;
    }

    public boolean deleteEvents(long l)
    {
        int i;
label0:
        {
            SQLiteDatabase sqlitedatabase = singularSQLiteHelper.getWritableDatabase();
            log.d("singular_sdk", String.format("EventStore deleteEvents: maxId=%d", new Object[] {
                Long.valueOf(l)
            }));
            String s = (new StringBuilder()).append("_id <= ").append(Long.toString(l)).toString();
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                i = sqlitedatabase.delete("events", s, null);
                break label0;
            }
            try
            {
                i = SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "events", s, null);
            }
            catch (SQLiteException sqliteexception)
            {
                return false;
            }
        }
        while (i <= 0) 
        {
            return false;
        }
        return true;
    }

    public Pair getEvents(int i)
    {
        Object obj2;
        obj2 = singularSQLiteHelper.getReadableDatabase();
        log.d("singular_sdk", String.format("EventStore getEvent: limit=%d", new Object[] {
            Integer.valueOf(i)
        }));
        Object obj = null;
        if (i != -1) goto _L2; else goto _L1
_L1:
        Object obj1 = obj;
        String as[] = ALL_COLUMNS;
        obj1 = obj;
        if (obj2 instanceof SQLiteDatabase) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        obj = ((SQLiteDatabase) (obj2)).query("events", as, null, null, null, null, "_id ASC", null);
_L8:
        obj1 = obj;
        obj2 = new JSONArray();
        long l;
        l = 0L;
        obj1 = obj;
        ((Cursor) (obj)).moveToFirst();
_L7:
        obj1 = obj;
        if (((Cursor) (obj)).isAfterLast()) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        l = ((Cursor) (obj)).getLong(0);
        obj1 = obj;
        as = ((Cursor) (obj)).getString(1);
        obj1 = obj;
        ((JSONArray) (obj2)).put(JSONObjectInstrumentation.init(as));
_L9:
        obj1 = obj;
        ((Cursor) (obj)).moveToNext();
          goto _L7
        obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        ((Cursor) (obj1)).close();
        throw obj;
        obj;
        obj1 = null;
_L11:
        return ((Pair) (obj1));
_L4:
        obj1 = obj;
        obj = SQLiteInstrumentation.query((SQLiteDatabase)obj2, "events", as, null, null, null, null, "_id ASC", null);
          goto _L8
_L2:
        obj1 = obj;
        as = ALL_COLUMNS;
        obj1 = obj;
        String s = Integer.toString(i);
        obj1 = obj;
        if (obj2 instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_249;
        }
        obj1 = obj;
        obj = ((SQLiteDatabase) (obj2)).query("events", as, null, null, null, null, "_id ASC", s);
          goto _L8
        obj1 = obj;
        obj = SQLiteInstrumentation.query((SQLiteDatabase)obj2, "events", as, null, null, null, null, "_id ASC", s);
          goto _L8
        obj1;
        obj1 = obj;
        log.e("singular_sdk", String.format("failed decoding event_id = %d", new Object[] {
            Long.valueOf(l)
        }));
        obj1 = obj;
        deleteEvent(l);
          goto _L9
_L6:
        obj1 = obj;
        obj2 = new Pair(Long.valueOf(l), obj2);
        obj1 = obj2;
        if (obj == null) goto _L11; else goto _L10
_L10:
        ((Cursor) (obj)).close();
        return ((Pair) (obj2));
          goto _L7
    }

}
