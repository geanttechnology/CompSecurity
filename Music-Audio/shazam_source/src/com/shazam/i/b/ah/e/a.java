// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.ah.e;

import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.l.d.d;
import com.shazam.android.persistence.d.b;
import com.shazam.i.b.c;

public final class a
{

    public static com.shazam.android.persistence.d.a a()
    {
        return a(com.shazam.i.b.ah.g.a.a(c.a()));
    }

    public static com.shazam.android.persistence.d.a a(SQLiteDatabase sqlitedatabase)
    {
        return a(com.shazam.i.b.ah.g.a.a(sqlitedatabase, sqlitedatabase));
    }

    private static b a(com.shazam.android.m.b b1)
    {
        return new b(b1, new com.shazam.android.l.c.a(com.shazam.i.j.a.b()), new d(new com.shazam.android.l.d.b(com.shazam.i.j.a.b())), new com.shazam.android.l.d.c());
    }
}
