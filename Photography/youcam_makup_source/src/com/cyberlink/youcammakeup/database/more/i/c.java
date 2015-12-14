// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.i;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.database.more.s;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.i:
//            d

public class c
{

    private final SQLiteDatabase a = h.a();
    private final SQLiteDatabase b = h.b();

    public c()
    {
    }

    public d a(String s1, long l, d d1)
    {
        s1 = b(s1, l);
        if (s1 == null)
        {
            s1 = d1.q();
            try
            {
                l = b.insert("SkuCache", null, s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return null;
            }
            finally
            {
                throw s1;
            }
            s1 = d1;
            if (l < 0L)
            {
                return null;
            }
        }
        return s1;
    }

    public Collection a(String s1, long l)
    {
        boolean flag = com.cyberlink.youcammakeup.kernelctrl.sku.h.c();
        String as1[] = s.a();
        Object obj;
        String as[];
        if (!flag)
        {
            obj = "SkuType=? and SkuStartDate<=? and SkuEndDate>=?";
        } else
        {
            obj = "SkuType=?";
        }
        if (flag) goto _L2; else goto _L1
_L1:
        as = new String[3];
        as[0] = s1;
        as[1] = String.valueOf(l);
        as[2] = String.valueOf(l);
        s1 = as;
_L5:
        obj = a.query("SkuCache", as1, ((String) (obj)), s1, null, null, null, null);
        if (obj != null) goto _L4; else goto _L3
_L3:
        s1 = ((String) (obj));
        m.e("SkuDAO", "Failed to query: cursor is null");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        s1 = null;
_L9:
        return s1;
_L2:
        as = new String[1];
        as[0] = s1;
        s1 = as;
          goto _L5
        Exception exception1;
        exception1;
        obj = null;
_L12:
        s1 = ((String) (obj));
        m.e("SkuDAO", (new StringBuilder()).append("Exception: ").append(exception1.getMessage()).toString());
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
_L4:
        s1 = ((String) (obj));
        if (((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_219;
        }
        s1 = ((String) (obj));
        m.b("SkuDAO", "Failure of cursor.moveToFirst().");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        s1 = ((String) (obj));
        ArrayList arraylist = new ArrayList();
        s1 = ((String) (obj));
        int j = ((Cursor) (obj)).getCount();
        s1 = ((String) (obj));
        ((Cursor) (obj)).moveToFirst();
        int i = 0;
_L7:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = ((String) (obj));
        int k = ((Cursor) (obj)).getColumnIndex("JsonString");
        if (k >= 0)
        {
            break MISSING_BLOCK_LABEL_308;
        }
        s1 = ((String) (obj));
        m.e("SkuDAO", "cursor.getColumnIndex() returned negative number");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        s1 = ((String) (obj));
        arraylist.add(new d(new JSONObject(((Cursor) (obj)).getString(k))));
        s1 = ((String) (obj));
        ((Cursor) (obj)).moveToNext();
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        s1 = arraylist;
        if (obj == null) goto _L9; else goto _L8
_L8:
        ((Cursor) (obj)).close();
        return arraylist;
        Exception exception;
        exception;
        s1 = null;
_L11:
        if (s1 != null)
        {
            s1.close();
        }
        throw exception;
        exception;
        if (true) goto _L11; else goto _L10
_L10:
        arraylist;
          goto _L12
    }

    public boolean a()
    {
        try
        {
            b.delete("SkuCache", null, null);
        }
        catch (Exception exception)
        {
            return false;
        }
        return true;
    }

    public d b(String s1, long l)
    {
        Cursor cursor;
        String as[] = s.a();
        String s2 = com.cyberlink.youcammakeup.c.c;
        cursor = a.query("SkuCache", as, "SkuType=? and Skuid=?", new String[] {
            s1, String.valueOf(l)
        }, null, null, null, s2);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        s1 = cursor;
        m.e("SkuDAO", "Failed to query: cursor is null");
        if (cursor != null)
        {
            cursor.close();
        }
        s1 = null;
_L4:
        return s1;
_L2:
        s1 = cursor;
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_115;
        }
        s1 = cursor;
        m.b("SkuDAO", "Failure of cursor.moveToFirst().");
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        s1 = cursor;
        int i = cursor.getColumnIndex("JsonString");
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        s1 = cursor;
        m.e("SkuDAO", "cursor.getColumnIndex() returned negative number");
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        s1 = cursor;
        d d1 = new d(new JSONObject(cursor.getString(i)));
        s1 = d1;
        if (cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
        return d1;
        Exception exception1;
        exception1;
        cursor = null;
_L8:
        s1 = cursor;
        m.e("SkuDAO", (new StringBuilder()).append("Exception: ").append(exception1.getMessage()).toString());
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        Exception exception;
        exception;
        s1 = null;
_L6:
        if (s1 != null)
        {
            s1.close();
        }
        throw exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
        exception1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean c(String s1, long l)
    {
        try
        {
            b.delete("SkuCache", "SkuType=? and Skuid=?", new String[] {
                s1, String.valueOf(l)
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return false;
        }
        return true;
    }
}
