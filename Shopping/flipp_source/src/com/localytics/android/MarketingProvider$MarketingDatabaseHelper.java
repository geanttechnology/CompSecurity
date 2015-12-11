// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.localytics.android:
//            LocalyticsDao, MarketingDownloader, BaseProvider

class t> extends t>
{

    protected void addControlGroup(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT 0;", new Object[] {
            "marketing_rules", "control_group"
        }));
    }

    protected void addNonUniqueRuleName(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
            "marketing_rules", "rule_name_non_unique"
        }));
        sqlitedatabase.execSQL(String.format("UPDATE %s SET %s = %s;", new Object[] {
            "marketing_rules", "rule_name_non_unique", "rule_name"
        }));
    }

    protected void addSchemaVersion(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT 1;", new Object[] {
            "marketing_rules", "schema_version"
        }));
    }

    protected void migrateV2ToV3(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor1;
        cursor1 = null;
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER, %s INTEGER, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER, %s INTEGER NOT NULL, %s TEXT, %s TEXT UNIQUE NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)", new Object[] {
            "marketing_rules", "_id", "campaign_id", "expiration", "display_seconds", "display_session", "version", "phone_location", "phone_size_width", "phone_size_height", 
            "tablet_location", "tablet_size_width", "tablet_size_height", "time_to_display", "internet_required", "ab_test", "rule_name", "location", "devices"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);", new Object[] {
            "marketing_ruleevent", "_id", "event_name", "rule_id_ref", "marketing_rules", "_id"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY);", new Object[] {
            "marketing_displayed", "campaign_id"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);", new Object[] {
            "marketing_conditions", "_id", "attribute_name", "operator", "rule_id_ref", "marketing_rules", "_id"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);", new Object[] {
            "marketing_condition_values", "_id", "value", "condition_id_ref", "marketing_conditions", "_id"
        }));
        if (oldDB == null) goto _L2; else goto _L1
_L1:
        SQLiteDatabase sqlitedatabase1 = oldDB;
        sqlitedatabase1;
        JVM INSTR monitorenter ;
        ContentValues contentvalues = new ContentValues();
        Cursor cursor = oldDB.query("amp_rules", null, null, null, null, null, "_id ASC");
        while (cursor.moveToNext()) 
        {
            contentvalues.put("_id", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("_id"))));
            contentvalues.put("campaign_id", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("campaign_id"))));
            contentvalues.put("expiration", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("expiration"))));
            contentvalues.put("display_seconds", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("display_seconds"))));
            contentvalues.put("display_session", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("display_session"))));
            contentvalues.put("version", cursor.getString(cursor.getColumnIndexOrThrow("version")));
            contentvalues.put("phone_location", cursor.getString(cursor.getColumnIndexOrThrow("phone_location")));
            contentvalues.put("phone_size_width", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("phone_size_width"))));
            contentvalues.put("phone_size_height", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("phone_size_height"))));
            contentvalues.put("tablet_location", cursor.getString(cursor.getColumnIndexOrThrow("tablet_location")));
            contentvalues.put("tablet_size_width", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("tablet_size_width"))));
            contentvalues.put("tablet_size_height", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("tablet_size_height"))));
            contentvalues.put("time_to_display", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("time_to_display"))));
            contentvalues.put("internet_required", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("internet_required"))));
            contentvalues.put("ab_test", cursor.getString(cursor.getColumnIndexOrThrow("ab_test")));
            contentvalues.put("rule_name", cursor.getString(cursor.getColumnIndexOrThrow("rule_name")));
            contentvalues.put("location", cursor.getString(cursor.getColumnIndexOrThrow("location")));
            contentvalues.put("devices", cursor.getString(cursor.getColumnIndexOrThrow("devices")));
            sqlitedatabase.insert("marketing_rules", null, contentvalues);
            contentvalues.clear();
        }
          goto _L3
        sqlitedatabase;
_L16:
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_773;
        }
        cursor.close();
        throw sqlitedatabase;
        sqlitedatabase;
        sqlitedatabase1;
        JVM INSTR monitorexit ;
        throw sqlitedatabase;
_L3:
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_793;
        }
        cursor.close();
        cursor = null;
        Cursor cursor2 = oldDB.query("amp_ruleevent", null, null, null, null, null, "_id ASC");
        cursor = cursor2;
        while (cursor.moveToNext()) 
        {
            contentvalues.put("_id", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("_id"))));
            contentvalues.put("event_name", cursor.getString(cursor.getColumnIndexOrThrow("event_name")));
            contentvalues.put("rule_id_ref", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("rule_id_ref"))));
            sqlitedatabase.insert("marketing_ruleevent", null, contentvalues);
            contentvalues.clear();
        }
          goto _L4
        sqlitedatabase;
_L14:
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_920;
        }
        cursor.close();
        throw sqlitedatabase;
_L4:
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_934;
        }
        cursor.close();
        cursor = null;
        cursor2 = oldDB.query("amp_displayed", null, null, null, null, null, "_id ASC");
        cursor = cursor2;
        break MISSING_BLOCK_LABEL_954;
        sqlitedatabase;
_L12:
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_1034;
        }
        cursor.close();
        throw sqlitedatabase;
        do
        {
            if (!cursor.moveToNext())
            {
                break;
            }
            if (cursor.getInt(cursor.getColumnIndexOrThrow("displayed")) == 1)
            {
                contentvalues.put("campaign_id", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("campaign_id"))));
                sqlitedatabase.insert("marketing_displayed", null, contentvalues);
                contentvalues.clear();
            }
        } while (true);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_1048;
        }
        cursor.close();
        cursor = null;
        cursor2 = oldDB.query("amp_conditions", null, null, null, null, null, "_id ASC");
        cursor = cursor2;
        while (cursor.moveToNext()) 
        {
            contentvalues.put("_id", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("_id"))));
            contentvalues.put("attribute_name", cursor.getString(cursor.getColumnIndexOrThrow("attribute_name")));
            contentvalues.put("operator", cursor.getString(cursor.getColumnIndexOrThrow("operator")));
            contentvalues.put("rule_id_ref", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("rule_id_ref"))));
            sqlitedatabase.insert("marketing_conditions", null, contentvalues);
            contentvalues.clear();
        }
          goto _L5
        sqlitedatabase;
_L10:
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_1196;
        }
        cursor.close();
        throw sqlitedatabase;
_L5:
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_1210;
        }
        cursor.close();
        cursor = cursor1;
        cursor1 = oldDB.query("amp_condition_values", null, null, null, null, null, "_id ASC");
        cursor = cursor1;
        while (cursor.moveToNext()) 
        {
            contentvalues.put("_id", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("_id"))));
            contentvalues.put("value", cursor.getString(cursor.getColumnIndexOrThrow("value")));
            contentvalues.put("condition_id_ref", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("condition_id_ref"))));
            sqlitedatabase.insert("marketing_condition_values", null, contentvalues);
            contentvalues.clear();
        }
          goto _L6
        sqlitedatabase;
_L8:
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_1335;
        }
        cursor.close();
        throw sqlitedatabase;
_L6:
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_1347;
        }
        cursor.close();
        cleanUpOldDB();
        sqlitedatabase1;
        JVM INSTR monitorexit ;
_L2:
        return;
        sqlitedatabase;
        if (true) goto _L8; else goto _L7
_L7:
        sqlitedatabase;
        if (true) goto _L10; else goto _L9
_L9:
        sqlitedatabase;
        if (true) goto _L12; else goto _L11
_L11:
        sqlitedatabase;
        if (true) goto _L14; else goto _L13
_L13:
        sqlitedatabase;
        cursor = null;
        if (true) goto _L16; else goto _L15
_L15:
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        if (sqlitedatabase == null)
        {
            throw new IllegalArgumentException("db cannot be null");
        } else
        {
            onUpgrade(sqlitedatabase, 0, 3);
            return;
        }
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        super.en(sqlitedatabase);
        en(String.format("SQLite library version is: %s", new Object[] {
            DatabaseUtils.stringForQuery(sqlitedatabase, "select sqlite_version()", null)
        }));
        if (!sqlitedatabase.isReadOnly())
        {
            sqlitedatabase.execSQL("PRAGMA foreign_keys = ON;");
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (i <= 0)
        {
            migrateV2ToV3(sqlitedatabase);
        }
        if (i < 2)
        {
            addNonUniqueRuleName(sqlitedatabase);
        }
        if (i < 3)
        {
            setUpFrequencyCappingTables(sqlitedatabase);
            addControlGroup(sqlitedatabase);
            addSchemaVersion(sqlitedatabase);
        }
    }

    protected void setUpFrequencyCappingTables(SQLiteDatabase sqlitedatabase)
    {
        Object obj1;
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER UNIQUE, %s INTEGER, %s INTEGER);", new Object[] {
            "frequency_capping_rules", "_id", "campaign_id", "max_display_count", "ignore_global"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE);", new Object[] {
            "frequency_capping_display_frequencies", "_id", "frequency_id", "count", "days", "frequency_id", "frequency_capping_rules", "_id"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE);", new Object[] {
            "frequency_capping_blackout_dates", "frequency_id", "rule_group_id", "start", "end", "frequency_id", "frequency_capping_rules", "_id"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE);", new Object[] {
            "frequency_capping_blackout_weekdays", "frequency_id", "rule_group_id", "day", "frequency_id", "frequency_capping_rules", "_id"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE);", new Object[] {
            "frequency_capping_blackout_times", "frequency_id", "rule_group_id", "start", "end", "frequency_id", "frequency_capping_rules", "_id"
        }));
        obj1 = new ArrayList();
        Object obj = sqlitedatabase.query("marketing_displayed", new String[] {
            "campaign_id"
        }, null, null, null, null, null);
        while (((Cursor) (obj)).moveToNext()) 
        {
            ((List) (obj1)).add(Integer.valueOf(((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("campaign_id"))));
        }
          goto _L1
        sqlitedatabase;
_L3:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
_L1:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL);", new Object[] {
            "campaigns_displayed", "campaign_id", "date", "ignore_global"
        }));
        for (obj = ((List) (obj1)).iterator(); ((Iterator) (obj)).hasNext(); sqlitedatabase.execSQL(String.format("INSERT INTO %s VALUES (?, datetime(0,'unixepoch'), ?);", new Object[] {
    "campaigns_displayed"
}), new Integer[] {
    obj1, Integer.valueOf(1)
}))
        {
            obj1 = (Integer)((Iterator) (obj)).next();
        }

        sqlitedatabase.execSQL(String.format("DROP TABLE %s", new Object[] {
            "marketing_displayed"
        }));
        sqlitedatabase.execSQL(String.format("DELETE FROM %s", new Object[] {
            "marketing_rules"
        }));
        BaseProvider.deleteDirectory(new File(MarketingDownloader.getMarketingDataDirectory(mLocalyticsDao.getAppContext(), mLocalyticsDao.getApiKey())));
        return;
        sqlitedatabase;
        obj = null;
        if (true) goto _L3; else goto _L2
_L2:
    }

    (String s, int i, LocalyticsDao localyticsdao)
    {
        super(s, i, localyticsdao);
    }
}
