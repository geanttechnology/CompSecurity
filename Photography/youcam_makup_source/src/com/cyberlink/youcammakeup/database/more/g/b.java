// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.g;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.g:
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
        ContentValues contentvalues;
        if (e(a1.a()))
        {
            f(a1.a());
        }
        contentvalues = a1.l();
        long l;
        m.a("PaletteInfoDao", (new StringBuilder()).append("db.insert to PaletteInfo: ").append(contentvalues.toString()).toString());
        l = b.insert("PaletteInfo", null, contentvalues);
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        m.e("PaletteInfoDao", (new StringBuilder()).append("db.insert failed. id: ").append(l).toString());
        a1 = null;
        return a1;
        a1;
        m.e("PaletteInfoDao", (new StringBuilder()).append("db.insert exception: ").append(a1.getMessage()).toString());
        return null;
        a1;
        throw a1;
    }

    public a a(String s)
    {
        Cursor cursor;
        String as[] = com.cyberlink.youcammakeup.database.more.m.a();
        String s1 = c.c;
        cursor = a.query("PaletteInfo", as, "GUID=?", new String[] {
            s
        }, null, null, null, s1);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        m.e("PaletteInfoDao", "Failed to query: cursor is null");
        Object obj = null;
        s = obj;
        if (cursor != null)
        {
            cursor.close();
            s = obj;
        }
_L4:
        return s;
_L2:
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_99;
        }
        m.b("PaletteInfoDao", "Failure of cursor.moveToFirst().");
        s = null;
        if (cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
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
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        i2 = cursor.getColumnIndex("ColorSetGUID");
        k3 = cursor.getColumnIndex("ColorCount");
        j2 = cursor.getColumnIndex("Name");
        k2 = cursor.getColumnIndex("Thumbnail");
        l2 = cursor.getColumnIndex("Source");
        i3 = cursor.getColumnIndex("Version");
        j3 = cursor.getColumnIndex("PaletteOrder");
        i = cursor.getColumnIndex("isNew");
        j = cursor.getColumnIndex("SkuGUID");
        k = cursor.getColumnIndex("ExtraData");
        l = cursor.getColumnIndex("Ext1");
        i1 = cursor.getColumnIndex("Ext2");
        j1 = cursor.getColumnIndex("Ext3");
        k1 = cursor.getColumnIndex("Ext4");
        l1 = cursor.getColumnIndex("Ext5");
        if (i2 >= 0 && j2 >= 0 && k2 >= 0 && l2 >= 0 && i3 >= 0 && j3 >= 0 && i >= 0 && j >= 0 && k >= 0 && l >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0)
        {
            break MISSING_BLOCK_LABEL_341;
        }
        m.e("PaletteInfoDao", "cursor.getColumnIndex() returned negative number");
        s = null;
        if (cursor == null) goto _L4; else goto _L5
_L5:
        cursor.close();
        return null;
        float f1;
        Object obj1;
        String s2;
        String s3;
        String s4;
        k3 = cursor.getInt(k3);
        obj1 = cursor.getString(i2);
        s2 = cursor.getString(j2);
        s3 = cursor.getString(k2);
        s4 = cursor.getString(l2);
        f1 = cursor.getFloat(i3);
        i2 = cursor.getInt(j3);
        String s5;
        String s6;
        String s7;
        String s8;
        String s9;
        String s10;
        String s11;
        boolean flag;
        if (cursor.getInt(i) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s5 = cursor.getString(j);
        s6 = cursor.getString(k);
        s7 = cursor.getString(l);
        s8 = cursor.getString(i1);
        s9 = cursor.getString(j1);
        s10 = cursor.getString(k1);
        s11 = cursor.getString(l1);
        obj1 = new a(s, ((String) (obj1)), Integer.valueOf(k3).intValue(), s2, s3, s4, Float.valueOf(f1).floatValue(), Integer.valueOf(i2).intValue(), Boolean.valueOf(flag).booleanValue(), s5, s6, s7, s8, s9, s10, s11);
        s = ((String) (obj1));
        if (cursor == null) goto _L4; else goto _L6
_L6:
        cursor.close();
        return ((a) (obj1));
        s;
        cursor = null;
_L10:
        m.e("PaletteInfoDao", (new StringBuilder()).append("Exception: ").append(s.getMessage()).toString());
        s = null;
        if (cursor == null) goto _L4; else goto _L7
_L7:
        cursor.close();
        return null;
        s;
        cursor = null;
_L9:
        if (cursor != null)
        {
            cursor.close();
        }
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L9; else goto _L8
_L8:
        s;
          goto _L10
    }

    public Collection a(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        s = a.query("PaletteInfo", new String[] {
            "GUID"
        }, "Ext1=? AND Source=?", new String[] {
            s, s1
        }, null, null, null, null);
        if (s == null)
        {
            m.e("PaletteInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("PaletteInfoDao", "Failure of cursor.moveToFirst().");
            s.close();
            return arraylist;
        }
        do
        {
            arraylist.add(s.getString(s.getColumnIndex("GUID")));
        } while (s.moveToNext());
        s.close();
        return arraylist;
    }

    public Collection a(String s, String s1, int i)
    {
        ArrayList arraylist = new ArrayList();
        String s2;
        if (i == 3)
        {
            s2 = "Ext1=? AND Source=? AND (ColorCount=3 OR ColorCount=4);";
        } else
        {
            s2 = "Ext1=? AND Source=? AND ColorCount=?";
        }
        if (i == 3)
        {
            String as[] = new String[2];
            as[0] = s;
            as[1] = s1;
            s = as;
        } else
        {
            String as1[] = new String[3];
            as1[0] = s;
            as1[1] = s1;
            as1[2] = String.valueOf(i);
            s = as1;
        }
        s = a.query("PaletteInfo", new String[] {
            "GUID"
        }, s2, s, null, null, "_id", null);
        if (s == null)
        {
            m.e("PaletteInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("PaletteInfoDao", "Failure of cursor.moveToFirst().");
            s.close();
            return arraylist;
        }
        do
        {
            arraylist.add(s.getString(s.getColumnIndex("GUID")));
        } while (s.moveToNext());
        s.close();
        return arraylist;
    }

    public Collection a(List list, String s)
    {
        ArrayList arraylist = new ArrayList();
        String s1 = "";
        String s2 = "";
        int i = 0;
        while (i < list.size()) 
        {
            String s3;
            StringBuilder stringbuilder;
            if (i == 0)
            {
                s3 = " AND (";
            } else
            {
                s3 = " OR ";
            }
            s3 = (new StringBuilder()).append(s3).append("PaletteInfo.Source = '").append((String)list.get(i)).append("'").toString();
            stringbuilder = (new StringBuilder()).append(s3);
            if (i + 1 == list.size())
            {
                s3 = ")";
            } else
            {
                s3 = "";
            }
            s3 = stringbuilder.append(s3).toString();
            s3 = (new StringBuilder()).append(s2).append(s3).toString();
            if (i == 0)
            {
                s2 = "CASE PaletteInfo.Source WHEN ";
            } else
            {
                s2 = " WHEN ";
            }
            s2 = (new StringBuilder()).append(s2).append("'").append((String)list.get(i)).append("' THEN ").toString();
            s2 = (new StringBuilder()).append(s2).append(String.valueOf(i + 1)).toString();
            stringbuilder = (new StringBuilder()).append(s2);
            if (i + 1 == list.size())
            {
                s2 = (new StringBuilder()).append(" ELSE ").append(String.valueOf(list.size() + 1)).append(" END").toString();
            } else
            {
                s2 = "";
            }
            s2 = stringbuilder.append(s2).toString();
            s1 = (new StringBuilder()).append(s1).append(s2).toString();
            i++;
            s2 = s3;
        }
        list = (new StringBuilder()).append("SELECT PaletteInfo.GUID FROM PaletteInfo LEFT JOIN ColorInfo WHERE PaletteInfo.ColorSetGUID = ColorInfo.Set_GUID AND PaletteInfo.ColorCount=1 AND PaletteInfo.Ext1=?").append(s2).append(" GROUP BY ").append("Color").append(" ORDER BY ").append("MIN(").append(s1).append("), ").append("PaletteInfo").append(".").append("_id").append(" ASC").toString();
        list = a.rawQuery(list, new String[] {
            s
        });
        if (list == null)
        {
            m.e("PaletteInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!list.moveToFirst())
        {
            m.e("PaletteInfoDao", "Failure of cursor.moveToFirst().");
            list.close();
            return arraylist;
        }
        do
        {
            arraylist.add(list.getString(list.getColumnIndex("GUID")));
        } while (list.moveToNext());
        list.close();
        return arraylist;
    }

    public a b(String s)
    {
        Cursor cursor;
        String as[] = com.cyberlink.youcammakeup.database.more.m.a();
        String s1 = c.c;
        cursor = a.query("PaletteInfo", as, "ColorSetGUID=?", new String[] {
            s
        }, null, null, null, s1);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        m.e("PaletteInfoDao", "Failed to query: cursor is null");
        Object obj = null;
        s = obj;
        if (cursor != null)
        {
            cursor.close();
            s = obj;
        }
_L4:
        return s;
_L2:
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_100;
        }
        m.b("PaletteInfoDao", "Failure of cursor.moveToFirst().");
        s = null;
        if (cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
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
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        k3 = cursor.getColumnIndex("GUID");
        i2 = cursor.getColumnIndex("ColorSetGUID");
        l3 = cursor.getColumnIndex("ColorCount");
        j2 = cursor.getColumnIndex("Name");
        k2 = cursor.getColumnIndex("Thumbnail");
        l2 = cursor.getColumnIndex("Source");
        i3 = cursor.getColumnIndex("Version");
        j3 = cursor.getColumnIndex("PaletteOrder");
        i = cursor.getColumnIndex("isNew");
        j = cursor.getColumnIndex("SkuGUID");
        k = cursor.getColumnIndex("ExtraData");
        l = cursor.getColumnIndex("Ext1");
        i1 = cursor.getColumnIndex("Ext2");
        j1 = cursor.getColumnIndex("Ext3");
        k1 = cursor.getColumnIndex("Ext4");
        l1 = cursor.getColumnIndex("Ext5");
        if (k3 >= 0 && i2 >= 0 && j2 >= 0 && k2 >= 0 && l2 >= 0 && i3 >= 0 && j3 >= 0 && i >= 0 && j >= 0 && k >= 0 && l >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0)
        {
            break MISSING_BLOCK_LABEL_357;
        }
        m.e("PaletteInfoDao", "cursor.getColumnIndex() returned negative number");
        s = null;
        if (cursor == null) goto _L4; else goto _L5
_L5:
        cursor.close();
        return null;
        float f1;
        Object obj1;
        String s2;
        String s3;
        String s4;
        s = cursor.getString(k3);
        k3 = cursor.getInt(l3);
        obj1 = cursor.getString(i2);
        s2 = cursor.getString(j2);
        s3 = cursor.getString(k2);
        s4 = cursor.getString(l2);
        f1 = cursor.getFloat(i3);
        i2 = cursor.getInt(j3);
        String s5;
        String s6;
        String s7;
        String s8;
        String s9;
        String s10;
        String s11;
        boolean flag;
        if (cursor.getInt(i) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s5 = cursor.getString(j);
        s6 = cursor.getString(k);
        s7 = cursor.getString(l);
        s8 = cursor.getString(i1);
        s9 = cursor.getString(j1);
        s10 = cursor.getString(k1);
        s11 = cursor.getString(l1);
        obj1 = new a(s, ((String) (obj1)), Integer.valueOf(k3).intValue(), s2, s3, s4, Float.valueOf(f1).floatValue(), Integer.valueOf(i2).intValue(), Boolean.valueOf(flag).booleanValue(), s5, s6, s7, s8, s9, s10, s11);
        s = ((String) (obj1));
        if (cursor == null) goto _L4; else goto _L6
_L6:
        cursor.close();
        return ((a) (obj1));
        s;
        cursor = null;
_L10:
        m.e("PaletteInfoDao", (new StringBuilder()).append("Exception: ").append(s.getMessage()).toString());
        s = null;
        if (cursor == null) goto _L4; else goto _L7
_L7:
        cursor.close();
        return null;
        s;
        cursor = null;
_L9:
        if (cursor != null)
        {
            cursor.close();
        }
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L9; else goto _L8
_L8:
        s;
          goto _L10
    }

    public Collection b(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        s = a.rawQuery("SELECT PaletteInfo.GUID FROM PaletteInfo WHERE (PaletteInfo.GUID IN  (SELECT PaletteInfo.GUID FROM PaletteInfo LEFT JOIN ColorInfo WHERE PaletteInfo.ColorSetGUID==ColorInfo.Set_GUID AND PaletteInfo.ColorCount==1 AND PaletteInfo.Ext1=? AND PaletteInfo.Source=? GROUP BY Color ORDER BY MIN(PaletteInfo._id)));", new String[] {
            s, s1
        });
        if (s == null)
        {
            m.e("PaletteInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("PaletteInfoDao", "Failure of cursor.moveToFirst().");
            s.close();
            return arraylist;
        }
        do
        {
            arraylist.add(s.getString(s.getColumnIndex("GUID")));
        } while (s.moveToNext());
        s.close();
        return arraylist;
    }

    public Collection c(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = a.query("PaletteInfo", new String[] {
            "GUID"
        }, "Source=?", new String[] {
            s
        }, null, null, null, null);
        if (s == null)
        {
            m.e("PaletteInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("PaletteInfoDao", "Failure of cursor.moveToFirst().");
            s.close();
            return arraylist;
        }
        do
        {
            arraylist.add(s.getString(s.getColumnIndex("GUID")));
        } while (s.moveToNext());
        s.close();
        return arraylist;
    }

    public boolean c(String s, String s1)
    {
        int i;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("isNew", s1);
        i = b.update("PaletteInfo", contentvalues, "GUID = ?", new String[] {
            s
        });
        if (i == 1)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        m.e("PaletteInfoDao", (new StringBuilder()).append("[updateIsNew] update GUID: ").append(s).append("+ rowsAffected != 1, rowsAffected: ").append(i).toString());
        return false;
        return true;
        s;
        m.e("PaletteInfoDao", (new StringBuilder()).append("[updateIsNew] db.update exception: ").append(s.getMessage()).toString());
        return false;
        s;
        throw s;
    }

    public Collection d(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = a.query("PaletteInfo", new String[] {
            "GUID"
        }, "SkuGUID=?", new String[] {
            s
        }, null, null, null, null);
        if (s == null)
        {
            m.e("PaletteInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("PaletteInfoDao", "Failure of cursor.moveToFirst().");
            s.close();
            return arraylist;
        }
        do
        {
            arraylist.add(s.getString(s.getColumnIndex("GUID")));
        } while (s.moveToNext());
        s.close();
        return arraylist;
    }

    public boolean e(String s)
    {
        Cursor cursor = a.query("PaletteInfo", new String[] {
            "GUID"
        }, "GUID=?", new String[] {
            s
        }, null, null, null, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        s = cursor;
        boolean flag = cursor.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (cursor != null)
        {
            cursor.close();
        }
        return false;
        if (cursor != null)
        {
            cursor.close();
        }
        return true;
        Exception exception1;
        exception1;
        cursor = null;
_L4:
        s = cursor;
        m.e("PaletteInfoDao", (new StringBuilder()).append("Exception: ").append(exception1.getMessage()).toString());
        if (cursor != null)
        {
            cursor.close();
        }
        return false;
        Exception exception;
        exception;
        s = null;
_L2:
        if (s != null)
        {
            s.close();
        }
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
        exception1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean f(String s)
    {
        a a1 = a(s);
        int i = b.delete("PaletteInfo", "GUID = ?", new String[] {
            s
        });
        if (i != 1)
        {
            m.e("PaletteInfoDao", (new StringBuilder()).append("[delete]  delete id: ").append(s).append(", rowsAffected != 1, rowsAffected: ").append(i).toString());
            return false;
        }
        if (h.i().a(a1.b()).size() == 0)
        {
            return h.i().b(a1.b());
        } else
        {
            return true;
        }
    }
}
