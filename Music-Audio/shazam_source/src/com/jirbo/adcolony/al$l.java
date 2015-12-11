// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            al, q, ac, am

static final class 
{

    boolean a;
    int b;
    int c;
    int d;
    int e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    String l;
    String m;
    String n;
    String o;
    String p;

    final boolean a()
    {
        if (a)
        {
            if (!q.c.c.a(f))
            {
                return false;
            }
            if (!q.c.c.a(h))
            {
                return false;
            }
        }
        return true;
    }

    final boolean a(h h1)
    {
        if (h1 == null)
        {
            return false;
        } else
        {
            a = h1.("enabled", true);
            e = h1.("delay");
            b = h1.("width");
            c = h1.("height");
            d = h1.("scale");
            f = h1.("image_normal", "");
            g = h1.("image_normal_last_modified", "");
            h = h1.("image_down", "");
            i = h1.("image_down_last_modified", "");
            j = h1.("click_action", "");
            k = h1.("click_action_type", "");
            l = h1.("label", "");
            m = h1.("label_rgba", "");
            n = h1.("label_shadow_rgba", "");
            o = h1.("label_html", "");
            p = h1.("event", "");
            return true;
        }
    }

    final void b()
    {
        q.c.c.a(f, g);
        q.c.c.a(h, i);
    }

    ()
    {
    }
}
