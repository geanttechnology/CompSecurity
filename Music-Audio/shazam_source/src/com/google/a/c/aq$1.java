// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;


// Referenced classes of package com.google.a.c:
//            bk, aq

static final class nit> extends bk
{

    final bk a;

    public final boolean hasNext()
    {
        return a.hasNext();
    }

    public final Object next()
    {
        return ((java.util.ntry)a.next()).getValue();
    }

    (bk bk1)
    {
        a = bk1;
        super();
    }
}
