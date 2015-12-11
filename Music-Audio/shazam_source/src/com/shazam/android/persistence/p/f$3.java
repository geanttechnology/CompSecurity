// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.p;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.a;

// Referenced classes of package com.shazam.android.persistence.p:
//            f

final class a
    implements a
{

    final f a;

    public final Cursor a(SQLiteDatabase sqlitedatabase)
    {
        return sqlitedatabase.query("tag", null, "status = ?", new String[] {
            com.shazam.model.Status.UNSUBMITTED.getDbString()
        }, null, null, null);
    }

    e(f f1)
    {
        a = f1;
        super();
    }
}
