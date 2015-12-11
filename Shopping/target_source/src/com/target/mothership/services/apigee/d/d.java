// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.d;

import com.google.b.f;
import com.google.b.i;
import com.google.b.l;
import com.google.b.o;
import com.target.mothership.b;
import java.util.Iterator;

// Referenced classes of package com.target.mothership.services.apigee.d:
//            b, c

public class d
{

    public static com.target.mothership.services.apigee.d.b a(o o1)
    {
        f f1 = com.target.mothership.b.a().k();
        com.target.mothership.services.apigee.d.b b1 = (com.target.mothership.services.apigee.d.b)f1.a(o1, com/target/mothership/services/apigee/d/b);
        o1 = ((l)f1.a(o1, com/google/b/l)).m();
        a(b1, o1);
        b(b1, o1);
        return b1;
    }

    protected static void a(com.target.mothership.services.apigee.d.b b1, o o1)
    {
        if (o1.a("itemAttributes"))
        {
            o1 = o1.b("itemAttributes").n();
            b1.b(a(((i) (o1))));
            b1.a(b(o1));
            b1.a(c(o1));
            b1.c(d(o1));
            b1.b(e(o1));
        }
    }

    private static boolean a(i j)
    {
        return a("isPickupEligible", j);
    }

    private static boolean a(String s, i j)
    {
        for (j = j.iterator(); j.hasNext();)
        {
            o o1 = ((l)j.next()).m();
            if (o1.a("attrName") && o1.b("attrName").c().equalsIgnoreCase(s) && o1.b("attrValue").c().equalsIgnoreCase("Y"))
            {
                return true;
            }
        }

        return false;
    }

    protected static void b(com.target.mothership.services.apigee.d.b b1, o o1)
    {
        b1.a((c)(new f()).a(o1, com/target/mothership/services/apigee/d/c));
    }

    private static boolean b(i j)
    {
        return a("isOnlineEligible", j);
    }

    private static String c(i j)
    {
        for (j = j.iterator(); j.hasNext();)
        {
            o o1 = ((l)j.next()).m();
            if (o1.a("attrName") && o1.b("attrName").c().equalsIgnoreCase("Size"))
            {
                return o1.b("attrValue").c();
            }
        }

        return null;
    }

    private static String d(i j)
    {
        for (j = j.iterator(); j.hasNext();)
        {
            o o1 = ((l)j.next()).m();
            if (o1.a("attrName") && o1.b("attrName").c().equalsIgnoreCase("value"))
            {
                return o1.b("attrValue").c();
            }
        }

        return null;
    }

    private static String e(i j)
    {
        for (j = j.iterator(); j.hasNext();)
        {
            o o1 = ((l)j.next()).m();
            if (o1.a("attrName") && o1.b("attrName").c().equalsIgnoreCase("Delivery Method"))
            {
                return o1.b("attrValue").c();
            }
        }

        return null;
    }
}
