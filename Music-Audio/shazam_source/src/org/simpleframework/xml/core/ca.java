// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

// Referenced classes of package org.simpleframework.xml.core:
//            af

final class ca
{

    private final Class a;
    private final Class b;
    private final Class c;
    private final String d;

    public ca(af af1, Annotation annotation)
    {
        b = af1.d();
        a = annotation.annotationType();
        d = af1.a();
        c = af1.C_();
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof ca)
        {
            obj = (ca)obj;
            if (obj == this)
            {
                flag = true;
            } else
            {
                flag = flag1;
                if (((ca) (obj)).a == a)
                {
                    flag = flag1;
                    if (((ca) (obj)).b == b)
                    {
                        flag = flag1;
                        if (((ca) (obj)).c == c)
                        {
                            return ((ca) (obj)).d.equals(d);
                        }
                    }
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return d.hashCode() ^ b.hashCode();
    }

    public final String toString()
    {
        return String.format("key '%s' for %s", new Object[] {
            d, b
        });
    }
}
