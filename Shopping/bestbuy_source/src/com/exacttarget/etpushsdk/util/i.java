// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.exacttarget.etpushsdk.ETPush;
import com.exacttarget.etpushsdk.data.Registration;
import com.exacttarget.etpushsdk.database.a;
import com.exacttarget.etpushsdk.database.b;
import com.exacttarget.etpushsdk.database.c;
import com.exacttarget.etpushsdk.database.d;
import com.exacttarget.etpushsdk.database.e;
import com.exacttarget.etpushsdk.database.g;
import com.exacttarget.etpushsdk.database.h;

// Referenced classes of package com.exacttarget.etpushsdk.util:
//            m, a

public class i extends SQLiteOpenHelper
{

    private static i a = null;
    private SQLiteDatabase b;
    private Context c;

    private i(Context context)
    {
        super(context, "etdb.db", null, 7);
        b = null;
        c = null;
        c = context.getApplicationContext();
    }

    public static i a()
    {
        com/exacttarget/etpushsdk/util/i;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            throw new IllegalStateException("~!uf is not initialized, call initializeInstance(..) method first.");
        }
        break MISSING_BLOCK_LABEL_25;
        Exception exception;
        exception;
        com/exacttarget/etpushsdk/util/i;
        JVM INSTR monitorexit ;
        throw exception;
        i j = a;
        com/exacttarget/etpushsdk/util/i;
        JVM INSTR monitorexit ;
        return j;
    }

    public static void a(Context context)
    {
        com/exacttarget/etpushsdk/util/i;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            com.exacttarget.etpushsdk.util.m.a("~!uf", "New instance of ETSqliteOpenHelper.");
            a = new i(context);
            a().b();
        }
        com/exacttarget/etpushsdk/util/i;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    private void a(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor = sqlitedatabase.query("analytic_item", a.a, null, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                int j = cursor.getInt(cursor.getColumnIndex("id"));
                String s = cursor.getString(cursor.getColumnIndex("device_id"));
                String s1 = cursor.getString(cursor.getColumnIndex("et_app_id"));
                String s2 = cursor.getString(cursor.getColumnIndex("pi_app_key"));
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("device_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s));
                contentvalues.put("et_app_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s1));
                contentvalues.put("pi_app_key", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s2));
                sqlitedatabase.update("analytic_item", contentvalues, "id = ?", new String[] {
                    String.valueOf(j)
                });
            }

            cursor.close();
        }
    }

    private void b(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor = sqlitedatabase.query("beacon_request", b.a, null, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                int j = cursor.getInt(cursor.getColumnIndex("id"));
                String s = cursor.getString(cursor.getColumnIndex("device_id"));
                double d1 = cursor.getDouble(cursor.getColumnIndex("latitude"));
                double d2 = cursor.getDouble(cursor.getColumnIndex("longitude"));
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("device_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s));
                contentvalues.put("latitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(Double.valueOf(d1))));
                contentvalues.put("longitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(Double.valueOf(d2))));
                sqlitedatabase.update("beacon_request", contentvalues, "id = ?", new String[] {
                    String.valueOf(j)
                });
            }

            cursor.close();
        }
    }

    private void c(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor = sqlitedatabase.query("geofence_request", c.a, null, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                int j = cursor.getInt(cursor.getColumnIndex("id"));
                String s = cursor.getString(cursor.getColumnIndex("device_id"));
                double d1 = cursor.getDouble(cursor.getColumnIndex("latitude"));
                double d2 = cursor.getDouble(cursor.getColumnIndex("longitude"));
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("device_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s));
                contentvalues.put("latitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(Double.valueOf(d1))));
                contentvalues.put("longitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(Double.valueOf(d2))));
                sqlitedatabase.update("geofence_request", contentvalues, "id = ?", new String[] {
                    String.valueOf(j)
                });
            }

            cursor.close();
        }
    }

    private void d(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor = sqlitedatabase.query("location_update", d.a, null, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                int j = cursor.getInt(cursor.getColumnIndex("id"));
                String s = cursor.getString(cursor.getColumnIndex("device_id"));
                double d1 = cursor.getDouble(cursor.getColumnIndex("latitude"));
                double d2 = cursor.getDouble(cursor.getColumnIndex("longitude"));
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("device_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s));
                contentvalues.put("latitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(Double.valueOf(d1))));
                contentvalues.put("longitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(Double.valueOf(d2))));
                sqlitedatabase.update("location_update", contentvalues, "id = ?", new String[] {
                    String.valueOf(j)
                });
            }

            cursor.close();
        }
    }

    private void e(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor = sqlitedatabase.query("messages", e.a, null, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                String s = cursor.getString(cursor.getColumnIndex("id"));
                String s1 = cursor.getString(cursor.getColumnIndex("alert"));
                String s2 = cursor.getString(cursor.getColumnIndex("open_direct"));
                String s3 = cursor.getString(cursor.getColumnIndex("category"));
                String s4 = cursor.getString(cursor.getColumnIndex("url"));
                String s5 = cursor.getString(cursor.getColumnIndex("subject"));
                java.util.ArrayList arraylist = Registration.deserializeAttributes(new String(cursor.getBlob(cursor.getColumnIndex("keys"))));
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("alert", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s1));
                contentvalues.put("open_direct", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s2));
                contentvalues.put("category", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s3));
                contentvalues.put("url", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s4));
                contentvalues.put("subject", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s5));
                contentvalues.put("keys", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), Registration.serializeAttributes(arraylist)));
                sqlitedatabase.update("messages", contentvalues, "id = ?", new String[] {
                    s
                });
            }

            cursor.close();
        }
    }

    private void f(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor = sqlitedatabase.query("regions", g.a, null, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                String s = cursor.getString(cursor.getColumnIndex("id"));
                double d1 = cursor.getDouble(cursor.getColumnIndex("latitude"));
                double d2 = cursor.getDouble(cursor.getColumnIndex("longitude"));
                String s1 = cursor.getString(cursor.getColumnIndex("beacon_guid"));
                String s2 = cursor.getString(cursor.getColumnIndex("description"));
                String s3 = cursor.getString(cursor.getColumnIndex("name"));
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("latitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(Double.valueOf(d1))));
                contentvalues.put("longitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(Double.valueOf(d2))));
                contentvalues.put("beacon_guid", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s1));
                contentvalues.put("description", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s2));
                contentvalues.put("name", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s3));
                sqlitedatabase.update("regions", contentvalues, "id = ?", new String[] {
                    s
                });
            }

            cursor.close();
        }
    }

    private void g(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor = sqlitedatabase.query("registration", h.a, null, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                int j = cursor.getInt(cursor.getColumnIndex("id"));
                String s = cursor.getString(cursor.getColumnIndex("device_id"));
                String s1 = cursor.getString(cursor.getColumnIndex("subscriber_key"));
                String s2 = cursor.getString(cursor.getColumnIndex("et_app_id"));
                String s3 = cursor.getString(cursor.getColumnIndex("email"));
                String s4 = cursor.getString(cursor.getColumnIndex("gcm_sender_id"));
                java.util.TreeSet treeset = Registration.deserializeTags(new String(cursor.getBlob(cursor.getColumnIndex("tags"))));
                java.util.ArrayList arraylist = Registration.deserializeAttributes(new String(cursor.getBlob(cursor.getColumnIndex("attributes"))));
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("device_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s));
                if (cursor.getColumnIndex("device_token") >= 0)
                {
                    contentvalues.put("device_token", "");
                }
                contentvalues.put("subscriber_key", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s1));
                contentvalues.put("et_app_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s2));
                contentvalues.put("email", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s3));
                contentvalues.put("gcm_sender_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), s4));
                contentvalues.put("tags", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), Registration.serializeTags(treeset)));
                contentvalues.put("attributes", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), Registration.serializeAttributes(arraylist)));
                sqlitedatabase.update("registration", contentvalues, "id = ?", new String[] {
                    String.valueOf(j)
                });
            }

            cursor.close();
        }
    }

    public SQLiteDatabase b()
    {
        this;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            throw new IllegalStateException("~!uf is not initialized, call initializeInstance(..) method first.");
        }
        break MISSING_BLOCK_LABEL_23;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        SQLiteDatabase sqlitedatabase;
        if (b == null)
        {
            b = a.getWritableDatabase();
        }
        sqlitedatabase = b;
        this;
        JVM INSTR monitorexit ;
        return sqlitedatabase;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        b().execSQL("VACUUM");
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        try
        {
            com.exacttarget.etpushsdk.util.m.a("~!uf", "onCreate");
            sqlitedatabase.execSQL("CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, device_id VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, email VARCHAR, badge INTEGER, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, last_sent BIGINT, hwid VARCHAR, gcm_sender_id VARCHAR, locale VARCHAR );");
            sqlitedatabase.execSQL("CREATE TABLE beacon_request (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, latitude DOUBLE PRECISION, longitude DOUBLE PRECISION );");
            sqlitedatabase.execSQL("CREATE TABLE geofence_request (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, latitude DOUBLE PRECISION, longitude DOUBLE PRECISION );");
            sqlitedatabase.execSQL("CREATE TABLE location_update (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, latitude DOUBLE PRECISION, longitude DOUBLE PRECISION, accuracy INTEGER, timestamp VARCHAR, last_sent BIGINT );");
            sqlitedatabase.execSQL("CREATE TABLE messages (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, badge VARCHAR, open_direct VARCHAR, category VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, page_id VARCHAR, url VARCHAR, subject VARCHAR, site_id VARCHAR, read SMALLINT, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, message_deleted SMALLINT, min_tripped INTEGER, proximity INTEGER, ephemeral_message SMALLINT, has_entered SMALLINT, notify_id INTEGER, loiter_seconds INTEGER, entry_time BIGINT );");
            sqlitedatabase.execSQL("CREATE TABLE regions (id VARCHAR PRIMARY KEY, latitude DOUBLE PRECISION, longitude DOUBLE PRECISION, radius INTEGER, active SMALLINT, beacon_guid VARCHAR, beacon_major INTEGER, beacon_minor INTEGER, entry_count INTEGER, exit_count INTEGER, description VARCHAR, name VARCHAR, location_type INTEGER, has_entered SMALLINT );");
            sqlitedatabase.execSQL("CREATE TABLE region_message (id INTEGER PRIMARY KEY AUTOINCREMENT, region_id VARCHAR, message_id VARCHAR );");
            sqlitedatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, et_app_id VARCHAR, event_date VARCHAR, analytic_types VARCHAR, object_ids VARCHAR, value INTEGER, ready_to_send SMALLINT, pi_app_key VARCHAR, last_sent BIGINT );");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            com.exacttarget.etpushsdk.util.m.c("~!uf", "Can't create database", sqlitedatabase);
        }
        throw new RuntimeException(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int j, int k)
    {
        ContentValues contentvalues;
        if (j < 2)
        {
            try
            {
                com.exacttarget.etpushsdk.util.m.a("~!uf", (new StringBuilder()).append("Updating DB from ").append(j).append(" to 2").toString());
                sqlitedatabase.execSQL("ALTER TABLE registration ADD COLUMN last_sent BIGINT;");
                sqlitedatabase.execSQL("ALTER TABLE registration ADD COLUMN hwid VARCHAR;");
                sqlitedatabase.execSQL("ALTER TABLE registration ADD COLUMN gcm_sender_id VARCHAR;");
                sqlitedatabase.execSQL("ALTER TABLE location_update ADD COLUMN last_sent BIGINT;");
                sqlitedatabase.execSQL("ALTER TABLE messages ADD COLUMN message_deleted SMALLINT;");
            }
            catch (Exception exception)
            {
                com.exacttarget.etpushsdk.util.m.c("~!uf", "Can't update database. blow it away and re-create", exception);
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS registration");
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS beacon_request");
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS geofence_request");
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS location_update");
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS messages");
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS regions");
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS region_message");
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS analytic_item");
                onCreate(sqlitedatabase);
                return;
            }
        }
        if (j >= 3)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        sqlitedatabase.execSQL("ALTER TABLE regions ADD COLUMN beacon_guid VARCHAR;");
        sqlitedatabase.execSQL("ALTER TABLE regions ADD COLUMN beacon_major INTEGER;");
        sqlitedatabase.execSQL("ALTER TABLE regions ADD COLUMN beacon_minor INTEGER;");
        sqlitedatabase.execSQL("ALTER TABLE regions ADD COLUMN entry_count INTEGER;");
        sqlitedatabase.execSQL("ALTER TABLE regions ADD COLUMN exit_count INTEGER;");
        sqlitedatabase.execSQL("ALTER TABLE regions ADD COLUMN description VARCHAR;");
        sqlitedatabase.execSQL("ALTER TABLE regions ADD COLUMN location_type INTEGER;");
        sqlitedatabase.execSQL("ALTER TABLE regions ADD COLUMN name VARCHAR;");
        sqlitedatabase.execSQL("ALTER TABLE regions ADD COLUMN has_entered SMALLINT;");
        sqlitedatabase.execSQL("ALTER TABLE messages ADD COLUMN min_tripped INTEGER;");
        sqlitedatabase.execSQL("ALTER TABLE messages ADD COLUMN proximity INTEGER;");
        sqlitedatabase.execSQL("ALTER TABLE messages ADD COLUMN ephemeral_message SMALLINT;");
        sqlitedatabase.execSQL("ALTER TABLE messages ADD COLUMN has_entered SMALLINT;");
        sqlitedatabase.execSQL("ALTER TABLE messages ADD COLUMN notify_id INTEGER;");
        sqlitedatabase.execSQL("ALTER TABLE messages ADD COLUMN loiter_seconds INTEGER;");
        sqlitedatabase.execSQL("ALTER TABLE messages ADD COLUMN entry_time BIGINT;");
        sqlitedatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, et_app_id VARCHAR, event_date VARCHAR, analytic_types VARCHAR, object_ids VARCHAR, value INTEGER, ready_to_send SMALLINT, pi_app_key VARCHAR, last_sent BIGINT );");
        sqlitedatabase.execSQL("CREATE TABLE beacon_request (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, latitude DOUBLE PRECISION, longitude DOUBLE PRECISION );");
        if (j >= 4)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        sqlitedatabase.execSQL("ALTER TABLE registration ADD COLUMN locale TEXT;");
        if (j >= 5)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        sqlitedatabase.execSQL("ALTER TABLE messages ADD COLUMN category VARCHAR;");
        if (j >= 6)
        {
            break MISSING_BLOCK_LABEL_240;
        }
        sqlitedatabase.execSQL("ALTER TABLE analytic_item ADD COLUMN pi_app_key VARCHAR;");
        if (j >= 7)
        {
            break MISSING_BLOCK_LABEL_353;
        }
        contentvalues = new ContentValues();
        contentvalues.put("pi_app_key", (String)null);
        j = sqlitedatabase.update("analytic_item", contentvalues, "pi_app_key = ? ", new String[] {
            ""
        });
        com.exacttarget.etpushsdk.util.m.a("~!uf", (new StringBuilder()).append("PI App Rows updated to null: ").append(j).toString());
        a(sqlitedatabase);
        b(sqlitedatabase);
        d(sqlitedatabase);
        c(sqlitedatabase);
        d(sqlitedatabase);
        e(sqlitedatabase);
        f(sqlitedatabase);
        g(sqlitedatabase);
    }

}
