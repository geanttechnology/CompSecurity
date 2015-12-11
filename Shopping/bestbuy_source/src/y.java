// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class y
{

    private final SQLiteDatabase a;
    private final aa b;
    private int c;

    public y(z z1, aa aa1)
    {
        a = z1.getWritableDatabase();
        c = 0x7fffffff;
        b = aa1;
    }

    private void d()
    {
        Object obj = (new StringBuilder("DELETE FROM metrics WHERE ROWID IN (SELECT ROWID FROM metrics ORDER BY timestamp DESC LIMIT -1 OFFSET ")).append(c).append(")").toString();
        obj = a.compileStatement(((String) (obj)));
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            int i = ((SQLiteStatement) (obj)).executeUpdateDelete();
            if (i > 0)
            {
                b.b("free_storage", i);
            }
            return;
        } else
        {
            ((SQLiteStatement) (obj)).execute();
            return;
        }
    }

    public final List a()
    {
        Object obj;
        Cursor cursor;
        Object obj1;
        obj = new ArrayList();
        obj1 = new HashSet();
        cursor = a.query("metrics", null, null, null, null, null, null);
        cursor.moveToFirst();
_L1:
        boolean flag = cursor.isAfterLast();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        ((List) (obj)).add(new af(new JSONObject(cursor.getString(1)), cursor.getLong(0)));
_L2:
        cursor.moveToNext();
          goto _L1
        obj;
        cursor.close();
        throw obj;
        JSONException jsonexception;
        jsonexception;
        p.a("Error parsing JSON from metric database", jsonexception);
        ((Set) (obj1)).add(cursor.getString(1));
          goto _L2
        cursor.close();
        for (Iterator iterator = ((Set) (obj1)).iterator(); iterator.hasNext(); a.delete("metrics", "data=?", new String[] {
    obj1
}))
        {
            obj1 = (String)iterator.next();
        }

        return ((List) (obj));
    }

    public final void a(int i)
    {
        c = 200;
        d();
    }

    public final boolean a(List list)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        ContentValues contentvalues = new ContentValues();
        Iterator iterator = list.iterator();
        flag = false;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_129;
            }
            Object obj = (af)iterator.next();
            contentvalues.put("timestamp", Long.valueOf(((af) (obj)).a()));
            if (((af) (obj)).b() == null)
            {
                throw new NullPointerException();
            }
            while (false) 
            {
                obj = ((af) (obj)).b().toString();
                contentvalues.put("data", ((String) (obj)));
                if (a.insert("metrics", null, contentvalues) == -1L)
                {
                    b.b("db_errors", 1L);
                } else
                {
                    flag = true;
                }
            }
        } while (true);
        if (flag)
        {
            d();
        }
        if (list.isEmpty() || flag)
        {
            flag1 = true;
        }
        return flag1;
    }

    public final void b()
    {
        a.delete("metrics", null, null);
    }

    public final void c()
    {
        a.close();
    }
}
