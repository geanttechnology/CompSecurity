// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class ctx
{

    public static final byte a[];
    public static final long b;
    private final bje c;
    private final bpa d;
    private final Executor e;
    private final Executor f;
    private final List g;

    public ctx()
    {
        c = null;
        d = null;
        e = null;
        f = null;
        g = Collections.emptyList();
    }

    public ctx(bje bje1, bpa bpa1, Executor executor, List list)
    {
        c = (bje)b.a(bje1);
        d = (bpa)b.a(bpa1);
        e = (Executor)b.a(executor);
        f = new bis();
        g = (List)b.a(list);
    }

    static bje a(ctx ctx1)
    {
        return ctx1.c;
    }

    static void a(ctx ctx1, bhv bhv, bxb bxb)
    {
        ctx1.f.execute(new ctz(ctx1, bhv, bxb));
    }

    static void a(ctx ctx1, bhv bhv, Exception exception)
    {
        ctx1.f.execute(new cua(ctx1, bhv, exception));
    }

    public bxb a(String s, bxb bxb)
    {
        return bxb;
    }

    public final crf a(String s, byte abyte0[], String s1, String s2, int i, int j)
    {
        b.a(s);
        b.a(abyte0);
        b.a(s2);
        bpa bpa1 = d;
        bxu bxu1 = new bxu(bpa1.b, bpa1.c.b(), bpa1.f);
        bxu1.d = bpa1.g;
        bxu1.a(abyte0);
        bxu1.a = s;
        bxu1.c = s2;
        bxu1.e = i;
        bxu1.D = j;
        bxu1.b = s1;
        for (abyte0 = g.iterator(); abyte0.hasNext(); ((bxr)abyte0.next()).a(bxu1)) { }
        b.a(s);
        b.a(bxu1);
        c.d(new csq());
        s = new cuc(this, bxu1, s);
        abyte0 = d;
        s1 = new bpb(abyte0, ((bpa) (abyte0)).e.b(), bxu1, s);
        ((bpa) (abyte0)).d.a(((bpa) (abyte0)).a.a(bxu1, duc, s1));
        return s;
    }

    public final void a(String s, byte abyte0[], String s1, String s2, int i, int j, bhv bhv)
    {
        b.a(bhv);
        e.execute(new cty(this, s, abyte0, s1, s2, i, j, bhv));
    }

    static 
    {
        a = bqd.a;
        b = TimeUnit.SECONDS.toMillis(15L);
    }
}
