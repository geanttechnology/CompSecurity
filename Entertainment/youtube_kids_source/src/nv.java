// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

final class nv extends bmr
{

    private nd a;

    nv(nd nd1)
    {
        a = nd1;
        super();
    }

    public final Object a()
    {
        String s = a.a(a.a.getContentResolver(), a.c.f());
        return new bys(new byj(a.c.c(), a.c.g(), new bng(a.a.getContentResolver()), a.b(), s), a.c.i());
    }
}
