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
//            a

public static class 
    implements t
{

    public l a(a a1, Type type, s s)
    {
        type = new o();
        type.a("giftCardNumber", com.target.mothership.services.apigee.f.a.a.a(a1));
        type.a("accessNumber", com.target.mothership.services.apigee.f.a.a.b(a1));
        if (com.target.mothership.services.apigee.f.a.a.c(a1).booleanValue())
        {
            a1 = "Y";
        } else
        {
            a1 = "N";
        }
        type.a("defaultPayment", a1);
        return type;
    }

    public l serialize(Object obj, Type type, s s)
    {
        return a((a)obj, type, s);
    }

    public ()
    {
    }
}
