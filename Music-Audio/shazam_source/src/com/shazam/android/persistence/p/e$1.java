// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.p;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.c;
import com.shazam.android.persistence.r.b;
import com.shazam.b.a.a;
import com.shazam.model.Tag;

// Referenced classes of package com.shazam.android.persistence.p:
//            e

final class a
    implements c
{

    final Tag a;
    final e b;

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        Object obj = a.track;
        com.shazam.android.persistence.p.e.a(b).a(((com.shazam.model.Track) (obj)));
        obj = (ContentValues)com.shazam.android.persistence.p.e.b(b).a(a);
        if (sqlitedatabase.update("tag", ((ContentValues) (obj)), (new StringBuilder("request_id='")).append(a.requestId).append("'").toString(), null) == 0)
        {
            sqlitedatabase.replace("tag", null, ((ContentValues) (obj)));
        }
    }

    e(e e1, Tag tag)
    {
        b = e1;
        a = tag;
        super();
    }
}
