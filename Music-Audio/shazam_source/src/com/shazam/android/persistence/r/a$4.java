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

final class a
    implements a
{

    final String a[];
    final com.shazam.android.persistence.r.a b;

    public final Cursor a(SQLiteDatabase sqlitedatabase)
    {
        String s = (new StringBuilder("track_id IN (")).append(com.shazam.android.util.d.b.a(a.length)).append(")").toString();
        String as[] = a;
        return sqlitedatabase.query("track_metadata", new String[] {
            "track_id", "entry_key", "entry_value"
        }, s, as, null, null, null);
    }

    e(com.shazam.android.persistence.r.a a1, String as[])
    {
        b = a1;
        a = as;
        super();
    }
}
