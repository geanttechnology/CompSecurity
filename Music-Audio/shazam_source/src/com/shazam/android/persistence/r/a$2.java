// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.r;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.c;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.shazam.android.persistence.r:
//            a

final class d
    implements c
{

    final ContentValues a;
    final String b;
    final String c[];
    final AtomicInteger d;
    final a e;

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        int i = sqlitedatabase.update("track", a, b, c);
        d.set(i);
    }

    eger(a a1, ContentValues contentvalues, String s, String as[], AtomicInteger atomicinteger)
    {
        e = a1;
        a = contentvalues;
        b = s;
        c = as;
        d = atomicinteger;
        super();
    }
}
