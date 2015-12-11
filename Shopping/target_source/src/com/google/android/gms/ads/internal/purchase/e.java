// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.b;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            d

public class e
{

    private static final String a = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[] {
        "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"
    });
    private static final Object c = new Object();
    private static e d;
    private final a b;

    e(Context context)
    {
    /* block-local class not found */
    class a {}

        b = new a(context, "google_inapp_purchase.db");
    }

    public static e a(Context context)
    {
        synchronized (c)
        {
            if (d == null)
            {
                d = new e(context);
            }
            context = d;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static String d()
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
            com.google.android.gms.ads.internal.util.client.b.e("Error opening writable conversion tracking database");
            return null;
        }
        return sqlitedatabase;
    }

    public d a(Cursor cursor)
    {
        if (cursor == null)
        {
            return null;
        } else
        {
            return new d(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
        }
    }

    public void a(d d1)
    {
        if (d1 == null)
        {
            return;
        }
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = a();
        if (sqlitedatabase != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        d1;
        obj;
        JVM INSTR monitorexit ;
        throw d1;
        d1 = String.format("%s = %d", new Object[] {
            "purchase_id", Long.valueOf(d1.a)
        });
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        sqlitedatabase.delete("InAppPurchase", d1, null);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "InAppPurchase", d1, null);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public int b()
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
            break MISSING_BLOCK_LABEL_29;
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
        obj = sqlitedatabase.rawQuery("select count(*) from InAppPurchase", null);
_L4:
        obj3 = obj;
        obj2 = obj;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = obj;
        obj2 = obj;
        int i = ((Cursor) (obj)).getInt(0);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        ((Cursor) (obj)).close();
        obj5;
        JVM INSTR monitorexit ;
        return i;
        obj;
        obj5;
        JVM INSTR monitorexit ;
        throw obj;
_L2:
        obj3 = obj;
        obj2 = obj4;
        obj = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "select count(*) from InAppPurchase", null);
        if (true) goto _L4; else goto _L3
_L3:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        ((Cursor) (obj)).close();
_L6:
        obj5;
        JVM INSTR monitorexit ;
        return 0;
        Object obj1;
        obj1;
        obj2 = obj3;
        com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Error getting record count").append(((SQLiteException) (obj1)).getMessage()).toString());
        if (obj3 == null) goto _L6; else goto _L5
_L5:
        ((Cursor) (obj3)).close();
          goto _L6
        obj1;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        ((Cursor) (obj2)).close();
        throw obj1;
    }

    public void b(d d1)
    {
        if (d1 == null)
        {
            return;
        }
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = a();
        if (sqlitedatabase != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        d1;
        obj;
        JVM INSTR monitorexit ;
        throw d1;
        ContentValues contentvalues;
        long l;
        contentvalues = new ContentValues();
        contentvalues.put("product_id", d1.c);
        contentvalues.put("developer_payload", d1.b);
        contentvalues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        l = sqlitedatabase.insert("InAppPurchase", null, contentvalues);
_L2:
        d1.a = l;
        if ((long)b() > 20000L)
        {
            c();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        l = SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "InAppPurchase", null, contentvalues);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void c()
    {
        Object obj2 = c;
        obj2;
        JVM INSTR monitorenter ;
        Object obj = a();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        obj2;
        JVM INSTR monitorexit ;
        return;
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj = ((SQLiteDatabase) (obj)).query("InAppPurchase", null, null, null, null, null, "record_time ASC", "1");
_L3:
        Object obj1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_70;
        }
        obj1 = obj;
        a(a(((Cursor) (obj))));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        ((Cursor) (obj)).close();
_L5:
        obj2;
        JVM INSTR monitorexit ;
        return;
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
_L2:
        obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "InAppPurchase", null, null, null, null, null, "record_time ASC", "1");
          goto _L3
        SQLiteException sqliteexception;
        sqliteexception;
        obj = null;
_L7:
        obj1 = obj;
        com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Error remove oldest record").append(sqliteexception.getMessage()).toString());
        if (obj == null) goto _L5; else goto _L4
_L4:
        ((Cursor) (obj)).close();
          goto _L5
_L6:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        ((Cursor) (obj1)).close();
        Exception exception;
        throw exception;
        exception;
          goto _L6
        sqliteexception;
          goto _L7
        exception;
        obj1 = null;
          goto _L6
    }

}
