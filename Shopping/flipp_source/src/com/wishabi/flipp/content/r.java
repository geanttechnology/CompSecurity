// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.wishabi.flipp.content:
//            x

final class r
    implements x
{

    r()
    {
    }

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("ALTER TABLE items ADD display_type INTEGER DEFAULT 0");
        sqlitedatabase.execSQL("ALTER TABLE items ADD ttm_url TEXT");
    }

    public final void b(SQLiteDatabase sqlitedatabase)
    {
        throw new RuntimeException("Downward migration not supported");
    }
}
