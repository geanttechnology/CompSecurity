// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            c, bd

abstract class g extends c
    implements bd
{

    protected g(Map map)
    {
        super(map);
    }

    Collection a()
    {
        return j();
    }

    public final Collection a(Object obj)
    {
        return b(obj);
    }

    public boolean a(Object obj, Object obj1)
    {
        return super.a(obj, obj1);
    }

    public Set b(Object obj)
    {
        return (Set)super.a(obj);
    }

    public final Collection e()
    {
        return k();
    }

    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    public Map i()
    {
        return super.i();
    }

    abstract Set j();

    public Set k()
    {
        return (Set)super.e();
    }
}
