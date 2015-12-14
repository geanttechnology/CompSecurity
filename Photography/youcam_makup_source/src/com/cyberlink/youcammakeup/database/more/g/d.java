// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.g;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.more.n;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.g:
//            c

public class d
{

    private final SQLiteDatabase a = h.a();
    private final SQLiteDatabase b = h.b();

    public d()
    {
    }

    public com.cyberlink.youcammakeup.database.more.g.c a(com.cyberlink.youcammakeup.database.more.g.c c1)
    {
        com.cyberlink.youcammakeup.database.more.g.c c2 = a(c1.a());
        if (c2 == null) goto _L2; else goto _L1
_L1:
        c1 = c2;
_L4:
        return c1;
_L2:
        ContentValues contentvalues = c1.e();
        long l;
        try
        {
            m.a("PaletteStyleInfoDao", (new StringBuilder()).append("db.insert to PaletteStyleInfo: ").append(contentvalues.toString()).toString());
            l = b.insert("PaletteStyleInfo", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.youcammakeup.database.more.g.c c1)
        {
            m.e("PaletteStyleInfoDao", (new StringBuilder()).append("db.insert exception: ").append(c1.getMessage()).toString());
            return null;
        }
        if (l >= 0L) goto _L4; else goto _L3
_L3:
        m.e("PaletteStyleInfoDao", (new StringBuilder()).append("db.insert failed. id: ").append(l).toString());
        return null;
    }

    public com.cyberlink.youcammakeup.database.more.g.c a(String s)
    {
        Object obj;
        String as[] = n.a();
        String s1 = c.c;
        obj = a.query("PaletteStyleInfo", as, "palette_guid=?", new String[] {
            s
        }, null, null, null, s1);
        if (obj != null) goto _L2; else goto _L1
_L1:
        m.e("PaletteStyleInfoDao", "Failed to query: cursor is null");
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
            break MISSING_BLOCK_LABEL_88;
        }
        m.b("PaletteStyleInfoDao", "Failure of cursor.moveToFirst().");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        int i;
        int j;
        int k;
        int l;
        i = ((Cursor) (obj)).getColumnIndex("style_guid");
        j = ((Cursor) (obj)).getColumnIndex("inner_ratio");
        k = ((Cursor) (obj)).getColumnIndex("feather_strength");
        l = ((Cursor) (obj)).getColumnIndex("intensity");
        if (i >= 0 && j >= 0 && k >= 0 && l >= 0)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        m.e("PaletteStyleInfoDao", "cursor.getColumnIndex() returned negative number");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        com.cyberlink.youcammakeup.database.more.g.c c1 = new com.cyberlink.youcammakeup.database.more.g.c(s, ((Cursor) (obj)).getString(i), ((Cursor) (obj)).getInt(j), ((Cursor) (obj)).getInt(k), ((Cursor) (obj)).getInt(l));
        s = c1;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return c1;
        obj;
        s = null;
_L8:
        m.e("PaletteStyleInfoDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
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
        Object obj1;
        obj1;
        obj = s;
        s = ((String) (obj1));
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        s = ((String) (obj));
        obj = obj1;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
