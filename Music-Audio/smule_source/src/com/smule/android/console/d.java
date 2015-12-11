// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.LinkedHashMap;

// Referenced classes of package com.smule.android.console:
//            e, f, a, g

public class d
{

    private static final String a[][];
    private static final String b[][];
    private f c;
    private SQLiteDatabase d;

    public d()
    {
        c = new f(com.smule.android.console.a.a());
        d = c.getWritableDatabase();
        c(d() - 200);
    }

    static String[][] b()
    {
        return b;
    }

    static String[][] c()
    {
        return a;
    }

    private int d()
    {
        boolean flag = false;
        Cursor cursor = d.rawQuery((new StringBuilder()).append("select max(").append(e.a.name()).append(") from ").append("cmdhistory").toString(), null);
        int i = ((flag) ? 1 : 0);
        if (cursor != null)
        {
            i = ((flag) ? 1 : 0);
            if (cursor.moveToFirst())
            {
                i = cursor.getInt(0);
            }
        }
        cursor.close();
        return i;
    }

    private int e()
    {
        boolean flag = false;
        Cursor cursor = d.rawQuery((new StringBuilder()).append("select min(").append(e.a.name()).append(") from ").append("cmdhistory").toString(), null);
        int i = ((flag) ? 1 : 0);
        if (cursor != null)
        {
            i = ((flag) ? 1 : 0);
            if (cursor.moveToFirst())
            {
                i = cursor.getInt(0);
            }
        }
        cursor.close();
        return i;
    }

    public String a(int i)
    {
        Object obj1 = null;
        Object obj = d;
        Object obj2 = e.b.name();
        String s = (new StringBuilder()).append(e.a.name()).append("=").append(i).toString();
        obj2 = ((SQLiteDatabase) (obj)).query("cmdhistory", new String[] {
            obj2
        }, s, null, null, null, null);
        obj = obj1;
        if (obj2 != null)
        {
            obj = obj1;
            if (((Cursor) (obj2)).moveToFirst())
            {
                obj = ((Cursor) (obj2)).getString(0);
            }
        }
        ((Cursor) (obj2)).close();
        return ((String) (obj));
    }

    public String a(String s)
    {
        Object obj = null;
        Object obj1 = d;
        String s1 = e.d.name();
        s = (new StringBuilder()).append(e.c.name()).append("='").append(s).append("'").toString();
        obj1 = ((SQLiteDatabase) (obj1)).query("setting", new String[] {
            s1
        }, s, null, null, null, null);
        s = obj;
        if (obj1 != null)
        {
            s = obj;
            if (((Cursor) (obj1)).moveToFirst())
            {
                s = ((Cursor) (obj1)).getString(0);
            }
        }
        ((Cursor) (obj1)).close();
        return s;
    }

    public void a()
    {
        if (d != null)
        {
            d.close();
            d = null;
        }
        if (c != null)
        {
            c.close();
            c = null;
        }
    }

    public void a(g g1, Object obj)
    {
        String s = null;
        if (!(obj instanceof Boolean)) goto _L2; else goto _L1
_L1:
        if (((Boolean)obj).booleanValue())
        {
            s = "T";
        } else
        {
            s = "F";
        }
_L4:
        if (s != null)
        {
            a(g1.name(), s);
        }
        return;
_L2:
        if (obj instanceof Integer)
        {
            s = String.valueOf((Integer)obj);
        } else
        if (obj instanceof Long)
        {
            s = String.valueOf((Long)obj);
        } else
        if (obj instanceof String)
        {
            s = (String)obj;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(String s, String s1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(e.d.name(), s1);
        if (d.update("setting", contentvalues, (new StringBuilder()).append(e.c.name()).append("='").append(s).append("'").toString(), null) != 1)
        {
            contentvalues.put(e.c.name(), s);
            d.insert("setting", null, contentvalues);
        }
    }

    public boolean a(g g1)
    {
        g1 = a(g1.name());
        if (g1 == null)
        {
            return false;
        } else
        {
            return g1.equalsIgnoreCase("T");
        }
    }

    public int b(g g1)
    {
        g1 = a(g1.name());
        if (g1 == null)
        {
            return 0;
        } else
        {
            return com.smule.android.console.a.a(g1);
        }
    }

    public LinkedHashMap b(int i)
    {
        Object obj = null;
        int j = d();
        LinkedHashMap linkedhashmap;
        Cursor cursor;
        if (i > 0)
        {
            i = j - i;
        } else
        {
            i = j - 200;
        }
        cursor = d.query("cmdhistory", null, (new StringBuilder()).append(e.a.name()).append(">").append(i).toString(), null, null, null, (new StringBuilder()).append(e.a.name()).append(" ASC").toString());
        linkedhashmap = obj;
        if (cursor.getCount() > 0)
        {
            linkedhashmap = obj;
            if (cursor.moveToFirst())
            {
                linkedhashmap = new LinkedHashMap();
                do
                {
                    linkedhashmap.put(Integer.valueOf(cursor.getInt(0)), cursor.getString(1));
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        return linkedhashmap;
    }

    public void b(String s)
    {
        int i = d();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(e.a.name(), Integer.valueOf(i + 1));
        contentvalues.put(e.b.name(), s);
        d.insert("cmdhistory", null, contentvalues);
    }

    public void c(int i)
    {
        if (i >= 0)
        {
            if (i == 0)
            {
                d.delete("cmdhistory", null, null);
                return;
            }
            d.delete("cmdhistory", (new StringBuilder()).append(e.a.name()).append("<=").append(i).toString(), null);
            i = e();
            if (i > 1)
            {
                d.execSQL((new StringBuilder()).append("update cmdhistory set ").append(e.a.name()).append(" = ").append(e.a.name()).append(" - ").append(i - 1).toString());
                return;
            }
        }
    }

    static 
    {
        a = (new String[][] {
            new String[] {
                e.a.name(), "INTEGER PRIMARY KEY"
            }, new String[] {
                e.b.name(), "TEXT"
            }
        });
        b = (new String[][] {
            new String[] {
                e.c.name(), "TEXT PRIMARY KEY"
            }, new String[] {
                e.d.name(), "TEXT"
            }
        });
    }
}
