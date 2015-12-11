// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class con
{

    static final int a[];

    static 
    {
        a = new int[cof.values().length];
        try
        {
            a[cof.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[cof.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[cof.c.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[cof.d.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
