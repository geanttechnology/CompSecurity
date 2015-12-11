// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.Cursor;

// Referenced classes of package com.wishabi.flipp.content:
//            ae

public final class ad
{

    public final Cursor a;
    public final ae b;
    public final int c;

    public ad(Cursor cursor, ae ae1, int i)
    {
        a = cursor;
        b = ae1;
        c = i;
    }

    public final int a()
    {
        a.moveToPosition(c);
        return a.getInt(b.a);
    }

    public final int b()
    {
        a.moveToPosition(c);
        return a.getInt(b.b);
    }

    public final int c()
    {
        a.moveToPosition(c);
        return a.getInt(b.c);
    }

    public final int d()
    {
        a.moveToPosition(c);
        return a.getInt(b.d);
    }

    public final long e()
    {
        a.moveToPosition(c);
        return a.getLong(b.e);
    }
}
