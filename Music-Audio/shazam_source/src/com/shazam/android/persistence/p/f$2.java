// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.p;

import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.c;

// Referenced classes of package com.shazam.android.persistence.p:
//            f

final class a
    implements c
{

    final long a;
    final f b;

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.delete("tag", "timestamp = ? AND status= ?", new String[] {
            String.valueOf(a), com.shazam.model.Status.UNSUBMITTED.getDbString()
        });
    }

    e(f f1, long l)
    {
        b = f1;
        a = l;
        super();
    }
}
