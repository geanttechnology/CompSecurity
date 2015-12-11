// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.for;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import io.presage.services.do.d;

// Referenced classes of package io.presage.services.for:
//            b, j

public final class i extends b
    implements j
{

    public i(Uri uri, String s)
    {
        super(new d(), uri, s);
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
        long l;
        Object obj = d().getSharedPreferences("presage", 0);
        Object obj1 = new StringBuilder(a_().toString());
        ((StringBuilder) (obj1)).append("-history-last-time");
        long l1 = ((SharedPreferences) (obj)).getLong(((StringBuilder) (obj1)).toString(), 0L);
        ((d)a()).a();
        io.presage.services.if.d d1;
        long l2;
        try
        {
            obj1 = d().getContentResolver();
            Uri uri = a_();
            String s = Long.toString(l1);
            obj1 = ((ContentResolver) (obj1)).query(uri, new String[] {
                "_id", "title", "url", "date", "visits"
            }, "date>?", new String[] {
                s
            }, "date DESC");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return;
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_332;
        }
        ((Cursor) (obj1)).moveToFirst();
        l = 0L;
_L3:
        if (((Cursor) (obj1)).isAfterLast())
        {
            break MISSING_BLOCK_LABEL_326;
        }
        d1 = new io.presage.services.if.d();
        d1.a(((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndex("_id")));
        d1.b(((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndex("title")));
        d1.c(((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndex("url")));
        d1.d(((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndex("date")));
        d1.e(((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndex("visits")));
        l2 = ((Cursor) (obj1)).getLong(((Cursor) (obj1)).getColumnIndex("date"));
        if (l > 0L)
        {
            l -= l2;
        } else
        {
            l = 0L;
        }
        d1.a(l);
        l = ((Cursor) (obj1)).getLong(((Cursor) (obj1)).getColumnIndex("date"));
        ((d)a()).a(d1);
        ((Cursor) (obj1)).moveToNext();
          goto _L3
        ((Cursor) (obj1)).close();
        l = System.currentTimeMillis() - 0x240c8400L;
        if (l - l1 <= 0x36ee80L) goto _L1; else goto _L4
_L4:
        if (((d)a()).f()) goto _L1; else goto _L5
_L5:
        obj = ((SharedPreferences) (obj)).edit();
        obj1 = new StringBuilder(a_().toString());
        ((StringBuilder) (obj1)).append("-history-last-time");
        ((android.content.SharedPreferences.Editor) (obj)).putLong(((StringBuilder) (obj1)).toString(), l);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        return;
    }
}
