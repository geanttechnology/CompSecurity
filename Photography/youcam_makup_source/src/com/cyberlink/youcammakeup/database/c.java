// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.cyberlink.youcammakeup.database:
//            d, e, k

public class c
{

    private static final String a[] = {
        "Level", "DataPath", "FileWidth", "FileHeight"
    };
    private static final String b[] = {
        "DataPath", "FileWidth", "FileHeight"
    };
    private final SQLiteDatabase c = com.cyberlink.youcammakeup.c.a();
    private final SQLiteDatabase d = com.cyberlink.youcammakeup.c.b();

    public c()
    {
    }

    public e a(long l, d d1)
    {
        Object obj;
        long l1;
        l1 = System.currentTimeMillis();
        int i = d1.a();
        obj = com.cyberlink.youcammakeup.c.c;
        obj = c.query("ImageCache", b, "ImageID=? AND Level=?", new String[] {
            String.valueOf(l), String.valueOf(i)
        }, null, null, null, ((String) (obj)));
        if (obj != null) goto _L2; else goto _L1
_L1:
        m.e("database.CacheDao", "Failed to query: cursor is null");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        d1 = null;
_L4:
        return d1;
_L2:
        if (((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_117;
        }
        m.b("database.CacheDao", "Failure of cursor.moveToFirst().");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        int j;
        int i1;
        int j1;
        double d2 = (double)(System.currentTimeMillis() - l1) / 1000D;
        i1 = ((Cursor) (obj)).getColumnIndex("DataPath");
        j1 = ((Cursor) (obj)).getColumnIndex("FileWidth");
        j = ((Cursor) (obj)).getColumnIndex("FileHeight");
        if (i1 >= 0 && j1 >= 0 && j >= 0)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        m.e("database.CacheDao", "cursor.getColumnIndex() returned negative number");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        int k1;
        l1 = System.currentTimeMillis();
        k1 = ((Cursor) (obj)).getCount();
        if (k1 <= 1)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        m.e("database.CacheDao", (new StringBuilder()).append("cursor.getCount() > 1, count: ").append(k1).toString());
        Object obj1;
        obj1 = ((Cursor) (obj)).getString(i1);
        i1 = ((Cursor) (obj)).getInt(j1);
        j = ((Cursor) (obj)).getInt(j);
        double d3 = (double)(System.currentTimeMillis() - l1) / 1000D;
        obj1 = new e(l, d1, ((String) (obj1)), i1, j);
        d1 = ((d) (obj1));
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return ((e) (obj1));
        obj;
        d1 = null;
_L8:
        m.e("database.CacheDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
        if (d1 != null)
        {
            d1.close();
        }
        return null;
        d1;
        obj = null;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw d1;
        d1;
        continue; /* Loop/switch isn't completed */
        Object obj2;
        obj2;
        obj = d1;
        d1 = ((d) (obj2));
        if (true) goto _L6; else goto _L5
_L5:
        obj2;
        d1 = ((d) (obj));
        obj = obj2;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public e a(k k1)
    {
        android.content.ContentValues contentvalues = k1.f();
        long l;
        try
        {
            l = d.insert("ImageCache", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (k k1)
        {
            m.e("database.CacheDao", (new StringBuilder()).append("db.insert exception: ").append(k1.getMessage()).toString());
            return null;
        }
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        m.e("database.CacheDao", (new StringBuilder()).append("db.insert id: ").append(l).toString());
        return null;
        k1 = new e(k1);
        return k1;
    }

    public e[] a(long l)
    {
        e ae1[] = new e[0];
        Cursor cursor;
        long l2;
        l2 = System.currentTimeMillis();
        cursor = c.query("ImageCache", a, "ImageID=?", new String[] {
            String.valueOf(l)
        }, null, null, "Level ASC", null);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        m.e("database.CacheDao", "Failed to query: cursor is null");
        e ae[];
        if (cursor != null)
        {
            cursor.close();
        }
        ae = ae1;
_L6:
        return ae;
_L2:
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        m.b("database.CacheDao", "Failure of cursor.moveToFirst().");
        if (cursor != null)
        {
            cursor.close();
        }
        return ae1;
        int j;
        int i1;
        int j1;
        int k1;
        double d1 = (double)(System.currentTimeMillis() - l2) / 1000D;
        j = cursor.getColumnIndex("Level");
        i1 = cursor.getColumnIndex("DataPath");
        j1 = cursor.getColumnIndex("FileWidth");
        k1 = cursor.getColumnIndex("FileHeight");
        if (j >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        m.e("database.CacheDao", "cursor.getColumnIndex() returned negative number");
        if (cursor != null)
        {
            cursor.close();
        }
        return ae1;
        e ae2[];
        int l1;
        l2 = System.currentTimeMillis();
        l1 = cursor.getCount();
        ae2 = new e[l1];
        int i = 0;
_L4:
        if (i >= l1)
        {
            break; /* Loop/switch isn't completed */
        }
        ae2[i] = new e(l, com.cyberlink.youcammakeup.database.d.a(Integer.valueOf(cursor.getInt(j))), cursor.getString(i1), cursor.getInt(j1), cursor.getInt(k1));
        cursor.moveToNext();
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        l = System.currentTimeMillis();
        double d2 = (double)(l - l2) / 1000D;
        ae = ae2;
        if (cursor == null) goto _L6; else goto _L5
_L5:
        cursor.close();
        return ae2;
        Object obj;
        obj;
        cursor = null;
_L10:
        m.e("database.CacheDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
        if (cursor != null)
        {
            cursor.close();
        }
        return ae1;
        obj;
        cursor = null;
_L8:
        if (cursor != null)
        {
            cursor.close();
        }
        throw obj;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L8; else goto _L7
_L7:
        obj;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public boolean b(long l)
    {
        try
        {
            d.delete("ImageCache", "ImageID=?", new String[] {
                String.valueOf(l)
            });
        }
        catch (Exception exception)
        {
            m.e("database.CacheDao", (new StringBuilder()).append("db.delete exception: ").append(exception.getMessage()).toString());
            return false;
        }
        return true;
    }

    public boolean b(long l, d d1)
    {
        int i;
        try
        {
            i = d1.a();
            i = d.delete("ImageCache", "ImageID=? AND Level=?", new String[] {
                String.valueOf(l), String.valueOf(i)
            });
        }
        // Misplaced declaration of an exception variable
        catch (d d1)
        {
            m.e("database.CacheDao", (new StringBuilder()).append("db.update exception: ").append(d1.getMessage()).toString());
            return false;
        }
        if (i <= 1)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        m.e("database.CacheDao", (new StringBuilder()).append("update id: ").append(l).append(", rowsAffected > 1, rowsAffected: ").append(i).toString());
        return false;
        return true;
    }

    public Collection c(long l)
    {
        e ae[] = a(l);
        if (b(l)) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((Collection) (obj));
_L2:
        ArrayList arraylist = new ArrayList(ae.length);
        int j = ae.length;
        int i = 0;
        do
        {
            obj = arraylist;
            if (i >= j)
            {
                continue;
            }
            arraylist.add(ae[i].c());
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

}
