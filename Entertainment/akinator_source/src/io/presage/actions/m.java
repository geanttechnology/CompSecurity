// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import io.presage.do.e;
import io.presage.utils.do.a;
import java.util.HashMap;

// Referenced classes of package io.presage.actions:
//            a

public final class m extends io.presage.actions.a
{

    private String a;

    public m(String s, String s1, e e1)
    {
        super(s, s1, e1);
    }

    public final void a(String s)
    {
        a = s;
    }

    public final String k()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("event", b().b("type"));
        hashmap.put("campaign", d());
        hashmap.put("advertiser", c());
        hashmap.put("advert", e());
        if (g() != null)
        {
            hashmap.put("error_type", g());
            hashmap.put("error_message", f());
        }
        if (a != null)
        {
            hashmap.put("completion", a);
        }
        i().a("track", hashmap);
        io.presage.utils.e.b(new String[] {
            "SendAdEvent", b().b("type")
        });
        n();
        return null;
    }
}
