// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.j.a.d.e;
import com.j.a.g.w;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;

// Referenced classes of package com.j.a.a.a:
//            e

public abstract class g
{

    public SQLiteDatabase a;
    public SQLiteOpenHelper b;

    public g()
    {
    }

    public int a(String s)
    {
        SQLiteDatabase sqlitedatabase;
        if (a == null || !a.isOpen())
        {
            a = b.getReadableDatabase();
        }
        sqlitedatabase = d();
        s = (new StringBuilder()).append("SELECT * FROM ").append(s).toString();
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        s = sqlitedatabase.rawQuery(s, null);
_L1:
        int i;
        i = s.getCount();
        s.close();
        return i;
        try
        {
            s = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, s, null);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            w.a((new StringBuilder()).append("count error: ").append(s.getMessage()).toString());
            return 0;
        }
          goto _L1
    }

    public Boolean a(String s, int i, g g1)
    {
        try
        {
            b = new com.j.a.a.a.e(e.e().o(), s, i, g1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            w.b("External Analytics", s);
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public ArrayList a(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        SQLiteDatabase sqlitedatabase;
        if (a == null || !a.isOpen())
        {
            a = b.getReadableDatabase();
        }
        sqlitedatabase = d();
        s = (new StringBuilder()).append("SELECT * FROM ").append(s).toString();
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            try
            {
                s = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, s, null);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                w.a((new StringBuilder()).append("Error getting data from db: ").append(s.getMessage()).toString());
                a.close();
                return arraylist;
            }
        }
        for (s = sqlitedatabase.rawQuery(s, null); s.moveToNext(); arraylist.add(s.getString(s.getColumnIndex(s1)))) { }
        s.close();
        return arraylist;
    }

    public void a(SQLiteDatabase sqlitedatabase)
    {
        a = sqlitedatabase;
    }

    public abstract void c();

    public SQLiteDatabase d()
    {
        return a;
    }
}
