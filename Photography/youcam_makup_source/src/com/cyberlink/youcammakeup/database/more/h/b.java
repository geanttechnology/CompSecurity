// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.database.more.g.a;
import com.cyberlink.youcammakeup.database.more.o;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.h:
//            a, e, f

public class b
{

    private final SQLiteDatabase a = h.a();
    private final SQLiteDatabase b = h.b();

    public b()
    {
    }

    public com.cyberlink.youcammakeup.database.more.h.a a(com.cyberlink.youcammakeup.database.more.h.a a1)
    {
        ContentValues contentvalues = a1.a();
        long l;
        try
        {
            m.a("PatternColorInfoDao", (new StringBuilder()).append("db.insert to PatternColorInfo: ").append(contentvalues.toString()).toString());
            l = b.insert("PatternColorInfo", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.youcammakeup.database.more.h.a a1)
        {
            m.e("PatternColorInfoDao", (new StringBuilder()).append("db.insert exception: ").append(a1.getMessage()).toString());
            return null;
        }
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        m.e("PatternColorInfoDao", (new StringBuilder()).append("db.insert failed. id: ").append(l).toString());
        a1 = null;
        return a1;
    }

    public Collection a(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        String as1[] = o.a();
        String s2;
        if (s1 != null)
        {
            s2 = "PatternGUID=? AND Source=?";
        } else
        {
            s2 = "PatternGUID=?";
        }
        if (s1 != null)
        {
            String as[] = new String[2];
            as[0] = s;
            as[1] = s1;
            s = as;
        } else
        {
            s1 = new String[1];
            s1[0] = s;
            s = s1;
        }
        s = a.query(true, "PatternColorInfo", as1, s2, s, "ColorGUID", null, null, null);
        if (s == null)
        {
            m.e("PatternColorInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("PatternColorInfoDao", "Failure of cursor.moveToFirst().");
            s.close();
            return arraylist;
        }
        int i = s.getColumnIndex("ColorGUID");
        do
        {
            arraylist.add(s.getString(i));
        } while (s.moveToNext());
        s.close();
        return arraylist;
    }

    public void a()
    {
        Cursor cursor = a.query("PatternColorInfo", o.a(), null, null, null, null, null, null);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        boolean flag = cursor.moveToFirst();
        if (flag) goto _L3; else goto _L2
_L2:
        if (cursor != null)
        {
            cursor.close();
        }
_L7:
        return;
_L3:
        int i;
        int j;
        int k;
        i = cursor.getColumnIndex("PatternGUID");
        j = cursor.getColumnIndex("ColorGUID");
        k = cursor.getColumnIndex("Source");
_L5:
        Object obj;
        String s;
        String s1;
        a a1;
        obj = cursor.getString(i);
        s = cursor.getString(j);
        s1 = cursor.getString(k);
        a1 = h.j().a(s);
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        obj = new e(((String) (obj)), s, s1, null, null, a1.c(), null);
        h.n().a(((e) (obj)));
        flag = cursor.moveToNext();
        if (flag) goto _L5; else goto _L4
_L4:
        if (cursor == null) goto _L7; else goto _L6
_L6:
        cursor.close();
        return;
        Object obj1;
        obj1;
        cursor = null;
_L11:
        m.e("PatternColorInfoDao", (new StringBuilder()).append("updateRelationToColor fail, e:").append(((Exception) (obj1)).getMessage()).toString());
        if (cursor == null) goto _L7; else goto _L8
_L8:
        cursor.close();
        return;
        obj1;
        cursor = null;
_L10:
        if (cursor != null)
        {
            cursor.close();
        }
        throw obj1;
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L10; else goto _L9
_L9:
        obj1;
          goto _L11
    }

    public boolean a(String s)
    {
        int i = b.delete("PatternColorInfo", "Source = ?", new String[] {
            s
        });
        if (i < 1)
        {
            m.e("PatternColorInfoDao", (new StringBuilder()).append("[deleteBySource]  delete id: ").append(s).append(", rowsAffected != 1, rowsAffected: ").append(i).toString());
            return false;
        } else
        {
            return true;
        }
    }
}
