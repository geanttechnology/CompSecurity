// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.c;
import org.simpleframework.xml.e.a;
import org.simpleframework.xml.e.b;

// Referenced classes of package org.simpleframework.xml.core:
//            aq, as, ag, bl, 
//            cj, ej

final class ar
{

    private final a a;
    private final a b;
    private final a c;
    private final c d;
    private final ej e;

    public ar(ej ej)
    {
        this(ej, null);
    }

    public ar(ej ej, c c1)
    {
        a = new b();
        b = new b();
        c = new b();
        d = c1;
        e = ej;
    }

    public final aq a(Class class1)
    {
        aq aq1 = (aq)c.a(class1);
        Object obj = aq1;
        if (aq1 == null)
        {
            obj = new as(class1, d);
            c.a(class1, obj);
        }
        return ((aq) (obj));
    }

    public final ag b(Class class1)
    {
        ag ag1 = (ag)b.a(class1);
        Object obj = ag1;
        if (ag1 == null)
        {
            aq aq1 = a(class1);
            obj = ag1;
            if (aq1 != null)
            {
                bl bl1 = new bl(aq1, e);
                obj = bl1;
                if (aq1 != null)
                {
                    b.a(class1, bl1);
                    obj = bl1;
                }
            }
        }
        return ((ag) (obj));
    }

    public final ag c(Class class1)
    {
        ag ag1 = (ag)a.a(class1);
        Object obj = ag1;
        if (ag1 == null)
        {
            aq aq1 = a(class1);
            obj = ag1;
            if (aq1 != null)
            {
                cj cj1 = new cj(aq1, e);
                obj = cj1;
                if (aq1 != null)
                {
                    a.a(class1, cj1);
                    obj = cj1;
                }
            }
        }
        return ((ag) (obj));
    }
}
