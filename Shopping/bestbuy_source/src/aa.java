// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class aa
{

    private final z a;
    private final Map b = new HashMap();

    public aa(z z1)
    {
        a = z1;
    }

    private void b(String s)
    {
        bc.a((new StringBuilder("Statistic '")).append(s).append("' set to ").append(a(s)).toString());
    }

    public final long a(String s)
    {
        if (b.containsKey(s))
        {
            return ((Long)b.get(s)).longValue();
        } else
        {
            return -1L;
        }
    }

    public final void a()
    {
        Object obj1 = null;
        Object obj = a.getReadableDatabase();
        Cursor cursor = ((SQLiteDatabase) (obj)).query("metric_stats", null, null, null, null, null, null);
        cursor.moveToFirst();
        for (; !cursor.isAfterLast(); cursor.moveToNext())
        {
            obj1 = cursor.getString(0);
            long l = cursor.getLong(1);
            b.put(obj1, Long.valueOf(l));
        }

          goto _L1
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
_L3:
        if (cursor != null)
        {
            cursor.close();
        }
        if (obj1 != null)
        {
            ((SQLiteDatabase) (obj1)).close();
        }
        throw obj;
_L1:
        if (cursor != null)
        {
            cursor.close();
        }
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        return;
        obj;
        cursor = null;
        continue; /* Loop/switch isn't completed */
        exception;
        cursor = null;
        obj1 = obj;
        obj = exception;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public final void a(String s, long l)
    {
        b.put(s, Long.valueOf(l));
        b(s);
    }

    public final void b()
    {
        Object obj = null;
        Object obj1 = a.getWritableDatabase();
        obj = obj1;
        Iterator iterator = b.keySet().iterator();
_L2:
        obj = obj1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        String s = (String)iterator.next();
        obj = obj1;
        ContentValues contentvalues = new ContentValues();
        obj = obj1;
        contentvalues.put("stat_name", s);
        obj = obj1;
        contentvalues.put("stat_value", Long.valueOf(a(s)));
        obj = obj1;
        ((SQLiteDatabase) (obj1)).insert("metric_stats", null, contentvalues);
        if (true) goto _L2; else goto _L1
        obj1;
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        throw obj1;
_L1:
        if (obj1 != null)
        {
            ((SQLiteDatabase) (obj1)).close();
        }
        return;
    }

    public final void b(String s, long l)
    {
        b.put(s, Long.valueOf(a(s) + l));
        b(s);
    }
}
