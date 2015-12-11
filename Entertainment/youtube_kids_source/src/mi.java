// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class mi
{

    public final Object a;
    public final ls b;
    public final mp c;
    public boolean d;

    private mi(Object obj, ls ls)
    {
        d = false;
        a = obj;
        b = ls;
        c = null;
    }

    private mi(mp mp)
    {
        d = false;
        a = null;
        b = null;
        c = mp;
    }

    public static mi a(Object obj, ls ls)
    {
        return new mi(obj, ls);
    }

    public static mi a(mp mp)
    {
        return new mi(mp);
    }
}
