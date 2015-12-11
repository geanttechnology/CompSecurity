// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;
import java.util.concurrent.Executor;

public final class cwz
{

    private final cpz a;
    private final bkn b;
    private final cnf c;
    private final bjp d;
    private final Executor e;

    public cwz(cpz cpz1, bkn bkn1, cnf cnf1, bjp bjp1, Executor executor)
    {
        a = (cpz)b.a(cpz1);
        b = (bkn)b.a(bkn1);
        c = (cnf)b.a(cnf1);
        d = (bjp)b.a(bjp1);
        e = (Executor)b.a(executor);
    }

    public final cww a(List list, String s)
    {
        return new cww(a, b, c, d, list, s, e);
    }
}
