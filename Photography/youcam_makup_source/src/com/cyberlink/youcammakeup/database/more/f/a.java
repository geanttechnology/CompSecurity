// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.f;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.more.l;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.f:
//            b

public class a
{

    private final SQLiteDatabase a = h.a();
    private final SQLiteDatabase b = h.b();

    public a()
    {
    }

    public b a(long l1)
    {
        Object obj1;
        String as[] = l.a();
        obj1 = c.c;
        obj1 = a.query("NoticeCache", as, "Nindex=?", new String[] {
            String.valueOf(l1)
        }, null, null, null, ((String) (obj1)));
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        Object obj = obj1;
        m.e("NoticeDao", "Failed to query: cursor is null");
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        obj = null;
_L4:
        return ((b) (obj));
_L2:
        obj = obj1;
        if (((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj = obj1;
        m.b("NoticeDao", "Failure of cursor.moveToFirst().");
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
        m.e("NoticeDao", "cursor.getColumnIndex() returned negative number");
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return null;
        obj = obj1;
        b b1 = new b(new JSONObject(((Cursor) (obj1)).getString(i)));
        obj = b1;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj1)).close();
        return b1;
        Exception exception1;
        exception1;
        obj1 = null;
_L8:
        obj = obj1;
        m.e("NoticeDao", (new StringBuilder()).append("Exception: ").append(exception1.getMessage()).toString());
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

    public b a(long l1, b b1)
    {
        b b2 = a(l1);
        if (b2 != null)
        {
            b1 = b2;
        } else
        {
            android.content.ContentValues contentvalues = b1.a(l1);
            try
            {
                l1 = b.insert("NoticeCache", null, contentvalues);
            }
            // Misplaced declaration of an exception variable
            catch (b b1)
            {
                return null;
            }
            if (l1 < 0L)
            {
                return null;
            }
        }
        return b1;
    }

    public boolean a()
    {
        b.delete("NoticeCache", null, null);
        return true;
    }
}
