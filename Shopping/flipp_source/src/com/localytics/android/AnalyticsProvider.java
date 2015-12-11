// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;

// Referenced classes of package com.localytics.android:
//            BaseProvider, LocalyticsDao, DatapointHelper, Constants

class AnalyticsProvider extends BaseProvider
{

    static final int DATABASE_VERSION = 2;

    AnalyticsProvider(LocalyticsDao localyticsdao)
    {
        super(localyticsdao);
    }

    AnalyticsProvider(String s, LocalyticsDao localyticsdao)
    {
        super(localyticsdao);
        mDb = (new AnalyticsDatabaseHelper(String.format("com.localytics.android.%s.%s.sqlite", new Object[] {
            DatapointHelper.getSha256_buggy(localyticsdao.getApiKey()), s
        }), 2, localyticsdao)).getWritableDatabase();
    }

    boolean canAddToDB()
    {
        return (new File(mDb.getPath())).length() < maxSiloDbSize();
    }

    long maxSiloDbSize()
    {
        return Constants.dbMaxSizeForAnalytics;
    }

    private class AnalyticsDatabaseHelper extends BaseProvider.LocalyticsDatabaseHelper
    {

        protected void addFirstOpenEventToInfoTable(SQLiteDatabase sqlitedatabase)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "first_open_event_blob"
            }));
        }

        protected void migrateV2ToV3(SQLiteDatabase sqlitedatabase)
        {
            sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER NOT NULL);", new Object[] {
                "events", "_id", "blob", "upload_format"
            }));
            sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY, %s TEXT NOT NULL);", new Object[] {
                "identifiers", "key", "value"
            }));
            sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY, %s TEXT NOT NULL);", new Object[] {
                "custom_dimensions", "custom_dimension_key", "custom_dimension_value"
            }));
            sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT UNIQUE NOT NULL, %s TEXT UNIQUE NOT NULL, %s INTEGER NOT NULL CHECK (%s >= 0), %s INTEGER NOT NULL CHECK(%s IN (%s, %s)), %s INTEGER NOT NULL CHECK(%s IN (%s, %s)), %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s INTEGER CHECK (%s >= 0), %s INTEGER CHECK (%s >= 0), %s INTEGER NOT NULL CHECK (%s >= 0), %s INTEGER NOT NULL CHECK (%s >= 0), %s TEXT, %s INTEGER);", new Object[] {
                "info", "_id", "api_key", "uuid", "created_time", "created_time", "opt_out", "opt_out", "0", "1", 
                "push_disabled", "push_disabled", "0", "1", "sender_id", "registration_id", "registration_version", "customer_id", "user_type", "fb_attribution", 
                "play_attribution", "first_android_id", "first_advertising_id", "package_name", "app_version", "current_session_uuid", "last_session_open_time", "last_session_open_time", "last_session_close_time", "last_session_close_time", 
                "next_session_number", "next_session_number", "next_header_number", "next_header_number", "queued_close_session_blob", "queued_close_session_blob_upload_format"
            }));
            if (oldDB == null) goto _L2; else goto _L1
_L1:
            SQLiteDatabase sqlitedatabase1 = oldDB;
            sqlitedatabase1;
            JVM INSTR monitorenter ;
            ContentValues contentvalues = new ContentValues();
            long l;
            long l2;
            l2 = 1L;
            l = 1L;
            Object obj = oldDB.query("api_keys", null, null, null, null, null, null);
            if (!((Cursor) (obj)).moveToFirst()) goto _L4; else goto _L3
_L3:
            String s1;
            String s2;
            int i;
            int j;
            long l4;
            s2 = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("api_key"));
            s1 = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("uuid"));
            l4 = ((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndexOrThrow("created_time"));
            i = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("opt_out"));
            j = Integer.valueOf("1").intValue();
            Object obj1;
            Object obj2;
            String s;
            Object obj3;
            boolean flag;
            if (i == j)
            {
                flag = true;
            } else
            {
                flag = false;
            }
_L42:
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_462;
            }
            ((Cursor) (obj)).close();
            obj = null;
            obj1 = oldDB.query("identifiers", null, null, null, null, null, null);
            obj = obj1;
            s = null;
_L6:
            if (!((Cursor) (obj)).moveToNext())
            {
                break; /* Loop/switch isn't completed */
            }
            obj3 = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("key"));
            obj2 = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("value"));
            Object obj4;
            Object obj5;
            StringBuilder stringbuilder;
            Iterator iterator;
            long l1;
            long l3;
            if (((String) (obj3)).equals("customer_id"))
            {
                obj1 = obj2;
            } else
            {
                obj1 = s;
            }
            contentvalues.put("key", ((String) (obj3)));
            contentvalues.put("value", ((String) (obj2)));
            sqlitedatabase.insert("identifiers", null, contentvalues);
            contentvalues.clear();
            s = ((String) (obj1));
            if (true) goto _L6; else goto _L5
            sqlitedatabase;
            obj = null;
_L39:
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_594;
            }
            ((Cursor) (obj)).close();
            throw sqlitedatabase;
            sqlitedatabase1;
            JVM INSTR monitorexit ;
            throw sqlitedatabase;
_L5:
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_614;
            }
            ((Cursor) (obj)).close();
            obj = null;
            obj1 = oldDB.query("custom_dimensions", null, null, null, null, null, null);
            obj = obj1;
            while (((Cursor) (obj)).moveToNext()) 
            {
                contentvalues.put("custom_dimension_key", ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("custom_dimension_key")).replace("com.localytics.android:", ""));
                contentvalues.put("custom_dimension_value", ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("custom_dimension_value")));
                sqlitedatabase.insert("custom_dimensions", null, contentvalues);
                contentvalues.clear();
            }
              goto _L7
            sqlitedatabase;
_L37:
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_718;
            }
            ((Cursor) (obj)).close();
            throw sqlitedatabase;
_L38:
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_730;
            }
            ((Cursor) (obj)).close();
            throw sqlitedatabase;
_L7:
            if (obj == null) goto _L9; else goto _L8
_L8:
            ((Cursor) (obj)).close();
            obj3 = null;
_L41:
            if (s2 == null) goto _L11; else goto _L10
_L10:
            MigrationDatabaseHelper.preUploadBuildBlobs(oldDB);
            obj4 = null;
            obj1 = null;
            l1 = 0L;
            obj2 = null;
            l2 = 1L;
            obj = null;
            l = 1L;
_L25:
            obj5 = MigrationDatabaseHelper.convertDatabaseToJson(mLocalyticsDao.getAppContext(), oldDB, s2);
            if (((List) (obj5)).isEmpty()) goto _L13; else goto _L12
_L12:
            stringbuilder = new StringBuilder();
            iterator = ((List) (obj5)).iterator();
            obj5 = obj1;
            l3 = l1;
            long l5 = l;
            obj1 = obj2;
            obj2 = obj;
            l1 = l2;
            l = l3;
            obj = obj5;
            l3 = l5;
_L22:
            if (!iterator.hasNext()) goto _L15; else goto _L14
_L14:
            obj5 = (JSONObject)iterator.next();
            if (((JSONObject) (obj5)).getString("dt").equals("h"))
            {
                l2 = l3;
                if (obj4 != null)
                {
                    break MISSING_BLOCK_LABEL_1973;
                }
                class EventsV3Columns.UploadFormat extends Enum
                {

                    private static final EventsV3Columns.UploadFormat $VALUES[];
                    public static final EventsV3Columns.UploadFormat V2;
                    public static final EventsV3Columns.UploadFormat V3;
                    private final int value;

                    public static EventsV3Columns.UploadFormat valueOf(String s3)
                    {
                        return (EventsV3Columns.UploadFormat)Enum.valueOf(com/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat, s3);
                    }

                    public static EventsV3Columns.UploadFormat[] values()
                    {
                        return (EventsV3Columns.UploadFormat[])$VALUES.clone();
                    }

                    public final int getValue()
                    {
                        return value;
                    }

                    static 
                    {
                        V2 = new EventsV3Columns.UploadFormat("V2", 0, 2);
                        V3 = new EventsV3Columns.UploadFormat("V3", 1, 3);
                        $VALUES = (new EventsV3Columns.UploadFormat[] {
                            V2, V3
                        });
                    }

                private EventsV3Columns.UploadFormat(String s, int i, int j)
                {
                    super(s, i);
                    value = j;
                }
                }

                Object obj6;
                ContentValues contentvalues1;
                try
                {
                    l2 = ((JSONObject) (obj5)).getLong("seq");
                    break MISSING_BLOCK_LABEL_1973;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj5)
                {
                    l2 = l3;
                }
                finally { }
                break MISSING_BLOCK_LABEL_1234;
            }
            l2 = 1L + l3;
            ((JSONObject) (obj4)).put("seq", l3);
            ((JSONObject) (obj4)).put("u", UUID.randomUUID().toString());
            stringbuilder.append(((JSONObject) (obj4)).toString()).append("\n").append(((JSONObject) (obj5)).toString());
            if (!((JSONObject) (obj5)).getString("dt").equals("c")) goto _L17; else goto _L16
_L16:
            obj6 = stringbuilder.toString();
            l3 = ((Long)((JSONObject) (obj5)).get("ct")).longValue() * 1000L;
            if (obj1 == null) goto _L19; else goto _L18
_L18:
            contentvalues1 = new ContentValues();
            contentvalues1.put("upload_format", Integer.valueOf(EventsV3Columns.UploadFormat.V2.getValue()));
            if (l3 <= l) goto _L21; else goto _L20
_L20:
            contentvalues1.put("blob", ((String) (obj1)));
            sqlitedatabase.insert("events", null, contentvalues1);
_L19:
            obj1 = obj6;
            l = l3;
_L23:
            if (!((JSONObject) (obj5)).has("fl"))
            {
                break MISSING_BLOCK_LABEL_1103;
            }
            obj5 = ((JSONObject) (obj5)).getJSONArray("fl").join(",");
            obj2 = obj5;
_L24:
            contentvalues.clear();
            stringbuilder.delete(0, stringbuilder.length());
            l3 = l2;
              goto _L22
_L21:
            contentvalues1.put("blob", ((String) (obj6)));
            sqlitedatabase.insert("events", null, contentvalues1);
              goto _L23
_L17:
            if (!((JSONObject) (obj5)).getString("dt").equals("s"))
            {
                break MISSING_BLOCK_LABEL_1191;
            }
            l3 = ((JSONObject) (obj5)).getLong("nth");
            l1 = l3;
            obj5 = ((JSONObject) (obj5)).getString("u");
            obj = obj5;
            contentvalues.put("blob", stringbuilder.toString());
            contentvalues.put("upload_format", Integer.valueOf(EventsV3Columns.UploadFormat.V2.getValue()));
            sqlitedatabase.insert("events", null, contentvalues);
              goto _L24
            obj5;
_L36:
            l3 = l2;
              goto _L22
_L15:
            obj5 = obj;
            obj6 = obj1;
            l2 = l1;
            obj = obj2;
            obj1 = obj5;
            l1 = l;
            obj2 = obj6;
            l = l3;
              goto _L25
_L13:
            l3 = l2;
            obj4 = obj;
            l2 = l;
            l = l3;
            obj = obj2;
            obj2 = obj1;
            obj1 = obj4;
_L40:
            obj4 = oldDB.query("info", null, null, null, null, null, null);
            obj3 = obj4;
            if (!((Cursor) (obj3)).moveToFirst()) goto _L27; else goto _L26
_L26:
            contentvalues.put("api_key", s2);
            contentvalues.put("uuid", s1);
            contentvalues.put("created_time", Long.valueOf(l4));
            contentvalues.put("opt_out", Boolean.valueOf(flag));
            contentvalues.put("push_disabled", Integer.valueOf(((Cursor) (obj3)).getInt(((Cursor) (obj3)).getColumnIndexOrThrow("push_disabled"))));
            contentvalues.put("sender_id", ((Cursor) (obj3)).getString(((Cursor) (obj3)).getColumnIndexOrThrow("sender_id")));
            contentvalues.put("registration_id", ((Cursor) (obj3)).getString(((Cursor) (obj3)).getColumnIndexOrThrow("registration_id")));
            contentvalues.put("registration_version", ((Cursor) (obj3)).getString(((Cursor) (obj3)).getColumnIndexOrThrow("registration_version")));
            if (s == null) goto _L29; else goto _L28
_L28:
            contentvalues.put("customer_id", s);
            contentvalues.put("user_type", "known");
_L32:
            contentvalues.put("fb_attribution", ((Cursor) (obj3)).getString(((Cursor) (obj3)).getColumnIndexOrThrow("fb_attribution")));
            contentvalues.put("play_attribution", ((Cursor) (obj3)).getString(((Cursor) (obj3)).getColumnIndexOrThrow("play_attribution")));
            contentvalues.put("first_android_id", ((Cursor) (obj3)).getString(((Cursor) (obj3)).getColumnIndexOrThrow("first_android_id")));
            contentvalues.put("first_advertising_id", ((Cursor) (obj3)).getString(((Cursor) (obj3)).getColumnIndexOrThrow("first_advertising_id")));
            contentvalues.put("app_version", DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext()));
            contentvalues.put("package_name", ((Cursor) (obj3)).getString(((Cursor) (obj3)).getColumnIndexOrThrow("package_name")));
            contentvalues.put("current_session_uuid", ((String) (obj2)));
            l3 = ((Cursor) (obj3)).getLong(((Cursor) (obj3)).getColumnIndexOrThrow("last_session_open_time"));
            contentvalues.put("last_session_open_time", Long.valueOf(l3));
            contentvalues.put("last_session_close_time", Long.valueOf(l1));
            contentvalues.put("next_header_number", Long.valueOf(1L + l2));
            contentvalues.put("next_session_number", Long.valueOf(1L + l));
            if (l1 <= l3) goto _L31; else goto _L30
_L30:
            contentvalues.put("queued_close_session_blob", ((String) (obj)));
            contentvalues.put("queued_close_session_blob_upload_format", Integer.valueOf(EventsV3Columns.UploadFormat.V2.getValue()));
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_1755;
            }
            mLocalyticsDao.setScreenFlow(Arrays.asList(((String) (obj1)).split(",")));
_L34:
            sqlitedatabase.insert("info", null, contentvalues);
            contentvalues.clear();
_L27:
            if (obj3 == null)
            {
                break MISSING_BLOCK_LABEL_1782;
            }
            ((Cursor) (obj3)).close();
            cleanUpOldDB();
            sqlitedatabase1;
            JVM INSTR monitorexit ;
_L2:
            return;
_L29:
            contentvalues.put("customer_id", s1);
            contentvalues.put("user_type", "anonymous");
              goto _L32
            sqlitedatabase;
_L35:
            if (obj3 == null)
            {
                break MISSING_BLOCK_LABEL_1824;
            }
            ((Cursor) (obj3)).close();
            throw sqlitedatabase;
_L31:
            if (obj == null) goto _L34; else goto _L33
_L33:
            obj1 = new ContentValues();
            ((ContentValues) (obj1)).put("blob", ((String) (obj)));
            ((ContentValues) (obj1)).put("upload_format", Integer.valueOf(EventsV3Columns.UploadFormat.V2.getValue()));
            sqlitedatabase.insert("events", null, ((ContentValues) (obj1)));
              goto _L34
            sqlitedatabase;
              goto _L35
            obj5;
              goto _L36
            obj5;
              goto _L36
            obj5;
              goto _L36
            obj5;
              goto _L36
            sqlitedatabase;
              goto _L37
            sqlitedatabase;
              goto _L38
            sqlitedatabase;
              goto _L39
_L11:
            obj1 = null;
            obj2 = null;
            obj = null;
            l1 = 0L;
              goto _L40
_L9:
            obj3 = obj;
              goto _L41
_L4:
            s1 = null;
            s2 = null;
            l4 = 0L;
            flag = false;
              goto _L42
            sqlitedatabase;
              goto _L38
            obj4 = obj5;
            l3 = l2;
              goto _L22
        }

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            if (sqlitedatabase == null)
            {
                throw new IllegalArgumentException("db cannot be null");
            } else
            {
                sqlitedatabase.execSQL("PRAGMA auto_vacuum = INCREMENTAL;");
                onUpgrade(sqlitedatabase, 0, 2);
                return;
            }
        }

        public void onOpen(SQLiteDatabase sqlitedatabase)
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

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            if (i <= 0)
            {
                migrateV2ToV3(sqlitedatabase);
            }
            if (i < 2)
            {
                addFirstOpenEventToInfoTable(sqlitedatabase);
            }
        }

        AnalyticsDatabaseHelper(String s, int i, LocalyticsDao localyticsdao)
        {
            super(s, i, localyticsdao);
        }
    }

}
