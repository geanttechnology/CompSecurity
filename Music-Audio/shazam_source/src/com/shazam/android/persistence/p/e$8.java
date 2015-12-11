// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.p;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.a;

// Referenced classes of package com.shazam.android.persistence.p:
//            e

final class e
    implements a
{

    final String a[];
    final String b;
    final String c[];
    final String d;
    final String e;
    final e f;

    public final Cursor a(SQLiteDatabase sqlitedatabase)
    {
        return sqlitedatabase.query("tag", a, com.shazam.android.persistence.p.e.d(b), c, null, null, d, e);
    }

    e(e e1, String as[], String s, String as1[], String s1, String s2)
    {
        f = e1;
        a = as;
        b = s;
        c = as1;
        d = s1;
        e = s2;
        super();
    }
}
