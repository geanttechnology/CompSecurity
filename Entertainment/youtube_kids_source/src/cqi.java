// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cqi
    implements crb
{

    final crb a;
    final cqk b;
    final cql c;

    private cqi(crb crb1, cqk cqk, cql cql)
    {
        a = crb1;
        b = cqk;
        c = cql;
    }

    public static cqi a(crb crb1, cqk cqk, cql cql)
    {
        return new cqi(crb1, cqk, cql);
    }

    public final void a(Object obj, bhv bhv)
    {
        a.a(obj, new cqj(this, bhv, obj));
    }
}
