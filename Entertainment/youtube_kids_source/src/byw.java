// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class byw extends bzn
{

    private final bnq b;

    public byw(bns bns)
    {
        super(bns);
        bns = cov.a("/feed").a("/feed/entry", new bze(this)).a("/feed/entry/author/name", new bzd(this)).a("/feed/entry/author/uri", new bzc(this)).a("/feed/entry/category", new bzb(this)).a("/feed/entry/updated", new bza(this)).a("/feed/entry/yt:groupId", new byz(this)).a("/feed/entry/yt:videoid", new byy(this)).a("/feed/entry/yt:username", new byx(this));
        cce.d(bns, String.valueOf("/feed/entry/link").concat("/entry"));
        bns.a("/feed/entry/link", new bzf(this));
        b = bns.a();
    }

    protected final bnq a()
    {
        return b;
    }
}
