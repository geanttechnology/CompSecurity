// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.database.more.k;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.e:
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
        ContentValues contentvalues = a1.g();
        long l;
        try
        {
            m.a("MaskInfoDao", (new StringBuilder()).append("db.insert to MaskInfo: ").append(contentvalues.toString()).toString());
            l = b.insert("MaskInfo", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            m.e("MaskInfoDao", (new StringBuilder()).append("db.insert exception: ").append(a1.getMessage()).toString());
            return null;
        }
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        m.e("MaskInfoDao", (new StringBuilder()).append("db.insert failed. id: ").append(l).toString());
        a1 = null;
        return a1;
    }

    public List a(String s)
    {
        ArrayList arraylist = new ArrayList();
        Object obj;
        String as[] = k.a();
        obj = a.query("MaskInfo", as, "PatternId=?", new String[] {
            s
        }, null, null, null, null);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        m.e("MaskInfoDao", "Failed to query: cursor is null");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return arraylist;
        if (((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_93;
        }
        m.b("MaskInfoDao", "Failure of cursor.moveToFirst().");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return arraylist;
        int i;
        int j;
        int l;
        int i1;
        int j1;
        i = ((Cursor) (obj)).getColumnIndex("MaskOrder");
        j = ((Cursor) (obj)).getColumnIndex("MaskPath");
        l = ((Cursor) (obj)).getColumnIndex("ExtraData");
        i1 = ((Cursor) (obj)).getColumnIndex("Ext_1");
        j1 = ((Cursor) (obj)).getColumnIndex("Ext_2");
        if (i >= 0 && j >= 0 && l >= 0 && i1 >= 0 && j1 >= 0)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        m.e("MaskInfoDao", "cursor.getColumnIndex() returned negative number");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return arraylist;
        boolean flag;
        do
        {
            arraylist.add(new a(s, ((Cursor) (obj)).getString(i), ((Cursor) (obj)).getString(j), ((Cursor) (obj)).getString(l), ((Cursor) (obj)).getString(i1), ((Cursor) (obj)).getString(j1)));
            flag = ((Cursor) (obj)).moveToNext();
        } while (flag);
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
_L1:
        return arraylist;
        obj;
        s = null;
_L4:
        m.e("MaskInfoDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
        if (s != null)
        {
            s.close();
        }
          goto _L1
        s;
        obj = null;
_L3:
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
        if (true) goto _L3; else goto _L2
_L2:
        obj1;
        s = ((String) (obj));
        obj = obj1;
          goto _L4
    }

    public boolean b(String s)
    {
        int i = b.delete("MaskInfo", "PatternId = ?", new String[] {
            s
        });
        if (i < 1)
        {
            m.e("MaskInfoDao", (new StringBuilder()).append("[deleteByPatternGUID]  delete id: ").append(s).append(", rowsAffected != 1, rowsAffected: ").append(i).toString());
            return false;
        } else
        {
            return true;
        }
    }
}
