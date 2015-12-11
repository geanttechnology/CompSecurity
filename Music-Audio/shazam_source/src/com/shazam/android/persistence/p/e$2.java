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

    final String a;
    final e b;

    public final Cursor a(SQLiteDatabase sqlitedatabase)
    {
        return sqlitedatabase.rawQuery("select count(_id) from tag where track_key = ?", new String[] {
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
