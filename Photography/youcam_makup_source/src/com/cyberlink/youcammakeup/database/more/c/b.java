// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.c;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.c:
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
        ContentValues contentvalues = a1.a();
        long l;
        m.a("LocalizationInfoDao", (new StringBuilder()).append("db.insert to LocalizationInfo: ").append(contentvalues.toString()).toString());
        l = b.insert("LocalizationInfo", null, contentvalues);
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        m.b("LocalizationInfoDao", (new StringBuilder()).append("db.insert failed. id: ").append(l).toString());
        a1 = null;
        return a1;
        a1;
        m.e("LocalizationInfoDao", (new StringBuilder()).append("db.insert exception: ").append(a1.getMessage()).toString());
        return null;
        a1;
        throw a1;
    }
}
