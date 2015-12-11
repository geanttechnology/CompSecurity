// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.wishabi.flipp.content:
//            x

final class t
    implements x
{

    t()
    {
    }

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE featured_items (_id INTEGER PRIMARY KEY, flyer_id INTEGER, item_image_url TEXT, sale_story TEXT, description TEXT, brand_id INTEGER, brand_logo_image_url TEXT, brand_display_name TEXT, weight INTEGER, left REAL, top REAL, right REAL, bottom REAL);");
    }

    public final void b(SQLiteDatabase sqlitedatabase)
    {
        throw new RuntimeException("Downward migration not supported");
    }
}
