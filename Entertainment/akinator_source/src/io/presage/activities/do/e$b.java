// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.activities.do;

import io.presage.ads.d;
import io.presage.do.e;
import io.presage.formats.a;
import shared_presage.com.google.gson.Gson;

// Referenced classes of package io.presage.activities.do:
//            e

public final class c
{

    final io.presage.activities.do.e a;
    private a b;
    private e c;

    public final String param(String s)
    {
        return (new Gson()).toJson(c.a(s));
    }

    public final void sendAction(String s)
    {
        io.presage.utils.e.b(new String[] {
            "PresageActivity", "sendAction:", s
        });
        if (s.equals("close") || s.equals("cancel"))
        {
            a.a(s);
            if (s.equals("close"))
            {
                b.a().b("home");
            }
        }
        b.a().b(s);
    }

    public final String stringParam(String s)
    {
        return c.a(s).toString();
    }

    public n.Gson(io.presage.activities.do.e e1, d d1)
    {
        a = e1;
        super();
        b = d1.d();
        c = d1.d().g();
    }
}
