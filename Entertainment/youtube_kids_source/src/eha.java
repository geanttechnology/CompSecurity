// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Map;
import java.util.Set;

abstract class eha extends egi
    implements ejx
{

    private static final long serialVersionUID = 0x67226fd4cd0928d8L;

    protected eha(Map map)
    {
        super(map);
    }

    Collection a()
    {
        return g();
    }

    public boolean a(Object obj, Object obj1)
    {
        return super.a(obj, obj1);
    }

    public final Collection b(Object obj)
    {
        return c(obj);
    }

    public Set c(Object obj)
    {
        return (Set)super.b(obj);
    }

    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    public Map f()
    {
        return super.f();
    }

    abstract Set g();
}
