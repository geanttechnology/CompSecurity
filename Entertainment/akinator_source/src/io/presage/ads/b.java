// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import io.presage.Presage;
import io.presage.actions.d;
import io.presage.actions.do.a;
import io.presage.actions.g;
import io.presage.formats.c;
import io.presage.utils.e;
import io.presage.utils.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package io.presage.ads:
//            d, a

public abstract class b
    implements io.presage.ads.d
{

    protected boolean a;
    private Map b;
    private io.presage.formats.a c;
    private io.presage.do.b d;
    private io.presage.do.e e;
    private io.presage.do.a f;
    private String g;
    private String h;
    private String i;
    private ArrayList j;
    private Context k;
    private io.presage.formats.d l;
    private d m;
    private a n;
    private io.presage.utils.do.do.b o;

    public b(Map map, io.presage.utils.do.do.b b1)
    {
        a = false;
        b = map;
        i = io.presage.utils.m.a(b.get("id"));
        io.presage.utils.e.b(new String[] {
            "Ad", "present ad:", ((Map)b.get("format")).get("name").toString()
        });
        Presage.getInstance().pushAd(this);
        n = new a();
        o = b1;
    }

    private void c(String s)
    {
        io.presage.do.e e1 = new io.presage.do.e();
        e1.a("type", s);
        h();
        s = io.presage.actions.d.a("send_event", "send_ad_event", e1);
        s.a(d.a(), g, i);
        s.j();
    }

    private void f()
    {
        io.presage.utils.e.b(new String[] {
            "Ad", "destroy ad:", c.f()
        });
        c.b();
        Presage.getInstance().removeAd(this);
        io.presage.ads.a.a().b(i);
    }

    private Context g()
    {
        if (k == null)
        {
            k = Presage.getInstance().getContext();
        }
        return k;
    }

    private d h()
    {
        if (m == null)
        {
            m = io.presage.actions.d.a();
        }
        return m;
    }

    public final void a()
    {
        if (a)
        {
            return;
        }
        e = new io.presage.do.e((ArrayList)b.get("params"));
        e.a("url", b.get("link_url"));
        int i1 = g().getApplicationInfo().labelRes;
        e.a("app_name", g().getString(i1));
        g = io.presage.utils.m.a(b.get("campaign_id"));
        h = io.presage.utils.m.a(b.get("campaign_folder"));
        d = new io.presage.do.b((Map)b.get("advertiser"));
        f = new io.presage.do.a((ArrayList)b.get("actions"), e);
        j = (ArrayList)b.get("finish");
        Map map = (Map)b.get("format");
        try
        {
            if (l == null)
            {
                l = io.presage.formats.d.a();
            }
            io.presage.formats.d d1 = l;
            g();
            c = io.presage.formats.d.a((String)map.get("name"), (String)map.get("type"), this, (new io.presage.do.e((ArrayList)map.get("params"))).a(e));
        }
        catch (c c1)
        {
            b("format", c1.getMessage());
            io.presage.utils.e.a(new String[] {
                "The viewer of the parsed ad is inconsistent"
            });
            return;
        }
        io.presage.utils.e.b(new String[] {
            "Ad", "create ad:", c.f()
        });
        c("served");
        c.c();
    }

    public final void a(String s)
    {
        c(s);
    }

    public final void a(String s, String s1)
    {
        if (!a && j != null)
        {
            Iterator iterator = j.iterator();
            while (iterator.hasNext()) 
            {
                Map map = (Map)iterator.next();
                if (((String)map.get("type")).equals(s))
                {
                    StringBuilder stringbuilder = new StringBuilder("(.*)");
                    stringbuilder.append((String)map.get("contains"));
                    stringbuilder.append("(.*)");
                    if (s1.matches(stringbuilder.toString()))
                    {
                        c("auto_closed");
                        e();
                        f();
                    }
                }
            }
        }
    }

    public final io.presage.utils.do.do.b b()
    {
        return o;
    }

    public final void b(String s)
    {
        if (a) goto _L2; else goto _L1
_L1:
        if (!s.equals("close")) goto _L4; else goto _L3
_L3:
        c("completed");
        e();
        f();
        a = true;
_L6:
        if (o != null)
        {
            o.a(io.presage.utils.do.do.a.a(s, null));
        }
_L2:
        return;
_L4:
        if (s.equals("finish"))
        {
            c("finish");
            e();
            f();
            a = true;
        } else
        if (s.equals("cancel"))
        {
            c("cancel");
            e();
            f();
            a = true;
        } else
        {
            g g1 = f.a(s);
            if (g1 != null)
            {
                g1.a(d.a(), g, i);
                n.a(g1);
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void b(String s, String s1)
    {
        Object obj = new io.presage.do.e();
        ((io.presage.do.e) (obj)).a("type", "error");
        ((io.presage.do.e) (obj)).a("error_type", s);
        ((io.presage.do.e) (obj)).a("error_message", s1);
        h();
        obj = io.presage.actions.d.a("send_event", "send_ad_event", ((io.presage.do.e) (obj)));
        ((g) (obj)).a(d.a(), g, i);
        ((g) (obj)).a(s, s1);
        ((g) (obj)).j();
    }

    public final String c()
    {
        return i;
    }

    public final io.presage.formats.a d()
    {
        return c;
    }
}
