// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.l;

import android.content.ContentValues;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.database.more.types.CollageLayoutType;
import com.cyberlink.youcammakeup.database.more.unzipped.c;
import java.io.File;
import java.util.Calendar;

public class a
{

    private final long a;
    private final long b;
    private final c c;
    private final CategoryType d;
    private Calendar e;
    private Calendar f;
    private String g;
    private CollageLayoutType h;
    private boolean i;

    public a(long l, String s, long l1, c c1, CategoryType categorytype, 
            Calendar calendar, Calendar calendar1, boolean flag)
    {
        a = l;
        g = s;
        b = l1;
        c = c1;
        d = categorytype;
        e = calendar;
        f = calendar1;
        i = flag;
    }

    public long a()
    {
        return a;
    }

    public long b()
    {
        return b;
    }

    public c c()
    {
        return c;
    }

    public String d()
    {
        return c.b().getAbsolutePath();
    }

    public CategoryType e()
    {
        return d;
    }

    public Calendar f()
    {
        return f;
    }

    public CollageLayoutType g()
    {
        return h;
    }

    protected ContentValues h()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("Tid", Long.valueOf(a()));
        contentvalues.put("GUID", g);
        contentvalues.put("Stamp", Long.valueOf(b()));
        contentvalues.put("FolderPath", d());
        contentvalues.put("TemplateType", e().toString());
        contentvalues.put("PublishDate", Long.valueOf(e.getTimeInMillis()));
        long l;
        if (f != null)
        {
            l = f.getTimeInMillis();
        } else
        {
            l = 0L;
        }
        contentvalues.put("ExpiredDate", Long.valueOf(l));
        contentvalues.put("IsNew", Boolean.valueOf(i));
        c.a(contentvalues);
        return contentvalues;
    }
}
