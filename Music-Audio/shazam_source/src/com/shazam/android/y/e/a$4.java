// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.y.e;

import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.c;

// Referenced classes of package com.shazam.android.y.e:
//            a

final class a
    implements c
{

    final a a;

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.delete("guaranteed_requests", null, null);
    }

    iteDatabase(a a1)
    {
        a = a1;
        super();
    }
}
