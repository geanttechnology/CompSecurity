// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.for;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import io.presage.Presage;
import io.presage.services.do.b;
import io.presage.services.if.c;

// Referenced classes of package io.presage.services.for:
//            b

public final class f extends io.presage.services.for.b
{

    public f(Uri uri, String s)
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
        Object obj = d().getContentResolver().query(a_(), new String[] {
            "_id", "title", "url", "date", "bookmark"
        }, "bookmark = 1", null, "date DESC");
        if (obj == null) goto _L1; else goto _L3
_L3:
        ((Cursor) (obj)).moveToFirst();
        for (; !((Cursor) (obj)).isAfterLast(); ((Cursor) (obj)).moveToNext())
        {
            c c1 = new c();
            c1.a(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("_id")));
            c1.b(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("title")));
            c1.c(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("url")));
            c1.d(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("date")));
            ((b)a()).a(c1);
        }

        break MISSING_BLOCK_LABEL_363;
_L6:
        if (Presage.getInstance().getId() == null) goto _L1; else goto _L4
_L4:
        ((b)a()).a();
        c c2;
        try
        {
            obj = d().getContentResolver().query(a_(), new String[] {
                "_id", "title", "url", "bookmark"
            }, "bookmark = 1", null, "_id DESC");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        if (obj == null) goto _L1; else goto _L5
_L5:
        ((Cursor) (obj)).moveToFirst();
        for (; !((Cursor) (obj)).isAfterLast(); ((Cursor) (obj)).moveToNext())
        {
            c2 = new c();
            c2.a(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("_id")));
            c2.b(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("title")));
            c2.c(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("url")));
            c2.d("0");
            ((b)a()).a(c2);
        }

        break MISSING_BLOCK_LABEL_370;
        try
        {
            ((Cursor) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
          goto _L6
        ((Cursor) (obj)).close();
        return;
    }
}
