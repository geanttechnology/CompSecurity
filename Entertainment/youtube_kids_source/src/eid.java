// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class eid extends egh
{

    private eic a;

    eid(eic eic1, int i, int j)
    {
        a = eic1;
        super(i, j);
    }

    protected final Object a(int i)
    {
        return a.get(i);
    }
}
