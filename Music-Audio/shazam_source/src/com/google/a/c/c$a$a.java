// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.a.c:
//            c, k

final class init> extends init>
{

    final etKey a;

    final Map a()
    {
        return a;
    }

    public final boolean contains(Object obj)
    {
        return k.a(a.a.entrySet(), obj);
    }

    public final Iterator iterator()
    {
        return new <init>(a);
    }

    public final boolean remove(Object obj)
    {
        if (!contains(obj))
        {
            return false;
        } else
        {
            obj = (java.util.try)obj;
            c.a(a.a, ((java.util.try) (obj)).getKey());
            return true;
        }
    }

    ( )
    {
        a = ;
        super();
    }
}
