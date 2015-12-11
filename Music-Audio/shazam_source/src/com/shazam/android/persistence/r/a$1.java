// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.r;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.c;
import com.shazam.b.a.a;
import com.shazam.model.Track;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.persistence.r:
//            a

final class a
    implements c
{

    final List a;
    final com.shazam.android.persistence.r.a b;

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        String s;
        Object obj;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); b.b.a(((List) (obj)), s))
        {
            obj = (Track)iterator.next();
            sqlitedatabase.replace("track", null, (ContentValues)b.a.a(obj));
            s = ((Track) (obj)).id;
            ContentValues contentvalues = new ContentValues();
            com.shazam.android.persistence.r.a.a(sqlitedatabase, ((Track) (obj)).metadata, s, contentvalues);
            obj = ((Track) (obj)).addOns;
        }

    }

    e(com.shazam.android.persistence.r.a a1, List list)
    {
        b = a1;
        a = list;
        super();
    }
}
