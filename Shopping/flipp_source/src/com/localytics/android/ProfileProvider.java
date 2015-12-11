// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;

// Referenced classes of package com.localytics.android:
//            BaseProvider, LocalyticsDao, DatapointHelper, Constants

class ProfileProvider extends BaseProvider
{

    static final int DATABASE_VERSION = 1;

    ProfileProvider(LocalyticsDao localyticsdao)
    {
        super(localyticsdao);
    }

    ProfileProvider(String s, LocalyticsDao localyticsdao)
    {
        super(localyticsdao);
        mDb = (new ProfileDatabaseHelper(String.format("com.localytics.android.%s.%s.sqlite", new Object[] {
            DatapointHelper.getSha256_buggy(localyticsdao.getApiKey()), s
        }), 1, localyticsdao)).getWritableDatabase();
    }

    boolean canAddToDB()
    {
        return (new File(mDb.getPath())).length() < maxSiloDbSize();
    }

    long maxSiloDbSize()
    {
        return Constants.dbMaxSizeForProfiles;
    }

    private class ProfileDatabaseHelper extends BaseProvider.LocalyticsDatabaseHelper
    {

        protected final void migrateV2ToV3(SQLiteDatabase sqlitedatabase)
        {
            sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)", new Object[] {
                "changes", "_id", "scope", "change", "customer_id"
            }));
            if (oldDB == null) goto _L2; else goto _L1
_L1:
            SQLiteDatabase sqlitedatabase1 = oldDB;
            sqlitedatabase1;
            JVM INSTR monitorenter ;
            Cursor cursor;
            ContentValues contentvalues;
            contentvalues = new ContentValues();
            cursor = oldDB.query("profile", null, null, null, null, null, "_id ASC");
_L5:
            boolean flag = cursor.moveToNext();
            if (!flag) goto _L4; else goto _L3
_L3:
            JSONObject jsonobject = new JSONObject(cursor.getString(cursor.getColumnIndexOrThrow("attribute")));
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("op", ProfileHandler.ProfileOperation.ASSIGN.getOperationString());
            String s = (String)jsonobject.keys().next();
            jsonobject1.put("attr", s);
            jsonobject1.put("value", jsonobject.get(s));
            contentvalues.put("scope", Localytics.ProfileScope.APPLICATION.getScope());
            contentvalues.put("change", jsonobject1.toString());
            contentvalues.put("customer_id", cursor.getString(cursor.getColumnIndexOrThrow("customer_id")));
            sqlitedatabase.insert("changes", null, contentvalues);
            contentvalues.clear();
              goto _L5
            JSONException jsonexception;
            jsonexception;
            Localytics.Log.w("Caught JSON exception", jsonexception);
              goto _L5
            sqlitedatabase;
_L7:
            if (cursor == null)
            {
                break MISSING_BLOCK_LABEL_262;
            }
            cursor.close();
            throw sqlitedatabase;
            sqlitedatabase;
            sqlitedatabase1;
            JVM INSTR monitorexit ;
            throw sqlitedatabase;
_L4:
            cleanUpOldDB();
            if (cursor == null)
            {
                break MISSING_BLOCK_LABEL_282;
            }
            cursor.close();
            sqlitedatabase1;
            JVM INSTR monitorexit ;
_L2:
            return;
            sqlitedatabase;
            cursor = null;
            if (true) goto _L7; else goto _L6
_L6:
        }

        public final void onCreate(SQLiteDatabase sqlitedatabase)
        {
            if (sqlitedatabase == null)
            {
                throw new IllegalArgumentException("db cannot be null");
            } else
            {
                sqlitedatabase.execSQL("PRAGMA auto_vacuum = INCREMENTAL;");
                onUpgrade(sqlitedatabase, 0, 1);
                return;
            }
        }

        public final void onOpen(SQLiteDatabase sqlitedatabase)
        {
            super.onOpen(sqlitedatabase);
            Localytics.Log.v(String.format("SQLite library version is: %s", new Object[] {
                DatabaseUtils.stringForQuery(sqlitedatabase, "select sqlite_version()", null)
            }));
            if (!sqlitedatabase.isReadOnly())
            {
                sqlitedatabase.execSQL("PRAGMA foreign_keys = ON;");
            }
        }

        public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            if (i <= 0)
            {
                migrateV2ToV3(sqlitedatabase);
            }
        }

        ProfileDatabaseHelper(String s, int i, LocalyticsDao localyticsdao)
        {
            super(s, i, localyticsdao);
        }
    }

}
