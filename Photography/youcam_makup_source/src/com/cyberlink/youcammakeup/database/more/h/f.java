// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.cyberlink.youcammakeup.database.more.q;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.h:
//            e

public class f
{

    private final SQLiteDatabase a = h.a();
    private final SQLiteDatabase b = h.b();

    public f()
    {
    }

    public e a(e e1)
    {
        ContentValues contentvalues = e1.a();
        long l;
        m.a("PatternPaletteInfoDao", (new StringBuilder()).append("db.insert to PatternPaletteInfo: ").append(contentvalues.toString()).toString());
        l = b.insert("PatternPaletteInfo", null, contentvalues);
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        m.e("PatternPaletteInfoDao", (new StringBuilder()).append("db.insert failed. id: ").append(l).toString());
        e1 = null;
        return e1;
        e1;
        m.e("PatternPaletteInfoDao", (new StringBuilder()).append("db.insert exception: ").append(e1.getMessage()).toString());
        return null;
        e1;
        throw e1;
    }

    public Collection a(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        String as1[] = q.a();
        String s2;
        String as[];
        if (s1 != null)
        {
            s2 = "PaletteGUID=? AND Source=?";
        } else
        {
            s2 = "PaletteGUID=?";
        }
        if (s1 == null) goto _L2; else goto _L1
_L1:
        as = new String[2];
        as[0] = s;
        as[1] = s1;
        s = as;
_L5:
        s1 = a.query(true, "PatternPaletteInfo", as1, s2, s, "PatternGUID", null, "MIN(_id)", null);
        if (s1 != null) goto _L4; else goto _L3
_L3:
        s = s1;
        m.e("PatternPaletteInfoDao", "Failed to query: cursor is null");
        if (s1 != null)
        {
            s1.close();
        }
        return arraylist;
_L2:
        s1 = new String[1];
        s1[0] = s;
        s = s1;
          goto _L5
        Exception exception;
        exception;
        s1 = null;
_L11:
        s = s1;
        m.e("PatternPaletteInfoDao", (new StringBuilder()).append("Exception: ").append(exception.getMessage()).toString());
        if (s1 != null)
        {
            s1.close();
        }
        return arraylist;
_L4:
        s = s1;
        if (s1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_200;
        }
        s = s1;
        m.e("PatternPaletteInfoDao", "Failure of cursor.moveToFirst().");
        s = s1;
        s1.close();
        if (s1 != null)
        {
            s1.close();
        }
        return arraylist;
        s = s1;
        int i = s1.getColumnIndex("PatternGUID");
_L7:
        s = s1;
        arraylist.add(s1.getString(i));
        s = s1;
        boolean flag = s1.moveToNext();
        if (flag) goto _L7; else goto _L6
_L6:
        if (s1 != null)
        {
            s1.close();
        }
        return arraylist;
        s1;
        s = null;
_L9:
        if (s != null)
        {
            s.close();
        }
        throw s1;
        s1;
        if (true) goto _L9; else goto _L8
_L8:
        exception;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public Collection b(String s, String s1)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        String s2;
        String as[];
        if (s1 != null)
        {
            s2 = "PaletteGUID=? AND Source=? AND PatternId IS NULL";
        } else
        {
            s2 = "PaletteGUID=? AND PatternId IS NULL";
        }
        if (s1 == null) goto _L2; else goto _L1
_L1:
        as = new String[2];
        as[0] = s;
        as[1] = s1;
        s = as;
_L5:
        s1 = new SQLiteQueryBuilder();
        s1.setDistinct(true);
        s1.setTables("PatternPaletteInfo LEFT OUTER JOIN TattooMaskInfo ON PatternPaletteInfo.PatternGUID = TattooMaskInfo.PatternId");
        s1 = s1.query(a, new String[] {
            "PatternGUID"
        }, s2, s, "PatternGUID", null, "MIN(PatternPaletteInfo._id)", null);
        if (s1 != null) goto _L4; else goto _L3
_L3:
        s = s1;
        m.e("PatternPaletteInfoDao", "Failed to query: cursor is null");
        if (s1 != null)
        {
            s1.close();
        }
        return arraylist;
_L2:
        s1 = new String[1];
        s1[0] = s;
        s = s1;
          goto _L5
        Exception exception;
        exception;
        s1 = null;
_L11:
        s = s1;
        m.e("PatternPaletteInfoDao", (new StringBuilder()).append("Exception: ").append(exception.getMessage()).toString());
        if (s1 != null)
        {
            s1.close();
        }
        return arraylist;
_L4:
        s = s1;
        if (s1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_219;
        }
        s = s1;
        m.e("PatternPaletteInfoDao", "Failure of cursor.moveToFirst().");
        s = s1;
        s1.close();
        if (s1 != null)
        {
            s1.close();
        }
        return arraylist;
        s = s1;
        int i = s1.getColumnIndex("PatternGUID");
_L7:
        s = s1;
        arraylist.add(s1.getString(i));
        s = s1;
        boolean flag = s1.moveToNext();
        if (flag) goto _L7; else goto _L6
_L6:
        if (s1 != null)
        {
            s1.close();
        }
        return arraylist;
        s1;
        s = null;
_L9:
        if (s != null)
        {
            s.close();
        }
        throw s1;
        s1;
        if (true) goto _L9; else goto _L8
_L8:
        exception;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public Collection c(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        String as1[] = q.a();
        String s2;
        String as[];
        if (s1 != null)
        {
            s2 = "PatternGUID=? AND Source=?";
        } else
        {
            s2 = "PatternGUID=?";
        }
        if (s1 == null) goto _L2; else goto _L1
_L1:
        as = new String[2];
        as[0] = s;
        as[1] = s1;
        s = as;
_L5:
        s1 = a.query(true, "PatternPaletteInfo", as1, s2, s, "PaletteGUID", null, "MIN(_id)", null);
        if (s1 != null) goto _L4; else goto _L3
_L3:
        s = s1;
        m.e("PatternPaletteInfoDao", "Failed to query: cursor is null");
        if (s1 != null)
        {
            s1.close();
        }
        return arraylist;
_L2:
        s1 = new String[1];
        s1[0] = s;
        s = s1;
          goto _L5
        Exception exception;
        exception;
        s1 = null;
_L11:
        s = s1;
        m.e("PatternPaletteInfoDao", (new StringBuilder()).append("Exception: ").append(exception.getMessage()).toString());
        if (s1 != null)
        {
            s1.close();
        }
        return arraylist;
_L4:
        s = s1;
        if (s1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_200;
        }
        s = s1;
        m.e("PatternPaletteInfoDao", "Failure of cursor.moveToFirst().");
        s = s1;
        s1.close();
        if (s1 != null)
        {
            s1.close();
        }
        return arraylist;
        s = s1;
        int i = s1.getColumnIndex("PaletteGUID");
_L7:
        s = s1;
        arraylist.add(s1.getString(i));
        s = s1;
        boolean flag = s1.moveToNext();
        if (flag) goto _L7; else goto _L6
_L6:
        if (s1 != null)
        {
            s1.close();
        }
        return arraylist;
        s1;
        s = null;
_L9:
        if (s != null)
        {
            s.close();
        }
        throw s1;
        s1;
        if (true) goto _L9; else goto _L8
_L8:
        exception;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public String d(String s, String s1)
    {
        s = a.query("PatternPaletteInfo", new String[] {
            "ColorIntensities"
        }, "PatternGUID=? AND PaletteGUID=?", new String[] {
            s, s1
        }, null, null, null, null);
        if (s != null) goto _L2; else goto _L1
_L1:
        s1 = s;
        m.e("PatternPaletteInfoDao", "Failed to query: cursor is null");
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
            break MISSING_BLOCK_LABEL_106;
        }
        s1 = s;
        m.e("PatternPaletteInfoDao", "Failure of cursor.moveToFirst().");
        s1 = s;
        s.close();
        if (s != null)
        {
            s.close();
        }
        return null;
        s1 = s;
        String s2 = s.getString(s.getColumnIndex("ColorIntensities"));
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
        m.e("PatternPaletteInfoDao", (new StringBuilder()).append("Exception: ").append(exception.getMessage()).toString());
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

    public boolean e(String s, String s1)
    {
        int i = b.delete("PatternPaletteInfo", "PatternGUID = ? AND Source = ?", new String[] {
            s, s1
        });
        if (i < 1)
        {
            m.e("PatternPaletteInfoDao", (new StringBuilder()).append("[deleteByPatternGUID]  delete id: ").append(s).append(", rowsAffected != 1, rowsAffected: ").append(i).toString());
            return false;
        } else
        {
            return true;
        }
    }

    public boolean f(String s, String s1)
    {
        String s2;
        int i;
        if (s1 != null)
        {
            s2 = "PaletteGUID = ? AND Source = ?";
        } else
        {
            s2 = "PaletteGUID = ?";
        }
        if (s1 != null)
        {
            String as[] = new String[2];
            as[0] = s;
            as[1] = s1;
            s1 = as;
        } else
        {
            s1 = new String[1];
            s1[0] = s;
        }
        i = b.delete("PatternPaletteInfo", s2, s1);
        if (i < 1)
        {
            m.e("PatternPaletteInfoDao", (new StringBuilder()).append("[deleteByPaletteGUID]  delete id: ").append(s).append(", rowsAffected != 1, rowsAffected: ").append(i).toString());
            return false;
        } else
        {
            return true;
        }
    }
}
