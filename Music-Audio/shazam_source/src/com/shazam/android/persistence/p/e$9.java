// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.p;

import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.c;

// Referenced classes of package com.shazam.android.persistence.p:
//            e

final class a
    implements c
{

    final String a;
    final e b;

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.delete("tag", "request_id= ?", new String[] {
            a
        });
    }

    e(e e1, String s)
    {
        b = e1;
        a = s;
        super();
    }
}
