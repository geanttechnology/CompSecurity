// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Collection;

// Referenced classes of package com.google.a.c:
//            ae, h, bf, n, 
//            z

public abstract class y extends ae
    implements h
{

    private static final java.util.Map.Entry a[] = new java.util.Map.Entry[0];

    y()
    {
    }

    public static y a(Object obj, Object obj1)
    {
        return new bf(obj, obj1);
    }

    public static y g()
    {
        return n.a;
    }

    public abstract y e_();

    public final z f()
    {
        return e_().d();
    }

    public Collection values()
    {
        return e_().d();
    }

}
