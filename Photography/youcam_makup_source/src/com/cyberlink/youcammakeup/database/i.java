// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.c;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.cyberlink.youcammakeup.database:
//            p, j, l

public class i
{

    private static final String a[] = {
        "_id", "HasDevelopAdjustments", "IsBlackWhite", "ImageID", "Formating", "Name", "RelValueString", "TEXT", "ValueString"
    };
    private final SQLiteDatabase b = com.cyberlink.youcammakeup.c.a();
    private final SQLiteDatabase c = com.cyberlink.youcammakeup.c.b();
    private final p d = com.cyberlink.youcammakeup.c.f();

    public i()
    {
    }

    private int a(String s, String as[], long l1)
    {
        if (d.j(l1))
        {
            break MISSING_BLOCK_LABEL_43;
        }
        m.e("database.DevStepDao", (new StringBuilder()).append("Failed to ImageDao.deleteDevStep(").append(l1).append(")").toString());
        return -1;
        int k;
        try
        {
            k = c.delete("ImageDevelopHistoryStep", s, as);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.e("database.DevStepDao", (new StringBuilder()).append("_deleteStep SQLException: ").append(s.getMessage()).toString());
            return -1;
        }
        return k;
    }

    private j d(long l1)
    {
        Object obj;
        long l3;
        l3 = System.currentTimeMillis();
        obj = c.c;
        obj = b.query("ImageDevelopHistoryStep", a, "_id=?", new String[] {
            String.valueOf(l1)
        }, null, null, null, ((String) (obj)));
        if (obj != null) goto _L2; else goto _L1
_L1:
        m.e("database.DevStepDao", "Failed to query: cursor is null");
        Object obj1;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        obj1 = null;
_L4:
        return ((j) (obj1));
_L2:
        if (((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_105;
        }
        m.b("database.DevStepDao", "Failure of cursor.moveToFirst().");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        int k;
        int i1;
        int j1;
        int k1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        double d1 = (double)(System.currentTimeMillis() - l3) / 1000D;
        l2 = ((Cursor) (obj)).getColumnIndex("_id");
        i3 = ((Cursor) (obj)).getColumnIndex("HasDevelopAdjustments");
        k2 = ((Cursor) (obj)).getColumnIndex("IsBlackWhite");
        k = ((Cursor) (obj)).getColumnIndex("ImageID");
        i1 = ((Cursor) (obj)).getColumnIndex("Formating");
        j1 = ((Cursor) (obj)).getColumnIndex("Name");
        k1 = ((Cursor) (obj)).getColumnIndex("RelValueString");
        i2 = ((Cursor) (obj)).getColumnIndex("TEXT");
        j2 = ((Cursor) (obj)).getColumnIndex("ValueString");
        if (l2 >= 0 && i3 >= 0 && k2 >= 0 && k >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && i2 >= 0 && i2 >= 0)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        m.e("database.DevStepDao", "cursor.getColumnIndex() returned negative number");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        int j3;
        l1 = System.currentTimeMillis();
        j3 = ((Cursor) (obj)).getCount();
        if (j3 <= 1)
        {
            break MISSING_BLOCK_LABEL_328;
        }
        m.e("database.DevStepDao", (new StringBuilder()).append("cursor.getCount() > 1, count: ").append(j3).toString());
        Object obj3;
        long l4 = ((Cursor) (obj)).getLong(l2);
        l2 = ((Cursor) (obj)).getInt(i3);
        k2 = ((Cursor) (obj)).getInt(k2);
        long l5 = ((Cursor) (obj)).getLong(k);
        obj1 = ((Cursor) (obj)).getString(i1);
        obj3 = ((Cursor) (obj)).getString(j1);
        String s = ((Cursor) (obj)).getString(k1);
        String s1 = ((Cursor) (obj)).getString(i2);
        String s2 = ((Cursor) (obj)).getString(j2);
        double d2 = (double)(System.currentTimeMillis() - l1) / 1000D;
        obj3 = new j(l4, l2, k2, l5, ((String) (obj1)), ((String) (obj3)), s, s1, s2);
        obj1 = obj3;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return ((j) (obj3));
        Object obj2;
        obj2;
        obj = null;
_L8:
        m.e("database.DevStepDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj2)).getMessage()).toString());
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        obj2;
        obj = null;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw obj2;
        obj2;
        continue; /* Loop/switch isn't completed */
        obj2;
        if (true) goto _L6; else goto _L5
_L5:
        obj2;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public j a(long l1)
    {
        long l2 = d.i(l1);
        if (l2 < 0L)
        {
            m.b("database.DevStepDao", (new StringBuilder()).append("Failed to getDevStepId(), return null. imageId: ").append(l1).toString());
            return null;
        } else
        {
            return d(l2);
        }
    }

    public j a(l l1)
    {
        try
        {
            android.content.ContentValues contentvalues = l1.j();
            l1 = new j(c.insert("ImageDevelopHistoryStep", null, contentvalues), l1);
            d.a(l1.d(), l1.a());
        }
        // Misplaced declaration of an exception variable
        catch (l l1)
        {
            m.e("database.DevStepDao", (new StringBuilder()).append("db.insert SQLException: ").append(l1.getMessage()).toString());
            return null;
        }
        return l1;
    }

    public Collection b(long l1)
    {
        ArrayList arraylist = new ArrayList(0);
        Cursor cursor;
        long l3;
        l3 = System.currentTimeMillis();
        cursor = b.query("ImageDevelopHistoryStep", a, "ImageID=?", new String[] {
            String.valueOf(l1)
        }, null, null, null, null);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        m.e("database.DevStepDao", "Failed to query: cursor is null");
        Object obj;
        if (cursor != null)
        {
            cursor.close();
        }
        obj = arraylist;
_L4:
        return ((Collection) (obj));
_L2:
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_111;
        }
        m.b("database.DevStepDao", "Failure of cursor.moveToFirst().");
        if (cursor != null)
        {
            cursor.close();
        }
        return arraylist;
        int k;
        int i1;
        int j1;
        int k1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        double d1 = (double)(System.currentTimeMillis() - l3) / 1000D;
        k = cursor.getColumnIndex("_id");
        i1 = cursor.getColumnIndex("HasDevelopAdjustments");
        j1 = cursor.getColumnIndex("IsBlackWhite");
        i3 = cursor.getColumnIndex("ImageID");
        k1 = cursor.getColumnIndex("Formating");
        i2 = cursor.getColumnIndex("Name");
        j2 = cursor.getColumnIndex("RelValueString");
        k2 = cursor.getColumnIndex("TEXT");
        l2 = cursor.getColumnIndex("ValueString");
        if (k >= 0 && i1 >= 0 && j1 >= 0 && i3 >= 0 && k1 >= 0 && i2 >= 0 && j2 >= 0 && k2 >= 0 && l2 >= 0)
        {
            break MISSING_BLOCK_LABEL_290;
        }
        m.e("database.DevStepDao", "cursor.getColumnIndex() returned negative number");
        if (cursor != null)
        {
            cursor.close();
        }
        return arraylist;
        ArrayList arraylist1;
        l3 = System.currentTimeMillis();
        arraylist1 = new ArrayList(cursor.getCount());
        do
        {
            long l4 = cursor.getLong(k);
            int j3 = cursor.getInt(i1);
            int k3 = cursor.getInt(j1);
            obj = cursor.getString(k1);
            String s = cursor.getString(i2);
            String s1 = cursor.getString(j2);
            String s2 = cursor.getString(k2);
            String s3 = cursor.getString(l2);
            double d2 = (double)(System.currentTimeMillis() - l3) / 1000D;
            arraylist1.add(new j(l4, j3, k3, l1, ((String) (obj)), s, s1, s2, s3));
        } while (cursor.moveToNext());
        l1 = System.currentTimeMillis();
        double d3 = (double)(l1 - l3) / 1000D;
        obj = arraylist1;
        if (cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
        return arraylist1;
        Object obj1;
        obj1;
        cursor = null;
_L8:
        m.e("database.DevStepDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj1)).getMessage()).toString());
        if (cursor != null)
        {
            cursor.close();
        }
        return arraylist;
        obj1;
        cursor = null;
_L6:
        if (cursor != null)
        {
            cursor.close();
        }
        throw obj1;
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public int c(long l1)
    {
        int k = a("ImageID=?", new String[] {
            String.valueOf(l1)
        }, l1);
        if (k < 0)
        {
            m.e("database.DevStepDao", (new StringBuilder()).append("deleteAll, rowsAffected < 0, rowsAffected: ").append(k).toString());
        }
        return k;
    }

}
