// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.a.a.b.a;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.target.mothership.services.a.a.b.a:
//            f, e

public static class 
    implements k
{

    public f a(l l1, Type type, j j1)
        throws p
    {
        type = new f();
        l1 = l1.m();
        f.a(type, new ArrayList());
        java.util.Entry entry;
        for (l1 = l1.a().iterator(); l1.hasNext(); f.a(type).add((e)j1.a((l)entry.getValue(), com/target/mothership/services/a/a/b/a/e)))
        {
            entry = (java.util.Entry)l1.next();
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
