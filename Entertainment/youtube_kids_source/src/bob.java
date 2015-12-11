// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;

public abstract class bob
{

    public final bxo a;
    public final bxm b;
    public final qs c;
    public final mh d;

    protected bob()
    {
        a = null;
        b = new bxm(new ArrayList());
        c = new cpn();
        d = null;
    }

    public bob(bxo bxo1, bxm bxm1, qs qs, mh mh1)
    {
        a = (bxo)b.a(bxo1);
        b = (bxm)b.a(bxm1);
        c = qs;
        d = (mh)b.a(mh1);
    }

    final boc a(Class class1)
    {
        return new boc(a, d, class1);
    }
}
