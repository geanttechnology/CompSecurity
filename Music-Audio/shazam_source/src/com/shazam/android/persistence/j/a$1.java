// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.j;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.a;
import com.shazam.android.persistence.f.e;

// Referenced classes of package com.shazam.android.persistence.j:
//            a

final class a
    implements a
{

    final com.shazam.android.persistence.j.a a;

    public final Cursor a(SQLiteDatabase sqlitedatabase)
    {
        return sqlitedatabase.query("view_myshazam", e.a, "tagStatus != ?", new String[] {
            com.shazam.model.Status.UNSUBMITTED.getDbString()
        }, null, null, "timestamp DESC");
    }

    e(com.shazam.android.persistence.j.a a1)
    {
        a = a1;
        super();
    }
}
