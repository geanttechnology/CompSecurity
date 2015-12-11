// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzj, zzaj, zzx

class ry extends SQLiteOpenHelper
{

    final zzj zzNr;

    private void zza(SQLiteDatabase sqlitedatabase)
    {
        boolean flag1 = true;
        Set set = zzb(sqlitedatabase, "hits2");
        for (int i = 0; i < 4; i++)
        {
            String s = (new String[] {
                "hit_id", "hit_string", "hit_time", "hit_url"
            })[i];
            if (!set.remove(s))
            {
                throw new SQLiteException((new StringBuilder("Database hits2 is missing required column: ")).append(s).toString());
            }
        }

        boolean flag;
        if (!set.remove("hit_app_id"))
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        if (!set.isEmpty())
        {
            throw new SQLiteException("Database hits2 has extra columns");
        }
        if (flag)
        {
            sqlitedatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
        }
    }

    private boolean zza(SQLiteDatabase sqlitedatabase, String s)
    {
        SQLiteDatabase sqlitedatabase1 = null;
        sqlitedatabase = sqlitedatabase.query("SQLITE_MASTER", new String[] {
            "name"
        }, "name=?", new String[] {
            s
        }, null, null, null);
        sqlitedatabase1 = sqlitedatabase;
        sqlitedatabase = sqlitedatabase1;
        boolean flag = sqlitedatabase1.moveToFirst();
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        return flag;
        SQLiteException sqliteexception;
        sqliteexception;
        sqlitedatabase1 = null;
_L4:
        sqlitedatabase = sqlitedatabase1;
        zzNr.zzc("Error querying for table", s, sqliteexception);
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        return false;
        sqlitedatabase;
        s = sqlitedatabase1;
_L2:
        if (s != null)
        {
            s.close();
        }
        throw sqlitedatabase;
        Exception exception;
        exception;
        s = sqlitedatabase;
        sqlitedatabase = exception;
        if (true) goto _L2; else goto _L1
_L1:
        sqliteexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private Set zzb(SQLiteDatabase sqlitedatabase, String s)
    {
        HashSet hashset;
        hashset = new HashSet();
        sqlitedatabase = sqlitedatabase.rawQuery((new StringBuilder("SELECT * FROM ")).append(s).append(" LIMIT 0").toString(), null);
        s = sqlitedatabase.getColumnNames();
        int i = 0;
_L2:
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        hashset.add(s[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        sqlitedatabase.close();
        return hashset;
        s;
        sqlitedatabase.close();
        throw s;
    }

    private void zzb(SQLiteDatabase sqlitedatabase)
    {
        int i = 0;
        sqlitedatabase = zzb(sqlitedatabase, "properties");
        for (; i < 6; i++)
        {
            String s = (new String[] {
                "app_uid", "cid", "tid", "params", "adid", "hits_count"
            })[i];
            if (!sqlitedatabase.remove(s))
            {
                throw new SQLiteException((new StringBuilder("Database properties is missing required column: ")).append(s).toString());
            }
        }

        if (!sqlitedatabase.isEmpty())
        {
            throw new SQLiteException("Database properties table has extra columns");
        } else
        {
            return;
        }
    }

    public SQLiteDatabase getWritableDatabase()
    {
        if (!zzj.zza(zzNr).zzv(0x36ee80L))
        {
            throw new SQLiteException("Database open failed");
        }
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = super.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            zzj.zza(zzNr).start();
            zzNr.zzbe("Opening the database failed, dropping the table and recreating it");
            Object obj = zzj.zzb(zzNr);
            zzNr.getContext().getDatabasePath(((String) (obj))).delete();
            try
            {
                obj = super.getWritableDatabase();
                zzj.zza(zzNr).clear();
            }
            catch (SQLiteException sqliteexception1)
            {
                zzNr.zze("Failed to open freshly created database", sqliteexception1);
                throw sqliteexception1;
            }
            return ((SQLiteDatabase) (obj));
        }
        return sqlitedatabase;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        zzx.zzbl(sqlitedatabase.getPath());
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor;
        if (android.os.RSION.SDK_INT >= 15)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        cursor = sqlitedatabase.rawQuery("PRAGMA journal_mode=memory", null);
        cursor.moveToFirst();
        cursor.close();
        if (!zza(sqlitedatabase, "hits2"))
        {
            sqlitedatabase.execSQL(zzj.zzja());
        } else
        {
            zza(sqlitedatabase);
        }
        if (!zza(sqlitedatabase, "properties"))
        {
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            return;
        } else
        {
            zzb(sqlitedatabase);
            return;
        }
        sqlitedatabase;
        cursor.close();
        throw sqlitedatabase;
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }

    ry(zzj zzj1, Context context, String s)
    {
        zzNr = zzj1;
        super(context, s, null, 1);
    }
}
