// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.a;

import com.google.b.l;
import com.google.b.o;
import com.google.b.s;
import com.google.b.t;
import java.lang.reflect.Type;

// Referenced classes of package com.target.mothership.services.apigee.f.a:
//            m

public static class 
    implements t
{

    public l a(m m1, Type type, s s)
    {
        type = new o();
        type.a("addressId", m.a(m1));
        type.a("addressType", m.b(m1));
        type.a("firstName", m.c(m1));
        type.a("lastName", m.d(m1));
        if (m.e(m1) != null)
        {
            if (m.e(m1).booleanValue())
            {
                m1 = "true";
            } else
            {
                m1 = "false";
            }
            type.a("primary", m1);
        }
        return type;
    }

    public l serialize(Object obj, Type type, s s)
    {
        return a((m)obj, type, s);
    }

    public ()
    {
    }
}
