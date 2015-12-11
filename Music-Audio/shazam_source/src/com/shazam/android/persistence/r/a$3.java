// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.r;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.a;
import com.shazam.android.util.d.b;

// Referenced classes of package com.shazam.android.persistence.r:
//            a

final class b
    implements a
{

    final String a[];
    final String b[];
    final com.shazam.android.persistence.r.a c;

    public final Cursor a(SQLiteDatabase sqlitedatabase)
    {
        String s = (new StringBuilder("_id IN (")).append(com.shazam.android.util.d.b.a(a.length)).append(")").toString();
        return sqlitedatabase.query("track", b, s, a, null, null, null);
    }

    e(com.shazam.android.persistence.r.a a1, String as[], String as1[])
    {
        c = a1;
        a = as;
        b = as1;
        super();
    }
}
