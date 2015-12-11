// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class dba
{

    public boolean a;
    public boolean b;
    public boolean c;
    private final ehk d = ehk.h();
    private final Enum e;
    private final String f;

    public dba(String s, Enum enum)
    {
        a = false;
        b = false;
        c = false;
        e = enum;
        f = s;
    }

    public final daz a()
    {
        return new daz(f, e, a, b, d, c);
    }

    public final dba a(Enum enum, Enum enum1)
    {
        d.a(enum, enum1);
        return this;
    }
}
