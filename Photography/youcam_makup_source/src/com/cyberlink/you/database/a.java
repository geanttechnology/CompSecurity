// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.you.e;
import com.cyberlink.you.i;
import com.cyberlink.you.utility.ULogUtility;

// Referenced classes of package com.cyberlink.you.database:
//            BaseObj

public abstract class a
{

    protected SQLiteDatabase a;
    protected SQLiteDatabase b;

    public a()
    {
        a = e.a();
        b = e.b();
    }

    protected abstract BaseObj a(Cursor cursor);

    protected BaseObj a(String s, String as[], String s1)
    {
        long l;
        l = System.currentTimeMillis();
        as = a.query(b(), c(), s, as, null, null, s1, e.c);
        if (as != null) goto _L2; else goto _L1
_L1:
        s = as;
        i.c(a(), new Object[] {
            "[get(String, String[])] ", "Failed to query: cursor is null"
        });
        s1 = null;
        s = s1;
        if (as != null)
        {
            as.close();
            s = s1;
        }
_L4:
        return s;
_L2:
        s = as;
        if (i.a() > 2)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        s = as;
        double d = (double)(System.currentTimeMillis() - l) / 1000D;
        s = as;
        i.a(a(), new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf(d), " seconds."
        });
        s = as;
        if (as.moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        s = as;
        i.a(a(), new Object[] {
            "[get(String, String[])] ", "Database has no records."
        });
        s = null;
        if (as != null)
        {
            as.close();
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
        s = as;
        s1 = a(((Cursor) (as)));
        s = s1;
        if (as == null) goto _L4; else goto _L5
_L5:
        as.close();
        return s1;
        s1;
        as = null;
_L9:
        s = as;
        ULogUtility.a(a(), "[get(String, String[])] ", s1);
        s = null;
        if (as == null) goto _L4; else goto _L6
_L6:
        as.close();
        return null;
        as;
        s = null;
_L8:
        if (s != null)
        {
            s.close();
        }
        throw as;
        as;
        if (true) goto _L8; else goto _L7
_L7:
        s1;
          goto _L9
    }

    protected abstract String a();

    public void a(BaseObj baseobj)
    {
        baseobj = baseobj.a();
        long l;
        try
        {
            if (i.a() <= 2)
            {
                i.a(a(), new Object[] {
                    "[insert] ", "db.insert to ", b(), ": ", baseobj.toString()
                });
            }
            l = b.insert(b(), null, baseobj);
        }
        // Misplaced declaration of an exception variable
        catch (BaseObj baseobj)
        {
            ULogUtility.a(a(), "[insert] ", baseobj);
            return;
        }
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        i.c(a(), new Object[] {
            "[insert] ", "db.insert id: ", Long.valueOf(l)
        });
    }

    protected abstract String b();

    protected abstract String[] c();
}
