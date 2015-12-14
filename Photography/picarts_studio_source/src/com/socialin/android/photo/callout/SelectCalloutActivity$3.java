// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.callout;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import com.socialin.android.d;
import com.socialin.android.photo.database.a;
import com.socialin.android.util.ModernAsyncTask;
import java.util.Date;

// Referenced classes of package com.socialin.android.photo.callout:
//            SelectCalloutActivity

final class a extends ModernAsyncTask
{

    private String a;
    private SelectCalloutActivity b;

    private transient Void a()
    {
        Object obj;
        if (a.equals(SelectCalloutActivity.c(b)))
        {
            break MISSING_BLOCK_LABEL_252;
        }
        obj = b.getContentResolver();
        android.net.Uri uri = a.a;
        String s = a;
        obj = ((ContentResolver) (obj)).query(uri, new String[] {
            "addtext_usage"
        }, "addtext_addedtext=?", new String[] {
            s
        }, null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        if (((Cursor) (obj)).getCount() != 0)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        obj = new ContentValues(2);
        ((ContentValues) (obj)).put("addtext_addedtext", a);
        ((ContentValues) (obj)).put("addtext_created_at", Long.valueOf((new Date()).getTime()));
        b.getContentResolver().insert(a.a, ((ContentValues) (obj)));
        return null;
        ((Cursor) (obj)).moveToFirst();
        ContentValues contentvalues = new ContentValues(2);
        contentvalues.put("addtext_usage", Integer.valueOf(((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("addtext_usage")) + 1));
        contentvalues.put("addtext_created_at", Long.valueOf((new Date()).getTime()));
        b.getContentResolver().update(a.a, contentvalues, "addtext_addedtext=?", new String[] {
            a
        });
        return null;
        Exception exception;
        exception;
        d.b(com.socialin.android.photo.callout.SelectCalloutActivity.a(), new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
        });
        return null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    (SelectCalloutActivity selectcalloutactivity, String s)
    {
        b = selectcalloutactivity;
        a = s;
        super();
    }
}
