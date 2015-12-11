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
//            e

public static class 
    implements t
{

    public l a(e e1, Type type, s s)
    {
        type = new o();
        type.a("firstName", e.a(e1));
        type.a("middleName", e.b(e1));
        type.a("lastName", e.c(e1));
        type.a("logonId", e.d(e1));
        type.a("logonPassword", e.e(e1));
        type.a("logonPasswordVerify", e.f(e1));
        type.a("sendMeEmail", e.g(e1).toString());
        return type;
    }

    public l serialize(Object obj, Type type, s s)
    {
        return a((e)obj, type, s);
    }

    public ()
    {
    }
}
