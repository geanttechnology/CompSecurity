// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.d:
//            c

public class d
{

    private final SQLiteDatabase a = h.a();
    private final SQLiteDatabase b = h.b();

    public d()
    {
    }

    public c a(c c1)
    {
        ContentValues contentvalues = c1.b();
        long l;
        m.a("LookCategoryInfoDao", (new StringBuilder()).append("db.insert to LookCategoryInfo: ").append(contentvalues.toString()).toString());
        l = b.insert("LookCategoryInfo", null, contentvalues);
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        m.e("LookCategoryInfoDao", (new StringBuilder()).append("db.insert failed. id: ").append(l).toString());
        c1 = null;
        return c1;
        c1;
        m.e("LookCategoryInfoDao", (new StringBuilder()).append("db.insert exception: ").append(c1.getMessage()).toString());
        return null;
        c1;
        throw c1;
    }

    public String a(String s)
    {
        s = a.query(true, "LookCategoryInfo", new String[] {
            "Type"
        }, "GUID=?", new String[] {
            s
        }, "Type", null, null, "1");
        if (s != null) goto _L2; else goto _L1
_L1:
        String s1 = s;
        m.e("LookCategoryInfoDao", "Failed to query: cursor is null");
        if (s != null)
        {
            s.close();
        }
        s1 = null;
_L4:
        return s1;
_L2:
        s1 = s;
        if (s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_97;
        }
        s1 = s;
        m.b("LookCategoryInfoDao", "Failure of cursor.moveToFirst().");
        if (s != null)
        {
            s.close();
        }
        return null;
        s1 = s;
        int i = s.getColumnIndex("Type");
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        s1 = s;
        m.e("LookCategoryInfoDao", "cursor.getColumnIndex() returned negative number");
        if (s != null)
        {
            s.close();
        }
        return null;
        s1 = s;
        String s2 = s.getString(i);
        s1 = s2;
        if (s == null) goto _L4; else goto _L3
_L3:
        s.close();
        return s2;
        Exception exception;
        exception;
        s = null;
_L8:
        s1 = s;
        m.e("LookCategoryInfoDao", (new StringBuilder()).append("Exception: ").append(exception.getMessage()).toString());
        if (s != null)
        {
            s.close();
        }
        return null;
        s;
        s1 = null;
_L6:
        if (s1 != null)
        {
            s1.close();
        }
        throw s;
        s;
        if (true) goto _L6; else goto _L5
_L5:
        exception;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public transient Collection a(String s, String as[])
    {
        String s1;
        Object obj1;
        ArrayList arraylist;
        obj1 = null;
        arraylist = new ArrayList();
        s1 = "Type=?";
        String as1[] = new String[as.length + 1];
        as1[0] = s;
        s = s1;
        if (as.length > 0)
        {
            s = (new StringBuilder()).append("Type=?").append(" AND ( ").toString();
        }
          goto _L1
_L8:
        int i;
        if (i >= as.length + 1)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        s1 = s;
        if (i <= 1)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        s1 = (new StringBuilder()).append(s).append(" OR ").toString();
        s = (new StringBuilder()).append(s1).append("Source=?").toString();
        as1[i] = as[i - 1];
        i++;
        continue; /* Loop/switch isn't completed */
        s1 = s;
        if (as.length > 0)
        {
            s1 = (new StringBuilder()).append(s).append(" )").toString();
        }
        s = new SQLiteQueryBuilder();
        s.setDistinct(true);
        s.setTables("LookInfo INNER JOIN LookCategoryInfo ON LookInfo.GUID = LookCategoryInfo.GUID");
        as = s.query(a, new String[] {
            "LookCategoryInfo.GUID"
        }, s1, as1, "LookCategoryInfo.GUID", null, "_id", null);
        if (as != null)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        s = as;
        m.e("LookCategoryInfoDao", "Failed to query: cursor is null");
        if (as != null)
        {
            as.close();
        }
        return arraylist;
        s = as;
        if (as.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_271;
        }
        s = as;
        m.b("LookCategoryInfoDao", "Failure of cursor.moveToFirst().");
        if (as != null)
        {
            as.close();
        }
        return arraylist;
        s = as;
        i = as.getColumnIndex("GUID");
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_311;
        }
        s = as;
        m.e("LookCategoryInfoDao", "cursor.getColumnIndex() returned negative number");
        if (as != null)
        {
            as.close();
        }
        return arraylist;
_L3:
        s = as;
        arraylist.add(as.getString(i));
        s = as;
        boolean flag = as.moveToNext();
        if (flag) goto _L3; else goto _L2
_L2:
        if (as != null)
        {
            as.close();
        }
        return arraylist;
        Object obj;
        obj;
        as = null;
_L6:
        s = as;
        m.e("LookCategoryInfoDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
        if (as != null)
        {
            as.close();
        }
        return arraylist;
        s;
        as = obj1;
_L5:
        if (as != null)
        {
            as.close();
        }
        throw s;
        obj;
        as = s;
        s = ((String) (obj));
        if (true) goto _L5; else goto _L4
_L4:
        obj;
        if (true) goto _L6; else goto _L1
_L1:
        i = 1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean b(String s)
    {
        int i = b.delete("LookCategoryInfo", "GUID = ?", new String[] {
            s
        });
        if (i == 0)
        {
            m.e("LookCategoryInfoDao", (new StringBuilder()).append("[delete]  delete id: ").append(s).append(", rowsAffected: ").append(i).toString());
            return false;
        } else
        {
            return true;
        }
    }
}
