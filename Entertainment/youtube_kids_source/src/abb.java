// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

final class abb extends bmr
{

    private aaa a;

    abb(aaa aaa1)
    {
        a = aaa1;
        super();
    }

    public final Object a()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(a.g());
        arraylist.add(a.l());
        arraylist.add(a.m());
        arraylist.add(a.f());
        return new cpz(arraylist, (mh)a.t.b_(), cqe.a, a.c.b(), a.O(), a.c.m());
    }
}
