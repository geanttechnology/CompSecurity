// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.inmobi.commons.core.b:
//            a

public final class b
{

    private static final String a = com/inmobi/commons/core/b/b.getSimpleName();
    private static volatile b b;
    private static final Object c = new Object();
    private static final Object d = new Object();
    private static int e = 0;
    private SQLiteDatabase f;

    private b()
    {
        com.inmobi.commons.core.b.a a1 = new com.inmobi.commons.core.b.a(com.inmobi.commons.a.a.b());
        try
        {
            f = a1.getWritableDatabase();
            b = this;
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Problem while getting writable database connection.", sqliteexception);
        }
    }

    public static b a()
    {
        com/inmobi/commons/core/b/b;
        JVM INSTR monitorenter ;
        synchronized (d)
        {
            e++;
        }
        b b1 = b;
        obj = b1;
        if (b1 != null) goto _L2; else goto _L1
_L1:
        Object obj1 = c;
        obj1;
        JVM INSTR monitorenter ;
        b1 = b;
        obj = b1;
        if (b1 != null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        b = new b();
        obj = b;
        obj1;
        JVM INSTR monitorexit ;
_L2:
        com/inmobi/commons/core/b/b;
        JVM INSTR monitorexit ;
        return ((b) (obj));
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        com/inmobi/commons/core/b/b;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int a(String s)
    {
        s = (new StringBuilder()).append("SELECT COUNT(*) FROM ").append(s).append(" ; ").toString();
        s = f.rawQuery(s, null);
        s.moveToFirst();
        int i = s.getInt(0);
        s.close();
        return i;
    }

    public int a(String s, String s1, String as[])
    {
        return f.delete(s, s1, as);
    }

    public List a(String s, String as[], String s1, String as1[], String s2, String s3, String s4, 
            String s5)
    {
        s = f.query(s, as, s1, as1, s2, s3, s4, s5);
        as = new ArrayList();
        if (s.moveToFirst())
        {
            do
            {
                s1 = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(s, s1);
                as.add(s1);
            } while (s.moveToNext());
        }
        s.close();
        return as;
    }

    public void a(String s, ContentValues contentvalues, String s1, String as[])
    {
        if (!a(s, contentvalues))
        {
            b(s, contentvalues, s1, as);
        }
    }

    public void a(String s, String s1)
    {
        s = (new StringBuilder()).append("CREATE TABLE IF NOT EXISTS ").append(s).append(s1).append(";").toString();
        f.execSQL(s);
    }

    public boolean a(String s, ContentValues contentvalues)
    {
        return f.insertWithOnConflict(s, null, contentvalues, 4) != -1L;
    }

    public int b(String s, ContentValues contentvalues, String s1, String as[])
    {
        return f.updateWithOnConflict(s, contentvalues, s1, as, 4);
    }

    public int b(String s, String s1, String as[])
    {
        s = (new StringBuilder()).append("SELECT COUNT(*) FROM ").append(s).append(" WHERE ").append(s1).append(" ; ").toString();
        s = f.rawQuery(s, as);
        s.moveToFirst();
        int i = s.getInt(0);
        s.close();
        return i;
    }

    public void b()
    {
        synchronized (d)
        {
            e--;
            if (e == 0)
            {
                f.close();
                b = null;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
