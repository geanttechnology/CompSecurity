// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            zzf

public class zzh
{
    public class zza extends SQLiteOpenHelper
    {

        final zzh zzCm;

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            String s = zzh.zzfj();
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

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaD((new StringBuilder()).append("Database updated from version ").append(i).append(" to version ").append(j).toString());
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            } else
            {
                SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE IF EXISTS InAppPurchase");
            }
            onCreate(sqlitedatabase);
        }

        public zza(Context context, String s)
        {
            zzCm = zzh.this;
            super(context, s, null, 4);
        }
    }


    private static final String zzCj;
    private static zzh zzCl;
    private static final Object zzpc = new Object();
    private final zza zzCk;

    zzh(Context context)
    {
        zzCk = new zza(context, "google_inapp_purchase.db");
    }

    static String zzfj()
    {
        return zzCj;
    }

    public static zzh zzx(Context context)
    {
        synchronized (zzpc)
        {
            if (zzCl == null)
            {
                zzCl = new zzh(context);
            }
            context = zzCl;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public int getRecordCount()
    {
        Object obj;
        Object obj4;
        obj4 = null;
        obj = null;
        Object obj5 = zzpc;
        obj5;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
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
        com.google.android.gms.ads.internal.util.client.zzb.zzaE((new StringBuilder()).append("Error getting record count").append(((SQLiteException) (obj1)).getMessage()).toString());
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

    public SQLiteDatabase getWritableDatabase()
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = zzCk.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Error opening writable conversion tracking database");
            return null;
        }
        return sqlitedatabase;
    }

    public zzf zza(Cursor cursor)
    {
        if (cursor == null)
        {
            return null;
        } else
        {
            return new zzf(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
        }
    }

    public void zza(zzf zzf1)
    {
        if (zzf1 == null)
        {
            return;
        }
        Object obj = zzpc;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        zzf1;
        obj;
        JVM INSTR monitorexit ;
        throw zzf1;
        zzf1 = String.format(Locale.US, "%s = %d", new Object[] {
            "purchase_id", Long.valueOf(zzf1.zzCd)
        });
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        sqlitedatabase.delete("InAppPurchase", zzf1, null);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "InAppPurchase", zzf1, null);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void zzb(zzf zzf1)
    {
        if (zzf1 == null)
        {
            return;
        }
        Object obj = zzpc;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        zzf1;
        obj;
        JVM INSTR monitorexit ;
        throw zzf1;
        ContentValues contentvalues;
        long l;
        contentvalues = new ContentValues();
        contentvalues.put("product_id", zzf1.zzCf);
        contentvalues.put("developer_payload", zzf1.zzCe);
        contentvalues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        l = sqlitedatabase.insert("InAppPurchase", null, contentvalues);
_L2:
        zzf1.zzCd = l;
        if ((long)getRecordCount() > 20000L)
        {
            zzfi();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        l = SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "InAppPurchase", null, contentvalues);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public List zzf(long l)
    {
        Object obj2 = zzpc;
        obj2;
        JVM INSTR monitorenter ;
        LinkedList linkedlist = new LinkedList();
        if (l > 0L)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        obj2;
        JVM INSTR monitorexit ;
        return linkedlist;
        Object obj = getWritableDatabase();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        obj2;
        JVM INSTR monitorexit ;
        return linkedlist;
        Object obj1 = String.valueOf(l);
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj = ((SQLiteDatabase) (obj)).query("InAppPurchase", null, null, null, null, null, "record_time ASC", ((String) (obj1)));
_L5:
        obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst()) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        linkedlist.add(zza(((Cursor) (obj))));
        obj1 = obj;
        boolean flag = ((Cursor) (obj)).moveToNext();
        if (flag) goto _L3; else goto _L4
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        ((Cursor) (obj)).close();
_L7:
        obj2;
        JVM INSTR monitorexit ;
        return linkedlist;
_L2:
        obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "InAppPurchase", null, null, null, null, null, "record_time ASC", ((String) (obj1)));
          goto _L5
        SQLiteException sqliteexception;
        sqliteexception;
        obj = null;
_L10:
        obj1 = obj;
        com.google.android.gms.ads.internal.util.client.zzb.zzaE((new StringBuilder()).append("Error extracing purchase info: ").append(sqliteexception.getMessage()).toString());
        if (obj == null) goto _L7; else goto _L6
_L6:
        ((Cursor) (obj)).close();
          goto _L7
        Exception exception;
        exception;
        obj2;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        obj1 = null;
_L9:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        ((Cursor) (obj1)).close();
        throw exception;
        exception;
        if (true) goto _L9; else goto _L8
_L8:
        sqliteexception;
          goto _L10
    }

    public void zzfi()
    {
        Object obj2 = zzpc;
        obj2;
        JVM INSTR monitorenter ;
        Object obj = getWritableDatabase();
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
        zza(zza(((Cursor) (obj))));
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
        com.google.android.gms.ads.internal.util.client.zzb.zzaE((new StringBuilder()).append("Error remove oldest record").append(sqliteexception.getMessage()).toString());
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

    static 
    {
        zzCj = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[] {
            "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"
        });
    }
}
