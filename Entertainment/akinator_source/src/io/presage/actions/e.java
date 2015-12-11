// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.Browser;
import io.presage.utils.m;

// Referenced classes of package io.presage.actions:
//            a

public final class e extends a
{

    public e(String s, String s1, io.presage.do.e e1)
    {
        super(s, s1, e1);
    }

    public final String k()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("title", b().b("title"));
        contentvalues.put("url", b().b("url"));
        contentvalues.put("bookmark", Integer.valueOf(1));
        if (b().b("icon") != null && b().b("icon").length() > 0)
        {
            byte abyte0[] = m.a(b().b("icon"));
            if (abyte0 != null)
            {
                contentvalues.put("favicon", abyte0);
                if (b().b("thumbnail") == null)
                {
                    contentvalues.put("thumbnail", abyte0);
                }
            }
        }
        if (b().b("thumbnail") != null && b().b("thumbnail").length() > 0)
        {
            byte abyte1[] = m.a(b().b("thumbnail"));
            if (abyte1 != null)
            {
                contentvalues.put("thumbnail", abyte1);
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
        try
        {
            h().getContentResolver().insert(Uri.parse("content://com.android.chrome.browser/history"), contentvalues);
        }
        catch (Exception exception3)
        {
            exception3.printStackTrace();
        }
        try
        {
            contentvalues.put("parentId", Integer.valueOf(3));
            h().getContentResolver().insert(Uri.parse("content://com.android.chrome.browser/bookmarks"), contentvalues);
        }
        catch (Exception exception4)
        {
            exception4.printStackTrace();
        }
        io.presage.utils.e.b(new String[] {
            "CreateBookmark", contentvalues.toString()
        });
        n();
        return null;
    }

    public final int p()
    {
        return 32;
    }
}
