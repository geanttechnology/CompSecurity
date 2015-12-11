// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cxx
    implements cpu
{

    public final cyf a = new cyf();
    public final cyb b = new cyb();
    private final int c;

    public cxx(int i)
    {
        c = i;
    }

    public final cxw a()
    {
        return new cxw(c, a.a(), b.a());
    }

    public final Object b()
    {
        return a();
    }
}
