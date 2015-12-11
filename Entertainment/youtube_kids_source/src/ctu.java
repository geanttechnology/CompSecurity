// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ctu
{

    static final int a[];
    static final int b[];
    static final int c[];

    static 
    {
        c = new int[cth.values().length];
        try
        {
            c[cth.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            c[cth.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        b = new int[ctt.values().length];
        try
        {
            b[ctt.i.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            b[ctt.f.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        a = new int[ctk.values().length];
        try
        {
            a[ctk.d.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[ctk.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[ctk.c.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[ctk.a.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[ctk.f.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[ctk.e.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
