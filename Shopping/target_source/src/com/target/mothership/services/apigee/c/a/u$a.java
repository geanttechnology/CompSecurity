// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.a;

import com.google.b.l;
import com.google.b.o;
import com.google.b.s;
import com.google.b.t;
import com.target.mothership.model.common.c;
import java.lang.reflect.Type;

// Referenced classes of package com.target.mothership.services.apigee.c.a:
//            u

public static class 
    implements t
{

    public l a(u u1, Type type, s s1)
    {
        type = new o();
        type.a("firstName", u.a(u1));
        type.a("middleName", u.b(u1));
        type.a("lastName", com.target.mothership.services.apigee.c.a.u.c(u1));
        type.a("addressLine", s1.a(u.d(u1)));
        type.a("city", u.e(u1));
        type.a("state", u.f(u1));
        type.a("zipCode", u.g(u1));
        type.a("phoneType", u.h(u1).toString());
        type.a("phone", u.i(u1));
        type.a("identifier", u.j(u1));
        if (u.k(u1))
        {
            u1 = "Y";
        } else
        {
            u1 = "N";
        }
        type.a("skipAddressValidation", u1);
        return type;
    }

    public l serialize(Object obj, Type type, s s1)
    {
        return a((u)obj, type, s1);
    }

    public ()
    {
    }
}
