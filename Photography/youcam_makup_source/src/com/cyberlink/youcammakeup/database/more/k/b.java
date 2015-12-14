// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.k;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.database.more.u;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.k:
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
        ContentValues contentvalues = a1.e();
        long l;
        m.a("TattooMaskInfoDao", (new StringBuilder()).append("db.insert to TattooMaskInfo: ").append(contentvalues.toString()).toString());
        l = b.insert("TattooMaskInfo", null, contentvalues);
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        m.e("TattooMaskInfoDao", (new StringBuilder()).append("db.insert failed. id: ").append(l).toString());
        a1 = null;
        return a1;
        a1;
        m.e("TattooMaskInfoDao", (new StringBuilder()).append("db.insert exception: ").append(a1.getMessage()).toString());
        return null;
        a1;
        throw a1;
    }

    public List a(String s)
    {
        Object obj;
        String as[] = u.a();
        obj = a.query("TattooMaskInfo", as, "PatternId=?", new String[] {
            s
        }, null, null, null, null);
        ArrayList arraylist = new ArrayList();
        if (obj != null) goto _L2; else goto _L1
_L1:
        m.e("TattooMaskInfoDao", "Failed to query: cursor is null");
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
            break MISSING_BLOCK_LABEL_92;
        }
        m.b("TattooMaskInfoDao", "Failure of cursor.moveToFirst().");
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
        i = ((Cursor) (obj)).getColumnIndex("TattooMaskOrder");
        j = ((Cursor) (obj)).getColumnIndex("TattoMaskPath");
        k = ((Cursor) (obj)).getColumnIndex("ExtraData");
        l = ((Cursor) (obj)).getColumnIndex("Ext_1");
        i1 = ((Cursor) (obj)).getColumnIndex("Ext_2");
        if (i >= 0 && j >= 0 && k >= 0 && l >= 0 && i1 >= 0)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        m.e("TattooMaskInfoDao", "cursor.getColumnIndex() returned negative number");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return arraylist;
        boolean flag;
        do
        {
            arraylist.add(new a(s, ((Cursor) (obj)).getString(i), ((Cursor) (obj)).getString(j), ((Cursor) (obj)).getString(k), ((Cursor) (obj)).getString(l), ((Cursor) (obj)).getString(i1)));
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
        m.e("TattooMaskInfoDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
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
}
