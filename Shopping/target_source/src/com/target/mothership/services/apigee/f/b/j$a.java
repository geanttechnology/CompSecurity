// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.b;

import com.google.b.f;
import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import com.target.mothership.b;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.services.apigee.f.b:
//            j, l

public static class 
    implements k
{

    public com.target.mothership.services.apigee.f.b.j a(l l1, Type type, j j1)
        throws p
    {
        type = new com.target.mothership.services.apigee.f.b.j();
        j1 = b.a().k();
        l1 = l1.m();
        if (l1.a("CheckoutProfile"))
        {
            com.target.mothership.services.apigee.f.b.l l2;
            for (l1 = l1.b("CheckoutProfile").n().iterator(); l1.hasNext(); j.a(type).add(l2))
            {
                l2 = (com.target.mothership.services.apigee.f.b.l)j1.a((l)l1.next(), com/target/mothership/services/apigee/f/b/l);
            }

        }
        return type;
    }

    public Object deserialize(l l1, Type type, j j1)
        throws p
    {
        return a(l1, type, j1);
    }

    public ()
    {
    }
}
