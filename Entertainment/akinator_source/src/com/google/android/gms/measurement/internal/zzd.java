// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzy, zzac, zzp, zzc, 
//            zzs, zzh, zzag, zza, 
//            zzae, zzv

class zzd extends zzy
{
    private class zza extends SQLiteOpenHelper
    {

        final zzd zzaLW;

        private void zza(SQLiteDatabase sqlitedatabase, String s, String s1)
            throws SQLiteException
        {
            sqlitedatabase = zzb(sqlitedatabase, s);
            s1 = s1.split(",");
            int j = s1.length;
            for (int i = 0; i < j; i++)
            {
                String s2 = s1[i];
                if (!sqlitedatabase.remove(s2))
                {
                    throw new SQLiteException((new StringBuilder()).append("Database ").append(s).append(" is missing required column: ").append(s2).toString());
                }
            }

            if (!sqlitedatabase.isEmpty())
            {
                throw new SQLiteException((new StringBuilder()).append("Database ").append(s).append(" table has extra columns").toString());
            } else
            {
                return;
            }
        }

        private void zza(SQLiteDatabase sqlitedatabase, String s, String s1, String s2)
            throws SQLiteException
        {
            if (!zza(sqlitedatabase, s))
            {
                sqlitedatabase.execSQL(s1);
            }
            try
            {
                zza(sqlitedatabase, s, s2);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                zzaLW.zzyd().zzzK().zzj("Failed to verify columns on table that was just created", s);
            }
            throw sqlitedatabase;
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
            zzaLW.zzyd().zzzL().zze("Error querying for table", s, sqliteexception);
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
            sqlitedatabase = sqlitedatabase.rawQuery((new StringBuilder()).append("SELECT * FROM ").append(s).append(" LIMIT 0").toString(), null);
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

        public SQLiteDatabase getWritableDatabase()
        {
            if (!zzd.zza(zzaLW).zzv(zzaLW.zzzt().zzyX()))
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
                zzd.zza(zzaLW).start();
                zzaLW.zzyd().zzzK().zzec("Opening the database failed, dropping and recreating it");
                Object obj = zzd.zzb(zzaLW);
                zzaLW.getContext().getDatabasePath(((String) (obj))).delete();
                try
                {
                    obj = super.getWritableDatabase();
                    zzd.zza(zzaLW).clear();
                }
                catch (SQLiteException sqliteexception1)
                {
                    zzaLW.zzyd().zzzK().zzj("Failed to open freshly created database", sqliteexception1);
                    throw sqliteexception1;
                }
                return ((SQLiteDatabase) (obj));
            }
            return sqlitedatabase;
        }

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            if (android.os.Build.VERSION.SDK_INT >= 9)
            {
                sqlitedatabase = new File(sqlitedatabase.getPath());
                sqlitedatabase.setReadable(false, false);
                sqlitedatabase.setWritable(false, false);
                sqlitedatabase.setReadable(true, true);
                sqlitedatabase.setWritable(true, true);
            }
        }

        public void onOpen(SQLiteDatabase sqlitedatabase)
        {
            Cursor cursor;
            if (android.os.Build.VERSION.SDK_INT >= 15)
            {
                break MISSING_BLOCK_LABEL_29;
            }
            cursor = sqlitedatabase.rawQuery("PRAGMA journal_mode=memory", null);
            cursor.moveToFirst();
            cursor.close();
            zza(sqlitedatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp");
            zza(sqlitedatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value");
            zza(sqlitedatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp");
            zza(sqlitedatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data");
            return;
            sqlitedatabase;
            cursor.close();
            throw sqlitedatabase;
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
        }

        zza(Context context, String s)
        {
            zzaLW = zzd.this;
            super(context, s, null, 1);
        }
    }


    private final zza zzaLU;
    private final zzac zzaLV = new zzac(zzit());

    zzd(zzv zzv)
    {
        super(zzv);
        zzv = zziZ();
        zzaLU = new zza(getContext(), zzv);
    }

    static int zza(Cursor cursor, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return cursor.getType(i);
        }
        CursorWindow cursorwindow = ((SQLiteCursor)cursor).getWindow();
        int j = cursor.getPosition();
        if (cursorwindow.isNull(j, i))
        {
            return 0;
        }
        if (cursorwindow.isLong(j, i))
        {
            return 1;
        }
        if (cursorwindow.isFloat(j, i))
        {
            return 2;
        }
        if (cursorwindow.isString(j, i))
        {
            return 3;
        }
        return !cursorwindow.isBlob(j, i) ? -1 : 4;
    }

    private long zza(String s, String as[], long l)
    {
        String as1[];
        String as2[];
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = getWritableDatabase();
        as2 = null;
        as1 = null;
        as = sqlitedatabase.rawQuery(s, as);
        as1 = as;
        as2 = as;
        if (!as.moveToFirst()) goto _L2; else goto _L1
_L1:
        as1 = as;
        as2 = as;
        l = as.getLong(0);
        long l1;
        l1 = l;
        if (as != null)
        {
            as.close();
            l1 = l;
        }
_L4:
        return l1;
_L2:
        l1 = l;
        if (as == null) goto _L4; else goto _L3
_L3:
        as.close();
        return l;
        as;
        as2 = as1;
        zzyd().zzzK().zze("Database error", s, as);
        as2 = as1;
        throw as;
        s;
        if (as2 != null)
        {
            as2.close();
        }
        throw s;
    }

    static zzac zza(zzd zzd1)
    {
        return zzd1.zzaLV;
    }

    static String zzb(zzd zzd1)
    {
        return zzd1.zziZ();
    }

    private String zziZ()
    {
        if (!zzzt().zzjA())
        {
            return zzzt().zzka();
        }
        if (zzzt().zzjB())
        {
            return zzzt().zzka();
        } else
        {
            zzyd().zzzM().zzec("Using secondary database");
            return zzzt().zzkb();
        }
    }

    private void zzzv()
    {
        zzis();
        zziE();
        long l = zzzs().zzaNl.get();
        long l1 = zzit().elapsedRealtime();
        if (Math.abs(l1 - l) > zzzt().zzzd())
        {
            zzzs().zzaNl.set(l1);
            zzzw();
        }
    }

    public void beginTransaction()
    {
        zziE();
        getWritableDatabase().beginTransaction();
    }

    public void endTransaction()
    {
        zziE();
        getWritableDatabase().endTransaction();
    }

    SQLiteDatabase getWritableDatabase()
    {
        zzis();
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = zzaLU.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            zzyd().zzzL().zzj("Error opening database", sqliteexception);
            throw sqliteexception;
        }
        return sqlitedatabase;
    }

    public void setTransactionSuccessful()
    {
        zziE();
        getWritableDatabase().setTransactionSuccessful();
    }

    public zzh zzH(String s, String s1)
    {
        Object obj;
        obj = null;
        zzx.zzcr(s);
        zzx.zzcr(s1);
        zzis();
        zziE();
        Cursor cursor = getWritableDatabase().query("events", new String[] {
            "lifetime_count", "current_bundle_count", "last_fire_timestamp"
        }, "app_id=? and name=?", new String[] {
            s, s1
        }, null, null, null);
        boolean flag = cursor.moveToFirst();
        if (flag) goto _L2; else goto _L1
_L1:
        if (cursor != null)
        {
            cursor.close();
        }
        s = null;
_L4:
        return s;
_L2:
        obj = new zzh(s, s1, cursor.getLong(0), cursor.getLong(1), cursor.getLong(2));
        if (cursor.moveToNext())
        {
            zzyd().zzzK().zzec("Got multiple records for event aggregates, expected one");
        }
        s = ((String) (obj));
        if (cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
        return ((zzh) (obj));
        obj;
        cursor = null;
_L8:
        zzyd().zzzK().zzd("Error querying events", s, s1, obj);
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        s;
        s1 = ((String) (obj));
_L6:
        if (s1 != null)
        {
            s1.close();
        }
        throw s;
        s;
        s1 = cursor;
        continue; /* Loop/switch isn't completed */
        s;
        s1 = cursor;
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void zzI(String s, String s1)
    {
        zzx.zzcr(s);
        zzx.zzcr(s1);
        zzis();
        zziE();
        try
        {
            int i = getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[] {
                s, s1
            });
            zzyd().zzzQ().zzj("Deleted user attribute rows:", Integer.valueOf(i));
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            zzyd().zzzK().zzd("Error deleting user attribute", s, s1, sqliteexception);
        }
    }

    public void zzN(long l)
    {
        zzis();
        zziE();
        if (getWritableDatabase().delete("queue", "rowid=?", new String[] {
    String.valueOf(l)
}) != 1)
        {
            zzyd().zzzK().zzec("Deleted fewer rows from queue than expected");
        }
    }

    void zza(ContentValues contentvalues, String s, Object obj)
    {
        zzx.zzcr(s);
        zzx.zzw(obj);
        if (obj instanceof String)
        {
            contentvalues.put(s, (String)obj);
            return;
        }
        if (obj instanceof Long)
        {
            contentvalues.put(s, (Long)obj);
            return;
        }
        if (obj instanceof Float)
        {
            contentvalues.put(s, (Float)obj);
            return;
        } else
        {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public void zza(com.google.android.gms.internal.zzpk.zzd zzd1)
    {
        zzis();
        zziE();
        zzx.zzw(zzd1);
        zzx.zzcr(zzd1.zzaOX);
        zzx.zzw(zzd1.zzaOP);
        zzzv();
        long l = zzit().currentTimeMillis();
        if (zzd1.zzaOP.longValue() < l - zzzt().zzzc() || zzd1.zzaOP.longValue() > zzzt().zzzc() + l)
        {
            zzyd().zzzL().zze("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(l), zzd1.zzaOP);
        }
        byte abyte0[];
        ContentValues contentvalues;
        try
        {
            abyte0 = new byte[zzd1.zzFR()];
            zzrx zzrx1 = zzrx.zzC(abyte0);
            zzd1.zza(zzrx1);
            zzrx1.zzFE();
            abyte0 = zzzq().zzg(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.internal.zzpk.zzd zzd1)
        {
            zzyd().zzzK().zzj("Data loss. Failed to serialize bundle", zzd1);
            return;
        }
        zzyd().zzzQ().zzj("Saving bundle, size", Integer.valueOf(abyte0.length));
        contentvalues = new ContentValues();
        contentvalues.put("app_id", zzd1.zzaOX);
        contentvalues.put("bundle_end_timestamp", zzd1.zzaOP);
        contentvalues.put("data", abyte0);
        try
        {
            if (getWritableDatabase().insert("queue", null, contentvalues) == -1L)
            {
                zzyd().zzzK().zzec("Failed to insert bundle (got -1)");
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.internal.zzpk.zzd zzd1)
        {
            zzyd().zzzK().zzj("Error storing bundle", zzd1);
        }
    }

    public void zza(com.google.android.gms.measurement.internal.zza zza1)
    {
        zzx.zzw(zza1);
        zzis();
        zziE();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("app_id", zza1.zzaLl);
        contentvalues.put("app_instance_id", zza1.zzaLK);
        contentvalues.put("gmp_app_id", zza1.zzaLL);
        contentvalues.put("resettable_device_id_hash", zza1.zzaLM);
        contentvalues.put("last_bundle_index", Long.valueOf(zza1.zzaLN));
        contentvalues.put("last_bundle_end_timestamp", Long.valueOf(zza1.zzaLO));
        try
        {
            if (getWritableDatabase().insertWithOnConflict("apps", null, contentvalues, 5) == -1L)
            {
                zzyd().zzzK().zzec("Failed to insert/update app (got -1)");
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.measurement.internal.zza zza1)
        {
            zzyd().zzzK().zzj("Error storing app", zza1);
        }
    }

    public void zza(zzae zzae1)
    {
        zzx.zzw(zzae1);
        zzis();
        zziE();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("app_id", zzae1.zzaLl);
        contentvalues.put("name", zzae1.mName);
        contentvalues.put("set_timestamp", Long.valueOf(zzae1.zzaOy));
        zza(contentvalues, "value", zzae1.zzJy);
        try
        {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentvalues, 5) == -1L)
            {
                zzyd().zzzK().zzec("Failed to insert/update user attribute (got -1)");
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzae zzae1)
        {
            zzyd().zzzK().zzj("Error storing user attribute", zzae1);
        }
    }

    public void zza(zzh zzh1)
    {
        zzx.zzw(zzh1);
        zzis();
        zziE();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("app_id", zzh1.zzaLl);
        contentvalues.put("name", zzh1.mName);
        contentvalues.put("lifetime_count", Long.valueOf(zzh1.zzaMe));
        contentvalues.put("current_bundle_count", Long.valueOf(zzh1.zzaMf));
        contentvalues.put("last_fire_timestamp", Long.valueOf(zzh1.zzaMg));
        try
        {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentvalues, 5) == -1L)
            {
                zzyd().zzzK().zzec("Failed to insert/update event aggregates (got -1)");
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzh zzh1)
        {
            zzyd().zzzK().zzj("Error storing event aggregates", zzh1);
        }
    }

    Object zzb(Cursor cursor, int i)
    {
        int j = zza(cursor, i);
        switch (j)
        {
        default:
            zzyd().zzzK().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(j));
            return null;

        case 0: // '\0'
            zzyd().zzzK().zzec("Loaded invalid null value from database");
            return null;

        case 1: // '\001'
            return Long.valueOf(cursor.getLong(i));

        case 2: // '\002'
            return Float.valueOf(cursor.getFloat(i));

        case 3: // '\003'
            return cursor.getString(i);

        case 4: // '\004'
            zzyd().zzzK().zzec("Loaded invalid blob type value, ignoring it");
            break;
        }
        return null;
    }

    public List zzdZ(String s)
    {
        ArrayList arraylist;
        zzx.zzcr(s);
        zzis();
        zziE();
        arraylist = new ArrayList();
        Object obj;
        obj = getWritableDatabase();
        int i = zzzt().zzyW();
        obj = ((SQLiteDatabase) (obj)).query("user_attributes", new String[] {
            "name", "set_timestamp", "value"
        }, "app_id=?", new String[] {
            s
        }, null, null, "rowid", String.valueOf(i + 1));
        boolean flag = ((Cursor) (obj)).moveToFirst();
        if (!flag)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return arraylist;
        }
_L6:
        String s1;
        Object obj1;
        long l;
        s1 = ((Cursor) (obj)).getString(0);
        l = ((Cursor) (obj)).getLong(1);
        obj1 = zzb(((Cursor) (obj)), 2);
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        zzyd().zzzK().zzec("Read invalid user attribute value, ignoring it");
_L4:
        if (((Cursor) (obj)).moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        if (arraylist.size() > zzzt().zzyW())
        {
            zzyd().zzzK().zzec("Loaded too many user attributes");
            arraylist.remove(zzzt().zzyW());
        }
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return arraylist;
_L2:
        arraylist.add(new zzae(s, s1, l, obj1));
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
        SQLiteException sqliteexception;
        sqliteexception;
_L10:
        zzyd().zzzK().zze("Error querying user attributes", s, sqliteexception);
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        s;
        obj = null;
_L8:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L8; else goto _L7
_L7:
        sqliteexception;
        obj = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public com.google.android.gms.measurement.internal.zza zzea(String s)
    {
        Object obj1;
        obj1 = null;
        zzx.zzcr(s);
        zzis();
        zziE();
        Object obj = getWritableDatabase().query("apps", new String[] {
            "app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_end_timestamp"
        }, "app_id=?", new String[] {
            s
        }, null, null, null);
        boolean flag = ((Cursor) (obj)).moveToFirst();
        if (flag) goto _L2; else goto _L1
_L1:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        s = null;
_L4:
        return s;
_L2:
        obj1 = new com.google.android.gms.measurement.internal.zza(s, ((Cursor) (obj)).getString(0), ((Cursor) (obj)).getString(1), ((Cursor) (obj)).getString(2), ((Cursor) (obj)).getLong(3), ((Cursor) (obj)).getLong(4));
        if (((Cursor) (obj)).moveToNext())
        {
            zzyd().zzzK().zzec("Got multiple records for app, expected one");
        }
        s = ((String) (obj1));
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return ((com.google.android.gms.measurement.internal.zza) (obj1));
        obj1;
        obj = null;
_L8:
        zzyd().zzzK().zze("Error querying app", s, obj1);
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        s;
        obj = obj1;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void zzhR()
    {
    }

    public List zzn(String s, int i, int j)
    {
        Cursor cursor;
        boolean flag1 = true;
        zzis();
        zziE();
        List list;
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        if (j > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        zzx.zzcr(s);
        cursor = getWritableDatabase().query("queue", new String[] {
            "rowid", "data"
        }, "app_id=?", new String[] {
            s
        }, null, null, "rowid", String.valueOf(i));
        if (cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        list = Collections.emptyList();
        s = list;
        if (cursor != null)
        {
            cursor.close();
            s = list;
        }
_L6:
        return s;
_L2:
        ArrayList arraylist = new ArrayList();
        i = 0;
_L7:
        long l = cursor.getLong(0);
        Object obj1;
        byte abyte0[] = cursor.getBlob(1);
        obj1 = zzzq().zzp(abyte0);
        if (arraylist.isEmpty()) goto _L4; else goto _L3
_L3:
        int k = obj1.length;
        if (k + i <= j) goto _L4; else goto _L5
_L5:
        s = arraylist;
        if (cursor != null)
        {
            cursor.close();
            return arraylist;
        }
          goto _L6
        obj1;
        zzyd().zzzK().zze("Failed to unzip queued bundle", s, obj1);
_L8:
        if (!cursor.moveToNext() || i > j) goto _L5; else goto _L7
_L4:
        zzrw zzrw1;
        com.google.android.gms.internal.zzpk.zzd zzd1;
        zzrw1 = zzrw.zzB(((byte []) (obj1)));
        zzd1 = new com.google.android.gms.internal.zzpk.zzd();
        zzd1.zzx(zzrw1);
        i = obj1.length + i;
        arraylist.add(Pair.create(zzd1, Long.valueOf(l)));
          goto _L8
        Object obj;
        obj;
_L11:
        zzyd().zzzK().zze("Error querying bundles", s, obj);
        obj = Collections.emptyList();
        s = ((String) (obj));
        if (cursor != null)
        {
            cursor.close();
            return ((List) (obj));
        }
          goto _L6
        IOException ioexception;
        ioexception;
        zzyd().zzzK().zze("Failed to merge queued bundle", s, ioexception);
          goto _L8
        s;
        cursor = null;
_L10:
        if (cursor != null)
        {
            cursor.close();
        }
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L10; else goto _L9
_L9:
        obj;
        cursor = null;
          goto _L11
    }

    public String zzzu()
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = getWritableDatabase();
        obj = ((SQLiteDatabase) (obj)).query("queue", new String[] {
            "app_id"
        }, null, null, null, null, "rowid", "1");
        obj1 = obj;
        obj = obj1;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_70;
        }
        obj = obj1;
        String s = ((Cursor) (obj1)).getString(0);
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return s;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return null;
        Object obj2;
        obj2;
        obj1 = null;
_L4:
        obj = obj1;
        zzyd().zzzK().zzj("Database error getting next bundle app id", obj2);
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return null;
        obj;
_L2:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
        obj2;
        obj1 = obj;
        obj = obj2;
        if (true) goto _L2; else goto _L1
_L1:
        obj2;
        if (true) goto _L4; else goto _L3
_L3:
    }

    void zzzw()
    {
        zzis();
        zziE();
        int i = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[] {
            String.valueOf(zzit().currentTimeMillis()), String.valueOf(zzzt().zzzc())
        });
        if (i > 0)
        {
            zzyd().zzzQ().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(i));
        }
    }

    public long zzzx()
    {
        return zza("select max(bundle_end_timestamp) from queue", ((String []) (null)), 0L);
    }
}
