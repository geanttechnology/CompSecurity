// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import java.util.Arrays;

// Referenced classes of package com.google.a.f:
//            c

static final class nit> extends nit>
{

    final volatile Class a(Object obj)
    {
        return (Class)obj;
    }

    final Iterable b(Object obj)
    {
        return Arrays.asList(((Class)obj).getInterfaces());
    }

    final Object c(Object obj)
    {
        return ((Class)obj).getSuperclass();
    }

    ()
    {
        super((byte)0);
    }
}
