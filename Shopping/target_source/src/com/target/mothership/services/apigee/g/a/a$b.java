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
//            a

public static class 
    implements t
{

    public l a(com.target.mothership.services.apigee.g.a.a a1, Type type, s s)
    {
        type = new o();
        s = new i();
        o o1;
        for (a1 = com.target.mothership.services.apigee.g.a.a.a(a1).iterator(); a1.hasNext(); s.a(o1))
        {
              = ()a1.next();
            o1 = new o();
            o1.a("user_id", com.target.mothership.services.apigee.g.a.a());
            o1.a("item_code", com.target.mothership.services.apigee.g.a.b());
            o1.a("item_note", c());
            o1.a("requested_quantity", d());
            o1.a("purchased_quantity", e());
            o1.a("channel", f().toString());
            o1.a("item_title", g());
            o1.a("item_type", h().toString());
            o1.a("item_position", com.target.mothership.services.apigee.g.a.i());
            o1.a("item_completed_ind", j());
            if (k() != null)
            {
                i j = new i();
                o o2 = new o();
                o2.a("promotion_type", k());
                o2.a("promotion_value", com.target.mothership.services.apigee.g.a.l());
                o1.a("promotions", j);
            }
        }

        type.a("items", s);
        return type;
    }

    public l serialize(Object obj, Type type, s s)
    {
        return a((com.target.mothership.services.apigee.g.a.a)obj, type, s);
    }

    public ()
    {
    }
}
