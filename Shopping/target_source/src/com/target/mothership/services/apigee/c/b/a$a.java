// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import android.support.v4.f.a;
import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.mothership.services.apigee.c.b:
//            a

public static class 
    implements k
{

    public com.target.mothership.services.apigee.c.b.a a(l l1, Type type, j j1)
        throws p
    {
        type = null;
        com.target.mothership.services.apigee.c.b.a a1 = new com.target.mothership.services.apigee.c.b.a();
        o o1 = l1.m();
        if (o1.a("orderId"))
        {
            l1 = o1.b("orderId").c();
        } else
        {
            l1 = null;
        }
        com.target.mothership.services.apigee.c.b.a.a(a1, l1);
        if (o1.a("totalQuantity"))
        {
            l1 = o1.b("totalQuantity").c();
        } else
        {
            l1 = null;
        }
        com.target.mothership.services.apigee.c.b.a.b(a1, l1);
        l1 = type;
        if (o1.a("totalAmount"))
        {
            l1 = o1.b("totalAmount").c();
        }
        com.target.mothership.services.apigee.c.b.a.c(a1, l1);
        if (o1.a("orderItem"))
        {
            com.target.mothership.services.apigee.c.b.a.a(a1, new ArrayList());
label0:
            for (l1 = o1.b("orderItem").n().iterator(); l1.hasNext(); com.target.mothership.services.apigee.c.b.a.a(a1).add(type))
            {
                type = (l)l1.next();
                Object obj = type.m();
                type = (nit>)j1.a(type, com/target/mothership/services/apigee/c/b/a$b);
                if (((o) (obj)).a("espOrderItem") && ((o) (obj)).b("espOrderItem").i() && ((o) (obj)).b("espOrderItem").n().a() > 0 && ((o)((o) (obj)).b("espOrderItem").n().a(0)).a("espAddedFlag") && "Y".equals(((o)((o) (obj)).b("espOrderItem").n().a(0)).b("espAddedFlag").c()))
                {
                    com.target.mothership.services.apigee.c.b.a(type, true);
                }
                if (!((o) (obj)).a("itemAttributes"))
                {
                    continue;
                }
                com.target.mothership.services.apigee.c.b.a(type, new a());
                obj = ((o) (obj)).b("itemAttributes").n().iterator();
                do
                {
                    o o2;
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            continue label0;
                        }
                        o2 = ((l)((Iterator) (obj)).next()).m();
                    } while (!o2.a("attrName"));
                    com.target.mothership.services.apigee.c.b.a(type).put(o2.b("attrName").c(), o2.b("attrValue").c());
                } while (true);
            }

        }
        return a1;
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
