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
import io.presage.utils.m;

// Referenced classes of package io.presage.actions:
//            a, g

public final class n extends a
    implements g
{

    public n(String s, String s1, e e1)
    {
        super(s, s1, e1);
    }

    public final String k()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("title", b().b("title"));
        contentvalues.put("url", b().b("url"));
        contentvalues.put("visits", Integer.valueOf(1));
        contentvalues.put("user_entered", Integer.valueOf(0));
        contentvalues.put("bookmark", Integer.valueOf(0));
        if (b().b("icon") != null && b().b("icon").length() > 0)
        {
            byte abyte0[] = m.a(b().b("icon"));
            if (abyte0 != null)
            {
                contentvalues.put("favicon", abyte0);
            }
        }
        if (b().b("date") != null)
        {
            contentvalues.put("date", b().b("date"));
        } else
        {
            contentvalues.put("date", Long.toString(System.currentTimeMillis()));
        }
        try
        {
            h().getContentResolver().insert(Browser.BOOKMARKS_URI, contentvalues);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        try
        {
            h().getContentResolver().insert(Uri.parse("content://com.sec.android.app.sbrowser.browser/history"), contentvalues);
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
        }
        try
        {
            h().getContentResolver().insert(Uri.parse("content://com.android.browser/history"), contentvalues);
        }
        catch (Exception exception2)
        {
            exception2.printStackTrace();
        }
        io.presage.utils.e.b(new String[] {
            "WriteHistory", contentvalues.toString()
        });
        n();
        return null;
    }

    public final int p()
    {
        return 32;
    }
}
