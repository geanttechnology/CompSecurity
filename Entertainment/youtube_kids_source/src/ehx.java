// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.EnumMap;

final class ehx extends eij
{

    private final transient EnumMap a;

    ehx(EnumMap enummap)
    {
        a = enummap;
        boolean flag;
        if (!enummap.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag);
    }

    static EnumMap a(ehx ehx1)
    {
        return ehx1.a;
    }

    final eiu a()
    {
        return new ehy(this);
    }

    final eiu c()
    {
        return new ehz(this);
    }

    public final boolean containsKey(Object obj)
    {
        return a.containsKey(obj);
    }

    final boolean e()
    {
        return false;
    }

    public final Object get(Object obj)
    {
        return a.get(obj);
    }

    public final int size()
    {
        return a.size();
    }

    final Object writeReplace()
    {
        return new eib(a);
    }
}
