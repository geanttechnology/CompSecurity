// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.o;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.a;

// Referenced classes of package com.shazam.android.persistence.o:
//            a

final class a
    implements a
{

    final String a;
    final com.shazam.android.persistence.o.a b;

    public final Cursor a(SQLiteDatabase sqlitedatabase)
    {
        return sqlitedatabase.rawQuery("select count(key) from disliked where key = ?", new String[] {
            a
        });
    }

    e(com.shazam.android.persistence.o.a a1, String s)
    {
        b = a1;
        a = s;
        super();
    }
}
