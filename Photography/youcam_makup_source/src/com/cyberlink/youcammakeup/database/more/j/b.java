// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.j;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.more.t;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.j:
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
        a a2 = a(a1.a());
        if (a2 == null) goto _L2; else goto _L1
_L1:
        a1 = a2;
_L4:
        return a1;
_L2:
        ContentValues contentvalues = a1.d();
        long l;
        try
        {
            m.a("StyleInfoDao", (new StringBuilder()).append("db.insert to StyleInfo: ").append(contentvalues.toString()).toString());
            l = b.insert("StyleInfo", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            m.e("StyleInfoDao", (new StringBuilder()).append("db.insert exception: ").append(a1.getMessage()).toString());
            return null;
        }
        if (l >= 0L) goto _L4; else goto _L3
_L3:
        m.e("StyleInfoDao", (new StringBuilder()).append("db.insert failed. id: ").append(l).toString());
        return null;
    }

    public a a(String s)
    {
        Object obj;
        String as[] = t.a();
        String s1 = c.c;
        obj = a.query("StyleInfo", as, "GUID=?", new String[] {
            s
        }, null, null, null, s1);
        if (obj != null) goto _L2; else goto _L1
_L1:
        m.e("StyleInfoDao", "Failed to query: cursor is null");
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
        m.b("StyleInfoDao", "Failure of cursor.moveToFirst().");
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
        i = ((Cursor) (obj)).getColumnIndex("ExtraData");
        j = ((Cursor) (obj)).getColumnIndex("Ext1");
        k = ((Cursor) (obj)).getColumnIndex("Ext2");
        l = ((Cursor) (obj)).getColumnIndex("Ext3");
        i1 = ((Cursor) (obj)).getColumnIndex("Ext4");
        j1 = ((Cursor) (obj)).getColumnIndex("Ext5");
        if (i >= 0 && j >= 0 && k >= 0 && l >= 0 && i1 >= 0 && j1 >= 0)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        m.e("StyleInfoDao", "cursor.getColumnIndex() returned negative number");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        a a1 = new a(s, ((Cursor) (obj)).getString(i), ((Cursor) (obj)).getString(j), ((Cursor) (obj)).getString(k), ((Cursor) (obj)).getString(l), ((Cursor) (obj)).getString(i1), ((Cursor) (obj)).getString(j1));
        s = a1;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return a1;
        obj;
        s = null;
_L8:
        m.e("StyleInfoDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
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
