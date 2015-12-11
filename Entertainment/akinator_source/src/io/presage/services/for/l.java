// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.for;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import io.presage.services.do.b;
import io.presage.services.if.h;

// Referenced classes of package io.presage.services.for:
//            b

public final class l extends io.presage.services.for.b
{

    public l(Uri uri, String s)
    {
        super(new b(), uri, s);
    }

    public final int g()
    {
        return 16;
    }

    public final void h()
    {
        if (c()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ((b)a()).a();
        Cursor cursor;
        h h1;
        try
        {
            cursor = d().getContentResolver().query(a_(), new String[] {
                "_id", "search", "date"
            }, null, null, "date DESC");
        }
        catch (Exception exception)
        {
            return;
        }
        if (cursor == null) goto _L1; else goto _L3
_L3:
        cursor.moveToFirst();
        for (; !cursor.isAfterLast(); cursor.moveToNext())
        {
            h1 = new h();
            h1.a(cursor.getString(cursor.getColumnIndex("_id")));
            h1.b(cursor.getString(cursor.getColumnIndex("search")));
            h1.c(cursor.getString(cursor.getColumnIndex("date")));
            ((b)a()).a(h1);
        }

        cursor.close();
        return;
    }
}
