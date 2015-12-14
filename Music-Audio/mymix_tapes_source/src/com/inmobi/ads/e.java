// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.core.utilities.info.a;
import com.inmobi.commons.core.utilities.uid.d;
import com.inmobi.signals.LocationInfo;
import com.inmobi.signals.a.c;
import com.inmobi.signals.b.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class e extends NetworkRequest
{

    private long d;
    private String e;
    private String f;
    private int g;
    private String h;
    private String i;
    private Map j;
    private Map k;

    public e(String s, long l, d d1)
    {
        super(com.inmobi.commons.core.network.NetworkRequest.RequestType.POST, s, true, d1);
        e = "json";
        g = 1;
        d = l;
        c.put("im-plid", String.valueOf(d));
        c.putAll(com.inmobi.commons.core.utilities.info.e.g());
        c.putAll(DisplayInfo.c());
        c.put("u-appIS", com.inmobi.commons.core.utilities.info.a.a().b());
        c.putAll(LocationInfo.a().e());
        c.putAll(LocationInfo.a().d());
        c.putAll(com.inmobi.signals.b.b.b());
        c.putAll(com.inmobi.signals.b.b.d());
        c.putAll(com.inmobi.signals.a.c.c());
        c.putAll(com.inmobi.signals.a.c.d());
    }

    public void a()
    {
        super.a();
        c.put("format", e);
        c.put("mk-ads", String.valueOf(g));
        c.put("adtype", h);
        if (i != null)
        {
            c.put("p-keywords", i);
        }
        if (j != null)
        {
            Iterator iterator = j.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (!c.containsKey(entry.getKey()))
                {
                    c.put(entry.getKey(), entry.getValue());
                }
            } while (true);
        }
        if (k != null)
        {
            c.putAll(k);
        }
    }

    public void a(int l)
    {
        g = l;
    }

    public void a(String s)
    {
        h = s;
    }

    public void a(Map map)
    {
        j = map;
    }

    public String b()
    {
        return h;
    }

    public void b(String s)
    {
        e = s;
    }

    public void b(Map map)
    {
        k = map;
    }

    public String c()
    {
        return f;
    }

    public void c(String s)
    {
        f = s;
    }

    public int d()
    {
        return g;
    }

    public void d(String s)
    {
        i = s;
    }

    public long e()
    {
        return d;
    }
}
