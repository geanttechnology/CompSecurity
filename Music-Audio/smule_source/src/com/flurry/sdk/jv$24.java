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
    final ir b;

    public ir a(ia ia, jw jw1)
    {
        if (a.isAssignableFrom(jw1.a()))
        {
            return b;
        } else
        {
            return null;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("Factory[typeHierarchy=").append(a.getName()).append(",adapter=").append(b).append("]").toString();
    }

    er(Class class1, ir ir)
    {
        a = class1;
        b = ir;
        super();
    }
}
