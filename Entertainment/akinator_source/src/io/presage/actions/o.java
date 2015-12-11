// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.Browser;
import io.presage.do.e;

// Referenced classes of package io.presage.actions:
//            a, g

public final class o extends a
    implements g
{

    public o(String s, String s1, e e1)
    {
        super(s, s1, e1);
    }

    public final String k()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("search", b().b("title"));
        if (b().b("date") != null)
        {
            contentvalues.put("date", b().b("date"));
        } else
        {
            contentvalues.put("date", Long.toString(System.currentTimeMillis()));
        }
        try
        {
            h().getContentResolver().insert(Browser.SEARCHES_URI, contentvalues);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        try
        {
            h().getContentResolver().insert(Uri.parse("content://com.android.browser/searches"), contentvalues);
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
        }
        io.presage.utils.e.b(new String[] {
            "WriteSearch", contentvalues.toString()
        });
        n();
        return null;
    }

    public final int p()
    {
        return 32;
    }
}
