// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.y.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.a;

// Referenced classes of package com.shazam.android.y.e:
//            a

final class a
    implements a
{

    final com.shazam.android.y.e.a a;

    public final Cursor a(SQLiteDatabase sqlitedatabase)
    {
        return sqlitedatabase.query("guaranteed_requests", com.shazam.android.y.e.a.c(), null, null, null, null, null);
    }

    iteDatabase(com.shazam.android.y.e.a a1)
    {
        a = a1;
        super();
    }
}
