// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            f

public final class h
{
    public final class a extends SQLiteOpenHelper
    {

        final h a;

        public final void onCreate(SQLiteDatabase sqlitedatabase)
        {
            sqlitedatabase.execSQL(h.d());
        }

        public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            (new StringBuilder("Database updated from version ")).append(i).append(" to version ").append(j);
            com.google.android.gms.ads.internal.util.client.b.a(4);
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(sqlitedatabase);
        }

        public a(Context context, String s)
        {
            a = h.this;
            super(context, s, null, 4);
        }
    }


    static final Object a = new Object();
    private static final String b;
    private static h d;
    private final a c;

    private h(Context context)
    {
        c = new a(context, "google_inapp_purchase.db");
    }

    static f a(Cursor cursor)
    {
        if (cursor == null)
        {
            return null;
        } else
        {
            return new f(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
        }
    }

    public static h a(Context context)
    {
        synchronized (a)
        {
            if (d == null)
            {
                d = new h(context);
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
        return b;
    }

    public final SQLiteDatabase a()
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = c.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return null;
        }
        return sqlitedatabase;
    }

    public final void a(f f1)
    {
        if (f1 == null)
        {
            return;
        }
        Object obj = a;
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
        f1;
        obj;
        JVM INSTR monitorexit ;
        throw f1;
        sqlitedatabase.delete("InAppPurchase", String.format(Locale.US, "%s = %d", new Object[] {
            "purchase_id", Long.valueOf(f1.a)
        }), null);
        obj;
        JVM INSTR monitorexit ;
    }

    public final List b()
    {
        Object obj1 = a;
        obj1;
        JVM INSTR monitorenter ;
        LinkedList linkedlist = new LinkedList();
        if (10L > 0L)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        obj1;
        JVM INSTR monitorexit ;
        return linkedlist;
        Object obj = a();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        obj1;
        JVM INSTR monitorexit ;
        return linkedlist;
        Cursor cursor = ((SQLiteDatabase) (obj)).query("InAppPurchase", null, null, null, null, null, "record_time ASC", "10");
        obj = cursor;
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        obj = cursor;
        linkedlist.add(a(cursor));
        obj = cursor;
        boolean flag = cursor.moveToNext();
        if (flag) goto _L1; else goto _L2
_L2:
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        cursor.close();
_L4:
        obj1;
        JVM INSTR monitorexit ;
        return linkedlist;
        SQLiteException sqliteexception;
        sqliteexception;
        cursor = null;
_L7:
        obj = cursor;
        (new StringBuilder("Error extracing purchase info: ")).append(sqliteexception.getMessage());
        obj = cursor;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        if (cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
          goto _L4
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        Exception exception;
        exception;
        obj = null;
_L6:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        ((Cursor) (obj)).close();
        throw exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
        sqliteexception;
          goto _L7
    }

    public final int c()
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        Object obj3 = a;
        obj3;
        JVM INSTR monitorenter ;
        Object obj2 = a();
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        obj3;
        JVM INSTR monitorexit ;
        return 0;
        obj2 = ((SQLiteDatabase) (obj2)).rawQuery("select count(*) from InAppPurchase", null);
        obj = obj2;
        obj1 = obj2;
        if (!((Cursor) (obj2)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        obj = obj2;
        obj1 = obj2;
        int i = ((Cursor) (obj2)).getInt(0);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        ((Cursor) (obj2)).close();
        obj3;
        JVM INSTR monitorexit ;
        return i;
        obj;
        obj3;
        JVM INSTR monitorexit ;
        throw obj;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        ((Cursor) (obj2)).close();
_L2:
        obj3;
        JVM INSTR monitorexit ;
        return 0;
        SQLiteException sqliteexception;
        sqliteexception;
        obj1 = obj;
        (new StringBuilder("Error getting record count")).append(sqliteexception.getMessage());
        obj1 = obj;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        if (obj == null) goto _L2; else goto _L1
_L1:
        ((Cursor) (obj)).close();
          goto _L2
        Exception exception;
        exception;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        ((Cursor) (obj1)).close();
        throw exception;
    }

    static 
    {
        b = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[] {
            "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"
        });
    }
}
