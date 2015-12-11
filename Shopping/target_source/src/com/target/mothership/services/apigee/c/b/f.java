// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import com.target.mothership.b;
import com.target.mothership.services.apigee.d.d;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.services.apigee.c.b:
//            k

public class f
{
    public static class a
        implements k
    {

        public f a(l l1, Type type, j j)
            throws p
        {
            type = new f();
            j = com.target.mothership.b.a().k();
            l1 = l1.m();
            f.a(type, (com.target.mothership.services.apigee.c.b.k)j.a(l1, com/target/mothership/services/apigee/c/b/k));
            j = new ArrayList();
            if (l1.a("orderItem"))
            {
                for (l1 = l1.d("orderItem").iterator(); l1.hasNext(); j.add(d.a(((l)l1.next()).m()))) { }
            }
            f.a(type, j);
            return type;
        }

        public Object deserialize(l l1, Type type, j j)
            throws p
        {
            return a(l1, type, j);
        }

        public a()
        {
        }
    }


    private com.target.mothership.services.apigee.c.b.k mCartSummary;
    private List mItems;

    public f()
    {
    }

    static com.target.mothership.services.apigee.c.b.k a(f f1, com.target.mothership.services.apigee.c.b.k k)
    {
        f1.mCartSummary = k;
        return k;
    }

    static List a(f f1, List list)
    {
        f1.mItems = list;
        return list;
    }

    public com.target.mothership.services.apigee.c.b.k a()
    {
        return mCartSummary;
    }

    public List b()
    {
        return mItems;
    }
}
