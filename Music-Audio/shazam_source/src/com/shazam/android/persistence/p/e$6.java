// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.p;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.a;

// Referenced classes of package com.shazam.android.persistence.p:
//            e

final class a
    implements a
{

    final e a;

    public final Cursor a(SQLiteDatabase sqlitedatabase)
    {
        return sqlitedatabase.rawQuery("select count(_id) from tag", null);
    }

    e(e e1)
    {
        a = e1;
        super();
    }
}
