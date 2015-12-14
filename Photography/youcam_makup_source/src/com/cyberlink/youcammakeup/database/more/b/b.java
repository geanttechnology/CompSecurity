// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.database.more.d;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.b:
//            a

public class b
{

    private final SQLiteDatabase a = h.a();
    private final SQLiteDatabase b = h.b();

    public b()
    {
    }

    public a a(a a1)
    {
        ContentValues contentvalues = a1.f();
        long l;
        m.a("ColorInfoDao", (new StringBuilder()).append("db.insert to ColorInfo: ").append(contentvalues.toString()).toString());
        l = b.insert("ColorInfo", null, contentvalues);
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        m.e("ColorInfoDao", (new StringBuilder()).append("db.insert failed. id: ").append(l).toString());
        a1 = null;
        return a1;
        a1;
        m.e("ColorInfoDao", (new StringBuilder()).append("db.insert exception: ").append(a1.getMessage()).toString());
        return null;
        a1;
        throw a1;
    }

    public a a(String s, String s1)
    {
        String as[] = d.a();
        s1 = a.query(true, "ColorInfo", as, "PatternType=? AND Source=?", new String[] {
            s, s1
        }, null, null, "_id", "1");
        if (s1 != null) goto _L2; else goto _L1
_L1:
        m.e("ColorInfoDao", "Failed to query: cursor is null");
        if (s1 != null)
        {
            s1.close();
        }
        s = null;
_L4:
        return s;
_L2:
        if (s1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_91;
        }
        m.b("ColorInfoDao", "Failure of cursor.moveToFirst().");
        if (s1 != null)
        {
            s1.close();
        }
        return null;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        i = s1.getColumnIndex("Set_GUID");
        j = s1.getColumnIndex("Color");
        k = s1.getColumnIndex("Intensity");
        l = s1.getColumnIndex("Source");
        i1 = s1.getColumnIndex("ExtraData");
        j1 = s1.getColumnIndex("Ext_1");
        k1 = s1.getColumnIndex("Ext_2");
        if (i >= 0 && j >= 0 && k >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0)
        {
            break MISSING_BLOCK_LABEL_211;
        }
        m.e("ColorInfoDao", "cursor.getColumnIndex() returned negative number");
        if (s1 != null)
        {
            s1.close();
        }
        return null;
        a a1 = new a(s1.getString(i), s, s1.getString(j), s1.getString(k), s1.getString(l), s1.getString(i1), s1.getString(j1), s1.getString(k1));
        s = a1;
        if (s1 == null) goto _L4; else goto _L3
_L3:
        s1.close();
        return a1;
        s1;
        s = null;
_L8:
        m.e("ColorInfoDao", (new StringBuilder()).append("Exception: ").append(s1.getMessage()).toString());
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
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        s1 = s;
        s = ((String) (obj));
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        s = s1;
        s1 = ((String) (obj));
        if (true) goto _L8; else goto _L7
_L7:
    }

    public String a(String s, String s1, String s2)
    {
        s = a.query(true, "ColorInfo", new String[] {
            "Set_GUID"
        }, "PatternType=? AND Color=? AND Source=?", new String[] {
            s, s1, s2
        }, "Set_GUID", null, null, "1");
        if (s != null) goto _L2; else goto _L1
_L1:
        s1 = s;
        m.e("ColorInfoDao", "Failed to query: cursor is null");
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
            break MISSING_BLOCK_LABEL_105;
        }
        s1 = s;
        m.b("ColorInfoDao", "Failure of cursor.moveToFirst().");
        if (s != null)
        {
            s.close();
        }
        return null;
        s1 = s;
        int i = s.getColumnIndex("Set_GUID");
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        s1 = s;
        m.e("ColorInfoDao", "cursor.getColumnIndex() returned negative number");
        if (s != null)
        {
            s.close();
        }
        return null;
        s1 = s;
        s2 = s.getString(i);
        s1 = s2;
        if (s == null) goto _L4; else goto _L3
_L3:
        s.close();
        return s2;
        s2;
        s = null;
_L8:
        s1 = s;
        m.e("ColorInfoDao", (new StringBuilder()).append("Exception: ").append(s2.getMessage()).toString());
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
        s2;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public List a(String s)
    {
        ArrayList arraylist = new ArrayList();
        Object obj;
        String as[] = d.a();
        obj = a.query(false, "ColorInfo", as, "Set_GUID=?", new String[] {
            s
        }, null, null, "_id", null);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        m.e("ColorInfoDao", "Failed to query: cursor is null");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return arraylist;
        if (((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_95;
        }
        m.b("ColorInfoDao", "Failure of cursor.moveToFirst().");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return arraylist;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        i = ((Cursor) (obj)).getColumnIndex("Set_GUID");
        j = ((Cursor) (obj)).getColumnIndex("PatternType");
        k = ((Cursor) (obj)).getColumnIndex("Color");
        l = ((Cursor) (obj)).getColumnIndex("Intensity");
        i1 = ((Cursor) (obj)).getColumnIndex("Source");
        j1 = ((Cursor) (obj)).getColumnIndex("ExtraData");
        k1 = ((Cursor) (obj)).getColumnIndex("Ext_1");
        l1 = ((Cursor) (obj)).getColumnIndex("Ext_2");
        if (i >= 0 && j >= 0 && k >= 0 && l >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        m.e("ColorInfoDao", "cursor.getColumnIndex() returned negative number");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return arraylist;
        boolean flag;
        do
        {
            arraylist.add(new a(s, ((Cursor) (obj)).getString(j), ((Cursor) (obj)).getString(k), ((Cursor) (obj)).getString(l), ((Cursor) (obj)).getString(i1), ((Cursor) (obj)).getString(j1), ((Cursor) (obj)).getString(k1), ((Cursor) (obj)).getString(l1)));
            flag = ((Cursor) (obj)).moveToNext();
        } while (flag);
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return arraylist;
        obj;
        s = null;
_L4:
        m.e("ColorInfoDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
        if (s != null)
        {
            s.close();
        }
        return arraylist;
        s;
        obj = null;
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        Object obj1;
        obj1;
        obj = s;
        s = ((String) (obj1));
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        s = ((String) (obj));
        obj = obj1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public transient List a(String s, String as[])
    {
        Object obj1;
        ArrayList arraylist;
        obj1 = null;
        arraylist = new ArrayList();
        String as1[] = d.a();
        String s1 = "";
        if (as.length > 0)
        {
            s1 = (new StringBuilder()).append("").append("CASE ").toString();
        }
          goto _L1
_L6:
        int i;
        if (i >= as.length)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        s1 = (new StringBuilder()).append(s1).append("Source WHEN '").append(as[i]).append("' THEN ").append(i).toString();
        i++;
        continue; /* Loop/switch isn't completed */
        String s2 = s1;
        if (as.length > 0)
        {
            s2 = (new StringBuilder()).append(s1).append(" ELSE ").append(as.length).append(" END").toString();
        }
        as = (new StringBuilder()).append("MIN(").append(s2).append(" AND ").append("_id").append("), ").append("_id").toString();
        as = a.query(true, "ColorInfo", as1, "PatternType=? AND Ext_1=?", new String[] {
            s, ""
        }, "Color", null, as, null);
        if (as != null)
        {
            break MISSING_BLOCK_LABEL_240;
        }
        m.e("ColorInfoDao", "Failed to query: cursor is null");
        if (as != null)
        {
            as.close();
        }
        return arraylist;
        if (as.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_270;
        }
        m.b("ColorInfoDao", "Failure of cursor.moveToFirst().");
        if (as != null)
        {
            as.close();
        }
        return arraylist;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        i = as.getColumnIndex("Set_GUID");
        j = as.getColumnIndex("Color");
        k = as.getColumnIndex("Intensity");
        l = as.getColumnIndex("Source");
        i1 = as.getColumnIndex("ExtraData");
        j1 = as.getColumnIndex("Ext_1");
        k1 = as.getColumnIndex("Ext_2");
        if (i >= 0 && j >= 0 && k >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0)
        {
            break MISSING_BLOCK_LABEL_391;
        }
        m.e("ColorInfoDao", "cursor.getColumnIndex() returned negative number");
        if (as != null)
        {
            as.close();
        }
        return arraylist;
        boolean flag;
        do
        {
            arraylist.add(new a(as.getString(i), s, as.getString(j), as.getString(k), as.getString(l), as.getString(i1), as.getString(j1), as.getString(k1)));
            flag = as.moveToNext();
        } while (flag);
        if (as != null)
        {
            as.close();
        }
        return arraylist;
        as;
        s = null;
_L4:
        m.e("ColorInfoDao", (new StringBuilder()).append("Exception: ").append(as.getMessage()).toString());
        if (s != null)
        {
            s.close();
        }
        return arraylist;
        s;
        as = obj1;
_L3:
        if (as != null)
        {
            as.close();
        }
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        as = s;
        s = ((String) (obj));
        if (true) goto _L3; else goto _L2
_L2:
        obj;
        s = as;
        as = ((String []) (obj));
        if (true) goto _L4; else goto _L1
_L1:
        i = 0;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean b(String s)
    {
        int i = b.delete("ColorInfo", "Set_GUID = ?", new String[] {
            s
        });
        if (i != 1)
        {
            m.e("ColorInfoDao", (new StringBuilder()).append("[deleteBySetGUID]  delete id: ").append(s).append(", rowsAffected != 1, rowsAffected: ").append(i).toString());
            return false;
        } else
        {
            return true;
        }
    }

    public boolean c(String s)
    {
        int i = b.delete("ColorInfo", "Source = ?", new String[] {
            s
        });
        if (i < 1)
        {
            m.e("ColorInfoDao", (new StringBuilder()).append("[deleteBySource]  delete id: ").append(s).append(", rowsAffected != 1, rowsAffected: ").append(i).toString());
            return false;
        } else
        {
            return true;
        }
    }
}
