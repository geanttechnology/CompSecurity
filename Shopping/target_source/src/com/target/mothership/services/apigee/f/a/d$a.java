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
//            d

public static class 
    implements t
{

    public l a(d d1, Type type, s s)
    {
        type = new o();
        type.a("newEmail", d.a(d1));
        type.a("confirmEmail", d.b(d1));
        if (d.c(d1))
        {
            d1 = "true";
        } else
        {
            d1 = "false";
        }
        type.a("sendMeEmail", d1);
        return type;
    }

    public l serialize(Object obj, Type type, s s)
    {
        return a((d)obj, type, s);
    }

    public ()
    {
    }
}
