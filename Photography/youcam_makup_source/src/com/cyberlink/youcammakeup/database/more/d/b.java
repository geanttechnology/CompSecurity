// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.more.e;
import com.cyberlink.youcammakeup.database.more.g.a;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.utility.av;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.d:
//            a

public class b
{

    private final SQLiteDatabase a = com.cyberlink.youcammakeup.h.a();
    private final SQLiteDatabase b = com.cyberlink.youcammakeup.h.b();

    public b()
    {
    }

    private String h(String s)
    {
        Object obj = null;
        s = (new StringBuilder()).append("SELECT PaletteInfo.GUID FROM PaletteInfo INNER JOIN ColorInfo ON PaletteInfo.ColorSetGUID = ColorInfo.Set_GUID WHERE ColorInfo.Color = '").append(s).append("'").toString();
        s = a.rawQuery(s, null);
        if (s == null) goto _L2; else goto _L1
_L1:
        String s1 = s;
        boolean flag = s.moveToFirst();
        if (flag) goto _L3; else goto _L2
_L2:
        s1 = obj;
        if (s != null)
        {
            s.close();
            s1 = obj;
        }
_L5:
        return s1;
_L3:
        s1 = s;
        String s2 = s.getString(s.getColumnIndex("PaletteInfo.GUID"));
        s1 = s2;
        if (s == null) goto _L5; else goto _L4
_L4:
        s.close();
        return s2;
        Exception exception;
        exception;
        s = null;
_L9:
        s1 = s;
        m.e("EffectInfoDao", (new StringBuilder()).append("getPaletteGUID(), Exception: ").append(exception.getMessage()).toString());
        s1 = obj;
        if (s == null) goto _L5; else goto _L6
_L6:
        s.close();
        return null;
        s;
        s1 = null;
_L8:
        if (s1 != null)
        {
            s1.close();
        }
        throw s;
        s;
        if (true) goto _L8; else goto _L7
_L7:
        exception;
          goto _L9
    }

    public com.cyberlink.youcammakeup.database.more.d.a a(com.cyberlink.youcammakeup.database.more.d.a a1)
    {
        com.cyberlink.youcammakeup.database.more.d.a a2 = a(a1.a());
        if (a2 == null) goto _L2; else goto _L1
_L1:
        a1 = a2;
_L4:
        return a1;
_L2:
        ContentValues contentvalues = a1.m();
        long l;
        try
        {
            m.a("EffectInfoDao", (new StringBuilder()).append("db.insert to EffectInfo: ").append(contentvalues.toString()).toString());
            l = b.insert("EffectInfo", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.youcammakeup.database.more.d.a a1)
        {
            m.e("EffectInfoDao", (new StringBuilder()).append("db.insert exception: ").append(a1.getMessage()).toString());
            return null;
        }
        if (l >= 0L) goto _L4; else goto _L3
_L3:
        m.e("EffectInfoDao", (new StringBuilder()).append("db.insert failed. id: ").append(l).toString());
        return null;
    }

    public com.cyberlink.youcammakeup.database.more.d.a a(String s)
    {
        String as[] = com.cyberlink.youcammakeup.database.more.e.a();
        String s1 = c.c;
        s = a.query("EffectInfo", as, "GUID=?", new String[] {
            s
        }, null, null, null, s1);
        if (s != null) goto _L2; else goto _L1
_L1:
        m.e("EffectInfoDao", "Failed to query: cursor is null");
        com.cyberlink.youcammakeup.database.more.d.a a1;
        if (s != null)
        {
            s.close();
        }
        a1 = null;
_L4:
        return a1;
_L2:
        if (s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        m.b("EffectInfoDao", "Failure of cursor.moveToFirst().");
        if (s != null)
        {
            s.close();
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
        int k2;
        i = s.getColumnIndex("GUID");
        j = s.getColumnIndex("PresetGUID");
        k = s.getColumnIndex("PatternGUID");
        l = s.getColumnIndex("EffectType");
        i1 = s.getColumnIndex("ColorCount");
        j1 = s.getColumnIndex("ColorSetGUID");
        k1 = s.getColumnIndex("Intensity");
        l1 = s.getColumnIndex("ListOrder");
        i2 = s.getColumnIndex("ExtraData");
        j2 = s.getColumnIndex("Ext_1");
        k2 = s.getColumnIndex("Ext_2");
        if (i >= 0 && j >= 0 && k >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0 && i2 >= 0 && j2 >= 0 && k2 >= 0)
        {
            break MISSING_BLOCK_LABEL_268;
        }
        m.e("EffectInfoDao", "cursor.getColumnIndex() returned negative number");
        if (s != null)
        {
            s.close();
        }
        return null;
        com.cyberlink.youcammakeup.database.more.d.a a2 = new com.cyberlink.youcammakeup.database.more.d.a(s.getString(i), s.getString(j), s.getString(k), s.getString(l), s.getString(i1), s.getString(j1), s.getString(k1), s.getString(l1), s.getString(i2), s.getString(j2), s.getString(k2));
        a1 = a2;
        if (s == null) goto _L4; else goto _L3
_L3:
        s.close();
        return a2;
        Object obj;
        obj;
        s = null;
_L8:
        m.e("EffectInfoDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
        if (s != null)
        {
            s.close();
        }
        return null;
        obj;
        s = null;
_L6:
        if (s != null)
        {
            s.close();
        }
        throw obj;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void a()
    {
        Cursor cursor;
        m.b("EffectInfoDao", "updateDataIfNoPaletteGuid");
        cursor = a.rawQuery("SELECT EffectInfo.GUID, EffectInfo.EffectType, EffectInfo.ExtraData, ColorInfo.Set_GUID, ColorInfo.Color FROM EffectInfo INNER JOIN ColorInfo ON EffectInfo.ColorSetGUID = ColorInfo.Set_GUID WHERE EffectInfo.ExtraData LIKE '%palette_guid\":\"\"%'", null);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (!cursor.moveToFirst()) goto _L2; else goto _L3
_L3:
        String s;
        Object obj1;
        String s1;
        Object obj2;
        String s2;
        int i = cursor.getColumnIndex("EffectInfo.GUID");
        int j = cursor.getColumnIndex("EffectInfo.EffectType");
        int k = cursor.getColumnIndex("EffectInfo.ExtraData");
        int l = cursor.getColumnIndex("ColorInfo.Color");
        int i1 = cursor.getColumnIndex("ColorInfo.Set_GUID");
        s = cursor.getString(i);
        obj1 = cursor.getString(j);
        obj2 = cursor.getString(k);
        s2 = cursor.getString(l);
        s1 = cursor.getString(i1);
        s2 = h(s2);
        obj2 = new JSONObject(((String) (obj2)));
        if (s2 == null) goto _L5; else goto _L4
_L4:
        ((JSONObject) (obj2)).put("palette_guid", s2);
_L6:
        boolean flag;
        b.execSQL((new StringBuilder()).append("UPDATE EffectInfo SET ExtraData = '").append(((JSONObject) (obj2)).toString()).append("' WHERE GUID = '").append(s).append("'").toString());
        flag = cursor.moveToNext();
        if (flag) goto _L3; else goto _L2
_L2:
        if (cursor != null)
        {
            cursor.close();
        }
_L8:
        return;
_L5:
        ((JSONObject) (obj2)).put("palette_guid", s1);
        obj1 = new a(s1, s1, 1, av.b(new av()).toString(), "", com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c.name(), 14F, 0, false, "", "", ((String) (obj1)), "", "", "", "");
        com.cyberlink.youcammakeup.h.j().a(((a) (obj1)));
          goto _L6
        Object obj;
        obj;
        m.e("EffectInfoDao", (new StringBuilder()).append("updateDataIfNoPaletteGuid(), Exception: ").append(((Exception) (obj)).getMessage()).toString());
        if (cursor == null) goto _L8; else goto _L7
_L7:
        cursor.close();
        return;
        obj;
        if (cursor != null)
        {
            cursor.close();
        }
        throw obj;
          goto _L6
    }

    public Collection b(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = a.query("EffectInfo", new String[] {
            "GUID"
        }, "PresetGUID=?", new String[] {
            s
        }, null, null, "ListOrder ASC", null);
        if (s == null)
        {
            m.e("EffectInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("EffectInfoDao", "Failure of cursor.moveToFirst().");
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

    public void b()
    {
        Cursor cursor;
        Cursor cursor1;
        cursor1 = null;
        cursor = null;
        m.b("EffectInfoDao", "updateDataFrom4_5To4_6()");
        Cursor cursor2 = a.rawQuery("SELECT EffectInfo.GUID, EffectInfo.ExtraData, ColorInfo.Ext_1 FROM EffectInfo INNER JOIN ColorInfo ON EffectInfo.ColorSetGUID = ColorInfo.Set_GUID WHERE ColorInfo.Ext_1 IS NOT NULL AND ColorInfo.Ext_1 != '' AND (ColorInfo.Source = 'DOWNLOAD' OR ColorInfo.Source = 'CUSTOM')", null);
        if (cursor2 == null) goto _L2; else goto _L1
_L1:
        cursor = cursor2;
        cursor1 = cursor2;
        if (!cursor2.moveToFirst()) goto _L2; else goto _L3
_L3:
        cursor = cursor2;
        cursor1 = cursor2;
        int i = cursor2.getColumnIndex("EffectInfo.GUID");
        cursor = cursor2;
        cursor1 = cursor2;
        int j = cursor2.getColumnIndex("EffectInfo.ExtraData");
        cursor = cursor2;
        cursor1 = cursor2;
        int k = cursor2.getColumnIndex("ColorInfo.Ext_1");
        cursor = cursor2;
        cursor1 = cursor2;
        String s = cursor2.getString(i);
        cursor = cursor2;
        cursor1 = cursor2;
        Object obj = cursor2.getString(j);
        cursor = cursor2;
        cursor1 = cursor2;
        String s1 = cursor2.getString(k);
        cursor = cursor2;
        cursor1 = cursor2;
        obj = new JSONObject(((String) (obj)));
        cursor = cursor2;
        cursor1 = cursor2;
        if (((JSONObject) (obj)).optString("palette_guid").equals(s1)) goto _L5; else goto _L4
_L4:
        cursor = cursor2;
        cursor1 = cursor2;
        if (com.cyberlink.youcammakeup.h.j().e(s1)) goto _L6; else goto _L5
_L5:
        cursor = cursor2;
        cursor1 = cursor2;
        boolean flag = cursor2.moveToNext();
        if (flag) goto _L3; else goto _L2
_L2:
        if (cursor2 != null)
        {
            cursor2.close();
        }
_L8:
        return;
_L6:
        cursor = cursor2;
        cursor1 = cursor2;
        ((JSONObject) (obj)).put("palette_guid", s1);
        cursor = cursor2;
        cursor1 = cursor2;
        b.execSQL((new StringBuilder()).append("UPDATE EffectInfo SET ExtraData = '").append(((JSONObject) (obj)).toString()).append("' WHERE GUID = '").append(s).append("'").toString());
          goto _L5
        Exception exception1;
        exception1;
        cursor1 = cursor;
        m.e("EffectInfoDao", (new StringBuilder()).append("updateDataFrom4_5To4_6(), Exception: ").append(exception1.getMessage()).toString());
        if (cursor == null) goto _L8; else goto _L7
_L7:
        cursor.close();
        return;
        Exception exception;
        exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw exception;
          goto _L5
    }

    public Collection c(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = a.query("EffectInfo", new String[] {
            "GUID"
        }, "PatternGUID=?", new String[] {
            s
        }, null, null, "ListOrder ASC", null);
        if (s == null)
        {
            m.e("EffectInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("EffectInfoDao", "Failure of cursor.moveToFirst().");
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

    public Collection d(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = a.query(true, "EffectInfo", new String[] {
            "PresetGUID"
        }, "PatternGUID=?", new String[] {
            s
        }, null, null, "ListOrder ASC", null);
        if (s == null)
        {
            m.e("EffectInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("EffectInfoDao", "Failure of cursor.moveToFirst().");
            s.close();
            return arraylist;
        }
        do
        {
            arraylist.add(s.getString(s.getColumnIndex("PresetGUID")));
        } while (s.moveToNext());
        s.close();
        return arraylist;
    }

    public Collection e(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = (new StringBuilder()).append('%').append(s).append('%').toString();
        s = a.query(true, "EffectInfo", new String[] {
            "PresetGUID"
        }, "ExtraData LIKE ?", new String[] {
            s
        }, null, null, null, null);
        if (s == null)
        {
            m.e("EffectInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("EffectInfoDao", "Failure of cursor.moveToFirst().");
            s.close();
            return arraylist;
        }
        do
        {
            arraylist.add(s.getString(s.getColumnIndex("PresetGUID")));
        } while (s.moveToNext());
        s.close();
        return arraylist;
    }

    public Collection f(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = a.query(true, "EffectInfo", new String[] {
            "PresetGUID", "PatternGUID"
        }, "EffectType=?", new String[] {
            s
        }, null, null, null, null);
        if (s == null)
        {
            m.e("EffectInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("EffectInfoDao", "Failure of cursor.moveToFirst().");
            s.close();
            return arraylist;
        }
        do
        {
            int i = s.getColumnIndex("PresetGUID");
            int j = s.getColumnIndex("PatternGUID");
            arraylist.add(new Pair(s.getString(i), s.getString(j)));
        } while (s.moveToNext());
        s.close();
        return arraylist;
    }

    public boolean g(String s)
    {
        com.cyberlink.youcammakeup.database.more.d.a a1 = a(s);
        if (a1 == null)
        {
            return false;
        }
        int i = b.delete("EffectInfo", "GUID = ?", new String[] {
            s
        });
        if (i != 1)
        {
            m.e("EffectInfoDao", (new StringBuilder()).append("[delete]  delete id: ").append(s).append(", rowsAffected != 1, rowsAffected: ").append(i).toString());
            return false;
        }
        if (com.cyberlink.youcammakeup.h.i().a(a1.f()).size() == 0)
        {
            return com.cyberlink.youcammakeup.h.i().b(a1.f());
        } else
        {
            return true;
        }
    }
}
