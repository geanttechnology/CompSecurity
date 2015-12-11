// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import java.util.Map;

// Referenced classes of package com.shazam.android.persistence:
//            c

public class LibraryDAO extends ContentProvider
{

    private c a;

    public LibraryDAO()
    {
    }

    public int delete(Uri uri, String s, String as[])
    {
        return 0;
    }

    public String getType(Uri uri)
    {
        Object obj = a.c;
        Map map = a.b;
        int i = ((UriMatcher) (obj)).match(uri);
        if (i != -1)
        {
            obj = (a.a)map.get(Integer.valueOf(i));
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        } else
        {
            return ((a.a) (obj)).c;
        }
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        return null;
    }

    public boolean onCreate()
    {
        a = new c(getContext());
        a.a();
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        return null;
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        return 0;
    }
}
