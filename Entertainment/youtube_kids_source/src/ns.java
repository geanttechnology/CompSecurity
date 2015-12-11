// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

final class ns extends bmr
{

    private nd a;

    ns(nd nd1)
    {
        a = nd1;
        super();
    }

    public final Object a()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(a.m.b_());
        arraylist.add(a.f());
        return new ql((bzl)a.l.b_(), a.c.g(), a.c.c(), arraylist, a.k(), (bng)a.k.b_(), a.i());
    }
}
