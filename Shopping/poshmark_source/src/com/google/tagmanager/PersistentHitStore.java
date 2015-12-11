// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.google.tagmanager:
//            HitStore, SimpleNetworkDispatcher, Log, HitStoreStateListener, 
//            Dispatcher, Clock, ServiceManagerImpl, Hit, 
//            FutureApis

class PersistentHitStore
    implements HitStore
{
    class StoreDispatchListener
        implements SimpleNetworkDispatcher.DispatchListener
    {

        final PersistentHitStore this$0;

        public void onHitDispatched(Hit hit)
        {
            deleteHit(hit.getHitId());
        }

        public void onHitPermanentDispatchFailure(Hit hit)
        {
            deleteHit(hit.getHitId());
            Log.v((new StringBuilder()).append("Permanent failure dispatching hitId: ").append(hit.getHitId()).toString());
        }

        public void onHitTransientDispatchFailure(Hit hit)
        {
            long l = hit.getHitFirstDispatchTime();
            if (l == 0L)
            {
                setHitFirstDispatchTime(hit.getHitId(), mClock.currentTimeMillis());
            } else
            if (0xdbba00L + l < mClock.currentTimeMillis())
            {
                deleteHit(hit.getHitId());
                Log.v((new StringBuilder()).append("Giving up on failed hitId: ").append(hit.getHitId()).toString());
                return;
            }
        }

        StoreDispatchListener()
        {
            this$0 = PersistentHitStore.this;
            super();
        }
    }

    class UrlDatabaseHelper extends SQLiteOpenHelper
    {

        private boolean mBadDatabase;
        private long mLastDatabaseCheckTime;
        final PersistentHitStore this$0;

        private boolean tablePresent(String s, SQLiteDatabase sqlitedatabase)
        {
            SQLiteDatabase sqlitedatabase1;
            SQLiteDatabase sqlitedatabase2;
            Object obj;
            Object obj1;
            obj1 = null;
            obj = null;
            sqlitedatabase1 = obj;
            sqlitedatabase2 = obj1;
            String as[] = new String[1];
            as[0] = "name";
            sqlitedatabase1 = obj;
            sqlitedatabase2 = obj1;
            String as1[] = new String[1];
            as1[0] = s;
            sqlitedatabase1 = obj;
            sqlitedatabase2 = obj1;
            if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
            sqlitedatabase1 = obj;
            sqlitedatabase2 = obj1;
            sqlitedatabase = sqlitedatabase.query("SQLITE_MASTER", as, "name=?", as1, null, null, null);
_L4:
            sqlitedatabase1 = sqlitedatabase;
            sqlitedatabase2 = sqlitedatabase;
            boolean flag = sqlitedatabase.moveToFirst();
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            return flag;
_L2:
            sqlitedatabase1 = obj;
            sqlitedatabase2 = obj1;
            sqlitedatabase = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "SQLITE_MASTER", as, "name=?", as1, null, null, null);
            if (true) goto _L4; else goto _L3
_L3:
            sqlitedatabase;
            sqlitedatabase2 = sqlitedatabase1;
            Log.w((new StringBuilder()).append("Error querying for table ").append(s).toString());
            if (sqlitedatabase1 != null)
            {
                sqlitedatabase1.close();
            }
            return false;
            s;
            if (sqlitedatabase2 != null)
            {
                sqlitedatabase2.close();
            }
            throw s;
        }

        private void validateColumnsPresent(SQLiteDatabase sqlitedatabase)
        {
            Object obj;
            String as[];
            int i;
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase = sqlitedatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            } else
            {
                sqlitedatabase = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "SELECT * FROM gtm_hits WHERE 0", null);
            }
            obj = new HashSet();
            as = sqlitedatabase.getColumnNames();
            i = 0;
_L2:
            if (i >= as.length)
            {
                break; /* Loop/switch isn't completed */
            }
            ((Set) (obj)).add(as[i]);
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            sqlitedatabase.close();
            if (!((Set) (obj)).remove("hit_id") || !((Set) (obj)).remove("hit_url") || !((Set) (obj)).remove("hit_time") || !((Set) (obj)).remove("hit_first_send_time"))
            {
                throw new SQLiteException("Database column missing");
            }
            break MISSING_BLOCK_LABEL_143;
            obj;
            sqlitedatabase.close();
            throw obj;
            if (!((Set) (obj)).isEmpty())
            {
                throw new SQLiteException("Database has extra columns");
            } else
            {
                return;
            }
        }

        public SQLiteDatabase getWritableDatabase()
        {
            SQLiteDatabase sqlitedatabase;
            if (mBadDatabase && mLastDatabaseCheckTime + 0x36ee80L > mClock.currentTimeMillis())
            {
                throw new SQLiteException("Database creation failed");
            }
            sqlitedatabase = null;
            mBadDatabase = true;
            mLastDatabaseCheckTime = mClock.currentTimeMillis();
            SQLiteDatabase sqlitedatabase1 = super.getWritableDatabase();
            sqlitedatabase = sqlitedatabase1;
_L2:
            SQLiteDatabase sqlitedatabase2 = sqlitedatabase;
            if (sqlitedatabase == null)
            {
                sqlitedatabase2 = super.getWritableDatabase();
            }
            mBadDatabase = false;
            return sqlitedatabase2;
            SQLiteException sqliteexception;
            sqliteexception;
            mContext.getDatabasePath(mDatabaseName).delete();
            if (true) goto _L2; else goto _L1
_L1:
        }

        boolean isBadDatabase()
        {
            return mBadDatabase;
        }

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            FutureApis.setOwnerOnlyReadWrite(sqlitedatabase.getPath());
        }

        public void onOpen(SQLiteDatabase sqlitedatabase)
        {
            Object obj;
            if (android.os.Build.VERSION.SDK_INT >= 15)
            {
                break MISSING_BLOCK_LABEL_36;
            }
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                obj = sqlitedatabase.rawQuery("PRAGMA journal_mode=memory", null);
            } else
            {
                obj = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "PRAGMA journal_mode=memory", null);
            }
            ((Cursor) (obj)).moveToFirst();
            ((Cursor) (obj)).close();
            if (!tablePresent("gtm_hits", sqlitedatabase))
            {
                obj = PersistentHitStore.CREATE_HITS_TABLE;
                if (!(sqlitedatabase instanceof SQLiteDatabase))
                {
                    sqlitedatabase.execSQL(((String) (obj)));
                    return;
                } else
                {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, ((String) (obj)));
                    return;
                }
            } else
            {
                validateColumnsPresent(sqlitedatabase);
                return;
            }
            sqlitedatabase;
            ((Cursor) (obj)).close();
            throw sqlitedatabase;
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
        }

        void setBadDatabase(boolean flag)
        {
            mBadDatabase = flag;
        }

        UrlDatabaseHelper(Context context, String s)
        {
            this$0 = PersistentHitStore.this;
            super(context, s, null, 1);
            mLastDatabaseCheckTime = 0L;
        }
    }


    private static final String CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[] {
        "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"
    });
    private static final String DATABASE_FILENAME = "gtm_urls.db";
    static final String HITS_TABLE = "gtm_hits";
    static final long HIT_DISPATCH_RETRY_WINDOW = 0xdbba00L;
    static final String HIT_FIRST_DISPATCH_TIME = "hit_first_send_time";
    static final String HIT_ID = "hit_id";
    private static final String HIT_ID_WHERE_CLAUSE = "hit_id=?";
    static final String HIT_TIME = "hit_time";
    static final String HIT_URL = "hit_url";
    private Clock mClock = new Clock() {

        final PersistentHitStore this$0;

        public long currentTimeMillis()
        {
            return System.currentTimeMillis();
        }

            
            {
                this$0 = PersistentHitStore.this;
                super();
            }
    };
    private final Context mContext;
    private final String mDatabaseName;
    private final UrlDatabaseHelper mDbHelper;
    private volatile Dispatcher mDispatcher;
    private long mLastDeleteStaleHitsTime;
    private final HitStoreStateListener mListener;

    PersistentHitStore(HitStoreStateListener hitstorestatelistener, Context context)
    {
        this(hitstorestatelistener, context, "gtm_urls.db");
    }

    PersistentHitStore(HitStoreStateListener hitstorestatelistener, Context context, String s)
    {
        mContext = context.getApplicationContext();
        mDatabaseName = s;
        mListener = hitstorestatelistener;
        mDbHelper = new UrlDatabaseHelper(mContext, mDatabaseName);
        mDispatcher = new SimpleNetworkDispatcher(new DefaultHttpClient(), mContext, new StoreDispatchListener());
        mLastDeleteStaleHitsTime = 0L;
    }

    private void deleteHit(long l)
    {
        deleteHits(new String[] {
            String.valueOf(l)
        });
    }

    private SQLiteDatabase getWritableDatabase(String s)
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = mDbHelper.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            Log.w(s);
            return null;
        }
        return sqlitedatabase;
    }

    private void removeOldHitIfFull()
    {
        int i = (getNumStoredHits() - 2000) + 1;
        if (i > 0)
        {
            List list = peekHitIds(i);
            Log.v((new StringBuilder()).append("Store full, deleting ").append(list.size()).append(" hits to make room.").toString());
            deleteHits((String[])list.toArray(new String[0]));
        }
    }

    private void setHitFirstDispatchTime(long l, long l1)
    {
        Object obj;
        ContentValues contentvalues;
        String as[];
        obj = getWritableDatabase("Error opening database for getNumStoredHits.");
        if (obj == null)
        {
            return;
        }
        contentvalues = new ContentValues();
        contentvalues.put("hit_first_send_time", Long.valueOf(l1));
        try
        {
            as = new String[1];
            as[0] = String.valueOf(l);
            if (!(obj instanceof SQLiteDatabase))
            {
                ((SQLiteDatabase) (obj)).update("gtm_hits", contentvalues, "hit_id=?", as);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.w((new StringBuilder()).append("Error setting HIT_FIRST_DISPATCH_TIME for hitId: ").append(l).toString());
            deleteHit(l);
            return;
        }
        SQLiteInstrumentation.update((SQLiteDatabase)obj, "gtm_hits", contentvalues, "hit_id=?", as);
        return;
    }

    private void writeHitToDatabase(long l, String s)
    {
        SQLiteDatabase sqlitedatabase;
        ContentValues contentvalues;
        sqlitedatabase = getWritableDatabase("Error opening database for putHit");
        if (sqlitedatabase == null)
        {
            return;
        }
        contentvalues = new ContentValues();
        contentvalues.put("hit_time", Long.valueOf(l));
        contentvalues.put("hit_url", s);
        contentvalues.put("hit_first_send_time", Integer.valueOf(0));
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        sqlitedatabase.insert("gtm_hits", null, contentvalues);
_L1:
        mListener.reportStoreIsEmpty(false);
        return;
        try
        {
            SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "gtm_hits", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("Error storing hit");
            return;
        }
          goto _L1
    }

    public void close()
    {
        try
        {
            mDbHelper.getWritableDatabase().close();
            mDispatcher.close();
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            Log.w("Error opening database for close");
        }
    }

    void deleteHits(String as[])
    {
        boolean flag = true;
        if (as != null && as.length != 0) goto _L2; else goto _L1
_L1:
        SQLiteDatabase sqlitedatabase;
        return;
_L2:
        if ((sqlitedatabase = getWritableDatabase("Error opening database for deleteHits.")) == null) goto _L1; else goto _L3
_L3:
        String s = String.format("HIT_ID in (%s)", new Object[] {
            TextUtils.join(",", Collections.nCopies(as.length, "?"))
        });
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        sqlitedatabase.delete("gtm_hits", s, as);
_L4:
        as = mListener;
        if (getNumStoredHits() != 0)
        {
            flag = false;
        }
        as.reportStoreIsEmpty(flag);
        return;
        try
        {
            SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "gtm_hits", s, as);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            Log.w("Error deleting hits");
            return;
        }
          goto _L4
    }

    int deleteStaleHits()
    {
        boolean flag = true;
        long l = mClock.currentTimeMillis();
        if (l > mLastDeleteStaleHitsTime + 0x5265c00L)
        {
            mLastDeleteStaleHitsTime = l;
            Object obj = getWritableDatabase("Error opening database for deleteStaleHits.");
            if (obj != null)
            {
                long l1 = mClock.currentTimeMillis();
                String as[] = new String[1];
                as[0] = Long.toString(l1 - 0x9a7ec800L);
                int i;
                if (!(obj instanceof SQLiteDatabase))
                {
                    i = ((SQLiteDatabase) (obj)).delete("gtm_hits", "HIT_TIME < ?", as);
                } else
                {
                    i = SQLiteInstrumentation.delete((SQLiteDatabase)obj, "gtm_hits", "HIT_TIME < ?", as);
                }
                obj = mListener;
                if (getNumStoredHits() != 0)
                {
                    flag = false;
                }
                ((HitStoreStateListener) (obj)).reportStoreIsEmpty(flag);
                return i;
            }
        }
        return 0;
    }

    public void dispatch()
    {
        Log.v("GTM Dispatch running...");
        if (mDispatcher.okToDispatch())
        {
            List list = peekHits(40);
            if (list.isEmpty())
            {
                Log.v("...nothing to dispatch");
                mListener.reportStoreIsEmpty(true);
                return;
            }
            mDispatcher.dispatchHits(list);
            if (getNumStoredUntriedHits() > 0)
            {
                ServiceManagerImpl.getInstance().dispatch();
                return;
            }
        }
    }

    public UrlDatabaseHelper getDbHelper()
    {
        return mDbHelper;
    }

    public Dispatcher getDispatcher()
    {
        return mDispatcher;
    }

    UrlDatabaseHelper getHelper()
    {
        return mDbHelper;
    }

    int getNumStoredHits()
    {
        Cursor cursor;
        Cursor cursor1;
        Cursor cursor2;
        Object obj;
        SQLiteDatabase sqlitedatabase;
        int i;
        boolean flag;
        flag = false;
        i = 0;
        sqlitedatabase = getWritableDatabase("Error opening database for getNumStoredHits.");
        if (sqlitedatabase == null)
        {
            return 0;
        }
        obj = null;
        cursor = null;
        cursor1 = cursor;
        cursor2 = obj;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        cursor1 = cursor;
        cursor2 = obj;
        cursor = sqlitedatabase.rawQuery("SELECT COUNT(*) from gtm_hits", null);
_L6:
        cursor1 = cursor;
        cursor2 = cursor;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        cursor1 = cursor;
        cursor2 = cursor;
        long l = cursor.getLong(0);
        i = (int)l;
        int j;
        j = i;
        if (cursor != null)
        {
            cursor.close();
            j = i;
        }
_L4:
        return j;
_L2:
        cursor1 = cursor;
        cursor2 = obj;
        try
        {
            cursor = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "SELECT COUNT(*) from gtm_hits", null);
            continue; /* Loop/switch isn't completed */
        }
        catch (SQLiteException sqliteexception)
        {
            cursor2 = cursor1;
        }
        finally
        {
            if (cursor2 != null)
            {
                cursor2.close();
            }
            throw exception;
        }
        Log.w("Error getting numStoredHits");
        j = ((flag) ? 1 : 0);
        if (cursor1 != null)
        {
            cursor1.close();
            j = ((flag) ? 1 : 0);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
    }

    int getNumStoredUntriedHits()
    {
        Cursor cursor;
        Cursor cursor1;
        Cursor cursor2;
        Object obj;
        SQLiteDatabase sqlitedatabase;
        int j;
        j = 0;
        sqlitedatabase = getWritableDatabase("Error opening database for getNumStoredHits.");
        if (sqlitedatabase == null)
        {
            return 0;
        }
        obj = null;
        cursor = null;
        cursor1 = cursor;
        cursor2 = obj;
        String as[] = new String[2];
        as[0] = "hit_id";
        as[1] = "hit_first_send_time";
        cursor1 = cursor;
        cursor2 = obj;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        cursor1 = cursor;
        cursor2 = obj;
        cursor = sqlitedatabase.query("gtm_hits", as, "hit_first_send_time=0", null, null, null, null);
_L6:
        cursor1 = cursor;
        cursor2 = cursor;
        int i = cursor.getCount();
        j = i;
        i = j;
        if (cursor != null)
        {
            cursor.close();
            i = j;
        }
_L4:
        return i;
_L2:
        cursor1 = cursor;
        cursor2 = obj;
        try
        {
            cursor = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "gtm_hits", as, "hit_first_send_time=0", null, null, null, null);
            continue; /* Loop/switch isn't completed */
        }
        catch (SQLiteException sqliteexception)
        {
            cursor2 = cursor1;
        }
        finally
        {
            if (cursor2 != null)
            {
                cursor2.close();
            }
            throw exception;
        }
        Log.w("Error getting num untried hits");
        i = j;
        if (cursor1 != null)
        {
            cursor1.close();
            i = j;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
    }

    List peekHitIds(int i)
    {
        ArrayList arraylist = new ArrayList();
        if (i > 0) goto _L2; else goto _L1
_L1:
        Log.w("Invalid maxHits specified. Skipping");
_L4:
        return arraylist;
_L2:
        SQLiteDatabase sqlitedatabase = getWritableDatabase("Error opening database for peekHitIds.");
        if (sqlitedatabase == null) goto _L4; else goto _L3
_L3:
        Cursor cursor;
        Cursor cursor1;
        Cursor cursor2;
        Object obj1;
        obj1 = null;
        cursor = null;
        cursor2 = cursor;
        cursor1 = obj1;
        String as[] = new String[1];
        as[0] = "hit_id";
        cursor2 = cursor;
        cursor1 = obj1;
        String s = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        cursor2 = cursor;
        cursor1 = obj1;
        String s1 = Integer.toString(i);
        cursor2 = cursor;
        cursor1 = obj1;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L6; else goto _L5
_L5:
        cursor2 = cursor;
        cursor1 = obj1;
        cursor = sqlitedatabase.query("gtm_hits", as, null, null, null, null, s, s1);
_L10:
        cursor2 = cursor;
        cursor1 = cursor;
        if (!cursor.moveToFirst())
        {
            continue; /* Loop/switch isn't completed */
        }
_L8:
        cursor2 = cursor;
        cursor1 = cursor;
        arraylist.add(String.valueOf(cursor.getLong(0)));
        cursor2 = cursor;
        cursor1 = cursor;
        boolean flag = cursor.moveToNext();
        if (flag) goto _L8; else goto _L7
_L7:
        if (cursor == null) goto _L4; else goto _L9
_L9:
        cursor.close();
        return arraylist;
_L6:
        cursor2 = cursor;
        cursor1 = obj1;
        cursor = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "gtm_hits", as, null, null, null, null, s, s1);
          goto _L10
        Object obj;
        obj;
        cursor1 = cursor2;
        Log.w((new StringBuilder()).append("Error in peekHits fetching hitIds: ").append(((SQLiteException) (obj)).getMessage()).toString());
        if (cursor2 == null) goto _L4; else goto _L11
_L11:
        cursor2.close();
        return arraylist;
        obj;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw obj;
    }

    public List peekHits(int i)
    {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        SQLiteDatabase sqlitedatabase;
        obj4 = new ArrayList();
        sqlitedatabase = getWritableDatabase("Error opening database for peekHits");
        if (sqlitedatabase == null)
        {
            return ((List) (obj4));
        }
        obj5 = null;
        obj = null;
        obj3 = obj;
        obj2 = obj5;
        String s = new String[3];
        s[0] = "hit_id";
        s[1] = "hit_time";
        s[2] = "hit_first_send_time";
        obj3 = obj;
        obj2 = obj5;
        String s1 = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        obj3 = obj;
        obj2 = obj5;
        String s2 = Integer.toString(i);
        obj3 = obj;
        obj2 = obj5;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj3 = obj;
        obj2 = obj5;
        obj = sqlitedatabase.query("gtm_hits", s, null, null, null, null, s1, s2);
_L10:
        obj3 = obj;
        obj2 = obj;
        obj5 = new ArrayList();
        int j;
        boolean flag;
        if (((Cursor) (obj)).moveToFirst())
        {
            do
            {
                ((List) (obj5)).add(new Hit(((Cursor) (obj)).getLong(0), ((Cursor) (obj)).getLong(1), ((Cursor) (obj)).getLong(2)));
                flag = ((Cursor) (obj)).moveToNext();
            } while (flag);
        }
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        j = 0;
        obj3 = obj;
        obj2 = obj;
        obj4 = new String[2];
        obj4[0] = "hit_id";
        obj4[1] = "hit_url";
        obj3 = obj;
        obj2 = obj;
        s = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        obj3 = obj;
        obj2 = obj;
        s1 = Integer.toString(i);
        obj3 = obj;
        obj2 = obj;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L4; else goto _L3
_L3:
        obj3 = obj;
        obj2 = obj;
        obj = sqlitedatabase.query("gtm_hits", ((String []) (obj4)), null, null, null, null, s, s1);
_L11:
        obj3 = obj;
        obj2 = obj;
        if (!((Cursor) (obj)).moveToFirst()) goto _L6; else goto _L5
_L5:
        i = j;
_L9:
        obj3 = obj;
        obj2 = obj;
        if (((SQLiteCursor)obj).getWindow().getNumRows() <= 0) goto _L8; else goto _L7
_L7:
        obj3 = obj;
        obj2 = obj;
        ((Hit)((List) (obj5)).get(i)).setHitUrl(((Cursor) (obj)).getString(1));
_L12:
        i++;
        obj3 = obj;
        obj2 = obj;
        boolean flag1 = ((Cursor) (obj)).moveToNext();
        if (flag1) goto _L9; else goto _L6
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return ((List) (obj5));
_L2:
        obj3 = obj;
        obj2 = obj5;
        obj = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "gtm_hits", s, null, null, null, null, s1, s2);
          goto _L10
        obj;
        obj5 = obj4;
        obj4 = obj;
        obj = obj3;
_L16:
        obj2 = obj;
        Log.w((new StringBuilder()).append("Error in peekHits fetching hitIds: ").append(((SQLiteException) (obj4)).getMessage()).toString());
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return ((List) (obj5));
        obj3;
        obj = obj2;
        obj2 = obj3;
_L15:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw obj2;
_L4:
        obj3 = obj;
        obj2 = obj;
        obj = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "gtm_hits", ((String []) (obj4)), null, null, null, null, s, s1);
          goto _L11
_L8:
        obj3 = obj;
        obj2 = obj;
        Log.w(String.format("HitString for hitId %d too large.  Hit will be deleted.", new Object[] {
            Long.valueOf(((Hit)((List) (obj5)).get(i)).getHitId())
        }));
          goto _L12
        Object obj1;
        obj1;
        obj2 = obj3;
        Log.w((new StringBuilder()).append("Error in peekHits fetching hit url: ").append(((SQLiteException) (obj1)).getMessage()).toString());
        obj2 = obj3;
        obj1 = new ArrayList();
        i = 0;
        obj2 = obj3;
        obj4 = ((List) (obj5)).iterator();
_L14:
        obj2 = obj3;
        if (!((Iterator) (obj4)).hasNext())
        {
            break MISSING_BLOCK_LABEL_687;
        }
        obj2 = obj3;
        obj5 = (Hit)((Iterator) (obj4)).next();
        obj2 = obj3;
        flag1 = TextUtils.isEmpty(((Hit) (obj5)).getHitUrl());
        j = i;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_704;
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_701;
        }
        if (obj3 != null)
        {
            ((Cursor) (obj3)).close();
        }
        return ((List) (obj1));
        j = 1;
        obj2 = obj3;
        ((List) (obj1)).add(obj5);
        i = j;
        if (true) goto _L14; else goto _L13
_L13:
        obj1;
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        throw obj1;
        obj2;
          goto _L15
        obj4;
          goto _L16
    }

    public void putHit(long l, String s)
    {
        deleteStaleHits();
        removeOldHitIfFull();
        writeHitToDatabase(l, s);
    }

    public void setClock(Clock clock)
    {
        mClock = clock;
    }

    void setDispatcher(Dispatcher dispatcher)
    {
        mDispatcher = dispatcher;
    }

    void setLastDeleteStaleHitsTime(long l)
    {
        mLastDeleteStaleHitsTime = l;
    }







}
