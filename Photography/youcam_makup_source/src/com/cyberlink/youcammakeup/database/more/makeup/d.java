// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.makeup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.makeup:
//            a

public class d
{

    private final SQLiteDatabase a = h.a();
    private final SQLiteDatabase b = h.b();

    public d()
    {
    }

    public a a(long l)
    {
        Object obj1;
        String as[] = com.cyberlink.youcammakeup.database.more.h.a();
        obj1 = c.c;
        obj1 = a.query("MakeupCategoryCache", as, "MCid=?", new String[] {
            String.valueOf(l)
        }, null, null, null, ((String) (obj1)));
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        Object obj = obj1;
        m.e("MakeupCategoryDAO", "Failed to query: cursor is null");
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        obj = null;
_L4:
        return ((a) (obj));
_L2:
        obj = obj1;
        if (((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj = obj1;
        m.b("MakeupCategoryDAO", "Failure of cursor.moveToFirst().");
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return null;
        obj = obj1;
        int i = ((Cursor) (obj1)).getColumnIndex("JsonString");
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        obj = obj1;
        m.e("MakeupCategoryDAO", "cursor.getColumnIndex() returned negative number");
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return null;
        obj = obj1;
        a a1 = new a(new JSONObject(((Cursor) (obj1)).getString(i)));
        obj = a1;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj1)).close();
        return a1;
        Exception exception1;
        exception1;
        obj1 = null;
_L8:
        obj = obj1;
        m.e("MakeupCategoryDAO", (new StringBuilder()).append("Exception: ").append(exception1.getMessage()).toString());
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return null;
        Exception exception;
        exception;
        obj = null;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
        exception1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public a a(long l, a a1)
    {
        a a2 = a(l);
        if (a2 != null)
        {
            a1 = a2;
        } else
        {
            android.content.ContentValues contentvalues = a1.f();
            try
            {
                l = b.insert("MakeupCategoryCache", null, contentvalues);
            }
            // Misplaced declaration of an exception variable
            catch (a a1)
            {
                return null;
            }
            finally
            {
                throw a1;
            }
            if (l < 0L)
            {
                return null;
            }
        }
        return a1;
    }

    public boolean a()
    {
        try
        {
            b.delete("MakeupCategoryCache", null, null);
        }
        catch (Exception exception)
        {
            return false;
        }
        return true;
    }

    public boolean a(a a1)
    {
        int i;
        try
        {
            android.content.ContentValues contentvalues = a1.e();
            long l = a1.a();
            i = b.update("MakeupCategoryCache", contentvalues, "MCid=?", new String[] {
                String.valueOf(l)
            });
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            return false;
        }
        finally
        {
            throw a1;
        }
        return i == 1;
    }
}
