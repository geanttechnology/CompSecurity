// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.g.a;

import com.google.b.i;
import com.google.b.l;
import com.google.b.o;
import com.google.b.s;
import com.google.b.t;
import com.target.mothership.common.c.a;
import com.target.mothership.common.c.b;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.services.apigee.g.a:
//            b

public static class 
    implements t
{

    public l a(com.target.mothership.services.apigee.g.a.b b1, Type type, s s)
    {
        type = new o();
        s = new i();
        o o1;
        for (b1 = b1.b().iterator(); b1.hasNext(); s.a(o1))
        {
              = ()b1.next();
            o1 = new o();
            o1.a("item_id", com.target.mothership.services.apigee.g.a.a());
            o1.a("user_id", com.target.mothership.services.apigee.g.a.b());
            o1.a("item_code", c());
            o1.a("item_note", d());
            o1.a("requested_quantity", e());
            o1.a("purchased_quantity", f());
            o1.a("channel", g().toString());
            o1.a("item_title", h());
            o1.a("item_type", com.target.mothership.services.apigee.g.a.i().toString());
            o1.a("item_position", j());
            o1.a("item_completed_ind", k());
            if (com.target.mothership.services.apigee.g.a.l() != null)
            {
                i j = new i();
                o o2 = new o();
                o2.a("promotion_type", com.target.mothership.services.apigee.g.a.l());
                o2.a("promotion_value", m());
                o1.a("promotions", j);
            }
        }

        type.a("items", s);
        return type;
    }

    public l serialize(Object obj, Type type, s s)
    {
        return a((com.target.mothership.services.apigee.g.a.b)obj, type, s);
    }

    public ()
    {
    }
}
