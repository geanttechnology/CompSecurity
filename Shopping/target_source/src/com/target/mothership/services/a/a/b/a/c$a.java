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
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.target.mothership.services.a.a.b.a:
//            c, b

public static class 
    implements k
{

    public c a(l l1, Type type, j j1)
        throws p
    {
        type = new c();
        for (l1 = l1.m().a().iterator(); l1.hasNext(); c.a((b)j1.a((l)((java.util.Entry)l1.next()).getValue(), com/target/mothership/services/a/a/b/a/b))) { }
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
