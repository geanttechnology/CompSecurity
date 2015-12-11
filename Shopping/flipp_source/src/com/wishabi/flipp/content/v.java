// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.wishabi.flipp.content:
//            x

final class v
    implements x
{

    v()
    {
    }

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE flyer_pages (id INTEGER PRIMARY KEY, flyer_id INTEGER, left REAL, bottom REAL, right REAL, top REAL, name TEXT,page INTEGER);");
        sqlitedatabase.execSQL("CREATE INDEX flyer_pages_flyer_id_index ON flyer_pages (flyer_id);");
        sqlitedatabase.execSQL("ALTER TABLE items ADD page_destination INTEGER");
    }

    public final void b(SQLiteDatabase sqlitedatabase)
    {
        throw new RuntimeException("Downward migration not supported");
    }
}
