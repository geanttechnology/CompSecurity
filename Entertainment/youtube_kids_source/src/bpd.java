// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bpd extends bob
{

    private final bpe e;
    private final bxs f;

    public bpd(bxo bxo, bxm bxm, qs qs1, mh mh)
    {
        this(bxo, bxm, qs1, mh, bnk.a, bxs.a);
    }

    private bpd(bxo bxo, bxm bxm, qs qs1, mh mh, bnk bnk1, bxs bxs1)
    {
        super(bxo, bxm, qs1, mh);
        f = (bxs)b.a(bxs1);
        e = new bpe(this, bnk1);
    }

    public final bpf a()
    {
        return new bpf(b, c.b(), f);
    }

    public final void a(bpf bpf1, mj mj)
    {
        e.b(bpf1, mj);
    }
}
