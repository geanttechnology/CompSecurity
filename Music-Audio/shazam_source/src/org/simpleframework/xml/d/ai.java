// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;

import org.simpleframework.xml.e.a;
import org.simpleframework.xml.e.b;

// Referenced classes of package org.simpleframework.xml.d:
//            p, ag, z

public final class ai
{

    private final a a = new b();
    private final a b = new b();
    private final z c;

    public ai(z z1)
    {
        c = new p(z1);
    }

    public final ag a(Class class1)
    {
        if (!b.contains(class1))
        {
            ag ag1 = (ag)a.a(class1);
            if (ag1 != null)
            {
                return ag1;
            }
            ag1 = c.a(class1);
            if (ag1 != null)
            {
                a.a(class1, ag1);
                return ag1;
            } else
            {
                b.a(class1, this);
                return ag1;
            }
        } else
        {
            return null;
        }
    }
}
