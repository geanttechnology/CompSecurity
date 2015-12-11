// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bwr
{

    static final int a[];
    public static final int b[];

    static 
    {
        b = new int[bwt.values().length];
        try
        {
            b[bwt.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            b[bwt.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            b[bwt.c.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            b[bwt.d.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        a = new int[bws.values().length];
        try
        {
            a[bws.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[bws.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[bws.c.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[bws.d.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
