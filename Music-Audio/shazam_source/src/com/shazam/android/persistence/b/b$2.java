// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.a;
import com.shazam.android.util.d.b;

// Referenced classes of package com.shazam.android.persistence.b:
//            b

final class a
    implements a
{

    final String a[];
    final com.shazam.android.persistence.b.b b;

    public final Cursor a(SQLiteDatabase sqlitedatabase)
    {
        String s = (new StringBuilder("track_id IN (")).append(com.shazam.android.util.d.b.a(a.length)).append(")").toString();
        String as[] = a;
        return sqlitedatabase.query("addon", new String[] {
            "track_id", "serialized_addons"
        }, s, as, null, null, null);
    }

    e(com.shazam.android.persistence.b.b b1, String as[])
    {
        b = b1;
        a = as;
        super();
    }
}
