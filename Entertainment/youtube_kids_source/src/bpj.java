// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class bpj extends bob
{

    private static final List e = Collections.emptyList();
    private final bpk f;
    private final bxs g;
    private final List h;

    protected bpj()
    {
        f = null;
        g = bxs.a;
        h = e;
    }

    public bpj(bxo bxo, bxm bxm, qs qs1, mh mh)
    {
        this(bxo, bxm, qs1, mh, bnk.a, bxs.a, e);
    }

    private bpj(bxo bxo, bxm bxm, qs qs1, mh mh, bnk bnk1, bxs bxs1, List list)
    {
        super(bxo, bxm, qs1, mh);
        g = (bxs)b.a(bxs1);
        h = (List)b.a(list);
        f = new bpk(this, bnk1);
    }

    public final bpl a()
    {
        bpl bpl1 = new bpl(b, c.b(), g);
        for (Iterator iterator = h.iterator(); iterator.hasNext(); iterator.next()) { }
        return bpl1;
    }

    public final void a(bpl bpl1, mj mj)
    {
        f.b(bpl1, mj);
    }

}
