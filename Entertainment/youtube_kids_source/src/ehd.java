// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;

final class ehd
    implements efx
{

    private Collection a;

    ehd(Collection collection)
    {
        a = collection;
        super();
    }

    public final Object a(Object obj)
    {
        Object obj1 = obj;
        if (obj == a)
        {
            obj1 = "(this Collection)";
        }
        return obj1;
    }
}
