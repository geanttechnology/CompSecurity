// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.google.android.gms.internal.fl;
import com.google.android.gms.internal.fn;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.google.android.gms.tagmanager:
//            bh, ak

class v
    implements DataLayer.c
{
    class a extends SQLiteOpenHelper
    {

        final v UJ;

        private void a(SQLiteDatabase sqlitedatabase)
        {
            Object obj;
            String as[];
            int i;
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase = sqlitedatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            } else
            {
                sqlitedatabase = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "SELECT * FROM datalayer WHERE 0", null);
            }
            obj = new HashSet();
            as = sqlitedatabase.getColumnNames();
            i = 0;
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
            break MISSING_BLOCK_LABEL_143;
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

        private boolean a(String s, SQLiteDatabase sqlitedatabase)
        {
            Object obj = null;
            String as[] = new String[1];
            as[0] = "name";
            String as1[] = new String[1];
            as1[0] = s;
            if (sqlitedatabase instanceof SQLiteDatabase)
            {
                break MISSING_BLOCK_LABEL_69;
            }
            sqlitedatabase = sqlitedatabase.query("SQLITE_MASTER", as, "name=?", as1, null, null, null);
_L1:
            boolean flag = sqlitedatabase.moveToFirst();
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            return flag;
            sqlitedatabase = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "SQLITE_MASTER", as, "name=?", as1, null, null, null);
              goto _L1
            sqlitedatabase;
            sqlitedatabase = null;
_L5:
            bh.w((new StringBuilder()).append("Error querying for table ").append(s).toString());
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            return false;
            s;
            sqlitedatabase = obj;
_L3:
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            throw s;
            s;
            continue; /* Loop/switch isn't completed */
            s;
            if (true) goto _L3; else goto _L2
_L2:
            SQLiteException sqliteexception;
            sqliteexception;
            if (true) goto _L5; else goto _L4
_L4:
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
            v.b(UJ).getDatabasePath("google_tagmanager.db").delete();
            if (true) goto _L2; else goto _L1
_L1:
        }

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            ak.B(sqlitedatabase.getPath());
        }

        public void onOpen(SQLiteDatabase sqlitedatabase)
        {
            Object obj;
            if (android.os.Build.VERSION.SDK_INT >= 15)
            {
                break MISSING_BLOCK_LABEL_36;
            }
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                obj = sqlitedatabase.rawQuery("PRAGMA journal_mode=memory", null);
            } else
            {
                obj = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "PRAGMA journal_mode=memory", null);
            }
            ((Cursor) (obj)).moveToFirst();
            ((Cursor) (obj)).close();
            if (!a("datalayer", sqlitedatabase))
            {
                obj = v.iX();
                if (!(sqlitedatabase instanceof SQLiteDatabase))
                {
                    sqlitedatabase.execSQL(((String) (obj)));
                    return;
                } else
                {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, ((String) (obj)));
                    return;
                }
            } else
            {
                a(sqlitedatabase);
                return;
            }
            sqlitedatabase;
            ((Cursor) (obj)).close();
            throw sqlitedatabase;
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int k)
        {
        }

        a(Context context, String s)
        {
            UJ = v.this;
            super(context, s, null, 1);
        }
    }

    private static class b
    {

        final String UA;
        final byte UM[];

        public String toString()
        {
            return (new StringBuilder()).append("KeyAndSerialized: key = ").append(UA).append(" serialized hash = ").append(Arrays.hashCode(UM)).toString();
        }

        b(String s, byte abyte0[])
        {
            UA = s;
            UM = abyte0;
        }
    }


    private static final String UD = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[] {
        "datalayer", "ID", "key", "value", "expires"
    });
    private fl Ty;
    private final Executor UE;
    private a UF;
    private int UG;
    private final Context mContext;

    public v(Context context)
    {
        this(context, fn.eI(), "google_tagmanager.db", 2000, ((Executor) (Executors.newSingleThreadExecutor())));
    }

    v(Context context, fl fl1, String s, int i, Executor executor)
    {
        mContext = context;
        Ty = fl1;
        UG = i;
        UE = executor;
        UF = new a(mContext, s);
    }

    private SQLiteDatabase G(String s)
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = UF.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            bh.w(s);
            return null;
        }
        return sqlitedatabase;
    }

    static List a(v v1)
    {
        return v1.iT();
    }

    static void a(v v1, String s)
    {
        v1.bj(s);
    }

    static void a(v v1, List list, long l)
    {
        v1.b(list, l);
    }

    static Context b(v v1)
    {
        return v1.mContext;
    }

    private void b(List list, long l)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = Ty.currentTimeMillis();
        t(l1);
        bQ(list.size());
        c(list, l1 + l);
        iW();
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        iW();
        throw list;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
    }

    private void bQ(int i)
    {
        i = (iV() - UG) + i;
        if (i > 0)
        {
            List list = bR(i);
            bh.u((new StringBuilder()).append("DataLayer store full, deleting ").append(list.size()).append(" entries to make room.").toString());
            g((String[])list.toArray(new String[0]));
        }
    }

    private List bR(int i)
    {
        Object obj;
        Object obj1;
        ArrayList arraylist;
        obj1 = null;
        arraylist = new ArrayList();
        if (i <= 0)
        {
            bh.w("Invalid maxEntries specified. Skipping.");
            return arraylist;
        }
        obj = G("Error opening database for peekEntryIds.");
        if (obj == null)
        {
            return arraylist;
        }
        String as[] = new String[1];
        as[0] = "ID";
        String s;
        String s1;
        s = String.format("%s ASC", new Object[] {
            "ID"
        });
        s1 = Integer.toString(i);
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj = ((SQLiteDatabase) (obj)).query("datalayer", as, null, null, null, null, s, s1);
_L5:
        obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst()) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        arraylist.add(String.valueOf(((Cursor) (obj)).getLong(0)));
        obj1 = obj;
        boolean flag = ((Cursor) (obj)).moveToNext();
        if (flag) goto _L3; else goto _L4
_L4:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
_L6:
        return arraylist;
_L2:
        obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "datalayer", as, null, null, null, null, s, s1);
          goto _L5
        SQLiteException sqliteexception;
        sqliteexception;
        obj = null;
_L9:
        obj1 = obj;
        bh.w((new StringBuilder()).append("Error in peekEntries fetching entryIds: ").append(sqliteexception.getMessage()).toString());
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
          goto _L6
        Exception exception;
        exception;
_L8:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw exception;
        exception;
        if (true) goto _L8; else goto _L7
_L7:
        sqliteexception;
          goto _L9
    }

    private void bj(String s)
    {
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = G("Error opening database for clearKeysWithPrefix.");
        if (sqlitedatabase == null)
        {
            return;
        }
        String as[] = new String[2];
        as[0] = s;
        int i;
        as[1] = (new StringBuilder()).append(s).append(".%").toString();
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        i = sqlitedatabase.delete("datalayer", "key = ? OR key LIKE ?", as);
_L1:
        bh.v((new StringBuilder()).append("Cleared ").append(i).append(" items").toString());
        iW();
        return;
        i = SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "datalayer", "key = ? OR key LIKE ?", as);
          goto _L1
        SQLiteException sqliteexception;
        sqliteexception;
        bh.w((new StringBuilder()).append("Error deleting entries with key prefix: ").append(s).append(" (").append(sqliteexception).append(").").toString());
        iW();
        return;
        s;
        iW();
        throw s;
    }

    private List c(List list)
    {
        ArrayList arraylist = new ArrayList();
        b b1;
        for (list = list.iterator(); list.hasNext(); arraylist.add(new DataLayer.a(b1.UA, j(b1.UM))))
        {
            b1 = (b)list.next();
        }

        return arraylist;
    }

    private void c(List list, long l)
    {
        SQLiteDatabase sqlitedatabase = G("Error opening database for writeEntryToDatabase.");
        if (sqlitedatabase != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                b b1 = (b)list.next();
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("expires", Long.valueOf(l));
                contentvalues.put("key", b1.UA);
                contentvalues.put("value", b1.UM);
                if (!(sqlitedatabase instanceof SQLiteDatabase))
                {
                    sqlitedatabase.insert("datalayer", null, contentvalues);
                } else
                {
                    SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "datalayer", null, contentvalues);
                }
            }
        }
    }

    private List d(List list)
    {
        ArrayList arraylist = new ArrayList();
        DataLayer.a a1;
        for (list = list.iterator(); list.hasNext(); arraylist.add(new b(a1.UA, j(a1.UB))))
        {
            a1 = (DataLayer.a)list.next();
        }

        return arraylist;
    }

    private void g(String as[])
    {
        if (as != null && as.length != 0) goto _L2; else goto _L1
_L1:
        Object obj;
        return;
_L2:
        if ((obj = G("Error opening database for deleteEntries.")) == null) goto _L1; else goto _L3
_L3:
        String s;
        s = String.format("%s in (%s)", new Object[] {
            "ID", TextUtils.join(",", Collections.nCopies(as.length, "?"))
        });
        try
        {
            if (!(obj instanceof SQLiteDatabase))
            {
                ((SQLiteDatabase) (obj)).delete("datalayer", s, as);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bh.w((new StringBuilder()).append("Error deleting entries ").append(Arrays.toString(as)).toString());
            return;
        }
        SQLiteInstrumentation.delete((SQLiteDatabase)obj, "datalayer", s, as);
        return;
    }

    private List iT()
    {
        List list;
        t(Ty.currentTimeMillis());
        list = c(iU());
        iW();
        return list;
        Exception exception;
        exception;
        iW();
        throw exception;
    }

    private List iU()
    {
        Object obj;
        Object obj1;
        obj = G("Error opening database for loadSerialized.");
        obj1 = new ArrayList();
        if (obj == null)
        {
            return ((List) (obj1));
        }
        String as[] = new String[2];
        as[0] = "key";
        as[1] = "value";
        if (!(obj instanceof SQLiteDatabase))
        {
            obj = ((SQLiteDatabase) (obj)).query("datalayer", as, null, null, null, null, "ID", null);
        } else
        {
            obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "datalayer", as, null, null, null, null, "ID", null);
        }
        for (; ((Cursor) (obj)).moveToNext(); ((List) (obj1)).add(new b(((Cursor) (obj)).getString(0), ((Cursor) (obj)).getBlob(1)))) { }
        break MISSING_BLOCK_LABEL_129;
        obj1;
        ((Cursor) (obj)).close();
        throw obj1;
        ((Cursor) (obj)).close();
        return ((List) (obj1));
    }

    private int iV()
    {
        Object obj;
        Object obj1;
        SQLiteDatabase sqlitedatabase;
        obj = null;
        sqlitedatabase = G("Error opening database for getNumStoredEntries.");
        if (sqlitedatabase == null)
        {
            return 0;
        }
        obj1 = obj;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        obj = sqlitedatabase.rawQuery("SELECT COUNT(*) from datalayer", null);
_L3:
        obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_157;
        }
        obj1 = obj;
        long l = ((Cursor) (obj)).getLong(0);
        int i = (int)l;
_L8:
        int k;
        k = i;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            k = i;
        }
_L4:
        return k;
_L2:
        obj1 = obj;
        obj = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "SELECT COUNT(*) from datalayer", null);
          goto _L3
        obj;
        obj = null;
_L7:
        bh.w("Error getting numStoredEntries");
        SQLiteException sqliteexception;
        Exception exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            k = 0;
        } else
        {
            k = 0;
        }
          goto _L4
        exception;
        obj = obj1;
        obj1 = exception;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw obj1;
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
        sqliteexception;
          goto _L7
        i = 0;
          goto _L8
    }

    private void iW()
    {
        try
        {
            UF.close();
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            return;
        }
    }

    static String iX()
    {
        return UD;
    }

    private Object j(byte abyte0[])
    {
        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
        abyte0 = new ObjectInputStream(bytearrayinputstream);
        Object obj = abyte0.readObject();
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        abyte0.close();
        bytearrayinputstream.close();
        return obj;
        abyte0;
        abyte0 = null;
_L8:
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_48;
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
            break MISSING_BLOCK_LABEL_68;
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
            break MISSING_BLOCK_LABEL_88;
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
        abyte0;
        return obj;
    }

    private byte[] j(Object obj)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ObjectOutputStream objectoutputstream = new ObjectOutputStream(bytearrayoutputstream);
        objectoutputstream.writeObject(obj);
        obj = bytearrayoutputstream.toByteArray();
        if (objectoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        objectoutputstream.close();
        bytearrayoutputstream.close();
        return ((byte []) (obj));
        obj;
        objectoutputstream = null;
_L6:
        if (objectoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_52;
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
            break MISSING_BLOCK_LABEL_72;
        }
        objectoutputstream.close();
        bytearrayoutputstream.close();
_L2:
        throw obj;
        IOException ioexception;
        ioexception;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        if (true) goto _L6; else goto _L5
_L5:
        ioexception;
        return ((byte []) (obj));
    }

    private void t(long l)
    {
        Object obj;
        obj = G("Error opening database for deleteOlderThan.");
        if (obj == null)
        {
            return;
        }
        String as[];
        int i;
        as = new String[1];
        as[0] = Long.toString(l);
        if (obj instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        i = ((SQLiteDatabase) (obj)).delete("datalayer", "expires <= ?", as);
_L1:
        bh.v((new StringBuilder()).append("Deleted ").append(i).append(" expired items").toString());
        return;
        try
        {
            i = SQLiteInstrumentation.delete((SQLiteDatabase)obj, "datalayer", "expires <= ?", as);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bh.w("Error deleting old entries.");
            return;
        }
          goto _L1
    }

    public void a(DataLayer.c.a a1)
    {
        UE.execute(new Runnable(a1) {

            final v UJ;
            final DataLayer.c.a UK;

            public void run()
            {
                UK.b(v.a(UJ));
            }

            
            {
                UJ = v.this;
                UK = a1;
                super();
            }
        });
    }

    public void a(List list, long l)
    {
        list = d(list);
        UE.execute(new Runnable(list, l) {

            final List UH;
            final long UI;
            final v UJ;

            public void run()
            {
                v.a(UJ, UH, UI);
            }

            
            {
                UJ = v.this;
                UH = list;
                UI = l;
                super();
            }
        });
    }

    public void bi(String s)
    {
        UE.execute(new Runnable(s) {

            final v UJ;
            final String UL;

            public void run()
            {
                v.a(UJ, UL);
            }

            
            {
                UJ = v.this;
                UL = s;
                super();
            }
        });
    }

}
