// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class vm extends ContentProvider
{

    public vm()
    {
    }

    public abstract vk a();

    public int delete(Uri uri, String s, String as[])
    {
        return 0;
    }

    public String getType(Uri uri)
    {
        return "vnd.android.cursor.dir/vnd.android.search.suggest";
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        a().a(contentvalues);
        return null;
    }

    public boolean onCreate()
    {
        vn vn1 = vf.a();
        (new bml(getContext(), new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new bmu(1)), vn1.b())).a(null);
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        s = "";
        as = s;
        if (uri.getPathSegments() != null)
        {
            as = s;
            if (uri.getLastPathSegment() != null)
            {
                as = s;
                if (uri.getPathSegments().size() > 1)
                {
                    as = uri.getLastPathSegment().toLowerCase();
                }
            }
        }
        uri = new vl();
        try
        {
            as = a().a(as);
            ((vl) (uri)).a.clear();
            for (as = as.iterator(); as.hasNext(); ((vl) (uri)).a.add(s))
            {
                s = (vj)as.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            bmo.b("error fetching suggestions", as);
        }
        return uri;
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        throw new UnsupportedOperationException();
    }
}
