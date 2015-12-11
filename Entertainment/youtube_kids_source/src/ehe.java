// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Set;

final class ehe extends eho
{

    static final ehe a = new ehe();

    private ehe()
    {
    }

    public final eiu b()
    {
        return eiu.g();
    }

    final eiu c()
    {
        throw new AssertionError("should never be called");
    }

    public final eiu d()
    {
        return eiu.g();
    }

    final boolean e()
    {
        return false;
    }

    public final Set entrySet()
    {
        return eiu.g();
    }

    public final Object get(Object obj)
    {
        return null;
    }

    public final boolean isEmpty()
    {
        return true;
    }

    public final Set keySet()
    {
        return eiu.g();
    }

    public final eho l_()
    {
        return this;
    }

    final Object readResolve()
    {
        return a;
    }

    public final int size()
    {
        return 0;
    }

}
