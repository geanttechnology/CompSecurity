// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.h;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.helpshift.e.a;
import com.helpshift.i.c;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

// Referenced classes of package com.helpshift.h:
//            f

public class g
{

    private SQLiteDatabase a;
    private f b;
    private String c[] = {
        "_id", "identifier", "profile_id", "name", "email", "salt"
    };

    public g(Context context)
    {
        b = new f(context);
    }

    private a a(Cursor cursor)
    {
        a a1 = new a(cursor.getString(1));
        a1.a(Long.valueOf(cursor.getLong(0)));
        a1.a(cursor.getString(2));
        a1.b(cursor.getString(3));
        a1.c(cursor.getString(4));
        a1.d(cursor.getString(5));
        return a1;
    }

    private ContentValues d(a a1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("identifier", a1.a());
        contentvalues.put("profile_id", a1.c());
        contentvalues.put("name", a1.d());
        contentvalues.put("email", a1.e());
        contentvalues.put("salt", a1.f());
        return contentvalues;
    }

    public a a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        String as[];
        b();
        obj = a;
        as = c;
        s = (new StringBuilder()).append("identifier = '").append(s).append("'").toString();
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        s = ((SQLiteDatabase) (obj)).query("profiles", as, s, null, null, null, null);
_L3:
        if (!s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_114;
        }
        obj = a(((Cursor) (s)));
_L4:
        s.close();
        c();
        this;
        JVM INSTR monitorexit ;
        return ((a) (obj));
_L2:
        s = SQLiteInstrumentation.query((SQLiteDatabase)obj, "profiles", as, s, null, null, null, null);
          goto _L3
        s;
        throw s;
        obj = null;
          goto _L4
    }

    public void a()
    {
        a = b.getWritableDatabase();
    }

    public void a(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        if (a(a1.a()) != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        b(a1);
_L1:
        com.helpshift.i.c.a("__hs__db_profiles");
        this;
        JVM INSTR monitorexit ;
        return;
        c(a1);
          goto _L1
        a1;
        throw a1;
    }

    public void b()
    {
        a = b.getReadableDatabase();
    }

    public void b(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        a();
        a1 = d(a1);
        sqlitedatabase = a;
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        sqlitedatabase.insert("profiles", null, a1);
_L1:
        c();
        this;
        JVM INSTR monitorexit ;
        return;
        SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "profiles", null, a1);
          goto _L1
        a1;
        throw a1;
    }

    public void c()
    {
        b.close();
    }

    public void c(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        ContentValues contentvalues;
        SQLiteDatabase sqlitedatabase;
        a();
        contentvalues = d(a1);
        sqlitedatabase = a;
        a1 = (new StringBuilder()).append("identifier = '").append(a1.a()).append("'").toString();
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        sqlitedatabase.update("profiles", contentvalues, a1, null);
_L1:
        c();
        this;
        JVM INSTR monitorexit ;
        return;
        SQLiteInstrumentation.update((SQLiteDatabase)sqlitedatabase, "profiles", contentvalues, a1, null);
          goto _L1
        a1;
        throw a1;
    }
}
