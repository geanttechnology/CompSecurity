// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.google.android.gms.d.ii;
import com.google.android.gms.d.ij;
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

// Referenced classes of package com.google.android.gms.e:
//            aj, p

final class dg
    implements c.c
{
    final class a extends SQLiteOpenHelper
    {

        final dg a;

        private static boolean a(String s, SQLiteDatabase sqlitedatabase)
        {
            Object obj = null;
            s = sqlitedatabase.query("SQLITE_MASTER", new String[] {
                "name"
            }, "name=?", new String[] {
                s
            }, null, null, null);
            boolean flag = s.moveToFirst();
            if (s != null)
            {
                s.close();
            }
            return flag;
            s;
            s = null;
_L4:
            aj.a();
            if (s != null)
            {
                s.close();
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
            Exception exception;
            exception;
            sqlitedatabase = s;
            s = exception;
            continue; /* Loop/switch isn't completed */
            exception;
            sqlitedatabase = s;
            s = exception;
            if (true) goto _L2; else goto _L1
_L1:
            sqlitedatabase;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final SQLiteDatabase getWritableDatabase()
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
            dg.b(a).getDatabasePath("google_tagmanager.db").delete();
            if (true) goto _L2; else goto _L1
_L1:
        }

        public final void onCreate(SQLiteDatabase sqlitedatabase)
        {
            p.a(sqlitedatabase.getPath());
        }

        public final void onOpen(SQLiteDatabase sqlitedatabase)
        {
            Object obj;
            if (android.os.Build.VERSION.SDK_INT >= 15)
            {
                break MISSING_BLOCK_LABEL_29;
            }
            obj = sqlitedatabase.rawQuery("PRAGMA journal_mode=memory", null);
            ((Cursor) (obj)).moveToFirst();
            ((Cursor) (obj)).close();
            if (a("datalayer", sqlitedatabase)) goto _L2; else goto _L1
_L1:
            sqlitedatabase.execSQL(dg.a());
_L6:
            return;
            sqlitedatabase;
            ((Cursor) (obj)).close();
            throw sqlitedatabase;
_L2:
            sqlitedatabase = sqlitedatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            obj = new HashSet();
            String as[] = sqlitedatabase.getColumnNames();
            int i = 0;
_L4:
            if (i >= as.length)
            {
                break; /* Loop/switch isn't completed */
            }
            ((Set) (obj)).add(as[i]);
            i++;
            if (true) goto _L4; else goto _L3
_L3:
            sqlitedatabase.close();
            if (!((Set) (obj)).remove("key") || !((Set) (obj)).remove("value") || !((Set) (obj)).remove("ID") || !((Set) (obj)).remove("expires"))
            {
                throw new SQLiteException("Database column missing");
            }
            continue; /* Loop/switch isn't completed */
            obj;
            sqlitedatabase.close();
            throw obj;
            if (((Set) (obj)).isEmpty()) goto _L6; else goto _L5
_L5:
            throw new SQLiteException("Database has extra columns");
        }

        public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
        }

        a(Context context, String s)
        {
            a = dg.this;
            super(context, s, null, 1);
        }
    }

    private static final class b
    {

        final String a;
        final byte b[];

        public final String toString()
        {
            return (new StringBuilder("KeyAndSerialized: key = ")).append(a).append(" serialized hash = ").append(Arrays.hashCode(b)).toString();
        }

        b(String s, byte abyte0[])
        {
            a = s;
            b = abyte0;
        }
    }


    private static final String a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[] {
        "datalayer", "ID", "key", "value", "expires"
    });
    private final Executor b;
    private final Context c;
    private a d;
    private ii e;
    private int f;

    public dg(Context context)
    {
        this(context, ij.d(), "google_tagmanager.db", ((Executor) (Executors.newSingleThreadExecutor())));
    }

    private dg(Context context, ii ii1, String s, Executor executor)
    {
        c = context;
        e = ii1;
        f = 2000;
        b = executor;
        d = new a(c, s);
    }

    private static Object a(byte abyte0[])
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

    static String a()
    {
        return a;
    }

    private List a(int i)
    {
        Object obj;
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (i <= 0)
        {
            aj.a();
            return arraylist;
        }
        obj = e();
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
        (new StringBuilder("Error in peekEntries fetching entryIds: ")).append(sqliteexception.getMessage());
        obj = obj1;
        aj.a();
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

    static List a(dg dg1)
    {
        return dg1.b();
    }

    private void a(long l)
    {
        SQLiteDatabase sqlitedatabase = e();
        if (sqlitedatabase == null)
        {
            return;
        }
        try
        {
            int i = sqlitedatabase.delete("datalayer", "expires <= ?", new String[] {
                Long.toString(l)
            });
            (new StringBuilder("Deleted ")).append(i).append(" expired items");
            aj.d();
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            aj.a();
        }
    }

    static void a(dg dg1, String s)
    {
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = dg1.e();
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        int i = sqlitedatabase.delete("datalayer", "key = ? OR key LIKE ?", new String[] {
            s, (new StringBuilder()).append(s).append(".%").toString()
        });
        (new StringBuilder("Cleared ")).append(i).append(" items");
        aj.d();
        dg1.f();
        return;
        SQLiteException sqliteexception;
        sqliteexception;
        (new StringBuilder("Error deleting entries with key prefix: ")).append(s).append(" (").append(sqliteexception).append(").");
        aj.a();
        dg1.f();
        return;
        s;
        dg1.f();
        throw s;
    }

    static void a(dg dg1, List list, long l)
    {
        dg1.b(list, l);
    }

    private static byte[] a(Object obj)
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

    static Context b(dg dg1)
    {
        return dg1.c;
    }

    private List b()
    {
        Object obj;
        a(e.a());
        Object obj1 = c();
        obj = new ArrayList();
        b b1;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(new c.a(b1.a, a(b1.b))))
        {
            b1 = (b)((Iterator) (obj1)).next();
        }

        break MISSING_BLOCK_LABEL_87;
        obj;
        f();
        throw obj;
        f();
        return ((List) (obj));
    }

    private void b(List list, long l)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        long l1;
        l1 = e.a();
        a(l1);
        i = list.size() + (d() - f);
        if (i <= 0) goto _L2; else goto _L1
_L1:
        String as[];
        List list1 = a(i);
        (new StringBuilder("DataLayer store full, deleting ")).append(list1.size()).append(" entries to make room.");
        aj.c();
        as = (String[])list1.toArray(new String[0]);
        if (as == null) goto _L2; else goto _L3
_L3:
        if (as.length != 0) goto _L4; else goto _L2
_L2:
        c(list, l1 + l);
        f();
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        SQLiteDatabase sqlitedatabase = e();
        if (sqlitedatabase == null) goto _L2; else goto _L5
_L5:
        String s = String.format("%s in (%s)", new Object[] {
            "ID", TextUtils.join(",", Collections.nCopies(as.length, "?"))
        });
        sqlitedatabase.delete("datalayer", s, as);
          goto _L2
        SQLiteException sqliteexception;
        sqliteexception;
        (new StringBuilder("Error deleting entries ")).append(Arrays.toString(as));
        aj.a();
          goto _L2
        list;
        f();
        throw list;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
    }

    private List c()
    {
        Object obj;
        Object obj1;
        obj1 = e();
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
            ((List) (obj)).add(new b(((Cursor) (obj1)).getString(0), ((Cursor) (obj1)).getBlob(1)));
        }
        break MISSING_BLOCK_LABEL_96;
        obj;
        ((Cursor) (obj1)).close();
        throw obj;
        ((Cursor) (obj1)).close();
        return ((List) (obj));
    }

    private void c(List list, long l)
    {
        SQLiteDatabase sqlitedatabase = e();
        if (sqlitedatabase != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                b b1 = (b)list.next();
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("expires", Long.valueOf(l));
                contentvalues.put("key", b1.a);
                contentvalues.put("value", b1.b);
                sqlitedatabase.insert("datalayer", null, contentvalues);
            }
        }
    }

    private int d()
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
        obj1 = e();
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        obj1 = ((SQLiteDatabase) (obj1)).rawQuery("SELECT COUNT(*) from datalayer", null);
        cursor = ((Cursor) (obj1));
        obj = obj1;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_62;
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
        aj.a();
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

    private SQLiteDatabase e()
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = d.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            aj.a();
            return null;
        }
        return sqlitedatabase;
    }

    private void f()
    {
        try
        {
            d.close();
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            return;
        }
    }

    public final void a(c.c.a a1)
    {
        b.execute(new Runnable(a1) {

            final c.c.a a;
            final dg b;

            public final void run()
            {
                a.a(dg.a(b));
            }

            
            {
                b = dg.this;
                a = a1;
                super();
            }
        });
    }

    public final void a(String s)
    {
        b.execute(new Runnable(s) {

            final String a;
            final dg b;

            public final void run()
            {
                dg.a(b, a);
            }

            
            {
                b = dg.this;
                a = s;
                super();
            }
        });
    }

    public final void a(List list, long l)
    {
        ArrayList arraylist = new ArrayList();
        c.a a1;
        for (list = list.iterator(); list.hasNext(); arraylist.add(new b(a1.a, a(a1.b))))
        {
            a1 = (c.a)list.next();
        }

        b.execute(new Runnable(arraylist, l) {

            final List a;
            final long b;
            final dg c;

            public final void run()
            {
                dg.a(c, a, b);
            }

            
            {
                c = dg.this;
                a = list;
                b = l;
                super();
            }
        });
    }

}
