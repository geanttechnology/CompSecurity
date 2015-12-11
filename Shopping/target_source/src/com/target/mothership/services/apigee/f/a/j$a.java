// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.a;

import com.google.b.l;
import com.google.b.o;
import com.google.b.s;
import com.google.b.t;
import com.target.mothership.model.common.a;
import com.target.mothership.model.common.c;
import java.lang.reflect.Type;

// Referenced classes of package com.target.mothership.services.apigee.f.a:
//            j

public static class 
    implements t
{

    public l a(j j1, Type type, s s1)
    {
        o o1 = new o();
        o1.a("firstName", com.target.mothership.services.apigee.f.a.j.a(j1));
        o1.a("middleName", j.b(j1));
        o1.a("lastName", com.target.mothership.services.apigee.f.a.j.c(j1));
        o1.a("addressLine", s1.a(j.d(j1)));
        o1.a("city", j.e(j1));
        o1.a("state", j.f(j1));
        o1.a("zipCode", j.g(j1));
        o1.a("addressType", a.Shipping.toString());
        o1.a("phoneType", j.h(j1).toString());
        o1.a("phone", j.i(j1));
        if (j.j(j1))
        {
            type = "Y";
        } else
        {
            type = "N";
        }
        o1.a("saveAsDefault", type);
        if (j.k(j1))
        {
            j1 = "Y";
        } else
        {
            j1 = "N";
        }
        o1.a("skipAddressValidation", j1);
        return o1;
    }

    public l serialize(Object obj, Type type, s s1)
    {
        return a((j)obj, type, s1);
    }

    public ()
    {
    }
}
