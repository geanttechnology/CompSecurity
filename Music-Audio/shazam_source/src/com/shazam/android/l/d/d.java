// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.d;

import android.database.Cursor;
import com.shazam.b.a.a;
import java.util.ArrayList;
import java.util.List;

public final class d
    implements a
{

    private final a a;

    public d(a a1)
    {
        a = a1;
    }

    private void a(Cursor cursor, List list)
    {
        if (cursor.moveToFirst())
        {
            do
            {
                list.add(a.a(cursor));
            } while (cursor.moveToNext());
        }
    }

    public final volatile Object a(Object obj)
    {
        return a((Cursor)obj);
    }

    public final List a(Cursor cursor)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (cursor == null || cursor.isClosed())
        {
            break MISSING_BLOCK_LABEL_33;
        }
        a(cursor, ((List) (arraylist)));
        cursor.close();
        return arraylist;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }
}
