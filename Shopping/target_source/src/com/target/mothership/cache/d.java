// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.target.a.a.b;
import com.target.mothership.services.e.h.b.a;
import com.target.mothership.services.e.h.b.c;
import com.target.mothership.services.e.h.b.i;
import com.target.mothership.services.e.h.b.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.cache:
//            i, CacheStoreSummary

public class d extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME = "mothership";
    private static final int DATABASE_VERSION = 6;
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_CITY = "CITY";
    public static final String KEY_COUNTRY = "COUNTRY";
    public static final String KEY_COUNTY = "COUNTY";
    public static final String KEY_EXPIRATION_TIME = "expiration_time";
    public static final String KEY_FORMATTED_ADDRESS = "FORMATTED_ADDRESS";
    public static final String KEY_FREQUENCY = "FREQUENCY";
    public static final String KEY_GUEST_ID = "GUEST_ID";
    public static final String KEY_HAS_REQUEST_TEAM_MEMBER = "HAS_REQUEST_TEAM_MEMBER";
    public static final String KEY_ID = "id";
    public static final String KEY_INSIDE = "INSIDE";
    public static final String KEY_IS_ANONYMOUS = "is_anonymous";
    public static final String KEY_LAST_RELEVANT = "LAST_RELEVANT";
    public static final String KEY_LAT = "LAT";
    public static final String KEY_LON = "LON";
    public static final String KEY_NAME = "NAME";
    public static final String KEY_OVERRIDE = "OVERRIDE";
    public static final String KEY_POSTAL_CODE = "POSTAL_CODE";
    public static final String KEY_RADIUS = "RADIUS";
    public static final String KEY_REFRESH_TOKEN = "refresh_token";
    public static final String KEY_STATE_OR_PROVINCE = "STATE_OR_PROVINCE";
    public static final String KEY_STORE_ID = "STORE_ID";
    public static final String KEY_STREET_ADDRESS = "STREET_ADDRESS";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_VERSION_NUMBER = "VERSION_NUMBER";
    public static final String TABLE_GUEST_STORE = "guest_store";
    public static final String TABLE_STORE = "store";
    public static final String TABLE_STORES_VERSION = "stores_version";
    public static final String TAG = com/target/mothership/cache/d.getSimpleName();

    public d(Context context)
    {
        super(context, "mothership", null, 6);
    }

    public void clearDatabase()
    {
        onUpgrade(getWritableDatabase(), 1, 2);
    }

    public List getAllStores()
    {
        Object obj;
        ArrayList arraylist;
        obj = getReadableDatabase();
        arraylist = new ArrayList();
        Object obj1 = i.ALL_STORE_COLUMNS;
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj = ((SQLiteDatabase) (obj)).query("store", ((String []) (obj1)), null, null, null, null, null);
_L4:
        while (((Cursor) (obj)).moveToNext()) 
        {
            arraylist.add(new CacheStoreSummary(((Cursor) (obj))));
        }
          goto _L3
        obj1;
_L9:
        b.a(TAG, (new StringBuilder()).append("Exception while trying to read the set store's data: ").append(obj1).toString());
        if (obj != null && !((Cursor) (obj)).isClosed())
        {
            ((Cursor) (obj)).close();
        }
_L6:
        return arraylist;
_L2:
        obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "store", ((String []) (obj1)), null, null, null, null, null);
          goto _L4
_L3:
        if (obj == null || ((Cursor) (obj)).isClosed()) goto _L6; else goto _L5
_L5:
        ((Cursor) (obj)).close();
        return arraylist;
        obj1;
        obj = null;
_L8:
        if (obj != null && !((Cursor) (obj)).isClosed())
        {
            ((Cursor) (obj)).close();
        }
        throw obj1;
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L8; else goto _L7
_L7:
        obj1;
        obj = null;
          goto _L9
    }

    public int getStoresVersion()
    {
        Object obj = getReadableDatabase();
        String as[] = new String[1];
        as[0] = "VERSION_NUMBER";
        if (obj instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        obj = ((SQLiteDatabase) (obj)).query("stores_version", as, null, null, null, null, null);
_L1:
        int k;
        ((Cursor) (obj)).moveToFirst();
        k = ((Cursor) (obj)).getInt(0);
        if (obj != null && !((Cursor) (obj)).isClosed())
        {
            ((Cursor) (obj)).close();
        }
        return k;
        obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "stores_version", as, null, null, null, null, null);
          goto _L1
        Exception exception;
        exception;
        obj = null;
_L3:
        if (obj != null && !((Cursor) (obj)).isClosed())
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        exception;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS store (STORE_ID TEXT PRIMARY KEY, NAME TEXT, LAT REAL, LON REAL, RADIUS REAL, STREET_ADDRESS TEXT, CITY TEXT, COUNTY TEXT, COUNTRY TEXT, POSTAL_CODE TEXT, STATE_OR_PROVINCE TEXT, FORMATTED_ADDRESS TEXT, HAS_REQUEST_TEAM_MEMBER INTEGER)");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE IF NOT EXISTS store (STORE_ID TEXT PRIMARY KEY, NAME TEXT, LAT REAL, LON REAL, RADIUS REAL, STREET_ADDRESS TEXT, CITY TEXT, COUNTY TEXT, COUNTRY TEXT, POSTAL_CODE TEXT, STATE_OR_PROVINCE TEXT, FORMATTED_ADDRESS TEXT, HAS_REQUEST_TEAM_MEMBER INTEGER)");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS stores_version(VERSION_NUMBER INTEGER)");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE IF NOT EXISTS stores_version(VERSION_NUMBER INTEGER)");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("INSERT INTO stores_version(VERSION_NUMBER) VALUES(0)");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "INSERT INTO stores_version(VERSION_NUMBER) VALUES(0)");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS guest_store(GUEST_ID TEXT, STORE_ID TEXT, FREQUENCY INTEGER, LAST_RELEVANT INTEGER, INSIDE INTEGER, OVERRIDE INTEGER)");
            return;
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE IF NOT EXISTS guest_store(GUEST_ID TEXT, STORE_ID TEXT, FREQUENCY INTEGER, LAST_RELEVANT INTEGER, INSIDE INTEGER, OVERRIDE INTEGER)");
            return;
        }
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int k, int l)
    {
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS store");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE IF EXISTS store");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS stores_version");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE IF EXISTS stores_version");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS guest_store");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE IF EXISTS guest_store");
        }
        onCreate(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int k, int l)
    {
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS store");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE IF EXISTS store");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS stores_version");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE IF EXISTS stores_version");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS guest_store");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE IF EXISTS guest_store");
        }
        onCreate(sqlitedatabase);
    }

    public void purgeStores()
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.beginTransaction();
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        sqlitedatabase.delete("store", "", null);
_L3:
        Object obj;
        obj = new ContentValues();
        ((ContentValues) (obj)).put("VERSION_NUMBER", Integer.valueOf(0));
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        sqlitedatabase.update("stores_version", ((ContentValues) (obj)), null, null);
_L4:
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
_L2:
        SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "store", "", null);
          goto _L3
        obj;
        sqlitedatabase.endTransaction();
        throw obj;
        SQLiteInstrumentation.update((SQLiteDatabase)sqlitedatabase, "stores_version", ((ContentValues) (obj)), null, null);
          goto _L4
    }

    public void updateStores(i k)
    {
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = getWritableDatabase();
        sqlitedatabase.beginTransaction();
        Object obj = k.c().iterator();
_L1:
        Object obj1;
        String as[];
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_128;
        }
        obj1 = (String)((Iterator) (obj)).next();
        as = new String[1];
        as[0] = ((String) (obj1));
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        sqlitedatabase.delete("store", "STORE_ID=?", as);
          goto _L1
        k;
        b.a("TGTServices", (new StringBuilder()).append("Exception while trying to update stores: ").append(k).toString());
        sqlitedatabase.endTransaction();
        return;
        SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "store", "STORE_ID=?", as);
          goto _L1
        k;
        sqlitedatabase.endTransaction();
        throw k;
        obj = k.b().iterator();
_L2:
        ContentValues contentvalues;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_458;
        }
        obj1 = (j)((Iterator) (obj)).next();
        contentvalues = new ContentValues();
        contentvalues.put("STORE_ID", ((j) (obj1)).a());
        contentvalues.put("NAME", ((j) (obj1)).b());
        int l;
        if (((j) (obj1)).e().booleanValue())
        {
            l = 1;
        } else
        {
            l = 0;
        }
label0:
        {
            contentvalues.put("HAS_REQUEST_TEAM_MEMBER", Integer.valueOf(l));
            if (((j) (obj1)).c() != null)
            {
                contentvalues.put("LAT", Double.valueOf(((j) (obj1)).c().a()));
                contentvalues.put("LON", Double.valueOf(((j) (obj1)).c().b()));
                contentvalues.put("RADIUS", Integer.valueOf(((j) (obj1)).c().c()));
            }
            if (((j) (obj1)).d() != null)
            {
                if (((j) (obj1)).d().a() != null && !((j) (obj1)).d().a().isEmpty())
                {
                    contentvalues.put("STREET_ADDRESS", (String)((j) (obj1)).d().a().get(0));
                }
                contentvalues.put("CITY", ((j) (obj1)).d().b());
                contentvalues.put("COUNTY", ((j) (obj1)).d().d());
                contentvalues.put("STATE_OR_PROVINCE", ((j) (obj1)).d().g());
                contentvalues.put("POSTAL_CODE", ((j) (obj1)).d().f());
                contentvalues.put("COUNTRY", ((j) (obj1)).d().c());
                contentvalues.put("FORMATTED_ADDRESS", ((j) (obj1)).d().e());
            }
            if (sqlitedatabase instanceof SQLiteDatabase)
            {
                break label0;
            }
            sqlitedatabase.replace("store", null, contentvalues);
        }
          goto _L2
        SQLiteInstrumentation.replace((SQLiteDatabase)sqlitedatabase, "store", null, contentvalues);
          goto _L2
        obj = new ContentValues();
        ((ContentValues) (obj)).put("VERSION_NUMBER", Integer.valueOf(k.a()));
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_505;
        }
        sqlitedatabase.update("stores_version", ((ContentValues) (obj)), null, null);
_L3:
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
        SQLiteInstrumentation.update((SQLiteDatabase)sqlitedatabase, "stores_version", ((ContentValues) (obj)), null, null);
          goto _L3
    }

}
