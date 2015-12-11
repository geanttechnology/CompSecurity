// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;


// Referenced classes of package org.simpleframework.xml.d:
//            z, ab, aa, a, 
//            ag

final class p
    implements z
{

    private z a;
    private z b;
    private z c;
    private z d;

    public p(z z1)
    {
        a = new ab();
        c = new aa();
        d = new a(this);
        b = z1;
    }

    public final ag a(Class class1)
    {
        ag ag = b.a(class1);
        if (ag != null)
        {
            return ag;
        }
        if (class1.isArray())
        {
            return d.a(class1);
        }
        if (class1.isPrimitive())
        {
            return a.a(class1);
        } else
        {
            return c.a(class1);
        }
    }
}
