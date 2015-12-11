// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.j.b;

import com.google.b.f;
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

// Referenced classes of package com.target.mothership.services.apigee.j.b:
//            e, a

public static class 
    implements k
{

    public e a(l l1, Type type, j j)
        throws p
    {
        j = new f();
        type = (e)j.a(l1, type);
        e.a(type, ()j.a(l1, com/target/mothership/services/apigee/j/b/e$a));
        j = l1.m();
        l1 = new ArrayList();
        if (j.a("orderItem"))
        {
            for (j = j.d("orderItem").iterator(); j.hasNext(); l1.add(com.target.mothership.services.apigee.j.b.a.b(((l)j.next()).m()))) { }
        }
        e.a(type, l1);
        return type;
    }

    public Object deserialize(l l1, Type type, j j)
        throws p
    {
        return a(l1, type, j);
    }

    public ()
    {
    }
}
