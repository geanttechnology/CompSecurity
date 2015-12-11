// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.p;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.c;

// Referenced classes of package com.shazam.android.persistence.p:
//            f

final class a
    implements c
{

    final ContentValues a;
    final f b;

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.replace("tag", null, a);
    }

    e(f f1, ContentValues contentvalues)
    {
        b = f1;
        a = contentvalues;
        super();
    }
}
