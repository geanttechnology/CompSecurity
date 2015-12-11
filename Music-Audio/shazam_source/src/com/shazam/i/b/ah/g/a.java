// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.ah.g;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.b;
import com.shazam.android.m.d;
import com.shazam.i.b.ah.e;
import com.shazam.i.b.c;

public final class a
{

    public static final Object a = new Object();

    public static b a()
    {
        return a(c.a());
    }

    public static b a(Context context)
    {
        return new d(a, e.a(context), e.b(context));
    }

    public static b a(SQLiteDatabase sqlitedatabase, SQLiteDatabase sqlitedatabase1)
    {
        return new d(a, sqlitedatabase, sqlitedatabase1);
    }

}
