// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.more.e.b;
import com.cyberlink.youcammakeup.database.more.p;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.h:
//            c

public class d
{

    private final SQLiteDatabase a = h.a();
    private final SQLiteDatabase b = h.b();

    public d()
    {
    }

    public com.cyberlink.youcammakeup.database.more.h.c a(com.cyberlink.youcammakeup.database.more.h.c c1)
    {
        com.cyberlink.youcammakeup.database.more.h.c c2 = a(c1.a());
        if (c2 == null) goto _L2; else goto _L1
_L1:
        c1 = c2;
_L4:
        return c1;
_L2:
        ContentValues contentvalues = c1.l();
        long l;
        try
        {
            m.a("PatternInfoDao", (new StringBuilder()).append("db.insert to PatternInfo: ").append(contentvalues.toString()).toString());
            l = b.insert("PatternInfo", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.youcammakeup.database.more.h.c c1)
        {
            m.e("PatternInfoDao", (new StringBuilder()).append("db.insert exception: ").append(c1.getMessage()).toString());
            return null;
        }
        if (l >= 0L) goto _L4; else goto _L3
_L3:
        m.e("PatternInfoDao", (new StringBuilder()).append("db.insert failed. id: ").append(l).toString());
        return null;
    }

    public com.cyberlink.youcammakeup.database.more.h.c a(String s)
    {
        Cursor cursor;
        String as[] = p.a();
        String s1 = c.c;
        cursor = a.query("PatternInfo", as, "GUID=?", new String[] {
            s
        }, null, null, null, s1);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        m.e("PatternInfoDao", "Failed to query: cursor is null");
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
        m.b("PatternInfoDao", "Failure of cursor.moveToFirst().");
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
        int i4;
        int j4;
        k = cursor.getColumnIndex("GUID");
        l = cursor.getColumnIndex("PatternType");
        i1 = cursor.getColumnIndex("Name");
        j1 = cursor.getColumnIndex("ThumbPath");
        k1 = cursor.getColumnIndex("Source");
        l1 = cursor.getColumnIndex("SupportMode");
        i2 = cursor.getColumnIndex("Version");
        j2 = cursor.getColumnIndex("ColorImagePath");
        k2 = cursor.getColumnIndex("ToolImagePath");
        l2 = cursor.getColumnIndex("ExtraData");
        i3 = cursor.getColumnIndex("IsNew");
        j3 = cursor.getColumnIndex("SkuGUID");
        k3 = cursor.getColumnIndex("ExtStr1");
        l3 = cursor.getColumnIndex("ExtStr2");
        i4 = cursor.getColumnIndex("ExtStr3");
        j4 = cursor.getColumnIndex("ExtInt1");
        j = cursor.getColumnIndex("ExtInt2");
        i = cursor.getColumnIndex("ExtInt3");
        if (k >= 0 && l >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0 && i2 >= 0 && j2 >= 0 && k2 >= 0 && l2 >= 0 && i3 >= 0 && j3 >= 0 && k3 >= 0 && l3 >= 0 && i4 >= 0 && j4 >= 0 && j >= 0 && i >= 0)
        {
            break MISSING_BLOCK_LABEL_386;
        }
        m.e("PatternInfoDao", "cursor.getColumnIndex() returned negative number");
        s = null;
        if (cursor == null) goto _L4; else goto _L5
_L5:
        cursor.close();
        return null;
        float f;
        Object obj1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        String s8;
        s = cursor.getString(k);
        obj1 = cursor.getString(l);
        s2 = cursor.getString(i1);
        s3 = cursor.getString(j1);
        s4 = cursor.getString(k1);
        s5 = cursor.getString(l1);
        f = cursor.getFloat(i2);
        s6 = cursor.getString(j2);
        s7 = cursor.getString(k2);
        s8 = cursor.getString(l2);
        String s9;
        String s10;
        String s11;
        String s12;
        boolean flag;
        if (cursor.getInt(i3) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s9 = cursor.getString(j3);
        s10 = cursor.getString(k3);
        s11 = cursor.getString(l3);
        s12 = cursor.getString(i4);
        k = cursor.getInt(j4);
        j = cursor.getInt(j);
        i = cursor.getInt(i);
        obj1 = new com.cyberlink.youcammakeup.database.more.h.c(s, ((String) (obj1)), s2, s3, s4, s5, Float.valueOf(f).floatValue(), s6, s7, Boolean.valueOf(flag).booleanValue(), s9, s8, s10, s11, s12, Integer.valueOf(k).intValue(), Integer.valueOf(j).intValue(), Integer.valueOf(i).intValue());
        s = ((String) (obj1));
        if (cursor == null) goto _L4; else goto _L6
_L6:
        cursor.close();
        return ((com.cyberlink.youcammakeup.database.more.h.c) (obj1));
        s;
        cursor = null;
_L10:
        m.e("PatternInfoDao", (new StringBuilder()).append("Exception: ").append(s.getMessage()).toString());
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
        String s2;
        if (s1 != null)
        {
            s2 = "PatternType=? AND Source=?";
        } else
        {
            s2 = "PatternType=?";
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
        s = a.query("PatternInfo", new String[] {
            "GUID"
        }, s2, s, null, null, "_id ASC", null);
        if (s == null)
        {
            m.e("PatternInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("PatternInfoDao", "Failure of cursor.moveToFirst().");
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

    public Collection b(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = a.query("PatternInfo", new String[] {
            "GUID"
        }, "Source=?", new String[] {
            s
        }, null, null, "GUID ASC", null);
        if (s == null)
        {
            m.e("PatternInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("PatternInfoDao", "Failure of cursor.moveToFirst().");
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

    public Collection b(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        String s2;
        if (s1 != null)
        {
            s2 = "PatternType=? AND Source=? AND PatternId IS NULL";
        } else
        {
            s2 = "PatternType=? AND PatternId IS NULL";
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
        s1 = new SQLiteQueryBuilder();
        s1.setDistinct(true);
        s1.setTables("PatternInfo LEFT OUTER JOIN TattooMaskInfo ON PatternInfo.GUID = TattooMaskInfo.PatternId");
        s = s1.query(a, new String[] {
            "GUID"
        }, s2, s, "GUID", null, null, null);
        if (s == null)
        {
            m.e("PatternInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("PatternInfoDao", "Failure of cursor.moveToFirst().");
            s.close();
            return arraylist;
        }
        int i = s.getColumnIndex("GUID");
        do
        {
            arraylist.add(s.getString(i));
        } while (s.moveToNext());
        s.close();
        return arraylist;
    }

    public Collection c(String s)
    {
        ArrayList arraylist = new ArrayList();
        String s1 = (new StringBuilder()).append("PatternType=? AND Source='").append(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.d.name()).append("'").append(" AND ").append("SkuGUID").append("!=''").toString();
        s = a.query("PatternInfo", new String[] {
            "GUID"
        }, s1, new String[] {
            s
        }, null, null, "_id ASC", null);
        if (s == null)
        {
            m.e("PatternInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("PatternInfoDao", "Failure of cursor.moveToFirst().");
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
        try
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("IsNew", s1);
            i = b.update("PatternInfo", contentvalues, "GUID = ?", new String[] {
                s
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return i == 1;
    }

    public boolean d(String s)
    {
        int i = b.delete("PatternInfo", "GUID = ?", new String[] {
            s
        });
        if (i != 1)
        {
            m.e("PatternInfoDao", (new StringBuilder()).append("[delete]  delete id: ").append(s).append(", rowsAffected != 1, rowsAffected: ").append(i).toString());
            return false;
        } else
        {
            return h.g().b(s);
        }
    }
}
