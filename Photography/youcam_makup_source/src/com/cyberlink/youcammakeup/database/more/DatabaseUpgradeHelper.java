// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.more.d.a;
import com.cyberlink.youcammakeup.database.more.d.e;
import com.pf.common.utility.m;
import java.util.UUID;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.more:
//            d, e, m, r

public class DatabaseUpgradeHelper
{

    private static int a(SQLiteDatabase sqlitedatabase, String s)
    {
        String as[];
        int i;
        i = 0;
        as = a();
        sqlitedatabase = sqlitedatabase.query("ColorInfo", as, "Set_GUID=?", new String[] {
            s
        }, null, null, null, null);
        if (sqlitedatabase == null) goto _L2; else goto _L1
_L1:
        s = sqlitedatabase;
        if (sqlitedatabase.moveToFirst()) goto _L3; else goto _L2
_L2:
        s = sqlitedatabase;
        m.e("database.more.DatabaseUpgradeHelper", "getColorCount: cursorColorCount is null or empty ");
        int j;
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        j = 0;
_L6:
        return j;
_L3:
        i++;
        s = sqlitedatabase;
        boolean flag = sqlitedatabase.moveToNext();
        if (flag) goto _L3; else goto _L4
_L4:
        j = i;
        if (sqlitedatabase == null) goto _L6; else goto _L5
_L5:
        sqlitedatabase.close();
        return i;
        Exception exception;
        exception;
        sqlitedatabase = null;
        i = 0;
_L10:
        s = sqlitedatabase;
        m.e("database.more.DatabaseUpgradeHelper", (new StringBuilder()).append("Exception: ").append(exception.getMessage()).toString());
        j = i;
        if (sqlitedatabase == null) goto _L6; else goto _L7
_L7:
        sqlitedatabase.close();
        return i;
        sqlitedatabase;
        s = null;
_L9:
        if (s != null)
        {
            s.close();
        }
        throw sqlitedatabase;
        sqlitedatabase;
        if (true) goto _L9; else goto _L8
_L8:
        exception;
        i = 0;
          goto _L10
        exception;
          goto _L10
    }

    private static void a(SQLiteDatabase sqlitedatabase, String s, String s1)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        String as[] = com.cyberlink.youcammakeup.database.more.e.a();
        String s2 = c.c;
        obj = sqlitedatabase.query("EffectInfo", as, "ColorSetGUID=?", new String[] {
            s
        }, null, null, null, s2);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        m.e("database.more.DatabaseUpgradeHelper", "Failed to query: cursor is null");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        m.b("database.more.DatabaseUpgradeHelper", "Failure of cursor.moveToFirst().");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            return;
        }
        continue; /* Loop/switch isn't completed */
        int i = ((Cursor) (obj)).getColumnIndex("GUID");
        int j = ((Cursor) (obj)).getColumnIndex("PresetGUID");
        int k = ((Cursor) (obj)).getColumnIndex("PatternGUID");
        int l = ((Cursor) (obj)).getColumnIndex("EffectType");
        int i1 = ((Cursor) (obj)).getColumnIndex("ColorCount");
        int j1 = ((Cursor) (obj)).getColumnIndex("Intensity");
        int k1 = ((Cursor) (obj)).getColumnIndex("ListOrder");
        int l1 = ((Cursor) (obj)).getColumnIndex("ExtraData");
        int i2 = ((Cursor) (obj)).getColumnIndex("Ext_1");
        int j2 = ((Cursor) (obj)).getColumnIndex("Ext_2");
        String s3 = ((Cursor) (obj)).getString(i);
        s = new a(s3, ((Cursor) (obj)).getString(j), ((Cursor) (obj)).getString(k), ((Cursor) (obj)).getString(l), ((Cursor) (obj)).getString(i1), s, ((Cursor) (obj)).getString(j1), ((Cursor) (obj)).getString(k1), ((Cursor) (obj)).getString(l1), ((Cursor) (obj)).getString(i2), ((Cursor) (obj)).getString(j2));
        JSONObject jsonobject = new JSONObject(s.l());
        jsonobject.put("palette_guid", s1);
        sqlitedatabase.update("EffectInfo", (new a(s.a(), s.b(), s.c(), s.d(), s.e(), s.f(), s.g(), s.k(), jsonobject.toString(), "", "")).m(), "GUID = ?", new String[] {
            s3
        });
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        s;
        sqlitedatabase = null;
_L7:
        m.e("database.more.DatabaseUpgradeHelper", (new StringBuilder()).append("Exception: ").append(s.getMessage()).toString());
        if (sqlitedatabase == null) goto _L1; else goto _L4
_L4:
        sqlitedatabase.close();
        return;
        sqlitedatabase;
        obj = null;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
        sqlitedatabase;
        continue; /* Loop/switch isn't completed */
        s;
        obj = sqlitedatabase;
        sqlitedatabase = s;
        if (true) goto _L6; else goto _L5
_L5:
        s;
        sqlitedatabase = ((SQLiteDatabase) (obj));
          goto _L7
    }

    public static boolean a(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor;
        int i;
        int j;
        int k;
        int i1;
        int j1;
        int k1;
        cursor = sqlitedatabase.query("PaletteInfo", new String[] {
            "GUID", "ColorSetGUID", "ColorCount", "PaletteOrder", "Source", "ExtraData", "Ext_1", "Ext_2"
        }, null, null, null, null, null, null);
        if (cursor == null)
        {
            m.e("database.more.DatabaseUpgradeHelper", "Failed to query: cursor is null");
            return false;
        }
        if (!cursor.moveToFirst())
        {
            m.b("database.more.DatabaseUpgradeHelper", "Failure of cursor.moveToFirst().");
            return false;
        }
        i = cursor.getColumnIndex("GUID");
        j = cursor.getColumnIndex("ColorSetGUID");
        k = cursor.getColumnIndex("ColorCount");
        int l = cursor.getColumnIndex("PaletteOrder");
        i1 = cursor.getColumnIndex("Source");
        j1 = cursor.getColumnIndex("ExtraData");
        k1 = cursor.getColumnIndex("Ext_1");
        int l1 = cursor.getColumnIndex("Ext_2");
        if (i < 0 || j < 0 || k < 0 || l < 0 || i1 < 0 || j1 < 0 || k1 < 0 || l1 < 0)
        {
            m.e("database.more.DatabaseUpgradeHelper", "cursor.getColumnIndex() returned negative number");
            return false;
        }
        sqlitedatabase.execSQL((new StringBuilder()).append("CREATE TABLE ").append("PaletteInfoTemp").append(" (").append("_id INTEGER PRIMARY KEY AUTOINCREMENT,GUID TEXT,ColorSetGUID TEXT,ColorCount TEXT,Name TEXT,Thumbnail TEXT,Source TEXT,Version REAL,PaletteOrder TEXT,isNew INTEGER,SkuGUID TEXT,ExtraData TEXT,Ext1 TEXT,Ext2 TEXT,Ext3 TEXT,Ext4 TEXT,Ext5 TEXT").append(");").toString());
        boolean flag;
        do
        {
            JSONObject jsonobject = new JSONObject(cursor.getString(j1));
            sqlitedatabase.insert("PaletteInfoTemp", null, (new com.cyberlink.youcammakeup.database.more.g.a(cursor.getString(i), cursor.getString(j), Integer.parseInt(cursor.getString(k)), jsonobject.optString("name"), "", cursor.getString(i1), Float.valueOf(jsonobject.optString("version")).floatValue(), 0, Boolean.valueOf(cursor.getString(k1)).booleanValue(), "", "", "", "", "", "", "")).l());
            flag = cursor.moveToNext();
        } while (flag);
_L2:
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS PaletteInfo");
        sqlitedatabase.execSQL((new StringBuilder()).append("ALTER TABLE ").append("PaletteInfoTemp").append(" RENAME TO ").append("PaletteInfo").toString());
        return true;
        Exception exception;
        exception;
        m.e("database.more.DatabaseUpgradeHelper", (new StringBuilder()).append("upgradeFrom1_4To1_5(), e: ").append(exception.toString()).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static boolean a(SQLiteDatabase sqlitedatabase, UpgradeType upgradetype)
    {
        Cursor cursor;
        int i;
        int j;
        int k;
        int l;
        cursor = sqlitedatabase.query("ColorInfo", a(), null, null, null, null, null, null);
        if (cursor == null)
        {
            m.e("database.more.DatabaseUpgradeHelper", "Failed to query: cursor is null. Cannot convert color to palette!");
            return false;
        }
        if (!cursor.moveToFirst())
        {
            m.b("database.more.DatabaseUpgradeHelper", "Failure of cursor.moveToFirst(). Cannot convert color to palette!");
            return false;
        }
        i = cursor.getColumnIndex("Set_GUID");
        j = cursor.getColumnIndex("PatternType");
        k = cursor.getColumnIndex("Source");
        l = cursor.getColumnIndex("Ext_1");
        if (i < 0 || j < 0 || k < 0)
        {
            m.e("database.more.DatabaseUpgradeHelper", "cursor.getColumnIndex() returned negative number");
            return false;
        }
_L8:
        String s;
        int i1;
        s = cursor.getString(i);
        i1 = a(sqlitedatabase, s);
        m.b("database.more.DatabaseUpgradeHelper", (new StringBuilder()).append("convertColorToPalette: colorCount: ").append(i1).toString());
        boolean flag = false;
        if (c(sqlitedatabase, s) != null)
        {
            flag = true;
        }
        m.b("database.more.DatabaseUpgradeHelper", (new StringBuilder()).append("convertColorToPalette: Color has palette already? ").append(flag).toString());
        if (flag || i1 <= 0) goto _L2; else goto _L1
_L1:
        String s1;
        String s2;
        String s3;
        s1 = cursor.getString(j);
        s2 = cursor.getString(k);
        s3 = cursor.getString(l);
        if (s3 == null) goto _L4; else goto _L3
_L3:
        if (s3.equals("") || !b(sqlitedatabase, s3)) goto _L4; else goto _L5
_L5:
        a(sqlitedatabase, s, s3);
_L2:
        if (!cursor.moveToNext())
        {
            break MISSING_BLOCK_LABEL_382;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (upgradetype == com.cyberlink.youcammakeup.database.more.UpgradeType.a && !s1.equals("eye_shadow") || upgradetype == UpgradeType.b && s1.equals("wig"))
        {
            sqlitedatabase.insert("PaletteInfo", null, (new com.cyberlink.youcammakeup.database.more.g.a(s, s, i1, "", "", s2, 0.0F, 0, false, "", "", s1, "", "", "", "")).l());
            a(sqlitedatabase, s, s);
        }
        if (true) goto _L2; else goto _L6
_L6:
        if (true) goto _L8; else goto _L7
_L7:
        sqlitedatabase;
        m.b("database.more.DatabaseUpgradeHelper", "convertColorToPalette failed!", sqlitedatabase);
        return true;
    }

    public static boolean b(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        cursor = sqlitedatabase.query("PatternInfo", new String[] {
            "GUID", "PatternType", "ThumbPath", "Source", "ColorImagePath", "ToolImagePath", "ExtraData", "Ext_1", "Ext_2"
        }, null, null, null, null, null, null);
        if (cursor == null)
        {
            m.e("database.more.DatabaseUpgradeHelper", "Failed to query: cursor is null");
            return false;
        }
        if (!cursor.moveToFirst())
        {
            m.b("database.more.DatabaseUpgradeHelper", "Failure of cursor.moveToFirst().");
            return false;
        }
        i = cursor.getColumnIndex("GUID");
        j = cursor.getColumnIndex("PatternType");
        k = cursor.getColumnIndex("ThumbPath");
        l = cursor.getColumnIndex("Source");
        i1 = cursor.getColumnIndex("ColorImagePath");
        j1 = cursor.getColumnIndex("ToolImagePath");
        k1 = cursor.getColumnIndex("ExtraData");
        l1 = cursor.getColumnIndex("Ext_1");
        i2 = cursor.getColumnIndex("Ext_2");
        if (i < 0 || j < 0 || k < 0 || l < 0 || i1 < 0 || j1 < 0 || k1 < 0 || l1 < 0 || i2 < 0)
        {
            m.e("database.more.DatabaseUpgradeHelper", "cursor.getColumnIndex() returned negative number");
            return false;
        }
        sqlitedatabase.execSQL((new StringBuilder()).append("CREATE TABLE ").append("PatternInfoTemp").append(" (").append("_id INTEGER PRIMARY KEY AUTOINCREMENT,GUID TEXT,PatternType TEXT,Name TEXT,ThumbPath TEXT,Source TEXT,SupportMode TEXT,Version REAL,ColorImagePath TEXT,ToolImagePath TEXT,IsNew INTEGER,SkuGUID TEXT,ExtraData TEXT,ExtStr1 TEXT,ExtStr2 TEXT,ExtStr3 TEXT,ExtInt1 INTEGER,ExtInt2 INTEGER,ExtInt3 INTEGER").append(");").toString());
        boolean flag;
        do
        {
            JSONObject jsonobject = new JSONObject(cursor.getString(k1));
            Float float1 = Float.valueOf(jsonobject.optString("version"));
            jsonobject.remove("version");
            sqlitedatabase.insert("PatternInfoTemp", null, (new com.cyberlink.youcammakeup.database.more.h.c(cursor.getString(i), cursor.getString(j), "", cursor.getString(k), cursor.getString(l), com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.c.name(), float1.floatValue(), cursor.getString(i1), cursor.getString(j1), Boolean.valueOf(cursor.getString(l1)).booleanValue(), cursor.getString(i2), jsonobject.toString(), "", "", "", 0, 0, 0)).l());
            flag = cursor.moveToNext();
        } while (flag);
_L2:
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS PatternInfo");
        sqlitedatabase.execSQL((new StringBuilder()).append("ALTER TABLE ").append("PatternInfoTemp").append(" RENAME TO ").append("PatternInfo").toString());
        return true;
        Exception exception;
        exception;
        m.e("database.more.DatabaseUpgradeHelper", (new StringBuilder()).append("upgradeFrom1_6To1_7(), e: ").append(exception.toString()).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static boolean b(SQLiteDatabase sqlitedatabase, String s)
    {
        s = sqlitedatabase.query("PaletteInfo", new String[] {
            "GUID"
        }, "GUID=?", new String[] {
            s
        }, null, null, null, null);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        sqlitedatabase = s;
        boolean flag = s.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        if (s != null)
        {
            s.close();
        }
        return false;
        if (s != null)
        {
            s.close();
        }
        return true;
        Exception exception;
        exception;
        s = null;
_L4:
        sqlitedatabase = s;
        m.e("database.more.DatabaseUpgradeHelper", (new StringBuilder()).append("Exception: ").append(exception.getMessage()).toString());
        if (s != null)
        {
            s.close();
        }
        return false;
        s;
        sqlitedatabase = null;
_L2:
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static com.cyberlink.youcammakeup.database.more.g.a c(SQLiteDatabase sqlitedatabase, String s)
    {
        Object obj;
        String as[] = com.cyberlink.youcammakeup.database.more.m.a();
        String s1 = c.c;
        obj = sqlitedatabase.query("PaletteInfo", as, "ColorSetGUID=?", new String[] {
            s
        }, null, null, null, s1);
        if (obj != null) goto _L2; else goto _L1
_L1:
        m.e("database.more.DatabaseUpgradeHelper", "Failed to query: cursor is null");
        s = null;
        sqlitedatabase = s;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            sqlitedatabase = s;
        }
_L4:
        return sqlitedatabase;
_L2:
        if (((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_93;
        }
        m.b("database.more.DatabaseUpgradeHelper", "Failure of cursor.moveToFirst().");
        sqlitedatabase = null;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
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
        i2 = ((Cursor) (obj)).getColumnIndex("ColorSetGUID");
        k3 = ((Cursor) (obj)).getColumnIndex("ColorCount");
        j2 = ((Cursor) (obj)).getColumnIndex("Name");
        k2 = ((Cursor) (obj)).getColumnIndex("Thumbnail");
        l2 = ((Cursor) (obj)).getColumnIndex("Source");
        i3 = ((Cursor) (obj)).getColumnIndex("Version");
        j3 = ((Cursor) (obj)).getColumnIndex("PaletteOrder");
        i = ((Cursor) (obj)).getColumnIndex("isNew");
        j = ((Cursor) (obj)).getColumnIndex("SkuGUID");
        k = ((Cursor) (obj)).getColumnIndex("ExtraData");
        l = ((Cursor) (obj)).getColumnIndex("Ext1");
        i1 = ((Cursor) (obj)).getColumnIndex("Ext2");
        j1 = ((Cursor) (obj)).getColumnIndex("Ext3");
        k1 = ((Cursor) (obj)).getColumnIndex("Ext4");
        l1 = ((Cursor) (obj)).getColumnIndex("Ext5");
        if (i2 >= 0 && j2 >= 0 && k2 >= 0 && l2 >= 0 && i3 >= 0 && j3 >= 0 && i >= 0 && j >= 0 && k >= 0 && l >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        m.e("database.more.DatabaseUpgradeHelper", "cursor.getColumnIndex() returned negative number");
        sqlitedatabase = null;
        if (obj == null) goto _L4; else goto _L5
_L5:
        ((Cursor) (obj)).close();
        return null;
        float f1;
        String s2;
        String s3;
        String s4;
        k3 = ((Cursor) (obj)).getInt(k3);
        sqlitedatabase = ((Cursor) (obj)).getString(i2);
        s2 = ((Cursor) (obj)).getString(j2);
        s3 = ((Cursor) (obj)).getString(k2);
        s4 = ((Cursor) (obj)).getString(l2);
        f1 = ((Cursor) (obj)).getFloat(i3);
        i2 = ((Cursor) (obj)).getInt(j3);
        String s5;
        String s6;
        String s7;
        String s8;
        String s9;
        String s10;
        String s11;
        boolean flag;
        if (((Cursor) (obj)).getInt(i) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s5 = ((Cursor) (obj)).getString(j);
        s6 = ((Cursor) (obj)).getString(k);
        s7 = ((Cursor) (obj)).getString(l);
        s8 = ((Cursor) (obj)).getString(i1);
        s9 = ((Cursor) (obj)).getString(j1);
        s10 = ((Cursor) (obj)).getString(k1);
        s11 = ((Cursor) (obj)).getString(l1);
        s = new com.cyberlink.youcammakeup.database.more.g.a(s, sqlitedatabase, Integer.valueOf(k3).intValue(), s2, s3, s4, Float.valueOf(f1).floatValue(), Integer.valueOf(i2).intValue(), Boolean.valueOf(flag).booleanValue(), s5, s6, s7, s8, s9, s10, s11);
        sqlitedatabase = s;
        if (obj == null) goto _L4; else goto _L6
_L6:
        ((Cursor) (obj)).close();
        return s;
        sqlitedatabase;
        s = null;
_L10:
        m.e("database.more.DatabaseUpgradeHelper", (new StringBuilder()).append("Exception: ").append(sqlitedatabase.getMessage()).toString());
        sqlitedatabase = null;
        if (s == null) goto _L4; else goto _L7
_L7:
        s.close();
        return null;
        sqlitedatabase;
        obj = null;
_L9:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
        sqlitedatabase;
        continue; /* Loop/switch isn't completed */
        sqlitedatabase;
        obj = s;
        if (true) goto _L9; else goto _L8
_L8:
        sqlitedatabase;
        s = ((String) (obj));
          goto _L10
    }

    public static boolean c(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        cursor = sqlitedatabase.query("LookInfo", new String[] {
            "GUID", "Version", "Name", "ThumbPath", "Source", "ExtraData", "Ext_1", "Ext_2"
        }, null, null, null, null, null, null);
        if (cursor == null)
        {
            m.e("upgradeLookTableFrom1_6To1_7", "Failed to query: cursor is null");
            return false;
        }
        if (!cursor.moveToFirst())
        {
            m.b("upgradeLookTableFrom1_6To1_7", "Failure of cursor.moveToFirst().");
            return false;
        }
        i = cursor.getColumnIndex("GUID");
        j = cursor.getColumnIndex("Version");
        k = cursor.getColumnIndex("Name");
        l = cursor.getColumnIndex("ThumbPath");
        i1 = cursor.getColumnIndex("Source");
        j1 = cursor.getColumnIndex("ExtraData");
        k1 = cursor.getColumnIndex("Ext_1");
        l1 = cursor.getColumnIndex("Ext_2");
        if (i < 0 || j < 0 || k < 0 || l < 0 || i1 < 0 || j1 < 0 || k1 < 0 || l1 < 0)
        {
            m.e("upgradeLookTableFrom1_6To1_7", "cursor.getColumnIndex() returned negative number");
            return false;
        }
        sqlitedatabase.execSQL((new StringBuilder()).append("CREATE TABLE ").append("LookInfoTemp").append(" (").append("_id INTEGER PRIMARY KEY AUTOINCREMENT,GUID TEXT,Version REAL,Name TEXT,Description TEXT,ThumbImage TEXT,PreviewImage TEXT,Source TEXT,SupportMode TEXT,IsNew INTEGER,ExtraData TEXT,ExtStr1 TEXT,ExtStr2 TEXT,ExtStr3 TEXT,ExtInt1 INTEGER,ExtInt2 INTEGER,ExtInt3 INTEGER").append(");").toString());
_L4:
        if (cursor.getString(j1).equals("")) goto _L2; else goto _L1
_L1:
        String s = cursor.getString(j1);
_L5:
        boolean flag;
        s = (new JSONObject(s)).optString("preview_image");
        sqlitedatabase.insert("LookInfoTemp", null, (new e(cursor.getString(i), Float.valueOf(cursor.getString(j)).floatValue(), cursor.getString(k), cursor.getString(l1), cursor.getString(l), s, cursor.getString(i1), com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.c.name(), Boolean.valueOf(cursor.getString(k1)).booleanValue(), "", "", "", "", 0, 0, 0)).k());
        flag = cursor.moveToNext();
        if (flag) goto _L4; else goto _L3
_L3:
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS LookInfo");
        sqlitedatabase.execSQL((new StringBuilder()).append("ALTER TABLE ").append("LookInfoTemp").append(" RENAME TO ").append("LookInfo").toString());
        return true;
_L2:
        s = "{}";
          goto _L5
        Exception exception;
        exception;
        m.e("upgradeLookTableFrom1_6To1_7", (new StringBuilder()).append("upgradeLookTableFrom1_6To1_7(), e: ").append(exception.toString()).toString());
          goto _L3
    }

    public static boolean d(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor;
        int i;
        int j;
        int k;
        int l;
        int j1;
        int k1;
        int l1;
        int i2;
        f(sqlitedatabase);
        cursor = sqlitedatabase.query("SkuColorInfo", com.cyberlink.youcammakeup.database.more.r.a(), null, null, null, null, null, null);
        if (cursor == null)
        {
            m.e("database.more.DatabaseUpgradeHelper", "Failed to query: cursor is null. Cannot upgrade palette table!");
            return false;
        }
        if (!cursor.moveToFirst())
        {
            m.b("database.more.DatabaseUpgradeHelper", "Failure of cursor.moveToFirst(). Cannot upgrade palette table!");
            return false;
        }
        i = cursor.getColumnIndex("SkuGUID");
        j = cursor.getColumnIndex("ItemGUID");
        k = cursor.getColumnIndex("PatternGUID");
        l = cursor.getColumnIndex("ColorNumber");
        int i1 = cursor.getColumnIndex("ColorName");
        j1 = cursor.getColumnIndex("ColorType");
        k1 = cursor.getColumnIndex("Color");
        l1 = cursor.getColumnIndex("Intensity");
        i2 = cursor.getColumnIndex("ExtraData");
        int j2 = cursor.getColumnIndex("Ext_1");
        int k2 = cursor.getColumnIndex("Ext_2");
        if (i < 0 || j < 0 || k < 0 || l < 0 || i1 < 0 || j1 < 0 || k1 < 0 || l1 < 0 || i2 < 0 || j2 < 0 || k2 < 0)
        {
            m.e("database.more.DatabaseUpgradeHelper", "cursor.getColumnIndex() returned negative number");
            return false;
        }
_L2:
        String s;
        String s1;
        String s2;
        Object obj;
        Object obj1;
        obj = UUID.randomUUID().toString();
        String s3 = cursor.getString(j1);
        s = cursor.getString(j);
        obj1 = cursor.getString(i);
        s1 = cursor.getString(k);
        s2 = Integer.valueOf(cursor.getInt(l1)).toString();
        obj1 = new com.cyberlink.youcammakeup.database.more.g.a(s, ((String) (obj)), 1, "", "", com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.d.name(), 0.0F, 0, false, ((String) (obj1)), "", s3, cursor.getString(l), "", "", "");
        obj = new com.cyberlink.youcammakeup.database.more.b.a(((String) (obj)), s3, cursor.getString(k1), s2, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.d.name(), cursor.getString(i2), s, "");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_443;
        }
        if (s1.equals("") || s == null)
        {
            break MISSING_BLOCK_LABEL_443;
        }
        if (!s.equals(""))
        {
            sqlitedatabase.insert("PatternPaletteInfo", null, (new com.cyberlink.youcammakeup.database.more.h.e(s1, s, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.d.name(), null, null, 1, s2)).a());
        }
        boolean flag;
        sqlitedatabase.insert("PaletteInfo", null, ((com.cyberlink.youcammakeup.database.more.g.a) (obj1)).l());
        sqlitedatabase.insert("ColorInfo", null, ((com.cyberlink.youcammakeup.database.more.b.a) (obj)).f());
        flag = cursor.moveToNext();
        if (flag) goto _L2; else goto _L1
_L1:
        if (cursor != null)
        {
            cursor.close();
        }
_L4:
        return true;
        sqlitedatabase;
        m.b("database.more.DatabaseUpgradeHelper", "upgradePaletteTableFrom1_7To1_8() failed!", sqlitedatabase);
        if (cursor != null)
        {
            cursor.close();
        }
        if (true) goto _L4; else goto _L3
_L3:
        sqlitedatabase;
        if (cursor != null)
        {
            cursor.close();
        }
        throw sqlitedatabase;
    }

    public static boolean e(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        cursor = sqlitedatabase.query("PatternPaletteInfo", new String[] {
            "PatternGUID", "PaletteGUID", "Source", "Purpose", "ColorCount", "ColorIntensities"
        }, null, null, null, null, null, null);
        if (cursor == null)
        {
            m.e("database.more.DatabaseUpgradeHelper", "Failed to query: cursor is null. Cannot upgrade palette table!");
            return false;
        }
        if (!cursor.moveToFirst())
        {
            m.b("database.more.DatabaseUpgradeHelper", "Failure of cursor.moveToFirst(). Cannot upgrade palette table!");
            return false;
        }
        i = cursor.getColumnIndex("PatternGUID");
        j = cursor.getColumnIndex("PaletteGUID");
        k = cursor.getColumnIndex("Source");
        l = cursor.getColumnIndex("Purpose");
        i1 = cursor.getColumnIndex("ColorCount");
        j1 = cursor.getColumnIndex("ColorIntensities");
        sqlitedatabase.execSQL((new StringBuilder()).append("CREATE TABLE ").append("PatternPaletteInfoTemp").append(" (").append("_id INTEGER PRIMARY KEY AUTOINCREMENT,PatternGUID TEXT,PaletteGUID TEXT,Source TEXT,Purpose TEXT,Type TEXT,ColorCount Integer,ColorIntensities TEXT,DateTime DATETIME DEFAULT CURRENT_TIMESTAMP").append(");").toString());
        boolean flag;
        do
        {
            sqlitedatabase.insert("PatternPaletteInfoTemp", null, (new com.cyberlink.youcammakeup.database.more.h.e(cursor.getString(i), cursor.getString(j), cursor.getString(k), cursor.getString(l), null, Integer.parseInt(cursor.getString(i1)), cursor.getString(j1))).a());
            flag = cursor.moveToNext();
        } while (flag);
        if (cursor != null)
        {
            cursor.close();
        }
_L2:
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS PatternPaletteInfo");
        sqlitedatabase.execSQL((new StringBuilder()).append("ALTER TABLE ").append("PatternPaletteInfoTemp").append(" RENAME TO ").append("PatternPaletteInfo").toString());
        return true;
        Exception exception;
        exception;
        m.b("database.more.DatabaseUpgradeHelper", "upgradePatternPaletteTableFrom1_7To1_8() failed!", exception);
        if (cursor != null)
        {
            cursor.close();
        }
        if (true) goto _L2; else goto _L1
_L1:
        sqlitedatabase;
        if (cursor != null)
        {
            cursor.close();
        }
        throw sqlitedatabase;
    }

    private static void f(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor = sqlitedatabase.query("PaletteInfo", com.cyberlink.youcammakeup.database.more.m.a(), null, null, null, null, null, null);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        m.e("database.more.DatabaseUpgradeHelper", "updatePaletteType Failed to query: cursor is null");
        if (cursor != null)
        {
            cursor.close();
        }
_L6:
        return;
_L2:
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_69;
        }
        m.b("database.more.DatabaseUpgradeHelper", "updatePaletteType Failure of cursor.moveToFirst().");
        if (cursor != null)
        {
            cursor.close();
            return;
        }
        continue; /* Loop/switch isn't completed */
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
        i = cursor.getColumnIndex("GUID");
        j = cursor.getColumnIndex("ColorSetGUID");
        k = cursor.getColumnIndex("ColorCount");
        l = cursor.getColumnIndex("Name");
        i1 = cursor.getColumnIndex("Thumbnail");
        j1 = cursor.getColumnIndex("Source");
        k1 = cursor.getColumnIndex("Version");
        l1 = cursor.getColumnIndex("PaletteOrder");
        i2 = cursor.getColumnIndex("isNew");
        j2 = cursor.getColumnIndex("SkuGUID");
        k2 = cursor.getColumnIndex("ExtraData");
        l2 = cursor.getColumnIndex("Ext2");
        i3 = cursor.getColumnIndex("Ext3");
        j3 = cursor.getColumnIndex("Ext4");
        k3 = cursor.getColumnIndex("Ext5");
_L4:
        float f1;
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        int l3;
        int i4;
        s = cursor.getString(i);
        l3 = cursor.getInt(k);
        s1 = cursor.getString(j);
        s2 = cursor.getString(l);
        s3 = cursor.getString(i1);
        s4 = cursor.getString(j1);
        f1 = cursor.getFloat(k1);
        i4 = cursor.getInt(l1);
        String s5;
        String s6;
        String s7;
        String s8;
        String s9;
        String s10;
        boolean flag;
        if (cursor.getInt(i2) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s5 = cursor.getString(j2);
        s6 = cursor.getString(k2);
        s7 = cursor.getString(l2);
        s8 = cursor.getString(i3);
        s9 = cursor.getString(j3);
        s10 = cursor.getString(k3);
        sqlitedatabase.update("PaletteInfo", (new com.cyberlink.youcammakeup.database.more.g.a(s, s1, Integer.valueOf(l3).intValue(), s2, s3, s4, Float.valueOf(f1).floatValue(), Integer.valueOf(i4).intValue(), Boolean.valueOf(flag).booleanValue(), s5, s6, "eye_shadow", s7, s8, s9, s10)).l(), "GUID = ?", new String[] {
            s
        });
        flag = cursor.moveToNext();
        if (flag) goto _L4; else goto _L3
_L3:
        if (cursor != null)
        {
            cursor.close();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
        sqlitedatabase;
        m.e("database.more.DatabaseUpgradeHelper", (new StringBuilder()).append("updatePaletteType Exception: ").append(sqlitedatabase.getMessage()).toString());
        if (cursor == null) goto _L6; else goto _L7
_L7:
        cursor.close();
        return;
        sqlitedatabase;
        if (cursor != null)
        {
            cursor.close();
        }
        throw sqlitedatabase;
    }

    private class UpgradeType extends Enum
    {

        public static final UpgradeType a;
        public static final UpgradeType b;
        private static final UpgradeType c[];

        public static UpgradeType valueOf(String s)
        {
            return (UpgradeType)Enum.valueOf(com/cyberlink/youcammakeup/database/more/DatabaseUpgradeHelper$UpgradeType, s);
        }

        public static UpgradeType[] values()
        {
            return (UpgradeType[])c.clone();
        }

        static 
        {
            a = new UpgradeType("CreateTable", 0);
            b = new UpgradeType("WigOnly", 1);
            c = (new UpgradeType[] {
                a, b
            });
        }

        private UpgradeType(String s, int i)
        {
            super(s, i);
        }
    }

}
