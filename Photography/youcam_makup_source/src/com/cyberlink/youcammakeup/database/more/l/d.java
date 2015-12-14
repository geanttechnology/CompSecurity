// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.l;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.more.w;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.l:
//            c

public class d
{

    private final SQLiteDatabase a = h.a();
    private final SQLiteDatabase b = h.b();

    public d()
    {
    }

    public com.cyberlink.youcammakeup.database.more.l.c a(long l)
    {
        Object obj1;
        String as[] = w.a();
        obj1 = c.c;
        obj1 = a.query("TemplateMetadataCache", as, "Tid=?", new String[] {
            String.valueOf(l)
        }, null, null, null, ((String) (obj1)));
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        Object obj = obj1;
        m.e("TemplateMetadataDao", "Failed to query: cursor is null");
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        obj = null;
_L4:
        return ((com.cyberlink.youcammakeup.database.more.l.c) (obj));
_L2:
        obj = obj1;
        if (((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj = obj1;
        m.b("TemplateMetadataDao", "Failure of cursor.moveToFirst().");
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return null;
        obj = obj1;
        int i = ((Cursor) (obj1)).getColumnIndex("JsonString");
        obj = obj1;
        int j = ((Cursor) (obj1)).getColumnIndex("IsNew");
        if (i >= 0 && j >= 0)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        obj = obj1;
        m.e("TemplateMetadataDao", "cursor.getColumnIndex() returned negative number");
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return null;
        obj = obj1;
        Object obj2 = ((Cursor) (obj1)).getString(i);
        obj = obj1;
        boolean flag;
        if (((Cursor) (obj1)).getInt(j) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = obj1;
        obj2 = new com.cyberlink.youcammakeup.database.more.l.c(new JSONObject(((String) (obj2))), flag);
        obj = obj2;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj1)).close();
        return ((com.cyberlink.youcammakeup.database.more.l.c) (obj2));
        Exception exception1;
        exception1;
        obj1 = null;
_L8:
        obj = obj1;
        m.e("TemplateMetadataDao", (new StringBuilder()).append("Exception: ").append(exception1.getMessage()).toString());
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
}
