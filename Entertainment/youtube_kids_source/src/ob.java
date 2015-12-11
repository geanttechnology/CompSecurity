// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.util.ArrayList;
import java.util.List;

final class ob extends bmr
{

    private nd a;

    ob(nd nd1)
    {
        a = nd1;
        super();
    }

    public final Object a()
    {
        byk byk1 = new byk(a.a, a.c.c(), a.c.g(), a.c.b(), a.i(), (bzl)a.l.b_(), a.n(), a.c.p().getAbsolutePath());
        ArrayList arraylist = new ArrayList();
        arraylist.add(a.g());
        arraylist.add(a.l());
        arraylist.add(a.f());
        byk1.a(arraylist, a.k(), (cby)a.f.b_(), a.s().a());
        return byk1;
    }
}
