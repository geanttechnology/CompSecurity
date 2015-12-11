// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzbg

class zzw
    implements DataLayer.zzc
{

    private static final String zzaWF = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[] {
        "datalayer", "ID", "key", "value", "expires"
    });
    private final Context mContext;
    private final Executor zzaWG;
    private zza zzaWH;
    private int zzaWI;
    private zzmn zzpW;

    public zzw(Context context)
    {
        this(context, zzmp.zzqt(), "google_tagmanager.db", 2000, ((Executor) (Executors.newSingleThreadExecutor())));
    }

    zzw(Context context, zzmn zzmn1, String s, int i, Executor executor)
    {
        mContext = context;
        zzpW = zzmn1;
        zzaWI = i;
        zzaWG = executor;
        zzaWH = new zza(mContext, s);
    }

    private List zzCJ()
    {
        List list;
        zzV(zzpW.currentTimeMillis());
        list = zzx(zzCK());
        zzCM();
        return list;
        Exception exception;
        exception;
        zzCM();
        throw exception;
    }

    private List zzCK()
    {
        Object obj;
        Object obj1;
        obj1 = zzeM("Error opening database for loadSerialized.");
        obj = new ArrayList();
        if (obj1 == null)
        {
            return ((List) (obj));
        }
        obj1 = ((SQLiteDatabase) (obj1)).query("datalayer", new String[] {
            "key", "value"
        }, null, null, null, null, "ID", null);
        while (((Cursor) (obj1)).moveToNext()) 
        {
            ((List) (obj)).add(new zzb(((Cursor) (obj1)).getString(0), ((Cursor) (obj1)).getBlob(1)));
        }
        break MISSING_BLOCK_LABEL_98;
        obj;
        ((Cursor) (obj1)).close();
        throw obj;
        ((Cursor) (obj1)).close();
        return ((List) (obj));
    }

    private int zzCL()
    {
        Cursor cursor;
        Object obj;
        Object obj1;
        int i;
        int j;
        obj = null;
        cursor = null;
        i = 0;
        j = 0;
        obj1 = zzeM("Error opening database for getNumStoredEntries.");
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        obj1 = ((SQLiteDatabase) (obj1)).rawQuery("SELECT COUNT(*) from datalayer", null);
        cursor = ((Cursor) (obj1));
        obj = obj1;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_63;
        }
        cursor = ((Cursor) (obj1));
        obj = obj1;
        long l = ((Cursor) (obj1)).getLong(0);
        i = (int)l;
        j = i;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
            return i;
        }
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        obj = cursor;
        zzbg.zzaH("Error getting numStoredEntries");
        if (cursor == null) goto _L1; else goto _L4
_L4:
        cursor.close();
        return 0;
        Exception exception;
        exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
    }

    private void zzCM()
    {
        try
        {
            zzaWH.close();
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            return;
        }
    }

    static String zzCN()
    {
        return zzaWF;
    }

    private byte[] zzI(Object obj)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ObjectOutputStream objectoutputstream = new ObjectOutputStream(bytearrayoutputstream);
        objectoutputstream.writeObject(obj);
        obj = bytearrayoutputstream.toByteArray();
        IOException ioexception;
        try
        {
            objectoutputstream.close();
            bytearrayoutputstream.close();
        }
        catch (IOException ioexception1)
        {
            return ((byte []) (obj));
        }
        return ((byte []) (obj));
        obj;
        objectoutputstream = null;
_L6:
        if (objectoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        objectoutputstream.close();
        bytearrayoutputstream.close();
        return null;
        obj;
        return null;
        obj;
        objectoutputstream = null;
_L4:
        if (objectoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        objectoutputstream.close();
        bytearrayoutputstream.close();
_L2:
        throw obj;
        ioexception;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void zzV(long l)
    {
        SQLiteDatabase sqlitedatabase = zzeM("Error opening database for deleteOlderThan.");
        if (sqlitedatabase == null)
        {
            return;
        }
        try
        {
            int i = sqlitedatabase.delete("datalayer", "expires <= ?", new String[] {
                Long.toString(l)
            });
            zzbg.v((new StringBuilder("Deleted ")).append(i).append(" expired items").toString());
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            zzbg.zzaH("Error deleting old entries.");
        }
    }

    static List zza(zzw zzw1)
    {
        return zzw1.zzCJ();
    }

    static void zza(zzw zzw1, String s)
    {
        zzw1.zzeL(s);
    }

    static void zza(zzw zzw1, List list, long l)
    {
        zzw1.zzb(list, l);
    }

    static Context zzb(zzw zzw1)
    {
        return zzw1.mContext;
    }

    private void zzb(List list, long l)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = zzpW.currentTimeMillis();
        zzV(l1);
        zzjt(list.size());
        zzc(list, l1 + l);
        zzCM();
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        zzCM();
        throw list;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
    }

    private void zzc(List list, long l)
    {
        SQLiteDatabase sqlitedatabase = zzeM("Error opening database for writeEntryToDatabase.");
        if (sqlitedatabase != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                zzb zzb1 = (zzb)list.next();
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("expires", Long.valueOf(l));
                contentvalues.put("key", zzb1.zzue);
                contentvalues.put("value", zzb1.zzaWO);
                sqlitedatabase.insert("datalayer", null, contentvalues);
            }
        }
    }

    private void zze(String as[])
    {
        SQLiteDatabase sqlitedatabase;
        if (as != null && as.length != 0)
        {
            if ((sqlitedatabase = zzeM("Error opening database for deleteEntries.")) != null)
            {
                String s = String.format("%s in (%s)", new Object[] {
                    "ID", TextUtils.join(",", Collections.nCopies(as.length, "?"))
                });
                try
                {
                    sqlitedatabase.delete("datalayer", s, as);
                    return;
                }
                catch (SQLiteException sqliteexception)
                {
                    zzbg.zzaH((new StringBuilder("Error deleting entries ")).append(Arrays.toString(as)).toString());
                }
                return;
            }
        }
    }

    private void zzeL(String s)
    {
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = zzeM("Error opening database for clearKeysWithPrefix.");
        if (sqlitedatabase == null)
        {
            return;
        }
        int i = sqlitedatabase.delete("datalayer", "key = ? OR key LIKE ?", new String[] {
            s, (new StringBuilder()).append(s).append(".%").toString()
        });
        zzbg.v((new StringBuilder("Cleared ")).append(i).append(" items").toString());
        zzCM();
        return;
        SQLiteException sqliteexception;
        sqliteexception;
        zzbg.zzaH((new StringBuilder("Error deleting entries with key prefix: ")).append(s).append(" (").append(sqliteexception).append(").").toString());
        zzCM();
        return;
        s;
        zzCM();
        throw s;
    }

    private SQLiteDatabase zzeM(String s)
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = zzaWH.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            zzbg.zzaH(s);
            return null;
        }
        return sqlitedatabase;
    }

    private void zzjt(int i)
    {
        i = (zzCL() - zzaWI) + i;
        if (i > 0)
        {
            List list = zzju(i);
            zzbg.zzaG((new StringBuilder("DataLayer store full, deleting ")).append(list.size()).append(" entries to make room.").toString());
            zze((String[])list.toArray(new String[0]));
        }
    }

    private List zzju(int i)
    {
        Object obj;
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (i <= 0)
        {
            zzbg.zzaH("Invalid maxEntries specified. Skipping.");
            return arraylist;
        }
        obj = zzeM("Error opening database for peekEntryIds.");
        if (obj == null)
        {
            return arraylist;
        }
        Object obj1;
        obj1 = String.format("%s ASC", new Object[] {
            "ID"
        });
        String s = Integer.toString(i);
        obj1 = ((SQLiteDatabase) (obj)).query("datalayer", new String[] {
            "ID"
        }, null, null, null, null, ((String) (obj1)), s);
        obj = obj1;
        if (!((Cursor) (obj1)).moveToFirst()) goto _L2; else goto _L1
_L1:
        obj = obj1;
        arraylist.add(String.valueOf(((Cursor) (obj1)).getLong(0)));
        obj = obj1;
        boolean flag = ((Cursor) (obj1)).moveToNext();
        if (flag) goto _L1; else goto _L2
_L2:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
_L3:
        return arraylist;
        SQLiteException sqliteexception;
        sqliteexception;
        obj1 = null;
_L6:
        obj = obj1;
        zzbg.zzaH((new StringBuilder("Error in peekEntries fetching entryIds: ")).append(sqliteexception.getMessage()).toString());
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
          goto _L3
        Exception exception;
        exception;
        obj = null;
_L5:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        exception;
        if (true) goto _L5; else goto _L4
_L4:
        sqliteexception;
          goto _L6
    }

    private Object zzu(byte abyte0[])
    {
        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
        abyte0 = new ObjectInputStream(bytearrayinputstream);
        Object obj = abyte0.readObject();
        try
        {
            abyte0.close();
            bytearrayinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return obj;
        }
        return obj;
        abyte0;
        abyte0 = null;
_L8:
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        abyte0.close();
        bytearrayinputstream.close();
        return null;
        abyte0;
        return null;
        abyte0;
        abyte0 = null;
_L6:
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        abyte0.close();
        bytearrayinputstream.close();
        return null;
        abyte0;
        return null;
        obj;
        abyte0 = null;
_L4:
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        abyte0.close();
        bytearrayinputstream.close();
_L2:
        throw obj;
        abyte0;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private List zzx(List list)
    {
        ArrayList arraylist = new ArrayList();
        zzb zzb1;
        for (list = list.iterator(); list.hasNext(); arraylist.add(new DataLayer.zza(zzb1.zzue, zzu(zzb1.zzaWO))))
        {
            zzb1 = (zzb)list.next();
        }

        return arraylist;
    }

    private List zzy(List list)
    {
        ArrayList arraylist = new ArrayList();
        DataLayer.zza zza1;
        for (list = list.iterator(); list.hasNext(); arraylist.add(new zzb(zza1.zzue, zzI(zza1.zzJy))))
        {
            zza1 = (DataLayer.zza)list.next();
        }

        return arraylist;
    }

    public void zza(DataLayer.zzc.zza zza1)
    {
        zzaWG.execute(new _cls2(zza1));
    }

    public void zza(List list, long l)
    {
        list = zzy(list);
        zzaWG.execute(new _cls1(list, l));
    }

    public void zzeK(String s)
    {
        zzaWG.execute(new _cls3(s));
    }


    private class zza extends SQLiteOpenHelper
    {

        final zzw zzaWL;

        private boolean zza(String s, SQLiteDatabase sqlitedatabase)
        {
            Object obj = null;
            sqlitedatabase = sqlitedatabase.query("SQLITE_MASTER", new String[] {
                "name"
            }, "name=?", new String[] {
                s
            }, null, null, null);
            boolean flag = sqlitedatabase.moveToFirst();
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            return flag;
            sqlitedatabase;
            sqlitedatabase = null;
_L4:
            zzbg.zzaH((new StringBuilder("Error querying for table ")).append(s).toString());
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            return false;
            s;
            sqlitedatabase = obj;
_L2:
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            throw s;
            s;
            continue; /* Loop/switch isn't completed */
            s;
            if (true) goto _L2; else goto _L1
_L1:
            SQLiteException sqliteexception;
            sqliteexception;
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void zzc(SQLiteDatabase sqlitedatabase)
        {
            Object obj;
            sqlitedatabase = sqlitedatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            obj = new HashSet();
            String as[] = sqlitedatabase.getColumnNames();
            int i = 0;
_L2:
            if (i >= as.length)
            {
                break; /* Loop/switch isn't completed */
            }
            ((Set) (obj)).add(as[i]);
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            sqlitedatabase.close();
            if (!((Set) (obj)).remove("key") || !((Set) (obj)).remove("value") || !((Set) (obj)).remove("ID") || !((Set) (obj)).remove("expires"))
            {
                throw new SQLiteException("Database column missing");
            }
            break MISSING_BLOCK_LABEL_122;
            obj;
            sqlitedatabase.close();
            throw obj;
            if (!((Set) (obj)).isEmpty())
            {
                throw new SQLiteException("Database has extra columns");
            } else
            {
                return;
            }
        }

        public SQLiteDatabase getWritableDatabase()
        {
            SQLiteDatabase sqlitedatabase = null;
            SQLiteDatabase sqlitedatabase1 = super.getWritableDatabase();
            sqlitedatabase = sqlitedatabase1;
_L2:
            SQLiteDatabase sqlitedatabase2 = sqlitedatabase;
            if (sqlitedatabase == null)
            {
                sqlitedatabase2 = super.getWritableDatabase();
            }
            return sqlitedatabase2;
            SQLiteException sqliteexception;
            sqliteexception;
            zzw.zzb(zzaWL).getDatabasePath("google_tagmanager.db").delete();
            if (true) goto _L2; else goto _L1
_L1:
        }

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            zzal.zzbl(sqlitedatabase.getPath());
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
            if (!zza("datalayer", sqlitedatabase))
            {
                sqlitedatabase.execSQL(zzw.zzCN());
                return;
            } else
            {
                zzc(sqlitedatabase);
                return;
            }
            sqlitedatabase;
            cursor.close();
            throw sqlitedatabase;
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
        }

        zza(Context context, String s)
        {
            zzaWL = zzw.this;
            super(context, s, null, 1);
        }
    }


    private class zzb
    {

        final byte zzaWO[];
        final String zzue;

        public String toString()
        {
            return (new StringBuilder("KeyAndSerialized: key = ")).append(zzue).append(" serialized hash = ").append(Arrays.hashCode(zzaWO)).toString();
        }

        zzb(String s, byte abyte0[])
        {
            zzue = s;
            zzaWO = abyte0;
        }
    }


    private class _cls2
        implements Runnable
    {

        final zzw zzaWL;
        final DataLayer.zzc.zza zzaWM;

        public void run()
        {
            zzaWM.zzw(zzw.zza(zzaWL));
        }

        _cls2(DataLayer.zzc.zza zza1)
        {
            zzaWL = zzw.this;
            zzaWM = zza1;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final List zzaWJ;
        final long zzaWK;
        final zzw zzaWL;

        public void run()
        {
            zzw.zza(zzaWL, zzaWJ, zzaWK);
        }

        _cls1(List list, long l)
        {
            zzaWL = zzw.this;
            zzaWJ = list;
            zzaWK = l;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final zzw zzaWL;
        final String zzaWN;

        public void run()
        {
            zzw.zza(zzaWL, zzaWN);
        }

        _cls3(String s)
        {
            zzaWL = zzw.this;
            zzaWN = s;
            super();
        }
    }

}
