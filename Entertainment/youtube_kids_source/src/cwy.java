// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cwy
{

    static final int a[];

    static 
    {
        a = new int[btx.values().length];
        try
        {
            a[btx.b.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[btx.c.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[btx.d.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[btx.e.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[btx.a.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
