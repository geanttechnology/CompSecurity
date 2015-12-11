// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.google.ads.conversiontracking:
//            g, j

public class i
{
    public class a extends SQLiteOpenHelper
    {

        final i a;

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            String s = i.e();
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.execSQL(s);
                return;
            } else
            {
                SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, s);
                return;
            }
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int k, int l)
        {
            Log.i("GoogleConversionReporter", (new StringBuilder(64)).append("Database updated from version ").append(k).append(" to version ").append(l).toString());
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS conversiontracking");
            } else
            {
                SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE IF EXISTS conversiontracking");
            }
            onCreate(sqlitedatabase);
        }

        public a(Context context, String s)
        {
            a = i.this;
            super(context, s, null, 5);
        }
    }


    private static final String a;
    private final a b;
    private final Object c = new Object();

    public i(Context context)
    {
        b = new a(context, "google_conversion_tracking.db");
    }

    static String e()
    {
        return a;
    }

    public SQLiteDatabase a()
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = b.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            Log.w("GoogleConversionReporter", "Error opening writable conversion tracking database");
            return null;
        }
        return sqlitedatabase;
    }

    public g a(Cursor cursor)
    {
        boolean flag1 = true;
        if (cursor == null)
        {
            return null;
        }
        int k = cursor.getInt(7);
        String s1 = cursor.getString(1);
        String s = s1;
        if (k > 0)
        {
            s = Uri.parse(s1).buildUpon().appendQueryParameter("retry", Integer.toString(k)).build().toString();
        }
        long l = cursor.getLong(0);
        s1 = cursor.getString(2);
        boolean flag;
        if (cursor.getInt(3) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (cursor.getInt(4) <= 0)
        {
            flag1 = false;
        }
        return new g(l, s, s1, flag, flag1, cursor.getString(5), cursor.getLong(6), k);
    }

    public List a(long l)
    {
        Object obj2 = c;
        obj2;
        JVM INSTR monitorenter ;
        LinkedList linkedlist = new LinkedList();
        if (l > 0L)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        obj2;
        JVM INSTR monitorexit ;
        return linkedlist;
        Object obj = a();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        obj2;
        JVM INSTR monitorexit ;
        return linkedlist;
        Object obj1 = String.valueOf(l);
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj = ((SQLiteDatabase) (obj)).query("conversiontracking", null, null, null, null, null, "last_retry_time ASC", ((String) (obj1)));
_L5:
        obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst()) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        linkedlist.add(a(((Cursor) (obj))));
        obj1 = obj;
        boolean flag = ((Cursor) (obj)).moveToNext();
        if (flag) goto _L3; else goto _L4
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        ((Cursor) (obj)).close();
_L9:
        obj2;
        JVM INSTR monitorexit ;
        return linkedlist;
_L2:
        obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "conversiontracking", null, null, null, null, null, "last_retry_time ASC", ((String) (obj1)));
          goto _L5
        SQLiteException sqliteexception;
        sqliteexception;
        obj = null;
_L13:
        obj1 = obj;
        String s = String.valueOf(sqliteexception.getMessage());
        obj1 = obj;
        if (s.length() == 0) goto _L7; else goto _L6
_L6:
        obj1 = obj;
        s = "Error extracing ping Info: ".concat(s);
_L10:
        obj1 = obj;
        Log.w("GoogleConversionReporter", s);
        if (obj == null) goto _L9; else goto _L8
_L8:
        ((Cursor) (obj)).close();
          goto _L9
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
_L7:
        obj1 = obj;
        s = new String("Error extracing ping Info: ");
          goto _L10
        Exception exception;
        exception;
_L12:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_256;
        }
        ((Cursor) (obj1)).close();
        throw exception;
        exception;
        obj1 = null;
        if (true) goto _L12; else goto _L11
_L11:
        s;
          goto _L13
    }

    public void a(g g1)
    {
        if (g1 == null)
        {
            return;
        }
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = a();
        if (sqlitedatabase != null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        g1;
        obj;
        JVM INSTR monitorexit ;
        throw g1;
        g1 = String.format(Locale.US, "%s = %d", new Object[] {
            "conversion_ping_id", Long.valueOf(g1.h)
        });
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        sqlitedatabase.delete("conversiontracking", g1, null);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "conversiontracking", g1, null);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void b()
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = a();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        String s;
        s = String.format(Locale.US, "(%s > %d) or (%s < %d and %s > 0)", new Object[] {
            "retry_count", Long.valueOf(9000L), "record_time", Long.valueOf(j.a() - 0x2932e00L), "retry_count"
        });
        if (obj1 instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        ((SQLiteDatabase) (obj1)).delete("conversiontracking", s, null);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        SQLiteInstrumentation.delete((SQLiteDatabase)obj1, "conversiontracking", s, null);
          goto _L1
    }

    public void b(g g1)
    {
        boolean flag;
        flag = true;
        if (g1 == null)
        {
            return;
        }
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = a();
        if (sqlitedatabase != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        g1;
        obj;
        JVM INSTR monitorexit ;
        throw g1;
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        contentvalues.put("string_url", g1.g);
        contentvalues.put("preference_key", g1.f);
        int k;
        long l;
        if (g1.b)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        contentvalues.put("is_repeatable", Integer.valueOf(k));
        if (g1.a)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = 0;
        }
        contentvalues.put("parameter_is_null", Integer.valueOf(k));
        contentvalues.put("preference_name", g1.e);
        contentvalues.put("record_time", Long.valueOf(g1.d));
        contentvalues.put("retry_count", Integer.valueOf(0));
        contentvalues.put("last_retry_time", Long.valueOf(g1.d));
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        l = sqlitedatabase.insert("conversiontracking", null, contentvalues);
_L2:
        g1.h = l;
        b();
        if ((long)c() > 20000L)
        {
            d();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        l = SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "conversiontracking", null, contentvalues);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public int c()
    {
        Object obj;
        Object obj4;
        obj4 = null;
        obj = null;
        Object obj5 = c;
        obj5;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = a();
        if (sqlitedatabase != null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        obj5;
        JVM INSTR monitorexit ;
        return 0;
        Object obj2;
        Object obj3;
        obj3 = obj;
        obj2 = obj4;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj3 = obj;
        obj2 = obj4;
        obj = sqlitedatabase.rawQuery("select count(*) from conversiontracking", null);
_L4:
        obj3 = obj;
        obj2 = obj;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = obj;
        obj2 = obj;
        int k = ((Cursor) (obj)).getInt(0);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        ((Cursor) (obj)).close();
        obj5;
        JVM INSTR monitorexit ;
        return k;
        obj;
        obj5;
        JVM INSTR monitorexit ;
        throw obj;
_L2:
        obj3 = obj;
        obj2 = obj4;
        obj = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "select count(*) from conversiontracking", null);
        if (true) goto _L4; else goto _L3
_L3:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        ((Cursor) (obj)).close();
_L8:
        obj5;
        JVM INSTR monitorexit ;
        return 0;
        Object obj1;
        obj1;
        obj2 = obj3;
        obj1 = String.valueOf(((SQLiteException) (obj1)).getMessage());
        obj2 = obj3;
        if (((String) (obj1)).length() == 0) goto _L6; else goto _L5
_L5:
        obj2 = obj3;
        obj1 = "Error getting record count".concat(((String) (obj1)));
_L9:
        obj2 = obj3;
        Log.w("GoogleConversionReporter", ((String) (obj1)));
        if (obj3 == null) goto _L8; else goto _L7
_L7:
        ((Cursor) (obj3)).close();
          goto _L8
_L6:
        obj2 = obj3;
        obj1 = new String("Error getting record count");
          goto _L9
        obj1;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        ((Cursor) (obj2)).close();
        throw obj1;
          goto _L8
    }

    public void c(g g1)
    {
        if (g1 == null)
        {
            return;
        }
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = a();
        if (sqlitedatabase != null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        g1;
        obj;
        JVM INSTR monitorexit ;
        throw g1;
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        contentvalues.put("last_retry_time", Long.valueOf(j.a()));
        contentvalues.put("retry_count", Integer.valueOf(g1.c + 1));
        g1 = String.format(Locale.US, "%s = %d", new Object[] {
            "conversion_ping_id", Long.valueOf(g1.h)
        });
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        sqlitedatabase.update("conversiontracking", contentvalues, g1, null);
_L2:
        b();
        obj;
        JVM INSTR monitorexit ;
        return;
        SQLiteInstrumentation.update((SQLiteDatabase)sqlitedatabase, "conversiontracking", contentvalues, g1, null);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void d()
    {
        Object obj2 = c;
        obj2;
        JVM INSTR monitorenter ;
        Object obj = a();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        obj2;
        JVM INSTR monitorexit ;
        return;
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj = ((SQLiteDatabase) (obj)).query("conversiontracking", null, null, null, null, null, "record_time ASC", "1");
_L3:
        Object obj1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_73;
        }
        obj1 = obj;
        a(a(((Cursor) (obj))));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        ((Cursor) (obj)).close();
_L7:
        obj2;
        JVM INSTR monitorexit ;
        return;
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
_L2:
        obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "conversiontracking", null, null, null, null, null, "record_time ASC", "1");
          goto _L3
        SQLiteException sqliteexception;
        sqliteexception;
        obj = null;
_L11:
        obj1 = obj;
        String s = String.valueOf(sqliteexception.getMessage());
        obj1 = obj;
        if (s.length() == 0) goto _L5; else goto _L4
_L4:
        obj1 = obj;
        s = "Error remove oldest record".concat(s);
_L8:
        obj1 = obj;
        Log.w("GoogleConversionReporter", s);
        if (obj == null) goto _L7; else goto _L6
_L6:
        ((Cursor) (obj)).close();
          goto _L7
_L5:
        obj1 = obj;
        s = new String("Error remove oldest record");
          goto _L8
        Exception exception;
        exception;
_L10:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        ((Cursor) (obj1)).close();
        throw exception;
        exception;
        obj1 = null;
        if (true) goto _L10; else goto _L9
_L9:
        s;
          goto _L11
    }

    static 
    {
        a = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT, %s INTEGER, %s INTEGER, %s TEXT, %s INTEGER, %s INTEGER,%s INTEGER);", new Object[] {
            "conversiontracking", "conversion_ping_id", "string_url", "preference_key", "is_repeatable", "parameter_is_null", "preference_name", "record_time", "retry_count", "last_retry_time"
        });
    }
}
