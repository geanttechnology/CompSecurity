// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class fo
{

    private static fo c;
    private fn a;
    private SQLiteDatabase b;

    public fo(Context context)
    {
        a = new fn(context, "BBYDb", null, 2);
        b();
        c = this;
    }

    public static fo a()
    {
        return c;
    }

    public int a(String s)
    {
        return b.delete(s, null, null);
    }

    public int a(String s, ContentValues contentvalues, String s1, String as[])
    {
        return b.update(s, contentvalues, s1, as);
    }

    public int a(String s, String s1, String as[])
    {
        return b.delete(s, s1, as);
    }

    public long a(String s, ContentValues contentvalues)
    {
        return b.insert(s, null, contentvalues);
    }

    public List a(String s, String as[], String s1, String s2)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        StringBuilder stringbuilder = new StringBuilder();
        int i;
        if (as == null)
        {
            stringbuilder.append("*");
        } else
        {
            int j = 0;
            while (j < as.length) 
            {
                if (j == as.length - 1)
                {
                    stringbuilder.append(as[j]).append(" ");
                } else
                {
                    stringbuilder.append(as[j]).append(", ");
                }
                j++;
            }
        }
        if (s1 == null && s2 == null)
        {
            s = (new StringBuilder()).append("SELECT ").append(stringbuilder).append(" FROM ").append(s).toString();
        } else
        {
            s = (new StringBuilder()).append("SELECT ").append(stringbuilder).append(" FROM ").append(s).append(" ORDER BY ").append(s1).append(" ").append(s2).toString();
        }
        s = b.rawQuery(s, null);
        if (as != null || s == null || !s.moveToFirst()) goto _L2; else goto _L1
_L1:
        do
        {
            as = new ContentValues();
            for (i = 0; i < s.getColumnCount(); i++)
            {
                as.put(s.getColumnName(i), s.getString(i));
            }

            arraylist.add(as);
        } while (s.moveToNext());
_L4:
        a(((Cursor) (s)));
        return arraylist;
_L2:
        if (s != null && s.moveToFirst())
        {
            do
            {
                s1 = new ContentValues();
                for (int k = 0; k < as.length; k++)
                {
                    s1.put(as[k], s.getString(k));
                }

                arraylist.add(s1);
            } while (s.moveToNext());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public List a(String s, String as[], String s1, String as1[], String s2)
    {
        ArrayList arraylist = new ArrayList();
        as1 = b.query(s, as, s1, as1, null, null, s2);
        s1 = as;
        if (as == null)
        {
            s1 = b(s);
        }
        if (as1 != null && as1.moveToFirst())
        {
            do
            {
                s = new ContentValues();
                for (int i = 0; i < s1.length; i++)
                {
                    s.put(s1[i], as1.getString(i));
                }

                arraylist.add(s);
            } while (as1.moveToNext());
        }
        a(((Cursor) (as1)));
        return arraylist;
    }

    public void a(Cursor cursor)
    {
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
    }

    public final void b()
    {
        try
        {
            b = a.getWritableDatabase();
            return;
        }
        catch (SQLException sqlexception)
        {
            return;
        }
    }

    public String[] b(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = b.rawQuery((new StringBuilder()).append("PRAGMA table_info(").append(s).append(")").toString(), null);
        if (s.moveToFirst())
        {
            do
            {
                arraylist.add(s.getString(1));
            } while (s.moveToNext());
        }
        a(s);
        return (String[])arraylist.toArray(new String[arraylist.size()]);
    }

    public void c()
    {
        b.beginTransaction();
    }

    public void d()
    {
        b.setTransactionSuccessful();
    }

    public void e()
    {
        b.endTransaction();
    }
}
