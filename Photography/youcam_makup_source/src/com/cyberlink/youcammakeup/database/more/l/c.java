// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.l;

import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.database.more.types.CollageLayoutType;
import com.cyberlink.youcammakeup.database.more.types.CollageType;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.e;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public class c
    implements e
{

    private static SimpleDateFormat n = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    private final long a;
    private final String b;
    private final CategoryType c;
    private final String d;
    private URI e;
    private URI f;
    private final String g;
    private final Date h;
    private final CollageType i;
    private final CollageLayoutType j;
    private final Date k;
    private final JSONObject l;
    private boolean m;

    public c(JSONObject jsonobject)
    {
        this(jsonobject, true);
    }

    public c(JSONObject jsonobject, boolean flag)
    {
        l = jsonobject;
        a = jsonobject.getLong("tid");
        b = jsonobject.getString("guid");
        m = flag;
        c = CategoryType.valueOf(jsonobject.getString("type").toUpperCase(Locale.US));
        d = jsonobject.getString("name");
        String s = jsonobject.getString("thumbnail");
        String s1;
        try
        {
            e = URI.create(s);
        }
        catch (Exception exception)
        {
            e = null;
        }
        s = jsonobject.getString("downloadurl");
        try
        {
            f = URI.create(s);
        }
        catch (Exception exception1)
        {
            f = null;
        }
        g = jsonobject.getString("downloadchecksum");
        s = jsonobject.getString("publishdate");
        s1 = jsonobject.getString("expireddate");
        h = n.parse(s);
        k = n.parse(s1);
        try
        {
            i = CollageType.valueOf(jsonobject.getString("collagetype").toUpperCase(Locale.US));
            j = CollageLayoutType.valueOf(jsonobject.getString("collagelayout").toUpperCase(Locale.US));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw jsonobject;
        }
    }

    public long a()
    {
        return a;
    }

    public CategoryType b()
    {
        return c;
    }

    public Date c()
    {
        return h;
    }

    public Date d()
    {
        return k;
    }

    public CollageType e()
    {
        return i;
    }

    public boolean f()
    {
        return m;
    }

    public long l()
    {
        return a;
    }

    public String m()
    {
        return b;
    }

    public String n()
    {
        return "template";
    }

    public URI o()
    {
        return f;
    }

}
