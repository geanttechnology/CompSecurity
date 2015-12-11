// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class cqp
    implements crb
{

    final bid a;
    private final bjo b;
    private final crb c;

    public cqp(bid bid1, crb crb1)
    {
        a = (bid)b.a(bid1);
        c = (crb)b.a(crb1);
        b = null;
    }

    public cqp(bjo bjo1, bid bid1, crb crb1)
    {
        b = (bjo)b.a(bjo1);
        a = (bid)b.a(bid1);
        c = (crb)b.a(crb1);
    }

    public bjo a(Object obj, Object obj1)
    {
        return b;
    }

    public final void a(Object obj, bhv bhv)
    {
        c.a(obj, new cqq(this, bhv));
    }
}
