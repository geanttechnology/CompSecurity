// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.i;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.database.more.r;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.i:
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
        ContentValues contentvalues = a1.i();
        long l;
        try
        {
            m.a("ColorInfoDao", (new StringBuilder()).append("db.insert to SkuColorInfo: ").append(contentvalues.toString()).toString());
            l = b.insert("SkuColorInfo", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            m.e("ColorInfoDao", (new StringBuilder()).append("db.insert exception: ").append(a1.getMessage()).toString());
            return null;
        }
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        m.e("ColorInfoDao", (new StringBuilder()).append("db.insert failed. id: ").append(l).toString());
        a1 = null;
        return a1;
    }

    public List a(String s)
    {
        ArrayList arraylist = new ArrayList();
        Object obj;
        String as[] = r.a();
        obj = a.query(false, "SkuColorInfo", as, "SkuGUID=?", new String[] {
            s
        }, null, null, "_id", null);
        if (obj != null) goto _L2; else goto _L1
_L1:
        m.e("ColorInfoDao", "Failed to query: cursor is null");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        obj = arraylist;
_L4:
        return ((List) (obj));
_L2:
        if (((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_94;
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
        int i2;
        int j2;
        i = ((Cursor) (obj)).getColumnIndex("ItemGUID");
        j = ((Cursor) (obj)).getColumnIndex("PatternGUID");
        k = ((Cursor) (obj)).getColumnIndex("ColorNumber");
        l = ((Cursor) (obj)).getColumnIndex("ColorName");
        i1 = ((Cursor) (obj)).getColumnIndex("ColorType");
        j1 = ((Cursor) (obj)).getColumnIndex("Color");
        k1 = ((Cursor) (obj)).getColumnIndex("Intensity");
        l1 = ((Cursor) (obj)).getColumnIndex("ExtraData");
        i2 = ((Cursor) (obj)).getColumnIndex("Ext_1");
        j2 = ((Cursor) (obj)).getColumnIndex("Ext_2");
        if (i >= 0 && j >= 0 && k >= 0 && l >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0 && i2 >= 0 && j2 >= 0)
        {
            break MISSING_BLOCK_LABEL_264;
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
            String s1 = ((Cursor) (obj)).getString(i);
            String s2 = ((Cursor) (obj)).getString(j);
            String s3 = ((Cursor) (obj)).getString(k);
            String s4 = ((Cursor) (obj)).getString(l);
            String s5 = ((Cursor) (obj)).getString(i1);
            String s6 = ((Cursor) (obj)).getString(j1);
            int k2 = ((Cursor) (obj)).getInt(k1);
            String s7 = ((Cursor) (obj)).getString(l1);
            String s8 = ((Cursor) (obj)).getString(i2);
            String s9 = ((Cursor) (obj)).getString(j2);
            arraylist.add(new a(s, s1, s2, s3, s4, s5, s6, Integer.valueOf(k2).intValue(), s7, s8, s9));
            flag = ((Cursor) (obj)).moveToNext();
        } while (flag);
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return arraylist;
        obj;
        s = null;
_L7:
        m.e("ColorInfoDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
        obj = null;
        if (s == null) goto _L4; else goto _L3
_L3:
        s.close();
        return null;
        s;
        obj = null;
_L6:
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
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        s = ((String) (obj));
        obj = obj1;
          goto _L7
    }

    public a b(String s)
    {
        Object obj;
        String as[] = r.a();
        obj = a.query(false, "SkuColorInfo", as, "ItemGUID=?", new String[] {
            s
        }, null, null, null, null);
        if (obj != null) goto _L2; else goto _L1
_L1:
        m.e("ColorInfoDao", "Failed to query: cursor is null");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        s = null;
_L4:
        return s;
_L2:
        if (((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        m.b("ColorInfoDao", "Failure of cursor.moveToFirst().");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        l = ((Cursor) (obj)).getColumnIndex("SkuGUID");
        i1 = ((Cursor) (obj)).getColumnIndex("PatternGUID");
        j1 = ((Cursor) (obj)).getColumnIndex("ColorNumber");
        k1 = ((Cursor) (obj)).getColumnIndex("ColorName");
        l1 = ((Cursor) (obj)).getColumnIndex("ColorType");
        i2 = ((Cursor) (obj)).getColumnIndex("Color");
        j2 = ((Cursor) (obj)).getColumnIndex("Intensity");
        i = ((Cursor) (obj)).getColumnIndex("ExtraData");
        j = ((Cursor) (obj)).getColumnIndex("Ext_1");
        k = ((Cursor) (obj)).getColumnIndex("Ext_2");
        if (l >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0 && i2 >= 0 && j2 >= 0 && i >= 0 && j >= 0 && k >= 0)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        m.e("ColorInfoDao", "cursor.getColumnIndex() returned negative number");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        Object obj1;
        obj1 = ((Cursor) (obj)).getString(l);
        String s1 = ((Cursor) (obj)).getString(i1);
        String s2 = ((Cursor) (obj)).getString(j1);
        String s3 = ((Cursor) (obj)).getString(k1);
        String s4 = ((Cursor) (obj)).getString(l1);
        String s5 = ((Cursor) (obj)).getString(i2);
        l = ((Cursor) (obj)).getInt(j2);
        String s6 = ((Cursor) (obj)).getString(i);
        String s7 = ((Cursor) (obj)).getString(j);
        String s8 = ((Cursor) (obj)).getString(k);
        obj1 = new a(((String) (obj1)), s, s1, s2, s3, s4, s5, Integer.valueOf(l).intValue(), s6, s7, s8);
        s = ((String) (obj1));
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return ((a) (obj1));
        obj;
        s = null;
_L8:
        m.e("ColorInfoDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
        if (s != null)
        {
            s.close();
        }
        return null;
        s;
        obj = null;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        Object obj2;
        obj2;
        obj = s;
        s = ((String) (obj2));
        if (true) goto _L6; else goto _L5
_L5:
        obj2;
        s = ((String) (obj));
        obj = obj2;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public a c(String s)
    {
        Object obj;
        String as[] = r.a();
        obj = a.query(false, "SkuColorInfo", as, "SkuGUID=?", new String[] {
            s
        }, null, null, "_id", "1");
        if (obj != null) goto _L2; else goto _L1
_L1:
        m.e("ColorInfoDao", "Failed to query: cursor is null");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        s = null;
_L4:
        return s;
_L2:
        if (((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_87;
        }
        m.b("ColorInfoDao", "Failure of cursor.moveToFirst().");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        l = ((Cursor) (obj)).getColumnIndex("ItemGUID");
        i1 = ((Cursor) (obj)).getColumnIndex("PatternGUID");
        j1 = ((Cursor) (obj)).getColumnIndex("ColorNumber");
        k1 = ((Cursor) (obj)).getColumnIndex("ColorName");
        l1 = ((Cursor) (obj)).getColumnIndex("ColorType");
        i2 = ((Cursor) (obj)).getColumnIndex("Color");
        j2 = ((Cursor) (obj)).getColumnIndex("Intensity");
        i = ((Cursor) (obj)).getColumnIndex("ExtraData");
        j = ((Cursor) (obj)).getColumnIndex("Ext_1");
        k = ((Cursor) (obj)).getColumnIndex("Ext_2");
        if (l >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0 && i2 >= 0 && j2 >= 0 && i >= 0 && j >= 0 && k >= 0)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        m.e("ColorInfoDao", "cursor.getColumnIndex() returned negative number");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        Object obj1;
        obj1 = ((Cursor) (obj)).getString(l);
        String s1 = ((Cursor) (obj)).getString(i1);
        String s2 = ((Cursor) (obj)).getString(j1);
        String s3 = ((Cursor) (obj)).getString(k1);
        String s4 = ((Cursor) (obj)).getString(l1);
        String s5 = ((Cursor) (obj)).getString(i2);
        l = ((Cursor) (obj)).getInt(j2);
        String s6 = ((Cursor) (obj)).getString(i);
        String s7 = ((Cursor) (obj)).getString(j);
        String s8 = ((Cursor) (obj)).getString(k);
        obj1 = new a(s, ((String) (obj1)), s1, s2, s3, s4, s5, Integer.valueOf(l).intValue(), s6, s7, s8);
        s = ((String) (obj1));
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return ((a) (obj1));
        obj;
        s = null;
_L8:
        m.e("ColorInfoDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
        if (s != null)
        {
            s.close();
        }
        return null;
        s;
        obj = null;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        Object obj2;
        obj2;
        obj = s;
        s = ((String) (obj2));
        if (true) goto _L6; else goto _L5
_L5:
        obj2;
        s = ((String) (obj));
        obj = obj2;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
