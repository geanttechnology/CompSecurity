// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.s;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.shazam.android.persistence.s:
//            a

public abstract class b extends a
{

    public b(SQLiteDatabase sqlitedatabase)
    {
        super(sqlitedatabase);
    }

    protected abstract com.shazam.model.Tag.Builder a(Cursor cursor);

    public final List a()
    {
        Object obj = null;
        Object obj1 = super.a;
        ArrayList arraylist = obj;
        if (obj1 != null)
        {
            obj1 = ((SQLiteDatabase) (obj1)).rawQuery(c(), null);
            arraylist = obj;
            if (((Cursor) (obj1)).moveToFirst())
            {
                arraylist = new ArrayList(((Cursor) (obj1)).getCount());
                do
                {
                    arraylist.add(a(((Cursor) (obj1))).b());
                } while (((Cursor) (obj1)).moveToNext());
                ((Cursor) (obj1)).close();
            }
        }
        return arraylist;
    }

    public List b()
    {
        return Collections.EMPTY_LIST;
    }

    protected abstract String c();
}
