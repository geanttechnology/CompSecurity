// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            is, jv, jw, ir, 
//            ia

final class t>
    implements is
{

    final Class a;
    final Class b;
    final ir c;

    public ir a(ia ia, jw jw1)
    {
        ia = jw1.a();
        if (ia == a || ia == b)
        {
            return c;
        } else
        {
            return null;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("Factory[type=").append(a.getName()).append("+").append(b.getName()).append(",adapter=").append(c).append("]").toString();
    }

    er(Class class1, Class class2, ir ir)
    {
        a = class1;
        b = class2;
        c = ir;
        super();
    }
}
